package com.didi.one.netdetect.task;

import android.content.Context;
import android.text.TextUtils;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.TraceRouteCommand;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.NetUtil;
import com.didi.one.netdetect.util.ONDLog;
import java.net.MalformedURLException;
import java.net.URL;

public class TraceRouteTask implements Task<String> {

    /* renamed from: a */
    private static final String f29478a = "OND_TraceRouteTask_New";

    /* renamed from: b */
    private Context f29479b;

    /* renamed from: c */
    private int f29480c;

    /* renamed from: d */
    private int f29481d;

    /* renamed from: e */
    private Command.OutPutHandler<String> f29482e;

    public TraceRouteTask(Context context) {
        this.f29479b = context;
    }

    public TraceRouteTask(Context context, Command.OutPutHandler<String> outPutHandler) {
        this.f29479b = context;
        this.f29482e = outPutHandler;
    }

    public String doTask(DetectionItem detectionItem) {
        if (TextUtils.isEmpty(detectionItem.url)) {
            return null;
        }
        try {
            TraceRouteCommand.Builder maxTTL = new TraceRouteCommand.Builder().setHost(NetUtil.isIpAddress(detectionItem.url) ? detectionItem.url : new URL(detectionItem.url).getHost()).setMaxTTL(this.f29480c);
            if (this.f29481d > 0) {
                maxTTL = maxTTL.setWaitTime(this.f29481d);
            }
            TraceRouteCommand build = maxTTL.build(this.f29479b);
            build.setOutPutHandler(this.f29482e);
            build.execute();
            String str = build.getNormalOutput() + "\r\n" + build.getErrorOutput();
            if (this.f29482e != null) {
                this.f29482e.handleResult(str);
            }
            ONDLog.m20755d(f29478a, str);
            return str;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setMaxTTL(int i) {
        this.f29480c = i;
    }

    public void setWaitTime(int i) {
        this.f29481d = i;
    }
}
