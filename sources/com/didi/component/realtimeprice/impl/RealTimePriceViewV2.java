package com.didi.component.realtimeprice.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.PriceUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.view.GlobalTipsContainer;
import com.didi.component.common.widget.CouponView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.realtimeprice.AbsRealTimePricePresenter;
import com.didi.component.realtimeprice.IRealTimePriceView;
import com.didi.component.realtimeprice.model.CouponAssistantModel;
import com.didi.component.realtimeprice.model.PayInfo;
import com.didi.component.realtimeprice.model.RealTimePrice;
import com.didi.component.realtimeprice.model.SelectPaywayItem;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.sdk.util.ToastHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.OrderStatus;
import com.didi.travel.psnger.model.response.CarOrder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class RealTimePriceViewV2 implements View.OnClickListener, IRealTimePriceView {

    /* renamed from: A */
    private CouponView f15271A;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsRealTimePricePresenter f15272a;

    /* renamed from: b */
    private View f15273b;

    /* renamed from: c */
    private TextView f15274c;

    /* renamed from: d */
    private TextView f15275d;

    /* renamed from: e */
    private IRealTimePriceView.OnActionListener f15276e;

    /* renamed from: f */
    private boolean f15277f = false;

    /* renamed from: g */
    private Context f15278g;

    /* renamed from: h */
    private GlobalTipsContainer f15279h;

    /* renamed from: i */
    private TextView f15280i;

    /* renamed from: j */
    private TextView f15281j;

    /* renamed from: k */
    private ImageView f15282k;

    /* renamed from: l */
    private boolean f15283l;

    /* renamed from: m */
    private TextView f15284m;

    /* renamed from: n */
    private ImageView f15285n;

    /* renamed from: o */
    private TextView f15286o;

    /* renamed from: p */
    private View f15287p;

    /* renamed from: q */
    private ImageView f15288q;

    /* renamed from: r */
    private ImageView f15289r;

    /* renamed from: s */
    private ConstraintLayout f15290s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public PayInfo f15291t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ImageView f15292u;

    /* renamed from: v */
    private Map<String, Object> f15293v = new HashMap();

    /* renamed from: w */
    private boolean f15294w = false;

    /* renamed from: x */
    private boolean f15295x = false;

    /* renamed from: y */
    private boolean f15296y = false;

    /* renamed from: z */
    private int f15297z = 0;

    public void hideNewbieGuide() {
    }

    public void hideOnTripCoupon() {
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public void setClickable(boolean z) {
    }

    public void setCoupon(LEGORichInfo lEGORichInfo) {
    }

    public void setCouponAssistant(CouponAssistantModel couponAssistantModel) {
    }

    public void setPriceDesc(String str) {
    }

    public void showFixedPriceGuidePopup(String str) {
    }

    public void showNewbieGuide(String str) {
    }

    public RealTimePriceViewV2(Context context, ViewGroup viewGroup) {
        this.f15278g = context;
        this.f15273b = LayoutInflater.from(context).inflate(R.layout.global_real_time_price_view_v2, viewGroup, false);
        this.f15274c = (TextView) m10969a((int) R.id.real_time_pay_way);
        this.f15275d = (TextView) m10969a((int) R.id.real_time_price_text);
        this.f15285n = (ImageView) m10969a((int) R.id.real_time_pay_way_ic);
        this.f15280i = (TextView) m10969a((int) R.id.real_time_coupon_tv);
        this.f15284m = (TextView) m10969a((int) R.id.real_time_pay_way_99);
        this.f15282k = (ImageView) m10969a((int) R.id.real_time_coupon_ic);
        this.f15286o = (TextView) m10969a((int) R.id.real_time_price_text_origin);
        this.f15287p = m10969a((int) R.id.combine_payway);
        this.f15288q = (ImageView) m10969a((int) R.id.pay_way_balance_icon);
        this.f15289r = (ImageView) m10969a((int) R.id.pay_way_card_icon);
        this.f15290s = (ConstraintLayout) m10969a((int) R.id.payway_container);
        this.f15292u = (ImageView) m10969a((int) R.id.iv_img_arrow);
        this.f15271A = (CouponView) m10969a((int) R.id.real_time_coupon_v);
        this.f15290s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (RealTimePriceViewV2.this.f15292u.getVisibility() == 0) {
                    RealTimePriceViewV2.this.f15272a.paywayChange(RealTimePriceViewV2.this.f15291t);
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.OnService.EVENT_PAYWAY_CHANGE_GUIDE_DISMISS);
            }
        });
    }

    public View getView() {
        return this.f15273b;
    }

    public void setPresenter(AbsRealTimePricePresenter absRealTimePricePresenter) {
        this.f15272a = absRealTimePricePresenter;
    }

    public void setData(RealTimePrice realTimePrice) {
        String str;
        if (realTimePrice == null) {
            return;
        }
        if (!TextUtils.isEmpty(realTimePrice.meterFare) || !TextUtils.isEmpty(realTimePrice.totalPrice)) {
            hideLoading();
            this.f15283l = realTimePrice.isDetailPriceClosed;
            this.f15275d.setVisibility(0);
            if (!TextUtils.isEmpty(realTimePrice.meterFare)) {
                str = realTimePrice.meterFare;
            } else {
                str = this.f15272a.getPrice(realTimePrice);
            }
            PriceUtils.setFeeDisplayForTextView(this.f15275d, str);
            m10972a(str);
        }
    }

    public void showLoading() {
        this.f15275d.setVisibility(4);
        this.f15277f = true;
    }

    public void hideLoading() {
        this.f15277f = false;
    }

    public boolean isLoading() {
        return this.f15277f;
    }

    public void setOnActionListener(IRealTimePriceView.OnActionListener onActionListener) {
        this.f15276e = onActionListener;
    }

    /* renamed from: a */
    private void m10971a() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.couponInfo != null && !TextUtils.isEmpty(order.couponInfo.couponText)) {
            this.f15280i.setVisibility(0);
            this.f15280i.setText(order.couponInfo.couponText);
        }
    }

    public void setPayWay(String str) {
        this.f15274c.setText(str);
    }

    /* renamed from: a */
    private void m10972a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f15275d.setContentDescription(this.f15273b.getContext().getString(R.string.global_accessible_real_time_price, new Object[]{str}));
        }
    }

    /* renamed from: a */
    private <T extends View> T m10969a(int i) {
        return this.f15273b.findViewById(i);
    }

    public void setData(PayInfo payInfo) {
        this.f15291t = payInfo;
        if (CollectionUtils.isEmpty((Collection) payInfo.payWayList)) {
            this.f15292u.setVisibility(8);
        } else {
            this.f15292u.setVisibility(0);
        }
        if (!CollectionUtils.isEmpty((Collection) payInfo.paywayItems)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < payInfo.paywayItems.size(); i++) {
                SelectPaywayItem selectPaywayItem = payInfo.paywayItems.get(i);
                if (selectPaywayItem != null && !TextUtils.isEmpty(selectPaywayItem.paywayText)) {
                    sb.append(selectPaywayItem.paywayText);
                    if (i < payInfo.paywayItems.size() - 1) {
                        sb.append("+");
                    }
                }
            }
            this.f15274c.setText(m10975b(sb.toString()));
            if (this.f15274c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15274c.getLayoutParams();
                layoutParams.removeRule(17);
                if (payInfo.paywayItems.size() == 2) {
                    this.f15287p.setVisibility(0);
                    this.f15285n.setVisibility(8);
                    Glide.with(this.f15278g).asBitmap().load(payInfo.paywayItems.get(0).paywayUrl).into(this.f15288q);
                    Glide.with(this.f15278g).asBitmap().load(payInfo.paywayItems.get(1).paywayUrl).into(this.f15289r);
                    layoutParams.addRule(17, R.id.combine_payway);
                } else {
                    this.f15287p.setVisibility(8);
                    this.f15285n.setVisibility(0);
                    Glide.with(this.f15278g).asBitmap().load(payInfo.paywayItems.get(0).paywayUrl).into(this.f15285n);
                    layoutParams.addRule(17, R.id.real_time_pay_way_ic);
                }
            }
        }
        if (!TextUtils.isEmpty(payInfo.totalFee)) {
            this.f15275d.setText(payInfo.totalFee);
            this.f15275d.setVisibility(0);
        }
        if (!TextUtils.isEmpty(payInfo.originFee)) {
            this.f15286o.setVisibility(0);
            this.f15286o.setText(payInfo.originFee);
            this.f15286o.getPaint().setFlags(16);
        } else {
            this.f15286o.setVisibility(8);
        }
        if (payInfo.payBrandRich == null || TextUtils.isEmpty(payInfo.payBrandRich.getContent())) {
            this.f15284m.setVisibility(8);
        } else {
            payInfo.payBrandRich.bindTextView(this.f15284m);
            this.f15284m.setVisibility(0);
        }
        if (payInfo.mPayAssistorModule != null) {
            GGKData gGKData = new GGKData();
            gGKData.parse(payInfo.mPayAssistorModule);
            if (gGKData.getData() != null) {
                JSONObject data = gGKData.getData();
                this.f15271A.setVisibility(0);
                this.f15271A.bindData((CouponView.CouponModel) new Gson().fromJson(data.toString(), CouponView.CouponModel.class));
            } else {
                this.f15271A.setVisibility(8);
            }
        } else {
            this.f15271A.setVisibility(8);
        }
        if (payInfo != null && !TextUtils.isEmpty(payInfo.changeResultText)) {
            ToastHelper.showShortInfo(this.f15278g, payInfo.changeResultText, (int) R.drawable.icon_toast_success);
        }
        float[] fArr = {UIUtils.dip2px(this.f15278g, 12.0f), UIUtils.dip2px(this.f15278g, 12.0f), 0.0f, 0.0f, UIUtils.dip2px(this.f15278g, 12.0f), UIUtils.dip2px(this.f15278g, 12.0f), 0.0f, 0.0f};
        if (!TextUtils.isEmpty(payInfo.payBrandBgStart) && !TextUtils.isEmpty(payInfo.payBrandBgEnd)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{Color.parseColor(payInfo.payBrandBgStart), Color.parseColor(payInfo.payBrandBgEnd)});
            gradientDrawable.setCornerRadii(fArr);
            this.f15284m.setBackground(gradientDrawable);
        }
        tracePaymentShow(this.f15291t.paymentsType);
    }

    /* renamed from: b */
    private String m10975b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Pattern.compile("[.]").matcher(str).replaceAll("").trim();
        }
        return "";
    }

    public void tracePaymentShow(int i) {
        int i2 = this.f15297z;
        int i3 = (i2 <= 0 || i <= 0) ? -1 : i2 != i ? 1 : 0;
        this.f15297z = i;
        if (i3 > -1) {
            if (OrderStatus.isWaitResponse(CarOrderHelper.getOrder()) && (!this.f15294w || i3 == 1)) {
                m10973a("wait_reply_page", i3, i);
                this.f15294w = true;
            }
            if (CarOrderHelper.isWaitDriver() && (!this.f15295x || i3 == 1)) {
                m10973a("wait_driver_page", i3, i);
                this.f15295x = true;
            }
            if (!CarOrderHelper.isOnService()) {
                return;
            }
            if (!this.f15296y || i3 == 1) {
                m10973a("in_trip_page", i3, i);
                this.f15296y = true;
            }
        }
    }

    /* renamed from: a */
    private void m10973a(String str, int i, int i2) {
        this.f15293v.put(GlobalPayOmegaConstant.EventKey.TAB, str);
        this.f15293v.put("style", Integer.valueOf(this.f15280i.getVisibility() == 0 ? 1 : 0));
        PayInfo payInfo = this.f15291t;
        if (!(payInfo == null || payInfo.mLog == null)) {
            try {
                this.f15293v.putAll((Map) new Gson().fromJson(this.f15291t.mLog.toString(), new TypeToken<HashMap<String, Object>>() {
                }.getType()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f15293v.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        this.f15293v.put("ischange", Integer.valueOf(i));
        this.f15293v.put("paytype", Integer.valueOf(i2));
        GlobalOmegaUtils.trackEvent("ibt_gp_payment_sw", this.f15293v);
        this.f15293v.clear();
    }
}
