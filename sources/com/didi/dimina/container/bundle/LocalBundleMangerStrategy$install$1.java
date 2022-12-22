package com.didi.dimina.container.bundle;

import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.BundleConfig;
import com.didi.dimina.container.mina.ITask;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LocalDevUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, mo175978d2 = {"com/didi/dimina/container/bundle/LocalBundleMangerStrategy$install$1", "Lcom/didi/dimina/container/mina/ITask;", "", "onComplete", "", "result", "(Ljava/lang/Boolean;)V", "runTaskInBackground", "()Ljava/lang/Boolean;", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LocalBundleMangerStrategy.kt */
public final class LocalBundleMangerStrategy$install$1 implements ITask<Boolean> {
    final /* synthetic */ BundleManagerStrategy.InstallCallback $callback;
    final /* synthetic */ LocalBundleMangerStrategy this$0;

    LocalBundleMangerStrategy$install$1(LocalBundleMangerStrategy localBundleMangerStrategy, BundleManagerStrategy.InstallCallback installCallback) {
        this.this$0 = localBundleMangerStrategy;
        this.$callback = installCallback;
    }

    public Boolean runTaskInBackground() {
        try {
            FileUtil.delete(this.this$0.f16784b);
            FileUtil.mkdirs(this.this$0.f16784b);
            File file = new File(this.this$0.f16784b);
            Dimina.Config config = Dimina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
            LocalDevUtil.copyAssetsFile(config.getApp(), this.this$0.f16783a, this.this$0.f16784b);
            File file2 = new File(this.this$0.f16784b + File.separator + ((String) CollectionsKt.last(StringsKt.split$default((CharSequence) this.this$0.f16783a, new String[]{"/"}, false, 0, 6, (Object) null))));
            LocalDevUtil.unzipFile(file2, new File(file.toString()));
            if (file2.exists()) {
                LocalDevUtil.deleteFile(file2);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onComplete(Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            BundleManagerStrategy.InstallCallback installCallback = this.$callback;
            if (installCallback != null) {
                installCallback.onOriginalPackageInstalled(BundleConfig.NO_VERSION_BUNDLE_CONFIG, BundleConfig.NO_VERSION_BUNDLE_CONFIG);
            }
            BundleManagerStrategy.InstallCallback installCallback2 = this.$callback;
            if (installCallback2 != null) {
                installCallback2.onUpdateMainPackageInstalled(BundleConfig.NO_VERSION_BUNDLE_CONFIG, BundleConfig.NO_VERSION_BUNDLE_CONFIG);
            }
            BundleManagerStrategy.InstallCallback installCallback3 = this.$callback;
            if (installCallback3 != null) {
                installCallback3.onUpdateSubPackageInstalled(BundleConfig.NO_VERSION_BUNDLE_CONFIG, BundleConfig.NO_VERSION_BUNDLE_CONFIG);
                return;
            }
            return;
        }
        BundleManagerStrategy.InstallCallback installCallback4 = this.$callback;
        if (installCallback4 != null) {
            installCallback4.onOriginalPackageInstalled((BundleConfig) null, (BundleConfig) null);
        }
        BundleManagerStrategy.InstallCallback installCallback5 = this.$callback;
        if (installCallback5 != null) {
            installCallback5.onUpdateMainPackageInstalled((BundleConfig) null, (BundleConfig) null);
        }
        BundleManagerStrategy.InstallCallback installCallback6 = this.$callback;
        if (installCallback6 != null) {
            installCallback6.onUpdateSubPackageInstalled((BundleConfig) null, (BundleConfig) null);
        }
    }
}
