package com.didiglobal.enginecore.register;

import com.didiglobal.enginecore.callback.XEReqParamRunnableImpl;
import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.template.temp.XETemplateComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XERegisterModel {
    public List<XETemplateComponent> components;
    public XEReqParamRunnableImpl paramRunnable;
    public int priority;
    public String requestKey;
    public XEReqParamsCallback requestParams;
    public boolean required;
    public XEResponseCallback response;
    public List<String> scenes;

    public XERegisterModel(String str, String str2, XEResponseCallback xEResponseCallback) {
        ArrayList arrayList = new ArrayList();
        this.scenes = arrayList;
        this.requestKey = str;
        arrayList.add(str2);
        this.response = xEResponseCallback;
    }

    public XERegisterModel(String str, List<String> list, XEResponseCallback xEResponseCallback) {
        ArrayList arrayList = new ArrayList();
        this.scenes = arrayList;
        this.requestKey = str;
        arrayList.addAll(list);
        this.response = xEResponseCallback;
    }

    public void addScene(String... strArr) {
        this.scenes.addAll(Arrays.asList(strArr));
    }
}
