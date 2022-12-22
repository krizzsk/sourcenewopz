package com.didi.entrega.customer;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.sdk.app.business.ISABusiness;
import com.didi.sdk.app.business.SaBusinessManager;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "sodaEntrega", value = {ISABusiness.class})
@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, mo175978d2 = {"Lcom/didi/entrega/customer/CustomerSABusiness;", "Lcom/didi/sdk/app/business/ISABusiness;", "()V", "transitionFragment", "Landroidx/fragment/app/Fragment;", "url", "", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerSABusiness.kt */
public final class CustomerSABusiness implements ISABusiness {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_SUPER_APP = "is_super_app";

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/CustomerSABusiness$Companion;", "", "()V", "KEY_SUPER_APP", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerSABusiness.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Fragment transitionFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        LogUtil.m14761d("ISABusiness", Intrinsics.stringPlus("url = ", str));
        GlobalContext.fromSuperApp();
        if (CustomerApolloUtil.createFragmentAllowNull() && Intrinsics.areEqual((Object) SaBusinessManager.Companion.getIns().getCurrentBusiness(), (Object) "sodaEntrega")) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(KEY_SUPER_APP, true);
        CustomerFragmentB customerFragmentB = new CustomerFragmentB();
        customerFragmentB.setArguments(bundle);
        return customerFragmentB;
    }
}
