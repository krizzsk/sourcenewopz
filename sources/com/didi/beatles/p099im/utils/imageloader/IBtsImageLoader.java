package com.didi.beatles.p099im.utils.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: com.didi.beatles.im.utils.imageloader.IBtsImageLoader */
public interface IBtsImageLoader {
    public static final IBtsImageLoader empty = new IBtsImageLoader() {
        public void cancel(Object obj) {
        }

        public void clearMemory() {
        }

        public Object download(String str, int i, int i2, Callback callback) {
            return null;
        }

        public Object download(String str, int i, int i2, IMImageRequestOptions iMImageRequestOptions, Callback callback) {
            return null;
        }

        public Object download(String str, Callback callback) {
            return null;
        }

        public void loadInto(Object obj, View view) {
        }

        public void loadInto(Object obj, View view, int i) {
        }

        public void loadInto(Object obj, View view, Drawable drawable) {
        }

        public void loadInto(Object obj, View view, Animator animator, IMImageRequestOptions iMImageRequestOptions, Callback callback) {
        }

        public void loadInto(Object obj, View view, Callback callback) {
        }

        public void loadIntoAsGif(Object obj, View view, int i, Callback callback) {
        }

        public void loadIntoAsGif(Object obj, View view, Callback callback) {
        }

        public void loadRoundInto(Object obj, int i, View view) {
        }

        public void loadRoundInto(Object obj, View view) {
        }

        public void loadRoundInto(Object obj, View view, int i) {
        }

        public IBtsImageLoader with(Context context) {
            return null;
        }
    };

    void cancel(Object obj);

    void clearMemory();

    Object download(String str, int i, int i2, Callback callback);

    Object download(String str, int i, int i2, IMImageRequestOptions iMImageRequestOptions, Callback callback);

    Object download(String str, Callback callback);

    void loadInto(Object obj, View view);

    void loadInto(Object obj, View view, int i);

    void loadInto(Object obj, View view, Drawable drawable);

    void loadInto(Object obj, View view, Animator animator, IMImageRequestOptions iMImageRequestOptions, Callback callback);

    void loadInto(Object obj, View view, Callback callback);

    void loadIntoAsGif(Object obj, View view, int i, Callback callback);

    void loadIntoAsGif(Object obj, View view, Callback callback);

    void loadRoundInto(Object obj, int i, View view);

    void loadRoundInto(Object obj, View view);

    void loadRoundInto(Object obj, View view, int i);

    IBtsImageLoader with(Context context);
}
