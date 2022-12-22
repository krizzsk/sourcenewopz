package com.didi.map.global.component.dropoff;

import com.didi.common.map.model.Padding;
import com.didi.map.sdk.component.IBaseComponent;
import com.didi.map.sdk.component.IDataComponent;

public interface IDropOffCompContract extends IBaseComponent<DropOffCompParam>, IDataComponent {
    void adjustMapCamera(Padding padding);
}
