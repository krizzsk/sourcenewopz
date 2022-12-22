package com.didi.app.nova.support.view.recyclerview.decorator;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public interface ItemDecorator {
    public static final int POSITION_BOTTOM = 8;
    public static final int POSITION_FIRST_ITEM = 16;
    public static final int POSITION_LAST_ITEM = 64;
    public static final int POSITION_LEFT = 1;
    public static final int POSITION_MIDDLE = 0;
    public static final int POSITION_MIDDLE_ITEM = 32;
    public static final int POSITION_RIGHT = 4;
    public static final int POSITION_TOP = 2;

    void getItemOffsets(Rect rect, int i, int i2);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2);
}
