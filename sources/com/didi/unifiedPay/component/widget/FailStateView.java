package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class FailStateView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private ImageView f44452a;

    /* renamed from: b */
    private TextView f44453b;

    /* renamed from: c */
    private TextView f44454c;

    /* renamed from: d */
    private TextView f44455d;

    /* renamed from: e */
    private ClickListener f44456e;

    public interface ClickListener {
        void onCancel();

        void onConfirm();
    }

    public static class Config {
        public static final int ICON_INFO = 2131689490;
        public static final int ICON_NETWORK_ERROR = 2131689489;
        public static final int ICON_SMILE = 2131689492;
        public String cancelText;
        public String confirmText;
        public int errorCode;
        public boolean hideAllButton = false;
        public int icon = ICON_INFO;
        public ClickListener listener;
        public String message;
        public boolean singleButton = false;
    }

    public FailStateView(Context context) {
        super(context);
        m31567a();
    }

    public FailStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31567a();
    }

    /* renamed from: a */
    private void m31567a() {
        View inflate = inflate(getContext(), R.layout.oc_unified_pay_failed_state_layout, this);
        this.f44452a = (ImageView) inflate.findViewById(R.id.oc_iv_fail_state_icon);
        this.f44453b = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_str);
        this.f44454c = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_cancle);
        this.f44455d = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_ok);
        this.f44454c.setOnClickListener(this);
        this.f44455d.setOnClickListener(this);
    }

    public void setIcon(Drawable drawable) {
        this.f44452a.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.f44452a.setImageResource(i);
    }

    public void setMessage(CharSequence charSequence) {
        if (charSequence == null || TextUtils.isEmpty(charSequence.toString())) {
            this.f44453b.setVisibility(8);
            return;
        }
        this.f44453b.setText(charSequence);
        this.f44453b.setVisibility(0);
    }

    public void setMessage(int i) {
        this.f44453b.setText(i);
        this.f44453b.setVisibility(0);
    }

    public void setCancelText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f44454c.setText(str);
        }
    }

    public void setCancelText(int i) {
        this.f44454c.setText(i);
    }

    public void setConfirmText(int i) {
        this.f44455d.setText(i);
    }

    public void setConfirmText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f44455d.setText(str);
        }
    }

    public void setFailViewClickListener(ClickListener clickListener) {
        this.f44456e = clickListener;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        ClickListener clickListener = this.f44456e;
        if (clickListener != null) {
            if (view == this.f44454c) {
                clickListener.onCancel();
            } else if (view == this.f44455d) {
                clickListener.onConfirm();
            }
        }
    }

    public void setupView(Config config) {
        if (config != null) {
            if (config.icon > 0) {
                this.f44452a.setImageResource(config.icon);
            }
            if (config.hideAllButton) {
                this.f44455d.setVisibility(8);
                this.f44454c.setVisibility(8);
            } else {
                if (config.singleButton) {
                    this.f44454c.setVisibility(8);
                } else {
                    this.f44454c.setVisibility(0);
                    this.f44454c.setText(config.cancelText);
                }
                this.f44455d.setVisibility(0);
            }
            this.f44455d.setText(config.confirmText);
            if (TextUtils.isEmpty(config.message)) {
                this.f44453b.setVisibility(8);
            } else {
                this.f44453b.setVisibility(0);
                this.f44453b.setText(config.message);
            }
            setFailViewClickListener(config.listener);
        }
    }
}
