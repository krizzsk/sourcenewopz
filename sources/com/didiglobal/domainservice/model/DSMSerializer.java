package com.didiglobal.domainservice.model;

import com.didiglobal.domainservice.model.AbsDomainSuffixModel;
import org.json.JSONObject;

public interface DSMSerializer<T extends AbsDomainSuffixModel> {
    T deserialize(JSONObject jSONObject);

    JSONObject serialize(T t);
}
