package com.didi.component.comp_travel_detail_new.view.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.didi.component.business.util.UiUtils;
import com.didi.component.comp_travel_detail_new.view.widget.RouteCardAddressView;
import com.didi.travel.psnger.model.response.StationModel;
import java.util.List;

public class RouteCardView extends LinearLayout {
    public static final int GUIDE_IMAGE_SIZE = 20;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f12508a;

    public RouteCardView(Context context) {
        super(context);
        m8494a(context);
    }

    public RouteCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8494a(context);
    }

    public RouteCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8494a(context);
    }

    /* renamed from: a */
    private void m8494a(Context context) {
        this.f12508a = context;
    }

    public void bindData(List<StationModel> list) {
        if (list != null && list.size() != 0) {
            boolean a = m8495a(list);
            final FrameLayout frameLayout = new FrameLayout(getContext());
            if (a) {
                addView(frameLayout);
            }
            for (int i = 0; i < list.size(); i++) {
                StationModel stationModel = list.get(i);
                if (stationModel != null) {
                    ImageView imageView = new ImageView(this.f12508a);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(UiUtils.dip2px(this.f12508a, 20.0f), UiUtils.dip2px(this.f12508a, 20.0f)));
                    frameLayout.addView(imageView);
                    if (!TextUtils.isEmpty(stationModel.guideImg)) {
                        Glide.with(this.f12508a).load(stationModel.guideImg).into(imageView);
                    }
                }
            }
            RouteCardAddressView routeCardAddressView = new RouteCardAddressView(this.f12508a);
            routeCardAddressView.setData(list, a);
            routeCardAddressView.setCallback(new RouteCardAddressView.Callback() {
                public void onCallback(int i, int i2) {
                    View childAt = frameLayout.getChildAt(i);
                    if (childAt != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new FrameLayout.LayoutParams(UiUtils.dip2px(RouteCardView.this.f12508a, 20.0f), UiUtils.dip2px(RouteCardView.this.f12508a, 20.0f));
                        }
                        layoutParams.topMargin = i2 - (UiUtils.dip2px(RouteCardView.this.f12508a, 20.0f) / 2);
                        childAt.setLayoutParams(layoutParams);
                    }
                }
            });
            addView(routeCardAddressView);
        }
    }

    /* renamed from: a */
    private boolean m8495a(List<StationModel> list) {
        if (!(list == null || list.size() == 0)) {
            for (int i = 0; i < list.size(); i++) {
                StationModel stationModel = list.get(i);
                if (stationModel != null && !TextUtils.isEmpty(stationModel.guideImg)) {
                    return true;
                }
            }
        }
        return false;
    }
}
