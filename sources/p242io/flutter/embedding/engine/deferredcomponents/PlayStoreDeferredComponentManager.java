package p242io.flutter.embedding.engine.deferredcomponents;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.didi.sdk.apm.SystemUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.FlutterJNI;
import p242io.flutter.embedding.engine.loader.ApplicationInfoLoader;
import p242io.flutter.embedding.engine.loader.FlutterApplicationInfo;
import p242io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;

/* renamed from: io.flutter.embedding.engine.deferredcomponents.PlayStoreDeferredComponentManager */
public class PlayStoreDeferredComponentManager implements DeferredComponentManager {
    public static final String MAPPING_KEY = (DeferredComponentManager.class.getName() + ".loadingUnitMapping");

    /* renamed from: a */
    private static final String f57622a = "PlayStoreDeferredComponentManager";

    /* renamed from: b */
    private SplitInstallManager f57623b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FlutterJNI f57624c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DeferredComponentChannel f57625d;

    /* renamed from: e */
    private Context f57626e;

    /* renamed from: f */
    private FlutterApplicationInfo f57627f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SparseArray<String> f57628g = new SparseArray<>();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SparseIntArray f57629h = new SparseIntArray();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SparseArray<String> f57630i = new SparseArray<>();

    /* renamed from: j */
    private Map<String, Integer> f57631j = new HashMap();

    /* renamed from: k */
    private FeatureInstallStateUpdatedListener f57632k;
    protected SparseArray<String> loadingUnitIdToComponentNames = new SparseArray<>();
    protected SparseArray<String> loadingUnitIdToSharedLibraryNames = new SparseArray<>();

    /* renamed from: io.flutter.embedding.engine.deferredcomponents.PlayStoreDeferredComponentManager$FeatureInstallStateUpdatedListener */
    private class FeatureInstallStateUpdatedListener implements SplitInstallStateUpdatedListener {
        private FeatureInstallStateUpdatedListener() {
        }

        public void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
            int sessionId = splitInstallSessionState.sessionId();
            if (PlayStoreDeferredComponentManager.this.f57628g.get(sessionId) != null) {
                switch (splitInstallSessionState.status()) {
                    case 1:
                        Log.m41134d(PlayStoreDeferredComponentManager.f57622a, String.format("Module \"%s\" (sessionId %d) install pending.", new Object[]{PlayStoreDeferredComponentManager.this.f57628g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f57630i.put(sessionId, "pending");
                        return;
                    case 2:
                        Log.m41134d(PlayStoreDeferredComponentManager.f57622a, String.format("Module \"%s\" (sessionId %d) downloading.", new Object[]{PlayStoreDeferredComponentManager.this.f57628g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f57630i.put(sessionId, "downloading");
                        return;
                    case 3:
                        Log.m41134d(PlayStoreDeferredComponentManager.f57622a, String.format("Module \"%s\" (sessionId %d) downloaded.", new Object[]{PlayStoreDeferredComponentManager.this.f57628g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f57630i.put(sessionId, "downloaded");
                        return;
                    case 4:
                        Log.m41134d(PlayStoreDeferredComponentManager.f57622a, String.format("Module \"%s\" (sessionId %d) installing.", new Object[]{PlayStoreDeferredComponentManager.this.f57628g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f57630i.put(sessionId, "installing");
                        return;
                    case 5:
                        Log.m41134d(PlayStoreDeferredComponentManager.f57622a, String.format("Module \"%s\" (sessionId %d) install successfully.", new Object[]{PlayStoreDeferredComponentManager.this.f57628g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager playStoreDeferredComponentManager = PlayStoreDeferredComponentManager.this;
                        playStoreDeferredComponentManager.loadAssets(playStoreDeferredComponentManager.f57629h.get(sessionId), (String) PlayStoreDeferredComponentManager.this.f57628g.get(sessionId));
                        if (PlayStoreDeferredComponentManager.this.f57629h.get(sessionId) > 0) {
                            PlayStoreDeferredComponentManager playStoreDeferredComponentManager2 = PlayStoreDeferredComponentManager.this;
                            playStoreDeferredComponentManager2.loadDartLibrary(playStoreDeferredComponentManager2.f57629h.get(sessionId), (String) PlayStoreDeferredComponentManager.this.f57628g.get(sessionId));
                        }
                        if (PlayStoreDeferredComponentManager.this.f57625d != null) {
                            PlayStoreDeferredComponentManager.this.f57625d.completeInstallSuccess((String) PlayStoreDeferredComponentManager.this.f57628g.get(sessionId));
                        }
                        PlayStoreDeferredComponentManager.this.f57628g.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f57629h.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f57630i.put(sessionId, "installed");
                        return;
                    case 6:
                        Log.m41136e(PlayStoreDeferredComponentManager.f57622a, String.format("Module \"%s\" (sessionId %d) install failed with: %s", new Object[]{PlayStoreDeferredComponentManager.this.f57628g.get(sessionId), Integer.valueOf(sessionId), Integer.valueOf(splitInstallSessionState.errorCode())}));
                        FlutterJNI c = PlayStoreDeferredComponentManager.this.f57624c;
                        int i = PlayStoreDeferredComponentManager.this.f57629h.get(sessionId);
                        c.deferredComponentInstallFailure(i, "Module install failed with " + splitInstallSessionState.errorCode(), true);
                        if (PlayStoreDeferredComponentManager.this.f57625d != null) {
                            PlayStoreDeferredComponentManager.this.f57625d.completeInstallError((String) PlayStoreDeferredComponentManager.this.f57628g.get(sessionId), "Android Deferred Component failed to install.");
                        }
                        PlayStoreDeferredComponentManager.this.f57628g.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f57629h.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f57630i.put(sessionId, "failed");
                        return;
                    case 7:
                        Log.m41134d(PlayStoreDeferredComponentManager.f57622a, String.format("Module \"%s\" (sessionId %d) install canceled.", new Object[]{PlayStoreDeferredComponentManager.this.f57628g.get(sessionId), Integer.valueOf(sessionId)}));
                        if (PlayStoreDeferredComponentManager.this.f57625d != null) {
                            PlayStoreDeferredComponentManager.this.f57625d.completeInstallError((String) PlayStoreDeferredComponentManager.this.f57628g.get(sessionId), "Android Deferred Component installation canceled.");
                        }
                        PlayStoreDeferredComponentManager.this.f57628g.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f57629h.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f57630i.put(sessionId, AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
                        return;
                    case 8:
                        Log.m41134d(PlayStoreDeferredComponentManager.f57622a, String.format("Module \"%s\" (sessionId %d) install requires user confirmation.", new Object[]{PlayStoreDeferredComponentManager.this.f57628g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f57630i.put(sessionId, "requiresUserConfirmation");
                        return;
                    case 9:
                        Log.m41134d(PlayStoreDeferredComponentManager.f57622a, String.format("Module \"%s\" (sessionId %d) install canceling.", new Object[]{PlayStoreDeferredComponentManager.this.f57628g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f57630i.put(sessionId, "canceling");
                        return;
                    default:
                        Log.m41134d(PlayStoreDeferredComponentManager.f57622a, "Unknown status: " + splitInstallSessionState.status());
                        return;
                }
            }
        }
    }

    public PlayStoreDeferredComponentManager(Context context, FlutterJNI flutterJNI) {
        this.f57626e = context;
        this.f57624c = flutterJNI;
        this.f57627f = ApplicationInfoLoader.load(context);
        this.f57623b = SplitInstallManagerFactory.create(context);
        FeatureInstallStateUpdatedListener featureInstallStateUpdatedListener = new FeatureInstallStateUpdatedListener();
        this.f57632k = featureInstallStateUpdatedListener;
        this.f57623b.registerListener(featureInstallStateUpdatedListener);
        m41443c();
    }

    public void setJNI(FlutterJNI flutterJNI) {
        this.f57624c = flutterJNI;
    }

    /* renamed from: a */
    private boolean m41439a() {
        if (this.f57624c != null) {
            return true;
        }
        Log.m41136e(f57622a, "No FlutterJNI provided. `setJNI` must be called on the DeferredComponentManager before attempting to load dart libraries or invoking with platform channels.");
        return false;
    }

    public void setDeferredComponentChannel(DeferredComponentChannel deferredComponentChannel) {
        this.f57625d = deferredComponentChannel;
    }

    /* renamed from: b */
    private ApplicationInfo m41440b() {
        try {
            return SystemUtils.getApplicationInfo(this.f57626e.getPackageManager(), this.f57626e.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    private void m41443c() {
        Bundle bundle;
        DeferredComponentManager.class.getName();
        ApplicationInfo b = m41440b();
        if (b != null && (bundle = b.metaData) != null) {
            String string = bundle.getString(MAPPING_KEY, (String) null);
            if (string == null) {
                Log.m41136e(f57622a, "No loading unit to dynamic feature module name found. Ensure '" + MAPPING_KEY + "' is defined in the base module's AndroidManifest.");
            } else if (!string.equals("")) {
                for (String split : string.split(",")) {
                    String[] split2 = split.split(":", -1);
                    int parseInt = Integer.parseInt(split2[0]);
                    this.loadingUnitIdToComponentNames.put(parseInt, split2[1]);
                    if (split2.length > 2) {
                        this.loadingUnitIdToSharedLibraryNames.put(parseInt, split2[2]);
                    }
                }
            }
        }
    }

    public void installDeferredComponent(int i, String str) {
        String str2 = str != null ? str : this.loadingUnitIdToComponentNames.get(i);
        if (str2 == null) {
            Log.m41136e(f57622a, "Deferred component name was null and could not be resolved from loading unit id.");
        } else if (!str2.equals("") || i <= 0) {
            this.f57623b.startInstall(SplitInstallRequest.newBuilder().addModule(str2).build()).addOnSuccessListener(new OnSuccessListener(str2, i) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onSuccess(Object obj) {
                    PlayStoreDeferredComponentManager.this.m41438a(this.f$1, this.f$2, (Integer) obj);
                }
            }).addOnFailureListener(new OnFailureListener(i, str) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onFailure(Exception exc) {
                    PlayStoreDeferredComponentManager.this.m41437a(this.f$1, this.f$2, exc);
                }
            });
        } else {
            loadDartLibrary(i, str2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m41438a(String str, int i, Integer num) {
        this.f57628g.put(num.intValue(), str);
        this.f57629h.put(num.intValue(), i);
        if (this.f57631j.containsKey(str)) {
            this.f57630i.remove(this.f57631j.get(str).intValue());
        }
        this.f57631j.put(str, num);
        this.f57630i.put(num.intValue(), "Requested");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m41437a(int i, String str, Exception exc) {
        SplitInstallException splitInstallException = (SplitInstallException) exc;
        int errorCode = splitInstallException.getErrorCode();
        if (errorCode == -6) {
            this.f57624c.deferredComponentInstallFailure(i, String.format("Install of deferred component module \"%s\" failed with a network error", new Object[]{str}), true);
        } else if (errorCode != -2) {
            this.f57624c.deferredComponentInstallFailure(i, String.format("Install of deferred component module \"%s\" failed with error %d: %s", new Object[]{str, Integer.valueOf(splitInstallException.getErrorCode()), splitInstallException.getMessage()}), false);
        } else {
            this.f57624c.deferredComponentInstallFailure(i, String.format("Install of deferred component module \"%s\" failed as it is unavailable", new Object[]{str}), false);
        }
    }

    public String getDeferredComponentInstallState(int i, String str) {
        if (str == null) {
            str = this.loadingUnitIdToComponentNames.get(i);
        }
        if (str == null) {
            Log.m41136e(f57622a, "Deferred component name was null and could not be resolved from loading unit id.");
            return "unknown";
        } else if (this.f57631j.containsKey(str)) {
            return this.f57630i.get(this.f57631j.get(str).intValue());
        } else if (this.f57623b.getInstalledModules().contains(str)) {
            return "installedPendingLoad";
        } else {
            return "unknown";
        }
    }

    public void loadAssets(int i, String str) {
        if (m41439a()) {
            try {
                Context createPackageContext = this.f57626e.createPackageContext(this.f57626e.getPackageName(), 0);
                this.f57626e = createPackageContext;
                this.f57624c.updateJavaAssetManager(createPackageContext.getAssets(), this.f57627f.flutterAssetsDir);
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void loadDartLibrary(int i, String str) {
        String str2;
        if (m41439a() && i >= 0) {
            String str3 = this.loadingUnitIdToSharedLibraryNames.get(i);
            if (str3 == null) {
                str3 = this.f57627f.aotSharedLibraryName + "-" + i + ".part.so";
            }
            if (Build.VERSION.SDK_INT >= 21) {
                str2 = Build.SUPPORTED_ABIS[0];
            } else {
                str2 = Build.CPU_ABI;
            }
            String replace = str2.replace("-", "_");
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.f57626e.getFilesDir());
            if (Build.VERSION.SDK_INT >= 21) {
                for (String file : this.f57626e.getApplicationInfo().splitSourceDirs) {
                    linkedList.add(new File(file));
                }
            }
            while (!linkedList.isEmpty()) {
                File file2 = (File) linkedList.remove();
                if (file2 == null || !file2.isDirectory() || file2.listFiles() == null) {
                    String name = file2.getName();
                    if (name.endsWith(".apk") && ((name.startsWith(str) || name.startsWith("split_config")) && name.contains(replace))) {
                        arrayList.add(file2.getAbsolutePath());
                    } else if (name.equals(str3)) {
                        arrayList2.add(file2.getAbsolutePath());
                    }
                } else {
                    for (File add : file2.listFiles()) {
                        linkedList.add(add);
                    }
                }
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(str3);
            for (String str4 : arrayList) {
                arrayList3.add(str4 + "!lib/" + str2 + "/" + str3);
            }
            for (String add2 : arrayList2) {
                arrayList3.add(add2);
            }
            this.f57624c.loadDartDeferredLibrary(i, (String[]) arrayList3.toArray(new String[arrayList3.size()]));
        }
    }

    public boolean uninstallDeferredComponent(int i, String str) {
        if (str == null) {
            str = this.loadingUnitIdToComponentNames.get(i);
        }
        if (str == null) {
            Log.m41136e(f57622a, "Deferred component name was null and could not be resolved from loading unit id.");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.f57623b.deferredUninstall(arrayList);
        if (this.f57631j.get(str) == null) {
            return true;
        }
        this.f57630i.delete(this.f57631j.get(str).intValue());
        return true;
    }

    public void destroy() {
        this.f57623b.unregisterListener(this.f57632k);
        this.f57625d = null;
        this.f57624c = null;
    }
}
