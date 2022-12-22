package com.didi.payment.kycservice.key.create.p131vm;

import android.app.Application;
import android.os.CountDownTimer;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.kycservice.kyc.response.MigrateTipData;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.utils.PollVM;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 /2\u00020\u0001:\u0001/B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010$\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\bJ\u0018\u0010(\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010)\u001a\u00020%H\u0016J\u0016\u0010*\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\b\u0010+\u001a\u00020%H\u0014J\u0016\u0010,\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010-\u001a\u00020%J\u0006\u0010.\u001a\u00020%R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013¨\u00060"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/vm/CheckCodeVM;", "Lcom/didi/payment/kycservice/utils/PollVM;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "countDownTimer", "Landroid/os/CountDownTimer;", "keyType", "", "keyVal", "", "getKeyVal", "()Ljava/lang/String;", "setKeyVal", "(Ljava/lang/String;)V", "leftTimeLD", "Landroidx/lifecycle/MutableLiveData;", "", "getLeftTimeLD", "()Landroidx/lifecycle/MutableLiveData;", "setLeftTimeLD", "(Landroidx/lifecycle/MutableLiveData;)V", "resultPageData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultPageData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultPageData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "showMigrateTipLD", "Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "getShowMigrateTipLD", "showResultPageLD", "", "getShowResultPageLD", "showToastLD", "getShowToastLD", "checkCode", "", "code", "srcFrom", "doPoll", "loadData", "migrateIn", "onCleared", "reqAuthCode", "startCountDown", "stopCountDown", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.key.create.vm.CheckCodeVM */
/* compiled from: CheckCodeVM.kt */
public final class CheckCodeVM extends PollVM {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: i */
    private static final long f30660i = 60000;

    /* renamed from: j */
    private static final long f30661j = 1000;

    /* renamed from: a */
    private int f30662a = 1;

    /* renamed from: b */
    private String f30663b = "";

    /* renamed from: c */
    private ResultPageData f30664c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CountDownTimer f30665d;

    /* renamed from: e */
    private final MutableLiveData<Boolean> f30666e = new MutableLiveData<>();

    /* renamed from: f */
    private final MutableLiveData<String> f30667f = new MutableLiveData<>();

    /* renamed from: g */
    private MutableLiveData<Long> f30668g = new MutableLiveData<>();

    /* renamed from: h */
    private final MutableLiveData<MigrateTipData> f30669h = new MutableLiveData<>();

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckCodeVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final String getKeyVal() {
        return this.f30663b;
    }

    public final void setKeyVal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30663b = str;
    }

    public final ResultPageData getResultPageData() {
        return this.f30664c;
    }

    public final void setResultPageData(ResultPageData resultPageData) {
        this.f30664c = resultPageData;
    }

    public final MutableLiveData<Boolean> getShowResultPageLD() {
        return this.f30666e;
    }

    public final MutableLiveData<String> getShowToastLD() {
        return this.f30667f;
    }

    public final MutableLiveData<Long> getLeftTimeLD() {
        return this.f30668g;
    }

    public final void setLeftTimeLD(MutableLiveData<Long> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30668g = mutableLiveData;
    }

    public final MutableLiveData<MigrateTipData> getShowMigrateTipLD() {
        return this.f30669h;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/vm/CheckCodeVM$Companion;", "", "()V", "TIME_INTERVAL", "", "TIME_TOTAL", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.kycservice.key.create.vm.CheckCodeVM$Companion */
    /* compiled from: CheckCodeVM.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void startCountDown() {
        CountDownTimer checkCodeVM$startCountDown$1 = new CheckCodeVM$startCountDown$1(this);
        this.f30665d = checkCodeVM$startCountDown$1;
        if (checkCodeVM$startCountDown$1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownTimer");
            checkCodeVM$startCountDown$1 = null;
        }
        checkCodeVM$startCountDown$1.start();
    }

    public final void stopCountDown() {
        CountDownTimer countDownTimer = this.f30665d;
        if (countDownTimer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownTimer");
            countDownTimer = null;
        }
        countDownTimer.cancel();
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        CountDownTimer countDownTimer = this.f30665d;
        if (countDownTimer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownTimer");
            countDownTimer = null;
        }
        countDownTimer.cancel();
    }

    public final void reqAuthCode(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        this.f30662a = i;
        this.f30663b = str;
        getNetModel().reqAuthCode(i, str, new CheckCodeVM$reqAuthCode$1(this, i, str));
    }

    public final void checkCode(int i, String str, String str2, int i2) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(str2, "code");
        getNetModel().checkAuthCode(i, str, str2, i2, new CheckCodeVM$checkCode$1(this, i, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21562a(int i, String str) {
        pollPixKeyStatus(i, str, 1, new CheckCodeVM$doPoll$1(this));
    }

    public final void migrateIn(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        getNetModel().reqPixKeyMigrateIn(i, str, new CheckCodeVM$migrateIn$1(this, i, str));
    }
}
