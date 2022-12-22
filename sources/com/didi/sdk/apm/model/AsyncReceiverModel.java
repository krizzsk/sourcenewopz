package com.didi.sdk.apm.model;

import android.content.Intent;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AsyncReceiverModel {
    public static final String EXTRA_MARKUP_FLAG = "extra_markup_flag";

    /* renamed from: a */
    private static final String f35042a = "AsyncReceiverModel";
    public Method method;
    public Object obj;
    public Object[] params;

    public AsyncReceiverModel(Method method2, Object obj2, Object[] objArr) {
        this.method = method2;
        this.obj = obj2;
        this.params = objArr;
    }

    public void invokeOnReceiveMethod() {
        try {
            if (this.params != null) {
                Object[] objArr = this.params;
                int length = objArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Object obj2 = objArr[i];
                    if (obj2 instanceof Intent) {
                        ((Intent) obj2).putExtra(EXTRA_MARKUP_FLAG, 1);
                        break;
                    }
                    i++;
                }
            }
            this.method.invoke(this.obj, this.params);
            Log.v(f35042a, "invoke onReceive success!");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
