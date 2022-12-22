package com.didi.universal.pay.sdk.method.paypay;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;

@Deprecated
public class PaypaySchemeActivity extends Activity {

    /* renamed from: a */
    private static final String f45113a = "globaldidicommon";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m32387a();
        finish();
    }

    /* renamed from: a */
    private void m32387a() {
        if (getIntent() != null) {
            String scheme = getIntent().getScheme();
            if (!TextUtils.isEmpty(scheme)) {
                Intent intent = new Intent();
                char c = 65535;
                if (scheme.hashCode() == -725366248 && scheme.equals("globaldidicommon")) {
                    c = 0;
                }
                if (c == 0) {
                    intent.setAction("com.xiaojukeji.action.paypayPollAction");
                    intent.putExtra("code", m32386a(getIntent().getData()));
                    LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                }
                finish();
            }
        }
    }

    /* renamed from: a */
    private int m32386a(Uri uri) {
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
