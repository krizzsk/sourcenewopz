package com.didi.soda.customer.base.lazycomponent;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Component;
import com.didi.soda.customer.base.lazycomponent.ILazyPresenter;
import com.didi.soda.customer.base.lazycomponent.ILazyView;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class LazyComponent<V extends ILazyView<P>, P extends ILazyPresenter<V>> extends Component {

    /* renamed from: a */
    static boolean f40349a = false;

    /* renamed from: b */
    private P f40350b;

    /* renamed from: c */
    private V f40351c;

    /* renamed from: d */
    private ComponentEvent f40352d;

    /* renamed from: e */
    private boolean f40353e = false;

    /* renamed from: f */
    private InitializedCallback f40354f = new InitializedCallback() {
        public final void onInitialized() {
            LazyComponent.this.m28609j();
        }
    };

    private enum ComponentEvent {
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY
    }

    interface InitializedCallback {
        void onInitialized();
    }

    /* access modifiers changed from: protected */
    public P onCreatePresenter() {
        return null;
    }

    /* access modifiers changed from: protected */
    public V onCreateView() {
        return null;
    }

    public static void log(String str) {
        if (f40349a) {
            LogUtil.m29100d("LazyComponent", str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void m28609j() {
        if (!this.f40353e) {
            this.f40353e = true;
            m28602c();
            return;
        }
        throw new IllegalArgumentException(">>>>>>懒加载Component发生重复初始化异常 <<<<<<");
    }

    public void load() {
        V v = this.f40351c;
        if (v != null) {
            v.load();
        }
    }

    public LazyComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* renamed from: com.didi.soda.customer.base.lazycomponent.LazyComponent$1 */
    static /* synthetic */ class C136071 {

        /* renamed from: $SwitchMap$com$didi$soda$customer$base$lazycomponent$LazyComponent$ComponentEvent */
        static final /* synthetic */ int[] f40355xcb1f9794;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent[] r0 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40355xcb1f9794 = r0
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40355xcb1f9794     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f40355xcb1f9794     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.RESUME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f40355xcb1f9794     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.PAUSE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f40355xcb1f9794     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.STOP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f40355xcb1f9794     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.DESTROY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.base.lazycomponent.LazyComponent.C136071.<clinit>():void");
        }
    }

    /* renamed from: c */
    private void m28602c() {
        int i = C136071.f40355xcb1f9794[this.f40352d.ordinal()];
        if (i == 1) {
            m28603d();
        } else if (i == 2) {
            m28603d();
            m28604e();
        } else if (i == 3) {
            m28603d();
            m28604e();
            m28605f();
        } else if (i == 4) {
            m28603d();
            m28604e();
        } else if (i == 5) {
            m28603d();
        }
    }

    public final V getLogicView() {
        return this.f40351c;
    }

    public final P getPresenter() {
        return this.f40350b;
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        super.onAttach();
        if (this.f40351c == null) {
            this.f40351c = onCreateView();
        }
        if (this.f40350b == null) {
            this.f40350b = onCreatePresenter();
        }
        this.f40350b.setInitCallback(this.f40354f);
        P p = this.f40350b;
        if (p != null) {
            p.attachView(this.f40351c);
            this.f40350b.innerAttach(this.mScopeContext);
        }
        V v = this.f40351c;
        if (v != null) {
            v.attachPresenter(this.f40350b);
            this.f40351c.innerAttach(getContainer());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        this.f40352d = ComponentEvent.CREATE;
        super.onCreate();
        if (this.f40353e) {
            m28603d();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.f40352d = ComponentEvent.START;
        super.onStart();
        if (this.f40353e) {
            m28604e();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.f40352d = ComponentEvent.RESUME;
        super.onResume();
        if (this.f40353e) {
            m28605f();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f40352d = ComponentEvent.PAUSE;
        super.onPause();
        if (this.f40353e) {
            m28606g();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f40352d = ComponentEvent.STOP;
        super.onStop();
        if (this.f40353e) {
            m28607h();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
        super.onDetach();
        V v = this.f40351c;
        if (v != null) {
            v.innerDetach();
        }
        P p = this.f40350b;
        if (p != null) {
            p.innerDetach();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f40352d = ComponentEvent.DESTROY;
        super.onDestroy();
        if (this.f40353e) {
            m28608i();
        }
    }

    /* renamed from: d */
    private void m28603d() {
        V v = this.f40351c;
        if (v != null) {
            v.onCreate();
        }
        P p = this.f40350b;
        if (p != null) {
            p.onCreate();
        }
    }

    /* renamed from: e */
    private void m28604e() {
        V v = this.f40351c;
        if (v != null) {
            v.onStart();
        }
        P p = this.f40350b;
        if (p != null) {
            p.onStart();
        }
    }

    /* renamed from: f */
    private void m28605f() {
        V v = this.f40351c;
        if (v != null) {
            v.onResume();
        }
        P p = this.f40350b;
        if (p != null) {
            p.onResume();
        }
    }

    /* renamed from: g */
    private void m28606g() {
        V v = this.f40351c;
        if (v != null) {
            v.onPause();
        }
        P p = this.f40350b;
        if (p != null) {
            p.onPause();
        }
    }

    /* renamed from: h */
    private void m28607h() {
        V v = this.f40351c;
        if (v != null) {
            v.onStop();
        }
        P p = this.f40350b;
        if (p != null) {
            p.onStop();
        }
    }

    /* renamed from: i */
    private void m28608i() {
        P p = this.f40350b;
        if (p != null) {
            p.onDestroy();
        }
        V v = this.f40351c;
        if (v != null) {
            v.onDestroy();
        }
    }
}
