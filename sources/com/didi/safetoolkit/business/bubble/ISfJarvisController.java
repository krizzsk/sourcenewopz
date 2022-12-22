package com.didi.safetoolkit.business.bubble;

import android.view.View;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;

public interface ISfJarvisController {
    void closeSafePanel();

    View getView();

    void init();

    void onRemove();

    void refreshJarvisData(SfJarvisData sfJarvisData);

    void removeCallback();

    void setBubbleStatusAndShow(SfBubbleData sfBubbleData);
}
