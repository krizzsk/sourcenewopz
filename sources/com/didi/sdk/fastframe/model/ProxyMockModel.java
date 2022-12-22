package com.didi.sdk.fastframe.model;

import android.os.AsyncTask;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyMockModel implements InvocationHandler {

    /* renamed from: a */
    private static final int f35889a = 1000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Object f35890b;

    public ProxyMockModel(Object obj) {
        this.f35890b = obj;
    }

    public Object invoke(Object obj, final Method method, final Object[] objArr) throws Throwable {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                try {
                    Thread.sleep(1000);
                    return null;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Void voidR) {
                try {
                    method.invoke(ProxyMockModel.this.f35890b, objArr);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                }
            }
        }.execute(new Void[0]);
        return null;
    }
}
