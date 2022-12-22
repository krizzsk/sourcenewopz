package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class SettingsSwitchView extends RelativeLayout {

    /* renamed from: a */
    private TextView f37495a;

    /* renamed from: b */
    private TextView f37496b;

    /* renamed from: c */
    private Switch f37497c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f37498d = false;

    public SettingsSwitchView(Context context) {
        super(context);
        m26620a(context);
    }

    public SettingsSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26620a(context);
    }

    public SettingsSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26620a(context);
    }

    /* renamed from: a */
    private void m26620a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.setting_switch_layout, this, true);
        this.f37495a = (TextView) findViewById(R.id.title);
        this.f37496b = (TextView) findViewById(R.id.subtitle);
        this.f37497c = (Switch) findViewById(R.id.switcher);
    }

    public void setTitle(String str) {
        if (this.f37495a != null && !TextUtils.isEmpty(str)) {
            this.f37495a.setText(str);
            this.f37495a.setVisibility(0);
        }
    }

    public void setSubTitle(String str) {
        if (this.f37496b != null && !TextUtils.isEmpty(str)) {
            this.f37496b.setText(str);
            this.f37496b.setVisibility(0);
        }
    }

    public void setOnCheckedChangeListener(final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch switchR = this.f37497c;
        if (switchR != null) {
            switchR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (SettingsSwitchView.this.f37498d) {
                        boolean unused = SettingsSwitchView.this.f37498d = false;
                        return;
                    }
                    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = onCheckedChangeListener;
                    if (onCheckedChangeListener != null) {
                        onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                    }
                }
            });
        }
    }

    public void setChecked(boolean z) {
        Switch switchR = this.f37497c;
        if (switchR != null) {
            if (z != switchR.isChecked()) {
                this.f37498d = true;
            }
            this.f37497c.setChecked(z);
        }
    }
}
