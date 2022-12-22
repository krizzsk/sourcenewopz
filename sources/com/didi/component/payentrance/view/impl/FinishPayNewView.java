package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.util.UIUtils;
import com.didi.component.payentrance.model.Jumpable;
import com.didi.component.payentrance.utils.PEUtils;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FinishPayNewView extends BasePayEntranceView {

    /* renamed from: a */
    private static final int f15025a = 0;

    /* renamed from: b */
    private static final int f15026b = 1;

    /* renamed from: c */
    private static final int f15027c = 8;

    /* renamed from: d */
    private int f15028d = 0;

    /* renamed from: e */
    private TextView f15029e;

    /* renamed from: f */
    private TextView f15030f;

    /* renamed from: g */
    private ViewGroup f15031g;

    /* renamed from: h */
    private TextView f15032h;

    /* renamed from: i */
    private TextView f15033i;

    /* renamed from: j */
    private LinearLayout f15034j;

    /* renamed from: k */
    private LinearLayout f15035k;

    /* renamed from: l */
    private Jumpable f15036l;

    /* renamed from: m */
    private ImageView f15037m;

    /* renamed from: n */
    private TextView f15038n;

    public void addSupplement(DeductionInfo deductionInfo, String str) {
    }

    public int getLayoutId() {
        return R.layout.global_pe_pay_finish_new;
    }

    public void removeSupplement() {
    }

    public void setActionText(String str) {
    }

    public FinishPayNewView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
        String str;
        this.f15029e = (TextView) findView(R.id.oc_tv_pay_entrance_price);
        this.f15037m = (ImageView) findView(R.id.oc_iv_pay_price_arrow);
        this.f15030f = (TextView) findView(R.id.oc_pay_entrance_money_summary);
        this.f15034j = (LinearLayout) findView(R.id.oc_tv_pay_entrance_layout);
        this.f15031g = (ViewGroup) findView(R.id.oc_pay_jumpable_container);
        this.f15032h = (TextView) findView(R.id.oc_tv_pay_entrance_info);
        this.f15033i = (TextView) findView(R.id.oc_pay_entrance_pay_way);
        this.f15038n = (TextView) findView(R.id.oc_pay_binding_card);
        this.f15035k = (LinearLayout) findView(R.id.oc_tv_pay_entrance_price_layout);
        CarOrder order = CarOrderHelper.getOrder();
        String str2 = null;
        if (order != null) {
            if (order.payInfo == null || TextUtil.isEmpty(order.payInfo.text)) {
                str = null;
            } else {
                str = order.payInfo.text;
                if (!TextUtil.isEmpty(order.payInfo.suffix)) {
                    str = str + " " + order.payInfo.suffix;
                }
            }
            Map<String, String> payedWay = FormStore.getInstance().getPayedWay();
            if (payedWay != null && payedWay.size() > 0) {
                str2 = payedWay.get(order.oid);
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            setPayWay(str2);
        } else {
            setPayWay(str);
        }
    }

    public void setFeeDescribe(CharSequence charSequence) {
        super.setFeeDescribe(charSequence);
        if (charSequence == null || TextUtil.isEmpty(charSequence.toString())) {
            this.f15032h.setVisibility(8);
            return;
        }
        this.f15032h.setVisibility(0);
        this.f15032h.setText(charSequence);
    }

    public void setPrice(double d) {
        setPrice(this.mContext.getString(R.string.pe_pay_entrance_money, new Object[]{PEUtils.format(d)}));
    }

    public void setPrice(String str) {
        this.f15034j.setVisibility(0);
        if (this.f15028d == 0) {
            this.f15029e.setText(str);
        } else {
            setMoneyWithUnit(this.f15029e, str, 1.875f);
        }
    }

    public void setMessage(CharSequence charSequence) {
        if (charSequence == null || TextUtil.isEmpty(charSequence.toString())) {
            this.f15030f.setVisibility(8);
            return;
        }
        this.f15030f.setVisibility(0);
        this.f15030f.setText(charSequence);
    }

    public void setJumpableItems(List<Jumpable> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (Jumpable next : list) {
                if (next.getId() == 1) {
                    this.f15036l = next;
                } else if (next.getId() != 3) {
                    arrayList.add(next);
                }
            }
            if (this.f15036l != null) {
                this.f15037m.setVisibility(0);
                this.f15029e.setTag(this.f15036l);
                this.f15029e.setOnClickListener(this.mOnViewClickListener);
            }
        }
        addJumpableViews(this.f15031g, arrayList);
    }

    /* access modifiers changed from: protected */
    public View getLoadingArea() {
        return findView(R.id.oc_pay_entrance_detail);
    }

    public void setPayWay(String str) {
        super.setPayWay(str);
        if (TextUtils.isEmpty(str)) {
            this.f15033i.setVisibility(8);
            return;
        }
        this.f15033i.setVisibility(0);
        this.f15033i.setText(str);
    }

    public void showBindCard(boolean z) {
        TextView textView = this.f15038n;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
            this.f15038n.setOnClickListener(new NoDoubleClickListener() {
                public void onNoDoubleClick(View view) {
                    if (FinishPayNewView.this.mOnBindCardClickListener != null) {
                        FinishPayNewView.this.mOnBindCardClickListener.onClick(view);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15035k.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f15037m.getLayoutParams();
            if (z) {
                this.f15033i.setVisibility(8);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(11);
                }
                layoutParams.addRule(9);
                this.f15035k.setGravity(3);
                this.f15030f.setGravity(3);
                this.f15037m.setImageResource(R.drawable.normal_price_tag_iv);
                layoutParams2.gravity = 80;
                layoutParams2.bottomMargin = UIUtils.dip2pxInt(this.mContext, 8.0f);
            } else {
                this.f15033i.setVisibility(0);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(9);
                }
                layoutParams.addRule(11);
                this.f15035k.setGravity(5);
                this.f15030f.setGravity(5);
                this.f15037m.setImageResource(R.drawable.finish_price_tag_iv);
                layoutParams2.gravity = 16;
                layoutParams2.bottomMargin = UIUtils.dip2pxInt(this.mContext, 0.0f);
            }
            this.f15028d = z ? 1 : 0;
            if (!TextUtils.isEmpty(this.f15029e.getText())) {
                setPrice(this.f15029e.getText().toString());
            }
        }
    }
}
