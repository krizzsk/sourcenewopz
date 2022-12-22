package com.didichuxing.bigdata.p173dp.locsdk.biz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.biz.DriverCommonBizAdapter */
class DriverCommonBizAdapter implements C15096a {

    /* renamed from: a */
    private static final String f45745a = ".action.DRIVER_USER_STATE_CHANGED";

    /* renamed from: b */
    private static final String f45746b = ".action.DRIVER_ORDER_STATE_CHANGED";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f45747c = "";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f45748d = "";

    /* renamed from: e */
    private static final String f45749e = "user_state";

    /* renamed from: f */
    private static final String f45750f = "order_state";

    /* renamed from: g */
    private static final String f45751g = "phone";

    /* renamed from: h */
    private static final String f45752h = "order_id";

    /* renamed from: i */
    private static final int f45753i = 1;

    /* renamed from: j */
    private static final int f45754j = 0;

    /* renamed from: k */
    private static final int f45755k = 1;

    /* renamed from: l */
    private static final int f45756l = 2;

    /* renamed from: m */
    private static final int f45757m = 4;

    /* renamed from: n */
    private static final int f45758n = 5;

    /* renamed from: o */
    private static final int f45759o = 7;

    /* renamed from: p */
    private static final int f45760p = -1;

    /* renamed from: q */
    private Context f45761q;

    /* renamed from: r */
    private BizStateReceiver f45762r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public BizStateListener f45763s;

    DriverCommonBizAdapter() {
    }

    /* renamed from: a */
    public void mo114370a(Context context) {
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        this.f45761q = applicationContext;
        String packageName = applicationContext != null ? applicationContext.getPackageName() : "";
        f45747c = packageName + f45745a;
        f45748d = packageName + f45746b;
    }

    /* renamed from: a */
    public void mo114371a(BizStateListener bizStateListener) {
        this.f45763s = bizStateListener;
        if (bizStateListener != null) {
            m32766c();
        } else {
            m32767d();
        }
    }

    /* renamed from: c */
    private void m32766c() {
        if (this.f45761q != null && this.f45762r == null) {
            this.f45762r = new BizStateReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f45747c);
            intentFilter.addAction(f45748d);
            LocalBroadcastManager.getInstance(this.f45761q).registerReceiver(this.f45762r, intentFilter);
        }
    }

    /* renamed from: d */
    private void m32767d() {
        Context context = this.f45761q;
        if (context != null && this.f45762r != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f45762r);
            this.f45762r = null;
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.biz.DriverCommonBizAdapter$BizStateReceiver */
    private class BizStateReceiver extends BroadcastReceiver {
        private BizStateReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            BizState bizState = null;
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                String stringExtra = intent.getStringExtra("phone");
                String stringExtra2 = intent.getStringExtra("order_id");
                if (DriverCommonBizAdapter.f45748d.equals(action)) {
                    bizState = DriverCommonBizAdapter.this.m32763b(intent.getIntExtra(DriverCommonBizAdapter.f45750f, -1));
                } else if (DriverCommonBizAdapter.f45747c.equals(action)) {
                    bizState = DriverCommonBizAdapter.this.m32759a(intent.getIntExtra(DriverCommonBizAdapter.f45749e, -1));
                }
                if (bizState != null && DriverCommonBizAdapter.this.f45763s != null) {
                    DriverCommonBizAdapter.this.f45763s.onBizStateChanged(bizState, stringExtra, stringExtra2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public BizState m32759a(int i) {
        if (i == 0) {
            return BizState.USER_DRIVER_END_OFF;
        }
        if (i != 1) {
            return BizState.INVAILD;
        }
        return BizState.USER_DRIVER_START_OFF;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public BizState m32763b(int i) {
        if (i == 1) {
            return BizState.ORDER_PICKUP;
        }
        if (i == 2) {
            return BizState.ORDER_WAIT;
        }
        if (i == 4) {
            return BizState.ORDER_ONTRIP;
        }
        if (i == 5) {
            return BizState.ORDER_COMPLETE;
        }
        if (i != 7) {
            return BizState.INVAILD;
        }
        return BizState.ORDER_CANCEL;
    }
}
