package com.didiglobal.enginecore;

import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.model.XEngineData;
import java.util.List;

public interface XEParserCallback {
    void onFail(Exception exc);

    void onRenderSuccess(XEngineData xEngineData, List<XEComponent> list);

    void onSuccess(XEngineData xEngineData, List<XEComponent> list);
}
