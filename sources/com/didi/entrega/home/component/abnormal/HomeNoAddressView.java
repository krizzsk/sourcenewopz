package com.didi.entrega.home.component.abnormal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.LocalPermissionHelper;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.home.manager.HomeOtherOmegaHelper;
import com.didi.entrega.home.page.HomeCityListPage;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;

public class HomeNoAddressView extends RelativeLayout {
    @BindView(16952)
    TextView mAddressContentTv;
    @BindView(16953)
    RFMainButton mAddressSelectTv;
    @BindView(16954)
    TextView mAddressTitleTv;
    @BindView(16955)
    RFGhostButton mAddressUnSelectTv;

    public HomeNoAddressView(Context context) {
        super(context);
        m15084a(context);
    }

    public HomeNoAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15084a(context);
    }

    public HomeNoAddressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15084a(context);
    }

    public void showAbnormal() {
        final Context context = GlobalContext.getContext();
        setVisibility(0);
        boolean isGpsEnabled = CustomerSystemUtil.isGpsEnabled(getContext());
        final boolean hasLocationPermission = LocalPermissionHelper.hasLocationPermission();
        if (!isGpsEnabled || !hasLocationPermission) {
            m15086a(hasLocationPermission ? ResourceHelper.getString(R.string.FoodC_home1_Location_service_oExR) : ResourceHelper.getString(R.string.FoodC_home1_Location_is_dgIV));
            m15088b(ResourceHelper.getString(R.string.FoodC_home1_When_you_lFEJ, ResourceHelper.getString(R.string.entrega_app_name)));
            m15087a(ResourceHelper.getString(hasLocationPermission ? R.string.FoodC_home1_Open_Location_AGQt : R.string.FoodC_home1_Open_Location_pUxm), new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (hasLocationPermission) {
                        CustomerSystemUtil.openLocationSettingActivity(context);
                    } else {
                        LocalPermissionHelper.openPermissionSetting((Activity) GlobalContext.getContext());
                    }
                    HomeOtherOmegaHelper.trackExceptionCK(2);
                }
            });
            m15089b(context.getString(R.string.FoodC_home1_View_Service_AOdo), new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    HomeNoAddressView.this.m15083a();
                }
            });
            return;
        }
        m15086a(ResourceHelper.getString(R.string.FoodC_home1_Location_is_dgIV));
        m15088b(ResourceHelper.getString(R.string.FoodC_home1_When_you_lFEJ, ResourceHelper.getString(R.string.entrega_app_name)));
        m15087a(context.getString(R.string.FoodC_home1_View_Service_AOdo), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HomeNoAddressView.this.m15083a();
            }
        });
        m15089b("", (View.OnClickListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15083a() {
        HomeCityListPage.showPage();
    }

    /* renamed from: a */
    private void m15084a(Context context) {
        ButterKnife.bind((Object) this, inflate(context, R.layout.entrega_component_home_address_abnormal, this));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mAddressTitleTv, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mAddressContentTv, IToolsService.FontType.LIGHT);
    }

    /* renamed from: a */
    private void m15086a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mAddressTitleTv.setText(str);
            this.mAddressTitleTv.setVisibility(0);
            return;
        }
        this.mAddressTitleTv.setVisibility(8);
    }

    /* renamed from: b */
    private void m15088b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mAddressContentTv.setText(str);
            this.mAddressContentTv.setVisibility(0);
            return;
        }
        this.mAddressContentTv.setVisibility(8);
    }

    /* renamed from: a */
    private void m15087a(String str, View.OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(str)) {
            this.mAddressSelectTv.setText(str);
            this.mAddressSelectTv.setVisibility(0);
            this.mAddressSelectTv.setOnClickListener(onClickListener);
            return;
        }
        this.mAddressSelectTv.setVisibility(8);
    }

    /* renamed from: b */
    private void m15089b(String str, View.OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(str)) {
            this.mAddressUnSelectTv.setText(str);
            this.mAddressUnSelectTv.setVisibility(0);
            this.mAddressUnSelectTv.setOnClickListener(onClickListener);
            return;
        }
        this.mAddressUnSelectTv.setVisibility(4);
    }
}
