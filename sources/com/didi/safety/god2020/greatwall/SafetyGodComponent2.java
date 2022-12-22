package com.didi.safety.god2020.greatwall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.didi.greatwall.protocol.AbsComponent;
import com.didi.greatwall.protocol.Component;
import com.didi.greatwall.protocol.ComponentBridge;
import com.didi.greatwall.protocol.ComponentListener;
import com.didi.safety.god.manager.GodManager;
import com.didi.safety.god2020.p145ui.GlobalCardDetectionAct2;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import org.json.JSONException;
import org.json.JSONObject;

@ServiceProvider(alias = "DOORGOD2", value = {Component.class})
public class SafetyGodComponent2 extends AbsComponent {
    public static final String NAME = "DOORGOD2";
    public static final String PAGE_PREVIEW = "PREVIEW";
    public static final String PAGE_SUBMIT = "SUBMIT";

    /* renamed from: a */
    private Context f34848a;

    /* renamed from: b */
    private Intent f34849b;

    public void onDestroy() {
    }

    public void onResume() {
        this.f34848a.startActivity(this.f34849b);
    }

    public void onCreate(Context context, Bundle bundle, ComponentListener componentListener) {
        Intent intent;
        Intent intent2 = null;
        try {
            String string = bundle.getString("initPage");
            intent = new Intent();
            try {
                GodManager.getInstance().setMainPage(string);
                intent.putExtra("keeperId", bundle.getString("keeperId"));
                intent.putExtra("bizCode", bundle.getInt("bizCode"));
                intent.putExtra("token", bundle.getString("token"));
                intent.putExtra("debug", bundle.getBoolean("debug"));
                intent.putExtra("initPage", string);
                intent.putExtra("cardsImgCode", "BR_S1");
                intent.putExtra("extraJsonObj", new JSONObject().toString());
                ComponentBridge.getInstance().addExecuteCallback(NAME, componentListener);
                if ("PREVIEW".equals(string)) {
                    intent.setClass(context, GlobalCardDetectionAct2.class);
                    intent.putExtra("cardsImgCode", bundle.getString("cards"));
                } else if (!"SUBMIT".equals(string)) {
                    componentListener.onFinish(4, (JSONObject) null);
                    return;
                }
            } catch (Exception e) {
                e = e;
                intent2 = intent;
                e.printStackTrace();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", e.getMessage());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                componentListener.onFinish(4, jSONObject);
                intent = intent2;
                this.f34848a = context;
                this.f34849b = intent;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("msg", e.getMessage());
            componentListener.onFinish(4, jSONObject2);
            intent = intent2;
            this.f34848a = context;
            this.f34849b = intent;
        }
        this.f34848a = context;
        this.f34849b = intent;
    }
}
