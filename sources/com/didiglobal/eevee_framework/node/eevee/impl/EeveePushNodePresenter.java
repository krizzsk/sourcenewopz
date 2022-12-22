package com.didiglobal.eevee_framework.node.eevee.impl;

import android.os.Bundle;
import com.didi.component.never.core.node.Node;
import com.didiglobal.common.common.never.node.EeveeNodePresenterImpl;
import com.didiglobal.common.common.xengine.XERequestRecord;
import com.didiglobal.common.common.xengine.XEngineReq;

public class EeveePushNodePresenter extends EeveeNodePresenterImpl {

    /* renamed from: a */
    private static final String f50103a = EeveePushNodePresenter.class.getSimpleName();

    public EeveePushNodePresenter(Node node, Bundle bundle) {
        super(node, bundle);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    public void setEeveeNodeId(String str) {
        super.setEeveeNodeId(str);
    }

    public String getEeveeNodeId() {
        return super.getEeveeNodeId();
    }

    public void onPagePause() {
        super.onPagePause();
    }

    public void onPageStart() {
        super.onPageStart();
    }

    public void onPageStop() {
        super.onPageStop();
    }

    public void onRemove() {
        super.onRemove();
    }

    public void onPageResume() {
        super.onPageResume();
        String eeveeNodeId = getEeveeNodeId();
        if (!XERequestRecord.getInstance().hasRecord(eeveeNodeId)) {
            XEngineReq.pageRequest(eeveeNodeId, true);
            XERequestRecord.getInstance().countIncrease(eeveeNodeId);
            return;
        }
        XEngineReq.pageRequest(eeveeNodeId);
    }

    public boolean onBackPressed() {
        return super.onBackPressed();
    }
}
