package com.didiglobal.scan.view.fragment;

import android.content.Context;
import com.didi.dqr.ResultPoint;
import com.didi.zxing.barcodescanner.BarcodeCallback;
import com.didi.zxing.barcodescanner.BarcodeResult;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didiglobal.scan.GlobalScan;
import com.didiglobal.scan.net.ScanNetRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/scan/view/fragment/QrCodeScanFragment$initCapture$1", "Lcom/didi/zxing/barcodescanner/BarcodeCallback;", "barcodeResult", "", "result", "Lcom/didi/zxing/barcodescanner/BarcodeResult;", "possibleResultPoints", "resultPoints", "", "Lcom/didi/dqr/ResultPoint;", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: QrCodeScanFragment.kt */
public final class QrCodeScanFragment$initCapture$1 implements BarcodeCallback {
    final /* synthetic */ QrCodeScanFragment this$0;

    public void possibleResultPoints(List<? extends ResultPoint> list) {
        Intrinsics.checkParameterIsNotNull(list, "resultPoints");
    }

    QrCodeScanFragment$initCapture$1(QrCodeScanFragment qrCodeScanFragment) {
        this.this$0 = qrCodeScanFragment;
    }

    public void barcodeResult(BarcodeResult barcodeResult) {
        Intrinsics.checkParameterIsNotNull(barcodeResult, "result");
        this.this$0.f51389k = true;
        CaptureManager access$getCaptureManager$p = this.this$0.f51386h;
        if (access$getCaptureManager$p != null) {
            access$getCaptureManager$p.onPauseWhioutWait();
        }
        if (this.this$0.getContext() != null) {
            ScanNetRequest scanNetRequest = ScanNetRequest.INSTANCE;
            Context context = this.this$0.getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
            GlobalScan.ScanFrom from = this.this$0.getFrom();
            String text = barcodeResult.getText();
            Intrinsics.checkExpressionValueIsNotNull(text, "result.text");
            int userType = this.this$0.getUserType();
            QrCodeScanFragment qrCodeScanFragment = this.this$0;
            scanNetRequest.request(context, from, text, userType, qrCodeScanFragment, qrCodeScanFragment);
        }
    }
}
