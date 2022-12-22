package com.didi.android.comp_xbanner.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.android.comp_xbanner.AbsGlobalXBannerPresenter;
import com.didi.android.comp_xbanner.IGlobalXBannerView;
import com.didi.global.xbanner.view.base.XBannerView;
import com.taxis99.R;

public class GlobalHomeXBannerView implements IGlobalXBannerView {

    /* renamed from: a */
    private View f8123a;

    /* renamed from: b */
    private AbsGlobalXBannerPresenter f8124b;

    /* renamed from: c */
    private XBannerView f8125c;

    public GlobalHomeXBannerView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_home_xbanner_layout, (ViewGroup) null);
        this.f8123a = inflate;
        this.f8125c = (XBannerView) inflate.findViewById(R.id.xbanner);
    }

    public View getView() {
        return this.f8123a;
    }

    public void setPresenter(AbsGlobalXBannerPresenter absGlobalXBannerPresenter) {
        this.f8124b = absGlobalXBannerPresenter;
    }

    public void setTranslationY(int i) {
        View view = this.f8123a;
        if (view != null) {
            view.setTranslationY((float) i);
        }
    }

    public XBannerView getXBannerView() {
        return this.f8125c;
    }
}
