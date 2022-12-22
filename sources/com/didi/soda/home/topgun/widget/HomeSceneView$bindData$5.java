package com.didi.soda.home.topgun.widget;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.soda.home.widget.TrapezoidDrawable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/home/topgun/widget/HomeSceneView$bindData$5", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeSceneView.kt */
public final class HomeSceneView$bindData$5 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ HomeSceneView this$0;

    HomeSceneView$bindData$5(HomeSceneView homeSceneView) {
        this.this$0 = homeSceneView;
    }

    public boolean onPreDraw() {
        ViewGroup.LayoutParams layoutParams = this.this$0.getFlTrapezoid().getLayoutParams();
        layoutParams.height = this.this$0.getMeasuredHeight();
        this.this$0.getFlTrapezoid().setLayoutParams(layoutParams);
        TrapezoidDrawable.Companion companion = TrapezoidDrawable.Companion;
        HomeSceneView homeSceneView = this.this$0;
        TrapezoidDrawable.Builder builder = new TrapezoidDrawable.Builder();
        builder.setTopPercent(homeSceneView.topPercent);
        builder.setBottomPercent(homeSceneView.bottomPercent);
        builder.setRightColor(homeSceneView.rightColor);
        builder.setRoundCorner(homeSceneView.roundRadius);
        this.this$0.getFlTrapezoid().setBackground(builder.build());
        this.this$0.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
}
