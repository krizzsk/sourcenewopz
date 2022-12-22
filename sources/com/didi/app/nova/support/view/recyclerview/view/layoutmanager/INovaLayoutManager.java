package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;

public interface INovaLayoutManager {
    int findFirstCompletelyVisibleItemPosition();

    int findFirstVisibleItemPosition();

    int findLastVisibleItemPosition();

    View getChildAt(int i);

    int getChildCount();

    int getItemCount();

    int getOrientation();

    int getPosition(View view);

    void init(NovaRecyclerAdapter novaRecyclerAdapter);

    void release();

    void setSmoothScroller(RecyclerView.SmoothScroller smoothScroller);
}
