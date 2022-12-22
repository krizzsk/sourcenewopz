package kshark;

import com.didi.flutter.nacho2.p115v2.NachoConstants;
import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kshark.ReferencePattern;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\bC\b\u0001\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001IB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H ¢\u0006\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bH¨\u0006J"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers;", "", "(Ljava/lang/String;I)V", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "IREQUEST_FINISH_CALLBACK", "ACTIVITY_CLIENT_RECORD__NEXT_IDLE", "SPAN_CONTROLLER", "MEDIA_SESSION_LEGACY_HELPER__SINSTANCE", "TEXT_LINE__SCACHED", "BLOCKING_QUEUE", "INPUT_METHOD_MANAGER_IS_TERRIBLE", "LAYOUT_TRANSITION", "SPELL_CHECKER_SESSION", "SPELL_CHECKER", "ACTIVITY_CHOOSE_MODEL", "MEDIA_PROJECTION_CALLBACK", "SPEECH_RECOGNIZER", "ACCOUNT_MANAGER", "MEDIA_SCANNER_CONNECTION", "USER_MANAGER__SINSTANCE", "APP_WIDGET_HOST_CALLBACKS", "AUDIO_MANAGER", "EDITTEXT_BLINK_MESSAGEQUEUE", "CONNECTIVITY_MANAGER__SINSTANCE", "ACCESSIBILITY_NODE_INFO__MORIGINALTEXT", "ASSIST_STRUCTURE", "ACCESSIBILITY_ITERATORS", "BIOMETRIC_PROMPT", "MAGNIFIER", "BACKDROP_FRAME_RENDERER__MDECORVIEW", "VIEWLOCATIONHOLDER_ROOT", "ACCESSIBILITY_NODE_ID_MANAGER", "TEXT_TO_SPEECH", "WINDOW_MANAGER_GLOBAL", "CONTROLLED_INPUT_CONNECTION_WRAPPER", "TOAST_TN", "SPEN_GESTURE_MANAGER", "CLIPBOARD_UI_MANAGER__SINSTANCE", "SEM_CLIPBOARD_MANAGER__MCONTEXT", "CLIPBOARD_EX_MANAGER", "SEM_EMERGENCY_MANAGER__MCONTEXT", "SEM_PERSONA_MANAGER", "SEM_APP_ICON_SOLUTION", "AW_RESOURCE__SRESOURCES", "TEXT_VIEW__MLAST_HOVERED_VIEW", "PERSONA_MANAGER", "RESOURCES__MCONTEXT", "VIEW_CONFIGURATION__MCONTEXT", "AUDIO_MANAGER__MCONTEXT_STATIC", "ACTIVITY_MANAGER_MCONTEXT", "STATIC_MTARGET_VIEW", "GESTURE_BOOST_MANAGER", "BUBBLE_POPUP_HELPER__SHELPER", "LGCONTEXT__MCONTEXT", "SMART_COVER_MANAGER", "MAPPER_CLIENT", "SYSTEM_SENSOR_MANAGER__MAPPCONTEXTIMPL", "INSTRUMENTATION_RECOMMEND_ACTIVITY", "DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER", "EXTENDED_STATUS_BAR_MANAGER", "OEM_SCENE_CALL_BLOCKER", "REFERENCES", "FINALIZER_WATCHDOG_DAEMON", "MAIN", "LEAK_CANARY_THREAD", "LEAK_CANARY_HEAP_DUMPER", "LEAK_CANARY_INTERNAL", "EVENT_RECEIVER__MMESSAGE_QUEUE", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: AndroidReferenceMatchers.kt */
public enum AndroidReferenceMatchers {
    ;
    
    /* access modifiers changed from: private */
    public static final Function1<AndroidBuildMirror, Boolean> ALWAYS = null;
    public static final Companion Companion = null;
    public static final String HUAWEI = "HUAWEI";
    private static final String LEAK_CANARY_THREAD_NAME = "LeakCanary-Heap-Dump";
    public static final String LENOVO = "LENOVO";

    /* renamed from: LG */
    public static final String f4515LG = "LGE";
    public static final String MEIZU = "Meizu";
    public static final String MOTOROLA = "motorola";
    public static final String NVIDIA = "NVIDIA";
    public static final String ONE_PLUS = "OnePlus";
    public static final String SAMSUNG = "samsung";
    public static final String SHARP = "SHARP";
    public static final String VIVO = "vivo";

    public abstract void add$shark(List<ReferenceMatcher> list);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$IREQUEST_FINISH_CALLBACK;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class IREQUEST_FINISH_CALLBACK extends AndroidReferenceMatchers {
        IREQUEST_FINISH_CALLBACK(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.app.Activity$1", "this$0", "Android Q added a new android.app.IRequestFinishCallback$Stub class. android.app.Activity creates an implementation of that interface as an anonymous subclass. That anonymous subclass has a reference to the activity. Another process is keeping the android.app.IRequestFinishCallback$Stub reference alive long after Activity.onDestroyed() has been called, causing the activity to leak.", AndroidReferenceMatchers$IREQUEST_FINISH_CALLBACK$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$ACTIVITY_CLIENT_RECORD__NEXT_IDLE;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class ACTIVITY_CLIENT_RECORD__NEXT_IDLE extends AndroidReferenceMatchers {
        ACTIVITY_CLIENT_RECORD__NEXT_IDLE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.app.ActivityThread$ActivityClientRecord", "nextIdle", "Android AOSP sometimes keeps a reference to a destroyed activity as a nextIdle client record in the android.app.ActivityThread.mActivities map. Not sure what's going on there, input welcome.", AndroidReferenceMatchers$ACTIVITY_CLIENT_RECORD__NEXT_IDLE$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$SPAN_CONTROLLER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class SPAN_CONTROLLER extends AndroidReferenceMatchers {
        SPAN_CONTROLLER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            Collection collection = list;
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.Editor$SpanController", "this$0", "Editor inserts a special span, which has a reference to the EditText. That span is a NoCopySpan, which makes sure it gets dropped when creating a new SpannableStringBuilder from a given CharSequence. TextView.onSaveInstanceState() does a copy of its mText before saving it in the bundle. Prior to KitKat, that copy was done using the SpannableString constructor, instead of SpannableStringBuilder. The SpannableString constructor does not drop NoCopySpan spans. So we end up with a saved state that holds a reference to the textview and therefore the entire view hierarchy & activity context. Fix: https://github.com/android/platform_frameworks_base/commit/af7dcdf35a37d7a7dbaad7d9869c1c91bce2272b . To fix this, you could override TextView.onSaveInstanceState(), and then use reflection to access TextView.SavedState.mText and clear the NoCopySpan spans.", AndroidReferenceMatchers$SPAN_CONTROLLER$add$1.INSTANCE));
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.Editor$EasyEditSpanController", "this$0", "Editor inserts a special span, which has a reference to the EditText. That span is a NoCopySpan, which makes sure it gets dropped when creating a new SpannableStringBuilder from a given CharSequence. TextView.onSaveInstanceState() does a copy of its mText before saving it in the bundle. Prior to KitKat, that copy was done using the SpannableString constructor, instead of SpannableStringBuilder. The SpannableString constructor does not drop NoCopySpan spans. So we end up with a saved state that holds a reference to the textview and therefore the entire view hierarchy & activity context. Fix: https://github.com/android/platform_frameworks_base/commit/af7dcdf35a37d7a7dbaad7d9869c1c91bce2272b . To fix this, you could override TextView.onSaveInstanceState(), and then use reflection to access TextView.SavedState.mText and clear the NoCopySpan spans.", AndroidReferenceMatchers$SPAN_CONTROLLER$add$2.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$MEDIA_SESSION_LEGACY_HELPER__SINSTANCE;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class MEDIA_SESSION_LEGACY_HELPER__SINSTANCE extends AndroidReferenceMatchers {
        MEDIA_SESSION_LEGACY_HELPER__SINSTANCE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.media.session.MediaSessionLegacyHelper", "sInstance", "MediaSessionLegacyHelper is a static singleton that is lazily instantiated and keeps a reference to the context it's given the first time MediaSessionLegacyHelper.getHelper() is called. This leak was introduced in android-5.0.1_r1 and fixed in Android 5.1.0_r1 by calling context.getApplicationContext(). Fix: https://github.com/android/platform_frameworks_base/commit/9b5257c9c99c4cb541d8e8e78fb04f008b1a9091 To fix this, you could call MediaSessionLegacyHelper.getHelper() early in Application.onCreate() and pass it the application context.", C2354x9e7c2099.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$TEXT_LINE__SCACHED;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class TEXT_LINE__SCACHED extends AndroidReferenceMatchers {
        TEXT_LINE__SCACHED(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.text.TextLine", "sCached", "TextLine.sCached is a pool of 3 TextLine instances. TextLine.recycle() has had at least two bugs that created memory leaks by not correctly clearing the recycled TextLine instances. The first was fixed in android-5.1.0_r1: https://github.com/android/platform_frameworks_base/commit/893d6fe48d37f71e683f722457bea646994a10 The second was fixed, not released yet: https://github.com/android/platform_frameworks_base/commit/b3a9bc038d3a218b1dbdf7b5668e3d6c12be5e To fix this, you could access TextLine.sCached and clear the pool every now and then (e.g. on activity destroy).", AndroidReferenceMatchers$TEXT_LINE__SCACHED$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$BLOCKING_QUEUE;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class BLOCKING_QUEUE extends AndroidReferenceMatchers {
        BLOCKING_QUEUE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            Collection collection = list;
            collection.add(Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "android.os.Message", "obj", "A thread waiting on a blocking queue will leak the last dequeued object as a stack local reference. So when a HandlerThread becomes idle, it keeps a local reference to the last message it received. That message then gets recycled and can be used again. As long as all messages are recycled after being used, this won't be a problem, because these references are cleared when being recycled. However, dialogs create template Message instances to be copied when a message needs to be sent. These Message templates holds references to the dialog listeners, which most likely leads to holding a reference onto the activity in some way. Dialogs never recycle their template Message, assuming these Message instances will get GCed when the dialog is GCed. The combination of these two things creates a high potential for memory leaks as soon as you use dialogs. These memory leaks might be temporary, but some handler threads sleep for a long time. To fix this, you could post empty messages to the idle handler threads from time to time. This won't be easy because you cannot access all handler threads, but a library that is widely used should consider doing this for its own handler threads. This leaks has been shown to happen in both Dalvik and ART.", (Function1) null, 8, (Object) null));
            String str = "A thread waiting on a blocking queue will leak the last dequeued object as a stack local reference. So when a HandlerThread becomes idle, it keeps a local reference to the last message it received. That message then gets recycled and can be used again. As long as all messages are recycled after being used, this won't be a problem, because these references are cleared when being recycled. However, dialogs create template Message instances to be copied when a message needs to be sent. These Message templates holds references to the dialog listeners, which most likely leads to holding a reference onto the activity in some way. Dialogs never recycle their template Message, assuming these Message instances will get GCed when the dialog is GCed. The combination of these two things creates a high potential for memory leaks as soon as you use dialogs. These memory leaks might be temporary, but some handler threads sleep for a long time. To fix this, you could post empty messages to the idle handler threads from time to time. This won't be easy because you cannot access all handler threads, but a library that is widely used should consider doing this for its own handler threads. This leaks has been shown to happen in both Dalvik and ART.";
            collection.add(Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "android.os.Message", "next", str, (Function1) null, 8, (Object) null));
            collection.add(Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "android.os.Message", "target", str, (Function1) null, 8, (Object) null));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class INPUT_METHOD_MANAGER_IS_TERRIBLE extends AndroidReferenceMatchers {
        INPUT_METHOD_MANAGER_IS_TERRIBLE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            Collection collection = list;
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mNextServedView", "When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$1.INSTANCE));
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mServedView", "When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$2.INSTANCE));
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mServedInputConnection", "When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$3.INSTANCE));
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mLastSrvView", "HUAWEI added a mLastSrvView field to InputMethodManager that leaks a reference to the last served view.", AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$4.INSTANCE));
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mCurRootView", "The singleton InputMethodManager is holding a reference to mCurRootView long after the activity has been destroyed. Observed on ICS MR1: https://github.com/square/leakcanary/issues/1#issuecomment-100579429 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$5.INSTANCE));
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mImeInsetsConsumer", "Android Q Beta has a leak where InputMethodManager.mImeInsetsConsumer isn't set to\nnull when the activity is destroyed.", AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$6.INSTANCE));
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mCurrentInputConnection", "In Android Q Beta InputMethodManager keeps its EditableInputConnection after the\nactivity has been destroyed.", AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$7.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$LAYOUT_TRANSITION;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class LAYOUT_TRANSITION extends AndroidReferenceMatchers {
        LAYOUT_TRANSITION(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.animation.LayoutTransition$1", "val$parent", "LayoutTransition leaks parent ViewGroup through ViewTreeObserver.OnPreDrawListener When triggered, this leaks stays until the window is destroyed. Tracked here: https://code.google.com/p/android/issues/detail?id=171830", AndroidReferenceMatchers$LAYOUT_TRANSITION$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$SPELL_CHECKER_SESSION;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class SPELL_CHECKER_SESSION extends AndroidReferenceMatchers {
        SPELL_CHECKER_SESSION(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.textservice.SpellCheckerSession$1", "this$0", "SpellCheckerSessionListenerImpl.mHandler is leaking destroyed Activity when the SpellCheckerSession is closed before the service is connected. Tracked here: https://code.google.com/p/android/issues/detail?id=172542", AndroidReferenceMatchers$SPELL_CHECKER_SESSION$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$SPELL_CHECKER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class SPELL_CHECKER extends AndroidReferenceMatchers {
        SPELL_CHECKER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.SpellChecker$1", "this$0", "SpellChecker holds on to a detached view that points to a destroyed activity. mSpellRunnable is being enqueued, and that callback should be removed when  closeSession() is called. Maybe closeSession() wasn't called, or maybe it was  called after the view was detached.", AndroidReferenceMatchers$SPELL_CHECKER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$ACTIVITY_CHOOSE_MODEL;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class ACTIVITY_CHOOSE_MODEL extends AndroidReferenceMatchers {
        ACTIVITY_CHOOSE_MODEL(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            Collection collection = list;
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("androidx.appcompat.internal.widget.ActivityChooserModel", "mActivityChoserModelPolicy", "ActivityChooserModel holds a static reference to the last set ActivityChooserModelPolicy which can be an activity context. Tracked here: https://code.google.com/p/android/issues/detail?id=172659 Hack: https://gist.github.com/andaag/b05ab66ed0f06167d6e0", AndroidReferenceMatchers$ACTIVITY_CHOOSE_MODEL$add$1.INSTANCE));
            collection.add(Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "android.widget.ActivityChooserModel", "mActivityChoserModelPolicy", "ActivityChooserModel holds a static reference to the last set ActivityChooserModelPolicy which can be an activity context. Tracked here: https://code.google.com/p/android/issues/detail?id=172659 Hack: https://gist.github.com/andaag/b05ab66ed0f06167d6e0", (Function1) null, 8, (Object) null));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$MEDIA_PROJECTION_CALLBACK;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class MEDIA_PROJECTION_CALLBACK extends AndroidReferenceMatchers {
        MEDIA_PROJECTION_CALLBACK(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.media.projection.MediaProjection$MediaProjectionCallback", "this$0", "MediaProjectionCallback is held by another process, and holds on to MediaProjection\nwhich has an activity as its context.", AndroidReferenceMatchers$MEDIA_PROJECTION_CALLBACK$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$SPEECH_RECOGNIZER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class SPEECH_RECOGNIZER extends AndroidReferenceMatchers {
        SPEECH_RECOGNIZER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.speech.SpeechRecognizer$InternalListener", "this$0", "Prior to Android 5, SpeechRecognizer.InternalListener was a non static inner class and leaked the SpeechRecognizer which leaked an activity context. Fixed in AOSP: https://github.com/android/platform_frameworks_base/commit /b37866db469e81aca534ff6186bdafd44352329b", AndroidReferenceMatchers$SPEECH_RECOGNIZER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$ACCOUNT_MANAGER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class ACCOUNT_MANAGER extends AndroidReferenceMatchers {
        ACCOUNT_MANAGER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.accounts.AccountManager$AmsTask$Response", "this$1", "AccountManager$AmsTask$Response is a stub and is held in memory by native code, probably because the reference to the response in the other process hasn't been cleared. AccountManager$AmsTask is holding on to the activity reference to use for launching a new sub- Activity. Tracked here: https://code.google.com/p/android/issues/detail?id=173689 Fix: Pass a null activity reference to the AccountManager methods and then deal with the returned future to to get the result and correctly start an activity when it's available.", AndroidReferenceMatchers$ACCOUNT_MANAGER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$MEDIA_SCANNER_CONNECTION;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class MEDIA_SCANNER_CONNECTION extends AndroidReferenceMatchers {
        MEDIA_SCANNER_CONNECTION(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.media.MediaScannerConnection", "mContext", "The static method MediaScannerConnection.scanFile() takes an activity context but the service might not disconnect after the activity has been destroyed. Tracked here: https://code.google.com/p/android/issues/detail?id=173788 Fix: Create an instance of MediaScannerConnection yourself and pass in the application context. Call connect() and disconnect() manually.", AndroidReferenceMatchers$MEDIA_SCANNER_CONNECTION$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$USER_MANAGER__SINSTANCE;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class USER_MANAGER__SINSTANCE extends AndroidReferenceMatchers {
        USER_MANAGER__SINSTANCE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.os.UserManager", "mContext", "UserManager has a static sInstance field that creates an instance and caches it the first time UserManager.get() is called. This instance is created with the outer context (which is an activity base context). Tracked here: https://code.google.com/p/android/issues/detail?id=173789 Introduced by: https://github.com/android/platform_frameworks_base/commit/27db46850b708070452c0ce49daf5f79503fbde6 Fix: trigger a call to UserManager.get() in Application.onCreate(), so that the UserManager instance gets cached with a reference to the application context.", AndroidReferenceMatchers$USER_MANAGER__SINSTANCE$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$APP_WIDGET_HOST_CALLBACKS;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class APP_WIDGET_HOST_CALLBACKS extends AndroidReferenceMatchers {
        APP_WIDGET_HOST_CALLBACKS(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.appwidget.AppWidgetHost$Callbacks", "this$0", "android.appwidget.AppWidgetHost$Callbacks is a stub and is held in memory native code. The reference to the `mContext` was not being cleared, which caused the Callbacks instance to retain this reference Fixed in AOSP: https://github.com/android/platform_frameworks_base/commit/7a96f3c917e0001ee739b65da37b2fadec7d7765", AndroidReferenceMatchers$APP_WIDGET_HOST_CALLBACKS$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$AUDIO_MANAGER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class AUDIO_MANAGER extends AndroidReferenceMatchers {
        AUDIO_MANAGER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.media.AudioManager$1", "this$0", "Prior to Android M, VideoView required audio focus from AudioManager and never abandoned it, which leaks the Activity context through the AudioManager. The root of the problem is that AudioManager uses whichever context it receives, which in the case of the VideoView example is an Activity, even though it only needs the application's context. The issue is fixed in Android M, and the AudioManager now uses the application's context. Tracked here: https://code.google.com/p/android/issues/detail?id=152173 Fix: https://gist.github.com/jankovd/891d96f476f7a9ce24e2", AndroidReferenceMatchers$AUDIO_MANAGER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$EDITTEXT_BLINK_MESSAGEQUEUE;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class EDITTEXT_BLINK_MESSAGEQUEUE extends AndroidReferenceMatchers {
        EDITTEXT_BLINK_MESSAGEQUEUE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.Editor$Blink", "this$0", "The EditText Blink of the Cursor is implemented using a callback and Messages, which trigger the display of the Cursor. If an AlertDialog or DialogFragment that contains a blinking cursor is detached, a message is posted with a delay after the dialog has been closed and as a result leaks the Activity. This can be fixed manually by calling TextView.setCursorVisible(false) in the dismiss() method of the dialog. Tracked here: https://code.google.com/p/android/issues/detail?id=188551 Fixed in AOSP: https://android.googlesource.com/platform/frameworks/base/+/5b734f2430e9f26c769d6af8ea5645e390fcf5af%5E%21/", AndroidReferenceMatchers$EDITTEXT_BLINK_MESSAGEQUEUE$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$CONNECTIVITY_MANAGER__SINSTANCE;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class CONNECTIVITY_MANAGER__SINSTANCE extends AndroidReferenceMatchers {
        CONNECTIVITY_MANAGER__SINSTANCE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.net.ConnectivityManager", "sInstance", "ConnectivityManager has a sInstance field that is set when the first ConnectivityManager instance is created. ConnectivityManager has a mContext field. When calling activity.getSystemService(Context.CONNECTIVITY_SERVICE) , the first ConnectivityManager instance is created with the activity context and stored in sInstance. That activity context then leaks forever. Until this is fixed, app developers can prevent this leak by making sure the ConnectivityManager is first created with an App Context. E.g. in some static init do: context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE) Tracked here: https://code.google.com/p/android/issues/detail?id=198852 Introduced here: https://github.com/android/platform_frameworks_base/commit/e0bef71662d81caaaa0d7214fb0bef5d39996a69", AndroidReferenceMatchers$CONNECTIVITY_MANAGER__SINSTANCE$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$ACCESSIBILITY_NODE_INFO__MORIGINALTEXT;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class ACCESSIBILITY_NODE_INFO__MORIGINALTEXT extends AndroidReferenceMatchers {
        ACCESSIBILITY_NODE_INFO__MORIGINALTEXT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.accessibility.AccessibilityNodeInfo", "mOriginalText", "AccessibilityNodeInfo has a static sPool of AccessibilityNodeInfo. When AccessibilityNodeInfo instances are released back in the pool, AccessibilityNodeInfo.clear() does not clear the mOriginalText field, which causes spans to leak which in turns causes TextView.ChangeWatcher to leak and the whole view hierarchy. Introduced here: https://android.googlesource.com/platform/frameworks/base/+/193520e3dff5248ddcf8435203bf99d2ba667219%5E%21/core/java/android/view/accessibility/AccessibilityNodeInfo.java", C2350xf2e4c9a2.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$ASSIST_STRUCTURE;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class ASSIST_STRUCTURE extends AndroidReferenceMatchers {
        ASSIST_STRUCTURE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.app.assist.AssistStructure$ViewNodeText", "mText", "AssistStructure (google assistant / autofill) holds on to text spannables on the screen. TextView.ChangeWatcher and android.widget.Editor end up in spans and typically hold on to the view hierarchy", AndroidReferenceMatchers$ASSIST_STRUCTURE$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$ACCESSIBILITY_ITERATORS;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class ACCESSIBILITY_ITERATORS extends AndroidReferenceMatchers {
        ACCESSIBILITY_ITERATORS(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.AccessibilityIterators$LineTextSegmentIterator", "mLayout", "AccessibilityIterators holds on to text layouts which can hold on to spans TextView.ChangeWatcher and android.widget.Editor end up in spans and typically hold on to the view hierarchy", AndroidReferenceMatchers$ACCESSIBILITY_ITERATORS$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$BIOMETRIC_PROMPT;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class BIOMETRIC_PROMPT extends AndroidReferenceMatchers {
        BIOMETRIC_PROMPT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.hardware.biometrics.BiometricPrompt", "mFingerprintManager", "BiometricPrompt holds on to a FingerprintManager which holds on to a destroyed activity.", AndroidReferenceMatchers$BIOMETRIC_PROMPT$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$MAGNIFIER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class MAGNIFIER extends AndroidReferenceMatchers {
        MAGNIFIER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.Magnifier$InternalPopupWindow", "mCallback", "android.widget.Magnifier.InternalPopupWindow registers a frame callback on android.view.ThreadedRenderer.SimpleRenderer which holds it as a native reference. android.widget.Editor$InsertionHandleView registers an OnOperationCompleteCallback on Magnifier.InternalPopupWindow. These references are held after the activity has been destroyed.", AndroidReferenceMatchers$MAGNIFIER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$BACKDROP_FRAME_RENDERER__MDECORVIEW;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class BACKDROP_FRAME_RENDERER__MDECORVIEW extends AndroidReferenceMatchers {
        BACKDROP_FRAME_RENDERER__MDECORVIEW(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("com.android.internal.policy.BackdropFrameRenderer", "mDecorView", "When BackdropFrameRenderer.releaseRenderer() is called, there's an unknown case where mRenderer becomes null but mChoreographer doesn't and the thread doesn't stop and ends up leaking mDecorView which itself holds on to a destroyed activity", C2351xd6b08f9e.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$VIEWLOCATIONHOLDER_ROOT;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class VIEWLOCATIONHOLDER_ROOT extends AndroidReferenceMatchers {
        VIEWLOCATIONHOLDER_ROOT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.ViewGroup$ViewLocationHolder", "mRoot", "In Android P, ViewLocationHolder has an mRoot field that is not cleared in its clear() method. Introduced in https://github.com/aosp-mirror/platform_frameworks_base/commit/86b326012813f09d8f1de7d6d26c986a909d Bug report: https://issuetracker.google.com/issues/112792715", AndroidReferenceMatchers$VIEWLOCATIONHOLDER_ROOT$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$ACCESSIBILITY_NODE_ID_MANAGER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class ACCESSIBILITY_NODE_ID_MANAGER extends AndroidReferenceMatchers {
        ACCESSIBILITY_NODE_ID_MANAGER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.accessibility.AccessibilityNodeIdManager", "mIdsToViews", "Android Q Beta added AccessibilityNodeIdManager which stores all views from their\nonAttachedToWindow() call, until detached. Unfortunately it's possible to trigger\nthe view framework to call detach before attach (by having a view removing itself\nfrom its parent in onAttach, which then causes AccessibilityNodeIdManager to keep\nchildren view forever. Future releases of Q will hold weak references.", AndroidReferenceMatchers$ACCESSIBILITY_NODE_ID_MANAGER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$TEXT_TO_SPEECH;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class TEXT_TO_SPEECH extends AndroidReferenceMatchers {
        TEXT_TO_SPEECH(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            Collection collection = list;
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.speech.tts.TextToSpeech", "mContext", "TextToSpeech.shutdown() does not release its references to context objects. Furthermore, TextToSpeech instances cannot be garbage collected due to other process keeping the references, resulting the context objects leaked. Developers might be able to mitigate the issue by passing application context to TextToSpeech constructor. Tracked at: https://github.com/square/leakcanary/issues/1210 and https://issuetracker.google.com/issues/129250419", AndroidReferenceMatchers$TEXT_TO_SPEECH$add$1.INSTANCE));
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.speech.tts.TtsEngines", "mContext", "TextToSpeech.shutdown() does not release its references to context objects. Furthermore, TextToSpeech instances cannot be garbage collected due to other process keeping the references, resulting the context objects leaked. Developers might be able to mitigate the issue by passing application context to TextToSpeech constructor. Tracked at: https://github.com/square/leakcanary/issues/1210 and https://issuetracker.google.com/issues/129250419", AndroidReferenceMatchers$TEXT_TO_SPEECH$add$2.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$WINDOW_MANAGER_GLOBAL;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class WINDOW_MANAGER_GLOBAL extends AndroidReferenceMatchers {
        WINDOW_MANAGER_GLOBAL(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.WindowManagerGlobal", "mRoots", "ViewRootImpl references a destroyed activity yet it's not detached (still has a view)\n and WindowManagerGlobal still references it.", AndroidReferenceMatchers$WINDOW_MANAGER_GLOBAL$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$CONTROLLED_INPUT_CONNECTION_WRAPPER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class CONTROLLED_INPUT_CONNECTION_WRAPPER extends AndroidReferenceMatchers {
        CONTROLLED_INPUT_CONNECTION_WRAPPER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(Companion.nativeGlobalVariableLeak$default(AndroidReferenceMatchers.Companion, "android.view.inputmethod.InputMethodManager$ControlledInputConnectionWrapper", "ControlledInputConnectionWrapper is held by a global variable in native code. ", (Function1) null, 4, (Object) null));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$TOAST_TN;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class TOAST_TN extends AndroidReferenceMatchers {
        TOAST_TN(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(Companion.nativeGlobalVariableLeak$default(AndroidReferenceMatchers.Companion, "android.widget.Toast$TN", "Toast.TN is held by a global variable in native code due to an IPC call to show the toast.", (Function1) null, 4, (Object) null));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$SPEN_GESTURE_MANAGER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class SPEN_GESTURE_MANAGER extends AndroidReferenceMatchers {
        SPEN_GESTURE_MANAGER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("com.samsung.android.smartclip.SpenGestureManager", "mContext", "SpenGestureManager has a static mContext field that leaks a reference to the activity. Yes, a STATIC mContext field.", AndroidReferenceMatchers$SPEN_GESTURE_MANAGER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$CLIPBOARD_UI_MANAGER__SINSTANCE;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class CLIPBOARD_UI_MANAGER__SINSTANCE extends AndroidReferenceMatchers {
        CLIPBOARD_UI_MANAGER__SINSTANCE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.sec.clipboard.ClipboardUIManager", "mContext", "ClipboardUIManager is a static singleton that leaks an activity context. Fix: trigger a call to ClipboardUIManager.getInstance() in Application.onCreate() , so that the ClipboardUIManager instance gets cached with a reference to the application context. Example: https://gist.github.com/cypressious/91c4fb1455470d803a602838dfcd5774", AndroidReferenceMatchers$CLIPBOARD_UI_MANAGER__SINSTANCE$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$SEM_CLIPBOARD_MANAGER__MCONTEXT;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class SEM_CLIPBOARD_MANAGER__MCONTEXT extends AndroidReferenceMatchers {
        SEM_CLIPBOARD_MANAGER__MCONTEXT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            Collection collection = list;
            collection.add(AndroidReferenceMatchers.Companion.nativeGlobalVariableLeak("com.samsung.android.content.clipboard.SemClipboardManager$1", "SemClipboardManager inner classes are held by native references due to IPC calls ", AndroidReferenceMatchers$SEM_CLIPBOARD_MANAGER__MCONTEXT$add$1.INSTANCE));
            collection.add(AndroidReferenceMatchers.Companion.nativeGlobalVariableLeak("com.samsung.android.content.clipboard.SemClipboardManager$3", "SemClipboardManager inner classes are held by native references due to IPC calls ", AndroidReferenceMatchers$SEM_CLIPBOARD_MANAGER__MCONTEXT$add$2.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$CLIPBOARD_EX_MANAGER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class CLIPBOARD_EX_MANAGER extends AndroidReferenceMatchers {
        CLIPBOARD_EX_MANAGER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            Collection collection = list;
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.sec.clipboard.ClipboardExManager", "mContext", "android.sec.clipboard.ClipboardExManager$IClipboardDataPasteEventImpl$1 is a native callback that holds IClipboardDataPasteEventImpl which holds ClipboardExManager which has a destroyed activity as mContext", AndroidReferenceMatchers$CLIPBOARD_EX_MANAGER$add$1.INSTANCE));
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.sec.clipboard.ClipboardExManager", "mPersonaManager", "android.sec.clipboard.ClipboardExManager$IClipboardDataPasteEventImpl$1 is a native callback that holds IClipboardDataPasteEventImpl which holds ClipboardExManager which holds PersonaManager which has a destroyed activity as mContext", AndroidReferenceMatchers$CLIPBOARD_EX_MANAGER$add$2.INSTANCE));
            collection.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.TextView$IClipboardDataPasteEventImpl", "this$0", "TextView$IClipboardDataPasteEventImpl$1 is held by a native ref, and IClipboardDataPasteEventImpl ends up leaking a detached textview", AndroidReferenceMatchers$CLIPBOARD_EX_MANAGER$add$3.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$SEM_EMERGENCY_MANAGER__MCONTEXT;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class SEM_EMERGENCY_MANAGER__MCONTEXT extends AndroidReferenceMatchers {
        SEM_EMERGENCY_MANAGER__MCONTEXT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("com.samsung.android.emergencymode.SemEmergencyManager", "mContext", "SemEmergencyManager is a static singleton that leaks a DecorContext. Fix: https://gist.github.com/jankovd/a210460b814c04d500eb12025902d60d", AndroidReferenceMatchers$SEM_EMERGENCY_MANAGER__MCONTEXT$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$SEM_PERSONA_MANAGER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class SEM_PERSONA_MANAGER extends AndroidReferenceMatchers {
        SEM_PERSONA_MANAGER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "com.samsung.android.knox.SemPersonaManager", "mContext", (String) null, AndroidReferenceMatchers$SEM_PERSONA_MANAGER$add$1.INSTANCE, 4, (Object) null));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$SEM_APP_ICON_SOLUTION;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class SEM_APP_ICON_SOLUTION extends AndroidReferenceMatchers {
        SEM_APP_ICON_SOLUTION(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "android.app.SemAppIconSolution", "mContext", (String) null, AndroidReferenceMatchers$SEM_APP_ICON_SOLUTION$add$1.INSTANCE, 4, (Object) null));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$AW_RESOURCE__SRESOURCES;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class AW_RESOURCE__SRESOURCES extends AndroidReferenceMatchers {
        AW_RESOURCE__SRESOURCES(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(Companion.staticFieldLeak$default(AndroidReferenceMatchers.Companion, "com.android.org.chromium.android_webview.AwResource", "sResources", (String) null, AndroidReferenceMatchers$AW_RESOURCE__SRESOURCES$add$1.INSTANCE, 4, (Object) null));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$TEXT_VIEW__MLAST_HOVERED_VIEW;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class TEXT_VIEW__MLAST_HOVERED_VIEW extends AndroidReferenceMatchers {
        TEXT_VIEW__MLAST_HOVERED_VIEW(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.widget.TextView", "mLastHoveredView", "mLastHoveredView is a static field in TextView that leaks the last hovered view.", AndroidReferenceMatchers$TEXT_VIEW__MLAST_HOVERED_VIEW$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$PERSONA_MANAGER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class PERSONA_MANAGER extends AndroidReferenceMatchers {
        PERSONA_MANAGER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.os.PersonaManager", "mContext", "android.app.LoadedApk.mResources has a reference to android.content.res.Resources.mPersonaManager which has a reference to android.os.PersonaManager.mContext which is an activity.", AndroidReferenceMatchers$PERSONA_MANAGER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$RESOURCES__MCONTEXT;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class RESOURCES__MCONTEXT extends AndroidReferenceMatchers {
        RESOURCES__MCONTEXT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.content.res.Resources", "mContext", "In AOSP the Resources class does not have a context. Here we have ZygoteInit.mResources (static field) holding on to a Resources instance that has a context that is the activity. Observed here: https://github.com/square/leakcanary/issues/1#issue-74450184", AndroidReferenceMatchers$RESOURCES__MCONTEXT$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$VIEW_CONFIGURATION__MCONTEXT;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class VIEW_CONFIGURATION__MCONTEXT extends AndroidReferenceMatchers {
        VIEW_CONFIGURATION__MCONTEXT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.ViewConfiguration", "mContext", "In AOSP the ViewConfiguration class does not have a context. Here we have ViewConfiguration.sConfigurations (static field) holding on to a ViewConfiguration instance that has a context that is the activity. Observed here: https://github.com/square/leakcanary/issues/1#issuecomment-100324683", AndroidReferenceMatchers$VIEW_CONFIGURATION__MCONTEXT$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$AUDIO_MANAGER__MCONTEXT_STATIC;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class AUDIO_MANAGER__MCONTEXT_STATIC extends AndroidReferenceMatchers {
        AUDIO_MANAGER__MCONTEXT_STATIC(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.media.AudioManager", "mContext_static", "Samsung added a static mContext_static field to AudioManager, holds a reference to the activity. Observed here: https://github.com/square/leakcanary/issues/32", AndroidReferenceMatchers$AUDIO_MANAGER__MCONTEXT_STATIC$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$ACTIVITY_MANAGER_MCONTEXT;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class ACTIVITY_MANAGER_MCONTEXT extends AndroidReferenceMatchers {
        ACTIVITY_MANAGER_MCONTEXT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.app.ActivityManager", "mContext", "Samsung added a static mContext field to ActivityManager, holds a reference to the activity. Observed here: https://github.com/square/leakcanary/issues/177 Fix in comment: https://github.com/square/leakcanary/issues/177#issuecomment-222724283", AndroidReferenceMatchers$ACTIVITY_MANAGER_MCONTEXT$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$STATIC_MTARGET_VIEW;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class STATIC_MTARGET_VIEW extends AndroidReferenceMatchers {
        STATIC_MTARGET_VIEW(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.widget.TextView", "mTargetView", "Samsung added a static mTargetView field to TextView which holds on to detached views.", AndroidReferenceMatchers$STATIC_MTARGET_VIEW$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$GESTURE_BOOST_MANAGER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class GESTURE_BOOST_MANAGER extends AndroidReferenceMatchers {
        GESTURE_BOOST_MANAGER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.gestureboost.GestureBoostManager", "mContext", "GestureBoostManager is a static singleton that leaks an activity context. Fix: https://github.com/square/leakcanary/issues/696#issuecomment-296420756", AndroidReferenceMatchers$GESTURE_BOOST_MANAGER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$BUBBLE_POPUP_HELPER__SHELPER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class BUBBLE_POPUP_HELPER__SHELPER extends AndroidReferenceMatchers {
        BUBBLE_POPUP_HELPER__SHELPER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.widget.BubblePopupHelper", "sHelper", "A static helper for EditText bubble popups leaks a reference to the latest focused view.", AndroidReferenceMatchers$BUBBLE_POPUP_HELPER__SHELPER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$LGCONTEXT__MCONTEXT;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class LGCONTEXT__MCONTEXT extends AndroidReferenceMatchers {
        LGCONTEXT__MCONTEXT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("com.lge.systemservice.core.LGContext", "mContext", "LGContext is a static singleton that leaks an activity context.", AndroidReferenceMatchers$LGCONTEXT__MCONTEXT$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$SMART_COVER_MANAGER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class SMART_COVER_MANAGER extends AndroidReferenceMatchers {
        SMART_COVER_MANAGER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("com.lge.systemservice.core.SmartCoverManager", "mContext", "SmartCoverManager$CallbackRegister is a callback held by a native ref, and SmartCoverManager ends up leaking an activity context.", AndroidReferenceMatchers$SMART_COVER_MANAGER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$MAPPER_CLIENT;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class MAPPER_CLIENT extends AndroidReferenceMatchers {
        MAPPER_CLIENT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("com.nvidia.ControllerMapper.MapperClient$ServiceClient", "this$0", "Not sure exactly what ControllerMapper is about, but there is an anonymous Handler in ControllerMapper.MapperClient.ServiceClient, which leaks ControllerMapper.MapperClient which leaks the activity context.", AndroidReferenceMatchers$MAPPER_CLIENT$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$SYSTEM_SENSOR_MANAGER__MAPPCONTEXTIMPL;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class SYSTEM_SENSOR_MANAGER__MAPPCONTEXTIMPL extends AndroidReferenceMatchers {
        SYSTEM_SENSOR_MANAGER__MAPPCONTEXTIMPL(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.hardware.SystemSensorManager", "mAppContextImpl", "SystemSensorManager stores a reference to context in a static field in its constructor. Fix: use application context to get SensorManager", C2355x1ce4a714.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$INSTRUMENTATION_RECOMMEND_ACTIVITY;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class INSTRUMENTATION_RECOMMEND_ACTIVITY extends AndroidReferenceMatchers {
        INSTRUMENTATION_RECOMMEND_ACTIVITY(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.app.Instrumentation", "mRecommendActivity", "Instrumentation would leak com.android.internal.app.RecommendActivity (in framework.jar) in Meizu FlymeOS 4.5 and above, which is based on Android 5.0 and  above", C2353xc395e254.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER extends AndroidReferenceMatchers {
        DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.app.admin.DevicePolicyManager$SettingsObserver", "this$0", "DevicePolicyManager keeps a reference to the context it has been created with instead of extracting the application context. In this Motorola build, DevicePolicyManager has an inner SettingsObserver class that is a content observer, which is held into memory by a binder transport object.", C2352x590d671a.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$EXTENDED_STATUS_BAR_MANAGER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class EXTENDED_STATUS_BAR_MANAGER extends AndroidReferenceMatchers {
        EXTENDED_STATUS_BAR_MANAGER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.app.ExtendedStatusBarManager", "sInstance", "ExtendedStatusBarManager is held in a static sInstance field and has a mContext\nfield which references a decor context which references a destroyed activity.", AndroidReferenceMatchers$EXTENDED_STATUS_BAR_MANAGER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$OEM_SCENE_CALL_BLOCKER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class OEM_SCENE_CALL_BLOCKER extends AndroidReferenceMatchers {
        OEM_SCENE_CALL_BLOCKER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("com.oneplus.util.OemSceneCallBlocker", "sContext", "OemSceneCallBlocker has a sContext static field which holds on to an activity instance.", AndroidReferenceMatchers$OEM_SCENE_CALL_BLOCKER$add$1.INSTANCE));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$REFERENCES;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class REFERENCES extends AndroidReferenceMatchers {
        REFERENCES(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            Collection collection = list;
            Companion companion = AndroidReferenceMatchers.Companion;
            String name = WeakReference.class.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "WeakReference::class.java.name");
            collection.add(companion.ignoredInstanceField(name, "referent"));
            collection.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("leakcanary.KeyedWeakReference", "referent"));
            Companion companion2 = AndroidReferenceMatchers.Companion;
            String name2 = SoftReference.class.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "SoftReference::class.java.name");
            collection.add(companion2.ignoredInstanceField(name2, "referent"));
            Companion companion3 = AndroidReferenceMatchers.Companion;
            String name3 = PhantomReference.class.getName();
            Intrinsics.checkExpressionValueIsNotNull(name3, "PhantomReference::class.java.name");
            collection.add(companion3.ignoredInstanceField(name3, "referent"));
            collection.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.Finalizer", "prev"));
            collection.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.Finalizer", "element"));
            collection.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.Finalizer", "next"));
            collection.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.FinalizerReference", "prev"));
            collection.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.FinalizerReference", "element"));
            collection.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.FinalizerReference", "next"));
            collection.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("sun.misc.Cleaner", "prev"));
            collection.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("sun.misc.Cleaner", "next"));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$FINALIZER_WATCHDOG_DAEMON;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class FINALIZER_WATCHDOG_DAEMON extends AndroidReferenceMatchers {
        FINALIZER_WATCHDOG_DAEMON(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredJavaLocal("FinalizerWatchdogDaemon"));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$MAIN;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class MAIN extends AndroidReferenceMatchers {
        MAIN(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredJavaLocal(NachoConstants.NACHO_ENTRYPOINT_NAME));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$LEAK_CANARY_THREAD;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class LEAK_CANARY_THREAD extends AndroidReferenceMatchers {
        LEAK_CANARY_THREAD(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredJavaLocal(AndroidReferenceMatchers.LEAK_CANARY_THREAD_NAME));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$LEAK_CANARY_HEAP_DUMPER;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class LEAK_CANARY_HEAP_DUMPER extends AndroidReferenceMatchers {
        LEAK_CANARY_HEAP_DUMPER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("leakcanary.internal.AndroidHeapDumper", "resumedActivity"));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$LEAK_CANARY_INTERNAL;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class LEAK_CANARY_INTERNAL extends AndroidReferenceMatchers {
        LEAK_CANARY_INTERNAL(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("leakcanary.internal.InternalLeakCanary", "application"));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$EVENT_RECEIVER__MMESSAGE_QUEUE;", "Lkshark/AndroidReferenceMatchers;", "add", "", "references", "", "Lkshark/ReferenceMatcher;", "add$shark", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    static final class EVENT_RECEIVER__MMESSAGE_QUEUE extends AndroidReferenceMatchers {
        EVENT_RECEIVER__MMESSAGE_QUEUE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void add$shark(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("android.view.Choreographer$FrameDisplayEventReceiver", "mMessageQueue"));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tJ\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\tJ;\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\b\b\u0002\u0010'\u001a\u00020\t2\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007J1\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010'\u001a\u00020\t2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0002J3\u0010,\u001a\u00020&2\u0006\u0010!\u001a\u00020\t2\b\b\u0002\u0010'\u001a\u00020\t2\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007J;\u0010-\u001a\u00020&2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\b\b\u0002\u0010'\u001a\u00020\t2\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007R\u001f\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006."}, mo175978d2 = {"Lkshark/AndroidReferenceMatchers$Companion;", "", "()V", "ALWAYS", "Lkotlin/Function1;", "Lkshark/AndroidBuildMirror;", "", "Lkotlin/ExtensionFunctionType;", "HUAWEI", "", "LEAK_CANARY_THREAD_NAME", "LENOVO", "LG", "MEIZU", "MOTOROLA", "NVIDIA", "ONE_PLUS", "SAMSUNG", "SHARP", "VIVO", "appDefaults", "", "Lkshark/ReferenceMatcher;", "getAppDefaults", "()Ljava/util/List;", "ignoredReferencesOnly", "getIgnoredReferencesOnly", "buildKnownReferences", "referenceMatchers", "", "Lkshark/AndroidReferenceMatchers;", "ignoredInstanceField", "Lkshark/IgnoredReferenceMatcher;", "className", "fieldName", "ignoredJavaLocal", "threadName", "instanceFieldLeak", "Lkshark/LibraryLeakReferenceMatcher;", "description", "patternApplies", "libraryLeak", "referencePattern", "Lkshark/ReferencePattern;", "nativeGlobalVariableLeak", "staticFieldLeak", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidReferenceMatchers.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<ReferenceMatcher> getIgnoredReferencesOnly() {
            Companion companion = AndroidReferenceMatchers.Companion;
            EnumSet of = EnumSet.of(AndroidReferenceMatchers.REFERENCES, AndroidReferenceMatchers.FINALIZER_WATCHDOG_DAEMON, AndroidReferenceMatchers.MAIN, AndroidReferenceMatchers.LEAK_CANARY_THREAD, AndroidReferenceMatchers.EVENT_RECEIVER__MMESSAGE_QUEUE);
            Intrinsics.checkExpressionValueIsNotNull(of, "EnumSet.of(\n            …MESSAGE_QUEUE\n          )");
            return companion.buildKnownReferences(of);
        }

        public final List<ReferenceMatcher> getAppDefaults() {
            Companion companion = AndroidReferenceMatchers.Companion;
            EnumSet<E> allOf = EnumSet.allOf(AndroidReferenceMatchers.class);
            Intrinsics.checkExpressionValueIsNotNull(allOf, "EnumSet.allOf(AndroidRef…enceMatchers::class.java)");
            return companion.buildKnownReferences(allOf);
        }

        public final List<ReferenceMatcher> buildKnownReferences(Set<? extends AndroidReferenceMatchers> set) {
            Intrinsics.checkParameterIsNotNull(set, "referenceMatchers");
            List<ReferenceMatcher> arrayList = new ArrayList<>();
            for (AndroidReferenceMatchers add$shark : set) {
                add$shark.add$shark(arrayList);
            }
            return arrayList;
        }

        public static /* synthetic */ LibraryLeakReferenceMatcher staticFieldLeak$default(Companion companion, String str, String str2, String str3, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            if ((i & 8) != 0) {
                function1 = AndroidReferenceMatchers.ALWAYS;
            }
            return companion.staticFieldLeak(str, str2, str3, function1);
        }

        public final LibraryLeakReferenceMatcher staticFieldLeak(String str, String str2, String str3, Function1<? super AndroidBuildMirror, Boolean> function1) {
            Intrinsics.checkParameterIsNotNull(str, "className");
            Intrinsics.checkParameterIsNotNull(str2, "fieldName");
            Intrinsics.checkParameterIsNotNull(str3, "description");
            Intrinsics.checkParameterIsNotNull(function1, "patternApplies");
            return libraryLeak(new ReferencePattern.StaticFieldPattern(str, str2), str3, function1);
        }

        public static /* synthetic */ LibraryLeakReferenceMatcher instanceFieldLeak$default(Companion companion, String str, String str2, String str3, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            if ((i & 8) != 0) {
                function1 = AndroidReferenceMatchers.ALWAYS;
            }
            return companion.instanceFieldLeak(str, str2, str3, function1);
        }

        public final LibraryLeakReferenceMatcher instanceFieldLeak(String str, String str2, String str3, Function1<? super AndroidBuildMirror, Boolean> function1) {
            Intrinsics.checkParameterIsNotNull(str, "className");
            Intrinsics.checkParameterIsNotNull(str2, "fieldName");
            Intrinsics.checkParameterIsNotNull(str3, "description");
            Intrinsics.checkParameterIsNotNull(function1, "patternApplies");
            return libraryLeak(new ReferencePattern.InstanceFieldPattern(str, str2), str3, function1);
        }

        public static /* synthetic */ LibraryLeakReferenceMatcher nativeGlobalVariableLeak$default(Companion companion, String str, String str2, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            if ((i & 4) != 0) {
                function1 = AndroidReferenceMatchers.ALWAYS;
            }
            return companion.nativeGlobalVariableLeak(str, str2, function1);
        }

        public final LibraryLeakReferenceMatcher nativeGlobalVariableLeak(String str, String str2, Function1<? super AndroidBuildMirror, Boolean> function1) {
            Intrinsics.checkParameterIsNotNull(str, "className");
            Intrinsics.checkParameterIsNotNull(str2, "description");
            Intrinsics.checkParameterIsNotNull(function1, "patternApplies");
            return libraryLeak(new ReferencePattern.NativeGlobalVariablePattern(str), str2, function1);
        }

        private final LibraryLeakReferenceMatcher libraryLeak(ReferencePattern referencePattern, String str, Function1<? super AndroidBuildMirror, Boolean> function1) {
            return new LibraryLeakReferenceMatcher(referencePattern, str, new AndroidReferenceMatchers$Companion$libraryLeak$1(function1));
        }

        public final IgnoredReferenceMatcher ignoredInstanceField(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "className");
            Intrinsics.checkParameterIsNotNull(str2, "fieldName");
            return new IgnoredReferenceMatcher(new ReferencePattern.InstanceFieldPattern(str, str2));
        }

        public final IgnoredReferenceMatcher ignoredJavaLocal(String str) {
            Intrinsics.checkParameterIsNotNull(str, "threadName");
            return new IgnoredReferenceMatcher(new ReferencePattern.JavaLocalPattern(str));
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        ALWAYS = AndroidReferenceMatchers$Companion$ALWAYS$1.INSTANCE;
    }
}
