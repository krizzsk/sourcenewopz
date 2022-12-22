package com.didichuxing.mas.sdk.quality.report.analysis;

public class AnalysisDelegater {
    private static boolean appAtFront = false;
    private static String currentPageName = "";
    private static String fragmentName = "";

    public static void setFragmentName(String str) {
        fragmentName = str;
    }

    public static void setCurrentPageName(String str) {
        currentPageName = str;
    }

    public static void setAppAtFront(boolean z) {
        appAtFront = z;
    }

    public static String getCurrentFramentName() {
        return fragmentName;
    }

    public static String getCurrentPageName() {
        return currentPageName;
    }

    public static boolean isAppAtFront() {
        return appAtFront;
    }
}
