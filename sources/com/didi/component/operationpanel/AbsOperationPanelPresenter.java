package com.didi.component.operationpanel;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.loading.AbsLoadingPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsOperationPanelPresenter extends AbsLoadingPresenter<IOperationPanelView> {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<EtaEda> f14770a = new BaseEventPublisher.OnEventListener<EtaEda>() {
        public void onEvent(String str, EtaEda etaEda) {
            EtaEda unused = AbsOperationPanelPresenter.this.f14772c = etaEda;
        }
    };

    /* renamed from: b */
    private final Logger f14771b = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EtaEda f14772c;
    protected IViewContainer.IComponentCreator componentCreator;

    /* renamed from: d */
    private long f14773d;
    protected long mCancelBtnClickTime;
    protected long mCancelDlgShowTime;
    protected ComponentParams mComponentParams;

    /* access modifiers changed from: protected */
    public abstract void onItemClicked(OperationPanelItemModel operationPanelItemModel);

    public boolean supportStandoutColor() {
        return true;
    }

    public AbsOperationPanelPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f14773d = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
        subscribe(BaseEventKeys.OnService.EVENT_STATUS_WAIT_PICK_UP_ETA, this.f14770a);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        if (this.mView != null) {
            ((IOperationPanelView) this.mView).onRemove();
        }
        unsubscribe(BaseEventKeys.OnService.EVENT_STATUS_WAIT_PICK_UP_ETA, this.f14770a);
    }

    /* access modifiers changed from: protected */
    public void showItems(ArrayList<OperationPanelItemModel> arrayList) {
        ((IOperationPanelView) this.mView).showItems(arrayList);
    }

    public final void onOperationPanelItemClicked(OperationPanelItemModel operationPanelItemModel) {
        int i = operationPanelItemModel.f14774id;
        if (i == 516) {
            m10558c();
        } else if (i != 519) {
            switch (i) {
                case 512:
                    m10557b();
                    this.f14771b.info("Click cancel btn", new Object[0]);
                    break;
                case 513:
                    GlobalOmegaUtils.trackEvent("pas_drivercard_sharetrip_ck");
                    GlobalOmegaUtils.trackEvent("gp_shareTrips_btn_ck");
                    break;
                case 514:
                    GlobalOmegaUtils.trackEvent("gp_pick_customerhelp_ck");
                    break;
            }
        } else {
            GlobalOmegaUtils.trackEvent("gp_sos_btn_ck");
        }
        onItemClicked(operationPanelItemModel);
    }

    /* renamed from: b */
    private void m10557b() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            String str = "2";
            String str2 = "1";
            if (order.status != 4 || order.substatus == 4001) {
                str = str2;
            } else if (order.substatus != 4003 && order.substatus == 4002) {
                str = "3";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("driver_status", str);
            if (!CarOrderHelper.isQuotaOrder()) {
                str2 = "0";
            }
            hashMap.put("fixed", str2);
            EtaEda etaEda = this.f14772c;
            if (etaEda != null) {
                hashMap.put("eda", Integer.valueOf(etaEda.eda));
                hashMap.put("eta", Integer.valueOf(this.f14772c.eta));
            }
            GlobalOmegaUtils.trackEvent("pas_drivercard_cancelorder_ck", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: c */
    private void m10558c() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put(ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(order.substatus));
            GlobalOmegaUtils.trackEvent("gp_oprationPanel_updateDest_btn_ck", (Map<String, Object>) hashMap);
        }
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.componentCreator = iComponentCreator;
    }

    public IComponent inflateComponent(String str, ViewGroup viewGroup) {
        IViewContainer.IComponentCreator iComponentCreator = this.componentCreator;
        if (iComponentCreator == null) {
            return null;
        }
        IComponent newComponent = iComponentCreator.newComponent(str, viewGroup);
        if (newComponent != null && newComponent.getView() != null && newComponent.getView().getView() != null) {
            return newComponent;
        }
        this.componentCreator.removeComponent(newComponent);
        return null;
    }

    public void removeComponent(IComponent iComponent) {
        IViewContainer.IComponentCreator iComponentCreator = this.componentCreator;
        if (iComponentCreator != null) {
            iComponentCreator.removeComponent(iComponent);
        }
    }
}
