package com.didi.component.common.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.common.dialog.IDialog;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class GuideViewDialog extends BaseCustomViewDialog {

    /* renamed from: a */
    private TextView f11549a;

    /* renamed from: b */
    private LinearLayout f11550b;

    /* renamed from: c */
    private boolean f11551c;

    /* renamed from: d */
    private BusinessContext f11552d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AlertDialogFragment f11553e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f11554f;

    public GuideViewDialog(BusinessContext businessContext) {
        super(businessContext.getContext());
        this.f11552d = businessContext;
    }

    /* access modifiers changed from: protected */
    public View customView() {
        View inflate = this.mInflate.inflate(R.layout.comp_dialog_guide_custom, (ViewGroup) null);
        this.f11554f = inflate;
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        this.f11549a = (TextView) view.findViewById(R.id.gua_new_user_title);
        this.f11550b = (LinearLayout) view.findViewById(R.id.gua_new_user_item_group);
    }

    public void show() {
        if (this.f11553e != null) {
            this.f11551c = true;
            this.f11552d.getNavigation().showDialog(this.f11553e);
        }
    }

    public boolean isShowing() {
        return this.f11551c;
    }

    public void dismiss() {
        if (this.f11553e != null) {
            this.f11552d.getNavigation().dismissDialog(this.f11553e);
            this.f11551c = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7834a(CharSequence charSequence) {
        this.f11549a.setText(charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7835a(String... strArr) {
        for (String text : strArr) {
            View inflate = this.mInflate.inflate(R.layout.comp_guide_custom_view_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.gua_new_user_txt)).setText(text);
            this.f11550b.addView(inflate);
        }
    }

    public static class DialogBuilder {
        private BusinessContext bizContext;
        private GuideViewDialogInfo dialogInfo;
        private Integer mActionHappend;
        private IDialog.DialogListener mListener;
        private AlertDialogFragment.OnClickListener mNegativeListener = new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DialogBuilder.this.handleOnClick(alertDialogFragment, 1);
            }
        };
        private AlertDialogFragment.OnClickListener mPositiveListener = new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DialogBuilder.this.handleOnClick(alertDialogFragment, 2);
            }
        };

        public DialogBuilder(BusinessContext businessContext) {
            this.bizContext = businessContext;
        }

        public void setDialogInfo(GuideViewDialogInfo guideViewDialogInfo) {
            this.dialogInfo = guideViewDialogInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public GuideViewDialog build() {
            GuideViewDialog guideViewDialog = new GuideViewDialog(this.bizContext);
            AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this.bizContext.getContext());
            builder.setCancelable(false);
            builder.setContentView(guideViewDialog.f11554f);
            guideViewDialog.m7834a((CharSequence) this.dialogInfo.f11555a);
            guideViewDialog.m7835a(this.dialogInfo.f11556b);
            builder.setNegativeButtonDefault().setNegativeButton((CharSequence) this.dialogInfo.f11557c, this.mNegativeListener);
            builder.setPositiveButtonDefault().setPositiveButton((CharSequence) this.dialogInfo.f11558d, this.mPositiveListener);
            AlertDialogFragment unused = guideViewDialog.f11553e = builder.create();
            return guideViewDialog;
        }

        /* access modifiers changed from: private */
        public void handleOnClick(AlertDialogFragment alertDialogFragment, int i) {
            this.mActionHappend = Integer.valueOf(i);
            IDialog.DialogListener dialogListener = this.mListener;
            if (dialogListener != null) {
                dialogListener.onAction(i);
            }
            if (alertDialogFragment != null && alertDialogFragment.isAdded()) {
                this.bizContext.getNavigation().dismissDialog(alertDialogFragment);
            }
        }
    }
}
