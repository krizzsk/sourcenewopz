package com.didi.dimina.container.secondparty.bundle.chain;

import android.content.Context;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.secondparty.bundle.DiminaHelper;
import com.didi.dimina.container.secondparty.bundle.UnzipManager;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.util.PmAssetsUtil;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.secondparty.bundle.util.PmJsonUtil;
import com.didi.dimina.container.secondparty.util.DebugExceptionUtil;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.VersionUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AssetInterceptor extends IPckInterceptor {
    public static final String TAG = "Dimina-PM AssetInterceptor ";

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean process() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "process() -> \t config="
            r0.append(r1)
            com.didi.dimina.container.secondparty.bundle.chain.InterceptorConfig r1 = r6.config
            r0.append(r1)
            java.lang.String r1 = "\tthis@"
            r0.append(r1)
            int r1 = r6.hashCode()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Dimina-PM AssetInterceptor "
            com.didi.dimina.container.util.LogUtil.iRelease(r1, r0)
            com.didi.dimina.container.secondparty.bundle.chain.InterceptorConfig r0 = r6.config
            com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean r0 = r0.localDmConfigBean
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x002e
            r0 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            com.didi.dimina.container.secondparty.bundle.chain.InterceptorConfig r4 = r6.config
            com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean r4 = r4.assetDmConfigBean
            if (r4 == 0) goto L_0x0037
            r4 = 1
            goto L_0x0038
        L_0x0037:
            r4 = 0
        L_0x0038:
            if (r0 == 0) goto L_0x0055
            if (r4 == 0) goto L_0x0047
            boolean r0 = r6.m12590d()
            if (r0 == 0) goto L_0x0047
            r6.m12583a()
            r0 = 1
            goto L_0x0048
        L_0x0047:
            r0 = 0
        L_0x0048:
            if (r4 == 0) goto L_0x0053
            boolean r4 = r6.m12589c()
            if (r4 == 0) goto L_0x0053
            r2 = r0
            r0 = 1
            goto L_0x006f
        L_0x0053:
            r2 = r0
            goto L_0x0062
        L_0x0055:
            if (r4 != 0) goto L_0x0064
            java.lang.String r0 = "Asset操作读取配置文件为null"
            com.didi.dimina.container.util.LogUtil.eRelease(r1, r0)
            com.didi.dimina.container.secondparty.bundle.chain.InterceptorConfig r0 = r6.config
            r4 = -202(0xffffffffffffff36, float:NaN)
            r0.localErrCode = r4
        L_0x0062:
            r0 = 0
            goto L_0x006f
        L_0x0064:
            com.didi.dimina.container.secondparty.bundle.chain.InterceptorConfig r0 = r6.config
            com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean r2 = new com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean
            r2.<init>()
            r0.localDmConfigBean = r2
            r0 = 1
            r2 = 1
        L_0x006f:
            if (r2 == 0) goto L_0x0077
            r6.m12595i()
            r6.m12593g()
        L_0x0077:
            if (r0 == 0) goto L_0x007f
            r6.m12594h()
            r6.m12591e()
        L_0x007f:
            if (r2 != 0) goto L_0x0083
            if (r0 == 0) goto L_0x0086
        L_0x0083:
            r6.m12592f()
        L_0x0086:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "process() ->needJsAppUpgrade="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = " needJsSdkUpgrade="
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = " assetInterceptor done"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.didi.dimina.container.util.LogUtil.iRelease(r1, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.bundle.chain.AssetInterceptor.process():boolean");
    }

    /* renamed from: a */
    private void m12583a() {
        LogUtil.eRelease(TAG, "Asset的版本高, 底包升级了, 要进行删除files，Asset重新复制的操作 ");
        String str = PmFileHelper.getFileDmBundleDir(Dimina.getConfig().getApp()) + File.separator + this.jsAppId + File.separator + this.config.localDmConfigBean.getAppVersionCode();
        LogUtil.iRelease(TAG, "升级场景, 需要删除的jsApp 路径 =" + str);
        PmFileUtil.deleteFile(str);
    }

    /* renamed from: b */
    private void m12586b() {
        DebugExceptionUtil.dottingPmTime(TAG + this.jsAppId, "执行 Asset的copy start");
        if (this.config.assetDmConfigBean == null) {
            LogUtil.eRelease(TAG, "Asset操作读取配置文件为null");
            this.config.localErrCode = -202;
            return;
        }
        DebugExceptionUtil.dottingPmTime(TAG + this.jsAppId, "底包的copy, 读取配置, json转化耗时");
        m12584a(this.config.assetDmConfigBean);
        m12587b(this.config.assetDmConfigBean);
        if (this.config.localErrCode != -9999) {
            LogUtil.eRelease(TAG, "asset操作 发生错误 " + this.config.localErrCode);
            return;
        }
        PmFileHelper.writeDmConfig2MMKV(this.jsAppId, PmJsonUtil.toString(this.config.assetDmConfigBean), this.mina);
        DebugExceptionUtil.dottingPmTime(TAG + this.jsAppId, " asset操作结束 errCode=" + this.config.localErrCode);
    }

    /* renamed from: a */
    private void m12584a(DMConfigBean dMConfigBean) {
        String createAppJsFilesDir = PmFileHelper.createAppJsFilesDir(this.context, dMConfigBean.getSdkId(this.mina), dMConfigBean.getSdkVersionCode());
        if (!CollectionsUtil.isEmpty((Collection) PmFileUtil.childFileInDir(createAppJsFilesDir))) {
            LogUtil.iRelease(TAG, createAppJsFilesDir + " 路径下有子文件, 所以不进行jsSdk的copy操作");
            return;
        }
        String[] assetsFiles = PmAssetsUtil.getAssetsFiles(this.context, DiminaHelper.getJsSdkAssetDir(this.mina));
        LogUtil.iRelease(TAG, "jsSdk路径=" + DiminaHelper.getJsSdkAssetDir(this.mina) + "\t 操作sdkFileList = " + Arrays.toString(assetsFiles));
        for (String str : assetsFiles) {
            Context context = this.context;
            PmAssetsUtil.copyAssetsFile(context, DiminaHelper.getJsSdkAssetDir(this.mina) + File.separator + str, createAppJsFilesDir);
        }
        ArrayList arrayList = new ArrayList();
        for (String next : PmFileUtil.childFileInDir(createAppJsFilesDir)) {
            if (next.endsWith(PmFileConstant.ZIP_SUFFIX)) {
                arrayList.add(createAppJsFilesDir + File.separator + next);
            }
        }
        LogUtil.iRelease(TAG, "jsSdk 需要解压的zip文件是: " + arrayList);
        UnzipManager.unzip(m12582a((List<String>) arrayList), new IDMCommonAction(createAppJsFilesDir) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void callback(Object obj) {
                AssetInterceptor.this.m12588b(this.f$1, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m12588b(String str, Boolean bool) {
        LogUtil.iRelease(TAG, "jssdk 解压结果 -> " + bool);
        if (!bool.booleanValue()) {
            LogUtil.eRelease(TAG, "jssdk 解压失败, 删除目录 : " + str);
            this.config.localErrCode = -204;
            PmFileUtil.deleteFile(str);
        }
    }

    /* renamed from: b */
    private void m12587b(DMConfigBean dMConfigBean) {
        String createAppJsFilesDir = PmFileHelper.createAppJsFilesDir(this.context, dMConfigBean.getAppId(), dMConfigBean.getAppVersionCode());
        if (!CollectionsUtil.isEmpty((Collection) PmFileUtil.childFileInDir(createAppJsFilesDir))) {
            LogUtil.iRelease(TAG, createAppJsFilesDir + " 路径下有子文件, 所以不进行jsApp的copy操作");
            return;
        }
        String[] assetsFiles = PmAssetsUtil.getAssetsFiles(this.context, this.config.jsAppAssetDir);
        LogUtil.iRelease(TAG, "jsApp路径:" + this.config.jsAppAssetDir + "jsApp appFileList = " + Arrays.toString(assetsFiles));
        for (String str : assetsFiles) {
            Context context = this.context;
            PmAssetsUtil.copyAssetsFile(context, this.config.jsAppAssetDir + File.separator + str, createAppJsFilesDir);
        }
        ArrayList arrayList = new ArrayList();
        for (String next : PmFileUtil.childFileInDir(createAppJsFilesDir)) {
            if (next.endsWith(PmFileConstant.ZIP_SUFFIX)) {
                arrayList.add(createAppJsFilesDir + File.separator + next);
            }
        }
        LogUtil.iRelease(TAG, "jsApp 需要解压的zip文件是: " + arrayList);
        UnzipManager.unzip(m12582a((List<String>) arrayList), new IDMCommonAction(createAppJsFilesDir) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void callback(Object obj) {
                AssetInterceptor.this.m12585a(this.f$1, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12585a(String str, Boolean bool) {
        LogUtil.iRelease(TAG, "jsApp 解压结果 -> " + bool);
        if (!bool.booleanValue()) {
            LogUtil.eRelease(TAG, "jsApp 解压失败, 删除目录 : " + str);
            this.config.localErrCode = -205;
            PmFileUtil.deleteFile(str);
        }
    }

    /* renamed from: a */
    private List<InstallModuleFileDescribe> m12582a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            InstallModuleFileDescribe installModuleFileDescribe = new InstallModuleFileDescribe();
            installModuleFileDescribe.setRelativePath(PmFileHelper.absolutePath2RelativePath(next));
            installModuleFileDescribe.setCacheAbsolutePath(next);
            installModuleFileDescribe.setFilesAbsolutePath(next);
            String substring = next.substring(next.lastIndexOf(File.separator) + 1);
            installModuleFileDescribe.setModuleName(substring.substring(0, substring.lastIndexOf(PmFileConstant.ZIP_SUFFIX)));
            arrayList.add(installModuleFileDescribe);
        }
        return arrayList;
    }

    /* renamed from: c */
    private boolean m12589c() {
        return VersionUtil.compareVersion(this.config.localDmConfigBean.getSdkVersionCode(), this.config.assetDmConfigBean.getSdkVersionCode()) < 0;
    }

    /* renamed from: d */
    private boolean m12590d() {
        return VersionUtil.compareVersion(this.config.localDmConfigBean.getAppVersionCode(), this.config.assetDmConfigBean.getAppVersionCode()) < 0;
    }

    /* renamed from: e */
    private void m12591e() {
        m12584a(this.config.assetDmConfigBean);
    }

    /* renamed from: f */
    private void m12592f() {
        PmFileHelper.writeDmConfig2MMKV(this.jsAppId, PmJsonUtil.toString(this.config.localDmConfigBean), this.mina);
    }

    /* renamed from: g */
    private void m12593g() {
        m12587b(this.config.assetDmConfigBean);
    }

    /* renamed from: h */
    private void m12594h() {
        DMConfigBean dMConfigBean = this.config.assetDmConfigBean;
        DMConfigBean dMConfigBean2 = this.config.localDmConfigBean;
        dMConfigBean2.setSdkId(dMConfigBean.getSdkId(this.mina));
        dMConfigBean2.setSdkVersionCode(dMConfigBean.getSdkVersionCode());
        dMConfigBean2.setSdkVersionName(dMConfigBean.getSdkVersionName());
        dMConfigBean2.setSdkModule(dMConfigBean.getSdkModule());
    }

    /* renamed from: i */
    private void m12595i() {
        DMConfigBean dMConfigBean = this.config.assetDmConfigBean;
        DMConfigBean dMConfigBean2 = this.config.localDmConfigBean;
        dMConfigBean2.setAppId(dMConfigBean.getAppId());
        dMConfigBean2.setAppVersionCode(dMConfigBean.getAppVersionCode());
        dMConfigBean2.setAppVersionName(dMConfigBean.getAppVersionName());
        dMConfigBean2.setAppModules(dMConfigBean.getAppModules());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AssetInterceptor{, App:'");
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
