package com.didi.soda.customer.foundation.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public final class BitmapUtil {

    /* renamed from: a */
    private static final String f41131a = "BitmapUtil";

    private BitmapUtil() {
    }

    public static Bitmap getViewBitmap(View view) {
        view.setDrawingCacheEnabled(true);
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap combineBitmap(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (!bitmap.isRecycled() && bitmap2 != null && !bitmap2.isRecycled()) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.drawBitmap(bitmap2, 19.0f, 17.0f, (Paint) null);
        }
        return createBitmap;
    }

    public static String convertIconToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(byteArray, 0);
    }

    public static Bitmap convertStringToIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i2) / ((float) width), ((float) i) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap getCircularBitmap(Bitmap bitmap, int i) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        Bitmap resizedBitmap = getResizedBitmap(bitmap, 54, 54);
        int width = resizedBitmap.getWidth() + i;
        int height = resizedBitmap.getHeight() + i;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        BitmapShader bitmapShader = new BitmapShader(resizedBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(createBitmap);
        float f = (width > height ? (float) height : (float) width) / 2.0f;
        float f2 = (float) (width / 2);
        float f3 = (float) (height / 2);
        canvas.drawCircle(f2, f3, f, paint);
        paint.setShader((Shader) null);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-1);
        paint.setStrokeWidth((float) i);
        canvas.drawCircle(f2, f3, f - ((float) (i / 2)), paint);
        return createBitmap;
    }

    public static RoundedBitmapDrawable getRoundedDrawable(Context context, int i, int i2) {
        RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(context.getResources(), BitmapFactory.decodeResource(context.getResources(), i));
        create.setCornerRadius((float) i2);
        return create;
    }

    public static GradientDrawable getRoundRectDrawable(int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) i);
        gradientDrawable.setColor(i2);
        gradientDrawable.setStroke(0, i2);
        return gradientDrawable;
    }

    public static Bitmap convertFileToBitmap(File file) {
        if (file != null && file.exists()) {
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        LogUtil.m29104i(f41131a, "file not exists ");
        return null;
    }
}
