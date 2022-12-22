package com.didi.payment.pix.refund.p140vm;

import android.app.Application;
import android.os.CountDownTimer;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.PixRefundExtrasResp;
import com.didi.payment.pix.net.response.PixRefundResultResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$J\b\u0010&\u001a\u00020 H\u0016J\u000e\u0010&\u001a\u00020 2\u0006\u0010#\u001a\u00020$J\u000e\u0010'\u001a\u00020 2\u0006\u0010#\u001a\u00020$J\u0016\u0010(\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020 R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000e¨\u0006,"}, mo175978d2 = {"Lcom/didi/payment/pix/refund/vm/PixOrderRefundDetailVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "TIME_INTERVAL", "", "TIME_TOTAL", "extrasRefundOptions", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$RefundOptions;", "getExtrasRefundOptions", "()Landroidx/lifecycle/MutableLiveData;", "setExtrasRefundOptions", "(Landroidx/lifecycle/MutableLiveData;)V", "mCountDownTimer", "Landroid/os/CountDownTimer;", "getMCountDownTimer", "()Landroid/os/CountDownTimer;", "setMCountDownTimer", "(Landroid/os/CountDownTimer;)V", "pixNetModel", "Lcom/didi/payment/pix/net/PixNetModel;", "getPixNetModel", "()Lcom/didi/payment/pix/net/PixNetModel;", "setPixNetModel", "(Lcom/didi/payment/pix/net/PixNetModel;)V", "refundDetails", "Lcom/didi/payment/pix/net/response/PixRefundResultResp$OrderRefundDetails;", "getRefundDetails", "setRefundDetails", "doRefund", "", "refundAmount", "", "orderId", "", "reasonId", "loadData", "loopQueryOrderDetail", "queryOrderDetail", "isLast", "", "stopCountTimer", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.refund.vm.PixOrderRefundDetailVM */
/* compiled from: PixOrderRefundDetailVM.kt */
public final class PixOrderRefundDetailVM extends WBaseViewModel {

    /* renamed from: a */
    private final long f31204a = 60000;

    /* renamed from: b */
    private final long f31205b = 1000;

    /* renamed from: c */
    private PixNetModel f31206c;

    /* renamed from: d */
    private MutableLiveData<PixRefundExtrasResp.RefundOptions> f31207d;

    /* renamed from: e */
    private MutableLiveData<PixRefundResultResp.OrderRefundDetails> f31208e;

    /* renamed from: f */
    private CountDownTimer f31209f;

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixOrderRefundDetailVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f31206c = new PixNetModel(application);
        this.f31207d = new MutableLiveData<>();
        this.f31208e = new MutableLiveData<>();
    }

    public final PixNetModel getPixNetModel() {
        return this.f31206c;
    }

    public final void setPixNetModel(PixNetModel pixNetModel) {
        Intrinsics.checkNotNullParameter(pixNetModel, "<set-?>");
        this.f31206c = pixNetModel;
    }

    public final MutableLiveData<PixRefundExtrasResp.RefundOptions> getExtrasRefundOptions() {
        return this.f31207d;
    }

    public final void setExtrasRefundOptions(MutableLiveData<PixRefundExtrasResp.RefundOptions> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31207d = mutableLiveData;
    }

    public final MutableLiveData<PixRefundResultResp.OrderRefundDetails> getRefundDetails() {
        return this.f31208e;
    }

    public final void setRefundDetails(MutableLiveData<PixRefundResultResp.OrderRefundDetails> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31208e = mutableLiveData;
    }

    public final void loadData(String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        isLoading().setValue(true);
        this.f31206c.queryRefundOptions(str, new PixOrderRefundDetailVM$loadData$1(this));
    }

    public final void doRefund(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "reasonId");
        isLoading().setValue(true);
        this.f31206c.refundTransferMoney(i, str, str2, new PixOrderRefundDetailVM$doRefund$1(this, str));
    }

    public final void queryOrderDetail(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        this.f31206c.queryRefundDetail(str, new PixOrderRefundDetailVM$queryOrderDetail$1(this, z));
    }

    public final CountDownTimer getMCountDownTimer() {
        return this.f31209f;
    }

    public final void setMCountDownTimer(CountDownTimer countDownTimer) {
        this.f31209f = countDownTimer;
    }

    public final void loopQueryOrderDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        if (this.f31209f == null) {
            this.f31209f = new PixOrderRefundDetailVM$loopQueryOrderDetail$1(this, str, 10000, ((long) 2) * this.f31205b);
        }
        CountDownTimer countDownTimer = this.f31209f;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public final void stopCountTimer() {
        CountDownTimer countDownTimer = this.f31209f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
