package com.didiglobal.common.common.never.node;

import android.os.Bundle;
import com.didi.component.never.core.node.Node;
import com.didi.component.never.core.node.NodePresenterImpl;
import com.didiglobal.common.business.arrangement.ArrangementUtil;
import com.didiglobal.common.common.util.NodeStartUtil;
import java.util.List;

public abstract class EeveeNodePresenterImpl extends NodePresenterImpl {
    protected String eeveeNodeId;

    public EeveeNodePresenterImpl(Node node, Bundle bundle) {
        super(node, bundle);
    }

    /* access modifiers changed from: protected */
    public void onNodePresenterInit(Node node, Bundle bundle) {
        super.onNodePresenterInit(node, bundle);
        if (bundle != null && bundle.containsKey(NodeStartUtil.EEVEE_NODE_ID)) {
            setEeveeNodeId(bundle.getString(NodeStartUtil.EEVEE_NODE_ID));
        }
    }

    public void onPageHiddenChanged(boolean z) {
        super.onPageHiddenChanged(z);
    }

    public void onPageStop() {
        super.onPageStop();
    }

    public void onRemove() {
        super.onRemove();
        setEeveeNodeId((String) null);
    }

    public String getEeveeNodeId() {
        return this.eeveeNodeId;
    }

    public void setEeveeNodeId(String str) {
        this.eeveeNodeId = str;
    }

    public List<String> initComponents() {
        return ArrangementUtil.convertComponents(ArrangementUtil.getCachedInflatedComponents(getEeveeNodeId()));
    }
}
