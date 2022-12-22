package com.didi.map.sdk.sharetrack.external.view;

import android.view.View;
import com.didi.map.sdk.sharetrack.external.view.INavigationGuidanceView;

public interface INavCardView {
    View getRealView();

    void onETAEDAChanged(String str);

    void setDestinationText(String str);

    void setIsInNightModeForcible(boolean z);

    void setOnNavigationBtnClickListener(INavigationGuidanceView.INavigationBtnClickListener iNavigationBtnClickListener);
}
