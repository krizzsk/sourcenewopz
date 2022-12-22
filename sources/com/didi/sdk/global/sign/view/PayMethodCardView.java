package com.didi.sdk.global.sign.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.sdk.global.common.com.UiUtils;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;

public class PayMethodCardView extends LinearLayout {

    /* renamed from: a */
    private ImageView f36319a;

    /* renamed from: b */
    private ImageView f36320b;

    /* renamed from: c */
    private ImageView f36321c;

    /* renamed from: d */
    private ImageView f36322d;

    /* renamed from: e */
    private ImageView f36323e;

    /* renamed from: f */
    private TextView f36324f;

    /* renamed from: g */
    private TextView f36325g;

    /* renamed from: h */
    private TextView f36326h;

    /* renamed from: i */
    private TextView f36327i;

    /* renamed from: j */
    private TextView f36328j;

    /* renamed from: k */
    private View.OnClickListener f36329k;

    /* renamed from: l */
    private PaySelItemData f36330l;

    public PayMethodCardView(Context context) {
        super(context);
        m25710a(context);
    }

    public PayMethodCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25710a(context);
    }

    public PayMethodCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25710a(context);
    }

    /* renamed from: a */
    private void m25710a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_wallet_paymethod_list_card, this, true);
        this.f36319a = (ImageView) inflate.findViewById(R.id.iv_paymethod_icon);
        this.f36320b = (ImageView) inflate.findViewById(R.id.iv_paymethod_check);
        this.f36321c = (ImageView) inflate.findViewById(R.id.iv_paymethod_switch);
        this.f36322d = (ImageView) inflate.findViewById(R.id.iv_paymethod_reddot);
        this.f36324f = (TextView) inflate.findViewById(R.id.tv_paymethod_name);
        this.f36325g = (TextView) inflate.findViewById(R.id.tv_paymethod_desc);
        this.f36326h = (TextView) inflate.findViewById(R.id.tv_paymethod_right_text_grey);
        this.f36327i = (TextView) inflate.findViewById(R.id.tv_paymethod_right_text_green_bg);
        this.f36328j = (TextView) inflate.findViewById(R.id.tv_paymethod_tips);
        this.f36323e = (ImageView) inflate.findViewById(R.id.iv_paymethod_masking);
    }

    public void setPayMethodItemInfo(PaySelItemData paySelItemData) {
        if (paySelItemData != null) {
            this.f36330l = paySelItemData;
            setSelectStyle(paySelItemData.style);
            if (this.f36330l.channelId == 120) {
                this.f36330l.isEnabled = true;
                String str = this.f36330l.title;
                if (TextUtils.isEmpty(str)) {
                    str = getContext().getString(R.string.one_payment_global_paylist_balance_title);
                }
                this.f36324f.setText(str);
                if (TextUtils.isEmpty(paySelItemData.info)) {
                    this.f36325g.setVisibility(8);
                } else {
                    this.f36325g.setVisibility(0);
                    this.f36325g.setText(paySelItemData.info);
                }
            } else {
                this.f36324f.setText(paySelItemData.title);
                if (paySelItemData.isFrozen) {
                    if (!WalletApolloUtil.isNewPayMethodListEnable() && !TextUtils.isEmpty(paySelItemData.subTitle)) {
                        this.f36325g.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_frozen_text_color_highlight));
                        this.f36325g.setText(paySelItemData.subTitle);
                    }
                    this.f36324f.setEnabled(!paySelItemData.isFrozen);
                } else if (TextUtils.isEmpty(paySelItemData.subTitle)) {
                    this.f36325g.setVisibility(8);
                } else {
                    this.f36325g.setVisibility(0);
                    this.f36325g.setText(paySelItemData.subTitle);
                }
                if (TextUtils.isEmpty(paySelItemData.tips)) {
                    this.f36328j.setVisibility(8);
                } else {
                    this.f36328j.setVisibility(0);
                    this.f36328j.setText(paySelItemData.tips);
                }
                if (paySelItemData.expired == 1) {
                    this.f36326h.setVisibility(0);
                    this.f36326h.setText(paySelItemData.expiredDesc);
                } else if (TextUtil.isEmpty(paySelItemData.info)) {
                    this.f36326h.setVisibility(8);
                } else {
                    this.f36326h.setVisibility(0);
                    this.f36326h.setText(paySelItemData.info);
                }
            }
            if (paySelItemData.isTitleBold) {
                this.f36324f.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.f36324f.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (paySelItemData.channelId == 190 && paySelItemData.status == 1 && !paySelItemData.isSufficient && WalletApolloUtil.isNewPayMethodListEnable() && !paySelItemData.isHit99payCombination) {
                int dip2px = UIUtils.dip2px(getContext(), 10.0f);
                this.f36327i.setPaddingRelative(dip2px, UIUtils.dip2px(getContext(), 4.0f), dip2px, UIUtils.dip2px(getContext(), 5.0f));
                int color = !paySelItemData.isFrozen ? -16777216 : ResourcesHelper.getColor(getContext(), R.color.wallet_color_D4D7D9);
                this.f36327i.setBackgroundResource(!paySelItemData.isFrozen ? R.drawable.one_payment_global_paymethod_99pay_topup_bg_shape : R.drawable.wallet_global_mainlist_account_btn_disable_bg);
                this.f36327i.setTextColor(color);
                this.f36327i.setTypeface(Typeface.defaultFromStyle(1));
                this.f36327i.setText(ResourcesHelper.getString(getContext(), R.string.wallet_balance_type_topup));
                this.f36320b.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f36327i.getLayoutParams();
                layoutParams.rightMargin = UiUtils.dip2px(getContext(), 20.0f);
                this.f36327i.setLayoutParams(layoutParams);
            } else if (paySelItemData.discountStyle == 1 && !TextUtils.isEmpty(paySelItemData.discount)) {
                this.f36327i.setVisibility(0);
                Bitmap bitmap = null;
                this.f36327i.setText((CharSequence) null);
                try {
                    bitmap = m25709a(paySelItemData.discount);
                } catch (Throwable unused) {
                }
                if (bitmap != null) {
                    this.f36327i.setBackground(new BitmapDrawable(getResources(), bitmap));
                }
                View view = new View(getContext());
                view.setBackgroundResource(R.drawable.payway_op_gradient_bg);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(UiUtils.dip2px(getContext(), 140.0f), UiUtils.dip2px(getContext(), 60.0f));
                layoutParams2.addRule(12);
                layoutParams2.addRule(21);
                view.setLayoutParams(layoutParams2);
                ViewParent parent = this.f36327i.getParent();
                if (parent instanceof RelativeLayout) {
                    ((RelativeLayout) parent).addView(view, 0);
                }
            } else if (!TextUtils.isEmpty(paySelItemData.discount)) {
                this.f36327i.setVisibility(0);
                this.f36327i.setText(paySelItemData.discount);
            } else if (!TextUtils.isEmpty(paySelItemData.channelTip)) {
                this.f36327i.setVisibility(0);
                this.f36327i.setBackgroundResource(R.drawable.one_payment_global_icon_new_selector);
                this.f36327i.setText(paySelItemData.channelTip);
            } else {
                this.f36327i.setVisibility(8);
            }
            Activity activity = (Activity) getContext();
            if (activity != null && !activity.isFinishing()) {
                if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
                    if (!TextUtils.isEmpty(paySelItemData.iconUrl)) {
                        GlideUtils.with2load2into(getContext(), paySelItemData.iconUrl, this.f36319a);
                    } else if (!WalletApolloUtil.isNewPayMethodListEnable()) {
                        int i = paySelItemData.channelId;
                        if (i == 120) {
                            this.f36319a.setImageResource(R.drawable.one_payment_global_icon_balance_selector);
                        } else if (i == 121) {
                            this.f36319a.setImageResource(R.drawable.one_payment_global_icon_enterprise_selector);
                        } else if (i == 150) {
                            this.f36319a.setImageResource(R.drawable.one_payment_global_icon_bank_selector);
                        } else if (i != 1000) {
                            switch (i) {
                                case 152:
                                    this.f36319a.setImageResource(R.drawable.one_payment_global_icon_paypal_selector);
                                    break;
                                case 153:
                                    this.f36319a.setImageResource(R.drawable.one_payment_global_icon_cash_selector);
                                    break;
                                case 154:
                                    this.f36319a.setImageResource(R.drawable.one_payment_global_icon_pos_selector);
                                    break;
                            }
                        } else {
                            this.f36319a.setImageResource(R.drawable.one_payment_global_icon_discounts_selector);
                        }
                    }
                    setTitleStyle(paySelItemData.titleStyle);
                    setSubTitleStyle(paySelItemData.subTitleStyle);
                    setMethodEnabled(paySelItemData.isEnabled);
                    if (paySelItemData.expired == 1) {
                        this.f36326h.setEnabled(false);
                        this.f36326h.setTextColor(ResourcesHelper.getColor(getContext(), R.color.one_payment_ff5252));
                    }
                    if (!paySelItemData.isEnabled) {
                        setIsSelected(false);
                    } else if (120 == paySelItemData.channelId || (paySelItemData.isHit99payCombination && 190 == paySelItemData.channelId)) {
                        setIsSelected(paySelItemData.isPriorityUse);
                    } else {
                        setIsSelected(paySelItemData.isSelected);
                    }
                    if (paySelItemData.isFrozen) {
                        this.f36320b.setVisibility(8);
                        this.f36321c.setVisibility(8);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private Bitmap m25709a(String str) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pay_way_select_off_icon, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_payway_select_discount)).setText(str);
        int dip2px = UiUtils.dip2px(getContext(), 41.0f);
        int dip2px2 = UiUtils.dip2px(getContext(), 30.0f);
        inflate.measure(View.MeasureSpec.makeMeasureSpec(dip2px, 1073741824), View.MeasureSpec.makeMeasureSpec(dip2px2, 1073741824));
        Bitmap createBitmap = Bitmap.createBitmap(inflate.getMeasuredWidth(), inflate.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        inflate.layout(0, 0, dip2px, dip2px2);
        inflate.draw(canvas);
        return createBitmap;
    }

    public void setRedDotVisibility(boolean z) {
        this.f36322d.setVisibility(z ? 0 : 8);
    }

    public PaySelItemData getPayMethodItemInfo() {
        return this.f36330l;
    }

    public int getChannelId() {
        PaySelItemData paySelItemData = this.f36330l;
        if (paySelItemData != null) {
            return paySelItemData.channelId;
        }
        return -1;
    }

    public String getCardIndex() {
        PaySelItemData paySelItemData = this.f36330l;
        return paySelItemData != null ? paySelItemData.cardIndex : "";
    }

    private void setSelectStyle(int i) {
        if (i == 0) {
            this.f36320b.setVisibility(8);
            this.f36321c.setVisibility(8);
        } else if (i == 1) {
            this.f36320b.setVisibility(0);
            this.f36321c.setVisibility(8);
            this.f36320b.setImageResource(m25711a() ? R.drawable.one_payment_99_paymethod_check_selector : R.drawable.one_payment_global_paymethod_check_selector);
        } else if (i == 2) {
            this.f36320b.setImageResource(R.drawable.one_payment_global_check_right_arrow);
            this.f36320b.setVisibility(0);
            this.f36321c.setVisibility(8);
        } else if (i == 3) {
            this.f36320b.setVisibility(8);
            this.f36321c.setVisibility(0);
        }
    }

    public void setIsSelected(boolean z) {
        this.f36330l.isSelected = z;
        this.f36320b.setSelected(z);
        this.f36321c.setSelected(z);
    }

    public void setTitleStyle(int i) {
        if (isEnabled()) {
            this.f36324f.setEnabled(i == 0);
        }
    }

    public void setMaskingVisibility(boolean z) {
        PaySelItemData paySelItemData = this.f36330l;
        if (paySelItemData != null && paySelItemData.channelId != 0) {
            this.f36323e.setVisibility(z ? 0 : 8);
            setMethodEnabled(!z);
            if (!this.f36330l.isFrozen) {
                if (z) {
                    this.f36325g.setVisibility(0);
                    this.f36325g.setText(R.string.GRider_1_After_closing_ofPI);
                    this.f36325g.setTextColor(ResourcesHelper.getColor(getContext(), R.color.one_payment_B3000000));
                    return;
                }
                this.f36325g.setTextColor(ResourcesHelper.getColor(getContext(), R.drawable.one_payment_global_paymethod_tip_text_color_selector));
                setSubTitleStyle(this.f36330l.subTitleStyle);
                if (this.f36330l.channelId == 120) {
                    if (TextUtils.isEmpty(this.f36330l.info)) {
                        this.f36325g.setVisibility(8);
                        return;
                    }
                    this.f36325g.setVisibility(0);
                    this.f36325g.setText(this.f36330l.info);
                } else if (TextUtils.isEmpty(this.f36330l.subTitle)) {
                    this.f36325g.setVisibility(8);
                } else {
                    this.f36325g.setVisibility(0);
                    this.f36325g.setText(this.f36330l.subTitle);
                }
            }
        }
    }

    public void setSubTitleStyle(int i) {
        if (!isEnabled()) {
            return;
        }
        if (i == 3) {
            this.f36325g.setTextColor(ResourcesHelper.getColor(getContext(), R.color.one_payment_global_paylist_subtitile_yellow));
        } else {
            this.f36325g.setEnabled(i == 0);
        }
    }

    public boolean getIsSelected() {
        return this.f36330l.isSelected;
    }

    public void setMethodClickListener(View.OnClickListener onClickListener) {
        this.f36329k = onClickListener;
        setOnClickListener(onClickListener);
    }

    private void setMethodEnabled(boolean z) {
        this.f36319a.setEnabled(z);
        this.f36324f.setEnabled(z);
        this.f36320b.setEnabled(z);
        this.f36321c.setEnabled(z);
        this.f36325g.setEnabled(z);
        this.f36326h.setEnabled(z);
        this.f36327i.setEnabled(z);
        if (!z) {
            setOnClickListener((View.OnClickListener) null);
        } else {
            setOnClickListener(this.f36329k);
        }
    }

    /* renamed from: a */
    private boolean m25711a() {
        Object terminalId;
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        if (proxy == null || (terminalId = proxy.getTerminalId(getContext())) == null) {
            return false;
        }
        return "5".equals(terminalId.toString());
    }
}
