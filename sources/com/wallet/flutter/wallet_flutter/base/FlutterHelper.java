package com.wallet.flutter.wallet_flutter.base;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.taxis99.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.MethodCall;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/base/FlutterHelper;", "", "()V", "Companion", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterHelper.kt */
public final class FlutterHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Handler f56040a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Gson f56041b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Map<String, IFlutterPluginBindingOwner> f56042c = new LinkedHashMap();

    @Metadata(mo175977d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J&\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010!\u001a\u00020\"J\u001c\u0010#\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0012J\u0010\u0010$\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\rJ\u0014\u0010%\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0002JH\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010+\u001a\u00020\"2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010.\u001a\u00020\"2\b\b\u0002\u0010/\u001a\u00020\u0014J\u001a\u00100\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u00101\u001a\u0004\u0018\u00010\u000eJ\u001c\u00102\u001a\u00020\u00102\u000e\b\u0004\u00103\u001a\b\u0012\u0004\u0012\u00020\u001004H\bø\u0001\u0000J\u0010\u00105\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u00066"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/base/FlutterHelper$Companion;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "pluginBindingMap", "", "", "Lcom/wallet/flutter/wallet_flutter/base/IFlutterPluginBindingOwner;", "callbackMethod", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "resultCode", "", "intent", "Landroid/content/Intent;", "(Landroidx/fragment/app/FragmentActivity;ILandroid/content/Intent;)Lkotlin/Unit;", "callbackMethodFail", "(Landroidx/fragment/app/FragmentActivity;Landroid/content/Intent;)Lkotlin/Unit;", "convertViewToBitmap", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "finishFlutterAfterStartOtherActivity", "pluginBindingId", "proxyActivity", "slideOut", "", "forceFinishFlutter", "forceFlutterResumed", "getPluginBindingOwner", "proxyByActivity", "call", "Lio/flutter/plugin/common/MethodCall;", "bindingOwner", "Lcom/wallet/flutter/wallet_flutter/base/IActivityAwareOwner;", "withMethodParams", "otherParams", "Lorg/json/JSONObject;", "forResult", "requestCode", "registerFlutterPluginBindingOwner", "flutterPluginBinding", "runOnMain", "block", "Lkotlin/Function0;", "unregisterFlutterPluginBindingOwner", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FlutterHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Handler getHandler() {
            return FlutterHelper.f56040a;
        }

        public final void runOnMain(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            if (Intrinsics.areEqual((Object) Thread.currentThread(), (Object) Looper.getMainLooper().getThread())) {
                function0.invoke();
            } else {
                getHandler().post(new FlutterHelper$Companion$runOnMain$1(function0));
            }
        }

        public final Gson getGson() {
            return FlutterHelper.f56041b;
        }

        public final void registerFlutterPluginBindingOwner(String str, IFlutterPluginBindingOwner iFlutterPluginBindingOwner) {
            if (str != null) {
                FlutterHelper.f56042c.put(str, iFlutterPluginBindingOwner);
            }
        }

        public final void unregisterFlutterPluginBindingOwner(String str) {
            if (str != null) {
                FlutterHelper.f56042c.put(str, (Object) null);
                IFlutterPluginBindingOwner iFlutterPluginBindingOwner = (IFlutterPluginBindingOwner) FlutterHelper.f56042c.remove(str);
            }
        }

        private final IFlutterPluginBindingOwner getPluginBindingOwner(String str) {
            if (str == null) {
                return null;
            }
            return (IFlutterPluginBindingOwner) FlutterHelper.f56042c.get(str);
        }

        public final void forceFlutterResumed(String str) {
            IFlutterPluginBindingOwner pluginBindingOwner;
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
            if (str != null && (pluginBindingOwner = FlutterHelper.Companion.getPluginBindingOwner(str)) != null && (flutterPluginBinding = pluginBindingOwner.getFlutterPluginBinding()) != null) {
                flutterPluginBinding.getFlutterEngine().getLifecycleChannel().appIsResumed();
            }
        }

        public static /* synthetic */ boolean proxyByActivity$default(Companion companion, MethodCall methodCall, IActivityAwareOwner iActivityAwareOwner, String str, boolean z, JSONObject jSONObject, boolean z2, int i, int i2, Object obj) {
            return companion.proxyByActivity(methodCall, iActivityAwareOwner, str, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? null : jSONObject, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? -1 : i);
        }

        public final boolean proxyByActivity(MethodCall methodCall, IActivityAwareOwner iActivityAwareOwner, String str, boolean z, JSONObject jSONObject, boolean z2, int i) {
            Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(iActivityAwareOwner, "bindingOwner");
            Intrinsics.checkNotNullParameter(str, "pluginBindingId");
            ActivityPluginBinding activityPluginBinding = iActivityAwareOwner.getActivityPluginBinding();
            if (activityPluginBinding == null) {
                return false;
            }
            Intent intent = new Intent(activityPluginBinding.getActivity(), FlutterProxyActivity.class);
            intent.putExtra(FlutterProxyActivity.methodNameKey, methodCall.method);
            intent.putExtra(FlutterProxyActivity.pluginBindingIdKey, str);
            if (z && methodCall.arguments != null) {
                intent.putExtra(FlutterProxyActivity.methodParamsKey, FlutterHelper.Companion.getGson().toJson(methodCall.arguments));
            }
            if (jSONObject != null) {
                intent.putExtra(FlutterProxyActivity.otherParamsKey, jSONObject.toString());
            }
            if (z2) {
                activityPluginBinding.getActivity().startActivityForResult(intent, i);
                return true;
            }
            activityPluginBinding.getActivity().startActivity(intent);
            return true;
        }

        public static /* synthetic */ Unit callbackMethod$default(Companion companion, FragmentActivity fragmentActivity, int i, Intent intent, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = -1;
            }
            if ((i2 & 4) != 0) {
                intent = null;
            }
            return companion.callbackMethod(fragmentActivity, i, intent);
        }

        public final Unit callbackMethod(FragmentActivity fragmentActivity, int i, Intent intent) {
            if (fragmentActivity == null) {
                return null;
            }
            fragmentActivity.setResult(i, intent);
            fragmentActivity.finish();
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit callbackMethodFail$default(Companion companion, FragmentActivity fragmentActivity, Intent intent, int i, Object obj) {
            if ((i & 2) != 0) {
                intent = null;
            }
            return companion.callbackMethodFail(fragmentActivity, intent);
        }

        public final Unit callbackMethodFail(FragmentActivity fragmentActivity, Intent intent) {
            return callbackMethod(fragmentActivity, 0, intent);
        }

        public static /* synthetic */ void forceFinishFlutter$default(Companion companion, String str, FragmentActivity fragmentActivity, int i, Object obj) {
            if ((i & 2) != 0) {
                fragmentActivity = null;
            }
            companion.forceFinishFlutter(str, fragmentActivity);
        }

        public final void forceFinishFlutter(String str, FragmentActivity fragmentActivity) {
            IFlutterPluginBindingOwner iFlutterPluginBindingOwner;
            ActivityPluginBinding flutterActivityBinding;
            Activity activity;
            if (fragmentActivity != null) {
                fragmentActivity.finish();
            }
            if (str != null && (iFlutterPluginBindingOwner = (IFlutterPluginBindingOwner) FlutterHelper.f56042c.get(str)) != null && (flutterActivityBinding = iFlutterPluginBindingOwner.getFlutterActivityBinding()) != null && (activity = flutterActivityBinding.getActivity()) != null) {
                activity.finish();
            }
        }

        public static /* synthetic */ void finishFlutterAfterStartOtherActivity$default(Companion companion, String str, FragmentActivity fragmentActivity, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                fragmentActivity = null;
            }
            if ((i & 4) != 0) {
                z = true;
            }
            companion.finishFlutterAfterStartOtherActivity(str, fragmentActivity, z);
        }

        public final void finishFlutterAfterStartOtherActivity(String str, FragmentActivity fragmentActivity, boolean z) {
            IFlutterPluginBindingOwner iFlutterPluginBindingOwner;
            ActivityPluginBinding flutterActivityBinding;
            Activity activity;
            if (fragmentActivity != null) {
                fragmentActivity.finish();
            }
            if (str != null && (iFlutterPluginBindingOwner = (IFlutterPluginBindingOwner) FlutterHelper.f56042c.get(str)) != null && (flutterActivityBinding = iFlutterPluginBindingOwner.getFlutterActivityBinding()) != null && (activity = flutterActivityBinding.getActivity()) != null) {
                View decorView = activity.getWindow().getDecorView();
                Companion companion = FlutterHelper.Companion;
                View decorView2 = activity.getWindow().getDecorView();
                Intrinsics.checkNotNullExpressionValue(decorView2, "it.window.decorView");
                decorView.setBackground(new BitmapDrawable(companion.convertViewToBitmap(decorView2)));
                activity.finish();
                if (z) {
                    activity.overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
                }
            }
        }

        private final Bitmap convertViewToBitmap(View view) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
            return createBitmap;
        }
    }

    static {
        Gson create = new GsonBuilder().registerTypeAdapter(new FlutterHelper$Companion$gson$1().getType(), new ObjectTypeAdapter()).create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder()\n          …  )\n            .create()");
        f56041b = create;
    }
}
