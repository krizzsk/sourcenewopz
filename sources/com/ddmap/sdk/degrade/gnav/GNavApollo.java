package com.ddmap.sdk.degrade.gnav;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ddmap.sdk.degrade.gnav.GoogleNavDegrade;
import com.ddmap.sdk.degrade.gnav.crashrule.AccumulateCrashRule;
import com.ddmap.sdk.degrade.gnav.crashrule.ContinuousCrashRule;
import com.ddmap.sdk.degrade.gnav.crashrule.ICrashRule;
import com.didi.safetoolkit.business.toolkit.model.SfViewMenuModel;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class GNavApollo {

    /* renamed from: f */
    private static GNavApollo f4279f;

    /* renamed from: a */
    private String f4280a;

    /* renamed from: b */
    private boolean f4281b = false;

    /* renamed from: c */
    private final List<ICrashRule<?>> f4282c = new ArrayList();

    /* renamed from: d */
    private String f4283d;

    /* renamed from: e */
    private boolean f4284e;

    private GNavApollo() {
        boolean z = false;
        IToggle toggle = Apollo.getToggle("global_map_driver_android_gNavDegrade_toggle");
        if (toggle != null && toggle.allow()) {
            IExperiment experiment = toggle.getExperiment();
            GoogleNavDegrade.Companion companion = GoogleNavDegrade.Companion;
            companion.debug("apollo = " + experiment);
            this.f4281b = ((Integer) experiment.getParam(SfViewMenuModel.TYPE_REALTIME_MONITOR, 0)).intValue() == 1;
            this.f4280a = (String) experiment.getParam("crashKey", "");
            String str = (String) experiment.getParam("accumulateRule", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(TypedValues.CycleType.S_WAVE_PERIOD, 0);
                    int optInt2 = jSONObject.optInt("number", 0);
                    if (optInt > 0 && optInt2 > 0) {
                        this.f4282c.add(new AccumulateCrashRule(optInt, optInt2));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int intValue = ((Integer) experiment.getParam("continuousRule", 0)).intValue();
            if (intValue > 0) {
                this.f4282c.add(new ContinuousCrashRule(intValue));
            }
            this.f4283d = (String) experiment.getParam("restoreVersion", "");
            this.f4284e = ((Integer) experiment.getParam("restoreFlag", 0)).intValue() == 1 ? true : z;
        }
    }

    public static GNavApollo get() {
        if (f4279f == null) {
            f4279f = new GNavApollo();
        }
        return f4279f;
    }

    public boolean isIsMonitor() {
        return this.f4281b;
    }

    public String getCrashKey() {
        return this.f4280a;
    }

    public List<ICrashRule<?>> getCrashRules() {
        return this.f4282c;
    }

    public String getRestoreVersion() {
        return this.f4283d;
    }

    public boolean isRestoreFlag() {
        return this.f4284e;
    }
}
