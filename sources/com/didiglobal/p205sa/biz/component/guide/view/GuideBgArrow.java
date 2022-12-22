package com.didiglobal.p205sa.biz.component.guide.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.UIUtils;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideBgArrow */
public class GuideBgArrow extends RelativeLayout implements IGuideInterface {

    /* renamed from: a */
    int f50935a = UIUtils.dip2pxInt(getContext(), 8.0f);

    /* renamed from: b */
    int f50936b = UIUtils.dip2pxInt(getContext(), 12.0f);

    /* renamed from: c */
    int f50937c = UIUtils.dip2pxInt(getContext(), 60.0f);

    /* renamed from: d */
    int f50938d = 200;

    /* renamed from: e */
    private int f50939e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f50940f;

    /* renamed from: g */
    private TextView f50941g;

    /* renamed from: h */
    private Button f50942h;

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideBgArrow$ArrowType */
    public @interface ArrowType {
        public static final int arrow_bottom = 1;
        public static final int arrow_top = 0;
    }

    public GuideBgArrow(Context context, int i) {
        super(context);
        this.f50939e = i;
        m36515a();
    }

    /* renamed from: a */
    private void m36515a() {
        setBackgroundColor(0);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sa_guide_text, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        addView(inflate, layoutParams);
        Button button = (Button) findViewById(R.id.guide_get);
        this.f50942h = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GuideBgArrow.this.f50940f != null) {
                    GuideBgArrow.this.f50940f.onClick(view);
                }
            }
        });
        this.f50941g = (TextView) findViewById(R.id.guide_tip);
        ViewGroup.LayoutParams layoutParams2 = findViewById(R.id.tips_container).getLayoutParams();
        if (layoutParams2 != null && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
            int i = this.f50939e;
            if (i == 0) {
                ((RelativeLayout.LayoutParams) layoutParams2).setMargins(0, this.f50935a, 0, 0);
            } else if (i == 1) {
                ((RelativeLayout.LayoutParams) layoutParams2).setMargins(0, 0, 0, this.f50935a);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setBtnText(String str) {
        Button button = this.f50942h;
        if (button != null) {
            button.setText(str);
        }
    }

    public int getArrowPos() {
        return this.f50938d;
    }

    public void setArrowPos(int i) {
        this.f50938d = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f50939e;
        if (i == 1) {
            m36516a(canvas);
        } else if (i == 0) {
            m36517b(canvas);
        }
    }

    /* renamed from: a */
    private void m36516a(Canvas canvas) {
        Path path = new Path();
        int i = this.f50935a;
        path.moveTo(0.0f, (float) this.f50937c);
        int i2 = this.f50937c;
        path.arcTo(new RectF(0.0f, 0.0f, (float) i2, (float) i2), 180.0f, 90.0f);
        path.lineTo((float) (getWidth() - this.f50937c), 0.0f);
        path.arcTo(new RectF((float) (getWidth() - this.f50937c), 0.0f, (float) getWidth(), (float) this.f50937c), -90.0f, 90.0f);
        path.lineTo((float) getWidth(), (float) ((getHeight() - this.f50937c) - i));
        path.arcTo(new RectF((float) (getWidth() - this.f50937c), (float) ((getHeight() - this.f50937c) - i), (float) getWidth(), (float) (getHeight() - i)), 0.0f, 90.0f);
        path.lineTo((float) this.f50938d, (float) (getHeight() - i));
        path.lineTo((float) (this.f50938d + (this.f50936b / 2)), (float) getHeight());
        path.lineTo((float) (this.f50938d + this.f50936b), (float) (getHeight() - i));
        path.lineTo((float) this.f50937c, (float) (getHeight() - i));
        int height = getHeight();
        int i3 = this.f50937c;
        path.arcTo(new RectF(0.0f, (float) ((height - i3) - i), (float) i3, (float) (getHeight() - i)), 90.0f, 90.0f);
        path.close();
        Paint paint = new Paint();
        paint.setColor(-65536);
        paint.setShader(new LinearGradient(0.0f, 0.0f, (float) canvas.getWidth(), 0.0f, Color.parseColor("#FF8F40"), Color.parseColor("#FF7040"), Shader.TileMode.CLAMP));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(1.0f);
        canvas.drawPath(path, paint);
    }

    /* renamed from: b */
    private void m36517b(Canvas canvas) {
        Path path = new Path();
        int i = this.f50935a;
        path.moveTo(0.0f, (float) (this.f50937c + i));
        float f = (float) i;
        int i2 = this.f50937c;
        path.arcTo(new RectF(0.0f, f, (float) i2, (float) (i2 + i)), 180.0f, 90.0f);
        path.lineTo((float) this.f50938d, f);
        path.lineTo((float) (this.f50938d + (this.f50936b / 2)), 0.0f);
        path.lineTo((float) (this.f50938d + this.f50936b), f);
        path.lineTo((float) (getWidth() - this.f50937c), f);
        path.arcTo(new RectF((float) (getWidth() - this.f50937c), f, (float) getWidth(), (float) (i + this.f50937c)), -90.0f, 90.0f);
        path.lineTo((float) getWidth(), (float) (getHeight() - this.f50937c));
        path.arcTo(new RectF((float) (getWidth() - this.f50937c), (float) (getHeight() - this.f50937c), (float) getWidth(), (float) getHeight()), 0.0f, 90.0f);
        path.lineTo((float) this.f50937c, (float) getHeight());
        int height = getHeight();
        int i3 = this.f50937c;
        path.arcTo(new RectF(0.0f, (float) (height - i3), (float) i3, (float) getHeight()), 90.0f, 90.0f);
        path.close();
        Paint paint = new Paint();
        paint.setColor(-65536);
        paint.setShader(new LinearGradient(0.0f, 0.0f, (float) canvas.getWidth(), 0.0f, Color.parseColor("#FF8F40"), Color.parseColor("#FF7040"), Shader.TileMode.CLAMP));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(1.0f);
        canvas.drawPath(path, paint);
    }

    public void setOnGetClickListener(View.OnClickListener onClickListener) {
        this.f50940f = onClickListener;
    }

    public void setGuideTips(String str) {
        TextView textView = this.f50941g;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
