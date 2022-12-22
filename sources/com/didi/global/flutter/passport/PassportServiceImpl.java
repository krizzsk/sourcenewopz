package com.didi.global.flutter.passport;

import android.text.TextUtils;
import com.didi.component.common.net.CarRequest;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.ActivityResInfo;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.service.IPassportService;
import com.didi.unifylogin.base.service.PassportServiceListener;
import com.didi.unifylogin.base.service.model.DataJsonWrapper;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IPassportService.class})
public class PassportServiceImpl implements IPassportService {
    public void onVerifyCodeReceived(String str, PassportServiceListener<BaseResponse> passportServiceListener) {
    }

    public void getHeadActivityRes(final PassportServiceListener<DataJsonWrapper> passportServiceListener) {
        CarRequest.getActivityRes(DIDIBaseApplication.getAppContext(), CarRequest.RESOURCE_NAME_G_PAS_SIGN_UP_BANNER, new ResponseListener<ActivityResInfo>() {
            public void onFinish(ActivityResInfo activityResInfo) {
                if (!TextUtils.isEmpty(activityResInfo.json)) {
                    passportServiceListener.onSuccess(new DataJsonWrapper(activityResInfo.json));
                } else {
                    passportServiceListener.onFail();
                }
            }
        });
    }
}
