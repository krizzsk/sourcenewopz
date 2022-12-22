package com.didi.reactive.tracker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class EventTracker {

    /* renamed from: C */
    private static boolean f33128C = false;

    /* renamed from: D */
    private static Initializer f33129D = null;
    public static final int MODE_DEV = 0;
    public static final int MODE_ONLINE = 10;

    /* renamed from: a */
    private static final String f33130a = "EventTracker";

    /* renamed from: b */
    private static final long f33131b = 300;

    /* renamed from: c */
    private static EvictingQueue f33132c = new EvictingQueue(256);

    /* renamed from: d */
    private static final int f33133d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static WeakHashMap<Context, Context> f33134e = new WeakHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final WeakHashMap<View, EventTracker> f33135f = new WeakHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final WeakHashMap<View, EventTracker> f33136g = new WeakHashMap<>();

    /* renamed from: h */
    private static final Handler f33137h = new Handler(Looper.getMainLooper());

    /* renamed from: i */
    private static InnerTracker[] f33138i;

    /* renamed from: j */
    private static AttrsGetter f33139j;

    /* renamed from: k */
    private static int f33140k = 10;

    /* renamed from: z */
    private static WeakReference<View> f33141z;

    /* renamed from: A */
    private WeakReference<Object> f33142A;

    /* renamed from: B */
    private long f33143B;

    /* renamed from: l */
    private String f33144l;

    /* renamed from: m */
    private boolean f33145m;

    /* renamed from: n */
    private WeakReference<Object> f33146n;

    /* renamed from: o */
    private int f33147o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f33148p = -1;

    /* renamed from: q */
    private int f33149q = -1;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f33150r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public WeakReference<View> f33151s;

    /* renamed from: t */
    private long f33152t;

    /* renamed from: u */
    private ViewTreeObserver.OnGlobalLayoutListener f33153u;

    /* renamed from: v */
    private Filter f33154v;

    /* renamed from: w */
    private AttrsGetter f33155w;

    /* renamed from: x */
    private Assertor f33156x;

    /* renamed from: y */
    private boolean f33157y = true;

    public interface Initializer {
        AttrsGetter createCommonAttrsGetter();

        InnerTracker[] createInnerTracker();

        int currentModel();

        boolean isEnabled();
    }

    public static boolean isInitialized() {
        return f33128C;
    }

    public static void init(Initializer initializer) {
        f33129D = initializer;
        f33138i = initializer.createInnerTracker();
        f33139j = initializer.createCommonAttrsGetter();
        f33140k = initializer.currentModel();
        f33128C = true;
    }

    private EventTracker(View view) {
        this.f33151s = new WeakReference<>(view);
        if (view != null) {
            this.f33153u = new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (EventTracker.this.f33148p == 1) {
                        EventTracker eventTracker = EventTracker.this;
                        if (!eventTracker.isAttachedToWindow((View) eventTracker.f33151s.get())) {
                            EventTracker.this.m23336a(0);
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f33153u);
        }
    }

    public EventTracker() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23336a(int i) {
        if (i == 0 && this.f33148p == 1) {
            this.f33152t = SystemClock.elapsedRealtime();
            this.f33146n = null;
        }
        this.f33148p = i;
    }

    public boolean isAttachedToWindow(View view) {
        if (view == null) {
            return false;
        }
        return ViewCompat.isAttachedToWindow(view);
    }

    /* renamed from: a */
    private static View m23334a(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() <= 0) {
            return null;
        }
        View childAt = viewGroup.getChildAt(0);
        if (m23348c(childAt)) {
            return childAt;
        }
        return m23334a(childAt);
    }

    public static void trackEvent(String str) {
        trackEvent(str, (Map) null);
    }

    public static void trackEvent(String str, Map map) {
        trackEvent(str, map, true);
    }

    public static void trackEvent(String str, Map map, boolean z) {
        trackEvent(str, map, z, (Assertor) null);
    }

    public static boolean hasPreEvents(String str, long j) {
        return f33132c.containsEvent(str, j);
    }

    public static boolean hasPreEvents(String str) {
        return f33132c.containsEvent(str, 0);
    }

    /* renamed from: b */
    private void m23345b(View view) {
        if (view != null) {
            final Context context = view.getContext();
            if (f33134e.get(context) == null) {
                if (context instanceof FragmentActivity) {
                    final FragmentActivity fragmentActivity = (FragmentActivity) context;
                    fragmentActivity.getLifecycle().addObserver(new LifecycleObserver() {
                        /* access modifiers changed from: package-private */
                        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
                        public void onAny(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                            if (event == Lifecycle.Event.ON_RESUME) {
                                EventTracker.m23346b(fragmentActivity.getSupportFragmentManager());
                            } else if (event == Lifecycle.Event.ON_DESTROY) {
                                lifecycleOwner.getLifecycle().removeObserver(this);
                                EventTracker.f33134e.remove(context);
                                Iterator it = EventTracker.f33135f.entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    EventTracker eventTracker = (EventTracker) entry.getValue();
                                    Context context = ((View) entry.getKey()).getContext();
                                    if ((context instanceof LifecycleOwner) && context == lifecycleOwner) {
                                        eventTracker.unbind();
                                        it.remove();
                                        EventTracker.f33136g.remove(entry.getKey());
                                    }
                                }
                            }
                        }
                    });
                    if (this.f33150r) {
                        fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
                            public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
                                try {
                                    EventTracker.this.m23338a(fragment);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    EventTracker.trackEvent("rx_track_error", new Attrs().attr(NotificationCompat.CATEGORY_ERROR, "onFragmentViewDestroyed").attr("ex", th), false);
                                }
                            }

                            public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
                                try {
                                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    EventTracker.trackEvent("rx_track_error", new Attrs().attr(NotificationCompat.CATEGORY_ERROR, "onFragmentDestroyed").attr("ex", th), false);
                                }
                            }
                        }, true);
                    }
                }
                f33134e.put(context, context);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23338a(Fragment fragment) {
        WeakReference<View> weakReference = f33141z;
        if (weakReference != null && weakReference.get() == fragment.getView()) {
            f33141z = null;
        }
        Iterator<Map.Entry<View, EventTracker>> it = f33136g.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (fragment.getContext() == ((View) next.getKey()).getContext()) {
                EventTracker eventTracker = (EventTracker) next.getValue();
                if (m23355f((View) next.getKey()).contains(fragment.getView())) {
                    eventTracker.unbind();
                    it.remove();
                    f33135f.remove(next.getKey());
                }
            }
        }
    }

    public void unbind() {
        View view;
        WeakReference<View> weakReference = this.f33151s;
        if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
            view.setTag(R.id.event_tracker_tag, (Object) null);
            if (view.getViewTreeObserver().isAlive() && this.f33153u != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f33153u);
            }
        }
        this.f33153u = null;
        this.f33155w = null;
        this.f33154v = null;
        this.f33156x = null;
    }

    public static boolean isBound(View view) {
        return view.getTag(R.id.event_tracker_tag) instanceof EventTracker;
    }

    public static EventTracker bind(View view) {
        if (view == null) {
            return new EventTracker((View) null);
        }
        if (!f33129D.isEnabled()) {
            return new EventTracker((View) null);
        }
        if (view.getTag(R.id.event_tracker_tag) instanceof EventTracker) {
            return (EventTracker) view.getTag(R.id.event_tracker_tag);
        }
        EventTracker eventTracker = new EventTracker(view);
        view.setTag(R.id.event_tracker_tag, eventTracker);
        if (!m23348c(view)) {
            View a = m23334a(view);
            if (a == null || a.getTag(R.id.event_tracker_tag) != null) {
                System.err.println("=========empty view group is not support yet=========");
            } else {
                a.setTag(R.id.event_tracker_tag, eventTracker);
                f33135f.put(a, eventTracker);
            }
        }
        f33135f.put(view, eventTracker);
        return eventTracker;
    }

    /* renamed from: c */
    private static boolean m23348c(View view) {
        if (view != null) {
            try {
                if (view.getClass().getDeclaredMethod("onVisibilityChanged", new Class[]{View.class, Integer.TYPE}) != null) {
                    return true;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public void trackOnShow(boolean z, String str) {
        trackOnShow(z, str, (AttrsGetter) null);
    }

    public void trackOnShow(final boolean z, final String str, final AttrsGetter attrsGetter) {
        View view;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            f33137h.post(new Runnable() {
                public void run() {
                    EventTracker.this.trackOnShow(z, str, attrsGetter);
                }
            });
            return;
        }
        this.f33150r = z;
        WeakReference<View> weakReference = this.f33151s;
        if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
            if (z) {
                f33136g.put(view, this);
            }
            this.f33145m = true;
            this.f33155w = attrsGetter;
            m23345b(view);
        }
        this.f33144l = str;
    }

    public static void _aop_onVisibilityChanged(View view, View view2, int i) {
        if (view2 != null) {
            try {
                Object tag = view.getTag(R.id.event_tracker_tag);
                if (tag instanceof EventTracker) {
                    ((EventTracker) tag).m23337a(view2, i);
                }
            } catch (Exception e) {
                e.printStackTrace();
                trackEvent("rx_track_error", new Attrs().attr(NotificationCompat.CATEGORY_ERROR, "_aop_onVisibilityChanged").attr("ex", e), false);
            }
        }
    }

    public static void _aop_onFragmentsChanged(final FragmentManager fragmentManager) {
        f33137h.post(new Runnable() {
            public void run() {
                try {
                    EventTracker.m23346b(fragmentManager);
                    for (Map.Entry value : EventTracker.f33136g.entrySet()) {
                        EventTracker eventTracker = (EventTracker) value.getValue();
                        if (eventTracker.f33150r) {
                            eventTracker.m23350d();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    EventTracker.trackEvent("rx_track_error", new Attrs().attr(NotificationCompat.CATEGORY_ERROR, "_aop_onFragmentsChanged").attr("ex", th), false);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m23346b(FragmentManager fragmentManager) {
        Fragment fragment;
        List<Fragment> fragments = fragmentManager.getFragments();
        WeakHashMap weakHashMap = new WeakHashMap();
        int size = fragments.size();
        while (true) {
            size--;
            if (size < 0) {
                fragment = null;
                break;
            }
            fragment = fragments.get(size);
            View view = fragment.getView();
            if (view != null) {
                weakHashMap.put(view, fragment);
                if (fragment.isVisible() && fragment.getUserVisibleHint()) {
                    break;
                }
            }
        }
        if (fragment == null) {
            f33141z = null;
        } else {
            f33141z = new WeakReference<>(fragment.getView());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m23350d() {
        int i;
        View view = (View) this.f33151s.get();
        if (view != null) {
            int i2 = this.f33149q;
            boolean d = m23352d(view);
            this.f33149q = d ? 1 : 0;
            if (!d) {
                this.f33146n = null;
            }
            if (this.f33145m && i2 != (i = this.f33149q) && i == 1 && view.getVisibility() == 0 && isAttachedToWindow(view)) {
                m23356f();
            }
        }
    }

    /* renamed from: d */
    private boolean m23352d(View view) {
        WeakReference<View> weakReference;
        if (view == null || (weakReference = f33141z) == null || weakReference.get() == null) {
            return false;
        }
        Set<View> f = m23355f(view);
        if (f.size() == 0) {
            return false;
        }
        return f.contains(f33141z.get());
    }

    /* renamed from: a */
    private void m23337a(View view, int i) {
        View view2 = (View) this.f33151s.get();
        if (view2 != null) {
            int i2 = 0;
            if (i == 0 || !m23354e(view)) {
                if (view2 == view) {
                    if (i == 0) {
                        i2 = 1;
                    }
                    m23336a(i2);
                } else if (m23342a(view2, view)) {
                    if (view2.getVisibility() == 0 && i == 0) {
                        i2 = 1;
                    }
                    m23336a(i2);
                } else {
                    if (view2.getVisibility() == 0) {
                        i2 = 1;
                    }
                    m23336a(i2);
                }
                if (this.f33150r) {
                    if (this.f33145m && this.f33148p == 1 && isAttachedToWindow(view2) && m23353e() && m23352d(view2)) {
                        m23356f();
                    }
                } else if (this.f33145m && this.f33148p == 1 && isAttachedToWindow(view2) && m23353e()) {
                    m23356f();
                }
            } else {
                m23336a(0);
            }
        }
    }

    /* renamed from: e */
    private boolean m23354e(View view) {
        return view != null && isAttachedToWindow(view) && m23355f(view).size() == 0;
    }

    /* renamed from: e */
    private boolean m23353e() {
        Object obj;
        WeakReference<Object> weakReference;
        Object obj2;
        AttrsGetter attrsGetter = this.f33155w;
        if (attrsGetter instanceof ShowEventAttrGetter) {
            obj = ((ShowEventAttrGetter) attrsGetter).getShowTag((View) this.f33151s.get());
            if (obj != null) {
                this.f33142A = new WeakReference<>(obj);
            }
        } else {
            obj = null;
        }
        if (this.f33147o <= 0 || obj == null || (weakReference = this.f33146n) == null || (obj2 = weakReference.get()) == null) {
            return true;
        }
        return !obj2.equals(obj);
    }

    /* renamed from: a */
    private boolean m23342a(View view, View view2) {
        if (view == view2) {
            return false;
        }
        while (view.getParent() != null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
            if (view == view2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    private void m23356f() {
        if (SystemClock.elapsedRealtime() - this.f33152t >= 300 && SystemClock.elapsedRealtime() - this.f33143B >= 300) {
            this.f33143B = SystemClock.elapsedRealtime();
            m23357g();
        }
    }

    /* renamed from: g */
    private void m23357g() {
        AttrsGetter attrsGetter = this.f33155w;
        Map attrs = attrsGetter != null ? attrsGetter.getAttrs() : null;
        Filter filter = this.f33154v;
        if (filter == null || filter.needTrack(this, this.f33144l, attrs)) {
            this.f33146n = this.f33142A;
            this.f33147o++;
            trackEvent(this.f33144l, attrs, this.f33157y, this.f33156x);
        }
    }

    public static void trackEvent(String str, Map map, boolean z, Assertor assertor) {
        AssertResult assertEvent;
        Map commonAttrs;
        if (f33138i == null) {
            SystemUtils.log(6, f33130a, "no innerTrackers", (Throwable) null, "com.didi.reactive.tracker.EventTracker", 617);
            return;
        }
        if (z && (commonAttrs = getCommonAttrs()) != null) {
            HashMap hashMap = new HashMap(commonAttrs);
            if (map != null) {
                hashMap.putAll(map);
            }
            map = hashMap;
        }
        if (f33140k < 10 && assertor != null && (assertEvent = assertor.assertEvent(map)) != null && !assertEvent.isPass()) {
            SystemUtils.log(6, f33130a, assertEvent.getMessage(), new RuntimeException(assertEvent.getMessage()), "com.didi.reactive.tracker.EventTracker", 634);
        }
        f33132c.add(new TrackedEvent(str));
        int length = f33138i.length;
        for (int i = 0; i < length; i++) {
            try {
                f33138i[i].track(str, map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Map getCommonAttrs() {
        AttrsGetter attrsGetter = f33139j;
        if (attrsGetter != null) {
            return attrsGetter.getAttrs();
        }
        return null;
    }

    /* renamed from: f */
    private static Set<View> m23355f(View view) {
        HashSet hashSet = new HashSet();
        while (view != null && view.getParent() != null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
            if (view.getId() == 16908290) {
                break;
            }
            hashSet.add(view);
        }
        return hashSet;
    }

    public EventTracker filter(Filter filter) {
        this.f33154v = filter;
        return this;
    }

    public EventTracker withCommonAttrs(boolean z) {
        this.f33157y = z;
        return this;
    }

    public EventTracker assertEvent(Assertor assertor) {
        this.f33156x = assertor;
        return this;
    }

    public static class TrackedEvent {
        private String eventId;
        private long time = SystemClock.elapsedRealtime();

        public TrackedEvent(String str) {
            this.eventId = str;
        }

        public long getTime() {
            return this.time;
        }

        public String getEventId() {
            return this.eventId;
        }
    }
}
