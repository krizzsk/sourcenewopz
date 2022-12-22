package com.didiglobal.scan.view.fragment;

import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didiglobal.scan.delegate.IViewStyleDelegate;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/didiglobal/scan/view/fragment/QrCodeScanFragment$initListener$3", "Lcom/didi/zxing/barcodescanner/DecoratedBarcodeView$TorchListener;", "onTorchOff", "", "onTorchOn", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: QrCodeScanFragment.kt */
public final class QrCodeScanFragment$initListener$3 implements DecoratedBarcodeView.TorchListener {
    final /* synthetic */ QrCodeScanFragment this$0;

    QrCodeScanFragment$initListener$3(QrCodeScanFragment qrCodeScanFragment) {
        this.this$0 = qrCodeScanFragment;
    }

    public void onTorchOn() {
        IViewStyleDelegate viewStyleDelegate = this.this$0.getViewStyleDelegate();
        this.this$0.m36787a(viewStyleDelegate != null ? viewStyleDelegate.getTurnOnImg() : R.drawable.global_icon_scan_torch_on);
        this.this$0.f51388j = true;
    }

    public void onTorchOff() {
        this.this$0.m36787a((int) R.drawable.global_icon_scan_torch_off);
        this.this$0.f51388j = false;
    }
}
