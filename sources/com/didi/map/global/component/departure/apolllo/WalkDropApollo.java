package com.didi.map.global.component.departure.apolllo;

import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/map/global/component/departure/apolllo/WalkDropApollo;", "", "()V", "Companion", "compDeparture_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalkDropApollo.kt */
public final class WalkDropApollo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f24867a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f24868b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static boolean f24869c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static boolean f24870d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static boolean f24871e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static boolean f24872f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static boolean f24873g;

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/map/global/component/departure/apolllo/WalkDropApollo$Companion;", "", "()V", "dropline_enable", "", "getDropline_enable", "()Z", "setDropline_enable", "(Z)V", "enable", "getEnable", "setEnable", "hms_enable", "getHms_enable", "setHms_enable", "recpoint_enable", "getRecpoint_enable", "setRecpoint_enable", "subtitle_adsorbed", "getSubtitle_adsorbed", "setSubtitle_adsorbed", "subtitle_not_adsorbed", "getSubtitle_not_adsorbed", "setSubtitle_not_adsorbed", "walkline_enable", "getWalkline_enable", "setWalkline_enable", "compDeparture_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalkDropApollo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getHms_enable() {
            return WalkDropApollo.f24867a;
        }

        public final void setHms_enable(boolean z) {
            WalkDropApollo.f24867a = z;
        }

        public final boolean getRecpoint_enable() {
            return WalkDropApollo.f24868b;
        }

        public final void setRecpoint_enable(boolean z) {
            WalkDropApollo.f24868b = z;
        }

        public final boolean getEnable() {
            return WalkDropApollo.f24869c;
        }

        public final void setEnable(boolean z) {
            WalkDropApollo.f24869c = z;
        }

        public final boolean getDropline_enable() {
            return WalkDropApollo.f24870d;
        }

        public final void setDropline_enable(boolean z) {
            WalkDropApollo.f24870d = z;
        }

        public final boolean getSubtitle_adsorbed() {
            return WalkDropApollo.f24871e;
        }

        public final void setSubtitle_adsorbed(boolean z) {
            WalkDropApollo.f24871e = z;
        }

        public final boolean getSubtitle_not_adsorbed() {
            return WalkDropApollo.f24872f;
        }

        public final void setSubtitle_not_adsorbed(boolean z) {
            WalkDropApollo.f24872f = z;
        }

        public final boolean getWalkline_enable() {
            return WalkDropApollo.f24873g;
        }

        public final void setWalkline_enable(boolean z) {
            WalkDropApollo.f24873g = z;
        }
    }

    static {
        IToggle toggle = Apollo.getToggle("global_map_pickup_page_walk_line_toggle");
        boolean z = true;
        if (toggle.allow()) {
            IExperiment experiment = toggle.getExperiment();
            Integer num = (Integer) experiment.getParam("hms_enable", 0);
            f24867a = num != null && num.intValue() == 1;
            Integer num2 = (Integer) experiment.getParam("recpoint_enable", 0);
            f24868b = num2 != null && num2.intValue() == 1;
            Integer num3 = (Integer) experiment.getParam("dropline_enable", 0);
            f24870d = num3 != null && num3.intValue() == 1;
            Integer num4 = (Integer) experiment.getParam("subtitle_adsorbed", 0);
            f24871e = num4 != null && num4.intValue() == 1;
            Integer num5 = (Integer) experiment.getParam("subtitle_not_adsorbed", 0);
            f24872f = num5 != null && num5.intValue() == 1;
            Integer num6 = (Integer) experiment.getParam("enable", 0);
            f24869c = num6 != null && num6.intValue() == 1;
        }
        IToggle toggle2 = Apollo.getToggle("global_map_waiting_for_driving_page_walk_line_toggle");
        if (toggle2.allow()) {
            Integer num7 = (Integer) toggle2.getExperiment().getParam("walkline_enable", 0);
            if (num7 == null || num7.intValue() != 1) {
                z = false;
            }
            f24873g = z;
        }
        DLog.m7384d("WalkDropApollo", "enable = " + f24869c + ", hms_enable =" + f24867a + ", recpoint_enable =" + f24868b + ", dropline_enable =" + f24870d + " , subtitle_adsorbed =" + f24871e + " ,subtitle_not_adsorbed =" + f24872f + " , walkline_enable = " + f24873g, new Object[0]);
    }
}
