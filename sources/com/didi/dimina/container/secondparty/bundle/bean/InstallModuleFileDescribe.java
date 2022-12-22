package com.didi.dimina.container.secondparty.bundle.bean;

import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import java.io.Serializable;

public class InstallModuleFileDescribe implements Serializable {
    private String cacheAbsolutePath;
    private String filesAbsolutePath;
    private String key;
    private int lazyDownload;
    private String md5;
    private int moduleId;
    private String moduleName;
    private String relativePath;
    private String url;

    public InstallModuleFileDescribe() {
    }

    public InstallModuleFileDescribe(DMConfigBean.AppModulesBean appModulesBean) {
        this.md5 = appModulesBean.getMd5();
        this.moduleId = appModulesBean.getModuleId();
        this.moduleName = appModulesBean.getModuleName();
        this.key = appModulesBean.getKey();
        this.url = appModulesBean.getUrl();
        this.lazyDownload = appModulesBean.getLazyDownload();
    }

    public String getCacheAbsolutePath() {
        return this.cacheAbsolutePath;
    }

    public void setCacheAbsolutePath(String str) {
        this.cacheAbsolutePath = str;
    }

    public String getFilesAbsolutePath() {
        return this.filesAbsolutePath;
    }

    public void setFilesAbsolutePath(String str) {
        this.filesAbsolutePath = str;
    }

    public String getRelativePath() {
        return this.relativePath;
    }

    public void setRelativePath(String str) {
        this.relativePath = str;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(int i) {
        this.moduleId = i;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public int getLazyDownload() {
        return this.lazyDownload;
    }

    public void setLazyDownload(int i) {
        this.lazyDownload = i;
    }

    public String toString() {
        return "InstallMoudleFileDescribe{relativePath='" + this.relativePath + '\'' + ", cache_absolute_path='" + this.cacheAbsolutePath + '\'' + ", files_absolute_path='" + this.filesAbsolutePath + '\'' + ", module_id='" + this.moduleId + '\'' + ", module_name='" + this.moduleName + '\'' + ", key='" + this.key + '\'' + ", lazy_download='" + this.lazyDownload + '\'' + '}';
    }
}
