package com.didi.one.netdetect.task;

import android.content.Context;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.IfconfigCommand;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.ONDLog;

public class IfconfigTask implements Task<String> {

    /* renamed from: a */
    private static final String f29462a = "OND_IfconfigTask";

    /* renamed from: b */
    private Context f29463b;

    /* renamed from: c */
    private Command.OutPutHandler<String> f29464c;

    public IfconfigTask(Context context) {
        this.f29463b = context;
    }

    public IfconfigTask(Context context, Command.OutPutHandler<String> outPutHandler) {
        this.f29463b = context;
        this.f29464c = outPutHandler;
    }

    public String doTask(DetectionItem detectionItem) {
        IfconfigCommand build = new IfconfigCommand.Builder().build(this.f29463b);
        build.setOutPutHandler(this.f29464c);
        build.execute();
        String str = build.getNormalOutput() + "\r\n" + build.getErrorOutput();
        Command.OutPutHandler<String> outPutHandler = this.f29464c;
        if (outPutHandler != null) {
            outPutHandler.handleResult(str);
        }
        ONDLog.m20755d(f29462a, str);
        return str;
    }
}
