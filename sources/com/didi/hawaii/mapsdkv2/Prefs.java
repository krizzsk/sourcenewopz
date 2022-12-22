package com.didi.hawaii.mapsdkv2;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.hawaii.utils.C9266IO;
import com.didi.hawaii.utils.StringUtil;
import com.didi.map.MapApolloHawaii;
import com.didi.map.constant.FileNameConstant;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;

public class Prefs {

    /* renamed from: b */
    private static final String f23683b = "com.didi.map";

    /* renamed from: c */
    private static final String f23684c = "sdk2_version";

    /* renamed from: a */
    private SharedPreferences f23685a = null;

    /* renamed from: d */
    private String f23686d;

    /* renamed from: e */
    private String f23687e;

    /* renamed from: f */
    private String f23688f;

    /* renamed from: g */
    private Context f23689g;

    /* renamed from: h */
    private String f23690h;

    public Prefs(Context context) {
        this.f23689g = context;
        this.f23688f = context.getFilesDir().getAbsolutePath() + FileNameConstant.CONFIG_FOLDER;
        this.f23690h = context.getFilesDir().getAbsolutePath() + FileNameConstant.MAP_GUARD_FOLDER;
        String str = this.f23688f;
        String a = m16827a(context);
        int i = MapApolloHawaii.BASE_MAP_VERSION;
        if (StringUtil.isEmpty(a)) {
            this.f23686d = str + FileNameConstant.RENDER_FOLDER_CONFIG + "_" + i + "d/";
        } else {
            this.f23686d = str + FileNameConstant.RENDER_SUB_FOLDER_CONFIG + "_" + i + "d/";
        }
        this.f23687e = str + FileNameConstant.SAT_FOLDER_V2;
    }

    public String getCachedSDKVersion() {
        if (this.f23685a == null) {
            this.f23685a = SystemUtils.getSharedPreferences(this.f23689g, "com.didi.map", 0);
        }
        return this.f23685a.getString(f23684c, (String) null);
    }

    public void setCachedSDKVersion(String str) {
        this.f23685a.edit().putString(f23684c, str).apply();
    }

    public String getMapPath4Language(int i) {
        String str = this.f23686d;
        if (i == 1) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            str = str + "_eng/";
        } else if (i == 2) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            str = str + "_gat/";
        } else if (i == 3) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            str = str + "_pt/";
        } else if (i == 4) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            str = str + "_es/";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public String getSatPath() {
        return this.f23687e;
    }

    public String getConfigPath() {
        return this.f23688f;
    }

    public String getMapGuardPath() {
        C9266IO.ensureDir(this.f23690h);
        return this.f23690h;
    }

    public String getWmsPath() {
        return this.f23688f + FileNameConstant.WMS_FOLDER_V2;
    }

    /* renamed from: a */
    private static String m16827a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String packageName = context.getPackageName();
            if (packageName != null) {
                if (packageName.length() != 0) {
                    return packageName.length() > 255 ? packageName.substring(0, 254) : packageName;
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
