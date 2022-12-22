package com.didi.soda.home.topgun.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;

public class HomeBusinessDividerRvModel implements RecyclerModel {
    public String mDividerName;

    public static HomeBusinessDividerRvModel convertDividerEntity(String str) {
        HomeBusinessDividerRvModel homeBusinessDividerRvModel = new HomeBusinessDividerRvModel();
        homeBusinessDividerRvModel.mDividerName = str;
        return homeBusinessDividerRvModel;
    }
}
