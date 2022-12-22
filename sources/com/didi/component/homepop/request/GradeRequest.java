package com.didi.component.homepop.request;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.bff.callback_adapter.BffTravelCallbackAdapter;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.grade.model.GradeUpdateModel;
import com.didi.travel.psnger.common.net.base.ResponseListener;

public class GradeRequest implements HomePopupRequest {
    public void cancelGroup() {
    }

    public void requestByService(Context context, String str) {
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_MEMBER_UPGRADE_POP).setCallback(new BffTravelCallbackAdapter(new ResponseListener<GradeUpdateModel>() {
            public void onSuccess(GradeUpdateModel gradeUpdateModel) {
                super.onSuccess(gradeUpdateModel);
                if (gradeUpdateModel != null && !TextUtils.isEmpty(gradeUpdateModel.bgImg)) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Home.SHOW_GRADE_UPDATE_DIALOG, gradeUpdateModel);
                }
            }

            public void onError(GradeUpdateModel gradeUpdateModel) {
                super.onError(gradeUpdateModel);
            }

            public void onFail(GradeUpdateModel gradeUpdateModel) {
                super.onFail(gradeUpdateModel);
            }
        }, context)).setServiceId(str).build());
    }

    public void closeWindow() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Home.HIDE_GRADE_UPDATE_DIALOG);
    }
}
