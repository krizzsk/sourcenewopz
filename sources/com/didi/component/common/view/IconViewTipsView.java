package com.didi.component.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

public class IconViewTipsView extends GlobalTipsView {
    public IconViewTipsView(Context context) {
        super(context);
    }

    public void setIcon(View view) {
        Bitmap bitmap;
        try {
            bitmap = m8017a(view);
        } catch (Throwable unused) {
            bitmap = null;
        }
        if (bitmap != null) {
            setIcon(bitmap);
        }
    }

    /* renamed from: a */
    private Bitmap m8017a(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(0, 0, measuredWidth, measuredHeight);
        view.draw(canvas);
        return createBitmap;
    }

    private void setIcon(Bitmap bitmap) {
        if (bitmap != null) {
            ViewGroup.LayoutParams layoutParams = this.mIvGuide.getLayoutParams();
            layoutParams.width = bitmap.getWidth();
            layoutParams.height = bitmap.getHeight();
            this.mIvGuide.setLayoutParams(layoutParams);
            this.mIvGuide.setBackground(new BitmapDrawable(getResources(), bitmap));
            this.mIvGuide.setImageBitmap((Bitmap) null);
        }
    }
}
