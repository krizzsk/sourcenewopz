package com.didi.beatles.p099im.net;

import android.text.TextUtils;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.api.entity.IMBaseRequest;
import com.didi.beatles.p099im.api.entity.IMBaseResponse;
import com.didi.beatles.p099im.api.url.IMApiUrl;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.net.IMHttpManager */
public class IMHttpManager {

    /* renamed from: a */
    private static IMHttpManager f9338a = null;

    /* renamed from: b */
    private static final String f9339b = "IMHttpManager";

    /* renamed from: c */
    private RpcServiceFactory f9340c = new RpcServiceFactory(IMCommonContextInfoHelper.getContext());

    /* renamed from: d */
    private Map<String, IMHttpService> f9341d = new HashMap();

    public static IMHttpManager getInstance() {
        if (f9338a == null) {
            f9338a = new IMHttpManager();
        }
        return f9338a;
    }

    private IMHttpManager() {
    }

    public void performCommonPost(IMBaseRequest iMBaseRequest, IMNetCallback<?> iMNetCallback) {
        if (iMBaseRequest == null) {
            IMLog.m6632e(f9339b, "request can not be null!");
            return;
        }
        IMNetCallback a = m6352a(iMNetCallback);
        HashMap hashMap = new HashMap();
        hashMap.put("data", IMJsonUtil.jsonFromObject(iMBaseRequest));
        m6351a().commonPost(hashMap, a);
    }

    public void performCommonGet(String str, IMNetCallback<?> iMNetCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.m6632e(f9339b, "getUrl can not be null!");
            return;
        }
        ((IMHttpService) this.f9340c.newRpcService(IMHttpService.class, str)).commonGet((Map<String, Object>) null, m6352a(iMNetCallback));
    }

    public void pullMessage(IMBaseRequest iMBaseRequest, boolean z, IMNetCallback<?> iMNetCallback) {
        if (iMBaseRequest == null) {
            IMLog.m6632e(f9339b, "request can not be null!");
            return;
        }
        IMNetCallback a = m6352a(iMNetCallback);
        IMHttpService a2 = m6351a();
        HashMap hashMap = new HashMap();
        hashMap.put("data", IMJsonUtil.jsonFromObject(iMBaseRequest));
        if (z) {
            a2.pollingMsg(hashMap, a);
        } else {
            a2.commonPost(hashMap, a);
        }
    }

    public void upLoadFile(String str, IMNetCallback<?> iMNetCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.m6632e(f9339b, "fileName can not be null while upload file");
            return;
        }
        IMNetCallback a = m6352a(iMNetCallback);
        File file = new File(str);
        HashMap hashMap = new HashMap();
        hashMap.put("filecontent", file);
        ((IMHttpService) this.f9340c.newRpcService(IMHttpService.class, IMApiUrl.getCommonHostOnline())).postFile(hashMap, a);
    }

    public void upLoadImage(String str, IMNetCallback<?> iMNetCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.m6632e(f9339b, "fileName can not be null while upload file");
            return;
        }
        IMNetCallback a = m6352a(iMNetCallback);
        File file = new File(str);
        HashMap hashMap = new HashMap();
        hashMap.put("filecontent", file);
        ((IMHttpService) this.f9340c.newRpcService(IMHttpService.class, IMApiUrl.getCommonHost())).postImage(hashMap, a);
    }

    /* renamed from: a */
    private IMHttpService m6351a() {
        IMHttpService iMHttpService = this.f9341d.get(IMApiUrl.getCommonHost());
        if (iMHttpService != null) {
            return iMHttpService;
        }
        IMHttpService iMHttpService2 = (IMHttpService) this.f9340c.newRpcService(IMHttpService.class, IMApiUrl.getCommonHost());
        this.f9341d.put(IMApiUrl.getCommonHost(), iMHttpService2);
        return iMHttpService2;
    }

    public void downloadFile(String str, final String str2, final IMNetCallback<Boolean> iMNetCallback) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            IMLog.m6632e(f9339b, "downloadUrl and filePath can not be null!");
            return;
        }
        ((IMHttpService) this.f9340c.newRpcService(IMHttpService.class, str)).downloadFile((String) null, new IMNetCallback<byte[]>() {
            /* JADX WARNING: Removed duplicated region for block: B:28:0x0052 A[Catch:{ all -> 0x003b }] */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x0059 A[SYNTHETIC, Splitter:B:30:0x0059] */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x0064 A[SYNTHETIC, Splitter:B:35:0x0064] */
            /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void success(byte[] r6) {
                /*
                    r5 = this;
                    java.io.File r0 = new java.io.File
                    java.lang.String r1 = r4
                    r0.<init>(r1)
                    boolean r1 = r0.isDirectory()
                    if (r1 == 0) goto L_0x000e
                    return
                L_0x000e:
                    boolean r1 = r0.exists()
                    if (r1 == 0) goto L_0x0017
                    r0.delete()
                L_0x0017:
                    r1 = 0
                    r2 = 1
                    java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003d }
                    r3.<init>(r0)     // Catch:{ IOException -> 0x003d }
                    r3.write(r6)     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
                    r3.close()     // Catch:{ IOException -> 0x0025 }
                    goto L_0x0029
                L_0x0025:
                    r6 = move-exception
                    r6.printStackTrace()
                L_0x0029:
                    com.didi.beatles.im.net.IMNetCallback r6 = r5
                    if (r6 == 0) goto L_0x0034
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                    r6.success(r0)
                L_0x0034:
                    return
                L_0x0035:
                    r6 = move-exception
                    r1 = r3
                    goto L_0x0062
                L_0x0038:
                    r6 = move-exception
                    r1 = r3
                    goto L_0x003e
                L_0x003b:
                    r6 = move-exception
                    goto L_0x0062
                L_0x003d:
                    r6 = move-exception
                L_0x003e:
                    java.lang.String r0 = "IMHttpManager"
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x003b }
                    r3 = 0
                    java.lang.String r4 = "there is a IOException while download file!"
                    r2[r3] = r4     // Catch:{ all -> 0x003b }
                    com.didi.beatles.p099im.utils.IMLog.m6632e(r0, r2)     // Catch:{ all -> 0x003b }
                    r6.printStackTrace()     // Catch:{ all -> 0x003b }
                    com.didi.beatles.im.net.IMNetCallback r0 = r5     // Catch:{ all -> 0x003b }
                    if (r0 == 0) goto L_0x0057
                    com.didi.beatles.im.net.IMNetCallback r0 = r5     // Catch:{ all -> 0x003b }
                    r0.failure(r6)     // Catch:{ all -> 0x003b }
                L_0x0057:
                    if (r1 == 0) goto L_0x0061
                    r1.close()     // Catch:{ IOException -> 0x005d }
                    goto L_0x0061
                L_0x005d:
                    r6 = move-exception
                    r6.printStackTrace()
                L_0x0061:
                    return
                L_0x0062:
                    if (r1 == 0) goto L_0x006c
                    r1.close()     // Catch:{ IOException -> 0x0068 }
                    goto L_0x006c
                L_0x0068:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x006c:
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.net.IMHttpManager.C41481.success(byte[]):void");
            }

            public void failure(IOException iOException) {
                IMNetCallback iMNetCallback = iMNetCallback;
                if (iMNetCallback != null) {
                    iMNetCallback.failure(iOException);
                }
            }
        });
    }

    public void getDownloadFileInfo(String str, IMNetCallback<?> iMNetCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.m6632e(f9339b, "url can not be null!");
            return;
        }
        ((IMHttpService) this.f9340c.newRpcService(IMHttpService.class, str)).getDownloadFileInfo((String) null, m6352a(iMNetCallback));
    }

    /* renamed from: a */
    private IMNetCallback m6352a(IMNetCallback<?> iMNetCallback) {
        return iMNetCallback != null ? iMNetCallback : new IMNetCallback<IMBaseResponse>() {
            public void failure(IOException iOException) {
            }

            public void success(IMBaseResponse iMBaseResponse) {
            }
        };
    }
}
