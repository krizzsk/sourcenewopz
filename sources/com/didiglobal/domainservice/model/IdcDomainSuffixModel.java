package com.didiglobal.domainservice.model;

import org.json.JSONException;
import org.json.JSONObject;

public class IdcDomainSuffixModel extends AbsDomainSuffixModel {
    public static final DSMSerializer<IdcDomainSuffixModel> SERIALIZER = new DSMSerializer<IdcDomainSuffixModel>() {
        public JSONObject serialize(IdcDomainSuffixModel idcDomainSuffixModel) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", idcDomainSuffixModel.type);
                jSONObject.putOpt(AbsDomainSuffixModel.SUFFIX, idcDomainSuffixModel.suffix);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public IdcDomainSuffixModel deserialize(JSONObject jSONObject) {
            IdcDomainSuffixModel idcDomainSuffixModel = new IdcDomainSuffixModel((String) null);
            idcDomainSuffixModel.type = jSONObject.optString("type", (String) null);
            idcDomainSuffixModel.suffix = jSONObject.optString(AbsDomainSuffixModel.SUFFIX, (String) null);
            return idcDomainSuffixModel;
        }
    };

    public IdcDomainSuffixModel(String str) {
        this.type = SuffixType.IDC;
        setSuffix(str);
    }
}
