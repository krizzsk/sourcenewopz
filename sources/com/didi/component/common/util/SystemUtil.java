package com.didi.component.common.util;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemUtil {
    public static boolean isCPU64() {
        String cpuProcessor = getCpuProcessor();
        return !TextUtils.isEmpty(cpuProcessor) && cpuProcessor.toLowerCase().contains("aarch64");
    }

    public static String getCpuProcessor() {
        try {
            return getFiledFromCpuInfo("Processor");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getFiledFromCpuInfo(String str) throws IOException {
        Matcher matcher;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
        Pattern compile = Pattern.compile(str + "\\s*:\\s*(.*)");
        do {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    matcher = compile.matcher(readLine);
                } else {
                    bufferedReader.close();
                    return "";
                }
            } finally {
                bufferedReader.close();
            }
        } while (!matcher.matches());
        return matcher.group(1);
    }
}
