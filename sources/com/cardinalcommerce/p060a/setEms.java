package com.cardinalcommerce.p060a;

import android.app.Activity;
import android.app.Dialog;
import com.taxis99.R;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setEms */
public class setEms {

    /* renamed from: a */
    private final Dialog f2764a;

    public setEms(Activity activity, String str) {
        Dialog dialog = new Dialog(activity);
        this.f2764a = dialog;
        dialog.setContentView(R.layout.progress_view_2);
        setFallbackLineSpacing setfallbacklinespacing = (setFallbackLineSpacing) this.f2764a.findViewById(R.id.imageView);
        try {
            JSONObject jSONObject = new JSONObject(new setMaxHeight(activity.getApplicationContext()).init.cca_continue("dsConfigurationString", (String) null)).getJSONObject("dsConfigurations").getJSONObject("directoryServers").getJSONObject(str);
            if (jSONObject != null) {
                String cca_continue = new setLinkTextColor(jSONObject.optString("imageUrl")).cca_continue(activity.getApplicationContext());
                if (!cca_continue.equals("")) {
                    setTextScaleX settextscalex = new setTextScaleX(setfallbacklinespacing, cca_continue);
                    settextscalex.getInstance.execute(settextscalex);
                }
            }
        } catch (JSONException e) {
            setTextMetricsParams sDKVersion = setTextMetricsParams.getSDKVersion();
            StringBuilder sb = new StringBuilder("JSON Exception \n");
            sb.append(e.getLocalizedMessage());
            sDKVersion.configure("11701", sb.toString(), (String) null);
        }
    }
}
