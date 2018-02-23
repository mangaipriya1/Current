package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import pageObjects.Login_Page;

public class Configure {
	static Properties pro;
	public static void Configure1() throws Exception{
		File src = new File("./Configuration/config.property");
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		

	}

	public static String getChromePath(){
		String chrome_Path = pro.getProperty("ChromeDriver");
		return chrome_Path;
	}
	
	public static String getUrl(){
		String url_Path = pro.getProperty("Url");
		return url_Path;
	}
	
	
	public String getIePath(){
		String IE_path =pro.getProperty("IEDriver");
		return IE_path;
	}
	
	
	public static String getExcel(){
		String excel = pro.getProperty("excel");
		return excel;
	}
}
