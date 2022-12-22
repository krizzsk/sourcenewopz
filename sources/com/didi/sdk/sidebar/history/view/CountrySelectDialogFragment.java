package com.didi.sdk.sidebar.history.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.taxis99.R;
import java.util.List;

public class CountrySelectDialogFragment extends SimplePopupBase {

    /* renamed from: a */
    private List<PopupSelectModel> f37407a;

    /* renamed from: b */
    private String f37408b;

    /* renamed from: c */
    private String f37409c;

    /* renamed from: d */
    private PopupSelectView f37410d;

    /* renamed from: e */
    private PopupSelectView.OnPopupSelectListClickListener f37411e;

    /* renamed from: f */
    private int f37412f = -1;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.country_select_dialog_layout;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        PopupSelectView popupSelectView = (PopupSelectView) this.mRootView.findViewById(R.id.popup_select_recycler_view);
        this.f37410d = popupSelectView;
        popupSelectView.setItems(this.f37407a);
        if (!TextUtils.isEmpty(this.f37408b)) {
            this.f37410d.setTitle(this.f37408b);
        }
        if (!TextUtils.isEmpty(this.f37409c)) {
            this.f37410d.setContent(this.f37409c);
        }
        this.f37410d.setOnPopupSelectListClickListener(this.f37411e);
        int i = this.f37412f;
        if (i >= 0) {
            this.f37410d.setSelectedPosition(i);
        }
    }

    public void setTitle(String str) {
        this.f37408b = str;
    }

    public void setContent(String str) {
        this.f37409c = str;
    }

    public void setItems(List<PopupSelectModel> list) {
        this.f37407a = list;
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f37411e = onPopupSelectListClickListener;
    }

    public void setSelectedPosition(int i) {
        this.f37412f = i;
    }
}
