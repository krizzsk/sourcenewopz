package com.microblink.blinkbarcode.util;

import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* compiled from: line */
public class IlIllIlIIl {
    public static boolean llIIlIlIIl(AssetManager assetManager, String str, String str2) {
        try {
            File file = new File(str2);
            String[] list = assetManager.list(str);
            if (list.length > 0) {
                file.mkdirs();
                for (String str3 : list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    String str4 = File.separator;
                    sb.append(str4);
                    sb.append(str3);
                    llIIlIlIIl(assetManager, sb.toString(), str2 + str4 + str3);
                }
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                return true;
            }
            Log.m40227d("Copy", file.toString(), new Object[0]);
            InputStream open = assetManager.open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            byte[] bArr = new byte[4096];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    open.close();
                    return true;
                }
            }
        } catch (Exception unused) {
            Log.m40227d(IlIllIlIIl.class, "File copy failed!", new Object[0]);
            return false;
        }
    }

    public static void llIIlIlIIl(File file) {
        if (file.isDirectory()) {
            for (File llIIlIlIIl : file.listFiles()) {
                llIIlIlIIl(llIIlIlIIl);
            }
        }
        try {
            Log.m40227d("Delete", file.toString(), new Object[0]);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            Log.m40227d(IlIllIlIIl.class, "Failed to delete file", e.getMessage());
        }
    }
}
