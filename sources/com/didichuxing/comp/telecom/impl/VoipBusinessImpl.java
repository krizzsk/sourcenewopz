package com.didichuxing.comp.telecom.impl;

import android.app.Activity;
import android.view.View;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel2;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007JL\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0007¨\u0006\u0012"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/impl/VoipBusinessImpl;", "", "()V", "bindResources", "", "", "", "showTipDialog", "", "context", "Landroid/app/Activity;", "title", "content", "ensureText", "yes", "Landroid/view/View$OnClickListener;", "cancelText", "no", "voip-impl_brpaxRelease"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipBusinessImpl.kt */
public final class VoipBusinessImpl {
    public static final VoipBusinessImpl INSTANCE = new VoipBusinessImpl();

    private VoipBusinessImpl() {
    }

    @JvmStatic
    public static final Map<String, Integer> bindResources() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("voip_call_page_string_call_waiting", Integer.valueOf(R.string.GDriver_IBT_Waiting_for_GfqY));
        hashMap.put("voip_call_notification_logo", Integer.valueOf(R.drawable.voip_biz_logo));
        hashMap.put("voip_call_page_default_avatar", Integer.valueOf(R.drawable.voip_biz_default_avatar));
        hashMap.put("voip_call_opposite_role", Integer.valueOf(R.string.GDriver_IBT__ephh));
        return hashMap;
    }

    @JvmStatic
    public static final void showTipDialog(Activity activity, String str, String str2, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2) {
        Intrinsics.checkParameterIsNotNull(activity, "context");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (LEGODrawer) null;
        if (str == null) {
            str = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        LEGOBtnTextAndCallback lEGOBtnTextAndCallback = new LEGOBtnTextAndCallback(str3, new VoipBusinessImpl$showTipDialog$drawerModel2$1(objectRef, onClickListener));
        if (str4 == null) {
            str4 = "";
        }
        LEGODrawerModel2 lEGODrawerModel2 = new LEGODrawerModel2(str, lEGOBtnTextAndCallback, new LEGOBtnTextAndCallback(str4, new VoipBusinessImpl$showTipDialog$drawerModel2$2(objectRef, onClickListener2)));
        lEGODrawerModel2.setSubTitle(str2);
        lEGODrawerModel2.setIsShowCloseImg(false);
        lEGODrawerModel2.setClickOutsideCanCancel(false);
        objectRef.element = LEGOUICreator.showDrawerTemplate(activity, lEGODrawerModel2);
    }
}
