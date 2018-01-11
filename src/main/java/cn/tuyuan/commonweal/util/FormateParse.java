package cn.tuyuan.commonweal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class FormateParse {

	public static Integer parseInt(String str){
		if(str!=null && !str.equalsIgnoreCase("")){
			return Integer.parseInt(str);
		}
		return 0;
	}
	
	public static Date parseDate(String str){
		System.out.println(str);
		if(str!=null && !str.equalsIgnoreCase("")){
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date d = null;
			try {
				d = sdf.parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return d;
		}
		return null;
	}
	
}
