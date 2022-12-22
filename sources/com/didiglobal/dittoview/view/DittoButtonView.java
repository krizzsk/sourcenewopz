package com.didiglobal.dittoview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didiglobal.dittoview.IParser;
import com.didiglobal.dittoview.IView;
import com.facebook.yoga.YogaNode;

public class DittoButtonView extends FrameLayout implements IParser, IView {

    /* renamed from: a */
    private static final String f49907a = "DittoButtonView";

    /* renamed from: b */
    private Context f49908b;

    /* renamed from: c */
    private float[] f49909c;

    public View getView() {
        return this;
    }

    public void onParseEnd() {
    }

    public void setBorder(DittoBorder dittoBorder) {
    }

    public void setShadow(DittoShadow dittoShadow) {
    }

    public DittoButtonView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DittoButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DittoButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f49909c = new float[8];
        this.f49908b = context;
    }

    public void parse(String str, String str2, YogaNode yogaNode) {
        str.getClass();
    }

    public void setCorner(DittoCorner dittoCorner) {
        float[] fArr = this.f49909c;
        float leftTopCorner = dittoCorner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f49909c;
        float rightTopCorner = dittoCorner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f49909c;
        float rightBottomCorner = dittoCorner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f49909c;
        float leftBottomCorner = dittoCorner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
