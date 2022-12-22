package com.didi.payment.pix.topup;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.PixOrderCreateResp;
import com.didi.payment.pix.net.response.PixTopUpOption;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\t¨\u0006 "}, mo175978d2 = {"Lcom/didi/payment/pix/topup/TopUpByPixViewModel;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "failedToast", "Landroidx/lifecycle/MutableLiveData;", "", "getFailedToast", "()Landroidx/lifecycle/MutableLiveData;", "orderId", "getOrderId", "()Ljava/lang/String;", "pixNetModel", "Lcom/didi/payment/pix/net/PixNetModel;", "getPixNetModel", "()Lcom/didi/payment/pix/net/PixNetModel;", "pixTopUpOption", "Lcom/didi/payment/pix/net/response/PixTopUpOption;", "getPixTopUpOption", "pwdData", "Lcom/didi/payment/wallet/password/PasswordDataVo;", "getPwdData", "successOrder", "Lcom/didi/payment/pix/net/response/PixOrderCreateResp$OrderMetaData;", "getSuccessOrder", "loadData", "", "topUp", "originAmount", "", "passwordToken", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopUpByPixViewModel.kt */
public final class TopUpByPixViewModel extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f31215a;

    /* renamed from: b */
    private final MutableLiveData<PixOrderCreateResp.OrderMetaData> f31216b = new MutableLiveData<>();

    /* renamed from: c */
    private final MutableLiveData<PixTopUpOption> f31217c = new MutableLiveData<>();

    /* renamed from: d */
    private final MutableLiveData<PasswordDataVo> f31218d = new MutableLiveData<>();

    /* renamed from: e */
    private final MutableLiveData<String> f31219e = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopUpByPixViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f31215a = new PixNetModel(application);
    }

    public final PixNetModel getPixNetModel() {
        return this.f31215a;
    }

    public final MutableLiveData<PixOrderCreateResp.OrderMetaData> getSuccessOrder() {
        return this.f31216b;
    }

    public final MutableLiveData<PixTopUpOption> getPixTopUpOption() {
        return this.f31217c;
    }

    public final String getOrderId() {
        PixOrderCreateResp.OrderMetaData value = this.f31216b.getValue();
        if (value == null) {
            return null;
        }
        return value.getOrderId();
    }

    public final MutableLiveData<PasswordDataVo> getPwdData() {
        return this.f31218d;
    }

    public final MutableLiveData<String> getFailedToast() {
        return this.f31219e;
    }

    public void loadData() {
        isLoading().setValue(true);
        this.f31215a.getPixTopUpOptions(new TopUpByPixViewModel$loadData$1(this));
    }

    public static /* synthetic */ void topUp$default(TopUpByPixViewModel topUpByPixViewModel, double d, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        topUpByPixViewModel.topUp(d, str);
    }

    public final void topUp(double d, String str) {
        isLoading().setValue(true);
        PixTopUpOption value = this.f31217c.getValue();
        String metadata = value == null ? null : value.getMetadata();
        if (metadata != null) {
            JsonObject asJsonObject = new JsonParser().parse(metadata).getAsJsonObject();
            int i = (int) (d * ((double) 100));
            asJsonObject.addProperty("price", (Number) Integer.valueOf(i));
            asJsonObject.addProperty("value", (Number) Integer.valueOf(i));
            TopUpByPixViewModel$topUp$callback$1 topUpByPixViewModel$topUp$callback$1 = new TopUpByPixViewModel$topUp$callback$1(this);
            PixNetModel pixNetModel = this.f31215a;
            String json = new Gson().toJson((JsonElement) asJsonObject);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(metadata)");
            PixNetModel.createPixTopUpOrder$default(pixNetModel, 0, 0, json, str, topUpByPixViewModel$topUp$callback$1, 3, (Object) null);
        }
    }
}
