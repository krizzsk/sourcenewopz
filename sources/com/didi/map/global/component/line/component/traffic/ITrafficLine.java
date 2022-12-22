package com.didi.map.global.component.line.component.traffic;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.map.global.component.line.component.ICompLineContract;
import java.util.List;

public interface ITrafficLine extends ICompLineContract {
    void erase(int i, LatLng latLng);

    List<Line> getLines();

    void highLight(boolean z);
}
