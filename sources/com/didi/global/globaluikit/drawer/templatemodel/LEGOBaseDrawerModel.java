package com.didi.global.globaluikit.drawer.templatemodel;

import android.text.TextUtils;
import android.view.View;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOImgModel;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGOBtnModelAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerDismissListener;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import java.util.ArrayList;
import java.util.List;

public abstract class LEGOBaseDrawerModel {
    private LEGODrawerDismissListener dismissListener;
    private int drawerStyle;
    private View extendedBottomView;
    private boolean isShowCloseImg;
    private boolean mBackPressedEnabled = true;
    private boolean mClickOutsideCanCancel = true;
    private LEGOOnAntiShakeClickListener mCloseImgListener;
    private View mExtendedUpView;
    private View mExtendedView;
    private LEGOImgModel mImgModel;
    private boolean mIsLoadingEnable = false;
    private LEGOBtnTextAndCallback mMajorBtnTextAndCallback;
    private List<LEGOBtnTextAndCallback> mMinorTextAndCallbacks = new ArrayList();
    private String mSubTitle;
    private String mTitle;
    private String trackId;

    /* access modifiers changed from: protected */
    public abstract LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel);

    public View getExtendedView() {
        return this.mExtendedView;
    }

    public LEGOBaseDrawerModel setExtendedView(View view) {
        this.mExtendedView = view;
        return this;
    }

    public View getExtendedUpView() {
        return this.mExtendedUpView;
    }

    public LEGOBaseDrawerModel setExtendedUpView(View view) {
        this.mExtendedUpView = view;
        return this;
    }

    public View getExtendedBottomView() {
        return this.extendedBottomView;
    }

    public LEGOBaseDrawerModel setExtendedBottomView(View view) {
        this.extendedBottomView = view;
        return this;
    }

    public LEGOBaseDrawerModel(String str, LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        this.mTitle = str;
        this.mMajorBtnTextAndCallback = lEGOBtnTextAndCallback;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public LEGOBtnTextAndCallback getMajorBtnTextAndCallback() {
        return this.mMajorBtnTextAndCallback;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public LEGOBaseDrawerModel setSubTitle(String str) {
        this.mSubTitle = str;
        return this;
    }

    public List<LEGOBtnTextAndCallback> getMinorTextAndCallbacks() {
        return this.mMinorTextAndCallbacks;
    }

    public LEGOBaseDrawerModel addMinorBtn(LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        this.mMinorTextAndCallbacks.add(lEGOBtnTextAndCallback);
        return this;
    }

    public LEGOImgModel getImgModel() {
        return this.mImgModel;
    }

    public LEGOBaseDrawerModel setImgModel(LEGOImgModel lEGOImgModel) {
        this.mImgModel = lEGOImgModel;
        return this;
    }

    public boolean getClickOutsideCanCancel() {
        return this.mClickOutsideCanCancel;
    }

    public LEGOBaseDrawerModel setClickOutsideCanCancel(boolean z) {
        this.mClickOutsideCanCancel = z;
        return this;
    }

    public LEGOOnAntiShakeClickListener getCloseImgListener() {
        return this.mCloseImgListener;
    }

    public LEGOBaseDrawerModel setShowCloseImgListener(LEGOOnAntiShakeClickListener lEGOOnAntiShakeClickListener) {
        this.mCloseImgListener = lEGOOnAntiShakeClickListener;
        return this;
    }

    public LEGOBaseDrawerModel setIsShowCloseImg(boolean z) {
        this.isShowCloseImg = z;
        return this;
    }

    public boolean getIsShowCloseImg() {
        return this.isShowCloseImg;
    }

    public boolean isLoadingEnable() {
        return this.mIsLoadingEnable;
    }

    private LEGOBaseDrawerModel setIsLoadingEnable(boolean z) {
        this.mIsLoadingEnable = z;
        return this;
    }

    public LEGODrawerModel convert() {
        LEGODrawerModel lEGODrawerModel = new LEGODrawerModel();
        setTitleMajorAndCanConfig(lEGODrawerModel);
        return convertOthers(lEGODrawerModel);
    }

    private void setTitleMajorAndCanConfig(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = getTitle();
        lEGODrawerModel.title = widgetModel;
        if (!TextUtils.isEmpty(getSubTitle())) {
            LEGODrawerModel.WidgetModel widgetModel2 = new LEGODrawerModel.WidgetModel();
            widgetModel2.text = getSubTitle();
            lEGODrawerModel.subTitle = widgetModel2;
        }
        LEGOBtnModelAndCallback lEGOBtnModelAndCallback = new LEGOBtnModelAndCallback();
        LEGODrawerModel.WidgetModel widgetModel3 = new LEGODrawerModel.WidgetModel();
        widgetModel3.text = getMajorBtnTextAndCallback().getText();
        lEGOBtnModelAndCallback.btnModel = widgetModel3;
        lEGOBtnModelAndCallback.listener = getMajorBtnTextAndCallback().getListener();
        lEGODrawerModel.majorBtn = lEGOBtnModelAndCallback;
        if (getMinorTextAndCallbacks().size() > 0) {
            lEGODrawerModel.minorBtns = new ArrayList();
            for (LEGOBtnTextAndCallback next : getMinorTextAndCallbacks()) {
                LEGOBtnModelAndCallback lEGOBtnModelAndCallback2 = new LEGOBtnModelAndCallback();
                LEGODrawerModel.WidgetModel widgetModel4 = new LEGODrawerModel.WidgetModel();
                widgetModel4.text = next.getText();
                lEGOBtnModelAndCallback2.btnModel = widgetModel4;
                lEGOBtnModelAndCallback2.listener = next.getListener();
                lEGODrawerModel.minorBtns.add(lEGOBtnModelAndCallback2);
            }
        }
        LEGOImgModel imgModel = getImgModel();
        if (imgModel != null && (!TextUtils.isEmpty(imgModel.getImgUrl()) || imgModel.getImgResId() != 0)) {
            if (!TextUtils.isEmpty(imgModel.getImgUrl())) {
                lEGODrawerModel.imgUrl = imgModel.getImgUrl();
            } else if (imgModel.getImgResId() != 0) {
                lEGODrawerModel.imgResId = imgModel.getImgResId();
            }
        }
        if (!(imgModel == null || imgModel.getImgPlaceHolder() == 0)) {
            lEGODrawerModel.imgPlaceHolder = imgModel.getImgPlaceHolder();
        }
        lEGODrawerModel.clickOutsideCanCancel = getClickOutsideCanCancel();
        lEGODrawerModel.backPressedEnabled = ismBackPressedEnabled();
        lEGODrawerModel.isLoadingEnable = isLoadingEnable();
        if (getExtendedUpView() != null) {
            lEGODrawerModel.extendedUpView = getExtendedUpView();
        }
        if (getExtendedBottomView() != null) {
            lEGODrawerModel.extendedBottomView = getExtendedBottomView();
        }
        if (getExtendedView() != null) {
            lEGODrawerModel.extendedView = getExtendedView();
        }
        lEGODrawerModel.isShowCloseImg = getIsShowCloseImg();
        lEGODrawerModel.mCloseImgListener = getCloseImgListener();
        lEGODrawerModel.dismissListener = getDismissListener();
        lEGODrawerModel.drawerStyle = getDrawerStyle();
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

    public LEGODrawerDismissListener getDismissListener() {
        return this.dismissListener;
    }

    public void setDismissListener(LEGODrawerDismissListener lEGODrawerDismissListener) {
        this.dismissListener = lEGODrawerDismissListener;
    }

    public int getDrawerStyle() {
        return this.drawerStyle;
    }

    public void setDrawerStyle(int i) {
        this.drawerStyle = i;
    }
}
