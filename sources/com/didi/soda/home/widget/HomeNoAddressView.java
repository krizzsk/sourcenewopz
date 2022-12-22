package com.didi.soda.home.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LocalPermissionHelper;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.helper.CustomerLocationSettingHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;

public class HomeNoAddressView extends RelativeLayout {
    @BindView(18964)
    TextView mAddressContentTv;
    @BindView(18966)
    RFMainButton mAddressSelectTv;
    @BindView(18967)
    TextView mAddressTitleTv;
    @BindView(18968)
    RFGhostButton mAddressUnSelectTv;

    public HomeNoAddressView(Context context) {
        super(context);
        m30613a(context);
    }

    public HomeNoAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30613a(context);
    }

    public HomeNoAddressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30613a(context);
    }

    public void showAbnormal(final boolean z) {
        Context context = GlobalContext.getContext();
        setVisibility(0);
        boolean a = m30616a();
        final boolean b = m30620b();
        if (!a || !b) {
            m30614a(b ? ResourceHelper.getString(R.string.FoodC_positioning_Position_get_BmzZ) : ResourceHelper.getString(R.string.FoodC_positioning_Position_open_Oadv));
            m30618b(ResourceHelper.getString(R.string.FoodC_positioning_Position_set_wmRd));
            m30615a(ResourceHelper.getString(R.string.FoodC_positioning_Permission_open_evWq), new View.OnClickListener() {
                public void onClick(View view) {
                    if (b) {
                        CustomerLocationSettingHelper.Companion.getInstance().startLocationSettingRequest((Activity) GlobalContext.getContext(), 4, (CustomerLocationSettingHelper.ILocationSettingRequestCallback) null);
                    } else {
                        LocalPermissionHelper.openPermissionSetting((Activity) GlobalContext.getContext());
                    }
                    HomeOmegaHelper.getInstance().locationSettingCk(z, HomeNoAddressView.this.m30620b(), HomeNoAddressView.this.m30616a(), false);
                }
            });
            m30619b(context.getString(R.string.FoodC_positioning_Enter_delivery_RAVy), new View.OnClickListener() {
                public void onClick(View view) {
                    DiRouter.request().path(RoutePath.ADDRESS_HOME).putInt("from", 6).open();
                    HomeOmegaHelper.getInstance().locationSettingCk(z, HomeNoAddressView.this.m30620b(), HomeNoAddressView.this.m30616a(), true);
                }
            });
            return;
        }
        m30614a(context.getString(R.string.FoodC_positioning_Position_get_BmzZ));
        m30618b(context.getString(R.string.FoodC_positioning_No_way_QBoI));
        m30615a(context.getString(R.string.FoodC_positioning_Enter_delivery_RAVy), new View.OnClickListener() {
            public void onClick(View view) {
                DiRouter.request().path(RoutePath.ADDRESS_HOME).putInt("from", 6).open();
                HomeOmegaHelper.getInstance().locationSettingCk(z, HomeNoAddressView.this.m30620b(), HomeNoAddressView.this.m30616a(), true);
            }
        });
        m30619b((String) null, (View.OnClickListener) null);
    }

    /* renamed from: a */
    private void m30613a(Context context) {
        ButterKnife.bind((Object) this, inflate(context, R.layout.customer_component_home_address, this));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mAddressTitleTv, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mAddressContentTv, IToolsService.FontType.LIGHT);
    }

    /* renamed from: a */
    private void m30614a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mAddressTitleTv.setText(str);
            this.mAddressTitleTv.setVisibility(0);
            return;
        }
        this.mAddressTitleTv.setVisibility(8);
    }

    /* renamed from: b */
    private void m30618b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mAddressContentTv.setText(str);
            this.mAddressContentTv.setVisibility(0);
            return;
        }
        this.mAddressContentTv.setVisibility(8);
    }

    /* renamed from: a */
    private void m30615a(String str, View.OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(str)) {
            this.mAddressSelectTv.setText(str);
            this.mAddressSelectTv.setVisibility(0);
            this.mAddressSelectTv.setOnClickListener(onClickListener);
            return;
        }
        this.mAddressSelectTv.setVisibility(8);
    }

    /* renamed from: b */
    private void m30619b(String str, View.OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(str)) {
            this.mAddressUnSelectTv.setText(str);
            this.mAddressUnSelectTv.setVisibility(0);
            this.mAddressUnSelectTv.setOnClickListener(onClickListener);
            return;
        }
        this.mAddressUnSelectTv.setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m30616a() {
        return CustomerSystemUtil.isGpsEnabled(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m30620b() {
        return LocalPermissionHelper.checkoutPermission((Activity) GlobalContext.getContext(), LocalPermissionHelper.LOCATION_PERMISSIONS);
    }
}
