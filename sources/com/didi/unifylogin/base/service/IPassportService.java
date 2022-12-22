package com.didi.unifylogin.base.service;

import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.service.model.DataJsonWrapper;

public interface IPassportService {
    void getHeadActivityRes(PassportServiceListener<DataJsonWrapper> passportServiceListener);

    void onVerifyCodeReceived(String str, PassportServiceListener<BaseResponse> passportServiceListener);
}
