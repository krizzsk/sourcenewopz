package com.didi.sdk.fastframe.presenter;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fastframe.model.IModel;
import com.didi.sdk.fastframe.model.ProxyMockModel;
import com.didi.sdk.fastframe.view.IView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class BasePresenter implements IPresenter {
    public static boolean IS_MOCK = false;

    /* renamed from: a */
    private static String f35891a = BasePresenter.class.getName();

    public BasePresenter(Context context, IView iView) {
    }

    public <M extends IModel> M getModel(Context context, Class<M> cls) {
        if (cls == null) {
            return null;
        }
        if (IS_MOCK) {
            try {
                return m25416a(context, cls);
            } catch (Exception e) {
                SystemUtils.log(6, f35891a, e.getMessage(), (Throwable) null, "com.didi.sdk.fastframe.presenter.BasePresenter", 48);
                return null;
            }
        } else {
            try {
                return (IModel) cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
                return null;
            }
        }
    }

    /* renamed from: a */
    private <M extends IModel> M m25416a(Context context, Class<M> cls) throws Exception {
        Class<?> cls2;
        IModel iModel;
        String name = cls.getPackage().getName();
        String simpleName = cls.getSimpleName();
        try {
            cls2 = Class.forName(name + ".Mock" + simpleName);
        } catch (ClassNotFoundException e) {
            try {
                cls2 = Class.forName(name + ".mock.Mock" + simpleName);
            } catch (ClassNotFoundException unused) {
                e.printStackTrace();
                cls2 = cls;
            }
        }
        if (cls2 != null) {
            try {
                iModel = (IModel) cls2.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
            }
            return (IModel) Proxy.newProxyInstance(iModel.getClass().getClassLoader(), iModel.getClass().getInterfaces(), new ProxyMockModel(iModel));
        }
        throw new Exception("没有 （" + name + simpleName + "） mock类");
        iModel = null;
        return (IModel) Proxy.newProxyInstance(iModel.getClass().getClassLoader(), iModel.getClass().getInterfaces(), new ProxyMockModel(iModel));
    }
}
