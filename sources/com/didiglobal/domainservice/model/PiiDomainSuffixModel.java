package com.didiglobal.domainservice.model;

import android.text.TextUtils;
import com.didiglobal.domainservice.utils.DomainUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PiiDomainSuffixModel extends AbsDomainSuffixModel {
    public static final DSMSerializer<PiiDomainSuffixModel> SERIALIZER = new DSMSerializer<PiiDomainSuffixModel>() {
        public JSONObject serialize(PiiDomainSuffixModel piiDomainSuffixModel) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", piiDomainSuffixModel.type);
                jSONObject.putOpt(AbsDomainSuffixModel.SUFFIX, piiDomainSuffixModel.suffix);
                jSONObject.putOpt(PiiDomainSuffixModel.URIS, new JSONArray(piiDomainSuffixModel.f50043a));
                jSONObject.putOpt("timeout", Integer.valueOf(piiDomainSuffixModel.f50044b));
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public PiiDomainSuffixModel deserialize(JSONObject jSONObject) {
            PiiDomainSuffixModel piiDomainSuffixModel = new PiiDomainSuffixModel();
            piiDomainSuffixModel.type = jSONObject.optString("type", (String) null);
            piiDomainSuffixModel.suffix = jSONObject.optString(AbsDomainSuffixModel.SUFFIX, (String) null);
            piiDomainSuffixModel.f50043a = DomainUtil.jsArrayToList(jSONObject.optJSONArray(PiiDomainSuffixModel.URIS));
            piiDomainSuffixModel.f50044b = jSONObject.optInt("timeout", 0);
            return piiDomainSuffixModel;
        }
    };
    public static final String TIMEOUT = "timeout";
    public static final String URIS = "uris";

    /* renamed from: a */
    List<String> f50043a;

    /* renamed from: b */
    int f50044b = 0;

    public PiiDomainSuffixModel() {
        this.type = SuffixType.PII;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = r2.f50044b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean illegal() {
        /*
            r2 = this;
            boolean r0 = super.illegal()
            if (r0 != 0) goto L_0x0019
            java.util.List<java.lang.String> r0 = r2.f50043a
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0019
            int r0 = r2.f50044b
            r1 = 10
            if (r0 > r1) goto L_0x0019
            if (r0 >= 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.domainservice.model.PiiDomainSuffixModel.illegal():boolean");
    }

    public boolean containUri(String str) {
        if (!illegal() && !TextUtils.isEmpty(str)) {
            for (String contains : this.f50043a) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> getUris() {
        return this.f50043a;
    }

    public void setUris(List<String> list) {
        this.f50043a = list;
    }

    public int getTimeout() {
        return this.f50044b;
    }

    public void setTimeout(int i) {
        this.f50044b = i;
    }
}
