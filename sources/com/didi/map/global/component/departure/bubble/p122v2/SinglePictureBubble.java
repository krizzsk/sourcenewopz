package com.didi.map.global.component.departure.bubble.p122v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.bubble.DepartureBubble;
import com.taxis99.R;

/* renamed from: com.didi.map.global.component.departure.bubble.v2.SinglePictureBubble */
public class SinglePictureBubble extends DepartureBubble {

    /* renamed from: a */
    private CharSequence f24905a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f24906b;

    /* renamed from: c */
    private View f24907c = null;

    public SinglePictureBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public SinglePictureBubble setUrl(Context context, CharSequence charSequence) {
        this.f24905a = charSequence;
        this.f24906b = context;
        return this;
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bubble_v2_single_pic_layout, viewGroup, false);
        this.f24907c = inflate;
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_pic);
        try {
            ((RequestBuilder) Glide.with(this.f24906b).asBitmap().load((Object) this.f24905a).centerCrop()).into(new BitmapImageViewTarget(imageView) {
                /* access modifiers changed from: protected */
                public void setResource(Bitmap bitmap) {
                    RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(SinglePictureBubble.this.f24906b.getResources(), bitmap);
                    create.setCornerRadius(15.0f);
                    imageView.setImageDrawable(create);
                }
            });
        } catch (Exception e) {
            DLog.m7384d("glide", "glide load  Exception:" + e.toString(), new Object[0]);
        }
        return this.f24907c;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f24907c.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f24907c.setVisibility(4);
    }
}
