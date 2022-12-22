package com.didi.soda.home.page.deleagteimp;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.component.error.ErrorHandleComponent;
import com.didi.soda.customer.component.login.LoginLogicComponent;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.map.MapLazyLoader;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.page.CustomerMainPageDelegate;
import com.didi.soda.home.policy.HomePolicyHelper;
import com.didi.soda.home.topgun.manager.HomePolicyUpdateRepo;
import com.didi.soda.home.topgun.manager.RpcLazyLoader;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.taxis99.R;

public class HolderMainPage extends CustomerMainPageDelegate {

    /* renamed from: a */
    private static final String f42716a = "HolderMainPage";

    /* renamed from: b */
    private HomePolicyHelper f42717b;

    /* renamed from: c */
    private FrameLayout f42718c;

    /* renamed from: d */
    private Subscription f42719d = null;

    public HolderMainPage(CustomerMainPageDelegate.CustomerPageCallback customerPageCallback) {
        super(customerPageCallback);
    }

    public boolean onHandleBack() {
        return super.onHandleBack();
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        this.f42718c = frameLayout;
        frameLayout.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_7_97_F5F5F7));
        this.f42718c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return this.f42718c;
    }

    public void onCreate(View view) {
        super.onCreate(view);
        m30161a();
        m30163b();
        getOwner().controller.addLifecycleListener(new HolderMainPageListener());
        MapLazyLoader.getLoader().loadMapNextIdle();
        RpcLazyLoader.getLoader().lazyRpc();
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        addComponent(new LoginLogicComponent(this.f42718c));
        addComponent(new ErrorHandleComponent(this.f42718c));
    }

    /* renamed from: a */
    private void m30161a() {
        this.f42717b = HomePolicyHelper.getInstance();
        this.f42719d = ((HomePolicyUpdateRepo) RepoFactory.getRepo(HomePolicyUpdateRepo.class)).subscribePolicyUpdateConfirmTime(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                HolderMainPage.this.m30162a((Long) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30162a(Long l) {
        HomePolicyHelper homePolicyHelper = this.f42717b;
        if (homePolicyHelper != null) {
            homePolicyHelper.savePolicyUpdateState();
        }
        Subscription subscription = this.f42719d;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    /* renamed from: b */
    private void m30163b() {
        HomeAddressEntity homeAddressEntity = (HomeAddressEntity) GsonUtil.fromJson(Uri.decode(getScopeContext().getBundle().getString("addressInfo")), HomeAddressEntity.class);
        if (homeAddressEntity != null && AddressUtil.checkAddressValid(homeAddressEntity.address)) {
            LogUtil.m29100d(f42716a, "updateAddress:" + homeAddressEntity.address);
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).setDeliveryAddress(homeAddressEntity.address, false, 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f42717b != null) {
            LogUtil.m29100d(f42716a, "mHomePolicyHelper-----resetPolicyConfig");
            this.f42717b.resetPolicyConfig();
        }
    }

    public void onPageChangeEnded() {
        super.onPageChangeEnded();
        HomePolicyHelper homePolicyHelper = this.f42717b;
        if (homePolicyHelper != null) {
            homePolicyHelper.updatePolicyConfig(GlobalContext.getPageInstrument().getDialogInstrument(), 2).needShowPolicyDialog();
        }
    }
}
