package com.didichuxing.omega.sdk.analysis;

public class AnalysisDelegater {
    private static boolean appIn = false;
    private static String currentPageName = "";
    private static String fragmentName = "";

    public static void setFragmentName(String str) {
        fragmentName = str;
    }

    public static void setCurrentPageName(String str) {
        currentPageName = str;
    }

    public static void setAppIn(boolean z) {
        appIn = z;
    }

    public static String getCurrentFramentName() {
        return fragmentName;
    }

    public static String getCurrentPageName() {
        return currentPageName;
    }

    public static boolean isAppIn() {
        return appIn;
    }
}
