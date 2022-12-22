package com.didi.component.drainage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.taxis99.R;
import java.util.List;

public class DrainageGuideView extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: g */
    private static final String f12873g = "show_guide_on_view_";

    /* renamed from: A */
    private int f12874A;

    /* renamed from: B */
    private int f12875B;

    /* renamed from: C */
    private Rect f12876C = new Rect();

    /* renamed from: a */
    boolean f12877a = true;

    /* renamed from: b */
    boolean f12878b = true;

    /* renamed from: c */
    private final String f12879c = getClass().getSimpleName();

    /* renamed from: d */
    private Context f12880d;

    /* renamed from: e */
    private List<View> f12881e;

    /* renamed from: f */
    private boolean f12882f = true;

    /* renamed from: h */
    private int f12883h;

    /* renamed from: i */
    private View f12884i;

    /* renamed from: j */
    private View f12885j;

    /* renamed from: k */
    private Paint f12886k;

    /* renamed from: l */
    private Paint f12887l;

    /* renamed from: m */
    private boolean f12888m;

    /* renamed from: n */
    private int[] f12889n;

    /* renamed from: o */
    private PorterDuffXfermode f12890o;

    /* renamed from: p */
    private Bitmap f12891p;

    /* renamed from: q */
    private int f12892q;

    /* renamed from: r */
    private Canvas f12893r;

    /* renamed from: s */
    private Direction f12894s;

    /* renamed from: t */
    private MyShape f12895t;

    /* renamed from: u */
    private int[] f12896u;

    /* renamed from: v */
    private boolean f12897v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public OnClickCallback f12898w;

    /* renamed from: x */
    private DrainageClickListener f12899x;

    /* renamed from: y */
    private boolean f12900y = false;

    /* renamed from: z */
    private int f12901z;

    public enum Direction {
        CENTER_TIPS_BOTTOM,
        CENTER_TIPS_TOP,
        BOTTOM_ARROW,
        TOP_ARROW,
        ANIMATION_TIPS_BOTTOM,
        ANIMATION_TIPS_TOP
    }

    public interface DrainageClickListener {
        void onClickDrainage(boolean z);
    }

    public enum MyShape {
        RECTANGULAR,
        CIRCLE
    }

    public interface OnClickCallback {
        void onClickedGuideView();
    }

    public void restoreState() {
        SystemUtils.log(2, this.f12879c, "restoreState", (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 100);
        this.f12883h = 0;
        this.f12886k = null;
        this.f12887l = null;
        this.f12888m = false;
        this.f12889n = null;
        this.f12890o = null;
        this.f12891p = null;
        this.f12877a = true;
        this.f12893r = null;
    }

    public int[] getLocation() {
        return this.f12896u;
    }

    public void setLocation(int[] iArr) {
        this.f12896u = iArr;
    }

    public DrainageGuideView(Context context) {
        super(context);
        this.f12880d = context;
        m8769a();
    }

    public void setDirection(Direction direction) {
        this.f12894s = direction;
    }

    public void setShape(MyShape myShape) {
        this.f12895t = myShape;
    }

    public void setCustomGuideView(View view) {
        this.f12885j = view;
        if (!this.f12882f) {
            restoreState();
        }
    }

    public void setBgColor(int i) {
        this.f12892q = i;
    }

    public View getTargetView() {
        return this.f12884i;
    }

    public void setTargetView(View view) {
        this.f12884i = view;
    }

    /* renamed from: a */
    private void m8769a() {
        this.f12901z = UiUtils.dip2px(getContext(), 10.0f);
        this.f12874A = UiUtils.dip2px(getContext(), 16.0f);
        this.f12875B = UiUtils.dip2px(getContext(), 20.0f);
    }

    public int[] getCenter() {
        return this.f12889n;
    }

    public void setCenter(int[] iArr) {
        this.f12889n = iArr;
    }

    public void hide() {
        SystemUtils.log(2, this.f12879c, LoginOmegaUtil.ACTIONID_HIDE, (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 177);
        if (this.f12884i != null) {
            removeAllViews();
            this.f12884i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ((FrameLayout) ((Activity) this.f12880d).getWindow().getDecorView()).removeView(this);
            restoreState();
            this.f12900y = false;
        }
    }

    public void show() {
        SystemUtils.log(2, this.f12879c, "show", (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 190);
        if (!this.f12900y) {
            View view = this.f12884i;
            if (view != null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            }
            View view2 = this.f12884i;
            if (view2 != null && view2.getLocalVisibleRect(new Rect())) {
                setBackgroundResource(R.color.transparent);
                ((FrameLayout) ((Activity) this.f12880d).getWindow().getDecorView()).addView(this);
                this.f12900y = true;
                this.f12882f = false;
            }
        }
    }

    public void setVisiblePaddings(Rect rect) {
        this.f12876C = rect;
    }

    public int getTargetViewpadding() {
        return this.f12874A;
    }

    public void setTargetViewpadding(int i) {
        this.f12874A = i;
    }

    public int getBgmargin() {
        return this.f12901z;
    }

    public void setBgmargin(int i) {
        this.f12901z = i;
    }

    public int getBgradius() {
        return this.f12875B;
    }

    public void setBgradius(int i) {
        this.f12875B = i;
    }

    /* renamed from: b */
    private void m8771b() {
        SystemUtils.log(2, this.f12879c, "createGuideView", (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 265);
        if (this.f12885j != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.f12894s != null) {
                UiUtils.dip2px(getContext(), 7.0f);
                int i = C53932.f12902x1fa8456[this.f12894s.ordinal()];
                if (i == 1 || i == 2) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    ((DrainageGuideBgViewTips) this.f12885j).setVisiblePaddings(this.f12876C);
                    ((DrainageGuideBgViewTips) this.f12885j).setMargin(new Rect(UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f)));
                    ((DrainageGuideBgViewTips) this.f12885j).setHightLightPos(new RectF((float) (this.f12896u[0] + this.f12884i.getPaddingLeft()), (float) (this.f12896u[1] + this.f12884i.getPaddingTop()), (float) ((this.f12896u[0] + this.f12884i.getWidth()) - this.f12884i.getPaddingRight()), (float) ((this.f12896u[1] + this.f12884i.getHeight()) - this.f12884i.getPaddingBottom())));
                }
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (this.f12885j.getParent() != null && (this.f12885j.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f12885j.getParent()).removeView(this.f12885j);
            }
            addView(this.f12885j, layoutParams);
        }
    }

    private int[] getTargetViewSize() {
        int[] iArr = {-1, -1};
        if (this.f12888m) {
            iArr[0] = this.f12884i.getWidth();
            iArr[1] = this.f12884i.getHeight();
        }
        return iArr;
    }

    private int getTargetViewRadius() {
        if (!this.f12888m) {
            return -1;
        }
        int[] targetViewSize = getTargetViewSize();
        int i = targetViewSize[0];
        int i2 = targetViewSize[1];
        return (int) (Math.sqrt((double) ((i * i) + (i2 * i2))) / 2.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        SystemUtils.log(2, this.f12879c, "onDraw", (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 339);
        if (this.f12888m && this.f12884i != null) {
            m8770a(canvas);
        }
    }

    /* renamed from: a */
    private void m8770a(Canvas canvas) {
        SystemUtils.log(2, this.f12879c, "drawBackground", (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 354);
        this.f12877a = false;
        this.f12891p = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        this.f12893r = new Canvas(this.f12891p);
        Paint paint = new Paint();
        int i = this.f12892q;
        if (i != 0) {
            paint.setColor(i);
        }
        Canvas canvas2 = this.f12893r;
        canvas2.drawRect(0.0f, 0.0f, (float) canvas2.getWidth(), (float) this.f12893r.getHeight(), paint);
        if (this.f12886k == null) {
            this.f12886k = new Paint();
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.f12890o = porterDuffXfermode;
        this.f12886k.setXfermode(porterDuffXfermode);
        this.f12886k.setAntiAlias(true);
        if (this.f12895t != null) {
            RectF rectF = new RectF();
            int i2 = C53932.$SwitchMap$com$didi$component$drainage$DrainageGuideView$MyShape[this.f12895t.ordinal()];
            if (i2 == 1) {
                rectF.left = (float) (this.f12896u[0] + this.f12876C.left + this.f12884i.getPaddingLeft());
                rectF.top = (float) (this.f12896u[1] + this.f12884i.getPaddingTop() + this.f12876C.top);
                rectF.right = (float) (((this.f12896u[0] + this.f12884i.getWidth()) - this.f12876C.right) - this.f12884i.getPaddingRight());
                rectF.bottom = (float) (((this.f12896u[1] + this.f12884i.getHeight()) - this.f12884i.getPaddingBottom()) - this.f12876C.bottom);
                this.f12886k.setColor(0);
                Canvas canvas3 = this.f12893r;
                int i3 = this.f12875B;
                canvas3.drawRoundRect(rectF, (float) i3, (float) i3, this.f12886k);
            } else if (i2 == 2) {
                this.f12886k.setColor(0);
                Canvas canvas4 = this.f12893r;
                int[] iArr = this.f12889n;
                canvas4.drawCircle((float) iArr[0], (float) iArr[1], (float) (this.f12884i.getWidth() / 2), this.f12886k);
            }
        } else {
            Canvas canvas5 = this.f12893r;
            int[] iArr2 = this.f12889n;
            canvas5.drawCircle((float) iArr2[0], (float) iArr2[1], (float) (this.f12884i.getWidth() / 2), this.f12886k);
        }
        canvas.drawBitmap(this.f12891p, 0.0f, 0.0f, paint);
        this.f12891p.recycle();
    }

    /* renamed from: com.didi.component.drainage.DrainageGuideView$2 */
    static /* synthetic */ class C53932 {

        /* renamed from: $SwitchMap$com$didi$component$drainage$DrainageGuideView$Direction */
        static final /* synthetic */ int[] f12902x1fa8456;
        static final /* synthetic */ int[] $SwitchMap$com$didi$component$drainage$DrainageGuideView$MyShape;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                com.didi.component.drainage.DrainageGuideView$MyShape[] r0 = com.didi.component.drainage.DrainageGuideView.MyShape.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$component$drainage$DrainageGuideView$MyShape = r0
                r1 = 1
                com.didi.component.drainage.DrainageGuideView$MyShape r2 = com.didi.component.drainage.DrainageGuideView.MyShape.RECTANGULAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$didi$component$drainage$DrainageGuideView$MyShape     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.component.drainage.DrainageGuideView$MyShape r3 = com.didi.component.drainage.DrainageGuideView.MyShape.CIRCLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.didi.component.drainage.DrainageGuideView$Direction[] r2 = com.didi.component.drainage.DrainageGuideView.Direction.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f12902x1fa8456 = r2
                com.didi.component.drainage.DrainageGuideView$Direction r3 = com.didi.component.drainage.DrainageGuideView.Direction.ANIMATION_TIPS_BOTTOM     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f12902x1fa8456     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.didi.component.drainage.DrainageGuideView$Direction r2 = com.didi.component.drainage.DrainageGuideView.Direction.ANIMATION_TIPS_TOP     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.drainage.DrainageGuideView.C53932.<clinit>():void");
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f12878b && motionEvent.getAction() == 0) {
            RectF rectF = new RectF();
            rectF.left = (float) (this.f12896u[0] + this.f12876C.left + this.f12884i.getPaddingLeft());
            rectF.top = (float) (this.f12896u[1] + this.f12884i.getPaddingTop() + this.f12876C.top);
            rectF.right = (float) (((this.f12896u[0] + this.f12884i.getWidth()) - this.f12876C.right) - this.f12884i.getPaddingRight());
            rectF.bottom = (float) (((this.f12896u[1] + this.f12884i.getHeight()) - this.f12884i.getPaddingBottom()) - this.f12876C.bottom);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x <= rectF.left || x >= rectF.right || y <= rectF.top || y >= rectF.bottom) {
                DrainageClickListener drainageClickListener = this.f12899x;
                if (drainageClickListener != null) {
                    drainageClickListener.onClickDrainage(false);
                }
            } else {
                hide();
                DrainageClickListener drainageClickListener2 = this.f12899x;
                if (drainageClickListener2 != null) {
                    drainageClickListener2.onClickDrainage(true);
                }
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnTouchOutListener(DrainageClickListener drainageClickListener) {
        this.f12899x = drainageClickListener;
    }

    public void setOnClickExit(boolean z) {
        this.f12897v = z;
    }

    public void setOnclickListener(OnClickCallback onClickCallback) {
        this.f12898w = onClickCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8773c() {
        final boolean z = this.f12897v;
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DrainageGuideView.this.f12898w != null) {
                    DrainageGuideView.this.f12898w.onClickedGuideView();
                }
                if (z) {
                    DrainageGuideView.this.hide();
                }
            }
        });
    }

    public void onGlobalLayout() {
        if (!this.f12888m) {
            if (this.f12884i.getHeight() > 0 || this.f12884i.getWidth() > 0) {
                this.f12888m = true;
            }
            if (this.f12889n == null) {
                int[] iArr = new int[2];
                this.f12896u = iArr;
                this.f12884i.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                this.f12889n = iArr2;
                iArr2[0] = this.f12896u[0] + (this.f12884i.getWidth() / 2);
                this.f12889n[1] = this.f12896u[1] + (this.f12884i.getHeight() / 2);
            }
            if (this.f12883h == 0) {
                this.f12883h = getTargetViewRadius();
            }
            m8771b();
        }
    }

    public static class Builder {
        static DrainageGuideView guiderView;
        static Builder instance = new Builder();
        Context mContext;

        private Builder() {
        }

        public Builder(Context context) {
            this.mContext = context;
        }

        public static Builder newInstance(Context context) {
            guiderView = new DrainageGuideView(context);
            return instance;
        }

        public Builder setTargetView(View view) {
            guiderView.setTargetView(view);
            return instance;
        }

        public Builder setBgColor(int i) {
            guiderView.setBgColor(i);
            return instance;
        }

        public Builder setBgRadius(int i) {
            guiderView.setBgradius(i);
            return instance;
        }

        public Builder setBgMargin(int i) {
            guiderView.setBgmargin(i);
            return instance;
        }

        public Builder setTargetViewpadding(int i) {
            guiderView.setTargetViewpadding(i);
            return instance;
        }

        public Builder setDirction(Direction direction) {
            guiderView.setDirection(direction);
            return instance;
        }

        public Builder setShape(MyShape myShape) {
            guiderView.setShape(myShape);
            return instance;
        }

        public Builder setCustomGuideView(View view) {
            guiderView.setCustomGuideView(view);
            return instance;
        }

        public DrainageGuideView build() {
            guiderView.m8773c();
            return guiderView;
        }

        public Builder setOnclickExit(boolean z) {
            guiderView.setOnClickExit(z);
            return instance;
        }

        public Builder setOnclickListener(OnClickCallback onClickCallback) {
            guiderView.setOnclickListener(onClickCallback);
            return instance;
        }
    }
}
