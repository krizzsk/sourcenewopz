package com.didi.dimina.container.bundle;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.bundle.bean.BundleConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0005\u0017\u0018\u0019\u001a\u001bJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J.\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0010H&J&\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0012H&J0\u0010\u0013\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0015H&J(\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/dimina/container/bundle/BundleManagerStrategy;", "", "cancelDownloadOtherPackage", "", "dmMina", "Lcom/didi/dimina/container/DMMina;", "getTag", "", "install", "mina", "callback", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$InstallCallback;", "installSubpackage", "isPreload", "", "moduleName", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInfoCallback;", "isSubpackageInstalled", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInstallCallback;", "requireContent", "subPath", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$ReadFileCallBack;", "transform2AbsolutePath", "FileInfo", "InstallCallback", "ReadFileCallBack", "SubpackageInfoCallback", "SubpackageInstallCallback", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BundleManagerStrategy.kt */
public interface BundleManagerStrategy {

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/dimina/container/bundle/BundleManagerStrategy$InstallCallback;", "", "onOriginalPackageInstalled", "", "appVersion", "Lcom/didi/dimina/container/bundle/bean/BundleConfig;", "sdkVersion", "onUpdateMainPackageInstalled", "jsAppConfig", "jsSdkConfig", "onUpdateSubPackageInstalled", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BundleManagerStrategy.kt */
    public interface InstallCallback {
        void onOriginalPackageInstalled(BundleConfig bundleConfig, BundleConfig bundleConfig2);

        void onUpdateMainPackageInstalled(BundleConfig bundleConfig, BundleConfig bundleConfig2);

        void onUpdateSubPackageInstalled(BundleConfig bundleConfig, BundleConfig bundleConfig2);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/dimina/container/bundle/BundleManagerStrategy$ReadFileCallBack;", "", "onRead", "", "success", "", "data", "Lcom/didi/dimina/container/bundle/BundleManagerStrategy$FileInfo;", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BundleManagerStrategy.kt */
    public interface ReadFileCallBack {
        void onRead(boolean z, FileInfo fileInfo);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInstallCallback;", "", "callback", "", "isInstall", "", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BundleManagerStrategy.kt */
    public interface SubpackageInstallCallback {
        void callback(boolean z);
    }

    void cancelDownloadOtherPackage(DMMina dMMina);

    String getTag();

    void install(DMMina dMMina, InstallCallback installCallback);

    void installSubpackage(boolean z, DMMina dMMina, String str, SubpackageInfoCallback subpackageInfoCallback);

    void isSubpackageInstalled(DMMina dMMina, String str, SubpackageInstallCallback subpackageInstallCallback);

    void requireContent(DMMina dMMina, String str, String str2, ReadFileCallBack readFileCallBack);

    String transform2AbsolutePath(DMMina dMMina, String str, String str2);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInfoCallback;", "", "callback", "", "errCode", "", "moduleInfo", "Lcom/didi/dimina/container/bundle/bean/AppInfo$ModuleInfo;", "Companion", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BundleManagerStrategy.kt */
    public interface SubpackageInfoCallback {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int FAIL = -1;
        public static final int SUCC = 0;

        void callback(int i, AppInfo.ModuleInfo moduleInfo);

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/dimina/container/bundle/BundleManagerStrategy$SubpackageInfoCallback$Companion;", "", "()V", "FAIL", "", "SUCC", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
        /* compiled from: BundleManagerStrategy.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int FAIL = -1;
            public static final int SUCC = 0;

            private Companion() {
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, mo175978d2 = {"Lcom/didi/dimina/container/bundle/BundleManagerStrategy$FileInfo;", "Ljava/io/Serializable;", "content", "", "filePath", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BundleManagerStrategy.kt */
    public static final class FileInfo implements Serializable {
        private String content;
        private String filePath;

        public FileInfo() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public FileInfo(String str, String str2) {
            this.content = str;
            this.filePath = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FileInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getContent() {
            return this.content;
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final void setFilePath(String str) {
            this.filePath = str;
        }
    }
}
