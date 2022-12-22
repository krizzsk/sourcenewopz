package com.didiglobal.comp.carmodellist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.component.common.util.StringUtil;
import com.didi.component.common.util.UIUtils;
import com.didi.global.globalgenerickit.template.yoga.util.NinePatchBuilder;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.estimate.CarInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel;
import com.didiglobal.comp.carmodellist.common.AnyCarSelectListener;
import com.didiglobal.comp.carmodellist.optionarea.estimatepass.AnyCarModelEstimateOptionsView;
import com.didiglobal.travel.util.CollectionUtils;
import com.taxis99.R;
import java.util.Collection;
import java.util.Iterator;

public class AnyCarVH extends BaseVH<AnyCarEstimateItemModel> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f49762a = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f49763b;

    /* renamed from: c */
    private View f49764c;
    public TextView carDesc;
    public ImageView carIcon;
    public ConstraintLayout carInfoContainer;
    public ImageView carPeopleIcon;
    public TextView carSeatNum;
    public TextView carTagGuide;
    public TextView carTitle;

    /* renamed from: d */
    private View f49765d;
    public View divider;

    /* renamed from: e */
    private View f49766e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f49767f;

    /* renamed from: g */
    private TextView f49768g;

    /* renamed from: h */
    private ImageView f49769h;
    public LinearLayout hybridIconAndTextLL;

    /* renamed from: i */
    private ImageView f49770i;

    /* renamed from: j */
    private ImageView f49771j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AnyCarEstimateItemModel f49772k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f49773l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public AnyCarSelectListener f49774m;
    public AnyCarModelEstimateOptionsView mOperationsView;
    public LinearLayout priceTextLL;

    public AnyCarVH(View view) {
        super(view);
        this.f49763b = view.getContext();
        this.f49764c = view.findViewById(R.id.anycar_item_container);
        this.f49765d = view.findViewById(R.id.anycar_divider_first_single_select);
        this.f49766e = view.findViewById(R.id.anycar_rec_item_bg_container);
        this.f49767f = view.findViewById(R.id.anycar_rec_daily_container);
        this.f49768g = (TextView) view.findViewById(R.id.anycar_rec_daily_tv);
        this.carIcon = (ImageView) view.findViewById(R.id.anycar_item_car_icon_iv);
        this.carTitle = (TextView) view.findViewById(R.id.anycar_item_car_name);
        this.carDesc = (TextView) view.findViewById(R.id.anycar_item_eta_tv);
        this.carSeatNum = (TextView) view.findViewById(R.id.anycar_item_seat_num);
        this.carPeopleIcon = (ImageView) view.findViewById(R.id.anycar_item_people_icon);
        this.carTagGuide = (TextView) view.findViewById(R.id.anycar_item_guide);
        this.divider = view.findViewById(R.id.anycar_item_divider);
        this.carInfoContainer = (ConstraintLayout) view.findViewById(R.id.anycar_item_info_container);
        this.hybridIconAndTextLL = (LinearLayout) view.findViewById(R.id.anycar_item_hybrid_icon_and_text_ll);
        this.priceTextLL = (LinearLayout) view.findViewById(R.id.anycar_item_price_list_ll);
        this.mOperationsView = (AnyCarModelEstimateOptionsView) view.findViewById(R.id.new_estimate_operation_list);
        this.f49769h = (ImageView) view.findViewById(R.id.anycar_item_select_cb);
        this.f49770i = (ImageView) view.findViewById(R.id.anycar_item_goto_img);
        this.f49771j = (ImageView) view.findViewById(R.id.anycar_open_detail_img);
    }

    public void setSelectListener(AnyCarSelectListener anyCarSelectListener) {
        this.f49774m = anyCarSelectListener;
    }

    public void bindData(final AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (anyCarEstimateItemModel != null) {
            this.f49772k = anyCarEstimateItemModel;
            CarInfoModel carInfoModel = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carInfo;
            if (carInfoModel != null) {
                if (!StringUtil.isNullOrEmpty(carInfoModel.carIcon)) {
                    Glide.with(this.f49763b).load(carInfoModel.carIcon).into(this.carIcon);
                }
                if (!StringUtil.isNullOrEmpty(carInfoModel.carName)) {
                    this.carTitle.setText(carInfoModel.carName);
                }
                m35893a(anyCarEstimateItemModel);
                if (!TextUtils.isEmpty(carInfoModel.carSeatNum)) {
                    this.carSeatNum.setVisibility(0);
                    this.carPeopleIcon.setVisibility(0);
                    this.carSeatNum.setText(carInfoModel.carSeatNum);
                    ((RequestBuilder) Glide.with(this.f49763b).load(carInfoModel.carSeatIcon).placeholder((int) R.drawable.car_model_icon_seat_people)).into(this.carPeopleIcon);
                } else {
                    this.carSeatNum.setVisibility(8);
                    this.carPeopleIcon.setVisibility(8);
                }
                if (!CollectionUtils.isEmpty((Collection<?>) carInfoModel.carPriceInfo)) {
                    this.priceTextLL.removeAllViews();
                    this.priceTextLL.setVisibility(0);
                    for (int i = 0; i < carInfoModel.carPriceInfo.size(); i++) {
                        CarInfoPriceModel carInfoPriceModel = carInfoModel.carPriceInfo.get(i);
                        if (!(carInfoPriceModel == null || carInfoPriceModel.carPrice == null || StringUtil.isNullOrEmpty(carInfoPriceModel.carPrice.getContent()))) {
                            View inflate = LayoutInflater.from(this.f49763b).inflate(R.layout.car_model_estimate_item_price_item_vertical, this.priceTextLL, false);
                            inflate.setPadding(0, 0, 0, UiUtils.dip2px(this.f49763b, (float) (carInfoPriceModel.lineSpacing / 2)));
                            this.priceTextLL.addView(inflate);
                            m35894a(carInfoPriceModel, inflate);
                        }
                    }
                }
                if (carInfoModel.hybridIconAndTextList == null || carInfoModel.hybridIconAndTextList.size() <= 0) {
                    this.hybridIconAndTextLL.setVisibility(8);
                } else {
                    this.hybridIconAndTextLL.removeAllViews();
                    this.hybridIconAndTextLL.setVisibility(0);
                    for (int size = carInfoModel.hybridIconAndTextList.size() - 1; size >= 0; size--) {
                        CarInfoModel.hybridIconAndText hybridiconandtext = carInfoModel.hybridIconAndTextList.get(size);
                        if (hybridiconandtext.type == 1 && !StringUtil.isNullOrEmpty(hybridiconandtext.icon)) {
                            View inflate2 = LayoutInflater.from(this.f49763b).inflate(R.layout.car_model_estimate_item_dynamic_layout, this.hybridIconAndTextLL, false);
                            this.hybridIconAndTextLL.addView(inflate2);
                            inflate2.setVisibility(0);
                            ImageView imageView = (ImageView) inflate2.findViewById(R.id.new_estimate_dynamic);
                            imageView.setVisibility(0);
                            Glide.with(this.f49763b).load(hybridiconandtext.icon).into(imageView);
                            if (carInfoModel.hybridIconAndTextList.size() == 1) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate2.getLayoutParams();
                                layoutParams.bottomMargin = UiUtils.dip2px(this.f49763b, 3.0f);
                                layoutParams.rightMargin = UiUtils.dip2px(this.f49763b, 0.0f);
                                inflate2.setLayoutParams(layoutParams);
                            }
                        } else if (hybridiconandtext.type != 2 || hybridiconandtext.info == null || StringUtil.isNullOrEmpty(hybridiconandtext.info.getContent())) {
                            if (hybridiconandtext.type == 3 && hybridiconandtext.info != null && !StringUtil.isNullOrEmpty(hybridiconandtext.info.getContent())) {
                                View inflate3 = LayoutInflater.from(this.f49763b).inflate(R.layout.car_model_estimate_item_discount_icon_text_layout, this.hybridIconAndTextLL, false);
                                this.hybridIconAndTextLL.addView(inflate3);
                                inflate3.setVisibility(0);
                                ImageView imageView2 = (ImageView) inflate3.findViewById(R.id.new_estimate_discount_icon);
                                if (!StringUtil.isNullOrEmpty(hybridiconandtext.icon)) {
                                    imageView2.setVisibility(0);
                                    Glide.with(this.f49763b).load(hybridiconandtext.icon).into(imageView2);
                                } else {
                                    imageView2.setVisibility(8);
                                }
                                TextView textView = (TextView) inflate3.findViewById(R.id.new_estimate_discount);
                                textView.setVisibility(0);
                                textView.setTextDirection(3);
                                hybridiconandtext.info.bindTextView(textView);
                                if (!StringUtil.isNullOrEmpty(hybridiconandtext.colorStart) && !StringUtil.isNullOrEmpty(hybridiconandtext.colorEnd)) {
                                    GradientDrawable gradientDrawable = new GradientDrawable();
                                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                                    gradientDrawable.setColors(new int[]{Color.parseColor(hybridiconandtext.colorStart), Color.parseColor(hybridiconandtext.colorEnd)});
                                    gradientDrawable.setCornerRadius(UIUtils.dip2px(this.f49763b, 6.0f));
                                    inflate3.setBackground(gradientDrawable);
                                }
                            }
                        } else if (StringUtil.isNullOrEmpty(hybridiconandtext.colorStart) || StringUtil.isNullOrEmpty(hybridiconandtext.colorEnd)) {
                            View inflate4 = LayoutInflater.from(this.f49763b).inflate(R.layout.car_model_estimate_item_origin_price_layout, this.hybridIconAndTextLL, false);
                            this.hybridIconAndTextLL.addView(inflate4);
                            inflate4.setVisibility(0);
                            TextView textView2 = (TextView) inflate4.findViewById(R.id.new_estimate_origin_price);
                            textView2.setVisibility(0);
                            textView2.setTextDirection(3);
                            hybridiconandtext.info.bindTextView(textView2);
                        } else {
                            View inflate5 = LayoutInflater.from(this.f49763b).inflate(R.layout.car_model_estimate_item_discount_icon_text_layout, this.hybridIconAndTextLL, false);
                            this.hybridIconAndTextLL.addView(inflate5);
                            inflate5.setVisibility(0);
                            ((ImageView) inflate5.findViewById(R.id.new_estimate_discount_icon)).setVisibility(8);
                            TextView textView3 = (TextView) inflate5.findViewById(R.id.new_estimate_discount);
                            textView3.setTextDirection(3);
                            textView3.setVisibility(0);
                            hybridiconandtext.info.bindTextView(textView3);
                            GradientDrawable gradientDrawable2 = new GradientDrawable();
                            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                            gradientDrawable2.setColors(new int[]{Color.parseColor(hybridiconandtext.colorStart), Color.parseColor(hybridiconandtext.colorEnd)});
                            gradientDrawable2.setCornerRadius(UIUtils.dip2px(this.f49763b, 6.0f));
                            inflate5.setBackground(gradientDrawable2);
                        }
                    }
                }
                if (CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation)) {
                    this.mOperationsView.setVisibility(8);
                } else {
                    this.mOperationsView.setData(anyCarEstimateItemModel, this.f49774m);
                }
                if (!StringUtil.isNullOrEmpty(carInfoModel.tagBubbleText)) {
                    this.carTagGuide.setVisibility(0);
                    this.carTagGuide.setText(carInfoModel.tagBubbleText);
                } else {
                    this.carTagGuide.setVisibility(8);
                }
                this.divider.setVisibility(0);
            }
            AnyCarConfigModel anyCarConfigModel = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig;
            if (anyCarConfigModel != null) {
                ViewGroup.LayoutParams layoutParams2 = this.f49764c.getLayoutParams();
                if (anyCarConfigModel.carGroupArea == 0) {
                    this.divider.setVisibility(8);
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                        marginLayoutParams.topMargin = UiUtils.dip2px(this.f49763b, 6.0f);
                        marginLayoutParams.bottomMargin = UiUtils.dip2px(this.f49763b, -2.0f);
                        this.f49764c.setLayoutParams(layoutParams2);
                    }
                    this.f49764c.setPadding(UiUtils.dip2px(this.f49763b, 9.0f), UiUtils.dip2px(this.f49763b, 4.0f), UiUtils.dip2px(this.f49763b, 9.0f), UiUtils.dip2px(this.f49763b, 8.0f));
                    this.f49764c.setBackgroundResource(R.drawable.anycar_item_rec_bg);
                    ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                    if (confirmListener != null && confirmListener.getAnyCarResponse() != null && !CollectionUtil.isEmpty((Collection<?>) confirmListener.getAnyCarResponse().groups)) {
                        Iterator<AnyCarGroup> it = confirmListener.getAnyCarResponse().groups.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            AnyCarGroup next = it.next();
                            if (next.recommendDaily != null && !TextUtils.isEmpty(next.recommendDaily.bgIcon) && next.recommendDaily.content != null && !TextUtils.isEmpty(next.recommendDaily.content.getContent())) {
                                this.f49767f.setVisibility(0);
                                next.recommendDaily.content.bindTextView(this.f49768g);
                                Glide.with(this.f49763b).asBitmap().load(next.recommendDaily.bgIcon).into(new CustomTarget<Bitmap>() {
                                    public void onLoadCleared(Drawable drawable) {
                                    }

                                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                                        NinePatchDrawable build = new NinePatchBuilder(AnyCarVH.this.f49763b.getResources(), bitmap).addXCenteredRegion(2).build();
                                        if (build != null) {
                                            AnyCarVH.this.f49767f.setBackground(build);
                                        }
                                    }
                                });
                                break;
                            }
                        }
                    } else {
                        this.f49767f.setVisibility(8);
                    }
                } else {
                    this.divider.setVisibility(0);
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        marginLayoutParams2.topMargin = 0;
                        marginLayoutParams2.bottomMargin = 0;
                        this.f49764c.setLayoutParams(layoutParams2);
                    }
                    this.f49764c.setPadding(UiUtils.dip2px(this.f49763b, 9.0f), 0, UiUtils.dip2px(this.f49763b, 9.0f), 0);
                    this.f49764c.setBackground((Drawable) null);
                    this.f49767f.setVisibility(8);
                }
                this.f49771j.setOnClickListener(new OnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        AnyCarVH.this.f49774m.openDetail(AnyCarVH.this.f49772k);
                    }
                });
                if (anyCarConfigModel.singleCarSelect == 1) {
                    this.f49769h.setVisibility(0);
                    this.f49770i.setVisibility(8);
                    this.f49771j.setVisibility(8);
                    if (anyCarConfigModel.isDefaultSelect()) {
                        m35900c(anyCarEstimateItemModel);
                    } else {
                        m35903e(anyCarEstimateItemModel);
                    }
                    this.itemView.setOnClickListener(new OnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            if (AnyCarVH.this.f49773l) {
                                AnyCarVH.this.m35902d(anyCarEstimateItemModel);
                            } else {
                                AnyCarVH.this.m35897b(anyCarEstimateItemModel);
                            }
                        }
                    });
                } else if (anyCarConfigModel.singleCarSelect == 2) {
                    this.f49769h.setVisibility(8);
                    this.f49770i.setVisibility(0);
                    this.f49771j.setVisibility(0);
                    this.itemView.setOnClickListener(new LEGOOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            Logger f = AnyCarVH.this.f49762a;
                            f.debug("formPresenter return : " + System.currentTimeMillis(), new Object[0]);
                            if (AnyCarVH.this.f49774m != null) {
                                AnyCarVH.this.f49774m.singleSelected(anyCarEstimateItemModel);
                            }
                        }
                    });
                    this.f49766e.setBackground((Drawable) null);
                    if (!CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation)) {
                        this.mOperationsView.setVisibility(0);
                    }
                }
                if (anyCarEstimateItemModel.mIsFirstSingle) {
                    this.f49765d.setVisibility(0);
                } else {
                    this.f49765d.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: a */
    private void m35893a(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carInfo != null) {
            CarInfoModel carInfoModel = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carInfo;
            this.carDesc.setVisibility(0);
            if (carInfoModel.carExtraText != null && !StringUtil.isNullOrEmpty(carInfoModel.carExtraText.getContent())) {
                carInfoModel.carExtraText.bindTextView(this.carDesc);
            } else if (anyCarEstimateItemModel.isSelected && carInfoModel.carSelectText != null && !StringUtil.isNullOrEmpty(carInfoModel.carSelectText.getContent())) {
                carInfoModel.carSelectText.bindTextView(this.carDesc);
            } else if (carInfoModel.unSelectText != null && !StringUtil.isNullOrEmpty(carInfoModel.unSelectText.getContent())) {
                carInfoModel.unSelectText.bindTextView(this.carDesc);
            } else if (carInfoModel.carDescText == null || StringUtil.isNullOrEmpty(carInfoModel.carDescText.getContent())) {
                this.carDesc.setVisibility(8);
            } else {
                carInfoModel.carDescText.bindTextView(this.carDesc);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m35897b(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        anyCarEstimateItemModel.isSelected = true;
        m35893a(anyCarEstimateItemModel);
        m35900c(anyCarEstimateItemModel);
        AnyCarSelectListener anyCarSelectListener = this.f49774m;
        if (anyCarSelectListener != null) {
            anyCarSelectListener.selectedItem(anyCarEstimateItemModel);
        }
    }

    /* renamed from: c */
    private void m35900c(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        this.f49773l = true;
        Glide.with(this.f49763b).load(Integer.valueOf(R.drawable.car_model_checkbox_selected)).into(this.f49769h);
        if (anyCarEstimateItemModel != null && !CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carDetail) && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carDetail.get(0) != null && !CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carDetail.get(0).carDetailModels)) {
            this.f49771j.setVisibility(0);
        }
        if (anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carGroupArea != 0) {
            this.f49764c.setBackgroundResource(R.drawable.car_model_item_select_bg);
            this.f49766e.setBackground((Drawable) null);
        } else {
            this.f49764c.setBackgroundResource(R.drawable.anycar_item_rec_bg);
            this.f49766e.setBackgroundResource(R.drawable.anycat_item_rec_select_bg);
        }
        if (anyCarEstimateItemModel != null && !CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation)) {
            this.mOperationsView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m35902d(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        anyCarEstimateItemModel.isSelected = false;
        m35893a(anyCarEstimateItemModel);
        m35903e(anyCarEstimateItemModel);
        AnyCarSelectListener anyCarSelectListener = this.f49774m;
        if (anyCarSelectListener != null) {
            anyCarSelectListener.unSelectItem(anyCarEstimateItemModel);
        }
    }

    /* renamed from: e */
    private void m35903e(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        this.f49773l = false;
        Glide.with(this.f49763b).load(Integer.valueOf(R.drawable.car_model_checkbox_unselected)).into(this.f49769h);
        this.f49771j.setVisibility(8);
        if (anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carGroupArea != 0) {
            this.f49764c.setBackground((Drawable) null);
        } else {
            this.f49764c.setBackgroundResource(R.drawable.anycar_item_rec_bg);
        }
        this.f49766e.setBackground((Drawable) null);
        if (anyCarEstimateItemModel != null && !CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation)) {
            this.mOperationsView.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m35894a(CarInfoPriceModel carInfoPriceModel, View view) {
        if (carInfoPriceModel != null && carInfoPriceModel.carPrice != null && view != null) {
            TextView textView = (TextView) view.findViewById(R.id.new_estimate_price_approx);
            GlobalRichInfo globalRichInfo = carInfoPriceModel.carPrice;
            TextView textView2 = (TextView) view.findViewById(R.id.new_estimate_price_symbol_left);
            TextView textView3 = (TextView) view.findViewById(R.id.new_estimate_price_symbol_right);
            globalRichInfo.getRichTextSize(0);
            String richTextColor = globalRichInfo.getRichTextColor(0);
            globalRichInfo.bindTextView((TextView) view.findViewById(R.id.new_estimate_price_text_tv));
            String str = carInfoPriceModel.priceSymbol;
            int priceSymbolPosition = carInfoPriceModel.getPriceSymbolPosition();
            int parseColor = Color.parseColor(richTextColor);
            if (TextUtils.isEmpty(str) || "2".equalsIgnoreCase(carInfoPriceModel.priceType)) {
                textView3.setVisibility(8);
                textView2.setVisibility(8);
            } else {
                textView3.setText(str);
                textView2.setText(str);
                textView3.setTextColor(parseColor);
                textView2.setTextColor(parseColor);
                if (priceSymbolPosition == 1) {
                    textView3.setVisibility(0);
                    textView2.setVisibility(8);
                } else if (priceSymbolPosition == 0) {
                    textView3.setVisibility(8);
                    textView2.setVisibility(0);
                }
                if (TextUtils.isEmpty(carInfoPriceModel.priceApprox)) {
                    textView3.setTextSize(2, 12.0f);
                    textView2.setTextSize(2, 12.0f);
                } else {
                    textView3.setTextSize(2, 9.0f);
                    textView2.setTextSize(2, 9.0f);
                }
            }
            if (!StringUtil.isNullOrEmpty(carInfoPriceModel.priceApprox)) {
                textView.setVisibility(0);
                textView.setText(carInfoPriceModel.priceApprox);
                return;
            }
            textView.setVisibility(8);
        }
    }
}
