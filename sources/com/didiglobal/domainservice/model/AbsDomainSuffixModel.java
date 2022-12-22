package com.didiglobal.domainservice.model;

import android.text.TextUtils;
import org.json.JSONObject;

public abstract class AbsDomainSuffixModel {
    public static final DSMSerializer<AbsDomainSuffixModel> SERIALIZER = new DSMSerializer<AbsDomainSuffixModel>() {
        public JSONObject serialize(AbsDomainSuffixModel absDomainSuffixModel) {
            return AbsDomainSuffixModel.m36054a(absDomainSuffixModel.type).serialize(absDomainSuffixModel);
        }

        public AbsDomainSuffixModel deserialize(JSONObject jSONObject) {
            return AbsDomainSuffixModel.m36054a(jSONObject.optString("type")).deserialize(jSONObject);
        }
    };
    public static final String SUFFIX = "suffix";
    public static final String TYPE = "type";
    protected String suffix;
    protected String type;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.didiglobal.domainservice.model.DSMSerializer<? extends com.didiglobal.domainservice.model.AbsDomainSuffixModel> m36054a(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 104104(0x196a8, float:1.45881E-40)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 110992(0x1b190, float:1.55533E-40)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "pii"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "idc"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 0
            goto L_0x0025
        L_0x0024:
            r0 = -1
        L_0x0025:
            if (r0 == 0) goto L_0x0043
            if (r0 != r2) goto L_0x002c
            com.didiglobal.domainservice.model.DSMSerializer<com.didiglobal.domainservice.model.PiiDomainSuffixModel> r3 = com.didiglobal.domainservice.model.PiiDomainSuffixModel.SERIALIZER
            return r3
        L_0x002c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Action type not found - "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x0043:
            com.didiglobal.domainservice.model.DSMSerializer<com.didiglobal.domainservice.model.IdcDomainSuffixModel> r3 = com.didiglobal.domainservice.model.IdcDomainSuffixModel.SERIALIZER
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.domainservice.model.AbsDomainSuffixModel.m36054a(java.lang.String):com.didiglobal.domainservice.model.DSMSerializer");
    }

    public boolean illegal() {
        return TextUtils.isEmpty(this.type) || (TextUtils.equals(this.type, SuffixType.IDC) && TextUtils.equals(this.type, SuffixType.PII)) || TextUtils.isEmpty(this.suffix);
    }

    public String getSuffix() {
        return this.suffix;
    }

    public void setSuffix(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("-")) {
            str = str.substring(1);
        }
        this.suffix = str;
    }

    public String getSuffixWithHead() {
        if (!TextUtils.isEmpty(this.suffix) && this.suffix.startsWith("-")) {
            return this.suffix;
        }
        return "-" + this.suffix;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
