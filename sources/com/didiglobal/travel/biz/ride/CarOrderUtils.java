package com.didiglobal.travel.biz.ride;

import com.didi.travel.psnger.model.response.CarOrder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, mo175978d2 = {"isInBooking", "", "Lcom/didi/travel/psnger/model/response/CarOrder;", "common_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarOrderUtils.kt */
public final class CarOrderUtils {
    public static final boolean isInBooking(CarOrder carOrder) {
        boolean z;
        boolean z2;
        boolean z3;
        Integer valueOf = carOrder == null ? null : Integer.valueOf(carOrder.substatus);
        if ((valueOf != null && valueOf.intValue() == 7005) || (valueOf != null && valueOf.intValue() == 7003)) {
            z = true;
        } else {
            z = false;
        }
        if (!z && (valueOf == null || valueOf.intValue() != 7004)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 && (valueOf == null || valueOf.intValue() != 7007)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3 && (valueOf == null || valueOf.intValue() != 7008)) {
            return false;
        }
        return true;
    }
}
