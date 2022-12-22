package com.didiglobal.common.common.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.never.core.node.NodeLaunchMode;
import com.didi.component.never.core.node.NodeManager;
import com.didiglobal.common.business.constant.NodeId;

public class NodeStartUtil {
    public static final String EEVEE_NODE_ID = "EEVEE_NODE_ID";

    public static void startNode(NodeManager nodeManager, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(EEVEE_NODE_ID, str2);
        NodeLaunchMode convertLaunchMode = convertLaunchMode(str);
        nodeManager.startNode(getNodeId(convertLaunchMode), convertLaunchMode, bundle);
    }

    public static NodeLaunchMode convertLaunchMode(String str) {
        if (TextUtils.isEmpty(str)) {
            return NodeLaunchMode.PUSH;
        }
        str.hashCode();
        return NodeLaunchMode.PUSH;
    }

    public static String getNodeId(NodeLaunchMode nodeLaunchMode) {
        return nodeLaunchMode == NodeLaunchMode.SWITCH ? NodeId.NODE_EEVEE_SWITCH : NodeId.NODE_EEVEE_PUSH;
    }
}
