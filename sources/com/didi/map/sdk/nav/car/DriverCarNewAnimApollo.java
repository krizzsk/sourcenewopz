package com.didi.map.sdk.nav.car;

import com.didi.common.map.MapVendor;
import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class DriverCarNewAnimApollo {

    /* renamed from: a */
    private static final String f28384a = "DriverCarNewAnimApollo";

    /* renamed from: b */
    private MapVendor f28385b;

    /* renamed from: c */
    private boolean f28386c;

    /* renamed from: d */
    private float f28387d;

    /* renamed from: e */
    private float f28388e;

    /* renamed from: f */
    private int f28389f;

    /* renamed from: g */
    private int f28390g;

    /* renamed from: h */
    private float f28391h;

    /* renamed from: i */
    private float f28392i;

    /* renamed from: j */
    private float f28393j;

    private static class Holder {
        static DriverCarNewAnimApollo instance = new DriverCarNewAnimApollo();

        private Holder() {
        }
    }

    public static DriverCarNewAnimApollo getInstance() {
        return Holder.instance;
    }

    private DriverCarNewAnimApollo() {
        this.f28386c = false;
        this.f28387d = 0.6f;
        this.f28388e = 0.6f;
        this.f28389f = 35;
        this.f28390g = 30;
        this.f28391h = 16.5f;
        this.f28392i = 18.25f;
        this.f28393j = 1.1f;
        IToggle toggle = Apollo.getToggle("global_map_driver_car_up_anim_opt_ab");
        if (toggle == null || !toggle.allow()) {
            this.f28386c = false;
            DLog.m7384d(f28384a, "global_map_driver_car_up_anim_opt_ab not allow", new Object[0]);
        } else if (toggle.getExperiment() != null) {
            try {
                boolean z = true;
                if (((Integer) toggle.getExperiment().getParam("enable", 0)).intValue() != 1) {
                    z = false;
                }
                this.f28386c = z;
                this.f28387d = Float.parseFloat((String) toggle.getExperiment().getParam("car_padding_top_ratio_google", "0.6"));
                this.f28388e = Float.parseFloat((String) toggle.getExperiment().getParam("car_padding_top_ratio_hawaii", "0.6"));
                this.f28389f = ((Integer) toggle.getExperiment().getParam("map_tilt_google", 35)).intValue();
                this.f28390g = ((Integer) toggle.getExperiment().getParam("map_tilt_hawaii", 30)).intValue();
                this.f28391h = Float.parseFloat((String) toggle.getExperiment().getParam("max_zoom_google", "16.5"));
                this.f28392i = Float.parseFloat((String) toggle.getExperiment().getParam("max_zoom_hawaii", "18.25"));
                this.f28393j = Float.parseFloat((String) toggle.getExperiment().getParam("car_zoom_ratio", "1.1"));
                DLog.m7384d(f28384a, "global_map_driver_car_up_anim_opt_ab allow and param: " + m20115a(), new Object[0]);
            } catch (Exception e) {
                DLog.m7384d(f28384a, " apllo exc: " + e.getMessage(), new Object[0]);
            }
        } else {
            this.f28386c = false;
            DLog.m7384d(f28384a, "global_map_driver_car_up_anim_opt_ab allow but with error", new Object[0]);
        }
    }

    public boolean enable() {
        return this.f28385b != MapVendor.HUAWEI && this.f28386c;
    }

    public void setMapVendor(MapVendor mapVendor) {
        DLog.m7384d(f28384a, "DriverCarAnim vendor: " + mapVendor, new Object[0]);
        this.f28385b = mapVendor;
    }

    public float getCarPaddingTopRatio() {
        if (this.f28385b == MapVendor.DIDI) {
            return this.f28388e;
        }
        return this.f28387d;
    }

    public int getMapTiltValue() {
        int i;
        if (this.f28385b == MapVendor.DIDI) {
            i = this.f28390g;
        } else {
            i = this.f28389f;
        }
        if (i < 0 || i >= 90) {
            return 45;
        }
        return i;
    }

    public float getMaxZoomLevel() {
        if (this.f28385b == MapVendor.DIDI) {
            return this.f28392i;
        }
        return this.f28391h;
    }

    public float getCarZoomRatio() {
        return this.f28393j;
    }

    /* renamed from: a */
    private String m20115a() {
        return "DriverCarNewAnimApollo{enable=" + this.f28386c + ", car_padding_top_ratio_google=" + this.f28387d + ", car_padding_top_ratio_hawaii=" + this.f28388e + ", map_tilt_google=" + this.f28389f + ", map_tilt_hawaii=" + this.f28390g + ", max_zoom_google=" + this.f28391h + ", max_zoom_hawaii=" + this.f28392i + ", car_zoom_ratio=" + this.f28393j + '}';
    }
}
