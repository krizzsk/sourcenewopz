package com.didi.entrega.home.component.feed.binder.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomeRvExposeUtil;
import com.didi.entrega.customer.widget.scroll.SlowLinearLayoutManager;
import com.didi.nova.assembly.p127ui.banner.OnBannerClickListener;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class RvBanner extends RecyclerView {
    public static final long DEFAULT_AUTO_PLAY_DELAY = 4100;
    public static final String TAG = "RvBanner";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Runnable f20669a;

    /* renamed from: b */
    private FitType f20670b;

    /* renamed from: c */
    private int f20671c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RvBannerAdapter f20672d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f20673e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<String> f20674f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f20675g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f20676h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f20677i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f20678j;
    public OnBannerClickListener mOnBannerClickListener;

    public RvBanner(Context context) {
        this(context, (AttributeSet) null);
    }

    public RvBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RvBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20669a = new Runnable() {
            public void run() {
                if (RvBanner.this.f20675g > 1) {
                    RvBanner.this.smoothScrollToPosition((RvBanner.this.f20673e + 1) % RvBanner.this.f20672d.getItemCount());
                }
                if (RvBanner.this.f20676h) {
                    RvBanner.this.f20678j.postDelayed(RvBanner.this.f20669a, RvBanner.this.f20677i);
                }
            }
        };
        this.f20673e = -1;
        this.f20674f = new ArrayList();
        this.f20676h = false;
        this.f20677i = 4100;
        this.f20678j = new Handler(Looper.getMainLooper());
        m15128a(context, attributeSet);
        m15127a(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f20676h) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                start();
            } else if (action == 0) {
                stop();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        stop();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            stop();
        } else {
            start();
        }
    }

    public void setIsAutoPlay(boolean z) {
        this.f20676h = z;
    }

    public void setBannerClickListener(OnBannerClickListener onBannerClickListener) {
        this.mOnBannerClickListener = onBannerClickListener;
    }

    public void setDatas(Context context, float f, List<String> list, OnBannerImageDownLoadListener onBannerImageDownLoadListener) {
        if (list != null && !list.isEmpty()) {
            this.f20674f.clear();
            this.f20674f.addAll(list);
            this.f20675g = list.size();
            RvBannerAdapter rvBannerAdapter = new RvBannerAdapter(this, context, f, this.f20674f, onBannerImageDownLoadListener);
            this.f20672d = rvBannerAdapter;
            rvBannerAdapter.f20680a = this.f20671c;
            this.f20672d.f20681b = this.f20670b;
            this.f20672d.f20682c = this.f20676h;
            setAdapter(this.f20672d);
            m15125a();
            if (getOnFlingListener() == null) {
                new CardSnapHelper().attachToRecyclerView(this);
            }
            if (this.f20676h) {
                this.f20673e = this.f20674f.size() * 1000;
                getLayoutManager().scrollToPosition(this.f20673e);
            } else {
                this.f20673e = 0;
            }
            start();
        }
    }

    public void start() {
        this.f20678j.removeCallbacks(this.f20669a);
        if (this.f20676h) {
            this.f20678j.postDelayed(this.f20669a, this.f20677i);
        }
    }

    public void stop() {
        this.f20678j.removeCallbacks(this.f20669a);
    }

    /* renamed from: a */
    private void m15128a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaRvBanner);
        this.f20676h = obtainStyledAttributes.getBoolean(1, false);
        this.f20670b = FitType.values()[obtainStyledAttributes.getInt(0, 0)];
        this.f20671c = obtainStyledAttributes.getResourceId(4, 0);
        obtainStyledAttributes.recycle();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            LogUtil.m14765i("RvBanner", "initAttrs banner rv width =" + layoutParams.width + ",height = " + layoutParams.width);
        }
    }

    /* renamed from: a */
    private void m15127a(Context context) {
        setLayoutManager(new SlowLinearLayoutManager(context, 0, false));
        RecyclerViewCornerRadius recyclerViewCornerRadius = new RecyclerViewCornerRadius(this);
        recyclerViewCornerRadius.setCornerRadius(context.getResources().getDimensionPixelOffset(R.dimen.rf_dimen_40));
        addItemDecoration(recyclerViewCornerRadius);
        new CustomeRvExposeUtil().setRecyclerItemExposeListener(this, new CustomeRvExposeUtil.OnItemExposeListener() {
            public final void onItemViewVisible(int i) {
                RvBanner.this.m15126a(i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15126a(int i) {
        if (this.mOnBannerClickListener != null) {
            if (this.f20676h) {
                i %= this.f20674f.size();
            }
            this.mOnBannerClickListener.onBannerPageSelected(i);
        }
    }

    /* renamed from: a */
    private void m15125a() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.f20672d.getHeight();
        layoutParams.width = -1;
        setLayoutParams(layoutParams);
        LogUtil.m14765i("RvBanner", "banner rv width =" + layoutParams.width + ",height = " + layoutParams.height);
    }

    /* renamed from: b */
    private void m15130b() {
        stop();
        this.mOnBannerClickListener = null;
    }

    private class CardSnapHelper extends PagerSnapHelper {
        private CardSnapHelper() {
        }

        public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
            int viewAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
            int size = RvBanner.this.f20676h ? viewAdapterPosition % RvBanner.this.f20674f.size() : viewAdapterPosition;
            if (!(viewAdapterPosition == RvBanner.this.f20673e || size >= RvBanner.this.f20674f.size() || RvBanner.this.f20674f.get(size) == null)) {
                int unused = RvBanner.this.f20673e = viewAdapterPosition;
            }
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
    }

    private class RecyclerViewCornerRadius extends RecyclerView.ItemDecoration {
        public static final String TAG = "RecyclerViewCornerRadius";
        /* access modifiers changed from: private */
        public int mBottomLeftRadius = 0;
        /* access modifiers changed from: private */
        public int mBottomRightRadius = 0;
        /* access modifiers changed from: private */
        public Path mPath;
        /* access modifiers changed from: private */
        public RectF mRectF;
        /* access modifiers changed from: private */
        public int mTopLeftRadius = 0;
        /* access modifiers changed from: private */
        public int mTopRightRadius = 0;

        RecyclerViewCornerRadius(final RecyclerView recyclerView) {
            recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(RvBanner.this) {
                public void onGlobalLayout() {
                    RectF unused = RecyclerViewCornerRadius.this.mRectF = new RectF(0.0f, 0.0f, (float) recyclerView.getMeasuredWidth(), (float) recyclerView.getMeasuredHeight());
                    Path unused2 = RecyclerViewCornerRadius.this.mPath = new Path();
                    RecyclerViewCornerRadius.this.mPath.reset();
                    RecyclerViewCornerRadius.this.mPath.addRoundRect(RecyclerViewCornerRadius.this.mRectF, new float[]{(float) RecyclerViewCornerRadius.this.mTopLeftRadius, (float) RecyclerViewCornerRadius.this.mTopLeftRadius, (float) RecyclerViewCornerRadius.this.mTopRightRadius, (float) RecyclerViewCornerRadius.this.mTopRightRadius, (float) RecyclerViewCornerRadius.this.mBottomLeftRadius, (float) RecyclerViewCornerRadius.this.mBottomLeftRadius, (float) RecyclerViewCornerRadius.this.mBottomRightRadius, (float) RecyclerViewCornerRadius.this.mBottomRightRadius}, Path.Direction.CCW);
                    recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            RectF rectF = this.mRectF;
            if (rectF != null) {
                canvas.clipRect(rectF);
                canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                if (Build.VERSION.SDK_INT >= 28) {
                    canvas.clipPath(this.mPath);
                } else {
                    canvas.clipPath(this.mPath, Region.Op.REPLACE);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setCornerRadius(int i) {
            this.mTopLeftRadius = i;
            this.mTopRightRadius = i;
            this.mBottomLeftRadius = i;
            this.mBottomRightRadius = i;
        }
    }
}
