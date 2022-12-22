package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.payentrance.model.Jumpable;
import com.didi.component.payentrance.utils.PEUtils;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class FinishPayView extends BasePayEntranceView {

    /* renamed from: a */
    private TextView f15039a;

    /* renamed from: b */
    private TextView f15040b;

    /* renamed from: c */
    private ViewGroup f15041c;

    /* renamed from: d */
    private ViewGroup f15042d;

    /* renamed from: e */
    private TextView f15043e;

    /* renamed from: f */
    private TextView f15044f;

    /* renamed from: g */
    private TextView f15045g;

    /* renamed from: h */
    private LinearLayout f15046h;

    /* renamed from: i */
    private Jumpable f15047i;

    /* renamed from: j */
    private View f15048j;

    /* renamed from: k */
    private TextView f15049k;

    public void addSupplement(DeductionInfo deductionInfo, String str) {
    }

    public int getLayoutId() {
        return R.layout.global_pe_pay_finish;
    }

    public void removeSupplement() {
    }

    public void setActionText(String str) {
    }

    public FinishPayView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
        this.f15039a = (TextView) findView(R.id.oc_tv_pay_entrance_price);
        this.f15048j = findView(R.id.oc_iv_pay_price_arrow);
        this.f15040b = (TextView) findView(R.id.oc_pay_entrance_money_summary);
        this.f15046h = (LinearLayout) findView(R.id.oc_tv_pay_entrance_layout);
        this.f15041c = (ViewGroup) findView(R.id.oc_pay_jumpable_container);
        this.f15042d = (ViewGroup) findView(R.id.oc_pay_entrance_supplement_container);
        TextView textView = (TextView) findView(R.id.oc_pay_penalty_has_fee_cancel_rule);
        this.f15043e = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (FinishPayView.this.mOnCancelRuleClickListener != null) {
                        FinishPayView.this.mOnCancelRuleClickListener.onCancelRuleClick();
                    }
                }
            });
        }
        this.f15044f = (TextView) findView(R.id.oc_tv_pay_entrance_info);
        this.f15045g = (TextView) findView(R.id.oc_pay_entrance_pay_way);
        this.f15049k = (TextView) findView(R.id.oc_pay_binding_card);
    }

    public void setFeeDescribe(CharSequence charSequence) {
        super.setFeeDescribe(charSequence);
        if (charSequence == null || TextUtil.isEmpty(charSequence.toString())) {
            this.f15044f.setVisibility(8);
            return;
        }
        this.f15044f.setVisibility(0);
        this.f15044f.setText(charSequence);
    }

    public void setPrice(double d) {
        setPrice(this.mContext.getString(R.string.pe_pay_entrance_money, new Object[]{PEUtils.format(d)}));
    }

    public void setPrice(String str) {
        this.f15046h.setVisibility(0);
        setMoneyWithUnit(this.f15039a, str, 1.5f);
    }

    public void setMessage(CharSequence charSequence) {
        if (charSequence == null || TextUtil.isEmpty(charSequence.toString())) {
            this.f15040b.setVisibility(8);
            return;
        }
        this.f15040b.setVisibility(0);
        this.f15040b.setText(charSequence);
    }

    public ViewGroup getSupplementContainer() {
        return this.f15042d;
    }

    public void setCancelRuleShow(boolean z) {
        this.f15043e.setVisibility(z ? 0 : 8);
    }

    public void setJumpableItems(List<Jumpable> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (Jumpable next : list) {
                if (next.getId() == 1) {
                    this.f15047i = next;
                } else {
                    arrayList.add(next);
                }
            }
            if (this.f15047i != null) {
                this.f15048j.setVisibility(0);
                this.f15039a.setTag(this.f15047i);
                this.f15039a.setOnClickListener(this.mOnViewClickListener);
            }
        }
        addJumpableViews(this.f15041c, arrayList);
    }

    /* access modifiers changed from: protected */
    public View getLoadingArea() {
        return findView(R.id.oc_pay_entrance_detail);
    }

    public void setPayWay(String str) {
        super.setPayWay(str);
        if (TextUtils.isEmpty(str)) {
            this.f15045g.setVisibility(8);
            return;
        }
        this.f15045g.setVisibility(0);
        this.f15045g.setText(str);
    }

    public void showBindCard(boolean z) {
        TextView textView = this.f15049k;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
            this.f15049k.setOnClickListener(new NoDoubleClickListener() {
                public void onNoDoubleClick(View view) {
                    if (FinishPayView.this.mOnBindCardClickListener != null) {
                        FinishPayView.this.mOnBindCardClickListener.onClick(view);
                    }
                }
            });
        }
    }
}
