package p242io.github.ponnamkarthik.toast.fluttertoast;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.blocks.constant.Const;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lio/github/ponnamkarthik/toast/fluttertoast/MethodCallHandlerImpl;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "mToast", "Landroid/widget/Toast;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "resetToast", "fluttertoast_release"}, mo175979k = 1, mo175980mv = {1, 6, 0}, mo175982xi = 48)
/* renamed from: io.github.ponnamkarthik.toast.fluttertoast.MethodCallHandlerImpl */
/* compiled from: MethodCallHandlerImpl.kt */
public final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private Context f58003a;

    /* renamed from: b */
    private Toast f58004b;

    public MethodCallHandlerImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f58003a = context;
    }

    public final Context getContext() {
        return this.f58003a;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.f58003a = context;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Toast toast;
        int i;
        Toast toast2;
        Drawable drawable;
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        Intrinsics.checkNotNullParameter(methodCall2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result2, "result");
        String str = methodCall2.method;
        if (Intrinsics.areEqual((Object) str, (Object) InternalJSMethod.SHOW_TOAST)) {
            String valueOf = String.valueOf(methodCall2.argument("msg"));
            String valueOf2 = String.valueOf(methodCall2.argument("length"));
            String valueOf3 = String.valueOf(methodCall2.argument("gravity"));
            Number number = (Number) methodCall2.argument("bgcolor");
            Number number2 = (Number) methodCall2.argument("textcolor");
            Number number3 = (Number) methodCall2.argument(Const.BlockParamConst.FONT_SIZE);
            if (Intrinsics.areEqual((Object) valueOf3, (Object) "top")) {
                i = 48;
            } else {
                i = Intrinsics.areEqual((Object) valueOf3, (Object) "center") ? 17 : 80;
            }
            boolean areEqual = Intrinsics.areEqual((Object) valueOf2, (Object) "long");
            if (number == null || Build.VERSION.SDK_INT > 31) {
                Toast makeText = Toast.makeText(this.f58003a, valueOf, areEqual ? 1 : 0);
                Intrinsics.checkNotNullExpressionValue(makeText, "makeText(context, mMessage, mDuration)");
                this.f58004b = makeText;
                if (Build.VERSION.SDK_INT <= 31) {
                    try {
                        Toast toast3 = this.f58004b;
                        if (toast3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mToast");
                            toast3 = null;
                        }
                        View view = toast3.getView();
                        Intrinsics.checkNotNull(view);
                        View findViewById = view.findViewById(16908299);
                        Intrinsics.checkNotNullExpressionValue(findViewById, "mToast.view!!.findViewById(android.R.id.message)");
                        TextView textView = (TextView) findViewById;
                        if (number3 != null) {
                            textView.setTextSize(number3.floatValue());
                        }
                        if (number2 != null) {
                            textView.setTextColor(number2.intValue());
                        }
                    } catch (Exception unused) {
                    }
                }
            } else {
                Object systemService = this.f58003a.getSystemService("layout_inflater");
                if (systemService != null) {
                    View inflate = ((LayoutInflater) systemService).inflate(R.layout.toast_custom, (ViewGroup) null);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.text);
                    textView2.setText(valueOf);
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable = this.f58003a.getDrawable(R.drawable.corner);
                        Intrinsics.checkNotNull(drawable);
                        Intrinsics.checkNotNullExpressionValue(drawable, "{\n                      …)!!\n                    }");
                    } else {
                        drawable = this.f58003a.getResources().getDrawable(R.drawable.corner);
                        Intrinsics.checkNotNullExpressionValue(drawable, "{\n                      …er)\n                    }");
                    }
                    drawable.setColorFilter(number.intValue(), PorterDuff.Mode.SRC_IN);
                    textView2.setBackground(drawable);
                    if (number3 != null) {
                        textView2.setTextSize(number3.floatValue());
                    }
                    if (number2 != null) {
                        textView2.setTextColor(number2.intValue());
                    }
                    Toast toast4 = new Toast(this.f58003a);
                    this.f58004b = toast4;
                    if (toast4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mToast");
                        toast4 = null;
                    }
                    toast4.setDuration(areEqual);
                    Toast toast5 = this.f58004b;
                    if (toast5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mToast");
                        toast5 = null;
                    }
                    toast5.setView(inflate);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
                }
            }
            if (Build.VERSION.SDK_INT <= 31) {
                if (i == 17) {
                    Toast toast6 = this.f58004b;
                    if (toast6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mToast");
                        toast6 = null;
                    }
                    toast6.setGravity(i, 0, 0);
                } else if (i != 48) {
                    Toast toast7 = this.f58004b;
                    if (toast7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mToast");
                        toast7 = null;
                    }
                    toast7.setGravity(i, 0, 100);
                } else {
                    Toast toast8 = this.f58004b;
                    if (toast8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mToast");
                        toast8 = null;
                    }
                    toast8.setGravity(i, 0, 100);
                }
            }
            Context context = this.f58003a;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new Runnable() {
                    public final void run() {
                        MethodCallHandlerImpl.m41770a(MethodCallHandlerImpl.this);
                    }
                });
            } else {
                Toast toast9 = this.f58004b;
                if (toast9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mToast");
                    toast2 = null;
                } else {
                    toast2 = toast9;
                }
                SystemUtils.showToast(toast2);
            }
            resetToast();
            result2.success(true);
        } else if (Intrinsics.areEqual((Object) str, (Object) "cancel")) {
            Toast toast10 = this.f58004b;
            if (toast10 != null) {
                if (toast10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mToast");
                    toast = null;
                } else {
                    toast = toast10;
                }
                toast.cancel();
            }
            result2.success(true);
        } else {
            result.notImplemented();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m41770a(MethodCallHandlerImpl methodCallHandlerImpl) {
        Intrinsics.checkNotNullParameter(methodCallHandlerImpl, "this$0");
        Toast toast = methodCallHandlerImpl.f58004b;
        if (toast == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToast");
            toast = null;
        }
        SystemUtils.showToast(toast);
    }

    public final void resetToast() {
        Toast toast = this.f58004b;
        if (toast != null) {
            if (toast == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mToast");
            }
            Toast toast2 = this.f58004b;
            if (toast2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mToast");
                toast2 = null;
            }
            View view = toast2.getView();
            boolean z = false;
            if (view != null && view.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        MethodCallHandlerImpl.m41771b(MethodCallHandlerImpl.this);
                    }
                }, 1000);
            } else if (this.f58004b == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mToast");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m41771b(MethodCallHandlerImpl methodCallHandlerImpl) {
        Intrinsics.checkNotNullParameter(methodCallHandlerImpl, "this$0");
        methodCallHandlerImpl.resetToast();
    }
}
