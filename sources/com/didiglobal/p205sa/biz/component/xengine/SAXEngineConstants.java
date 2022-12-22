package com.didiglobal.p205sa.biz.component.xengine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/xengine/SAXEngineConstants;", "", "()V", "REQUEST_KEY_ALERT", "", "getREQUEST_KEY_ALERT", "()Ljava/lang/String;", "setREQUEST_KEY_ALERT", "(Ljava/lang/String;)V", "REQUEST_KEY_SHEET", "getREQUEST_KEY_SHEET", "setREQUEST_KEY_SHEET", "REQUEST_KEY_TOAST", "getREQUEST_KEY_TOAST", "setREQUEST_KEY_TOAST", "SA_EVENT_XENGINE_COMMIT", "SA_XENGINE_TYPE", "SCENE_SA_ACTIVITY", "SCENE_SA_HOME", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.xengine.SAXEngineConstants */
/* compiled from: SAXEngineConstants.kt */
public final class SAXEngineConstants {
    public static final SAXEngineConstants INSTANCE = new SAXEngineConstants();
    public static final String SA_EVENT_XENGINE_COMMIT = "SA_EVENT_XENGINE_COMMIT";
    public static final String SA_XENGINE_TYPE = "SA_XENGINE";
    public static final String SCENE_SA_ACTIVITY = "sa_activity";
    public static final String SCENE_SA_HOME = "sa_home";

    /* renamed from: a */
    private static String f51201a = "passenger_newSheet";

    /* renamed from: b */
    private static String f51202b = "passenger_newPopup";

    /* renamed from: c */
    private static String f51203c = "passenger_toast";

    private SAXEngineConstants() {
    }

    public final String getREQUEST_KEY_SHEET() {
        return f51201a;
    }

    public final void setREQUEST_KEY_SHEET(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f51201a = str;
    }

    public final String getREQUEST_KEY_ALERT() {
        return f51202b;
    }

    public final void setREQUEST_KEY_ALERT(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f51202b = str;
    }

    public final String getREQUEST_KEY_TOAST() {
        return f51203c;
    }

    public final void setREQUEST_KEY_TOAST(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f51203c = str;
    }
}
