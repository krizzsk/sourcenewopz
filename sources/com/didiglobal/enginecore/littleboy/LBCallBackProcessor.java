package com.didiglobal.enginecore.littleboy;

import android.text.TextUtils;
import com.android.didi.bfflib.utils.TrackUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.enginecore.utils.XEngineLog;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LBCallBackProcessor implements RpcService.Callback<JsonObject> {

    /* renamed from: a */
    private List<LBAbility> f50183a;

    /* renamed from: b */
    private ILBTask f50184b;

    public LBCallBackProcessor(ILBTask iLBTask, List<LBAbility> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f50183a = copyOnWriteArrayList;
        copyOnWriteArrayList.addAll(list);
        this.f50184b = iLBTask;
    }

    public void onSuccess(JsonObject jsonObject) {
        ILBTask iLBTask;
        try {
            if (this.f50184b.getStatus() == 3) {
                m36159a((JsonObject) null, (Exception) null);
            } else if (jsonObject.get("errno").getAsInt() == 0) {
                m36157a(jsonObject);
            } else {
                XEngineLog.m36188fi("bffFail" + jsonObject);
                m36159a(jsonObject, (Exception) null);
            }
            iLBTask = this.f50184b;
            if (iLBTask == null) {
                return;
            }
        } catch (Exception e) {
            TrackUtil.trackError(e instanceof JsonParseException ? 1 : 5, "", e, jsonObject.toString());
            e.printStackTrace();
            onFailure(new IOException(e));
            iLBTask = this.f50184b;
            if (iLBTask == null) {
                return;
            }
        } catch (Throwable th) {
            ILBTask iLBTask2 = this.f50184b;
            if (iLBTask2 != null) {
                iLBTask2.removeCache();
                this.f50184b.setRequesting(false);
                this.f50184b.setStatus(2);
            }
            throw th;
        }
        iLBTask.removeCache();
        this.f50184b.setRequesting(false);
        this.f50184b.setStatus(2);
    }

    public void onFailure(IOException iOException) {
        ILBTask iLBTask;
        try {
            m36159a((JsonObject) null, (Exception) iOException);
            iLBTask = this.f50184b;
            if (iLBTask == null) {
                return;
            }
        } catch (Exception e) {
            TrackUtil.trackError(e instanceof JsonParseException ? 1 : 5, "", e, "");
            e.printStackTrace();
            iLBTask = this.f50184b;
            if (iLBTask == null) {
                return;
            }
        } catch (Throwable th) {
            ILBTask iLBTask2 = this.f50184b;
            if (iLBTask2 != null) {
                iLBTask2.setRequesting(false);
                this.f50184b.removeCache();
                this.f50184b.setStatus(2);
            }
            throw th;
        }
        iLBTask.setRequesting(false);
        this.f50184b.removeCache();
        this.f50184b.setStatus(2);
    }

    /* renamed from: a */
    private void m36157a(JsonObject jsonObject) {
        XEngineLog.m36181d("bffCallbackonSuccessPrivate");
        for (LBAbility a : this.f50183a) {
            m36158a(jsonObject, a);
        }
    }

    /* renamed from: a */
    private void m36158a(JsonObject jsonObject, LBAbility lBAbility) {
        RpcService.Callback<JsonObject> callback = lBAbility.getCallback();
        if (callback != null && jsonObject.get("data") != null) {
            try {
                callback.onSuccess(m36156a(jsonObject.get("data").getAsJsonObject(), lBAbility.getRequestKey()));
            } catch (Exception e) {
                TrackUtil.trackError(e instanceof JsonParseException ? 1 : 5, "", e, jsonObject.toString());
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private JsonObject m36156a(JsonObject jsonObject, String str) {
        if (!(TextUtils.isEmpty(str) || jsonObject == null || jsonObject.keySet() == null || jsonObject.keySet().size() == 0)) {
            for (String next : jsonObject.keySet()) {
                if (str.equals(next)) {
                    return jsonObject.get(next).getAsJsonObject();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m36159a(JsonObject jsonObject, Exception exc) {
        IOException iOException;
        XEngineLog.m36188fi("bffCallbackonFailurePrivate");
        for (LBAbility callback : this.f50183a) {
            RpcService.Callback<JsonObject> callback2 = callback.getCallback();
            if (callback2 != null) {
                if (exc == null) {
                    try {
                        iOException = new IOException("网络请求失败");
                    } catch (Exception e) {
                        TrackUtil.trackError(exc instanceof JsonParseException ? 1 : 5, "", exc, jsonObject.toString());
                        e.printStackTrace();
                    }
                } else {
                    iOException = new IOException(exc);
                }
                callback2.onFailure(iOException);
            }
        }
    }
}
