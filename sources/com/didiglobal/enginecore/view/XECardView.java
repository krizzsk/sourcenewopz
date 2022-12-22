package com.didiglobal.enginecore.view;

import android.content.Context;
import android.view.View;
import com.didiglobal.enginecore.data.XECardViewData;

public interface XECardView<T extends XECardViewData> {
    void createView(Context context, T t);

    View getView();
}
