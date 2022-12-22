package com.didi.unifylogin.utils.customview;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.AlertDialogBase;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.taxis99.R;

public class LoginAlertDialogFragment extends AlertDialogBase {

    /* renamed from: a */
    private Builder f44989a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnClickListener f44990b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnClickListener f44991c;

    /* renamed from: d */
    private TextView f44992d;

    /* renamed from: e */
    private TextView f44993e;

    /* renamed from: f */
    private TextView f44994f;

    /* renamed from: g */
    private TextView f44995g;

    public interface OnClickListener {
        void onClick(LoginAlertDialogFragment loginAlertDialogFragment, View view);
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            Window window = dialog.getWindow();
            if (LoginPreferredConfig.isUsePassengerUIStyle()) {
                window.setLayout((int) (((double) displayMetrics.widthPixels) * 0.701d), -2);
            } else {
                window.setLayout((int) (((double) displayMetrics.widthPixels) * 0.777d), -2);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.4f;
            attributes.flags |= 2;
            window.setAttributes(attributes);
        }
    }

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View view;
        if (LoginPreferredConfig.isUsePassengerUIStyle()) {
            view = layoutInflater.inflate(R.layout.login_unify_fragment_login_alert_dialog_passenger_style, (ViewGroup) null);
        } else {
            view = layoutInflater.inflate(R.layout.login_unify_fragment_login_alert_dialog, (ViewGroup) null);
        }
        this.f44992d = (TextView) view.findViewById(R.id.txt_title);
        this.f44993e = (TextView) view.findViewById(R.id.txt_messsage);
        this.f44994f = (TextView) view.findViewById(R.id.btn_negative);
        this.f44995g = (TextView) view.findViewById(R.id.btn_positive);
        this.f44994f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (LoginAlertDialogFragment.this.f44990b != null) {
                    LoginAlertDialogFragment.this.f44990b.onClick(LoginAlertDialogFragment.this, view);
                }
            }
        });
        this.f44995g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (LoginAlertDialogFragment.this.f44991c != null) {
                    LoginAlertDialogFragment.this.f44991c.onClick(LoginAlertDialogFragment.this, view);
                }
            }
        });
        this.f44992d.setText(this.f44989a.title);
        this.f44993e.setText(this.f44989a.message);
        this.f44994f.setText(this.f44989a.negativeButtonText);
        this.f44995g.setText(this.f44989a.positiveButtonText);
        this.f44990b = this.f44989a.negativeButtonListener;
        this.f44991c = this.f44989a.positiveButtonListener;
        return view;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static LoginAlertDialogFragment m32250b(Context context, Builder builder) {
        LoginAlertDialogFragment loginAlertDialogFragment = new LoginAlertDialogFragment();
        loginAlertDialogFragment.f44989a = builder;
        loginAlertDialogFragment.setCancelable(builder.cancelable);
        return loginAlertDialogFragment;
    }

    public LoginAlertDialogFragment setTitle(String str) {
        this.f44992d.setText(str);
        return this;
    }

    public LoginAlertDialogFragment setMessage(String str) {
        this.f44993e.setText(str);
        return this;
    }

    public LoginAlertDialogFragment setNegativeButtonText(String str) {
        this.f44994f.setText(str);
        return this;
    }

    public LoginAlertDialogFragment setPositiveButtonText(String str) {
        this.f44995g.setText(str);
        return this;
    }

    public LoginAlertDialogFragment setNegativeButtonListener(OnClickListener onClickListener) {
        this.f44990b = onClickListener;
        return this;
    }

    public LoginAlertDialogFragment setPositiveButtonListener(OnClickListener onClickListener) {
        this.f44991c = onClickListener;
        return this;
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (Exception e) {
            SystemUtils.log(6, "AlertDialogFragment", "show dialog error", e, "com.didi.unifylogin.utils.customview.LoginAlertDialogFragment", 132);
        }
    }

    public static class Builder {
        boolean cancelable = true;
        Context context;
        String message;
        OnClickListener negativeButtonListener;
        String negativeButtonText;
        OnClickListener positiveButtonListener;
        String positiveButtonText;
        String title;

        public Builder(Context context2) {
            this.context = context2;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public Builder setNegativeButtonText(String str) {
            this.negativeButtonText = str;
            return this;
        }

        public Builder setPositiveButtonText(String str) {
            this.positiveButtonText = str;
            return this;
        }

        public Builder setNegativeButtonListener(OnClickListener onClickListener) {
            this.negativeButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButtonListener(OnClickListener onClickListener) {
            this.positiveButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(String str, OnClickListener onClickListener) {
            this.negativeButtonText = str;
            this.negativeButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(String str, OnClickListener onClickListener) {
            this.positiveButtonText = str;
            this.positiveButtonListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.cancelable = z;
            return this;
        }

        public LoginAlertDialogFragment create() {
            return LoginAlertDialogFragment.m32250b(this.context, this);
        }
    }
}
