package com.didi.component.common.pininput.dialog;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.component.common.widget.pin.PinShowLayout;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class ShowPinDialog {
    public static final int ACTION_CLOSE = 4;
    public static final int ACTION_NEGATIVE = 1;
    public static final int ACTION_NEUTRAL = 3;
    public static final int ACTION_POSITIVE = 2;

    /* renamed from: a */
    private final int f11673a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BusinessContext f11674b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AlertDialogFragment f11675c;

    /* renamed from: d */
    private boolean f11676d;

    public interface DialogListener {
        void onAction(int i);
    }

    public boolean cancelable() {
        return false;
    }

    public ShowPinDialog(int i) {
        this.f11673a = i;
    }

    public int getId() {
        return this.f11673a;
    }

    public void show() {
        this.f11676d = true;
        this.f11674b.getNavigation().showDialog(this.f11675c);
    }

    public boolean isShowing() {
        return this.f11676d;
    }

    public void dismiss() {
        this.f11674b.getNavigation().dismissDialog(this.f11675c);
        this.f11676d = false;
    }

    public void update(ShowPinDialogInfo showPinDialogInfo) {
        if (showPinDialogInfo != null) {
            m7903a(showPinDialogInfo, this.f11675c.getView());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7903a(ShowPinDialogInfo showPinDialogInfo, View view) {
        if (view != null) {
            ((PinShowLayout) view.findViewById(R.id.dialog_pin_show_layout)).showPin(showPinDialogInfo.getPin());
            ((TextView) view.findViewById(R.id.dialog_title)).setText(showPinDialogInfo.getTitle());
        }
    }

    public static final class DialogBuilder {
        private BusinessContext mBizCtx;
        private ShowPinDialogInfo mDialogInfo;
        /* access modifiers changed from: private */
        public DialogListener mListener;

        public DialogBuilder(BusinessContext businessContext) {
            this.mBizCtx = businessContext;
        }

        public DialogBuilder setDialogInfo(ShowPinDialogInfo showPinDialogInfo) {
            this.mDialogInfo = showPinDialogInfo;
            return this;
        }

        public DialogBuilder setListener(DialogListener dialogListener) {
            this.mListener = dialogListener;
            return this;
        }

        public ShowPinDialog build() {
            ShowPinDialog showPinDialog = new ShowPinDialog(this.mDialogInfo.getDialogId());
            BusinessContext unused = showPinDialog.f11674b = this.mBizCtx;
            View inflate = LayoutInflater.from(this.mBizCtx.getContext()).inflate(R.layout.global_dialog_show_pin, (ViewGroup) null);
            AlertDialogFragment unused2 = showPinDialog.f11675c = new AlertDialogFragment.Builder(this.mBizCtx.getContext()).setContentView(inflate).setPositiveButton((CharSequence) getButtonString(), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    DialogBuilder.this.mListener.onAction(4);
                }
            }).setCancelable(this.mDialogInfo.isCancelable()).create();
            showPinDialog.m7903a(this.mDialogInfo, inflate);
            return showPinDialog;
        }

        private SpannableString getButtonString() {
            SpannableString spannableString = new SpannableString(this.mDialogInfo.getButton());
            spannableString.setSpan(new ForegroundColorSpan(this.mBizCtx.getContext().getResources().getColor(R.color.color_FEA330)), 0, this.mDialogInfo.getButton().length(), 33);
            return spannableString;
        }
    }
}
