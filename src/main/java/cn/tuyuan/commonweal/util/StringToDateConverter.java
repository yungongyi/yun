package cn.tuyuan.commonweal.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


public class StringToDateConverter implements Converter<String,Date> {

	private String patten;

	public StringToDateConverter(String patten) {
		this.patten=patten;
	}
	public Date convert(String str) {
		Date date=null;
		try {
			date=new SimpleDateFormat(patten).parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
