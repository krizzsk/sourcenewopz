package com.didi.sdk.component.share;

import android.content.Context;
import android.view.View;
import com.didi.sdk.component.share.ShareView;

public interface IShareViewAdapter {
    int getPlatform();

    View getPlatformView();

    void init(ShareView shareView);

    void onClick(int i, Context context, ShareView.ShareModel shareModel);

    void setShareListener(ShareView.ShareListener shareListener);
}
