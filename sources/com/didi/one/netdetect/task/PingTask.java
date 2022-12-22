package com.didi.one.netdetect.task;

import android.content.Context;
import android.text.TextUtils;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.PingCommand;
import com.didi.one.netdetect.command.PingResult;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.NetUtil;
import com.didi.one.netdetect.util.ONDLog;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PingTask implements Task<PingResult> {

    /* renamed from: b */
    private static final String f29468b = "OND_PingTask";

    /* renamed from: a */
    private Logger f29469a = LoggerFactory.getLogger("OneNetDetect");

    /* renamed from: c */
    private int f29470c;

    /* renamed from: d */
    private int f29471d;

    /* renamed from: e */
    private Context f29472e;

    /* renamed from: f */
    private Command.OutPutHandler<PingResult> f29473f;

    public PingTask(Context context) {
        this.f29472e = context;
    }

    public PingTask(Context context, Command.OutPutHandler<PingResult> outPutHandler) {
        this.f29472e = context;
        this.f29473f = outPutHandler;
    }

    public PingResult doTask(DetectionItem detectionItem) {
        PingResult a = m20752a(detectionItem, true);
        if (a == null || !TextUtils.isEmpty(a.getErrValue()) || a.isFailAll()) {
            return m20752a(detectionItem, false);
        }
        return a;
    }

    /* renamed from: a */
    private PingResult m20752a(DetectionItem detectionItem, boolean z) {
        if (TextUtils.isEmpty(detectionItem.url)) {
            return new PingResult(0, "ERROR", "item.url is null, " + detectionItem);
        }
        String str = "Ping native";
        ONDLog.m20755d(f29468b, z ? str : "Ping external file");
        Command.OutPutHandler<PingResult> outPutHandler = this.f29473f;
        if (outPutHandler != null) {
            StringBuilder sb = new StringBuilder();
            if (!z) {
                str = "Ping external file";
            }
            sb.append(str);
            sb.append("\r\n");
            outPutHandler.handleMsg(sb.toString());
        }
        try {
            PingCommand build = new PingCommand.Builder().setIsNative(z).setHost(NetUtil.isIpAddress(detectionItem.url) ? detectionItem.url : new URL(detectionItem.url).getHost()).setSendCount(this.f29470c).setTimeout(this.f29471d).build(this.f29472e);
            build.setOutPutHandler(this.f29473f);
            build.execute();
            ONDLog.m20755d(f29468b, "normal output:\r\n" + build.getNormalOutput());
            ONDLog.m20755d(f29468b, "error output:\r\n" + build.getErrorOutput());
            PingResult pingResult = new PingResult(this.f29470c, build.getNormalOutput(), build.getErrorOutput());
            if (pingResult.isFailAll()) {
                HashMap hashMap = new HashMap();
                hashMap.put("pingResult", pingResult.getNormalValue());
                this.f29469a.errorEvent("Ping", (Map<?, ?>) hashMap);
            }
            if (this.f29473f != null) {
                this.f29473f.handleResult(pingResult);
            }
            return pingResult;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            PingResult pingResult2 = new PingResult(0, "ERROR", e.getMessage());
            Command.OutPutHandler<PingResult> outPutHandler2 = this.f29473f;
            if (outPutHandler2 != null) {
                outPutHandler2.handleResult(pingResult2);
            }
            return pingResult2;
        }
    }

    public void setCount(int i) {
        this.f29470c = i;
    }

    public void setTimeout(int i) {
        this.f29471d = i;
    }
}
