package com.didichuxing.omega.tracker;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
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
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.record.Event;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class ViewTracker {
    private static final long HUMAN_FEEL_INTERVAL = 300;
    private static final int NONE = -1;
    private static EvictingQueue PREEVENTS = new EvictingQueue(256);
    private static final String TAG = "ViewTracker";
    /* access modifiers changed from: private */
    public static final WeakHashMap<View, ViewTracker> inFragmentTrackers = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public static WeakHashMap<Context, Context> lifeCycleObserverIndicate = new WeakHashMap<>();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static WeakReference<View> topVisibleFragmentViewRef;
    /* access modifiers changed from: private */
    public static final WeakHashMap<View, ViewTracker> trackers = new WeakHashMap<>();
    private IExplosionAttr explosionAttr;
    private int fragmentVisibility = -1;
    private long inVisibleTimePoint;
    /* access modifiers changed from: private */
    public boolean isInFragment = false;
    private long lastShowTrackTime;
    private ViewTreeObserver.OnGlobalLayoutListener listener;
    private String onShowEventId;
    /* access modifiers changed from: private */
    public WeakReference<View> viewRef;
    /* access modifiers changed from: private */
    public int viewVisibility = -1;
    private boolean watchShow;

    public interface IClickAttr {
        Map<String, String> getAttr();
    }

    public interface IExplosionAttr {
        Map<String, String> getAttr();
    }

    private ViewTracker(View view) {
        this.viewRef = new WeakReference<>(view);
        if (view != null) {
            this.listener = new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (ViewTracker.this.viewVisibility == 1) {
                        ViewTracker viewTracker = ViewTracker.this;
                        if (!viewTracker.isAttachedToWindow((View) viewTracker.viewRef.get())) {
                            ViewTracker.this.changeViewVisibility(0);
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.listener);
        }
    }

    /* access modifiers changed from: private */
    public void changeViewVisibility(int i) {
        if (i == 0 && this.viewVisibility == 1) {
            this.inVisibleTimePoint = SystemClock.elapsedRealtime();
        }
        this.viewVisibility = i;
    }

    /* access modifiers changed from: private */
    public boolean isAttachedToWindow(View view) {
        if (view == null) {
            return false;
        }
        return ViewCompat.isAttachedToWindow(view);
    }

    private static View findHasAopMethodLeafView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() <= 0) {
            return null;
        }
        View childAt = viewGroup.getChildAt(0);
        if (hasAopMethod(childAt)) {
            return childAt;
        }
        return findHasAopMethodLeafView(childAt);
    }

    public static void trackEvent(String str) {
        trackEvent(str, (Map) null);
    }

    public static boolean hasPreEvents(String str, long j) {
        return PREEVENTS.containsEvent(str, j);
    }

    public static boolean hasPreEvents(String str) {
        return PREEVENTS.containsEvent(str, 0);
    }

    private void bindLifecycleObserver(View view) {
        if (view != null) {
            final Context context = view.getContext();
            if (lifeCycleObserverIndicate.get(context) == null) {
                if (context instanceof FragmentActivity) {
                    final FragmentActivity fragmentActivity = (FragmentActivity) context;
                    fragmentActivity.getLifecycle().addObserver(new LifecycleObserver() {
                        /* access modifiers changed from: package-private */
                        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
                        public void onAny(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                            if (event == Lifecycle.Event.ON_RESUME) {
                                ViewTracker.setTopVisibleFragment(fragmentActivity.getSupportFragmentManager());
                            } else if (event == Lifecycle.Event.ON_DESTROY) {
                                lifecycleOwner.getLifecycle().removeObserver(this);
                                ViewTracker.lifeCycleObserverIndicate.remove(context);
                                Iterator it = ViewTracker.trackers.entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    ViewTracker viewTracker = (ViewTracker) entry.getValue();
                                    Context context = ((View) entry.getKey()).getContext();
                                    if ((context instanceof LifecycleOwner) && context == lifecycleOwner) {
                                        viewTracker.unbind();
                                        it.remove();
                                        ViewTracker.inFragmentTrackers.remove(entry.getKey());
                                    }
                                }
                            }
                        }
                    });
                    if (this.isInFragment) {
                        fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
                            public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
                                try {
                                    ViewTracker.this._onFragmentViewDestroyed(fragment);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    HashMap hashMap = new HashMap();
                                    hashMap.put(NotificationCompat.CATEGORY_ERROR, "onFragmentViewDestroyed");
                                    ViewTracker.trackEvent("rx_track_error", hashMap);
                                }
                            }

                            public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
                                try {
                                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    HashMap hashMap = new HashMap();
                                    hashMap.put(NotificationCompat.CATEGORY_ERROR, "onFragmentDestroyed");
                                    ViewTracker.trackEvent("rx_track_error", hashMap);
                                }
                            }
                        }, true);
                    }
                }
                lifeCycleObserverIndicate.put(context, context);
            }
        }
    }

    /* access modifiers changed from: private */
    public void _onFragmentViewDestroyed(Fragment fragment) {
        WeakReference<View> weakReference = topVisibleFragmentViewRef;
        if (weakReference != null && weakReference.get() == fragment.getView()) {
            topVisibleFragmentViewRef = null;
        }
        Iterator<Map.Entry<View, ViewTracker>> it = inFragmentTrackers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (fragment.getContext() == ((View) next.getKey()).getContext()) {
                ViewTracker viewTracker = (ViewTracker) next.getValue();
                if (getParentViews((View) next.getKey()).contains(fragment.getView())) {
                    viewTracker.unbind();
                    it.remove();
                    trackers.remove(next.getKey());
                }
            }
        }
    }

    public void unbind() {
        View view;
        WeakReference<View> weakReference = this.viewRef;
        if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
            view.setTag(R.id.omega_event_tracker_tag, (Object) null);
            if (view.getViewTreeObserver().isAlive() && this.listener != null && Build.VERSION.SDK_INT >= 16) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.listener);
            }
        }
        this.listener = null;
        this.explosionAttr = null;
    }

    public static boolean isBound(View view) {
        return view.getTag(R.id.omega_event_tracker_tag) instanceof ViewTracker;
    }

    public static ViewTracker bind(View view) {
        if (view == null) {
            return new ViewTracker((View) null);
        }
        if (view.getTag(R.id.omega_event_tracker_tag) instanceof ViewTracker) {
            return (ViewTracker) view.getTag(R.id.omega_event_tracker_tag);
        }
        ViewTracker viewTracker = new ViewTracker(view);
        view.setTag(R.id.omega_event_tracker_tag, viewTracker);
        if (!hasAopMethod(view)) {
            View findHasAopMethodLeafView = findHasAopMethodLeafView(view);
            if (findHasAopMethodLeafView == null || findHasAopMethodLeafView.getTag(R.id.omega_event_tracker_tag) != null) {
                System.err.println("=========empty view group is not support yet=========");
            } else {
                findHasAopMethodLeafView.setTag(R.id.omega_event_tracker_tag, viewTracker);
                trackers.put(findHasAopMethodLeafView, viewTracker);
            }
        }
        trackers.put(view, viewTracker);
        return viewTracker;
    }

    private static boolean hasAopMethod(View view) {
        if (view == null) {
            return false;
        }
        try {
            view.getClass().getDeclaredMethod("onVisibilityChanged", new Class[]{View.class, Integer.TYPE});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void trackOnShow(boolean z, String str) {
        trackOnShow(z, str, (IExplosionAttr) null);
    }

    public ViewTracker trackOnShow(final boolean z, final String str, final IExplosionAttr iExplosionAttr) {
        View view;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            mainHandler.post(new Runnable() {
                public void run() {
                    ViewTracker.this.trackOnShow(z, str, iExplosionAttr);
                }
            });
            return this;
        }
        this.isInFragment = z;
        WeakReference<View> weakReference = this.viewRef;
        if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
            if (z) {
                inFragmentTrackers.put(view, this);
            }
            this.watchShow = true;
            this.explosionAttr = iExplosionAttr;
            bindLifecycleObserver(view);
        }
        this.onShowEventId = str;
        return this;
    }

    public ViewTracker trackOnClick(String str, IClickAttr iClickAttr) {
        View view;
        WeakReference<View> weakReference = this.viewRef;
        if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
            try {
                Method declaredMethod = Class.forName("android.view.View").getDeclaredMethod("getListenerInfo", new Class[0]);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                Object invoke = declaredMethod.invoke(view, new Object[0]);
                Field declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                declaredField.set(invoke, new OnClickListenerProxy((View.OnClickListener) declaredField.get(invoke), str, iClickAttr));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public static void _aop_onVisibilityChanged(View view, View view2, int i) {
        if (view2 != null) {
            try {
                Object tag = view.getTag(R.id.omega_event_tracker_tag);
                if (tag instanceof ViewTracker) {
                    ((ViewTracker) tag).onVisibilityChanged(view2, i);
                }
            } catch (Exception e) {
                e.printStackTrace();
                HashMap hashMap = new HashMap();
                hashMap.put(NotificationCompat.CATEGORY_ERROR, "_aop_onVisibilityChanged");
                trackEvent("rx_track_error", hashMap);
            }
        }
    }

    public static void _aop_onFragmentsChanged(final FragmentManager fragmentManager) {
        mainHandler.post(new Runnable() {
            public void run() {
                try {
                    ViewTracker.setTopVisibleFragment(fragmentManager);
                    for (Map.Entry value : ViewTracker.inFragmentTrackers.entrySet()) {
                        ViewTracker viewTracker = (ViewTracker) value.getValue();
                        if (viewTracker.isInFragment) {
                            viewTracker._onFragmentChanged();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    HashMap hashMap = new HashMap();
                    hashMap.put(NotificationCompat.CATEGORY_ERROR, "_aop_onFragmentsChanged");
                    ViewTracker.trackEvent("rx_track_error", hashMap);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void setTopVisibleFragment(FragmentManager fragmentManager) {
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
            topVisibleFragmentViewRef = null;
        } else {
            topVisibleFragmentViewRef = new WeakReference<>(fragment.getView());
        }
    }

    /* access modifiers changed from: private */
    public void _onFragmentChanged() {
        View view = (View) this.viewRef.get();
        if (view != null) {
            int i = this.fragmentVisibility;
            boolean isVisibleInFragment = isVisibleInFragment(view);
            this.fragmentVisibility = isVisibleInFragment ? 1 : 0;
            if (this.watchShow && i != isVisibleInFragment && isVisibleInFragment && view.getVisibility() == 0 && isAttachedToWindow(view)) {
                doShowTrack();
            }
        }
    }

    private boolean isVisibleInFragment(View view) {
        WeakReference<View> weakReference;
        if (view == null || (weakReference = topVisibleFragmentViewRef) == null || weakReference.get() == null) {
            return false;
        }
        Set<View> parentViews = getParentViews(view);
        if (parentViews.size() == 0) {
            return false;
        }
        return parentViews.contains(topVisibleFragmentViewRef.get());
    }

    private void onVisibilityChanged(View view, int i) {
        View view2 = (View) this.viewRef.get();
        if (view2 != null) {
            int i2 = 0;
            if (i == 0 || !isDecorViewChanged(view)) {
                if (view2 == view) {
                    if (i == 0) {
                        i2 = 1;
                    }
                    changeViewVisibility(i2);
                } else if (isParentView(view2, view)) {
                    if (view2.getVisibility() == 0 && i == 0) {
                        i2 = 1;
                    }
                    changeViewVisibility(i2);
                } else {
                    if (view2.getVisibility() == 0) {
                        i2 = 1;
                    }
                    changeViewVisibility(i2);
                }
                if (this.isInFragment) {
                    if (this.watchShow && this.viewVisibility == 1 && isAttachedToWindow(view2) && isVisibleInFragment(view2)) {
                        doShowTrack();
                    }
                } else if (this.watchShow && this.viewVisibility == 1 && isAttachedToWindow(view2)) {
                    doShowTrack();
                }
            } else {
                changeViewVisibility(0);
            }
        }
    }

    private boolean isDecorViewChanged(View view) {
        return view != null && isAttachedToWindow(view) && getParentViews(view).size() == 0;
    }

    private boolean isParentView(View view, View view2) {
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

    private void doShowTrack() {
        if (SystemClock.elapsedRealtime() - this.inVisibleTimePoint >= 300 && SystemClock.elapsedRealtime() - this.lastShowTrackTime >= 300) {
            this.lastShowTrackTime = SystemClock.elapsedRealtime();
            doTrack();
        }
    }

    private void doTrack() {
        IExplosionAttr iExplosionAttr = this.explosionAttr;
        trackEvent(this.onShowEventId, iExplosionAttr != null ? iExplosionAttr.getAttr() : null);
    }

    public static void trackEvent(String str, Map map) {
        PREEVENTS.add(new TrackedEvent(str));
        Tracker.trackEvent(str, "", map);
    }

    private static Set<View> getParentViews(View view) {
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

    private static class OnClickListenerProxy implements View.OnClickListener {
        private IClickAttr clickAttr;
        private String clickEventId;
        private View.OnClickListener originalListener;

        private OnClickListenerProxy(View.OnClickListener onClickListener, String str, IClickAttr iClickAttr) {
            this.originalListener = onClickListener;
            this.clickEventId = str;
            this.clickAttr = iClickAttr;
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = this.originalListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (!TextUtils.isEmpty(this.clickEventId)) {
                Event event = new Event(this.clickEventId);
                IClickAttr iClickAttr = this.clickAttr;
                if (!(iClickAttr == null || iClickAttr.getAttr() == null)) {
                    event.putAllAttrs(new HashMap(this.clickAttr.getAttr()));
                }
                Tracker.trackEvent(event);
            }
        }
    }
}
