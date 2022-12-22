package com.didi.component.splitfare.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.dialog.GlobalAbsBottomPopWin;
import com.didi.component.splitfare.event.SplitFareEventTracker;
import com.didi.travel.psnger.core.model.response.DTSDKSplitFareInfo;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.taxis99.R;
import java.util.List;

public class AcceptSplitFarePopupWindow extends GlobalAbsBottomPopWin implements View.OnClickListener {

    /* renamed from: a */
    private AcceptPaymentsView f15995a;

    /* renamed from: b */
    private TextView f15996b;

    /* renamed from: c */
    private TextView f15997c;

    /* renamed from: d */
    private View f15998d;

    /* renamed from: e */
    private View f15999e;

    /* renamed from: f */
    private DTSDKSplitFareInfo f16000f;

    /* renamed from: g */
    private OnSplitFareActionListener f16001g;

    public interface OnSplitFareActionListener {
        void onAccept(View view);

        void onDecline(View view);

        void onPaymentClick(View view);
    }

    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.accept_splitfare_view;
    }

    public AcceptSplitFarePopupWindow(Context context, DTSDKSplitFareInfo dTSDKSplitFareInfo) {
        super(context);
        this.f16000f = dTSDKSplitFareInfo;
    }

    public void setActionListener(OnSplitFareActionListener onSplitFareActionListener) {
        this.f16001g = onSplitFareActionListener;
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_REQUEST_DLG_SW);
        this.f15995a = (AcceptPaymentsView) findViewById(R.id.accept_payment_methods);
        this.f15996b = (TextView) findViewById(R.id.accept_title_view);
        this.f15997c = (TextView) findViewById(R.id.accept_content_view);
        this.f15998d = findViewById(R.id.accept_submit_btn);
        this.f15999e = findViewById(R.id.accept_cancel_btn);
        if (this.f16000f == null) {
            return true;
        }
        findViewById(R.id.accept_payment_layout).setOnClickListener(this);
        this.f15998d.setOnClickListener(this);
        this.f15999e.setOnClickListener(this);
        this.f15996b.setText(this.f16000f.split_msg_title);
        this.f15997c.setText(this.f16000f.split_msg_content);
        return true;
    }

    public void updatePaymentLabel(List<PayWayModel.PayWayItem> list) {
        if (list != null && list.size() > 0) {
            this.f15995a.updateLabel(list);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        OnSplitFareActionListener onSplitFareActionListener = this.f16001g;
        if (onSplitFareActionListener != null) {
            if (id == R.id.accept_submit_btn) {
                onSplitFareActionListener.onAccept(view);
            } else if (id == R.id.accept_cancel_btn) {
                onSplitFareActionListener.onDecline(view);
            } else if (id == R.id.accept_payment_layout) {
                onSplitFareActionListener.onPaymentClick(view);
            }
        }
    }
}
