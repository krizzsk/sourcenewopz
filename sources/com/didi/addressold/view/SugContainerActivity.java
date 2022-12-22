package com.didi.addressold.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.address.AddressException;
import com.didi.address.AddressResult;
import com.didi.address.GlobalSugCallback;
import com.didi.address.TransparentStatusBarManager;
import com.didi.address.model.SugMapConstants;
import com.didi.address.model.SugParams;
import com.didi.addressold.DidiAddressApiFactory;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class SugContainerActivity extends AppCompatActivity {

    /* renamed from: a */
    static final String f7919a = "result";

    public static Intent getIntent(Context context, SugParams sugParams) {
        Intent intent = new Intent(context, SugContainerActivity.class);
        intent.putExtra(SugMapConstants.EXTRA_ADDRESS_PARAM, sugParams);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        TransparentStatusBarManager.OnStatusBarTransparentListener onStatusBarTransparentListener = TransparentStatusBarManager.getInstance().getOnStatusBarTransparentListener();
        if (onStatusBarTransparentListener != null) {
            onStatusBarTransparentListener.OnStartusBarTransparent(this);
        }
        super.onCreate(bundle);
        setContentView((int) R.layout.old_activity_sug_container);
        if (getIntent() != null) {
            m5105a((SugParams) getIntent().getSerializableExtra(SugMapConstants.EXTRA_ADDRESS_PARAM));
        }
    }

    /* renamed from: a */
    private void m5105a(SugParams sugParams) {
        try {
            DidiAddressApiFactory.createDidiAddress(this).selectAddress((Activity) this, (int) R.id.container, sugParams, (GlobalSugCallback) new GlobalSugCallback() {
                public void onAttach(int i) {
                }

                public void onCloseButtonClick() {
                }

                public void onDetach(int i) {
                }

                public boolean onCloseButtonIntercept() {
                    SugContainerActivity.this.onBackPressed();
                    return true;
                }

                public void setResult(AddressResult addressResult) {
                    SugContainerActivity.this.m5104a(addressResult);
                }
            });
        } catch (AddressException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5104a(AddressResult addressResult) {
        if (addressResult == null) {
            onBackPressed();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("result", addressResult);
        setResult(-1, intent);
        finish();
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }
}
