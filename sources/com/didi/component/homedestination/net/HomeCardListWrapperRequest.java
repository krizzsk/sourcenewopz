package com.didi.component.homedestination.net;

import android.content.Context;
import com.didi.component.homedestination.model.HomeCardListResponse;
import com.didi.component.homedestination.model.HomeCpfAwareResponse;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import java.util.Map;

public class HomeCardListWrapperRequest extends HomeGetRecRequest {

    /* renamed from: a */
    private HomeGetRecRequest f14092a;

    /* renamed from: b */
    private HomeOrderBanRequest f14093b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public HomeCardListResponse f14094c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OrderBanCardInfo f14095d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Runnable f14096e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public HomeCpfAwareResponse f14097f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OrderBanCardInfo f14098g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Runnable f14099h;

    public HomeCardListWrapperRequest(Context context) {
        super(context);
        this.f14092a = new HomeGetRecRequest(context);
        this.f14093b = new HomeOrderBanRequest(context);
    }

    public void getRecRequest(Map map, ResponseListener<HomeCardListResponse> responseListener) {
        this.f14094c = null;
        this.f14095d = null;
        this.f14096e = null;
        this.f14092a.getRecRequest(map, m9826a(responseListener));
        this.f14093b.getOrderBanRequest(map, m9825a());
    }

    /* renamed from: a */
    private ResponseListener<HomeCardListResponse> m9826a(final ResponseListener<HomeCardListResponse> responseListener) {
        return new ResponseListener<HomeCardListResponse>() {
            public void onFinish(HomeCardListResponse homeCardListResponse) {
                HomeCardListWrapperRequest homeCardListWrapperRequest = HomeCardListWrapperRequest.this;
                if (homeCardListResponse == null) {
                    homeCardListResponse = new HomeCardListResponse();
                }
                HomeCardListResponse unused = homeCardListWrapperRequest.f14094c = homeCardListResponse;
                Runnable unused2 = HomeCardListWrapperRequest.this.f14096e = new Runnable() {
                    public void run() {
                        responseListener.onFinish(HomeCardListWrapperRequest.this.f14094c);
                    }
                };
                HomeCardListWrapperRequest.this.m9832b();
            }
        };
    }

    /* renamed from: a */
    private ResponseListener<OrderBanCardInfo> m9825a() {
        return new ResponseListener<OrderBanCardInfo>() {
            public void onFinish(OrderBanCardInfo orderBanCardInfo) {
                HomeCardListWrapperRequest homeCardListWrapperRequest = HomeCardListWrapperRequest.this;
                if (orderBanCardInfo == null) {
                    orderBanCardInfo = new OrderBanCardInfo();
                }
                OrderBanCardInfo unused = homeCardListWrapperRequest.f14095d = orderBanCardInfo;
                HomeCardListWrapperRequest.this.m9832b();
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9832b() {
        OrderBanCardInfo orderBanCardInfo;
        HomeCardListResponse homeCardListResponse = this.f14094c;
        if (homeCardListResponse != null && (orderBanCardInfo = this.f14095d) != null && this.f14096e != null) {
            homeCardListResponse.orderBanCardInfo = orderBanCardInfo;
            this.f14096e.run();
        }
    }

    /* renamed from: b */
    private ResponseListener<HomeCpfAwareResponse> m9829b(final ResponseListener<HomeCpfAwareResponse> responseListener) {
        return new ResponseListener<HomeCpfAwareResponse>() {
            public void onSuccess(HomeCpfAwareResponse homeCpfAwareResponse) {
                HomeCardListWrapperRequest homeCardListWrapperRequest = HomeCardListWrapperRequest.this;
                if (homeCpfAwareResponse == null) {
                    homeCpfAwareResponse = new HomeCpfAwareResponse();
                }
                HomeCpfAwareResponse unused = homeCardListWrapperRequest.f14097f = homeCpfAwareResponse;
                Runnable unused2 = HomeCardListWrapperRequest.this.f14099h = new Runnable() {
                    public void run() {
                        responseListener.onSuccess(HomeCardListWrapperRequest.this.f14097f);
                    }
                };
                HomeCardListWrapperRequest.this.m9836d();
            }

            public void onFail(HomeCpfAwareResponse homeCpfAwareResponse) {
                HomeCardListWrapperRequest homeCardListWrapperRequest = HomeCardListWrapperRequest.this;
                if (homeCpfAwareResponse == null) {
                    homeCpfAwareResponse = new HomeCpfAwareResponse();
                }
                HomeCpfAwareResponse unused = homeCardListWrapperRequest.f14097f = homeCpfAwareResponse;
                Runnable unused2 = HomeCardListWrapperRequest.this.f14099h = new Runnable() {
                    public void run() {
                        responseListener.onFail(HomeCardListWrapperRequest.this.f14097f);
                    }
                };
                HomeCardListWrapperRequest.this.m9836d();
            }
        };
    }

    /* renamed from: c */
    private ResponseListener<OrderBanCardInfo> m9835c() {
        return new ResponseListener<OrderBanCardInfo>() {
            public void onFinish(OrderBanCardInfo orderBanCardInfo) {
                HomeCardListWrapperRequest homeCardListWrapperRequest = HomeCardListWrapperRequest.this;
                if (orderBanCardInfo == null) {
                    orderBanCardInfo = new OrderBanCardInfo();
                }
                OrderBanCardInfo unused = homeCardListWrapperRequest.f14098g = orderBanCardInfo;
                HomeCardListWrapperRequest.this.m9836d();
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m9836d() {
        OrderBanCardInfo orderBanCardInfo;
        HomeCpfAwareResponse homeCpfAwareResponse = this.f14097f;
        if (homeCpfAwareResponse != null && (orderBanCardInfo = this.f14098g) != null && this.f14099h != null) {
            homeCpfAwareResponse.orderBanCardInfo = orderBanCardInfo;
            this.f14099h.run();
        }
    }
}
