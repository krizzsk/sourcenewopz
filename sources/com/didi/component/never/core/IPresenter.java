package com.didi.component.never.core;

import android.content.Intent;
import android.os.Bundle;
import com.didi.component.never.core.data.NodeStatus;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.component.never.core.node.NodeLaunchMode;
import com.didi.component.never.core.sender.DataSender;

public interface IPresenter {
    Bundle dataInfo(NodeStatus nodeStatus);

    void doPublish(String str);

    void doPublish(String str, Object obj);

    IComponent findComponent(String str);

    DataSender getDataSender(String str, String str2);

    void goBack();

    void goBack(Bundle bundle);

    void goBackRoot();

    void goBackRoot(Bundle bundle);

    void onActivityResult(int i, int i2, Intent intent);

    void onAdd(Bundle bundle);

    boolean onBackPressed();

    void onPageHiddenChanged(boolean z);

    void onPagePause();

    void onPageResume();

    void onPageStart();

    void onPageStop();

    void onRemove();

    void startNode(String str, NodeLaunchMode nodeLaunchMode);

    void startNode(String str, NodeLaunchMode nodeLaunchMode, Bundle bundle);

    void subscribe(String str, BaseEventPublisher.OnEventListener onEventListener);

    void subscribe(String str, BaseEventPublisher.OnEventListener onEventListener, Class<?> cls);

    void unsubscribe(String str, BaseEventPublisher.OnEventListener onEventListener);

    void unsubscribe(String str, BaseEventPublisher.OnEventListener onEventListener, Class<?> cls);
}
