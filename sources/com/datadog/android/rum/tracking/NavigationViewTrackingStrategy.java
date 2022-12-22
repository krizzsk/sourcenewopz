package com.datadog.android.rum.tracking;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.ActivityKt;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.FragmentNavigator;
import com.datadog.android.core.internal.utils.ViewUtilsKt;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.internal.monitor.EventType;
import com.datadog.android.rum.internal.tracking.AndroidXFragmentLifecycleCallbacks;
import com.datadog.android.rum.model.ViewEvent;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003!\"#B'\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\"\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u0019*\u00020\u000e2\b\b\u0001\u0010\u001e\u001a\u00020\u0005H\u0002J\f\u0010\u001f\u001a\u00020 *\u00020\nH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo175978d2 = {"Lcom/datadog/android/rum/tracking/NavigationViewTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ActivityLifecycleTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "navigationViewId", "", "trackArguments", "", "componentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "Landroidx/navigation/NavDestination;", "(IZLcom/datadog/android/rum/tracking/ComponentPredicate;)V", "lifecycleCallbackRefs", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Lcom/datadog/android/rum/tracking/NavigationViewTrackingStrategy$NavControllerFragmentLifecycleCallbacks;", "predicate", "Landroidx/fragment/app/Fragment;", "onActivityPaused", "", "activity", "onActivityStarted", "onActivityStopped", "onDestinationChanged", "controller", "Landroidx/navigation/NavController;", "destination", "arguments", "Landroid/os/Bundle;", "findNavControllerOrNull", "viewId", "getRumViewName", "", "AdvancedMonitorDecorator", "Companion", "NavControllerFragmentLifecycleCallbacks", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NavigationViewTrackingStrategy.kt */
public final class NavigationViewTrackingStrategy extends ActivityLifecycleTrackingStrategy implements NavController.OnDestinationChangedListener, ViewTrackingStrategy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String UNKNOWN_DESTINATION_NAME = "Unknown";

    /* renamed from: a */
    private final int f4035a;

    /* renamed from: b */
    private final boolean f4036b;

    /* renamed from: c */
    private final ComponentPredicate<NavDestination> f4037c;

    /* renamed from: d */
    private WeakHashMap<Activity, NavControllerFragmentLifecycleCallbacks> f4038d;

    /* renamed from: e */
    private final ComponentPredicate<Fragment> f4039e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavigationViewTrackingStrategy(int i, boolean z, ComponentPredicate componentPredicate, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, (i2 & 4) != 0 ? new AcceptAllNavDestinations() : componentPredicate);
    }

    public NavigationViewTrackingStrategy(int i, boolean z, ComponentPredicate<NavDestination> componentPredicate) {
        Intrinsics.checkNotNullParameter(componentPredicate, "componentPredicate");
        this.f4035a = i;
        this.f4036b = z;
        this.f4037c = componentPredicate;
        this.f4038d = new WeakHashMap<>();
        this.f4039e = new NavigationViewTrackingStrategy$predicate$1();
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityStarted(activity);
        NavController a = m2526a(activity, this.f4035a);
        if (a != null) {
            if (FragmentActivity.class.isAssignableFrom(activity.getClass())) {
                NavControllerFragmentLifecycleCallbacks navControllerFragmentLifecycleCallbacks = new NavControllerFragmentLifecycleCallbacks(a, C2208x2b42a531.INSTANCE, this.f4039e);
                navControllerFragmentLifecycleCallbacks.register((FragmentActivity) activity);
                this.f4038d.put(activity, navControllerFragmentLifecycleCallbacks);
            }
            a.addOnDestinationChangedListener(this);
        }
    }

    public void onActivityStopped(Activity activity) {
        NavControllerFragmentLifecycleCallbacks remove;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityStopped(activity);
        NavController a = m2526a(activity, this.f4035a);
        if (a != null) {
            a.removeOnDestinationChangedListener(this);
            if (FragmentActivity.class.isAssignableFrom(activity.getClass()) && (remove = this.f4038d.remove(activity)) != null) {
                remove.unregister((FragmentActivity) activity);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        NavDestination currentDestination;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityPaused(activity);
        NavController a = m2526a(activity, this.f4035a);
        if (a != null && (currentDestination = a.getCurrentDestination()) != null) {
            RumMonitor.DefaultImpls.stopView$default(GlobalRum.get(), currentDestination, (Map) null, 2, (Object) null);
        }
    }

    public void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(navController, "controller");
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        if (this.f4037c.accept(navDestination)) {
            Map<String, Object> convertToRumAttributes = this.f4036b ? convertToRumAttributes(bundle) : MapsKt.emptyMap();
            String viewName = this.f4037c.getViewName(navDestination);
            CharSequence charSequence = viewName;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                viewName = ViewUtilsKt.resolveViewUrl((Object) navDestination);
            }
            GlobalRum.get().startView(navDestination, viewName, convertToRumAttributes);
        }
    }

    /* renamed from: a */
    private final NavController m2526a(Activity activity, int i) {
        try {
            return ActivityKt.findNavController(activity, i);
        } catch (IllegalArgumentException unused) {
            return null;
        } catch (IllegalStateException unused2) {
            return null;
        }
    }

    /* renamed from: a */
    private final String m2527a(NavDestination navDestination) {
        ComponentName component;
        String className;
        if (navDestination instanceof FragmentNavigator.Destination) {
            String className2 = ((FragmentNavigator.Destination) navDestination).getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "className");
            return className2;
        } else if (navDestination instanceof DialogFragmentNavigator.Destination) {
            String className3 = ((DialogFragmentNavigator.Destination) navDestination).getClassName();
            Intrinsics.checkNotNullExpressionValue(className3, "className");
            return className3;
        } else if (!(navDestination instanceof ActivityNavigator.Destination) || (component = ((ActivityNavigator.Destination) navDestination).getComponent()) == null || (className = component.getClassName()) == null) {
            return "Unknown";
        } else {
            return className;
        }
    }

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/datadog/android/rum/tracking/NavigationViewTrackingStrategy$NavControllerFragmentLifecycleCallbacks;", "Lcom/datadog/android/rum/internal/tracking/AndroidXFragmentLifecycleCallbacks;", "navController", "Landroidx/navigation/NavController;", "argumentsProvider", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "", "", "", "componentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "(Landroidx/navigation/NavController;Lkotlin/jvm/functions/Function1;Lcom/datadog/android/rum/tracking/ComponentPredicate;)V", "resolveKey", "fragment", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NavigationViewTrackingStrategy.kt */
    public static final class NavControllerFragmentLifecycleCallbacks extends AndroidXFragmentLifecycleCallbacks {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final Object NO_DESTINATION_FOUND = new Object();
        private final NavController navController;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public NavControllerFragmentLifecycleCallbacks(androidx.navigation.NavController r10, kotlin.jvm.functions.Function1<? super androidx.fragment.app.Fragment, ? extends java.util.Map<java.lang.String, ? extends java.lang.Object>> r11, com.datadog.android.rum.tracking.ComponentPredicate<androidx.fragment.app.Fragment> r12) {
            /*
                r9 = this;
                java.lang.String r0 = "navController"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                java.lang.String r0 = "argumentsProvider"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                java.lang.String r0 = "componentPredicate"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                com.datadog.android.rum.NoOpRumMonitor r0 = new com.datadog.android.rum.NoOpRumMonitor
                r0.<init>()
                r5 = r0
                com.datadog.android.rum.RumMonitor r5 = (com.datadog.android.rum.RumMonitor) r5
                com.datadog.android.rum.tracking.NavigationViewTrackingStrategy$AdvancedMonitorDecorator r0 = new com.datadog.android.rum.tracking.NavigationViewTrackingStrategy$AdvancedMonitorDecorator
                com.datadog.android.rum.RumMonitor r1 = com.datadog.android.rum.GlobalRum.get()
                boolean r2 = r1 instanceof com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
                if (r2 == 0) goto L_0x0024
                com.datadog.android.rum.internal.monitor.AdvancedRumMonitor r1 = (com.datadog.android.rum.internal.monitor.AdvancedRumMonitor) r1
                goto L_0x0025
            L_0x0024:
                r1 = 0
            L_0x0025:
                if (r1 != 0) goto L_0x002e
                com.datadog.android.rum.internal.monitor.NoOpAdvancedRumMonitor r1 = new com.datadog.android.rum.internal.monitor.NoOpAdvancedRumMonitor
                r1.<init>()
                com.datadog.android.rum.internal.monitor.AdvancedRumMonitor r1 = (com.datadog.android.rum.internal.monitor.AdvancedRumMonitor) r1
            L_0x002e:
                r0.<init>(r1)
                r6 = r0
                com.datadog.android.rum.internal.monitor.AdvancedRumMonitor r6 = (com.datadog.android.rum.internal.monitor.AdvancedRumMonitor) r6
                r7 = 4
                r8 = 0
                r4 = 0
                r1 = r9
                r2 = r11
                r3 = r12
                r1.<init>(r2, r3, r4, r5, r6, r7, r8)
                r9.navController = r10
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.tracking.NavigationViewTrackingStrategy.NavControllerFragmentLifecycleCallbacks.<init>(androidx.navigation.NavController, kotlin.jvm.functions.Function1, com.datadog.android.rum.tracking.ComponentPredicate):void");
        }

        public Object resolveKey(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            NavDestination currentDestination = this.navController.getCurrentDestination();
            return currentDestination == null ? NO_DESTINATION_FOUND : currentDestination;
        }

        @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/datadog/android/rum/tracking/NavigationViewTrackingStrategy$NavControllerFragmentLifecycleCallbacks$Companion;", "", "()V", "NO_DESTINATION_FOUND", "getNO_DESTINATION_FOUND", "()Ljava/lang/Object;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: NavigationViewTrackingStrategy.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getNO_DESTINATION_FOUND() {
                return NavControllerFragmentLifecycleCallbacks.NO_DESTINATION_FOUND;
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001J9\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0001J9\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0001J\u0019\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0001J\u0019\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0001J\u0011\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0007H\u0001J/\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0001J\u0019\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020!H\u0001J\u0019\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020!H\u0001J\t\u0010#\u001a\u00020\u0005H\u0001J7\u0010$\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0001J/\u0010'\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0001J/\u0010(\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0001JH\u0010)\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u00142\u0006\u0010-\u001a\u00020.2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0001¢\u0006\u0002\u0010/JN\u00100\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0001¢\u0006\u0002\u00101J/\u00102\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0001J\u001f\u00102\u001a\u00020\u00052\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0001J'\u00103\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0001J \u00104\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u000206H\u0016J\u0011\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u000209H\u0001J\u0011\u0010:\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0007H\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, mo175978d2 = {"Lcom/datadog/android/rum/tracking/NavigationViewTrackingStrategy$AdvancedMonitorDecorator;", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "advancedRumMonitor", "(Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;)V", "addCrash", "", "message", "", "source", "Lcom/datadog/android/rum/RumErrorSource;", "throwable", "", "addError", "attributes", "", "", "addErrorWithStacktrace", "stacktrace", "addLongTask", "durationNs", "", "target", "addResourceTiming", "key", "timing", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "addTiming", "name", "addUserAction", "type", "Lcom/datadog/android/rum/RumActionType;", "eventDropped", "viewId", "Lcom/datadog/android/rum/internal/monitor/EventType;", "eventSent", "resetSession", "startResource", "method", "url", "startUserAction", "startView", "stopResource", "statusCode", "", "size", "kind", "Lcom/datadog/android/rum/RumResourceKind;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;)V", "stopResourceWithError", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/util/Map;)V", "stopUserAction", "stopView", "updateViewLoadingTime", "loadingTimeInNs", "Lcom/datadog/android/rum/model/ViewEvent$LoadingType;", "viewTreeChanged", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "waitForResourceTiming", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NavigationViewTrackingStrategy.kt */
    public static final class AdvancedMonitorDecorator implements AdvancedRumMonitor {
        private final AdvancedRumMonitor advancedRumMonitor;

        public void addCrash(String str, RumErrorSource rumErrorSource, Throwable th) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(rumErrorSource, "source");
            Intrinsics.checkNotNullParameter(th, "throwable");
            this.advancedRumMonitor.addCrash(str, rumErrorSource, th);
        }

        public void addError(String str, RumErrorSource rumErrorSource, Throwable th, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(rumErrorSource, "source");
            Intrinsics.checkNotNullParameter(map, "attributes");
            this.advancedRumMonitor.addError(str, rumErrorSource, th, map);
        }

        public void addErrorWithStacktrace(String str, RumErrorSource rumErrorSource, String str2, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(rumErrorSource, "source");
            Intrinsics.checkNotNullParameter(map, "attributes");
            this.advancedRumMonitor.addErrorWithStacktrace(str, rumErrorSource, str2, map);
        }

        public void addLongTask(long j, String str) {
            Intrinsics.checkNotNullParameter(str, "target");
            this.advancedRumMonitor.addLongTask(j, str);
        }

        public void addResourceTiming(String str, ResourceTiming resourceTiming) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(resourceTiming, "timing");
            this.advancedRumMonitor.addResourceTiming(str, resourceTiming);
        }

        public void addTiming(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.advancedRumMonitor.addTiming(str);
        }

        public void addUserAction(RumActionType rumActionType, String str, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(rumActionType, "type");
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(map, "attributes");
            this.advancedRumMonitor.addUserAction(rumActionType, str, map);
        }

        public void eventDropped(String str, EventType eventType) {
            Intrinsics.checkNotNullParameter(str, "viewId");
            Intrinsics.checkNotNullParameter(eventType, "type");
            this.advancedRumMonitor.eventDropped(str, eventType);
        }

        public void eventSent(String str, EventType eventType) {
            Intrinsics.checkNotNullParameter(str, "viewId");
            Intrinsics.checkNotNullParameter(eventType, "type");
            this.advancedRumMonitor.eventSent(str, eventType);
        }

        public void resetSession() {
            this.advancedRumMonitor.resetSession();
        }

        public void startResource(String str, String str2, String str3, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "method");
            Intrinsics.checkNotNullParameter(str3, "url");
            Intrinsics.checkNotNullParameter(map, "attributes");
            this.advancedRumMonitor.startResource(str, str2, str3, map);
        }

        public void startUserAction(RumActionType rumActionType, String str, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(rumActionType, "type");
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(map, "attributes");
            this.advancedRumMonitor.startUserAction(rumActionType, str, map);
        }

        public void startView(Object obj, String str, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(obj, "key");
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(map, "attributes");
            this.advancedRumMonitor.startView(obj, str, map);
        }

        public void stopResource(String str, Integer num, Long l, RumResourceKind rumResourceKind, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(rumResourceKind, "kind");
            Intrinsics.checkNotNullParameter(map, "attributes");
            this.advancedRumMonitor.stopResource(str, num, l, rumResourceKind, map);
        }

        public void stopResourceWithError(String str, Integer num, String str2, RumErrorSource rumErrorSource, Throwable th, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "message");
            Intrinsics.checkNotNullParameter(rumErrorSource, "source");
            Intrinsics.checkNotNullParameter(th, "throwable");
            Intrinsics.checkNotNullParameter(map, "attributes");
            this.advancedRumMonitor.stopResourceWithError(str, num, str2, rumErrorSource, th, map);
        }

        public void stopUserAction(RumActionType rumActionType, String str, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(rumActionType, "type");
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(map, "attributes");
            this.advancedRumMonitor.stopUserAction(rumActionType, str, map);
        }

        @Deprecated(message = "This method is deprecated. Please use RumMonitor#stopUserAction(type, name, attributes) instead")
        public void stopUserAction(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "attributes");
            this.advancedRumMonitor.stopUserAction(map);
        }

        public void stopView(Object obj, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(obj, "key");
            Intrinsics.checkNotNullParameter(map, "attributes");
            this.advancedRumMonitor.stopView(obj, map);
        }

        public void viewTreeChanged(Time time) {
            Intrinsics.checkNotNullParameter(time, "eventTime");
            this.advancedRumMonitor.viewTreeChanged(time);
        }

        public void waitForResourceTiming(String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.advancedRumMonitor.waitForResourceTiming(str);
        }

        public AdvancedMonitorDecorator(AdvancedRumMonitor advancedRumMonitor2) {
            Intrinsics.checkNotNullParameter(advancedRumMonitor2, "advancedRumMonitor");
            this.advancedRumMonitor = advancedRumMonitor2;
        }

        public void updateViewLoadingTime(Object obj, long j, ViewEvent.LoadingType loadingType) {
            Intrinsics.checkNotNullParameter(obj, "key");
            Intrinsics.checkNotNullParameter(loadingType, "type");
            if (!Intrinsics.areEqual(obj, NavControllerFragmentLifecycleCallbacks.Companion.getNO_DESTINATION_FOUND())) {
                this.advancedRumMonitor.updateViewLoadingTime(obj, j, loadingType);
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/datadog/android/rum/tracking/NavigationViewTrackingStrategy$Companion;", "", "()V", "UNKNOWN_DESTINATION_NAME", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NavigationViewTrackingStrategy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
