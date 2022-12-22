package com.didi.component.estimate.newui.view.vertical;

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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.StringUtil;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.AutofitTextView;
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

public class RecommendVerticalAdapter extends RecyclerView.Adapter<VerticalCarViewHolder> {

    /* renamed from: a */
    private final List<EstimateItemModel> f13184a = new ArrayList();

    /* renamed from: b */
    private final Context f13185b;

    /* renamed from: c */
    private AbsEstimatePresenter f13186c;
    public ItemClickListener clickListener;

    /* renamed from: d */
    private VerticalSelectAnimation f13187d;

    /* renamed from: e */
    private int f13188e = 0;

    public RecommendVerticalAdapter(Context context, ItemClickListener itemClickListener) {
        this.f13185b = context;
        this.clickListener = itemClickListener;
    }

    public int getItemViewType(int i) {
        return this.f13184a.get(i).viewType;
    }

    public VerticalCarViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2 = R.layout.new_estimate_item_vertical_recommend;
        if (i != 2) {
            if (i == 12) {
                i2 = R.layout.new_estimate_item_vertical_loading;
            } else if (i == 13) {
                i2 = R.layout.new_estimate_item_vertical_loading_sel;
            }
        }
        return new VerticalCarViewHolder(LayoutInflater.from(this.f13185b).inflate(i2, viewGroup, false), i);
    }

    public void onBindViewHolder(VerticalCarViewHolder verticalCarViewHolder, int i) {
        VerticalCarViewHolder verticalCarViewHolder2 = verticalCarViewHolder;
        final int i2 = i;
        final EstimateItemModel estimateItemModel = this.f13184a.get(i2);
        if (estimateItemModel.viewType != 12 && estimateItemModel.viewType != 13) {
            verticalCarViewHolder2.estimateItemModel = estimateItemModel;
            CarInfoModel carInfoModel = estimateItemModel.carInfo;
            if (carInfoModel != null) {
                if (verticalCarViewHolder2.carIcon != null) {
                    verticalCarViewHolder2.carIcon.setPivotX(((float) UIUtils.dip2pxInt(this.f13185b, 90.0f)) * 0.8f);
                    verticalCarViewHolder2.carIcon.setPivotY((float) UIUtils.dip2pxInt(this.f13185b, 45.0f));
                }
                if (!StringUtil.isNullOrEmpty(carInfoModel.carIcon)) {
                    Glide.with(this.f13185b.getApplicationContext()).load(carInfoModel.carIcon).into(verticalCarViewHolder2.carIcon);
                }
                if (!StringUtil.isNullOrEmpty(carInfoModel.carName)) {
                    verticalCarViewHolder2.carTitle.setText(carInfoModel.carName);
                }
                int i3 = 8;
                if (!estimateItemModel.isSelected || estimateItemModel.carDetail == null || estimateItemModel.carDetail.size() == 0) {
                    verticalCarViewHolder2.carTitle.setTextSize(16.0f);
                    verticalCarViewHolder2.arrowIc.setVisibility(8);
                } else {
                    verticalCarViewHolder2.carTitle.setTextSize(20.0f);
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
                    for (int i4 = 0; i4 < carInfoModel.carPriceInfo.size(); i4++) {
                        CarInfoPriceModel carInfoPriceModel = carInfoModel.carPriceInfo.get(i4);
                        if (carInfoPriceModel.carPrice != null && !StringUtil.isNullOrEmpty(carInfoPriceModel.carPrice.getContent())) {
                            View inflate = LayoutInflater.from(this.f13185b).inflate(R.layout.new_estimate_price_item_vertical, verticalCarViewHolder2.priceTextLL, false);
                            inflate.setPadding(0, 0, 0, UiUtils.dip2px(this.f13185b, (float) (carInfoPriceModel.lineSpacing / 2)));
                            verticalCarViewHolder2.priceTextLL.addView(inflate);
                            m8977a(carInfoPriceModel, inflate);
                        }
                    }
                }
                if (carInfoModel.hybridIconAndTextList == null || carInfoModel.hybridIconAndTextList.size() <= 0) {
                    verticalCarViewHolder2.hybridIconAndTextLL.setVisibility(8);
                } else {
                    verticalCarViewHolder2.hybridIconAndTextLL.removeAllViews();
                    verticalCarViewHolder2.hybridIconAndTextLL.setVisibility(0);
                    int i5 = 1;
                    int size = carInfoModel.hybridIconAndTextList.size() - 1;
                    while (size >= 0) {
                        CarInfoModel.hybridIconAndText hybridiconandtext = carInfoModel.hybridIconAndTextList.get(size);
                        if (hybridiconandtext.type == i5 && !StringUtil.isNullOrEmpty(hybridiconandtext.icon) && !EstimateUtils.isDestroy((Activity) this.f13185b)) {
                            View inflate2 = LayoutInflater.from(this.f13185b).inflate(R.layout.new_estimate_item_dynamic_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
                            verticalCarViewHolder2.hybridIconAndTextLL.addView(inflate2);
                            inflate2.setVisibility(0);
                            ImageView imageView = (ImageView) inflate2.findViewById(R.id.new_estimate_dynamic);
                            imageView.setVisibility(0);
                            Glide.with(this.f13185b).load(hybridiconandtext.icon).into(imageView);
                            if (carInfoModel.hybridIconAndTextList.size() == i5) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate2.getLayoutParams();
                                layoutParams.bottomMargin = UiUtils.dip2px(this.f13185b, 3.0f);
                                layoutParams.rightMargin = UiUtils.dip2px(this.f13185b, 0.0f);
                                inflate2.setLayoutParams(layoutParams);
                            }
                        } else if (hybridiconandtext.type != 2 || hybridiconandtext.info == null || StringUtil.isNullOrEmpty(hybridiconandtext.info.getContent())) {
                            if (hybridiconandtext.type == 3 && hybridiconandtext.info != null && !StringUtil.isNullOrEmpty(hybridiconandtext.info.getContent())) {
                                View inflate3 = LayoutInflater.from(this.f13185b).inflate(R.layout.new_estimate_item_discount_icon_text_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
                                verticalCarViewHolder2.hybridIconAndTextLL.addView(inflate3);
                                inflate3.setVisibility(0);
                                ImageView imageView2 = (ImageView) inflate3.findViewById(R.id.new_estimate_discount_icon);
                                if (StringUtil.isNullOrEmpty(hybridiconandtext.icon) || EstimateUtils.isDestroy((Activity) this.f13185b)) {
                                    imageView2.setVisibility(8);
                                } else {
                                    imageView2.setVisibility(0);
                                    Glide.with(this.f13185b).load(hybridiconandtext.icon).into(imageView2);
                                }
                                TextView textView = (TextView) inflate3.findViewById(R.id.new_estimate_discount);
                                textView.setVisibility(0);
                                textView.setTextDirection(3);
                                hybridiconandtext.info.bindTextView(textView);
                                if (!StringUtil.isNullOrEmpty(hybridiconandtext.colorStart) && !StringUtil.isNullOrEmpty(hybridiconandtext.colorEnd)) {
                                    GradientDrawable gradientDrawable = new GradientDrawable();
                                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                                    gradientDrawable.setColors(new int[]{Color.parseColor(hybridiconandtext.colorStart), Color.parseColor(hybridiconandtext.colorEnd)});
                                    gradientDrawable.setCornerRadius(UIUtils.dip2px(this.f13185b, 6.0f));
                                    inflate3.setBackground(gradientDrawable);
                                    size--;
                                    i5 = 1;
                                }
                            }
                        } else if (StringUtil.isNullOrEmpty(hybridiconandtext.colorStart) || StringUtil.isNullOrEmpty(hybridiconandtext.colorEnd)) {
                            View inflate4 = LayoutInflater.from(this.f13185b).inflate(R.layout.new_estimate_item_origin_price_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
                            verticalCarViewHolder2.hybridIconAndTextLL.addView(inflate4);
                            inflate4.setVisibility(0);
                            TextView textView2 = (TextView) inflate4.findViewById(R.id.new_estimate_origin_price);
                            textView2.setVisibility(0);
                            textView2.setTextDirection(3);
                            hybridiconandtext.info.bindTextView(textView2);
                        } else {
                            View inflate5 = LayoutInflater.from(this.f13185b).inflate(R.layout.new_estimate_item_discount_icon_text_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
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
                            gradientDrawable2.setCornerRadius(UIUtils.dip2px(this.f13185b, 6.0f));
                            inflate5.setBackground(gradientDrawable2);
                        }
                        size--;
                        i5 = 1;
                    }
                }
                if (estimateItemModel.isSelected) {
                    verticalCarViewHolder2.mOperationsView.setPresenter(this.f13186c);
                    verticalCarViewHolder2.mOperationsView.setEstimateItemClick(this.clickListener);
                    if (verticalCarViewHolder2.mOperationsView.setData(estimateItemModel)) {
                        verticalCarViewHolder2.mOperationsView.setVisibility(0);
                        verticalCarViewHolder2.selectedInfoHeight = UIUtils.dip2pxInt(this.f13185b, 85.0f);
                        verticalCarViewHolder2.selectedCardHeight = UIUtils.dip2pxInt(this.f13185b, 199.0f);
                    } else {
                        verticalCarViewHolder2.mOperationsView.setVisibility(8);
                        verticalCarViewHolder2.selectedInfoHeight = UIUtils.dip2pxInt(this.f13185b, 100.0f);
                        verticalCarViewHolder2.selectedCardHeight = UIUtils.dip2pxInt(this.f13185b, 164.0f);
                    }
                } else {
                    verticalCarViewHolder2.mOperationsView.setVisibility(8);
                }
                if (!StringUtil.isNullOrEmpty(carInfoModel.tagBubbleText)) {
                    verticalCarViewHolder2.carTagGuide.setVisibility(0);
                    verticalCarViewHolder2.carTagGuide.setText(carInfoModel.tagBubbleText);
                } else {
                    verticalCarViewHolder2.carTagGuide.setVisibility(8);
                }
                View view = verticalCarViewHolder2.divider;
                if (!estimateItemModel.isSelected) {
                    i3 = 0;
                }
                view.setVisibility(i3);
                verticalCarViewHolder2.carInfoContainer.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (RecommendVerticalAdapter.this.clickListener != null) {
                            RecommendVerticalAdapter.this.clickListener.itemClick(estimateItemModel, i2, false);
                        }
                    }
                });
            }
            verticalCarViewHolder2.mask.setBackgroundColor(Color.argb(this.f13188e, 255, 255, 255));
        }
    }

    /* renamed from: a */
    private void m8976a(VerticalCarViewHolder verticalCarViewHolder, boolean z) {
        int i;
        int dip2pxInt = UIUtils.dip2pxInt(this.f13185b, 96.0f);
        int dip2pxInt2 = UIUtils.dip2pxInt(this.f13185b, 20.0f);
        if (z) {
            i = UIUtils.dip2pxInt(this.f13185b, 30.0f);
        } else {
            i = UIUtils.dip2pxInt(this.f13185b, 22.0f);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) verticalCarViewHolder.carTitle.getLayoutParams();
        layoutParams.setMargins(dip2pxInt, i, 0, 0);
        verticalCarViewHolder.carTitle.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) verticalCarViewHolder.priceTextLL.getLayoutParams();
        layoutParams2.setMargins(0, i, dip2pxInt2, 0);
        verticalCarViewHolder.priceTextLL.setLayoutParams(layoutParams2);
    }

    /* renamed from: a */
    private void m8977a(CarInfoPriceModel carInfoPriceModel, View view) {
        if (carInfoPriceModel != null && carInfoPriceModel.carPrice != null && view != null) {
            TextView textView = (TextView) view.findViewById(R.id.new_estimate_price_approx);
            GlobalRichInfo globalRichInfo = carInfoPriceModel.carPrice;
            AutofitTextView autofitTextView = (AutofitTextView) view.findViewById(R.id.new_estimate_price_text_tv);
            TextView textView2 = (TextView) view.findViewById(R.id.new_estimate_price_symbol_left);
            TextView textView3 = (TextView) view.findViewById(R.id.new_estimate_price_symbol_right);
            int richTextSize = globalRichInfo.getRichTextSize(0);
            String richTextColor = globalRichInfo.getRichTextColor(0);
            autofitTextView.setTextSize(2, ((float) richTextSize) / 2.0f);
            autofitTextView.setTextColor(Color.parseColor(richTextColor));
            autofitTextView.setText(globalRichInfo.getContent());
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
                autofitTextView.setTextColor(Color.parseColor(richTextColor));
                if (priceSymbolPosition == 1) {
                    textView3.setVisibility(0);
                    textView2.setVisibility(8);
                    autofitTextView.setGravity(8388629);
                } else if (priceSymbolPosition == 0) {
                    textView3.setVisibility(8);
                    textView2.setVisibility(0);
                    autofitTextView.setGravity(8388627);
                }
                if (TextUtils.isEmpty(carInfoPriceModel.priceApprox)) {
                    textView3.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13185b, R.dimen.new_estimate_symbol_size_big));
                    textView2.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13185b, R.dimen.new_estimate_symbol_size_big));
                } else {
                    textView3.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13185b, R.dimen.new_estimate_symbol_size_small));
                    textView2.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13185b, R.dimen.new_estimate_symbol_size_small));
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
        this.f13184a.clear();
        this.f13184a.addAll(list);
        notifyDataSetChanged();
    }

    public void updateRecommandBg(int i) {
        this.f13188e = i;
        notifyDataSetChanged();
    }

    public void setVerticalSelectAnimation(VerticalSelectAnimation verticalSelectAnimation) {
        this.f13187d = verticalSelectAnimation;
    }

    public int getItemCount() {
        return this.f13184a.size();
    }

    public List<EstimateItemModel> getDataList() {
        return this.f13184a;
    }

    public void setPresenter(AbsEstimatePresenter absEstimatePresenter) {
        this.f13186c = absEstimatePresenter;
    }
}
