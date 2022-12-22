package com.didi.unifiedPay.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class ABTestProxyHolder {

    /* renamed from: a */
    private static INewUISwitchProxy f44595a;

    /* renamed from: b */
    private static IPayMethodGroupSwitchProxy f44596b;

    /* renamed from: c */
    private static OptimizedUISwitch f44597c;

    public interface INewUISwitchProxy {
        boolean isNewTrip();
    }

    public interface IPayMethodGroupSwitchProxy {
        boolean isAllowPayMethodGroup();
    }

    public static INewUISwitchProxy getNewUISwitch() {
        return f44595a;
    }

    public static void setNewUISwitch(INewUISwitchProxy iNewUISwitchProxy) {
        f44595a = iNewUISwitchProxy;
    }

    public static IPayMethodGroupSwitchProxy getPayMethodGroupSwitch() {
        if (f44596b == null) {
            f44596b = new IPayMethodGroupSwitchProxy() {
                public boolean isAllowPayMethodGroup() {
                    return ABTestProxyHolder.getStatus("ibt_cashier_new_pay_method_list_toggle", false);
                }
            };
        }
        return f44596b;
    }

    public static void setPayMethodGroupSwitch(IPayMethodGroupSwitchProxy iPayMethodGroupSwitchProxy) {
        f44596b = iPayMethodGroupSwitchProxy;
    }

    public static synchronized OptimizedUISwitch getOptimizedUISwitch() {
        OptimizedUISwitch optimizedUISwitch;
        synchronized (ABTestProxyHolder.class) {
            if (f44597c == null) {
                f44597c = new OptimizedUISwitch();
            }
            optimizedUISwitch = f44597c;
        }
        return optimizedUISwitch;
    }

    public static class OptimizedUISwitch {
        private boolean optimize = false;

        public void setOptimize(boolean z) {
            this.optimize = z;
        }

        public boolean optimized() {
            return this.optimize;
        }
    }

    public static boolean getStatus(String str, boolean z) {
        try {
            IToggle toggle = Apollo.getToggle(str, z);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }
}
