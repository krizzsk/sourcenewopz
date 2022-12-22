package com.didi.component.never.core.node;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.component.never.core.IComponent;
import com.didi.component.never.core.container.ContainerComponent;
import com.didi.component.never.core.data.NodeStatus;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.component.never.core.sender.DataSender;
import com.didi.component.never.core.util.FrameworkRegister;
import com.didi.component_processor.annonation.ModuleMap;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class NodePresenterImpl implements NodePresenter {

    /* renamed from: a */
    private final String f14672a = getClass().getName();

    /* renamed from: b */
    private List<String> f14673b;
    protected Bundle bundle;

    /* renamed from: c */
    private Node f14674c;

    /* renamed from: d */
    private ContainerComponent f14675d;
    protected Context mContext;

    public Bundle dataInfo(NodeStatus nodeStatus) {
        return null;
    }

    public void doPublish(String str) {
    }

    public void doPublish(String str, Object obj) {
    }

    public abstract List<String> initComponents();

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAdd(Bundle bundle2) {
    }

    public boolean onBackPressed() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onNodePresenterInit(Node node, Bundle bundle2) {
    }

    public void onRemove() {
    }

    public NodePresenterImpl(Node node, Bundle bundle2) {
        onNodePresenterInit(node, bundle2);
        this.f14674c = node;
        m10456a();
    }

    /* renamed from: a */
    private void m10456a() {
        if (this.f14673b == null) {
            this.f14673b = new ArrayList();
        }
        boolean z = false;
        for (String next : initComponents()) {
            if (z || !ModuleMap.containerContains(next)) {
                this.f14673b.add(next);
            } else {
                setContainer(next);
                z = true;
            }
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public NodeManager getNodeManager() {
        return this.f14674c.getNodeManager();
    }

    public List<String> getComponentList() {
        return this.f14673b;
    }

    public Node getNode() {
        return this.f14674c;
    }

    public void startNode(String str, NodeLaunchMode nodeLaunchMode, Bundle bundle2) {
        getNodeManager().startNode(str, nodeLaunchMode, bundle2);
    }

    public void goBack() {
        getNodeManager().goBack((Bundle) null);
    }

    public void goBack(Bundle bundle2) {
        getNodeManager().goBack(bundle2);
    }

    public void goBackRoot() {
        getNodeManager().backToRoot((Bundle) null);
    }

    public void goBackRoot(Bundle bundle2) {
        getNodeManager().backToRoot(bundle2);
    }

    public void subscribe(String str, BaseEventPublisher.OnEventListener onEventListener) {
        if (!TextUtils.isEmpty(str) && onEventListener != null) {
            BaseEventPublisher.getPublisher().subscribe(str, onEventListener);
        }
    }

    public void unsubscribe(String str, BaseEventPublisher.OnEventListener onEventListener) {
        if (!TextUtils.isEmpty(str) && onEventListener != null) {
            BaseEventPublisher.getPublisher().unsubscribe(str, onEventListener);
        }
    }

    public void onPageHiddenChanged(boolean z) {
        for (String findComponentByType : this.f14673b) {
            IComponent findComponentByType2 = getNodeManager().getHostPage().findComponentByType(findComponentByType);
            if (!(findComponentByType2 == null || findComponentByType2.getPresenter() == null)) {
                findComponentByType2.getPresenter().onPageHiddenChanged(z);
                List<String> childComponents = findComponentByType2.getPresenter().getChildComponents();
                if (childComponents != null) {
                    for (String findChildComponentByType : childComponents) {
                        IComponent findChildComponentByType2 = getNodeManager().getHostPage().findChildComponentByType(findChildComponentByType);
                        if (!(findChildComponentByType2 == null || findChildComponentByType2.getPresenter() == null)) {
                            findChildComponentByType2.getPresenter().onPageHiddenChanged(z);
                        }
                    }
                }
            }
        }
    }

    public void onPageStart() {
        for (String findComponentByType : this.f14673b) {
            IComponent findComponentByType2 = getNodeManager().getHostPage().findComponentByType(findComponentByType);
            if (!(findComponentByType2 == null || findComponentByType2.getPresenter() == null)) {
                findComponentByType2.getPresenter().onPageStart();
                List<String> childComponents = findComponentByType2.getPresenter().getChildComponents();
                if (childComponents != null) {
                    for (String findChildComponentByType : childComponents) {
                        IComponent findChildComponentByType2 = getNodeManager().getHostPage().findChildComponentByType(findChildComponentByType);
                        if (!(findChildComponentByType2 == null || findChildComponentByType2.getPresenter() == null)) {
                            findChildComponentByType2.getPresenter().onPageStart();
                        }
                    }
                }
            }
        }
    }

    public void onPageResume() {
        for (String findComponentByType : this.f14673b) {
            IComponent findComponentByType2 = getNodeManager().getHostPage().findComponentByType(findComponentByType);
            if (!(findComponentByType2 == null || findComponentByType2.getPresenter() == null)) {
                findComponentByType2.getPresenter().onPageResume();
                List<String> childComponents = findComponentByType2.getPresenter().getChildComponents();
                if (childComponents != null) {
                    for (String findChildComponentByType : childComponents) {
                        IComponent findChildComponentByType2 = getNodeManager().getHostPage().findChildComponentByType(findChildComponentByType);
                        if (!(findChildComponentByType2 == null || findChildComponentByType2.getPresenter() == null)) {
                            findChildComponentByType2.getPresenter().onPageResume();
                        }
                    }
                }
            }
        }
    }

    public void onPagePause() {
        for (String findComponentByType : this.f14673b) {
            IComponent findComponentByType2 = getNodeManager().getHostPage().findComponentByType(findComponentByType);
            if (!(findComponentByType2 == null || findComponentByType2.getPresenter() == null)) {
                findComponentByType2.getPresenter().onPagePause();
                List<String> childComponents = findComponentByType2.getPresenter().getChildComponents();
                if (childComponents != null) {
                    for (String findChildComponentByType : childComponents) {
                        IComponent findChildComponentByType2 = getNodeManager().getHostPage().findChildComponentByType(findChildComponentByType);
                        if (!(findChildComponentByType2 == null || findChildComponentByType2.getPresenter() == null)) {
                            findChildComponentByType2.getPresenter().onPagePause();
                        }
                    }
                }
            }
        }
    }

    public void onPageStop() {
        for (String findComponentByType : this.f14673b) {
            IComponent findComponentByType2 = getNodeManager().getHostPage().findComponentByType(findComponentByType);
            if (!(findComponentByType2 == null || findComponentByType2.getPresenter() == null)) {
                findComponentByType2.getPresenter().onPageStop();
                List<String> childComponents = findComponentByType2.getPresenter().getChildComponents();
                if (childComponents != null) {
                    for (String findChildComponentByType : childComponents) {
                        IComponent findChildComponentByType2 = getNodeManager().getHostPage().findChildComponentByType(findChildComponentByType);
                        if (!(findChildComponentByType2 == null || findChildComponentByType2.getPresenter() == null)) {
                            findChildComponentByType2.getPresenter().onPageStop();
                        }
                    }
                }
            }
        }
    }

    public void removeAll() {
        onRemove();
        for (String findComponentByType : this.f14673b) {
            IComponent findComponentByType2 = getNodeManager().getHostPage().findComponentByType(findComponentByType);
            if (!(findComponentByType2 == null || findComponentByType2.getPresenter() == null)) {
                findComponentByType2.getPresenter().onRemove();
                List<String> childComponents = findComponentByType2.getPresenter().getChildComponents();
                if (childComponents != null) {
                    for (String findChildComponentByType : childComponents) {
                        IComponent findChildComponentByType2 = getNodeManager().getHostPage().findChildComponentByType(findChildComponentByType);
                        if (!(findChildComponentByType2 == null || findChildComponentByType2.getPresenter() == null)) {
                            findChildComponentByType2.getPresenter().onRemove();
                        }
                    }
                }
            }
        }
    }

    public void unsubscribe(String str, BaseEventPublisher.OnEventListener onEventListener, Class cls) {
        if (!TextUtils.isEmpty(str) && onEventListener != null) {
            BaseEventPublisher.getPublisher().unsubscribe(str, onEventListener);
        }
    }

    public void subscribe(String str, BaseEventPublisher.OnEventListener onEventListener, Class cls) {
        if (!TextUtils.isEmpty(str) && onEventListener != null) {
            BaseEventPublisher.getPublisher().subscribe(str, onEventListener);
        }
    }

    public void startNode(String str, NodeLaunchMode nodeLaunchMode) {
        startNode(str, nodeLaunchMode, (Bundle) null);
    }

    public DataSender getComponentSender(String str, String str2) {
        if (getNodeManager() == null || getNodeManager().getHostPage() == null) {
            String str3 = this.f14672a;
            SystemUtils.log(6, str3, "getNodeManager is null or getHostPage is null, componentType =" + str + "senderName = " + str2, (Throwable) null, "com.didi.component.never.core.node.NodePresenterImpl", 305);
            return null;
        }
        if (getNodeManager().getHostPage().findComponentByType(str) == null) {
            String str4 = this.f14672a;
            SystemUtils.log(6, str4, "findComponentByType is null,componentType =" + str + "senderName = " + str2, (Throwable) null, "com.didi.component.never.core.node.NodePresenterImpl", 310);
        }
        if (getNodeManager().getHostPage().findComponentByType(str) != null) {
            ComponentPresenter presenter = getNodeManager().getHostPage().findComponentByType(str).getPresenter();
            if (presenter == null) {
                String str5 = this.f14672a;
                SystemUtils.log(6, str5, "iPresenterInterface is null,componentType =" + str + "senderName = " + str2, (Throwable) null, "com.didi.component.never.core.node.NodePresenterImpl", 315);
            }
            if (presenter != null && (presenter instanceof ComponentPresenterImpl)) {
                return ((ComponentPresenterImpl) presenter).getSender(str2);
            }
        }
        return null;
    }

    public DataSender getDataSender(String str, String str2) {
        return getComponentSender(str, str2);
    }

    public Bundle getBundles() {
        return this.bundle;
    }

    public void setBundles(Bundle bundle2) {
        this.bundle = bundle2;
    }

    public void changeLayoutParams(String str, ViewGroup.LayoutParams layoutParams) {
        getNodeManager().changeLayoutParams(str, layoutParams);
    }

    public void setContainer(String str) {
        Class<? extends ContainerComponent> containerComponentClass = FrameworkRegister.getContainerComponentClass(str);
        if (containerComponentClass != null) {
            this.f14675d = (ContainerComponent) getNodeManager().getHostPage().inflateComponent(containerComponentClass);
        }
    }

    public ContainerComponent getContainer() {
        return this.f14675d;
    }

    public IComponent findComponent(String str) {
        if (getNodeManager().getHostPage() == null || getNodeManager().getHostPage().getInflatedComponents() == null) {
            return null;
        }
        return getNodeManager().getHostPage().getInflatedComponents().get(str);
    }
}
