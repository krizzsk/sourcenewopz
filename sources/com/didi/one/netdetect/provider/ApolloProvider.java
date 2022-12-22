package com.didi.one.netdetect.provider;

import android.text.TextUtils;
import com.didi.one.netdetect.model.DetectionGroup;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.ONDLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import didinet.ApolloAPI;
import didinet.NetEngine;
import java.util.List;

public class ApolloProvider implements IDetectionGroupProvider {

    /* renamed from: a */
    private static final String f29451a = "OND_ApolloProvider";

    /* renamed from: b */
    private static String f29452b = "net_detect_monitor_experiments";

    /* renamed from: c */
    private String f29453c;

    public ApolloProvider(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f29453c = str;
        } else {
            this.f29453c = f29452b;
        }
    }

    public DetectionGroup providerDetectionGroup() {
        ApolloAPI.Toggle toggle = NetEngine.getInstance().getApolloAPI().getToggle(this.f29453c);
        if (toggle.allow()) {
            DetectionGroup detectionGroup = new DetectionGroup();
            ApolloAPI.Experiment experiment = toggle.getExperiment();
            String str = (String) experiment.getParam("detectInterval", "");
            String str2 = (String) experiment.getParam("detecTimeout", "");
            String str3 = (String) experiment.getParam("pingCount", "");
            String str4 = (String) experiment.getParam("pingTimeout", "");
            String str5 = (String) experiment.getParam("trInterval", "");
            String str6 = (String) experiment.getParam("trPercent", "");
            String str7 = (String) experiment.getParam("pingOTInterval", "3600");
            String str8 = (String) experiment.getParam("pingOTPercent", "100");
            String str9 = (String) experiment.getParam("detectList", "");
            String str10 = (String) experiment.getParam("url", "");
            try {
                detectionGroup.detectInterval = Integer.valueOf(str).intValue();
                detectionGroup.detecTimeout = Integer.valueOf(str2).intValue();
                detectionGroup.pingCount = Integer.valueOf(str3).intValue();
                detectionGroup.pingTimeout = Integer.valueOf(str4).intValue();
                detectionGroup.trInterval = Integer.valueOf(str5).intValue();
                detectionGroup.trPercent = Integer.valueOf(str6).intValue();
                detectionGroup.pingOutputInterval = Integer.valueOf(str7).intValue();
                detectionGroup.pingOutputPercent = Integer.valueOf(str8).intValue();
                detectionGroup.detectList = (List) new Gson().fromJson(str9, new TypeToken<List<DetectionItem>>() {
                }.getType());
                detectionGroup.reportUrl = (List) new Gson().fromJson(str10, new TypeToken<List<String>>() {
                }.getType());
                detectionGroup.checkValid();
                return detectionGroup;
            } catch (Exception e) {
                ONDLog.m20755d(f29451a, "GET TASK FORM APOLLO FAILED => " + e.toString());
                return null;
            }
        } else {
            ONDLog.m20755d(f29451a, "DO NOT HAVE PERMISSION");
            return null;
        }
    }
}
