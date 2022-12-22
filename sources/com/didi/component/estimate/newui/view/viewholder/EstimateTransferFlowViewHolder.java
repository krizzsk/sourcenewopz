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
import com.didi.component.estimate.newui.view.DynamicArrowDrawable;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.taxis99.R;

public class EstimateTransferFlowViewHolder extends RecyclerView.ViewHolder {
    public static final int TYPE_HORIZON = 0;
    public static final int TYPE_VERTICAL = 1;

    /* renamed from: a */
    private Context f13219a;

    /* renamed from: b */
    private View f13220b;

    /* renamed from: c */
    private ImageView f13221c;

    /* renamed from: d */
    private TextView f13222d;

    /* renamed from: e */
    private View f13223e;

    /* renamed from: f */
    private GradientDrawable f13224f;

    /* renamed from: g */
    private DynamicArrowDrawable f13225g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CarMessageModel f13226h;

    /* renamed from: i */
    private int f13227i = -1;

    /* renamed from: j */
    private float f13228j;

    /* renamed from: k */
    private float f13229k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TransferFlowListener f13230l;

    /* renamed from: m */
    private RecyclerView f13231m;

    /* renamed from: n */
    private int f13232n = 0;

    /* renamed from: o */
    private RecyclerView.OnScrollListener f13233o = new RecyclerView.OnScrollListener() {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            EstimateTransferFlowViewHolder.this.m8996b();
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            EstimateTransferFlowViewHolder.this.m8996b();
        }
    };

    public interface TransferFlowListener {
        void onTransferFlowClick(CarMessageModel carMessageModel);

        void onTransferFlowCloseClick(CarMessageModel carMessageModel);
    }

    public EstimateTransferFlowViewHolder(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.estimate_item_transfer_flow, viewGroup, false));
        this.f13219a = viewGroup.getContext();
        m8993a();
    }

    /* renamed from: a */
    private void m8993a() {
        this.f13220b = this.itemView.findViewById(R.id.layout_card);
        this.f13221c = (ImageView) this.itemView.findViewById(R.id.iv_icon);
        this.f13222d = (TextView) this.itemView.findViewById(R.id.tv_msg);
        this.f13223e = this.itemView.findViewById(R.id.layout_close);
        this.f13228j = (float) UiUtils.dip2px(this.f13219a, 12.0f);
        this.f13229k = (float) UiUtils.dip2px(this.f13219a, 8.0f);
        DynamicArrowDrawable dynamicArrowDrawable = new DynamicArrowDrawable();
        this.f13225g = dynamicArrowDrawable;
        dynamicArrowDrawable.setCornerRadius((float) UiUtils.dip2px(this.f13219a, 20.0f));
        this.f13225g.setArrow(3, 0.0f, 0.0f, this.f13228j, this.f13229k);
        this.f13220b.setBackground(this.f13225g);
        this.f13220b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EstimateTransferFlowViewHolder.this.f13230l != null) {
                    EstimateTransferFlowViewHolder.this.f13230l.onTransferFlowClick(EstimateTransferFlowViewHolder.this.f13226h);
                }
            }
        });
        this.f13223e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EstimateTransferFlowViewHolder.this.f13230l != null) {
                    EstimateTransferFlowViewHolder.this.f13230l.onTransferFlowCloseClick(EstimateTransferFlowViewHolder.this.f13226h);
                }
            }
        });
    }

    public void setListener(TransferFlowListener transferFlowListener) {
        this.f13230l = transferFlowListener;
    }

    public void setCarRecyclerView(RecyclerView recyclerView) {
        this.f13231m = recyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.f13233o);
        }
    }

    public void setData(CarMessageModel carMessageModel, int i) {
        this.f13226h = carMessageModel;
        this.f13227i = i;
        update();
    }

    public void update() {
        int i;
        int i2;
        CarMessageModel carMessageModel = this.f13226h;
        if (carMessageModel == null || TextUtils.isEmpty(carMessageModel.messageBgStart) || TextUtils.isEmpty(this.f13226h.messageBgEnd)) {
            i2 = Color.parseColor("#FFEACC");
            i = Color.parseColor("#FFF7E6");
        } else {
            try {
                i2 = Color.parseColor(this.f13226h.messageBgStart);
                i = Color.parseColor(this.f13226h.messageBgEnd);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                i2 = Color.parseColor("#FFEACC");
                i = Color.parseColor("#FFF7E6");
            }
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i2, i});
        this.f13224f = gradientDrawable;
        gradientDrawable.setGradientType(0);
        this.f13225g.setSrcDrawable(this.f13224f);
        this.f13220b.setBackground(this.f13225g);
        this.itemView.post(new Runnable() {
            public void run() {
                EstimateTransferFlowViewHolder.this.m8996b();
            }
        });
        if (!TextUtils.isEmpty(this.f13226h.messageIcon)) {
            this.f13221c.setVisibility(0);
            Context context = this.f13219a;
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                Glide.with(this.f13219a).load(this.f13226h.messageIcon).into(this.f13221c);
            }
        } else {
            this.f13221c.setVisibility(8);
        }
        this.f13222d.setTextColor(UiUtils.parseColor(this.f13226h.messageTextColor, "#663300"));
        if (!TextUtils.isEmpty(this.f13226h.messageTex)) {
            this.f13222d.setText(this.f13226h.messageTex);
        } else {
            this.f13222d.setText("");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8996b() {
        int i;
        int i2;
        RecyclerView recyclerView = this.f13231m;
        if (recyclerView != null && (i = this.f13227i) >= 0) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i);
            if (findViewHolderForAdapterPosition == null) {
                this.f13225g.setArrow(3, 0.0f, 0.0f, this.f13228j, this.f13229k);
                return;
            }
            int[] iArr = new int[2];
            findViewHolderForAdapterPosition.itemView.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            this.f13220b.getLocationOnScreen(iArr2);
            float max = (float) Math.max(iArr[0], iArr2[0]);
            float min = (float) Math.min(iArr[0] + findViewHolderForAdapterPosition.itemView.getWidth(), iArr2[0] + this.f13220b.getWidth());
            if (this.f13232n == 1) {
                i2 = UiUtils.dip2px(this.f13219a, 80.0f);
            } else {
                i2 = (((int) (max + min)) / 2) - iArr2[0];
            }
            this.f13225g.setArrow(3, (float) i2, (float) UiUtils.dip2px(this.f13219a, 40.0f), this.f13228j, this.f13229k);
        }
    }

    public void setType(int i) {
        this.f13232n = i;
    }
}
