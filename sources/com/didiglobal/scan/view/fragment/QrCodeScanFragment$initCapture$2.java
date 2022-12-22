package com.didiglobal.scan.view.fragment;

import com.didi.zxing.barcodescanner.CameraPreview;
import com.didiglobal.scan.view.weight.ViewFinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0014\u0010\u0004\u001a\u00020\u00032\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didiglobal/scan/view/fragment/QrCodeScanFragment$initCapture$2", "Lcom/didi/zxing/barcodescanner/CameraPreview$StateListener;", "cameraClosed", "", "cameraError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "previewSized", "previewStarted", "previewStopped", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: QrCodeScanFragment.kt */
public final class QrCodeScanFragment$initCapture$2 implements CameraPreview.StateListener {
    final /* synthetic */ QrCodeScanFragment this$0;

    public void cameraClosed() {
    }

    public void previewSized() {
    }

    QrCodeScanFragment$initCapture$2(QrCodeScanFragment qrCodeScanFragment) {
        this.this$0 = qrCodeScanFragment;
    }

    public void previewStarted() {
        ViewFinder access$getViewFinderView$p = this.this$0.f51385g;
        if (access$getViewFinderView$p != null) {
            access$getViewFinderView$p.startAnimator();
        }
    }

    public void previewStopped() {
        ViewFinder access$getViewFinderView$p = this.this$0.f51385g;
        if (access$getViewFinderView$p != null) {
            access$getViewFinderView$p.stopAnimator();
        }
    }

    public void cameraError(Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "e");
        this.this$0.f51387i.postDelayed(new QrCodeScanFragment$initCapture$2$cameraError$1(this), 2000);
        exc.printStackTrace();
    }
}
