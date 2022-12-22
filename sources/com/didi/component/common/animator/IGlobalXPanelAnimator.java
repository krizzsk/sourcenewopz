package com.didi.component.common.animator;

import android.view.View;

public interface IGlobalXPanelAnimator {

    public interface VisibilityChangedListener {
        void onHidden();

        void onHiddenStart();

        void onShown();

        void onShownStart();
    }

    void hide(View view);

    void hide(View view, long j, long j2, VisibilityChangedListener visibilityChangedListener);

    void hide(View view, long j, VisibilityChangedListener visibilityChangedListener);

    void initPrepare(View view);

    boolean isShown(View view);

    void show(View view);

    void show(View view, long j, long j2, VisibilityChangedListener visibilityChangedListener);

    void show(View view, long j, VisibilityChangedListener visibilityChangedListener);
}
