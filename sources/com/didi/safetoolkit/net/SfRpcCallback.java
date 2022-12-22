package com.didi.safetoolkit.net;

import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.didi.safetoolkit.model.SfBaseObject;
import com.didi.safetoolkit.util.SfEnvironment;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.SfParseException;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public abstract class SfRpcCallback<T extends SfBaseObject> implements RpcService.Callback<T> {
    private SfResponseListener<T> mResponseListener;

    public SfRpcCallback(SfResponseListener<T> sfResponseListener) {
        this.mResponseListener = sfResponseListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0066 A[Catch:{ Exception -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(T r4) {
        /*
            r3 = this;
            java.lang.String r0 = "SfRpcCallback"
            if (r4 == 0) goto L_0x001a
            boolean r1 = r4.isAvailable()     // Catch:{ Exception -> 0x006c }
            if (r1 != 0) goto L_0x000b
            goto L_0x001a
        L_0x000b:
            java.lang.String r1 = "onSuccess "
            com.didi.safetoolkit.util.SfLog.m24409i(r0, r1)     // Catch:{ Exception -> 0x006c }
            com.didi.safetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006c }
            if (r0 == 0) goto L_0x0062
            com.didi.safetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006c }
            r0.onSuccess(r4)     // Catch:{ Exception -> 0x006c }
            goto L_0x0062
        L_0x001a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006c }
            java.lang.String r2 = "onError : "
            r1.<init>(r2)     // Catch:{ Exception -> 0x006c }
            if (r4 != 0) goto L_0x0029
            java.lang.String r2 = "Response is NULL."
            r1.append(r2)     // Catch:{ Exception -> 0x006c }
            goto L_0x0052
        L_0x0029:
            java.lang.String r2 = "Response error, traceid = "
            r1.append(r2)     // Catch:{ Exception -> 0x006c }
            java.lang.String r2 = ",  error code = "
            r1.append(r2)     // Catch:{ Exception -> 0x006c }
            int r2 = r4.errno     // Catch:{ Exception -> 0x006c }
            r1.append(r2)     // Catch:{ Exception -> 0x006c }
            java.lang.String r2 = ", error msg = "
            r1.append(r2)     // Catch:{ Exception -> 0x006c }
            java.lang.String r2 = r4.errmsg     // Catch:{ Exception -> 0x006c }
            r1.append(r2)     // Catch:{ Exception -> 0x006c }
            java.lang.String r2 = ", response class typeLocal = "
            r1.append(r2)     // Catch:{ Exception -> 0x006c }
            java.lang.Class r2 = r4.getClass()     // Catch:{ Exception -> 0x006c }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x006c }
            r1.append(r2)     // Catch:{ Exception -> 0x006c }
        L_0x0052:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x006c }
            com.didi.safetoolkit.util.SfLog.m24413w(r0, r1)     // Catch:{ Exception -> 0x006c }
            com.didi.safetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006c }
            if (r0 == 0) goto L_0x0062
            com.didi.safetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006c }
            r0.onError(r4)     // Catch:{ Exception -> 0x006c }
        L_0x0062:
            com.didi.safetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006c }
            if (r0 == 0) goto L_0x0071
            com.didi.safetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006c }
            r0.onFinish(r4)     // Catch:{ Exception -> 0x006c }
            goto L_0x0071
        L_0x006c:
            r4 = move-exception
            boolean r0 = com.didi.safetoolkit.util.SfEnvironment.DEBUG
            if (r0 != 0) goto L_0x0072
        L_0x0071:
            return
        L_0x0072:
            com.didi.safetoolkit.util.SfParseException r0 = new com.didi.safetoolkit.util.SfParseException
            r0.<init>((java.lang.Throwable) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safetoolkit.net.SfRpcCallback.onSuccess(com.didi.safetoolkit.model.SfBaseObject):void");
    }

    public void onFailure(IOException iOException) {
        SfLog.m24405e("SfRpcCallback", "【onFailure】", iOException);
        if (SfEnvironment.DEBUG && iOException != null) {
            Throwable cause = iOException.getCause();
            if (cause instanceof SfParseException) {
                String localCause = ((SfParseException) cause).getLocalCause();
                if (TextUtils.isEmpty(localCause)) {
                    localCause = "NetCallback CRASH!";
                }
                throw new AndroidRuntimeException(localCause, cause);
            }
        }
        SfResponseListener<T> sfResponseListener = this.mResponseListener;
        if (sfResponseListener != null) {
            sfResponseListener.onFail(-1, SfStringGetter.getString(R.string.sf_common_no_net_error_tips));
            this.mResponseListener.onFinish(null);
        }
    }
}
