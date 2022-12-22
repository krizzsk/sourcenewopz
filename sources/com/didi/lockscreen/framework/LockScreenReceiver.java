package com.didi.lockscreen.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.lifecycle.XEngineLifeCycle;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didi.sdk.util.LockScreenUtilKt;
import com.didi.travel.psnger.model.response.CarOrder;

public class LockScreenReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        CarOrder order;
        if (XEngineLifeCycle.getInstance().isServiceEngineActive() && GlobalApolloUtils.isShowLockScreen() && LockScreenUtilKt.hasLockScreenMap(context) && (order = CarOrderHelper.getOrder()) != null && order.comboType != 4 && 21081 != order.productid && 21106 != order.productid) {
            int i = order.status;
            int i2 = order.substatus;
            if (i != 4) {
                return;
            }
            if ((i2 == 4001 || i2 == 4002 || i2 == 4003 || i2 == 4004 || i2 == 4005) && !LockScreenUtilKt.getLockScreenNotShow(context).equals(order.oid)) {
                Intent intent2 = new Intent(context, LockScreenActivity.class);
                intent2.addFlags(276824064);
                context.startActivity(intent2);
            }
        }
    }
}
