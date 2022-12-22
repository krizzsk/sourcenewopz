package com.didi.component.comp_new_xpanel.presenter;

import android.os.Bundle;
import com.didi.component.common.base.ComponentType;
import com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter;
import com.didi.component.core.ComponentParams;

public class NewXpanelTripPresenter extends AbsNewXPanelPresenter {
    public NewXpanelTripPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public String[] getNativeCards() {
        return new String[]{ComponentType.EVALUATE_FIVE_STAR_ENTRANCE, ComponentType.EVALUATE_QUESTION_ENTRANCE, "travel_group_info_v2", ComponentType.DRIVER_BAR, ComponentType.OPERATION_PANEL, ComponentType.CANCEL_PANEL, ComponentType.RIDE_EXPECTATION, ComponentType.ANY_CAR_APPEND_LIST, ComponentType.FLEX_AUTOMATIC_MATCH_CARD, "passenger_newXpanel+bargainingCard_logic+bargaining_card", ComponentType.PAY_ENTRANCE_NEW_UI, ComponentType.XPANEL_CARPOOL_MATCHTOGO, ComponentType.XPANEL_CARPOOL_MATCHONTRIP, ComponentType.TRAVEL_GROUP_CARPOOL_INFO, ComponentType.XPANEL_PAX_BOARDING_MODIFY_CARD, ComponentType.TRAVEL_GROUP_NEW};
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getComponentIdByType(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 50
            java.lang.String r2 = "2"
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = 594603900(0x2370ef7c, float:1.3061139E-17)
            if (r0 == r1) goto L_0x0011
            goto L_0x0023
        L_0x0011:
            java.lang.String r0 = "driver_bar"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0023
            r0 = 0
            goto L_0x0024
        L_0x001b:
            boolean r0 = r5.equals(r2)
            if (r0 == 0) goto L_0x0023
            r0 = 1
            goto L_0x0024
        L_0x0023:
            r0 = -1
        L_0x0024:
            if (r0 == 0) goto L_0x002a
            if (r0 == r3) goto L_0x0029
            return r5
        L_0x0029:
            return r2
        L_0x002a:
            java.lang.String r5 = "new_driver_bar"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.comp_new_xpanel.presenter.NewXpanelTripPresenter.getComponentIdByType(java.lang.String):java.lang.String");
    }
}
