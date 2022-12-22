package com.didi.beatles.p099im.views.imageView;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.views.IMProfileTextView;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.imageView.IMProfileCircleImageView */
public class IMProfileCircleImageView extends RelativeLayout {

    /* renamed from: a */
    private IMCircleImageView f10287a;

    /* renamed from: b */
    private IMProfileTextView f10288b;

    public IMProfileCircleImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public IMProfileCircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMProfileCircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7020a();
    }

    /* renamed from: a */
    private void m7020a() {
        LayoutInflater.from(getContext()).inflate(R.layout.imageview_circle_profile, this, true);
        this.f10287a = (IMCircleImageView) findViewById(R.id.circle_iv);
        this.f10288b = (IMProfileTextView) findViewById(R.id.profile_tv);
    }

    public void setImageSrc(Object obj, int i) {
        BtsImageLoader.getInstance().loadInto(obj, (View) this.f10287a, (int) R.drawable.bts_im_general_default_avatar);
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f10288b.setVisibility(8);
            return;
        }
        this.f10288b.setVisibility(0);
        this.f10288b.setText(str);
    }
}
