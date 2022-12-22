package com.didi.payment.kycservice.kyc.p133vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.kyc.response.PixChooseTypeListResp;
import com.didi.payment.kycservice.net.PixNetModel;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/vm/ChooseTypeBaseVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "reqType", "", "(Landroid/app/Application;I)V", "bizLD", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Data;", "getBizLD", "()Landroidx/lifecycle/MutableLiveData;", "netModel", "Lcom/didi/payment/kycservice/net/PixNetModel;", "getNetModel", "()Lcom/didi/payment/kycservice/net/PixNetModel;", "loadData", "", "loadPixIdTypeList", "loadPixKeyTypeList", "Companion", "NetCallback", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.ChooseTypeBaseVM */
/* compiled from: ChooseTypeBaseVM.kt */
public class ChooseTypeBaseVM extends WBaseViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_ID = 0;
    public static final int TYPE_PIX_KEY = 1;

    /* renamed from: a */
    private final int f30870a;

    /* renamed from: b */
    private final PixNetModel f30871b;

    /* renamed from: c */
    private final MutableLiveData<PixChooseTypeListResp.Data> f30872c = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseTypeBaseVM(Application application, int i) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f30870a = i;
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f30871b = new PixNetModel(application2);
        loadData();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/vm/ChooseTypeBaseVM$Companion;", "", "()V", "TYPE_ID", "", "TYPE_PIX_KEY", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.kycservice.kyc.vm.ChooseTypeBaseVM$Companion */
    /* compiled from: ChooseTypeBaseVM.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public final PixNetModel getNetModel() {
        return this.f30871b;
    }

    public final MutableLiveData<PixChooseTypeListResp.Data> getBizLD() {
        return this.f30872c;
    }

    public void loadData() {
        if (this.f30870a == 0) {
            m21733a();
        } else {
            m21734b();
        }
    }

    /* renamed from: a */
    private final void m21733a() {
        this.f30871b.getPixIDTypeList(new NetCallback(this));
    }

    /* renamed from: b */
    private final void m21734b() {
        this.f30871b.getPixKeyTypeList(new NetCallback(this));
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/vm/ChooseTypeBaseVM$NetCallback;", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp;", "(Lcom/didi/payment/kycservice/kyc/vm/ChooseTypeBaseVM;)V", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.kycservice.kyc.vm.ChooseTypeBaseVM$NetCallback */
    /* compiled from: ChooseTypeBaseVM.kt */
    private final class NetCallback extends WNetCallback<PixChooseTypeListResp> {
        final /* synthetic */ ChooseTypeBaseVM this$0;

        public NetCallback(ChooseTypeBaseVM chooseTypeBaseVM) {
            Intrinsics.checkNotNullParameter(chooseTypeBaseVM, "this$0");
            this.this$0 = chooseTypeBaseVM;
        }

        public void onStart() {
            this.this$0.isLoading().setValue(true);
            this.this$0.isNetError().setValue(false);
        }

        public void onComplete() {
            this.this$0.isLoading().setValue(false);
        }

        public void onSuccess(PixChooseTypeListResp pixChooseTypeListResp) {
            Intrinsics.checkNotNullParameter(pixChooseTypeListResp, "response");
            super.onSuccess(pixChooseTypeListResp);
            if (pixChooseTypeListResp.getData() != null) {
                MutableLiveData<PixChooseTypeListResp.Data> bizLD = this.this$0.getBizLD();
                PixChooseTypeListResp.Data data = pixChooseTypeListResp.getData();
                Intrinsics.checkNotNull(data);
                bizLD.setValue(data);
            } else {
                this.this$0.isNetError().setValue(true);
            }
            if (pixChooseTypeListResp.errno == 60222) {
                this.this$0.getErrObj().setValue(pixChooseTypeListResp);
            }
        }

        public void onFailure(IOException iOException) {
            super.onFailure(iOException);
            this.this$0.isNetError().setValue(true);
        }
    }
}
