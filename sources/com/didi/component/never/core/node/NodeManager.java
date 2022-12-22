package com.didi.component.never.core.node;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.IComponent;
import com.didi.component.never.core.annotation.AnnotationUtil;
import com.didi.component.never.core.node.NodeStack;
import com.didi.component.never.core.page.Page;
import com.didi.component.never.core.util.FrameworkRegister;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NodeManager {

    /* renamed from: c */
    private static final String f14663c = NodeManager.class.getSimpleName();

    /* renamed from: a */
    Node f14664a;

    /* renamed from: b */
    Page f14665b;

    /* renamed from: d */
    private NodeStack f14666d = new NodeStack();

    /* renamed from: e */
    private Node f14667e;

    /* renamed from: f */
    private final Context f14668f;

    /* renamed from: g */
    private OnNodeChangedListener f14669g;

    /* renamed from: h */
    private final List<IComponent> f14670h = new ArrayList();

    /* renamed from: i */
    private final List<IComponent> f14671i = new ArrayList();

    public interface OnNodeChangedListener {
        void nodeChanged(Node node);
    }

    public NodeManager(Page page, Context context) {
        this.f14665b = page;
        this.f14668f = context;
    }

    public Page getHostPage() {
        return this.f14665b;
    }

    public Node getActiveNode() {
        return this.f14664a;
    }

    public void startNewNode(Node node, Bundle bundle, NodeLaunchMode nodeLaunchMode, boolean z) {
        if (nodeLaunchMode == null) {
            nodeLaunchMode = NodeLaunchMode.PUSH;
        }
        if (C63032.$SwitchMap$com$didi$component$never$core$node$NodeLaunchMode[nodeLaunchMode.ordinal()] != 1) {
            m10446a(node, bundle, z);
        } else {
            m10450b(node, bundle, z);
        }
    }

    /* renamed from: com.didi.component.never.core.node.NodeManager$2 */
    static /* synthetic */ class C63032 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$component$never$core$node$NodeLaunchMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.component.never.core.node.NodeLaunchMode[] r0 = com.didi.component.never.core.node.NodeLaunchMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$component$never$core$node$NodeLaunchMode = r0
                com.didi.component.never.core.node.NodeLaunchMode r1 = com.didi.component.never.core.node.NodeLaunchMode.SWITCH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$component$never$core$node$NodeLaunchMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.component.never.core.node.NodeLaunchMode r1 = com.didi.component.never.core.node.NodeLaunchMode.PUSH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.never.core.node.NodeManager.C63032.<clinit>():void");
        }
    }

    public void startNewNode(Node node, Bundle bundle, NodeLaunchMode nodeLaunchMode) {
        startNewNode(node, bundle, nodeLaunchMode, false);
    }

    public void startNode(Node node, NodeLaunchMode nodeLaunchMode, Bundle bundle) {
        startNewNode(node, bundle, nodeLaunchMode);
        if (node.getPresenter() != null) {
            node.getPresenter().setBundles(bundle);
        }
    }

    public void startNode(String str, NodeLaunchMode nodeLaunchMode, Bundle bundle, boolean z) {
        Node findNodeById = findNodeById(str, bundle);
        startNewNode(findNodeById, bundle, nodeLaunchMode, z);
        if (findNodeById.getPresenter() != null) {
            findNodeById.getPresenter().setBundles(bundle);
        }
    }

    public void startNode(String str, NodeLaunchMode nodeLaunchMode, Bundle bundle) {
        startNode(findNodeById(str, bundle), nodeLaunchMode, bundle);
    }

    public Node findNodeById(String str, Bundle bundle) {
        Class<? extends Node> node = FrameworkRegister.getNode(str);
        if (node != null) {
            try {
                return (Node) node.getConstructor(new Class[]{NodeManager.class, Bundle.class}).newInstance(new Object[]{this, bundle});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        } else {
            throw new NullPointerException("nodeId named :" + str + " is null");
        }
        return null;
    }

    public void startNode(Node node, NodeLaunchMode nodeLaunchMode) {
        startNode(node, nodeLaunchMode, (Bundle) null);
    }

    public void goBack(Bundle bundle) {
        if (canGoBack()) {
            m10452c(bundle);
        }
    }

    public boolean canGoBack() {
        NodeStack nodeStack = this.f14666d;
        return nodeStack != null && nodeStack.size() > 1;
    }

    /* renamed from: a */
    private void m10444a(Node node) {
        if (node != null) {
            for (String next : node.getPresenter().getComponentList()) {
                IComponent findComponentByType = getHostPage().findComponentByType(next);
                if (findComponentByType == null || findComponentByType.getPresenter() == null) {
                    throw new NullPointerException("component or component's presenter is null. component's id is :" + next);
                }
                findComponentByType.getPresenter().setNodeParent(node);
                List<String> childComponents = findComponentByType.getPresenter().getChildComponents();
                if (childComponents != null) {
                    for (String findChildComponentByType : childComponents) {
                        IComponent findChildComponentByType2 = getHostPage().findChildComponentByType(findChildComponentByType);
                        if (!(findChildComponentByType2 == null || findChildComponentByType2.getPresenter() == null)) {
                            findChildComponentByType2.getPresenter().setNodeParent(node);
                        }
                    }
                }
            }
        }
    }

    public void componentSetParent(IComponent iComponent) {
        if (iComponent != null && iComponent.getPresenter() != null) {
            if (this.f14664a != null) {
                iComponent.getPresenter().setNodeParent(this.f14664a);
            } else if (this.f14667e != null) {
                iComponent.getPresenter().setNodeParent(this.f14667e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x015a, code lost:
        return r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.os.Bundle m10440a(com.didi.component.never.core.node.NodeLaunchMode r11, com.didi.component.never.core.node.Node r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x015b }
            r0.<init>()     // Catch:{ all -> 0x015b }
            if (r12 != 0) goto L_0x000a
            monitor-exit(r10)
            return r0
        L_0x000a:
            com.didi.component.never.core.data.NodeStatus r1 = new com.didi.component.never.core.data.NodeStatus     // Catch:{ all -> 0x015b }
            r1.<init>()     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.node.Node r2 = r10.f14667e     // Catch:{ all -> 0x015b }
            if (r2 != 0) goto L_0x0016
            java.lang.String r2 = ""
            goto L_0x001c
        L_0x0016:
            com.didi.component.never.core.node.Node r2 = r10.f14667e     // Catch:{ all -> 0x015b }
            java.lang.String r2 = r2.getId()     // Catch:{ all -> 0x015b }
        L_0x001c:
            r1.from = r2     // Catch:{ all -> 0x015b }
            java.lang.String r2 = r12.getId()     // Catch:{ all -> 0x015b }
            r1.f14653to = r2     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.node.NodePresenter r2 = r12.getPresenter()     // Catch:{ all -> 0x015b }
            java.util.List r2 = r2.getComponentList()     // Catch:{ all -> 0x015b }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x015b }
            r3.<init>()     // Catch:{ all -> 0x015b }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x015b }
            r4.<init>()     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.node.NodePresenter r5 = r12.getPresenter()     // Catch:{ all -> 0x015b }
            java.util.List r5 = r5.getComponentList()     // Catch:{ all -> 0x015b }
            java.util.Map r5 = r10.m10441a((java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x015b }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.page.Page r7 = r10.getHostPage()     // Catch:{ all -> 0x015b }
            java.util.Map r7 = r7.getActiveComponents()     // Catch:{ all -> 0x015b }
            r6.<init>(r7)     // Catch:{ all -> 0x015b }
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x015b }
            if (r7 != 0) goto L_0x00cb
            java.util.Set r6 = r6.keySet()     // Catch:{ all -> 0x015b }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x015b }
        L_0x005d:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x015b }
            if (r7 == 0) goto L_0x00cb
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x015b }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.page.Page r8 = r10.getHostPage()     // Catch:{ all -> 0x015b }
            java.util.Map r8 = r8.getInflatedComponents()     // Catch:{ all -> 0x015b }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.IComponent r8 = (com.didi.component.never.core.IComponent) r8     // Catch:{ all -> 0x015b }
            if (r8 == 0) goto L_0x008a
            com.didi.component.never.core.ComponentPresenter r9 = r8.getPresenter()     // Catch:{ all -> 0x015b }
            if (r9 == 0) goto L_0x008a
            com.didi.component.never.core.ComponentPresenter r9 = r8.getPresenter()     // Catch:{ all -> 0x015b }
            android.os.Bundle r9 = r9.dataInfo(r1)     // Catch:{ all -> 0x015b }
            r0.putBundle(r7, r9)     // Catch:{ all -> 0x015b }
        L_0x008a:
            boolean r9 = r2.contains(r7)     // Catch:{ all -> 0x015b }
            if (r9 != 0) goto L_0x00a5
            com.didi.component.never.core.node.NodeLaunchMode r7 = com.didi.component.never.core.node.NodeLaunchMode.PUSH     // Catch:{ all -> 0x015b }
            if (r11 != r7) goto L_0x0098
            r3.add(r8)     // Catch:{ all -> 0x015b }
            goto L_0x005d
        L_0x0098:
            com.didi.component.never.core.page.Page r7 = r10.getHostPage()     // Catch:{ all -> 0x015b }
            r7.removeComponent(r8)     // Catch:{ all -> 0x015b }
            java.util.List<com.didi.component.never.core.IComponent> r7 = r10.f14671i     // Catch:{ all -> 0x015b }
            r7.add(r8)     // Catch:{ all -> 0x015b }
            goto L_0x005d
        L_0x00a5:
            java.lang.Class r9 = r8.getClass()     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.ComponentParams r9 = r10.getComponentParams(r12, r9)     // Catch:{ all -> 0x015b }
            boolean r9 = r8.recreateWhenNodeChange(r9)     // Catch:{ all -> 0x015b }
            if (r9 == 0) goto L_0x00c0
            com.didi.component.never.core.page.Page r7 = r10.getHostPage()     // Catch:{ all -> 0x015b }
            r7.removeComponent(r8)     // Catch:{ all -> 0x015b }
            java.util.List<com.didi.component.never.core.IComponent> r7 = r10.f14671i     // Catch:{ all -> 0x015b }
            r7.add(r8)     // Catch:{ all -> 0x015b }
            goto L_0x005d
        L_0x00c0:
            r5.remove(r7)     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.node.NodeLaunchMode r7 = com.didi.component.never.core.node.NodeLaunchMode.REMOVED     // Catch:{ all -> 0x015b }
            if (r11 != r7) goto L_0x005d
            r4.add(r8)     // Catch:{ all -> 0x015b }
            goto L_0x005d
        L_0x00cb:
            com.didi.component.never.core.node.Node r11 = r10.f14667e     // Catch:{ all -> 0x015b }
            if (r11 == 0) goto L_0x00e6
            com.didi.component.never.core.node.Node r11 = r10.f14667e     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.node.NodePresenter r11 = r11.getPresenter()     // Catch:{ all -> 0x015b }
            if (r11 == 0) goto L_0x00e6
            com.didi.component.never.core.node.Node r11 = r10.f14667e     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.node.NodePresenter r11 = r11.getPresenter()     // Catch:{ all -> 0x015b }
            android.os.Bundle r11 = r11.dataInfo(r1)     // Catch:{ all -> 0x015b }
            java.lang.String r1 = "nodeBundleKey"
            r0.putBundle(r1, r11)     // Catch:{ all -> 0x015b }
        L_0x00e6:
            r10.f14667e = r12     // Catch:{ all -> 0x015b }
            java.util.Collection r11 = r5.values()     // Catch:{ all -> 0x015b }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x015b }
        L_0x00f0:
            boolean r1 = r11.hasNext()     // Catch:{ all -> 0x015b }
            if (r1 == 0) goto L_0x010a
            java.lang.Object r1 = r11.next()     // Catch:{ all -> 0x015b }
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.page.Page r2 = r10.getHostPage()     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.IComponent r1 = r2.inflateComponent(r1)     // Catch:{ all -> 0x015b }
            java.util.List<com.didi.component.never.core.IComponent> r2 = r10.f14670h     // Catch:{ all -> 0x015b }
            r2.add(r1)     // Catch:{ all -> 0x015b }
            goto L_0x00f0
        L_0x010a:
            java.util.Iterator r11 = r3.iterator()     // Catch:{ all -> 0x015b }
        L_0x010e:
            boolean r1 = r11.hasNext()     // Catch:{ all -> 0x015b }
            if (r1 == 0) goto L_0x0122
            java.lang.Object r1 = r11.next()     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.IComponent r1 = (com.didi.component.never.core.IComponent) r1     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.page.Page r2 = r10.getHostPage()     // Catch:{ all -> 0x015b }
            r2.invisibleComponent(r1)     // Catch:{ all -> 0x015b }
            goto L_0x010e
        L_0x0122:
            java.util.Iterator r11 = r4.iterator()     // Catch:{ all -> 0x015b }
        L_0x0126:
            boolean r1 = r11.hasNext()     // Catch:{ all -> 0x015b }
            if (r1 == 0) goto L_0x013a
            java.lang.Object r1 = r11.next()     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.IComponent r1 = (com.didi.component.never.core.IComponent) r1     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.page.Page r2 = r10.getHostPage()     // Catch:{ all -> 0x015b }
            r2.visibleComponent(r1)     // Catch:{ all -> 0x015b }
            goto L_0x0126
        L_0x013a:
            com.didi.component.never.core.node.NodePresenter r11 = r12.getPresenter()     // Catch:{ all -> 0x015b }
            if (r11 == 0) goto L_0x0159
            com.didi.component.never.core.node.NodePresenter r11 = r12.getPresenter()     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.container.ContainerComponent r11 = r11.getContainer()     // Catch:{ all -> 0x015b }
            if (r11 == 0) goto L_0x0159
            com.didi.component.never.core.page.Page r11 = r10.getHostPage()     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.node.NodePresenter r12 = r12.getPresenter()     // Catch:{ all -> 0x015b }
            com.didi.component.never.core.container.ContainerComponent r12 = r12.getContainer()     // Catch:{ all -> 0x015b }
            r11.layoutComponents(r12)     // Catch:{ all -> 0x015b }
        L_0x0159:
            monitor-exit(r10)
            return r0
        L_0x015b:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.never.core.node.NodeManager.m10440a(com.didi.component.never.core.node.NodeLaunchMode, com.didi.component.never.core.node.Node):android.os.Bundle");
    }

    /* renamed from: a */
    private void m10443a(Bundle bundle) {
        m10448b(bundle);
        m10442a();
    }

    /* renamed from: b */
    private void m10448b(Bundle bundle) {
        if (!this.f14670h.isEmpty()) {
            for (IComponent next : this.f14670h) {
                if (!(next == null || next.getPresenter() == null)) {
                    next.getPresenter().onAdd(bundle);
                }
            }
        }
        this.f14670h.clear();
    }

    /* renamed from: a */
    private void m10442a() {
        if (!this.f14671i.isEmpty()) {
            for (IComponent next : this.f14671i) {
                if (!(next == null || next.getPresenter() == null)) {
                    next.getPresenter().onRemove();
                }
            }
        }
        this.f14671i.clear();
    }

    /* renamed from: b */
    private void m10449b(Node node) {
        this.f14664a = node;
        OnNodeChangedListener onNodeChangedListener = this.f14669g;
        if (onNodeChangedListener != null) {
            onNodeChangedListener.nodeChanged(node);
        }
    }

    /* renamed from: a */
    private Map<String, Class<? extends IComponent>> m10441a(List<String> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String next : list) {
            Class<? extends IComponent> standardComponentClass = FrameworkRegister.getStandardComponentClass(next);
            if (standardComponentClass != null) {
                linkedHashMap.put(next, standardComponentClass);
            }
        }
        return linkedHashMap;
    }

    public Node getInflatedNode() {
        return this.f14667e;
    }

    public boolean isEmptyStack() {
        NodeStack nodeStack = this.f14666d;
        return nodeStack == null || nodeStack.isEmpty();
    }

    public Context getContext() {
        return this.f14668f;
    }

    public ComponentParams getComponentParams(Node node, Class<? extends IComponent> cls) {
        if (node == null) {
            node = this.f14664a;
        }
        return getHostPage().getComponentParams(AnnotationUtil.getNodeId(node.getClass()), AnnotationUtil.getComponentName(cls));
    }

    public void changeLayoutParams(String str, ViewGroup.LayoutParams layoutParams) {
        getHostPage().changeLayoutParams(str, layoutParams);
    }

    /* renamed from: a */
    private void m10445a(Node node, Bundle bundle) {
        if (node != null && node.getPresenter() != null) {
            node.getPresenter().onAdd(bundle);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10453c(Node node) {
        if (node != null && node.getPresenter() != null) {
            node.getPresenter().onRemove();
        }
    }

    /* renamed from: d */
    private void m10454d(Node node) {
        if (node != null && node.getPresenter() != null) {
            node.getPresenter().onPageStart();
            node.getPresenter().onPageResume();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10455e(Node node) {
        if (node != null && node.getPresenter() != null) {
            node.getPresenter().onPagePause();
            node.getPresenter().onPageStop();
        }
    }

    /* renamed from: a */
    private void m10446a(Node node, Bundle bundle, boolean z) {
        Node node2 = this.f14664a;
        if (node2 != null) {
            m10455e(node2);
        }
        if (node != null) {
            Bundle a = m10440a(NodeLaunchMode.PUSH, node);
            if (bundle != null) {
                a.putAll(bundle);
            }
            this.f14666d.push(node);
            m10444a(node);
            m10443a(a);
            m10445a(node, a);
            if (!z) {
                m10454d(node);
            }
            m10449b(node);
        }
    }

    /* renamed from: c */
    private void m10452c(Bundle bundle) {
        Node node = this.f14664a;
        if (node != null) {
            m10455e(node);
            m10453c(this.f14664a);
        }
        if (this.f14666d.size() > 1) {
            this.f14666d.pop();
            Node node2 = (Node) this.f14666d.peek();
            if (node2 != null) {
                Bundle a = m10440a(NodeLaunchMode.REMOVED, node2);
                if (bundle != null) {
                    a.putAll(bundle);
                }
                m10444a(node2);
                m10443a(a);
                m10454d(node2);
                m10449b(node2);
                if (node2.getPresenter() != null) {
                    node2.getPresenter().setBundles(a);
                }
            }
        }
    }

    /* renamed from: b */
    private void m10450b(Node node, Bundle bundle, boolean z) {
        if (this.f14664a != null && this.f14666d.size() > 0) {
            m10455e(this.f14664a);
            m10453c(this.f14664a);
            this.f14666d.pop();
        }
        if (node != null) {
            Bundle a = m10440a(NodeLaunchMode.SWITCH, node);
            if (bundle != null) {
                a.putAll(bundle);
            }
            m10444a(node);
            m10443a(a);
            this.f14666d.push(node);
            m10445a(node, a);
            if (!z) {
                m10454d(node);
            }
            m10449b(node);
        }
    }

    public void backToRoot(Bundle bundle) {
        Node root = this.f14666d.root(new NodeStack.NodeStackListener() {
            public void onNodePop(Node node) {
                NodeManager.this.m10455e(node);
                NodeManager.this.m10453c(node);
            }
        });
        Bundle a = m10440a(NodeLaunchMode.REMOVED, root);
        if (bundle != null) {
            a.putAll(bundle);
        }
        m10444a(root);
        m10443a(a);
        m10454d(root);
        m10449b(root);
        if (root.getPresenter() != null) {
            root.getPresenter().setBundles(a);
        }
    }

    public void setOnNodeChangedListener(OnNodeChangedListener onNodeChangedListener) {
        this.f14669g = onNodeChangedListener;
    }

    public void release() {
        nodeStackRemove();
        this.f14666d = null;
        this.f14667e = null;
        this.f14664a = null;
        this.f14665b = null;
        this.f14669g = null;
    }

    public void nodeStackRemove() {
        for (int size = this.f14666d.size(); size > 0; size--) {
            Node pop = this.f14666d.pop();
            if (pop != null) {
                pop.getPresenter().onRemove();
            }
        }
    }
}
