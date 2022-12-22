package com.didi.app.nova.skeleton;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public interface RestrictContext {
    AssetManager getAssets();

    int getColor(int i);

    Drawable getDrawable(int i);

    Resources getResources();

    String getString(int i);

    String getString(int i, Object... objArr);

    CharSequence getText(int i);

    Resources.Theme getTheme();
}
