package com.didi.safetoolkit.business.bubble;

import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;

public interface ISafePresenter {

    public interface Callback {
        void callback(SfBubbleData sfBubbleData, boolean z);
    }

    void onActionClick(String str);

    void refreshJarvisData(SfJarvisData sfJarvisData, Callback callback);

    void removeCallBacks();
}
