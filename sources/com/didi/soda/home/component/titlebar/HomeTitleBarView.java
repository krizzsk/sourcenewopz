package com.didi.soda.home.component.titlebar;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.home.component.titlebar.Contract;
import com.taxis99.R;

public class HomeTitleBarView extends Contract.AbsTitleBarView {
    @BindView(17914)
    IconTextView mAddressArrow;
    @BindView(23788)
    TextView mAddressTv;

    public void updateAddress(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mAddressTv.setText(str);
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.component_home_titlebar_layout, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.mAddressTv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsTitleBarPresenter) HomeTitleBarView.this.getPresenter()).onAddressClick();
            }
        });
        this.mAddressArrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsTitleBarPresenter) HomeTitleBarView.this.getPresenter()).onAddressClick();
            }
        });
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mAddressTv, IToolsService.FontType.LIGHT);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mAddressTv.setOnClickListener((View.OnClickListener) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }
}
