package com.didiglobal.passenger.aus.component;

import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.service.WaitRspServicePresenter;
import com.taxis99.R;

public class AusWaitRspServicePresenter extends WaitRspServicePresenter {
    public AusWaitRspServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void showWaitPspTimeNotify(String str) {
        String str2;
        if (this.mContext != null) {
            String string = this.mContext.getString(R.string.car_notify_wait_title_for_aus);
            if (GlobalApolloUtil.isNewWaitRspPushContent()) {
                str2 = this.mContext.getString(R.string.car_wait_rsp_al_tip_new);
            } else {
                str2 = this.mContext.getString(R.string.car_wait_rsp_al_tip_for_aus, new Object[]{str});
            }
            NotificationUtils.getInstance(this.mContext).showNotification(string, HighlightUtil.highlight(this.mContext, str2), true, true);
        }
    }
}
