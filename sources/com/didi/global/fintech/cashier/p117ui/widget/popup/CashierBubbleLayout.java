package com.didi.global.fintech.cashier.p117ui.widget.popup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.global.fintech.cashier.p117ui.kts.ContextKtxKt;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.CashierBubbleLayout */
public class CashierBubbleLayout extends LinearLayout {

    /* renamed from: a */
    private static final String f21930a = "[arrow]";

    /* renamed from: d */
    private static final int f21931d = 2;

    /* renamed from: s */
    private static final int f21932s = 5;

    /* renamed from: b */
    private Context f21933b;

    /* renamed from: c */
    private int f21934c;

    /* renamed from: e */
    private int f21935e;

    /* renamed from: f */
    private Point f21936f;

    /* renamed from: g */
    private int f21937g;

    /* renamed from: h */
    private int f21938h;

    /* renamed from: i */
    private int f21939i;

    /* renamed from: j */
    private Paint f21940j;

    /* renamed from: k */
    private Path f21941k;

    /* renamed from: l */
    private RectF f21942l;

    /* renamed from: m */
    private TextView f21943m;
    public String mDirection;

    /* renamed from: n */
    private ImageView f21944n;

    /* renamed from: o */
    private FrameLayout f21945o;

    /* renamed from: p */
    private int f21946p = 0;

    /* renamed from: q */
    private int f21947q = 0;

    /* renamed from: r */
    private int f21948r = 0;

    /* renamed from: t */
    private float f21949t;

    /* renamed from: u */
    private float f21950u;

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.CashierBubbleLayout$Direction */
    public @interface Direction {
    }

    /* renamed from: c */
    private boolean m15878c(int i, int i2) {
        return i <= i2 + 5;
    }

    public CashierBubbleLayout(Context context) {
        super(context);
        this.f21933b = context;
        this.f21934c = context.getResources().getDimensionPixelOffset(R.dimen.g_payment_bubble_default_offset);
        this.f21937g = context.getResources().getDimensionPixelOffset(R.dimen.g_payment_bubble_triangle_width);
        this.f21938h = context.getResources().getDimensionPixelOffset(R.dimen.g_payment_bubble_triangle_height);
        this.f21935e = context.getResources().getDimensionPixelOffset(R.dimen.g_payment_bubble_default_radius);
        m15872a();
    }

    /* access modifiers changed from: package-private */
    public void setCloseBtnVisible(boolean z) {
        this.f21944n.setVisibility(z ? 0 : 8);
    }

    /* renamed from: a */
    private void m15872a() {
        Paint paint = new Paint();
        this.f21940j = paint;
        paint.setAntiAlias(true);
        this.f21941k = new Path();
        this.f21942l = new RectF();
        this.f21936f = new Point();
        setWillNotDraw(false);
        inflate(this.f21933b, R.layout.global_cashier_layout_bubble, this);
        this.f21943m = (TextView) findViewById(R.id.center_text);
        this.f21944n = (ImageView) findViewById(R.id.close_btn);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.left_icon);
        this.f21945o = frameLayout;
        frameLayout.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void setCloseClickListener(View.OnClickListener onClickListener) {
        this.f21944n.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setText(String str) {
        this.f21943m.setText(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66227a(int i, int i2, int i3) {
        if (i > 0) {
            this.f21943m.setTextSize(2, (float) i);
        }
        if ((i2 & i3) == 1) {
            this.f21943m.setTypeface(Typeface.SANS_SERIF, 3);
        } else if (i2 == 1) {
            this.f21943m.setTypeface(Typeface.SANS_SERIF, 1);
        } else if (i3 == 1) {
            this.f21943m.setTypeface(Typeface.SANS_SERIF, 2);
        }
    }

    /* access modifiers changed from: package-private */
    public void setTypeface(int i) {
        this.f21943m.setTypeface(Typeface.SANS_SERIF, i);
    }

    /* access modifiers changed from: package-private */
    public void setMaxLines(int i) {
        this.f21946p = i;
        this.f21943m.setMaxLines(i);
        this.f21943m.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    }

    /* access modifiers changed from: package-private */
    public void setLeftDrawable(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f21945o.getChildCount() > 0) {
                this.f21945o.removeAllViews();
            }
            this.f21945o.setVisibility(0);
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f21945o.addView(imageView);
            Glide.with(this.f21933b).load(str).into(imageView);
        }
    }

    /* access modifiers changed from: package-private */
    public void setLeftView(View view) {
        if (view != null) {
            if (this.f21945o.getChildCount() > 0) {
                this.f21945o.removeAllViews();
            }
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f21945o.addView(view);
            this.f21945o.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66228a(View view, int i, int i2) {
        if (view != null && i > -2 && i2 > -2) {
            if (this.f21945o.getChildCount() > 0) {
                this.f21945o.removeAllViews();
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f21945o.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.f21945o.setLayoutParams(layoutParams);
            this.f21945o.requestLayout();
            this.f21945o.addView(view);
            this.f21945o.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void setLeftDrawable(int i) {
        try {
            if (this.f21945o.getChildCount() > 0) {
                this.f21945o.removeAllViews();
            }
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f21945o.addView(imageView);
            imageView.setImageDrawable(getResources().getDrawable(i));
            this.f21945o.setVisibility(0);
        } catch (Exception e) {
            e.printStackTrace();
            this.f21945o.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66226a(int i, int i2) {
        this.f21947q = i;
        this.f21948r = i2;
        setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
    }

    public void setBubbleBackgroundColor(int i) {
        this.f21940j.setColor(i);
    }

    public void setBubbleBackgroundColor(String str) {
        try {
            this.f21940j.setColor(Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66229a(String str, int i) {
        this.mDirection = str.replace("left", "right");
        this.f21939i = i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0063, code lost:
        r3 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009a, code lost:
        r3 = (float) (-r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b4, code lost:
        r3 = ((float) r3) / 2.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
        m15873a(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setPivot(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            switch(r0) {
                case -1699597560: goto L_0x0052;
                case -1383228885: goto L_0x0048;
                case -966253391: goto L_0x003d;
                case -609197669: goto L_0x0033;
                case 115029: goto L_0x0028;
                case 3317767: goto L_0x001e;
                case 108511772: goto L_0x0013;
                case 116576946: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x005c
        L_0x0008:
            java.lang.String r0 = "top_right"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 5
            goto L_0x005d
        L_0x0013:
            java.lang.String r0 = "right"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 2
            goto L_0x005d
        L_0x001e:
            java.lang.String r0 = "left"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 0
            goto L_0x005d
        L_0x0028:
            java.lang.String r0 = "top"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 1
            goto L_0x005d
        L_0x0033:
            java.lang.String r0 = "bottom_left"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 6
            goto L_0x005d
        L_0x003d:
            java.lang.String r0 = "top_left"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 4
            goto L_0x005d
        L_0x0048:
            java.lang.String r0 = "bottom"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 3
            goto L_0x005d
        L_0x0052:
            java.lang.String r0 = "bottom_right"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 7
            goto L_0x005d
        L_0x005c:
            r3 = -1
        L_0x005d:
            r0 = 0
            r1 = 1073741824(0x40000000, float:2.0)
            switch(r3) {
                case 0: goto L_0x00b0;
                case 1: goto L_0x00a8;
                case 2: goto L_0x009d;
                case 3: goto L_0x008f;
                case 4: goto L_0x0087;
                case 5: goto L_0x007a;
                case 6: goto L_0x0072;
                case 7: goto L_0x0065;
                default: goto L_0x0063;
            }
        L_0x0063:
            r3 = 0
            goto L_0x00b6
        L_0x0065:
            int r3 = r2.getLayoutWidth()
            int r0 = r2.f21934c
            int r3 = r3 - r0
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x009a
        L_0x0072:
            int r3 = r2.f21934c
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x009a
        L_0x007a:
            int r3 = r2.getLayoutWidth()
            int r0 = r2.f21934c
            int r3 = r3 - r0
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x00b4
        L_0x0087:
            int r3 = r2.f21934c
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x00b4
        L_0x008f:
            int r3 = r2.getWidth()
            float r3 = (float) r3
            float r0 = r3 / r1
            int r3 = r2.getLayoutHeight()
        L_0x009a:
            int r3 = -r3
            float r3 = (float) r3
            goto L_0x00b6
        L_0x009d:
            int r3 = r2.getLayoutWidth()
            int r3 = -r3
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x00b4
        L_0x00a8:
            int r3 = r2.getLayoutWidth()
            float r3 = (float) r3
            float r3 = r3 / r1
            r0 = r3
            goto L_0x0063
        L_0x00b0:
            int r3 = r2.getLayoutHeight()
        L_0x00b4:
            float r3 = (float) r3
            float r3 = r3 / r1
        L_0x00b6:
            r2.m15873a((float) r0, (float) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.widget.popup.CashierBubbleLayout.setPivot(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0074, code lost:
        m15876b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        m15876b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007a, code lost:
        m15879d(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007d, code lost:
        m15879d(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008d, code lost:
        m15880e(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r4) {
        /*
            r3 = this;
            super.onDraw(r4)
            android.graphics.Point r0 = r3.f21936f
            int r0 = r0.x
            if (r0 <= 0) goto L_0x0090
            android.graphics.Point r0 = r3.f21936f
            int r0 = r0.y
            if (r0 <= 0) goto L_0x0090
            java.lang.String r0 = r3.mDirection
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case -1699597560: goto L_0x0064;
                case -1383228885: goto L_0x005a;
                case -966253391: goto L_0x004f;
                case -609197669: goto L_0x0045;
                case 115029: goto L_0x003a;
                case 3317767: goto L_0x0030;
                case 108511772: goto L_0x0025;
                case 116576946: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x006d
        L_0x001a:
            java.lang.String r2 = "top_right"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 5
            goto L_0x006d
        L_0x0025:
            java.lang.String r2 = "right"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 2
            goto L_0x006d
        L_0x0030:
            java.lang.String r2 = "left"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 0
            goto L_0x006d
        L_0x003a:
            java.lang.String r2 = "top"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 1
            goto L_0x006d
        L_0x0045:
            java.lang.String r2 = "bottom_left"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 6
            goto L_0x006d
        L_0x004f:
            java.lang.String r2 = "top_left"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 4
            goto L_0x006d
        L_0x005a:
            java.lang.String r2 = "bottom"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 3
            goto L_0x006d
        L_0x0064:
            java.lang.String r2 = "bottom_right"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 7
        L_0x006d:
            switch(r1) {
                case 0: goto L_0x0089;
                case 1: goto L_0x0085;
                case 2: goto L_0x0081;
                case 3: goto L_0x0071;
                case 4: goto L_0x0074;
                case 5: goto L_0x0077;
                case 6: goto L_0x007a;
                case 7: goto L_0x007d;
                default: goto L_0x0070;
            }
        L_0x0070:
            goto L_0x008d
        L_0x0071:
            r3.m15879d(r4)
        L_0x0074:
            r3.m15876b(r4)
        L_0x0077:
            r3.m15876b(r4)
        L_0x007a:
            r3.m15879d(r4)
        L_0x007d:
            r3.m15879d(r4)
            goto L_0x008d
        L_0x0081:
            r3.m15877c(r4)
            goto L_0x0090
        L_0x0085:
            r3.m15876b(r4)
            goto L_0x0090
        L_0x0089:
            r3.m15874a(r4)
            goto L_0x0090
        L_0x008d:
            r3.m15880e(r4)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.widget.popup.CashierBubbleLayout.onDraw(android.graphics.Canvas):void");
    }

    /* renamed from: a */
    private void m15873a(float f, float f2) {
        this.f21949t = f;
        this.f21950u = f2;
    }

    /* renamed from: a */
    private void m15874a(Canvas canvas) {
        Path path = this.f21941k;
        RectF rectF = this.f21942l;
        int i = this.f21935e;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
        this.f21941k.moveTo((float) (this.f21936f.x + 2), ((float) this.f21936f.y) - (((float) this.f21937g) / 2.0f));
        this.f21941k.lineTo(((float) this.f21936f.x) - (((float) this.f21938h) / 2.0f), (float) this.f21936f.y);
        this.f21941k.lineTo((float) (this.f21936f.x + 2), ((float) this.f21936f.y) + (((float) this.f21937g) / 2.0f));
        this.f21941k.close();
        canvas.drawPath(this.f21941k, this.f21940j);
    }

    /* renamed from: b */
    private void m15876b(Canvas canvas) {
        Path path = this.f21941k;
        RectF rectF = this.f21942l;
        int i = this.f21935e;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
        this.f21941k.moveTo(((float) this.f21936f.x) + (((float) this.f21938h) / 2.0f), (float) this.f21936f.y);
        this.f21941k.lineTo((float) this.f21936f.x, ((float) this.f21936f.y) - (((float) this.f21937g) / 2.0f));
        this.f21941k.lineTo(((float) this.f21936f.x) - (((float) this.f21938h) / 2.0f), (float) this.f21936f.y);
        this.f21941k.close();
        canvas.drawPath(this.f21941k, this.f21940j);
    }

    /* renamed from: c */
    private void m15877c(Canvas canvas) {
        Path path = this.f21941k;
        RectF rectF = this.f21942l;
        int i = this.f21935e;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CW);
        this.f21941k.moveTo((float) (this.f21936f.x - 2), ((float) this.f21936f.y) - (((float) this.f21937g) / 2.0f));
        this.f21941k.lineTo(((float) this.f21936f.x) + (((float) this.f21937g) / 2.0f), (float) this.f21936f.y);
        this.f21941k.lineTo((float) (this.f21936f.x - 2), ((float) this.f21936f.y) + (((float) this.f21937g) / 2.0f));
        this.f21941k.close();
        canvas.drawPath(this.f21941k, this.f21940j);
    }

    /* renamed from: d */
    private void m15879d(Canvas canvas) {
        Path path = this.f21941k;
        RectF rectF = this.f21942l;
        int i = this.f21935e;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
        this.f21941k.moveTo(((float) this.f21936f.x) + (((float) this.f21938h) / 2.0f), (float) this.f21936f.y);
        this.f21941k.lineTo((float) this.f21936f.x, ((float) this.f21936f.y) + (((float) this.f21937g) / 2.0f));
        this.f21941k.lineTo(((float) this.f21936f.x) - (((float) this.f21938h) / 2.0f), (float) this.f21936f.y);
        this.f21941k.close();
        canvas.drawPath(this.f21941k, this.f21940j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66230b(int i, int i2) {
        this.f21938h = i2;
        this.f21937g = i;
    }

    /* renamed from: e */
    private void m15880e(Canvas canvas) {
        if (getPaddingBottom() != 0) {
            Path path = this.f21941k;
            RectF rectF = this.f21942l;
            int i = this.f21935e;
            path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
            this.f21941k.close();
            canvas.drawPath(this.f21941k, this.f21940j);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSizeChanged(int r2, int r3, int r4, int r5) {
        /*
            r1 = this;
            super.onSizeChanged(r2, r3, r4, r5)
            android.graphics.RectF r4 = r1.f21942l
            int r5 = r1.getPaddingLeft()
            float r5 = (float) r5
            r4.left = r5
            android.graphics.RectF r4 = r1.f21942l
            int r5 = r1.getPaddingTop()
            float r5 = (float) r5
            r4.top = r5
            android.graphics.RectF r4 = r1.f21942l
            int r5 = r1.getPaddingRight()
            int r5 = r2 - r5
            float r5 = (float) r5
            r4.right = r5
            android.graphics.RectF r4 = r1.f21942l
            int r5 = r1.getPaddingBottom()
            int r5 = r3 - r5
            float r5 = (float) r5
            r4.bottom = r5
            java.lang.String r4 = r1.mDirection
            int r5 = r4.hashCode()
            r0 = 2
            switch(r5) {
                case -1699597560: goto L_0x0080;
                case -1383228885: goto L_0x0076;
                case -966253391: goto L_0x006b;
                case -609197669: goto L_0x0061;
                case 115029: goto L_0x0056;
                case 3317767: goto L_0x004c;
                case 108511772: goto L_0x0041;
                case 116576946: goto L_0x0036;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x008a
        L_0x0036:
            java.lang.String r5 = "top_right"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 5
            goto L_0x008b
        L_0x0041:
            java.lang.String r5 = "right"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 2
            goto L_0x008b
        L_0x004c:
            java.lang.String r5 = "left"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 0
            goto L_0x008b
        L_0x0056:
            java.lang.String r5 = "top"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 1
            goto L_0x008b
        L_0x0061:
            java.lang.String r5 = "bottom_left"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 6
            goto L_0x008b
        L_0x006b:
            java.lang.String r5 = "top_left"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 4
            goto L_0x008b
        L_0x0076:
            java.lang.String r5 = "bottom"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 3
            goto L_0x008b
        L_0x0080:
            java.lang.String r5 = "bottom_right"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 7
            goto L_0x008b
        L_0x008a:
            r4 = -1
        L_0x008b:
            switch(r4) {
                case 0: goto L_0x00fc;
                case 1: goto L_0x00ee;
                case 2: goto L_0x00df;
                case 3: goto L_0x00d0;
                case 4: goto L_0x00c1;
                case 5: goto L_0x00b1;
                case 6: goto L_0x00a1;
                case 7: goto L_0x0090;
                default: goto L_0x008e;
            }
        L_0x008e:
            goto L_0x0109
        L_0x0090:
            android.graphics.Point r4 = r1.f21936f
            int r5 = r1.f21934c
            int r2 = r2 - r5
            r4.x = r2
            android.graphics.Point r2 = r1.f21936f
            int r4 = r1.getPaddingBottom()
            int r3 = r3 - r4
            r2.y = r3
            goto L_0x0109
        L_0x00a1:
            android.graphics.Point r2 = r1.f21936f
            int r4 = r1.f21934c
            r2.x = r4
            android.graphics.Point r2 = r1.f21936f
            int r4 = r1.getPaddingBottom()
            int r3 = r3 - r4
            r2.y = r3
            goto L_0x0109
        L_0x00b1:
            android.graphics.Point r3 = r1.f21936f
            int r4 = r1.f21934c
            int r2 = r2 - r4
            r3.x = r2
            android.graphics.Point r2 = r1.f21936f
            int r3 = r1.getPaddingTop()
            r2.y = r3
            goto L_0x0109
        L_0x00c1:
            android.graphics.Point r2 = r1.f21936f
            int r3 = r1.f21934c
            r2.x = r3
            android.graphics.Point r2 = r1.f21936f
            int r3 = r1.getPaddingTop()
            r2.y = r3
            goto L_0x0109
        L_0x00d0:
            android.graphics.Point r4 = r1.f21936f
            int r2 = r2 / r0
            r4.x = r2
            android.graphics.Point r2 = r1.f21936f
            int r4 = r1.getPaddingBottom()
            int r3 = r3 - r4
            r2.y = r3
            goto L_0x0109
        L_0x00df:
            android.graphics.Point r4 = r1.f21936f
            int r5 = r1.getPaddingRight()
            int r2 = r2 - r5
            r4.x = r2
            android.graphics.Point r2 = r1.f21936f
            int r3 = r3 / r0
            r2.y = r3
            goto L_0x0109
        L_0x00ee:
            android.graphics.Point r3 = r1.f21936f
            int r2 = r2 / r0
            r3.x = r2
            android.graphics.Point r2 = r1.f21936f
            int r3 = r1.getPaddingTop()
            r2.y = r3
            goto L_0x0109
        L_0x00fc:
            android.graphics.Point r2 = r1.f21936f
            int r4 = r1.getPaddingLeft()
            r2.x = r4
            android.graphics.Point r2 = r1.f21936f
            int r3 = r3 / r0
            r2.y = r3
        L_0x0109:
            int r2 = r1.f21939i
            if (r2 == 0) goto L_0x0110
            r1.m15875b()
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.widget.popup.CashierBubbleLayout.onSizeChanged(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int getLayoutWidth() {
        int dp2px = ContextKtxKt.dp2px(this.f21933b, 27);
        if (this.f21945o.getVisibility() == 0) {
            dp2px += ContextKtxKt.dp2px(this.f21933b, 24);
        }
        if (this.f21944n.getVisibility() == 0) {
            dp2px += ContextKtxKt.dp2px(this.f21933b, 25);
        }
        int textSize = (int) (((float) dp2px) + (this.f21943m.getTextSize() * ((float) this.f21943m.getText().length())));
        String name = CashierBubbleLayout.class.getName();
        SystemUtils.log(6, name, "getLayoutWidth: " + textSize, (Throwable) null, "com.didi.global.fintech.cashier.ui.widget.popup.CashierBubbleLayout", 438);
        return textSize;
    }

    /* access modifiers changed from: package-private */
    public int getLayoutHeight() {
        int dp2px = (int) (((float) (ContextKtxKt.dp2px(this.f21933b, 11) * 2)) + this.f21943m.getTextSize());
        String name = CashierBubbleLayout.class.getName();
        SystemUtils.log(6, name, "getLayoutWidth: " + dp2px, (Throwable) null, "com.didi.global.fintech.cashier.ui.widget.popup.CashierBubbleLayout", 444);
        return dp2px;
    }

    /* access modifiers changed from: package-private */
    public int[] getMeasureWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int i2 = this.f21947q;
        if (i2 <= 0 || (i = this.f21948r) <= 0) {
            measure(0, 0);
            int measuredWidth = getMeasuredWidth();
            int i3 = getResources().getDisplayMetrics().widthPixels;
            if (measuredWidth > i3) {
                measuredWidth = i3;
            }
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth >= i3) {
                int i4 = (i3 / measuredWidth) + (i3 % measuredWidth) > 0 ? 1 : 0;
                int i5 = this.f21946p;
                if (i5 > 0 && i5 < i4) {
                    i4 = i5;
                }
                measuredHeight *= i4;
            }
            int measuredHeight2 = this.f21945o.getMeasuredHeight();
            int measuredHeight3 = this.f21943m.getMeasuredHeight();
            int measuredHeight4 = this.f21944n.getMeasuredHeight();
            if (m15878c(measuredHeight2, measuredHeight3) && m15878c(measuredHeight4, measuredHeight3)) {
                measuredHeight += ContextKtxKt.dp2px(this.f21933b, 10) * 2;
            }
            iArr[0] = measuredWidth;
            iArr[1] = measuredHeight;
            return iArr;
        }
        iArr[0] = i2;
        iArr[1] = i;
        return iArr;
    }

    public void setTriangleOffset(int i) {
        this.f21939i = i;
        m15875b();
        invalidate();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15875b() {
        /*
            r3 = this;
            java.lang.String r0 = r3.mDirection
            int r1 = r0.hashCode()
            switch(r1) {
                case -1699597560: goto L_0x0054;
                case -1383228885: goto L_0x004a;
                case -966253391: goto L_0x003f;
                case -609197669: goto L_0x0035;
                case 115029: goto L_0x002a;
                case 3317767: goto L_0x0020;
                case 108511772: goto L_0x0015;
                case 116576946: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x005e
        L_0x000a:
            java.lang.String r1 = "top_right"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 5
            goto L_0x005f
        L_0x0015:
            java.lang.String r1 = "right"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 1
            goto L_0x005f
        L_0x0020:
            java.lang.String r1 = "left"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 0
            goto L_0x005f
        L_0x002a:
            java.lang.String r1 = "top"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 2
            goto L_0x005f
        L_0x0035:
            java.lang.String r1 = "bottom_left"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 6
            goto L_0x005f
        L_0x003f:
            java.lang.String r1 = "top_left"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 4
            goto L_0x005f
        L_0x004a:
            java.lang.String r1 = "bottom"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 3
            goto L_0x005f
        L_0x0054:
            java.lang.String r1 = "bottom_right"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 7
            goto L_0x005f
        L_0x005e:
            r0 = -1
        L_0x005f:
            switch(r0) {
                case 0: goto L_0x006d;
                case 1: goto L_0x006d;
                case 2: goto L_0x0063;
                case 3: goto L_0x0063;
                case 4: goto L_0x0063;
                case 5: goto L_0x0063;
                case 6: goto L_0x0063;
                case 7: goto L_0x0063;
                default: goto L_0x0062;
            }
        L_0x0062:
            goto L_0x0076
        L_0x0063:
            android.graphics.Point r0 = r3.f21936f
            int r1 = r0.x
            int r2 = r3.f21939i
            int r1 = r1 + r2
            r0.x = r1
            goto L_0x0076
        L_0x006d:
            android.graphics.Point r0 = r3.f21936f
            int r1 = r0.y
            int r2 = r3.f21939i
            int r1 = r1 + r2
            r0.y = r1
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.widget.popup.CashierBubbleLayout.m15875b():void");
    }

    /* access modifiers changed from: package-private */
    public float[] getPivot() {
        return new float[]{this.f21949t, this.f21950u};
    }
}
