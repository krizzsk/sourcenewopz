package com.didi.soda.home.topgun.manager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;

public class HomeUpdateHeaderInfoHelper {
    public static void updateAddressInfo(TextView textView, ScopeContext scopeContext, int i) {
        Context context = textView.getContext();
        String string = context.getResources().getString(R.string.customer_global_home_deliver_to_loading);
        String string2 = context.getResources().getString(R.string.customer_address_load_none);
        textView.setText(string);
        textView.setClickable(false);
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddress(scopeContext, new Action1(textView, string2) {
            public final /* synthetic */ TextView f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void call(Object obj) {
                HomeUpdateHeaderInfoHelper.m30430a(this.f$0, this.f$1, (AddressEntity) obj);
            }
        });
        textView.setOnClickListener(new View.OnClickListener(i) {
            public final /* synthetic */ int f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                HomeUpdateHeaderInfoHelper.m30429a(this.f$0, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m30430a(TextView textView, String str, AddressEntity addressEntity) {
        textView.setClickable(true);
        if (AddressUtil.checkAddressValid(addressEntity)) {
            textView.setText(addressEntity.poi.displayName);
        } else {
            textView.setText(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m30429a(int i, View view) {
        int i2;
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).clearAddressTip();
        if (i == 0) {
            HomeOmegaHelper.getInstance().headerAddressClick();
            i2 = 2;
        } else {
            TopicActOmegaHelper.Companion.getInstance().trackAddressClick();
            i2 = 10;
        }
        DiRouter.request().path(RoutePath.ADDRESS_HOME).putInt("from", i2).open();
        HomeLogTrackerHelper.setLogTracker("onAddressClick", "c-act|");
    }
}
