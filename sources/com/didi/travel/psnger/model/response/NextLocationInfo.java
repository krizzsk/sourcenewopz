package com.didi.travel.psnger.model.response;

import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class NextLocationInfo extends BaseObject {
    public float accSpeedX;
    public float accSpeedY;
    public float accSpeedZ;
    public double accuracy;
    public float anglePitch;
    public float angleRoll;
    public float angleYaw;
    public double direction;
    public double speed;
    public int timestamp;
    public int type;

    /* renamed from: x */
    public double f44223x;

    /* renamed from: y */
    public double f44224y;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.f44223x = jSONObject.optDouble("x");
        this.f44224y = jSONObject.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
        this.type = jSONObject.optInt("type");
        this.direction = jSONObject.optDouble(BlocksConst.WIDGET_PARAMS_ANGLE);
        this.timestamp = jSONObject.optInt("timestamp");
    }

    public String toString() {
        return "NextLocationInfo{x=" + this.f44223x + ", y=" + this.f44224y + ", type=" + this.type + ", accuracy=" + this.accuracy + ", direction=" + this.direction + ", speed=" + this.speed + ", accSpeedX=" + this.accSpeedX + ", accSpeedY=" + this.accSpeedY + ", accSpeedZ=" + this.accSpeedZ + ", angleYaw=" + this.angleYaw + ", angleRoll=" + this.angleRoll + ", anglePitch=" + this.anglePitch + ", timestamp=" + this.timestamp + '}';
    }
}
