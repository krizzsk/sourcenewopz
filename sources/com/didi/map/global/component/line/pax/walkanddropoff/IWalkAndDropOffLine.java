package com.didi.map.global.component.line.pax.walkanddropoff;

import com.didi.common.map.internal.IMapElement;
import com.didi.map.sdk.component.IBaseComponent;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH&J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u001c\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/map/global/component/line/pax/walkanddropoff/IWalkAndDropOffLine;", "Lcom/didi/map/sdk/component/IBaseComponent;", "Lcom/didi/map/global/component/line/pax/walkanddropoff/WalkDropOffParam;", "getDropOffLine", "", "Lcom/didi/common/map/internal/IMapElement;", "getWalkLine", "removeAllLine", "", "setOnWalkDropChangeListener", "listener", "Lcom/didi/map/global/component/line/pax/walkanddropoff/onWalkDropChangeListener;", "setVisible", "visible", "", "updateLines", "start", "Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "dest", "compLine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IWalkAndDropOffLine.kt */
public interface IWalkAndDropOffLine extends IBaseComponent<WalkDropOffParam> {
    List<IMapElement> getDropOffLine();

    List<IMapElement> getWalkLine();

    void removeAllLine();

    void setOnWalkDropChangeListener(onWalkDropChangeListener onwalkdropchangelistener);

    void setVisible(boolean z);

    void updateLines(DoublePoint doublePoint);

    void updateLines(DoublePoint doublePoint, DoublePoint doublePoint2);
}
