package com.didi.entrega.home.component.noservice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;

public class HomeNoServiceView extends IView<HomeNoServicePresenter> {
    @BindView(16956)
    CustomerAppCompatTextView mContent;
    @BindView(16958)
    RFMainButton mSelectCityButton;
    @BindView(16957)
    CustomerAppCompatTextView mTitle;

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ButterKnife.bind((Object) this, getView());
        this.mTitle.setText(ResourceHelper.getString(R.string.FoodC_home1_Flashless_services_Wbuv, ResourceHelper.getString(R.string.entrega_app_name)));
        this.mContent.setText(ResourceHelper.getString(R.string.FoodC_home1_Flash_service_VWDw, ResourceHelper.getString(R.string.entrega_app_name)));
        this.mSelectCityButton.setOnClickListener($$Lambda$HomeNoServiceView$4ewqgBQhouUFDMs_95G077OG5Q0.INSTANCE);
        getView().setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.entrega_component_home_no_service, viewGroup);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61812a(boolean z) {
        if (z) {
            getView().setVisibility(0);
        } else {
            getView().setVisibility(8);
        }
    }
}
