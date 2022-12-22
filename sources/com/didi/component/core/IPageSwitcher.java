package com.didi.component.core;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.sdk.app.BusinessContext;

public interface IPageSwitcher {
    boolean forward(Intent intent);

    boolean forward(Intent intent, Animations animations);

    boolean forward(Class<? extends Fragment> cls, Bundle bundle);

    boolean forward(Class<? extends Fragment> cls, Bundle bundle, Animations animations);

    Fragment getHost();

    boolean goBack();

    boolean goBack(Bundle bundle);

    boolean goBackRoot();

    boolean goBackRoot(Bundle bundle);

    void startActivityForResult(Intent intent, int i, Bundle bundle);

    void updateBusinessContext(BusinessContext businessContext);
}
