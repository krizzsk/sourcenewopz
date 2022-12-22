package com.didi.soda.customer.widget.dialog;

import android.view.View;
import android.widget.ImageView;
import com.didi.soda.customer.widget.dialog.CustomerCommonDialog;
import rui.base.ImageLoader;
import rui.widget.dialog.DialogModel;

public class DialogBuilder {

    /* renamed from: a */
    private String f41773a;

    /* renamed from: b */
    private String f41774b;

    /* renamed from: c */
    private boolean f41775c = false;

    /* renamed from: d */
    private View.OnClickListener f41776d;

    /* renamed from: e */
    private View.OnClickListener f41777e;

    /* renamed from: f */
    private ImageLoader f41778f;

    /* renamed from: g */
    private ImageLoader f41779g;

    /* renamed from: h */
    private boolean f41780h;

    /* renamed from: i */
    private View f41781i;

    /* renamed from: j */
    private CustomerCommonDialog.DialogAction f41782j;

    /* renamed from: k */
    private CustomerCommonDialog.DialogAction f41783k;

    /* renamed from: l */
    private CustomerCommonDialog.DialogAction f41784l;

    public static class CustomerDialogModel extends DialogModel {
        public boolean mCancelable = false;
        public View mContentView;
        public CustomerCommonDialog.DialogAction mMainAction;
        public View.OnClickListener mOnHandleBackListener;
        public CustomerCommonDialog.DialogAction mSubAction1;
        public CustomerCommonDialog.DialogAction mSubAction2;
    }

    public DialogBuilder addMainAction(CustomerCommonDialog.DialogAction dialogAction) {
        this.f41784l = dialogAction;
        return this;
    }

    public DialogBuilder addSubAction1(String str) {
        this.f41782j = new CustomerCommonDialog.DialogAction(str, (View.OnClickListener) null);
        return this;
    }

    public DialogBuilder addSubAction1(CustomerCommonDialog.DialogAction dialogAction) {
        this.f41782j = dialogAction;
        return this;
    }

    public DialogBuilder addSubAction2(String str) {
        this.f41783k = new CustomerCommonDialog.DialogAction(str, (View.OnClickListener) null);
        return this;
    }

    public DialogBuilder addSubAction2(CustomerCommonDialog.DialogAction dialogAction) {
        this.f41783k = dialogAction;
        return this;
    }

    public CustomerDialogModel build() {
        CustomerDialogModel customerDialogModel = new CustomerDialogModel();
        customerDialogModel.title = this.f41773a;
        customerDialogModel.content = this.f41774b;
        customerDialogModel.headerImage = this.f41778f;
        customerDialogModel.iconImage = this.f41779g;
        customerDialogModel.hasClose = this.f41775c;
        customerDialogModel.onCloseListener = this.f41776d;
        customerDialogModel.mOnHandleBackListener = this.f41777e;
        customerDialogModel.mContentView = this.f41781i;
        customerDialogModel.mMainAction = this.f41784l;
        customerDialogModel.mSubAction1 = this.f41782j;
        customerDialogModel.mSubAction2 = this.f41783k;
        customerDialogModel.mCancelable = this.f41780h;
        return customerDialogModel;
    }

    public boolean getCancelable() {
        return this.f41780h;
    }

    public DialogBuilder setCancelable(boolean z) {
        this.f41780h = z;
        return this;
    }

    public DialogBuilder setContent(String str) {
        this.f41774b = str;
        return this;
    }

    public DialogBuilder setContent(View view) {
        this.f41781i = view;
        return this;
    }

    public DialogBuilder setHasClose(boolean z) {
        this.f41775c = z;
        return this;
    }

    public DialogBuilder setHeaderBackground(final int i) {
        this.f41778f = new ImageLoader() {
            public void load(ImageView imageView) {
                imageView.setBackgroundResource(i);
            }
        };
        return this;
    }

    public DialogBuilder setIconImage(final int i) {
        this.f41779g = new ImageLoader() {
            public void load(ImageView imageView) {
                imageView.setBackgroundResource(i);
            }
        };
        return this;
    }

    public DialogBuilder setOnCloseListener(View.OnClickListener onClickListener) {
        this.f41776d = onClickListener;
        return this;
    }

    public DialogBuilder setOnHandleBackListener(View.OnClickListener onClickListener) {
        this.f41777e = onClickListener;
        return this;
    }

    public DialogBuilder setTitle(String str) {
        this.f41773a = str;
        return this;
    }
}
