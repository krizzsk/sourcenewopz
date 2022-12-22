package com.didi.safetoolkit.api;

import android.content.Context;
import java.util.Map;

public interface ISfInfoService {
    Map<String, Object> getBaseParams(Context context);

    String getCarOrderId();

    String getCountryIsoCode();
}
