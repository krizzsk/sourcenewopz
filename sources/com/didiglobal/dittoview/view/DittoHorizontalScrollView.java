package com.didiglobal.dittoview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.didiglobal.dittoview.IParser;
import com.didiglobal.dittoview.IView;
import com.facebook.yoga.YogaNode;

public class DittoHorizontalScrollView extends HorizontalScrollView implements IParser, IView {
    public View getView() {
        return this;
    }

    public void onParseEnd() {
    }

    public void parse(String str, String str2, YogaNode yogaNode) {
    }

    public void setBorder(DittoBorder dittoBorder) {
    }

    public void setCorner(DittoCorner dittoCorner) {
    }

    public void setShadow(DittoShadow dittoShadow) {
    }

    public DittoHorizontalScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DittoHorizontalScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DittoHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScrollBarSize(0);
        setOverScrollMode(2);
    }
}
