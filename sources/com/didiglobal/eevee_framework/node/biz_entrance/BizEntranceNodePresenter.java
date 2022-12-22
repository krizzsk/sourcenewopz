package com.didiglobal.eevee_framework.node.biz_entrance;

import android.os.Bundle;
import com.didi.component.never.core.node.Node;
import com.didiglobal.common.common.never.node.EeveeNodePresenterImpl;
import java.util.ArrayList;
import java.util.List;

public class BizEntranceNodePresenter extends EeveeNodePresenterImpl {
    public BizEntranceNodePresenter(Node node, Bundle bundle) {
        super(node, bundle);
    }

    public List<String> initComponents() {
        return new ArrayList();
    }
}
