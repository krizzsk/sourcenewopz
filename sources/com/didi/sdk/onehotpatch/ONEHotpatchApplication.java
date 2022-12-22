package com.didi.sdk.onehotpatch;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.didi.dynamic.manager.utils.DownloadUtil;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ONEHotpatchApplication extends Application {
    private static Crash sCrash;
    private static boolean sExecute;
    private static final Handler sMainHandler = new Handler(Looper.getMainLooper());
    private ArrayList<Application.ActivityLifecycleCallbacks> mActivityLifecycleCallbacks = new ArrayList<>();
    private ArrayList<Application.OnProvideAssistDataListener> mAssistCallbacks = null;
    private boolean mAttach = false;
    private ArrayList<ComponentCallbacks> mComponentCallbacks = new ArrayList<>();
    private List mOriginProviders = new ArrayList();
    private Application mRealApplication;
    private ArrayList<Application.ActivityLifecycleCallbacks> mRemoveActivityLifecycleCallbacks = new ArrayList<>();

    public abstract String getRealApplicationName();

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Logger.log("ONEHotpatchApplication attachBaseContext  " + getProcessName(this), new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        sCrash = new Crash(this);
        if (sMainHandler != null && UtilsHub.isMainProcess(this)) {
            sMainHandler.post(sCrash);
        }
        sExecute = sCrash.reset();
        Logger.log("sExecute " + sExecute, new Object[0]);
        String realApplicationName = getRealApplicationName();
        if (TextUtils.isEmpty(realApplicationName)) {
            throwException("realApplicationName null", (Throwable) null);
        }
        ONEPatchFacade.launch(this, true);
        removeProvidersTemporarily();
        callRealAppAttach(realApplicationName);
        Logger.log("ONEHotpatchApplication attachBaseContext spend " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void onCreate() {
        Logger.log("ONEHotpatchApplication onCreate()  mRealApplication: " + this.mRealApplication + "  " + getProcessName(this), new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRealApplication != null) {
            replaceRealApplication();
            installProviders();
            this.mRealApplication.onCreate();
            if (sExecute) {
                sCrash.recordSuccToFile(UtilsHub.getProcessName(this));
            }
            Logger.log("ONEHotpatchApplication onCreate() spend  " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            super.onCreate();
        }
    }

    private void callRealAppAttach(String str) {
        try {
            Application application = (Application) Class.forName(str, false, getClassLoader()).newInstance();
            getDeclaredMethod(Application.class, "attach", Context.class).invoke(application, new Object[]{getBaseContext()});
            this.mRealApplication = application;
            afterAttach();
        } catch (Throwable th) {
            throwException("real application attach fail", th);
        }
    }

    private void removeProvidersTemporarily() {
        try {
            Class forName = forName("android.app.ActivityThread");
            Object obj = getDeclaredField(forName, "mBoundApplication").get(getDeclaredMethod(forName, "currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]));
            List list = (List) getDeclaredField(obj.getClass(), "providers").get(obj);
            if (list != null) {
                this.mOriginProviders.addAll(list);
                list.clear();
            }
            Logger.log("removeProvidersTemporarily finish " + this.mOriginProviders.size(), new Object[0]);
        } catch (Throwable th) {
            throwException("removeProvidersTemporarily fail ", th);
        }
    }

    private void installProviders() {
        try {
            Class forName = forName("android.app.ActivityThread");
            Object invoke = getDeclaredMethod(forName, "currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
            Object obj = getDeclaredField(forName, "mBoundApplication").get(getDeclaredMethod(forName, "currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]));
            List list = (List) getDeclaredField(obj.getClass(), "providers").get(obj);
            if (list != null) {
                list.addAll(this.mOriginProviders);
                this.mOriginProviders.clear();
                getDeclaredMethod(forName, "installContentProviders", Context.class, List.class).invoke(invoke, new Object[]{this.mRealApplication, list});
                Logger.log("installProviders finish " + list.size(), new Object[0]);
            }
        } catch (Throwable th) {
            throwException("installProviders fail ", th);
        }
    }

    private void replaceRealApplication() {
        try {
            Class forName = forName("android.app.ContextImpl");
            getDeclaredField(forName, "mOuterContext").set(getBaseContext(), this.mRealApplication);
            Object obj = getDeclaredField(forName, "mPackageInfo").get(getBaseContext());
            getDeclaredField(obj.getClass(), "mApplication").set(obj, this.mRealApplication);
            Object obj2 = getDeclaredField(obj.getClass(), "mActivityThread").get(obj);
            getDeclaredField(obj2.getClass(), "mInitialApplication").set(obj2, this.mRealApplication);
            List list = (List) getDeclaredField(obj2.getClass(), "mAllApplications").get(obj2);
            for (int i = 0; i < list.size(); i++) {
                list.set(i, this.mRealApplication);
            }
            Logger.log("replaceRealApplication finish", new Object[0]);
        } catch (Throwable th) {
            throwException("replaceRealApplication fail ", th);
        }
    }

    private Class forName(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    private Method getDeclaredMethod(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod;
    }

    private Field getDeclaredField(Class cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (!declaredField.isAccessible()) {
            declaredField.setAccessible(true);
        }
        return declaredField;
    }

    public static String getProcessName(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            return invoke instanceof String ? (String) invoke : "";
        } catch (Throwable unused) {
            return DownloadUtil.getProcessNameByPid(context, Process.myPid());
        }
    }

    private void throwException(String str, Throwable th) {
        if (sExecute) {
            recordCrash(this, str, th);
        }
        throw new RuntimeException("abandon application: " + str, th);
    }

    public boolean recordCrash(Context context, String str, Throwable th) {
        try {
            sCrash.recordCrashToFile(UtilsHub.getProcessName(context), str + "\n" + UtilsHub.dumpException(th));
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public void afterAttach() {
        if (!this.mAttach && this.mRealApplication != null) {
            ArrayList<Application.ActivityLifecycleCallbacks> arrayList = this.mActivityLifecycleCallbacks;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<Application.ActivityLifecycleCallbacks> it = this.mActivityLifecycleCallbacks.iterator();
                while (it.hasNext()) {
                    this.mRealApplication.registerActivityLifecycleCallbacks(it.next());
                }
            }
            ArrayList<Application.ActivityLifecycleCallbacks> arrayList2 = this.mRemoveActivityLifecycleCallbacks;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                Iterator<Application.ActivityLifecycleCallbacks> it2 = this.mRemoveActivityLifecycleCallbacks.iterator();
                while (it2.hasNext()) {
                    this.mRealApplication.unregisterActivityLifecycleCallbacks(it2.next());
                }
            }
            ArrayList<ComponentCallbacks> arrayList3 = this.mComponentCallbacks;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                Iterator<ComponentCallbacks> it3 = this.mComponentCallbacks.iterator();
                while (it3.hasNext()) {
                    this.mRealApplication.registerComponentCallbacks(it3.next());
                }
            }
            this.mAttach = true;
        }
    }

    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (!this.mAttach) {
            synchronized (this.mActivityLifecycleCallbacks) {
                this.mActivityLifecycleCallbacks.add(activityLifecycleCallbacks);
            }
            return;
        }
        Application application = this.mRealApplication;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (!this.mAttach) {
            synchronized (this.mRemoveActivityLifecycleCallbacks) {
                this.mRemoveActivityLifecycleCallbacks.add(activityLifecycleCallbacks);
            }
            return;
        }
        Application application = this.mRealApplication;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        if (!this.mAttach) {
            synchronized (this.mComponentCallbacks) {
                this.mComponentCallbacks.add(componentCallbacks);
            }
            return;
        }
        Application application = this.mRealApplication;
        if (application != null) {
            application.registerComponentCallbacks(componentCallbacks);
        }
    }
}
