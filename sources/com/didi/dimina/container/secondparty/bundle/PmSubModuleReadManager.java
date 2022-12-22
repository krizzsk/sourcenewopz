package com.didi.dimina.container.secondparty.bundle;

import android.content.Context;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.secondparty.bundle.PmConstant;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadHelper;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadManager;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadTask;
import com.didi.dimina.container.secondparty.bundle.http.PmHttpUtil;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.dimina.container.secondparty.util.DebugExceptionUtil;
import com.didi.dimina.container.secondparty.util.Trace4DiUtil;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 52\u00020\u0001:\u0003567B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"H\u0002J:\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u0017H\u0002J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J8\u0010-\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u0017J$\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u001b2\b\b\u0002\u00100\u001a\u00020\u001b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u00020\u0019J&\u00103\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u001b2\b\b\u0002\u00101\u001a\u00020\u0004H\u0007J\u0006\u00104\u001a\u00020\u0019R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager;", "", "()V", "filePathInFiles", "", "getFilePathInFiles", "()Ljava/lang/String;", "key2UrlsRequestUrl", "getKey2UrlsRequestUrl", "mCbConfig", "Lcom/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager$SubModuleInstallCbConfig;", "mDmMina", "Lcom/didi/dimina/container/DMMina;", "mDownloadStartTime", "", "mFinalFileName", "mHttpRequestStartTime", "mIsPreload", "", "mJsId", "mJsVersion", "mModuleName", "mSubInstallCb", "Lcom/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager$SubModuleInstallCallBack;", "dealCallBack", "", "errorCode", "", "content", "throwable", "", "getKey2UrlRequestParam", "", "appModule", "Lcom/didi/dimina/container/secondparty/bundle/bean/DMConfigBean$AppModulesBean;", "handleKey2UrlSuccThenOperated", "url", "init", "dmMina", "isPreload", "jsAppId", "moduleName", "finalFileName", "callBack", "keyReplaceUrlThenOperated", "load", "traceSubPackageDownloadEnd", "result", "errCode", "errMsg", "traceSubPackageDownloadStart", "traceSubPackageHttpRequestEnd", "traceSubPackageHttpRequestStart", "Companion", "SubModuleInstallCallBack", "SubModuleInstallCbConfig", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PmSubModuleReadManager.kt */
public final class PmSubModuleReadManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "Dimina-PM PmSubModuleReadManager";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f17052a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f17053b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f17054c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f17055d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SubModuleInstallCallBack f17056e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final SubModuleInstallCbConfig f17057f = new SubModuleInstallCbConfig();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f17058g;

    /* renamed from: h */
    private DMMina f17059h;

    /* renamed from: i */
    private long f17060i;

    /* renamed from: j */
    private long f17061j;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager$SubModuleInstallCallBack;", "", "onModuleInstall", "", "errorCode", "", "installCbConfig", "Lcom/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager$SubModuleInstallCbConfig;", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: PmSubModuleReadManager.kt */
    public interface SubModuleInstallCallBack {
        void onModuleInstall(int i, SubModuleInstallCbConfig subModuleInstallCbConfig);
    }

    public final void traceSubPackageHttpRequestEnd() {
        traceSubPackageHttpRequestEnd$default(this, (String) null, 0, (String) null, 7, (Object) null);
    }

    public final void traceSubPackageHttpRequestEnd(String str) {
        traceSubPackageHttpRequestEnd$default(this, str, 0, (String) null, 6, (Object) null);
    }

    public final void traceSubPackageHttpRequestEnd(String str, int i) {
        traceSubPackageHttpRequestEnd$default(this, str, i, (String) null, 4, (Object) null);
    }

    public final void load(boolean z, DMMina dMMina, String str, String str2, String str3, SubModuleInstallCallBack subModuleInstallCallBack) {
        Intrinsics.checkParameterIsNotNull(dMMina, "dmMina");
        Intrinsics.checkParameterIsNotNull(str, "jsAppId");
        Intrinsics.checkParameterIsNotNull(str2, "moduleName");
        Intrinsics.checkParameterIsNotNull(subModuleInstallCallBack, "callBack");
        DebugExceptionUtil.dottingPmTime("jsAppId=" + str + "\tsubModule=" + str2 + "finalFileName=" + str3, "子模块加载 开始");
        m12575a(dMMina, z, str, str2, str3, subModuleInstallCallBack);
        DMThreadPool.DmThreadPoolExecutor executor = DMThreadPool.getExecutor();
        if (executor == null) {
            Intrinsics.throwNpe();
        }
        executor.execute(new PmSubModuleReadManager$load$1(this, dMMina, str2));
    }

    /* renamed from: a */
    private final void m12575a(DMMina dMMina, boolean z, String str, String str2, String str3, SubModuleInstallCallBack subModuleInstallCallBack) {
        this.f17059h = dMMina;
        this.f17052a = str;
        this.f17053b = str2;
        this.f17054c = str3;
        this.f17056e = subModuleInstallCallBack;
        this.f17058g = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12577a(DMConfigBean.AppModulesBean appModulesBean) {
        traceSubPackageHttpRequestStart();
        PmHttpUtil.get(m12579b(), Companion.getKey2UrlRequestHeaders(appModulesBean), m12580b(appModulesBean), new PmSubModuleReadManager$keyReplaceUrlThenOperated$1(this, appModulesBean));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12578a(String str, DMConfigBean.AppModulesBean appModulesBean) {
        this.f17057f.setUrl(str);
        appModulesBean.setUrl(str);
        PmDownloadTask appModulesBean2PmDownloadTask = PmDownloadHelper.appModulesBean2PmDownloadTask(appModulesBean, this.f17052a, (String) null);
        Intrinsics.checkExpressionValueIsNotNull(appModulesBean2PmDownloadTask, "appDownloadTask");
        appModulesBean2PmDownloadTask.setPreload(this.f17058g);
        List arrayList = new ArrayList();
        arrayList.add(appModulesBean2PmDownloadTask);
        InstallModuleFileDescribe appModulesBean2InstallModuleFileDescribe = PmDownloadHelper.appModulesBean2InstallModuleFileDescribe(appModulesBean, appModulesBean2PmDownloadTask.saveFilePath);
        List arrayList2 = new ArrayList();
        Intrinsics.checkExpressionValueIsNotNull(appModulesBean2InstallModuleFileDescribe, "appInstallModule");
        arrayList2.add(appModulesBean2InstallModuleFileDescribe);
        LogUtil.iRelease(TAG, "子module的下载任务是 = " + arrayList);
        traceSubPackageDownloadStart();
        new PmDownloadManager().download(arrayList, new PmSubModuleReadManager$handleKey2UrlSuccThenOperated$1(this, arrayList2, arrayList, appModulesBean2PmDownloadTask));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final String m12573a() {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        String filesModuleFilePath = PmFileHelper.getFilesModuleFilePath((Context) config.getApp(), this.f17052a, this.f17055d, this.f17053b, this.f17054c);
        Intrinsics.checkExpressionValueIsNotNull(filesModuleFilePath, "PmFileHelper.getFilesMod…duleName, mFinalFileName)");
        return filesModuleFilePath;
    }

    /* renamed from: b */
    private final String m12579b() {
        return PmHttpUtil.getBaseUrl(this.f17059h) + PmConstant.HTTP.KEY_2_URL;
    }

    /* renamed from: a */
    static /* synthetic */ void m12576a(PmSubModuleReadManager pmSubModuleReadManager, int i, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            th = null;
        }
        pmSubModuleReadManager.m12574a(i, str, th);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12574a(int i, String str, Throwable th) {
        if (this.f17056e != null) {
            this.f17057f.content = str;
            this.f17057f.moduleName = this.f17053b;
            this.f17057f.finalFileName = this.f17054c;
            this.f17057f.jsVersion = this.f17055d;
            this.f17057f.throwable = th;
            SubModuleInstallCallBack subModuleInstallCallBack = this.f17056e;
            if (subModuleInstallCallBack == null) {
                Intrinsics.throwNpe();
            }
            subModuleInstallCallBack.onModuleInstall(i, this.f17057f);
        }
    }

    public final void traceSubPackageHttpRequestStart() {
        this.f17060i = System.currentTimeMillis();
        DMMina dMMina = this.f17059h;
        Trace4DiUtil.tracePmSubPackageRequestStart(dMMina != null ? dMMina.getMinaIndex() : -1);
    }

    public static /* synthetic */ void traceSubPackageHttpRequestEnd$default(PmSubModuleReadManager pmSubModuleReadManager, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "-1";
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        pmSubModuleReadManager.traceSubPackageHttpRequestEnd(str, i, str2);
    }

    public final void traceSubPackageHttpRequestEnd(String str, int i, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "result");
        Intrinsics.checkParameterIsNotNull(str2, DMWebSocketListener.KEY_ERR_MSG);
        DMMina dMMina = this.f17059h;
        int minaIndex = dMMina != null ? dMMina.getMinaIndex() : -1;
        String str3 = this.f17053b;
        Trace4DiUtil.tracePmSubPackageRequestEnd(minaIndex, str, System.currentTimeMillis() - this.f17060i, str3, "" + i, str2);
    }

    public final void traceSubPackageDownloadStart() {
        this.f17061j = System.currentTimeMillis();
        DMMina dMMina = this.f17059h;
        Trace4DiUtil.tracePmSubPackageDownloadStart(dMMina != null ? dMMina.getMinaIndex() : -1);
    }

    public static /* synthetic */ void traceSubPackageDownloadEnd$default(PmSubModuleReadManager pmSubModuleReadManager, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            str = "";
        }
        pmSubModuleReadManager.traceSubPackageDownloadEnd(i, i2, str);
    }

    public final void traceSubPackageDownloadEnd(int i, int i2, String str) {
        DMMina dMMina = this.f17059h;
        int minaIndex = dMMina != null ? dMMina.getMinaIndex() : -1;
        Trace4DiUtil.tracePmSubPackageDownloadEnd(minaIndex, "" + i, System.currentTimeMillis() - this.f17061j, this.f17053b, "" + i2, str);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager$SubModuleInstallCbConfig;", "", "()V", "content", "", "filePath", "finalFileName", "jsVersion", "moduleName", "throwable", "", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "toString", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: PmSubModuleReadManager.kt */
    public static final class SubModuleInstallCbConfig {
        public String content;
        public String filePath;
        public String finalFileName;
        public String jsVersion;
        public String moduleName;
        public Throwable throwable;
        private String url;

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public String toString() {
            return "SubModuleInstallCbConfig{url='" + this.url + '\'' + " content.length=='" + CollectionsUtil.getSize(this.content) + '\'' + ", moduleName='" + this.moduleName + '\'' + ", finalFileName='" + this.finalFileName + '\'' + ", filePath='" + this.filePath + '\'' + ", jsVersion='" + this.jsVersion + '\'' + '}';
        }
    }

    /* renamed from: b */
    private final Map<String, Object> m12580b(DMConfigBean.AppModulesBean appModulesBean) {
        Map<String, Object> hashMap = new HashMap<>();
        String key = appModulesBean.getKey();
        Intrinsics.checkExpressionValueIsNotNull(key, "appModule.key");
        hashMap.put("keys", key);
        String channel = appModulesBean.getChannel();
        Intrinsics.checkExpressionValueIsNotNull(channel, "appModule.channel");
        hashMap.put("channel", channel);
        return hashMap;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager$Companion;", "", "()V", "TAG", "", "getKey2UrlRequestHeaders", "", "appModule", "Lcom/didi/dimina/container/secondparty/bundle/bean/DMConfigBean$AppModulesBean;", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: PmSubModuleReadManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Map<String, String> getKey2UrlRequestHeaders(DMConfigBean.AppModulesBean appModulesBean) {
            return new HashMap<>();
        }
    }
}
