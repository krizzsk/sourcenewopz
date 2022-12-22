package com.firebase.jobdispatcher;

import android.os.Bundle;

public interface JobParameters {
    int[] getConstraints();

    Bundle getExtras();

    int getLifetime();

    RetryStrategy getRetryStrategy();

    String getService();

    String getTag();

    JobTrigger getTrigger();

    TriggerReason getTriggerReason();

    boolean isRecurring();

    boolean shouldReplaceCurrent();
}
