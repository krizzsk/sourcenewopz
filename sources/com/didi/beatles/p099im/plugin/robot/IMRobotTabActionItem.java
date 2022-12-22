package com.didi.beatles.p099im.plugin.robot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.plugin.robot.widget.IMRobotBtmTabContentView;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeReturn;
import com.didi.beatles.p099im.protocol.host.IMTabInvokeEnv;
import com.didi.beatles.p099im.protocol.model.IMTabActionItem;

/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotTabActionItem */
public class IMRobotTabActionItem extends IMTabActionItem {
    public IMRobotTabActionItem(Context context, IMTabInvokeEnv iMTabInvokeEnv) {
        super(3, new IMRobotBtmTabContentView(context, (AttributeSet) null, iMTabInvokeEnv));
    }

    public IMActionInvokeReturn invokeAction(Context context, IMActionInvokeEnv iMActionInvokeEnv) {
        IMRobotConstant.setData(iMActionInvokeEnv.getOrderId(), iMActionInvokeEnv.getBusinessTraceParam(), iMActionInvokeEnv.getActionSource());
        IMRobotGuideHelper.onClickRedDot(context, IMCommonContextInfoHelper.getUid(), getPluginId());
        IMActionInvokeReturn iMActionInvokeReturn = new IMActionInvokeReturn();
        IMRobotPanelView iMRobotPanelView = new IMRobotPanelView(context, iMActionInvokeEnv);
        iMRobotPanelView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        iMActionInvokeReturn.containView = iMRobotPanelView;
        return iMActionInvokeReturn;
    }
}
