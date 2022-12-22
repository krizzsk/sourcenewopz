package com.didi.component.estimate.newui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.util.Utils;
import com.didi.component.common.util.ActivityUtil;
import com.didi.component.common.util.StringUtil;
import com.didi.component.estimate.newui.view.EstimateDetailShareCarView;
import com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstimateDetailPageView extends ConstraintLayout {

    /* renamed from: a */
    private static final float f13065a = 0.18f;

    /* renamed from: b */
    private static final float f13066b = 0.5f;

    /* renamed from: c */
    private static final int f13067c = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<CarDetailModel> f13068d = new ArrayList();

    /* renamed from: e */
    private Context f13069e;

    /* renamed from: f */
    private View f13070f;

    /* renamed from: g */
    private TextView f13071g;

    /* renamed from: h */
    private TextView f13072h;

    /* renamed from: i */
    private TextView f13073i;

    /* renamed from: j */
    private LinearLayout f13074j;

    /* renamed from: k */
    private View f13075k;

    /* renamed from: l */
    private TextView f13076l;

    /* renamed from: m */
    private ImageView f13077m;

    /* renamed from: n */
    private ImageView f13078n;

    /* renamed from: o */
    private CarDetailFeeListView f13079o;

    /* renamed from: p */
    private FrameLayout f13080p;

    /* renamed from: q */
    private FrameLayout f13081q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public EstimateItemModel f13082r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public AnyCarEstimateItemModel f13083s;

    public EstimateDetailPageView(Context context, List<CarDetailModel> list, EstimateItemModel estimateItemModel) {
        super(context);
        this.f13068d = list;
        this.f13069e = context;
        this.f13070f = LayoutInflater.from(context).inflate(R.layout.estimate_detail_item, this, true);
        this.f13082r = estimateItemModel;
        m8888a();
    }

    public EstimateDetailPageView(Context context, List<CarDetailModel> list, AnyCarEstimateItemModel anyCarEstimateItemModel) {
        super(context);
        this.f13068d = list;
        this.f13069e = context;
        this.f13070f = LayoutInflater.from(context).inflate(R.layout.estimate_detail_item, this, true);
        this.f13083s = anyCarEstimateItemModel;
        m8888a();
    }

    public EstimateDetailPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EstimateDetailPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m8888a() {
        this.f13071g = (TextView) this.f13070f.findViewById(R.id.car_detail_name);
        this.f13072h = (TextView) this.f13070f.findViewById(R.id.car_detail_desc);
        this.f13073i = (TextView) this.f13070f.findViewById(R.id.car_detail_eta);
        this.f13074j = (LinearLayout) this.f13070f.findViewById(R.id.car_detail_seat_ll);
        this.f13076l = (TextView) this.f13070f.findViewById(R.id.car_detail_seat_tv);
        this.f13077m = (ImageView) this.f13070f.findViewById(R.id.car_detail_seat_ic);
        this.f13078n = (ImageView) this.f13070f.findViewById(R.id.car_detail_icon);
        this.f13081q = (FrameLayout) this.f13070f.findViewById(R.id.car_detail_icon_ll);
        View findViewById = this.f13070f.findViewById(R.id.car_bottom_shadow_view);
        this.f13075k = findViewById;
        findViewById.setBackground(getResources().getDrawable(Utils.isBrazilPackage(this.f13069e) ? R.drawable.estimate_car_detail_popup_shadow_99 : R.drawable.estimate_car_detail_popup_shadow));
        this.f13079o = (CarDetailFeeListView) this.f13070f.findViewById(R.id.estimate_detail_fee_list);
        this.f13080p = (FrameLayout) this.f13070f.findViewById(R.id.estimate_detail_share_car_container);
        if (this.f13068d.size() > 1 && this.f13068d.get(0).carTwoPrice != null) {
            this.f13079o.setVisibility(8);
            this.f13080p.setVisibility(0);
            this.f13080p.addView(new EstimateDetailShareCarView(this.f13069e, this.f13068d, this.f13083s, new EstimateDetailShareCarView.ShareCarTabListener() {
                public void chooseTab(int i) {
                    EstimateDetailPageView estimateDetailPageView = EstimateDetailPageView.this;
                    estimateDetailPageView.m8893a((CarDetailModel) estimateDetailPageView.f13068d.get(i));
                    if (EstimateDetailPageView.this.f13083s != null) {
                        EstimateDetailPageView estimateDetailPageView2 = EstimateDetailPageView.this;
                        estimateDetailPageView2.m8892a(estimateDetailPageView2.f13083s, i);
                        return;
                    }
                    EstimateDetailPageView estimateDetailPageView3 = EstimateDetailPageView.this;
                    estimateDetailPageView3.m8894a(estimateDetailPageView3.f13082r, i);
                }
            }));
            m8893a(this.f13068d.get(0));
        } else if (this.f13068d.size() > 0) {
            CarDetailModel carDetailModel = this.f13068d.get(0);
            this.f13080p.removeAllViews();
            this.f13080p.setVisibility(8);
            this.f13079o.setVisibility(0);
            this.f13079o.setData(carDetailModel.carDetailFeeInfo);
            m8893a(carDetailModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8894a(EstimateItemModel estimateItemModel, int i) {
        HashMap hashMap = new HashMap();
        if (!(estimateItemModel == null || estimateItemModel.carConfig == null)) {
            hashMap.put("bubble_id", estimateItemModel.carConfig.estimateId);
            hashMap.put("product_id", Integer.valueOf(estimateItemModel.carConfig.carProductId));
            hashMap.put("combo_type", Integer.valueOf(estimateItemModel.carConfig.carComboType));
            hashMap.put("cartype", Integer.valueOf(estimateItemModel.carConfig.carLevel));
            hashMap.put("action_type", Integer.valueOf(i));
            if (estimateItemModel.carConfig.extraData != null) {
                estimateItemModel.carConfig.extraData.putAllExtraLog(hashMap);
            }
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_cartypedetail_notmatch_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8892a(AnyCarEstimateItemModel anyCarEstimateItemModel, int i) {
        HashMap hashMap = new HashMap();
        if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null)) {
            AnyCarConfigModel anyCarConfigModel = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig;
            hashMap.put("bubble_id", anyCarConfigModel.estimateId);
            hashMap.put("product_id", Integer.valueOf(anyCarConfigModel.carProductId));
            hashMap.put("combo_type", Integer.valueOf(anyCarConfigModel.carComboType));
            hashMap.put("cartype", Integer.valueOf(anyCarConfigModel.carLevel));
            hashMap.put("action_type", Integer.valueOf(i));
            if (anyCarConfigModel.extraData != null) {
                anyCarConfigModel.extraData.putAllExtraLog(hashMap);
            }
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_cartypedetail_notmatch_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8893a(CarDetailModel carDetailModel) {
        if (!StringUtil.isNullOrEmpty(carDetailModel.carName)) {
            this.f13071g.setText(carDetailModel.carName);
        }
        if (!StringUtil.isNullOrEmpty(carDetailModel.carIcon)) {
            this.f13078n.setVisibility(0);
            Glide.with(this.f13069e.getApplicationContext()).load(carDetailModel.carIcon).into(this.f13078n);
        } else {
            this.f13078n.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(carDetailModel.carDesc)) {
            this.f13072h.setVisibility(0);
            this.f13072h.setText(carDetailModel.carDesc);
        } else {
            this.f13072h.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(carDetailModel.carEta)) {
            this.f13073i.setVisibility(0);
            this.f13073i.setText(carDetailModel.carEta);
        } else {
            this.f13073i.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(carDetailModel.carSeatNum)) {
            this.f13074j.setVisibility(0);
            this.f13076l.setText(carDetailModel.carSeatNum);
            if (!ActivityUtil.isActivityDestroyed(this.f13069e)) {
                ((RequestBuilder) Glide.with(this.f13069e).load(carDetailModel.carSeatIcon).placeholder((int) R.drawable.estimate_seat_people)).into(this.f13077m);
                return;
            }
            return;
        }
        this.f13074j.setVisibility(8);
    }

    public void startAnimOfPositive(float f) {
        float f2 = f > 0.5f ? 0.0f : (0.5f - f) * 2.0f;
        float screenWidth = (float) ((int) (((float) UiUtils.getScreenWidth(this.f13069e)) * f));
        this.f13071g.setAlpha(f2);
        this.f13072h.setAlpha(f2);
        this.f13073i.setAlpha(f2);
        this.f13074j.setAlpha(f2);
        this.f13079o.setAlpha(f2);
        this.f13080p.setAlpha(f2);
        this.f13078n.setTranslationX(screenWidth);
        if (!Utils.isBrazilPackage(this.f13069e)) {
            this.f13078n.setTranslationY(-(screenWidth * f13065a));
        }
    }

    public void resetAnim() {
        this.f13071g.setAlpha(1.0f);
        this.f13072h.setAlpha(1.0f);
        this.f13073i.setAlpha(1.0f);
        this.f13074j.setAlpha(1.0f);
        this.f13079o.setAlpha(1.0f);
        this.f13080p.setAlpha(1.0f);
        this.f13078n.setTranslationX(0.0f);
        if (!Utils.isBrazilPackage(this.f13069e)) {
            this.f13078n.setTranslationY(0.0f);
        }
    }

    public void startAnimOfMinus(float f) {
        float f2 = 0.0f;
        float f3 = 1.0f;
        int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
        if (!(i == 0 || f == 0.0f)) {
            f3 = 1.0f - (2.0f * f);
        }
        if (!(i == 0 || f == 0.0f)) {
            f2 = (float) ((int) (((float) UiUtils.getScreenWidth(this.f13069e)) * f));
        }
        this.f13071g.setAlpha(f3);
        this.f13072h.setAlpha(f3);
        this.f13073i.setAlpha(f3);
        this.f13074j.setAlpha(f3);
        this.f13079o.setAlpha(f3);
        this.f13080p.setAlpha(f3);
        this.f13078n.setTranslationX(-f2);
        if (!Utils.isBrazilPackage(this.f13069e)) {
            this.f13078n.setTranslationY(f2 * f13065a);
        }
    }
}
