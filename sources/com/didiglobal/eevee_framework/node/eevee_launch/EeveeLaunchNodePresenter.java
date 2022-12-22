package com.didiglobal.eevee_framework.node.eevee_launch;

import android.os.Bundle;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.component.never.core.node.Node;
import com.didiglobal.common.business.arrangement.ArrangementUtil;
import com.didiglobal.common.business.constant.ComponentType;
import com.didiglobal.common.common.event.BaseEventKeys;
import com.didiglobal.common.common.never.node.EeveeNodePresenterImpl;
import com.didiglobal.common.common.util.NodeStartUtil;
import com.didiglobal.common.common.xengine.XEngineReq;
import java.util.ArrayList;
import java.util.List;

public class EeveeLaunchNodePresenter extends EeveeNodePresenterImpl {

    /* renamed from: a */
    private final BaseEventPublisher.OnEventListener<String> f50104a = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (str2.equals("eevee")) {
                EeveeLaunchNodePresenter.this.m36102a();
            }
        }
    };

    public EeveeLaunchNodePresenter(Node node, Bundle bundle) {
        super(node, bundle);
    }

    public List<String> initComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ComponentType.XENGINE);
        arrayList.add(ComponentType.COMP_ARRANGEMENT);
        return arrayList;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Common.COMP_ARRANGEMENT_READY, this.f50104a);
        XEngineReq.pageRequest("eevee");
    }

    public void onPageResume() {
        super.onPageResume();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36102a() {
        NodeStartUtil.startNode(getNodeManager(), "push", ArrangementUtil.getStartNodeName(), getBundles());
    }

    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Common.COMP_ARRANGEMENT_READY, this.f50104a);
    }
}
