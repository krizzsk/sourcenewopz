package com.didichuxing.omega.sdk.trafficstat.datareader.snapshot;

import java.io.File;

public class NetworkStatsFactory {
    private static final String TAG = "NetworkStatsFactory";
    private final File mStatsXtIfaceAll;
    private final File mStatsXtIfaceFmt;
    private final File mStatsXtUid;

    public NetworkStatsFactory() {
        this(new File("/proc/"));
    }

    public NetworkStatsFactory(File file) {
        this.mStatsXtIfaceAll = new File(file, "net/xt_qtaguid/iface_stat_all");
        this.mStatsXtIfaceFmt = new File(file, "net/xt_qtaguid/iface_stat_fmt");
        this.mStatsXtUid = new File(file, "net/xt_qtaguid/stats");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0094 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats readNetworkStatsSummaryDev() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "problem parsing stats"
            java.io.File r1 = r9.mStatsXtIfaceAll
            boolean r1 = r1.exists()
            r2 = 0
            if (r1 != 0) goto L_0x000c
            return r2
        L_0x000c:
            com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats r1 = new com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats
            long r3 = android.os.SystemClock.elapsedRealtime()
            r5 = 6
            r1.<init>(r3, r5)
            com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats$Entry r3 = new com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats$Entry
            r3.<init>()
            com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.ProcFileReader r4 = new com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.ProcFileReader     // Catch:{ NullPointerException -> 0x009a, NumberFormatException -> 0x0094 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ NullPointerException -> 0x009a, NumberFormatException -> 0x0094 }
            java.io.File r6 = r9.mStatsXtIfaceAll     // Catch:{ NullPointerException -> 0x009a, NumberFormatException -> 0x0094 }
            r5.<init>(r6)     // Catch:{ NullPointerException -> 0x009a, NumberFormatException -> 0x0094 }
            r4.<init>(r5)     // Catch:{ NullPointerException -> 0x009a, NumberFormatException -> 0x0094 }
        L_0x0027:
            boolean r2 = r4.hasMoreData()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            if (r2 == 0) goto L_0x0087
            java.lang.String r2 = r4.nextString()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            r3.iface = r2     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            r2 = -1
            r3.uid = r2     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            r3.set = r2     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            r2 = 0
            r3.tag = r2     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            int r5 = r4.nextInt()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            if (r5 == 0) goto L_0x0042
            r2 = 1
        L_0x0042:
            long r5 = r4.nextLong()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            r3.rxBytes = r5     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r5 = r4.nextLong()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            r3.rxPackets = r5     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r5 = r4.nextLong()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            r3.txBytes = r5     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r5 = r4.nextLong()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            r3.txPackets = r5     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            if (r2 == 0) goto L_0x0080
            long r5 = r3.rxBytes     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r7 = r4.nextLong()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r5 = r5 + r7
            r3.rxBytes = r5     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r5 = r3.rxPackets     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r7 = r4.nextLong()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r5 = r5 + r7
            r3.rxPackets = r5     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r5 = r3.txBytes     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r7 = r4.nextLong()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r5 = r5 + r7
            r3.txBytes = r5     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r5 = r3.txPackets     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r7 = r4.nextLong()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            long r5 = r5 + r7
            r3.txPackets = r5     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
        L_0x0080:
            r1.addValues(r3)     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            r4.finishLine()     // Catch:{ NullPointerException -> 0x0090, NumberFormatException -> 0x008e, all -> 0x008b }
            goto L_0x0027
        L_0x0087:
            r4.close()
            return r1
        L_0x008b:
            r0 = move-exception
            r2 = r4
            goto L_0x00a0
        L_0x008e:
            r2 = r4
            goto L_0x0094
        L_0x0090:
            r2 = r4
            goto L_0x009a
        L_0x0092:
            r0 = move-exception
            goto L_0x00a0
        L_0x0094:
            com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException r1 = new com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException     // Catch:{ all -> 0x0092 }
            r1.<init>(r0)     // Catch:{ all -> 0x0092 }
            throw r1     // Catch:{ all -> 0x0092 }
        L_0x009a:
            com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException r1 = new com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException     // Catch:{ all -> 0x0092 }
            r1.<init>(r0)     // Catch:{ all -> 0x0092 }
            throw r1     // Catch:{ all -> 0x0092 }
        L_0x00a0:
            r2.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStatsFactory.readNetworkStatsSummaryDev():com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0085 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0071=Splitter:B:25:0x0071, B:37:0x0085=Splitter:B:37:0x0085, B:30:0x0079=Splitter:B:30:0x0079} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats readNetworkStatsSummaryXt() {
        /*
            r7 = this;
            java.lang.String r0 = "problem parsing stats"
            java.io.File r1 = r7.mStatsXtIfaceFmt
            boolean r1 = r1.exists()
            r2 = 0
            if (r1 != 0) goto L_0x000c
            return r2
        L_0x000c:
            com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats r1 = new com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats
            long r3 = android.os.SystemClock.elapsedRealtime()
            r5 = 6
            r1.<init>(r3, r5)
            com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats$Entry r3 = new com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats$Entry
            r3.<init>()
            com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.ProcFileReader r4 = new com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.ProcFileReader     // Catch:{ NullPointerException -> 0x008b, NumberFormatException -> 0x0085, FileNotFoundException -> 0x0078, IOException -> 0x0070 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ NullPointerException -> 0x008b, NumberFormatException -> 0x0085, FileNotFoundException -> 0x0078, IOException -> 0x0070 }
            java.io.File r6 = r7.mStatsXtIfaceFmt     // Catch:{ NullPointerException -> 0x008b, NumberFormatException -> 0x0085, FileNotFoundException -> 0x0078, IOException -> 0x0070 }
            r5.<init>(r6)     // Catch:{ NullPointerException -> 0x008b, NumberFormatException -> 0x0085, FileNotFoundException -> 0x0078, IOException -> 0x0070 }
            r4.<init>(r5)     // Catch:{ NullPointerException -> 0x008b, NumberFormatException -> 0x0085, FileNotFoundException -> 0x0078, IOException -> 0x0070 }
            r4.finishLine()     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
        L_0x002a:
            boolean r2 = r4.hasMoreData()     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            if (r2 == 0) goto L_0x005d
            java.lang.String r2 = r4.nextString()     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            r3.iface = r2     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            r2 = -1
            r3.uid = r2     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            r3.set = r2     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            r2 = 0
            r3.tag = r2     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            long r5 = r4.nextLong()     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            r3.rxBytes = r5     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            long r5 = r4.nextLong()     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            r3.rxPackets = r5     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            long r5 = r4.nextLong()     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            r3.txBytes = r5     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            long r5 = r4.nextLong()     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            r3.txPackets = r5     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            r1.addValues(r3)     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            r4.finishLine()     // Catch:{ NullPointerException -> 0x006c, NumberFormatException -> 0x006a, FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
            goto L_0x002a
        L_0x005d:
            r4.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0084
        L_0x0061:
            r0 = move-exception
            r2 = r4
            goto L_0x0091
        L_0x0064:
            r0 = move-exception
            r2 = r4
            goto L_0x0071
        L_0x0067:
            r0 = move-exception
            r2 = r4
            goto L_0x0079
        L_0x006a:
            r2 = r4
            goto L_0x0085
        L_0x006c:
            r2 = r4
            goto L_0x008b
        L_0x006e:
            r0 = move-exception
            goto L_0x0091
        L_0x0070:
            r0 = move-exception
        L_0x0071:
            r0.printStackTrace()     // Catch:{ all -> 0x006e }
            r2.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0084
        L_0x0078:
            r0 = move-exception
        L_0x0079:
            r0.printStackTrace()     // Catch:{ all -> 0x006e }
            r2.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0084:
            return r1
        L_0x0085:
            com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException r1 = new com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException     // Catch:{ all -> 0x006e }
            r1.<init>(r0)     // Catch:{ all -> 0x006e }
            throw r1     // Catch:{ all -> 0x006e }
        L_0x008b:
            com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException r1 = new com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException     // Catch:{ all -> 0x006e }
            r1.<init>(r0)     // Catch:{ all -> 0x006e }
            throw r1     // Catch:{ all -> 0x006e }
        L_0x0091:
            r2.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0099:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStatsFactory.readNetworkStatsSummaryXt():com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats");
    }

    public NetworkStats readNetworkStatsDetail() {
        return readNetworkStatsDetail(-1);
    }

    public NetworkStats readNetworkStatsDetail(int i) {
        return javaReadNetworkStatsDetail(this.mStatsXtUid, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009d, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009e, code lost:
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a0, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a1, code lost:
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a3, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a3 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a6 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:6:0x0025] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats javaReadNetworkStatsDetail(java.io.File r8, int r9) {
        /*
            java.lang.String r0 = "problem parsing idx "
            boolean r1 = com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.FormatCheck.isAdapterSuccess()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats r1 = new com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats
            long r3 = android.os.SystemClock.elapsedRealtime()
            r5 = 24
            r1.<init>(r3, r5)
            com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats$Entry r3 = new com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats$Entry
            r3.<init>()
            r4 = 1
            com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.ProcFileReader r5 = new com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.ProcFileReader     // Catch:{ NullPointerException -> 0x00de, NumberFormatException -> 0x00c3, IOException -> 0x00b1 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ NullPointerException -> 0x00de, NumberFormatException -> 0x00c3, IOException -> 0x00b1 }
            r6.<init>(r8)     // Catch:{ NullPointerException -> 0x00de, NumberFormatException -> 0x00c3, IOException -> 0x00b1 }
            r5.<init>(r6)     // Catch:{ NullPointerException -> 0x00de, NumberFormatException -> 0x00c3, IOException -> 0x00b1 }
            r5.finishLine()     // Catch:{ NullPointerException -> 0x00ac, NumberFormatException -> 0x00a9, IOException -> 0x00a6, all -> 0x00a3 }
            r8 = 1
        L_0x0029:
            boolean r2 = r5.hasMoreData()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            if (r2 == 0) goto L_0x0099
            int r8 = r5.nextInt()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            int r2 = r4 + 1
            if (r8 != r2) goto L_0x007a
            java.lang.String r2 = r5.nextString()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r3.iface = r2     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            java.lang.String r2 = r5.nextString()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            int r2 = com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats.kernelToTag(r2)     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r3.tag = r2     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            int r2 = r5.nextInt()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r3.uid = r2     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            int r2 = r5.nextInt()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r3.set = r2     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            long r6 = r5.nextLong()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r3.rxBytes = r6     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            long r6 = r5.nextLong()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r3.rxPackets = r6     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            long r6 = r5.nextLong()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r3.txBytes = r6     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            long r6 = r5.nextLong()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r3.txPackets = r6     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r2 = -1
            if (r9 == r2) goto L_0x0072
            int r2 = r3.uid     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            if (r9 != r2) goto L_0x0075
        L_0x0072:
            r1.addValues(r3)     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
        L_0x0075:
            r5.finishLine()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r4 = r8
            goto L_0x0029
        L_0x007a:
            com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException r9 = new com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r2.<init>()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            java.lang.String r3 = "inconsistent idx="
            r2.append(r3)     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r2.append(r8)     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            java.lang.String r3 = " after lastIdx="
            r2.append(r3)     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r2.append(r4)     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            java.lang.String r2 = r2.toString()     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            r9.<init>(r2)     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
            throw r9     // Catch:{ NullPointerException -> 0x00a0, NumberFormatException -> 0x009d, IOException -> 0x00a6, all -> 0x00a3 }
        L_0x0099:
            r5.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c2
        L_0x009d:
            r9 = move-exception
            r4 = r8
            goto L_0x00aa
        L_0x00a0:
            r9 = move-exception
            r4 = r8
            goto L_0x00ad
        L_0x00a3:
            r8 = move-exception
            r2 = r5
            goto L_0x00f9
        L_0x00a6:
            r8 = move-exception
            r2 = r5
            goto L_0x00b2
        L_0x00a9:
            r9 = move-exception
        L_0x00aa:
            r2 = r5
            goto L_0x00c4
        L_0x00ac:
            r9 = move-exception
        L_0x00ad:
            r2 = r5
            goto L_0x00df
        L_0x00af:
            r8 = move-exception
            goto L_0x00f9
        L_0x00b1:
            r8 = move-exception
        L_0x00b2:
            java.lang.String r9 = "omega_generic_traffic_stat:javaReadNetworkStatsDetail3"
            com.didichuxing.omega.sdk.analysis.Tracker.trackGood(r9, r8)     // Catch:{ all -> 0x00af }
            r8.printStackTrace()     // Catch:{ all -> 0x00af }
            r2.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c2
        L_0x00be:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00c2:
            return r1
        L_0x00c3:
            r9 = move-exception
        L_0x00c4:
            java.lang.String r8 = "omega_generic_traffic_stat:javaReadNetworkStatsDetail2"
            com.didichuxing.omega.sdk.analysis.Tracker.trackGood(r8, r9)     // Catch:{ all -> 0x00af }
            com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException r8 = new com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r9.<init>()     // Catch:{ all -> 0x00af }
            r9.append(r0)     // Catch:{ all -> 0x00af }
            r9.append(r4)     // Catch:{ all -> 0x00af }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00af }
            r8.<init>(r9)     // Catch:{ all -> 0x00af }
            throw r8     // Catch:{ all -> 0x00af }
        L_0x00de:
            r9 = move-exception
        L_0x00df:
            java.lang.String r8 = "omega_generic_traffic_stat:javaReadNetworkStatsDetail1"
            com.didichuxing.omega.sdk.analysis.Tracker.trackGood(r8, r9)     // Catch:{ all -> 0x00af }
            com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException r8 = new com.didichuxing.omega.sdk.trafficstat.datareader.exception.ProtocolException     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r9.<init>()     // Catch:{ all -> 0x00af }
            r9.append(r0)     // Catch:{ all -> 0x00af }
            r9.append(r4)     // Catch:{ all -> 0x00af }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00af }
            r8.<init>(r9)     // Catch:{ all -> 0x00af }
            throw r8     // Catch:{ all -> 0x00af }
        L_0x00f9:
            r2.close()     // Catch:{ IOException -> 0x00fd }
            goto L_0x0101
        L_0x00fd:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0101:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStatsFactory.javaReadNetworkStatsDetail(java.io.File, int):com.didichuxing.omega.sdk.trafficstat.datareader.snapshot.NetworkStats");
    }
}
