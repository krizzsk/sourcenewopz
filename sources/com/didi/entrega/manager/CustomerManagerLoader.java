package com.didi.entrega.manager;

import com.didi.entrega.manager.CustomerManagerRegistry;
import com.didi.entrega.manager.base.ICustomerManager;

public final class CustomerManagerLoader {

    /* renamed from: a */
    private static CustomerManagerRegistry<Class, CustomerManagerWrapper> f20823a = new CustomerManagerRegistry<>();

    /* renamed from: b */
    private static CustomerManagerRegistry<Class, CustomerManagerWrapper> f20824b = new CustomerManagerRegistry<>();

    private CustomerManagerLoader() {
    }

    public static void init() {
        CustomerManagerLoaderProxy.initManager();
    }

    public static <T extends ICustomerManager> T loadManager(Class<T> cls) {
        CustomerManagerWrapper customerManagerWrapper = f20823a.get(cls);
        if (customerManagerWrapper == null) {
            return f20824b.get(cls).getInnerManager();
        }
        return customerManagerWrapper.getInnerManager();
    }

    public static void start() {
        f20823a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.start();
            }
        });
    }

    public static void stop() {
        f20823a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.stop();
            }
        });
    }

    public static void destroy() {
        f20823a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.destroy();
            }
        });
        f20823a.clear();
    }

    /* renamed from: a */
    static void m15235a(Class<? extends ICustomerManager> cls, ICustomerManager iCustomerManager) {
        if (iCustomerManager != null) {
            CustomerManagerWrapper customerManagerWrapper = new CustomerManagerWrapper(iCustomerManager);
            customerManagerWrapper.create();
            f20823a.register(cls, customerManagerWrapper);
        }
    }

    /* renamed from: b */
    static void m15236b(Class<? extends ICustomerManager> cls, ICustomerManager iCustomerManager) {
        if (iCustomerManager != null) {
            CustomerManagerWrapper customerManagerWrapper = new CustomerManagerWrapper(iCustomerManager);
            customerManagerWrapper.create();
            f20824b.register(cls, customerManagerWrapper);
        }
    }
}
