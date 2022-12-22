package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.unifiedPay.util.UiThreadHandler;
import com.taxis99.R;

public class ToastView extends FrameLayout {

    /* renamed from: a */
    private ImageView f44471a;

    /* renamed from: b */
    private TextView f44472b;

    /* renamed from: c */
    private long f44473c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DismissListener f44474d;

    public static class Config {
        public static final int ICON_INFO = 2131689490;
        public static final int ICON_NETWORK_ERROR = 2131689489;
        public static final int ICON_SMILE = 2131689492;

        /* renamed from: ICON_SUCCESS */
        public static final int dialog_icon_success = 2131689491;
        public long dismissMs = 2000;
        public int icon = ICON_INFO;
        public DismissListener listener;
        public String message;
    }

    public interface DismissListener {
        void onDismiss();
    }

    public ToastView(Context context) {
        super(context);
        m31580a();
    }

    public ToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31580a();
    }

    /* renamed from: a */
    private void m31580a() {
        View inflate = inflate(getContext(), R.layout.oc_unified_pay_failed_state_layout, this);
        this.f44471a = (ImageView) inflate.findViewById(R.id.oc_iv_fail_state_icon);
        this.f44472b = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_str);
        ((LinearLayout) inflate.findViewById(R.id.oc_ll_fail_state_btn)).setVisibility(8);
    }

    public void setupView(Config config) {
        if (config != null) {
            this.f44473c = config.dismissMs;
            if (config.icon > 0) {
                this.f44471a.setImageResource(config.icon);
            }
            if (TextUtils.isEmpty(config.message)) {
                this.f44472b.setVisibility(8);
            } else {
                this.f44472b.setVisibility(0);
                this.f44472b.setText(config.message);
            }
            m31581b();
        }
    }

    /* renamed from: b */
    private void m31581b() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                if (ToastView.this.f44474d != null) {
                    ToastView.this.f44474d.onDismiss();
                }
            }
        }, this.f44473c);
    }

    public void setListener(DismissListener dismissListener) {
        this.f44474d = dismissListener;
    }
}
