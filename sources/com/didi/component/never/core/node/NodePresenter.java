package com.didi.component.never.core.node;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.component.never.core.IPresenter;
import com.didi.component.never.core.container.ContainerComponent;
import com.didi.component.never.core.sender.DataSender;
import java.util.List;

public interface NodePresenter extends IPresenter {
    void changeLayoutParams(String str, ViewGroup.LayoutParams layoutParams);

    Bundle getBundles();

    List<String> getComponentList();

    DataSender getComponentSender(String str, String str2);

    ContainerComponent getContainer();

    Node getNode();

    NodeManager getNodeManager();

    void removeAll();

    void setBundles(Bundle bundle);

    void setContainer(String str);

    void setContext(Context context);
}
