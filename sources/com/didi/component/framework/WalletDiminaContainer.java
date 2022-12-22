package com.didi.component.framework;

import androidx.fragment.app.Fragment;
import com.didi.sdk.app.business.ISABusiness;
import com.didi.wallet.dimina.view.WalletDiminaFragment;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "wallet", value = {ISABusiness.class})
@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/component/framework/WalletDiminaContainer;", "Lcom/didi/sdk/app/business/ISABusiness;", "()V", "transitionFragment", "Landroidx/fragment/app/Fragment;", "url", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IWalletDiminaFragment.kt */
public final class WalletDiminaContainer implements ISABusiness {
    public Fragment transitionFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        if (Intrinsics.areEqual((Object) new URI(str).getPath(), (Object) "/dimina_enter")) {
            return WalletDiminaFragment.Companion.newInstance$default(WalletDiminaFragment.Companion, str, false, 2, (Object) null);
        }
        return null;
    }
}
