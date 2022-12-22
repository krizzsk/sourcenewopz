package com.didi.map.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DiskLog {
    public static void log(String str, String str2) {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(m20430a("/sdcard/sctx_log/", str), true);
            try {
                m20432a(fileWriter2, str2);
                fileWriter2.flush();
                fileWriter2.close();
            } catch (IOException unused) {
                fileWriter = fileWriter2;
            }
        } catch (IOException unused2) {
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException unused3) {
                }
            }
        }
    }

    /* renamed from: a */
    private static void m20432a(FileWriter fileWriter, String str) throws IOException {
        m20431a(fileWriter);
        m20431a(str);
        fileWriter.append("\r\n");
        fileWriter.append(str);
        fileWriter.append("\r\n");
    }

    /* renamed from: a */
    static <T> T m20431a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* renamed from: a */
    private static File m20430a(String str, String str2) {
        m20431a(str);
        m20431a(str2);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, String.format("%s.log", new Object[]{str2}));
    }
}
