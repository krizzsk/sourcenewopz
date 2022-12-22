package com.didi.map.global.component.line.component;

import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.List;

public interface ICompLineContract extends IBaseComponent<LineParams> {

    /* renamed from: com.didi.map.global.component.line.component.ICompLineContract$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$updateLinePoints(ICompLineContract iCompLineContract, List list) {
        }
    }

    List<LatLng> getAllLinePoints();

    List<IMapElement> getBestViewElements();

    void setLineClickListener(OnLineClickListener onLineClickListener);

    void setLineVisible(boolean z);

    void setListener(OnLineDrawStatusListener onLineDrawStatusListener);

    void start();

    void stop();

    void updateLinePoints(List<LatLng> list);
}
