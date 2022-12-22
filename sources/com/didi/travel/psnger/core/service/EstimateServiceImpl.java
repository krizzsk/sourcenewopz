package com.didi.travel.psnger.core.service;

import android.content.Context;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.estimate.EstimateService;
import com.didi.travel.psnger.core.model.request.BaseEstimateParams;
import com.didi.travel.psnger.core.model.response.IEstimateModel;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({EstimateService.class})
public class EstimateServiceImpl implements EstimateService {
    public Object estimate(Context context, BaseEstimateParams baseEstimateParams, ResponseListener<? extends IEstimateModel> responseListener) {
        return null;
    }
}
