package com.didichuxing.mlcp.drtc.utils;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.RTCConsts;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didichuxing.mlcp.drtc.utils.g */
/* compiled from: SDPUtils */
public class C15925g {
    /* renamed from: a */
    public static String m34745a(String str, String str2, boolean z) {
        String[] split = str.split("\r\n");
        Pattern compile = Pattern.compile("^a=rtpmap:(\\d+) " + str2 + "(/\\d+)+[\r]?$");
        String str3 = z ? "m=audio " : "m=video ";
        String str4 = null;
        int i = -1;
        for (int i2 = 0; i2 < split.length && (i == -1 || str4 == null); i2++) {
            if (split[i2].startsWith(str3)) {
                i = i2;
            } else {
                Matcher matcher = compile.matcher(split[i2]);
                if (matcher.matches()) {
                    str4 = matcher.group(1);
                }
            }
        }
        if (i == -1 || str4 == null) {
            return str;
        }
        String[] split2 = split[i].split(" ");
        if (split2.length > 3) {
            StringBuilder sb = new StringBuilder();
            sb.append(split2[0]);
            sb.append(" ");
            sb.append(split2[1]);
            sb.append(" ");
            sb.append(split2[2]);
            sb.append(" ");
            sb.append(str4);
            for (int i3 = 3; i3 < split2.length; i3++) {
                if (!split2[i3].equals(str4)) {
                    sb.append(" ");
                    sb.append(split2[i3]);
                }
            }
            split[i] = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        for (String append : split) {
            sb2.append(append);
            sb2.append("\r\n");
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public static String m34746a(String str, boolean z, String str2, int i) {
        boolean z2;
        String str3;
        String str4;
        String str5 = str;
        String str6 = str2;
        int i2 = i;
        SystemUtils.log(3, "SDPUtils", "设置起始码率:" + i2, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.g", 58);
        String[] split = str6.split("\r\n");
        Pattern compile = Pattern.compile("^a=rtpmap:(\\d+) " + str5 + "(/\\d+)+[\r]?$");
        int i3 = 0;
        while (true) {
            z2 = true;
            if (i3 >= split.length) {
                i3 = -1;
                str3 = null;
                break;
            }
            Matcher matcher = compile.matcher(split[i3]);
            if (matcher.matches()) {
                str3 = matcher.group(1);
                break;
            }
            i3++;
        }
        if (str3 == null) {
            SystemUtils.log(5, "SDPUtils", "No rtpmap for " + str5 + " codec", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.g", 79);
            return str6;
        }
        SystemUtils.log(3, "SDPUtils", "找到编码器 " + str5 + " rtpmap " + str3 + " at " + split[i3], (Throwable) null, "com.didichuxing.mlcp.drtc.utils.g", 83);
        StringBuilder sb = new StringBuilder();
        sb.append("^a=fmtp:");
        sb.append(str3);
        sb.append(" \\w+=\\d+.*[\r]?$");
        Pattern compile2 = Pattern.compile(sb.toString());
        int i4 = 0;
        while (true) {
            if (i4 >= split.length) {
                z2 = false;
                break;
            } else if (compile2.matcher(split[i4]).matches()) {
                SystemUtils.log(3, "SDPUtils", "Found " + str5 + " " + split[i4], (Throwable) null, "com.didichuxing.mlcp.drtc.utils.g", 95);
                if (z) {
                    split[i4] = split[i4] + "; x-google-start-bitrate=" + i2;
                } else {
                    split[i4] = split[i4] + "; maxaveragebitrate=" + (i2 * 1000);
                }
                SystemUtils.log(3, "SDPUtils", "Update remote SDP line: " + split[i4], (Throwable) null, "com.didichuxing.mlcp.drtc.utils.g", 105);
            } else {
                i4++;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i5 = 0; i5 < split.length; i5++) {
            sb2.append(split[i5]);
            sb2.append("\r\n");
            if (!z2 && i5 == i3) {
                if (z) {
                    str4 = "a=fmtp:" + str3 + " " + RTCConsts.VIDEO_CODEC_PARAM_START_BITRATE + "=" + i2;
                } else {
                    str4 = "a=fmtp:" + str3 + " " + RTCConsts.AUDIO_CODEC_PARAM_BITRATE + "=" + (i2 * 1000);
                }
                SystemUtils.log(3, "SDPUtils", "Add remote SDP line: " + str4, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.g", 125);
                sb2.append(str4);
                sb2.append("\r\n");
            }
        }
        SystemUtils.log(3, "SDPUtils", "设置起始码率操作结束", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.g", 130);
        return sb2.toString();
    }
}
