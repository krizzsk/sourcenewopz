package com.didi.payment.commonsdk.p129ui;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/ui/FragmentSwitchVM;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "fragmengSwitchLD", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/commonsdk/ui/FragmentSwitchVM$ForwardAction;", "getFragmengSwitchLD", "()Landroidx/lifecycle/MutableLiveData;", "setFragmengSwitchLD", "(Landroidx/lifecycle/MutableLiveData;)V", "fragmengSwitchLD2", "Lcom/didi/payment/commonsdk/ui/FragmentSwitchVM$PageSwitch;", "getFragmengSwitchLD2", "setFragmengSwitchLD2", "ForwardAction", "PageSwitch", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.commonsdk.ui.FragmentSwitchVM */
/* compiled from: FragmentSwitchVM.kt */
public final class FragmentSwitchVM extends AndroidViewModel {

    /* renamed from: a */
    private MutableLiveData<ForwardAction> f30171a = new MutableLiveData<>();

    /* renamed from: b */
    private MutableLiveData<PageSwitch> f30172b = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentSwitchVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<ForwardAction> getFragmengSwitchLD() {
        return this.f30171a;
    }

    public final void setFragmengSwitchLD(MutableLiveData<ForwardAction> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30171a = mutableLiveData;
    }

    public final MutableLiveData<PageSwitch> getFragmengSwitchLD2() {
        return this.f30172b;
    }

    public final void setFragmengSwitchLD2(MutableLiveData<PageSwitch> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30172b = mutableLiveData;
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/ui/FragmentSwitchVM$ForwardAction;", "", "clz", "Ljava/lang/Class;", "extras", "Landroid/os/Bundle;", "(Ljava/lang/Class;Landroid/os/Bundle;)V", "doReplace", "", "getDoReplace", "()Z", "setDoReplace", "(Z)V", "getExtras", "()Landroid/os/Bundle;", "setExtras", "(Landroid/os/Bundle;)V", "targetPageClz", "getTargetPageClz", "()Ljava/lang/Class;", "setTargetPageClz", "(Ljava/lang/Class;)V", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.commonsdk.ui.FragmentSwitchVM$ForwardAction */
    /* compiled from: FragmentSwitchVM.kt */
    public static final class ForwardAction {
        private boolean doReplace;
        private Bundle extras;
        private Class<?> targetPageClz;

        public ForwardAction(Class<?> cls, Bundle bundle) {
            Intrinsics.checkNotNullParameter(cls, "clz");
            this.targetPageClz = cls;
            this.extras = bundle;
        }

        public final Class<?> getTargetPageClz() {
            return this.targetPageClz;
        }

        public final void setTargetPageClz(Class<?> cls) {
            this.targetPageClz = cls;
        }

        public final Bundle getExtras() {
            return this.extras;
        }

        public final void setExtras(Bundle bundle) {
            this.extras = bundle;
        }

        public final boolean getDoReplace() {
            return this.doReplace;
        }

        public final void setDoReplace(boolean z) {
            this.doReplace = z;
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR,\u0010\u0010\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\t¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/ui/FragmentSwitchVM$PageSwitch;", "", "pop", "", "forwardPageClz", "Ljava/lang/Class;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "(ZLjava/lang/Class;)V", "(Z)V", "extras", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "setExtras", "(Landroid/os/Bundle;)V", "mforwardPageClz", "getMforwardPageClz", "()Ljava/lang/Class;", "setMforwardPageClz", "(Ljava/lang/Class;)V", "popCurrentFragment", "getPopCurrentFragment", "()Z", "setPopCurrentFragment", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.commonsdk.ui.FragmentSwitchVM$PageSwitch */
    /* compiled from: FragmentSwitchVM.kt */
    public static final class PageSwitch {
        private Bundle extras;
        private Class<? extends WBaseFragment<WBaseViewModel>> mforwardPageClz;
        private boolean popCurrentFragment;

        public PageSwitch(boolean z) {
            this.popCurrentFragment = z;
        }

        public final boolean getPopCurrentFragment() {
            return this.popCurrentFragment;
        }

        public final void setPopCurrentFragment(boolean z) {
            this.popCurrentFragment = z;
        }

        public final Class<? extends WBaseFragment<WBaseViewModel>> getMforwardPageClz() {
            return this.mforwardPageClz;
        }

        public final void setMforwardPageClz(Class<? extends WBaseFragment<WBaseViewModel>> cls) {
            this.mforwardPageClz = cls;
        }

        public final Bundle getExtras() {
            return this.extras;
        }

        public final void setExtras(Bundle bundle) {
            this.extras = bundle;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public PageSwitch(boolean z, Class<? extends WBaseFragment<WBaseViewModel>> cls) {
            this(z);
            Intrinsics.checkNotNullParameter(cls, "forwardPageClz");
            this.mforwardPageClz = cls;
        }
    }
}
