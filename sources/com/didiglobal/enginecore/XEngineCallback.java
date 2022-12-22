package com.didiglobal.enginecore;

import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import java.util.List;
import java.util.Map;

public interface XEngineCallback {
    void onFailed(Map<String, EngineErrorException> map);

    void onSuccess(XEngineData xEngineData, List<XEComponent> list);

    void onSuccessWithRenderList(XEngineData xEngineData, List<XEComponent> list);
}
