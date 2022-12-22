package com.didi.sdk.apm;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class ApmJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d("ApmJobService", "onStartJob:" + jobParameters.getJobId());
        Log.d("ApmJobService", "onStartJob end");
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        Log.d("ApmJobService", "onStopJob");
        return false;
    }
}
