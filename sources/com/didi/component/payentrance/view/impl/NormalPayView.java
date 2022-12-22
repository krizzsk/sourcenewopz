package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.payentrance.model.Jumpable;
import com.didi.component.payentrance.utils.PEUtils;
import com.didi.component.payentrance.utils.TextUtil;
import com.didi.component.payentrance.view.IPayEntranceView;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class NormalPayView extends BasePayEntranceView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TextView f15060a;

    /* renamed from: b */
    private TextView f15061b;

    /* renamed from: c */
    private TextView f15062c;

    /* renamed from: d */
    private TextView f15063d;

    /* renamed from: e */
    private TextView f15064e;

    /* renamed from: f */
    private ViewGroup f15065f;

    /* renamed from: g */
    private ViewGroup f15066g;

    /* renamed from: h */
    private boolean f15067h;

    /* renamed from: i */
    private LinearLayout f15068i;

    /* renamed from: j */
    private Jumpable f15069j;

    /* renamed from: k */
    private View f15070k;

    public int getLayoutId() {
        return R.layout.global_pe_pay_normal_view;
    }

    public NormalPayView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
        this.f15060a = (TextView) findView(R.id.oc_tv_pay_entrance_price);
        this.f15070k = findView(R.id.oc_iv_pay_price_arrow);
        this.f15061b = (TextView) findView(R.id.oc_pay_entrance_money_summary);
        this.f15068i = (LinearLayout) findView(R.id.oc_tv_pay_entrance_layout);
        TextView textView = (TextView) findView(R.id.oc_pay_entrance_goto_pay);
        this.f15062c = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NormalPayView.this.performOnPay(TextUtil.getFirstMoneyFromText(String.valueOf(NormalPayView.this.f15060a.getText())), "0");
            }
        });
        TextView textView2 = (TextView) findView(R.id.oc_pay_penalty_has_fee_cancel_rule);
        this.f15064e = textView2;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (NormalPayView.this.mOnCancelRuleClickListener != null) {
                        NormalPayView.this.mOnCancelRuleClickListener.onCancelRuleClick();
                    }
                }
            });
        }
        this.f15066g = (ViewGroup) findView(R.id.oc_pay_entrance_supplement_container);
        this.f15065f = (ViewGroup) findView(R.id.oc_pay_jumpable_container);
        this.f15063d = (TextView) findView(R.id.oc_tv_fee_abnormal_describe);
    }

    public void setPrice(double d) {
        setPrice(this.mContext.getString(R.string.pe_pay_entrance_money, new Object[]{PEUtils.format(d)}));
    }

    public void setFeeDescribe(CharSequence charSequence) {
        super.setFeeDescribe(charSequence);
        if (charSequence == null || TextUtil.isEmpty(charSequence.toString())) {
            this.f15063d.setVisibility(8);
            return;
        }
        this.f15063d.setText(charSequence);
        this.f15063d.setVisibility(0);
    }

    public void setPrice(String str) {
        this.f15068i.setVisibility(0);
        setMoneyWithUnit(this.f15060a, str, 2.14f);
    }

    public void setMessage(CharSequence charSequence) {
        this.f15061b.setVisibility(0);
        this.f15061b.setText(charSequence);
    }

    public void addSupplement(DeductionInfo deductionInfo, String str) {
        if (deductionInfo != null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.global_pe_pay_supplement_item, this.f15066g, false);
            TextView textView = (TextView) inflate.findViewById(R.id.g_pay_entrance_supplement_name);
            if (!TextUtil.isEmpty(deductionInfo.name)) {
                textView.setText(deductionInfo.name);
            }
            ((TextView) inflate.findViewById(R.id.g_pay_entrance_supplement_value)).setText(" " + deductionInfo.deduction + " ");
            if (this.f15067h) {
                ViewGroup viewGroup = this.f15066g;
                viewGroup.addView(inflate, viewGroup.getChildCount() - 1);
                return;
            }
            this.f15066g.addView(inflate);
        }
    }

    public ViewGroup getSupplementContainer() {
        return this.f15066g;
    }

    public void removeSupplement() {
        this.f15066g.removeAllViews();
    }

    public void setActionText(String str) {
        ((TextView) findView(R.id.oc_pay_entrance_goto_pay)).setText(str);
    }

    public void setJumpableItems(List<Jumpable> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (Jumpable next : list) {
                if (next.getId() == 1) {
                    this.f15069j = next;
                } else {
                    arrayList.add(next);
                }
            }
            if (this.f15069j != null) {
                this.f15070k.setVisibility(0);
                this.f15060a.setTag(this.f15069j);
                this.f15060a.setOnClickListener(this.mOnViewClickListener);
            }
        }
        addJumpableViews(this.f15065f, arrayList);
    }

    public void setCancelRuleShow(boolean z) {
        this.f15064e.setVisibility(z ? 0 : 8);
    }

    /* access modifiers changed from: protected */
    public View getLoadingArea() {
        return findView(R.id.oc_pay_entrance_detail);
    }

    public void showTipsCheckbox(String str, boolean z, final IPayEntranceView.OnTipsCheckChangeListener onTipsCheckChangeListener) {
        this.f15067h = true;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.global_pe_pay_tips_item, this.f15066g, false);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.oc_pay_entrance_supplement_checkbox);
        final TextView textView = (TextView) inflate.findViewById(R.id.oc_pay_entrance_supplement_title);
        textView.setText(str);
        if (!z) {
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.pe_color_666666));
        } else {
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.pe_color_FC9153));
        }
        checkBox.setChecked(z);
        ((RelativeLayout) inflate.findViewById(R.id.oc_rl_tips_item)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CheckBox checkBox = checkBox;
                checkBox.setChecked(!checkBox.isChecked());
                if (!checkBox.isChecked()) {
                    TextView textView = textView;
                    textView.setTextColor(textView.getContext().getResources().getColor(R.color.pe_color_666666));
                } else {
                    TextView textView2 = textView;
                    textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.pe_color_FC9153));
                }
                IPayEntranceView.OnTipsCheckChangeListener onTipsCheckChangeListener = onTipsCheckChangeListener;
                if (onTipsCheckChangeListener != null) {
                    onTipsCheckChangeListener.onTipsCheckChanged(checkBox.isChecked());
                }
            }
        });
        this.f15066g.addView(inflate);
    }

    public void disableActionBtn() {
        ((TextView) findView(R.id.oc_pay_entrance_goto_pay)).setBackgroundResource(R.drawable.pe_button_disabled_shape);
        this.f15062c.setClickable(false);
    }
}
