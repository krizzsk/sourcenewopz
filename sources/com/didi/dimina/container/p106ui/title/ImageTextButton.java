package com.didi.dimina.container.p106ui.title;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.service.ImageLoaderService;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.title.ImageTextButton */
public class ImageTextButton extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ImageView f17846a;

    /* renamed from: b */
    private TextView f17847b;

    public ImageTextButton(Context context) {
        super(context);
        m13361a();
    }

    public ImageTextButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13361a();
    }

    public ImageTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13361a();
    }

    /* renamed from: a */
    private void m13361a() {
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_image_button, this);
        this.f17846a = (ImageView) findViewById(R.id.dimina_image_button_iv);
        this.f17847b = (TextView) findViewById(R.id.dimina_image_button_bt);
    }

    public TextView getTextView() {
        return this.f17847b;
    }

    public void showText(String str) {
        this.f17847b.setVisibility(0);
        this.f17846a.setVisibility(8);
        this.f17847b.setText(str);
    }

    public void showImage(String str) {
        this.f17847b.setVisibility(8);
        this.f17846a.setVisibility(0);
        Dimina.getConfig().getAdapterConfig().getImageLoaderService().load(getContext(), str, (ImageLoaderService.FinishBitmapListener) new ImageLoaderService.FinishBitmapListener() {
            public void onBitmapFinish(Bitmap bitmap) {
                ImageTextButton.this.f17846a.setImageBitmap(bitmap);
            }
        });
    }
}
