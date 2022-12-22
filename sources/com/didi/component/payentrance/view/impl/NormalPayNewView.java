package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.text.TextUtils;
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

public class NormalPayNewView extends BasePayEntranceView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TextView f15050a;

    /* renamed from: b */
    private TextView f15051b;

    /* renamed from: c */
    private TextView f15052c;

    /* renamed from: d */
    private TextView f15053d;

    /* renamed from: e */
    private ViewGroup f15054e;

    /* renamed from: f */
    private ViewGroup f15055f;

    /* renamed from: g */
    private boolean f15056g;

    /* renamed from: h */
    private LinearLayout f15057h;

    /* renamed from: i */
    private Jumpable f15058i;

    /* renamed from: j */
    private View f15059j;

    public int getLayoutId() {
        return R.layout.global_pe_pay_normal_view_new;
    }

    public NormalPayNewView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
        this.f15050a = (TextView) findView(R.id.oc_tv_pay_entrance_price);
        this.f15059j = findView(R.id.oc_iv_pay_price_arrow);
        this.f15051b = (TextView) findView(R.id.oc_pay_entrance_money_summary);
        this.f15057h = (LinearLayout) findView(R.id.oc_tv_pay_entrance_layout);
        TextView textView = (TextView) findView(R.id.oc_pay_entrance_goto_pay);
        this.f15052c = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NormalPayNewView.this.performOnPay(TextUtil.getFirstMoneyFromText(String.valueOf(NormalPayNewView.this.f15050a.getText())), "0");
            }
        });
        this.f15055f = (ViewGroup) findView(R.id.oc_pay_entrance_supplement_container);
        this.f15054e = (ViewGroup) findView(R.id.oc_pay_jumpable_container);
        this.f15053d = (TextView) findView(R.id.oc_tv_fee_abnormal_describe);
    }

    public void setPrice(double d) {
        setPrice(this.mContext.getString(R.string.pe_pay_entrance_money, new Object[]{PEUtils.format(d)}));
    }

    public void setFeeDescribe(CharSequence charSequence) {
        super.setFeeDescribe(charSequence);
        if (charSequence == null || TextUtil.isEmpty(charSequence.toString())) {
            this.f15053d.setVisibility(8);
            return;
        }
        this.f15053d.setText(charSequence);
        this.f15053d.setVisibility(0);
    }

    public void setPrice(String str) {
        this.f15057h.setVisibility(0);
        setMoneyWithUnit(this.f15050a, str, 1.875f);
    }

    public void setMessage(CharSequence charSequence) {
        this.f15051b.setVisibility(0);
        this.f15051b.setText(charSequence);
    }

    public void addSupplement(DeductionInfo deductionInfo, String str) {
        if (!TextUtils.isEmpty(str)) {
            TextView textView = new TextView(this.mContext);
            textView.setText(str);
            textView.setTextColor(this.mContext.getResources().getColor(R.color.color_999999));
            textView.setTextSize(9.0f);
            this.f15055f.addView(textView);
        }
    }

    public void removeSupplement() {
        this.f15055f.removeAllViews();
    }

    public void setActionText(String str) {
        ((TextView) findView(R.id.oc_pay_entrance_goto_pay)).setText(str);
    }

    public void setJumpableItems(List<Jumpable> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (Jumpable next : list) {
                if (next.getId() == 1) {
                    this.f15058i = next;
                } else if (next.getId() != 3) {
                    arrayList.add(next);
                }
            }
            if (this.f15058i != null) {
                this.f15059j.setVisibility(0);
                this.f15050a.setTag(this.f15058i);
                this.f15050a.setOnClickListener(this.mOnViewClickListener);
            }
        }
        addJumpableViews(this.f15054e, arrayList);
    }

    /* access modifiers changed from: protected */
    public View getLoadingArea() {
        return findView(R.id.oc_pay_entrance_detail);
    }

    public void showTipsCheckbox(String str, boolean z, final IPayEntranceView.OnTipsCheckChangeListener onTipsCheckChangeListener) {
        this.f15056g = true;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.global_pe_pay_tips_item, this.f15055f, false);
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
        this.f15055f.addView(inflate);
    }

    public void disableActionBtn() {
        ((TextView) findView(R.id.oc_pay_entrance_goto_pay)).setEnabled(false);
        this.f15052c.setClickable(false);
    }
}
