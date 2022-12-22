package com.didi.component.mapflow.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.address.model.WayPoint;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.global.flow.scene.sug.ISubmitWayPointsCallback;
import com.didi.sdk.address.address.entity.Address;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsBeforeOrderMapFlowDelegatePresenter extends AbsMapFlowDelegatePresenter {
    public AbsBeforeOrderMapFlowDelegatePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, ISubmitWayPointsCallback iSubmitWayPointsCallback) {
        GLog.m7965d("zl-route-editor", "[sug page] onSubmit WayPoints : " + list + " changed: " + list2);
        if (!hasWayPointBy(list, 3)) {
            if (hasWayPointBy(list, 2)) {
                List<WayPoint> filterWayPointBy = filterWayPointBy(list, 2);
                filterWayPointBy.get(filterWayPointBy.size() - 1).setWayPointType(3);
            }
        }
        FormStore.getInstance().clearStopPoints();
        if (hasWayPointBy(list, 1, 3)) {
            FormStore.getInstance().saveWayPoint(list);
            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.RouteEditor.EVENT_WAY_POINTS_CHANGED, list2);
        }
        iSubmitWayPointsCallback.onSuccess();
    }

    /* access modifiers changed from: protected */
    public List<Integer> getEditableWayPointsType() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<WayPoint> getWayPoints() {
        List<WayPoint> wayPoints = FormStore.getInstance().getWayPoints();
        WayPoint wayPoint = null;
        WayPoint wayPoint2 = null;
        for (WayPoint next : wayPoints) {
            if (next.getWayPointType() == 1) {
                wayPoint = next;
            } else if (next.getWayPointType() == 3) {
                wayPoint2 = next;
            }
        }
        if (wayPoint == null) {
            wayPoints.add(0, new WayPoint(1, (Address) null));
        }
        if (wayPoint2 == null) {
            wayPoints.add(wayPoints.size(), new WayPoint(3, (Address) null));
        }
        return wayPoints;
    }
}
