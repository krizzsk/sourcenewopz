package com.didi.component.never.core;

import android.os.Bundle;
import com.didi.component.never.core.node.Node;
import com.didi.component.never.core.page.Page;

public interface IPageSwitcherV2 {
    boolean forward(Node node, Bundle bundle);

    Page getHost();

    boolean goBack();

    boolean goBack(Bundle bundle);

    boolean goBackRoot();

    boolean goBackRoot(Bundle bundle);
}
