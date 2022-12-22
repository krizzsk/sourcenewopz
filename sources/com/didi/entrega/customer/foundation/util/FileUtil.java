package com.didi.entrega.customer.foundation.util;

import java.io.File;

public final class FileUtil {

    /* renamed from: KB */
    public static final long f20136KB = 1024;

    /* renamed from: MB */
    public static final long f20137MB = 1048576;
    public static final String SIMPLE_B = "B";
    public static final String SIMPLE_KB = "K";
    public static final String SIMPLE_MB = "M";

    private FileUtil() {
    }

    public static long getFileSize(File file) {
        long j = 0;
        if (!file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        for (File fileSize : file.listFiles()) {
            j += getFileSize(fileSize);
        }
        return j;
    }

    public static String getFileSizeString(File file) {
        long fileSize = getFileSize(file);
        if (fileSize <= 0) {
            return "";
        }
        if (fileSize < 1024) {
            return fileSize + "B";
        } else if (fileSize < 1048576) {
            return (fileSize / 1024) + "K";
        } else {
            return (fileSize / 1048576) + "M";
        }
    }

    public static boolean isFileExists(String str) {
        try {
            if (!new File(str).exists()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean deleteFile(String str) {
        if (str == null) {
            return true;
        }
        return new File(str).delete();
    }

    public static boolean deleteDir(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    return deleteDir(file2);
                }
                file2.delete();
            }
        }
        file.delete();
        return true;
    }

    public static void deleteFileRecursive(File file) {
        try {
            if (file.isDirectory()) {
                for (File deleteFileRecursive : file.listFiles()) {
                    deleteFileRecursive(deleteFileRecursive);
                }
            }
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
