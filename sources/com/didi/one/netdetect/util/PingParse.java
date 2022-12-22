package com.didi.one.netdetect.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingParse {
    public static String getFormattingStr(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str2.contains("timeout")) {
            sb.append("ping: cannot resolve " + str + ": Timeout");
        } else if (str2.contains("unknown")) {
            sb.append("ping: cannot resolve " + str + ": Unknown host");
        } else {
            makePingResponse(str2, sb);
        }
        return sb.toString();
    }

    public static void makePingResponse(String str, StringBuilder sb) {
        String ip = getIP(str);
        List<String> sumBytes = getSumBytes(str);
        List<String> ttl = getTTL(str);
        List<String> time = getTime(str);
        List<String> icmp_seq = getIcmp_seq(str);
        int size = time.size();
        int i = 0;
        while (true) {
            int i2 = size - 1;
            if (i < i2) {
                sb.append(sumBytes.get(i) + "bytes from " + ip + ": icmp_seq=#" + icmp_seq.get(i) + " ttl=" + ttl.get(i) + " time=" + time.get(i) + "ms\n");
                i++;
            } else {
                sb.append(sumBytes.get(i2) + "bytes from " + ip + ": icmp_seq=#" + icmp_seq.get(i2) + " ttl=" + ttl.get(i2) + " time=" + time.get(i2) + "ms");
                return;
            }
        }
    }

    public static List<String> getTime(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("(?<==)([\\.0-9\\s]+)(?=ms)(?!.*DUP)").matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group().toString().trim());
        }
        return arrayList;
    }

    public static List<String> getSumBytes(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("(?<=\\D)([\\s0-9]+)(?=bytes)").matcher(str);
        while (matcher.find()) {
            String trim = matcher.group().toString().trim();
            if (matcher.group().toString().trim().matches("\\d+")) {
                arrayList.add(trim);
            }
        }
        return arrayList;
    }

    public static List<String> getTTL(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("(?<=ttl=)([0-9]+)(?=\\s)").matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group().toString().trim());
        }
        return arrayList;
    }

    public static String getIP(String str) {
        Matcher matcher = Pattern.compile("(?<=\\()([\\d]+\\.)+[\\d]+(?=\\))").matcher(str);
        String str2 = null;
        while (matcher.find()) {
            str2 = matcher.group().toString().trim();
        }
        return str2;
    }

    public static List<String> getIcmp_seq(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("(?<=icmp_seq=)([0-9]+)(?=\\s)").matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group().toString().trim());
        }
        return arrayList;
    }
}
