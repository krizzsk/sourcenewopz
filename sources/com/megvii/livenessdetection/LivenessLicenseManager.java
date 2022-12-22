package com.megvii.livenessdetection;

import android.content.Context;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.megvii.licensemanager.ILicenseManager;
import com.megvii.livenessdetection.obf.C20343b;
import com.megvii.livenessdetection.obf.C20344c;
import com.megvii.livenessdetection.obf.C20347e;
import java.security.InvalidParameterException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LivenessLicenseManager implements ILicenseManager {

    /* renamed from: a */
    private Context f55785a;

    /* renamed from: b */
    private C20347e f55786b;

    private native String nativeCheckLicense(Context context, String str);

    private native String nativeGenAuthMsg(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    public LivenessLicenseManager(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.f55785a = applicationContext;
            C20344c.m40211a(applicationContext).mo165090a("livenessdetection", "v2.4.5");
            this.f55786b = new C20347e(this.f55785a);
            return;
        }
        throw new InvalidParameterException("mContext cannot be null");
    }

    public String getContext(String str) {
        int i;
        JSONObject a = C20343b.m40205a();
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        String sb2 = sb.toString();
        this.f55786b.mo165093a("809bd36cf78612fd1f11b739c382bfac", C20343b.m40204a(this.f55785a.getPackageName().getBytes()));
        this.f55786b.mo165093a("37dbd151eb3ca24477bc27cf0febcbe3", sb2);
        String a2 = this.f55786b.mo165092a("cb072839e1e240a23baae123ca6cf165");
        Context context = this.f55785a;
        String packageName = context.getPackageName();
        String jSONObject = a.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(System.currentTimeMillis() / 1000);
        try {
            JSONObject jSONObject2 = new JSONObject(nativeGenAuthMsg(context, packageName, str, jSONObject, sb3.toString(), m40186a(this.f55785a), a2));
            String string = jSONObject2.getString("auth");
            String string2 = jSONObject2.getString("seed");
            String string3 = jSONObject2.getString("key");
            try {
                i = Integer.parseInt(this.f55786b.mo165092a("5f389fef5fd41c84a33a91c6574cbf51"));
            } catch (Exception unused) {
                i = 0;
            }
            C20347e eVar = this.f55786b;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(i + 1);
            eVar.mo165093a("5f389fef5fd41c84a33a91c6574cbf51", sb4.toString());
            this.f55786b.mo165093a("b62f7aea9613b98976498a9ecabe537b", string3);
            if (!string2.equals(a2)) {
                this.f55786b.mo165093a("cb072839e1e240a23baae123ca6cf165", string2);
            }
            return string;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long setLicense(String str) {
        long j;
        if (!(this.f55785a == null || str == null || str.length() == 0)) {
            this.f55785a = this.f55785a.getApplicationContext();
            if (!(this.f55786b.mo165092a("b62f7aea9613b98976498a9ecabe537b") == null || this.f55786b.mo165092a("cb072839e1e240a23baae123ca6cf165") == null)) {
                try {
                    JSONObject jSONObject = new JSONObject(nativeCheckLicense(this.f55785a, this.f55786b.mo165092a("cb072839e1e240a23baae123ca6cf165") + ":" + this.f55786b.mo165092a("b62f7aea9613b98976498a9ecabe537b") + ":" + str));
                    j = jSONObject.getLong("expire_time");
                    try {
                        int i = new JSONObject(jSONObject.getString("extra")).getInt("max_saved_log");
                        C20347e eVar = this.f55786b;
                        StringBuilder sb = new StringBuilder();
                        sb.append(i);
                        eVar.mo165093a("889109d126886bd98bc8f6a70d138545", sb.toString());
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    j = 0;
                }
                if (j != 0) {
                    C20347e eVar2 = this.f55786b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(j);
                    eVar2.mo165093a("a01625815f3428cb69100cc5d613fa7d", sb2.toString());
                    this.f55786b.mo165093a("e2380b201325a8f252636350338aeae8", this.f55786b.mo165092a("b62f7aea9613b98976498a9ecabe537b") + ":" + str);
                    this.f55786b.mo165093a("bc8f6a70d138545889109d126886bd98", Detector.getVersion());
                }
                return j;
            }
        }
        return 0;
    }

    public long checkCachedLicense() {
        String a = this.f55786b.mo165092a("a01625815f3428cb69100cc5d613fa7d");
        if (a != null && Detector.getVersion().equals(this.f55786b.mo165092a("bc8f6a70d138545889109d126886bd98"))) {
            try {
                long parseLong = Long.parseLong(a);
                if (System.currentTimeMillis() / 1000 > parseLong) {
                    return 0;
                }
                return parseLong;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public String getVersion() {
        return Detector.getVersion();
    }

    /* renamed from: a */
    private String m40186a(Context context) {
        String b;
        JSONArray jSONArray = new JSONArray();
        if (context == null) {
            return jSONArray.toString();
        }
        if (!SDKConsts.BOOLEAN_FALSE.equals(this.f55786b.mo165092a("49668163590f816aaf863df014568115")) && (b = this.f55786b.mo165094b("8cd0604ba33e2ba7f38a56f0aec08a54")) != null) {
            try {
                jSONArray = new JSONArray(b);
            } catch (Exception unused) {
            }
        }
        return jSONArray.toString();
    }

    static {
        try {
            System.loadLibrary("livenessdetection_v2.4.5");
        } catch (Exception unused) {
        }
    }
}
