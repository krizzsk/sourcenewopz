package com.didi.sdk.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Map;

public class SuperAppBusinessContextHelper extends BusinessContextHelper {
    public SuperAppBusinessContextHelper(FragmentActivity fragmentActivity, ITitleBarDelegate iTitleBarDelegate, IStatusBarDelegate iStatusBarDelegate, IBizNavBarDelegate iBizNavBarDelegate, Class<? extends BaseBusinessContext> cls, int i, Map<Integer, Class<? extends Fragment>> map) {
        super(fragmentActivity, iTitleBarDelegate, iStatusBarDelegate, iBizNavBarDelegate, cls, i, map);
    }
}
