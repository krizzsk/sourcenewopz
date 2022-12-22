package com.didiglobal.p205sa.biz.component.sapanel;

import com.didiglobal.p205sa.biz.component.sapanel.interfaces.IXpCardBindDataReadyCallback;
import org.json.JSONObject;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.SAPanelAdapter */
public interface SAPanelAdapter {
    void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback);
}
