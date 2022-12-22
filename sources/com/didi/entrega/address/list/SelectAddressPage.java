package com.didi.entrega.address.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.entrega.address.list.component.feed.AddressFeedMessageComponent;
import com.didi.entrega.address.list.component.search.SearchAddressComponent;
import com.didi.entrega.address.utils.omega.AddressOmegaHelper;
import com.didi.entrega.customer.base.pages.FloatingCustomerPage;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;
import com.didi.rfusion.widget.floating.RFFloatingChangeHandler;
import com.taxis99.R;

@Route({"addressListPage"})
public class SelectAddressPage extends FloatingCustomerPage {

    /* renamed from: n */
    private static final String f19410n = "SelectAddressPage";

    /* renamed from: a */
    FrameLayout f19411a;

    /* renamed from: b */
    FrameLayout f19412b;

    /* renamed from: c */
    CustomerAppCompatTextView f19413c;

    /* renamed from: d */
    ViewGroup f19414d;

    /* renamed from: e */
    LottieAnimationView f19415e;

    /* renamed from: f */
    View f19416f;

    /* renamed from: g */
    View f19417g;

    /* renamed from: h */
    View f19418h;

    /* renamed from: i */
    CustomerAppCompatTextView f19419i;

    /* renamed from: j */
    SearchAddressComponent f19420j;

    /* renamed from: k */
    AddressFeedMessageComponent f19421k;

    public SelectAddressPage() {
        DiRouter.registerHub("addressListPage", this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setContentView(this.f19418h);
        setType(2);
        int i = getScopeContext().getBundle().getInt("from", -1);
        this.f19411a.setVisibility(8);
        this.f19415e.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
            public void onCompositionLoaded(LottieComposition lottieComposition) {
                SelectAddressPage.this.f19415e.setFrame((int) lottieComposition.getEndFrame());
            }
        });
        this.f19414d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SelectAddressPage.this.m14522a(view);
            }
        });
        this.f19416f.setOnClickListener(new View.OnClickListener(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                SelectAddressPage.this.m14521a(this.f$1, view);
            }
        });
        m14523b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m14522a(View view) {
        this.f19415e.setSpeed(-2.0f);
        this.f19415e.playAnimation();
        this.f19411a.setVisibility(0);
        this.f19420j.showOrHide(true, (SearchAddressComponent.OnSearchAnimationListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m14521a(int i, View view) {
        if (this.f19411a.getVisibility() == 0) {
            m14524c();
            return;
        }
        dismiss();
        AddressOmegaHelper.INSTANCE.trackDeliverySearchReturnCK(i);
    }

    /* renamed from: b */
    private void m14523b() {
        int i = getScopeContext().getBundle().getInt("from", -1);
        if (i == 2 || i == 4 || i == 6) {
            this.f19413c.setText(ResourceHelper.getString(R.string.FoodC_search_Address_of_XLJA));
            this.f19419i.setText(ResourceHelper.getString(R.string.FoodC_search_Where_does_JuOK));
            this.f19420j.setSearchTextHint(ResourceHelper.getString(R.string.FoodC_search_Where_does_JuOK));
            return;
        }
        this.f19413c.setText(ResourceHelper.getString(R.string.FoodC_search_Mail_address_DnuS));
        this.f19419i.setText(ResourceHelper.getString(R.string.FoodC_search_Where_does_XByG));
        this.f19420j.setSearchTextHint(ResourceHelper.getString(R.string.FoodC_search_Where_does_XByG));
    }

    public boolean onHandleBack() {
        if (this.f19411a.getVisibility() != 0) {
            return super.onHandleBack();
        }
        m14524c();
        return true;
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        SearchAddressComponent searchAddressComponent = new SearchAddressComponent(this.f19411a);
        this.f19420j = searchAddressComponent;
        addComponent(searchAddressComponent);
        AddressFeedMessageComponent addressFeedMessageComponent = new AddressFeedMessageComponent(this.f19412b);
        this.f19421k = addressFeedMessageComponent;
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
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.entrega_customer_page_address_home, (ViewGroup) getView(), false);
        this.f19418h = inflate;
        this.f19411a = (FrameLayout) inflate.findViewById(R.id.fl_search_top_container);
        this.f19412b = (FrameLayout) this.f19418h.findViewById(R.id.fl_recommend_address_container);
        this.f19413c = (CustomerAppCompatTextView) this.f19418h.findViewById(R.id.customer_tv_title_label);
        this.f19414d = (ViewGroup) this.f19418h.findViewById(R.id.customer_search_view);
        this.f19415e = (LottieAnimationView) this.f19418h.findViewById(R.id.customer_iv_page_arrow_back);
        this.f19416f = this.f19418h.findViewById(R.id.customer_fl_address_back_container);
        this.f19417g = this.f19418h.findViewById(R.id.customer_fl_address_mask_container);
        this.f19419i = (CustomerAppCompatTextView) this.f19418h.findViewById(R.id.customer_custom_address_search);
    }

    /* renamed from: c */
    private void m14524c() {
        this.f19415e.setSpeed(2.0f);
        this.f19415e.playAnimation();
        this.f19420j.showOrHide(false, new SearchAddressComponent.OnSearchAnimationListener() {
            public final void onAnimationCompleted() {
                SelectAddressPage.this.m14525d();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m14525d() {
        this.f19411a.setVisibility(8);
    }
}
