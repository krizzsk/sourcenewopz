package com.didi.app.nova.support.view.recyclerview.decorator;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public interface ItemDecoratorOver extends ItemDecorator {
    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2);
}
