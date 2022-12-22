package com.dmap.navigation.engine.core;

import com.dmap.navigation.engine.event.NaviEvent;

public interface INaviEventListener {
    void onEvent(NaviEvent naviEvent);
}
