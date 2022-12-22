package com.didi.common.map.adapter.didiadapter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.didi.common.map.util.CollectionUtil;
import java.util.Collection;
import java.util.List;

public class TextureBitmapFactory {

    public static class TextureConfig {
        public int textureHeight;
        public int textureWidth;
    }

    public static Bitmap createBitmap(List<Integer> list, TextureConfig textureConfig) {
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return null;
        }
        if (m7322a(textureConfig)) {
            return m7321a(list, 44, 1);
        }
        return m7321a(list, textureConfig.textureWidth, textureConfig.textureHeight);
    }

    /* renamed from: a */
    private static boolean m7322a(TextureConfig textureConfig) {
        return textureConfig == null || textureConfig.textureHeight <= 0 || textureConfig.textureWidth <= 0;
    }

    /* renamed from: a */
    private static Bitmap m7321a(List<Integer> list, int i, int i2) {
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, list.size() * i2, Bitmap.Config.ARGB_8888);
        float f = (float) (i2 / 2);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        for (Integer next : list) {
            if (next != null) {
                paint.reset();
                paint.setColor(next.intValue());
                paint.setStrokeWidth((float) i2);
                canvas.drawLine(0.0f, f, (float) i, f, paint);
            }
            f += (float) i2;
        }
        return createBitmap;
    }

    /* renamed from: b */
    private static Bitmap m7323b(List<Integer> list, int i, int i2) {
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, list.size() * i2, Bitmap.Config.ARGB_8888);
        float f = (float) (i2 / 2);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        for (Integer next : list) {
            if (next != null) {
                paint.reset();
                paint.setColor(next.intValue());
                float f2 = (float) i2;
                paint.setStrokeWidth(f2);
                canvas.drawLine(0.0f, f, (float) i, f, paint);
                f += f2;
            }
        }
        return createBitmap;
    }
}
