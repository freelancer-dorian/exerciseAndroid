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
* 查找文件 
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
* 逐行读java文件 
* @param f 
* @throws IOException 
*/ 
private static void updateFile(File f) throws IOException { 
	String filePathStr = f.getPath(); 
	System.out.println("开始读取文件的路径:::::::"+filePathStr); 
	FileInputStream fis = new FileInputStream(f); 
InputStreamReader isr = new InputStreamReader(fis,Charset.forName("GBK")); //以gbk编码打开文本文件 
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
//如果文件有修改，则修改后的文件，覆盖原有文件 
if(linenum>0) { 
	System.out.println("============================="); 
	System.out.println("filePathStr:"+filePathStr); 
	System.out.println("文件修改了："+linenum+"处。"); 
	System.out.println("============================="); 
	String cont = res.toString(); 
	ReadWriteFile.write(cont, filePathStr); 
} 
} 
/** 
* 验证读取的字符串信息 
* 和更新字符串信息 
* @param str 
*/ 
private static String updateStr(String str) { 
//判断字符串是否是需要更新的字符串 
	boolean isok = filterStr(str); 
	int strNum = StringValidation.strNum(str, StringValidation.ch); 
	if(isok || strNum == 0) { 
		return str; 
	} else { 
		String temp = ""; 
		for(int i=1;i<=strNum/2;i++) { 
temp += " //$NON-NLS-"+i+"$"; //需要添加的字符 
} 
str = str+temp; 
} 
return str; 
} 
//过滤文件类型 
private static FileFilter ff = new FileFilter() { 
	public boolean accept(File pathname) { 
		String path = pathname.getName().toLowerCase(); 
		logger.info("FileFilter path::::"+path); 
//只匹配 .java 结尾的文件 
		if (pathname.isDirectory() || path.endsWith(".java")) { 
			return true; 
		} 
		return false; 
	} 
}; 
/** 
* 过滤掉不需要处理的字符串 
* @param str 
* @return 
*/ 
public static boolean filterStr(String str) { 
	boolean isok = false; 
//过滤字符串 
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
* 验证字符串是否含有中文字符 
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
		System.out.println("获取文件的路径:::::::"+filePathStr); 
		FileInputStream fis = new FileInputStream(f); 
			InputStreamReader isr = new InputStreamReader(fis,Charset.forName("GBK")); //以gbk编码打开文本文件 
			BufferedReader br = new BufferedReader(isr, 8192 * 8); 
			String line = null; 
			int linenum = 0; 
			while((line=br.readLine())!=null) { 
				linenum ++; 
				res.append(line+"此处可以添加你自己的字符串处理逻辑"+"\r\n"); 
			} 
			br.close(); 
			return res.toString(); 
		} 
}
