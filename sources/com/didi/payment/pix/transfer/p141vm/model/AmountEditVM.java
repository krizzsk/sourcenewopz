package com.didi.payment.pix.transfer.p141vm.model;

import android.app.Application;
import android.content.Context;
import android.os.CountDownTimer;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didi.payment.pix.net.response.PixTransferOption;
import com.didi.payment.wallet.global.model.NightlyLimitSettingModel;
import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u000103J\b\u00105\u001a\u00020/H\u0016J\b\u00106\u001a\u00020/H\u0002J\u000e\u00107\u001a\u00020/2\u0006\u00108\u001a\u000203J\u0016\u00109\u001a\u00020/2\u0006\u00108\u001a\u0002032\u0006\u0010:\u001a\u00020 J\u000e\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u000203J\u0006\u0010=\u001a\u00020/J\u0016\u0010>\u001a\u00020/2\u0006\u0010<\u001a\u0002032\u0006\u0010?\u001a\u000201R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R \u0010#\u001a\b\u0012\u0004\u0012\u00020$0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000fR \u0010*\u001a\b\u0012\u0004\u0012\u00020+0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011¨\u0006@"}, mo175978d2 = {"Lcom/didi/payment/pix/transfer/vm/model/AmountEditVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "TIME_INTERVAL", "", "getTIME_INTERVAL", "()J", "setTIME_INTERVAL", "(J)V", "errCreateOrder", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "getErrCreateOrder", "()Landroidx/lifecycle/MutableLiveData;", "setErrCreateOrder", "(Landroidx/lifecycle/MutableLiveData;)V", "mCountDownTimer", "Landroid/os/CountDownTimer;", "netModel", "Lcom/didi/payment/pix/net/PixNetModel;", "nightlyLimitSettingModel", "Lcom/didi/payment/wallet/global/model/NightlyLimitSettingModel;", "nightlyLimitVo", "Lcom/didi/payment/wallet/global/model/resp/GetNightlyLimitResp$NightlyLimitVo;", "getNightlyLimitVo", "orderDetailLD", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$OrderDetail;", "getOrderDetailLD", "setOrderDetailLD", "orderDetailLooping", "", "getOrderDetailLooping", "setOrderDetailLooping", "pixAccountQueryByQr", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PixAccount;", "getPixAccountQueryByQr", "setPixAccountQueryByQr", "pwdData", "Lcom/didi/payment/wallet/password/PasswordDataVo;", "getPwdData", "transferOption", "Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;", "getTransferOption", "setTransferOption", "createPixTransferOrder", "", "productId", "", "bizContent", "", "passwordToken", "loadData", "loadNightlyLimitConfig", "loopQueryOrderDetail", "orderId", "queryOrderDetail", "isLastCheck", "queryPixKeyDetail", "key", "stopCountTimer", "triggerRealtimePush", "type", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.transfer.vm.model.AmountEditVM */
/* compiled from: AmountEditVM.kt */
public final class AmountEditVM extends WBaseViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CountDownTimer f31261a;

    /* renamed from: b */
    private PixNetModel f31262b;

    /* renamed from: c */
    private final NightlyLimitSettingModel f31263c;

    /* renamed from: d */
    private final MutableLiveData<GetNightlyLimitResp.NightlyLimitVo> f31264d = new MutableLiveData<>();

    /* renamed from: e */
    private MutableLiveData<WBaseResp> f31265e = new MutableLiveData<>();

    /* renamed from: f */
    private MutableLiveData<Boolean> f31266f = new MutableLiveData<>();

    /* renamed from: g */
    private MutableLiveData<PixOrderDetailResp.OrderDetail> f31267g = new MutableLiveData<>();

    /* renamed from: h */
    private MutableLiveData<PixTransferOption.TransferOptionInfo> f31268h = new MutableLiveData<>();

    /* renamed from: i */
    private MutableLiveData<PixKeyVerifyResp.PixAccount> f31269i = new MutableLiveData<>();

    /* renamed from: j */
    private final MutableLiveData<PasswordDataVo> f31270j = new MutableLiveData<>();

    /* renamed from: k */
    private long f31271k = 1000;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AmountEditVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Context context = application;
        this.f31262b = new PixNetModel(context);
        this.f31263c = new NightlyLimitSettingModel(context);
    }

    public final MutableLiveData<GetNightlyLimitResp.NightlyLimitVo> getNightlyLimitVo() {
        return this.f31264d;
    }

    public final MutableLiveData<WBaseResp> getErrCreateOrder() {
        return this.f31265e;
    }

    public final void setErrCreateOrder(MutableLiveData<WBaseResp> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31265e = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getOrderDetailLooping() {
        return this.f31266f;
    }

    public final void setOrderDetailLooping(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31266f = mutableLiveData;
    }

    public final MutableLiveData<PixOrderDetailResp.OrderDetail> getOrderDetailLD() {
        return this.f31267g;
    }

    public final void setOrderDetailLD(MutableLiveData<PixOrderDetailResp.OrderDetail> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31267g = mutableLiveData;
    }

    public final MutableLiveData<PixTransferOption.TransferOptionInfo> getTransferOption() {
        return this.f31268h;
    }

    public final void setTransferOption(MutableLiveData<PixTransferOption.TransferOptionInfo> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31268h = mutableLiveData;
    }

    public final MutableLiveData<PixKeyVerifyResp.PixAccount> getPixAccountQueryByQr() {
        return this.f31269i;
    }

    public final void setPixAccountQueryByQr(MutableLiveData<PixKeyVerifyResp.PixAccount> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31269i = mutableLiveData;
    }

    public final MutableLiveData<PasswordDataVo> getPwdData() {
        return this.f31270j;
    }

    public final long getTIME_INTERVAL() {
        return this.f31271k;
    }

    public final void setTIME_INTERVAL(long j) {
        this.f31271k = j;
    }

    public void loadData() {
        isLoading().setValue(true);
        this.f31262b.getTransferOptionInfo(new AmountEditVM$loadData$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m22006a() {
        isLoading().setValue(true);
        this.f31263c.getNightlyLimit(99996, new AmountEditVM$loadNightlyLimitConfig$1(this));
    }

    public static /* synthetic */ void createPixTransferOrder$default(AmountEditVM amountEditVM, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        amountEditVM.createPixTransferOrder(i, str, str2);
    }

    public final void createPixTransferOrder(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, Const.PayParams.BIZ_CONTENT);
        this.f31266f.setValue(true);
        this.f31262b.createTransferOrder(i, 0, "{\"currency\":\"BRL\", \"sku\":\"pix key transfer\"}", str, str2, new AmountEditVM$createPixTransferOrder$1(this, str));
    }

    public final void queryPixKeyDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        isLoading().setValue(true);
        this.f31262b.verifyPixKey(str, true, new AmountEditVM$queryPixKeyDetail$1(this));
    }

    public final void loopQueryOrderDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        if (this.f31261a == null) {
            this.f31261a = new AmountEditVM$loopQueryOrderDetail$1(this, str, 10000, ((long) 2) * this.f31271k);
        }
        CountDownTimer countDownTimer = this.f31261a;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public final void stopCountTimer() {
        CountDownTimer countDownTimer = this.f31261a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final void queryOrderDetail(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        SystemUtils.log(3, "hgl", "queryOrderDetail...", (Throwable) null, "com.didi.payment.pix.transfer.vm.model.AmountEditVM", 191);
        this.f31266f.setValue(true);
        this.f31262b.getOrderDetail(str, new AmountEditVM$queryOrderDetail$1(this, z, str));
    }

    public final void triggerRealtimePush(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f31262b.notifyTransferPush(str, i, new AmountEditVM$triggerRealtimePush$1());
    }
}
