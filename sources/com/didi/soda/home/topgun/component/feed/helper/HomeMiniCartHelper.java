package com.didi.soda.home.topgun.component.feed.helper;

import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.component.feed.base.FooterViewIPresenter;
import com.didi.soda.customer.component.provider.ICartProvider;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;

public class HomeMiniCartHelper implements IScopeLifecycle {

    /* renamed from: a */
    private static final int f42826a = 5;

    /* renamed from: b */
    private static final int f42827b = 3000;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ScopeContext f42828c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RecyclerView f42829d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FooterViewIPresenter f42830e;

    /* renamed from: f */
    private RecyclerView.OnScrollListener f42831f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ICartProvider f42832g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f42833h;

    /* renamed from: i */
    private boolean f42834i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f42835j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnceActionUtil.ActionPool f42836k = new OnceActionUtil.ActionPool();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Runnable f42837l = new Runnable() {
        public void run() {
            if (HomeMiniCartHelper.this.f42832g != null && !HomeMiniCartHelper.this.f42835j) {
                HomeMiniCartHelper.this.f42832g.show();
                HomeMiniCartHelper.this.m30297b();
            }
        }
    };

    public void onCreate(ILive iLive) {
    }

    public void onPause(ILive iLive) {
    }

    public void onResume(ILive iLive) {
    }

    public void onStart(ILive iLive) {
    }

    public void onStop(ILive iLive) {
    }

    public void attach(ScopeContext scopeContext, RecyclerView recyclerView, FooterViewIPresenter footerViewIPresenter) {
        this.f42828c = scopeContext;
        this.f42829d = recyclerView;
        this.f42830e = footerViewIPresenter;
        this.f42832g = (ICartProvider) scopeContext.getObject("service_cart_key");
        m30296a();
        scopeContext.addObserver(this);
    }

    public void setFilterShow(boolean z) {
        this.f42835j = z;
        ICartProvider iCartProvider = this.f42832g;
        if (iCartProvider == null) {
            return;
        }
        if (z) {
            iCartProvider.hide();
        } else {
            iCartProvider.show();
        }
    }

    public void onDestroy(ILive iLive) {
        UiHandlerUtil.removeCallbacks(this.f42837l);
        this.f42828c.removeObserver(this);
        this.f42829d.removeOnScrollListener(this.f42831f);
    }

    /* renamed from: a */
    private void m30296a() {
        C140212 r0 = new RecyclerView.OnScrollListener() {
            /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView r5, int r6) {
                /*
                    r4 = this;
                    super.onScrollStateChanged(r5, r6)
                    com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper r5 = com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper.this
                    com.didi.soda.customer.component.provider.ICartProvider r5 = r5.f42832g
                    if (r5 != 0) goto L_0x001d
                    com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper r5 = com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper.this
                    com.didi.app.nova.skeleton.ScopeContext r0 = r5.f42828c
                    java.lang.String r1 = "service_cart_key"
                    java.lang.Object r0 = r0.getObject(r1)
                    com.didi.soda.customer.component.provider.ICartProvider r0 = (com.didi.soda.customer.component.provider.ICartProvider) r0
                    com.didi.soda.customer.component.provider.ICartProvider unused = r5.f42832g = r0
                L_0x001d:
                    if (r6 != 0) goto L_0x0083
                    java.lang.Class<com.didi.soda.manager.base.ICustomerCartManager> r5 = com.didi.soda.manager.base.ICustomerCartManager.class
                    com.didi.soda.manager.base.ICustomerManager r5 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r5)
                    com.didi.soda.manager.base.ICustomerCartManager r5 = (com.didi.soda.manager.base.ICustomerCartManager) r5
                    boolean r5 = r5.isGlobalCartListEmpty()
                    if (r5 != 0) goto L_0x0036
                    com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper r5 = com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper.this
                    java.lang.Runnable r5 = r5.f42837l
                    com.didi.soda.customer.foundation.util.UiHandlerUtil.post(r5)
                L_0x0036:
                    com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper r5 = com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper.this
                    com.didi.soda.customer.component.feed.base.FooterViewIPresenter r5 = r5.f42830e
                    boolean r5 = r5 instanceof com.didi.soda.home.topgun.component.feed.HomeFeedPresenter
                    if (r5 == 0) goto L_0x005b
                    com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper r5 = com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper.this     // Catch:{ Exception -> 0x0057 }
                    com.didi.soda.customer.component.feed.base.FooterViewIPresenter r5 = r5.f42830e     // Catch:{ Exception -> 0x0057 }
                    com.didi.soda.home.topgun.component.feed.HomeFeedPresenter r5 = (com.didi.soda.home.topgun.component.feed.HomeFeedPresenter) r5     // Catch:{ Exception -> 0x0057 }
                    com.didi.soda.datasource.page.dynamic.DynamicDataSource r5 = r5.getDataSource()     // Catch:{ Exception -> 0x0057 }
                    com.didi.soda.datasource.page.PageParams r5 = r5.getPageParams()     // Catch:{ Exception -> 0x0057 }
                    com.didi.soda.home.topgun.manager.HomeFeedParam r5 = (com.didi.soda.home.topgun.manager.HomeFeedParam) r5     // Catch:{ Exception -> 0x0057 }
                    java.lang.String r5 = r5.getTraceId()     // Catch:{ Exception -> 0x0057 }
                    goto L_0x005d
                L_0x0057:
                    r5 = move-exception
                    r5.printStackTrace()
                L_0x005b:
                    java.lang.String r5 = ""
                L_0x005d:
                    com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper r0 = com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper.this
                    int r0 = r0.f42833h
                    if (r0 == r6) goto L_0x0083
                    com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper$2$1 r0 = new com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper$2$1
                    r1 = 2
                    java.lang.Object[] r1 = new java.lang.Object[r1]
                    java.lang.String r2 = "sailing_c_x_homepage_slidefeed_ck"
                    r3 = 0
                    r1[r3] = r2
                    r2 = 1
                    r1[r2] = r5
                    r0.<init>(r1)
                    com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper r5 = com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper.this
                    com.didi.soda.customer.foundation.util.OnceActionUtil$ActionPool r5 = r5.f42836k
                    com.didi.soda.customer.foundation.util.OnceActionUtil$OnceAction[] r1 = new com.didi.soda.customer.foundation.util.OnceActionUtil.OnceAction[r2]
                    r1[r3] = r0
                    r5.doAction(r1)
                L_0x0083:
                    com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper r5 = com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper.this
                    int unused = r5.f42833h = r6
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper.C140212.onScrollStateChanged(androidx.recyclerview.widget.RecyclerView, int):void");
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (HomeMiniCartHelper.this.f42832g == null) {
                    HomeMiniCartHelper homeMiniCartHelper = HomeMiniCartHelper.this;
                    ICartProvider unused = homeMiniCartHelper.f42832g = (ICartProvider) homeMiniCartHelper.f42828c.getObject("service_cart_key");
                }
                if (HomeMiniCartHelper.this.f42832g != null && Math.abs(i2) >= 5) {
                    UiHandlerUtil.removeCallbacks(HomeMiniCartHelper.this.f42837l);
                    if (i2 >= 0 || ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).isGlobalCartListEmpty()) {
                        HomeMiniCartHelper.this.f42832g.hide();
                        HomeMiniCartHelper.this.m30299c();
                        return;
                    }
                    HomeMiniCartHelper.this.f42832g.show();
                    HomeMiniCartHelper.this.m30297b();
                }
            }
        };
        this.f42831f = r0;
        this.f42829d.addOnScrollListener(r0);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r0 = m30301d();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m30297b() {
        /*
            r4 = this;
            com.didi.soda.customer.component.provider.ICartProvider r0 = r4.f42832g
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isCanShow()
            if (r0 != 0) goto L_0x0010
            com.didi.soda.customer.component.feed.base.FooterViewIPresenter r0 = r4.f42830e
            r0.hideFooterStubView()
            return
        L_0x0010:
            boolean r0 = r4.f42834i
            if (r0 == 0) goto L_0x0015
            return
        L_0x0015:
            int r0 = r4.m30301d()
            if (r0 <= 0) goto L_0x004d
            r1 = 1
            r4.f42834i = r1
            com.didi.soda.customer.component.feed.base.FooterViewIPresenter r2 = r4.f42830e
            r2.showFooterStubView()
            r2 = 2
            int[] r2 = new int[r2]
            r3 = 0
            r2[r3] = r3
            androidx.recyclerview.widget.RecyclerView r3 = r4.f42829d
            int r3 = com.didi.soda.home.topgun.component.feed.helper.HomeCalculateHeightUtil.getCartStubOffset(r3)
            r2[r1] = r3
            android.animation.ValueAnimator r1 = android.animation.ValueAnimator.ofInt(r2)
            r2 = 500(0x1f4, double:2.47E-321)
            r1.setDuration(r2)
            android.view.animation.AccelerateInterpolator r2 = new android.view.animation.AccelerateInterpolator
            r2.<init>()
            r1.setInterpolator(r2)
            com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper$3 r2 = new com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper$3
            r2.<init>(r0)
            r1.addUpdateListener(r2)
            r1.start()
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper.m30297b():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m30299c() {
        if (this.f42834i) {
            this.f42834i = false;
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{HomeCalculateHeightUtil.getCartStubOffset(this.f42829d), 0});
            ofInt.setDuration(500);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HomeMiniCartHelper.this.f42830e.updateFooterStubViewHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.start();
        }
    }

    /* renamed from: d */
    private int m30301d() {
        RecyclerView.LayoutManager layoutManager = this.f42829d.getLayoutManager();
        int findLastCompletelyVisibleItemPosition = layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() : 0;
        int itemCount = layoutManager.getItemCount() - 1;
        if (findLastCompletelyVisibleItemPosition == itemCount) {
            return itemCount;
        }
        return 0;
    }
}
