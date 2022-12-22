package com.didiglobal.p205sa.biz.node;

import android.os.Bundle;
import com.didi.component.never.core.node.NodeImpl;
import com.didi.component.never.core.node.NodeManager;
import com.didi.component_processor.annonation.NodeName;
import com.didiglobal.p205sa.biz.presenter.SuperAppActivityPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/node/SuperActivityNode;", "Lcom/didi/component/never/core/node/NodeImpl;", "Lcom/didiglobal/sa/biz/presenter/SuperAppActivityPresenter;", "nodeManager", "Lcom/didi/component/never/core/node/NodeManager;", "bundle", "Landroid/os/Bundle;", "(Lcom/didi/component/never/core/node/NodeManager;Landroid/os/Bundle;)V", "createPresenter", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@NodeName(name = "NODE_SUPPER_ACTIVITY")
/* renamed from: com.didiglobal.sa.biz.node.SuperActivityNode */
/* compiled from: SuperActivityNode.kt */
public final class SuperActivityNode extends NodeImpl<SuperAppActivityPresenter> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperActivityNode(NodeManager nodeManager, Bundle bundle) {
        super(nodeManager, bundle);
        Intrinsics.checkNotNullParameter(nodeManager, "nodeManager");
    }

    public SuperAppActivityPresenter createPresenter(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return new SuperAppActivityPresenter(this, bundle);
    }
}
