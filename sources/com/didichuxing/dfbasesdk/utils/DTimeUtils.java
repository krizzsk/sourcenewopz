package com.didichuxing.dfbasesdk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DTimeUtils {
    public static final String HH_mm = "HH:mm";
    public static final String MM_Yue_dd_Ri = "MM月dd日";
    public static final String MM_dd = "MM-dd";
    public static final String MM_yy = "MM/yy";
    public static final String M_Yue_d_Ri = "M月d日";
    public static final String d_Ri = "d日";
    public static final String dd_MM = "dd/MM";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String yyyy_MM = "yyyy-MM";
    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyy_Nian_MM_Yue = "yyyy年MM月";
    public static final String yyyy_Nian_MM_Yue_dd_Ri = "yyyy年MM月dd日";

    public static String getFormatterTime(long j) {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(j));
    }
}
