package com.dmap.navigation.engine.simple;

import com.dmap.navigation.base.route.IMatchRouteInfo;
import com.dmap.navigation.jni.swig.MatchedRouteInfo;
import java.math.BigInteger;

public class SimpleMatchRouteInfo implements IMatchRouteInfo {

    /* renamed from: a */
    private final BigInteger f52012a;

    /* renamed from: b */
    private final BigInteger f52013b;

    /* renamed from: c */
    private final String f52014c;

    public SimpleMatchRouteInfo(MatchedRouteInfo matchedRouteInfo) {
        this.f52012a = matchedRouteInfo.getLinkId();
        this.f52013b = matchedRouteInfo.getLinkIdRaw();
        this.f52014c = matchedRouteInfo.getMapVersion();
    }

    public BigInteger getLinkId() {
        return this.f52012a;
    }

    public BigInteger getLinkIdRaw() {
        return this.f52013b;
    }

    public String getMapVersion() {
        return this.f52014c;
    }
}
