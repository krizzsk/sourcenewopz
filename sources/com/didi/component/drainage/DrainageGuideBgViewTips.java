package com.didi.component.drainage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.drainage.DrainageGuideView;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;

public class DrainageGuideBgViewTips extends RelativeLayout {

    /* renamed from: A */
    private float f12820A;

    /* renamed from: B */
    private float f12821B;

    /* renamed from: C */
    private int f12822C = 40;

    /* renamed from: D */
    private Paint f12823D;

    /* renamed from: E */
    private int f12824E;

    /* renamed from: F */
    private RectF f12825F = new RectF();

    /* renamed from: G */
    private Paint f12826G;

    /* renamed from: H */
    private Paint f12827H;

    /* renamed from: I */
    private Bitmap f12828I;

    /* renamed from: J */
    private Canvas f12829J;

    /* renamed from: K */
    private int f12830K;

    /* renamed from: L */
    private int[] f12831L;

    /* renamed from: M */
    private Rect f12832M;

    /* renamed from: N */
    private int f12833N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public View.OnClickListener f12834O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public View.OnClickListener f12835P;

    /* renamed from: Q */
    private TextView f12836Q;

    /* renamed from: R */
    private float f12837R;

    /* renamed from: S */
    private float f12838S;

    /* renamed from: T */
    private Rect f12839T = new Rect();

    /* renamed from: U */
    private View f12840U;

    /* renamed from: V */
    private View f12841V;

    /* renamed from: W */
    private DrainageGuideView.MyShape f12842W;

    /* renamed from: X */
    private ImageView f12843X;

    /* renamed from: Y */
    private Paint f12844Y;

    /* renamed from: Z */
    private Bitmap f12845Z;

    /* renamed from: a */
    int f12846a = 75;

    /* renamed from: aa */
    private Paint f12847aa;

    /* renamed from: b */
    int f12848b = 125;

    /* renamed from: c */
    int f12849c = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: d */
    int f12850d = (-UiUtils.dip2px(getContext(), 9.0f));

    /* renamed from: e */
    int f12851e = UiUtils.dip2px(getContext(), 15.0f);

    /* renamed from: f */
    float f12852f = ((float) UiUtils.dip2px(getContext(), 24.0f));

    /* renamed from: g */
    float f12853g = ((float) UiUtils.dip2px(getContext(), 34.0f));

    /* renamed from: h */
    int f12854h = 51;

    /* renamed from: i */
    int f12855i = 25;

    /* renamed from: j */
    int f12856j = 0;

    /* renamed from: k */
    int f12857k = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: l */
    float f12858l = ((float) UiUtils.dip2px(getContext(), 24.0f));

    /* renamed from: m */
    float f12859m = ((float) UiUtils.dip2px(getContext(), 31.0f));

    /* renamed from: n */
    int f12860n = 127;

    /* renamed from: o */
    int f12861o = 102;

    /* renamed from: p */
    int f12862p = 0;

    /* renamed from: q */
    int f12863q;

    /* renamed from: r */
    int f12864r = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: s */
    int f12865s = UiUtils.dip2px(getContext(), 11.0f);

    /* renamed from: t */
    float f12866t = 0.33333334f;

    /* renamed from: u */
    int f12867u = UiUtils.dip2px(getContext(), 16.0f);

    /* renamed from: v */
    int f12868v = UiUtils.dip2px(getContext(), 11.0f);

    /* renamed from: w */
    int f12869w = UiUtils.dip2px(getContext(), 20.0f);

    /* renamed from: x */
    int f12870x = UiUtils.dip2px(getContext(), 24.0f);

    /* renamed from: y */
    int f12871y = UiUtils.dip2px(getContext(), 2.0f);

    /* renamed from: z */
    private Paint f12872z;

    public @interface TipType {
        public static final int Tip_bottom = 1;
        public static final int Tip_top = 0;
    }

    public void setVisiblePaddings(Rect rect) {
        this.f12839T = rect;
    }

    public DrainageGuideBgViewTips(Context context, int i) {
        super(context);
        this.f12824E = i;
        m8762a();
    }

    /* renamed from: a */
    private void m8762a() {
        setBackgroundResource(R.color.transparent);
        this.f12830K = UiUtils.dip2px(getContext(), 20.0f);
        int dip2px = UiUtils.dip2px(getContext(), 30.0f);
        this.f12833N = dip2px;
        int i = dip2px * 2;
        this.f12831L = new int[]{i, i, i, i};
        m8765b();
        this.f12840U = LayoutInflater.from(getContext()).inflate(R.layout.drainage_guide_view, (ViewGroup) null);
        addView(this.f12840U, new RelativeLayout.LayoutParams(-2, -2));
        View findViewById = findViewById(R.id.close);
        this.f12841V = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DrainageGuideBgViewTips.this.f12834O != null) {
                    DrainageGuideBgViewTips.this.f12834O.onClick(view);
                }
            }
        });
        this.f12843X = (ImageView) findViewById(R.id.img);
        this.f12840U.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f12836Q = (TextView) findViewById(R.id.drainage_tips);
    }

    /* renamed from: b */
    private void m8765b() {
        int parseColor = Color.parseColor("#FF8040");
        int parseColor2 = Color.parseColor("#FF8040");
        Paint paint = new Paint();
        this.f12872z = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f12872z.setColor(parseColor);
        this.f12872z.setStrokeWidth(12.0f);
        this.f12872z.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f12847aa = paint2;
        paint2.setAntiAlias(true);
        this.f12847aa.setStyle(Paint.Style.STROKE);
        this.f12847aa.setStrokeWidth(6.0f);
        this.f12847aa.setAlpha(255);
        this.f12847aa.setColor(parseColor2);
        Paint paint3 = new Paint();
        this.f12844Y = paint3;
        paint3.setAntiAlias(true);
        this.f12844Y.setStyle(Paint.Style.STROKE);
        this.f12844Y.setStrokeWidth(6.0f);
        this.f12844Y.setAlpha(51);
        this.f12844Y.setColor(parseColor2);
        Bitmap copy = BitmapFactory.decodeResource(getResources(), R.drawable.arrow).copy(Bitmap.Config.ARGB_8888, true);
        int width = copy.getWidth();
        int height = copy.getHeight();
        float f = ((float) this.f12869w) / ((float) width);
        float f2 = ((float) this.f12870x) / ((float) height);
        Matrix matrix = new Matrix();
        if (this.f12824E == 1) {
            matrix.setRotate(180.0f);
        }
        matrix.postScale(f, f2);
        this.f12845Z = Bitmap.createBitmap(copy, 0, 0, width, height, matrix, true);
        Paint paint4 = new Paint();
        this.f12823D = paint4;
        paint4.setColor(parseColor2);
        this.f12823D.setStyle(Paint.Style.FILL);
    }

    public void setOnGetClickListener(View.OnClickListener onClickListener) {
        this.f12834O = onClickListener;
    }

    public void setmGuideViewListener(View.OnClickListener onClickListener) {
        this.f12835P = onClickListener;
    }

    public void setHightLightPos(RectF rectF) {
        this.f12825F = rectF;
        this.f12837R = rectF.bottom - rectF.top;
        this.f12838S = rectF.right - rectF.left;
        this.f12820A = rectF.left + (this.f12838S / 2.0f);
        this.f12821B = (this.f12837R / 2.0f) + rectF.top;
        this.f12846a = ((int) (this.f12837R / 2.0f)) - this.f12839T.top;
        this.f12848b = ((int) (this.f12838S / 2.0f)) - this.f12839T.left;
    }

    public void setMargin(Rect rect) {
        this.f12832M = rect;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m8763a(canvas);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            super.onMeasure(r6, r7)
            android.view.View r6 = r5.f12840U
            if (r6 == 0) goto L_0x00db
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            if (r6 == 0) goto L_0x00db
            android.view.View r6 = r5.f12840U
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r6 = (android.widget.RelativeLayout.LayoutParams) r6
            android.graphics.RectF r7 = r5.f12825F
            float r7 = r7.right
            android.graphics.RectF r0 = r5.f12825F
            float r0 = r0.left
            float r7 = r7 + r0
            r0 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r0
            int r1 = r5.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            r2 = 1101004800(0x41a00000, float:20.0)
            float r1 = r1 - r2
            r3 = 0
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0040
            int r1 = r5.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            float r1 = r1 + r2
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0040
            r7 = 14
            r6.addRule(r7)
            goto L_0x008f
        L_0x0040:
            int r1 = r5.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            r2 = 1098907648(0x41800000, float:16.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0077
            r7 = 11
            r6.addRule(r7)
            int r7 = r5.getMeasuredWidth()
            float r7 = (float) r7
            android.graphics.RectF r0 = r5.f12825F
            float r0 = r0.right
            float r7 = r7 - r0
            android.graphics.Rect r0 = r5.f12839T
            int r0 = r0.right
            float r0 = (float) r0
            float r7 = r7 + r0
            int r7 = (int) r7
            android.content.Context r0 = r5.getContext()
            int r0 = com.didi.global.globaluikit.utils.UiUtils.dip2px(r0, r2)
            if (r7 >= r0) goto L_0x0074
            android.content.Context r7 = r5.getContext()
            int r7 = com.didi.global.globaluikit.utils.UiUtils.dip2px(r7, r2)
        L_0x0074:
            r0 = r7
            r7 = 0
            goto L_0x0091
        L_0x0077:
            int r1 = r5.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            int r7 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x008f
            r7 = 9
            r6.addRule(r7)
            android.content.Context r7 = r5.getContext()
            int r7 = com.didi.global.globaluikit.utils.UiUtils.dip2px(r7, r2)
            goto L_0x0090
        L_0x008f:
            r7 = 0
        L_0x0090:
            r0 = 0
        L_0x0091:
            int r1 = r5.f12824E
            r2 = 1
            if (r1 != r2) goto L_0x00b3
            float r1 = r5.f12821B
            int r2 = r5.f12846a
            float r2 = (float) r2
            float r1 = r1 + r2
            int r2 = r5.f12868v
            float r2 = (float) r2
            float r1 = r1 + r2
            android.graphics.Bitmap r2 = r5.f12845Z
            int r2 = r2.getHeight()
            float r2 = (float) r2
            float r1 = r1 + r2
            int r2 = r5.f12871y
            int r2 = r2 * 10
            float r2 = (float) r2
            float r1 = r1 + r2
            int r1 = (int) r1
            r6.setMargins(r7, r1, r0, r3)
            goto L_0x00db
        L_0x00b3:
            if (r1 != 0) goto L_0x00db
            r1 = 12
            r6.addRule(r1)
            int r1 = r5.getMeasuredHeight()
            float r2 = r5.f12821B
            int r4 = r5.f12846a
            float r4 = (float) r4
            float r2 = r2 - r4
            int r4 = r5.f12868v
            float r4 = (float) r4
            float r2 = r2 - r4
            android.graphics.Bitmap r4 = r5.f12845Z
            int r4 = r4.getHeight()
            float r4 = (float) r4
            float r2 = r2 - r4
            int r4 = r5.f12871y
            int r4 = r4 * 10
            float r4 = (float) r4
            float r2 = r2 - r4
            int r2 = (int) r2
            int r1 = r1 - r2
            r6.setMargins(r7, r3, r0, r1)
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.drainage.DrainageGuideBgViewTips.onMeasure(int, int):void");
    }

    /* renamed from: a */
    private void m8763a(Canvas canvas) {
        if (this.f12826G == null) {
            this.f12826G = new Paint();
            this.f12826G.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            this.f12826G.setAntiAlias(true);
        }
        if (canvas.getWidth() > 0 && canvas.getHeight() > 0) {
            if (this.f12828I == null) {
                this.f12828I = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                this.f12829J = new Canvas(this.f12828I);
            }
            if (this.f12827H == null) {
                Paint paint = new Paint();
                this.f12827H = paint;
                paint.setColor(Color.parseColor("#FF8040"));
                this.f12827H.setStyle(Paint.Style.STROKE);
                this.f12827H.setAntiAlias(true);
                this.f12827H.setStrokeWidth((float) UiUtils.dip2px(getContext(), 6.0f));
            }
            if (this.f12842W == DrainageGuideView.MyShape.RECTANGULAR) {
                this.f12829J.drawRoundRect((this.f12825F.left + ((float) this.f12839T.left)) - ((float) (this.f12832M.left / 2)), (this.f12825F.top + ((float) this.f12839T.top)) - ((float) (this.f12832M.top / 2)), (this.f12825F.right - ((float) this.f12839T.right)) + ((float) (this.f12832M.right / 2)), (this.f12825F.bottom - ((float) this.f12839T.bottom)) + ((float) (this.f12832M.bottom / 2)), (float) UiUtils.dip2px(getContext(), 24.0f), (float) UiUtils.dip2px(getContext(), 24.0f), this.f12827H);
            } else if (this.f12842W == DrainageGuideView.MyShape.CIRCLE) {
                this.f12829J.drawCircle(this.f12820A, this.f12821B, (float) (this.f12848b + (this.f12832M.left / 2)), this.f12827H);
            }
            canvas.drawBitmap(this.f12828I, 0.0f, 0.0f, this.f12827H);
            m8766b(canvas);
        }
    }

    /* renamed from: c */
    private void m8767c() {
        int[] iArr = this.f12831L;
        if (iArr != null && iArr.length >= 4) {
            Path path = new Path();
            path.moveTo((this.f12825F.left + ((float) this.f12831L[0])) - ((float) this.f12832M.left), this.f12825F.top - ((float) this.f12832M.top));
            path.lineTo((this.f12825F.right - ((float) this.f12831L[1])) + ((float) this.f12832M.right), this.f12825F.top - ((float) this.f12832M.top));
            path.arcTo(new RectF((this.f12825F.right - ((float) this.f12831L[1])) + ((float) this.f12832M.right), this.f12825F.top - ((float) this.f12832M.top), this.f12825F.right + ((float) this.f12832M.right), (this.f12825F.top - ((float) this.f12832M.top)) + ((float) this.f12831L[1])), -90.0f, 90.0f);
            path.lineTo(this.f12825F.right + ((float) this.f12832M.right), (this.f12825F.bottom + ((float) this.f12832M.bottom)) - ((float) this.f12831L[2]));
            path.arcTo(new RectF((this.f12825F.right + ((float) this.f12832M.right)) - ((float) this.f12831L[2]), (this.f12825F.bottom + ((float) this.f12832M.bottom)) - ((float) this.f12831L[2]), this.f12825F.right + ((float) this.f12832M.right), this.f12825F.bottom + ((float) this.f12832M.bottom)), 0.0f, 90.0f);
            path.lineTo((this.f12825F.left - ((float) this.f12832M.left)) + ((float) this.f12831L[3]), this.f12825F.bottom + ((float) this.f12832M.bottom));
            path.arcTo(new RectF(this.f12825F.left - ((float) this.f12832M.left), (this.f12825F.bottom + ((float) this.f12832M.bottom)) - ((float) this.f12831L[3]), (this.f12825F.left - ((float) this.f12832M.left)) + ((float) this.f12831L[3]), this.f12825F.bottom + ((float) this.f12832M.bottom)), 90.0f, 90.0f);
            path.lineTo(this.f12825F.left - ((float) this.f12832M.left), (this.f12825F.top - ((float) this.f12832M.top)) + ((float) this.f12831L[0]));
            path.arcTo(new RectF(this.f12825F.left - ((float) this.f12832M.left), this.f12825F.top - ((float) this.f12832M.top), (this.f12825F.left - ((float) this.f12832M.left)) + ((float) this.f12831L[0]), (this.f12825F.top - ((float) this.f12832M.top)) + ((float) this.f12831L[0])), 180.0f, 90.0f);
            path.close();
            this.f12829J.drawPath(path, this.f12827H);
        }
    }

    public void setShape(DrainageGuideView.MyShape myShape) {
        this.f12842W = myShape;
    }

    public void setData(final DrainageData drainageData) {
        if (!(this.f12836Q == null || drainageData.getTips() == null)) {
            this.f12836Q.setText(m8760a(drainageData.getTips(), getResources().getDrawable(R.drawable.drainage_icon_more)));
        }
        int i = R.drawable.drainage_didi_placehold;
        if (AppUtils.isBrazilApp(getContext())) {
            i = R.drawable.drainage_99_placehold;
        }
        ((RequestBuilder) ((RequestBuilder) Glide.with(getContext()).load(drainageData.getImage()).placeholder(i)).error(i)).into(this.f12843X);
        if (!TextUtils.isEmpty(drainageData.getTips_action())) {
            this.f12840U.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (DrainageGuideBgViewTips.this.f12835P != null) {
                        DrainageGuideBgViewTips.this.f12835P.onClick(view);
                    }
                    DRouter.build(drainageData.getTips_action()).start();
                }
            });
        }
    }

    /* renamed from: a */
    private SpannableStringBuilder m8760a(String str, Drawable drawable) {
        drawable.setBounds(0, 0, UiUtils.dip2px(getContext(), 12.0f), UiUtils.dip2px(getContext(), 12.0f));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + "  ");
        spannableStringBuilder.setSpan(new VerticalImageSpan(drawable), spannableStringBuilder.length() + -1, spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }

    /* renamed from: b */
    private void m8766b(Canvas canvas) {
        float f;
        float f2;
        int i = this.f12850d;
        int i2 = this.f12849c;
        float f3 = (((float) (i - i2)) * 1.0f) / ((float) (this.f12851e - i2));
        int i3 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i3 > 0 && f3 <= 1.0f) {
            float f4 = this.f12852f;
            float f5 = f4 + ((this.f12853g - f4) * f3);
            int i4 = this.f12854h;
            float f6 = ((float) i4) + (((float) (this.f12855i - i4)) * f3);
            this.f12844Y.setStrokeWidth((float) i);
            this.f12844Y.setAlpha((int) f6);
            if (this.f12842W == DrainageGuideView.MyShape.RECTANGULAR) {
                float f7 = this.f12820A;
                int i5 = this.f12848b;
                int i6 = this.f12850d;
                float f8 = this.f12821B;
                int i7 = this.f12846a;
                canvas.drawRoundRect(new RectF((f7 - ((float) i5)) - ((float) (i6 / 2)), (f8 - ((float) i7)) - ((float) (i6 / 2)), f7 + ((float) i5) + ((float) (i6 / 2)), f8 + ((float) i7) + ((float) (i6 / 2))), f5, f5, this.f12844Y);
            } else if (this.f12842W == DrainageGuideView.MyShape.CIRCLE) {
                canvas.drawCircle(this.f12820A, this.f12821B, (float) (this.f12848b + (this.f12850d / 2)), this.f12844Y);
            }
        } else if (f3 >= 1.0f) {
            float f9 = this.f12866t;
            if (f3 <= f9 + 1.0f) {
                float f10 = (f3 - 1.0f) / f9;
                int i8 = this.f12855i;
                this.f12844Y.setAlpha((int) (((float) i8) + (((float) (this.f12856j - i8)) * f10)));
                if (this.f12842W == DrainageGuideView.MyShape.RECTANGULAR) {
                    float f11 = this.f12820A;
                    int i9 = this.f12848b;
                    int i10 = this.f12850d;
                    float f12 = this.f12821B;
                    int i11 = this.f12846a;
                    RectF rectF = new RectF((f11 - ((float) i9)) - ((float) (i10 / 2)), (f12 - ((float) i11)) - ((float) (i10 / 2)), f11 + ((float) i9) + ((float) (i10 / 2)), f12 + ((float) i11) + ((float) (i10 / 2)));
                    float f13 = this.f12853g;
                    canvas.drawRoundRect(rectF, f13, f13, this.f12844Y);
                } else if (this.f12842W == DrainageGuideView.MyShape.CIRCLE) {
                    canvas.drawCircle(this.f12820A, this.f12821B, (float) (this.f12848b + (this.f12850d / 2)), this.f12844Y);
                }
            }
        }
        float f14 = this.f12866t;
        if (f3 <= f14 || f3 >= f14 + 1.0f) {
            float f15 = this.f12866t;
            if (f3 >= f15 + 1.0f && f3 <= (f15 * 2.0f) + 1.0f) {
                float f16 = ((f3 - 1.0f) - f15) / f15;
                int i12 = this.f12861o;
                this.f12847aa.setAlpha((int) (((float) i12) + (((float) (this.f12862p - i12)) * f16)));
                if (this.f12842W == DrainageGuideView.MyShape.RECTANGULAR) {
                    RectF rectF2 = new RectF(((this.f12820A - ((float) this.f12848b)) - ((float) ((this.f12850d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f12857k / 2)), ((this.f12821B - ((float) this.f12846a)) - ((float) ((this.f12850d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f12857k / 2)), this.f12820A + ((float) this.f12848b) + ((float) ((this.f12850d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f12857k / 2)), this.f12821B + ((float) this.f12846a) + ((float) ((this.f12850d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f12857k / 2)));
                    float f17 = this.f12859m;
                    canvas.drawRoundRect(rectF2, f17, f17, this.f12847aa);
                } else if (this.f12842W == DrainageGuideView.MyShape.CIRCLE) {
                    canvas.drawCircle(this.f12820A, this.f12821B, (float) (this.f12848b + ((this.f12850d - UiUtils.dip2px(getContext(), 4.0f)) / 2) + (this.f12857k / 2)), this.f12847aa);
                }
            }
        } else {
            float f18 = f3 - f14;
            int i13 = this.f12860n;
            float f19 = ((float) i13) + (((float) (this.f12861o - i13)) * f18);
            float f20 = this.f12858l;
            float f21 = f20 + ((this.f12859m - f20) * f18);
            this.f12847aa.setStrokeWidth((float) this.f12857k);
            this.f12847aa.setAlpha((int) f19);
            if (this.f12842W == DrainageGuideView.MyShape.RECTANGULAR) {
                canvas.drawRoundRect(new RectF(((this.f12820A - ((float) this.f12848b)) - ((float) ((this.f12850d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f12857k / 2)), ((this.f12821B - ((float) this.f12846a)) - ((float) ((this.f12850d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f12857k / 2)), this.f12820A + ((float) this.f12848b) + ((float) ((this.f12850d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f12857k / 2)), this.f12821B + ((float) this.f12846a) + ((float) ((this.f12850d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f12857k / 2))), f21, f21, this.f12847aa);
            } else if (this.f12842W == DrainageGuideView.MyShape.CIRCLE) {
                canvas.drawCircle(this.f12820A, this.f12821B, (float) (this.f12848b + ((this.f12850d - UiUtils.dip2px(getContext(), 4.0f)) / 2) + (this.f12857k / 2)), this.f12847aa);
            }
        }
        if (f3 <= 0.0f) {
            int i14 = this.f12868v;
            int i15 = this.f12867u;
            float f22 = (((float) (i14 - i15)) * ((f3 + 1.0f) / 1.0f)) + ((float) i15);
            if (this.f12824E == 1) {
                f2 = this.f12821B + ((float) this.f12846a) + f22;
            } else {
                f2 = ((this.f12821B - ((float) this.f12846a)) - f22) - ((float) this.f12845Z.getHeight());
            }
            canvas.drawBitmap(this.f12845Z, this.f12820A - ((float) (this.f12869w / 2)), f2, new Paint());
        } else if (i3 > 0) {
            int i16 = this.f12867u;
            int i17 = this.f12868v;
            float f23 = (((float) (i16 - i17)) * (f3 / ((this.f12866t * 2.0f) + 1.0f))) + ((float) i17);
            if (this.f12824E == 1) {
                f = this.f12821B + ((float) this.f12846a) + f23;
            } else {
                f = ((this.f12821B - ((float) this.f12846a)) - f23) - ((float) this.f12845Z.getHeight());
            }
            canvas.drawBitmap(this.f12845Z, this.f12820A - ((float) (this.f12869w / 2)), f, new Paint());
        }
        if (this.f12824E == 1) {
            float f24 = this.f12820A;
            float height = this.f12821B + ((float) this.f12846a) + ((float) this.f12868v) + ((float) this.f12845Z.getHeight());
            int i18 = this.f12871y;
            canvas.drawCircle(f24, height + ((float) (i18 * 2)), (float) i18, this.f12823D);
            float f25 = this.f12820A;
            float height2 = this.f12821B + ((float) this.f12846a) + ((float) this.f12868v) + ((float) this.f12845Z.getHeight());
            int i19 = this.f12871y;
            canvas.drawCircle(f25, height2 + ((float) (i19 * 5)), (float) i19, this.f12823D);
            float f26 = this.f12820A;
            float height3 = this.f12821B + ((float) this.f12846a) + ((float) this.f12868v) + ((float) this.f12845Z.getHeight());
            int i20 = this.f12871y;
            canvas.drawCircle(f26, height3 + ((float) (i20 * 8)), (float) i20, this.f12823D);
        } else {
            float f27 = this.f12820A;
            float height4 = ((this.f12821B - ((float) this.f12846a)) - ((float) this.f12868v)) - ((float) this.f12845Z.getHeight());
            int i21 = this.f12871y;
            canvas.drawCircle(f27, height4 - ((float) (i21 * 2)), (float) i21, this.f12823D);
            float f28 = this.f12820A;
            float height5 = ((this.f12821B - ((float) this.f12846a)) - ((float) this.f12868v)) - ((float) this.f12845Z.getHeight());
            int i22 = this.f12871y;
            canvas.drawCircle(f28, height5 - ((float) (i22 * 5)), (float) i22, this.f12823D);
            float f29 = this.f12820A;
            float height6 = ((this.f12821B - ((float) this.f12846a)) - ((float) this.f12868v)) - ((float) this.f12845Z.getHeight());
            int i23 = this.f12871y;
            canvas.drawCircle(f29, height6 - ((float) (i23 * 8)), (float) i23, this.f12823D);
        }
        this.f12850d += UiUtils.dip2px(getContext(), 1.0f);
        if (f3 > (this.f12866t * 2.0f) + 1.0f) {
            this.f12850d = -UiUtils.dip2px(getContext(), 9.0f);
        }
        postInvalidateDelayed((long) this.f12822C);
    }
}
