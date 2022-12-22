package com.didi.component.expectation.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.didi.component.expectation.model.AnyCarRequesting;
import com.taxis99.R;
import java.util.List;

public class AnyCarRequestingAdapter extends RecyclerView.Adapter<AnyCarRequestingViewHolder> {

    /* renamed from: a */
    private Context f13682a;

    /* renamed from: b */
    private List<AnyCarRequesting> f13683b;

    public AnyCarRequestingAdapter(Context context, List<AnyCarRequesting> list) {
        this.f13682a = context;
        this.f13683b = list;
    }

    public AnyCarRequestingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AnyCarRequestingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.anycar_expectation_car_requesting_item, viewGroup, false));
    }

    public void onBindViewHolder(AnyCarRequestingViewHolder anyCarRequestingViewHolder, int i) {
        List<AnyCarRequesting> list = this.f13683b;
        if (list != null) {
            AnyCarRequesting anyCarRequesting = list.get(i);
            String str = anyCarRequesting.iconUrl;
            if (!TextUtils.isEmpty(str)) {
                Glide.with(this.f13682a.getApplicationContext()).load(str).into(anyCarRequestingViewHolder.anyCarRequestingIcon);
            }
            anyCarRequestingViewHolder.anyCarRequestingTitle.setText(anyCarRequesting.typeName);
            if (anyCarRequesting.statusDes != null) {
                anyCarRequesting.statusDes.bindTextView(anyCarRequestingViewHolder.anyCarRequestingStatus);
            }
            anyCarRequestingViewHolder.anyCarRequestingStatusAnimation.playAnimation();
        }
    }

    public int getItemCount() {
        List<AnyCarRequesting> list = this.f13683b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    class AnyCarRequestingViewHolder extends RecyclerView.ViewHolder {
        public ImageView anyCarRequestingIcon;
        public TextView anyCarRequestingStatus;
        public LottieAnimationView anyCarRequestingStatusAnimation;
        public TextView anyCarRequestingTitle;

        public AnyCarRequestingViewHolder(View view) {
            super(view);
            this.anyCarRequestingIcon = (ImageView) view.findViewById(R.id.any_car_requesting_icon);
            this.anyCarRequestingTitle = (TextView) view.findViewById(R.id.any_car_requesting_title);
            this.anyCarRequestingStatus = (TextView) view.findViewById(R.id.any_car_requesting_status);
            this.anyCarRequestingStatusAnimation = (LottieAnimationView) view.findViewById(R.id.any_car_requesting_status_animation);
        }
    }
}
