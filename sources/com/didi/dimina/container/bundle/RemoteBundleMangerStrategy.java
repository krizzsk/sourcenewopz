package com.didi.dimina.container.bundle;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.bundle.bean.BundleConfig;
import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LogUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J.\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0016H\u0016J0\u0010\u0017\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0019H\u0016J(\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/dimina/container/bundle/RemoteBundleMangerStrategy;", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy;", "remoteUrl", "", "(Ljava/lang/String;)V", "getRemoteUrl", "()Ljava/lang/String;", "cancelDownloadOtherPackage", "", "dmMina", "Lcom/didi/dimina/container/DMMina;", "getTag", "install", "mina", "callback", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$InstallCallback;", "installSubpackage", "isPreload", "", "moduleName", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInfoCallback;", "isSubpackageInstalled", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInstallCallback;", "requireContent", "subPath", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$ReadFileCallBack;", "transform2AbsolutePath", "Companion", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RemoteBundleMangerStrategy.kt */
public final class RemoteBundleMangerStrategy implements BundleManagerStrategy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "RemotePckMangerStrategy";

    /* renamed from: a */
    private final String f16785a;

    public void cancelDownloadOtherPackage(DMMina dMMina) {
    }

    public String getTag() {
        return "remote";
    }

    public RemoteBundleMangerStrategy(String str) {
        Intrinsics.checkParameterIsNotNull(str, "remoteUrl");
        this.f16785a = str;
    }

    public final String getRemoteUrl() {
        return this.f16785a;
    }

    public void install(DMMina dMMina, BundleManagerStrategy.InstallCallback installCallback) {
        if (installCallback != null) {
            installCallback.onOriginalPackageInstalled(BundleConfig.NO_VERSION_BUNDLE_CONFIG, BundleConfig.NO_VERSION_BUNDLE_CONFIG);
        }
        if (installCallback != null) {
            installCallback.onUpdateMainPackageInstalled(BundleConfig.NO_VERSION_BUNDLE_CONFIG, BundleConfig.NO_VERSION_BUNDLE_CONFIG);
        }
        if (installCallback != null) {
            installCallback.onUpdateSubPackageInstalled(BundleConfig.NO_VERSION_BUNDLE_CONFIG, BundleConfig.NO_VERSION_BUNDLE_CONFIG);
        }
    }

    public void installSubpackage(boolean z, DMMina dMMina, String str, BundleManagerStrategy.SubpackageInfoCallback subpackageInfoCallback) {
        if (subpackageInfoCallback != null) {
            subpackageInfoCallback.callback(0, new AppInfo.ModuleInfo());
        }
    }

    public void isSubpackageInstalled(DMMina dMMina, String str, BundleManagerStrategy.SubpackageInstallCallback subpackageInstallCallback) {
        if (subpackageInstallCallback != null) {
            subpackageInstallCallback.callback(true);
        }
    }

    public void requireContent(DMMina dMMina, String str, String str2, BundleManagerStrategy.ReadFileCallBack readFileCallBack) {
        String str3;
        String str4;
        String str5 = this.f16785a;
        if (!StringsKt.endsWith$default(str5, "/", false, 2, (Object) null)) {
            str5 = str5 + "/";
        }
        if (str2 == null || !StringsKt.startsWith$default(str2, "/", false, 2, (Object) null)) {
            str3 = str2;
        } else {
            str3 = str2.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(str3, "(this as java.lang.String).substring(startIndex)");
        }
        if (Constant.isFromSDK(str3)) {
            str4 = str5 + str3;
        } else {
            if (str != null) {
                if (!(str.length() == 0)) {
                    str4 = str5 + str + File.separator + str3;
                }
            }
            str4 = str5 + str3;
        }
        LogUtil.iRelease(TAG, "requireContent \t moduleName=" + str + "\t subPath=" + str2 + "\t result=" + str4);
        if (StringsKt.startsWith$default(str4, "http", false, 2, (Object) null)) {
            DMThreadPool.DmThreadPoolExecutor executor = DMThreadPool.getExecutor();
            if (executor != null) {
                executor.execute(new RemoteBundleMangerStrategy$requireContent$2(str4, readFileCallBack));
                return;
            }
            return;
        }
        String readFile2String = FileUtil.readFile2String(new File(str4));
        if (TextUtils.isEmpty(readFile2String)) {
            if (readFileCallBack != null) {
                readFileCallBack.onRead(false, new BundleManagerStrategy.FileInfo(readFile2String, str4));
            }
        } else if (readFileCallBack != null) {
            readFileCallBack.onRead(true, new BundleManagerStrategy.FileInfo(readFile2String, str4));
        }
    }

    public String transform2AbsolutePath(DMMina dMMina, String str, String str2) {
        String str3;
        String str4 = this.f16785a;
        boolean z = false;
        if (!StringsKt.endsWith$default(str4, "/", false, 2, (Object) null)) {
            str4 = str4 + "/";
        }
        String str5 = str2 != null ? str2 : "";
        if (str2 == null) {
            Intrinsics.throwNpe();
        }
        if (StringsKt.startsWith$default(str2, "/", false, 2, (Object) null)) {
            str5 = str2.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(str5, "(this as java.lang.String).substring(startIndex)");
        }
        if (Constant.isFromSDK(str5)) {
            str3 = str4 + str5;
        } else {
            if (str != null) {
                if (str.length() == 0) {
                    z = true;
                }
                if (!z) {
                    str3 = str4 + str + File.separator + str5;
                }
            }
            str3 = str4 + str5;
        }
        LogUtil.iRelease(TAG, "transform2AbsolutePath \t moduleName=" + str + "\t subPath=" + str2 + "\t result=" + str3);
        return str3;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/dimina/container/bundle/RemoteBundleMangerStrategy$Companion;", "", "()V", "TAG", "", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RemoteBundleMangerStrategy.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
