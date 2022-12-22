package com.didi.payment.pix.qrpayee.p139vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.PixQrCodeGenResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/payment/pix/qrpayee/vm/QRPayeePageVm;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "netModel", "Lcom/didi/payment/pix/net/PixNetModel;", "getNetModel", "()Lcom/didi/payment/pix/net/PixNetModel;", "setNetModel", "(Lcom/didi/payment/pix/net/PixNetModel;)V", "qrCodeData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/pix/net/response/PixQrCodeGenResp$QRCodePageData;", "getQrCodeData", "()Landroidx/lifecycle/MutableLiveData;", "setQrCodeData", "(Landroidx/lifecycle/MutableLiveData;)V", "loadData", "", "amount", "", "desc", "isModified", "", "imgWidth", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.qrpayee.vm.QRPayeePageVm */
/* compiled from: QRPayeePageVm.kt */
public final class QRPayeePageVm extends WBaseViewModel {

    /* renamed from: a */
    private PixNetModel f31178a;

    /* renamed from: b */
    private MutableLiveData<PixQrCodeGenResp.QRCodePageData> f31179b = new MutableLiveData<>();

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QRPayeePageVm(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f31178a = new PixNetModel(application);
    }

    public final PixNetModel getNetModel() {
        return this.f31178a;
    }

    public final void setNetModel(PixNetModel pixNetModel) {
        Intrinsics.checkNotNullParameter(pixNetModel, "<set-?>");
        this.f31178a = pixNetModel;
    }

    public final MutableLiveData<PixQrCodeGenResp.QRCodePageData> getQrCodeData() {
        return this.f31179b;
    }

    public final void setQrCodeData(MutableLiveData<PixQrCodeGenResp.QRCodePageData> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31179b = mutableLiveData;
    }

    public final void loadData(String str, String str2, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "amount");
        Intrinsics.checkNotNullParameter(str2, "desc");
        isLoading().setValue(true);
        this.f31178a.genQRCode(str, str2, z, i, new QRPayeePageVm$loadData$1(this));
    }
}
