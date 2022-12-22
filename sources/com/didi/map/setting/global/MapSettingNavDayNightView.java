package com.didi.map.setting.global;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.IMapSettingPreferences;
import com.didi.map.setting.common.MapSettingFactory;
import com.taxis99.R;

public class MapSettingNavDayNightView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private TextView f28956a;

    /* renamed from: b */
    private TextView f28957b;

    /* renamed from: c */
    private TextView f28958c;

    /* renamed from: d */
    private IMapSettingPreferences f28959d;

    /* renamed from: e */
    private int f28960e;

    public MapSettingNavDayNightView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MapSettingNavDayNightView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapSettingNavDayNightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28960e = -1;
        m20374a();
    }

    /* renamed from: a */
    private void m20374a() {
        LayoutInflater.from(getContext()).inflate(R.layout.map_setting_nav_day_night_layout, this);
        this.f28956a = (TextView) findViewById(R.id.map_setting_nav_day_night_mode_auto);
        this.f28957b = (TextView) findViewById(R.id.map_setting_nav_day_night_mode_day);
        this.f28958c = (TextView) findViewById(R.id.map_setting_nav_day_night_mode_night);
        this.f28956a.setOnClickListener(this);
        this.f28957b.setOnClickListener(this);
        this.f28958c.setOnClickListener(this);
        IMapSettingPreferences createMapPreferences = MapSettingFactory.createMapPreferences(getContext());
        this.f28959d = createMapPreferences;
        int navDayNightMode = createMapPreferences.getNavDayNightMode();
        this.f28956a.setSelected(false);
        this.f28957b.setSelected(false);
        this.f28958c.setSelected(false);
        if (navDayNightMode == 0) {
            this.f28956a.setSelected(true);
        } else if (navDayNightMode == 1) {
            this.f28957b.setSelected(true);
        } else if (navDayNightMode == 2) {
            this.f28958c.setSelected(true);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view == this.f28956a) {
            setDayNightMode(0);
        } else if (view == this.f28957b) {
            setDayNightMode(1);
        } else if (view == this.f28958c) {
            setDayNightMode(2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:3|(3:5|6|7)(4:(1:10)(2:11|(1:13))|15|16|18)|14|15|16|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        if (com.didichuxing.nightmode.sdk.NightModeState.DAY != com.didichuxing.nightmode.sdk.NightModeManager.getInstance(getContext()).getNightModeState()) goto L_0x0045;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setDayNightMode(int r4) {
        /*
            r3 = this;
            int r0 = r3.f28960e
            if (r0 != r4) goto L_0x0005
            return
        L_0x0005:
            r3.f28960e = r4
            com.didi.map.setting.common.IMapSettingPreferences r0 = r3.f28959d
            r0.setNavDayNightMode(r4)
            android.widget.TextView r0 = r3.f28956a
            r1 = 0
            r0.setSelected(r1)
            android.widget.TextView r0 = r3.f28957b
            r0.setSelected(r1)
            android.widget.TextView r0 = r3.f28958c
            r0.setSelected(r1)
            r0 = 1
            if (r4 != 0) goto L_0x0035
            android.widget.TextView r4 = r3.f28956a
            r4.setSelected(r0)
            com.didichuxing.nightmode.sdk.NightModeState r4 = com.didichuxing.nightmode.sdk.NightModeState.DAY     // Catch:{ all -> 0x0046 }
            android.content.Context r2 = r3.getContext()     // Catch:{ all -> 0x0046 }
            com.didichuxing.nightmode.sdk.NightModeManager r2 = com.didichuxing.nightmode.sdk.NightModeManager.getInstance(r2)     // Catch:{ all -> 0x0046 }
            com.didichuxing.nightmode.sdk.NightModeState r2 = r2.getNightModeState()     // Catch:{ all -> 0x0046 }
            if (r4 == r2) goto L_0x0046
            goto L_0x0045
        L_0x0035:
            if (r4 != r0) goto L_0x003d
            android.widget.TextView r4 = r3.f28957b
            r4.setSelected(r0)
            goto L_0x0046
        L_0x003d:
            r2 = 2
            if (r4 != r2) goto L_0x0046
            android.widget.TextView r4 = r3.f28958c
            r4.setSelected(r0)
        L_0x0045:
            r1 = 1
        L_0x0046:
            android.content.Context r4 = r3.getContext()     // Catch:{ all -> 0x0051 }
            com.didichuxing.nightmode.sdk.NightModeManager r4 = com.didichuxing.nightmode.sdk.NightModeManager.getInstance(r4)     // Catch:{ all -> 0x0051 }
            r4.onOrderStageChanged(r1)     // Catch:{ all -> 0x0051 }
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.setting.global.MapSettingNavDayNightView.setDayNightMode(int):void");
    }
}
