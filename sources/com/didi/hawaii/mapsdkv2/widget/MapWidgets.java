package com.didi.hawaii.mapsdkv2.widget;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Handler;
import android.widget.FrameLayout;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.map.outer.map.MapView;
import com.taxis99.R;

public class MapWidgets implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: n */
    private static final int[] f24143n = {Color.argb(255, 90, 90, 90), -1};

    /* renamed from: o */
    private static final int[] f24144o = {-1, Color.argb(255, 12, 12, 12)};

    /* renamed from: a */
    private final MapView f24145a;

    /* renamed from: b */
    private ScaleView f24146b;

    /* renamed from: c */
    private C9253a f24147c;

    /* renamed from: d */
    private GLBaseMapView f24148d;

    /* renamed from: e */
    private int f24149e = 20;

    /* renamed from: f */
    private int f24150f = 20;

    /* renamed from: g */
    private int f24151g = 12;

    /* renamed from: h */
    private int f24152h = 12;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f24153i = 5;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Handler f24154j;

    /* renamed from: k */
    private final float f24155k;

    /* renamed from: l */
    private int f24156l;

    /* renamed from: m */
    private ValueAnimator f24157m;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final Runnable f24158p = new Runnable() {
        public void run() {
            if (MapWidgets.this.f24153i == 4) {
                MapWidgets.this.m17245b(true);
                MapWidgets.this.m17241a(false);
            }
        }
    };

    /* renamed from: b */
    private static int m17242b(int i) {
        return (i == 9 || i == 11) ? R.drawable.didi_map_logo_night : R.drawable.didi_map_logo;
    }

    public MapWidgets(MapView mapView, GLBaseMapView gLBaseMapView) {
        this.f24156l = gLBaseMapView.getMapMode();
        this.f24145a = mapView;
        this.f24148d = gLBaseMapView;
        this.f24154j = gLBaseMapView.getMainHandler();
        this.f24155k = gLBaseMapView.getMapContext().getAndroidContext().getResources().getDisplayMetrics().density;
        m17237a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17241a(boolean z) {
        if (!z) {
            ScaleView scaleView = this.f24146b;
            if (scaleView != null) {
                scaleView.mo71539b();
                this.f24145a.removeView(this.f24146b);
                this.f24146b = null;
            }
        } else if (this.f24146b == null) {
            int[] c = m17247c(this.f24156l);
            this.f24146b = new ScaleView(this.f24145a.getContext(), this.f24148d, c[0], c[1]);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 83;
            layoutParams.leftMargin = this.f24149e;
            layoutParams.bottomMargin = this.f24150f;
            this.f24145a.addView(this.f24146b, layoutParams);
            this.f24146b.mo71537a();
        }
    }

    public void setScaleViewLeft(int i) {
        FrameLayout.LayoutParams layoutParams;
        this.f24149e = i;
        ScaleView scaleView = this.f24146b;
        if (scaleView != null && (layoutParams = (FrameLayout.LayoutParams) scaleView.getLayoutParams()) != null) {
            layoutParams.leftMargin = i;
            this.f24146b.setLayoutParams(layoutParams);
        }
    }

    public void setScaleViewBottom(int i) {
        FrameLayout.LayoutParams layoutParams;
        this.f24150f = i;
        ScaleView scaleView = this.f24146b;
        if (scaleView != null && (layoutParams = (FrameLayout.LayoutParams) scaleView.getLayoutParams()) != null) {
            layoutParams.bottomMargin = i;
            this.f24146b.setLayoutParams(layoutParams);
        }
    }

    public boolean isScaleViewVisible() {
        ScaleView scaleView = this.f24146b;
        if (scaleView != null && scaleView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void setLogoScaleShowMode(int i) {
        if ((i == 3 || i == 1 || i == 2 || i == 5 || i == 4) && this.f24153i != i) {
            this.f24153i = i;
            m17237a();
        }
    }

    /* renamed from: a */
    private void m17237a() {
        int i = this.f24153i;
        if (i == 1) {
            m17245b(true);
            m17241a(false);
            this.f24148d.setScaleRulerControl(new GLBaseMapView.ScaleRulerShowCallback() {
                public void onScaleChange() {
                }

                public void onMapModeChange(int i) {
                    MapWidgets.this.m17238a(i);
                }
            });
            this.f24154j.removeCallbacks(this.f24158p);
        } else if (i == 2) {
            m17245b(false);
            m17241a(true);
            this.f24148d.setScaleRulerControl(new GLBaseMapView.ScaleRulerShowCallback() {
                public void onScaleChange() {
                }

                public void onMapModeChange(int i) {
                    MapWidgets.this.m17238a(i);
                }
            });
            this.f24154j.removeCallbacks(this.f24158p);
        } else if (i == 3) {
            m17241a(true);
            m17245b(true);
            this.f24148d.setScaleRulerControl(new GLBaseMapView.ScaleRulerShowCallback() {
                public void onScaleChange() {
                }

                public void onMapModeChange(int i) {
                    MapWidgets.this.m17238a(i);
                }
            });
            this.f24154j.removeCallbacks(this.f24158p);
        } else if (i == 4) {
            m17245b(true);
            this.f24148d.setScaleRulerControl(new GLBaseMapView.ScaleRulerShowCallback() {
                public void onScaleChange() {
                    MapWidgets.this.m17241a(true);
                    MapWidgets.this.m17245b(false);
                    MapWidgets.this.f24154j.removeCallbacks(MapWidgets.this.f24158p);
                    MapWidgets.this.f24154j.postDelayed(MapWidgets.this.f24158p, 1000);
                }

                public void onMapModeChange(int i) {
                    MapWidgets.this.m17238a(i);
                }
            });
        } else if (i == 5) {
            m17245b(false);
            m17241a(false);
            this.f24148d.setScaleRulerControl((GLBaseMapView.ScaleRulerShowCallback) null);
            this.f24154j.removeCallbacks(this.f24158p);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17238a(int i) {
        this.f24156l = i;
        C9253a aVar = this.f24147c;
        if (aVar != null) {
            aVar.setImageResource(m17242b(i));
        }
        if (this.f24146b != null) {
            int[] c = m17247c(this.f24156l);
            this.f24146b.mo71538a(c[0], c[1]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17245b(boolean z) {
        if (z) {
            if (this.f24147c == null) {
                C9253a aVar = new C9253a(this.f24145a.getContext());
                this.f24147c = aVar;
                aVar.setAlpha(0);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 83;
                layoutParams.leftMargin = this.f24151g;
                layoutParams.bottomMargin = this.f24152h;
                this.f24147c.setImageResource(m17242b(this.f24156l));
                this.f24145a.addView(this.f24147c, layoutParams);
                ValueAnimator valueAnimator = this.f24157m;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.f24157m = null;
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 255});
                this.f24157m = ofInt;
                ofInt.addUpdateListener(this);
                this.f24157m.setDuration(600);
                this.f24157m.start();
            }
        } else if (this.f24147c != null) {
            ValueAnimator valueAnimator2 = this.f24157m;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.f24157m = null;
            }
            if (this.f24145a.indexOfChild(this.f24147c) != -1) {
                this.f24145a.removeView(this.f24147c);
            }
            this.f24147c = null;
        }
    }

    public void setLogoViewLeft(int i) {
        FrameLayout.LayoutParams layoutParams;
        this.f24151g = i - ((int) (((double) this.f24155k) * 3.5d));
        C9253a aVar = this.f24147c;
        if (aVar != null && (layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams()) != null) {
            layoutParams.leftMargin = this.f24151g;
            this.f24147c.setLayoutParams(layoutParams);
        }
    }

    public void setLogoViewBottom(int i) {
        FrameLayout.LayoutParams layoutParams;
        this.f24152h = i - ((int) (((double) this.f24155k) * 3.5d));
        C9253a aVar = this.f24147c;
        if (aVar != null && (layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams()) != null) {
            layoutParams.bottomMargin = this.f24152h;
            this.f24147c.setLayoutParams(layoutParams);
        }
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.f24147c != null) {
            this.f24147c.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: c */
    private static int[] m17247c(int i) {
        if (i == 9 || i == 11) {
            return f24144o;
        }
        return f24143n;
    }
}
