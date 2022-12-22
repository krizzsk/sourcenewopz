package com.didi.usercenter.net.pojo;

import android.content.Context;
import com.didi.sdk.util.SystemUtil;
import com.didi.usercenter.util.SignatureHelper;
import com.google.gson.Gson;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UserInfoReqParam implements Serializable {
    private String android_id;
    private String cancel;
    private String cpu = SystemUtil.getCPUSerialno();
    private String deviceid = SystemUtil.getIMEI();
    private String imei = SystemUtil.getIMEI();
    private String lang;
    private String mac = SystemUtil.getMacSerialno();
    private String pixels;
    private String sig;
    private String suuid;
    private String token;
    private String uuid;

    public UserInfoReqParam(Context context, String str, String str2) {
        this.suuid = SignatureHelper.getUUID(context);
        this.android_id = SignatureHelper.getAndroidID(context);
        StringBuilder sb = new StringBuilder();
        sb.append("test");
        sb.append(SignatureHelper.toMD5(this.suuid + "*&didi@").toLowerCase());
        this.cancel = sb.toString();
        this.pixels = "1440*2392";
        this.uuid = SignatureHelper.toMD5("1_" + this.android_id + "2_" + this.imei + "3_" + this.cpu);
        this.token = str;
        this.sig = SignatureHelper.getParamSig(new Gson().toJson((Object) this));
        this.lang = str2;
    }

    public Map<String, String> getBaseMap() {
        HashMap hashMap = new HashMap();
        ArrayList<Field> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getClass().getDeclaredFields()));
        for (Field field : arrayList) {
            try {
                if (!field.getName().equals("$change")) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);
                        Object obj = field.get(this);
                        if (!(obj instanceof String)) {
                            obj = String.valueOf(obj);
                        }
                        hashMap.put(field.getName(), (String) obj);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }
}
