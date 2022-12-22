package com.didichuxing.diface.biz.bioassay.fpp;

import android.os.AsyncTask;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import java.lang.ref.WeakReference;

/* renamed from: com.didichuxing.diface.biz.bioassay.fpp.a */
/* compiled from: OpenCameraTask */
class C15441a extends AsyncTask<Void, Void, Integer> {

    /* renamed from: a */
    private final WeakReference<DiFaceFppBioassayActivity> f47228a;

    C15441a(DiFaceFppBioassayActivity diFaceFppBioassayActivity) {
        this.f47228a = new WeakReference<>(diFaceFppBioassayActivity);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        DiFaceBaseActivity diFaceBaseActivity = (DiFaceBaseActivity) this.f47228a.get();
        if (diFaceBaseActivity != null) {
            diFaceBaseActivity.showProgress();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Integer doInBackground(Void... voidArr) {
        DiFaceFppBioassayActivity diFaceFppBioassayActivity = (DiFaceFppBioassayActivity) this.f47228a.get();
        if (diFaceFppBioassayActivity == null) {
            return -1;
        }
        return Integer.valueOf(diFaceFppBioassayActivity.mo116206a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        DiFaceFppBioassayActivity diFaceFppBioassayActivity = (DiFaceFppBioassayActivity) this.f47228a.get();
        if (diFaceFppBioassayActivity != null) {
            diFaceFppBioassayActivity.hideProgress();
            diFaceFppBioassayActivity.mo116207a(num.intValue());
        }
    }
}
