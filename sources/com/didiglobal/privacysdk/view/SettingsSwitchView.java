package com.didiglobal.privacysdk.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didiglobal.privacysdk.GlobalPrivacySDK;
import com.taxis99.R;

public class SettingsSwitchView extends RelativeLayout {

    /* renamed from: a */
    private TextView f50702a;

    /* renamed from: b */
    private TextView f50703b;

    /* renamed from: c */
    private SwitchCompat f50704c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f50705d = false;

    /* renamed from: e */
    private View f50706e;

    public SettingsSwitchView(Context context) {
        super(context);
        m36394a(context);
    }

    public SettingsSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m36394a(context);
    }

    public SettingsSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m36394a(context);
    }

    /* renamed from: a */
    private void m36394a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.global_privacy_setting_switch_layout, this, true);
        this.f50702a = (TextView) findViewById(R.id.title);
        if (GlobalPrivacySDK.isItemTitleBold()) {
            this.f50702a.setTypeface(Typeface.DEFAULT_BOLD);
        }
        this.f50703b = (TextView) findViewById(R.id.description);
        this.f50704c = (SwitchCompat) findViewById(R.id.switcher);
        this.f50706e = findViewById(R.id.divider);
    }

    public void setTitle(String str) {
        if (this.f50702a != null && !TextUtils.isEmpty(str)) {
            this.f50702a.setText(str);
            this.f50702a.setVisibility(0);
        }
    }

    public void setSwitchColor(int i) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.global_privacy_switch_didi_track_on);
        gradientDrawable.setColor(i);
        stateListDrawable.addState(new int[]{16842912}, gradientDrawable);
        stateListDrawable.addState(new int[0], getResources().getDrawable(R.drawable.global_privacy_switch_didi_track_off));
        this.f50704c.setTrackDrawable(stateListDrawable);
    }

    public void setOnCheckedChangeListener(final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        SwitchCompat switchCompat = this.f50704c;
        if (switchCompat != null) {
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (SettingsSwitchView.this.f50705d) {
                        boolean unused = SettingsSwitchView.this.f50705d = false;
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
        SwitchCompat switchCompat = this.f50704c;
        if (switchCompat != null) {
            if (z != switchCompat.isChecked()) {
                this.f50705d = true;
            }
            this.f50704c.setChecked(z);
        }
    }

    public boolean isChecked() {
        SwitchCompat switchCompat = this.f50704c;
        if (switchCompat != null) {
            return switchCompat.isChecked();
        }
        return false;
    }

    public void setDescText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f50703b.setText(charSequence);
            this.f50703b.setVisibility(0);
        }
    }

    public void setDescBackgroundColor(int i) {
        this.f50703b.setBackgroundColor(i);
    }

    public void setSwitchVisibility(int i) {
        this.f50704c.setVisibility(i);
    }

    public void setDescVisibility(int i) {
        this.f50703b.setVisibility(i);
    }

    public void setDividerVisibility(int i) {
        this.f50706e.setVisibility(i);
    }
}
