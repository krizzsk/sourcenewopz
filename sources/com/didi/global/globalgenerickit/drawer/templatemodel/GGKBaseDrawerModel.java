package com.didi.global.globalgenerickit.drawer.templatemodel;

import android.text.TextUtils;
import android.view.View;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.callback.GGKImgModel;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import java.util.ArrayList;
import java.util.List;

public abstract class GGKBaseDrawerModel {
    private View extendedBottomView;
    private View extendedView;
    private boolean mBackPressedEnabled = true;
    private boolean mClickOutsideCanCancel = true;
    private View mExtendedUpView;
    private GGKImgModel mImgModel;
    private boolean mIsLoadingEnable = false;
    private GGKBtnTextAndCallback mMajorBtnTextAndCallback;
    private List<GGKBtnTextAndCallback> mMinorTextAndCallbacks = new ArrayList();
    private String mSubTitle;
    private String mTitle;
    private String trackId;

    /* access modifiers changed from: protected */
    public abstract GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel);

    public GGKBaseDrawerModel setExtendedView(View view) {
        this.extendedView = view;
        return this;
    }

    public View getExtendedView() {
        return this.extendedView;
    }

    public View getExtendedUpView() {
        return this.mExtendedUpView;
    }

    public GGKBaseDrawerModel setExtendedUpView(View view) {
        this.mExtendedUpView = view;
        return this;
    }

    public View getExtendedBottomView() {
        return this.extendedBottomView;
    }

    public GGKBaseDrawerModel setExtendedBottomView(View view) {
        this.extendedBottomView = view;
        return this;
    }

    public GGKBaseDrawerModel(String str, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        this.mTitle = str;
        this.mMajorBtnTextAndCallback = gGKBtnTextAndCallback;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public GGKBtnTextAndCallback getMajorBtnTextAndCallback() {
        return this.mMajorBtnTextAndCallback;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public GGKBaseDrawerModel setSubTitle(String str) {
        this.mSubTitle = str;
        return this;
    }

    public List<GGKBtnTextAndCallback> getMinorTextAndCallbacks() {
        return this.mMinorTextAndCallbacks;
    }

    public GGKBaseDrawerModel addMinorBtn(GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        this.mMinorTextAndCallbacks.add(gGKBtnTextAndCallback);
        return this;
    }

    public GGKImgModel getImgModel() {
        return this.mImgModel;
    }

    public GGKBaseDrawerModel setImgModel(GGKImgModel gGKImgModel) {
        this.mImgModel = gGKImgModel;
        return this;
    }

    public boolean getClickOutsideCanCancel() {
        return this.mClickOutsideCanCancel;
    }

    public GGKBaseDrawerModel setClickOutsideCanCancel(boolean z) {
        this.mClickOutsideCanCancel = z;
        return this;
    }

    public boolean isLoadingEnable() {
        return this.mIsLoadingEnable;
    }

    public GGKBaseDrawerModel setIsLoadingEnable(boolean z) {
        this.mIsLoadingEnable = z;
        return this;
    }

    public GGKDrawerModel convert() {
        GGKDrawerModel gGKDrawerModel = new GGKDrawerModel();
        setTitleMajorAndCanConfig(gGKDrawerModel);
        return convertOthers(gGKDrawerModel);
    }

    private void setTitleMajorAndCanConfig(GGKDrawerModel gGKDrawerModel) {
        GGKDrawerModel.WidgetModel widgetModel = new GGKDrawerModel.WidgetModel();
        widgetModel.text = getTitle();
        gGKDrawerModel.title = widgetModel;
        if (!TextUtils.isEmpty(getSubTitle())) {
            GGKDrawerModel.WidgetModel widgetModel2 = new GGKDrawerModel.WidgetModel();
            widgetModel2.text = getSubTitle();
            gGKDrawerModel.subTitle = widgetModel2;
        }
        gGKDrawerModel.majorBtn = getMajorBtnTextAndCallback();
        if (getMinorTextAndCallbacks().size() > 0) {
            gGKDrawerModel.minorBtns = getMinorTextAndCallbacks();
        }
        GGKImgModel imgModel = getImgModel();
        if (imgModel != null && (!TextUtils.isEmpty(imgModel.getImgUrl()) || imgModel.getImgResId() != 0)) {
            if (!TextUtils.isEmpty(imgModel.getImgUrl())) {
                gGKDrawerModel.imgUrl = imgModel.getImgUrl();
            } else if (imgModel.getImgResId() != 0) {
                gGKDrawerModel.imgResId = imgModel.getImgResId();
            }
        }
        if (!(imgModel == null || imgModel.getImgPlaceHolder() == 0)) {
            gGKDrawerModel.imgPlaceHolder = imgModel.getImgPlaceHolder();
        }
        gGKDrawerModel.clickOutsideCanCancel = getClickOutsideCanCancel();
        gGKDrawerModel.backPressedEnabled = ismBackPressedEnabled();
        gGKDrawerModel.isLoadingEnable = isLoadingEnable();
        if (getExtendedUpView() != null) {
            gGKDrawerModel.extendedUpView = getExtendedUpView();
        }
        if (getExtendedBottomView() != null) {
            gGKDrawerModel.extendedBottomView = getExtendedBottomView();
        }
        if (getExtendedView() != null) {
            gGKDrawerModel.extendedView = getExtendedView();
        }
    }

    public boolean ismBackPressedEnabled() {
        return this.mBackPressedEnabled;
    }

    public void setmBackPressedEnabled(boolean z) {
        this.mBackPressedEnabled = z;
    }

    public String getTrackId() {
        return this.trackId;
    }

    public void setTrackId(String str) {
        this.trackId = str;
    }
}
