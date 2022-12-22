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
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.StringUtil;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.AutofitTextView;
import com.didi.component.estimate.newui.view.viewholder.ItemClickListener;
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

public class AllVerticalAdapter extends RecyclerView.Adapter<VerticalCarViewHolder> {

    /* renamed from: a */
    private final List<EstimateItemModel> f13153a = new ArrayList();

    /* renamed from: b */
    private final Context f13154b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ItemClickListener f13155c;

    public AllVerticalAdapter(Context context, ItemClickListener itemClickListener) {
        this.f13154b = context;
        this.f13155c = itemClickListener;
    }

    public int getItemViewType(int i) {
        return this.f13153a.get(i).viewType;
    }

    public VerticalCarViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new VerticalCarViewHolder(LayoutInflater.from(this.f13154b).inflate(R.layout.new_estimate_item_vertical_all, viewGroup, false), i);
    }

    public void onBindViewHolder(VerticalCarViewHolder verticalCarViewHolder, int i) {
        VerticalCarViewHolder verticalCarViewHolder2 = verticalCarViewHolder;
        final int i2 = i;
        final EstimateItemModel estimateItemModel = this.f13153a.get(i2);
        verticalCarViewHolder2.estimateItemModel = estimateItemModel;
        CarInfoModel carInfoModel = estimateItemModel.carInfo;
        if (carInfoModel != null) {
            if (!StringUtil.isNullOrEmpty(carInfoModel.carIcon)) {
                Glide.with(this.f13154b.getApplicationContext()).load(carInfoModel.carIcon).into(verticalCarViewHolder2.carIcon);
            }
            if (!StringUtil.isNullOrEmpty(carInfoModel.carName)) {
                verticalCarViewHolder2.carTitle.setText(carInfoModel.carName);
            }
            verticalCarViewHolder2.carTitle.setTextSize(16.0f);
            verticalCarViewHolder2.carIcon.getLayoutParams().width = UIUtils.dip2pxInt(this.f13154b, 90.0f);
            verticalCarViewHolder2.carIcon.getLayoutParams().height = UIUtils.dip2pxInt(this.f13154b, 60.0f);
            int i3 = 8;
            verticalCarViewHolder2.arrowIc.setVisibility(8);
            if (verticalCarViewHolder2.carGroupName != null) {
                if (!StringUtil.isNullOrEmpty(estimateItemModel.itemTitle)) {
                    verticalCarViewHolder2.carGroupName.setText(estimateItemModel.itemTitle);
                    verticalCarViewHolder2.carGroupName.setVisibility(0);
                } else {
                    verticalCarViewHolder2.carGroupName.setVisibility(8);
                }
            }
            if (carInfoModel.unSelectText == null || StringUtil.isNullOrEmpty(carInfoModel.unSelectText.getContent())) {
                verticalCarViewHolder2.carEtaTime.setVisibility(8);
            } else {
                verticalCarViewHolder2.carEtaTime.setVisibility(0);
                carInfoModel.unSelectText.bindTextView(verticalCarViewHolder2.carEtaTime);
            }
            if (carInfoModel.carDescText == null || StringUtil.isNullOrEmpty(carInfoModel.carDescText.getContent())) {
                verticalCarViewHolder2.carDesc.setVisibility(8);
            } else {
                verticalCarViewHolder2.carDesc.setVisibility(0);
                carInfoModel.carDescText.bindTextView(verticalCarViewHolder2.carDesc);
            }
            if (carInfoModel.carSeatNum != null) {
                verticalCarViewHolder2.carSeatNum.setVisibility(0);
                verticalCarViewHolder2.carPeopleIcon.setVisibility(0);
                verticalCarViewHolder2.carSeatNum.setText(carInfoModel.carSeatNum);
                ((RequestBuilder) Glide.with(this.f13154b).load(carInfoModel.carSeatIcon).placeholder((int) R.drawable.estimate_seat_people)).into(verticalCarViewHolder2.carPeopleIcon);
            } else {
                verticalCarViewHolder2.carSeatNum.setVisibility(8);
                verticalCarViewHolder2.carPeopleIcon.setVisibility(8);
            }
            if (!CollectionUtils.isEmpty((Collection) carInfoModel.carPriceInfo)) {
                verticalCarViewHolder2.priceTextLL.removeAllViews();
                verticalCarViewHolder2.priceTextLL.setVisibility(0);
                for (int i4 = 0; i4 < carInfoModel.carPriceInfo.size(); i4++) {
                    CarInfoPriceModel carInfoPriceModel = carInfoModel.carPriceInfo.get(i4);
                    if (carInfoPriceModel.carPrice != null && !StringUtil.isNullOrEmpty(carInfoPriceModel.carPrice.getContent())) {
                        View inflate = LayoutInflater.from(this.f13154b).inflate(R.layout.estimate_price_text_all_vertical, verticalCarViewHolder2.priceTextLL, false);
                        inflate.setPadding(0, 0, 0, UiUtils.dip2px(this.f13154b, (float) (carInfoPriceModel.lineSpacing / 2)));
                        verticalCarViewHolder2.priceTextLL.addView(inflate);
                        m8938a(carInfoPriceModel, inflate);
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
                    if (hybridiconandtext.type == i5 && !StringUtil.isNullOrEmpty(hybridiconandtext.icon) && !EstimateUtils.isDestroy((Activity) this.f13154b)) {
                        View inflate2 = LayoutInflater.from(this.f13154b).inflate(R.layout.new_estimate_item_dynamic_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
                        verticalCarViewHolder2.hybridIconAndTextLL.addView(inflate2);
                        inflate2.setVisibility(0);
                        ImageView imageView = (ImageView) inflate2.findViewById(R.id.new_estimate_dynamic);
                        imageView.setVisibility(0);
                        Glide.with(this.f13154b).load(hybridiconandtext.icon).into(imageView);
                        if (carInfoModel.hybridIconAndTextList.size() == i5) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate2.getLayoutParams();
                            layoutParams.bottomMargin = UiUtils.dip2px(this.f13154b, 3.0f);
                            layoutParams.rightMargin = UiUtils.dip2px(this.f13154b, 0.0f);
                            inflate2.setLayoutParams(layoutParams);
                        }
                    } else if (hybridiconandtext.type != 2 || hybridiconandtext.info == null || StringUtil.isNullOrEmpty(hybridiconandtext.info.getContent())) {
                        if (hybridiconandtext.type == 3 && hybridiconandtext.info != null && !StringUtil.isNullOrEmpty(hybridiconandtext.info.getContent())) {
                            View inflate3 = LayoutInflater.from(this.f13154b).inflate(R.layout.new_estimate_item_discount_icon_text_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
                            verticalCarViewHolder2.hybridIconAndTextLL.addView(inflate3);
                            inflate3.setVisibility(0);
                            ImageView imageView2 = (ImageView) inflate3.findViewById(R.id.new_estimate_discount_icon);
                            if (StringUtil.isNullOrEmpty(hybridiconandtext.icon) || EstimateUtils.isDestroy((Activity) this.f13154b)) {
                                imageView2.setVisibility(8);
                            } else {
                                imageView2.setVisibility(0);
                                Glide.with(this.f13154b).load(hybridiconandtext.icon).into(imageView2);
                            }
                            TextView textView = (TextView) inflate3.findViewById(R.id.new_estimate_discount);
                            textView.setVisibility(0);
                            hybridiconandtext.info.bindTextView(textView);
                            if (!StringUtil.isNullOrEmpty(hybridiconandtext.colorStart) && !StringUtil.isNullOrEmpty(hybridiconandtext.colorEnd)) {
                                GradientDrawable gradientDrawable = new GradientDrawable();
                                gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                                gradientDrawable.setColors(new int[]{Color.parseColor(hybridiconandtext.colorStart), Color.parseColor(hybridiconandtext.colorEnd)});
                                gradientDrawable.setCornerRadius(UIUtils.dip2px(this.f13154b, 6.0f));
                                inflate3.setBackground(gradientDrawable);
                                size--;
                                i5 = 1;
                            }
                        }
                    } else if (StringUtil.isNullOrEmpty(hybridiconandtext.colorStart) || StringUtil.isNullOrEmpty(hybridiconandtext.colorEnd)) {
                        View inflate4 = LayoutInflater.from(this.f13154b).inflate(R.layout.new_estimate_item_origin_price_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
                        verticalCarViewHolder2.hybridIconAndTextLL.addView(inflate4);
                        inflate4.setVisibility(0);
                        TextView textView2 = (TextView) inflate4.findViewById(R.id.new_estimate_origin_price);
                        textView2.setVisibility(0);
                        hybridiconandtext.info.bindTextView(textView2);
                    } else {
                        View inflate5 = LayoutInflater.from(this.f13154b).inflate(R.layout.new_estimate_item_discount_icon_text_layout, verticalCarViewHolder2.hybridIconAndTextLL, false);
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
                        gradientDrawable2.setCornerRadius(UIUtils.dip2px(this.f13154b, 6.0f));
                        inflate5.setBackground(gradientDrawable2);
                    }
                    size--;
                    i5 = 1;
                }
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
                    if (AllVerticalAdapter.this.f13155c != null) {
                        AllVerticalAdapter.this.f13155c.itemClick(estimateItemModel, i2, false);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m8938a(CarInfoPriceModel carInfoPriceModel, View view) {
        if (carInfoPriceModel != null && carInfoPriceModel.carPrice != null && view != null) {
            GlobalRichInfo globalRichInfo = carInfoPriceModel.carPrice;
            TextView textView = (TextView) view.findViewById(R.id.new_estimate_price_approx);
            AutofitTextView autofitTextView = (AutofitTextView) view.findViewById(R.id.new_estimate_price_text_tv);
            TextView textView2 = (TextView) view.findViewById(R.id.new_estimate_price_symbol_left);
            TextView textView3 = (TextView) view.findViewById(R.id.new_estimate_price_symbol_right);
            int richTextSize = globalRichInfo.getRichTextSize(0);
            String richTextColor = globalRichInfo.getRichTextColor(0);
            autofitTextView.setMaxTextSize(2, ((float) richTextSize) / 2.0f);
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
                    textView3.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13154b, R.dimen.new_estimate_symbol_size_big));
                    textView2.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13154b, R.dimen.new_estimate_symbol_size_big));
                } else {
                    textView3.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13154b, R.dimen.new_estimate_symbol_size_small));
                    textView2.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.f13154b, R.dimen.new_estimate_symbol_size_small));
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
        this.f13153a.clear();
        this.f13153a.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f13153a.size();
    }
}
