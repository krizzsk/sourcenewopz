package com.didi.map.sdk.sharetrack.common;

import com.didi.map.sdk.sharetrack.external.round.BaseRoundStrategy;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006#"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/common/ShareTrackApolloHelper;", "", "()V", "EDA_arrived_pass", "", "getEDA_arrived_pass", "()I", "setEDA_arrived_pass", "(I)V", "EDA_arriving_TTS", "getEDA_arriving_TTS", "setEDA_arriving_TTS", "canDebugToast", "", "getCanDebugToast", "()Z", "setCanDebugToast", "(Z)V", "distance_pass_long_abnormal_air", "getDistance_pass_long_abnormal_air", "setDistance_pass_long_abnormal_air", "distance_pass_long_abnormal_pt", "getDistance_pass_long_abnormal_pt", "setDistance_pass_long_abnormal_pt", "distance_pass_long_normal", "getDistance_pass_long_normal", "setDistance_pass_long_normal", "isV3Enable", "setV3Enable", "noRoadThreshold", "getNoRoadThreshold", "setNoRoadThreshold", "shouldTrackEvent", "getShouldTrackEvent", "setShouldTrackEvent", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ShareTrackApolloHelper.kt */
public final class ShareTrackApolloHelper {
    public static final ShareTrackApolloHelper INSTANCE = new ShareTrackApolloHelper();

    /* renamed from: a */
    private static boolean f28614a;

    /* renamed from: b */
    private static int f28615b;

    /* renamed from: c */
    private static int f28616c;

    /* renamed from: d */
    private static int f28617d;

    /* renamed from: e */
    private static int f28618e;

    /* renamed from: f */
    private static int f28619f;

    /* renamed from: g */
    private static int f28620g;

    /* renamed from: h */
    private static int f28621h;

    /* renamed from: i */
    private static int f28622i;

    static {
        IExperiment experiment;
        f28615b = 30;
        f28617d = 100;
        f28618e = 15;
        f28619f = 100;
        f28620g = 100;
        f28621h = 80;
        f28622i = 1;
        IToggle toggle = Apollo.getToggle("map_driver_android_mapkit_debug_toast_toggle");
        if (toggle != null) {
            f28614a = toggle.allow();
        }
        IToggle toggle2 = Apollo.getToggle("map_driver_round_road_AB");
        if (!(toggle2 == null || (experiment = toggle2.getExperiment()) == null)) {
            Object param = experiment.getParam("isV3Enable", 0);
            Intrinsics.checkExpressionValueIsNotNull(param, "it.getParam(\"isV3Enable\", 0)");
            f28616c = ((Number) param).intValue();
            Object param2 = experiment.getParam("EDA_arriving_TTS", 100);
            Intrinsics.checkExpressionValueIsNotNull(param2, "it.getParam(\"EDA_arriving_TTS\", 100)");
            f28617d = ((Number) param2).intValue();
            Object param3 = experiment.getParam("EDA_arrived_pass", 15);
            Intrinsics.checkExpressionValueIsNotNull(param3, "it.getParam(\"EDA_arrived_pass\", 15)");
            f28618e = ((Number) param3).intValue();
            Object param4 = experiment.getParam("distance_pass_long_abnormal_air", 100);
            Intrinsics.checkExpressionValueIsNotNull(param4, "it.getParam(\"distance_pa…_long_abnormal_air\", 100)");
            f28619f = ((Number) param4).intValue();
            Object param5 = experiment.getParam("distance_pass_long_abnormal_pt", 100);
            Intrinsics.checkExpressionValueIsNotNull(param5, "it.getParam(\"distance_pass_long_abnormal_pt\", 100)");
            f28620g = ((Number) param5).intValue();
            Object param6 = experiment.getParam("distance_pass_long_normal", 80);
            Intrinsics.checkExpressionValueIsNotNull(param6, "it.getParam(\"distance_pass_long_normal\", 80)");
            f28621h = ((Number) param6).intValue();
            Object param7 = experiment.getParam("track_event", 1);
            Intrinsics.checkExpressionValueIsNotNull(param7, "it.getParam(\"track_event\", 1)");
            f28622i = ((Number) param7).intValue();
            DLog.m20357d(BaseRoundStrategy.TAG, "isV3Enable: " + f28616c + ',' + "EDA_arriving_TTS: " + f28617d + ',' + "EDA_arrived_pass: " + f28618e + ',' + "distance_pass_long_abnormal_air: " + f28619f + "distance_pass_long_abnormal_pt: " + f28620g + "distance_pass_long_normal: " + f28621h + "shouldTrackEvent: " + f28622i, new Object[0]);
        }
        IToggle toggle3 = Apollo.getToggle("map_driver_route_end_unreachable");
        if (toggle3 != null) {
            Object param8 = toggle3.getExperiment().getParam("tts_distance", 30);
            Intrinsics.checkExpressionValueIsNotNull(param8, "it.getParam(\"tts_distance\", 30)");
            f28615b = ((Number) param8).intValue();
            DLog.m20357d(BaseRoundStrategy.TAG, "noRoadThreshold: " + f28615b, new Object[0]);
        }
    }

    private ShareTrackApolloHelper() {
    }

    public final boolean getCanDebugToast() {
        return f28614a;
    }

    public final void setCanDebugToast(boolean z) {
        f28614a = z;
    }

    public final int getNoRoadThreshold() {
        return f28615b;
    }

    public final void setNoRoadThreshold(int i) {
        f28615b = i;
    }

    public final int isV3Enable() {
        return f28616c;
    }

    public final void setV3Enable(int i) {
        f28616c = i;
    }

    public final int getEDA_arriving_TTS() {
        return f28617d;
    }

    public final void setEDA_arriving_TTS(int i) {
        f28617d = i;
    }

    public final int getEDA_arrived_pass() {
        return f28618e;
    }

    public final void setEDA_arrived_pass(int i) {
        f28618e = i;
    }

    public final int getDistance_pass_long_abnormal_air() {
        return f28619f;
    }

    public final void setDistance_pass_long_abnormal_air(int i) {
        f28619f = i;
    }

    public final int getDistance_pass_long_abnormal_pt() {
        return f28620g;
    }

    public final void setDistance_pass_long_abnormal_pt(int i) {
        f28620g = i;
    }

    public final int getDistance_pass_long_normal() {
        return f28621h;
    }

    public final void setDistance_pass_long_normal(int i) {
        f28621h = i;
    }

    public final int getShouldTrackEvent() {
        return f28622i;
    }

    public final void setShouldTrackEvent(int i) {
        f28622i = i;
    }
}
