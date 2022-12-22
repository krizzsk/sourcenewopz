package com.didiglobal.common.common.util;

import com.didi.drouter.router.Request;

public class RouterHandleUtil {
    public static int getIntQueryParam(Request request, String str, int i) {
        try {
            return Integer.parseInt(request.getUri().getQueryParameter(str));
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }
}
