package com.didiglobal.enginecore.template.xml;

import com.didiglobal.dittoview.mvvm.DittoData;
import com.didiglobal.enginecore.data.XECardViewData;

public class XMLCardData implements XECardViewData {
    private DittoData data;
    private int height;
    private int width;

    public DittoData getData() {
        return this.data;
    }

    public void setData(DittoData dittoData) {
        this.data = dittoData;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
