package com.didi.addressnew.framework.fragmentmarket.map.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class WayPointRcyViewSpacesItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f7206a = 10;

    public WayPointRcyViewSpacesItemDecoration(int i) {
        this.f7206a = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildPosition(view) != 0) {
            rect.top = this.f7206a;
        }
    }
}
