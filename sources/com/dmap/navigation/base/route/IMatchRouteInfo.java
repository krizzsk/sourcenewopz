package com.dmap.navigation.base.route;

import java.math.BigInteger;

public interface IMatchRouteInfo {
    BigInteger getLinkId();

    BigInteger getLinkIdRaw();

    String getMapVersion();
}
