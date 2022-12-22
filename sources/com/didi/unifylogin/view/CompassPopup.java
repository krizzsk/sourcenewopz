package com.didi.unifylogin.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.taxis99.R;
import java.io.Serializable;

public class CompassPopup extends SimplePopupBase {

    /* renamed from: a */
    private static final String f45020a = "key_compass";
    protected View.OnClickListener cancelListener;
    protected TextView compass_cancel_btn;
    protected TextView compass_confirm_btn;
    protected TextView compass_title;
    protected View.OnClickListener confirmListener;
    protected IPopupDataHandler data;

    public interface IPopupDataHandler extends Serializable {
        String getNegativeBtnText();

        String getPositiveBtnText();

        String getSubTitle();

        String getTitle();
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_compass_dialog;
    }

    public static CompassPopup getInstance(IPopupDataHandler iPopupDataHandler) {
        CompassPopup compassPopup = new CompassPopup();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f45020a, iPopupDataHandler);
        compassPopup.setArguments(bundle);
        return compassPopup;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.data = (IPopupDataHandler) getArguments().getSerializable(f45020a);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        LoginOmegaUtil.trackEvent("tone_p_x_roaming_sw");
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.compass_title = (TextView) this.mRootView.findViewById(R.id.compass_title);
        this.compass_confirm_btn = (TextView) this.mRootView.findViewById(R.id.compass_confirm_btn);
        this.compass_cancel_btn = (TextView) this.mRootView.findViewById(R.id.compass_cancel_btn);
        if (this.data != null) {
            setCancelable(false);
            this.compass_title.setText(this.data.getTitle());
            this.compass_confirm_btn.setText(this.data.getPositiveBtnText());
            this.compass_confirm_btn.setEnabled(true);
            this.compass_confirm_btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    CompassPopup.this.dismiss();
                    if (CompassPopup.this.confirmListener != null) {
                        CompassPopup.this.confirmListener.onClick(view);
                    }
                }
            });
            this.compass_cancel_btn.setText(this.data.getNegativeBtnText());
            this.compass_cancel_btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    CompassPopup.this.dismiss();
                    if (CompassPopup.this.cancelListener != null) {
                        CompassPopup.this.cancelListener.onClick(view);
                    }
                }
            });
        }
    }

    public void setPositiveuttonText(CharSequence charSequence) {
        TextView textView = this.compass_confirm_btn;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setNegativeButtonText(CharSequence charSequence) {
        TextView textView = this.compass_cancel_btn;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.confirmListener = onClickListener;
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.cancelListener = onClickListener;
    }
}
