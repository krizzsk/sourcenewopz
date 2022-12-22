package com.didi.unifylogin.spi;

import android.content.Context;
import com.didiglobal.domainservice.model.AbsDomainSuffixModel;

public interface CompassRequestInterface {
    boolean cacheDomainSuffix(Context context, String str);

    boolean cacheDomainSuffixModel(Context context, AbsDomainSuffixModel absDomainSuffixModel);

    void compassRequestBegin();

    void compassResponse(String str);

    String getCacheDomainSuffix(Context context, String str);

    AbsDomainSuffixModel getCacheDomainSuffixModel(Context context, String str, String str2);

    boolean isDynamicDomainSupport(Context context);

    void removeDomainSuffixModel(Context context, String str);
}
