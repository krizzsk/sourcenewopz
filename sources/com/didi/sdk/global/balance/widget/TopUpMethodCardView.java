package com.didi.sdk.global.balance.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.balance.model.TopUpMethodItemInfo;
import com.taxis99.R;

@Deprecated
public class TopUpMethodCardView extends LinearLayout {

    /* renamed from: a */
    private static final String f36041a = "Balance";

    /* renamed from: b */
    private ImageView f36042b;

    /* renamed from: c */
    private ImageView f36043c;

    /* renamed from: d */
    private ImageView f36044d;

    /* renamed from: e */
    private TextView f36045e;

    /* renamed from: f */
    private TextView f36046f;

    /* renamed from: g */
    private TextView f36047g;

    /* renamed from: h */
    private TextView f36048h;

    /* renamed from: i */
    private boolean f36049i;

    /* renamed from: j */
    private boolean f36050j;

    /* renamed from: k */
    private TopUpMethodItemInfo f36051k;

    public enum STYLE {
        CHECK,
        CLICK
    }

    public TopUpMethodCardView(Context context) {
        super(context);
        m25493a(context);
    }

    public TopUpMethodCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25493a(context);
    }

    public TopUpMethodCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25493a(context);
    }

    /* renamed from: a */
    private void m25493a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.one_payment_v_global_balance_topup_method_card, this, true);
        this.f36042b = (ImageView) inflate.findViewById(R.id.iv_topup_method_icon);
        this.f36043c = (ImageView) inflate.findViewById(R.id.iv_topup_method_check);
        this.f36044d = (ImageView) inflate.findViewById(R.id.iv_topup_method_reddot);
        this.f36045e = (TextView) inflate.findViewById(R.id.tv_topup_method_name);
        this.f36046f = (TextView) inflate.findViewById(R.id.tv_topup_method_desc);
        this.f36047g = (TextView) inflate.findViewById(R.id.tv_topup_method_value_prefix);
        this.f36048h = (TextView) inflate.findViewById(R.id.tv_topup_method_value);
    }

    public void setPayMethodItemInfo(TopUpMethodItemInfo topUpMethodItemInfo) {
        if (topUpMethodItemInfo == null) {
            SystemUtils.log(6, "Balance", "top up method item info is null", (Throwable) null, "com.didi.sdk.global.balance.widget.TopUpMethodCardView", 78);
            return;
        }
        this.f36051k = topUpMethodItemInfo;
        this.f36045e.setText(topUpMethodItemInfo.name);
        if (TextUtils.isEmpty(topUpMethodItemInfo.description)) {
            this.f36046f.setVisibility(8);
        } else {
            this.f36046f.setVisibility(0);
            this.f36046f.setText(topUpMethodItemInfo.description);
        }
        if (TextUtils.isEmpty(topUpMethodItemInfo.valuePrefix)) {
            this.f36047g.setVisibility(8);
        } else {
            this.f36047g.setVisibility(0);
            this.f36047g.setText(topUpMethodItemInfo.valuePrefix);
        }
        if (TextUtils.isEmpty(topUpMethodItemInfo.value)) {
            this.f36048h.setVisibility(8);
        } else {
            this.f36048h.setVisibility(0);
            this.f36048h.setText(topUpMethodItemInfo.value);
        }
        if (!TextUtils.isEmpty(topUpMethodItemInfo.iconUrl)) {
            GlideUtils.with2load2into(getContext(), topUpMethodItemInfo.iconUrl, this.f36042b);
        } else if (topUpMethodItemInfo.channelId != 120) {
            SystemUtils.log(4, "Balance", "No proper icon for unsupported payment channel: " + topUpMethodItemInfo.channelId, (Throwable) null, "com.didi.sdk.global.balance.widget.TopUpMethodCardView", 116);
            this.f36042b.setImageResource(R.drawable.one_payment_global_icon_cash_selector);
        } else {
            this.f36042b.setImageResource(R.drawable.one_payment_global_icon_balance_selector);
        }
    }

    public void setRedDotVisibility(boolean z) {
        SystemUtils.log(3, "Balance", "set visibility to " + z + " for " + this.f36051k.name, (Throwable) null, "com.didi.sdk.global.balance.widget.TopUpMethodCardView", 124);
        this.f36044d.setVisibility(z ? 0 : 8);
    }

    public TopUpMethodItemInfo getItemInfo() {
        return this.f36051k;
    }

    public int getChannelId() {
        TopUpMethodItemInfo topUpMethodItemInfo = this.f36051k;
        if (topUpMethodItemInfo != null) {
            return topUpMethodItemInfo.channelId;
        }
        return -1;
    }

    public void setSelectStyle(STYLE style) {
        int i;
        if (style == STYLE.CHECK) {
            try {
                i = DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.checkbox_selector);
            } catch (Exception unused) {
                i = R.drawable.one_payment_global_topup_method_check_selector;
            }
            this.f36043c.setImageResource(i);
        } else if (style == STYLE.CLICK) {
            this.f36043c.setImageResource(R.drawable.one_payment_global_check_right_arrow);
        }
    }

    public void setIsSelected(boolean z) {
        this.f36049i = z;
        this.f36043c.setSelected(z);
    }

    public boolean getIsSelected() {
        return this.f36049i;
    }

    public void setMethodClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setEnabled(boolean z) {
        this.f36050j = z;
        this.f36042b.setEnabled(z);
        this.f36045e.setEnabled(z);
        this.f36043c.setEnabled(z);
        this.f36046f.setEnabled(z);
        if (!z) {
            setOnClickListener((View.OnClickListener) null);
        }
    }

    public boolean getEnabled() {
        return this.f36050j;
    }
}
