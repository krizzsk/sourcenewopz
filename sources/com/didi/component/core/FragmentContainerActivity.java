package com.didi.component.core;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.core.util.CLog;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class FragmentContainerActivity extends FragmentActivity {
    public static final String FRAGMENT_CLASS = "fragment_class";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(FRAGMENT_CLASS);
            if (!TextUtils.isEmpty(stringExtra)) {
                CLog.m8708d("lmf className=" + stringExtra);
                try {
                    Fragment fragment = (Fragment) Class.forName(stringExtra).newInstance();
                    setContentView((int) R.layout.comp_fragment_container_layout);
                    fragment.setArguments(intent.getExtras());
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment, stringExtra).commitAllowingStateLoss();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (ClassNotFoundException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
