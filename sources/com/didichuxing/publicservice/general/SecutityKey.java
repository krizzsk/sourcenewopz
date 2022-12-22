package com.didichuxing.publicservice.general;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import org.apache.commons.codec2.binary.Base64;
import org.apache.commons.codec2.digest.DigestUtils;

public class SecutityKey {
    public static final String SIGNATURE = "sd#6jjfsd@987sdffi$";
    private static SecutityKey mInstance;

    public static SecutityKey getInstance() {
        if (mInstance == null) {
            mInstance = new SecutityKey();
        }
        return mInstance;
    }

    public String renderSignatureStr(Map<String, Object> map, String str) {
        ArrayList<Map.Entry> arrayList = new ArrayList<>(map.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Object>>() {
            public int compare(Map.Entry<String, Object> entry, Map.Entry<String, Object> entry2) {
                return entry.getKey().compareTo(entry2.getKey());
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append(str + ParamKeys.SIGN_AND);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : arrayList) {
                sb.append((String) entry.getKey());
                sb.append("=");
                String valueOf = String.valueOf(entry.getValue());
                if (valueOf != null) {
                    sb.append(valueOf.trim());
                    sb.append(ParamKeys.SIGN_AND);
                } else {
                    sb.append(valueOf);
                    sb.append(ParamKeys.SIGN_AND);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return Base64.encodeBase64String(DigestUtils.md5Hex(sb.toString()).getBytes());
    }
}
