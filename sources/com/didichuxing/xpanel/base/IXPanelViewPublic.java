package com.didichuxing.xpanel.base;

import android.view.View;
import android.view.ViewGroup;
import com.didichuxing.xpanel.agent.IXPanelAgentClickListener;
import com.didichuxing.xpanel.channel.global.impl.IXPanelSpaceInterceptor;

public interface IXPanelViewPublic extends IXPanelLife {
    void bindAgentClickListener(IXPanelAgentClickListener iXPanelAgentClickListener);

    void bindSpaceInterceptor(IXPanelSpaceInterceptor iXPanelSpaceInterceptor);

    ViewGroup getHandleView();

    View getView();

    void setMinShowHeight(int i);
}
