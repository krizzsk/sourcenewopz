package com.didichuxing.xpanel.channel.global.impl;

public interface IXPanelCallBack {
    void doXPanelContentChange();

    void doXPanelMoveChange(int i);

    void doXPanelPullStateChange(boolean z);

    void doXPanelScrollStatusChange(int i);

    void doXPanelShowHeightChange(int i);
}
