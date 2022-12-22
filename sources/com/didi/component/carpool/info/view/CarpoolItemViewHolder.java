package com.didi.component.carpool.info.view;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.component.carpool.info.model.CarpoolInfoItem;
import com.taxis99.R;

public class CarpoolItemViewHolder {

    /* renamed from: a */
    LottieAnimationView f11462a;

    /* renamed from: b */
    ImageView f11463b;

    /* renamed from: c */
    TextView f11464c;

    /* renamed from: d */
    TextView f11465d;

    /* renamed from: e */
    int f11466e;

    public CarpoolItemViewHolder(View view, int i) {
        this.f11462a = (LottieAnimationView) view.findViewById(R.id.global_travel_detail_head);
        this.f11463b = (ImageView) view.findViewById(R.id.global_travel_detail_icon);
        this.f11464c = (TextView) view.findViewById(R.id.global_travel_detail_title);
        this.f11465d = (TextView) view.findViewById(R.id.global_travel_detail_sub_title);
        this.f11466e = i;
    }

    public void setData(CarpoolInfoItem carpoolInfoItem, int i) {
        if (!TextUtils.isEmpty(carpoolInfoItem.title)) {
            this.f11464c.setVisibility(0);
            this.f11464c.setText(carpoolInfoItem.title);
        } else {
            this.f11464c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(carpoolInfoItem.subTitle)) {
            this.f11465d.setVisibility(0);
            this.f11465d.setText(carpoolInfoItem.subTitle);
        } else {
            this.f11465d.setVisibility(8);
        }
        int i2 = carpoolInfoItem.viewType;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        this.f11463b.setImageResource(R.drawable.global_com_icon_distination);
                    }
                } else if (carpoolInfoItem.status == 1) {
                    this.f11463b.setImageResource(R.drawable.global_travel_detail_via_history_point_20);
                } else {
                    this.f11463b.setImageResource(R.drawable.global_travel_detail_via_point);
                }
            } else if (carpoolInfoItem.status == 1) {
                this.f11463b.setImageResource(R.drawable.global_travel_detail_via_history_point_20);
            } else if (carpoolInfoItem.status == 0) {
                this.f11463b.setImageResource(R.drawable.global_travel_detail_pickup_point_20);
            } else if (carpoolInfoItem.status == 2) {
                this.f11463b.setImageResource(R.drawable.global_travel_detail_people_via_point_20);
            }
        } else if (carpoolInfoItem.status == 1) {
            this.f11463b.setImageResource(R.drawable.global_travel_detail_history_point_20);
        } else {
            this.f11463b.setImageResource(R.drawable.global_com_icon_pickup);
        }
        if (carpoolInfoItem.status == 0) {
            this.f11464c.setTypeface(Typeface.DEFAULT_BOLD);
            if (carpoolInfoItem.viewType == 0 || carpoolInfoItem.viewType == 1) {
                this.f11462a.setAnimation("anim/travel_card_anim_data_start.json");
            } else {
                this.f11462a.setAnimation("anim/travel_card_anim_data_end.json");
            }
            this.f11462a.setRepeatCount(-1);
            this.f11462a.playAnimation();
            return;
        }
        this.f11464c.setTypeface(Typeface.DEFAULT);
        this.f11462a.pauseAnimation();
    }
}
