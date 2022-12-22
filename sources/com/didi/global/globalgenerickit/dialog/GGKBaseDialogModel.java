package com.didi.global.globalgenerickit.dialog;

import android.text.TextUtils;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.callback.GGKImgModel;
import java.util.ArrayList;
import java.util.List;

public abstract class GGKBaseDialogModel {

    /* renamed from: a */
    private List<GGKBtnTextAndCallback> f22059a = new ArrayList();

    /* renamed from: b */
    private String f22060b;

    /* renamed from: c */
    private int f22061c;

    /* renamed from: d */
    private int f22062d;

    /* access modifiers changed from: protected */
    public abstract void convertOthers(GGKRealUsedModel gGKRealUsedModel);

    public GGKBaseDialogModel(GGKBtnTextAndCallback... gGKBtnTextAndCallbackArr) {
        if (gGKBtnTextAndCallbackArr != null) {
            for (GGKBtnTextAndCallback add : gGKBtnTextAndCallbackArr) {
                this.f22059a.add(add);
            }
        }
    }

    public GGKBaseDialogModel(List<GGKBtnTextAndCallback> list) {
        if (list != null) {
            for (GGKBtnTextAndCallback add : list) {
                this.f22059a.add(add);
            }
        }
    }

    public GGKBaseDialogModel addMinorBtn(GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        this.f22059a.add(gGKBtnTextAndCallback);
        return this;
    }

    public List<GGKBtnTextAndCallback> getBtns() {
        return this.f22059a;
    }

    public String getImageUrl() {
        return this.f22060b;
    }

    public GGKBaseDialogModel setImageUrl(String str) {
        this.f22060b = str;
        return this;
    }

    public int getImageResId() {
        return this.f22061c;
    }

    public GGKBaseDialogModel setImageResId(int i) {
        this.f22061c = i;
        return this;
    }

    public int getImgPlaceHolder() {
        return this.f22062d;
    }

    public GGKBaseDialogModel setImgPlaceHolder(int i) {
        this.f22062d = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public GGKRealUsedModel mo66512a() {
        GGKRealUsedModel gGKRealUsedModel = new GGKRealUsedModel();
        gGKRealUsedModel.f22091g = this.f22059a;
        mo66513a(gGKRealUsedModel);
        convertOthers(gGKRealUsedModel);
        return gGKRealUsedModel;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66513a(GGKRealUsedModel gGKRealUsedModel) {
        if (!TextUtils.isEmpty(getImageUrl()) || getImageResId() != 0) {
            gGKRealUsedModel.f22094j = new GGKImgModel();
            if (getImageUrl() != null) {
                gGKRealUsedModel.f22094j.setImgUrl(getImageUrl());
            } else if (getImageResId() != 0) {
                gGKRealUsedModel.f22094j.setImgResId(getImageResId());
            }
            if (getImgPlaceHolder() != 0) {
                gGKRealUsedModel.f22094j.setImgPlaceHolder(getImgPlaceHolder());
            }
        }
    }
}
