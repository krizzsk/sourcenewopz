package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class SettingsSwitchItemView extends ComponentView {

    /* renamed from: a */
    private View f37491a;

    /* renamed from: b */
    private TextView f37492b;

    /* renamed from: c */
    private SwitchCompat f37493c;

    /* renamed from: d */
    private TextView f37494d;

    public SettingsSwitchItemView(Context context) {
        super(context);
    }

    public View createView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.settings_switch_item, (ViewGroup) null);
        this.f37491a = inflate;
        this.f37492b = (TextView) inflate.findViewById(R.id.title);
        SwitchCompat switchCompat = (SwitchCompat) this.f37491a.findViewById(R.id.switcher);
        this.f37493c = switchCompat;
        switchCompat.setClickable(false);
        this.f37493c.setVisibility(8);
        this.f37494d = (TextView) this.f37491a.findViewById(R.id.subtitle);
        return this.f37491a;
    }

    public View getView() {
        return this.f37491a;
    }

    public void setName(String str) {
        super.setName(str);
        this.f37492b.setText(str);
    }

    public void setSubtitle(String str) {
        TextView textView = this.f37494d;
        if (textView != null) {
            textView.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            if (!TextUtils.isEmpty(str)) {
                this.f37494d.setText(str);
            }
        }
    }

    public void setSwitchVisible(boolean z) {
        this.f37493c.setVisibility(z ? 0 : 8);
    }

    public boolean isSwitchVisible() {
        return this.f37493c.getVisibility() == 0;
    }

    public void setSwitchBtn(boolean z) {
        this.f37493c.setChecked(z);
    }

    public boolean isChecked() {
        return this.f37493c.isChecked();
    }

    public void setCheckable(boolean z) {
        this.f37493c.setClickable(z);
    }

    public void setOnCheckedChangeListener(final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        SwitchCompat switchCompat = this.f37493c;
        if (switchCompat != null) {
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = onCheckedChangeListener;
                    if (onCheckedChangeListener != null) {
                        onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                    }
                }
            });
        }
    }
}
