package com.didi.component.common.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.common.base.ComponentProxy;
import com.didi.component.common.util.GoBackRootUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;
import com.didi.travel.p171v2.store.Store;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.p170v2.TravelUtil;

public abstract class BaseExpressPresenter<V extends IView> extends IPresenter<V> {
    protected final String TAG = getClass().getSimpleName();
    /* access modifiers changed from: protected */
    public ComponentParams mComponentParams;
    protected ComponentProxy mComponentProxy;

    public void afterCreateSession() {
    }

    public void afterDestroySession() {
    }

    /* access modifiers changed from: protected */
    public void afterOrderIdUpdate() {
    }

    /* access modifiers changed from: protected */
    public void beforeCreateSession() {
    }

    public void beforeDestroySession() {
    }

    /* access modifiers changed from: protected */
    public void beforeOrderIdUpdate() {
    }

    public BaseExpressPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
        this.mComponentProxy = new ComponentProxy(new ComponentProxy.ComponentCallback() {
            public int getPageId() {
                return BaseExpressPresenter.this.mComponentParams.pageID;
            }

            public void beforeCreateSession() {
                super.beforeCreateSession();
                BaseExpressPresenter.this.beforeCreateSession();
            }

            public void afterCreateSession() {
                super.afterCreateSession();
                BaseExpressPresenter.this.afterCreateSession();
            }

            public void beforeDestroySession() {
                super.beforeDestroySession();
                BaseExpressPresenter.this.beforeDestroySession();
            }

            public void afterDestroySession() {
                super.afterDestroySession();
                BaseExpressPresenter.this.afterDestroySession();
            }

            public void beforeOrderIdUpdate() {
                super.beforeOrderIdUpdate();
                BaseExpressPresenter.this.beforeOrderIdUpdate();
            }

            public void afterOrderIdUpdate() {
                super.afterOrderIdUpdate();
                BaseExpressPresenter.this.afterOrderIdUpdate();
            }
        }, getClass().getSimpleName());
    }

    public ComponentProxy getComponentProxy() {
        return this.mComponentProxy;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        String str = this.TAG;
        LogUtils.m31493i(str, "onAdd:arguments = " + bundle);
        this.mComponentProxy.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.mComponentProxy.onRemove();
    }

    /* access modifiers changed from: protected */
    public void goBackRoot() {
        if (!GoBackRootUtils.hasGobackRideHome(getHost().getFragmentManager(), (Bundle) null)) {
            super.goBackRoot();
        }
    }

    /* access modifiers changed from: protected */
    public void goBackRoot(Bundle bundle) {
        if (!GoBackRootUtils.hasGobackRideHome(getHost().getFragmentManager(), bundle)) {
            super.goBackRoot(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
    }

    /* access modifiers changed from: protected */
    public Store<DTSDKOrderDetail> getOrderDetailStore() {
        String orderId = this.mComponentProxy.getOrderId();
        if (TextUtils.isEmpty(orderId) || this.mComponentProxy.getSession() == null) {
            return null;
        }
        return Store.getStore(TravelUtil.generateCarOrderStoreKey(orderId));
    }
}
