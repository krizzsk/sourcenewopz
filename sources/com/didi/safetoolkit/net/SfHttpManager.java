package com.didi.safetoolkit.net;

import android.content.Context;
import android.text.TextUtils;
import com.didi.safetoolkit.model.SfBaseObject;
import com.didi.safetoolkit.util.SfEnvironment;
import com.didi.safetoolkit.util.SfLog;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.PathParameter;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

public final class SfHttpManager implements INetworkService {

    /* renamed from: a */
    private static volatile SfHttpManager f34525a;

    /* renamed from: c */
    private static final RpcService.Callback f34526c = new SfRpcCallback<SfBaseObject>((SfResponseListener) null) {
    };

    /* renamed from: b */
    private RpcServiceFactory f34527b;

    private SfHttpManager(Context context) {
        this.f34527b = new RpcServiceFactory(context.getApplicationContext());
    }

    public static SfHttpManager getInstance(Context context) {
        if (f34525a == null) {
            synchronized (SfHttpManager.class) {
                if (f34525a == null) {
                    f34525a = new SfHttpManager(context);
                }
            }
        }
        return f34525a;
    }

    public void performRequest(ISfRpcRequest iSfRpcRequest, RpcService.Callback<?> callback) {
        Map<String, Object> a = C11781a.m24390a(iSfRpcRequest);
        Class a2 = m24384a(iSfRpcRequest);
        if (a2 != null) {
            m24385a(a2, a, iSfRpcRequest.getServiceName(), iSfRpcRequest.getBaseUrl(), iSfRpcRequest.getPathParameter(), callback);
        }
    }

    /* renamed from: a */
    private void m24385a(Class cls, Map<String, Object> map, String str, String str2, String str3, RpcService.Callback<?> callback) {
        Annotation[][] parameterAnnotations;
        if (cls == null || TextUtils.isEmpty(str)) {
            SfLog.m24403e("@executeRpcServiceRequest, Rpc Clazz or method is null!");
            return;
        }
        Method method = null;
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Method method2 = declaredMethods[i];
            if (str.equals(method2.getName())) {
                method = method2;
                break;
            }
            i++;
        }
        if (method != null && (parameterAnnotations = method.getParameterAnnotations()) != null && parameterAnnotations.length != 0) {
            ArrayList arrayList = new ArrayList(4);
            ArrayList arrayList2 = new ArrayList(4);
            for (Annotation[] annotationArr : parameterAnnotations) {
                if (annotationArr != null && annotationArr.length > 0) {
                    Class<? extends Annotation> annotationType = annotationArr[0].annotationType();
                    if (PathParameter.class.equals(annotationType)) {
                        arrayList.add(String.class);
                        arrayList2.add(str3);
                    } else if (QueryParameter.class.equals(annotationType) || BodyParameter.class.equals(annotationType)) {
                        arrayList.add(Map.class);
                        arrayList2.add(map);
                    } else if (TargetThread.class.equals(annotationType)) {
                        arrayList.add(RpcService.Callback.class);
                        arrayList2.add(callback == null ? f34526c : callback);
                    }
                }
            }
            try {
                RpcService a = m24383a(cls, str2);
                Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) arrayList.toArray(new Class[arrayList.size()]));
                SfLog.m24409i("SfHttpManager", String.format("Start rpc: %s#%s", new Object[]{cls.getCanonicalName(), str}));
                declaredMethod.invoke(a, arrayList2.toArray());
            } catch (NoSuchMethodException e) {
                SfLog.m24407e((Throwable) e);
                m24386a((Exception) e);
            } catch (InvocationTargetException e2) {
                SfLog.m24407e((Throwable) e2);
                m24386a((Exception) e2);
            } catch (IllegalAccessException e3) {
                SfLog.m24407e((Throwable) e3);
                m24386a((Exception) e3);
            } catch (Exception e4) {
                SfLog.m24407e((Throwable) e4);
                m24386a(e4);
            }
        }
    }

    /* renamed from: a */
    private void m24386a(Exception exc) {
        if (SfEnvironment.DEBUG) {
            throw new RuntimeException(exc);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.reflect.ParameterizedType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.reflect.ParameterizedType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Class} */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r8 = ((java.lang.reflect.ParameterizedType) r4).getActualTypeArguments();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Class m24384a(com.didi.safetoolkit.net.ISfRpcRequest r8) {
        /*
            r7 = this;
            java.lang.Class r8 = r8.getClass()
            java.lang.reflect.Type[] r8 = r8.getGenericInterfaces()
            int r0 = r8.length
            r1 = 0
            r2 = 0
        L_0x000b:
            r3 = 0
            if (r2 >= r0) goto L_0x0023
            r4 = r8[r2]
            r5 = r4
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
            java.lang.reflect.Type r5 = r5.getRawType()
            java.lang.Class r5 = (java.lang.Class) r5
            java.lang.Class r5 = (java.lang.Class) r5
            java.lang.Class<com.didi.safetoolkit.net.ISfRpcRequest> r6 = com.didi.safetoolkit.net.ISfRpcRequest.class
            if (r5 != r6) goto L_0x0020
            goto L_0x0024
        L_0x0020:
            int r2 = r2 + 1
            goto L_0x000b
        L_0x0023:
            r4 = r3
        L_0x0024:
            if (r4 == 0) goto L_0x0034
            java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
            java.lang.reflect.Type[] r8 = r4.getActualTypeArguments()
            if (r8 == 0) goto L_0x0034
            int r0 = r8.length
            if (r0 <= 0) goto L_0x0034
            r8 = r8[r1]
            goto L_0x0035
        L_0x0034:
            r8 = r3
        L_0x0035:
            if (r8 == 0) goto L_0x003a
            r3 = r8
            java.lang.Class r3 = (java.lang.Class) r3
        L_0x003a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safetoolkit.net.SfHttpManager.m24384a(com.didi.safetoolkit.net.ISfRpcRequest):java.lang.Class");
    }

    /* renamed from: a */
    private <T extends RpcService> T m24383a(Class<T> cls, String str) {
        return this.f34527b.newRpcService(cls, str);
    }
}
