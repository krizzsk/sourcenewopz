package com.didiglobal.ddmirror.network;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0012"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/network/DDMirrorNetConstants;", "", "()V", "KEY_EXT", "", "getKEY_EXT", "()Ljava/lang/String;", "KEY_PATH", "getKEY_PATH", "KEY_VALUE", "getKEY_VALUE", "MIRRPR_HTTP_ERROR", "getMIRRPR_HTTP_ERROR", "MIRRPR_HTTP_REQUEST", "getMIRRPR_HTTP_REQUEST", "URL_FLAG", "getURL_FLAG", "HttpErrType", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DDMirrorNetConstants.kt */
public final class DDMirrorNetConstants {
    public static final DDMirrorNetConstants INSTANCE = new DDMirrorNetConstants();
    private static final String KEY_EXT = KEY_EXT;
    private static final String KEY_PATH = KEY_PATH;
    private static final String KEY_VALUE = KEY_VALUE;
    private static final String MIRRPR_HTTP_ERROR = MIRRPR_HTTP_ERROR;
    private static final String MIRRPR_HTTP_REQUEST = MIRRPR_HTTP_REQUEST;
    private static final String URL_FLAG = URL_FLAG;

    private DDMirrorNetConstants() {
    }

    public final String getMIRRPR_HTTP_ERROR() {
        return MIRRPR_HTTP_ERROR;
    }

    public final String getMIRRPR_HTTP_REQUEST() {
        return MIRRPR_HTTP_REQUEST;
    }

    public final String getURL_FLAG() {
        return URL_FLAG;
    }

    public final String getKEY_PATH() {
        return KEY_PATH;
    }

    public final String getKEY_VALUE() {
        return KEY_VALUE;
    }

    public final String getKEY_EXT() {
        return KEY_EXT;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/network/DDMirrorNetConstants$HttpErrType;", "", "()V", "ReponseDataRegexError", "", "ReponseDataValueLostError", "RequestBodyRegexError", "RequestBodyValueLostError", "RequestHeaderRegexError", "RequestHeaderValueLostError", "RequestNetError", "RequestQueryRegexError", "RequestQueryValueLostError", "ResponseHTTPCodeError", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DDMirrorNetConstants.kt */
    public static final class HttpErrType {
        public static final HttpErrType INSTANCE = new HttpErrType();
        public static final int ReponseDataRegexError = 7;
        public static final int ReponseDataValueLostError = 8;
        public static final int RequestBodyRegexError = 2;
        public static final int RequestBodyValueLostError = 5;
        public static final int RequestHeaderRegexError = 3;
        public static final int RequestHeaderValueLostError = 6;
        public static final int RequestNetError = -1;
        public static final int RequestQueryRegexError = 1;
        public static final int RequestQueryValueLostError = 4;
        public static final int ResponseHTTPCodeError = 0;

        private HttpErrType() {
        }
    }
}
