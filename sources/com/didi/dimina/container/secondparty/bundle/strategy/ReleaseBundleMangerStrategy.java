package com.didi.dimina.container.secondparty.bundle.strategy;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.secondparty.bundle.DiminaHelper;
import com.didi.dimina.container.secondparty.bundle.PmInstallManager;
import com.didi.dimina.container.secondparty.bundle.PmSubModuleHelper;
import com.didi.dimina.container.secondparty.bundle.PmSubModuleReadManager;
import com.didi.dimina.container.secondparty.bundle.bean.PreloadTask;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadManager;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.util.Trace4DiUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J.\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u001aH\u0016J0\u0010\u001b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u001cH\u0016J8\u0010\u001d\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u001cH\u0002J(\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006!"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/strategy/ReleaseBundleMangerStrategy;", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy;", "()V", "assetPath", "", "(Ljava/lang/String;)V", "<set-?>", "getAssetPath", "()Ljava/lang/String;", "cancelDownloadOtherPackage", "", "dmMina", "Lcom/didi/dimina/container/DMMina;", "getReleaseTransformUrl", "mina", "moduleName", "subPath", "getTag", "install", "callback", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$InstallCallback;", "installSubpackage", "isPreload", "", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInfoCallback;", "isSubpackageInstalled", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInstallCallback;", "requireContent", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$ReadFileCallBack;", "requireContentRelease", "jsAppId", "transform2AbsolutePath", "Companion", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ReleaseBundleMangerStrategy.kt */
public final class ReleaseBundleMangerStrategy implements BundleManagerStrategy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "Dimina-PM DmPckMangerStrategy";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Map<String, CopyOnWriteArrayList<BundleManagerStrategy.SubpackageInfoCallback>> f17095b = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final ConcurrentLinkedQueue<PreloadTask> f17096c = new ConcurrentLinkedQueue<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static volatile Map<String, InstallTask> f17097d = new ConcurrentHashMap();

    /* renamed from: a */
    private String f17098a;

    public String getTag() {
        return "release";
    }

    public final String getAssetPath() {
        return this.f17098a;
    }

    public ReleaseBundleMangerStrategy() {
    }

    public ReleaseBundleMangerStrategy(String str) {
        this.f17098a = str;
    }

    public void cancelDownloadOtherPackage(DMMina dMMina) {
        LogUtil.iRelease(TAG, "调用 cancelDownloadOtherModule");
        if (dMMina == null) {
            Intrinsics.throwNpe();
        }
        PmDownloadManager.cancelPreDownloadTask(DiminaHelper.getJsAppId(dMMina));
    }

    public void install(DMMina dMMina, BundleManagerStrategy.InstallCallback installCallback) {
        if (!(dMMina == null || dMMina.getConfig() == null)) {
            DMConfig config = dMMina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config, "mina.config");
            if (config.getLaunchConfig() != null) {
                String jsSdkId = DiminaHelper.getJsSdkId(dMMina);
                String jsAppId = DiminaHelper.getJsAppId(dMMina);
                long currentTimeMillis = System.currentTimeMillis();
                LogUtil.eRelease(TAG, "-------------------------------- start install----------------------------------jsApp:" + jsAppId + "\t jsSdk:" + jsSdkId);
                if (f17097d.containsKey(jsAppId)) {
                    LogUtil.wRelease(TAG, jsAppId + "\t 当前install任务 已经在执行了， 所以不必重复执行");
                    InstallTask installTask = f17097d.get(jsAppId);
                    if (installTask != null) {
                        installTask.recordCallback(installCallback);
                        return;
                    }
                    return;
                }
                InstallTask installTask2 = new InstallTask();
                installTask2.recordCallback(installCallback);
                f17097d.put(jsAppId, installTask2);
                int minaIndex = dMMina.getMinaIndex();
                Trace4DiUtil.tracePmInstallStart("2", jsAppId, jsSdkId);
                PmInstallManager.install(dMMina, jsSdkId, jsAppId, new ReleaseBundleMangerStrategy$install$processCallBack$1(minaIndex), new ReleaseBundleMangerStrategy$install$1(currentTimeMillis, jsAppId, dMMina, minaIndex));
                return;
            }
        }
        LogUtil.eRelease(TAG, "执行 install 任务，但是相关配置 为null");
    }

    public void installSubpackage(boolean z, DMMina dMMina, String str, BundleManagerStrategy.SubpackageInfoCallback subpackageInfoCallback) {
        String str2 = str;
        BundleManagerStrategy.SubpackageInfoCallback subpackageInfoCallback2 = subpackageInfoCallback;
        if (dMMina == null) {
            Intrinsics.throwNpe();
        }
        String jsAppId = DiminaHelper.getJsAppId(dMMina);
        String str3 = jsAppId + IOUtils.DIR_SEPARATOR_UNIX + str;
        if (f17095b.containsKey(str3)) {
            LogUtil.wRelease(TAG, "当前分包正在下载 -> " + str3);
            List list = f17095b.get(str3);
            if (list != null) {
                list.add(subpackageInfoCallback2);
                return;
            }
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(subpackageInfoCallback2);
        f17095b.put(str3, copyOnWriteArrayList);
        Trace4DiUtil.trackSubPackageDownloadStart(dMMina.getMinaIndex(), str);
        PmSubModuleReadManager pmSubModuleReadManager = new PmSubModuleReadManager();
        if (str2 == null) {
            Intrinsics.throwNpe();
        }
        pmSubModuleReadManager.load(z, dMMina, jsAppId, str, (String) null, new ReleaseBundleMangerStrategy$installSubpackage$1(this, str, str3, dMMina, z, subpackageInfoCallback));
    }

    public void isSubpackageInstalled(DMMina dMMina, String str, BundleManagerStrategy.SubpackageInstallCallback subpackageInstallCallback) {
        if (dMMina == null) {
            Intrinsics.throwNpe();
        }
        String jsAppId = DiminaHelper.getJsAppId(dMMina);
        PmSubModuleHelper.isModuleInstalled(dMMina, jsAppId, str, new ReleaseBundleMangerStrategy$isSubpackageInstalled$1(jsAppId, str, subpackageInstallCallback));
    }

    public void requireContent(DMMina dMMina, String str, String str2, BundleManagerStrategy.ReadFileCallBack readFileCallBack) {
        LogUtil.iRelease(TAG, "requireContent()->\tmoduleName=" + str + "\tsubPath=" + str2);
        if (!TextUtils.isEmpty(str2)) {
            if (dMMina == null) {
                Intrinsics.throwNpe();
            }
            m12658a(dMMina, DiminaHelper.getJsAppId(dMMina), str, str2, readFileCallBack);
        }
    }

    public String transform2AbsolutePath(DMMina dMMina, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        String a = m12657a(dMMina, str, str2);
        LogUtil.iRelease(TAG, "\t moduleName=" + str + "\t subPath=" + str2 + "\t resultUrl=" + a);
        return a;
    }

    /* renamed from: a */
    private final String m12657a(DMMina dMMina, String str, String str2) {
        if (dMMina == null) {
            Intrinsics.throwNpe();
        }
        String jsAppId = DiminaHelper.getJsAppId(dMMina);
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        String filesModuleFilePath = PmFileHelper.getFilesModuleFilePath(dMMina, (Context) config.getApp(), jsAppId, str, str2);
        Intrinsics.checkExpressionValueIsNotNull(filesModuleFilePath, "PmFileHelper.getFilesMod…pId, moduleName, subPath)");
        return filesModuleFilePath;
    }

    /* renamed from: a */
    private final void m12658a(DMMina dMMina, String str, String str2, String str3, BundleManagerStrategy.ReadFileCallBack readFileCallBack) {
        PmSubModuleReadManager pmSubModuleReadManager = new PmSubModuleReadManager();
        if (dMMina == null) {
            Intrinsics.throwNpe();
        }
        if (str2 == null) {
            Intrinsics.throwNpe();
        }
        pmSubModuleReadManager.load(false, dMMina, str, str2, str3, new ReleaseBundleMangerStrategy$requireContentRelease$1(str, str2, str3, readFileCallBack));
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/strategy/ReleaseBundleMangerStrategy$Companion;", "", "()V", "TAG", "", "mPmInstallTaskMap", "", "Lcom/didi/dimina/container/secondparty/bundle/strategy/InstallTask;", "getMPmInstallTaskMap", "()Ljava/util/Map;", "setMPmInstallTaskMap", "(Ljava/util/Map;)V", "mPreloadTaskQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/didi/dimina/container/secondparty/bundle/bean/PreloadTask;", "getMPreloadTaskQueue", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "mSubPackageCallbackMap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInfoCallback;", "getMSubPackageCallbackMap", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ReleaseBundleMangerStrategy.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, CopyOnWriteArrayList<BundleManagerStrategy.SubpackageInfoCallback>> getMSubPackageCallbackMap() {
            return ReleaseBundleMangerStrategy.f17095b;
        }

        public final ConcurrentLinkedQueue<PreloadTask> getMPreloadTaskQueue() {
            return ReleaseBundleMangerStrategy.f17096c;
        }

        public final Map<String, InstallTask> getMPmInstallTaskMap() {
            return ReleaseBundleMangerStrategy.f17097d;
        }

        public final void setMPmInstallTaskMap(Map<String, InstallTask> map) {
            Intrinsics.checkParameterIsNotNull(map, "<set-?>");
            ReleaseBundleMangerStrategy.f17097d = map;
        }
    }
}
