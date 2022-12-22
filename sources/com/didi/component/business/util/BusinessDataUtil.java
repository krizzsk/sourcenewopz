package com.didi.component.business.util;

import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;

public class BusinessDataUtil {
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        if (m7695a(r2) == false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a5, code lost:
        if (m7695a(r2) == false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00da, code lost:
        if (m7695a(r1) == false) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010c, code lost:
        if (m7695a(r1) == false) goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getProductId() {
        /*
            com.didi.travel.psnger.model.response.CarOrder r0 = com.didi.component.business.util.CarOrderHelper.getOrder()
            if (r0 == 0) goto L_0x0011
            int r1 = r0.productid
            if (r1 <= 0) goto L_0x0011
            int r0 = r0.productid
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x001b
        L_0x0011:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            int r0 = r0.Bid
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L_0x001b:
            r1 = 0
            com.didi.component.business.data.form.PageCompDataTransfer r2 = com.didi.component.business.data.form.PageCompDataTransfer.getInstance()     // Catch:{ Exception -> 0x00a8 }
            com.didi.component.business.data.form.listener.ConfirmListener r2 = r2.getConfirmListener()     // Catch:{ Exception -> 0x00a8 }
            if (r2 == 0) goto L_0x00ac
            boolean r3 = r2.getIsAnyCar()     // Catch:{ Exception -> 0x00a8 }
            if (r3 == 0) goto L_0x00ac
            int r3 = r2.getCurrentPage()     // Catch:{ Exception -> 0x00a8 }
            r4 = 1
            if (r3 != r4) goto L_0x005f
            java.util.List r3 = r2.getSelectedAnyCarItems()     // Catch:{ Exception -> 0x00a8 }
            if (r3 == 0) goto L_0x00ac
            java.util.List r3 = r2.getSelectedAnyCarItems()     // Catch:{ Exception -> 0x00a8 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x00a8 }
            if (r3 <= 0) goto L_0x00ac
            java.util.List r2 = r2.getSelectedAnyCarItems()     // Catch:{ Exception -> 0x00a8 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x00a8 }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r2 = (com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel) r2     // Catch:{ Exception -> 0x00a8 }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r2 = r2.mAnyCarEstimateNetItem     // Catch:{ Exception -> 0x00a8 }
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r2 = r2.carConfig     // Catch:{ Exception -> 0x00a8 }
            int r2 = r2.carBussinessId     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00a8 }
            boolean r3 = m7695a(r2)     // Catch:{ Exception -> 0x00a8 }
            if (r3 != 0) goto L_0x00ac
        L_0x005d:
            r0 = r2
            goto L_0x00ac
        L_0x005f:
            r4 = 3
            if (r3 != r4) goto L_0x00ac
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r3 = r2.getSelectedSingleAnyCarItem()     // Catch:{ Exception -> 0x00a8 }
            if (r3 == 0) goto L_0x007d
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r2 = r2.getSelectedSingleAnyCarItem()     // Catch:{ Exception -> 0x00a8 }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r2 = r2.mAnyCarEstimateNetItem     // Catch:{ Exception -> 0x00a8 }
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r2 = r2.carConfig     // Catch:{ Exception -> 0x00a8 }
            int r2 = r2.carBussinessId     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00a8 }
            boolean r3 = m7695a(r2)     // Catch:{ Exception -> 0x00a8 }
            if (r3 != 0) goto L_0x00ac
            goto L_0x005d
        L_0x007d:
            java.util.List r3 = r2.getSelectedAnyCarItems()     // Catch:{ Exception -> 0x00a8 }
            if (r3 == 0) goto L_0x00ac
            java.util.List r3 = r2.getSelectedAnyCarItems()     // Catch:{ Exception -> 0x00a8 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x00a8 }
            if (r3 <= 0) goto L_0x00ac
            java.util.List r2 = r2.getSelectedAnyCarItems()     // Catch:{ Exception -> 0x00a8 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x00a8 }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r2 = (com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel) r2     // Catch:{ Exception -> 0x00a8 }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r2 = r2.mAnyCarEstimateNetItem     // Catch:{ Exception -> 0x00a8 }
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r2 = r2.carConfig     // Catch:{ Exception -> 0x00a8 }
            int r2 = r2.carBussinessId     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00a8 }
            boolean r3 = m7695a(r2)     // Catch:{ Exception -> 0x00a8 }
            if (r3 != 0) goto L_0x00ac
            goto L_0x005d
        L_0x00a8:
            r2 = move-exception
            r2.printStackTrace()
        L_0x00ac:
            com.didi.component.business.data.form.PageCompDataTransfer r2 = com.didi.component.business.data.form.PageCompDataTransfer.getInstance()     // Catch:{ Exception -> 0x010f }
            com.didi.component.business.data.form.listener.TripListener r2 = r2.getTripListener()     // Catch:{ Exception -> 0x010f }
            if (r2 == 0) goto L_0x0113
            boolean r3 = r2.getIsAnyCar()     // Catch:{ Exception -> 0x010f }
            if (r3 == 0) goto L_0x0113
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r3 = r2.getSelectedSingleAnyCarItem()     // Catch:{ Exception -> 0x010f }
            if (r3 == 0) goto L_0x00de
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r1 = r2.getSelectedSingleAnyCarItem()     // Catch:{ Exception -> 0x010f }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r1.mAnyCarEstimateNetItem     // Catch:{ Exception -> 0x010f }
            if (r1 == 0) goto L_0x0113
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r2 = r1.carConfig     // Catch:{ Exception -> 0x010f }
            if (r2 == 0) goto L_0x0113
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r1 = r1.carConfig     // Catch:{ Exception -> 0x010f }
            int r1 = r1.carBussinessId     // Catch:{ Exception -> 0x010f }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x010f }
            boolean r2 = m7695a(r1)     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x0113
        L_0x00dc:
            r0 = r1
            goto L_0x0113
        L_0x00de:
            java.util.List r3 = r2.getSelectedAnyCarItems()     // Catch:{ Exception -> 0x010f }
            if (r3 == 0) goto L_0x0113
            java.util.List r3 = r2.getSelectedAnyCarItems()     // Catch:{ Exception -> 0x010f }
            int r3 = r3.size()     // Catch:{ Exception -> 0x010f }
            if (r3 <= 0) goto L_0x0113
            java.util.List r2 = r2.getSelectedAnyCarItems()     // Catch:{ Exception -> 0x010f }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ Exception -> 0x010f }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r1 = (com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel) r1     // Catch:{ Exception -> 0x010f }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r1.mAnyCarEstimateNetItem     // Catch:{ Exception -> 0x010f }
            if (r1 == 0) goto L_0x0113
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r2 = r1.carConfig     // Catch:{ Exception -> 0x010f }
            if (r2 == 0) goto L_0x0113
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r1 = r1.carConfig     // Catch:{ Exception -> 0x010f }
            int r1 = r1.carBussinessId     // Catch:{ Exception -> 0x010f }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x010f }
            boolean r2 = m7695a(r1)     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x0113
            goto L_0x00dc
        L_0x010f:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0113:
            boolean r1 = m7695a(r0)
            if (r1 == 0) goto L_0x0130
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ride"
            int r1 = com.didi.component.business.util.BusinessUtils.getDefaultBusinessId(r1)
            r0.append(r1)
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0130:
            boolean r1 = m7695a(r0)
            if (r1 == 0) goto L_0x0138
            java.lang.String r0 = "30008"
        L_0x0138:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ProductId:"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.didi.component.common.util.GLog.m7964d(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.business.util.BusinessDataUtil.getProductId():java.lang.String");
    }

    public static int getProductIdInt() {
        try {
            return Integer.valueOf(getProductId()).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 30008;
        }
    }

    /* renamed from: a */
    private static boolean m7695a(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str) || "0".equals(str);
    }

    public static boolean isPriceValid(EstimateItemModel estimateItemModel) {
        return estimateItemModel != null && !Float.isNaN(estimateItemModel.feeNumber);
    }

    public static boolean isPriceValid(float f) {
        return !Float.isNaN(f) && f != 0.0f;
    }

    public static boolean isEstimateSuccessWithNoPrice(EstimateItemModel estimateItemModel) {
        return estimateItemModel != null && estimateItemModel.feeNumber < 0.0f;
    }

    public static boolean isBetterServiceCar(int i) {
        return isBetterServiceCar(String.valueOf(i));
    }

    public static boolean isBetterServiceCar(String str) {
        return TextUtils.equals(str, String.valueOf(20001)) || TextUtils.equals(str, String.valueOf(20002));
    }

    public static boolean isBetterServiceCar() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            return isBetterServiceCar(order.carLevel);
        }
        return isBetterServiceCar(FormStore.getInstance().getCarLevel());
    }

    public static boolean isOrderHasCancelFee(CarOrder carOrder) {
        if (carOrder == null) {
            return false;
        }
        if ((carOrder.carCancelTrip == null || !(carOrder.carCancelTrip.cancelType == 1 || carOrder.carCancelTrip.payType == 1)) && !(carOrder.status == 6 && carOrder.substatus == 6002)) {
            if (carOrder.status == 5) {
                return carOrder.substatus == 5002 || carOrder.substatus == 5003;
            }
            return false;
        }
    }

    public static boolean isTripCanceled(CarOrder carOrder) {
        return carOrder != null && ((carOrder.status == 5 && (carOrder.substatus == 5002 || carOrder.substatus == 5003)) || carOrder.status == 6 || carOrder.status == 2);
    }

    public static boolean isOrderClosedByMis(CarOrder carOrder) {
        return carOrder != null && carOrder.status == 3 && carOrder.substatus == 2001;
    }

    public static boolean isCancelFeeNeedPay() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return false;
        }
        if (isTripCanceled(order) || isOrderHasCancelFee(order) || isOrderClosedByMis(order)) {
            return true;
        }
        return false;
    }

    public static boolean isTripCanceledWithoutFee(CarOrder carOrder) {
        return carOrder != null && ((carOrder.status == 6 && carOrder.substatus == 6001) || ((carOrder.status == 2 && carOrder.substatus != 2003) || (carOrder.substatus == 2003 && carOrder.payResult == null)));
    }

    public static boolean isOrderClosedWithoutDriverService(CarOrder carOrder) {
        return carOrder.status == 2 && carOrder.substatus == 2005;
    }

    public static boolean isCarPoolLine(CarOrder carOrder) {
        return carOrder != null && carOrder.comboType == 4;
    }

    public static boolean isOpenRideOrder(CarOrder carOrder) {
        return carOrder != null && carOrder.comboType == 500;
    }

    public static boolean onInterceptOrderStatus(CarOrder carOrder, int i) {
        return CarOrderHelper.isWaitDriver() && i > carOrder.substatus;
    }

    public static boolean isCancelOrder(CarOrder carOrder) {
        if (carOrder == null) {
            return false;
        }
        int status = carOrder.getStatus();
        int subStatus = carOrder.getSubStatus();
        if (status != 2) {
            if (status != 5) {
                if (status != 6) {
                    return false;
                }
            } else if (5001 != subStatus) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean isEndService() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return false;
        }
        if (order.status == 2 || order.status == 6 || order.status == 5 || order.status == 3) {
            return true;
        }
        return false;
    }
}
