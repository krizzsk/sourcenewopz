package com.didi.soda.customer.widget.tabbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001HB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020 H\u0002J\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u001cJ\b\u0010'\u001a\u00020 H\u0007J\u001e\u0010(\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0002J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u001eH\u0002J\u0010\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u00020\u001eH\u0002J\u0010\u00102\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J$\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u00010\u001e2\u0006\u00107\u001a\u00020\u001e2\b\b\u0002\u00108\u001a\u00020\u000eH\u0002J\u001a\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020\b2\b\b\u0002\u00108\u001a\u00020\u000eH\u0002J\u001a\u0010;\u001a\u00020#2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000e0=J\u0006\u0010>\u001a\u00020#J\u0010\u0010?\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0002J\u0018\u0010@\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u00108\u001a\u00020\u000eJ\u0010\u0010A\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u0002042\u0006\u0010D\u001a\u00020\bH\u0002J\b\u0010E\u001a\u00020 H\u0002J\u0014\u0010F\u001a\u00020 2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0GR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\t\u001a\u00060\nR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarController;", "", "()V", "componentCallback", "Lcom/didi/soda/customer/widget/tabbar/TabComponentCallback;", "context", "Landroid/content/Context;", "curSelected", "Lcom/didi/soda/customer/widget/tabbar/TabBarItemModel;", "event", "Lcom/didi/soda/customer/widget/tabbar/TabBarController$Event;", "getEvent", "()Lcom/didi/soda/customer/widget/tabbar/TabBarController$Event;", "isShowed", "", "onTabBarChangedListener", "Lcom/didi/soda/customer/widget/tabbar/OnTabChangedListener;", "getOnTabBarChangedListener", "()Lcom/didi/soda/customer/widget/tabbar/OnTabChangedListener;", "setOnTabBarChangedListener", "(Lcom/didi/soda/customer/widget/tabbar/OnTabChangedListener;)V", "pageCallback", "Lcom/didi/soda/customer/widget/tabbar/PageCallback;", "tabBar", "Landroid/widget/LinearLayout;", "tabBarModels", "", "tabContentView", "Landroid/view/ViewGroup;", "toUpdateList", "Lcom/didi/soda/customer/widget/tabbar/TabBarItem;", "addToTab", "", "tabBarItemModel", "index", "", "adjustTabOrder", "anchor", "parentView", "apply", "attach", "checkControllerIsInit", "checkRepeatAdd", "toAddItem", "componentAddToPage", "controller", "Lcom/didi/soda/customer/widget/tabbar/ComponentController;", "componentRemoveFromPage", "createTabBarItemModel", "tabBarItem", "createTabContainerView", "createTabItemView", "Lcom/didi/soda/customer/widget/tabbar/TabBarItemView;", "dispatchTabChangedEvent", "pre", "next", "fromUser", "doTabChangeEvent", "waitSelected", "findTabIndex", "predicate", "Lkotlin/Function1;", "getSelectedTabIndex", "removeFromTab", "selectTab", "setupTabContent", "setupTabItemView", "tabItemView", "model", "updateSelectState", "updateTabBarItem", "", "Event", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabBarController.kt */
public final class TabBarController {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<C13883a> f42191a = new ArrayList();

    /* renamed from: b */
    private final List<TabBarItem> f42192b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C13883a f42193c;

    /* renamed from: d */
    private boolean f42194d;

    /* renamed from: e */
    private ViewGroup f42195e;

    /* renamed from: f */
    private LinearLayout f42196f;

    /* renamed from: g */
    private PageCallback f42197g;

    /* renamed from: h */
    private Context f42198h;

    /* renamed from: i */
    private OnTabChangedListener f42199i;

    /* renamed from: j */
    private final Event f42200j = new Event(this);

    /* renamed from: k */
    private TabComponentCallback f42201k;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TabBarController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TabBarOp.values().length];
            iArr[TabBarOp.ADD.ordinal()] = 1;
            iArr[TabBarOp.UPDATE_ALL.ordinal()] = 2;
            iArr[TabBarOp.UPDATE_TAB.ordinal()] = 3;
            iArr[TabBarOp.NONE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final OnTabChangedListener getOnTabBarChangedListener() {
        return this.f42199i;
    }

    public final void setOnTabBarChangedListener(OnTabChangedListener onTabChangedListener) {
        this.f42199i = onTabChangedListener;
    }

    public final Event getEvent() {
        return this.f42200j;
    }

    public final void attach(Context context, PageCallback pageCallback, TabComponentCallback tabComponentCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageCallback, "pageCallback");
        Intrinsics.checkNotNullParameter(tabComponentCallback, "componentCallback");
        this.f42198h = context;
        this.f42201k = tabComponentCallback;
        this.f42197g = pageCallback;
    }

    public final void anchor(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        if (this.f42194d) {
            LogUtil.m29106w("TabBar", "TabBarController, Error, 多次调用 show() 方法！！！");
            return;
        }
        this.f42194d = true;
        Context context = this.f42198h;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        View inflate = View.inflate(context, R.layout.customer_widget_tabbar_layout, viewGroup);
        this.f42196f = (LinearLayout) inflate.findViewById(R.id.customer_tabbar_item_layout);
        this.f42195e = (ViewGroup) inflate.findViewById(R.id.customer_tabbar_content_layout);
    }

    /* renamed from: a */
    private final void m29743a(C13883a aVar) {
        ViewGroup viewGroup;
        if (this.f42196f != null) {
            ViewGroup viewGroup2 = this.f42195e;
        }
        LinearLayout linearLayout = this.f42196f;
        if (linearLayout != null) {
            linearLayout.removeView(aVar.mo106246b());
        }
        if (!(aVar.mo106248c() == null || (viewGroup = this.f42195e) == null)) {
            viewGroup.removeView(aVar.mo106248c());
        }
        if (aVar.mo106241a().getController() != null) {
            ComponentController controller = aVar.mo106241a().getController();
            Intrinsics.checkNotNull(controller);
            m29753c(controller);
            this.f42200j.dispatchPageEventWhenRemove(controller);
            controller.internOnTabRemoveEvent();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m29739a(TabBarController tabBarController, C13883a aVar, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        tabBarController.m29744a(aVar, i);
    }

    /* renamed from: a */
    private final void m29744a(C13883a aVar, int i) {
        ViewGroup viewGroup;
        if (this.f42196f != null) {
            ViewGroup viewGroup2 = this.f42195e;
        }
        LinearLayout linearLayout = this.f42196f;
        if (linearLayout != null) {
            linearLayout.addView(aVar.mo106246b(), i);
        }
        if (aVar.mo106248c() != null && (viewGroup = this.f42195e) != null) {
            viewGroup.addView(aVar.mo106248c(), i);
        }
    }

    /* renamed from: a */
    private final void m29737a() {
        if (this.f42196f != null && this.f42195e != null) {
            Iterator it = this.f42191a.iterator();
            boolean z = false;
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                LinearLayout linearLayout = this.f42196f;
                Intrinsics.checkNotNull(linearLayout);
                if (linearLayout.indexOfChild(((C13883a) next).mo106246b()) != i) {
                    z = true;
                    break;
                }
                i = i2;
            }
            if (z) {
                LinearLayout linearLayout2 = this.f42196f;
                Intrinsics.checkNotNull(linearLayout2);
                linearLayout2.removeAllViews();
                ViewGroup viewGroup = this.f42195e;
                Intrinsics.checkNotNull(viewGroup);
                viewGroup.removeAllViews();
                for (C13883a aVar : this.f42191a) {
                    LinearLayout linearLayout3 = this.f42196f;
                    Intrinsics.checkNotNull(linearLayout3);
                    linearLayout3.addView(aVar.mo106246b());
                    if (aVar.mo106251f()) {
                        ViewGroup viewGroup2 = this.f42195e;
                        Intrinsics.checkNotNull(viewGroup2);
                        viewGroup2.addView(aVar.mo106248c());
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private final void m29750b() {
        Unit unit;
        C13883a aVar = null;
        boolean z = false;
        for (C13883a aVar2 : this.f42191a) {
            if (aVar2.mo106250e()) {
                aVar = aVar2;
            }
            if (Intrinsics.areEqual((Object) this.f42193c, (Object) aVar2)) {
                z = true;
            }
        }
        if (aVar == null) {
            aVar = z ? this.f42193c : null;
        }
        if (aVar == null) {
            unit = null;
        } else {
            if (!Intrinsics.areEqual((Object) this.f42193c, (Object) aVar)) {
                m29752b(aVar);
                m29741a(this, aVar, false, 2, (Object) null);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null && this.f42191a.size() > 0) {
            C13883a aVar3 = this.f42191a.get(0);
            m29752b(aVar3);
            m29741a(this, aVar3, false, 2, (Object) null);
        }
    }

    public final int getSelectedTabIndex() {
        C13883a aVar = this.f42193c;
        if (aVar == null) {
            return -1;
        }
        List<C13883a> list = this.f42191a;
        Intrinsics.checkNotNull(aVar);
        return list.indexOf(aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29752b(C13883a aVar) {
        if (!aVar.mo106251f()) {
            LogUtil.m29100d("TabBarController", "init it when you click it.");
            ComponentController controller = aVar.mo106241a().getController();
            if (controller != null) {
                View a = m29736a(controller);
                aVar.mo106242a(a);
                aVar.mo106247b(true);
                ViewGroup viewGroup = this.f42195e;
                if (viewGroup != null) {
                    viewGroup.addView(a);
                }
                m29751b(controller);
                this.f42200j.dispatchPageEventWhenAdd(controller);
            }
        }
    }

    /* renamed from: a */
    private final boolean m29747a(TabBarItem tabBarItem) {
        Object obj;
        Iterator it = this.f42191a.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) tabBarItem, (Object) ((C13883a) obj).mo106241a())) {
                break;
            }
        }
        if (((C13883a) obj) == null) {
            return false;
        }
        LogUtil.m29106w("TabBarController", "item = " + tabBarItem + ", 检查是否有重复添加TabBarItem！！！");
        return true;
    }

    public final void updateTabBarItem(List<TabBarItem> list) {
        Intrinsics.checkNotNullParameter(list, "toUpdateList");
        this.f42192b.addAll(list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.didi.soda.customer.widget.tabbar.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.didi.soda.customer.widget.tabbar.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.didi.soda.customer.widget.tabbar.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.didi.soda.customer.widget.tabbar.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: com.didi.soda.customer.widget.tabbar.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: com.didi.soda.customer.widget.tabbar.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: com.didi.soda.customer.widget.tabbar.a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void apply() {
        /*
            r8 = this;
            java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItem> r0 = r8.f42192b
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItem> r1 = r8.f42192b
            java.util.Collection r1 = (java.util.Collection) r1
            r0.<init>(r1)
            java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItem> r1 = r8.f42192b
            r1.clear()
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.List<com.didi.soda.customer.widget.tabbar.a> r2 = r8.f42191a
            java.util.Collection r2 = (java.util.Collection) r2
            r1.<init>(r2)
            java.util.List<com.didi.soda.customer.widget.tabbar.a> r2 = r8.f42191a
            r2.clear()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = 0
            java.util.Iterator r0 = r0.iterator()
        L_0x002c:
            boolean r3 = r0.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x00de
            java.lang.Object r3 = r0.next()
            int r5 = r2 + 1
            if (r2 >= 0) goto L_0x003e
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x003e:
            com.didi.soda.customer.widget.tabbar.TabBarItem r3 = (com.didi.soda.customer.widget.tabbar.TabBarItem) r3
            com.didi.soda.customer.widget.tabbar.TabBarOp r6 = r3.getOp()
            int[] r7 = com.didi.soda.customer.widget.tabbar.TabBarController.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r7[r6]
            r7 = 1
            if (r6 == r7) goto L_0x00c2
            r2 = 2
            if (r6 == r2) goto L_0x0086
            r2 = 3
            if (r6 == r2) goto L_0x0086
            r2 = 4
            if (r6 == r2) goto L_0x005a
            goto L_0x00d6
        L_0x005a:
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0061:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0079
            java.lang.Object r6 = r2.next()
            r7 = r6
            com.didi.soda.customer.widget.tabbar.a r7 = (com.didi.soda.customer.widget.tabbar.C13883a) r7
            com.didi.soda.customer.widget.tabbar.TabBarItem r7 = r7.mo106241a()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r3)
            if (r7 == 0) goto L_0x0061
            r4 = r6
        L_0x0079:
            com.didi.soda.customer.widget.tabbar.a r4 = (com.didi.soda.customer.widget.tabbar.C13883a) r4
            if (r4 == 0) goto L_0x00d6
            r1.remove(r4)
            java.util.List<com.didi.soda.customer.widget.tabbar.a> r2 = r8.f42191a
            r2.add(r4)
            goto L_0x00d6
        L_0x0086:
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x008d:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x00a5
            java.lang.Object r6 = r2.next()
            r7 = r6
            com.didi.soda.customer.widget.tabbar.a r7 = (com.didi.soda.customer.widget.tabbar.C13883a) r7
            com.didi.soda.customer.widget.tabbar.TabBarItem r7 = r7.mo106241a()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r3)
            if (r7 == 0) goto L_0x008d
            r4 = r6
        L_0x00a5:
            com.didi.soda.customer.widget.tabbar.a r4 = (com.didi.soda.customer.widget.tabbar.C13883a) r4
            if (r4 == 0) goto L_0x00b9
            r1.remove(r4)
            com.didi.soda.customer.widget.tabbar.TabBarOp r2 = r3.getOp()
            r4.mo106243a((com.didi.soda.customer.widget.tabbar.TabBarOp) r2)
            java.util.List<com.didi.soda.customer.widget.tabbar.a> r2 = r8.f42191a
            r2.add(r4)
            goto L_0x00d6
        L_0x00b9:
            java.lang.String r2 = "TabController"
            java.lang.String r4 = "找不到对于的model!!!!"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29100d(r2, r4)
            goto L_0x00d6
        L_0x00c2:
            java.lang.String r4 = "tabBarItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            com.didi.soda.customer.widget.tabbar.a r4 = r8.m29748b((com.didi.soda.customer.widget.tabbar.TabBarItem) r3)
            if (r4 == 0) goto L_0x00d6
            r8.m29744a((com.didi.soda.customer.widget.tabbar.C13883a) r4, (int) r2)
            java.util.List<com.didi.soda.customer.widget.tabbar.a> r2 = r8.f42191a
            r2.add(r4)
        L_0x00d6:
            com.didi.soda.customer.widget.tabbar.TabBarOp r2 = com.didi.soda.customer.widget.tabbar.TabBarOp.NONE
            r3.setOp(r2)
            r2 = r5
            goto L_0x002c
        L_0x00de:
            int r0 = r1.size()
            if (r0 <= 0) goto L_0x0109
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r0 = r1.iterator()
        L_0x00ea:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0109
            java.lang.Object r1 = r0.next()
            com.didi.soda.customer.widget.tabbar.a r1 = (com.didi.soda.customer.widget.tabbar.C13883a) r1
            com.didi.soda.customer.widget.tabbar.a r2 = r8.f42193c
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x0100
            r8.f42193c = r4
        L_0x0100:
            java.lang.String r2 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r8.m29743a((com.didi.soda.customer.widget.tabbar.C13883a) r1)
            goto L_0x00ea
        L_0x0109:
            r8.m29737a()
            r8.m29750b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.widget.tabbar.TabBarController.apply():void");
    }

    /* renamed from: b */
    private final C13883a m29748b(TabBarItem tabBarItem) {
        ComponentController controller;
        PageCallback pageCallback = null;
        if (m29747a(tabBarItem) || (controller = tabBarItem.getController()) == null) {
            return null;
        }
        Context context = this.f42198h;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        C13884b b = m29749b(context);
        C13883a aVar = new C13883a(tabBarItem, b, (View) null, false, 12, (DefaultConstructorMarker) null);
        m29746a(b, aVar);
        PageCallback pageCallback2 = this.f42197g;
        if (pageCallback2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageCallback");
        } else {
            pageCallback = pageCallback2;
        }
        controller.attach(pageCallback, tabBarItem.getParams());
        boolean z = !tabBarItem.isLazyLoad();
        if (z) {
            aVar.mo106242a((View) m29736a(controller));
            aVar.mo106247b(true);
        } else {
            aVar.mo106247b(false);
        }
        if (z) {
            m29751b(controller);
            this.f42200j.dispatchPageEventWhenAdd(controller);
        }
        return aVar;
    }

    public final int findTabIndex(Function1<? super TabBarItem, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i = 0;
        for (C13883a a : this.f42191a) {
            if (function1.invoke(a.mo106241a()).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static /* synthetic */ void selectTab$default(TabBarController tabBarController, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        tabBarController.selectTab(i, z);
    }

    public final void selectTab(int i, boolean z) {
        if (i >= 0 && i < this.f42191a.size()) {
            C13883a aVar = this.f42191a.get(i);
            m29752b(aVar);
            m29745a(aVar, z);
        }
    }

    /* renamed from: a */
    private final void m29746a(C13884b bVar, C13883a aVar) {
        bVar.mo106254b(aVar);
        bVar.setOnClickListener(new View.OnClickListener(aVar) {
            public final /* synthetic */ C13883a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                TabBarController.m29740a(TabBarController.this, this.f$1, view);
            }
        });
        if (aVar.mo106241a().isCanDoubleClick()) {
            bVar.setOnDoubleClickListener(new TabBarController$setupTabItemView$2(this, aVar));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29740a(TabBarController tabBarController, C13883a aVar, View view) {
        Intrinsics.checkNotNullParameter(tabBarController, "this$0");
        Intrinsics.checkNotNullParameter(aVar, "$model");
        tabBarController.m29752b(aVar);
        tabBarController.m29745a(aVar, true);
    }

    /* renamed from: a */
    private final ViewGroup m29736a(ComponentController componentController) {
        Context context = this.f42198h;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        ViewGroup a = m29735a(context);
        Context context3 = this.f42198h;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            context2 = context3;
        }
        View tabView = componentController.getTabView(context2);
        componentController.setupComponents(tabView);
        a.addView(tabView);
        a.setVisibility(8);
        return a;
    }

    /* renamed from: b */
    private final void m29751b(ComponentController componentController) {
        for (ComponentInfo componentInfo : componentController.getComponentList()) {
            if (!componentInfo.isAdded()) {
                TabComponentCallback tabComponentCallback = this.f42201k;
                if (tabComponentCallback != null) {
                    tabComponentCallback.addComponent(componentInfo.getComponent());
                }
                componentInfo.setAdded(true);
            }
        }
    }

    /* renamed from: c */
    private final void m29753c(ComponentController componentController) {
        for (ComponentInfo componentInfo : componentController.getComponentList()) {
            if (componentInfo.isAdded()) {
                TabComponentCallback tabComponentCallback = this.f42201k;
                if (tabComponentCallback != null) {
                    tabComponentCallback.removeComponent(componentInfo.getComponent());
                }
                componentInfo.setAdded(false);
            }
        }
    }

    /* renamed from: a */
    private final ViewGroup m29735a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    /* renamed from: b */
    private final C13884b m29749b(Context context) {
        C13884b bVar = new C13884b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        bVar.setLayoutParams(layoutParams);
        return bVar;
    }

    /* renamed from: a */
    static /* synthetic */ void m29741a(TabBarController tabBarController, C13883a aVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        tabBarController.m29745a(aVar, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29745a(C13883a aVar, boolean z) {
        TabBarItem tabBarItem;
        C13883a aVar2 = this.f42193c;
        if (aVar2 != null) {
            aVar2.mo106245a(false, z);
            ComponentController controller = aVar2.mo106241a().getController();
            if (controller != null) {
                controller.onTabVisibleChanged(false, z);
            }
        }
        this.f42193c = aVar;
        aVar.mo106245a(true, z);
        ComponentController controller2 = aVar.mo106241a().getController();
        if (controller2 != null) {
            controller2.onTabVisibleChanged(true, z);
        }
        if (aVar2 == null) {
            tabBarItem = null;
        } else {
            tabBarItem = aVar2.mo106241a();
        }
        m29742a(tabBarItem, aVar.mo106241a(), z);
    }

    /* renamed from: a */
    static /* synthetic */ void m29738a(TabBarController tabBarController, TabBarItem tabBarItem, TabBarItem tabBarItem2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        tabBarController.m29742a(tabBarItem, tabBarItem2, z);
    }

    /* renamed from: a */
    private final void m29742a(TabBarItem tabBarItem, TabBarItem tabBarItem2, boolean z) {
        OnTabChangedListener onTabChangedListener = this.f42199i;
        if (onTabChangedListener != null) {
            onTabChangedListener.onTanChangedEvent(this, tabBarItem, tabBarItem2, z);
        }
    }

    @Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ+\u0010\n\u001a\u00020\u00062!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00060\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarController$Event;", "", "(Lcom/didi/soda/customer/widget/tabbar/TabBarController;)V", "pageEvent", "Lcom/didi/app/nova/skeleton/IScopeLifecycle$PageStatus;", "dispatchPageEventWhenAdd", "", "controller", "Lcom/didi/soda/customer/widget/tabbar/ComponentController;", "dispatchPageEventWhenRemove", "dispatchToItems", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCreate", "onDestroy", "onPageResult", "data", "Landroid/os/Bundle;", "onPause", "onResume", "onStart", "onStop", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TabBarController.kt */
    public final class Event {
        private IScopeLifecycle.PageStatus pageEvent;
        final /* synthetic */ TabBarController this$0;

        @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: TabBarController.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[IScopeLifecycle.PageStatus.values().length];
                iArr[IScopeLifecycle.PageStatus.Create.ordinal()] = 1;
                iArr[IScopeLifecycle.PageStatus.Start.ordinal()] = 2;
                iArr[IScopeLifecycle.PageStatus.Resume.ordinal()] = 3;
                iArr[IScopeLifecycle.PageStatus.Pause.ordinal()] = 4;
                iArr[IScopeLifecycle.PageStatus.Stop.ordinal()] = 5;
                iArr[IScopeLifecycle.PageStatus.Destroy.ordinal()] = 6;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Event(TabBarController tabBarController) {
            Intrinsics.checkNotNullParameter(tabBarController, "this$0");
            this.this$0 = tabBarController;
        }

        public final void onCreate() {
            this.pageEvent = IScopeLifecycle.PageStatus.Create;
            dispatchToItems(TabBarController$Event$onCreate$1.INSTANCE);
        }

        public final void onStart() {
            this.pageEvent = IScopeLifecycle.PageStatus.Start;
            dispatchToItems(TabBarController$Event$onStart$1.INSTANCE);
        }

        public final void onResume() {
            this.pageEvent = IScopeLifecycle.PageStatus.Resume;
            dispatchToItems(TabBarController$Event$onResume$1.INSTANCE);
        }

        public final void onStop() {
            this.pageEvent = IScopeLifecycle.PageStatus.Stop;
            dispatchToItems(TabBarController$Event$onStop$1.INSTANCE);
        }

        public final void onPause() {
            this.pageEvent = IScopeLifecycle.PageStatus.Pause;
            dispatchToItems(TabBarController$Event$onPause$1.INSTANCE);
        }

        public final void onDestroy() {
            this.pageEvent = IScopeLifecycle.PageStatus.Destroy;
            dispatchToItems(TabBarController$Event$onDestroy$1.INSTANCE);
        }

        public final void onPageResult(Bundle bundle) {
            dispatchToItems(new TabBarController$Event$onPageResult$1(bundle));
        }

        public final void dispatchPageEventWhenAdd(ComponentController componentController) {
            IScopeLifecycle.PageStatus pageStatus;
            int i;
            if (componentController != null && (pageStatus = this.pageEvent) != null) {
                if (pageStatus == null) {
                    i = -1;
                } else {
                    i = WhenMappings.$EnumSwitchMapping$0[pageStatus.ordinal()];
                }
                if (i == 1) {
                    componentController.onCreate();
                } else if (i == 2) {
                    componentController.onCreate();
                    componentController.onStart();
                } else if (i == 3) {
                    componentController.onCreate();
                    componentController.onStart();
                    componentController.onResume();
                } else if (i == 4) {
                    componentController.onCreate();
                    componentController.onStart();
                } else if (i == 5) {
                    componentController.onCreate();
                }
            }
        }

        public final void dispatchPageEventWhenRemove(ComponentController componentController) {
            IScopeLifecycle.PageStatus pageStatus;
            int i;
            if (componentController != null && (pageStatus = this.pageEvent) != null) {
                if (pageStatus == null) {
                    i = -1;
                } else {
                    i = WhenMappings.$EnumSwitchMapping$0[pageStatus.ordinal()];
                }
                if (i == 1) {
                    componentController.onDestroy();
                } else if (i == 2) {
                    componentController.onStop();
                    componentController.onDestroy();
                } else if (i == 3) {
                    componentController.onPause();
                    componentController.onStop();
                    componentController.onDestroy();
                } else if (i == 4) {
                    componentController.onStop();
                    componentController.onDestroy();
                } else if (i == 5) {
                    componentController.onDestroy();
                }
            }
        }

        private final void dispatchToItems(Function1<? super ComponentController, Unit> function1) {
            ComponentController controller;
            for (C13883a aVar : this.this$0.f42191a) {
                if (aVar.mo106251f() && (controller = aVar.mo106241a().getController()) != null) {
                    function1.invoke(controller);
                }
            }
        }
    }
}
