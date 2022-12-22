package com.didi.component.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class IconTextTipsView extends GlobalTipsView {

    /* renamed from: a */
    private Paint f11832a;

    /* renamed from: b */
    private Paint f11833b;

    /* renamed from: c */
    private int f11834c = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.global_tips_icon_width);

    /* renamed from: d */
    private int f11835d = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.global_tips_icon_height);

    /* renamed from: e */
    private int f11836e = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.global_tips_icon_bg_round);

    public IconTextTipsView(Context context) {
        super(context);
        int color = ResourcesHelper.getColor(getContext(), R.color.global_tips_icon_bg);
        int color2 = ResourcesHelper.getColor(getContext(), R.color.global_tips_icon_text);
        int dimensionPixelSize = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_10sp);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(color);
        paint.setAntiAlias(true);
        this.f11832a = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(color2);
        paint2.setTextSize((float) dimensionPixelSize);
        this.f11833b = paint2;
    }

    public void setIcon(String str) {
        Bitmap bitmap;
        try {
            bitmap = m8016a(str);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmap = null;
        }
        if (bitmap != null) {
            ViewGroup.LayoutParams layoutParams = this.mIvGuide.getLayoutParams();
            layoutParams.width = -2;
            this.mIvGuide.setLayoutParams(layoutParams);
            this.mIvGuide.setBackground(new BitmapDrawable(getResources(), bitmap));
            this.mIvGuide.setImageBitmap((Bitmap) null);
        }
    }

    /* renamed from: a */
    private Bitmap m8016a(String str) {
        float measureText = this.f11833b.measureText(str) + ((float) ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.dp_8));
        int i = this.f11834c;
        if (measureText > ((float) i)) {
            i = (int) measureText;
        }
        int i2 = this.f11835d;
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF();
        rectF.left = 1.0f;
        rectF.top = 1.0f;
        rectF.right = (float) (i - 1);
        rectF.bottom = (float) (i2 - 1);
        int i3 = this.f11836e;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, this.f11832a);
        Rect rect = new Rect();
        this.f11833b.getTextBounds(str, 0, str.length(), rect);
        Paint.FontMetrics fontMetrics = this.f11833b.getFontMetrics();
        canvas.drawText(str, ((float) (i - rect.width())) / 2.0f, (((float) (i2 / 2)) - fontMetrics.descent) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f), this.f11833b);
        return createBitmap;
    }
}
