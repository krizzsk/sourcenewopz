package com.didi.xengine.flutter;

import java.util.ArrayList;
import java.util.List;

public class FlutterRegisterModel {
    public FlutterBizParamCallback callback;
    public String identifier;
    public int priority;
    public boolean required;
    public List<String> scenes = new ArrayList();
}
