package com.didi.soda.customer.binder.banner;

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
import com.didi.nova.assembly.p127ui.banner.OnBannerClickListener;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomeRvExposeUtil;
import com.didi.soda.customer.widget.scroll.SlowLinearLayoutManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class RvBanner extends RecyclerView {
    public static final long DEFAULT_AUTO_PLAY_DELAY = 4100;
    public static final String TAG = "RvBanner";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Runnable f40387a;

    /* renamed from: b */
    private FitType f40388b;

    /* renamed from: c */
    private int f40389c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RvBannerAdapter f40390d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f40391e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<String> f40392f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f40393g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f40394h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f40395i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f40396j;
    public OnBannerClickListener mOnBannerClickListener;

    public RvBanner(Context context) {
        this(context, (AttributeSet) null);
    }

    public RvBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RvBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f40387a = new Runnable() {
            public void run() {
                if (RvBanner.this.f40393g > 1) {
                    RvBanner.this.smoothScrollToPosition((RvBanner.this.f40391e + 1) % RvBanner.this.f40390d.getItemCount());
                }
                if (RvBanner.this.f40394h) {
                    RvBanner.this.f40396j.postDelayed(RvBanner.this.f40387a, RvBanner.this.f40395i);
                }
            }
        };
        this.f40391e = -1;
        this.f40392f = new ArrayList();
        this.f40394h = false;
        this.f40395i = 4100;
        this.f40396j = new Handler(Looper.getMainLooper());
        m28645a(context, attributeSet);
        m28644a(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f40394h) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                start();
            } else if (action == 0) {
                stop();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setIsAutoPlay(boolean z) {
        this.f40394h = z;
    }

    public void setBannerClickListener(OnBannerClickListener onBannerClickListener) {
        this.mOnBannerClickListener = onBannerClickListener;
    }

    public void setDatas(Context context, float f, List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f40392f.clear();
            this.f40392f.addAll(list);
            this.f40393g = list.size();
            RvBannerAdapter rvBannerAdapter = new RvBannerAdapter(this, context, f, this.f40392f);
            this.f40390d = rvBannerAdapter;
            rvBannerAdapter.f40398a = this.f40389c;
            this.f40390d.f40399b = this.f40388b;
            this.f40390d.f40400c = this.f40394h;
            setAdapter(this.f40390d);
            m28642a();
            if (getOnFlingListener() == null) {
                new CardSnapHelper().attachToRecyclerView(this);
            }
            if (this.f40394h) {
                this.f40391e = this.f40392f.size() * 1000;
                getLayoutManager().scrollToPosition(this.f40391e);
            } else {
                this.f40391e = 0;
            }
            start();
        }
    }

    public void start() {
        this.f40396j.removeCallbacks(this.f40387a);
        if (this.f40394h) {
            this.f40396j.postDelayed(this.f40387a, this.f40395i);
        }
    }

    public void stop() {
        this.f40396j.removeCallbacks(this.f40387a);
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

    /* renamed from: a */
    private void m28645a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RvBanner);
        this.f40394h = obtainStyledAttributes.getBoolean(0, false);
        this.f40388b = FitType.values()[obtainStyledAttributes.getInt(6, 0)];
        this.f40389c = obtainStyledAttributes.getResourceId(3, 0);
        obtainStyledAttributes.recycle();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            LogUtil.m29104i("RvBanner", "initAttrs banner rv width =" + layoutParams.width + ",height = " + layoutParams.width);
        }
    }

    /* renamed from: a */
    private void m28644a(Context context) {
        setLayoutManager(new SlowLinearLayoutManager(context, 0, false));
        RecyclerViewCornerRadius recyclerViewCornerRadius = new RecyclerViewCornerRadius(this);
        recyclerViewCornerRadius.setCornerRadius(context.getResources().getDimensionPixelOffset(R.dimen.customer_40px));
        addItemDecoration(recyclerViewCornerRadius);
        new CustomeRvExposeUtil().setRecyclerItemExposeListener(this, new CustomeRvExposeUtil.OnItemExposeListener() {
            public final void onItemViewVisible(int i) {
                RvBanner.this.m28643a(i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28643a(int i) {
        if (this.mOnBannerClickListener != null) {
            if (this.f40394h) {
                i %= this.f40392f.size();
            }
            this.mOnBannerClickListener.onBannerPageSelected(i);
        }
    }

    /* renamed from: a */
    private void m28642a() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.f40390d.getHeight();
        layoutParams.width = -1;
        setLayoutParams(layoutParams);
        LogUtil.m29104i("RvBanner", "banner rv width =" + layoutParams.width + ",height = " + layoutParams.height);
    }

    /* renamed from: b */
    private void m28647b() {
        stop();
        this.mOnBannerClickListener = null;
    }

    private class CardSnapHelper extends PagerSnapHelper {
        private CardSnapHelper() {
        }

        public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
            int viewAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
            int size = RvBanner.this.f40394h ? viewAdapterPosition % RvBanner.this.f40392f.size() : viewAdapterPosition;
            if (!(viewAdapterPosition == RvBanner.this.f40391e || size >= RvBanner.this.f40392f.size() || RvBanner.this.f40392f.get(size) == null)) {
                int unused = RvBanner.this.f40391e = viewAdapterPosition;
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
