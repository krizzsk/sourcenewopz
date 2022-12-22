package com.didi.component.traveldetail.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.util.OnServiceOmegaUtil;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.traveldetail.AbsTravelDetailPresenterV2;
import com.didi.component.traveldetail.ITravelDetailViewV2;
import com.didi.component.traveldetail.model.TravelDetailItemV2;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TravelDetailPresenterV2 extends AbsTravelDetailPresenterV2 {

    /* renamed from: a */
    private String f16155a = "TravelDetailPresenterV2";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Boolean f16156b = true;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<JSONObject> f16157c = new BaseEventPublisher.OnEventListener<JSONObject>() {
        public void onEvent(String str, JSONObject jSONObject) {
            List<TravelDetailItemV2> buildTravelDetailData;
            if (TextUtils.equals(str, BaseEventKeys.OnService.EVENT_SHOW_GROUP_INFO_V2) && TravelDetailPresenterV2.this.mView != null && (buildTravelDetailData = TravelDetailPresenterV2.this.buildTravelDetailData(jSONObject)) != null) {
                ((ITravelDetailViewV2) TravelDetailPresenterV2.this.mView).setTravelDetailData(buildTravelDetailData);
            }
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<Integer> f16158d = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (TextUtils.equals(str, BaseEventKeys.XPanel.EVENT_NEW_XPANEL_STATUS) && TravelDetailPresenterV2.this.mView != null) {
                ((ITravelDetailViewV2) TravelDetailPresenterV2.this.mView).doXPanelStatusChanged(num.intValue());
            }
        }
    };

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<Object> f16159e = new BaseEventPublisher.OnEventListener<Object>() {
        public void onEvent(String str, Object obj) {
            if (TextUtils.equals(str, BaseEventKeys.RouteEditor.EVENT_WAY_POINTS_CHANGED)) {
                TravelDetailPresenterV2.this.m11846b();
                TravelDetailPresenterV2.this.doPublish(BaseEventKeys.NewXpanel.EVENT_REFRESH_XPANEL_NEW);
            }
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16160f = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(str, BaseEventKeys.OnService.EVENT_UPDATE_WAY_POINT)) {
                TravelDetailPresenterV2.this.doPublish(BaseEventKeys.NewXpanel.EVENT_REFRESH_XPANEL_NEW);
            }
        }
    };

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<Boolean> f16161g = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (TextUtils.equals(str, BaseEventKeys.OnService.EVENT_SHOW_EDIT_GUIDE)) {
                Boolean unused = TravelDetailPresenterV2.this.f16156b = bool;
                if (bool.booleanValue()) {
                    ((ITravelDetailViewV2) TravelDetailPresenterV2.this.mView).hideGuide();
                } else {
                    ((ITravelDetailViewV2) TravelDetailPresenterV2.this.mView).showGuide();
                }
            }
        }
    };

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042 A[Catch:{ JSONException -> 0x00e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c A[Catch:{ JSONException -> 0x00e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094 A[Catch:{ JSONException -> 0x00e5 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m11846b() {
        /*
            r14 = this;
            java.lang.String r0 = "0"
            java.lang.String r1 = "status"
            com.didi.travel.psnger.model.response.CarOrder r2 = com.didi.component.business.util.CarOrderHelper.getOrder()
            if (r2 != 0) goto L_0x000b
            return
        L_0x000b:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e5 }
            r3.<init>()     // Catch:{ JSONException -> 0x00e5 }
            com.didi.sdk.address.address.entity.Address r4 = r2.startAddress     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r5 = ""
            java.lang.String r6 = "address"
            if (r4 == 0) goto L_0x0026
            com.didi.sdk.address.address.entity.Address r4 = r2.startAddress     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r4 = r4.displayName     // Catch:{ JSONException -> 0x00e5 }
            if (r4 == 0) goto L_0x0026
            com.didi.sdk.address.address.entity.Address r4 = r2.startAddress     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r4 = r4.displayName     // Catch:{ JSONException -> 0x00e5 }
            r3.put(r6, r4)     // Catch:{ JSONException -> 0x00e5 }
            goto L_0x0029
        L_0x0026:
            r3.put(r6, r5)     // Catch:{ JSONException -> 0x00e5 }
        L_0x0029:
            r3.put(r1, r0)     // Catch:{ JSONException -> 0x00e5 }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00e5 }
            r4.<init>()     // Catch:{ JSONException -> 0x00e5 }
            java.util.List<com.didi.address.model.WayPoint> r7 = r2.wayPointList     // Catch:{ JSONException -> 0x00e5 }
            if (r7 == 0) goto L_0x007d
            int r8 = r7.size()     // Catch:{ JSONException -> 0x00e5 }
            if (r8 <= 0) goto L_0x007d
            r8 = 0
        L_0x003c:
            int r9 = r7.size()     // Catch:{ JSONException -> 0x00e5 }
            if (r8 >= r9) goto L_0x007d
            java.lang.Object r9 = r7.get(r8)     // Catch:{ JSONException -> 0x00e5 }
            com.didi.address.model.WayPoint r9 = (com.didi.address.model.WayPoint) r9     // Catch:{ JSONException -> 0x00e5 }
            com.didi.sdk.address.address.entity.Address r9 = r9.getAddress()     // Catch:{ JSONException -> 0x00e5 }
            if (r9 == 0) goto L_0x007a
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e5 }
            r10.<init>()     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r11 = r9.address     // Catch:{ JSONException -> 0x00e5 }
            r10.put(r6, r11)     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r11 = "lat"
            double r12 = r9.latitude     // Catch:{ JSONException -> 0x00e5 }
            r10.put(r11, r12)     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r11 = "lng"
            double r12 = r9.longitude     // Catch:{ JSONException -> 0x00e5 }
            r10.put(r11, r12)     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r11 = "name"
            java.lang.String r12 = r9.displayName     // Catch:{ JSONException -> 0x00e5 }
            r10.put(r11, r12)     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r11 = "poi_id"
            java.lang.String r9 = r9.poiId     // Catch:{ JSONException -> 0x00e5 }
            r10.put(r11, r9)     // Catch:{ JSONException -> 0x00e5 }
            r10.put(r1, r0)     // Catch:{ JSONException -> 0x00e5 }
            r4.put(r10)     // Catch:{ JSONException -> 0x00e5 }
        L_0x007a:
            int r8 = r8 + 1
            goto L_0x003c
        L_0x007d:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e5 }
            r7.<init>()     // Catch:{ JSONException -> 0x00e5 }
            com.didi.sdk.address.address.entity.Address r8 = r2.endAddress     // Catch:{ JSONException -> 0x00e5 }
            if (r8 == 0) goto L_0x0094
            com.didi.sdk.address.address.entity.Address r8 = r2.endAddress     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r8 = r8.displayName     // Catch:{ JSONException -> 0x00e5 }
            if (r8 == 0) goto L_0x0094
            com.didi.sdk.address.address.entity.Address r2 = r2.endAddress     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r2 = r2.displayName     // Catch:{ JSONException -> 0x00e5 }
            r7.put(r6, r2)     // Catch:{ JSONException -> 0x00e5 }
            goto L_0x0097
        L_0x0094:
            r7.put(r6, r5)     // Catch:{ JSONException -> 0x00e5 }
        L_0x0097:
            r7.put(r1, r0)     // Catch:{ JSONException -> 0x00e5 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e5 }
            r0.<init>()     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r1 = "startAddress"
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r1 = "wayPoints"
            r0.put(r1, r4)     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r1 = "endAddress"
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x00e5 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e5 }
            r1.<init>()     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r2 = "data"
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x00e5 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e5 }
            r0.<init>()     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r2 = "normal"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00e5 }
            com.didi.component.core.IView r2 = r14.mView     // Catch:{ JSONException -> 0x00e5 }
            com.didi.component.traveldetail.ITravelDetailViewV2 r2 = (com.didi.component.traveldetail.ITravelDetailViewV2) r2     // Catch:{ JSONException -> 0x00e5 }
            java.util.List r0 = r14.buildTravelDetailData(r0)     // Catch:{ JSONException -> 0x00e5 }
            r2.setTravelDetailData(r0)     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r0 = r14.f16155a     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r2 = r1.toString()     // Catch:{ JSONException -> 0x00e5 }
            com.didi.component.common.util.GLog.m7965d(r0, r2)     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r0 = r14.f16155a     // Catch:{ JSONException -> 0x00e5 }
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ JSONException -> 0x00e5 }
            r2.<init>()     // Catch:{ JSONException -> 0x00e5 }
            java.lang.String r1 = r2.toJson((java.lang.Object) r1)     // Catch:{ JSONException -> 0x00e5 }
            com.didi.component.common.util.GLog.m7965d(r0, r1)     // Catch:{ JSONException -> 0x00e5 }
            goto L_0x00e9
        L_0x00e5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.traveldetail.impl.TravelDetailPresenterV2.m11846b():void");
    }

    public TravelDetailPresenterV2(Context context) {
        super(context);
    }

    public void onEditClick() {
        if (!GlobalApolloUtil.isRouteEditorEnable() || CarOrderHelper.isCarPoolLineHaveOrder()) {
            m11848c();
        } else {
            m11850d();
        }
    }

    /* renamed from: c */
    private void m11848c() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.updateDest != null) {
            if (order.updateDest.updateDestIsOk == 0) {
                doPublish(BaseEventKeys.OnService.EVENT_SHOW_SUG_PAGE_DEST);
            } else {
                m11842a(order.updateDest.updateDestTitle, order.updateDest.updateDestText);
            }
        }
    }

    /* renamed from: a */
    private void m11842a(String str, String str2) {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(3);
        normalDialogInfo.setTitle(str);
        normalDialogInfo.setMessage(str2);
        normalDialogInfo.setPositiveText(ResourcesHelper.getString(this.mContext, R.string.global_update_dest_confirm_ok));
        normalDialogInfo.setCancelable(false);
        showDialog(normalDialogInfo);
    }

    /* renamed from: d */
    private void m11850d() {
        GlobalOmegaUtils.trackEvent("gp_editRoute_ck");
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.updateWayPoint != null) {
            if (order.updateWayPoint.updateIsOk == 0) {
                doPublish(BaseEventKeys.OnService.EVENT_SHOW_ROUTE_EDITOR_PAGE);
            } else if (order.updateWayPoint.updateIsOk == 1) {
                if (!TextUtils.isEmpty(order.updateWayPoint.updateText)) {
                    ToastHelper.showShortInfo(this.mContext, order.updateWayPoint.updateText, (int) R.drawable.global_ic_toast_fail);
                } else {
                    ToastHelper.showShortInfo(this.mContext, this.mContext.getString(R.string.global_waypoint_drivecar_unsupport), (int) R.drawable.global_ic_toast_fail);
                }
                OnServiceOmegaUtil.sendNotSupportWayPointOmage(2, order);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m11851e();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m11854f();
    }

    /* renamed from: e */
    private void m11851e() {
        subscribe(BaseEventKeys.OnService.EVENT_SHOW_GROUP_INFO_V2, this.f16157c);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.RouteEditor.EVENT_WAY_POINTS_CHANGED, this.f16159e);
        subscribe(BaseEventKeys.XPanel.EVENT_NEW_XPANEL_STATUS, this.f16158d);
        subscribe(BaseEventKeys.OnService.EVENT_UPDATE_WAY_POINT, this.f16160f);
        subscribe(BaseEventKeys.OnService.EVENT_SHOW_EDIT_GUIDE, this.f16161g);
    }

    /* renamed from: f */
    private void m11854f() {
        unsubscribe(BaseEventKeys.OnService.EVENT_SHOW_GROUP_INFO_V2, this.f16157c);
        unsubscribe(BaseEventKeys.RouteEditor.EVENT_WAY_POINTS_CHANGED, this.f16159e);
        unsubscribe(BaseEventKeys.XPanel.EVENT_NEW_XPANEL_STATUS, this.f16158d);
        unsubscribe(BaseEventKeys.OnService.EVENT_UPDATE_WAY_POINT, this.f16160f);
        unsubscribe(BaseEventKeys.OnService.EVENT_SHOW_EDIT_GUIDE, this.f16161g);
    }

    public boolean getShowEditGuideNow() {
        return this.f16156b.booleanValue();
    }

    public List<TravelDetailItemV2> buildTravelDetailData(JSONObject jSONObject) {
        TravelDetailItemV2 a;
        ArrayList arrayList = null;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("normal").optJSONObject("data");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("startAddress");
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("endAddress");
            JSONArray optJSONArray = optJSONObject.optJSONArray("wayPoints");
            ArrayList arrayList2 = new ArrayList();
            if (optJSONObject2 != null) {
                try {
                    TravelDetailItemV2 a2 = m11840a(optJSONObject2, "1");
                    if (a2 != null) {
                        arrayList2.add(a2);
                    }
                } catch (JSONException e) {
                    e = e;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TravelDetailItemV2 a3 = m11840a(optJSONArray.getJSONObject(i), "3");
                    if (a3 != null) {
                        arrayList2.add(a3);
                    }
                }
            }
            if (!(optJSONObject3 == null || (a = m11840a(optJSONObject3, "2")) == null)) {
                arrayList2.add(a);
            }
            m11843a((List<TravelDetailItemV2>) arrayList2);
            return arrayList2;
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            return arrayList;
        }
    }

    /* renamed from: a */
    private void m11843a(List<TravelDetailItemV2> list) {
        CarOrder order;
        if (list != null && !list.isEmpty() && (order = CarOrderHelper.getOrder()) != null) {
            if (CarOrderHelper.isOnService()) {
                if (order.wayPointList == null || order.wayPointList.size() <= 0) {
                    if (list.size() > 1) {
                        list.get(1).isPlay = true;
                    }
                } else if (order.wayPointList.size() == 1 && order.wayPointList.get(0).getTripState() == 0) {
                    if (list.size() > 1) {
                        list.get(1).isPlay = true;
                    }
                } else if (order.wayPointList.size() == 2 && order.wayPointList.get(0).getTripState() == 0) {
                    if (list.size() > 2) {
                        list.get(1).isPlay = true;
                    }
                } else if (order.wayPointList.size() == 2 && order.wayPointList.get(1).getTripState() == 0) {
                    if (list.size() > 3) {
                        list.get(2).isPlay = true;
                    }
                } else if (list.size() > 3) {
                    list.get(3).isPlay = true;
                } else if (list.size() > 2) {
                    list.get(2).isPlay = true;
                }
            } else if ((order.substatus == 4003 || order.substatus == 4004) && list.size() > 1) {
                list.get(0).isPlay = true;
            }
        }
    }

    /* renamed from: a */
    private TravelDetailItemV2 m11840a(JSONObject jSONObject, String str) {
        try {
            TravelDetailItemV2 travelDetailItemV2 = new TravelDetailItemV2();
            travelDetailItemV2.addressType = str;
            travelDetailItemV2.title = jSONObject.optString("address", "");
            String str2 = "0";
            if (!CarOrderHelper.isOnService()) {
                boolean isOrderEnd = CarOrderHelper.isOrderEnd();
            } else if (str == "3") {
                str2 = jSONObject.optString("status", str2);
            } else if (str == "1") {
                str2 = "1";
            }
            travelDetailItemV2.iconRes = m11844b(str2, str);
            travelDetailItemV2.needAsh = TextUtils.equals("1", str2);
            return travelDetailItemV2;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    private int m11844b(String str, String str2) {
        if (TextUtils.equals(str, "1")) {
            return TextUtils.equals(str2, "3") ? R.drawable.global_com_icon_mark_dis : R.drawable.global_com_icon_pickup_dis;
        }
        if (TextUtils.equals(str2, "1")) {
            return R.drawable.global_com_icon_pickup;
        }
        if (TextUtils.equals(str2, "3")) {
            return R.drawable.global_com_icon_orange_stop;
        }
        if (TextUtils.equals(str2, "2")) {
            return R.drawable.global_com_icon_distination;
        }
        return R.drawable.global_com_icon_pickup;
    }
}
