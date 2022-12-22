package com.didi.entrega.home.shimmer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.home.shimmer.adapter.ShimmerBaseAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShimmerRecyclerView extends RecyclerView {

    /* renamed from: a */
    private static final int f20728a = 125;

    /* renamed from: b */
    private ShimmerViewType f20729b;

    /* renamed from: c */
    private int[] f20730c = {1726540011, -1712789269, -857151253, -1513237, -1513237, -857151253, -1712789269, 1726540011};
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AnimatorSet f20731d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f20732e = true;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m15168a(View view, MotionEvent motionEvent) {
        return true;
    }

    public ShimmerRecyclerView(Context context) {
        super(context);
        m15166a(context);
    }

    public ShimmerRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15166a(context);
    }

    public ShimmerRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15166a(context);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            AnimatorSet animatorSet = this.f20731d;
            if (animatorSet != null && !animatorSet.isRunning()) {
                this.f20732e = true;
                this.f20731d.start();
                return;
            }
            return;
        }
        AnimatorSet animatorSet2 = this.f20731d;
        if (animatorSet2 != null) {
            this.f20732e = false;
            animatorSet2.cancel();
            this.f20731d.end();
        }
    }

    public void startShimmerAnimator(ShimmerViewType shimmerViewType) {
        if (shimmerViewType != this.f20729b) {
            setAlpha(1.0f);
            setAdapter((RecyclerView.Adapter) null);
            m15164a();
            this.f20729b = shimmerViewType;
            setAdapter(ShimmerAdapterFactory.createShimmerAdapter(shimmerViewType));
            postDelayed(new Runnable() {
                public final void run() {
                    ShimmerRecyclerView.this.m15171b();
                }
            }, 200);
        }
    }

    public void stopShimmerAnimator(AnimatorListenerAdapter animatorListenerAdapter) {
        m15164a();
        m15165a(animatorListenerAdapter);
    }

    public void onDestroy() {
        m15164a();
    }

    /* renamed from: a */
    private void m15165a(AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(350);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
    }

    /* renamed from: a */
    private void m15164a() {
        this.f20732e = false;
        this.f20729b = null;
        AnimatorSet animatorSet = this.f20731d;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f20731d.end();
            this.f20731d.removeAllListeners();
            this.f20731d = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15171b() {
        ShimmerBaseAdapter shimmerBaseAdapter = (ShimmerBaseAdapter) getAdapter();
        if (shimmerBaseAdapter != null && !CollectionsUtil.isEmpty(shimmerBaseAdapter.getAnimationViewSet())) {
            List<List<View>> animationViewSet = shimmerBaseAdapter.getAnimationViewSet();
            this.f20731d = new AnimatorSet();
            this.f20732e = true;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < animationViewSet.size(); i++) {
                List list = animationViewSet.get(i);
                if (!CollectionsUtil.isEmpty(list)) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(this.f20730c);
                    ofInt.setEvaluator(new ArgbEvaluator());
                    ofInt.setDuration(1000);
                    ofInt.setStartDelay((long) (i * 125));
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(list) {
                        public final /* synthetic */ List f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ShimmerRecyclerView.m15167a(this.f$0, valueAnimator);
                        }
                    });
                    arrayList.add(ofInt);
                }
            }
            if (arrayList.size() > 0) {
                this.f20731d.playTogether(arrayList);
                this.f20731d.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (ShimmerRecyclerView.this.f20732e && ShimmerRecyclerView.this.f20731d != null) {
                            ShimmerRecyclerView.this.f20731d.start();
                        }
                    }
                });
                this.f20731d.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15167a(List list, ValueAnimator valueAnimator) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((GradientDrawable) ((View) it.next()).getBackground()).setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: a */
    private void m15166a(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        setLayoutManager(linearLayoutManager);
        setOnTouchListener($$Lambda$ShimmerRecyclerView$dctEypjSyVI52Aaqv4eShOJius.INSTANCE);
        setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF));
    }
}
