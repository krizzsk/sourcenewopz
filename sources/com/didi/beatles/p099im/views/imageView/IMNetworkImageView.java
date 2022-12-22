package com.didi.beatles.p099im.views.imageView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;

/* renamed from: com.didi.beatles.im.views.imageView.IMNetworkImageView */
public class IMNetworkImageView extends AppCompatImageView {

    /* renamed from: a */
    private BtsImageLoader f10285a;

    /* renamed from: b */
    private String f10286b;

    public IMNetworkImageView(Context context) {
        super(context);
    }

    public IMNetworkImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IMNetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m7019a() {
        if (this.f10285a == null) {
            this.f10285a = BtsImageLoader.getInstance();
            if (getContext() != null) {
                this.f10285a.with(getContext());
            }
        }
    }

    public String getImageSourceUrl() {
        return this.f10286b;
    }

    public void loadImageUrl(String str, int i) {
        m7019a();
        if (!str.equals(this.f10286b)) {
            this.f10286b = str;
            if (i == -1) {
                this.f10285a.loadInto(str, this);
            } else {
                this.f10285a.loadInto((Object) str, (View) this, i);
            }
        }
    }
}
