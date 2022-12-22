package com.didi.map.global.component.streetview;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.didi.map.global.component.streetview.StreetViewComp;

public interface IStreetViewLoader {

    public interface OnStreetViewActionListener {
        void goFeedback();

        void hideView();
    }

    void cancelStreetViewLoad();

    View createView(LayoutInflater layoutInflater);

    int getLayoutResId();

    void load(StreetViewCompParams streetViewCompParams, ImageView imageView, StreetViewComp.ILoadCallback iLoadCallback);

    void setListener(OnStreetViewActionListener onStreetViewActionListener);
}
