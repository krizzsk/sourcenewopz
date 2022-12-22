package com.didi.app.nova.skeleton;

import com.didi.app.nova.skeleton.tools.Cancelable;

public interface LiveHandler extends ILive {
    void bind(Cancelable cancelable);
}
