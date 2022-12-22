package com.didi.universal.pay.sdk.method.bankPay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.sdk.apm.SystemUtils;

public class SchemeActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = new Intent();
        intent.setAction(BankPayMethod.BANKPOLLACTION);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        if (BankPayMethod.getActivity() != null) {
            startActivity(new Intent(this, BankPayMethod.getActivity().getClass()));
        }
        finish();
    }
}
