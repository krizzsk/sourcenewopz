package com.didi.dimina.container.service;

import com.didi.dimina.container.DMMina;
import org.json.JSONObject;

public interface FirstFetchService {
    JSONObject getFirstTokenTogether(DMMina dMMina);

    void requestFirstTogether(DMMina dMMina);
}
