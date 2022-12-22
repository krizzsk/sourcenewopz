package com.didi.dimina.container.bundle;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.mina.DMSingleTaskExecutor;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LogUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J.\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0014\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0016J0\u0010\u0016\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0018H\u0016J(\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/dimina/container/bundle/LocalBundleMangerStrategy;", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy;", "assetFilePath", "", "localFilePath", "(Ljava/lang/String;Ljava/lang/String;)V", "cancelDownloadOtherPackage", "", "dmMina", "Lcom/didi/dimina/container/DMMina;", "getTag", "install", "mina", "callback", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$InstallCallback;", "installSubpackage", "isPreload", "", "moduleName", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInfoCallback;", "isSubpackageInstalled", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInstallCallback;", "requireContent", "subPath", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$ReadFileCallBack;", "transform2AbsolutePath", "Companion", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LocalBundleMangerStrategy.kt */
public final class LocalBundleMangerStrategy implements BundleManagerStrategy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "LocalPckMangerStrategy";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f16783a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f16784b;

    public void cancelDownloadOtherPackage(DMMina dMMina) {
    }

    public String getTag() {
        return "local";
    }

    public LocalBundleMangerStrategy(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "assetFilePath");
        Intrinsics.checkParameterIsNotNull(str2, "localFilePath");
        this.f16783a = str;
        this.f16784b = str2;
    }

    public void install(DMMina dMMina, BundleManagerStrategy.InstallCallback installCallback) {
        DMSingleTaskExecutor.INSTANCE.execute(new LocalBundleMangerStrategy$install$1(this, installCallback));
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
        String str5 = this.f16784b;
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
        String str4 = this.f16784b;
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

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/dimina/container/bundle/LocalBundleMangerStrategy$Companion;", "", "()V", "TAG", "", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: LocalBundleMangerStrategy.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
