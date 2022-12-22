package com.didi.payment.wallet.global.wallet.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.sdk.net.C14489Util;
import com.taxis99.R;
import global.didi.pay.GlobalUniPayActivity;

public class WalletTopUpUniPayActivity extends GlobalUniPayActivity {
    public static void launch(Activity activity, PayParam payParam, int i) {
        Intent intent = new Intent(activity, WalletTopUpUniPayActivity.class);
        intent.putExtra("uni_pay_param", C14489Util.jsonFromObject(payParam));
        activity.startActivityForResult(intent, i);
        activity.overridePendingTransition(R.anim.wallet_anim_fade_in, R.anim.wallet_anim_fade_out);
    }

    public static void launchInFragment(Fragment fragment, PayParam payParam, int i) {
        if (fragment != null && fragment.getContext() != null) {
            Intent intent = new Intent(fragment.getContext(), WalletTopUpUniPayActivity.class);
            intent.putExtra("uni_pay_param", C14489Util.jsonFromObject(payParam));
            fragment.startActivityForResult(intent, i);
            if (fragment.getActivity() != null) {
                fragment.getActivity().overridePendingTransition(R.anim.wallet_anim_fade_in, R.anim.wallet_anim_fade_out);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        SystemUtil.init(this);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.transparent));
    }

    public void callStartActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    public void callStartActivity(Intent intent) {
        startActivity(intent);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.wallet_anim_fade_in, R.anim.wallet_anim_fade_out);
    }
}
