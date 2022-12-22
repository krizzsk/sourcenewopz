package com.didi.wallet.dimina.view;

import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.commoninterfacelib.permission.TheOneBaseFragment;
import com.didi.wallet.dimina.DiminaLaunchModel;
import com.taxis99.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\"\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006 "}, mo175978d2 = {"Lcom/didi/wallet/dimina/view/WalletDiminaFragment;", "Lcom/didi/commoninterfacelib/permission/TheOneBaseFragment;", "Landroid/view/KeyEvent$Callback;", "()V", "diminaLaunchModel", "Lcom/didi/wallet/dimina/DiminaLaunchModel;", "getDiminaLaunchModel", "()Lcom/didi/wallet/dimina/DiminaLaunchModel;", "diminaLaunchModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "", "p0", "", "p1", "Landroid/view/KeyEvent;", "onKeyLongPress", "onKeyMultiple", "p2", "onKeyUp", "onViewCreated", "", "view", "Companion", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletDiminaFragment.kt */
public final class WalletDiminaFragment extends TheOneBaseFragment implements KeyEvent.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIMINA_ROUTER_URL = "DIMINA_ROUTER_URL";
    public static final String IS_NEED_FINISH_ACTIVITY = "IS_NEED_FINISH_ACTIVITY";

    /* renamed from: a */
    private final Lazy f45178a = LazyKt.lazy(new WalletDiminaFragment$diminaLaunchModel$2(this));

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/wallet/dimina/view/WalletDiminaFragment$Companion;", "", "()V", "DIMINA_ROUTER_URL", "", "IS_NEED_FINISH_ACTIVITY", "newInstance", "Lcom/didi/wallet/dimina/view/WalletDiminaFragment;", "url", "isNeedFinishActivity", "", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletDiminaFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ WalletDiminaFragment newInstance$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.newInstance(str, z);
        }

        public final WalletDiminaFragment newInstance(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "url");
            WalletDiminaFragment walletDiminaFragment = new WalletDiminaFragment();
            Uri.parse(str);
            Bundle bundle = new Bundle();
            bundle.putBoolean(WalletDiminaFragment.IS_NEED_FINISH_ACTIVITY, z);
            bundle.putString(WalletDiminaFragment.DIMINA_ROUTER_URL, str);
            walletDiminaFragment.setArguments(bundle);
            return walletDiminaFragment;
        }
    }

    /* renamed from: a */
    private final DiminaLaunchModel m32454a() {
        return (DiminaLaunchModel) this.f45178a.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_wallet_dimina, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        m32454a().launchDimina(bundle);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!(keyEvent != null && keyEvent.getKeyCode() == 4)) {
            return false;
        }
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        if (!(!fragments.isEmpty())) {
            return false;
        }
        Fragment fragment = fragments.get(fragments.size() - 1);
        if (fragment instanceof KeyEvent.Callback) {
            return ((KeyEvent.Callback) fragment).onKeyUp(i, keyEvent);
        }
        return false;
    }
}
