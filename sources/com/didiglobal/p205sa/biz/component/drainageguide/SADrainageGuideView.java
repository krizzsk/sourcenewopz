package com.didiglobal.p205sa.biz.component.drainageguide;

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
import com.didiglobal.p205sa.biz.component.guide.view.GuideBgArrow;
import com.didiglobal.p205sa.biz.component.guide.view.GuideBgViewTips;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView */
public class SADrainageGuideView extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: g */
    private static final String f50891g = "show_guide_on_view_";

    /* renamed from: A */
    private int f50892A;

    /* renamed from: B */
    private int f50893B;

    /* renamed from: C */
    private Rect f50894C = new Rect();

    /* renamed from: a */
    boolean f50895a = true;

    /* renamed from: b */
    boolean f50896b = true;

    /* renamed from: c */
    private final String f50897c = getClass().getSimpleName();

    /* renamed from: d */
    private Context f50898d;

    /* renamed from: e */
    private List<View> f50899e;

    /* renamed from: f */
    private boolean f50900f = true;

    /* renamed from: h */
    private int f50901h;

    /* renamed from: i */
    private View f50902i;

    /* renamed from: j */
    private View f50903j;

    /* renamed from: k */
    private Paint f50904k;

    /* renamed from: l */
    private Paint f50905l;

    /* renamed from: m */
    private boolean f50906m;

    /* renamed from: n */
    private int[] f50907n;

    /* renamed from: o */
    private PorterDuffXfermode f50908o;

    /* renamed from: p */
    private Bitmap f50909p;

    /* renamed from: q */
    private int f50910q;

    /* renamed from: r */
    private Canvas f50911r;

    /* renamed from: s */
    private Direction f50912s;

    /* renamed from: t */
    private MyShape f50913t;

    /* renamed from: u */
    private int[] f50914u;

    /* renamed from: v */
    private boolean f50915v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public OnClickCallback f50916w;

    /* renamed from: x */
    private DrainageClickListener f50917x;

    /* renamed from: y */
    private boolean f50918y = false;

    /* renamed from: z */
    private int f50919z;

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction */
    public enum Direction {
        CENTER_TIPS_BOTTOM,
        CENTER_TIPS_TOP,
        BOTTOM_ARROW,
        TOP_ARROW,
        ANIMATION_TIPS_BOTTOM,
        ANIMATION_TIPS_TOP
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$DrainageClickListener */
    public interface DrainageClickListener {
        void onClickDrainage(boolean z);
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$MyShape */
    public enum MyShape {
        RECTANGULAR
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$OnClickCallback */
    public interface OnClickCallback {
        void onClickedGuideView();
    }

    public void restoreState() {
        SystemUtils.log(2, this.f50897c, "restoreState", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 102);
        this.f50901h = 0;
        this.f50904k = null;
        this.f50905l = null;
        this.f50906m = false;
        this.f50907n = null;
        this.f50908o = null;
        this.f50909p = null;
        this.f50895a = true;
        this.f50911r = null;
    }

    public int[] getLocation() {
        return this.f50914u;
    }

    public void setLocation(int[] iArr) {
        this.f50914u = iArr;
    }

    public SADrainageGuideView(Context context) {
        super(context);
        this.f50898d = context;
        m36500a();
    }

    public void setDirection(Direction direction) {
        this.f50912s = direction;
    }

    public void setShape(MyShape myShape) {
        this.f50913t = myShape;
    }

    public void setCustomGuideView(View view) {
        this.f50903j = view;
        if (!this.f50900f) {
            restoreState();
        }
    }

    public void setBgColor(int i) {
        this.f50910q = i;
    }

    public View getTargetView() {
        return this.f50902i;
    }

    public void setTargetView(View view) {
        this.f50902i = view;
    }

    /* renamed from: a */
    private void m36500a() {
        this.f50919z = (int) getContext().getResources().getDimension(R.dimen.view_padding_by_bg);
        this.f50892A = (int) getContext().getResources().getDimension(R.dimen.view_padding);
        this.f50893B = (int) getContext().getResources().getDimension(R.dimen.view_radius);
    }

    public int[] getCenter() {
        return this.f50907n;
    }

    public void setCenter(int[] iArr) {
        this.f50907n = iArr;
    }

    public void hide() {
        SystemUtils.log(2, this.f50897c, LoginOmegaUtil.ACTIONID_HIDE, (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 179);
        if (this.f50902i != null) {
            removeAllViews();
            this.f50902i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ((FrameLayout) ((Activity) this.f50898d).getWindow().getDecorView()).removeView(this);
            restoreState();
            this.f50918y = false;
        }
    }

    public void show() {
        SystemUtils.log(2, this.f50897c, "show", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 192);
        if (!this.f50918y) {
            View view = this.f50902i;
            if (view != null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            }
            View view2 = this.f50902i;
            if (view2 != null && view2.getLocalVisibleRect(new Rect())) {
                setBackgroundResource(R.color.transparent);
                ((FrameLayout) ((Activity) this.f50898d).getWindow().getDecorView()).addView(this);
                this.f50918y = true;
                this.f50900f = false;
            }
        }
    }

    public void setVisiblePaddings(Rect rect) {
        this.f50894C = rect;
    }

    public int getTargetViewpadding() {
        return this.f50892A;
    }

    public void setTargetViewpadding(int i) {
        this.f50892A = i;
    }

    public int getBgmargin() {
        return this.f50919z;
    }

    public void setBgmargin(int i) {
        this.f50919z = i;
    }

    public int getBgradius() {
        return this.f50893B;
    }

    public void setBgradius(int i) {
        this.f50893B = i;
    }

    /* renamed from: b */
    private void m36502b() {
        SystemUtils.log(2, this.f50897c, "createGuideView", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 267);
        if (this.f50903j != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.f50912s != null) {
                int dip2px = UiUtils.dip2px(getContext(), 7.0f);
                switch (C171162.f50920x5cdeb3fe[this.f50912s.ordinal()]) {
                    case 1:
                        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams.setMargins(this.f50892A, ((this.f50914u[1] + this.f50902i.getHeight()) + dip2px) - this.f50902i.getPaddingBottom(), this.f50892A, 0);
                        View view = this.f50903j;
                        if (view instanceof GuideBgArrow) {
                            ((GuideBgArrow) view).setArrowPos(((this.f50914u[0] + this.f50902i.getPaddingLeft()) + (((this.f50902i.getWidth() - this.f50902i.getPaddingLeft()) - this.f50902i.getPaddingRight()) / 2)) - this.f50892A);
                            break;
                        }
                        break;
                    case 2:
                        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams.addRule(12);
                        int i = this.f50892A;
                        layoutParams.setMargins(i, 0, i, ((getHeight() - this.f50914u[1]) - this.f50902i.getPaddingTop()) + dip2px);
                        View view2 = this.f50903j;
                        if (view2 instanceof GuideBgArrow) {
                            ((GuideBgArrow) view2).setArrowPos(((this.f50914u[0] + this.f50902i.getPaddingLeft()) + (((this.f50902i.getWidth() - this.f50902i.getPaddingLeft()) - this.f50902i.getPaddingRight()) / 2)) - this.f50892A);
                            break;
                        }
                        break;
                    case 3:
                        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        ((GuideBgViewTips) this.f50903j).setVisiblePaddings(this.f50894C);
                        int i2 = this.f50919z;
                        ((GuideBgViewTips) this.f50903j).setMargin(new Rect(i2, i2, i2, i2));
                        int[] iArr = this.f50914u;
                        ((GuideBgViewTips) this.f50903j).setHightLightPos(new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + this.f50902i.getWidth()), (float) (this.f50914u[1] + this.f50902i.getHeight())));
                        int i3 = this.f50892A;
                        int i4 = this.f50919z;
                        layoutParams.setMargins(i3 - i4, (this.f50914u[1] - i4) + this.f50894C.top, this.f50892A - this.f50919z, 0);
                        break;
                    case 4:
                        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams.addRule(12);
                        ((GuideBgViewTips) this.f50903j).setVisiblePaddings(this.f50894C);
                        int i5 = this.f50919z;
                        ((GuideBgViewTips) this.f50903j).setMargin(new Rect(i5, i5, i5, i5));
                        int[] iArr2 = this.f50914u;
                        ((GuideBgViewTips) this.f50903j).setHightLightPos(new RectF((float) iArr2[0], (float) iArr2[1], (float) (iArr2[0] + this.f50902i.getWidth()), (float) (this.f50914u[1] + this.f50902i.getHeight())));
                        int i6 = this.f50892A;
                        int i7 = this.f50919z;
                        layoutParams.setMargins(i6 - i7, 0, i6 - i7, (((getHeight() - this.f50914u[1]) - this.f50902i.getHeight()) + this.f50894C.bottom) - this.f50919z);
                        break;
                    case 5:
                    case 6:
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        ((SADrainageGuideBgViewTips) this.f50903j).setVisiblePaddings(this.f50894C);
                        ((SADrainageGuideBgViewTips) this.f50903j).setMargin(new Rect(UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f)));
                        ((SADrainageGuideBgViewTips) this.f50903j).setHightLightPos(new RectF((float) (this.f50914u[0] + this.f50902i.getPaddingLeft()), (float) (this.f50914u[1] + this.f50902i.getPaddingTop()), (float) ((this.f50914u[0] + this.f50902i.getWidth()) - this.f50902i.getPaddingRight()), (float) ((this.f50914u[1] + this.f50902i.getHeight()) - this.f50902i.getPaddingBottom())));
                        break;
                }
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (this.f50903j.getParent() != null && (this.f50903j.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f50903j.getParent()).removeView(this.f50903j);
            }
            addView(this.f50903j, layoutParams);
        }
    }

    private int[] getTargetViewSize() {
        int[] iArr = {-1, -1};
        if (this.f50906m) {
            iArr[0] = this.f50902i.getWidth();
            iArr[1] = this.f50902i.getHeight();
        }
        return iArr;
    }

    private int getTargetViewRadius() {
        if (!this.f50906m) {
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
        SystemUtils.log(2, this.f50897c, "onDraw", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 398);
        if (this.f50906m && this.f50902i != null) {
            m36501a(canvas);
        }
    }

    /* renamed from: a */
    private void m36501a(Canvas canvas) {
        SystemUtils.log(2, this.f50897c, "drawBackground", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 413);
        this.f50895a = false;
        this.f50909p = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        this.f50911r = new Canvas(this.f50909p);
        Paint paint = new Paint();
        int i = this.f50910q;
        if (i != 0) {
            paint.setColor(i);
        }
        Canvas canvas2 = this.f50911r;
        canvas2.drawRect(0.0f, 0.0f, (float) canvas2.getWidth(), (float) this.f50911r.getHeight(), paint);
        if (this.f50904k == null) {
            this.f50904k = new Paint();
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.f50908o = porterDuffXfermode;
        this.f50904k.setXfermode(porterDuffXfermode);
        this.f50904k.setAntiAlias(true);
        if (this.f50913t != null) {
            RectF rectF = new RectF();
            if (C171162.f50921xe3f1bd94[this.f50913t.ordinal()] == 1) {
                rectF.left = (float) (this.f50914u[0] + this.f50894C.left + this.f50902i.getPaddingLeft());
                rectF.top = (float) (this.f50914u[1] + this.f50902i.getPaddingTop() + this.f50894C.top);
                rectF.right = (float) (((this.f50914u[0] + this.f50902i.getWidth()) - this.f50894C.right) - this.f50902i.getPaddingRight());
                rectF.bottom = (float) (((this.f50914u[1] + this.f50902i.getHeight()) - this.f50902i.getPaddingBottom()) - this.f50894C.bottom);
                this.f50904k.setColor(0);
                Canvas canvas3 = this.f50911r;
                int i2 = this.f50893B;
                canvas3.drawRoundRect(rectF, (float) i2, (float) i2, this.f50904k);
            }
        } else {
            Canvas canvas4 = this.f50911r;
            int[] iArr = this.f50907n;
            canvas4.drawCircle((float) iArr[0], (float) iArr[1], (float) this.f50901h, this.f50904k);
        }
        canvas.drawBitmap(this.f50909p, 0.0f, 0.0f, paint);
        this.f50909p.recycle();
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$2 */
    static /* synthetic */ class C171162 {

        /* renamed from: $SwitchMap$com$didiglobal$sa$biz$component$drainageguide$SADrainageGuideView$Direction */
        static final /* synthetic */ int[] f50920x5cdeb3fe;

        /* renamed from: $SwitchMap$com$didiglobal$sa$biz$component$drainageguide$SADrainageGuideView$MyShape */
        static final /* synthetic */ int[] f50921xe3f1bd94;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0023 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
        static {
            /*
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$MyShape[] r0 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.MyShape.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50921xe3f1bd94 = r0
                r1 = 1
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$MyShape r2 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.MyShape.RECTANGULAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction[] r0 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50920x5cdeb3fe = r0
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r2 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.BOTTOM_ARROW     // Catch:{ NoSuchFieldError -> 0x0023 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0023 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = f50920x5cdeb3fe     // Catch:{ NoSuchFieldError -> 0x002e }
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r1 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.TOP_ARROW     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r0 = f50920x5cdeb3fe     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r1 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.CENTER_TIPS_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r0 = f50920x5cdeb3fe     // Catch:{ NoSuchFieldError -> 0x0044 }
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r1 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.CENTER_TIPS_TOP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r0 = f50920x5cdeb3fe     // Catch:{ NoSuchFieldError -> 0x004f }
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r1 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.ANIMATION_TIPS_BOTTOM     // Catch:{ NoSuchFieldError -> 0x004f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r0 = f50920x5cdeb3fe     // Catch:{ NoSuchFieldError -> 0x005a }
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r1 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.ANIMATION_TIPS_TOP     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.C171162.<clinit>():void");
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f50896b && motionEvent.getAction() == 0) {
            RectF rectF = new RectF();
            rectF.left = (float) (this.f50914u[0] + this.f50894C.left + this.f50902i.getPaddingLeft());
            rectF.top = (float) (this.f50914u[1] + this.f50902i.getPaddingTop() + this.f50894C.top);
            rectF.right = (float) (((this.f50914u[0] + this.f50902i.getWidth()) - this.f50894C.right) - this.f50902i.getPaddingRight());
            rectF.bottom = (float) (((this.f50914u[1] + this.f50902i.getHeight()) - this.f50902i.getPaddingBottom()) - this.f50894C.bottom);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x <= rectF.left || x >= rectF.right || y <= rectF.top || y >= rectF.bottom) {
                DrainageClickListener drainageClickListener = this.f50917x;
                if (drainageClickListener != null) {
                    drainageClickListener.onClickDrainage(false);
                }
            } else {
                hide();
                DrainageClickListener drainageClickListener2 = this.f50917x;
                if (drainageClickListener2 != null) {
                    drainageClickListener2.onClickDrainage(true);
                }
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnTouchOutListener(DrainageClickListener drainageClickListener) {
        this.f50917x = drainageClickListener;
    }

    public void setOnClickExit(boolean z) {
        this.f50915v = z;
    }

    public void setOnclickListener(OnClickCallback onClickCallback) {
        this.f50916w = onClickCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36504c() {
        final boolean z = this.f50915v;
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SADrainageGuideView.this.f50916w != null) {
                    SADrainageGuideView.this.f50916w.onClickedGuideView();
                }
                if (z) {
                    SADrainageGuideView.this.hide();
                }
            }
        });
    }

    public void onGlobalLayout() {
        if (!this.f50906m) {
            if (this.f50902i.getHeight() > 0 || this.f50902i.getWidth() > 0) {
                this.f50906m = true;
            }
            if (this.f50907n == null) {
                int[] iArr = new int[2];
                this.f50914u = iArr;
                this.f50902i.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                this.f50907n = iArr2;
                iArr2[0] = this.f50914u[0] + (this.f50902i.getWidth() / 2);
                this.f50907n[1] = this.f50914u[1] + (this.f50902i.getHeight() / 2);
            }
            if (this.f50901h == 0) {
                this.f50901h = getTargetViewRadius();
            }
            m36502b();
        }
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Builder */
    public static class Builder {
        static SADrainageGuideView guiderView;
        static Builder instance = new Builder();
        Context mContext;

        private Builder() {
        }

        public Builder(Context context) {
            this.mContext = context;
        }

        public static Builder newInstance(Context context) {
            guiderView = new SADrainageGuideView(context);
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

        public SADrainageGuideView build() {
            guiderView.m36504c();
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
