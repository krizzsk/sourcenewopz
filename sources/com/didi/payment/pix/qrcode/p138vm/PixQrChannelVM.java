package com.didi.payment.pix.qrcode.p138vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.PixQrChannelResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/payment/pix/qrcode/vm/PixQrChannelVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "netModel", "Lcom/didi/payment/pix/net/PixNetModel;", "qrChannel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/pix/net/response/PixQrChannelResp$Data;", "getQrChannel", "()Landroidx/lifecycle/MutableLiveData;", "setQrChannel", "(Landroidx/lifecycle/MutableLiveData;)V", "loadData", "", "Factory", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.qrcode.vm.PixQrChannelVM */
/* compiled from: PixQrChannelVM.kt */
public final class PixQrChannelVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f31165a;

    /* renamed from: b */
    private MutableLiveData<PixQrChannelResp.Data> f31166b = new MutableLiveData<>(null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixQrChannelVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f31165a = new PixNetModel(application2);
    }

    public final MutableLiveData<PixQrChannelResp.Data> getQrChannel() {
        return this.f31166b;
    }

    public final void setQrChannel(MutableLiveData<PixQrChannelResp.Data> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31166b = mutableLiveData;
    }

    public void loadData() {
        isLoading().setValue(true);
        this.f31165a.getPixQrChannelList(new PixQrChannelVM$loadData$1(this));
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/pix/qrcode/vm/PixQrChannelVM$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.pix.qrcode.vm.PixQrChannelVM$Factory */
    /* compiled from: PixQrChannelVM.kt */
    public static final class Factory implements ViewModelProvider.Factory {
        private final Application application;

        public Factory(Application application2) {
            Intrinsics.checkNotNullParameter(application2, "application");
            this.application = application2;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            return (ViewModel) new PixQrChannelVM(this.application);
        }
    }
}
