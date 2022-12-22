package com.didiglobal.enginecore.callback;

import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import java.util.List;

public interface XEResponseCallback {
    void onFailed(String str, EngineErrorException engineErrorException);

    void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list);
}
