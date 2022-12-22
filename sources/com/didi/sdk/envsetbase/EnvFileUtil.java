package com.didi.sdk.envsetbase;

import android.content.Context;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EnvFileUtil {
    public static final String OMEGA_CORE_DATA_FILE = "omegacore.txt";
    public static final String OMEGA_REGISTER_DATA_FILE = "omegareg.txt";

    /* renamed from: a */
    private static final String f35834a = "didi/envconfig";

    public static File getDiskCacheDir(Context context, String str) {
        String str2;
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || Environment.isExternalStorageRemovable()) {
                str2 = context.getCacheDir().getPath();
                File file = new File(str2 + File.separator + f35834a);
                file.mkdirs();
                return new File(file + File.separator + str);
            }
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                str2 = externalCacheDir.getPath();
            } else {
                str2 = context.getCacheDir().getPath();
            }
            File file2 = new File(str2 + File.separator + f35834a);
            file2.mkdirs();
            return new File(file2 + File.separator + str);
        } catch (Exception unused) {
            str2 = context.getCacheDir().getPath();
        }
    }

    public static String readTextFile(File file) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb = new StringBuilder();
                for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                    sb.append(readLine);
                    sb.append("\n");
                }
                String sb2 = sb.toString();
                closeQuietly(bufferedReader2);
                return sb2;
            } catch (IOException unused) {
                bufferedReader = bufferedReader2;
                closeQuietly(bufferedReader);
                return "";
            } catch (Throwable th) {
                closeQuietly(bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            closeQuietly(bufferedReader);
            return "";
        }
    }

    public static void writeTxtToFile(String str, File file) {
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter2.write(str);
                closeQuietly(bufferedWriter2);
            } catch (IOException e) {
                e = e;
                bufferedWriter = bufferedWriter2;
                try {
                    e.printStackTrace();
                    closeQuietly(bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                closeQuietly(bufferedWriter);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            closeQuietly(bufferedWriter);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
