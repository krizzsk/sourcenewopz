package com.didi.component.estimate.newui.view.vertical;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.widget.AutofitTextView;
import com.didi.component.estimate.newui.view.CarEstimateOptionsView;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;

public class VerticalCarViewHolder extends RecyclerView.ViewHolder {
    public ImageView arrowIc;
    public TextView carApproxText;
    public TextView carDesc;
    public TextView carDiscount;
    public ImageView carDiscountIcon;
    public LinearLayout carDiscountLL;
    public ImageView carDynamic;
    public TextView carEtaTime;
    public TextView carGroupName;
    public ImageView carIcon;
    public FrameLayout carIconFl;
    public ConstraintLayout carInfoContainer;
    public ImageView carPeopleIcon;
    public LinearLayout carPrice;
    public TextView carPriceOrigin;
    public TextView carPriceSymbolLeftTv;
    public TextView carPriceSymbolRightTv;
    public AutofitTextView carPriceTv;
    public TextView carSeatNum;
    public TextView carTagGuide;
    public TextView carTitle;
    public View divider;
    public EstimateItemModel estimateItemModel;
    public LinearLayout hybridIconAndTextLL;
    public View layout;
    public CarEstimateOptionsView mOperationsView;
    public View mask;
    public LinearLayout priceTextLL;
    public int selectedCardHeight;
    public int selectedInfoHeight;

    public VerticalCarViewHolder(View view, int i) {
        super(view);
        this.layout = view.findViewById(R.id.new_estimate_car_layout);
        this.mask = view.findViewById(R.id.new_estimate_recommand_mask);
        this.carIcon = (ImageView) view.findViewById(R.id.new_estimate_car_icon_iv);
        this.carTitle = (TextView) view.findViewById(R.id.new_estimate_car_name);
        this.carEtaTime = (TextView) view.findViewById(R.id.new_estimate_eta_tv);
        this.carPriceOrigin = (TextView) view.findViewById(R.id.new_estimate_origin_price);
        this.arrowIc = (ImageView) view.findViewById(R.id.new_estimate_select_arrow);
        this.carSeatNum = (TextView) view.findViewById(R.id.new_estimate_seat_num);
        this.carPeopleIcon = (ImageView) view.findViewById(R.id.new_estimate_people_icon);
        this.carDesc = (TextView) view.findViewById(R.id.new_estimate_car_desc);
        this.carGroupName = (TextView) view.findViewById(R.id.estimate_expand_group_name);
        this.carTagGuide = (TextView) view.findViewById(R.id.new_estimate_tag_guide);
        this.divider = view.findViewById(R.id.new_estimate_view_divider);
        this.carInfoContainer = (ConstraintLayout) view.findViewById(R.id.new_estimate_car_info_container);
        this.hybridIconAndTextLL = (LinearLayout) view.findViewById(R.id.new_estimate_hybrid_icon_and_text_ll);
        this.priceTextLL = (LinearLayout) view.findViewById(R.id.new_estimate_price_list_ll);
        this.carPrice = (LinearLayout) view.findViewById(R.id.new_estimate_price_text);
        if (i != 3) {
            this.carIconFl = (FrameLayout) view.findViewById(R.id.new_estimate_car_icon);
        }
        if (i == 2 || i == 3) {
            this.mOperationsView = (CarEstimateOptionsView) view.findViewById(R.id.new_estimate_operation_list);
        }
    }
}
