package com.didi.dimina.container.secondparty.bundle.chain;

import com.didi.dimina.container.secondparty.bundle.PmInstallManager;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import java.util.ArrayList;
import java.util.List;

public class InterceptorConfig {
    public static final String TAG = "Dimina-PM InterceptorConfig";
    public DMConfigBean assetDmConfigBean = null;
    public List<InstallModuleFileDescribe> downloadModuleList = new ArrayList();
    public DMConfigBean httpDmConfigBean = null;
    public PmInstallManager.DmInstallCallBack installCb;
    public boolean isJsAppNeedDownload = false;
    public boolean isJsSdkNeedDownload = false;
    public String jsAppAssetDir;
    public String jsAppId;
    public String jsSdkId;
    public DMConfigBean localDmConfigBean = null;
    public int localErrCode = -9999;
    public PmInstallManager.InstallProcessCallBack processCb;
    public int remoteErrCode = -9999;
    public List<InstallModuleFileDescribe> subPreDownloadModuleList = new ArrayList();
    public int subPreErrCode = -9999;

    public String toString() {
        return "InterceptorConfig{localErrCode=" + this.localErrCode + ", remoteErrCode=" + this.remoteErrCode + ", subPreErrCode=" + this.subPreErrCode + ", jsAppId='" + this.jsAppId + '\'' + ", jsSdkId='" + this.jsSdkId + '\'' + ", jsAppAssetDir='" + this.jsAppAssetDir + '\'' + ", @" + hashCode() + '}';
    }
}
