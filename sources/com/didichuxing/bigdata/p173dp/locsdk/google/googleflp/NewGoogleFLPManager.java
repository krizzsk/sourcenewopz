package com.didichuxing.bigdata.p173dp.locsdk.google.googleflp;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.PermRetryApollo;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.LocNTPHelper;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.ThreadDispatcher;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.locator.IFLPLocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.locator.IFLPLocator;
import com.didichuxing.bigdata.p173dp.locsdk.trace.data.ETraceSource;
import com.didichuxing.bigdata.p173dp.locsdk.utils.LocExceptionTracker;
import com.didichuxing.bigdata.p173dp.locsdk.utils.MockLocationChecker;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.List;

@ServiceProvider({IFLPLocator.class})
/* renamed from: com.didichuxing.bigdata.dp.locsdk.google.googleflp.NewGoogleFLPManager */
public class NewGoogleFLPManager implements IFLPLocator {

    /* renamed from: a */
    private static final String f45765a = "NewGoogleFLPManager";

    /* renamed from: i */
    private static final long f45766i = 15000;

    /* renamed from: b */
    private Context f45767b;

    /* renamed from: c */
    private volatile DIDILocation f45768c;

    /* renamed from: d */
    private long f45769d;

    /* renamed from: e */
    private boolean f45770e = false;

    /* renamed from: f */
    private long f45771f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f45772g = false;

    /* renamed from: h */
    private long f45773h;

    /* renamed from: j */
    private IFLPLocationListener f45774j;

    /* renamed from: k */
    private LocationRequest f45775k;

    /* renamed from: l */
    private FusedLocationProviderClient f45776l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f45777m = 0;

    /* renamed from: n */
    private LocationCallback f45778n = new LocationCallback() {
        public void onLocationResult(LocationResult locationResult) {
            List<Location> locations = locationResult.getLocations();
            if (locations.size() > 0) {
                NewGoogleFLPManager.this.m32776a(locations.get(locations.size() - 1));
                NewGoogleFLPManager.m32773a(NewGoogleFLPManager.this);
                if (NewGoogleFLPManager.this.f45777m >= 10) {
                    int unused = NewGoogleFLPManager.this.f45777m = 0;
                    DLog.m32737d("NewGoogleFLPManager location arrived: google flp");
                }
            }
        }

        public void onLocationAvailability(LocationAvailability locationAvailability) {
            super.onLocationAvailability(locationAvailability);
            DLog.m32737d(" googleFlp available = " + locationAvailability.isLocationAvailable());
        }
    };

    /* renamed from: o */
    private long f45779o;

    /* renamed from: a */
    static /* synthetic */ int m32773a(NewGoogleFLPManager newGoogleFLPManager) {
        int i = newGoogleFLPManager.f45777m;
        newGoogleFLPManager.f45777m = i + 1;
        return i;
    }

    public void init(Context context, long j) {
        if (context != null) {
            this.f45767b = context;
            this.f45771f = j;
            this.f45770e = true;
            this.f45776l = LocationServices.getFusedLocationProviderClient(context);
            createLocationRequest(this.f45771f);
            m32775a();
        }
    }

    public void setLocationListener(IFLPLocationListener iFLPLocationListener) {
        this.f45774j = iFLPLocationListener;
    }

    /* renamed from: a */
    private void m32775a() {
        try {
            this.f45772g = false;
            this.f45776l.requestLocationUpdates(this.f45775k, this.f45778n, ThreadDispatcher.getWorkThread().getLooper()).addOnSuccessListener(new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    DLog.m32737d("NewGoogleFLPManager Google fusedLocation provider client success");
                }
            }).addOnCanceledListener(new OnCanceledListener() {
                public void onCanceled() {
                }
            }).addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(Task<Void> task) {
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    if (LocExceptionTracker.getInstance().enable()) {
                        if (exc instanceof SecurityException) {
                            LocExceptionTracker.getInstance().trackInnerException(1, "GMS_NoPerm");
                        } else if (!(exc instanceof ApiException) || ((ApiException) exc).getStatusCode() != 17) {
                            LocExceptionTracker instance = LocExceptionTracker.getInstance();
                            instance.trackInnerException(5, "GMS_" + exc.getClass().getCanonicalName());
                        } else {
                            LocExceptionTracker.getInstance().trackInnerException(3, "GMS_InvalidClientException");
                        }
                    }
                    if (PermRetryApollo.getInstance().shouldRetryLoc() && (exc instanceof SecurityException)) {
                        DLog.m32737d("NewGoogleFLPManager Security exception");
                        boolean unused = NewGoogleFLPManager.this.f45772g = true;
                    }
                    DLog.m32737d("NewGoogleFLPManager Google fusedLocation provider client failed: " + exc.getClass() + "," + exc.getCause() + "," + exc.getMessage() + "," + exc.getLocalizedMessage());
                }
            });
        } catch (SecurityException unused) {
            if (LocExceptionTracker.getInstance().enable()) {
                LocExceptionTracker.getInstance().trackInnerException(1, "GMS_NoPerm");
            }
            this.f45772g = true;
        } catch (Throwable th) {
            if (LocExceptionTracker.getInstance().enable()) {
                LocExceptionTracker instance = LocExceptionTracker.getInstance();
                instance.trackInnerException(5, "GMS_" + th.getClass().getCanonicalName());
            }
            this.f45772g = false;
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m32780b() {
        if (this.f45770e && this.f45772g && this.f45767b != null && SystemClock.elapsedRealtime() - this.f45773h > 15000) {
            DLog.m32737d("NewGoogleFLPManager retry loc google flp");
            this.f45773h = SystemClock.elapsedRealtime();
            if (Utils.isLocationPermissionGranted(this.f45767b)) {
                DLog.m32737d("NewGoogleFLPManager RESTART loc when permission granted");
                m32775a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public LocationRequest createLocationRequest(long j) {
        this.f45775k = new LocationRequest();
        long value = DIDILocationUpdateOption.IntervalMode.LOW_FREQUENCY.getValue();
        if (j >= value) {
            j = value;
        }
        this.f45775k.setInterval(j);
        this.f45775k.setFastestInterval(1000);
        this.f45775k.setPriority(100);
        return this.f45775k;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32776a(Location location) {
        if (Utils.locCorrect(location)) {
            if (DIDILocationManager.enableMockLocation || !MockLocationChecker.isMockLocation(this.f45767b, location, true)) {
                LocNTPHelper.adjustSystemLocationTimestamp(location);
                DIDILocation loadFromSystemLoc = DIDILocation.loadFromSystemLoc(location, ETraceSource.googleflp, Utils.getCoordinateType());
                IFLPLocationListener iFLPLocationListener = this.f45774j;
                if (iFLPLocationListener != null) {
                    iFLPLocationListener.onLocationChanged(loadFromSystemLoc);
                }
                this.f45768c = loadFromSystemLoc;
                this.f45769d = Utils.getTimeBoot();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f45779o > 15000) {
                    DLog.m32737d("callback gms location: " + location.getLongitude() + "," + location.getLatitude() + ", " + location.getSpeed() + ", " + location.getBearing());
                    this.f45779o = currentTimeMillis;
                }
            }
        }
    }

    public DIDILocation getFLPLocation() {
        if (!Utils.locCorrect(this.f45768c)) {
            this.f45768c = null;
        } else if (Utils.getTimeBoot() - this.f45769d > 20000) {
            this.f45768c = null;
        }
        if (this.f45768c == null) {
            m32780b();
        }
        return this.f45768c;
    }

    public void destroy() {
        FusedLocationProviderClient fusedLocationProviderClient = this.f45776l;
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.removeLocationUpdates(this.f45778n);
            this.f45776l = null;
        }
        this.f45769d = 0;
        this.f45768c = null;
        this.f45774j = null;
        this.f45771f = 0;
        this.f45770e = false;
    }
}
