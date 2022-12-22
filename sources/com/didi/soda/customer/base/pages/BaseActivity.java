package com.didi.soda.customer.base.pages;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.foundation.sdk.service.LocaleService;

public class BaseActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocaleService.getInstance().attachBaseContext(context));
    }
}
