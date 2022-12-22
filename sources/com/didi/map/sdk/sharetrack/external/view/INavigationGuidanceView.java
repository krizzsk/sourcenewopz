package com.didi.map.sdk.sharetrack.external.view;

public interface INavigationGuidanceView {

    public interface INavigationBtnClickListener {
        void onNavigationBtnClicked();
    }

    void setDestinationText(String str);

    void setEDAETAText(String str);

    void setIsInNightModeForcible(boolean z);

    void setOnNavigationBtnClickListener(INavigationBtnClickListener iNavigationBtnClickListener);
}
