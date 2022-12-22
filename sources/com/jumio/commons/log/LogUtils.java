package com.jumio.commons.log;

import android.graphics.Bitmap;
import com.jumio.analytics.AnalyticsEvent;
import com.jumio.core.extraction.JumioRect;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class LogUtils {
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String DEBUG_DIRECTORY = "";
    public static final String FILE_ANALYTICS_REQUESTS = "";
    public static final String FILE_OCR_INFO = "";
    public static final String FILE_SERVER_REQUESTS = "";
    public static final String NEW_LINE = "\r\n";
    public static File logFolder;
    public static File logFolderTemp;

    public static void appendCoordinatesLog(StringBuilder sb, ArrayList<ArrayList<JumioRect>> arrayList) {
    }

    public static void appendParameter(StringBuilder sb, String str, long j) {
    }

    public static void appendParameter(StringBuilder sb, String str, String str2) {
    }

    public static void appendParameter(StringBuilder sb, String str, Date date) {
    }

    public static void appendParameter(StringBuilder sb, String str, char[] cArr) {
    }

    public static void copyFile(String str, String str2, String str3) {
    }

    public static void dumpDataInSubfolder(byte[] bArr, String str, String str2) {
    }

    public static void dumpImageInSubfolder(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i) {
    }

    public static void dumpImageInSubfolder(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i, String str2) {
    }

    public static void dumpImageInSubfolder(ImageSource imageSource, String str, Bitmap.CompressFormat compressFormat, int i, String str2) {
    }

    public static void dumpPictureWithCoordinates(ArrayList<ArrayList<JumioRect>> arrayList, Bitmap bitmap, String str) {
    }

    public static File getDebugFileRoot(String str) {
        return null;
    }

    public static File getLogFolder() {
        return null;
    }

    public static File getSubFolder(String str) {
        return null;
    }

    public static void init() {
    }

    public static void logAnalytics(AnalyticsEvent analyticsEvent) {
    }

    public static void logInfoInSubfolder(String str, String str2, String str3) {
    }

    public static void logServerRequest(String str, String str2) {
    }

    public static void logServerResponse(String str, int i, long j, String str2) {
    }

    public static void setSessionLogFolderName(String str) {
    }
}
