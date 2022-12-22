package com.didi.entrega.home.component.city.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.mark.StickyHeader;

public class HomeCityTitleRvModel implements RecyclerModel, StickyHeader {
    public String mCountryName;

    public HomeCityTitleRvModel(String str) {
        this.mCountryName = str;
    }
}
