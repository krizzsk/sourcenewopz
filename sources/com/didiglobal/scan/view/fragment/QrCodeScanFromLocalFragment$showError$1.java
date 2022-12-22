package com.didiglobal.scan.view.fragment;

import androidx.fragment.app.FragmentManager;
import com.didiglobal.scan.view.ScanErrorDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: QrCodeScanFromLocalFragment.kt */
final class QrCodeScanFromLocalFragment$showError$1 implements Runnable {
    final /* synthetic */ String $error;
    final /* synthetic */ QrCodeScanFromLocalFragment this$0;

    QrCodeScanFromLocalFragment$showError$1(QrCodeScanFromLocalFragment qrCodeScanFromLocalFragment, String str) {
        this.this$0 = qrCodeScanFromLocalFragment;
        this.$error = str;
    }

    public final void run() {
        this.this$0.hideLoading();
        ScanErrorDialogFragment.Companion companion = ScanErrorDialogFragment.Companion;
        String str = this.$error;
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "childFragmentManager");
        companion.show(str, childFragmentManager, new ScanErrorDialogFragment.ClickCallBack() {
            public void onClick() {
            }
        });
    }
}
