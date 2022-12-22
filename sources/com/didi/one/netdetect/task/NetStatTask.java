package com.didi.one.netdetect.task;

import android.content.Context;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.NetstatCommand;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.ONDLog;

public class NetStatTask implements Task<String> {

    /* renamed from: a */
    private static final String f29465a = "OND_NetStatTask";

    /* renamed from: b */
    private Context f29466b;

    /* renamed from: c */
    private Command.OutPutHandler<String> f29467c;

    public NetStatTask(Context context) {
        this.f29466b = context;
    }

    public NetStatTask(Context context, Command.OutPutHandler<String> outPutHandler) {
        this.f29466b = context;
        this.f29467c = outPutHandler;
    }

    public String doTask(DetectionItem detectionItem) {
        NetstatCommand build = new NetstatCommand.Builder().setRoutingTable(false).build(this.f29466b);
        build.setOutPutHandler(this.f29467c);
        build.execute();
        String str = build.getNormalOutput() + "\r\n" + build.getErrorOutput();
        Command.OutPutHandler<String> outPutHandler = this.f29467c;
        if (outPutHandler != null) {
            outPutHandler.handleResult(str);
        }
        ONDLog.m20755d(f29465a, str);
        return str;
    }
}
