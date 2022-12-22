package com.didi.beatles.p099im.thirty.greenrobot.dao.async;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperationExecutor$1 */
/* synthetic */ class AsyncOperationExecutor$1 {

    /* renamed from: $SwitchMap$com$didi$beatles$im$thirty$greenrobot$dao$async$AsyncOperation$OperationType */
    static final /* synthetic */ int[] f9674xb6843a26;

    /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(46:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
    static {
        /*
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType[] r0 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f9674xb6843a26 = r0
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.Delete     // Catch:{ NoSuchFieldError -> 0x0012 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
        L_0x0012:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x001d }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.DeleteInTxIterable     // Catch:{ NoSuchFieldError -> 0x001d }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
        L_0x001d:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x0028 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.DeleteInTxArray     // Catch:{ NoSuchFieldError -> 0x0028 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
        L_0x0028:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x0033 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.Insert     // Catch:{ NoSuchFieldError -> 0x0033 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
        L_0x0033:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x003e }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.InsertInTxIterable     // Catch:{ NoSuchFieldError -> 0x003e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
        L_0x003e:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x0049 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.InsertInTxArray     // Catch:{ NoSuchFieldError -> 0x0049 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
        L_0x0049:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x0054 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.InsertOrReplace     // Catch:{ NoSuchFieldError -> 0x0054 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
        L_0x0054:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x0060 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.InsertOrReplaceInTxIterable     // Catch:{ NoSuchFieldError -> 0x0060 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
        L_0x0060:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x006c }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.InsertOrReplaceInTxArray     // Catch:{ NoSuchFieldError -> 0x006c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
            r2 = 9
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
        L_0x006c:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x0078 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.Update     // Catch:{ NoSuchFieldError -> 0x0078 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
            r2 = 10
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
        L_0x0078:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x0084 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.UpdateInTxIterable     // Catch:{ NoSuchFieldError -> 0x0084 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
            r2 = 11
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
        L_0x0084:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x0090 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.UpdateInTxArray     // Catch:{ NoSuchFieldError -> 0x0090 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
            r2 = 12
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
        L_0x0090:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x009c }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.TransactionRunnable     // Catch:{ NoSuchFieldError -> 0x009c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
            r2 = 13
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
        L_0x009c:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x00a8 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.TransactionCallable     // Catch:{ NoSuchFieldError -> 0x00a8 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
            r2 = 14
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
        L_0x00a8:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x00b4 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.QueryList     // Catch:{ NoSuchFieldError -> 0x00b4 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
            r2 = 15
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
        L_0x00b4:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x00c0 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.QueryUnique     // Catch:{ NoSuchFieldError -> 0x00c0 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
            r2 = 16
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
        L_0x00c0:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x00cc }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.DeleteByKey     // Catch:{ NoSuchFieldError -> 0x00cc }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
            r2 = 17
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
        L_0x00cc:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x00d8 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.DeleteAll     // Catch:{ NoSuchFieldError -> 0x00d8 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
            r2 = 18
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
        L_0x00d8:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x00e4 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.Load     // Catch:{ NoSuchFieldError -> 0x00e4 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
            r2 = 19
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
        L_0x00e4:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x00f0 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.LoadAll     // Catch:{ NoSuchFieldError -> 0x00f0 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
            r2 = 20
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
        L_0x00f0:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x00fc }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.Count     // Catch:{ NoSuchFieldError -> 0x00fc }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
            r2 = 21
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
        L_0x00fc:
            int[] r0 = f9674xb6843a26     // Catch:{ NoSuchFieldError -> 0x0108 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType r1 = com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation.OperationType.Refresh     // Catch:{ NoSuchFieldError -> 0x0108 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
            r2 = 22
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperationExecutor$1.<clinit>():void");
    }
}
