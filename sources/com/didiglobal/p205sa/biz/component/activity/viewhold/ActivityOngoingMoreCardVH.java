package com.didiglobal.p205sa.biz.component.activity.viewhold;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityCardModel;
import com.didiglobal.p205sa.biz.component.activity.omega.ActivityOmegaTracker;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.viewhold.ActivityOngoingMoreCardVH */
public class ActivityOngoingMoreCardVH extends BaseRecVH {

    /* renamed from: a */
    boolean f50789a = false;

    /* renamed from: com.didiglobal.sa.biz.component.activity.viewhold.ActivityOngoingMoreCardVH$IViewMoreListener */
    public interface IViewMoreListener {
        void onLoadMoreOrLess(boolean z);
    }

    public void bindView(ActivityCardModel activityCardModel) {
    }

    public ActivityOngoingMoreCardVH(View view, final IViewMoreListener iViewMoreListener) {
        super(view);
        final TextView textView = (TextView) view.findViewById(R.id.view_more_tv);
        final ImageView imageView = (ImageView) view.findViewById(R.id.view_more_icon);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ActivityOngoingMoreCardVH activityOngoingMoreCardVH = ActivityOngoingMoreCardVH.this;
                activityOngoingMoreCardVH.f50789a = !activityOngoingMoreCardVH.f50789a;
                IViewMoreListener iViewMoreListener = iViewMoreListener;
                if (iViewMoreListener != null) {
                    iViewMoreListener.onLoadMoreOrLess(ActivityOngoingMoreCardVH.this.f50789a);
                    if (ActivityOngoingMoreCardVH.this.f50789a) {
                        textView.setText(R.string.GRider_batch1__dIMV);
                        imageView.setImageResource(R.drawable.sa_activity_fold_arrow);
                    } else {
                        textView.setText(R.string.GRider_batch1__YuLO);
                        imageView.setImageResource(R.drawable.sa_activity_more_arrow);
                    }
                }
                ActivityOmegaTracker.OmegaViewMoreClick();
            }
        });
    }
}
