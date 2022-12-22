package com.didi.soda.customer.binder.abnormal.topgun;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;

public class TopGunAbnormalRvModel implements RecyclerModel {

    /* renamed from: a */
    private TopGunAbnormalViewModel f40384a;
    public int mHeight;

    public TopGunAbnormalViewModel getAbnormalVm() {
        return this.f40384a;
    }

    public void setAbnormalVm(TopGunAbnormalViewModel topGunAbnormalViewModel) {
        this.f40384a = topGunAbnormalViewModel;
    }
}
