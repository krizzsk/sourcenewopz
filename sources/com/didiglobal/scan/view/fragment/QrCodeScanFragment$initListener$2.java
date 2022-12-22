package com.didiglobal.scan.view.fragment;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: QrCodeScanFragment.kt */
final class QrCodeScanFragment$initListener$2 implements View.OnClickListener {
    final /* synthetic */ QrCodeScanFragment this$0;

    QrCodeScanFragment$initListener$2(QrCodeScanFragment qrCodeScanFragment) {
        this.this$0 = qrCodeScanFragment;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.this$0.f51388j) {
            DecoratedBarcodeView access$getBarCodeView$p = this.this$0.f51384f;
            if (access$getBarCodeView$p != null) {
                access$getBarCodeView$p.setTorchOff();
                return;
            }
            return;
        }
        DecoratedBarcodeView access$getBarCodeView$p2 = this.this$0.f51384f;
        if (access$getBarCodeView$p2 != null) {
            access$getBarCodeView$p2.setTorchOn();
        }
    }
}
