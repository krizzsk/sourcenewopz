package com.didi.rfusion.widget.tab;

import java.util.List;

/* renamed from: com.didi.rfusion.widget.tab.a */
/* compiled from: IRFTabBar */
interface C11568a {
    void selectTab(int i);

    void setData(List<String> list);

    void setOnTabFirstExposureListener(OnRFTabFirstExposureListener onRFTabFirstExposureListener);

    void setOnTabSelectedListener(OnRFTabSelectedListener onRFTabSelectedListener);

    void setTabBarAdapter(RFTabAdapter rFTabAdapter);

    void setTabBarSpec(int i);

    void showDividerLine(boolean z);
}
