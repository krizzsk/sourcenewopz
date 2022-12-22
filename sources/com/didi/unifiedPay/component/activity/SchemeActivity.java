package com.didi.unifiedPay.component.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.UnifiedPayConstant;
import com.didi.unifiedPay.sdk.paypay.PaypayPayMethod;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;

public class SchemeActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m31504a();
        finish();
    }

    /* renamed from: a */
    private void m31504a() {
        if (getIntent() != null) {
            String scheme = getIntent().getScheme();
            if (!TextUtils.isEmpty(scheme)) {
                Intent intent = new Intent();
                char c = 65535;
                int hashCode = scheme.hashCode();
                if (hashCode != -725366248) {
                    if (hashCode != -444556060) {
                        if (hashCode == 1856177428 && scheme.equals(UnifiedPayConstant.Schemes.CASHIER_PAYPAY_GLOBAL)) {
                            c = 1;
                        }
                    } else if (scheme.equals(UnifiedPayConstant.Schemes.CASHIER_PAYPAY_SODA_USER_GLOBAL)) {
                        c = 2;
                    }
                } else if (scheme.equals(UnifiedPayConstant.Schemes.GLOBAL_DIDI_COMMON)) {
                    c = 0;
                }
                if (c == 0 || c == 1 || c == 2) {
                    intent.setAction("com.xiaojukeji.action.paypayPollAction");
                    intent.putExtra("code", m31503a(getIntent().getData()));
                    LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                    if (PaypayPayMethod.getActivity() != null) {
                        startActivity(new Intent(this, PaypayPayMethod.getActivity().getClass()));
                    }
                }
                finish();
            }
        }
    }

    /* renamed from: a */
    private int m31503a(Uri uri) {
        if (uri == null) {
            return 0;
        }
        try {
            return ((Integer) JsonUtil.json2Map(uri.getQueryParameter("response")).get("code")).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
