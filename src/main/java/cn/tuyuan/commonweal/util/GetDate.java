package cn.tuyuan.commonweal.util;

import java.text.SimpleDateFormat;

public class GetDate {

	//字符串转换为日期类型
	public static java.util.Date strToDate(String dateStr,String parttern) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat(parttern);
		return sdf.parse(dateStr);
	}
	
}
