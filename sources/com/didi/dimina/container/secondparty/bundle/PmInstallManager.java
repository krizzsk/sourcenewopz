package com.didi.dimina.container.secondparty.bundle;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.chain.ChainManager;
import com.didi.dimina.container.secondparty.bundle.chain.IPckInterceptor;
import com.didi.dimina.container.secondparty.bundle.chain.InterceptorConfig;
import java.util.List;

public class PmInstallManager {
    public static final String TAG = "Dimina-PM PmInstallManager";

    public interface DmInstallCallBack {
        void onLocalInstall(int i, DMConfigBean dMConfigBean, InstallExtraInfo installExtraInfo);

        void onRemoteInstall(int i, DMConfigBean dMConfigBean, InstallExtraInfo installExtraInfo);

        void onSubPreInstall(int i, List<InstallModuleFileDescribe> list, InstallExtraInfo installExtraInfo);
    }

    public interface InstallProcessCallBack {
        public static final int PROCESS_REMOTE_START_INSTALL = 5;
        public static final int PROCESS_START_INSTALL = 1;

        void onProcess(int i);
    }

    public static void install(DMMina dMMina, String str, String str2, InstallProcessCallBack installProcessCallBack, DmInstallCallBack dmInstallCallBack) {
        IPckInterceptor localIOChain = ChainManager.getLocalIOChain();
        InterceptorConfig interceptorConfig = new InterceptorConfig();
        interceptorConfig.jsAppId = str2;
        interceptorConfig.jsSdkId = str;
        interceptorConfig.jsAppAssetDir = DiminaHelper.getJsAppAssetDir(dMMina);
        interceptorConfig.processCb = installProcessCallBack;
        interceptorConfig.installCb = dmInstallCallBack;
        localIOChain.setValue(dMMina, interceptorConfig);
        PmIOQueueManager.getInstance().enqueue(localIOChain);
    }

    public static class InstallExtraInfo {
        public static final int DEFAULT_NO_SET = -1;
        public static final int LOCAL_INSTALL_COPY_ASSET = 1;
        public static final int LOCAL_INSTALL_FILE_EXIT = 2;
        public static final int REMOTE_INSTALL_DOWNLOAD_OK = 3;
        public static final int REMOTE_INTALL_NO_NEED_DOWNLOAD = 4;
        public int localInstallType = -1;
        public String otherInfo = "";
        public int remoteInstallType = -1;

        public String toString() {
            return "InstallExtraInfo{localInstallType=" + this.localInstallType + ", remoteInstallType=" + this.remoteInstallType + ", otherInfo=" + this.otherInfo + '}';
        }
    }
}
