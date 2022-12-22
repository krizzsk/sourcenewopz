package com.didi.payment.kycservice.key.create;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.kycservice.kyc.response.MigrateTipData;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.utils.PollVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010(\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010*\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u0006H\u0002J\b\u0010,\u001a\u00020)H\u0016J\u0016\u0010-\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001e¨\u0006."}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/PixKeyCreateVM;", "Lcom/didi/payment/kycservice/utils/PollVM;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "checkCodePageSrcFrom", "", "getCheckCodePageSrcFrom", "()I", "setCheckCodePageSrcFrom", "(I)V", "keyType", "getKeyType", "setKeyType", "keyVal", "", "getKeyVal", "()Ljava/lang/String;", "setKeyVal", "(Ljava/lang/String;)V", "resultPageData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultPageData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultPageData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "showKeyListPageLD", "Landroidx/lifecycle/MutableLiveData;", "", "getShowKeyListPageLD", "()Landroidx/lifecycle/MutableLiveData;", "showMigrateTipLD", "Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "getShowMigrateTipLD", "showResultPageLD", "getShowResultPageLD", "showToastLD", "getShowToastLD", "showVerifyPageLD", "getShowVerifyPageLD", "createPixKey", "", "doPoll", "pollType", "loadData", "migrateIn", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyCreateVM.kt */
public final class PixKeyCreateVM extends PollVM {

    /* renamed from: a */
    private int f30623a = 1;

    /* renamed from: b */
    private String f30624b = "";

    /* renamed from: c */
    private int f30625c;

    /* renamed from: d */
    private ResultPageData f30626d;

    /* renamed from: e */
    private final MutableLiveData<MigrateTipData> f30627e = new MutableLiveData<>();

    /* renamed from: f */
    private final MutableLiveData<Boolean> f30628f = new MutableLiveData<>();

    /* renamed from: g */
    private final MutableLiveData<Boolean> f30629g = new MutableLiveData<>();

    /* renamed from: h */
    private final MutableLiveData<Boolean> f30630h = new MutableLiveData<>();

    /* renamed from: i */
    private final MutableLiveData<String> f30631i = new MutableLiveData<>();

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixKeyCreateVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final int getKeyType() {
        return this.f30623a;
    }

    public final void setKeyType(int i) {
        this.f30623a = i;
    }

    public final String getKeyVal() {
        return this.f30624b;
    }

    public final void setKeyVal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30624b = str;
    }

    public final int getCheckCodePageSrcFrom() {
        return this.f30625c;
    }

    public final void setCheckCodePageSrcFrom(int i) {
        this.f30625c = i;
    }

    public final ResultPageData getResultPageData() {
        return this.f30626d;
    }

    public final void setResultPageData(ResultPageData resultPageData) {
        this.f30626d = resultPageData;
    }

    public final MutableLiveData<MigrateTipData> getShowMigrateTipLD() {
        return this.f30627e;
    }

    public final MutableLiveData<Boolean> getShowVerifyPageLD() {
        return this.f30628f;
    }

    public final MutableLiveData<Boolean> getShowResultPageLD() {
        return this.f30629g;
    }

    public final MutableLiveData<Boolean> getShowKeyListPageLD() {
        return this.f30630h;
    }

    public final MutableLiveData<String> getShowToastLD() {
        return this.f30631i;
    }

    public final void createPixKey(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        this.f30623a = i;
        this.f30624b = str;
        getNetModel().createPixKey(i, str, new PixKeyCreateVM$createPixKey$1(this, i, str));
    }

    public final void migrateIn(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        getNetModel().reqPixKeyMigrateIn(i, str, new PixKeyCreateVM$migrateIn$1(this, i, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21528a(int i, String str, int i2) {
        pollPixKeyStatus(i, str, i2, new PixKeyCreateVM$doPoll$1(this, i2));
    }
}
