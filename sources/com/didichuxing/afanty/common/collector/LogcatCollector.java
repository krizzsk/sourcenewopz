package com.didichuxing.afanty.common.collector;

import android.os.Process;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LogcatCollector {
    public static String getLogcat() {
        return m32656a(100);
    }

    /* renamed from: a */
    private static String m32656a(int i) {
        String str;
        int myPid = Process.myPid();
        if (myPid > 0) {
            str = Integer.toString(myPid) + "):";
        } else {
            str = null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("logcat");
        int i2 = 0;
        arrayList.addAll(Arrays.asList(new String[]{"-t", String.valueOf(i), "-v", "time"}));
        StringBuilder sb = new StringBuilder();
        try {
            final Process exec = Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()]));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        InputStream errorStream = exec.getErrorStream();
                        while (errorStream.read(new byte[1024]) >= 0) {
                        }
                        errorStream.close();
                    } catch (Throwable unused) {
                    }
                }
            }).start();
            while (true) {
                if (i2 >= i) {
                    break;
                }
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (str == null || readLine.contains(str)) {
                    sb.append(readLine);
                    sb.append("\n");
                }
                i2++;
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
