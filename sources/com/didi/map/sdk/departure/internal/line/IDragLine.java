package com.didi.map.sdk.departure.internal.line;

import com.didi.map.sdk.component.IBaseComponent;
import com.didi.map.sdk.component.IUIComponent;

public interface IDragLine extends IBaseComponent<DragLineParam>, IUIComponent {
    void update(DragLineParam dragLineParam);
}
