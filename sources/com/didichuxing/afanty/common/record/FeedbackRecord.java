package com.didichuxing.afanty.common.record;

public class FeedbackRecord extends ChanceRecord {
    public void setFeedbackType(String str) {
        put("ft", str);
    }

    public void setFeedbackContent(String str) {
        put("fc", str);
    }

    public void setFeatureTeam(int i) {
        put("feature", Integer.valueOf(i));
    }
}
