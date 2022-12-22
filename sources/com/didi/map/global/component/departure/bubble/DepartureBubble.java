package com.didi.map.global.component.departure.bubble;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import com.didi.map.global.component.departure.bubble.MapBubble;

public abstract class DepartureBubble implements MapBubble {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ViewGroup f24876a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f24877b = false;

    /* renamed from: c */
    private int f24878c = 1;

    /* renamed from: d */
    private int f24879d = (1 * 400);

    /* renamed from: e */
    private int f24880e = (1 * 400);

    /* renamed from: f */
    private MapBubble.OnClickListener f24881f;

    /* access modifiers changed from: protected */
    public abstract View getView(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public abstract void setContentInvisible();

    /* access modifiers changed from: protected */
    public abstract void setContentVisible();

    public DepartureBubble(ViewGroup viewGroup) {
        this.f24876a = viewGroup;
    }

    public synchronized void show() {
        show(true);
    }

    public void setOnClickListener(MapBubble.OnClickListener onClickListener) {
        this.f24881f = onClickListener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void show(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.view.ViewGroup r0 = r4.f24876a     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            android.view.ViewGroup r0 = r4.f24876a     // Catch:{ all -> 0x006c }
            android.view.View r0 = r4.getView(r0)     // Catch:{ all -> 0x006c }
            android.view.ViewGroup r1 = r4.f24876a     // Catch:{ all -> 0x006c }
            int r1 = r1.getChildCount()     // Catch:{ all -> 0x006c }
            r2 = 0
            if (r1 <= 0) goto L_0x0018
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            if (r1 == 0) goto L_0x0039
            boolean r5 = r4.f24877b     // Catch:{ all -> 0x006c }
            if (r5 == 0) goto L_0x002d
            android.view.ViewGroup r5 = r4.f24876a     // Catch:{ all -> 0x006c }
            com.didi.map.global.component.departure.bubble.DepartureBubble$1 r1 = new com.didi.map.global.component.departure.bubble.DepartureBubble$1     // Catch:{ all -> 0x006c }
            r1.<init>(r0)     // Catch:{ all -> 0x006c }
            int r0 = r4.f24879d     // Catch:{ all -> 0x006c }
            long r2 = (long) r0     // Catch:{ all -> 0x006c }
            r5.postDelayed(r1, r2)     // Catch:{ all -> 0x006c }
            goto L_0x0037
        L_0x002d:
            android.view.ViewGroup r5 = r4.f24876a     // Catch:{ all -> 0x006c }
            r4.m17709a((android.view.ViewGroup) r5)     // Catch:{ all -> 0x006c }
            android.view.ViewGroup r5 = r4.f24876a     // Catch:{ all -> 0x006c }
            r5.addView(r0)     // Catch:{ all -> 0x006c }
        L_0x0037:
            monitor-exit(r4)
            return
        L_0x0039:
            com.didi.map.global.component.departure.bubble.-$$Lambda$DepartureBubble$LOnpiwezV9H2Kkq8EYBNaPaiTHk r1 = new com.didi.map.global.component.departure.bubble.-$$Lambda$DepartureBubble$LOnpiwezV9H2Kkq8EYBNaPaiTHk     // Catch:{ all -> 0x006c }
            r1.<init>()     // Catch:{ all -> 0x006c }
            r0.setOnClickListener(r1)     // Catch:{ all -> 0x006c }
            android.view.ViewGroup r1 = r4.f24876a     // Catch:{ all -> 0x006c }
            r1.addView(r0)     // Catch:{ all -> 0x006c }
            if (r5 == 0) goto L_0x006a
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r2)     // Catch:{ all -> 0x006c }
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r2)     // Catch:{ all -> 0x006c }
            r0.measure(r5, r1)     // Catch:{ all -> 0x006c }
            int r5 = r0.getMeasuredWidth()     // Catch:{ all -> 0x006c }
            int r1 = r0.getMeasuredHeight()     // Catch:{ all -> 0x006c }
            com.didi.map.global.component.departure.bubble.DepartureBubble$2 r2 = new com.didi.map.global.component.departure.bubble.DepartureBubble$2     // Catch:{ all -> 0x006c }
            r2.<init>()     // Catch:{ all -> 0x006c }
            android.view.animation.AnimationSet r5 = r4.m17707a(r5, r1, r2)     // Catch:{ all -> 0x006c }
            r4.setContentInvisible()     // Catch:{ all -> 0x006c }
            r0.startAnimation(r5)     // Catch:{ all -> 0x006c }
        L_0x006a:
            monitor-exit(r4)
            return
        L_0x006c:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.bubble.DepartureBubble.show(boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m17708a(View view) {
        MapBubble.OnClickListener onClickListener = this.f24881f;
        if (onClickListener != null) {
            onClickListener.onClick();
        }
    }

    public boolean isInAnimation() {
        return this.f24877b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17709a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).clearAnimation();
        }
        viewGroup.removeAllViews();
    }

    /* renamed from: a */
    private AnimationSet m17707a(int i, int i2, Animation.AnimationListener animationListener) {
        float f = (float) i2;
        ScaleAnimation scaleAnimation = new ScaleAnimation((0.66f * f) / ((float) i), 1.0f, 0.66f, 1.0f, (float) (i / 2), f);
        scaleAnimation.setDuration((long) this.f24879d);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration((long) this.f24880e);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(animationListener);
        return animationSet;
    }
}
