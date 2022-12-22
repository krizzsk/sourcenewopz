package com.didi.component.never.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.didi.component.never.core.IView;
import com.didi.component.never.core.IViewContainer;
import com.didi.component.never.core.annotation.AnnotationUtil;
import com.didi.component.never.core.callback.DataTransfer;
import com.didi.component.never.core.data.NodeStatus;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.component.never.core.node.Node;
import com.didi.component.never.core.node.NodeLaunchMode;
import com.didi.component.never.core.sender.DataSender;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class ComponentPresenterImpl<V extends IView> implements ComponentPresenter<V>, DataTransfer {

    /* renamed from: a */
    private final String f14645a = getClass().getName();

    /* renamed from: b */
    private final List<String> f14646b = new CopyOnWriteArrayList();

    /* renamed from: c */
    private Map<String, DataSender> f14647c = new HashMap();
    protected ComponentParams componentParams;
    /* access modifiers changed from: protected */
    public Context mContext;
    protected Node mParent;
    protected boolean mRemoved = false;
    /* access modifiers changed from: protected */
    public V mView;

    public Bundle dataInfo(NodeStatus nodeStatus) {
        return null;
    }

    public Map<String, Object> getData(int i, int i2) {
        return null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onNodeChanged(Node node) {
    }

    public synchronized void addSender(DataSender dataSender) {
        for (String next : m10421a(new ArrayList(), dataSender.getClass())) {
            String str = this.f14645a;
            SystemUtils.log(3, str, "now addSender,senderName = " + next + ", which belongs to :" + getClass().getSimpleName(), (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 50);
            this.f14647c.put(next, dataSender);
        }
    }

    public synchronized void removeSender(DataSender dataSender) {
        if (dataSender != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (Map.Entry next : this.f14647c.entrySet()) {
                if (!(next.getKey() == null || next.getValue() == null || !((DataSender) next.getValue()).equals(dataSender))) {
                    arrayList.add(next.getKey());
                }
            }
            for (String str : arrayList) {
                String str2 = this.f14645a;
                SystemUtils.log(6, str2, "now removed Sender,senderName = " + str + ", which belongs to :" + getClass().getSimpleName(), (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 66);
                this.f14647c.remove(str);
            }
        }
    }

    public synchronized void removeSender(String str) {
        this.f14647c.remove(str);
    }

    /* renamed from: a */
    private List<String> m10421a(List<String> list, Class cls) {
        for (Class cls2 : cls.getInterfaces()) {
            if (DataSender.class.isAssignableFrom(cls2)) {
                String senderName = AnnotationUtil.getSenderName(cls2);
                if (!TextUtils.isEmpty(senderName)) {
                    list.add(senderName);
                }
            }
        }
        if (cls.getSuperclass() != null) {
            m10421a(list, cls.getSuperclass());
        }
        return list;
    }

    public DataSender getSender(String str) {
        DataSender dataSender = this.f14647c.get(str);
        if (dataSender == null) {
            String str2 = this.f14645a;
            SystemUtils.log(3, str2, "sender is null. sender may not init, which senderName is " + str, (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 93);
        }
        return dataSender;
    }

    public ComponentPresenterImpl(ComponentParams componentParams2) {
        if (componentParams2 != null) {
            if (componentParams2.getActivity() != null) {
                this.mContext = componentParams2.getActivity();
            }
            this.componentParams = componentParams2;
        }
    }

    public List<String> getChildComponents() {
        return this.f14646b;
    }

    public void addChildComponent(String str) {
        this.f14646b.add(str);
    }

    public void removeChildComponent(String str) {
        this.f14646b.remove(str);
    }

    public void setNodeParent(Node node) {
        this.mParent = node;
    }

    public Node getNodeParent() {
        return this.mParent;
    }

    public void startNode(String str, NodeLaunchMode nodeLaunchMode) {
        startNode(str, nodeLaunchMode, (Bundle) null);
    }

    public void startNode(String str, NodeLaunchMode nodeLaunchMode, Bundle bundle) {
        Node node = this.mParent;
        if (node != null && node.getPresenter() != null) {
            this.mParent.getPresenter().startNode(str, nodeLaunchMode, bundle);
        }
    }

    public void goBack() {
        Node node = this.mParent;
        if (node != null && node.getPresenter() != null) {
            this.mParent.getPresenter().goBack();
        }
    }

    public void goBack(Bundle bundle) {
        Node node = this.mParent;
        if (node != null && node.getPresenter() != null) {
            this.mParent.getPresenter().goBack(bundle);
        }
    }

    public void goBackRoot() {
        Node node = this.mParent;
        if (node != null && node.getPresenter() != null) {
            this.mParent.getPresenter().goBackRoot();
        }
    }

    public void goBackRoot(Bundle bundle) {
        Node node = this.mParent;
        if (node != null && node.getPresenter() != null) {
            this.mParent.getPresenter().goBackRoot(bundle);
        }
    }

    public void doPublish(String str) {
        doPublish(str, (Object) null);
    }

    public void doPublish(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && !this.mRemoved) {
            BaseEventPublisher.getPublisher().publish(str, obj);
        }
    }

    public void subscribe(String str, BaseEventPublisher.OnEventListener onEventListener) {
        if (!TextUtils.isEmpty(str) && onEventListener != null && !this.mRemoved) {
            BaseEventPublisher.getPublisher().subscribe(str, onEventListener);
        }
    }

    public void subscribe(String str, BaseEventPublisher.OnEventListener onEventListener, Class<?> cls) {
        if (!TextUtils.isEmpty(str) && onEventListener != null && !this.mRemoved) {
            if (cls == null) {
                BaseEventPublisher.getPublisher().subscribe(str, onEventListener);
            } else {
                BaseEventPublisher.getPublisher().subscribe(str, onEventListener, cls);
            }
        }
    }

    public void unsubscribe(String str, BaseEventPublisher.OnEventListener onEventListener) {
        if (!TextUtils.isEmpty(str) && onEventListener != null) {
            BaseEventPublisher.getPublisher().unsubscribe(str, onEventListener);
        }
    }

    public void unsubscribe(String str, BaseEventPublisher.OnEventListener onEventListener, Class<?> cls) {
        if (!TextUtils.isEmpty(str) && onEventListener != null) {
            if (cls == null) {
                BaseEventPublisher.getPublisher().unsubscribe(str, onEventListener);
            } else {
                BaseEventPublisher.getPublisher().unsubscribe(str, onEventListener, cls);
            }
        }
    }

    public void setIView(V v) {
        this.mView = v;
    }

    public void onAdd(Bundle bundle) {
        SystemUtils.log(6, this.f14645a, "onAdd: ", (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 297);
    }

    public void onPageHiddenChanged(boolean z) {
        SystemUtils.log(6, this.f14645a, "onPageHiddenChanged: ", (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 302);
    }

    public void onPageStart() {
        SystemUtils.log(6, this.f14645a, "onPageStart: ", (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 307);
    }

    public void onPageResume() {
        SystemUtils.log(6, this.f14645a, "onPageResume: ", (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 312);
    }

    public void onPagePause() {
        SystemUtils.log(6, this.f14645a, "onPagePause: ", (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 317);
    }

    public void onPageStop() {
        SystemUtils.log(6, this.f14645a, "onPageStop: ", (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 322);
    }

    public final void dispatchRemove() {
        onRemove();
        this.mRemoved = true;
    }

    public void onRemove() {
        IViewContainer.IComponentCreator viewCreator;
        SystemUtils.log(6, this.f14645a, "onRemove: ", (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 333);
        if (getNodeParent() != null && getNodeParent().getNodeManager().getHostPage() != null && (viewCreator = getNodeParent().getNodeManager().getHostPage().getViewCreator()) != null) {
            for (String removeComponent : this.f14646b) {
                viewCreator.removeComponent((ComponentPresenter) this, removeComponent);
            }
        }
    }

    public DataSender getDataSender(String str, String str2) {
        String str3 = this.f14645a;
        SystemUtils.log(3, str3, "now you trying to get DataSender ,which componentType =" + str + "senderName = " + str2, (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 347);
        if (getNodeParent() == null) {
            String str4 = this.f14645a;
            SystemUtils.log(6, str4, "getNodeParent is null,componentType =" + str + "senderName = " + str2, (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 349);
        }
        if (getNodeParent().getPresenter() == null) {
            String str5 = this.f14645a;
            SystemUtils.log(6, str5, "getNodeParent().getPresenter is null,componentType =" + str + "senderName = " + str2, (Throwable) null, "com.didi.component.never.core.ComponentPresenterImpl", 352);
        }
        if (getNodeParent() == null || getNodeParent().getPresenter() == null) {
            return null;
        }
        return getNodeParent().getPresenter().getDataSender(str, str2);
    }

    public void changeLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.componentParams != null && getNodeParent() != null && getNodeParent().getPresenter() != null) {
            getNodeParent().getPresenter().changeLayoutParams(this.componentParams.type, layoutParams);
        }
    }

    public IComponent findComponent(String str) {
        if (getNodeParent() == null || getNodeParent().getNodeManager().getHostPage() == null || getNodeParent().getNodeManager().getHostPage().getInflatedComponents() == null) {
            return null;
        }
        return getNodeParent().getNodeManager().getHostPage().getInflatedComponents().get(str);
    }
}
