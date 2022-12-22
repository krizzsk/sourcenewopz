package com.didi.addressnew.framework.fragmentmarket.map.presenter;

import android.text.TextUtils;
import com.didi.address.model.WayPoint;
import com.didi.address.model.WayPointParam;
import com.didi.addressnew.framework.fragmentmarket.map.ISugWayPointPageView;
import com.didi.addressnew.util.CommonUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SugMapWayPointPagePresenter {

    /* renamed from: a */
    private ISugWayPointPageView f7172a;

    /* renamed from: b */
    private WayPointParam f7173b;

    /* renamed from: c */
    private List<Integer> f7174c = new ArrayList();

    /* renamed from: d */
    private List<WayPoint> f7175d = new ArrayList();

    /* renamed from: e */
    private List<WayPoint> f7176e = new ArrayList();

    /* renamed from: f */
    private List<WayPoint> f7177f = new ArrayList();

    /* renamed from: g */
    private List<WayPoint> f7178g = new ArrayList();

    /* renamed from: h */
    private boolean f7179h = true;

    /* renamed from: i */
    private int f7180i = -1;

    public SugMapWayPointPagePresenter(ISugWayPointPageView iSugWayPointPageView, WayPointParam wayPointParam) {
        this.f7172a = iSugWayPointPageView;
        this.f7173b = wayPointParam;
        m4342a();
    }

    /* renamed from: a */
    private void m4342a() {
        WayPointParam wayPointParam = this.f7173b;
        if (wayPointParam != null) {
            List<WayPoint> wayPoints = wayPointParam.getWayPoints();
            if (!CollectionUtil.isEmpty((Collection<?>) wayPoints)) {
                this.f7176e.addAll(m4341a(wayPoints));
            }
            m4348b("loadWayPoints mAllWayPoints.size=" + this.f7176e.size());
            List<Integer> wayPointTypes = this.f7173b.getWayPointTypes();
            if (!CollectionUtil.isEmpty((Collection<?>) wayPointTypes)) {
                this.f7174c.addAll(wayPointTypes);
            }
            m4348b("loadWayTypes mWayPointTypes.size=" + this.f7174c.size() + "mWayPointTypes = " + this.f7174c);
        }
        m4349c();
        m4351d();
        this.f7177f = findWayPointsByType(2, this.f7176e);
        Collections.sort(this.f7176e, C3182xa2c6e2fa.INSTANCE);
        UiThreadHandler.post(new Runnable() {
            public final void run() {
                SugMapWayPointPagePresenter.this.m4353e();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ int m4339a(WayPoint wayPoint, WayPoint wayPoint2) {
        return wayPoint.getWayPointType() - wayPoint2.getWayPointType();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4353e() {
        WayPointParam wayPointParam;
        WayPoint wayPoint = null;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f7174c)) {
            for (WayPoint next : this.f7176e) {
                next.setEditable(this.f7174c.contains(Integer.valueOf(next.getWayPointType())));
                if (this.f7172a.addWayPoint(next)) {
                    m4343a(next);
                }
                if (next.getWayPointType() == 2) {
                    wayPoint = next;
                }
            }
        }
        this.f7172a.onWayPointsUpdated();
        this.f7172a.updatePageContent();
        this.f7172a.updateAddStopEnterVisible(findWayPointsByType(3, this.f7176e).get(0), canAddStop());
        if (wayPoint == null && (wayPointParam = this.f7173b) != null && wayPointParam.isAddDefaultWayPoint()) {
            m4348b("loadWayTypes addDefaultWayPoint is true");
            createStop();
            this.f7172a.onWayPointsUpdated();
        }
    }

    /* renamed from: c */
    private void m4349c() {
        WayPoint wayPoint = null;
        WayPoint wayPoint2 = null;
        for (WayPoint next : this.f7176e) {
            if (next.getWayPointType() == 1) {
                wayPoint = next;
            } else if (next.getWayPointType() == 3) {
                wayPoint2 = next;
            }
        }
        if (wayPoint == null) {
            this.f7176e.add(0, new WayPoint(1, (Address) null));
        }
        if (wayPoint2 == null) {
            List<WayPoint> list = this.f7176e;
            list.add(list.size(), new WayPoint(3, (Address) null));
        }
    }

    /* renamed from: d */
    private void m4351d() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f7174c)) {
            this.f7174c.add(1);
            this.f7174c.add(2);
            this.f7174c.add(3);
        }
    }

    public List<WayPoint> getValidWayPoints() {
        return this.f7175d;
    }

    public List<WayPoint> getChangedWayPoints() {
        return this.f7178g;
    }

    public boolean canAddStop() {
        return this.f7177f.size() < 2;
    }

    /* renamed from: a */
    private void m4343a(WayPoint wayPoint) {
        if (wayPoint.valid()) {
            if (this.f7175d.indexOf(wayPoint) < 0) {
                this.f7175d.add(wayPoint);
            }
            updateSubmitStatus(this.f7175d);
        }
    }

    public boolean sortWayPoints() {
        List<WayPoint> list = this.f7175d;
        if (list == null || list.size() < 2) {
            return false;
        }
        Collections.sort(this.f7175d, new Comparator<WayPoint>() {
            public int compare(WayPoint wayPoint, WayPoint wayPoint2) {
                int wayPointType;
                int wayPointType2;
                if (wayPoint.getWayPointType() == wayPoint2.getWayPointType() && wayPoint2.getWayPointType() == 2) {
                    wayPointType = SugMapWayPointPagePresenter.this.getStopIndex(wayPoint);
                    wayPointType2 = SugMapWayPointPagePresenter.this.getStopIndex(wayPoint2);
                } else {
                    wayPointType = wayPoint.getWayPointType();
                    wayPointType2 = wayPoint2.getWayPointType();
                }
                return wayPointType - wayPointType2;
            }
        });
        List<WayPoint> list2 = this.f7175d;
        WayPoint wayPoint = list2.get(list2.size() - 1);
        if (wayPoint.getWayPointType() != 3) {
            wayPoint.setWayPointType(3);
        }
        return true;
    }

    public int getStopIndex(WayPoint wayPoint) {
        return this.f7177f.indexOf(wayPoint);
    }

    public void createStop() {
        if (canAddStop()) {
            WayPoint wayPoint = new WayPoint(2, (Address) null);
            m4347b(wayPoint);
            addToStopPoints(wayPoint);
            if (this.f7172a.addWayPoint(wayPoint)) {
                addToChangedWayPoints(wayPoint);
                this.f7172a.updateAddStopEnterVisible(findWayPointsByType(3, this.f7176e).get(0), canAddStop());
                return;
            }
            m4357h(wayPoint);
            m4356g(wayPoint);
        }
    }

    public boolean hasEditableStopPoint() {
        if (this.f7177f.isEmpty()) {
            return false;
        }
        for (WayPoint isEditable : this.f7177f) {
            if (isEditable.isEditable()) {
                return true;
            }
        }
        return false;
    }

    public void addToChangedWayPoints(WayPoint wayPoint) {
        if (wayPoint != null && wayPoint.valid()) {
            int indexOf = this.f7178g.indexOf(wayPoint);
            if (indexOf >= 0) {
                this.f7178g.set(indexOf, wayPoint);
            } else {
                this.f7178g.add(wayPoint);
            }
        }
    }

    /* renamed from: b */
    private void m4347b(WayPoint wayPoint) {
        if (wayPoint != null) {
            if (hasWayPointBy(this.f7176e, 3)) {
                List<WayPoint> list = this.f7176e;
                list.add(list.size() - 1, wayPoint);
            } else {
                this.f7176e.add(wayPoint);
            }
            m4343a(wayPoint);
        }
    }

    public void deleteWayPoint(WayPoint wayPoint) {
        if (wayPoint != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("del_lat", Double.valueOf(wayPoint.getAddress().getLatitude()));
            hashMap.put("del_lng", Double.valueOf(wayPoint.getAddress().getLongitude()));
            if (wayPoint.getWayPointType() == 2) {
                m4350c(wayPoint);
            } else if (wayPoint.getWayPointType() == 3) {
                m4352d(wayPoint);
            }
        }
    }

    /* renamed from: c */
    private void m4350c(WayPoint wayPoint) {
        if (this.f7172a.removeWayPoint(wayPoint)) {
            m4357h(wayPoint);
            m4356g(wayPoint);
            if (m4354e(wayPoint)) {
                m4355f(wayPoint);
            } else {
                addToChangedWayPoints(wayPoint);
            }
            this.f7172a.updateAddStopEnterVisible(findWayPointsByType(3, this.f7176e).get(0), canAddStop());
        }
    }

    /* renamed from: d */
    private void m4352d(WayPoint wayPoint) {
        if (this.f7172a.removeWayPoint(wayPoint)) {
            m4357h(wayPoint);
            m4356g(wayPoint);
            if (m4354e(wayPoint)) {
                m4355f(wayPoint);
            } else {
                addToChangedWayPoints(wayPoint);
            }
            this.f7172a.resetWayPointList();
        }
    }

    /* renamed from: e */
    private boolean m4354e(WayPoint wayPoint) {
        return this.f7178g.indexOf(wayPoint) >= 0;
    }

    /* renamed from: f */
    private void m4355f(WayPoint wayPoint) {
        this.f7178g.remove(wayPoint);
    }

    /* renamed from: g */
    private void m4356g(WayPoint wayPoint) {
        this.f7180i = this.f7177f.indexOf(wayPoint);
        this.f7177f.remove(wayPoint);
        if (this.f7177f.isEmpty()) {
            this.f7180i = -1;
        }
    }

    public void clearStopPoints() {
        this.f7177f.clear();
        this.f7180i = -1;
    }

    /* access modifiers changed from: protected */
    public boolean hasWayPointBy(List<WayPoint> list, int... iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            int i3 = iArr[i];
            Iterator<WayPoint> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getWayPointType() == i3) {
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                i2++;
            }
            i++;
        }
        if (iArr.length == i2) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    private void m4357h(WayPoint wayPoint) {
        this.f7176e.remove(wayPoint);
        this.f7175d.remove(wayPoint);
        updateSubmitStatus(this.f7175d);
    }

    public void addToStopPoints(WayPoint wayPoint) {
        int i = this.f7180i;
        if (i != -1) {
            this.f7177f.add(i, wayPoint);
        } else {
            this.f7177f.add(wayPoint);
        }
    }

    public void updateSubmitStatus(List<WayPoint> list) {
        if (this.f7172a != null) {
            boolean z = false;
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                this.f7172a.setSubmitEnable(false);
                return;
            }
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (WayPoint next : list) {
                if (CommonUtils.isValidLocation(next.getAddress())) {
                    if (next.getWayPointType() == 1) {
                        z2 = true;
                    } else if (next.getWayPointType() == 2) {
                        z3 = true;
                    } else if (next.getWayPointType() == 3) {
                        z4 = true;
                    }
                }
            }
            ISugWayPointPageView iSugWayPointPageView = this.f7172a;
            if (iSugWayPointPageView != null) {
                if (z2 && (z3 || z4)) {
                    z = true;
                }
                iSugWayPointPageView.setSubmitEnable(z);
            }
        }
    }

    /* renamed from: a */
    private List<WayPoint> m4341a(List<WayPoint> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (WayPoint next : list) {
            if (next.getWayPointType() != 2) {
                arrayList.add(next);
            } else if (i <= 2) {
                arrayList.add(next);
                i++;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<WayPoint> findWayPointsByType(int i, List<WayPoint> list) {
        ArrayList arrayList = new ArrayList();
        for (WayPoint next : list) {
            if (next.getWayPointType() == i) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void onAddressResult(Address address, WayPoint wayPoint) {
        m4344a(address, wayPoint);
    }

    /* renamed from: a */
    private void m4344a(Address address, WayPoint wayPoint) {
        if (address != null) {
            if (!m4345a(m4345a(address.poiId) ? address.uid : address.poiId)) {
                Address address2 = wayPoint.getAddress();
                wayPoint.setTripState(0);
                wayPoint.setAddress(address);
                m4343a(wayPoint);
                if (this.f7172a.updateWayPoint(wayPoint)) {
                    addToChangedWayPoints(wayPoint);
                } else {
                    wayPoint.setAddress(address2);
                    m4343a(wayPoint);
                }
                List<WayPoint> findWayPointsByType = findWayPointsByType(3, this.f7176e);
                if (findWayPointsByType != null && !findWayPointsByType.isEmpty()) {
                    this.f7172a.updateAddStopEnterVisible(findWayPointsByType.get(0), canAddStop());
                }
            }
        }
    }

    /* renamed from: a */
    private int m4340a(Address address, String str) {
        if (str == null) {
            return -1;
        }
        for (WayPoint next : this.f7176e) {
            if (str.equals(next.getAddress().poiId) && LatLngUtils.locateCorrect(new LatLng(next.getAddress().getLatitude(), next.getAddress().getLongitude()))) {
                return address.equals(next.getAddress()) ^ true ? 1 : 0;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private boolean m4345a(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }

    /* renamed from: b */
    private void m4348b(String str) {
        SystemUtils.log(4, "WayPointPresenterDebug", str, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.presenter.SugMapWayPointPagePresenter", 538);
    }
}
