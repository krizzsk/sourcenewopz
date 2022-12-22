package com.google.android.gms.ads.nonagon.transaction.omid;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class OmidSettings {
    private final JSONObject zzhok;

    public OmidSettings(JSONObject jSONObject) {
        this.zzhok = jSONObject;
    }

    public OmidMediaType getMediaType() {
        int optInt = this.zzhok.optInt("media_type", -1);
        if (optInt == 0) {
            return OmidMediaType.DISPLAY;
        }
        if (optInt != 1) {
            return OmidMediaType.UNKNOWN;
        }
        return OmidMediaType.VIDEO;
    }

    public String getVideoEventsOwner() {
        if (zza.zzhoj[getMediaType().ordinal()] != 1) {
            return "javascript";
        }
        return null;
    }
}
