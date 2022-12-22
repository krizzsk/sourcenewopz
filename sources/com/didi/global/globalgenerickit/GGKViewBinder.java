package com.didi.global.globalgenerickit;

import android.content.Context;
import android.view.View;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.didi.global.globalgenerickit.template.yoga.XMLCacheEntity;

public interface GGKViewBinder {
    void bind(View view, GGKData gGKData);

    EventListener createEventListener(GGKData gGKData);

    View createView(Context context, GGKData gGKData);

    void onCDNCached(XMLCacheEntity xMLCacheEntity);
}
