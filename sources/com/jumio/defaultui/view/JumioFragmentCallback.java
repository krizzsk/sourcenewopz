package com.jumio.defaultui.view;

import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.defaultui.view.LoadingView;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0004H&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0014H&J\b\u0010\u0019\u001a\u00020\u0012H&¨\u0006\u001a"}, mo175978d2 = {"Lcom/jumio/defaultui/view/JumioFragmentCallback;", "", "Lcom/jumio/commons/utils/DeviceRotationManager;", "getRotationManager", "", "startUserJourney", "startCountrySelection", "countrySelected", "retakeImage", "skipAddonPart", "Lcom/jumio/defaultui/view/LoadingView$State;", "loadingState", "updateLoadingState", "hideLoading", "announceAccessibilityFragmentTitle", "", "automationString", "setUiAutomationString", "", "isRunningTest", "", "resourceId", "setActionBarQuitIcon", "color", "setBackgroundColor", "validatePermissions", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioFragmentCallback.kt */
public interface JumioFragmentCallback {
    void announceAccessibilityFragmentTitle();

    void countrySelected();

    DeviceRotationManager getRotationManager();

    void hideLoading();

    boolean isRunningTest();

    void retakeImage();

    void setActionBarQuitIcon(int i);

    void setBackgroundColor(int i);

    void setUiAutomationString(String str);

    void skipAddonPart();

    void startCountrySelection();

    void startUserJourney();

    void updateLoadingState(LoadingView.State state);

    boolean validatePermissions();
}
