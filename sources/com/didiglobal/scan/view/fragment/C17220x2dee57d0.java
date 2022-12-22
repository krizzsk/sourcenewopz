package com.didiglobal.scan.view.fragment;

import android.content.Context;
import com.didi.sdk.util.ResourcesHelper;
import com.didiglobal.scan.net.ScanNetRequest;
import com.didiglobal.scan.util.DecodeUtil;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, mo175978d2 = {"com/didiglobal/scan/view/fragment/QrCodeScanFromLocalFragment$initListeners$2$1$1", "Lcom/didiglobal/scan/util/DecodeUtil$DecodeCallback;", "onError", "", "onSuccess", "str", "", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.scan.view.fragment.QrCodeScanFromLocalFragment$initListeners$2$$special$$inlined$let$lambda$1 */
/* compiled from: QrCodeScanFromLocalFragment.kt */
public final class C17220x2dee57d0 implements DecodeUtil.DecodeCallback {
    final /* synthetic */ QrCodeScanFromLocalFragment$initListeners$2 this$0;

    C17220x2dee57d0(QrCodeScanFromLocalFragment$initListeners$2 qrCodeScanFromLocalFragment$initListeners$2) {
        this.this$0 = qrCodeScanFromLocalFragment$initListeners$2;
    }

    public void onSuccess(String str) {
        Intrinsics.checkParameterIsNotNull(str, "str");
        ScanNetRequest scanNetRequest = ScanNetRequest.INSTANCE;
        Context context = this.this$0.this$0.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        scanNetRequest.request(context, this.this$0.this$0.getFrom(), str, this.this$0.this$0.getUserType(), this.this$0.this$0, this.this$0.this$0);
    }

    public void onError() {
        QrCodeScanFromLocalFragment qrCodeScanFromLocalFragment = this.this$0.this$0;
        String string = ResourcesHelper.getString(this.this$0.this$0.getContext(), R.string.Finance_LightSpeedPC_Identification_failed_wKuB);
        Intrinsics.checkExpressionValueIsNotNull(string, "ResourcesHelper.getStrin…                        )");
        qrCodeScanFromLocalFragment.showError(string);
    }
}
