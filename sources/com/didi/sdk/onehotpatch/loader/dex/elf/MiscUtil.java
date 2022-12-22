package com.didi.sdk.onehotpatch.loader.dex.elf;

import com.didi.dynamic.manager.utils.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class MiscUtil {
    private static final String TAG = "MiscUtil";

    public static File changeExt(File file, String str) {
        String str2;
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(str)) {
            return file;
        }
        int lastIndexOf = absolutePath.lastIndexOf(".");
        if (lastIndexOf > 0) {
            str2 = absolutePath.substring(0, lastIndexOf + 1) + str;
        } else {
            str2 = absolutePath + "." + str;
        }
        return new File(str2);
    }

    public static int toInt(String str) {
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
                cArr[i] = charAt;
                i++;
            }
        }
        if (i == 0) {
            return 0;
        }
        return Integer.parseInt(new String(cArr, 0, i));
    }

    public static File appendTail(File file, String str) {
        return new File(getFileDirPath(file.getAbsolutePath()), getFilenamePrefix(file.getName()) + str + "." + getFilenameSuffix(file.getName()));
    }

    public static File[] getFiles(String str, String str2) {
        File file = new File(str);
        final String[] split = str2.split(";");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].toLowerCase();
        }
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                for (String endsWith : split) {
                    if (str.toLowerCase().endsWith(endsWith)) {
                        return true;
                    }
                }
                return false;
            }
        });
        return listFiles == null ? new File[0] : listFiles;
    }

    public static String getFilenamePrefix(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String getFilenameSuffix(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String getFileDirPath(String str) {
        return str.substring(0, str.lastIndexOf(File.separatorChar) + 1);
    }

    public static String workingDir() {
        return System.getProperty("user.dir");
    }

    public static String path(String... strArr) {
        StringBuilder sb = new StringBuilder(128);
        int length = strArr.length - 1;
        for (int i = 0; i < length; i++) {
            if (strArr[i].length() >= 1) {
                sb.append(strArr[i]);
                if (!strArr[i].endsWith(File.separator)) {
                    sb.append(File.separator);
                }
            }
        }
        sb.append(strArr[length]);
        return sb.toString();
    }

    public static void mkdirs(File file) {
        if (!file.exists() && !file.mkdirs()) {
            Log.m14486e(TAG, "Failed to create directory " + file);
        }
    }

    public static void delete(File file) {
        if (!file.delete()) {
            Log.m14486e(TAG, "Failed to delete " + file);
        }
    }

    public static byte[] readBytes(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i > 0) {
            int read = inputStream.read(bArr, i2, i);
            if (read == -1) {
                break;
            }
            i -= read;
            i2 += read;
        }
        return bArr;
    }

    public static byte[] readBytes(InputStream inputStream) throws IOException {
        return readBytes(inputStream, inputStream.available());
    }

    static boolean checkFourBytes(File file, int i, long j) {
        long j2;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.skipBytes(i);
            j2 = (long) randomAccessFile.readInt();
        } catch (IOException e) {
            Log.m14494w(TAG, (Throwable) e);
            j2 = 0;
        }
        Log.m14488i(TAG, "elf magic:" + j2);
        return j2 == j;
    }

    public static boolean isZip(File file) {
        return checkFourBytes(file, 0, 1347093252);
    }

    public static boolean isDex(File file) {
        return checkFourBytes(file, 0, 1684371466);
    }

    public static boolean isElf(File file) {
        return checkFourBytes(file, 0, 2135247942);
    }
}
