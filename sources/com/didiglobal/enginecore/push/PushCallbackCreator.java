package com.didiglobal.enginecore.push;

import com.didiglobal.enginecore.XEngineCallback;

public interface PushCallbackCreator {
    String getCurrentScene();

    XEngineCallback getEngineCallback();
}
