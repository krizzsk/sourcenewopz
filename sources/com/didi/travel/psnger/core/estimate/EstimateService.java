package com.didi.travel.psnger.core.estimate;

import android.content.Context;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.request.BaseEstimateParams;
import com.didi.travel.psnger.core.model.response.IEstimateModel;

public interface EstimateService {
    Object estimate(Context context, BaseEstimateParams baseEstimateParams, ResponseListener<? extends IEstimateModel> responseListener);
}
