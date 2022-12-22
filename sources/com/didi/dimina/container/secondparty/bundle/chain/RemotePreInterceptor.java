package com.didi.dimina.container.secondparty.bundle.chain;

import android.text.TextUtils;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.util.InterceptorConfigHelper;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.util.DebugKitStoreUtil;
import com.didi.dimina.container.util.LogUtil;

public class RemotePreInterceptor extends IPckInterceptor {
    public static final String TAG = "Dimina-PM RemotePreInterceptor";

    /* access modifiers changed from: protected */
    public boolean process() {
        LogUtil.iRelease(TAG, "process() -> \t config=" + this.config + "\tthis@" + hashCode());
        InterceptorConfigHelper.dealProcessCallBack(this.config, 5);
        this.mina.getPerformance().setRemoteInstallStartTime();
        if (TextUtils.equals("debugkit_dload_limittrue", DebugKitStoreUtil.getDloadLimit(this.jsAppId))) {
            LogUtil.eRelease(TAG, "进入开发者模式, 不执行远程安装  ");
            this.config.remoteErrCode = PckErrCode.DEBUGKIT_LIMITED;
            return true;
        }
        if (this.config.localDmConfigBean == null) {
            this.config.localDmConfigBean = new DMConfigBean();
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RemotePreInterceptor{, App:'");
        sb.append(this.jsAppId);
        sb.append('\'');
        sb.append(", sdk:'");
        sb.append(this.jsSdkId);
        sb.append('\'');
        sb.append(", @");
        sb.append(hashCode());
        sb.append(", DMMina@");
        sb.append(this.mina != null ? Integer.valueOf(this.mina.hashCode()) : "null");
        sb.append('}');
        return sb.toString();
    }
}
