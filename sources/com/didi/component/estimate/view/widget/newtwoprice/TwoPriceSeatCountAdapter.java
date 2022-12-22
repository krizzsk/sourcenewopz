package com.didi.component.estimate.view.widget.newtwoprice;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.travel.psnger.model.response.estimate.CarSeatChoiceModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class TwoPriceSeatCountAdapter extends RecyclerView.Adapter<SeatCountViewHolder> {

    /* renamed from: a */
    private Context f13278a;

    /* renamed from: b */
    private List<CarSeatChoiceModel> f13279b;

    /* renamed from: c */
    private LayoutInflater f13280c;

    /* renamed from: d */
    private int f13281d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnSeatItemClickListener f13282e;

    public interface OnSeatItemClickListener {
        void onItemClick(int i);
    }

    public TwoPriceSeatCountAdapter(Context context) {
        this.f13278a = context;
        this.f13279b = new ArrayList();
        this.f13280c = LayoutInflater.from(context);
    }

    public List<CarSeatChoiceModel> getData() {
        return this.f13279b;
    }

    public void updateData(List<CarSeatChoiceModel> list) {
        this.f13279b = list;
        notifyDataSetChanged();
    }

    public void setOnSeatItemClickListener(OnSeatItemClickListener onSeatItemClickListener) {
        this.f13282e = onSeatItemClickListener;
    }

    public SeatCountViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SeatCountViewHolder(this.f13280c.inflate(R.layout.global_two_price_list_item_new_ui, viewGroup, false));
    }

    public void onBindViewHolder(SeatCountViewHolder seatCountViewHolder, final int i) {
        CarSeatChoiceModel carSeatChoiceModel = this.f13279b.get(i);
        seatCountViewHolder.seatCount.setText(carSeatChoiceModel.choiceText.getContent());
        if (this.f13281d == i) {
            seatCountViewHolder.itemImg.setImageResource(DidiThemeManager.getIns().getResPicker(this.f13278a).getResIdByTheme(R.attr.new_ui_common_icon_radio_large));
            carSeatChoiceModel.valueText.bindTextView(seatCountViewHolder.price);
        } else {
            seatCountViewHolder.itemImg.setImageResource(R.drawable.com_icon_radio_large_unsel);
            seatCountViewHolder.price.setText("");
        }
        if (this.f13281d != i || carSeatChoiceModel == null || carSeatChoiceModel.extraText == null || TextUtils.isEmpty(carSeatChoiceModel.extraText.getContent())) {
            seatCountViewHolder.tips.setText("");
        } else {
            carSeatChoiceModel.extraText.bindTextView(seatCountViewHolder.tips);
        }
        seatCountViewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TwoPriceSeatCountAdapter.this.f13282e != null) {
                    TwoPriceSeatCountAdapter.this.f13282e.onItemClick(i);
                }
            }
        });
    }

    public int getItemCount() {
        List<CarSeatChoiceModel> list = this.f13279b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setSelectedPos(int i) {
        if (i >= 0) {
            this.f13281d = i;
            notifyDataSetChanged();
        }
    }

    static class SeatCountViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImg;
        View itemLayout;
        TextView peopleTv;
        TextView price;
        TextView seatCount;
        TextView tips;

        public SeatCountViewHolder(View view) {
            super(view);
            this.itemLayout = view;
            this.seatCount = (TextView) view.findViewById(R.id.seat_count_number);
            this.peopleTv = (TextView) view.findViewById(R.id.seat_rider_text);
            this.price = (TextView) view.findViewById(R.id.seat_count_estimate_price);
            this.itemImg = (ImageView) view.findViewById(R.id.seat_count_select_item_icon);
            this.tips = (TextView) view.findViewById(R.id.seat_count_tips);
        }
    }
}
