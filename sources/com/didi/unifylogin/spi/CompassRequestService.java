package com.didi.unifylogin.spi;

import android.content.Context;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.domainservice.model.AbsDomainSuffixModel;

public class CompassRequestService {

    /* renamed from: a */
    private static CompassRequestInterface f44866a;

    public static void compassRequestBegin() {
        CompassRequestInterface a = m32190a();
        if (a != null) {
            a.compassRequestBegin();
        }
    }

    public static void compassResponse(String str) {
        CompassRequestInterface a = m32190a();
        if (a != null) {
            a.compassResponse(str);
        }
    }

    public static boolean cacheDomainSuffix(Context context, String str) {
        CompassRequestInterface a = m32190a();
        if (a != null) {
            return a.cacheDomainSuffix(context, str);
        }
        return false;
    }

    public static boolean cacheDomainSuffixModel(Context context, AbsDomainSuffixModel absDomainSuffixModel) {
        CompassRequestInterface a = m32190a();
        if (a != null) {
            return a.cacheDomainSuffixModel(context, absDomainSuffixModel);
        }
        return false;
    }

    public static void removeDomainSuffixModel(Context context, String str) {
        CompassRequestInterface a = m32190a();
        if (a != null) {
            a.removeDomainSuffixModel(context, str);
        }
    }

    public static String getCacheDomainSuffix(Context context, String str) {
        CompassRequestInterface a = m32190a();
        return a != null ? a.getCacheDomainSuffix(context, str) : str;
    }

    public static AbsDomainSuffixModel getCacheDomainSuffixModel(Context context, String str, String str2) {
        CompassRequestInterface a = m32190a();
        if (a != null) {
            return a.getCacheDomainSuffixModel(context, str, str2);
        }
        return null;
    }

    public static boolean isSupportDynamicDomain(Context context) {
        CompassRequestInterface a = m32190a();
        if (a != null) {
            return a.isDynamicDomainSupport(context);
        }
        return false;
    }

    /* renamed from: a */
    private static CompassRequestInterface m32190a() {
        if (f44866a == null) {
            synchronized (CompassRequestService.class) {
                if (f44866a == null) {
                    f44866a = (CompassRequestInterface) ServiceLoader.load(CompassRequestInterface.class).get();
                }
            }
        }
        return f44866a;
    }
}
