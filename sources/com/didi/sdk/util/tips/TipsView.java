package com.didi.sdk.util.tips;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class TipsView extends RelativeLayout {

    /* renamed from: A */
    private PorterDuffXfermode f37744A;

    /* renamed from: B */
    private View f37745B;

    /* renamed from: a */
    boolean f37746a;

    /* renamed from: b */
    int f37747b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Point f37748c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f37749d = 0;

    /* renamed from: e */
    private String f37750e;

    /* renamed from: f */
    private String f37751f;

    /* renamed from: g */
    private String f37752g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f37753h;

    /* renamed from: i */
    private boolean f37754i;

    /* renamed from: j */
    private int f37755j = 0;

    /* renamed from: k */
    private int f37756k = 0;

    /* renamed from: l */
    private int f37757l = 10;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View f37758m;

    /* renamed from: n */
    private int f37759n;

    /* renamed from: o */
    private int f37760o;

    /* renamed from: p */
    private int f37761p;

    /* renamed from: q */
    private int f37762q;

    /* renamed from: r */
    private int f37763r;

    /* renamed from: s */
    private int f37764s;

    /* renamed from: t */
    private StoreUtils f37765t;

    /* renamed from: u */
    private Bitmap f37766u;

    /* renamed from: v */
    private Canvas f37767v;

    /* renamed from: w */
    private Paint f37768w;

    /* renamed from: x */
    private Paint f37769x;

    /* renamed from: y */
    private Paint f37770y;

    /* renamed from: z */
    private Paint f37771z;

    public TipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26752a();
    }

    public TipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26752a();
    }

    public TipsView(Context context) {
        super(context);
        m26752a();
    }

    /* renamed from: a */
    static Point m26749a(View view) {
        Point point = new Point();
        point.x = view.getLeft() + (view.getWidth() / 2);
        point.y = view.getTop() + (view.getHeight() / 2);
        return point;
    }

    public void setShowView(View view) {
        this.f37745B = view;
    }

    /* renamed from: a */
    private void m26752a() {
        setVisibility(8);
        setBackgroundColor(0);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f37765t = new StoreUtils(getContext());
        this.f37768w = new Paint();
        this.f37769x = new Paint();
        this.f37770y = new Paint();
        this.f37771z = new Paint();
        this.f37744A = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f37759n = i;
        this.f37760o = i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f37766u == null) {
            this.f37766u = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
            this.f37767v = new Canvas(this.f37766u);
        }
        this.f37767v.drawColor(Color.parseColor("#40000000"));
        int i = this.f37763r;
        if (i != 0) {
            this.f37767v.drawColor(i);
        } else {
            this.f37767v.drawColor(Color.parseColor("#40000000"));
        }
        this.f37768w.setColor(Color.parseColor("#00000000"));
        Canvas canvas2 = this.f37767v;
        canvas2.drawRect(0.0f, 0.0f, (float) canvas2.getWidth(), (float) this.f37767v.getHeight(), this.f37768w);
        this.f37771z.setColor(getResources().getColor(17170445));
        this.f37771z.setXfermode(this.f37744A);
        m26753b();
        canvas.drawBitmap(this.f37766u, 0.0f, 0.0f, this.f37769x);
    }

    /* renamed from: b */
    private void m26753b() {
        View view = this.f37758m;
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            RectF rectF = new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + this.f37758m.getWidth()), (float) (iArr[1] + this.f37758m.getHeight()));
            Canvas canvas = this.f37767v;
            int i = this.f37757l;
            canvas.drawRoundRect(rectF, (float) i, (float) i, this.f37771z);
        }
    }

    public void show(final Activity activity) {
        if (!isDisplayOneTime() || !this.f37765t.mo97123a(getDisplayOneTimeID())) {
            if (isDisplayOneTime()) {
                this.f37765t.mo97124b(getDisplayOneTimeID());
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ((ViewGroup) activity.getWindow().getDecorView()).addView(TipsView.this);
                    TipsView.this.setVisibility(0);
                    TipsView.this.startAnimation(AnimationUtils.loadAnimation(TipsView.this.getContext(), R.anim.fade_in));
                    TipsView.this.f37758m.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            if (!TipsView.this.f37746a) {
                                if (TipsView.this.f37758m.getHeight() > 0 && TipsView.this.f37758m.getWidth() > 0) {
                                    TipsView.this.f37746a = true;
                                }
                                if (!TipsView.this.f37753h) {
                                    int[] iArr = new int[2];
                                    TipsView.this.f37758m.getLocationInWindow(iArr);
                                    Point unused = TipsView.this.f37748c = new Point(iArr[0] + (TipsView.this.f37758m.getWidth() / 2), iArr[1] + (TipsView.this.f37758m.getHeight() / 2));
                                    int unused2 = TipsView.this.f37749d = TipsView.this.f37758m.getWidth() / 2;
                                } else {
                                    int[] iArr2 = new int[2];
                                    TipsView.this.f37758m.getLocationInWindow(iArr2);
                                    Point unused3 = TipsView.this.f37748c = new Point(iArr2[0] + TipsView.this.f37748c.x, iArr2[1] + TipsView.this.f37748c.y);
                                }
                                TipsView.this.invalidate();
                                TipsView.this.m26756c();
                            }
                        }
                    });
                }
            }, (long) getDelay());
            return;
        }
        setVisibility(8);
        ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).removeView(this);
    }

    private void getStatusBarHeight() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            this.f37747b = getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m26756c() {
        getStatusBarHeight();
        removeAllViews();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f37747b;
        View view = this.f37745B;
        if (view != null) {
            view.setLayoutParams(layoutParams);
            addView(this.f37745B);
        }
    }

    public String getButtonText() {
        String str = this.f37752g;
        return (str == null || str.equals("")) ? "Got it" : this.f37752g;
    }

    public void setButtonText(String str) {
        this.f37752g = str;
    }

    public void setTarget(View view) {
        this.f37758m = view;
    }

    public void setTarget(View view, int i, int i2, int i3) {
        this.f37753h = true;
        this.f37758m = view;
        this.f37748c = new Point(i, i2);
        this.f37749d = i3;
    }

    public String getTitle() {
        return this.f37750e;
    }

    public void setTitle(String str) {
        this.f37750e = str;
    }

    public String getDescription() {
        return this.f37751f;
    }

    public void setDescription(String str) {
        this.f37751f = str;
    }

    public boolean isDisplayOneTime() {
        return this.f37754i;
    }

    public void setDisplayOneTime(boolean z) {
        this.f37754i = z;
    }

    public int getDelay() {
        return this.f37756k;
    }

    public void setDelay(int i) {
        this.f37756k = i;
    }

    public int getDisplayOneTimeID() {
        return this.f37755j;
    }

    public void setDisplayOneTimeID(int i) {
        this.f37755j = i;
    }

    public int getTitle_color() {
        return this.f37761p;
    }

    public void setTitle_color(int i) {
        this.f37761p = i;
    }

    public int getDescription_color() {
        return this.f37762q;
    }

    public void setDescription_color(int i) {
        this.f37762q = i;
    }

    public int getBackground_color() {
        return this.f37763r;
    }

    public void setBackground_color(int i) {
        this.f37763r = i;
    }

    public int getCircleColor() {
        return this.f37764s;
    }

    public void setCircleColor(int i) {
        this.f37764s = i;
    }

    public void cancel() {
        ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).removeView(this);
        Bitmap bitmap = this.f37766u;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f37766u.recycle();
        }
    }
}
