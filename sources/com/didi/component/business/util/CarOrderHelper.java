package com.didi.component.business.util;

import com.didi.component.business.data.form.FormStore;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.travel.psnger.utils.NumberUtil;

public class CarOrderHelper {

    /* renamed from: a */
    private static final int f11373a = 1;

    /* renamed from: b */
    private static final int f11374b = 2;

    /* renamed from: c */
    private static String f11375c = "";

    public static void fillOrder(CarOrder carOrder, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("fillOrder:order = ");
        sb.append(carOrder);
        sb.append(", orderId = ");
        sb.append(TravelUtil.getRichOid(carOrder == null ? "" : carOrder.oid));
        LogUtils.m31492e("CarOrderHelper", sb.toString());
        FormStore instance = FormStore.getInstance();
        carOrder.transportTime = instance.getTransportTime();
        carOrder.startAddress = instance.getStartAddress();
        carOrder.endAddress = instance.getEndAddress();
        carOrder.orderType = carOrder.transportTime > 0 ? 1 : 0;
        carOrder.productid = i;
        carOrder.carLevel = String.valueOf(instance.getCarLevel());
        carOrder.payType = NumberUtil.parseInt(instance.getPayWay());
        carOrder.comboType = instance.getCurrentComboType();
        PaymentAssist.getInstance().mCarEstimateItem = instance.getEstimateItem();
        PaymentAssist.getInstance().mSelectPayments = instance.getPayWay();
        if (EstimateUtils.isFixedPricingTypeShowing()) {
            carOrder.countPriceType = 101;
        }
        DDTravelOrderStore.setOrder(carOrder);
        TravelUtil.setCarOrder(carOrder);
        GlobalOmegaUtils.putGlobal("g_ComboType", Integer.valueOf(carOrder.comboType));
    }

    public static void fillFormStore(CarOrder carOrder, boolean z) {
        if (carOrder != null) {
            FormStore instance = FormStore.getInstance();
            instance.setStartAddress(carOrder.startAddress);
            instance.setDepartureAddress(carOrder.startAddress);
            instance.setEndAddress(carOrder.endAddress);
            instance.setTransportTime(carOrder.transportTime);
            instance.setEstimateModelTraceId("");
            if (!TextUtil.isEmpty(PaymentAssist.getInstance().mSelectPayments)) {
                instance.setPayWay(PaymentAssist.getInstance().mSelectPayments);
            }
            instance.setData(FormStore.KEY_RECALL_ORDER, Boolean.valueOf(z));
            int i = -1;
            try {
                if (!TextUtil.isEmpty(carOrder.carPoolOrderScene)) {
                    i = NumberUtil.parseInt(carOrder.carPoolOrderScene);
                }
                instance.setCarTypeInfo(carOrder.productid, carOrder.comboType, Integer.parseInt(carOrder.carLevel), i);
            } catch (Exception unused) {
            }
            instance.setEstimateItem(PaymentAssist.getInstance().mCarEstimateItem);
            GlobalOmegaUtils.putGlobal("g_ComboType", Integer.valueOf(carOrder.comboType));
        }
    }

    public static synchronized CarOrder getOrder() {
        CarOrder carOrder;
        Class<CarOrderHelper> cls = CarOrderHelper.class;
        synchronized (cls) {
            carOrder = (CarOrder) DDTravelOrderStore.getOrder();
            TravelUtil.checkSessionCarOrder(cls.getSimpleName() + ".getOrder", carOrder);
        }
        return carOrder;
    }

    public static synchronized void saveOrder(CarOrder carOrder) {
        synchronized (CarOrderHelper.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("saveOrder:order = ");
            sb.append(carOrder);
            sb.append(", orderId = ");
            sb.append(TravelUtil.getRichOid(carOrder == null ? "" : carOrder.oid));
            LogUtils.m31492e("CarOrderHelper", sb.toString());
            if (carOrder != null) {
                GlobalOmegaUtils.putGlobal("g_ComboType", Integer.valueOf(carOrder.comboType));
            }
            DDTravelOrderStore.setOrder(carOrder);
            TravelUtil.setCarOrder(carOrder);
        }
    }

    public static int getOrderStatus() {
        CarOrder order = getOrder();
        if (order == null) {
            return 0;
        }
        return order.status;
    }

    public static int getOrderSubStatus() {
        CarOrder order = getOrder();
        if (order == null) {
            return 0;
        }
        return order.substatus;
    }

    public static boolean isOrderEnd() {
        CarOrder order = getOrder();
        if (order == null) {
            return false;
        }
        if (order.status == 3 || order.status == 5) {
            return true;
        }
        return false;
    }

    public static boolean isOnService() {
        CarOrder order = getOrder();
        if (order == null || 4 != order.status) {
            return false;
        }
        if (4005 == order.substatus || 4006 == order.substatus) {
            return true;
        }
        return false;
    }

    public static boolean isWaitDriver() {
        CarOrder order = getOrder();
        if (order == null || 4 != order.status) {
            return false;
        }
        if (4001 == order.substatus || 4002 == order.substatus || 4003 == order.substatus || 4004 == order.substatus || 4007 == order.substatus) {
            return true;
        }
        return false;
    }

    public static boolean isDriverArrival() {
        CarOrder order = getOrder();
        if (order == null || 4 != order.status) {
            return false;
        }
        if (4003 == order.substatus || 4004 == order.substatus || 4007 == order.substatus) {
            return true;
        }
        return false;
    }

    public static boolean isOrderStatusNeedDashCamClosed() {
        CarOrder order = getOrder();
        if (order == null) {
            return false;
        }
        if ((4 == order.status && 4006 == order.substatus) || 3 == order.status || 5 == order.status || 6 == order.status) {
            return true;
        }
        return false;
    }

    public static int getReAssignOrderType() {
        CarOrder order = getOrder();
        if (order == null || order.assignResult == null) {
            return 1;
        }
        return 2;
    }

    public static boolean isQuotaOrder() {
        CarOrder order = getOrder();
        if (order == null || order.isCapPrice != 1) {
            return false;
        }
        return true;
    }

    public static boolean isCarPoolLineHaveOrder() {
        CarOrder order = getOrder();
        if (order == null) {
            return FormStore.getInstance().isCarPoolLineBeforeHaveOrder();
        }
        return BusinessDataUtil.isCarPoolLine(order);
    }

    public static boolean isUseNewCard() {
        CarOrder order = getOrder();
        if (order == null || order.carDriver == null || order.carDriver.useNewCard == 1) {
            return true;
        }
        return false;
    }

    public static int getOrderCode() {
        CarOrder order = getOrder();
        if (order == null || order.orderState == null) {
            return 0;
        }
        return order.orderState.code;
    }

    public static void setReassignOid(String str) {
        f11375c = str;
    }

    public static String getReassignOrderId() {
        return f11375c;
    }

    public static long getOrderCreateTime() {
        CarOrder order = getOrder();
        if (order == null) {
            return 0;
        }
        return order.getCreateTime();
    }

    public static boolean isAssignOrder() {
        CarOrder order = getOrder();
        return (order == null || order.assignResult == null) ? false : true;
    }

    public static String getOrderId() {
        CarOrder order = getOrder();
        return order != null ? order.getOid() : "";
    }
}
