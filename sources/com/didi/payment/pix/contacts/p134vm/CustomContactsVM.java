package com.didi.payment.pix.contacts.p134vm;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.PhoneUtil;
import com.didi.payment.pix.contacts.p134vm.model.PhoneContacts;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0014H\u0016R&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/payment/pix/contacts/vm/CustomContactsVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "contactsLD", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/didi/payment/pix/contacts/vm/model/PhoneContacts;", "getContactsLD", "()Landroidx/lifecycle/MutableLiveData;", "setContactsLD", "(Landroidx/lifecycle/MutableLiveData;)V", "netModel", "Lcom/didi/payment/pix/net/PixNetModel;", "phoneNumPixLD", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PixKeyList;", "getPhoneNumPixLD", "setPhoneNumPixLD", "checkPhoneNum", "", "pNum", "", "loadContacts", "context", "Landroid/content/Context;", "loadData", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.contacts.vm.CustomContactsVM */
/* compiled from: CustomContactsVM.kt */
public final class CustomContactsVM extends WBaseViewModel {

    /* renamed from: a */
    private PixNetModel f31050a;

    /* renamed from: b */
    private MutableLiveData<List<PhoneContacts>> f31051b = new MutableLiveData<>();

    /* renamed from: c */
    private MutableLiveData<PixKeyVerifyResp.PixKeyList> f31052c = new MutableLiveData<>();

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomContactsVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f31050a = new PixNetModel(application);
    }

    public final MutableLiveData<List<PhoneContacts>> getContactsLD() {
        return this.f31051b;
    }

    public final void setContactsLD(MutableLiveData<List<PhoneContacts>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31051b = mutableLiveData;
    }

    public final MutableLiveData<PixKeyVerifyResp.PixKeyList> getPhoneNumPixLD() {
        return this.f31052c;
    }

    public final void setPhoneNumPixLD(MutableLiveData<PixKeyVerifyResp.PixKeyList> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31052c = mutableLiveData;
    }

    public final void loadContacts(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        isLoading().setValue(true);
        List<PhoneContacts> phoneRecords = PhoneUtil.getPhoneRecords(context);
        Intrinsics.checkNotNullExpressionValue(phoneRecords, "getPhoneRecords(context)");
        isLoading().setValue(false);
        this.f31051b.setValue(phoneRecords);
    }

    public final void checkPhoneNum(String str) {
        Intrinsics.checkNotNullParameter(str, "pNum");
        isLoading().setValue(true);
        this.f31050a.verifyPixKey(str, true, new CustomContactsVM$checkPhoneNum$1(this));
    }
}
