package com.didi.component.estimate.newui.view.one;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.StringUtil;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.AutofitTextView;
import com.didi.component.estimate.newui.view.vertical.VerticalCarViewHolder;
import com.didi.component.estimate.newui.view.viewholder.ItemClickListener;
import com.didi.component.estimate.presenter.AbsEstimatePresenter;
import com.didi.component.utils.EstimateUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.estimate.CarInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OneVerticalAdapter extends RecyclerView.Adapter<VerticalCarViewHolder> {

    /* renamed from: a */
    private final List<EstimateItemModel> f13150a = new ArrayList();

    /* renamed from: b */
    private final Context f13151b;

    /* renamed from: c */
    private AbsEstimatePresenter f13152c;
    public ItemClickListener clickListener;

    public OneVerticalAdapter(Context context, ItemClickListener itemClickListener) {
        this.f13151b = context;
        this.clickListener = itemClickListener;
    }

    public int getItemViewType(int i) {
        return this.f13150a.get(i).viewType;
    }

    public VerticalCarViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new VerticalCarViewHolder(LayoutInflater.from(this.f13151b).inflate(R.layout.estimate_choose_one_car_layout, viewGroup, false), i);
    }

    public void onBindViewHolder(VerticalCarViewHolder verticalCarViewHolder, int i) {
        VerticalCarViewHolder verticalCarViewHolder2 = verticalCarViewHolder;
        final int i2 = i;
        final EstimateItemModel estimateItemModel = this.f13150a.get(i2);
        verticalCarViewHolder2.estimateItemModel = estimateItemModel;
        CarInfoModel carInfoModel = estimateItemModel.carInfo;
        if (carInfoModel != null) {
            if (!StringUtil.isNullOrEmpty(carInfoModel.carIcon)) {
                Glide.with(this.f13151b.getApplicationContext()).load(carInfoModel.carIcon).into(verticalCarViewHolder2.carIcon);
            }
            if (!StringUtil.isNullOrEmpty(carInfoModel.carName)) {
                verticalCarViewHolder2.carTitle.setText(carInfoModel.carName);
            }
            verticalCarViewHolder2.carTitle.setTextSize(20.0f);
            verticalCarViewHolder2.carIcon.getLayoutParams().width = UIUtils.dip2pxInt(this.f13151b, 150.0f);
            verticalCarViewHolder2.carIcon.getLayoutParams().height = UIUtils.dip2pxInt(this.f13151b, 100.0f);
            if (estimateItemModel == null || estimateItemModel.carDetail == null || estimateItemModel.carDetail.size() == 0) {
                verticalCarViewHolder2.arrowIc.setVisibility(8);
            } else {
                verticalCarViewHolder2.arrowIc.setVisibility(0);
            }
            verticalCarViewHolder2.carEtaTime.setVisibility(0);
            if (carInfoModel.carExtraText != null && !StringUtil.isNullOrEmpty(carInfoModel.carExtraText.getContent())) {
                carInfoModel.carExtraText.bindTextView(verticalCarViewHolder2.carEtaTime);
            } else if (estimateItemModel.isSelected && carInfoModel.carSelectText != null && !StringUtil.isNullOrEmpty(carInfoModel.carSelectText.getContent())) {
                carInfoModel.carSelectText.bindTextView(verticalCarViewHolder2.carEtaTime);
            } else if (carInfoModel.unSelectText != null && !StringUtil.isNullOrEmpty(carInfoModel.unSelectText.getContent())) {
                carInfoModel.unSelectText.bindTextView(verticalCarViewHolder2.carEtaTime);
            } else if (carInfoModel.carDescText == null || StringUtil.isNullOrEmpty(carInfoModel.carDescText.getContent())) {
                verticalCarViewHolder2.carEtaTime.setVisibility(8);
            } else {
                carInfoModel.carDescText.bindTextView(verticalCarViewHolder2.carEtaTime);
            }
            if (!CollectionUtils.isEmpty((Collection) carInfoModel.carPriceInfo)) {
                verticalCarViewHolder2.priceTextLL.removeAllViews();
                verticalCarViewHolder2.priceTextLL.setVisibility(0);
                for (int i3 = 0; i3 < carInfoModel.carPriceInfo.size(); i3++) {
                    CarInfoPriceModel carInfoPriceModel = carInfoModel.carPriceInfo.get(i3);
                    if (carInfoPriceModel.carPrice != null && !StringUtil.isNullOrEmpty(carInfoPriceModel.carPrice.getContent())) {
                        View inflate = LayoutInflater.from(this.f13151b).inflate(R.layout.estimate_one_car_price_layout, verticalCarViewHolder2.priceTextLL, false);
                        inflate.setPadding(0, 0, 0, UiUtils.dip2px(this.f13151b, (float) (carInfoPriceModel.lineSpacing / 2)));
                        verticalCarViewHolder2.priceTextLL.addView(inflate);
                        m8936a(carInfoPriceModel, inflate);
                    }
                }
            }
            if (carInfoModel.hybridIconAndTextList == null || carInfoModel.hybridIconAndTextList.size() <= 0) {
                verticalCarViewHolder2.hybridIconAndTextLL.setVisibility(8);
            } else {
                verticalCarViewHolder2.hybridIconAndTextLL.removeAllViews();
                verticalCarViewHolder2.hybridIconAndTextLL.setVisibility(0);
                int i4 = 1;
                int size = carInfoModel.hybridIconAndTextList.size() - 1;
                while (size >= 0) {
                    CarInfoModel.hybridIconAndText hybridiconandtext = carInfoModel.hybridIconAndTextList.get(size);
                    if (hybridiconandtext.type == i4 && !StringUtil.isNullOrEmpty(hybridiconandtext.icon) && !EstimateUtils.isDestroy((Activity) this.f13151b)) {
                        View inflate2 = LayoutInflater.from(this.f13151b).inflate(R.layout.new_estimate_item_dynamic_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
                        verticalCarViewHolder2.hybridIconAndTextLL.addView(inflate2);
                        inflate2.setVisibility(0);
                        ImageView imageView = (ImageView) inflate2.findViewById(R.id.new_estimate_dynamic);
                        imageView.setVisibility(0);
                        Glide.with(this.f13151b).load(hybridiconandtext.icon).into(imageView);
                        if (carInfoModel.hybridIconAndTextList.size() == i4) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate2.getLayoutParams();
                            layoutParams.bottomMargin = UiUtils.dip2px(this.f13151b, 3.0f);
                            layoutParams.rightMargin = UiUtils.dip2px(this.f13151b, 0.0f);
                            inflate2.setLayoutParams(layoutParams);
                        }
                    } else if (hybridiconandtext.type != 2 || hybridiconandtext.info == null || StringUtil.isNullOrEmpty(hybridiconandtext.info.getContent())) {
                        if (hybridiconandtext.type == 3 && hybridiconandtext.info != null && !StringUtil.isNullOrEmpty(hybridiconandtext.info.getContent())) {
                            View inflate3 = LayoutInflater.from(this.f13151b).inflate(R.layout.new_estimate_item_discount_icon_text_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
                            verticalCarViewHolder2.hybridIconAndTextLL.addView(inflate3);
                            inflate3.setVisibility(0);
                            ImageView imageView2 = (ImageView) inflate3.findViewById(R.id.new_estimate_discount_icon);
                            if (StringUtil.isNullOrEmpty(hybridiconandtext.icon) || EstimateUtils.isDestroy((Activity) this.f13151b)) {
                                imageView2.setVisibility(8);
                            } else {
                                imageView2.setVisibility(0);
                                Glide.with(this.f13151b).load(hybridiconandtext.icon).into(imageView2);
                            }
                            TextView textView = (TextView) inflate3.findViewById(R.id.new_estimate_discount);
                            textView.setTextDirection(3);
                            textView.setVisibility(0);
                            hybridiconandtext.info.bindTextView(textView);
                            if (!StringUtil.isNullOrEmpty(hybridiconandtext.colorStart) && !StringUtil.isNullOrEmpty(hybridiconandtext.colorEnd)) {
                                GradientDrawable gradientDrawable = new GradientDrawable();
                                gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                                gradientDrawable.setColors(new int[]{Color.parseColor(hybridiconandtext.colorStart), Color.parseColor(hybridiconandtext.colorEnd)});
                                gradientDrawable.setCornerRadius(UIUtils.dip2px(this.f13151b, 6.0f));
                                inflate3.setBackground(gradientDrawable);
                                size--;
                                i4 = 1;
                            }
                        }
                    } else if (StringUtil.isNullOrEmpty(hybridiconandtext.colorStart) || StringUtil.isNullOrEmpty(hybridiconandtext.colorEnd)) {
                        View inflate4 = LayoutInflater.from(this.f13151b).inflate(R.layout.new_estimate_item_origin_price_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
                        verticalCarViewHolder2.hybridIconAndTextLL.addView(inflate4);
                        inflate4.setVisibility(0);
                        TextView textView2 = (TextView) inflate4.findViewById(R.id.new_estimate_origin_price);
                        textView2.setTextDirection(3);
                        textView2.setVisibility(0);
                        hybridiconandtext.info.bindTextView(textView2);
                    } else {
                        View inflate5 = LayoutInflater.from(this.f13151b).inflate(R.layout.new_estimate_item_discount_icon_text_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
                        verticalCarViewHolder2.hybridIconAndTextLL.addView(inflate5);
                        inflate5.setVisibility(0);
                        ((ImageView) inflate5.findViewById(R.id.new_estimate_discount_icon)).setVisibility(8);
                        TextView textView3 = (TextView) inflate5.findViewById(R.id.new_estimate_discount);
                        textView3.setTextDirection(3);
                        textView3.setVisibility(0);
                        hybridiconandtext.info.bindTextView(textView3);
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                        gradientDrawable2.setColors(new int[]{Color.parseColor(hybridiconandtext.colorStart), Color.parseColor(hybridiconandtext.colorEnd)});
                        gradientDrawable2.setCornerRadius(UIUtils.dip2px(this.f13151b, 6.0f));
                        inflate5.setBackground(gradientDrawable2);
                    }
                    size--;
                    i4 = 1;
                }
            }
            verticalCarViewHolder2.mOperationsView.setPresenter(this.f13152c);
            verticalCarViewHolder2.mOperationsView.setEstimateItemClick(this.clickListener);
            if (verticalCarViewHolder2.mOperationsView.setData(estimateItemModel)) {
                verticalCarViewHolder2.mOperationsView.setVisibility(0);
                verticalCarViewHolder2.selectedInfoHeight = UIUtils.dip2pxInt(this.f13151b, 85.0f);
                verticalCarViewHolder2.selectedCardHeight = UIUtils.dip2pxInt(this.f13151b, 199.0f);
            } else {
                verticalCarViewHolder2.mOperationsView.setVisibility(8);
                verticalCarViewHolder2.selectedInfoHeight = UIUtils.dip2pxInt(this.f13151b, 100.0f);
                verticalCarViewHolder2.selectedCardHeight = UIUtils.dip2pxInt(this.f13151b, 164.0f);
            }
            verticalCarViewHolder2.carInfoContainer.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (OneVerticalAdapter.this.clickListener != null) {
                        OneVerticalAdapter.this.clickListener.itemClick(estimateItemModel, i2, false);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m8936a(CarInfoPriceModel carInfoPriceModel, View view) {
        if (carInfoPriceModel != null && carInfoPriceModel.carPrice != null && view != null) {
            GlobalRichInfo globalRichInfo = carInfoPriceModel.carPrice;
            String str = carInfoPriceModel.priceApprox;
            TextView textView = (TextView) view.findViewById(R.id.new_estimate_price_approx);
            AutofitTextView autofitTextView = (AutofitTextView) view.findViewById(R.id.new_estimate_price_text_tv);
            TextView textView2 = (TextView) view.findViewById(R.id.new_estimate_price_symbol_left);
            TextView textView3 = (TextView) view.findViewById(R.id.new_estimate_price_symbol_right);
            int richTextSize = globalRichInfo.getRichTextSize(0);
            String richTextColor = globalRichInfo.getRichTextColor(0);
            autofitTextView.setMaxTextSize(2, (float) (richTextSize / 2));
            autofitTextView.setTextColor(Color.parseColor(richTextColor));
            autofitTextView.setText(globalRichInfo.getContent());
            String str2 = carInfoPriceModel.priceSymbol;
            int priceSymbolPosition = carInfoPriceModel.getPriceSymbolPosition();
            int parseColor = Color.parseColor(richTextColor);
            if (TextUtils.isEmpty(str2) || "2".equalsIgnoreCase(carInfoPriceModel.priceType)) {
                textView3.setVisibility(8);
                textView2.setVisibility(8);
            } else {
                textView3.setText(str2);
                textView2.setText(str2);
                textView3.setTextColor(parseColor);
                textView2.setTextColor(parseColor);
                if (priceSymbolPosition == 1) {
                    textView3.setVisibility(0);
                    textView2.setVisibility(8);
                    autofitTextView.setGravity(21);
                } else if (priceSymbolPosition == 0) {
                    textView3.setVisibility(8);
                    textView2.setVisibility(0);
                    autofitTextView.setGravity(19);
                }
                if (TextUtils.isEmpty(str)) {
                    textView3.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13151b, R.dimen.new_estimate_symbol_size_big));
                    textView2.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13151b, R.dimen.new_estimate_symbol_size_big));
                } else {
                    textView3.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13151b, R.dimen.new_estimate_symbol_size_small));
                    textView2.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13151b, R.dimen.new_estimate_symbol_size_small));
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

    public void setData(List<EstimateItemModel> list) {
        this.f13150a.clear();
        this.f13150a.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f13150a.size();
    }

    public void setPresenter(AbsEstimatePresenter absEstimatePresenter) {
        this.f13152c = absEstimatePresenter;
    }
}
