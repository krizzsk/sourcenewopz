package com.didi.soda.manager;

import com.didi.soda.manager.CustomerManagerRegistry;
import com.didi.soda.manager.base.ICustomerManager;

public final class CustomerManagerLoader {

    /* renamed from: a */
    private static CustomerManagerRegistry<Class, CustomerManagerWrapper> f43358a = new CustomerManagerRegistry<>();

    /* renamed from: b */
    private static CustomerManagerRegistry<Class, CustomerManagerWrapper> f43359b = new CustomerManagerRegistry<>();

    private CustomerManagerLoader() {
    }

    public static void init() {
        CustomerManagerLoaderProxy.initManager();
    }

    public static <T extends ICustomerManager> T loadManager(Class<T> cls) {
        CustomerManagerWrapper customerManagerWrapper = f43358a.get(cls);
        if (customerManagerWrapper == null) {
            return f43359b.get(cls).getInnerManager();
        }
        return customerManagerWrapper.getInnerManager();
    }

    public static void start() {
        f43358a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.start();
            }
        });
    }

    public static void stop() {
        f43358a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.stop();
            }
        });
    }

    public static void destroy() {
        f43358a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.destroy();
            }
        });
        f43358a.clear();
    }

    /* renamed from: a */
    static void m30662a(Class<? extends ICustomerManager> cls, ICustomerManager iCustomerManager) {
        if (iCustomerManager != null) {
            CustomerManagerWrapper customerManagerWrapper = new CustomerManagerWrapper(iCustomerManager);
            customerManagerWrapper.create();
            f43358a.register(cls, customerManagerWrapper);
        }
    }

    /* renamed from: b */
    static void m30663b(Class<? extends ICustomerManager> cls, ICustomerManager iCustomerManager) {
        if (iCustomerManager != null) {
            CustomerManagerWrapper customerManagerWrapper = new CustomerManagerWrapper(iCustomerManager);
            customerManagerWrapper.create();
            f43359b.register(cls, customerManagerWrapper);
        }
    }
}
