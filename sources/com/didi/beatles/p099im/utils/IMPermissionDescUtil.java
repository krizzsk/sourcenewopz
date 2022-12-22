package com.didi.beatles.p099im.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ$\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/beatles/im/utils/IMPermissionDescUtil;", "", "()V", "decorView", "Landroid/view/ViewGroup;", "rootView", "Landroid/view/View;", "hidePermissionDesc", "", "showPermissionDesc", "context", "Landroid/content/Context;", "permissionStr", "", "name", "desc", "im_library_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.beatles.im.utils.IMPermissionDescUtil */
/* compiled from: IMPermissionDescUtil.kt */
public final class IMPermissionDescUtil {
    public static final IMPermissionDescUtil INSTANCE = new IMPermissionDescUtil();

    /* renamed from: a */
    private static View f9784a;

    /* renamed from: b */
    private static ViewGroup f9785b;

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    /* renamed from: com.didi.beatles.im.utils.IMPermissionDescUtil$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Permisssion.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Permisssion.CAMERA.ordinal()] = 1;
            $EnumSwitchMapping$0[Permisssion.EXTERNAL_STORAGE.ordinal()] = 2;
            $EnumSwitchMapping$0[Permisssion.SOUND_RECORDING.ordinal()] = 3;
        }
    }

    private IMPermissionDescUtil() {
    }

    public final void showPermissionDesc(Context context, String str, String str2) {
        if (context != null && (context instanceof Activity)) {
            Window window = ((Activity) context).getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "this.window");
            View decorView = window.getDecorView();
            if (decorView != null) {
                f9785b = (ViewGroup) decorView;
                LayoutInflater from = LayoutInflater.from(context);
                ViewGroup viewGroup = f9785b;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("decorView");
                }
                View inflate = from.inflate(R.layout.im_common_permission_desc_view, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(this…c_view, decorView, false)");
                f9784a = inflate;
                if (inflate == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rootView");
                }
                View findViewById = inflate.findViewById(R.id.permission_name);
                Intrinsics.checkExpressionValueIsNotNull(findViewById, "rootView.findViewById(R.id.permission_name)");
                TextView textView = (TextView) findViewById;
                View view = f9784a;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rootView");
                }
                View findViewById2 = view.findViewById(R.id.permission_desc);
                Intrinsics.checkExpressionValueIsNotNull(findViewById2, "rootView.findViewById(R.id.permission_desc)");
                TextView textView2 = (TextView) findViewById2;
                CharSequence charSequence = str;
                if (!TextUtils.isEmpty(charSequence)) {
                    CharSequence charSequence2 = str2;
                    if (!TextUtils.isEmpty(charSequence2)) {
                        textView.setText(charSequence);
                        textView2.setText(charSequence2);
                        ViewGroup viewGroup2 = f9785b;
                        if (viewGroup2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("decorView");
                        }
                        View view2 = f9784a;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("rootView");
                        }
                        viewGroup2.addView(view2);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public final void showPermissionDesc(Context context, String str) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "permissionStr");
        if (context != null && (context instanceof Activity)) {
            Window window = ((Activity) context).getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "this.window");
            View decorView = window.getDecorView();
            if (decorView != null) {
                f9785b = (ViewGroup) decorView;
                LayoutInflater from = LayoutInflater.from(context);
                ViewGroup viewGroup = f9785b;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("decorView");
                }
                boolean z = false;
                View inflate = from.inflate(R.layout.im_common_permission_desc_view, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(this…c_view, decorView, false)");
                f9784a = inflate;
                if (inflate == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rootView");
                }
                View findViewById = inflate.findViewById(R.id.permission_name);
                Intrinsics.checkExpressionValueIsNotNull(findViewById, "rootView.findViewById(R.id.permission_name)");
                TextView textView = (TextView) findViewById;
                View view = f9784a;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rootView");
                }
                View findViewById2 = view.findViewById(R.id.permission_desc);
                Intrinsics.checkExpressionValueIsNotNull(findViewById2, "rootView.findViewById(R.id.permission_desc)");
                TextView textView2 = (TextView) findViewById2;
                Permisssion permisssion = Permisssion.NO;
                int hashCode = str.hashCode();
                if (hashCode != -406040016) {
                    if (hashCode != 463403621) {
                        if (hashCode == 1831139720 && str.equals(Permission.RECORD_AUDIO)) {
                            permisssion = Permisssion.SOUND_RECORDING;
                        }
                    } else if (str.equals(Permission.CAMERA)) {
                        permisssion = Permisssion.CAMERA;
                    }
                } else if (str.equals(Permission.READ_EXTERNAL_STORAGE)) {
                    permisssion = Permisssion.EXTERNAL_STORAGE;
                }
                int i = WhenMappings.$EnumSwitchMapping$0[permisssion.ordinal()];
                String str3 = "";
                if (i == 1) {
                    str3 = context.getString(R.string.permission_camera_title);
                    Intrinsics.checkExpressionValueIsNotNull(str3, "getString(R.string.permission_camera_title)");
                    str2 = context.getString(R.string.permission_camera_desc);
                    Intrinsics.checkExpressionValueIsNotNull(str2, "getString(R.string.permission_camera_desc)");
                } else if (i == 2) {
                    str3 = context.getString(R.string.permission_external_storage_title);
                    Intrinsics.checkExpressionValueIsNotNull(str3, "getString(R.string.permi…n_external_storage_title)");
                    str2 = context.getString(R.string.permission_external_storage_desc);
                    Intrinsics.checkExpressionValueIsNotNull(str2, "getString(R.string.permi…on_external_storage_desc)");
                } else if (i != 3) {
                    str2 = str3;
                } else {
                    str3 = context.getString(R.string.permission_sound_record_title);
                    Intrinsics.checkExpressionValueIsNotNull(str3, "getString(R.string.permission_sound_record_title)");
                    str2 = context.getString(R.string.permission_sound_record_desc);
                    Intrinsics.checkExpressionValueIsNotNull(str2, "getString(R.string.permission_sound_record_desc)");
                }
                CharSequence charSequence = str3;
                if (charSequence.length() > 0) {
                    CharSequence charSequence2 = str2;
                    if (charSequence2.length() > 0) {
                        z = true;
                    }
                    if (z) {
                        textView.setText(charSequence);
                        textView2.setText(charSequence2);
                        ViewGroup viewGroup2 = f9785b;
                        if (viewGroup2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("decorView");
                        }
                        View view2 = f9784a;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("rootView");
                        }
                        viewGroup2.addView(view2);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public final void hidePermissionDesc() {
        ViewGroup viewGroup = f9785b;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decorView");
        }
        View view = f9784a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        viewGroup.removeView(view);
    }
}
