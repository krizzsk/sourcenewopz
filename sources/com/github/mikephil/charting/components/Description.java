package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

public class Description extends ComponentBase {

    /* renamed from: a */
    private String f52287a = "Description Label";

    /* renamed from: b */
    private MPPointF f52288b;

    /* renamed from: c */
    private Paint.Align f52289c = Paint.Align.RIGHT;

    public Description() {
        this.mTextSize = Utils.convertDpToPixel(8.0f);
    }

    public void setText(String str) {
        this.f52287a = str;
    }

    public String getText() {
        return this.f52287a;
    }

    public void setPosition(float f, float f2) {
        MPPointF mPPointF = this.f52288b;
        if (mPPointF == null) {
            this.f52288b = MPPointF.getInstance(f, f2);
            return;
        }
        mPPointF.f52498x = f;
        this.f52288b.f52499y = f2;
    }

    public MPPointF getPosition() {
        return this.f52288b;
    }

    public void setTextAlign(Paint.Align align) {
        this.f52289c = align;
    }

    public Paint.Align getTextAlign() {
        return this.f52289c;
    }
}
