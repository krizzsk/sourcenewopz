package com.didi.component.comp_flex.automatic_match;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.IView;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class AutomaticMatchView implements IView<AutomaticMatchPresenter> {

    /* renamed from: a */
    private View f12137a;

    /* renamed from: b */
    private Context f12138b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AutomaticMatchPresenter f12139c;

    /* renamed from: d */
    private TextView f12140d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SwitchCompat f12141e;

    /* renamed from: f */
    private final Logger f12142f = LoggerFactory.getLogger("AutomaticMatchView");

    /* renamed from: g */
    private CompoundButton.OnCheckedChangeListener f12143g = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AutoTrackHelper.trackViewOnClick(compoundButton, z);
            AutomaticMatchView automaticMatchView = AutomaticMatchView.this;
            automaticMatchView.m8209a("switchBtn ischecked " + z);
            AutomaticMatchView.this.f12141e.setEnabled(false);
            AutomaticMatchView.this.f12139c.onCheckedChanged(z);
            HashMap hashMap = new HashMap();
            hashMap.put("k", "click");
            hashMap.put(RavenKey.VERSION, "autopick");
            hashMap.put("style", Integer.valueOf(z ? 1 : 2));
            GlobalOmegaUtils.trackEvent("ibt_gp_wait_autopick_ck", (Map<String, Object>) hashMap);
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8209a(String str) {
        this.f12142f.info(str, new Object[0]);
    }

    public AutomaticMatchView(Context context, ViewGroup viewGroup) {
        this.f12138b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.flex_automatic_match_layout, viewGroup, false);
        this.f12137a = inflate;
        this.f12140d = (TextView) inflate.findViewById(R.id.title_text);
        this.f12141e = (SwitchCompat) this.f12137a.findViewById(R.id.automatic_match_switcher);
    }

    public View getView() {
        return this.f12137a;
    }

    public void setPresenter(AutomaticMatchPresenter automaticMatchPresenter) {
        this.f12139c = automaticMatchPresenter;
    }

    public void update(AutomaticMatchModel automaticMatchModel) {
        if (automaticMatchModel != null) {
            boolean z = true;
            this.f12141e.setEnabled(true);
            automaticMatchModel.title.bindTextView(this.f12140d);
            if (automaticMatchModel.toggle != 1) {
                z = false;
            }
            resetSwitchChecked(z);
            HashMap hashMap = new HashMap();
            hashMap.put("k", "show");
            hashMap.put(RavenKey.VERSION, "autopick");
            GlobalOmegaUtils.trackEvent("ibt_gp_wait_autopick_sw", (Map<String, Object>) hashMap);
        }
    }

    public void updateSwitchBtnEnable(boolean z) {
        this.f12141e.setEnabled(z);
    }

    public void resetSwitchChecked(boolean z) {
        this.f12141e.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        if (this.f12141e.isChecked() != z) {
            this.f12141e.setChecked(z);
        }
        this.f12141e.setOnCheckedChangeListener(this.f12143g);
    }
}
