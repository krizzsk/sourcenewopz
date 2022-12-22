package com.didi.sdk.view.picker;

import com.didi.sdk.view.picker.IPickerData;
import java.util.List;

public interface IPickerDataInject<T extends IPickerData> {
    List<T> getData(List<T> list);
}
