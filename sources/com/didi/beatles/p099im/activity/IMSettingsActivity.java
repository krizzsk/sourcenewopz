package com.didi.beatles.p099im.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.notify.NotificationUtils;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.beatles.p099im.views.titlebar.CommonTitleBar;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.activity.IMSettingsActivity */
public class IMSettingsActivity extends IMBaseActivity implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f9019a = IMSettingsActivity.class.getSimpleName();

    /* renamed from: f */
    private static final String f9020f = "page_from";

    /* renamed from: b */
    private CommonTitleBar f9021b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f9022c;

    /* renamed from: d */
    private TextView f9023d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ImageView f9024e;

    /* renamed from: g */
    private int f9025g = -1;

    public static void startActivity(Context context, int i) {
        Intent intent = new Intent(context, IMSettingsActivity.class);
        intent.putExtra(f9020f, i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        setContentView((int) R.layout.activity_im_settings);
        m6130b();
        m6132d();
        IMTraceUtil.addBusinessEvent("ddim_setting_sw").add("from", Integer.valueOf(this.f9025g)).report();
    }

    /* renamed from: b */
    private void m6130b() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f9025g = intent.getIntExtra(f9020f, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m6131c();
    }

    /* renamed from: c */
    private void m6131c() {
        NotificationUtils.isNotificationEnabled(this, new NotificationUtils.OnIMNotificationEnableCallback() {
            public void onNotificationEnabled(boolean z) {
                IMLog.m6631d(IMSettingsActivity.f9019a, C4234I.m6591t("[onNotificationEnabled] #refreshNotificationSwitch# enable=", Boolean.valueOf(z)));
                if (z) {
                    IMSettingsActivity.this.f9022c.setText(IMSettingsActivity.this.getString(R.string.im_new_msg_notification_open));
                    IMSettingsActivity.this.f9024e.setVisibility(8);
                    return;
                }
                IMSettingsActivity.this.f9022c.setText(IMSettingsActivity.this.getString(R.string.im_new_msg_notification_unopen));
                IMSettingsActivity.this.f9024e.setVisibility(0);
            }
        });
    }

    /* renamed from: d */
    private void m6132d() {
        this.f9021b = (CommonTitleBar) findViewById(R.id.settings_title_bar);
        this.f9022c = (TextView) findViewById(R.id.tv_notification_switch);
        this.f9023d = (TextView) findViewById(R.id.tv_notification_title);
        this.f9024e = (ImageView) findViewById(R.id.iv_notification_red_dot);
        this.f9021b.setTitle(getString(R.string.im_msg_settings));
        this.f9021b.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMSettingsActivity.this.finish();
            }
        });
        this.f9023d.setText(getString(R.string.im_new_msg_notification_settings));
        this.f9022c.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.tv_notification_switch) {
            m6133e();
        }
    }

    /* renamed from: e */
    private void m6133e() {
        IMTraceUtil.addBusinessEvent("ddim_setting_newnotice_ck").report();
        NotificationUtils.isNotificationEnabled(this, new NotificationUtils.OnIMNotificationEnableCallback() {
            public void onNotificationEnabled(boolean z) {
                IMLog.m6631d(IMSettingsActivity.f9019a, C4234I.m6591t("[onNotificationEnabled] #openNotificationSettings# enable=", Boolean.valueOf(z)));
                NotificationUtils.openNotificationSettings(IMSettingsActivity.this);
            }
        });
    }

    /* renamed from: a */
    private void m6128a(String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) "", 0);
        if (Build.VERSION.SDK_INT < 14) {
            makeText.cancel();
        }
        SystemUtils.showToast(makeText);
        IMTipsToast.setIcon(makeText, IMResource.getDrawableID(R.drawable.im_toast_warm));
        IMTipsToast.setText(makeText, str);
    }
}
