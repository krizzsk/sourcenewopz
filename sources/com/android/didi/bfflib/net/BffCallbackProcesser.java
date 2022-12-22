package com.android.didi.bfflib.net;

import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.BffCallBack;
import com.android.didi.bfflib.BffExtra;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.concurrent.BffAbilityMapModel;
import com.android.didi.bfflib.concurrent.BffConcurrentFormStore;
import com.android.didi.bfflib.utils.BffLog;
import com.android.didi.bfflib.utils.TrackUtil;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;

public class BffCallbackProcesser implements RpcService.CallbackV2<String> {
    private List<IBffProxy.Ability> mAbilityList;
    private IBffProxy mBffProxyImpl;

    public BffCallbackProcesser(IBffProxy iBffProxy, List<IBffProxy.Ability> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.mAbilityList = copyOnWriteArrayList;
        copyOnWriteArrayList.addAll(list);
        this.mBffProxyImpl = iBffProxy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didichuxing.foundation.rpc.RpcResponseProxy<java.lang.String> r12) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            if (r12 == 0) goto L_0x000f
            java.util.List r1 = r12.getHeaders()
            java.lang.String r2 = "didi-header-rid"
            java.lang.String r1 = r11.getHeader(r1, r2)
            goto L_0x0010
        L_0x000f:
            r1 = r0
        L_0x0010:
            r8 = 2
            r9 = 0
            r10 = 0
            com.android.didi.bfflib.IBffProxy r2 = r11.mBffProxyImpl     // Catch:{ Exception -> 0x0081 }
            int r2 = r2.getStatus()     // Catch:{ Exception -> 0x0081 }
            r3 = 3
            if (r2 != r3) goto L_0x0027
            r4 = 0
            r5 = 4
            r7 = 0
            r3 = 0
            r2 = r11
            r6 = r1
            r2.onFailurePrivate(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0081 }
            goto L_0x007a
        L_0x0027:
            if (r12 == 0) goto L_0x0071
            boolean r2 = r12.isSuccessful()     // Catch:{ Exception -> 0x0081 }
            if (r2 == 0) goto L_0x0064
            java.lang.Object r12 = r12.getContent()     // Catch:{ Exception -> 0x0081 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0081 }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x005f }
            r0.<init>()     // Catch:{ Exception -> 0x005f }
            java.lang.Class<com.android.didi.bfflib.net.BffResponsePojo> r2 = com.android.didi.bfflib.net.BffResponsePojo.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r12, r2)     // Catch:{ Exception -> 0x005f }
            com.android.didi.bfflib.net.BffResponsePojo r0 = (com.android.didi.bfflib.net.BffResponsePojo) r0     // Catch:{ Exception -> 0x005f }
            if (r0 == 0) goto L_0x004e
            int r2 = r0.getErrno()     // Catch:{ Exception -> 0x004a }
            r7 = r2
            goto L_0x0050
        L_0x004a:
            r2 = move-exception
            r3 = r0
            r4 = r2
            goto L_0x0062
        L_0x004e:
            r2 = -1
            r7 = -1
        L_0x0050:
            if (r7 != 0) goto L_0x0056
            r11.onSuccessPrivate(r0, r1)     // Catch:{ Exception -> 0x004a }
            goto L_0x007a
        L_0x0056:
            r4 = 0
            r5 = 3
            r2 = r11
            r3 = r0
            r6 = r1
            r2.onFailurePrivate(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x004a }
            goto L_0x007a
        L_0x005f:
            r0 = move-exception
            r4 = r0
            r3 = r10
        L_0x0062:
            r0 = r12
            goto L_0x0084
        L_0x0064:
            r4 = 0
            r5 = 3
            int r7 = r12.getStatus()     // Catch:{ Exception -> 0x0081 }
            r2 = r11
            r3 = r10
            r6 = r1
            r2.onFailurePrivate(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0081 }
            goto L_0x007a
        L_0x0071:
            r4 = 0
            r5 = 2
            r7 = 0
            r3 = 0
            r2 = r11
            r6 = r1
            r2.onFailurePrivate(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0081 }
        L_0x007a:
            com.android.didi.bfflib.IBffProxy r12 = r11.mBffProxyImpl
            if (r12 == 0) goto L_0x00a8
            goto L_0x009b
        L_0x007f:
            r12 = move-exception
            goto L_0x00a9
        L_0x0081:
            r12 = move-exception
            r4 = r12
            r3 = r10
        L_0x0084:
            r4.printStackTrace()     // Catch:{ all -> 0x007f }
            r5 = 5
            r7 = 0
            r2 = r11
            r6 = r1
            r2.onFailurePrivate(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x008f }
            goto L_0x0097
        L_0x008f:
            r12 = move-exception
            r12.printStackTrace()     // Catch:{ all -> 0x007f }
            r2 = 5
            com.android.didi.bfflib.utils.TrackUtil.trackError(r2, r1, r12, r0)     // Catch:{ all -> 0x007f }
        L_0x0097:
            com.android.didi.bfflib.IBffProxy r12 = r11.mBffProxyImpl
            if (r12 == 0) goto L_0x00a8
        L_0x009b:
            r12.removeCache()
            com.android.didi.bfflib.IBffProxy r12 = r11.mBffProxyImpl
            r12.setRequesting(r9)
            com.android.didi.bfflib.IBffProxy r12 = r11.mBffProxyImpl
            r12.setStatus(r8)
        L_0x00a8:
            return
        L_0x00a9:
            com.android.didi.bfflib.IBffProxy r0 = r11.mBffProxyImpl
            if (r0 == 0) goto L_0x00ba
            r0.removeCache()
            com.android.didi.bfflib.IBffProxy r0 = r11.mBffProxyImpl
            r0.setRequesting(r9)
            com.android.didi.bfflib.IBffProxy r0 = r11.mBffProxyImpl
            r0.setStatus(r8)
        L_0x00ba:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.didi.bfflib.net.BffCallbackProcesser.onSuccess(com.didichuxing.foundation.rpc.RpcResponseProxy):void");
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        IBffProxy iBffProxy;
        try {
            onFailurePrivate((BffResponsePojo) null, iOException, 2, "", 0);
            iBffProxy = this.mBffProxyImpl;
            if (iBffProxy == null) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            TrackUtil.trackError(5, "", e, "");
            iBffProxy = this.mBffProxyImpl;
            if (iBffProxy == null) {
                return;
            }
        } catch (Throwable th) {
            IBffProxy iBffProxy2 = this.mBffProxyImpl;
            if (iBffProxy2 != null) {
                iBffProxy2.setRequesting(false);
                this.mBffProxyImpl.removeCache();
                this.mBffProxyImpl.setStatus(2);
            }
            throw th;
        }
        iBffProxy.setRequesting(false);
        this.mBffProxyImpl.removeCache();
        this.mBffProxyImpl.setStatus(2);
    }

    private void onSuccessPrivate(BffResponsePojo bffResponsePojo, String str) {
        BffAbilityMapModel abilityMapModel = BffConcurrentFormStore.getInstance().getAbilityMapModel();
        if (!(bffResponsePojo.getData() == null || bffResponsePojo.getData().getAbilities() == null || bffResponsePojo.getData().getAbilities().get(Bff.CONCURRENT_FORM_ABILITY_ID) == null || (abilityMapModel != null && abilityMapModel.errno == 0 && abilityMapModel.data != null))) {
            for (IBffProxy.Ability next : this.mAbilityList) {
                if (next.getId().equals(Bff.CONCURRENT_FORM_ABILITY_ID)) {
                    callbackAnAbilityOnSuccess(bffResponsePojo, next, str);
                    this.mAbilityList.remove(next);
                }
            }
        }
        Logger logger = LoggerFactory.getLogger("GlobalBff");
        logger.info("onSuccessPrivate:" + this.mAbilityList.size(), new Object[0]);
        for (IBffProxy.Ability callbackAnAbilityOnSuccess : this.mAbilityList) {
            callbackAnAbilityOnSuccess(bffResponsePojo, callbackAnAbilityOnSuccess, str);
        }
    }

    private void callbackAnAbilityOnSuccess(BffResponsePojo bffResponsePojo, IBffProxy.Ability ability, String str) {
        String str2;
        RpcService.Callback<JsonObject> callback = ability.getCallback();
        BffCallBack<JsonObject> bffCallBack = ability.getBffCallBack();
        if (callback != null || bffCallBack != null) {
            JsonObject asJsonObject = bffResponsePojo.getData().getAbilities().get(ability.getId()).getAsJsonObject();
            BffLog.m1480d("bffDatad callback " + ability.getId());
            int i = -1;
            if (!(asJsonObject == null || asJsonObject.get("errno") == null)) {
                i = asJsonObject.get("errno").getAsInt();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("traceID", str);
            hashMap.put("abilityId", ability.getId());
            hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.ERR_NO, Integer.valueOf(i));
            LoggerFactory.getLogger("GlobalBff").info("bff success", (Map<?, ?>) hashMap);
            if (callback != null) {
                try {
                    callback.onSuccess(asJsonObject);
                } catch (Exception e) {
                    e.printStackTrace();
                    int i2 = 5;
                    if ((e instanceof JsonSyntaxException) || (e instanceof JSONException)) {
                        i2 = 1;
                        str2 = asJsonObject.toString();
                    } else {
                        str2 = "";
                    }
                    TrackUtil.trackError(i2, str, e, str2, ability.getId());
                }
            } else if (bffCallBack != null) {
                bffCallBack.onSuccess(asJsonObject, new BffExtra(str, ability.getId()));
            }
        }
    }

    private void onFailurePrivate(BffResponsePojo bffResponsePojo, Exception exc, int i, String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("traceID", str);
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.ERR_NO, Integer.valueOf(i2));
        hashMap.put(DMWebSocketListener.KEY_ERR_MSG, bffResponsePojo != null ? bffResponsePojo.getErrmsg() : "");
        LoggerFactory.getLogger("GlobalBff").info("bff fail:", (Map<?, ?>) hashMap);
        onFailurePrivate(bffResponsePojo, exc, i, str, i2, "");
    }

    private void onFailurePrivate(BffResponsePojo bffResponsePojo, Exception exc, int i, String str, int i2, String str2) {
        IOException iOException;
        Exception exc2 = exc;
        for (IBffProxy.Ability next : this.mAbilityList) {
            RpcService.Callback<JsonObject> callback = next.getCallback();
            BffCallBack<JsonObject> bffCallBack = next.getBffCallBack();
            if (callback != null || bffCallBack != null) {
                if (exc2 == null) {
                    try {
                        iOException = new IOException("net error");
                    } catch (Exception e) {
                        Exception exc3 = e;
                        exc3.printStackTrace();
                        TrackUtil.trackError(5, str, exc3, str2, i2, next.getId());
                    }
                } else {
                    iOException = new IOException(exc2);
                }
                if (callback != null) {
                    callback.onFailure(iOException);
                } else if (bffCallBack != null) {
                    bffCallBack.onFailure(new BffExtra(str, i, next.getId(), exc2 != null ? exc2 : iOException, i2));
                }
            }
            TrackUtil.trackError(i, str, exc, str2, i2, next.getId());
        }
    }

    public String getHeader(List<HttpHeader> list, String str) {
        if (!(list == null || list.size() == 0)) {
            ListIterator<HttpHeader> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                HttpHeader previous = listIterator.previous();
                if (previous.getName() != null && previous.getName().equalsIgnoreCase(str)) {
                    return previous.getValue();
                }
            }
        }
        return "";
    }
}
