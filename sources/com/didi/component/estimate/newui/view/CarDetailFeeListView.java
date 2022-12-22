package com.didi.component.estimate.newui.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.adapter.CommonRvAdapter;
import com.didi.component.common.adapter.CommonRvVH;
import com.didi.component.common.p101h5.PriceDetailWebActivity;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.StringUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailCouponModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailFeeDescModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailFeeInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailFeeItemModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailFeeRuleModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDetailFeeListView extends FrameLayout {

    /* renamed from: a */
    private View f13032a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<Object> f13033b = new ArrayList();

    /* renamed from: c */
    private CarDetailFeeInfoModel f13034c;

    /* renamed from: d */
    private CommonRvAdapter f13035d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f13036e;

    /* renamed from: f */
    private boolean f13037f;

    /* renamed from: g */
    private AnyCarEstimateItemModel f13038g;

    public CarDetailFeeListView(Context context, AnyCarEstimateItemModel anyCarEstimateItemModel) {
        super(context);
        this.f13036e = context;
        this.f13038g = anyCarEstimateItemModel;
        m8859a(context);
    }

    public CarDetailFeeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13036e = context;
        m8859a(context);
    }

    public CarDetailFeeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13036e = context;
        m8859a(context);
    }

    /* renamed from: a */
    private void m8859a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.estimate_detail_fee_list, this, true);
        this.f13032a = inflate;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.car_detail_fee_list);
        this.f13035d = new CommonRvAdapter(context) {
            public int getLayoutResourceId(int i) {
                return CarDetailFeeListView.this.m8856a(i);
            }

            public void bindData(CommonRvVH commonRvVH, int i) {
                Object obj = CarDetailFeeListView.this.f13033b.get(i);
                if (obj instanceof CarDetailFeeItemModel) {
                    TextView textView = commonRvVH.getTextView(R.id.detail_fare_normal_item_name);
                    TextView textView2 = commonRvVH.getTextView(R.id.detail_fare_normal_item_value);
                    CarDetailFeeItemModel carDetailFeeItemModel = (CarDetailFeeItemModel) obj;
                    if (carDetailFeeItemModel.feeItemText == null || TextUtils.isEmpty(carDetailFeeItemModel.feeItemText.getContent())) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                        carDetailFeeItemModel.feeItemText.bindTextView(textView);
                    }
                    if (carDetailFeeItemModel.feeItemValue == null || TextUtils.isEmpty(carDetailFeeItemModel.feeItemValue.getContent())) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setVisibility(0);
                        carDetailFeeItemModel.feeItemValue.bindTextView(textView2);
                    }
                }
                if (obj instanceof CarDetailCouponModel) {
                    TextView textView3 = commonRvVH.getTextView(R.id.detail_fare_coupon_item_name);
                    TextView textView4 = commonRvVH.getTextView(R.id.detail_fare_coupon_item_value);
                    CarDetailCouponModel carDetailCouponModel = (CarDetailCouponModel) obj;
                    if (carDetailCouponModel.couponText == null || TextUtils.isEmpty(carDetailCouponModel.couponText.getContent())) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setVisibility(0);
                        carDetailCouponModel.couponText.bindTextView(textView3);
                    }
                    if (carDetailCouponModel.couponValue == null || TextUtils.isEmpty(carDetailCouponModel.couponValue.getContent())) {
                        textView4.setVisibility(8);
                    } else {
                        textView4.setVisibility(0);
                        carDetailCouponModel.couponValue.bindTextView(textView4);
                    }
                }
                if (obj instanceof CarDetailFeeDescModel) {
                    TextView textView5 = commonRvVH.getTextView(R.id.detail_fare_desc_item);
                    CarDetailFeeDescModel carDetailFeeDescModel = (CarDetailFeeDescModel) obj;
                    if (carDetailFeeDescModel.DetailDescContent == null || TextUtils.isEmpty(carDetailFeeDescModel.DetailDescContent.getContent())) {
                        textView5.setVisibility(8);
                    } else {
                        textView5.setVisibility(0);
                        carDetailFeeDescModel.DetailDescContent.bindTextView(textView5);
                    }
                    TextView textView6 = commonRvVH.getTextView(R.id.destail_fare_desc_title);
                    if (carDetailFeeDescModel.detailDescTitle == null || TextUtils.isEmpty(carDetailFeeDescModel.detailDescTitle.getContent())) {
                        textView6.setVisibility(8);
                    } else {
                        textView6.setVisibility(0);
                        carDetailFeeDescModel.detailDescTitle.bindTextView(textView6);
                    }
                }
                if (obj instanceof CarDetailFeeRuleModel) {
                    TextView textView7 = commonRvVH.getTextView(R.id.detail_fare_rule_tv);
                    final LinearLayout linearLayout = (LinearLayout) commonRvVH.getTargetView(R.id.fare_rules_ll);
                    final CarDetailFeeRuleModel carDetailFeeRuleModel = (CarDetailFeeRuleModel) obj;
                    if (!TextUtils.isEmpty(carDetailFeeRuleModel.feeRuleDesc)) {
                        textView7.setVisibility(0);
                        textView7.setText(carDetailFeeRuleModel.feeRuleDesc);
                        textView7.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                AutoTrackHelper.trackViewOnClick(view);
                                CarDetailFeeListView.this.sendOmegaEvent();
                                if (!StringUtil.isNullOrEmpty(carDetailFeeRuleModel.feeRuleLink)) {
                                    Intent intent = new Intent(CarDetailFeeListView.this.f13036e, PriceDetailWebActivity.class);
                                    intent.setFlags(268435456);
                                    intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(carDetailFeeRuleModel.feeRuleLink));
                                    CarDetailFeeListView.this.f13036e.startActivity(intent);
                                    return;
                                }
                                linearLayout.setVisibility(8);
                            }
                        });
                        return;
                    }
                    textView7.setVisibility(8);
                    linearLayout.setVisibility(8);
                }
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(this.f13035d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m8856a(int i) {
        Object obj = this.f13033b.get(i);
        if (obj instanceof CarDetailFeeItemModel) {
            return R.layout.estimate_detail_fare_item_normal;
        }
        if (obj instanceof CarDetailCouponModel) {
            return R.layout.estimate_detail_fare_item_discount;
        }
        if (obj instanceof CarDetailFeeDescModel) {
            return R.layout.estimate_detail_fare_explanation_item;
        }
        if (obj instanceof CarDetailFeeRuleModel) {
            return R.layout.estimate_detail_fare_rules;
        }
        return R.layout.estimate_detail_fare_item_normal;
    }

    public void setData(CarDetailFeeInfoModel carDetailFeeInfoModel) {
        if (carDetailFeeInfoModel != null) {
            this.f13034c = carDetailFeeInfoModel;
            this.f13033b.clear();
            if (!CollectionUtils.isEmpty((Collection) this.f13034c.feesList)) {
                this.f13033b.addAll(this.f13034c.feesList);
            }
            if (!CollectionUtils.isEmpty((Collection) this.f13034c.carDeatilCoupon)) {
                this.f13033b.addAll(this.f13034c.carDeatilCoupon);
                this.f13037f = true;
            } else {
                this.f13037f = false;
            }
            if (this.f13034c.carDetailFeeDesc != null) {
                this.f13033b.add(this.f13034c.carDetailFeeDesc);
            }
            if (this.f13034c.carDetailFeeRule != null) {
                this.f13033b.add(this.f13034c.carDetailFeeRule);
            }
            this.f13035d.setMData(this.f13033b);
            this.f13035d.notifyDataSetChanged();
        }
    }

    public void sendOmegaEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", this.f13037f ? "1" : "2");
        AnyCarEstimateItemModel anyCarEstimateItemModel = this.f13038g;
        if (anyCarEstimateItemModel == null) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (!(newEstimateItem == null || newEstimateItem.carConfig == null)) {
                hashMap.put("cartype", Integer.valueOf(newEstimateItem.carConfig.carLevel));
                if (newEstimateItem.carConfig.extraData != null) {
                    newEstimateItem.carConfig.extraData.putAllExtraLog(hashMap);
                }
            }
        } else if (anyCarEstimateItemModel.mAnyCarEstimateNetItem != null) {
            hashMap.put("cartype", Integer.valueOf(this.f13038g.mAnyCarEstimateNetItem.carConfig.carLevel));
            if (this.f13038g.mAnyCarEstimateNetItem.carConfig.extraData != null) {
                this.f13038g.mAnyCarEstimateNetItem.carConfig.extraData.putAllExtraLog(hashMap);
            }
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_cartypedetail_price_ck", (Map<String, Object>) hashMap);
    }
}
