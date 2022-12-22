package com.didi.sdk.onehotpatch.commonstatic.bean;

import java.io.Serializable;

public class PatchModule implements Serializable {
    private static final long serialVersionUID = 2562105129843079287L;
    public String appVersion;
    public String ext;
    public String moduleCode;
    public String modulePath;
    public String version;
    public long versionLong;

    public String toString() {
        return "PatchModule{moduleCode='" + this.moduleCode + '\'' + ", version='" + this.version + '\'' + ", appVersion='" + this.appVersion + '\'' + ", versionLong=" + this.versionLong + ", modulePath='" + this.modulePath + '\'' + ", ext='" + this.ext + '\'' + '}';
    }
}
