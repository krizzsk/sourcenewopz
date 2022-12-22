package com.didi.map.sdk.sharetrack.external;

public @interface DiDiNavStatusCode {
    public static final int ERROR_API_LOCATION_PERMISSION_MISSING = 104;
    public static final int ERROR_API_NETWORK_ERROR = 103;
    public static final int ERROR_API_NOT_AUTHORIZED = 101;
    public static final int ERROR_API_TERMS_NOT_ACCEPTED = 102;
    public static final int ERROR_ROUTE_LOCATION_DISABLED = 205;
    public static final int ERROR_ROUTE_LOCATION_UNKNOWN = 206;
    public static final int ERROR_ROUTE_NETWORK_ERROR = 202;
    public static final int ERROR_ROUTE_NO_ROUTE_FOUND = 201;
    public static final int ERROR_ROUTE_QUOTA_CHECK_FAILED = 203;
    public static final int ERROR_ROUTE_ROUTE_CANCELED = 204;
    public static final int ERROR_ROUTE_WAYPOINT_ERROR = 207;
    public static final int OK_AUTO_ARRIVED = 300;
    public static final int OK_NAVIGATOR_READY = 100;
    public static final int OK_ROUTE_SUCCESS = 200;
}
