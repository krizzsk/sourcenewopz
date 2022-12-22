package com.didi.unifylogin.domain;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.spi.CompassRequestService;
import com.didiglobal.domainservice.model.AbsDomainSuffixModel;
import com.didiglobal.domainservice.model.IdcDomainSuffixModel;
import com.didiglobal.domainservice.model.PiiDomainSuffixModel;
import com.didiglobal.domainservice.model.SuffixType;

public class GlobalDomainCache {

    /* renamed from: a */
    private static String f44764a = "g";

    /* renamed from: b */
    private static volatile GlobalDomainCache f44765b;

    /* renamed from: c */
    private PiiDomainSuffixModel f44766c;

    /* renamed from: d */
    private IdcDomainSuffixModel f44767d;

    private GlobalDomainCache() {
    }

    public static GlobalDomainCache getInstance(Context context) {
        if (f44765b == null) {
            synchronized (GlobalDomainCache.class) {
                if (f44765b == null) {
                    f44765b = new GlobalDomainCache();
                    f44765b.getDomainFromCache(context);
                }
            }
        }
        return f44765b;
    }

    public AbsDomainSuffixModel getDomainFromCache(Context context, String str) {
        AbsDomainSuffixModel domainSuffixModelInMemory = getDomainSuffixModelInMemory(str);
        if (domainSuffixModelInMemory != null) {
            return domainSuffixModelInMemory;
        }
        AbsDomainSuffixModel cacheDomainSuffixModel = CompassRequestService.getCacheDomainSuffixModel(context, f44764a, str);
        setDomainSuffixModelInMemory(cacheDomainSuffixModel);
        return cacheDomainSuffixModel;
    }

    public void setDomainSuffixModelInMemory(AbsDomainSuffixModel absDomainSuffixModel) {
        if (absDomainSuffixModel != null) {
            String type = absDomainSuffixModel.getType();
            char c = 65535;
            int hashCode = type.hashCode();
            if (hashCode != 104104) {
                if (hashCode == 110992 && type.equals(SuffixType.PII)) {
                    c = 1;
                }
            } else if (type.equals(SuffixType.IDC)) {
                c = 0;
            }
            if (c == 0) {
                this.f44767d = (IdcDomainSuffixModel) absDomainSuffixModel;
            } else if (c == 1) {
                this.f44766c = (PiiDomainSuffixModel) absDomainSuffixModel;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didiglobal.domainservice.model.AbsDomainSuffixModel getDomainSuffixModelInMemory(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 104104(0x196a8, float:1.45881E-40)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 110992(0x1b190, float:1.55533E-40)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "pii"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "idc"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 0
            goto L_0x0025
        L_0x0024:
            r4 = -1
        L_0x0025:
            if (r4 == 0) goto L_0x002e
            if (r4 == r2) goto L_0x002b
            r4 = 0
            return r4
        L_0x002b:
            com.didiglobal.domainservice.model.PiiDomainSuffixModel r4 = r3.f44766c
            return r4
        L_0x002e:
            com.didiglobal.domainservice.model.IdcDomainSuffixModel r4 = r3.f44767d
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.domain.GlobalDomainCache.getDomainSuffixModelInMemory(java.lang.String):com.didiglobal.domainservice.model.AbsDomainSuffixModel");
    }

    public String getDomainFromCache(Context context) {
        getDomainFromCache(context, SuffixType.IDC);
        IdcDomainSuffixModel idcDomainSuffixModel = this.f44767d;
        if (idcDomainSuffixModel == null) {
            return f44764a;
        }
        return idcDomainSuffixModel.getSuffix();
    }

    public boolean hasCached() {
        IdcDomainSuffixModel idcDomainSuffixModel = this.f44767d;
        return idcDomainSuffixModel != null && !idcDomainSuffixModel.getSuffix().equals(f44764a);
    }

    public void setDomainSuffix(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            setDomainSuffixModel(context, new IdcDomainSuffixModel(str));
            return;
        }
        throw new NullPointerException("Null or empty String can not be cached!");
    }

    public void setDomainSuffixModel(Context context, AbsDomainSuffixModel absDomainSuffixModel) {
        if (absDomainSuffixModel == null || TextUtils.isEmpty(absDomainSuffixModel.getSuffix())) {
            throw new NullPointerException("Null or empty String can not be cached!");
        } else if (CompassRequestService.cacheDomainSuffixModel(context, absDomainSuffixModel)) {
            setDomainSuffixModelInMemory(absDomainSuffixModel);
        }
    }

    public void removeDomainSuffixModel(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            CompassRequestService.removeDomainSuffixModel(context, str);
        }
    }
}
