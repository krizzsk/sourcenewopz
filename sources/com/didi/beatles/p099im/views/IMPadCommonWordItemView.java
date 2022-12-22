package com.didi.beatles.p099im.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.IMPadCommonWordItemView */
public class IMPadCommonWordItemView extends FrameLayout {

    /* renamed from: a */
    private static final String f9911a = IMPadCommonWordItemView.class.getSimpleName();

    /* renamed from: b */
    private static final float f9912b = 0.93f;

    /* renamed from: c */
    private RelativeLayout f9913c;

    /* renamed from: d */
    private TextView f9914d;

    /* renamed from: e */
    private TextView f9915e;

    public IMPadCommonWordItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMPadCommonWordItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMPadCommonWordItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6692a(context);
    }

    /* renamed from: a */
    private void m6692a(Context context) {
        inflate(context, R.layout.im_pad_common_word_item, this);
        this.f9913c = (RelativeLayout) findViewById(R.id.im_pad_item_container);
        this.f9914d = (TextView) findViewById(R.id.im_pad_item_main_tv);
        this.f9915e = (TextView) findViewById(R.id.im_pad_item_sub_tv);
    }

    public void bind(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.contains(IMTextUtils.DEVIDER_TAG)) {
                this.f9914d.setText(str);
                this.f9915e.setVisibility(8);
                return;
            }
            this.f9915e.setVisibility(0);
            this.f9914d.setText(IMTextUtils.getTitle(str));
            this.f9915e.setText(IMTextUtils.getContent(str));
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z) {
        super.dispatchSetPressed(z);
        m6693a(z);
    }

    /* renamed from: a */
    private void m6693a(boolean z) {
        RelativeLayout relativeLayout = this.f9913c;
        float f = f9912b;
        relativeLayout.setScaleX(z ? f9912b : 1.0f);
        RelativeLayout relativeLayout2 = this.f9913c;
        if (!z) {
            f = 1.0f;
        }
        relativeLayout2.setScaleY(f);
    }
}
