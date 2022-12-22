package com.didi.unifiedPay.component.widget.loading;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;

public class FailStateDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private ImageView f44490a;

    /* renamed from: b */
    private TextView f44491b;

    /* renamed from: c */
    private TextView f44492c;

    /* renamed from: d */
    private TextView f44493d;

    /* renamed from: e */
    private onClickListener f44494e;

    /* renamed from: f */
    private Object f44495f;

    public static class Config {
        public static final int ICON_INFO = 2131689490;
        public static final int ICON_NETWORK_ERROR = 2131689489;
        public static final int ICON_SMILE = 2131689492;
        public String cancelText;
        public String confirmText;
        public boolean hideAllButton = false;
        public int icon = ICON_INFO;
        public onClickListener listener;
        public String message;
        public boolean singleButton = false;
    }

    public interface onClickListener {
        void onCancel();

        void onConfirm();
    }

    public FailStateDialog(Context context) {
        super(context);
        m31596a(context);
    }

    public FailStateDialog(Context context, int i) {
        super(context, i);
        m31596a(context);
    }

    protected FailStateDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        m31596a(context);
    }

    /* renamed from: a */
    private void m31596a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_pay_failed_layout, (ViewGroup) null);
        setContentView(inflate);
        this.f44490a = (ImageView) inflate.findViewById(R.id.oc_iv_fail_state_icon);
        this.f44491b = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_str);
        this.f44492c = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_cancle);
        this.f44493d = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_ok);
        this.f44492c.setOnClickListener(this);
        this.f44493d.setOnClickListener(this);
    }

    public void setIcon(Drawable drawable) {
        this.f44490a.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.f44490a.setImageResource(i);
    }

    public void setMessage(CharSequence charSequence) {
        if (charSequence == null || TextUtils.isEmpty(charSequence.toString())) {
            this.f44491b.setVisibility(8);
            return;
        }
        this.f44491b.setText(charSequence);
        this.f44491b.setVisibility(0);
    }

    public void setMessage(int i) {
        this.f44491b.setText(i);
        this.f44491b.setVisibility(0);
    }

    public void setCancelText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f44492c.setText(str);
        }
    }

    public void setCancelText(int i) {
        this.f44492c.setText(i);
    }

    public void setConfirmText(int i) {
        this.f44493d.setText(i);
    }

    public void setConfirmText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f44493d.setText(str);
        }
    }

    public void setTag(Object obj) {
        this.f44495f = obj;
    }

    public Object getTag() {
        return this.f44495f;
    }

    public void setOnClickListener(onClickListener onclicklistener) {
        this.f44494e = onclicklistener;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        onClickListener onclicklistener = this.f44494e;
        if (onclicklistener != null) {
            if (view == this.f44492c) {
                onclicklistener.onCancel();
            } else if (view == this.f44493d) {
                onclicklistener.onConfirm();
            }
        }
    }

    public void setupView(Config config) {
        if (config != null) {
            if (config.icon > 0) {
                this.f44490a.setImageResource(config.icon);
            }
            if (config.hideAllButton) {
                this.f44493d.setVisibility(8);
                this.f44492c.setVisibility(8);
            } else if (config.singleButton) {
                this.f44493d.setVisibility(0);
                this.f44492c.setVisibility(8);
            } else {
                this.f44493d.setVisibility(0);
                this.f44492c.setVisibility(0);
            }
            if (!TextUtil.isEmpty(config.confirmText)) {
                this.f44493d.setText(config.confirmText);
            } else {
                this.f44493d.setText(ResourcesHelper.getString(getContext(), R.string.oc_uni_pay_i_know));
            }
            if (!TextUtil.isEmpty(config.cancelText)) {
                this.f44492c.setText(config.cancelText);
            } else {
                this.f44492c.setText(ResourcesHelper.getString(getContext(), R.string.oc_fail_state_cancel));
            }
            this.f44491b.setText(config.message);
            setOnClickListener(config.listener);
        }
    }
}
