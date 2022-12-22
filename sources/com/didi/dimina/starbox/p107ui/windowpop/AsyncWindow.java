package com.didi.dimina.starbox.p107ui.windowpop;

import android.view.View;
import android.view.WindowManager;

/* renamed from: com.didi.dimina.starbox.ui.windowpop.AsyncWindow */
public interface AsyncWindow {
    boolean onForegroundChange(boolean z);

    void onLayoutParams(WindowManager.LayoutParams layoutParams);

    View provideView();
}
