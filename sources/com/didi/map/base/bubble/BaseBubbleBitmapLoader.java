package com.didi.map.base.bubble;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.collection.LruCache;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.common.MapAssets;

public abstract class BaseBubbleBitmapLoader {
    public static final String FILE_SPLIT_FLAG = "\\|";
    protected static float fDensityXH = 1.0f;
    public final Context context;
    private LruCache<String, Bitmap> mCacheBitmap = new LruCache<>(50);
    private LruCache<String, Drawable> mCacheDrawable = new LruCache<>(5);

    public abstract Bitmap loadBitmap(Bubble bubble, int i);

    public BaseBubbleBitmapLoader(Context context2) {
        this.context = context2;
        if (fDensityXH == 1.0f) {
            fDensityXH = ((float) context2.getResources().getDisplayMetrics().densityDpi) / 320.0f;
        }
    }

    public void putCacheBitmap(String str, Bitmap bitmap) {
        this.mCacheBitmap.put(str, bitmap);
    }

    public void putCacheDrawable(String str, Drawable drawable) {
        this.mCacheDrawable.put(str, drawable);
    }

    public Bitmap getCacheBitmap(String str) {
        return this.mCacheBitmap.get(str);
    }

    public Drawable getCacheDrawable(String str) {
        return this.mCacheDrawable.get(str);
    }

    public void onDestory() {
        this.mCacheBitmap.evictAll();
        this.mCacheDrawable.evictAll();
    }

    public int[] getBitmapWH(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inScaled = false;
        MapAssets.bitmap(this.context, str, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public float getDip2Px(float f) {
        return (float) DisplayUtils.dip2px(this.context, f);
    }

    public float[] calculateTextWidthAndHeight(String str, int i) {
        Paint paint = new Paint();
        paint.setTextSize(TypedValue.applyDimension(2, (float) i, this.context.getResources().getDisplayMetrics()));
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setFakeBoldText(true);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return new float[]{paint.measureText(str), fontMetrics.bottom - fontMetrics.top};
    }

    /* access modifiers changed from: protected */
    public float[] calculateTextWidthAndHeightNew(String str, float f) {
        TextView textView = new TextView(this.context);
        textView.setText(str);
        textView.setTextSize(1, f);
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new float[]{(float) textView.getMeasuredWidth(), (float) textView.getMeasuredHeight()};
    }
}
