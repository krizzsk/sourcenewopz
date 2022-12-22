package com.didi.component.business.data.form;

import com.didi.component.business.data.form.listener.CommonListener;
import com.didi.component.business.data.form.listener.ConfirmGetListener;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.data.form.listener.HomeListener;
import com.didi.component.business.data.form.listener.TripListener;

public class PageCompDataTransfer {

    /* renamed from: a */
    private CommonListener f11285a;

    /* renamed from: b */
    private HomeListener f11286b;

    /* renamed from: c */
    private ConfirmListener f11287c;

    /* renamed from: d */
    private ConfirmGetListener f11288d;

    /* renamed from: e */
    private TripListener f11289e;

    private PageCompDataTransfer() {
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final PageCompDataTransfer INSTANCE = new PageCompDataTransfer();

        private SingletonHolder() {
        }
    }

    public static PageCompDataTransfer getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void setHomeListener(HomeListener homeListener) {
        this.f11286b = homeListener;
    }

    public HomeListener getHomeListener() {
        return this.f11286b;
    }

    public void setConfirmListener(ConfirmListener confirmListener) {
        this.f11287c = confirmListener;
    }

    public ConfirmListener getConfirmListener() {
        return this.f11287c;
    }

    public ConfirmGetListener getConfirmGetListener() {
        return this.f11288d;
    }

    public void setConfirmGetListener(ConfirmGetListener confirmGetListener) {
        this.f11288d = confirmGetListener;
    }

    public void setTripListener(TripListener tripListener) {
        this.f11289e = tripListener;
    }

    public TripListener getTripListener() {
        return this.f11289e;
    }

    public CommonListener getCommonListener() {
        return this.f11285a;
    }

    public void setCommonListener(CommonListener commonListener) {
        this.f11285a = commonListener;
    }
}
