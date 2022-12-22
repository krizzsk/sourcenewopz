package com.didi.entrega.customer.widget.dialog;

import android.view.View;
import android.widget.ImageView;
import com.didi.entrega.customer.widget.dialog.CustomerCommonDialog;
import rui.base.ImageLoader;
import rui.widget.dialog.DialogModel;

public class DialogBuilder {

    /* renamed from: a */
    private String f20434a;

    /* renamed from: b */
    private String f20435b;

    /* renamed from: c */
    private boolean f20436c = false;

    /* renamed from: d */
    private View.OnClickListener f20437d;

    /* renamed from: e */
    private View.OnClickListener f20438e;

    /* renamed from: f */
    private ImageLoader f20439f;

    /* renamed from: g */
    private ImageLoader f20440g;

    /* renamed from: h */
    private boolean f20441h;

    /* renamed from: i */
    private View f20442i;

    /* renamed from: j */
    private CustomerCommonDialog.DialogAction f20443j;

    /* renamed from: k */
    private CustomerCommonDialog.DialogAction f20444k;

    /* renamed from: l */
    private CustomerCommonDialog.DialogAction f20445l;

    public static class CustomerDialogModel extends DialogModel {
        public boolean mCancelable = false;
        public View mContentView;
        public CustomerCommonDialog.DialogAction mMainAction;
        public View.OnClickListener mOnHandleBackListener;
        public CustomerCommonDialog.DialogAction mSubAction1;
        public CustomerCommonDialog.DialogAction mSubAction2;
    }

    public DialogBuilder addMainAction(CustomerCommonDialog.DialogAction dialogAction) {
        this.f20445l = dialogAction;
        return this;
    }

    public DialogBuilder addSubAction1(String str) {
        this.f20443j = new CustomerCommonDialog.DialogAction(str, (View.OnClickListener) null);
        return this;
    }

    public DialogBuilder addSubAction1(CustomerCommonDialog.DialogAction dialogAction) {
        this.f20443j = dialogAction;
        return this;
    }

    public DialogBuilder addSubAction2(String str) {
        this.f20444k = new CustomerCommonDialog.DialogAction(str, (View.OnClickListener) null);
        return this;
    }

    public DialogBuilder addSubAction2(CustomerCommonDialog.DialogAction dialogAction) {
        this.f20444k = dialogAction;
        return this;
    }

    public CustomerDialogModel build() {
        CustomerDialogModel customerDialogModel = new CustomerDialogModel();
        customerDialogModel.title = this.f20434a;
        customerDialogModel.content = this.f20435b;
        customerDialogModel.headerImage = this.f20439f;
        customerDialogModel.iconImage = this.f20440g;
        customerDialogModel.hasClose = this.f20436c;
        customerDialogModel.onCloseListener = this.f20437d;
        customerDialogModel.mOnHandleBackListener = this.f20438e;
        customerDialogModel.mContentView = this.f20442i;
        customerDialogModel.mMainAction = this.f20445l;
        customerDialogModel.mSubAction1 = this.f20443j;
        customerDialogModel.mSubAction2 = this.f20444k;
        customerDialogModel.mCancelable = this.f20441h;
        return customerDialogModel;
    }

    public boolean getCancelable() {
        return this.f20441h;
    }

    public DialogBuilder setCancelable(boolean z) {
        this.f20441h = z;
        return this;
    }

    public DialogBuilder setContent(String str) {
        this.f20435b = str;
        return this;
    }

    public DialogBuilder setContent(View view) {
        this.f20442i = view;
        return this;
    }

    public DialogBuilder setHasClose(boolean z) {
        this.f20436c = z;
        return this;
    }

    public DialogBuilder setHeaderBackground(final int i) {
        this.f20439f = new ImageLoader() {
            public void load(ImageView imageView) {
                imageView.setBackgroundResource(i);
            }
        };
        return this;
    }

    public DialogBuilder setIconImage(final int i) {
        this.f20440g = new ImageLoader() {
            public void load(ImageView imageView) {
                imageView.setBackgroundResource(i);
            }
        };
        return this;
    }

    public DialogBuilder setOnCloseListener(View.OnClickListener onClickListener) {
        this.f20437d = onClickListener;
        return this;
    }

    public DialogBuilder setOnHandleBackListener(View.OnClickListener onClickListener) {
        this.f20438e = onClickListener;
        return this;
    }

    public DialogBuilder setTitle(String str) {
        this.f20434a = str;
        return this;
    }
}
