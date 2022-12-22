package com.didi.dimina.container.secondparty.bundle.strategy;

import com.didi.dimina.container.secondparty.bundle.PmInstallManager;
import com.didi.dimina.container.secondparty.util.Trace4DiUtil;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "processCode", "", "onProcess"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ReleaseBundleMangerStrategy.kt */
final class ReleaseBundleMangerStrategy$install$processCallBack$1 implements PmInstallManager.InstallProcessCallBack {
    final /* synthetic */ int $minaIndex;

    ReleaseBundleMangerStrategy$install$processCallBack$1(int i) {
        this.$minaIndex = i;
    }

    public final void onProcess(int i) {
        if (i == 1) {
            Trace4DiUtil.trackMainPackageDownloadStart(this.$minaIndex);
        } else if (i == 5) {
            Trace4DiUtil.trackMainPackageDownloadRemoteStart(this.$minaIndex);
        }
    }
}
