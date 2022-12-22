package com.didi.one.netdetect.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TraceRouteReportInfo implements Serializable {
    private List<TraceRouteItemResult> data = new ArrayList();

    public List<TraceRouteItemResult> getData() {
        return this.data;
    }

    public void setData(List<TraceRouteItemResult> list) {
        this.data = list;
    }
}
