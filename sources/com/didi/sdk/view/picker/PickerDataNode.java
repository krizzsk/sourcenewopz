package com.didi.sdk.view.picker;

import com.didi.sdk.view.picker.IPickerData;
import java.util.List;

public class PickerDataNode<T extends IPickerData> {
    public T data;
    public List<PickerDataNode<T>> pointList;

    public PickerDataNode() {
    }

    public PickerDataNode(T t) {
        this(t, (List) null);
    }

    public PickerDataNode(T t, List<PickerDataNode<T>> list) {
        this.data = t;
        this.pointList = list;
    }
}
