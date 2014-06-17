import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
	public static void main(String[] args){
		System.out.println(System.getProperty("user.dir"));
	}
	

/** 
* �����ļ� 
* @param f 
* @throws IOException 
*/ 
public static void findFile(File f) throws IOException { 
	if(f.exists()) { 
		if(f.isDirectory()) { 
			for(File fs:f.listFiles(ff)) { 
				findFile(fs); 
			} 
		} else { 
			updateFile(f); 
		} 
	} 
} 
/** 
* ���ж�java�ļ� 
* @param f 
* @throws IOException 
*/ 
private static void updateFile(File f) throws IOException { 
	String filePathStr = f.getPath(); 
	System.out.println("��ʼ��ȡ�ļ���·��:::::::"+filePathStr); 
	FileInputStream fis = new FileInputStream(f); 
InputStreamReader isr = new InputStreamReader(fis,Charset.forName("GBK")); //��gbk������ı��ļ� 
BufferedReader br = new BufferedReader(isr, 8192 * 8); 
String line = null; 
int linenum = 0; 
StringBuffer res = new StringBuffer(); 
while((line=br.readLine())!=null) { 
	String updateStr= updateStr(line); 
	res.append(updateStr+"\r\n"); 
	if(!line.trim().equals(updateStr.trim())) { 
		linenum ++; 
	} 
} 
br.close(); 
//����ļ����޸ģ����޸ĺ���ļ�������ԭ���ļ� 
if(linenum>0) { 
	System.out.println("============================="); 
	System.out.println("filePathStr:"+filePathStr); 
	System.out.println("�ļ��޸��ˣ�"+linenum+"����"); 
	System.out.println("============================="); 
	String cont = res.toString(); 
	ReadWriteFile.write(cont, filePathStr); 
} 
} 
/** 
* ��֤��ȡ���ַ�����Ϣ 
* �͸����ַ�����Ϣ 
* @param str 
*/ 
private static String updateStr(String str) { 
//�ж��ַ����Ƿ�����Ҫ���µ��ַ��� 
	boolean isok = filterStr(str); 
	int strNum = StringValidation.strNum(str, StringValidation.ch); 
	if(isok || strNum == 0) { 
		return str; 
	} else { 
		String temp = ""; 
		for(int i=1;i<=strNum/2;i++) { 
temp += " //$NON-NLS-"+i+"$"; //��Ҫ��ӵ��ַ� 
} 
str = str+temp; 
} 
return str; 
} 
//�����ļ����� 
private static FileFilter ff = new FileFilter() { 
	public boolean accept(File pathname) { 
		String path = pathname.getName().toLowerCase(); 
		logger.info("FileFilter path::::"+path); 
//ֻƥ�� .java ��β���ļ� 
		if (pathname.isDirectory() || path.endsWith(".java")) { 
			return true; 
		} 
		return false; 
	} 
}; 
/** 
* ���˵�����Ҫ������ַ��� 
* @param str 
* @return 
*/ 
public static boolean filterStr(String str) { 
	boolean isok = false; 
//�����ַ��� 
	isok = (str.indexOf("import ")>=0) 
	|| (str.indexOf("package ")>=0) 
	|| (str.indexOf(" class ")>=0) 
	|| (str.indexOf("//$NON-NLS")>=0) 
	|| (str.indexOf("//")==0) 
	|| (str.indexOf("/*")>=0) 
	|| (str.indexOf("*")>=0) 
	|| (str.trim().indexOf("@")==0) 
	|| (str.indexOf("\"")==-1) 
	|| ("".equals(str)) 
	|| isCh(str); 
	return isok; 
} 
/** 
* ��֤�ַ����Ƿ��������ַ� 
* @param str 
* @return 
*/ 
public static boolean isCh(String str) { 
	Pattern pa = Pattern.compile("[\u4E00-\u9FA0]"); 
	Matcher m = pa.matcher(str); 
	boolean isok = m.find(); 
	return isok; 
} 
	
	public static String readFile(String path) throws IOException { 
		File f = new File(path); 
		StringBuffer res = new StringBuffer(); 
		String filePathStr = f.getPath(); 
		System.out.println("��ȡ�ļ���·��:::::::"+filePathStr); 
		FileInputStream fis = new FileInputStream(f); 
			InputStreamReader isr = new InputStreamReader(fis,Charset.forName("GBK")); //��gbk������ı��ļ� 
			BufferedReader br = new BufferedReader(isr, 8192 * 8); 
			String line = null; 
			int linenum = 0; 
			while((line=br.readLine())!=null) { 
				linenum ++; 
				res.append(line+"�˴�����������Լ����ַ��������߼�"+"\r\n"); 
			} 
			br.close(); 
			return res.toString(); 
		} 
}
