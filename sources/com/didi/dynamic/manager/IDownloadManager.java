package com.didi.dynamic.manager;

import java.util.List;
import java.util.Set;

public interface IDownloadManager {
    void addDownloadListener(int i, IDownloadListener iDownloadListener);

    void checkModuleAndDownload();

    Module checkModuleAndDownloadByModuleName(String str);

    void cleanModuleByModuleType(int i);

    void deleteModule(Module module);

    void deleteModule(String str, String str2);

    Set<String> getAllCurrentModuleCodes();

    List<Module> getAllCurrentModules();

    List<Module> getModules(String str);

    Module getNewestDownloadedModule(String str);

    Module getNewestModule(String str);

    void removeDownloadListener(int i, IDownloadListener iDownloadListener);

    void removeDownloadListener(IDownloadListener iDownloadListener);

    void setExtraParameter(String str, String str2, int i, double d, double d2, String str3);
}
