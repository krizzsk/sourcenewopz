package com.didiglobal.p205sa.biz.component.activity.viewhold;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.common.util.UIUtils;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityCardModel;
import com.didiglobal.p205sa.biz.component.activity.presenter.ActivityPanelPresenter;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.viewhold.ActivityOngingEmptyVH */
public class ActivityOngingEmptyVH extends BaseRecVH {

    /* renamed from: a */
    private ImageView f50780a;

    /* renamed from: b */
    private TextView f50781b;

    public ActivityOngingEmptyVH(View view) {
        super(view);
        this.f50780a = (ImageView) view.findViewById(R.id.empty_img);
        this.f50781b = (TextView) view.findViewById(R.id.empty_tips);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            ((RecyclerView.LayoutParams) layoutParams).setMargins(0, ActivityPanelPresenter.isNoData ? UIUtils.dip2pxInt(view.getContext(), 50.0f) : 0, 0, 0);
        }
    }

    public void bindView(ActivityCardModel activityCardModel) {
        if (activityCardModel != null) {
            ((RequestBuilder) Glide.with(this.itemView.getContext()).load(activityCardModel.getBusiness_image()).placeholder((int) R.drawable.sa_business_default)).into(this.f50780a);
            if (activityCardModel.getOrder_flag_tips() != null) {
                activityCardModel.getOrder_flag_tips().bindTextView(this.f50781b);
            }
        }
    }
}
