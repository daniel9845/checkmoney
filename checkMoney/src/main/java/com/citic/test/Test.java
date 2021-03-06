package com.citic.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.http.util.TextUtils;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
//            String str = "20887019486626410156_20171230_账务明细.csv";
//            
//            System.out.println(encodeFileName(str));
            
          
//            System.out.println(TimeStamp2Date("1518418745", "yyyy-MM-dd HH:mm:ss"));
            System.out.println(Date2TimeStamp("2018-02-12 00:00:00", "yyyy-MM-dd HH:mm:ss"));
	}
	
	private static String encodeFileName(String fileName) {
    	String prefix = fileName.substring(0,fileName.lastIndexOf("_")+1);
    	String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
    	fileName = fileName.substring(fileName.lastIndexOf("_")+1,fileName.lastIndexOf("."));
    	switch (fileName) {
		case "业务明细(汇总)":  fileName = prefix+"1"+suffix; break; 
		case "业务明细": fileName = prefix+"2"+suffix;  break;
		case "账务明细(汇总)": fileName = prefix+"3"+suffix; break;
		case "账务明细": fileName = prefix+"alipayBill"+suffix; break; 

		}
		return fileName;
    }
	
	/**
     * Java将Unix时间戳转换成指定格式日期字符串
     * @param timestampString 时间戳 如："1473062802";
     * @param formats 要格式化的格式 默认："yyyy-MM-dd HH:mm:ss";
     *
     * @return 返回结果 如："2016-09-05 12:04:25";
     */
    public static String TimeStamp2Date(String timestampString, String formats) {
        if (TextUtils.isEmpty(formats))
            formats = "yyyy-MM-dd HH:mm:ss";
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }
    /**
     * 日期格式字符串转换成时间戳
     *
     * @param dateStr 字符串日期
     * @param format   如：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String Date2TimeStamp(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
