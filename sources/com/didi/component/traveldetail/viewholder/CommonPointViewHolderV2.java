package com.didi.component.traveldetail.viewholder;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.component.traveldetail.model.TravelDetailItemV2;
import com.taxis99.R;

public class CommonPointViewHolderV2 extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private TextView f16172a = ((TextView) this.itemView.findViewById(R.id.travelCommonText));

    /* renamed from: b */
    private ImageView f16173b = ((ImageView) this.itemView.findViewById(R.id.routeIcon));

    /* renamed from: c */
    private LottieAnimationView f16174c = ((LottieAnimationView) this.itemView.findViewById(R.id.anim));

    public CommonPointViewHolderV2(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_travel_detail_common_point_item_layout_v2, viewGroup, false));
    }

    public void bindData(TravelDetailItemV2 travelDetailItemV2) {
        if (travelDetailItemV2 != null) {
            this.f16172a.setText(travelDetailItemV2.title);
            if (travelDetailItemV2.needAsh) {
                this.f16172a.setTextColor(Color.parseColor("#D4D7D9"));
            } else {
                this.f16172a.setTextColor(Color.parseColor("#000000"));
            }
            this.f16173b.setImageResource(travelDetailItemV2.iconRes);
            if (travelDetailItemV2.isPlay) {
                this.f16174c.setVisibility(0);
                if (travelDetailItemV2.isStartAddress()) {
                    this.f16174c.setAnimation("anim/travel_card_anim_data_start.json");
                } else {
                    this.f16174c.setAnimation("anim/travel_card_anim_data_end.json");
                }
                this.f16174c.playAnimation();
                return;
            }
            this.f16174c.setVisibility(4);
            this.f16174c.pauseAnimation();
        }
    }
}
