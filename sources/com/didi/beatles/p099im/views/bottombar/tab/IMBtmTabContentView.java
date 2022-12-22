package com.didi.beatles.p099im.views.bottombar.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabContentView */
public class IMBtmTabContentView extends LinearLayout {

    /* renamed from: a */
    private static final String f10118a = IMBtmTabContentView.class.getSimpleName();

    /* renamed from: b */
    private ImageView f10119b;

    /* renamed from: c */
    private TextView f10120c;

    /* renamed from: d */
    private View f10121d;

    public IMBtmTabContentView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMBtmTabContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMBtmTabContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        inflate(context, R.layout.im_btm_tab_content_view, this);
        this.f10119b = (ImageView) findViewById(R.id.im_tab_icon);
        this.f10120c = (TextView) findViewById(R.id.im_tab_text);
        this.f10121d = findViewById(R.id.im_tab_dot);
    }

    public void bindData(String str, int i) {
        this.f10119b.setImageResource(i);
        this.f10120c.setText(str);
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
    }

    public void setDotVisible(int i) {
        if (i == 0) {
            IMViewUtil.show(this.f10121d);
        } else {
            IMViewUtil.hide(this.f10121d);
        }
    }
}
