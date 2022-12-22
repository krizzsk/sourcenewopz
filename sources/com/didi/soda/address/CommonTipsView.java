package com.didi.soda.address;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CommonTipsView extends View {

    /* renamed from: a */
    private final int f38640a = 11;

    /* renamed from: b */
    private final int f38641b = 5;

    /* renamed from: c */
    private final int f38642c = 10;

    /* renamed from: d */
    private final int f38643d = 15;

    /* renamed from: e */
    private Context f38644e;

    /* renamed from: f */
    private TextView f38645f;

    /* renamed from: g */
    private ImageView f38646g;

    /* renamed from: h */
    private int f38647h;

    /* renamed from: i */
    private int f38648i;

    /* renamed from: a */
    private int m27361a(int i) {
        return 0;
    }

    /* renamed from: a */
    private void m27362a() {
    }

    public CommonTipsView(Context context) {
        super(context);
        this.f38644e = context;
    }

    public CommonTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38644e = context;
    }

    public void setBackgroundColor(int i) {
        this.f38647h = i;
    }

    public void setCloseImage(int i) {
        this.f38646g.setImageResource(i);
    }

    public void setContent(String str) {
        this.f38645f.setText(str);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
    }

    /* renamed from: b */
    private void m27363b() {
        new RelativeLayout(this.f38644e);
        new LinearLayout.LayoutParams(-2, -2);
    }

    public static final class ArrowOriation {
        public static final int BOTTOM_CENTER = 4096;
        public static final int BOTTOM_LEFT = 8192;
        public static final int BOTTOM_RIGHT = 12288;
        public static final int LEFT = 16;
        public static final int RIGHT = 256;
        public static final int UP_CENTER = 1;
        public static final int UP_LEFT = 2;
        public static final int UP_RIGHT = 3;

        private ArrowOriation() {
        }
    }
}
