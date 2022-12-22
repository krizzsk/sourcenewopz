package com.didi.dimina.container.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/dimina/container/util/ScreenshotUtils;", "", "()V", "getTempBitmapPath", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "contentHeight", "", "getWebViewLongBitmap", "Landroid/graphics/Bitmap;", "mergeBitmap", "newBitmap", "oldBitmap", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ScreenshotUtils.kt */
public final class ScreenshotUtils {
    public static final ScreenshotUtils INSTANCE = new ScreenshotUtils();

    private ScreenshotUtils() {
    }

    @JvmStatic
    public static final String getTempBitmapPath(Context context, View view, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(view, "view");
        File file = new File(context.getCacheDir().toString() + File.separator + "dimina_webview_screen_shot" + ".jpg");
        Bitmap webViewLongBitmap = getWebViewLongBitmap(view, i);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            webViewLongBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "tempBitmapFile.absolutePath");
        return absolutePath;
    }

    @JvmStatic
    public static final Bitmap getWebViewLongBitmap(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        view.scrollTo(0, 0);
        view.setVerticalScrollBarEnabled(false);
        int height = (view.getHeight() - view.getPaddingTop()) - view.getPaddingBottom();
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), height, Bitmap.Config.RGB_565);
        view.draw(new Canvas(createBitmap));
        int i2 = height;
        while (i2 < i) {
            int i3 = i - i2;
            if (i3 > height) {
                i3 = height;
            }
            view.scrollBy(0, i3);
            i2 += i3;
            Bitmap createBitmap2 = Bitmap.createBitmap(view.getWidth(), i2, Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap2));
            ScreenshotUtils screenshotUtils = INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(createBitmap2, "newBitmap");
            Intrinsics.checkExpressionValueIsNotNull(createBitmap, "mergeBitmap");
            createBitmap = screenshotUtils.m13426a(createBitmap2, createBitmap);
        }
        view.scrollTo(0, 0);
        view.setVerticalScrollBarEnabled(true);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "mergeBitmap");
        return createBitmap;
    }

    /* renamed from: a */
    private final Bitmap m13426a(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "mergeBitmap");
        return createBitmap;
    }
}
