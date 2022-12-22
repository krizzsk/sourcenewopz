package com.didiglobal.p205sa.biz.component.guide.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView */
public class GuideView extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: f */
    private static final String f50960f = "show_guide_on_view_";

    /* renamed from: A */
    private Rect f50961A = new Rect();

    /* renamed from: a */
    boolean f50962a = true;

    /* renamed from: b */
    private final String f50963b = getClass().getSimpleName();

    /* renamed from: c */
    private Context f50964c;

    /* renamed from: d */
    private List<View> f50965d;

    /* renamed from: e */
    private boolean f50966e = true;

    /* renamed from: g */
    private int f50967g;

    /* renamed from: h */
    private View f50968h;

    /* renamed from: i */
    private View f50969i;

    /* renamed from: j */
    private Paint f50970j;

    /* renamed from: k */
    private Paint f50971k;

    /* renamed from: l */
    private boolean f50972l;

    /* renamed from: m */
    private int[] f50973m;

    /* renamed from: n */
    private PorterDuffXfermode f50974n;

    /* renamed from: o */
    private Bitmap f50975o;

    /* renamed from: p */
    private int f50976p;

    /* renamed from: q */
    private Canvas f50977q;

    /* renamed from: r */
    private Direction f50978r;

    /* renamed from: s */
    private MyShape f50979s;

    /* renamed from: t */
    private int[] f50980t;

    /* renamed from: u */
    private boolean f50981u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public OnClickCallback f50982v;

    /* renamed from: w */
    private boolean f50983w = false;

    /* renamed from: x */
    private int f50984x;

    /* renamed from: y */
    private int f50985y;

    /* renamed from: z */
    private int f50986z;

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView$Direction */
    public enum Direction {
        CENTER_TIPS_BOTTOM,
        CENTER_TIPS_TOP,
        BOTTOM_ARROW,
        TOP_ARROW
    }

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView$MyShape */
    public enum MyShape {
        RECTANGULAR
    }

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView$OnClickCallback */
    public interface OnClickCallback {
        void onClickedGuideView();
    }

    public void restoreState() {
        SystemUtils.log(2, this.f50963b, "restoreState", (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 103);
        this.f50967g = 0;
        this.f50970j = null;
        this.f50971k = null;
        this.f50972l = false;
        this.f50973m = null;
        this.f50974n = null;
        this.f50975o = null;
        this.f50962a = true;
        this.f50977q = null;
    }

    public int[] getLocation() {
        return this.f50980t;
    }

    public void setLocation(int[] iArr) {
        this.f50980t = iArr;
    }

    public GuideView(Context context) {
        super(context);
        this.f50964c = context;
        m36523a();
    }

    public void setDirection(Direction direction) {
        this.f50978r = direction;
    }

    public void setShape(MyShape myShape) {
        this.f50979s = myShape;
    }

    public void setCustomGuideView(View view) {
        this.f50969i = view;
        if (!this.f50966e) {
            restoreState();
        }
    }

    public void setBgColor(int i) {
        this.f50976p = i;
    }

    public View getTargetView() {
        return this.f50968h;
    }

    public void setTargetView(View view) {
        this.f50968h = view;
    }

    /* renamed from: a */
    private void m36523a() {
        this.f50984x = (int) getContext().getResources().getDimension(R.dimen.view_padding_by_bg);
        this.f50985y = (int) getContext().getResources().getDimension(R.dimen.view_padding);
        this.f50986z = (int) getContext().getResources().getDimension(R.dimen.view_radius);
    }

    public int[] getCenter() {
        return this.f50973m;
    }

    public void setCenter(int[] iArr) {
        this.f50973m = iArr;
    }

    public void hide() {
        SystemUtils.log(2, this.f50963b, LoginOmegaUtil.ACTIONID_HIDE, (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 180);
        if (this.f50968h != null) {
            removeAllViews();
            this.f50968h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ((FrameLayout) ((Activity) this.f50964c).getWindow().getDecorView()).removeView(this);
            restoreState();
            this.f50983w = false;
        }
    }

    public void show() {
        SystemUtils.log(2, this.f50963b, "show", (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 193);
        if (!this.f50983w) {
            View view = this.f50968h;
            if (view != null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            }
            setBackgroundResource(R.color.transparent);
            ((FrameLayout) ((Activity) this.f50964c).getWindow().getDecorView()).addView(this);
            this.f50983w = true;
            this.f50966e = false;
        }
    }

    public void setVisiblePaddings(Rect rect) {
        this.f50961A = rect;
    }

    public int getTargetViewpadding() {
        return this.f50985y;
    }

    public void setTargetViewpadding(int i) {
        this.f50985y = i;
    }

    public int getBgmargin() {
        return this.f50984x;
    }

    public void setBgmargin(int i) {
        this.f50984x = i;
    }

    public int getBgradius() {
        return this.f50986z;
    }

    public void setBgradius(int i) {
        this.f50986z = i;
    }

    /* renamed from: b */
    private void m36525b() {
        SystemUtils.log(2, this.f50963b, "createGuideView", (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 265);
        if (this.f50969i != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.f50978r != null) {
                int dip2px = UiUtils.dip2px(getContext(), 7.0f);
                int i = C171263.f50987x5ebae6ff[this.f50978r.ordinal()];
                if (i == 1) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(this.f50985y, ((this.f50980t[1] + this.f50968h.getHeight()) + dip2px) - this.f50968h.getPaddingBottom(), this.f50985y, 0);
                    View view = this.f50969i;
                    if (view instanceof GuideBgArrow) {
                        ((GuideBgArrow) view).setArrowPos(((this.f50980t[0] + this.f50968h.getPaddingLeft()) + (((this.f50968h.getWidth() - this.f50968h.getPaddingLeft()) - this.f50968h.getPaddingRight()) / 2)) - this.f50985y);
                    }
                } else if (i == 2) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    int i2 = this.f50985y;
                    layoutParams.setMargins(i2, 0, i2, ((getHeight() - this.f50980t[1]) - this.f50968h.getPaddingTop()) + dip2px);
                    View view2 = this.f50969i;
                    if (view2 instanceof GuideBgArrow) {
                        ((GuideBgArrow) view2).setArrowPos(((this.f50980t[0] + this.f50968h.getPaddingLeft()) + (((this.f50968h.getWidth() - this.f50968h.getPaddingLeft()) - this.f50968h.getPaddingRight()) / 2)) - this.f50985y);
                    }
                } else if (i == 3) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    ((GuideBgViewTips) this.f50969i).setVisiblePaddings(this.f50961A);
                    int i3 = this.f50984x;
                    ((GuideBgViewTips) this.f50969i).setMargin(new Rect(i3, i3, i3, i3));
                    int[] iArr = this.f50980t;
                    ((GuideBgViewTips) this.f50969i).setHightLightPos(new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + this.f50968h.getWidth()), (float) (this.f50980t[1] + this.f50968h.getHeight())));
                    int i4 = this.f50985y;
                    int i5 = this.f50984x;
                    layoutParams.setMargins(i4 - i5, (this.f50980t[1] - i5) + this.f50961A.top, this.f50985y - this.f50984x, 0);
                } else if (i == 4) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    ((GuideBgViewTips) this.f50969i).setVisiblePaddings(this.f50961A);
                    int i6 = this.f50984x;
                    ((GuideBgViewTips) this.f50969i).setMargin(new Rect(i6, i6, i6, i6));
                    int[] iArr2 = this.f50980t;
                    ((GuideBgViewTips) this.f50969i).setHightLightPos(new RectF((float) iArr2[0], (float) iArr2[1], (float) (iArr2[0] + this.f50968h.getWidth()), (float) (this.f50980t[1] + this.f50968h.getHeight())));
                    int i7 = this.f50985y;
                    int i8 = this.f50984x;
                    layoutParams.setMargins(i7 - i8, 0, i7 - i8, (((getHeight() - this.f50980t[1]) - this.f50968h.getHeight()) + this.f50961A.bottom) - this.f50984x);
                }
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (this.f50969i.getParent() != null && (this.f50969i.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f50969i.getParent()).removeView(this.f50969i);
            }
            addView(this.f50969i, layoutParams);
        }
    }

    private int[] getTargetViewSize() {
        int[] iArr = {-1, -1};
        if (this.f50972l) {
            iArr[0] = this.f50968h.getWidth();
            iArr[1] = this.f50968h.getHeight();
        }
        return iArr;
    }

    private int getTargetViewRadius() {
        if (!this.f50972l) {
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
        SystemUtils.log(2, this.f50963b, "onDraw", (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 380);
        if (this.f50972l && this.f50968h != null) {
            m36524a(canvas);
        }
    }

    /* renamed from: a */
    private void m36524a(Canvas canvas) {
        SystemUtils.log(2, this.f50963b, "drawBackground", (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 395);
        this.f50962a = false;
        this.f50975o = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        this.f50977q = new Canvas(this.f50975o);
        Paint paint = new Paint();
        int i = this.f50976p;
        if (i != 0) {
            paint.setColor(i);
        }
        Canvas canvas2 = this.f50977q;
        canvas2.drawRect(0.0f, 0.0f, (float) canvas2.getWidth(), (float) this.f50977q.getHeight(), paint);
        if (this.f50970j == null) {
            this.f50970j = new Paint();
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.f50974n = porterDuffXfermode;
        this.f50970j.setXfermode(porterDuffXfermode);
        this.f50970j.setAntiAlias(true);
        if (this.f50979s != null) {
            RectF rectF = new RectF();
            if (C171263.f50988xd190bcd5[this.f50979s.ordinal()] == 1) {
                rectF.left = (float) (this.f50980t[0] + this.f50961A.left + this.f50968h.getPaddingLeft());
                rectF.top = (float) (this.f50980t[1] + this.f50968h.getPaddingTop() + this.f50961A.top);
                rectF.right = (float) (((this.f50980t[0] + this.f50968h.getWidth()) - this.f50961A.right) - this.f50968h.getPaddingRight());
                rectF.bottom = (float) (((this.f50980t[1] + this.f50968h.getHeight()) - this.f50968h.getPaddingBottom()) - this.f50961A.bottom);
                this.f50970j.setColor(0);
                Canvas canvas3 = this.f50977q;
                int i2 = this.f50986z;
                canvas3.drawRoundRect(rectF, (float) i2, (float) i2, this.f50970j);
            }
        } else {
            Canvas canvas4 = this.f50977q;
            int[] iArr = this.f50973m;
            canvas4.drawCircle((float) iArr[0], (float) iArr[1], (float) this.f50967g, this.f50970j);
        }
        canvas.drawBitmap(this.f50975o, 0.0f, 0.0f, paint);
        this.f50975o.recycle();
    }

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView$3 */
    static /* synthetic */ class C171263 {

        /* renamed from: $SwitchMap$com$didiglobal$sa$biz$component$guide$view$GuideView$Direction */
        static final /* synthetic */ int[] f50987x5ebae6ff;

        /* renamed from: $SwitchMap$com$didiglobal$sa$biz$component$guide$view$GuideView$MyShape */
        static final /* synthetic */ int[] f50988xd190bcd5;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0023 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
        static {
            /*
                com.didiglobal.sa.biz.component.guide.view.GuideView$MyShape[] r0 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.MyShape.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50988xd190bcd5 = r0
                r1 = 1
                com.didiglobal.sa.biz.component.guide.view.GuideView$MyShape r2 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.MyShape.RECTANGULAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                com.didiglobal.sa.biz.component.guide.view.GuideView$Direction[] r0 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50987x5ebae6ff = r0
                com.didiglobal.sa.biz.component.guide.view.GuideView$Direction r2 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.Direction.BOTTOM_ARROW     // Catch:{ NoSuchFieldError -> 0x0023 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0023 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = f50987x5ebae6ff     // Catch:{ NoSuchFieldError -> 0x002e }
                com.didiglobal.sa.biz.component.guide.view.GuideView$Direction r1 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.Direction.TOP_ARROW     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r0 = f50987x5ebae6ff     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.didiglobal.sa.biz.component.guide.view.GuideView$Direction r1 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.Direction.CENTER_TIPS_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r0 = f50987x5ebae6ff     // Catch:{ NoSuchFieldError -> 0x0044 }
                com.didiglobal.sa.biz.component.guide.view.GuideView$Direction r1 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.Direction.CENTER_TIPS_TOP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.guide.view.GuideView.C171263.<clinit>():void");
        }
    }

    public void setOnClickExit(boolean z) {
        this.f50981u = z;
    }

    public void setOnclickListener(OnClickCallback onClickCallback) {
        this.f50982v = onClickCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36527c() {
        final boolean z = this.f50981u;
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GuideView.this.f50982v != null) {
                    GuideView.this.f50982v.onClickedGuideView();
                }
                if (z) {
                    GuideView.this.hide();
                }
            }
        });
    }

    public void onGlobalLayout() {
        if (!this.f50972l) {
            if (this.f50968h.getHeight() > 0 || this.f50968h.getWidth() > 0) {
                this.f50972l = true;
            }
            if (this.f50973m == null) {
                int[] iArr = new int[2];
                this.f50980t = iArr;
                this.f50968h.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                this.f50973m = iArr2;
                iArr2[0] = this.f50980t[0] + (this.f50968h.getWidth() / 2);
                this.f50973m[1] = this.f50980t[1] + (this.f50968h.getHeight() / 2);
            }
            if (this.f50967g == 0) {
                this.f50967g = getTargetViewRadius();
            }
            m36525b();
            UIHandler.post(new Runnable() {
                public void run() {
                    GuideView.this.m36529d();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m36529d() {
        try {
            int childCount = getChildCount();
            HashMap hashMap = new HashMap();
            hashMap.put("childcount", Integer.valueOf(childCount));
            if (childCount == 0) {
                OmegaSDKAdapter.trackEvent("tech_sa_pax_event_guide_show", (Map<String, Object>) hashMap);
            } else if (childCount == 1) {
                hashMap.put("visible", Boolean.valueOf(getChildAt(0).getLocalVisibleRect(new Rect())));
                OmegaSDKAdapter.trackEvent("tech_sa_pax_event_guide_show", (Map<String, Object>) hashMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView$Builder */
    public static class Builder {
        static GuideView guiderView;
        static Builder instance = new Builder();
        Context mContext;

        private Builder() {
        }

        public Builder(Context context) {
            this.mContext = context;
        }

        public static Builder newInstance(Context context) {
            guiderView = new GuideView(context);
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

        public GuideView build() {
            guiderView.m36527c();
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
