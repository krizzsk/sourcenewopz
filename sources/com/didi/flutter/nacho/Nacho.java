package com.didi.flutter.nacho;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.flutter.nacho.Default;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p242io.flutter.embedding.android.FlutterFragment2;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.FlutterEngineCache;
import p242io.flutter.embedding.engine.FlutterEngineGroup;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;

public class Nacho {
    public static final String DEFAULT_ENGINE_ID = "_NACHO_ENGINE";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Nacho f21081a = new Nacho();

    /* renamed from: b */
    private Configuration f21082b;

    /* renamed from: c */
    private FlutterEngineGroup f21083c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Logger f21084d = LoggerFactory.getLogger("Nacho");
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f21085e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WeakReference<Activity> f21086f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final LinkedList<WeakReference<Activity>> f21087g = new LinkedList<>();

    /* renamed from: h */
    private final LinkedList<WeakReference<? extends FlutterFragment2>> f21088h = new LinkedList<>();

    /* renamed from: i */
    private boolean f21089i = false;

    public enum LaunchMode {
        Immediate,
        Idle,
        Requirement
    }

    public String cachedEngineId() {
        return DEFAULT_ENGINE_ID;
    }

    public void addEngineOption(EngineOption engineOption) {
        this.f21082b.addEngineOption(engineOption);
    }

    @Deprecated
    public FlutterEngine engine() {
        return getEngine(DEFAULT_ENGINE_ID);
    }

    private Nacho() {
    }

    public static Logger logger() {
        return f21081a.f21084d;
    }

    public static Nacho getInstance() {
        return f21081a;
    }

    public static Router Router() {
        return f21081a.f21082b.f61864router;
    }

    public static Configuration beginConfig(Application application) {
        return new Configuration(application);
    }

    public FlutterEngine getEengine() {
        return getEngine(DEFAULT_ENGINE_ID);
    }

    public NativeInfoFetcher nativeInfoFetcher() {
        return this.f21082b.nativeInfoFetcher;
    }

    public boolean isEngineStarted() {
        return this.f21089i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15518a(Configuration configuration) {
        this.f21082b = configuration;
        Logger logger = this.f21084d;
        logger.info("try init flutter engine,release:true,launchMode:" + this.f21082b.launchMode, new Object[0]);
        if (this.f21082b.launchMode == LaunchMode.Immediate) {
            getEngine(DEFAULT_ENGINE_ID);
        } else if (this.f21082b.launchMode == LaunchMode.Idle) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                public boolean queueIdle() {
                    Nacho.this.getEngine(Nacho.DEFAULT_ENGINE_ID);
                    return false;
                }
            });
        }
        configuration.context.registerActivityLifecycleCallbacks(new Default.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Logger a = Nacho.this.f21084d;
                a.info("Nacho:: onActivityCreated ::" + activity, new Object[0]);
                String stringExtra = activity.getIntent().getStringExtra(Page.TAG_ROUTER_NAME);
                if (stringExtra != null) {
                    int intExtra = activity.getIntent().getIntExtra(Page.TAG_LAUNCH_MODE, 0);
                    int size = Nacho.this.f21087g.size();
                    for (int i = 0; i < size; i++) {
                        final Activity activity2 = (Activity) ((WeakReference) Nacho.this.f21087g.get(i)).get();
                        if (activity2 != null && intExtra == 1 && stringExtra.equals(activity2.getIntent().getStringExtra(Page.TAG_ROUTER_NAME))) {
                            new Handler().post(new Runnable() {
                                public void run() {
                                    activity2.finish();
                                }
                            });
                        }
                    }
                }
                Nacho.this.f21087g.add(new WeakReference(activity));
            }

            public void onActivityResumed(Activity activity) {
                Logger a = Nacho.this.f21084d;
                a.info("Nacho:: onActivityResumed ::" + activity, new Object[0]);
                WeakReference unused = Nacho.this.f21086f = new WeakReference(activity);
                if (Nacho.this.m15520a(activity)) {
                    boolean unused2 = Nacho.this.f21085e = false;
                }
            }

            public void onActivityPaused(Activity activity) {
                Logger a = Nacho.this.f21084d;
                a.info("Nacho:: onActivityPaused ::" + activity, new Object[0]);
                if (Nacho.this.f21086f != null && Nacho.this.f21086f.get() == activity) {
                    Nacho.this.f21086f.clear();
                    WeakReference unused = Nacho.this.f21086f = null;
                }
            }

            public void onActivityDestroyed(Activity activity) {
                Logger a = Nacho.this.f21084d;
                a.info("Nacho:: onActivityDestroyed ::" + activity, new Object[0]);
                int size = Nacho.this.f21087g.size();
                for (int i = 0; i < size; i++) {
                    if (((WeakReference) Nacho.this.f21087g.get(i)).get() == activity) {
                        Nacho.this.f21087g.remove(i);
                        return;
                    }
                }
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                Logger a = Nacho.this.f21084d;
                a.info("Nacho:: onActivitySaveInstanceState ::" + activity, new Object[0]);
                super.onActivitySaveInstanceState(activity, bundle);
            }
        });
        this.f21089i = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m15520a(Activity activity) {
        return activity instanceof NachoFlutterActivity;
    }

    public FlutterEngine getEngine(String str) {
        FlutterEngine flutterEngine;
        FlutterEngineCache instance = FlutterEngineCache.getInstance();
        synchronized (instance) {
            FlutterEngine flutterEngine2 = instance.get(str);
            if (flutterEngine2 != null) {
                return flutterEngine2;
            }
            this.f21082b.flutterEngineLifecycleListener.onPreStart(this.f21082b.context, str);
            EngineOption engineOption = this.f21082b.getEngineOption(str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("createByGroup", engineOption.f21080d);
                jSONObject.put("engineId", engineOption.f21078b);
                engineOption.addArg(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (engineOption.f21080d) {
                m15524b();
                FlutterEngineGroup.Options options = new FlutterEngineGroup.Options(this.f21082b.context);
                options.setDartEntrypointArgs(engineOption.f21079c);
                flutterEngine = this.f21083c.createAndRunEngine(options);
            } else {
                flutterEngine = new FlutterEngine(this.f21082b.context);
                flutterEngine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault(), engineOption.f21079c);
            }
            if (engineOption.f21077a) {
                flutterEngine.getDartExecutor().getBinaryMessenger().enableBufferingIncomingMessages();
            }
            instance.put(str, flutterEngine);
            ((NachoPlugin) getInstance().getPlugin(flutterEngine, (Class<? extends FlutterPlugin>) NachoPlugin.class)).onPluginRegistered(flutterEngine);
            this.f21082b.flutterEngineLifecycleListener.onPostStart(this.f21082b.context, str);
            return flutterEngine;
        }
    }

    /* renamed from: b */
    private synchronized void m15524b() {
        if (this.f21083c == null) {
            this.f21083c = new FlutterEngineGroup(this.f21082b.context);
        }
    }

    public INachoApp getTopContainer() {
        Activity topActivity = getTopActivity();
        if (topActivity instanceof INachoApp) {
            return (INachoApp) topActivity;
        }
        if (topActivity instanceof FragmentActivity) {
            return (INachoApp) getTopFlutterFragment();
        }
        return null;
    }

    public boolean isPaddingOpenContainer() {
        return this.f21085e;
    }

    public void paddingOpenContainer() {
        this.f21085e = true;
    }

    public Context getContext() {
        return this.f21082b.context;
    }

    public static class Configuration {
        /* access modifiers changed from: private */
        public Application context;
        /* access modifiers changed from: private */
        public FlutterEngineLifecycleListener flutterEngineLifecycleListener = new Default.DefaultFlutterEngineLifecycleListener();
        /* access modifiers changed from: private */
        public LaunchMode launchMode = LaunchMode.Immediate;
        /* access modifiers changed from: private */
        public NativeInfoFetcher nativeInfoFetcher = new Default.DefaultNativeInfoFetcher();
        private Map<String, EngineOption> optionMap = new HashMap();
        /* access modifiers changed from: private */

        /* renamed from: router  reason: collision with root package name */
        public Router f61864router = new Default.DefaultRouter();

        public Configuration(Application application) {
            this.context = application;
        }

        public void init() {
            Nacho.f21081a.m15518a(this);
        }

        public Configuration lifecycleListener(FlutterEngineLifecycleListener flutterEngineLifecycleListener2) {
            if (flutterEngineLifecycleListener2 != null) {
                this.flutterEngineLifecycleListener = flutterEngineLifecycleListener2;
            }
            return this;
        }

        public Configuration router(Router router2) {
            this.f61864router = router2;
            return this;
        }

        public Configuration nativeInfoFetcher(NativeInfoFetcher nativeInfoFetcher2) {
            this.nativeInfoFetcher = nativeInfoFetcher2;
            return this;
        }

        public Configuration setLaunchMode(LaunchMode launchMode2) {
            this.launchMode = launchMode2;
            return this;
        }

        public Configuration addEngineOption(EngineOption engineOption) {
            this.optionMap.put(engineOption.f21078b, engineOption);
            return this;
        }

        public EngineOption getEngineOption(String str) {
            EngineOption engineOption = this.optionMap.get(str);
            return engineOption == null ? new EngineOption(str) : engineOption;
        }
    }

    public Activity getTopActivity() {
        if (this.f21086f == null && this.f21087g.size() > 0) {
            this.f21086f = this.f21087g.getLast();
        }
        WeakReference<Activity> weakReference = this.f21086f;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public <T extends FlutterPlugin> T getPlugin(Class<? extends FlutterPlugin> cls) {
        return getPlugin(getEengine(), cls);
    }

    public <T extends FlutterPlugin> T getPlugin(FlutterEngine flutterEngine, Class<? extends FlutterPlugin> cls) {
        return flutterEngine.getPlugins().get(cls);
    }

    public <T extends FlutterPlugin> T getPlugin(String str, Class<? extends FlutterPlugin> cls) {
        return FlutterEngineCache.getInstance().get(str).getPlugins().get(cls);
    }

    public NachoPlugin getNachoPlugin() {
        return (NachoPlugin) getPlugin(NachoPlugin.class);
    }

    public NachoPlugin getNachoPlugin(FlutterEngine flutterEngine) {
        return (NachoPlugin) getPlugin(flutterEngine, (Class<? extends FlutterPlugin>) NachoPlugin.class);
    }

    public boolean isFlutterOnTop() {
        Fragment findFragmentByTag;
        if (getTopContainer() != null) {
            return true;
        }
        Activity topActivity = getTopActivity();
        if (!(topActivity instanceof FragmentActivity) || (findFragmentByTag = ((FragmentActivity) topActivity).getSupportFragmentManager().findFragmentByTag(Default.TAG_BOTTOM_DIALOG)) == null || !findFragmentByTag.isResumed() || !findFragmentByTag.isVisible()) {
            return false;
        }
        return true;
    }

    public boolean dismissFlutterDialog() {
        boolean z = false;
        for (int size = this.f21087g.size() - 1; size >= 0; size--) {
            Activity activity = (Activity) this.f21087g.get(size).get();
            if (activity instanceof FragmentActivity) {
                Fragment findFragmentByTag = ((FragmentActivity) activity).getSupportFragmentManager().findFragmentByTag(Default.TAG_BOTTOM_DIALOG);
                if (findFragmentByTag instanceof DialogFragment) {
                    try {
                        ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
                        z = true;
                    } catch (Exception e) {
                        logger().error("dismissFlutterDialog error", (Throwable) e);
                    }
                }
            }
        }
        return z;
    }

    public void addFlutterFragment(FlutterFragment2 flutterFragment2) {
        this.f21088h.add(new WeakReference(flutterFragment2));
    }

    public void removeFlutterFragment(FlutterFragment2 flutterFragment2) {
        this.f21088h.remove(flutterFragment2);
    }

    public FlutterFragment2 getTopFlutterFragment() {
        if (this.f21088h.size() > 0) {
            return (FlutterFragment2) this.f21088h.getLast().get();
        }
        return null;
    }
}
