package com.didi.rfusion.widget.floating;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.config.RFLogger;

public interface IRFFloatingExpand {
    void dismiss(ScopeContext scopeContext);

    void dismiss(ScopeContext scopeContext, Bundle bundle);

    Bundle getFloatingArgs(ScopeContext scopeContext);

    RFFloatingNavBar getNavBar(ScopeContext scopeContext);

    void pushOuter(ScopeContext scopeContext, Page page);

    void pushOuter(ScopeContext scopeContext, Dialog dialog, String str);

    void pushPage(ScopeContext scopeContext, Page page);

    void pushPage(ScopeContext scopeContext, Page page, int i);

    void setGestureEnable(ScopeContext scopeContext, boolean z);

    /* renamed from: com.didi.rfusion.widget.floating.IRFFloatingExpand$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static RFFloatingNavBar $default$getNavBar(IRFFloatingExpand _this, ScopeContext scopeContext) {
            return (RFFloatingNavBar) scopeContext.getBundle().getSerializable(RFFloating.f33528m);
        }

        public static void $default$setGestureEnable(IRFFloatingExpand _this, ScopeContext scopeContext, boolean z) {
            if (scopeContext != null) {
                RFFloatingControllerProxy rFFloatingControllerProxy = (RFFloatingControllerProxy) scopeContext.getBundle().getSerializable(RFFloating.f33527l);
                if (rFFloatingControllerProxy != null) {
                    rFFloatingControllerProxy.setGestureEnable(z);
                } else {
                    RFLogger.getLogger().info("IRFFloatingExpand", "setGestureEnable:fail");
                }
            }
        }

        public static void $default$dismiss(IRFFloatingExpand _this, ScopeContext scopeContext) {
            if (scopeContext != null) {
                RFFloatingControllerProxy rFFloatingControllerProxy = (RFFloatingControllerProxy) scopeContext.getBundle().getSerializable(RFFloating.f33527l);
                if (rFFloatingControllerProxy != null) {
                    rFFloatingControllerProxy.dismiss();
                } else {
                    RFLogger.getLogger().info("IRFFloatingExpand", "dismiss:fail");
                }
            }
        }

        public static void $default$dismiss(IRFFloatingExpand _this, ScopeContext scopeContext, Bundle bundle) {
            if (scopeContext != null) {
                RFFloatingControllerProxy rFFloatingControllerProxy = (RFFloatingControllerProxy) scopeContext.getBundle().getSerializable(RFFloating.f33527l);
                if (rFFloatingControllerProxy != null) {
                    rFFloatingControllerProxy.dismiss(bundle);
                } else {
                    RFLogger.getLogger().info("IRFFloatingExpand", "dismiss:fail");
                }
            }
        }

        public static Bundle $default$getFloatingArgs(IRFFloatingExpand _this, ScopeContext scopeContext) {
            if (scopeContext == null) {
                return null;
            }
            RFFloatingControllerProxy rFFloatingControllerProxy = (RFFloatingControllerProxy) scopeContext.getBundle().getSerializable(RFFloating.f33527l);
            if (rFFloatingControllerProxy != null) {
                return rFFloatingControllerProxy.getArgs();
            }
            RFLogger.getLogger().info("IRFFloatingExpand", "getFloatingArgs:fail");
            return null;
        }

        public static void $default$pushPage(IRFFloatingExpand _this, ScopeContext scopeContext, Page page) {
            _this.pushPage(scopeContext, page, 0);
        }

        public static void $default$pushPage(IRFFloatingExpand _this, ScopeContext scopeContext, Page page, int i) {
            if (scopeContext != null && page != null) {
                RFFloatingControllerProxy rFFloatingControllerProxy = (RFFloatingControllerProxy) scopeContext.getBundle().getSerializable(RFFloating.f33527l);
                if (rFFloatingControllerProxy != null) {
                    rFFloatingControllerProxy.pushPage(page, i);
                } else {
                    RFLogger.getLogger().info("IRFFloatingExpand", "push:fail");
                }
            }
        }

        public static void $default$pushOuter(IRFFloatingExpand _this, ScopeContext scopeContext, Page page) {
            if (scopeContext != null) {
                RFFloatingControllerProxy rFFloatingControllerProxy = (RFFloatingControllerProxy) scopeContext.getBundle().getSerializable(RFFloating.f33527l);
                if (rFFloatingControllerProxy != null) {
                    rFFloatingControllerProxy.pushOuter(page);
                } else {
                    RFLogger.getLogger().info("IRFFloatingExpand", "pushOuter:fail");
                }
            }
        }

        public static void $default$pushOuter(IRFFloatingExpand _this, ScopeContext scopeContext, Dialog dialog, String str) {
            if (scopeContext != null) {
                RFFloatingControllerProxy rFFloatingControllerProxy = (RFFloatingControllerProxy) scopeContext.getBundle().getSerializable(RFFloating.f33527l);
                if (rFFloatingControllerProxy != null) {
                    rFFloatingControllerProxy.pushOuter(dialog, str);
                } else {
                    RFLogger.getLogger().info("IRFFloatingExpand", "pushOuter:fail");
                }
            }
        }
    }
}
