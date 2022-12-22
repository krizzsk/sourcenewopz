package com.didi.payment.transfer.cashier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.sdk.net.C14489Util;
import com.taxis99.R;
import global.didi.pay.GlobalUniPayActivity;

public class TransferCashierActivity extends GlobalUniPayActivity {
    public static void launch(Activity activity, PayParam payParam, int i) {
        Intent intent = new Intent(activity, TransferCashierActivity.class);
        intent.putExtra("uni_pay_param", C14489Util.jsonFromObject(payParam));
        activity.startActivityForResult(intent, i);
        activity.overridePendingTransition(R.anim.trans_anim_fade_in, R.anim.trans_anim_fade_out);
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
        overridePendingTransition(R.anim.trans_anim_fade_in, R.anim.trans_anim_fade_out);
    }
}
