package com.didi.travel.p171v2;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.business.BffBaseObject;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.travel.p171v2.biz.Biz;
import com.didi.travel.p171v2.biz.IBiz;
import com.didi.travel.p171v2.biz.IIBiz;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.ApiInvokePolicy;
import com.didi.travel.p171v2.biz.api.DataLevel;
import com.didi.travel.p171v2.biz.api.IIApi;
import com.didi.travel.p171v2.biz.api.RemoteCallback;
import com.didi.travel.p171v2.biz.bff.BffV2InvokeCallback;
import com.didi.travel.p171v2.biz.bff.BffVersion;
import com.didi.travel.p171v2.biz.bff.IIBff;
import com.didi.travel.p171v2.biz.rpc.IIRpc;
import com.didi.travel.p171v2.session.Session;
import com.didi.travel.p171v2.store.IStoreCallback;
import com.didi.travel.p171v2.store.Store;
import com.didi.travel.p171v2.util.KeyUtil;
import com.didi.travel.p171v2.util.LogUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.travel.v2.TravelSDKV2 */
public final class TravelSDKV2 {
    public static final String TAG = TravelSDKV2.class.getSimpleName();

    /* renamed from: a */
    private static Context f44276a;

    /* renamed from: b */
    private static boolean f44277b = false;

    /* renamed from: c */
    private static final Map<String, Biz> f44278c = new HashMap();

    /* renamed from: d */
    private static final Map<String, WeakReference<Session>> f44279d = new HashMap();

    public static void init(Context context, boolean z) {
        f44276a = context.getApplicationContext();
        f44277b = z;
    }

    public static Context getAppContext() {
        return f44276a;
    }

    public static boolean isDebug() {
        return f44277b;
    }

    public static <T extends IBiz> T loadBiz(Class<T> cls) {
        String str = TAG;
        LogUtils.m31494v(str, "loadBiz:clz = " + cls);
        checkBizClass(cls, TAG);
        IIBiz iIBiz = (IIBiz) cls.getAnnotation(IIBiz.class);
        Biz biz = f44278c.get(iIBiz.key());
        if (biz == null) {
            biz = new Biz(cls);
            f44278c.put(biz.getKey(), biz);
        } else if (!cls.equals(biz.getBizClass())) {
            throw new IllegalStateException(TAG + ".loadBiz:bizKey conflict, bizKey = " + iIBiz.key() + ", clz = " + cls + ", oldBizClz = " + biz.getBizClass());
        }
        return biz.getIBiz();
    }

    public static <T extends IBiz> T unloadBiz(Class<T> cls) {
        Biz remove;
        String str = TAG;
        LogUtils.m31494v(str, "unloadBiz:clz = " + cls);
        if (checkBizClassSafety(cls, TAG) && (remove = f44278c.remove(((IIBiz) cls.getAnnotation(IIBiz.class)).key())) != null) {
            return remove.getIBiz();
        }
        return null;
    }

    public static <T extends IBiz> T unloadBiz(String str) {
        String str2 = TAG;
        LogUtils.m31494v(str2, "unloadBiz:bizKey = " + str);
        Biz remove = f44278c.remove(str);
        if (remove == null) {
            return null;
        }
        return remove.getIBiz();
    }

    public static <T extends IBiz> Biz<T> getBiz(String str) {
        return f44278c.get(str);
    }

    public static <T extends IBiz> Biz<T> getBiz(Class<T> cls) {
        if (!checkBizClassSafety(cls, TAG)) {
            return null;
        }
        return getBiz(((IIBiz) cls.getAnnotation(IIBiz.class)).key());
    }

    public static <T extends IBiz> T getIBiz(String str) {
        String str2 = TAG;
        LogUtils.m31494v(str2, "getIBiz:bizKey = " + str);
        Biz biz = getBiz(str);
        if (biz == null) {
            return null;
        }
        return biz.getIBiz();
    }

    public static <T extends IBiz> T getIBiz(Class<T> cls) {
        Biz<T> biz;
        String str = TAG;
        LogUtils.m31494v(str, "getIBiz:clz = " + cls);
        if (checkBizClassSafety(cls, TAG) && (biz = getBiz(cls)) != null) {
            return biz.getIBiz();
        }
        return null;
    }

    public static <T extends IBiz> void checkBizClass(Class<T> cls, String str) {
        LogUtils.m31494v(str, "checkBizClass:clz = " + cls);
        if (cls == null) {
            throw new NullPointerException(str + ".checkBizClass:clz is null");
        } else if (!cls.isInterface()) {
            throw new IllegalArgumentException(str + ".checkBizClass:clz is not interface type, clz = " + cls);
        } else if (!IBiz.class.isAssignableFrom(cls) || IBiz.class.equals(cls)) {
            throw new IllegalArgumentException(str + ".checkBizClass:clz is not child interface of IBiz， clz = " + cls);
        } else {
            IIBiz iIBiz = (IIBiz) cls.getAnnotation(IIBiz.class);
            if (iIBiz == null) {
                throw new IllegalArgumentException(str + ".checkBizClass:clz has not IIBiz annotation, clz = " + cls);
            } else if (TextUtils.isEmpty(iIBiz.key())) {
                throw new IllegalArgumentException(str + ".checkBizClass:the key of IIBiz annotation is empty, clz = " + cls);
            }
        }
    }

    public static <T extends IBiz> boolean checkBizClassSafety(Class<T> cls, String str) {
        if (cls == null) {
            LogUtils.m31491d(str, "checkBizClassSafety:clz is null");
            return false;
        } else if (!cls.isInterface()) {
            LogUtils.m31491d(str, "checkBizClassSafety:clz is not interface type, clz = " + cls);
            return false;
        } else if (!IBiz.class.isAssignableFrom(cls) || IBiz.class.equals(cls)) {
            LogUtils.m31491d(str, ".checkBizClassSafety:clz is not child interface of IBiz， clz = " + cls);
            return false;
        } else {
            IIBiz iIBiz = (IIBiz) cls.getAnnotation(IIBiz.class);
            if (iIBiz == null) {
                LogUtils.m31491d(str, ".checkBizClassSafety:clz has not IIBiz annotation, clz = " + cls);
                return false;
            } else if (!TextUtils.isEmpty(iIBiz.key())) {
                return true;
            } else {
                LogUtils.m31491d(str, ".checkBizClassSafety:the key of IIBiz annotation is empty, clz = " + cls);
                return false;
            }
        }
    }

    public static void checkMethod(Method method, String str) {
        if (method != null) {
            IIApi iIApi = (IIApi) method.getAnnotation(IIApi.class);
            checkIIApi(iIApi, str);
            ApiInvokePolicy apiInvokePolicy = iIApi.apiInvokePolicy();
            if (!ApiInvokePolicy.INNER.equals(apiInvokePolicy)) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes == null || parameterTypes.length == 0) {
                    throw new IllegalArgumentException(str + ".checkMethod:parameterTypes is empty, method = " + method);
                } else if (parameterTypes.length >= 2) {
                    if (Map.class.isAssignableFrom(parameterTypes[0])) {
                        Class cls = parameterTypes[parameterTypes.length - 1];
                        if (ApiInvokePolicy.RPC.equals(apiInvokePolicy)) {
                            checkIIRpc((IIRpc) method.getAnnotation(IIRpc.class), str);
                            if (!RemoteCallback.class.isAssignableFrom(cls)) {
                                throw new IllegalArgumentException(str + ".checkMethod:callbackType is not RemoteCallback, method = " + method);
                            }
                        } else if (ApiInvokePolicy.BFF.equals(apiInvokePolicy)) {
                            IIBff iIBff = (IIBff) method.getAnnotation(IIBff.class);
                            checkIIBff(iIBff, str);
                            if (BffVersion.V1.equals(iIBff.version())) {
                                if (!RemoteCallback.class.isAssignableFrom(cls)) {
                                    throw new IllegalArgumentException(str + ".checkMethod:callbackType is not RemoteCallback, method = " + method);
                                }
                            } else if (BffVersion.V2.equals(iIBff.version()) && !BffResponseListener.class.isAssignableFrom(cls)) {
                                throw new IllegalArgumentException(str + ".checkMethod:callbackType is not BffResponseListener, method = " + method);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException(str + ".checkMethod:requestParamType is not Map, method = " + method);
                    }
                } else {
                    throw new IllegalArgumentException(str + ".checkMethod:parameterTypes is less than 2, method = " + method);
                }
            }
        } else {
            throw new IllegalArgumentException(str + ".checkMethod:method is null ");
        }
    }

    public static void checkIIApi(IIApi iIApi, String str) {
        if (iIApi == null) {
            throw new NullPointerException(str + ".checkIIApi:iiApi is null");
        } else if (!TextUtils.isEmpty(iIApi.key())) {
            DataLevel storeDataLevel = iIApi.storeDataLevel();
            Class<? extends IStoreCallback> apiStoreCallbackImp = iIApi.apiStoreCallbackImp();
            if (!DataLevel.NONE.equals(storeDataLevel) && IStoreCallback.class.equals(apiStoreCallbackImp)) {
                throw new IllegalArgumentException(str + ".checkIIApi:invalid apiStoreCallbackImp, clz = " + apiStoreCallbackImp);
            }
        } else {
            throw new IllegalArgumentException(str + ".checkIIApi:invalid iiApi, iiApi.key() is empty");
        }
    }

    public static void checkIIRpc(IIRpc iIRpc, String str) {
        if (iIRpc == null) {
            throw new NullPointerException(str + ".checkIIRpc:iiRpc is null");
        } else if (TextUtils.isEmpty(iIRpc.hostKey())) {
            throw new IllegalArgumentException(str + ".checkIIRpc:invalid iiRpc, iiRpc.hostKey() is empty");
        } else if (TextUtils.isEmpty(iIRpc.host())) {
            throw new IllegalArgumentException(str + ".checkIIRpc:invalid iiRpc, iiRpc.host() is empty");
        }
    }

    public static void checkIIBff(IIBff iIBff, String str) {
        if (iIBff == null) {
            throw new NullPointerException(str + ".checkIIBff:iiBff is null");
        } else if (!TextUtils.isEmpty(iIBff.ability())) {
            Class<?> dataType = iIBff.dataType();
            if (BffVersion.V1.equals(iIBff.version()) || !BffVersion.V2.equals(iIBff.version())) {
                return;
            }
            if (BffBaseObject.class.isAssignableFrom(dataType)) {
                Class<? extends BffV2InvokeCallback> bffV2InvokeCallbackImp = iIBff.bffV2InvokeCallbackImp();
                TypeVariable[] typeParameters = bffV2InvokeCallbackImp.getTypeParameters();
                if (typeParameters != null && typeParameters.length > 0) {
                    throw new IllegalArgumentException(TAG + ".checkIIBff:invalid iiBff V2, bffV2InvokeCallbackImp must not be generic class, iiBff.bffV2InvokeCallbackImp() = " + bffV2InvokeCallbackImp);
                }
                return;
            }
            throw new IllegalArgumentException(TAG + ".checkIIBff:invalid iiBff V2, iiBff.dataType() = " + dataType);
        } else {
            throw new IllegalArgumentException(TAG + ".checkIIBff:invalid iiBff, iiBff.ability() is empty");
        }
    }

    public static synchronized Map<String, WeakReference<Session>> getSessionMap() {
        HashMap hashMap;
        synchronized (TravelSDKV2.class) {
            hashMap = new HashMap(f44279d);
        }
        return hashMap;
    }

    public static synchronized Session createSession(String str, Class<? extends IBiz>... clsArr) {
        Session session;
        synchronized (TravelSDKV2.class) {
            String str2 = TAG;
            LogUtils.m31493i(str2, "createSession:tag = " + str + ", bizClzArray = " + clsArr);
            session = new Session(str, clsArr);
            f44279d.put(session.getKey(), new WeakReference(session));
        }
        return session;
    }

    public static synchronized Session getSession(String str) {
        Session session;
        synchronized (TravelSDKV2.class) {
            WeakReference weakReference = f44279d.get(str);
            if (weakReference == null) {
                session = null;
            } else {
                session = (Session) weakReference.get();
            }
        }
        return session;
    }

    public static <T> String getStoreKey(Api api, Object[] objArr, T t) {
        String str;
        if (api == null) {
            return "";
        }
        IStoreCallback apiStoreCallback = api.getApiStoreCallback();
        if (apiStoreCallback == null) {
            str = IStoreCallback.DEFAULT_API_DETAIL_KEY;
        } else {
            str = apiStoreCallback.getStoreApiDetailKey(objArr, t);
        }
        return KeyUtil.generateStoreKey(api.getBizKey(), api.getKey(), str);
    }

    public static boolean isNeedStore(Api api, DataLevel dataLevel) {
        if (api != null && !DataLevel.NONE.equals(api.getStoreDataLevel()) && dataLevel.compareTo(api.getStoreDataLevel()) >= 0) {
            return true;
        }
        return false;
    }

    public static <T> void handleStore(Api api, DataLevel dataLevel, Object[] objArr, T t) {
        if (isNeedStore(api, dataLevel)) {
            String str = TAG;
            LogUtils.m31493i(str, "handleStore:api = " + api + ", args = " + objArr + ", data = " + t + ", dataLevel = " + dataLevel);
            Store orCreateStore = Store.getOrCreateStore(getStoreKey(api, objArr, t));
            if (orCreateStore != null) {
                orCreateStore.setCallback(api.getApiStoreCallback());
                orCreateStore.setStore(objArr, t);
            }
        }
    }

    public static <T> void bindStoreLifeCycle(Session session, Api api, Object[] objArr, T t) {
        if (session == null) {
            String str = TAG;
            LogUtils.m31495w(str, "bindStoreLifeCycle:session is null, api = " + api);
            return;
        }
        Store orCreateStore = Store.getOrCreateStore(getStoreKey(api, objArr, t));
        if (orCreateStore != null) {
            orCreateStore.setOuterLifecycle(session.getLifecycle());
        }
    }
}
