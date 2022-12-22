package com.didiglobal.p205sa.biz.component.activity.viewhold;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityCardModel;

/* renamed from: com.didiglobal.sa.biz.component.activity.viewhold.BaseRecVH */
public abstract class BaseRecVH extends RecyclerView.ViewHolder {
    public abstract void bindView(ActivityCardModel activityCardModel);

    public BaseRecVH(View view) {
        super(view);
    }
}
