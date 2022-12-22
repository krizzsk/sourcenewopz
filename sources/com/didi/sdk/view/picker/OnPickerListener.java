package com.didi.sdk.view.picker;

import com.didi.sdk.view.picker.IPickerData;
import java.util.List;

public interface OnPickerListener<T extends IPickerData> {
    void onResult(List<T> list, int[] iArr);
}
