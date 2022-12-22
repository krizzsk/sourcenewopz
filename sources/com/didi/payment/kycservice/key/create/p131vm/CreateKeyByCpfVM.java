package com.didi.payment.kycservice.key.create.p131vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.net.PixNetModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/vm/CreateKeyByCpfVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "isFinish", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "setFinish", "(Landroidx/lifecycle/MutableLiveData;)V", "netModel", "Lcom/didi/payment/kycservice/net/PixNetModel;", "create", "", "keyVal", "", "loadData", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.key.create.vm.CreateKeyByCpfVM */
/* compiled from: CreateKeyByCpfVM.kt */
public final class CreateKeyByCpfVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f30670a;

    /* renamed from: b */
    private MutableLiveData<Boolean> f30671b = new MutableLiveData<>();

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateKeyByCpfVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f30670a = new PixNetModel(application);
    }

    public final MutableLiveData<Boolean> isFinish() {
        return this.f30671b;
    }

    public final void setFinish(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30671b = mutableLiveData;
    }

    public final void create(String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        this.f30670a.createPixKey(0, str, new CreateKeyByCpfVM$create$1(this));
    }
}
