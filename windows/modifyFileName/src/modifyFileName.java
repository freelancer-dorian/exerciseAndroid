import java.io.File;



public class modifyFileName {
	public static void main (String argv[]) {
		
		String filePath = "F:/Video/Coursera/___Current/Classical Music Composition/Week6";
		File dir = new File(filePath);
        File[] files = dir.listFiles();
        
        if (files == null)   
            return;   
        
        for (int i = 0; i < files.length; i++) {   
        	
            if (!files[i].isDirectory()) {   
                
                String finalFileNameString = "";
                finalFileNameString = convertASCII(files[i].getName());
                                
                if (!finalFileNameString.equals(files[i].getName())){
//                	System.out.println(files[i].getName());
//                	System.out.println(finalFileNameString);
	                File targetFiles = new File(files[i].getParent() + File.separator + finalFileNameString);
	                if (files[i].renameTo(targetFiles)) {
	                	System.out.println("OK");
	                }
                }
            }
        }
	}
	
	public static String convertASCII(String asc) {
		
		while (asc.indexOf("%") != -1) {
			int index = asc.indexOf("%");
			String replace = asc.substring(index,index + 3);
			char to = convertString(replace);
			String check = checkFileString(String.valueOf(to));
			
			asc = asc.replace(replace, check);
		}
		
		return asc;
	}
	
	public static String checkFileString(String a) {
		String ret = "";
		String[] rules = {"\\", "/", ":", "*", "?", "\"", "<", ">", "|"};
		for (int i = 0; i < rules.length; i++) {
			if (a.equals(rules[i])) {
				ret = "";
				break;
			} else {
				ret = a;
			}
		}
		return ret;
	}
	
	public static char convertString(String in) {
		String a = in.substring(1,in.length());
		int i = Integer.valueOf(a,16);
		char ret = (char) i;
		return ret;
	}
}
