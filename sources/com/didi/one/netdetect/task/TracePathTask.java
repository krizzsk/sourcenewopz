package com.didi.one.netdetect.task;

import android.content.Context;
import android.text.TextUtils;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.TracePathCommand;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.NetUtil;
import com.didi.one.netdetect.util.ONDLog;
import java.net.MalformedURLException;
import java.net.URL;

public class TracePathTask implements Task<String> {

    /* renamed from: a */
    private static final String f29474a = "OND_TraceRouteTask";

    /* renamed from: b */
    private Context f29475b;

    /* renamed from: c */
    private int f29476c;

    /* renamed from: d */
    private Command.OutPutHandler<String> f29477d;

    public TracePathTask(Context context) {
        this.f29475b = context;
    }

    public TracePathTask(Context context, Command.OutPutHandler<String> outPutHandler) {
        this.f29475b = context;
        this.f29477d = outPutHandler;
    }

    public String doTask(DetectionItem detectionItem) {
        if (TextUtils.isEmpty(detectionItem.url)) {
            return null;
        }
        TracePathCommand.Builder builder = new TracePathCommand.Builder();
        try {
            builder.setHost(NetUtil.isIpAddress(detectionItem.url) ? detectionItem.url : new URL(detectionItem.url).getHost()).setMaxTTL(this.f29476c);
            TracePathCommand build = builder.build(this.f29475b);
            build.setOutPutHandler(this.f29477d);
            build.execute();
            String str = build.getNormalOutput() + "\r\n" + build.getErrorOutput();
            if (this.f29477d != null) {
                this.f29477d.handleResult(str);
            }
            ONDLog.m20755d(f29474a, str);
            return str;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setMaxTTL(int i) {
        this.f29476c = i;
    }
}
