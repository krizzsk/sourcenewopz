package com.didi.sdk.util;

import android.text.TextUtils;
import com.didi.sdk.util.config.Preferences;
import java.util.UUID;

public class SUUIDHelper {

    /* renamed from: a */
    private static final String f37680a = "sysdata";

    /* renamed from: b */
    private static final String f37681b = "uuid.sys";

    /* renamed from: c */
    private static String f37682c;

    public static String getDiDiSUUID() {
        if (!TextUtils.isEmpty(f37682c)) {
            return f37682c;
        }
        String diDiUUID = Preferences.getInstance().getDiDiUUID();
        f37682c = diDiUUID;
        if (!TextUtils.isEmpty(diDiUUID)) {
            return f37682c;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.valueOf(System.getProperties().toString() + System.currentTimeMillis()));
        sb2.append(UUID.randomUUID());
        sb.append(MD5.toMD5(sb2.toString()));
        sb.append("_");
        sb.append(SystemUtil.getChannelId());
        String sb3 = sb.toString();
        f37682c = sb3;
        if (TextUtils.isEmpty(sb3)) {
            return f37682c;
        }
        Preferences.getInstance().setDiDiUUID(f37682c);
        return f37682c;
    }
}
