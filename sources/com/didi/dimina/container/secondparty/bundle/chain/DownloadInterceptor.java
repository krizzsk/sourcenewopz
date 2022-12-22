package com.didi.dimina.container.secondparty.bundle.chain;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.bundle.PmIOQueueManager;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadHelper;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadManager;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadTask;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmBundleUtil;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.bundle.util.PmJsonUtil;
import com.didi.dimina.container.secondparty.util.Trace4DiUtil;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0014J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u001cJ\b\u0010#\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/chain/DownloadInterceptor;", "Lcom/didi/dimina/container/secondparty/bundle/chain/IPckInterceptor;", "()V", "mDownloadStartTime", "", "mDownloadTaskList", "", "Lcom/didi/dimina/container/secondparty/bundle/download/PmDownloadTask;", "mStartDowmloadTime", "addDownloadTask4StrategyOneCorrespondOne", "", "addFollowOperation2Queue", "addJsApp2Download", "dmConfig", "Lcom/didi/dimina/container/secondparty/bundle/bean/DMConfigBean;", "appModulesList", "", "Lcom/didi/dimina/container/secondparty/bundle/bean/DMConfigBean$AppModulesBean;", "addJsSdk2Download", "downloadJsApp", "downloadJsSdk", "execRemoteIOChain", "isModuleNull", "", "modulesBean", "process", "startLoad", "toString", "", "traceRemoteInstallEnd", "result", "", "config", "Lcom/didi/dimina/container/secondparty/bundle/chain/InterceptorConfig;", "errCode", "traceRemoteInstallStart", "Companion", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DownloadInterceptor.kt */
public final class DownloadInterceptor extends IPckInterceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "Dimina-PM DownloadInterceptor";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<PmDownloadTask> f17066a = new ArrayList();

    /* renamed from: b */
    private long f17067b;

    /* renamed from: c */
    private long f17068c;

    /* access modifiers changed from: protected */
    public boolean process() {
        LogUtil.iRelease(TAG, "process() -> \t config=" + this.config + "\tthis@" + hashCode());
        if (this.config.remoteErrCode != -9999) {
            m12611d();
            return true;
        } else if (this.config.httpDmConfigBean == null) {
            LogUtil.eRelease(TAG, "返回结果的转化结果为null");
            this.config.remoteErrCode = PckErrCode.HTTP_DM_CONFIG_NULL;
            m12611d();
            return true;
        } else {
            this.f17066a.clear();
            this.config.downloadModuleList.clear();
            this.config.isJsAppNeedDownload = false;
            this.config.isJsSdkNeedDownload = false;
            m12605a();
            if (CollectionsUtil.isEmpty((Collection) this.f17066a)) {
                LogUtil.iRelease(TAG, "没有下载任务 ");
                this.config.remoteErrCode = 0;
                m12611d();
                return true;
            }
            m12612e();
            return false;
        }
    }

    /* renamed from: a */
    private final void m12605a() {
        if (this.config.assetDmConfigBean == null) {
            DMMina dMMina = this.mina;
            Dimina.Config config = Dimina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
            String readAssetDmConfig = PmFileHelper.readAssetDmConfig(dMMina, config.getApp(), this.config.jsAppAssetDir);
            this.config.assetDmConfigBean = PmJsonUtil.json2DmConfigBean(readAssetDmConfig);
        }
        m12610c();
        m12609b();
    }

    /* renamed from: b */
    private final void m12609b() {
        DMConfigBean dMConfigBean = this.config.httpDmConfigBean;
        Intrinsics.checkExpressionValueIsNotNull(dMConfigBean, "config.httpDmConfigBean");
        String sdkVersionCode = dMConfigBean.getSdkVersionCode();
        DMConfigBean dMConfigBean2 = this.config.localDmConfigBean;
        Intrinsics.checkExpressionValueIsNotNull(dMConfigBean2, "config.localDmConfigBean");
        int compareVersion = PmBundleUtil.compareVersion(sdkVersionCode, dMConfigBean2.getSdkVersionCode());
        boolean z = true;
        if (compareVersion == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("jssdk 版本相等， 所以不进行下载任务操作,  返回sdkModule是否为null:");
            DMConfigBean dMConfigBean3 = this.config.httpDmConfigBean;
            Intrinsics.checkExpressionValueIsNotNull(dMConfigBean3, "config.httpDmConfigBean");
            if (dMConfigBean3.getSdkModule() != null) {
                z = false;
            }
            sb.append(z);
            LogUtil.iRelease(TAG, sb.toString());
            return;
        }
        if (this.config.assetDmConfigBean != null) {
            DMConfigBean dMConfigBean4 = this.config.assetDmConfigBean;
            Intrinsics.checkExpressionValueIsNotNull(dMConfigBean4, "config.assetDmConfigBean");
            String sdkVersionCode2 = dMConfigBean4.getSdkVersionCode();
            DMConfigBean dMConfigBean5 = this.config.httpDmConfigBean;
            Intrinsics.checkExpressionValueIsNotNull(dMConfigBean5, "config.httpDmConfigBean");
            if (PmBundleUtil.compareVersion(sdkVersionCode2, dMConfigBean5.getSdkVersionCode()) > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("jssdk版本不同, 本应该下载，但是因为本地jsSdk更高,所以取消下载 AssetJsSdkVersion:");
                DMConfigBean dMConfigBean6 = this.config.assetDmConfigBean;
                Intrinsics.checkExpressionValueIsNotNull(dMConfigBean6, "config.assetDmConfigBean");
                sb2.append(dMConfigBean6.getSdkVersionCode());
                sb2.append("\t httpJsSdkVersion:");
                DMConfigBean dMConfigBean7 = this.config.httpDmConfigBean;
                Intrinsics.checkExpressionValueIsNotNull(dMConfigBean7, "config.httpDmConfigBean");
                sb2.append(dMConfigBean7.getSdkVersionCode());
                LogUtil.eRelease(TAG, sb2.toString());
                return;
            }
        }
        DMConfigBean dMConfigBean8 = this.config.httpDmConfigBean;
        Intrinsics.checkExpressionValueIsNotNull(dMConfigBean8, "config.httpDmConfigBean");
        if (!m12608a(dMConfigBean8.getSdkModule())) {
            this.config.isJsSdkNeedDownload = true;
            DMConfigBean dMConfigBean9 = this.config.httpDmConfigBean;
            Intrinsics.checkExpressionValueIsNotNull(dMConfigBean9, "config.httpDmConfigBean");
            m12606a(dMConfigBean9);
        }
    }

    /* renamed from: c */
    private final void m12610c() {
        DMConfigBean dMConfigBean = this.config.httpDmConfigBean;
        Intrinsics.checkExpressionValueIsNotNull(dMConfigBean, "config.httpDmConfigBean");
        if (!CollectionsUtil.isEmpty((Collection) dMConfigBean.getAppModules())) {
            DMConfigBean dMConfigBean2 = this.config.httpDmConfigBean;
            Intrinsics.checkExpressionValueIsNotNull(dMConfigBean2, "config.httpDmConfigBean");
            String appVersionCode = dMConfigBean2.getAppVersionCode();
            DMConfigBean dMConfigBean3 = this.config.localDmConfigBean;
            Intrinsics.checkExpressionValueIsNotNull(dMConfigBean3, "config.localDmConfigBean");
            if (PmBundleUtil.compareVersion(appVersionCode, dMConfigBean3.getAppVersionCode()) != 0) {
                if (this.config.assetDmConfigBean != null) {
                    DMConfigBean dMConfigBean4 = this.config.assetDmConfigBean;
                    Intrinsics.checkExpressionValueIsNotNull(dMConfigBean4, "config.assetDmConfigBean");
                    String appVersionCode2 = dMConfigBean4.getAppVersionCode();
                    DMConfigBean dMConfigBean5 = this.config.httpDmConfigBean;
                    Intrinsics.checkExpressionValueIsNotNull(dMConfigBean5, "config.httpDmConfigBean");
                    if (PmBundleUtil.compareVersion(appVersionCode2, dMConfigBean5.getAppVersionCode()) > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("jsApp版本不同, 本应该下载，但是因为本地jsApp更高,所以取消下载 AssetJsAppVersion:");
                        DMConfigBean dMConfigBean6 = this.config.assetDmConfigBean;
                        Intrinsics.checkExpressionValueIsNotNull(dMConfigBean6, "config.assetDmConfigBean");
                        sb.append(dMConfigBean6.getAppVersionCode());
                        sb.append("\t httpJsAppVersion:");
                        DMConfigBean dMConfigBean7 = this.config.httpDmConfigBean;
                        Intrinsics.checkExpressionValueIsNotNull(dMConfigBean7, "config.httpDmConfigBean");
                        sb.append(dMConfigBean7.getAppVersionCode());
                        LogUtil.eRelease(TAG, sb.toString());
                        return;
                    }
                }
                List arrayList = new ArrayList();
                DMConfigBean dMConfigBean8 = this.config.httpDmConfigBean;
                Intrinsics.checkExpressionValueIsNotNull(dMConfigBean8, "config.httpDmConfigBean");
                for (DMConfigBean.AppModulesBean next : dMConfigBean8.getAppModules()) {
                    Intrinsics.checkExpressionValueIsNotNull(next, "appModule");
                    if (next.getLazyDownload() == 0) {
                        arrayList.add(next);
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.config.isJsAppNeedDownload = true;
                    DMConfigBean dMConfigBean9 = this.config.httpDmConfigBean;
                    Intrinsics.checkExpressionValueIsNotNull(dMConfigBean9, "config.httpDmConfigBean");
                    m12607a(dMConfigBean9, arrayList);
                    return;
                }
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("jsApp 版本相等，或者返回appModule为null. 所以不进行下载任务操作,  返回appModule是否为null:");
        DMConfigBean dMConfigBean10 = this.config.httpDmConfigBean;
        Intrinsics.checkExpressionValueIsNotNull(dMConfigBean10, "config.httpDmConfigBean");
        sb2.append(CollectionsUtil.isEmpty((Collection) dMConfigBean10.getAppModules()));
        LogUtil.iRelease(TAG, sb2.toString());
    }

    /* renamed from: d */
    private final void m12611d() {
        IPckInterceptor remoteIOChain = ChainManager.getRemoteIOChain();
        remoteIOChain.setValue(this.mina, this.config);
        PmIOQueueManager.getInstance().enqueue(remoteIOChain);
    }

    /* renamed from: e */
    private final void m12612e() {
        LogUtil.iRelease(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  开始下载");
        int size = this.f17066a.size();
        for (int i = 0; i < size; i++) {
            LogUtil.iRelease(TAG, "第" + i + "个下载任务 -> " + this.f17066a.get(i));
        }
        m12614g();
        this.f17067b = System.currentTimeMillis();
        new PmDownloadManager().download(this.f17066a, new DownloadInterceptor$startLoad$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m12613f() {
        IPckInterceptor remoteIOChain = ChainManager.getRemoteIOChain();
        remoteIOChain.setValue(this.mina, this.config);
        PmIOQueueManager.getInstance().enqueue(remoteIOChain);
    }

    /* renamed from: a */
    private final void m12607a(DMConfigBean dMConfigBean, List<? extends DMConfigBean.AppModulesBean> list) {
        for (DMConfigBean.AppModulesBean appModulesBean : list) {
            Dimina.Config config = Dimina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
            String zipModuleCacheUniquFilePath = PmFileHelper.getZipModuleCacheUniquFilePath(config.getApp(), appModulesBean.getModuleName(), dMConfigBean.getAppId(), TextUtils.isEmpty(dMConfigBean.getAppVersionCode()) ? appModulesBean.getVersion() : dMConfigBean.getAppVersionCode());
            LogUtil.iRelease(TAG, "jsApp的 cache存储路径 =" + zipModuleCacheUniquFilePath);
            PmDownloadTask pmDownloadTask = new PmDownloadTask(this.jsAppId, (long) appModulesBean.getModuleId(), appModulesBean.getMd5(), appModulesBean.getUrl(), zipModuleCacheUniquFilePath, appModulesBean.getModuleName());
            this.f17066a.add(pmDownloadTask);
            this.config.downloadModuleList.add(PmDownloadHelper.appModulesBean2InstallModuleFileDescribe(appModulesBean, pmDownloadTask.saveFilePath));
        }
    }

    /* renamed from: a */
    private final void m12606a(DMConfigBean dMConfigBean) {
        DMConfigBean.AppModulesBean sdkModule = dMConfigBean.getSdkModule();
        if (sdkModule == null) {
            LogUtil.eRelease(TAG, "sdkModule 为null");
            return;
        }
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        String zipModuleCacheUniquFilePath = PmFileHelper.getZipModuleCacheUniquFilePath(config.getApp(), sdkModule.getModuleName(), dMConfigBean.getSdkId(this.mina), dMConfigBean.getSdkVersionCode());
        LogUtil.iRelease(TAG, "jsSdk的 cache存储路径 =" + zipModuleCacheUniquFilePath);
        this.f17066a.add(new PmDownloadTask(dMConfigBean.getSdkId(this.mina), (long) sdkModule.getModuleId(), sdkModule.getMd5(), sdkModule.getUrl(), zipModuleCacheUniquFilePath, sdkModule.getModuleName()));
        InstallModuleFileDescribe installModuleFileDescribe = new InstallModuleFileDescribe(sdkModule);
        installModuleFileDescribe.setRelativePath(PmFileHelper.absolutePath2RelativePath(zipModuleCacheUniquFilePath));
        installModuleFileDescribe.setCacheAbsolutePath(zipModuleCacheUniquFilePath);
        this.config.downloadModuleList.add(installModuleFileDescribe);
    }

    /* renamed from: g */
    private final void m12614g() {
        this.f17068c = System.currentTimeMillis();
        DMMina dMMina = this.mina;
        Trace4DiUtil.tracePmDownloadInstallStart(dMMina != null ? dMMina.getMinaIndex() : -1);
    }

    public final void traceRemoteInstallEnd(int i, InterceptorConfig interceptorConfig, String str) {
        String str2;
        String str3;
        String errMsg;
        DMConfigBean.AppModulesBean sdkModule;
        InterceptorConfig interceptorConfig2 = interceptorConfig;
        Intrinsics.checkParameterIsNotNull(interceptorConfig2, "config");
        try {
            Iterator<PmDownloadTask> it = this.f17066a.iterator();
            long j = 0;
            long j2 = 0;
            while (true) {
                String str4 = null;
                if (!it.hasNext()) {
                    break;
                }
                PmDownloadTask next = it.next();
                String moduleName = next != null ? next.getModuleName() : null;
                DMConfigBean dMConfigBean = interceptorConfig2.httpDmConfigBean;
                if (!(dMConfigBean == null || (sdkModule = dMConfigBean.getSdkModule()) == null)) {
                    str4 = sdkModule.getModuleName();
                }
                if (Intrinsics.areEqual((Object) moduleName, (Object) str4)) {
                    j2 = next != null ? next.getCostTime() : 0;
                } else {
                    j = next != null ? next.getCostTime() : 0;
                }
            }
            String str5 = "";
            for (PmDownloadTask pmDownloadTask : this.f17066a) {
                if (!(pmDownloadTask == null || (errMsg = pmDownloadTask.getErrMsg()) == null)) {
                    Intrinsics.checkExpressionValueIsNotNull(errMsg, "str");
                    str5 = errMsg;
                }
            }
            DMMina dMMina = this.mina;
            int minaIndex = dMMina != null ? dMMina.getMinaIndex() : -1;
            long currentTimeMillis = System.currentTimeMillis() - this.f17068c;
            if (interceptorConfig2.isJsAppNeedDownload) {
                DMConfigBean dMConfigBean2 = interceptorConfig2.httpDmConfigBean;
                str2 = dMConfigBean2 != null ? dMConfigBean2.getAppVersionCode() : null;
            } else {
                str2 = "";
            }
            if (interceptorConfig2.isJsSdkNeedDownload) {
                DMConfigBean dMConfigBean3 = interceptorConfig2.httpDmConfigBean;
                str3 = dMConfigBean3 != null ? dMConfigBean3.getSdkVersionCode() : null;
            } else {
                str3 = "";
            }
            Trace4DiUtil.tracePmDownloadInstallEnd(minaIndex, i, j, j2, currentTimeMillis, str2, str3, str, str5);
        } catch (Exception e) {
            LogUtil.eRelease(TAG, "traceRemoteInstallEnd() 发生exception");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private final boolean m12608a(DMConfigBean.AppModulesBean appModulesBean) {
        return appModulesBean == null || TextUtils.isEmpty(appModulesBean.getKey());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadInterceptor{, App:'");
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

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/chain/DownloadInterceptor$Companion;", "", "()V", "TAG", "", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DownloadInterceptor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
