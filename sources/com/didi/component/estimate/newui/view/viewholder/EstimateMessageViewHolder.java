package com.didi.component.estimate.newui.view.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.UiUtils;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.taxis99.R;

public class EstimateMessageViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private Context f13211a;

    /* renamed from: b */
    private View f13212b;

    /* renamed from: c */
    private View f13213c;

    /* renamed from: d */
    private View f13214d;

    /* renamed from: e */
    private ImageView f13215e;

    /* renamed from: f */
    private TextView f13216f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CarMessageModel f13217g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MessageListener f13218h;

    public interface MessageListener {
        void onMessageClick(CarMessageModel carMessageModel);
    }

    public EstimateMessageViewHolder(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.estimate_item_message, viewGroup, false));
        this.f13211a = viewGroup.getContext();
        m8991a();
    }

    /* renamed from: a */
    private void m8991a() {
        this.f13214d = this.itemView.findViewById(R.id.layout_card_root);
        this.f13213c = this.itemView.findViewById(R.id.layer_view);
        this.f13212b = this.itemView.findViewById(R.id.layout_card);
        this.f13215e = (ImageView) this.itemView.findViewById(R.id.iv_icon);
        this.f13216f = (TextView) this.itemView.findViewById(R.id.tv_message);
        this.f13212b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EstimateMessageViewHolder.this.f13218h != null) {
                    EstimateMessageViewHolder.this.f13218h.onMessageClick(EstimateMessageViewHolder.this.f13217g);
                }
            }
        });
    }

    public void setListener(MessageListener messageListener) {
        this.f13218h = messageListener;
    }

    public void setData(CarMessageModel carMessageModel) {
        this.f13217g = carMessageModel;
        update();
    }

    public void update() {
        int i;
        int i2;
        CarMessageModel carMessageModel = this.f13217g;
        if (carMessageModel == null || TextUtils.isEmpty(carMessageModel.messageBgStart) || TextUtils.isEmpty(this.f13217g.messageBgEnd)) {
            i2 = Color.parseColor("#FFDDCC");
            i = Color.parseColor("#FFF0E6");
        } else {
            try {
                i2 = Color.parseColor(this.f13217g.messageBgStart);
                i = Color.parseColor(this.f13217g.messageBgEnd);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                i2 = Color.parseColor("#FFDDCC");
                i = Color.parseColor("#FFF0E6");
            }
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i2, i});
        gradientDrawable.setGradientType(0);
        this.f13213c.setVisibility(8);
        this.f13213c.setVisibility(0);
        gradientDrawable.setCornerRadii(new float[]{(float) UiUtils.dip2px(this.f13211a, 20.0f), (float) UiUtils.dip2px(this.f13211a, 20.0f), (float) UiUtils.dip2px(this.f13211a, 20.0f), (float) UiUtils.dip2px(this.f13211a, 20.0f), 0.0f, 0.0f, 0.0f, 0.0f});
        this.f13214d.setBackground(gradientDrawable);
        CarMessageModel carMessageModel2 = this.f13217g;
        if (carMessageModel2 == null || TextUtils.isEmpty(carMessageModel2.messageIcon)) {
            this.f13215e.setVisibility(8);
        } else {
            this.f13215e.setVisibility(0);
            Context context = this.f13211a;
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                Glide.with(this.f13211a).load(this.f13217g.messageIcon).into(this.f13215e);
            }
        }
        TextView textView = this.f13216f;
        CarMessageModel carMessageModel3 = this.f13217g;
        textView.setTextColor(UiUtils.parseColor(carMessageModel3 != null ? carMessageModel3.messageTextColor : null, "#662200"));
        CarMessageModel carMessageModel4 = this.f13217g;
        if (carMessageModel4 == null || TextUtils.isEmpty(carMessageModel4.messageTex)) {
            this.f13216f.setText("");
        } else {
            this.f13216f.setText(this.f13217g.messageTex);
        }
    }
}
