package com.didi.component.never.core;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

public interface IPageSwitcher {
    boolean forward(Intent intent);

    boolean forward(Class<? extends Fragment> cls, Bundle bundle);

    Fragment getHost();

    boolean goBack();

    boolean goBack(Bundle bundle);

    boolean goBackRoot();

    boolean goBackRoot(Bundle bundle);

    void startActivityForResult(Intent intent, int i, Bundle bundle);
}
