package com.didi.dimina.container.bundle.bean;

import java.io.Serializable;
import java.util.List;

public class AppInfo {

    /* renamed from: id */
    public String f16786id;
    public List<ModuleInfo> moduleInfos;
    public String version;
    public String versionName;

    public static class ModuleInfo implements Serializable {
        public String dirPath;
        public String moduleName;
        public String version;
        public String versionName;
    }
}
