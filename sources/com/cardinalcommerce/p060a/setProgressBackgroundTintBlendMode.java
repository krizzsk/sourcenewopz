package com.cardinalcommerce.p060a;

import com.didi.sdk.push.fcm.Constact;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setProgressBackgroundTintBlendMode */
public final class setProgressBackgroundTintBlendMode extends setKeyListener {

    /* renamed from: b */
    private static int f2924b = 0;

    /* renamed from: c */
    private static int f2925c = 1;

    /* renamed from: a */
    private final setProgressBackgroundTintMode f2926a = setProgressBackgroundTintMode.init();

    public setProgressBackgroundTintBlendMode(setSecondaryProgressTintList setsecondaryprogresstintlist, String str) {
        try {
            C2026q a = C2026q.m1921a();
            if (str == null && a.f2630c.cca_continue != null) {
                str = a.f2630c.cca_continue;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(Constants.ERROR_CODE, setsecondaryprogresstintlist.cca_continue);
            jSONObject.putOpt("errorComponent", setsecondaryprogresstintlist.Cardinal);
            jSONObject.putOpt("errorDescription", setsecondaryprogresstintlist.getInstance);
            jSONObject.putOpt("errorDetail", setsecondaryprogresstintlist.init);
            jSONObject.putOpt("errorMessageType", setsecondaryprogresstintlist.configure);
            jSONObject.putOpt(Constact.KEY_LINK_MESSAGETYPE, setsecondaryprogresstintlist.values);
            jSONObject.putOpt("messageVersion", setsecondaryprogresstintlist.cleanup);
            jSONObject.putOpt("sdkTransID", setsecondaryprogresstintlist.getSDKVersion);
            jSONObject.putOpt("threeDSServerTransID", setsecondaryprogresstintlist.CardinalError);
            jSONObject.putOpt("acsTransID", setsecondaryprogresstintlist.getWarnings);
            super.configure(str, jSONObject.toString(), 8000);
        } catch (JSONException e) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2926a;
            StringBuilder sb = new StringBuilder("Exception while executing task \n");
            sb.append(e.getLocalizedMessage());
            setprogressbackgroundtintmode.init(new setImageMatrix(11421, sb.toString()));
        }
    }

    public final void cca_continue(String str) {
        int i = f2924b;
        int i2 = i & 1;
        int i3 = -(-((i ^ 1) | i2));
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2925c = i4 % 128;
        int i5 = i4 % 2;
        this.f2926a.Cardinal("EMVCoTransaction", "Error Task Ended");
        int i6 = f2924b;
        int i7 = ((i6 | 20) << 1) - (i6 ^ 20);
        int i8 = (i7 & -1) + (i7 | -1);
        f2925c = i8 % 128;
        int i9 = i8 % 2;
    }

    public final void cca_continue(Exception exc, setMin setmin) {
        setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2926a;
        StringBuilder sb = new StringBuilder("Exception while executing task \n");
        sb.append(exc.getLocalizedMessage());
        setprogressbackgroundtintmode.init(new setImageMatrix(11421, sb.toString()));
        int i = f2924b;
        int i2 = (i & -40) | ((~i) & 39);
        int i3 = -(-((i & 39) << 1));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f2925c = i4 % 128;
        int i5 = i4 % 2;
    }

    public final void getInstance(String str, int i) {
        super.getInstance(str, i);
        this.f2926a.init(new setImageMatrix(11421, "Exception while executing task \n".concat(String.valueOf(str))));
        int i2 = f2925c;
        int i3 = i2 & 93;
        int i4 = (i2 | 93) & (~i3);
        int i5 = -(-(i3 << 1));
        int i6 = (i4 & i5) + (i4 | i5);
        f2924b = i6 % 128;
        int i7 = i6 % 2;
    }
}
