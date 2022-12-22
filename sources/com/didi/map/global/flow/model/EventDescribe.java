package com.didi.map.global.flow.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface EventDescribe {
    public static final String BubblePageTips = "Bubble_Page_Tips";
    public static final String DriverLowVersion = "Driver_Low_Version";
    public static final String DriverUseExternalNavigation = "Driver_Use_External_Navigation";
    public static final String FollowYourLine = "Follow_Your_Line";
    public static final String GoingOffCourse = "Going_Off_Course";
    public static final String RecommendPickupDismissTips = "Recommend_Pickup_Dismiss_Tips";
    public static final String RevenueTips = "Revenue_Tips";

    @Retention(RetentionPolicy.SOURCE)
    public @interface EventType {
    }
}
