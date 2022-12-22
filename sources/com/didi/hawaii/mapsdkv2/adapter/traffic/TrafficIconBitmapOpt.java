package com.didi.hawaii.mapsdkv2.adapter.traffic;

import com.didi.hawaii.utils.BitmapUtil;
import com.didi.map.base.bubble.BaseBubbleBitmapOpt;

public class TrafficIconBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private static final String f23766a = "map/";

    /* renamed from: b */
    private static final String f23767b = "map/night";

    /* renamed from: c */
    private final int f23768c;

    /* renamed from: d */
    private float f23769d = 50.0f;

    /* renamed from: e */
    private boolean f23770e = false;

    public TrafficIconBitmapOpt(long j, String str, int i) {
        super(str, j);
        this.f23768c = i;
        this.f23769d = 50.0f / BitmapUtil.fDensityXH;
    }

    public int getTrafficIconType() {
        return this.f23768c;
    }

    public TrafficIconBitmapOpt setIconSize(int i) {
        this.f23769d = ((float) i) / BitmapUtil.fDensityXH;
        return this;
    }

    public TrafficIconBitmapOpt setIsHintIcon(boolean z) {
        this.f23770e = z;
        return this;
    }

    public boolean isHint() {
        return this.f23770e;
    }

    public float getRealIconSize() {
        return this.f23769d;
    }

    public String getTrafficIconTypeFileName() {
        switch (this.f23768c / 100) {
            case 0:
                return "map/" + "traffic_yongdu_3x.png";
            case 1:
                return "map/" + "traffic_shigu_3x.png";
            case 2:
                return "map/" + "traffic_shigong_3x.png";
            case 3:
                return "map/" + "traffic_guanzhi_3x.png";
            case 4:
                return "map/" + "traffic_fenglu_3x.png";
            case 5:
                return "map/" + "traffic_jishui_3x.png";
            case 6:
                return "map/" + "traffic_jingcha_3x.png";
            case 7:
                return "map/" + "traffic_gonggao_3x.png";
            default:
                return "map/" + "traffic_default_3x.png";
        }
    }

    public String getResourcePaths() {
        return super.toString() + "traffic_icon" + isNight() + this.f23769d + "|";
    }
}
