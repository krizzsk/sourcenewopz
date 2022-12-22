package com.didi.soda.home.topgun.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;

public class HomeNoResultRvModel implements RecyclerModel {
    public String mBgImg;
    public String mBtnText;
    public String mCateId;
    public String mPage;
    public String mSelectFilter;
    public String mSubTitle;
    public String mTitleName;
    public String recId;

    public static HomeNoResultRvModel convertDividerEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        HomeNoResultRvModel homeNoResultRvModel = new HomeNoResultRvModel();
        homeNoResultRvModel.mTitleName = str;
        homeNoResultRvModel.mSubTitle = str2;
        homeNoResultRvModel.mBgImg = str3;
        homeNoResultRvModel.mBtnText = str4;
        homeNoResultRvModel.mSelectFilter = str5;
        homeNoResultRvModel.mPage = str6;
        homeNoResultRvModel.mCateId = str7;
        homeNoResultRvModel.recId = str8;
        return homeNoResultRvModel;
    }
}
