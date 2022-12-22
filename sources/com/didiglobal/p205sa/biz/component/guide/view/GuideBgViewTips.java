package com.didiglobal.p205sa.biz.component.guide.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideBgViewTips */
public class GuideBgViewTips extends RelativeLayout implements IGuideInterface {

    /* renamed from: a */
    private int f50943a;

    /* renamed from: b */
    private RectF f50944b = new RectF();

    /* renamed from: c */
    private Paint f50945c;

    /* renamed from: d */
    private Paint f50946d;

    /* renamed from: e */
    private Bitmap f50947e;

    /* renamed from: f */
    private Canvas f50948f;

    /* renamed from: g */
    private int f50949g;

    /* renamed from: h */
    private int[] f50950h;

    /* renamed from: i */
    private Rect f50951i;

    /* renamed from: j */
    private int f50952j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View.OnClickListener f50953k;

    /* renamed from: l */
    private TextView f50954l;

    /* renamed from: m */
    private Button f50955m;

    /* renamed from: n */
    private float f50956n;

    /* renamed from: o */
    private float f50957o;

    /* renamed from: p */
    private Rect f50958p = new Rect();

    /* renamed from: q */
    private View f50959q;

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideBgViewTips$TipType */
    public @interface TipType {
        public static final int Tip_bottom = 1;
        public static final int Tip_top = 0;
    }

    public void setVisiblePaddings(Rect rect) {
        this.f50958p = rect;
    }

    public GuideBgViewTips(Context context, int i) {
        super(context);
        this.f50943a = i;
        m36519a();
    }

    /* renamed from: a */
    private void m36519a() {
        setBackgroundResource(R.color.transparent);
        this.f50949g = (int) getContext().getResources().getDimension(R.dimen.view_radius);
        int dimension = (int) getContext().getResources().getDimension(R.dimen.view_bg_radius);
        this.f50952j = dimension;
        int i = dimension * 2;
        this.f50950h = new int[]{i, i, i, i};
        getContext().getResources().getDimension(R.dimen.view_bg_content);
        this.f50959q = LayoutInflater.from(getContext()).inflate(R.layout.sa_guide_text, (ViewGroup) null);
        addView(this.f50959q, new RelativeLayout.LayoutParams(-1, -2));
        Button button = (Button) findViewById(R.id.guide_get);
        this.f50955m = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GuideBgViewTips.this.f50953k != null) {
                    GuideBgViewTips.this.f50953k.onClick(view);
                }
            }
        });
        this.f50954l = (TextView) findViewById(R.id.guide_tip);
    }

    public void setOnGetClickListener(View.OnClickListener onClickListener) {
        this.f50953k = onClickListener;
    }

    public void setmAllBgDiameter(int[] iArr) {
        this.f50950h = iArr;
    }

    public int getmTipType() {
        return this.f50943a;
    }

    public void setGuideTips(String str) {
        TextView textView = this.f50954l;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setBtnText(String str) {
        Button button = this.f50955m;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setHightLightPos(RectF rectF) {
        this.f50944b = rectF;
        this.f50956n = rectF.bottom - rectF.top;
        this.f50957o = rectF.right - rectF.left;
        View view = this.f50959q;
        if (view != null && view.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f50959q.getLayoutParams();
            int i = this.f50943a;
            if (i == 1) {
                layoutParams.setMargins(0, ((((int) this.f50956n) - this.f50958p.top) - this.f50958p.bottom) + this.f50951i.top, 0, 0);
            } else if (i == 0) {
                layoutParams.addRule(10);
            }
        }
    }

    public void setMargin(Rect rect) {
        this.f50951i = rect;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m36520a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) ((((this.f50956n + ((float) this.f50951i.bottom)) + ((float) this.f50959q.getMeasuredHeight())) - ((float) this.f50958p.top)) - ((float) this.f50958p.bottom)));
    }

    /* renamed from: a */
    private void m36520a(Canvas canvas) {
        if (this.f50945c == null) {
            this.f50945c = new Paint();
            this.f50945c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            this.f50945c.setAntiAlias(true);
        }
        if (canvas.getWidth() > 0 && canvas.getHeight() > 0) {
            if (this.f50947e == null) {
                this.f50947e = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                this.f50948f = new Canvas(this.f50947e);
            }
            if (this.f50946d == null) {
                Paint paint = new Paint();
                this.f50946d = paint;
                paint.setShader(new LinearGradient(0.0f, 0.0f, (float) canvas.getWidth(), 0.0f, Color.parseColor("#FF8F40"), Color.parseColor("#FF7040"), Shader.TileMode.CLAMP));
                this.f50946d.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f50946d.setStrokeWidth(1.0f);
            }
            m36521b();
            int i = this.f50943a;
            if (i == 1) {
                this.f50944b.left = (float) this.f50951i.left;
                RectF rectF = this.f50944b;
                rectF.right = ((rectF.left + this.f50957o) - ((float) this.f50958p.left)) - ((float) this.f50958p.right);
                this.f50944b.top = (float) this.f50951i.top;
                this.f50944b.bottom = ((this.f50956n + ((float) this.f50951i.top)) - ((float) this.f50958p.top)) - ((float) this.f50958p.bottom);
            } else if (i == 0) {
                this.f50944b.left = (float) this.f50951i.left;
                RectF rectF2 = this.f50944b;
                rectF2.right = ((rectF2.left + this.f50957o) - ((float) this.f50958p.left)) - ((float) this.f50958p.right);
                this.f50944b.top = (((float) (getHeight() - this.f50951i.bottom)) - this.f50956n) + ((float) this.f50958p.top) + ((float) this.f50958p.bottom);
                this.f50944b.bottom = (float) (getHeight() - this.f50951i.bottom);
            }
            Canvas canvas2 = this.f50948f;
            RectF rectF3 = this.f50944b;
            int i2 = this.f50949g;
            canvas2.drawRoundRect(rectF3, (float) i2, (float) i2, this.f50945c);
            canvas.drawBitmap(this.f50947e, 0.0f, 0.0f, this.f50946d);
        }
    }

    /* renamed from: b */
    private void m36521b() {
        int[] iArr = this.f50950h;
        if (iArr != null && iArr.length >= 4) {
            Path path = new Path();
            path.moveTo((float) this.f50950h[0], 0.0f);
            path.lineTo((float) (this.f50948f.getWidth() - this.f50950h[1]), 0.0f);
            path.arcTo(new RectF((float) (this.f50948f.getWidth() - this.f50950h[1]), 0.0f, (float) this.f50948f.getWidth(), (float) this.f50950h[1]), -90.0f, 90.0f);
            path.lineTo((float) this.f50948f.getWidth(), (float) (getHeight() - this.f50950h[2]));
            path.arcTo(new RectF((float) (this.f50948f.getWidth() - this.f50950h[2]), (float) (getHeight() - this.f50950h[2]), (float) this.f50948f.getWidth(), (float) getHeight()), 0.0f, 90.0f);
            path.lineTo((float) this.f50950h[3], (float) getHeight());
            int height = getHeight();
            int[] iArr2 = this.f50950h;
            path.arcTo(new RectF(0.0f, (float) (height - iArr2[3]), (float) iArr2[3], (float) getHeight()), 90.0f, 90.0f);
            path.lineTo(0.0f, (float) this.f50950h[0]);
            int[] iArr3 = this.f50950h;
            path.arcTo(new RectF(0.0f, 0.0f, (float) iArr3[0], (float) iArr3[0]), 180.0f, 90.0f);
            path.close();
            this.f50948f.drawPath(path, this.f50946d);
        }
    }
}
