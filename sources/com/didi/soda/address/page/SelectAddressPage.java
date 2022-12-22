package com.didi.soda.address.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.rfusion.widget.floating.RFFloatingChangeHandler;
import com.didi.soda.address.component.feed.AddressFeedMessageComponent;
import com.didi.soda.address.component.search.SearchAddressComponent;
import com.didi.soda.address.manager.AddressMessageRepo;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.AppConfigUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"addressSelectPage", "addressListPage"})
public class SelectAddressPage extends FloatingCustomerPage {

    /* renamed from: k */
    private static final String f38788k = "SelectAddressPage";

    /* renamed from: a */
    FrameLayout f38789a;

    /* renamed from: b */
    FrameLayout f38790b;

    /* renamed from: c */
    CustomerAppCompatTextView f38791c;

    /* renamed from: d */
    ViewGroup f38792d;

    /* renamed from: e */
    LottieAnimationView f38793e;

    /* renamed from: f */
    View f38794f;

    /* renamed from: g */
    View f38795g;

    /* renamed from: h */
    View f38796h;

    /* renamed from: i */
    SearchAddressComponent f38797i;

    /* renamed from: j */
    AddressFeedMessageComponent f38798j;

    public SelectAddressPage() {
        DiRouter.registerHub(RoutePath.ADDRESS_HOME, this);
        DiRouter.registerHub("addressListPage", this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setContentView(this.f38796h);
        setType(2);
        this.f38789a.setVisibility(8);
        this.f38793e.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
            public void onCompositionLoaded(LottieComposition lottieComposition) {
                SelectAddressPage.this.f38793e.setFrame((int) lottieComposition.getEndFrame());
            }
        });
        this.f38792d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SelectAddressPage.this.m27495b(view);
            }
        });
        this.f38794f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SelectAddressPage.this.m27493a(view);
            }
        });
        if (!AppConfigUtil.isGuideAnimShowed()) {
            m27496c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m27495b(View view) {
        this.f38793e.setSpeed(-2.0f);
        this.f38793e.playAnimation();
        this.f38789a.setVisibility(0);
        this.f38797i.showOrHide(true, (SearchAddressComponent.OnSearchAnimationListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27493a(View view) {
        if (this.f38789a.getVisibility() == 0) {
            m27494b();
            return;
        }
        dismiss();
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", (getScopeContext() == null || getScopeContext().getObject("PageName") == null) ? "" : (String) getScopeContext().getObject("PageName")).build().track();
    }

    public boolean onHandleBack() {
        if (this.f38789a.getVisibility() != 0) {
            return super.onHandleBack();
        }
        m27494b();
        return true;
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        SearchAddressComponent searchAddressComponent = new SearchAddressComponent(this.f38789a);
        this.f38797i = searchAddressComponent;
        addComponent(searchAddressComponent);
        AddressFeedMessageComponent addressFeedMessageComponent = new AddressFeedMessageComponent(this.f38790b);
        this.f38798j = addressFeedMessageComponent;
        addComponent(addressFeedMessageComponent);
    }

    public ControllerChangeHandler getPushHandler() {
        boolean z = false;
        if (getScopeContext() != null) {
            z = getScopeContext().getBundle().getBoolean("remove_font_page", false);
        }
        return new RFFloatingChangeHandler(z);
    }

    /* access modifiers changed from: protected */
    public void updateFloatingConfig() {
        super.updateFloatingConfig();
        getNavBar().setVisible(false);
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_address_home, (ViewGroup) getView(), false);
        this.f38796h = inflate;
        this.f38789a = (FrameLayout) inflate.findViewById(R.id.fl_search_top_container);
        this.f38790b = (FrameLayout) this.f38796h.findViewById(R.id.fl_recommend_address_container);
        this.f38791c = (CustomerAppCompatTextView) this.f38796h.findViewById(R.id.customer_tv_title_label);
        this.f38792d = (ViewGroup) this.f38796h.findViewById(R.id.customer_search_view);
        this.f38793e = (LottieAnimationView) this.f38796h.findViewById(R.id.customer_iv_page_arrow_back);
        this.f38794f = this.f38796h.findViewById(R.id.customer_fl_address_back_container);
        this.f38795g = this.f38796h.findViewById(R.id.customer_fl_address_mask_container);
    }

    /* renamed from: b */
    private void m27494b() {
        this.f38793e.setSpeed(2.0f);
        this.f38793e.playAnimation();
        this.f38797i.showOrHide(false, new SearchAddressComponent.OnSearchAnimationListener() {
            public final void onAnimationCompleted() {
                SelectAddressPage.this.m27497d();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m27497d() {
        this.f38789a.setVisibility(8);
    }

    /* renamed from: c */
    private void m27496c() {
        ((AddressMessageRepo) RepoFactory.getRepo(AddressMessageRepo.class)).subscribeAddressAnimMessage(getScopeContext(), new Action2<AddressMessageRepo.AddressAnimStatus>() {
            public void call(AddressMessageRepo.AddressAnimStatus addressAnimStatus, Subscription subscription) {
                if (addressAnimStatus == AddressMessageRepo.AddressAnimStatus.ANIM_START) {
                    SelectAddressPage.this.f38795g.setVisibility(0);
                } else if (addressAnimStatus == AddressMessageRepo.AddressAnimStatus.ANIM_END) {
                    AppConfigUtil.setGuideAnimShowed();
                    SelectAddressPage.this.f38795g.setVisibility(8);
                    subscription.unsubscribe();
                }
            }
        });
    }
}
