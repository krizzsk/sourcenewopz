package com.didi.app.nova.skeleton.conductor.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didi.app.nova.skeleton.conductor.ActivityHostedRouter;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.Router;
import com.didi.app.nova.skeleton.conductor.embed.FragmentLifecycle;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didichuxing.sofa.permission.PermissionHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentLifecycleHandler implements Application.ActivityLifecycleCallbacks, FragmentLifecycle {

    /* renamed from: a */
    private static final String f8386a = "FragmentLifecycleHandler";

    /* renamed from: b */
    private static final String f8387b = "LifecycleHandler.pendingPermissionRequests";

    /* renamed from: c */
    private static final String f8388c = "LifecycleHandler.permissionRequests";

    /* renamed from: d */
    private static final String f8389d = "LifecycleHandler.activityRequests";

    /* renamed from: e */
    private static final String f8390e = "LifecycleHandler.routerState";

    /* renamed from: j */
    private static final Map<Fragment, FragmentLifecycleHandler> f8391j = new HashMap();

    /* renamed from: f */
    private Activity f8392f;

    /* renamed from: g */
    private boolean f8393g;

    /* renamed from: h */
    private boolean f8394h;

    /* renamed from: i */
    private boolean f8395i;

    /* renamed from: k */
    private SparseArray<String> f8396k = new SparseArray<>();

    /* renamed from: l */
    private SparseArray<String> f8397l = new SparseArray<>();

    /* renamed from: m */
    private ArrayList<PendingPermissionRequest> f8398m = new ArrayList<>();

    /* renamed from: n */
    private final Map<Integer, ActivityHostedRouter> f8399n = new HashMap();

    /* renamed from: o */
    private Fragment f8400o;

    /* renamed from: p */
    private C3722a f8401p;

    public FragmentLifecycleHandler(Fragment fragment) {
        this.f8400o = fragment;
        fragment.setRetainInstance(true);
        this.f8400o.setHasOptionsMenu(true);
    }

    public static FragmentLifecycle install(Fragment fragment) {
        FragmentLifecycleHandler fragmentLifecycleHandler = f8391j.get(fragment);
        if (fragmentLifecycleHandler == null) {
            fragmentLifecycleHandler = new FragmentLifecycleHandler(fragment);
            fragmentLifecycleHandler.f8392f = fragment.getActivity();
            fragmentLifecycleHandler.f8401p = new C3722a(fragmentLifecycleHandler);
            fragment.getFragmentManager().registerFragmentLifecycleCallbacks(fragmentLifecycleHandler.f8401p, false);
            f8391j.put(fragment, fragmentLifecycleHandler);
        }
        TraceUtil.trace(f8386a, "install(" + fragment + ")");
        return fragmentLifecycleHandler;
    }

    public static Router getFragmentRouter(Fragment fragment, ViewGroup viewGroup, Bundle bundle) {
        FragmentLifecycleHandler fragmentLifecycleHandler = f8391j.get(fragment);
        if (fragmentLifecycleHandler == null) {
            return null;
        }
        return fragmentLifecycleHandler.getRouter(viewGroup, bundle);
    }

    public Router getRouter(ViewGroup viewGroup, Bundle bundle) {
        ActivityHostedRouter activityHostedRouter = this.f8399n.get(Integer.valueOf(m5594a(viewGroup)));
        if (activityHostedRouter == null) {
            activityHostedRouter = new ActivityHostedRouter();
            activityHostedRouter.setHost(this, viewGroup);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle(f8390e + activityHostedRouter.getContainerId());
                if (bundle2 != null) {
                    activityHostedRouter.restoreInstanceState(bundle2);
                }
            }
            this.f8399n.put(Integer.valueOf(m5594a(viewGroup)), activityHostedRouter);
        } else {
            activityHostedRouter.setHost(this, viewGroup);
        }
        return activityHostedRouter;
    }

    public List<Router> getRouters() {
        return new ArrayList(this.f8399n.values());
    }

    public Activity getLifecycleActivity() {
        return this.f8392f;
    }

    /* renamed from: a */
    private static int m5594a(ViewGroup viewGroup) {
        return viewGroup.getId();
    }

    public boolean registerActivityListener(Activity activity) {
        this.f8392f = activity;
        if (this.f8393g) {
            return false;
        }
        this.f8393g = true;
        activity.getApplication().registerActivityLifecycleCallbacks(this);
        return true;
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            StringSparseArrayParceler stringSparseArrayParceler = (StringSparseArrayParceler) bundle.getParcelable(f8388c);
            this.f8396k = stringSparseArrayParceler != null ? stringSparseArrayParceler.getStringSparseArray() : new SparseArray<>();
            StringSparseArrayParceler stringSparseArrayParceler2 = (StringSparseArrayParceler) bundle.getParcelable(f8389d);
            this.f8397l = stringSparseArrayParceler2 != null ? stringSparseArrayParceler2.getStringSparseArray() : new SparseArray<>();
            ArrayList<PendingPermissionRequest> parcelableArrayList = bundle.getParcelableArrayList(f8387b);
            if (parcelableArrayList == null) {
                parcelableArrayList = new ArrayList<>();
            }
            this.f8398m = parcelableArrayList;
        }
        TraceUtil.trace(f8386a, NachoLifecycleManager.LIFECYCLE_ON_CREATE);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(f8388c, new StringSparseArrayParceler(this.f8396k));
        bundle.putParcelable(f8389d, new StringSparseArrayParceler(this.f8397l));
        bundle.putParcelableArrayList(f8387b, this.f8398m);
        TraceUtil.trace(f8386a, "onSaveInstanceState");
    }

    public void onDestroy() {
        Activity activity = this.f8392f;
        if (activity != null) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            m5596b();
            this.f8392f = null;
        }
        TraceUtil.trace(f8386a, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
    }

    public void onAttach(Context context) {
        this.f8394h = false;
        m5595a();
        TraceUtil.trace(f8386a, "onAttach");
    }

    public void onDetach() {
        this.f8395i = false;
        m5596b();
        getFragmentManager().unregisterFragmentLifecycleCallbacks(this.f8401p);
        f8391j.remove(this.f8400o);
        TraceUtil.trace(f8386a, "onDetach");
    }

    /* renamed from: a */
    private void m5595a() {
        if (!this.f8395i) {
            this.f8395i = true;
            for (int size = this.f8398m.size() - 1; size >= 0; size--) {
                PendingPermissionRequest remove = this.f8398m.remove(size);
                requestPermissions(remove.instanceId, remove.permissions);
            }
        }
        for (ActivityHostedRouter onContextAvailable : this.f8399n.values()) {
            onContextAvailable.onContextAvailable();
        }
    }

    /* renamed from: b */
    private void m5596b() {
        if (!this.f8394h) {
            this.f8394h = true;
            if (this.f8392f != null) {
                for (ActivityHostedRouter onActivityDestroyed : this.f8399n.values()) {
                    onActivityDestroyed.onActivityDestroyed(this.f8392f);
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String str = this.f8397l.get(i);
        if (str != null) {
            for (ActivityHostedRouter onActivityResult : this.f8399n.values()) {
                onActivityResult.onActivityResult(str, i, i2, intent);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        String str = this.f8396k.get(i);
        if (str != null) {
            for (ActivityHostedRouter controllerWithInstanceId : this.f8399n.values()) {
                Controller controllerWithInstanceId2 = controllerWithInstanceId.getControllerWithInstanceId(str);
                if (controllerWithInstanceId2 != null) {
                    PermissionHelper.onRequestPermissionsResult(this.f8400o, (Object) controllerWithInstanceId2, i, strArr, iArr);
                }
            }
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        for (ActivityHostedRouter handleRequestedPermission : this.f8399n.values()) {
            Boolean handleRequestedPermission2 = handleRequestedPermission.handleRequestedPermission(str);
            if (handleRequestedPermission2 != null) {
                return handleRequestedPermission2.booleanValue();
            }
        }
        return false;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        for (ActivityHostedRouter onCreateOptionsMenu : this.f8399n.values()) {
            onCreateOptionsMenu.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        for (ActivityHostedRouter onPrepareOptionsMenu : this.f8399n.values()) {
            onPrepareOptionsMenu.onPrepareOptionsMenu(menu);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        for (ActivityHostedRouter onOptionsItemSelected : this.f8399n.values()) {
            if (onOptionsItemSelected.onOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void registerForActivityResult(String str, int i) {
        this.f8397l.put(i, str);
    }

    public void unregisterForActivityResults(String str) {
        for (int size = this.f8397l.size() - 1; size >= 0; size--) {
            SparseArray<String> sparseArray = this.f8397l;
            if (str.equals(sparseArray.get(sparseArray.keyAt(size)))) {
                this.f8397l.removeAt(size);
            }
        }
    }

    public void startActivityForResult(String str, Intent intent, int i) {
        registerForActivityResult(str, i);
        this.f8400o.startActivityForResult(intent, i);
    }

    public void startActivityForResult(String str, Intent intent, int i, Bundle bundle) {
        registerForActivityResult(str, i);
        this.f8400o.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(String str, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        String str2 = str;
        registerForActivityResult(str, i);
        this.f8400o.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void requestPermissions(String str, String[] strArr) {
        int generateRequestCode = PermissionHelper.generateRequestCode(strArr);
        if (this.f8395i) {
            this.f8396k.put(generateRequestCode, str);
            for (ActivityHostedRouter controllerWithInstanceId : this.f8399n.values()) {
                Controller controllerWithInstanceId2 = controllerWithInstanceId.getControllerWithInstanceId(str);
                if (controllerWithInstanceId2 != null) {
                    PermissionHelper.requestPermission(this.f8400o, (Object) controllerWithInstanceId2, strArr);
                }
            }
            return;
        }
        this.f8398m.add(new PendingPermissionRequest(str, strArr, generateRequestCode));
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f8392f == null) {
            this.f8392f = activity;
            for (ActivityHostedRouter onContextAvailable : this.f8399n.values()) {
                onContextAvailable.onContextAvailable();
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        if (this.f8392f == activity) {
            for (ActivityHostedRouter onActivityStarted : this.f8399n.values()) {
                onActivityStarted.onActivityStarted(activity);
            }
        }
    }

    public void onActivityResumed(Activity activity) {
        if (this.f8392f == activity) {
            for (ActivityHostedRouter onActivityResumed : this.f8399n.values()) {
                onActivityResumed.onActivityResumed(activity);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        if (this.f8392f == activity) {
            for (ActivityHostedRouter onActivityPaused : this.f8399n.values()) {
                onActivityPaused.onActivityPaused(activity);
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        if (this.f8392f == activity) {
            for (ActivityHostedRouter onActivityStopped : this.f8399n.values()) {
                onActivityStopped.onActivityStopped(activity);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (this.f8392f == activity) {
            for (Router next : this.f8399n.values()) {
                Bundle bundle2 = new Bundle();
                next.saveInstanceState(bundle2);
                bundle.putBundle(f8390e + next.getContainerId(), bundle2);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity == this.f8392f) {
            f8391j.remove(this);
        }
    }

    public void startActivity(Intent intent) {
        this.f8400o.startActivity(intent);
    }

    public FragmentManager getFragmentManager() {
        return this.f8400o.getFragmentManager();
    }

    public Fragment getAttachedFragment() {
        return this.f8400o;
    }

    private static class PendingPermissionRequest implements Parcelable {
        public static final Parcelable.Creator<PendingPermissionRequest> CREATOR = new Parcelable.Creator<PendingPermissionRequest>() {
            public PendingPermissionRequest createFromParcel(Parcel parcel) {
                return new PendingPermissionRequest(parcel);
            }

            public PendingPermissionRequest[] newArray(int i) {
                return new PendingPermissionRequest[i];
            }
        };
        final String instanceId;
        final String[] permissions;
        final int requestCode;

        public int describeContents() {
            return 0;
        }

        PendingPermissionRequest(String str, String[] strArr, int i) {
            this.instanceId = str;
            this.permissions = strArr;
            this.requestCode = i;
        }

        private PendingPermissionRequest(Parcel parcel) {
            this.instanceId = parcel.readString();
            this.permissions = parcel.createStringArray();
            this.requestCode = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.instanceId);
            parcel.writeStringArray(this.permissions);
            parcel.writeInt(this.requestCode);
        }
    }
}
