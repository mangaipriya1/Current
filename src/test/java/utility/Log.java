package utility;

import java.util.logging.Logger;

public class Log {
	public static Logger Log = Logger.getLogger(Log.class.getName());
	
	 public static void startTestCase(String sTestCaseName){
		 Log.info("************************************");
		 Log.info("@@@@@@@@@@"+sTestCaseName+"@@@@@@@@@@");
		 Log.info("************************************");
	 }
	 
	 public static void endTestCase(String sTestCaseName){
		 Log.info("************"+"END"+"*******************");
	 }
	 
	 public static void info(String message){
		 Log.info(message);
		 
	 }
	 
	 public static void warn(String message){
		 Log.warning(message);
	 }

}
