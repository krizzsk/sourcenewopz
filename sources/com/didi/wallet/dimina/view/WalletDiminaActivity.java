package com.didi.wallet.dimina.view;

import android.os.Bundle;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.drouter.api.Extend;
import com.didi.payment.base.tracker.FinExtAttrBiz;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/wallet/dimina/view/WalletDiminaActivity;", "Lcom/didi/commoninterfacelib/permission/TheOneBaseActivity;", "()V", "finExtAttrBiz", "Lcom/didi/payment/base/tracker/FinExtAttrBiz;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletDiminaActivity.kt */
public final class WalletDiminaActivity extends TheOneBaseActivity {

    /* renamed from: a */
    private final FinExtAttrBiz f45177a = new FinExtAttrBiz();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String string;
        String string2;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.acy_wallet_dimina);
        Bundle extras = getIntent().getExtras();
        if (extras == null || (string = extras.getString(Extend.REQUEST_BUILD_URI)) == null) {
            finish();
            return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.containerTop, WalletDiminaFragment.Companion.newInstance(string, true)).commitAllowingStateLoss();
        Bundle extras2 = getIntent().getExtras();
        String str = "";
        if (!(extras2 == null || (string2 = extras2.getString("ext")) == null)) {
            str = string2;
        }
        this.f45177a.updateExtAttrs2FinGlobalAttrs(str);
    }
}
