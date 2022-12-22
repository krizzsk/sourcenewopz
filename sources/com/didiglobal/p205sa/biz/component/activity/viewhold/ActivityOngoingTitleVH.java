package com.didiglobal.p205sa.biz.component.activity.viewhold;

import android.view.View;
import android.widget.TextView;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityCardModel;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.viewhold.ActivityOngoingTitleVH */
public class ActivityOngoingTitleVH extends BaseRecVH {

    /* renamed from: a */
    private final TextView f50790a;

    public ActivityOngoingTitleVH(View view) {
        super(view);
        this.f50790a = (TextView) view.findViewById(R.id.title);
    }

    public void bindView(ActivityCardModel activityCardModel) {
        if (activityCardModel != null && activityCardModel.getTitle() != null) {
            activityCardModel.getTitle().bindTextView(this.f50790a);
        }
    }
}
