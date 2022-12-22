package com.didi.one.netdetect.command;

import android.content.Context;
import android.text.TextUtils;
import com.didi.one.netdetect.util.ExecuteFileUtils;
import com.didi.one.netdetect.util.ONDLog;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public abstract class Command {

    /* renamed from: a */
    private static final String f29423a = "OND_Command";
    protected Context context;
    protected String errorOutput;
    protected boolean isNative;
    protected OutPutHandler mOutPutHandler;
    protected String normalOutput;

    public interface OutPutHandler<T> {
        void handleMsg(String str);

        void handleResult(T t);
    }

    /* access modifiers changed from: protected */
    public abstract String generateCommandStr();

    /* access modifiers changed from: protected */
    public abstract String whichCmd();

    protected Command(Context context2) {
        this.context = context2;
        m20733a(context2);
    }

    /* renamed from: a */
    private void m20733a(Context context2) {
        String whichCmd = whichCmd();
        if (!TextUtils.isEmpty(whichCmd)) {
            try {
                this.isNative = !ExecuteFileUtils.checkCmdFile(context2, whichCmd);
                ONDLog.m20755d(f29423a, Const.jaLeft + whichCmd + "] binary executable successful installed");
            } catch (Exception unused) {
                ONDLog.m20757e(f29423a, "Can't install [" + whichCmd + "] binary executable");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cf, code lost:
        if (r2 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c7 A[Catch:{ IOException -> 0x00c8, InterruptedException -> 0x00be, all -> 0x00b9, all -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d6 A[SYNTHETIC, Splitter:B:45:0x00d6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute() {
        /*
            r8 = this;
            java.lang.String r0 = ""
            r8.normalOutput = r0
            r8.errorOutput = r0
            java.lang.String r0 = r8.generateCommandStr()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0011
            return
        L_0x0011:
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x00c8, InterruptedException -> 0x00be, all -> 0x00b9 }
            java.lang.Process r0 = r2.exec(r0)     // Catch:{ IOException -> 0x00c8, InterruptedException -> 0x00be, all -> 0x00b9 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b4, InterruptedException -> 0x00af, all -> 0x00aa }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b4, InterruptedException -> 0x00af, all -> 0x00aa }
            java.io.InputStream r4 = r0.getInputStream()     // Catch:{ IOException -> 0x00b4, InterruptedException -> 0x00af, all -> 0x00aa }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00b4, InterruptedException -> 0x00af, all -> 0x00aa }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00b4, InterruptedException -> 0x00af, all -> 0x00aa }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            java.io.InputStream r4 = r0.getErrorStream()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
        L_0x0036:
            java.lang.String r3 = r2.readLine()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            java.lang.String r4 = "\r\n"
            if (r3 == 0) goto L_0x0067
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.<init>()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.append(r3)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.append(r4)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r8.m20734a((java.lang.String) r5)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.<init>()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            java.lang.String r6 = r8.normalOutput     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.append(r6)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.append(r3)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.append(r4)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            java.lang.String r3 = r5.toString()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r8.normalOutput = r3     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            goto L_0x0036
        L_0x0067:
            java.lang.String r3 = r1.readLine()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            if (r3 == 0) goto L_0x0096
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.<init>()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.append(r3)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.append(r4)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r8.m20734a((java.lang.String) r5)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.<init>()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            java.lang.String r6 = r8.errorOutput     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.append(r6)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.append(r3)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r5.append(r4)     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            java.lang.String r3 = r5.toString()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r8.errorOutput = r3     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            goto L_0x0067
        L_0x0096:
            r2.close()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r1.close()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
            r0.waitFor()     // Catch:{ IOException -> 0x00a8, InterruptedException -> 0x00a6 }
        L_0x009f:
            r2.close()     // Catch:{ Exception -> 0x00d2 }
        L_0x00a2:
            r0.destroy()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00d2
        L_0x00a6:
            r1 = move-exception
            goto L_0x00c2
        L_0x00a8:
            r1 = move-exception
            goto L_0x00cc
        L_0x00aa:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
            goto L_0x00d4
        L_0x00af:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
            goto L_0x00c2
        L_0x00b4:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
            goto L_0x00cc
        L_0x00b9:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x00d4
        L_0x00be:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L_0x00c2:
            r1.printStackTrace()     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x00a2
            goto L_0x009f
        L_0x00c8:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L_0x00cc:
            r1.printStackTrace()     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x00a2
            goto L_0x009f
        L_0x00d2:
            return
        L_0x00d3:
            r1 = move-exception
        L_0x00d4:
            if (r2 == 0) goto L_0x00d9
            r2.close()     // Catch:{ Exception -> 0x00dc }
        L_0x00d9:
            r0.destroy()     // Catch:{ Exception -> 0x00dc }
        L_0x00dc:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.one.netdetect.command.Command.execute():void");
    }

    /* access modifiers changed from: protected */
    public String getCmdPath() {
        if (this.isNative) {
            return whichCmd();
        }
        return ExecuteFileUtils.getCmdFilePath(this.context, whichCmd());
    }

    public String getNormalOutput() {
        return this.normalOutput;
    }

    public String getErrorOutput() {
        return this.errorOutput;
    }

    /* renamed from: a */
    private void m20734a(String str) {
        OutPutHandler outPutHandler = this.mOutPutHandler;
        if (outPutHandler != null) {
            outPutHandler.handleMsg(str);
        }
    }

    public void setOutPutHandler(OutPutHandler outPutHandler) {
        this.mOutPutHandler = outPutHandler;
    }
}
