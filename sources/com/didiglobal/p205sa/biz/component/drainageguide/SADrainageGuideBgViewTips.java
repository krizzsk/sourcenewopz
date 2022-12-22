package com.didiglobal.p205sa.biz.component.drainageguide;

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
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideBgViewTips */
public class SADrainageGuideBgViewTips extends RelativeLayout {

    /* renamed from: A */
    int f50833A = UiUtils.dip2px(getContext(), 2.0f);

    /* renamed from: B */
    private Paint f50834B;

    /* renamed from: C */
    private Bitmap f50835C;

    /* renamed from: D */
    private Paint f50836D;

    /* renamed from: E */
    private Paint f50837E;

    /* renamed from: F */
    private float f50838F;

    /* renamed from: G */
    private float f50839G;

    /* renamed from: H */
    private int f50840H = 45;

    /* renamed from: I */
    private Paint f50841I;

    /* renamed from: J */
    private int f50842J;

    /* renamed from: K */
    private RectF f50843K = new RectF();

    /* renamed from: L */
    private Paint f50844L;

    /* renamed from: M */
    private Paint f50845M;

    /* renamed from: N */
    private Bitmap f50846N;

    /* renamed from: O */
    private Canvas f50847O;

    /* renamed from: P */
    private int f50848P;

    /* renamed from: Q */
    private int[] f50849Q;

    /* renamed from: R */
    private Rect f50850R;

    /* renamed from: S */
    private int f50851S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public View.OnClickListener f50852T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public View.OnClickListener f50853U;

    /* renamed from: V */
    private TextView f50854V;

    /* renamed from: W */
    private float f50855W;

    /* renamed from: X */
    private float f50856X;

    /* renamed from: Y */
    private Rect f50857Y = new Rect();

    /* renamed from: Z */
    private View f50858Z;

    /* renamed from: a */
    int f50859a = 75;

    /* renamed from: aa */
    private View f50860aa;

    /* renamed from: ab */
    private ImageView f50861ab;

    /* renamed from: b */
    int f50862b = 125;

    /* renamed from: c */
    int f50863c = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: d */
    int f50864d = (-UiUtils.dip2px(getContext(), 9.0f));

    /* renamed from: e */
    int f50865e = UiUtils.dip2px(getContext(), 15.0f);

    /* renamed from: f */
    float f50866f = ((float) UiUtils.dip2px(getContext(), 24.0f));

    /* renamed from: g */
    float f50867g = ((float) UiUtils.dip2px(getContext(), 34.0f));

    /* renamed from: h */
    int f50868h = 51;

    /* renamed from: i */
    int f50869i = 25;

    /* renamed from: j */
    int f50870j = 0;

    /* renamed from: k */
    int f50871k;

    /* renamed from: l */
    int f50872l = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: m */
    int f50873m = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: n */
    float f50874n = ((float) UiUtils.dip2px(getContext(), 24.0f));

    /* renamed from: o */
    float f50875o = ((float) UiUtils.dip2px(getContext(), 31.0f));

    /* renamed from: p */
    int f50876p = 127;

    /* renamed from: q */
    int f50877q = 102;

    /* renamed from: r */
    int f50878r = 0;

    /* renamed from: s */
    int f50879s;

    /* renamed from: t */
    int f50880t = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: u */
    int f50881u = UiUtils.dip2px(getContext(), 11.0f);

    /* renamed from: v */
    float f50882v = 0.33333334f;

    /* renamed from: w */
    int f50883w = UiUtils.dip2px(getContext(), 16.0f);

    /* renamed from: x */
    int f50884x = UiUtils.dip2px(getContext(), 11.0f);

    /* renamed from: y */
    int f50885y = UiUtils.dip2px(getContext(), 20.0f);

    /* renamed from: z */
    int f50886z = UiUtils.dip2px(getContext(), 24.0f);

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideBgViewTips$TipType */
    public @interface TipType {
        public static final int Tip_bottom = 1;
        public static final int Tip_top = 0;
    }

    public void setVisiblePaddings(Rect rect) {
        this.f50857Y = rect;
    }

    public SADrainageGuideBgViewTips(Context context, int i) {
        super(context);
        this.f50842J = i;
        m36492a();
    }

    /* renamed from: a */
    private void m36492a() {
        setBackgroundResource(R.color.transparent);
        this.f50848P = (int) getContext().getResources().getDimension(R.dimen.view_radius);
        int dimension = (int) getContext().getResources().getDimension(R.dimen.view_bg_radius);
        this.f50851S = dimension;
        int i = dimension * 2;
        this.f50849Q = new int[]{i, i, i, i};
        m36497c();
        this.f50858Z = LayoutInflater.from(getContext()).inflate(R.layout.sa_drainage_guide_view, (ViewGroup) null);
        addView(this.f50858Z, new RelativeLayout.LayoutParams(-2, -2));
        View findViewById = findViewById(R.id.close);
        this.f50860aa = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SADrainageGuideBgViewTips.this.f50852T != null) {
                    SADrainageGuideBgViewTips.this.f50852T.onClick(view);
                }
            }
        });
        this.f50861ab = (ImageView) findViewById(R.id.img);
        this.f50854V = (TextView) findViewById(R.id.drainage_tips);
    }

    public void setOnGetClickListener(View.OnClickListener onClickListener) {
        this.f50852T = onClickListener;
    }

    public void setmGuideViewListener(View.OnClickListener onClickListener) {
        this.f50853U = onClickListener;
    }

    public void setmAllBgDiameter(int[] iArr) {
        this.f50849Q = iArr;
    }

    public void setHightLightPos(RectF rectF) {
        this.f50843K = rectF;
        this.f50855W = rectF.bottom - rectF.top;
        this.f50856X = rectF.right - rectF.left;
        this.f50838F = rectF.left + (this.f50856X / 2.0f);
        this.f50839G = (this.f50855W / 2.0f) + rectF.top;
        this.f50859a = ((int) (this.f50855W / 2.0f)) - this.f50857Y.top;
        this.f50862b = ((int) (this.f50856X / 2.0f)) - this.f50857Y.left;
    }

    public void setMargin(Rect rect) {
        this.f50850R = rect;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m36493a(canvas);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            super.onMeasure(r7, r8)
            android.view.View r7 = r6.f50858Z
            if (r7 == 0) goto L_0x00c5
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            if (r7 == 0) goto L_0x00c5
            android.view.View r7 = r6.f50858Z
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r7 = (android.widget.RelativeLayout.LayoutParams) r7
            android.graphics.RectF r8 = r6.f50843K
            float r8 = r8.right
            android.graphics.RectF r0 = r6.f50843K
            float r0 = r0.left
            float r8 = r8 + r0
            r0 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r0
            int r1 = r6.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            r2 = 1101004800(0x41a00000, float:20.0)
            float r1 = r1 - r2
            r3 = 0
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0040
            int r1 = r6.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            float r1 = r1 + r2
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0040
            r8 = 14
            r7.addRule(r8)
            goto L_0x0074
        L_0x0040:
            int r1 = r6.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            r2 = 1098907648(0x41800000, float:16.0)
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x005c
            r8 = 11
            r7.addRule(r8)
            android.content.Context r8 = r6.getContext()
            int r8 = com.didi.global.globaluikit.utils.UiUtils.dip2px(r8, r2)
            r0 = r8
            r8 = 0
            goto L_0x0076
        L_0x005c:
            int r1 = r6.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 >= 0) goto L_0x0074
            r8 = 9
            r7.addRule(r8)
            android.content.Context r8 = r6.getContext()
            int r8 = com.didi.global.globaluikit.utils.UiUtils.dip2px(r8, r2)
            goto L_0x0075
        L_0x0074:
            r8 = 0
        L_0x0075:
            r0 = 0
        L_0x0076:
            int r1 = r6.f50842J
            r2 = 1
            r4 = 10
            if (r1 != r2) goto L_0x009d
            r7.addRule(r4)
            float r1 = r6.f50839G
            int r2 = r6.f50859a
            float r2 = (float) r2
            float r1 = r1 + r2
            int r2 = r6.f50884x
            float r2 = (float) r2
            float r1 = r1 + r2
            android.graphics.Bitmap r2 = r6.f50835C
            int r2 = r2.getHeight()
            float r2 = (float) r2
            float r1 = r1 + r2
            int r2 = r6.f50833A
            int r2 = r2 * 10
            float r2 = (float) r2
            float r1 = r1 + r2
            int r1 = (int) r1
            r7.setMargins(r8, r1, r0, r3)
            goto L_0x00c5
        L_0x009d:
            if (r1 != 0) goto L_0x00c5
            r1 = 12
            r7.addRule(r1)
            int r1 = r6.getMeasuredHeight()
            float r2 = r6.f50839G
            int r5 = r6.f50859a
            float r5 = (float) r5
            float r2 = r2 - r5
            int r5 = r6.f50884x
            float r5 = (float) r5
            float r2 = r2 - r5
            android.graphics.Bitmap r5 = r6.f50835C
            int r5 = r5.getHeight()
            float r5 = (float) r5
            float r2 = r2 - r5
            int r5 = r6.f50833A
            int r5 = r5 * 10
            float r4 = (float) r5
            float r2 = r2 - r4
            int r2 = (int) r2
            int r1 = r1 - r2
            r7.setMargins(r8, r3, r0, r1)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideBgViewTips.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* renamed from: a */
    private void m36493a(Canvas canvas) {
        if (this.f50844L == null) {
            this.f50844L = new Paint();
            this.f50844L.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            this.f50844L.setAntiAlias(true);
        }
        if (canvas.getWidth() > 0 && canvas.getHeight() > 0) {
            if (this.f50846N == null) {
                this.f50846N = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                this.f50847O = new Canvas(this.f50846N);
            }
            if (this.f50845M == null) {
                Paint paint = new Paint();
                this.f50845M = paint;
                paint.setColor(Color.parseColor("#FF8040"));
                this.f50845M.setStyle(Paint.Style.STROKE);
                this.f50845M.setAntiAlias(true);
                this.f50845M.setStrokeWidth((float) UiUtils.dip2px(getContext(), 6.0f));
            }
            this.f50847O.drawRoundRect((this.f50843K.left + ((float) this.f50857Y.left)) - ((float) (this.f50850R.left / 2)), (this.f50843K.top + ((float) this.f50857Y.top)) - ((float) (this.f50850R.top / 2)), (this.f50843K.right - ((float) this.f50857Y.right)) + ((float) (this.f50850R.right / 2)), (this.f50843K.bottom - ((float) this.f50857Y.bottom)) + ((float) (this.f50850R.bottom / 2)), (float) UiUtils.dip2px(getContext(), 24.0f), (float) UiUtils.dip2px(getContext(), 24.0f), this.f50845M);
            canvas.drawBitmap(this.f50846N, 0.0f, 0.0f, this.f50845M);
            m36496b(canvas);
        }
    }

    /* renamed from: b */
    private void m36495b() {
        int[] iArr = this.f50849Q;
        if (iArr != null && iArr.length >= 4) {
            Path path = new Path();
            path.moveTo((this.f50843K.left + ((float) this.f50849Q[0])) - ((float) this.f50850R.left), this.f50843K.top - ((float) this.f50850R.top));
            path.lineTo((this.f50843K.right - ((float) this.f50849Q[1])) + ((float) this.f50850R.right), this.f50843K.top - ((float) this.f50850R.top));
            path.arcTo(new RectF((this.f50843K.right - ((float) this.f50849Q[1])) + ((float) this.f50850R.right), this.f50843K.top - ((float) this.f50850R.top), this.f50843K.right + ((float) this.f50850R.right), (this.f50843K.top - ((float) this.f50850R.top)) + ((float) this.f50849Q[1])), -90.0f, 90.0f);
            path.lineTo(this.f50843K.right + ((float) this.f50850R.right), (this.f50843K.bottom + ((float) this.f50850R.bottom)) - ((float) this.f50849Q[2]));
            path.arcTo(new RectF((this.f50843K.right + ((float) this.f50850R.right)) - ((float) this.f50849Q[2]), (this.f50843K.bottom + ((float) this.f50850R.bottom)) - ((float) this.f50849Q[2]), this.f50843K.right + ((float) this.f50850R.right), this.f50843K.bottom + ((float) this.f50850R.bottom)), 0.0f, 90.0f);
            path.lineTo((this.f50843K.left - ((float) this.f50850R.left)) + ((float) this.f50849Q[3]), this.f50843K.bottom + ((float) this.f50850R.bottom));
            path.arcTo(new RectF(this.f50843K.left - ((float) this.f50850R.left), (this.f50843K.bottom + ((float) this.f50850R.bottom)) - ((float) this.f50849Q[3]), (this.f50843K.left - ((float) this.f50850R.left)) + ((float) this.f50849Q[3]), this.f50843K.bottom + ((float) this.f50850R.bottom)), 90.0f, 90.0f);
            path.lineTo(this.f50843K.left - ((float) this.f50850R.left), (this.f50843K.top - ((float) this.f50850R.top)) + ((float) this.f50849Q[0]));
            path.arcTo(new RectF(this.f50843K.left - ((float) this.f50850R.left), this.f50843K.top - ((float) this.f50850R.top), (this.f50843K.left - ((float) this.f50850R.left)) + ((float) this.f50849Q[0]), (this.f50843K.top - ((float) this.f50850R.top)) + ((float) this.f50849Q[0])), 180.0f, 90.0f);
            path.close();
            this.f50847O.drawPath(path, this.f50845M);
        }
    }

    public void setData(final SADrainageModel sADrainageModel) {
        if (!(this.f50854V == null || sADrainageModel.getTips() == null)) {
            this.f50854V.setText(getSpanWithLabel(sADrainageModel.getTips(), ContextCompat.getDrawable(getContext(), R.drawable.drainage_icon_more)));
        }
        int i = R.drawable.drainage_didi_placehold;
        if (AppUtils.isBrazilApp(getContext())) {
            i = R.drawable.drainage_99_placehold;
        }
        ((RequestBuilder) ((RequestBuilder) Glide.with(getContext()).load(sADrainageModel.getImage()).placeholder(i)).error(i)).into(this.f50861ab);
        if (!TextUtils.isEmpty(sADrainageModel.getTips_action())) {
            this.f50858Z.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (SADrainageGuideBgViewTips.this.f50853U != null) {
                        SADrainageGuideBgViewTips.this.f50853U.onClick(view);
                    }
                    DRouter.build(sADrainageModel.getTips_action()).start();
                }
            });
        }
    }

    public SpannableStringBuilder getSpanWithLabel(String str, Drawable drawable) {
        drawable.setBounds(0, 0, UiUtils.dip2px(getContext(), 12.0f), UiUtils.dip2px(getContext(), 12.0f));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + "  ");
        spannableStringBuilder.setSpan(new SAVerticalImageSpan(drawable), spannableStringBuilder.length() + -1, spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }

    /* renamed from: c */
    private void m36497c() {
        int parseColor = Color.parseColor("#FF8040");
        int parseColor2 = Color.parseColor("#FF8040");
        Paint paint = new Paint();
        this.f50836D = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f50836D.setColor(parseColor);
        this.f50836D.setStrokeWidth(12.0f);
        this.f50836D.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f50837E = paint2;
        paint2.setAntiAlias(true);
        this.f50837E.setStyle(Paint.Style.STROKE);
        this.f50837E.setStrokeWidth(6.0f);
        this.f50837E.setAlpha(255);
        this.f50837E.setColor(parseColor2);
        Paint paint3 = new Paint();
        this.f50834B = paint3;
        paint3.setAntiAlias(true);
        this.f50834B.setStyle(Paint.Style.STROKE);
        this.f50834B.setStrokeWidth(6.0f);
        this.f50834B.setAlpha(51);
        this.f50834B.setColor(parseColor2);
        Bitmap copy = BitmapFactory.decodeResource(getResources(), R.drawable.arrow).copy(Bitmap.Config.ARGB_8888, true);
        int width = copy.getWidth();
        int height = copy.getHeight();
        float f = ((float) this.f50885y) / ((float) width);
        float f2 = ((float) this.f50886z) / ((float) height);
        Matrix matrix = new Matrix();
        if (this.f50842J == 1) {
            matrix.setRotate(180.0f);
        }
        matrix.postScale(f, f2);
        this.f50835C = Bitmap.createBitmap(copy, 0, 0, width, height, matrix, true);
        Paint paint4 = new Paint();
        this.f50841I = paint4;
        paint4.setColor(parseColor2);
        this.f50841I.setStyle(Paint.Style.FILL);
    }

    /* renamed from: b */
    private void m36496b(Canvas canvas) {
        float f;
        float f2;
        int i = this.f50864d;
        int i2 = this.f50863c;
        float f3 = (((float) (i - i2)) * 1.0f) / ((float) (this.f50865e - i2));
        int i3 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i3 > 0 && f3 <= 1.0f) {
            float f4 = this.f50866f;
            float f5 = f4 + ((this.f50867g - f4) * f3);
            int i4 = this.f50868h;
            float f6 = ((float) i4) + (((float) (this.f50869i - i4)) * f3);
            this.f50834B.setStrokeWidth((float) i);
            this.f50834B.setAlpha((int) f6);
            float f7 = this.f50838F;
            int i5 = this.f50862b;
            int i6 = this.f50864d;
            float f8 = this.f50839G;
            int i7 = this.f50859a;
            canvas.drawRoundRect(new RectF((f7 - ((float) i5)) - ((float) (i6 / 2)), (f8 - ((float) i7)) - ((float) (i6 / 2)), f7 + ((float) i5) + ((float) (i6 / 2)), f8 + ((float) i7) + ((float) (i6 / 2))), f5, f5, this.f50834B);
        } else if (f3 >= 1.0f) {
            float f9 = this.f50882v;
            if (f3 <= f9 + 1.0f) {
                float f10 = (f3 - 1.0f) / f9;
                int i8 = this.f50869i;
                this.f50834B.setAlpha((int) (((float) i8) + (((float) (this.f50870j - i8)) * f10)));
                float f11 = this.f50838F;
                int i9 = this.f50862b;
                int i10 = this.f50864d;
                float f12 = this.f50839G;
                int i11 = this.f50859a;
                RectF rectF = new RectF((f11 - ((float) i9)) - ((float) (i10 / 2)), (f12 - ((float) i11)) - ((float) (i10 / 2)), f11 + ((float) i9) + ((float) (i10 / 2)), f12 + ((float) i11) + ((float) (i10 / 2)));
                float f13 = this.f50867g;
                canvas.drawRoundRect(rectF, f13, f13, this.f50834B);
            }
        }
        float f14 = this.f50882v;
        if (f3 <= f14 || f3 >= f14 + 1.0f) {
            float f15 = this.f50882v;
            if (f3 >= f15 + 1.0f && f3 <= (f15 * 2.0f) + 1.0f) {
                float f16 = ((f3 - 1.0f) - f15) / f15;
                int i12 = this.f50877q;
                this.f50837E.setAlpha((int) (((float) i12) + (((float) (this.f50878r - i12)) * f16)));
                RectF rectF2 = new RectF(((this.f50838F - ((float) this.f50862b)) - ((float) ((this.f50864d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f50872l / 2)), ((this.f50839G - ((float) this.f50859a)) - ((float) ((this.f50864d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f50872l / 2)), this.f50838F + ((float) this.f50862b) + ((float) ((this.f50864d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f50872l / 2)), this.f50839G + ((float) this.f50859a) + ((float) ((this.f50864d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f50872l / 2)));
                float f17 = this.f50875o;
                canvas.drawRoundRect(rectF2, f17, f17, this.f50837E);
            }
        } else {
            float f18 = f3 - f14;
            int i13 = this.f50876p;
            float f19 = ((float) i13) + (((float) (this.f50877q - i13)) * f18);
            float f20 = this.f50874n;
            float f21 = f20 + ((this.f50875o - f20) * f18);
            this.f50837E.setStrokeWidth((float) this.f50872l);
            this.f50837E.setAlpha((int) f19);
            canvas.drawRoundRect(new RectF(((this.f50838F - ((float) this.f50862b)) - ((float) ((this.f50864d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f50872l / 2)), ((this.f50839G - ((float) this.f50859a)) - ((float) ((this.f50864d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f50872l / 2)), this.f50838F + ((float) this.f50862b) + ((float) ((this.f50864d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f50872l / 2)), this.f50839G + ((float) this.f50859a) + ((float) ((this.f50864d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f50872l / 2))), f21, f21, this.f50837E);
        }
        if (f3 <= 0.0f) {
            int i14 = this.f50884x;
            int i15 = this.f50883w;
            float f22 = (((float) (i14 - i15)) * ((f3 + 1.0f) / 1.0f)) + ((float) i15);
            if (this.f50842J == 1) {
                f2 = this.f50839G + ((float) this.f50859a) + f22;
            } else {
                f2 = ((this.f50839G - ((float) this.f50859a)) - f22) - ((float) this.f50835C.getHeight());
            }
            canvas.drawBitmap(this.f50835C, this.f50838F - ((float) (this.f50885y / 2)), f2, new Paint());
        } else if (i3 > 0) {
            int i16 = this.f50883w;
            int i17 = this.f50884x;
            float f23 = (((float) (i16 - i17)) * (f3 / ((this.f50882v * 2.0f) + 1.0f))) + ((float) i17);
            if (this.f50842J == 1) {
                f = this.f50839G + ((float) this.f50859a) + f23;
            } else {
                f = ((this.f50839G - ((float) this.f50859a)) - f23) - ((float) this.f50835C.getHeight());
            }
            canvas.drawBitmap(this.f50835C, this.f50838F - ((float) (this.f50885y / 2)), f, new Paint());
        }
        if (this.f50842J == 1) {
            float f24 = this.f50838F;
            float height = this.f50839G + ((float) this.f50859a) + ((float) this.f50884x) + ((float) this.f50835C.getHeight());
            int i18 = this.f50833A;
            canvas.drawCircle(f24, height + ((float) (i18 * 2)), (float) i18, this.f50841I);
            float f25 = this.f50838F;
            float height2 = this.f50839G + ((float) this.f50859a) + ((float) this.f50884x) + ((float) this.f50835C.getHeight());
            int i19 = this.f50833A;
            canvas.drawCircle(f25, height2 + ((float) (i19 * 5)), (float) i19, this.f50841I);
            float f26 = this.f50838F;
            float height3 = this.f50839G + ((float) this.f50859a) + ((float) this.f50884x) + ((float) this.f50835C.getHeight());
            int i20 = this.f50833A;
            canvas.drawCircle(f26, height3 + ((float) (i20 * 8)), (float) i20, this.f50841I);
        } else {
            float f27 = this.f50838F;
            float height4 = ((this.f50839G - ((float) this.f50859a)) - ((float) this.f50884x)) - ((float) this.f50835C.getHeight());
            int i21 = this.f50833A;
            canvas.drawCircle(f27, height4 - ((float) (i21 * 2)), (float) i21, this.f50841I);
            float f28 = this.f50838F;
            float height5 = ((this.f50839G - ((float) this.f50859a)) - ((float) this.f50884x)) - ((float) this.f50835C.getHeight());
            int i22 = this.f50833A;
            canvas.drawCircle(f28, height5 - ((float) (i22 * 5)), (float) i22, this.f50841I);
            float f29 = this.f50838F;
            float height6 = ((this.f50839G - ((float) this.f50859a)) - ((float) this.f50884x)) - ((float) this.f50835C.getHeight());
            int i23 = this.f50833A;
            canvas.drawCircle(f29, height6 - ((float) (i23 * 8)), (float) i23, this.f50841I);
        }
        this.f50864d += UiUtils.dip2px(getContext(), 1.0f);
        if (f3 > (this.f50882v * 2.0f) + 1.0f) {
            this.f50864d = -UiUtils.dip2px(getContext(), 9.0f);
        }
        postInvalidateDelayed((long) this.f50840H);
    }
}
