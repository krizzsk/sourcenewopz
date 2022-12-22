package com.didi.one.netdetect.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DetectionReportInfo implements Serializable {
    private List<DetectionItemResult> data = new ArrayList();

    public List<DetectionItemResult> getData() {
        return this.data;
    }

    public void setData(List<DetectionItemResult> list) {
        this.data = list;
    }
}
