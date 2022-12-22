package com.didi.payment.base.dialog;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class PayCommonDialogFragment extends SimplePopupBase {

    /* renamed from: a */
    private TextView f29876a;

    /* renamed from: b */
    private TextView f29877b;

    /* renamed from: c */
    private TextView f29878c;

    /* renamed from: d */
    private TextView f29879d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnButtonClickedListener f29880e;

    /* renamed from: f */
    private String f29881f;

    /* renamed from: g */
    private String f29882g;

    /* renamed from: h */
    private String f29883h;

    /* renamed from: i */
    private String f29884i;

    public interface OnButtonClickedListener {
        void onNegButtonClicked(PayCommonDialogFragment payCommonDialogFragment);

        void onPosButtonClicked(PayCommonDialogFragment payCommonDialogFragment);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.pay_base_dialog_common;
    }

    public static void show(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, OnButtonClickedListener onButtonClickedListener) {
        PayCommonDialogFragment payCommonDialogFragment = new PayCommonDialogFragment();
        payCommonDialogFragment.f29881f = str;
        payCommonDialogFragment.f29882g = str2;
        payCommonDialogFragment.f29883h = str3;
        payCommonDialogFragment.f29884i = str4;
        payCommonDialogFragment.f29880e = onButtonClickedListener;
        payCommonDialogFragment.show(fragmentActivity.getSupportFragmentManager(), "pay_base_dialog_common");
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f29876a = (TextView) this.mRootView.findViewById(R.id.tv_pay_base_dialog_common_title);
        this.f29877b = (TextView) this.mRootView.findViewById(R.id.tv_pay_base_dialog_common_content);
        this.f29878c = (TextView) this.mRootView.findViewById(R.id.tv_pay_base_dialog_common_pos);
        this.f29879d = (TextView) this.mRootView.findViewById(R.id.tv_pay_base_dialog_common_neg);
        this.f29876a.setText(this.f29881f);
        if (!TextUtils.isEmpty(this.f29882g)) {
            this.f29877b.setVisibility(0);
        } else {
            this.f29877b.setVisibility(8);
        }
        this.f29877b.setText(this.f29882g);
        this.f29878c.setText(this.f29883h);
        this.f29879d.setText(this.f29884i);
        this.f29878c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (PayCommonDialogFragment.this.f29880e != null) {
                    PayCommonDialogFragment.this.f29880e.onPosButtonClicked(PayCommonDialogFragment.this);
                }
            }
        });
        this.f29879d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (PayCommonDialogFragment.this.f29880e != null) {
                    PayCommonDialogFragment.this.f29880e.onNegButtonClicked(PayCommonDialogFragment.this);
                }
            }
        });
    }
}
