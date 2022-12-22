package com.didiglobal.domainservice;

import android.content.Context;
import android.text.TextUtils;
import com.didiglobal.domainservice.model.AbsDomainSuffixModel;
import com.didiglobal.domainservice.model.IdcDomainSuffixModel;
import com.didiglobal.domainservice.model.PiiDomainSuffixModel;
import com.didiglobal.domainservice.model.SuffixType;
import com.didiglobal.domainservice.utils.ELog;
import com.didiglobal.domainservice.utils.SharedPrefUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class DomainStore {

    /* renamed from: a */
    private static final String f50037a = "g";

    /* renamed from: b */
    private static final String f50038b = "global_sp_key_domain_suffix";

    /* renamed from: c */
    private static final String f50039c = "global_sp_key_idc_domain_suffix";

    /* renamed from: d */
    private static final String f50040d = "global_sp_key_pii_domain_suffix";

    /* renamed from: e */
    private static volatile IdcDomainSuffixModel f50041e;

    /* renamed from: f */
    private static volatile PiiDomainSuffixModel f50042f;

    protected static boolean refreshDomainSuffix(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            return m36053a(context, str);
        }
        ELog.log("Invalid cache domain suffix value " + str);
        return false;
    }

    protected static boolean refreshDomainSuffixModel(Context context, AbsDomainSuffixModel absDomainSuffixModel) {
        if (absDomainSuffixModel != null && !absDomainSuffixModel.illegal()) {
            return m36052a(context, absDomainSuffixModel);
        }
        ELog.log("Invalid cache domain suffix value ");
        return false;
    }

    protected static void removeDomainSuffixModel(Context context, String str) {
        SharedPrefUtil.remove(context, getSpKey(str));
        m36051a(str);
    }

    /* renamed from: a */
    private static boolean m36053a(Context context, String str) {
        return m36052a(context, (AbsDomainSuffixModel) new IdcDomainSuffixModel(str));
    }

    /* renamed from: a */
    private static boolean m36052a(Context context, AbsDomainSuffixModel absDomainSuffixModel) {
        boolean put = SharedPrefUtil.put(context, getSpKey(absDomainSuffixModel.getType()), AbsDomainSuffixModel.SERIALIZER.serialize(absDomainSuffixModel).toString());
        if (put) {
            m36050a(absDomainSuffixModel);
        }
        return put;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.didiglobal.domainservice.model.AbsDomainSuffixModel m36050a(com.didiglobal.domainservice.model.AbsDomainSuffixModel r4) {
        /*
            java.lang.String r0 = r4.getType()
            int r1 = r0.hashCode()
            r2 = 104104(0x196a8, float:1.45881E-40)
            r3 = 1
            if (r1 == r2) goto L_0x001e
            r2 = 110992(0x1b190, float:1.55533E-40)
            if (r1 == r2) goto L_0x0014
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "pii"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0028
            r0 = 1
            goto L_0x0029
        L_0x001e:
            java.lang.String r1 = "idc"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0028
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = -1
        L_0x0029:
            if (r0 == 0) goto L_0x0036
            if (r0 == r3) goto L_0x002f
            r4 = 0
            return r4
        L_0x002f:
            com.didiglobal.domainservice.model.PiiDomainSuffixModel r4 = (com.didiglobal.domainservice.model.PiiDomainSuffixModel) r4
            f50042f = r4
            com.didiglobal.domainservice.model.PiiDomainSuffixModel r4 = f50042f
            return r4
        L_0x0036:
            com.didiglobal.domainservice.model.IdcDomainSuffixModel r4 = (com.didiglobal.domainservice.model.IdcDomainSuffixModel) r4
            f50041e = r4
            com.didiglobal.domainservice.model.IdcDomainSuffixModel r4 = f50041e
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.domainservice.DomainStore.m36050a(com.didiglobal.domainservice.model.AbsDomainSuffixModel):com.didiglobal.domainservice.model.AbsDomainSuffixModel");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m36051a(java.lang.String r3) {
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
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0024
            r3 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "idc"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0024
            r3 = 0
            goto L_0x0025
        L_0x0024:
            r3 = -1
        L_0x0025:
            r0 = 0
            if (r3 == 0) goto L_0x002e
            if (r3 == r2) goto L_0x002b
            goto L_0x0030
        L_0x002b:
            f50042f = r0
            goto L_0x0030
        L_0x002e:
            f50041e = r0
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.domainservice.DomainStore.m36051a(java.lang.String):void");
    }

    protected static String getCacheDomainSuffix(Context context) {
        return getCacheDomainSuffix(context, "g");
    }

    protected static String getCacheDomainSuffix(Context context, String str) {
        IdcDomainSuffixModel idcDomainSuffixModel = (IdcDomainSuffixModel) getCacheDomainSuffixModel(context, str, SuffixType.IDC);
        if (idcDomainSuffixModel == null) {
            return "";
        }
        return idcDomainSuffixModel.getSuffix();
    }

    protected static AbsDomainSuffixModel getCacheDomainSuffixModel(Context context, String str) {
        return getCacheDomainSuffixModel(context, "g", str);
    }

    protected static AbsDomainSuffixModel getCacheDomainSuffixModel(Context context, String str, String str2) {
        if (SuffixType.IDC.equals(str2) && f50041e != null && !f50041e.illegal()) {
            return f50041e;
        }
        if (SuffixType.PII.equals(str2) && f50042f != null && !f50042f.illegal()) {
            return f50042f;
        }
        Object obj = SharedPrefUtil.get(context, getSpKey(str2), "");
        if (!(obj instanceof String) || obj.equals("")) {
            if (obj.equals("") && SuffixType.IDC.equals(str2)) {
                Object obj2 = SharedPrefUtil.get(context, f50038b, str);
                if (obj2 instanceof String) {
                    f50041e = new IdcDomainSuffixModel((String) obj2);
                    return f50041e;
                }
            }
            return null;
        }
        try {
            return m36050a(AbsDomainSuffixModel.SERIALIZER.deserialize(new JSONObject((String) obj)));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getSpKey(java.lang.String r3) {
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
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0024
            r3 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "idc"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0024
            r3 = 0
            goto L_0x0025
        L_0x0024:
            r3 = -1
        L_0x0025:
            if (r3 == 0) goto L_0x002e
            if (r3 == r2) goto L_0x002b
            r3 = 0
            return r3
        L_0x002b:
            java.lang.String r3 = "global_sp_key_pii_domain_suffix"
            return r3
        L_0x002e:
            java.lang.String r3 = "global_sp_key_idc_domain_suffix"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.domainservice.DomainStore.getSpKey(java.lang.String):java.lang.String");
    }
}
