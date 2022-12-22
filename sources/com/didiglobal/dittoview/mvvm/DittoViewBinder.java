package com.didiglobal.dittoview.mvvm;

import android.content.Context;
import android.view.View;
import com.didiglobal.dittoview.DittoEventListener;
import com.didiglobal.dittoview.DittoXMLCacheEntity;

public interface DittoViewBinder {
    void bind(View view, DittoData dittoData);

    DittoEventListener createEventListener(DittoData dittoData);

    View createView(Context context, DittoData dittoData);

    void onCDNCached(DittoXMLCacheEntity dittoXMLCacheEntity);
}
