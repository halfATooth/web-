package com.example.test.util;

import com.example.test.bean.VerificationCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

public class CommonMethod {
    public static VerificationCode generateVerCode(String username){
        Random r = new Random();
        int code = r.nextInt(1000000);
        long time = System.currentTimeMillis()/1000;
        return new VerificationCode(username, time, code);
    }
    public static Integer getInteger(Map data, String key) {
        Object obj = data.get(key);
        if(obj == null)
            return null;
        if(obj instanceof Integer)
            return (Integer)obj;
        String str = obj.toString();
        try {
            return new Integer(str);
        }catch(Exception e) {
            return null;
        }
    }
    public static Long getLong(Map data,String key) {
        Object obj = data.get(key);
        if(obj == null)
            return null;
        if(obj instanceof Long)
            return (Long)obj;
        String str = obj.toString();
        try {
            return new Long(str);
        }catch(Exception e) {
            return null;
        }
    }

    public static Double getDouble(Map data,String key) {
        Object obj = data.get(key);
        if(obj == null)
            return null;
        if(obj instanceof Double)
            return (Double)obj;
        String str = obj.toString();
        try {
            return new Double(str);
        }catch(Exception e) {
            return null;
        }
    }
    public static String getString(Map data,String key){
        Object obj = data.get(key);
        if(obj == null)
            return "";
        if(obj instanceof String)
            return (String)obj;
        return obj.toString();
    }
    public static Date getDate(Map data, String key) {
        Object obj = data.get(key);
        if(obj == null)
            return null;
        if(obj instanceof Date)
            return (Date)obj;
        String str = obj.toString();
        return formatDateTime(str,"yyyy-MM-dd");
    }
    public static Date getTime(Map data,String key) {
        Object obj = data.get(key);
        if(obj == null)
            return null;
        if(obj instanceof Date)
            return (Date)obj;
        String str = obj.toString();
        return formatDateTime(str,"yyyy-MM-dd HH:mm:ss");
    }
    public static Date formatDateTime(String timeSrc, String f) {
        SimpleDateFormat sdFormat = new SimpleDateFormat(f);
        sdFormat.setLenient(true);
        try {
            if (timeSrc == null || timeSrc.trim().equals(""))
                return null;

            Date tmpDate = sdFormat.parse(timeSrc);
            return tmpDate;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
//			e.printStackTrace();
            return null;
        }
    }
    public static String parseDateTime(Date timeSrc, String f) {
        if (timeSrc == null)
            return null;
        SimpleDateFormat sdFormat = new SimpleDateFormat(f);
        String result = sdFormat.format(timeSrc);
        if (result != null)
            return result;
        else
            return "";
    }
}
