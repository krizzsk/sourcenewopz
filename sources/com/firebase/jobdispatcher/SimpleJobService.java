package com.firebase.jobdispatcher;

import android.os.AsyncTask;
import androidx.collection.SimpleArrayMap;

public abstract class SimpleJobService extends JobService {

    /* renamed from: c */
    private final SimpleArrayMap<JobParameters, AsyncJobTask> f52143c = new SimpleArrayMap<>();

    public abstract int onRunJob(JobParameters jobParameters);

    public boolean onStartJob(JobParameters jobParameters) {
        AsyncJobTask asyncJobTask = new AsyncJobTask(jobParameters);
        synchronized (this.f52143c) {
            this.f52143c.put(jobParameters, asyncJobTask);
        }
        asyncJobTask.execute(new Void[0]);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        synchronized (this.f52143c) {
            AsyncJobTask remove = this.f52143c.remove(jobParameters);
            if (remove == null) {
                return false;
            }
            remove.cancel(true);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m37212b(JobParameters jobParameters, boolean z) {
        synchronized (this.f52143c) {
            this.f52143c.remove(jobParameters);
        }
        jobFinished(jobParameters, z);
    }

    private static class AsyncJobTask extends AsyncTask<Void, Void, Integer> {
        private final JobParameters jobParameters;
        private final SimpleJobService jobService;

        private AsyncJobTask(SimpleJobService simpleJobService, JobParameters jobParameters2) {
            this.jobService = simpleJobService;
            this.jobParameters = jobParameters2;
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(Void... voidArr) {
            return Integer.valueOf(this.jobService.onRunJob(this.jobParameters));
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            SimpleJobService simpleJobService = this.jobService;
            JobParameters jobParameters2 = this.jobParameters;
            boolean z = true;
            if (num.intValue() != 1) {
                z = false;
            }
            simpleJobService.m37212b(jobParameters2, z);
        }
    }
}
