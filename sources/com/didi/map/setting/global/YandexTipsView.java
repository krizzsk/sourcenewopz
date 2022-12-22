package com.didi.map.setting.global;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.IMapSettingPreferences;
import com.didi.map.setting.common.MapSettingFactory;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.taxis99.R;

public class YandexTipsView {

    /* renamed from: a */
    private IMapSettingPreferences f29011a;

    /* renamed from: b */
    private Context f29012b;

    /* renamed from: c */
    private ViewGroup f29013c;

    /* renamed from: d */
    private View f29014d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View.OnClickListener f29015e;

    public YandexTipsView(Context context) {
        this.f29012b = context;
        this.f29011a = MapSettingFactory.createMapPreferences(context);
    }

    public void setParentView(ViewGroup viewGroup) {
        this.f29013c = viewGroup;
    }

    public void setOkClickListener(View.OnClickListener onClickListener) {
        this.f29015e = onClickListener;
    }

    public boolean show(String str) {
        if (this.f29013c == null) {
            Context context = this.f29012b;
            if (context instanceof Activity) {
                this.f29013c = (ViewGroup) ((Activity) context).getWindow().getDecorView();
            }
        }
        if (this.f29013c == null) {
            return false;
        }
        if (this.f29014d != null) {
            return true;
        }
        if (this.f29011a == null) {
            this.f29011a = MapSettingFactory.createMapPreferences(this.f29012b);
        }
        if (MapSettingNavConstant.YANDEX_NAV.equals(str)) {
            if (this.f29011a.hasShowYandexNavTipsInOrder()) {
                return false;
            }
            this.f29011a.setShowYandexNavTipsInOrder(true);
        } else if (MapSettingNavConstant.YANDEX_MAP.equals(str)) {
            if (this.f29011a.hasShowYandexMapTipsInOrder()) {
                return false;
            }
            this.f29011a.setShowYandexMapTipsInOrder(true);
        }
        if (this.f29014d == null) {
            View inflate = LayoutInflater.from(this.f29013c.getContext()).inflate(R.layout.map_setting_yandex_tip_view, (ViewGroup) null);
            this.f29014d = inflate;
            inflate.findViewById(R.id.yandex_tip_confirm_btn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    YandexTipsView.this.m20420a();
                    if (YandexTipsView.this.f29015e != null) {
                        YandexTipsView.this.f29015e.onClick(view);
                    }
                }
            });
        }
        this.f29013c.addView(this.f29014d, new ViewGroup.LayoutParams(-1, -1));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20420a() {
        View view;
        ViewGroup viewGroup = this.f29013c;
        if (viewGroup != null && (view = this.f29014d) != null) {
            viewGroup.removeView(view);
            this.f29014d = null;
        }
    }
}
