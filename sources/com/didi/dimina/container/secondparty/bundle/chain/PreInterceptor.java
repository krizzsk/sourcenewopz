package com.didi.dimina.container.secondparty.bundle.chain;

import android.text.TextUtils;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.secondparty.bundle.util.PmJsonUtil;
import com.didi.dimina.container.secondparty.bundle.util.UpgradeUtil;
import com.didi.dimina.container.secondparty.util.Trace4DiUtil;
import com.didi.dimina.container.util.DebugKitStoreUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;

public class PreInterceptor extends IPckInterceptor {
    public static final String TAG = "Dimina-PM PreInterceptor";

    /* access modifiers changed from: protected */
    public boolean process() {
        LogUtil.iRelease(TAG, "process() -> \t config=" + this.config + "\tthis@" + hashCode());
        Trace4DiUtil.setMainPackageDownloadStartTime();
        if (TextUtils.equals("debugkit_dload_limittrue", DebugKitStoreUtil.getDloadLimit(this.jsAppId))) {
            LogUtil.iRelease(TAG, " debug工具禁止更新，此时只使用assets目录下的配置 ");
            PmFileUtil.deleteFile(PmFileHelper.getFileDmBundleDir(Dimina.getConfig().getApp()));
        }
        String readFilesJsAppDmConfig = PmFileHelper.readFilesJsAppDmConfig(Dimina.getConfig().getApp(), this.jsAppId, this.mina);
        if (!TextUtils.isEmpty(readFilesJsAppDmConfig)) {
            this.config.localDmConfigBean = PmJsonUtil.json2DmConfigBean(readFilesJsAppDmConfig);
        }
        if (this.config.localDmConfigBean != null && !UpgradeUtil.isNativeAppUpgrade()) {
            return true;
        }
        String readAssetDmConfig = PmFileHelper.readAssetDmConfig(this.mina, Dimina.getConfig().getApp(), this.config.jsAppAssetDir);
        this.config.assetDmConfigBean = PmJsonUtil.json2DmConfigBean(readAssetDmConfig);
        if (this.config.assetDmConfigBean != null && (!TextUtils.equals(this.config.assetDmConfigBean.getAppId(), this.jsAppId) || !TextUtils.equals(this.config.assetDmConfigBean.getSdkId(this.mina), this.jsSdkId))) {
            LogUtil.eRelease(TAG, "!!!!!!!!!!!!!!! ------------  出现错误 ----------- !!!!!!!!!!!!!!!");
            LogUtil.eRelease(TAG, "传入的jsAppId(或JsSdkId), 与 Asset 中读取的值不同");
            LogUtil.eRelease(TAG, "asset配置:" + this.config.assetDmConfigBean);
            if (!TextUtils.equals(this.config.assetDmConfigBean.getAppId(), this.jsAppId)) {
                this.config.localErrCode = PckErrCode.JSAPP_ID_NOT_EQUAL_ASSET_ID;
            } else {
                this.config.localErrCode = PckErrCode.JSSDK_ID_NOT_EQUAL_ASSET_ID;
            }
            if (Dimina.getConfig().isDebug()) {
                UIHandlerUtil.post($$Lambda$PreInterceptor$lG4BdDuIfTmlTZwQPcc3C_RY0Bg.INSTANCE);
            }
        }
        UpgradeUtil.saveNativeAppVersionCode2MMKV();
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreInterceptor{, App:'");
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
