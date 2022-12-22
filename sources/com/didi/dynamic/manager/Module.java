package com.didi.dynamic.manager;

import android.content.Context;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.dynamic.manager.utils.DownloadUtil;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class Module implements Cloneable {
    public static final int LAUNCH_TYPE_DEFAULT = 1;
    public static final int LAUNCH_TYPE_NEEDED = 2;
    public static final int LAUNCH_TYPE_WIFI = 3;
    public static final int MODULE_TYPE_HYBRID = 2;
    public static final int MODULE_TYPE_PATCH = 1;
    public static final int MODULE_TYPE_PLUGIN = 0;
    public static final int MODULE_TYPE_UNKNOWN = -1;

    /* renamed from: b */
    private static final String f19335b = "Module";

    /* renamed from: a */
    boolean f19336a;
    public String appVersion;
    public String ext;
    public int launchType;
    public String moduleCode;
    public boolean moduleIsUseful;
    public File modulePath;
    public File moduleTempPath;
    public int moduleType = -1;
    public String url;
    public String version;
    public long versionLong;

    Module() {
    }

    /* renamed from: a */
    static Module m14451a(Context context, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt(DownloadManager.KEY_PACKAGE_TYPE, 0);
        Module module = new Module();
        module.moduleType = optInt;
        String string = jSONObject.getString(DownloadManager.KEY_MODULE_VERSION);
        module.version = string;
        try {
            module.versionLong = Long.parseLong(string);
            module.moduleCode = jSONObject.getString(DownloadManager.KEY_MODULE_CODE);
            module.url = jSONObject.getString("url");
            module.launchType = jSONObject.getInt(DownloadManager.KEY_LAUNCH_TYPE);
            module.ext = jSONObject.optString("ext", "");
            File dir = context.getDir(DownloadManager.MODULE_DIR, 0);
            File file = new File(dir, DownloadManager.MODULE_DIR_TEMP);
            new File(dir, DownloadManager.MODULE_DIR_ZIP);
            String str = optInt == 0 ? ".apk" : PmFileConstant.ZIP_SUFFIX;
            module.modulePath = new File(dir, module.moduleCode + "_" + module.version + str);
            module.moduleTempPath = new File(file, module.moduleCode + "_" + module.version + str);
            module.appVersion = DownloadUtil.getVersionNameAndCode(context);
            module.moduleIsUseful = true;
            return module;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public Module clone() {
        Module module = new Module();
        module.moduleCode = this.moduleCode;
        module.version = this.version;
        module.url = this.url;
        module.launchType = this.launchType;
        module.f19336a = this.f19336a;
        module.modulePath = this.modulePath;
        module.moduleTempPath = this.moduleTempPath;
        module.appVersion = this.appVersion;
        module.moduleType = this.moduleType;
        module.versionLong = this.versionLong;
        module.moduleIsUseful = this.moduleIsUseful;
        module.ext = this.ext;
        return module;
    }

    public boolean isDownloaded() {
        return this.f19336a;
    }

    public boolean isAvailable() {
        return isDownloaded();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Module)) {
            return false;
        }
        Module module = (Module) obj;
        if (!this.moduleCode.equals(module.moduleCode) || !this.version.equals(module.version) || !this.appVersion.equals(module.appVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.moduleCode.hashCode() + 31) * 31) + this.version.hashCode()) * 31) + this.appVersion.hashCode();
    }

    public String toString() {
        return "Module[ " + this.moduleCode + " : " + this.version + " : " + this.appVersion + " ]";
    }
}
