package com.didi.payment.wallet.global.wallet.view.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class MobileTopUpTipDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private static final String f32824a = "MOBLIE_TOPUP_TIP_KEY";

    /* renamed from: b */
    private Context f32825b;

    /* renamed from: c */
    private LinearLayout f32826c;

    /* renamed from: d */
    private LinearLayout f32827d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View.OnClickListener f32828e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f32829f;

    public MobileTopUpTipDialogFragment() {
        setStyle(0, R.style.cornerdialog);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.wallet_global_dialog_mobile_topup_tip, (ViewGroup) null, false);
        this.f32826c = (LinearLayout) inflate.findViewById(R.id.ll_confirm);
        this.f32827d = (LinearLayout) inflate.findViewById(R.id.ll_cancel);
        this.f32826c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MobileTopUpTipDialogFragment.this.dismissAllowingStateLoss();
                if (MobileTopUpTipDialogFragment.this.f32828e != null) {
                    MobileTopUpTipDialogFragment.this.f32828e.onClick(view);
                }
            }
        });
        this.f32827d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MobileTopUpTipDialogFragment.this.dismissAllowingStateLoss();
                if (MobileTopUpTipDialogFragment.this.f32829f != null) {
                    MobileTopUpTipDialogFragment.this.f32829f.onClick(view);
                }
            }
        });
        return inflate;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
        PaySharedPreferencesUtil.putBoolean(this.f32825b, f32824a, true);
    }

    public void setConfirmClickListener(View.OnClickListener onClickListener) {
        this.f32828e = onClickListener;
    }

    public void setCancelClickListener(View.OnClickListener onClickListener) {
        this.f32829f = onClickListener;
    }

    public void setContext(Context context) {
        this.f32825b = context;
    }

    public static boolean canShow(Context context) {
        return !PaySharedPreferencesUtil.getBoolean(context, f32824a, false);
    }
}
