package com.didi.soda.customer.widget.loading;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public interface ILoadingRender extends Animatable {

    public interface Callback extends Drawable.Callback {
        void onCreate(Bundle bundle);

        void onLayout();

        void onStart();

        void onStop();
    }

    public static class SimpleCallback implements Callback {
        public void invalidateDrawable(Drawable drawable) {
        }

        public void onCreate(Bundle bundle) {
        }

        public void onLayout() {
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }
    }

    void addCallback(Callback callback);

    void createRender(Context context, Bundle bundle);

    Rect getBorder();

    View getView();

    void layoutRender(View view, ViewGroup viewGroup);
}
