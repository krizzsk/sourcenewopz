package com.didi.dimina.container.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.io.File;

public interface ImageLoaderService {

    public interface FinishBitmapListener {
        void onBitmapFinish(Bitmap bitmap);
    }

    public interface FinishDrawableListener {
        void onDrawableFinish(Drawable drawable);
    }

    public interface FinishFileListener {
        void onFileFinish(File file);
    }

    void download(Context context, String str, FinishFileListener finishFileListener);

    void load(Context context, File file, FinishBitmapListener finishBitmapListener);

    void load(Context context, String str, int i, int i2, int i3, FinishBitmapListener finishBitmapListener);

    void load(Context context, String str, int i, int i2, FinishBitmapListener finishBitmapListener);

    void load(Context context, String str, FinishBitmapListener finishBitmapListener);

    void load(Context context, String str, FinishDrawableListener finishDrawableListener);

    void loadCircleInto(Context context, File file, ImageView imageView);

    void loadInto(Context context, File file, ImageView imageView);

    void loadInto(Context context, String str, int i, ImageView imageView);
}
