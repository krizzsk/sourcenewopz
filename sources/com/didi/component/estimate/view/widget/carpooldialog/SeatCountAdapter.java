package com.didi.component.estimate.view.widget.carpooldialog;

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
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.UIUtils;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.estimate.CarSeatChoiceModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SeatCountAdapter extends RecyclerView.Adapter<SeatCountViewHolder> {

    /* renamed from: a */
    private Context f13262a;

    /* renamed from: b */
    private List<CarSeatChoiceModel> f13263b;

    /* renamed from: c */
    private LayoutInflater f13264c;

    /* renamed from: d */
    private int f13265d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnSeatItemClickListener f13266e;

    public interface OnSeatItemClickListener {
        void onItemClick(int i);
    }

    public SeatCountAdapter(Context context) {
        this.f13262a = context;
        this.f13263b = new ArrayList();
        this.f13264c = LayoutInflater.from(context);
    }

    public void updateData(List<CarSeatChoiceModel> list) {
        this.f13263b = list;
        notifyDataSetChanged();
    }

    public void setOnSeatItemClickListener(OnSeatItemClickListener onSeatItemClickListener) {
        this.f13266e = onSeatItemClickListener;
    }

    public List<CarSeatChoiceModel> getData() {
        return this.f13263b;
    }

    public SeatCountViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SeatCountViewHolder(this.f13264c.inflate(R.layout.global_seat_count_list_item_new_ui, viewGroup, false));
    }

    public void onBindViewHolder(SeatCountViewHolder seatCountViewHolder, final int i) {
        CarSeatChoiceModel carSeatChoiceModel = this.f13263b.get(i);
        if (carSeatChoiceModel != null) {
            if (carSeatChoiceModel.choiceText != null) {
                carSeatChoiceModel.choiceText.bindTextView(seatCountViewHolder.seatCount);
            }
            if (this.f13265d != i || carSeatChoiceModel.isUnavailable) {
                seatCountViewHolder.itemImg.setImageResource(carSeatChoiceModel.isUnavailable ? R.drawable.com_icon_radio_large_dis : R.drawable.com_icon_radio_large_unsel);
                seatCountViewHolder.cardView.setRadius(UIUtils.dip2px(this.f13262a, 0.0f));
                seatCountViewHolder.cardView.setCardElevation(0.0f);
                seatCountViewHolder.seatTips.setVisibility(8);
                seatCountViewHolder.priceLayout.setVisibility(8);
            } else {
                seatCountViewHolder.itemImg.setImageResource(DidiThemeManager.getIns().getResPicker(this.f13262a).getResIdByTheme(R.attr.new_ui_common_icon_radio_large));
                seatCountViewHolder.cardView.setRadius(UIUtils.dip2px(this.f13262a, 20.0f));
                seatCountViewHolder.cardView.setCardElevation(UIUtils.dip2px(this.f13262a, 10.0f));
                if (carSeatChoiceModel.valueList == null || carSeatChoiceModel.valueList.size() <= 0) {
                    seatCountViewHolder.priceLayout.setVisibility(8);
                } else {
                    seatCountViewHolder.priceLayout.removeAllViews();
                    seatCountViewHolder.priceLayout.setVisibility(0);
                    for (int i2 = 0; i2 < carSeatChoiceModel.valueList.size(); i2++) {
                        if (carSeatChoiceModel.valueList.get(i2) != null) {
                            GlobalRichInfo globalRichInfo = carSeatChoiceModel.valueList.get(i2).valueText;
                            TextView textView = new TextView(this.f13262a);
                            textView.setGravity(17);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.setMargins(0, 0, 0, UIUtils.dip2pxInt(this.f13262a, ((float) carSeatChoiceModel.valueList.get(i2).length) / 2.0f));
                            seatCountViewHolder.priceLayout.addView(textView, layoutParams);
                            globalRichInfo.bindTextView(textView);
                        }
                    }
                }
                if (carSeatChoiceModel.intro == null || carSeatChoiceModel.intro.richText == null || TextUtils.isEmpty(carSeatChoiceModel.intro.richText.getContent())) {
                    seatCountViewHolder.seatTips.setVisibility(8);
                } else {
                    seatCountViewHolder.seatTips.setVisibility(0);
                    carSeatChoiceModel.intro.richText.bindTextView(seatCountViewHolder.seatTips);
                    if (!TextUtils.isEmpty(carSeatChoiceModel.intro.colorStart) && !TextUtils.isEmpty(carSeatChoiceModel.intro.colorEnd)) {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                        gradientDrawable.setColors(new int[]{Color.parseColor(carSeatChoiceModel.intro.colorStart), Color.parseColor(carSeatChoiceModel.intro.colorEnd)});
                        seatCountViewHolder.seatTips.setBackground(gradientDrawable);
                    }
                }
            }
            seatCountViewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (SeatCountAdapter.this.f13266e != null) {
                        SeatCountAdapter.this.f13266e.onItemClick(i);
                    }
                }
            });
        }
    }

    public int getItemCount() {
        List<CarSeatChoiceModel> list = this.f13263b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setSelectedPos(int i) {
        List<CarSeatChoiceModel> list;
        if (i >= 0 && (list = this.f13263b) != null && i < list.size() && !this.f13263b.get(i).isUnavailable) {
            this.f13265d = i;
            notifyDataSetChanged();
        }
    }

    static class SeatCountViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ConstraintLayout constraintLayout;
        ImageView itemImg;
        View itemLayout;
        LinearLayout priceLayout;
        TextView seatCount;
        TextView seatTips;

        public SeatCountViewHolder(View view) {
            super(view);
            this.itemLayout = view;
            this.cardView = (CardView) view.findViewById(R.id.seat_card_view_layout);
            this.constraintLayout = (ConstraintLayout) view.findViewById(R.id.seat_cl_layout);
            this.seatCount = (TextView) view.findViewById(R.id.seat_count_tv);
            this.itemImg = (ImageView) view.findViewById(R.id.seat_count_select_item_icon_iv);
            this.priceLayout = (LinearLayout) view.findViewById(R.id.seat_price_layout);
            this.seatTips = (TextView) view.findViewById(R.id.seat_tips);
        }
    }
}
