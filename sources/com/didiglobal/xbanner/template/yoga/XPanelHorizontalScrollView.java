package com.didiglobal.xbanner.template.yoga;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.didiglobal.xbanner.template.yoga.view.Border;
import com.didiglobal.xbanner.template.yoga.view.Corner;
import com.facebook.yoga.YogaNode;

public class XPanelHorizontalScrollView extends HorizontalScrollView implements IParser, IView {
    public View getView() {
        return this;
    }

    public void onParseEnd() {
    }

    public void parse(String str, String str2, YogaNode yogaNode) {
    }

    public void setBorder(Border border) {
    }

    public void setCorner(Corner corner) {
    }

    public XPanelHorizontalScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelHorizontalScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScrollBarSize(0);
        setOverScrollMode(2);
    }
}
