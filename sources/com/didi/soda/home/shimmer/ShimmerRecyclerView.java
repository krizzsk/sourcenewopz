package com.didi.soda.home.shimmer;

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
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.home.shimmer.adapter.ShimmerBaseAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShimmerRecyclerView extends RecyclerView {

    /* renamed from: a */
    private static final int f42728a = 125;

    /* renamed from: b */
    private ShimmerViewType f42729b;

    /* renamed from: c */
    private int[] f42730c = {1726211046, -1713118234, -857480218, -1842202, -1842202, -857480218, -1713118234, 1726211046};
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AnimatorSet f42731d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f42732e = true;

    /* renamed from: f */
    private boolean f42733f = true;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m30175a(View view, MotionEvent motionEvent) {
        return true;
    }

    public void setListDelay(boolean z) {
        this.f42733f = z;
    }

    public ShimmerRecyclerView(Context context) {
        super(context);
        m30173a(context);
    }

    public ShimmerRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30173a(context);
    }

    public ShimmerRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30173a(context);
    }

    public void startShimmerAnimator(ShimmerViewType shimmerViewType) {
        if (shimmerViewType != this.f42729b) {
            setAlpha(1.0f);
            setAdapter((RecyclerView.Adapter) null);
            m30171a();
            this.f42729b = shimmerViewType;
            setAdapter(ShimmerAdapterFactory.creatShimmerAdapter(shimmerViewType));
            postDelayed(new Runnable() {
                public final void run() {
                    ShimmerRecyclerView.this.m30179c();
                }
            }, 200);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m30179c() {
        try {
            m30178b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopShimmerAnimator(AnimatorListenerAdapter animatorListenerAdapter) {
        m30171a();
        m30172a(animatorListenerAdapter);
    }

    public void onDestory() {
        m30171a();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            AnimatorSet animatorSet = this.f42731d;
            if (animatorSet != null && !animatorSet.isRunning()) {
                this.f42732e = true;
                this.f42731d.start();
                return;
            }
            return;
        }
        AnimatorSet animatorSet2 = this.f42731d;
        if (animatorSet2 != null) {
            this.f42732e = false;
            animatorSet2.cancel();
            this.f42731d.end();
        }
    }

    /* renamed from: a */
    private void m30172a(AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(350);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
    }

    /* renamed from: a */
    private void m30171a() {
        this.f42732e = false;
        this.f42729b = null;
        AnimatorSet animatorSet = this.f42731d;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f42731d.end();
            this.f42731d.removeAllListeners();
            this.f42731d = null;
        }
    }

    /* renamed from: b */
    private void m30178b() {
        ShimmerBaseAdapter shimmerBaseAdapter = (ShimmerBaseAdapter) getAdapter();
        if (shimmerBaseAdapter != null && !CollectionsUtil.isEmpty(shimmerBaseAdapter.getAnimationViewSet()) && !this.f42732e) {
            List<List<View>> animationViewSet = shimmerBaseAdapter.getAnimationViewSet();
            this.f42731d = new AnimatorSet();
            this.f42732e = true;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < animationViewSet.size(); i++) {
                List list = animationViewSet.get(i);
                if (!CollectionsUtil.isEmpty(list)) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(this.f42730c);
                    ofInt.setEvaluator(new ArgbEvaluator());
                    ofInt.setDuration(1000);
                    if (this.f42733f) {
                        ofInt.setStartDelay((long) (i * 125));
                    }
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(list) {
                        public final /* synthetic */ List f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ShimmerRecyclerView.m30174a(this.f$0, valueAnimator);
                        }
                    });
                    arrayList.add(ofInt);
                }
            }
            if (arrayList.size() > 0) {
                this.f42731d.playTogether(arrayList);
                this.f42731d.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (ShimmerRecyclerView.this.f42732e && ShimmerRecyclerView.this.f42731d != null) {
                            ShimmerRecyclerView.this.f42731d.start();
                        }
                    }
                });
                this.f42731d.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m30174a(List list, ValueAnimator valueAnimator) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((GradientDrawable) ((View) it.next()).getBackground()).setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: a */
    private void m30173a(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        setLayoutManager(linearLayoutManager);
        setOnTouchListener($$Lambda$ShimmerRecyclerView$G5p_vRk8e4pczNTPJdl9oOVGso.INSTANCE);
        setBackgroundColor(context.getResources().getColor(R.color.rf_color_v2_grey2_10_a100));
    }
}
