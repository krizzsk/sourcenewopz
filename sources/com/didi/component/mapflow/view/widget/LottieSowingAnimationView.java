package com.didi.component.mapflow.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.component.common.util.HandlerUtils;
import com.didi.component.core.IPresenter;
import com.didi.component.lifecycle.LifecycleOwner;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;

public class LottieSowingAnimationView extends FrameLayout {

    /* renamed from: a */
    private LottieAnimationView f14515a = ((LottieAnimationView) findViewById(R.id.global_map_anim_background));
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LottieAnimationView f14516b = ((LottieAnimationView) findViewById(R.id.global_map_anim_sowing));
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LottieAnimationView f14517c = ((LottieAnimationView) findViewById(R.id.global_map_anim_location));
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f14518d = findViewById(R.id.global_map_anim_sowing_group);

    /* renamed from: e */
    private boolean f14519e;

    /* renamed from: f */
    private boolean f14520f;

    /* renamed from: g */
    private boolean f14521g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f14522h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f14523i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LottieComposition f14524j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public LottieComposition f14525k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LottieComposition f14526l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Map f14527m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public LatLng f14528n;

    /* renamed from: o */
    private IPresenter f14529o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ObjectAnimator f14530p;

    /* renamed from: q */
    private boolean f14531q;

    public LottieSowingAnimationView(IPresenter iPresenter, Context context) {
        super(context);
        this.f14529o = iPresenter;
        LayoutInflater.from(context).inflate(R.layout.global_map_sowing_animation, this, true);
        ApmThreadPool.execute((Runnable) new Runnable() {
            public void run() {
                LottieSowingAnimationView lottieSowingAnimationView = LottieSowingAnimationView.this;
                LottieComposition unused = lottieSowingAnimationView.f14524j = LottieCompositionFactory.fromRawResSync(lottieSowingAnimationView.getContext(), R.raw.map_anim_background).getValue();
                LottieSowingAnimationView lottieSowingAnimationView2 = LottieSowingAnimationView.this;
                LottieComposition unused2 = lottieSowingAnimationView2.f14525k = LottieCompositionFactory.fromRawResSync(lottieSowingAnimationView2.getContext(), R.raw.map_anim_sowing).getValue();
                LottieSowingAnimationView lottieSowingAnimationView3 = LottieSowingAnimationView.this;
                LottieComposition unused3 = lottieSowingAnimationView3.f14526l = LottieCompositionFactory.fromRawResSync(lottieSowingAnimationView3.getContext(), R.raw.map_anim_location).getValue();
                LottieSowingAnimationView.this.m10315a();
            }
        });
        this.f14515a.post(new Runnable() {
            public void run() {
                LottieSowingAnimationView lottieSowingAnimationView = LottieSowingAnimationView.this;
                float unused = lottieSowingAnimationView.f14522h = (float) lottieSowingAnimationView.getMeasuredWidth();
                LottieSowingAnimationView lottieSowingAnimationView2 = LottieSowingAnimationView.this;
                float unused2 = lottieSowingAnimationView2.f14523i = (float) lottieSowingAnimationView2.getMeasuredHeight();
                LottieSowingAnimationView.this.m10315a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10315a() {
        LottieComposition lottieComposition = this.f14524j;
        if (lottieComposition != null) {
            int width = lottieComposition.getBounds().width();
            float f = this.f14522h;
            if (f > 0.0f) {
                float f2 = this.f14523i;
                if (f2 > 0.0f && width > 0) {
                    this.f14524j.getBounds().set(0, 0, width, (int) ((f2 / f) * ((float) width)));
                    this.f14520f = true;
                    if (this.f14521g) {
                        start();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    public void bindMap(Map map, LatLng latLng) {
        if (map != null && latLng != null) {
            this.f14527m = map;
            this.f14528n = latLng;
            m10320b();
        }
    }

    /* renamed from: b */
    private void m10320b() {
        if (this.f14527m != null && this.f14528n != null && this.f14518d != null) {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    LottieSowingAnimationView.this.f14517c.playAnimation();
                }
            }, 400);
            HandlerUtils.getMainHandler().lifecycle((LifecycleOwner) this.f14529o).last(new Runnable() {
                public void run() {
                    LottieSowingAnimationView.this.f14516b.playAnimation();
                }
            }).loop(new Runnable() {
                public void run() {
                    PointF pointF;
                    if (LottieSowingAnimationView.this.f14527m.getProjection() != null) {
                        pointF = LottieSowingAnimationView.this.f14527m.getProjection().toScreenLocation(LottieSowingAnimationView.this.f14528n);
                    } else {
                        pointF = new PointF((float) LottieSowingAnimationView.this.getResources().getDisplayMetrics().widthPixels, (float) (LottieSowingAnimationView.this.getResources().getDisplayMetrics().heightPixels / 2));
                    }
                    if (pointF != null) {
                        int measuredWidth = LottieSowingAnimationView.this.f14518d.getMeasuredWidth();
                        int measuredHeight = LottieSowingAnimationView.this.f14518d.getMeasuredHeight();
                        if (measuredWidth > 0 && measuredHeight > 0) {
                            LottieSowingAnimationView.this.f14518d.getX();
                            float y = LottieSowingAnimationView.this.f14518d.getY();
                            float f = pointF.x;
                            int i = measuredWidth / 2;
                            float f2 = pointF.y - ((float) (measuredHeight / 2));
                            if (LottieSowingAnimationView.this.f14530p != null) {
                                LottieSowingAnimationView.this.f14530p.cancel();
                            }
                            LottieSowingAnimationView lottieSowingAnimationView = LottieSowingAnimationView.this;
                            ObjectAnimator unused = lottieSowingAnimationView.f14530p = ObjectAnimator.ofFloat(lottieSowingAnimationView.f14518d, View.Y, new float[]{y, f2});
                            LottieSowingAnimationView.this.f14530p.setDuration(200);
                            LottieSowingAnimationView.this.f14530p.start();
                        }
                    }
                }
            }, 200, 1200);
        }
    }

    public boolean isSowing() {
        return this.f14531q;
    }

    public void start() {
        this.f14531q = true;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m10323c();
        } else {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    LottieSowingAnimationView.this.m10323c();
                }
            });
        }
    }

    public void stop() {
        this.f14531q = false;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m10325d();
        } else {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    LottieSowingAnimationView.this.m10325d();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10323c() {
        LottieComposition lottieComposition;
        LottieComposition lottieComposition2;
        LottieComposition lottieComposition3;
        this.f14519e = true;
        if (!this.f14520f) {
            this.f14521g = true;
            m10315a();
            return;
        }
        if (this.f14515a.getComposition() == null && (lottieComposition3 = this.f14524j) != null) {
            this.f14515a.setComposition(lottieComposition3);
        }
        if (this.f14516b.getComposition() == null && (lottieComposition2 = this.f14525k) != null) {
            this.f14516b.setComposition(lottieComposition2);
        }
        if (this.f14517c.getComposition() == null && (lottieComposition = this.f14526l) != null) {
            this.f14517c.setComposition(lottieComposition);
        }
        this.f14516b.setRepeatCount(-1);
        this.f14516b.addAnimatorListener(new AnimatorListenerAdapter() {
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                LottieSowingAnimationView.this.f14516b.setMinFrame(107);
            }

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LottieSowingAnimationView.this.f14516b.setMinFrame(36);
            }
        });
        this.f14515a.playAnimation();
        m10320b();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10325d() {
        this.f14515a.cancelAnimation();
        this.f14516b.cancelAnimation();
        this.f14517c.cancelAnimation();
        this.f14519e = false;
    }

    public void hideSowing() {
        this.f14516b.setVisibility(8);
        this.f14517c.setVisibility(8);
        this.f14515a.animate().alpha(0.0f).setDuration(640).start();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f14519e) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
