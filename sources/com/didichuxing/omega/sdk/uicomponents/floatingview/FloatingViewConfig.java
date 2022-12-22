package com.didichuxing.omega.sdk.uicomponents.floatingview;

public class FloatingViewConfig {
    public static IConfig iConfig;

    public interface IConfig {
        String getCancelItemText();

        String getCloseItemText();

        String getDialogCancel();

        String getDialogConfirm();

        String getDialogContent();
    }
}
