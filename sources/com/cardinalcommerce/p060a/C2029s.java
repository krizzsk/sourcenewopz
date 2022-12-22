package com.cardinalcommerce.p060a;

import android.content.Context;
import com.cardinalcommerce.emvco.services.CardinalThreeDS2ServiceImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.s */
final class C2029s {

    /* renamed from: p */
    private static int f2638p = 0;

    /* renamed from: q */
    private static int f2639q = 1;

    /* renamed from: a */
    final JSONObject f2640a;

    /* renamed from: b */
    final JSONObject f2641b;

    /* renamed from: c */
    final JSONObject f2642c;

    /* renamed from: d */
    final JSONArray f2643d;

    /* renamed from: e */
    final Context f2644e;

    /* renamed from: f */
    private setCompoundDrawablePadding f2645f;

    /* renamed from: g */
    private setCompoundDrawableTintBlendMode f2646g;

    /* renamed from: h */
    private setCompoundDrawableTintMode f2647h;

    /* renamed from: i */
    private setTextSelectHandleRight f2648i;

    /* renamed from: j */
    private setCompoundDrawableTintList f2649j;

    /* renamed from: k */
    private setTextSelectHandleLeft f2650k;

    /* renamed from: l */
    private setCompoundDrawablesRelative f2651l;

    /* renamed from: m */
    private setLastBaselineToBottomHeight f2652m;

    /* renamed from: n */
    private setProgressBackgroundTintMode f2653n = setProgressBackgroundTintMode.init();

    /* renamed from: o */
    private boolean f2654o;

    C2029s(setProgressDrawable setprogressdrawable) {
        this.f2644e = setprogressdrawable.init;
        this.f2643d = m1937a(setprogressdrawable);
        this.f2654o = setprogressdrawable.getInstance();
        setProgress.Cardinal();
        setCompoundDrawablePadding setcompounddrawablepadding = setProgress.getInstance;
        this.f2645f = setcompounddrawablepadding;
        this.f2650k = setcompounddrawablepadding.cca_continue;
        this.f2649j = this.f2645f.configure;
        this.f2648i = this.f2645f.getInstance;
        this.f2647h = this.f2645f.CardinalError.cca_continue;
        this.f2646g = this.f2645f.values;
        this.f2651l = this.f2645f.CardinalError.getInstance;
        this.f2652m = this.f2645f.init.Cardinal;
        this.f2640a = new JSONObject();
        this.f2641b = new JSONObject();
        this.f2642c = new JSONObject();
        try {
            m1938a();
            this.f2653n.Cardinal("EMVCoTransaction", "JSON created");
        } catch (JSONException e) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2653n;
            StringBuilder sb = new StringBuilder(" Error Creating LASSO JSON \n");
            sb.append(e.getLocalizedMessage());
            setprogressbackgroundtintmode.init(new setImageMatrix(11317, sb.toString()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:267:0x05b0, code lost:
        if (r0 == 0) goto L_0x05c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x05be, code lost:
        if (androidx.core.content.ContextCompat.checkSelfPermission(r1.f2644e, "android.permission.BLUETOOTH_CONNECT") == 0) goto L_0x05c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x04d4  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x053f  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0548  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x055e  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0586  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x05d4  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0653  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0659  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x066a  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x066d  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0671  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0677  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0686  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x06af  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x06be  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x06c4  */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x06d8  */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x06db  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x06df  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x06e3  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x06f9  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x06fb  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x06fe  */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x0702  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0715  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0718  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x071c  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x072b  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x073a  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x073d  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0740  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0746  */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x076c  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x076f  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0773  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0787  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0796  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x079c  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x07ab  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x07b1  */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x07cd  */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x07cf  */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x07d2  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x07d6  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x07f1  */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x07f3  */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x07f6  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x080d  */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x081c  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0837  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0846  */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x084c  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0871  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x088c  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x08a6  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x08a9  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x08ad  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x08b1  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x08e0  */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x08e2  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x08e5  */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x08eb  */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x08fa  */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x08fd  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x0903  */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x0907  */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0935  */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x093b  */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x094a  */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x095f  */
    /* JADX WARNING: Removed duplicated region for block: B:435:0x096e  */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0971  */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x0977  */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x097d  */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x09b6  */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x09b9  */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x09bd  */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x09c3  */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x09e4  */
    /* JADX WARNING: Removed duplicated region for block: B:462:0x0a0b  */
    /* JADX WARNING: Removed duplicated region for block: B:465:0x0a46  */
    /* JADX WARNING: Removed duplicated region for block: B:474:0x0a65  */
    /* JADX WARNING: Removed duplicated region for block: B:477:0x0a74  */
    /* JADX WARNING: Removed duplicated region for block: B:478:0x0a7a  */
    /* JADX WARNING: Removed duplicated region for block: B:481:0x0a9f  */
    /* JADX WARNING: Removed duplicated region for block: B:490:0x0ac4  */
    /* JADX WARNING: Removed duplicated region for block: B:493:0x0ad3  */
    /* JADX WARNING: Removed duplicated region for block: B:494:0x0ad9  */
    /* JADX WARNING: Removed duplicated region for block: B:497:0x0ae8  */
    /* JADX WARNING: Removed duplicated region for block: B:498:0x0aee  */
    /* JADX WARNING: Removed duplicated region for block: B:501:0x0b13  */
    /* JADX WARNING: Removed duplicated region for block: B:502:0x0b15  */
    /* JADX WARNING: Removed duplicated region for block: B:504:0x0b18  */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x0b44  */
    /* JADX WARNING: Removed duplicated region for block: B:516:0x0b5e  */
    /* JADX WARNING: Removed duplicated region for block: B:517:0x0b60  */
    /* JADX WARNING: Removed duplicated region for block: B:519:0x0b63  */
    /* JADX WARNING: Removed duplicated region for block: B:520:0x0b67  */
    /* JADX WARNING: Removed duplicated region for block: B:523:0x0b8e  */
    /* JADX WARNING: Removed duplicated region for block: B:524:0x0ba5  */
    /* JADX WARNING: Removed duplicated region for block: B:527:0x0be0  */
    /* JADX WARNING: Removed duplicated region for block: B:528:0x0be6  */
    /* JADX WARNING: Removed duplicated region for block: B:531:0x0bf5  */
    /* JADX WARNING: Removed duplicated region for block: B:540:0x0c1d  */
    /* JADX WARNING: Removed duplicated region for block: B:543:0x0c37  */
    /* JADX WARNING: Removed duplicated region for block: B:544:0x0c3a  */
    /* JADX WARNING: Removed duplicated region for block: B:546:0x0c3e  */
    /* JADX WARNING: Removed duplicated region for block: B:547:0x0c42  */
    /* JADX WARNING: Removed duplicated region for block: B:550:0x0c53  */
    /* JADX WARNING: Removed duplicated region for block: B:551:0x0c55  */
    /* JADX WARNING: Removed duplicated region for block: B:553:0x0c58  */
    /* JADX WARNING: Removed duplicated region for block: B:554:0x0c5c  */
    /* JADX WARNING: Removed duplicated region for block: B:557:0x0c84  */
    /* JADX WARNING: Removed duplicated region for block: B:558:0x0c8a  */
    /* JADX WARNING: Removed duplicated region for block: B:561:0x0c99  */
    /* JADX WARNING: Removed duplicated region for block: B:562:0x0c9b  */
    /* JADX WARNING: Removed duplicated region for block: B:564:0x0c9e  */
    /* JADX WARNING: Removed duplicated region for block: B:565:0x0cb8  */
    /* JADX WARNING: Removed duplicated region for block: B:568:0x0cc7  */
    /* JADX WARNING: Removed duplicated region for block: B:569:0x0cdf  */
    /* JADX WARNING: Removed duplicated region for block: B:572:0x0cee  */
    /* JADX WARNING: Removed duplicated region for block: B:573:0x0cf0  */
    /* JADX WARNING: Removed duplicated region for block: B:575:0x0cf3  */
    /* JADX WARNING: Removed duplicated region for block: B:576:0x0cf9  */
    /* JADX WARNING: Removed duplicated region for block: B:579:0x0d08  */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x0d0b  */
    /* JADX WARNING: Removed duplicated region for block: B:583:0x0d11  */
    /* JADX WARNING: Removed duplicated region for block: B:584:0x0d24  */
    /* JADX WARNING: Removed duplicated region for block: B:587:0x0d33  */
    /* JADX WARNING: Removed duplicated region for block: B:588:0x0d39  */
    /* JADX WARNING: Removed duplicated region for block: B:591:0x0d48  */
    /* JADX WARNING: Removed duplicated region for block: B:592:0x0d4a  */
    /* JADX WARNING: Removed duplicated region for block: B:594:0x0d4d  */
    /* JADX WARNING: Removed duplicated region for block: B:595:0x0d51  */
    /* JADX WARNING: Removed duplicated region for block: B:598:0x0d62  */
    /* JADX WARNING: Removed duplicated region for block: B:599:0x0d64  */
    /* JADX WARNING: Removed duplicated region for block: B:601:0x0d67  */
    /* JADX WARNING: Removed duplicated region for block: B:602:0x0d6b  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0d9d  */
    /* JADX WARNING: Removed duplicated region for block: B:606:0x0da3  */
    /* JADX WARNING: Removed duplicated region for block: B:609:0x0db2  */
    /* JADX WARNING: Removed duplicated region for block: B:610:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:613:0x0ddb  */
    /* JADX WARNING: Removed duplicated region for block: B:626:0x0e06  */
    /* JADX WARNING: Removed duplicated region for block: B:629:0x0e20  */
    /* JADX WARNING: Removed duplicated region for block: B:630:0x0e26  */
    /* JADX WARNING: Removed duplicated region for block: B:634:0x0e2f A[LOOP:5: B:632:0x0e2b->B:634:0x0e2f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:637:0x0e5f  */
    /* JADX WARNING: Removed duplicated region for block: B:638:0x0e62  */
    /* JADX WARNING: Removed duplicated region for block: B:641:0x0e66  */
    /* JADX WARNING: Removed duplicated region for block: B:650:0x0e8d  */
    /* JADX WARNING: Removed duplicated region for block: B:653:0x0e9c  */
    /* JADX WARNING: Removed duplicated region for block: B:655:0x0e9f  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0ea3  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1938a() throws org.json.JSONException {
        /*
            r17 = this;
            r1 = r17
            com.cardinalcommerce.a.setCompoundDrawablePadding r0 = r1.f2645f
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            if (r0 == r3) goto L_0x000f
            goto L_0x0efa
        L_0x000f:
            int r0 = f2638p
            int r0 = r0 + 120
            int r0 = r0 - r3
            int r4 = r0 % 128
            f2639q = r4
            int r0 = r0 % 2
            com.cardinalcommerce.a.setTextSelectHandleLeft r0 = r1.f2650k
            r4 = 27
            if (r0 == 0) goto L_0x0023
            r0 = 27
            goto L_0x0025
        L_0x0023:
            r0 = 17
        L_0x0025:
            r5 = 17
            if (r0 == r5) goto L_0x0085
            java.lang.String r0 = "C001"
            com.cardinalcommerce.a.setTextSelectHandleLeft r5 = r1.f2650k
            char[] r5 = r5.cca_continue
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0038
            r6 = 46
            goto L_0x003a
        L_0x0038:
            r6 = 32
        L_0x003a:
            r7 = 46
            if (r6 == r7) goto L_0x0042
            r1.m1939a((java.lang.String) r0)
            goto L_0x0055
        L_0x0042:
            int r6 = f2639q
            r7 = r6 | 13
            int r7 = r7 << r3
            r6 = r6 ^ 13
            int r7 = r7 - r6
            int r6 = r7 % 128
            f2638p = r6
            int r7 = r7 % 2
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
        L_0x0055:
            java.lang.String r0 = "C003"
            com.cardinalcommerce.a.setTextSelectHandleLeft r5 = r1.f2650k
            char[] r5 = r5.configure
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0063
            r6 = 0
            goto L_0x0064
        L_0x0063:
            r6 = 1
        L_0x0064:
            if (r6 == r3) goto L_0x006c
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x006f
        L_0x006c:
            r1.m1939a((java.lang.String) r0)
        L_0x006f:
            java.lang.String r0 = "C004"
            com.cardinalcommerce.a.setTextSelectHandleLeft r5 = r1.f2650k
            char[] r5 = r5.Cardinal
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0081
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x0094
        L_0x0081:
            r1.m1939a((java.lang.String) r0)
            goto L_0x0094
        L_0x0085:
            java.lang.String r0 = "C001"
            r1.m1939a((java.lang.String) r0)
            java.lang.String r0 = "C003"
            r1.m1939a((java.lang.String) r0)
            java.lang.String r0 = "C004"
            r1.m1939a((java.lang.String) r0)
        L_0x0094:
            com.cardinalcommerce.a.setTextSelectHandleRight r0 = r1.f2648i
            if (r0 == 0) goto L_0x009a
            r0 = 0
            goto L_0x009b
        L_0x009a:
            r0 = 1
        L_0x009b:
            if (r0 == r3) goto L_0x00cf
            int r0 = f2639q
            int r0 = r0 + 112
            int r0 = r0 - r3
            int r5 = r0 % 128
            f2638p = r5
            int r0 = r0 % 2
            java.lang.String r0 = "C006"
            com.cardinalcommerce.a.setTextSelectHandleRight r5 = r1.f2648i
            char[] r5 = r5.cca_continue
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x00cb
            int r6 = f2639q
            int r6 = r6 + 97
            int r6 = r6 - r3
            r7 = r6 ^ -1
            r6 = r6 & -1
            int r6 = r6 << r3
            int r7 = r7 + r6
            int r6 = r7 % 128
            f2638p = r6
            int r7 = r7 % 2
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x00d4
        L_0x00cb:
            r1.m1939a((java.lang.String) r0)
            goto L_0x00d4
        L_0x00cf:
            java.lang.String r0 = "C006"
            r1.m1939a((java.lang.String) r0)
        L_0x00d4:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            r5 = 48
            r6 = 9
            r7 = 7
            r8 = 0
            if (r0 == 0) goto L_0x0176
            int r0 = f2638p
            r9 = r0 ^ 15
            r0 = r0 & 15
            r0 = r0 | r9
            int r0 = r0 << r3
            int r9 = -r9
            r10 = r0 | r9
            int r10 = r10 << r3
            r0 = r0 ^ r9
            int r10 = r10 - r0
            int r0 = r10 % 128
            f2639q = r0
            int r10 = r10 % 2
            java.lang.String r0 = "C002"
            com.cardinalcommerce.a.setCompoundDrawableTintList r9 = r1.f2649j
            char[] r9 = r9.getInstance
            java.lang.String r9 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r9)
            if (r9 == 0) goto L_0x0112
            int r10 = f2638p
            r11 = r10 ^ 48
            r10 = r10 & r5
            int r10 = r10 << r3
            int r11 = r11 + r10
            int r11 = r11 - r3
            int r10 = r11 % 128
            f2639q = r10
            int r11 = r11 % 2
            org.json.JSONObject r10 = r1.f2641b
            r10.put(r0, r9)
            goto L_0x0115
        L_0x0112:
            r1.m1939a((java.lang.String) r0)
        L_0x0115:
            java.lang.String r0 = "C005"
            com.cardinalcommerce.a.setCompoundDrawableTintList r9 = r1.f2649j
            char[] r9 = r9.getWarnings
            java.lang.String r9 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r9)
            if (r9 == 0) goto L_0x0127
            org.json.JSONObject r10 = r1.f2641b
            r10.put(r0, r9)
            goto L_0x012a
        L_0x0127:
            r1.m1939a((java.lang.String) r0)
        L_0x012a:
            java.lang.String r0 = "C007"
            java.lang.String r9 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r8)
            if (r9 == 0) goto L_0x0138
            org.json.JSONObject r10 = r1.f2641b
            r10.put(r0, r9)
            goto L_0x013b
        L_0x0138:
            r1.m1939a((java.lang.String) r0)
        L_0x013b:
            java.lang.String r0 = "C008"
            com.cardinalcommerce.a.setCompoundDrawableTintList r9 = r1.f2649j
            char[] r9 = r9.cca_continue
            java.lang.String r9 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r9)
            if (r9 == 0) goto L_0x0149
            r10 = 1
            goto L_0x014a
        L_0x0149:
            r10 = 0
        L_0x014a:
            if (r10 == 0) goto L_0x0152
            org.json.JSONObject r10 = r1.f2641b
            r10.put(r0, r9)
            goto L_0x0155
        L_0x0152:
            r1.m1939a((java.lang.String) r0)
        L_0x0155:
            java.lang.String r0 = "C009"
            com.cardinalcommerce.a.setCompoundDrawableTintList r9 = r1.f2649j
            char[] r9 = r9.cleanup
            java.lang.String r9 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r9)
            if (r9 == 0) goto L_0x0172
            int r10 = f2638p
            int r10 = r10 + 68
            int r10 = r10 - r3
            int r11 = r10 % 128
            f2639q = r11
            int r10 = r10 % 2
            org.json.JSONObject r10 = r1.f2641b
            r10.put(r0, r9)
            goto L_0x01b0
        L_0x0172:
            r1.m1939a((java.lang.String) r0)
            goto L_0x01b0
        L_0x0176:
            java.lang.String r0 = "C002"
            r1.m1939a((java.lang.String) r0)
            java.lang.String r0 = "C005"
            r1.m1939a((java.lang.String) r0)
            r0 = 7
        L_0x0181:
            if (r0 > r6) goto L_0x0185
            r9 = 0
            goto L_0x0186
        L_0x0185:
            r9 = 1
        L_0x0186:
            if (r9 == r3) goto L_0x01b0
            java.lang.String r9 = java.lang.String.valueOf(r0)
            java.lang.String r10 = "C00"
            java.lang.String r9 = r10.concat(r9)
            r1.m1939a((java.lang.String) r9)
            r9 = r0 & -46
            r0 = r0 | -46
            int r0 = -r0
            int r0 = -r0
            r10 = r9 ^ r0
            r0 = r0 & r9
            int r0 = r0 << r3
            int r10 = r10 + r0
            r0 = 47
            r9 = r10 & -48
            int r11 = ~r10
            r11 = r11 & r0
            r9 = r9 | r11
            r0 = r0 & r10
            int r0 = r0 << r3
            int r0 = -r0
            int r0 = -r0
            int r0 = ~r0
            int r9 = r9 - r0
            int r0 = r9 + -1
            goto L_0x0181
        L_0x01b0:
            com.cardinalcommerce.a.setCompoundDrawableTintMode r0 = r1.f2647h
            if (r0 == 0) goto L_0x01eb
            java.lang.String r9 = "C010"
            char[] r0 = r0.init
            java.lang.String r0 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r0)
            if (r0 == 0) goto L_0x01e7
            int r10 = f2638p
            int r10 = r10 + 107
            int r10 = r10 - r3
            r11 = r10 & -1
            r10 = r10 | -1
            int r11 = r11 + r10
            int r10 = r11 % 128
            f2639q = r10
            int r11 = r11 % 2
            if (r11 != 0) goto L_0x01d2
            r10 = 1
            goto L_0x01d3
        L_0x01d2:
            r10 = 0
        L_0x01d3:
            if (r10 == r3) goto L_0x01db
            org.json.JSONObject r10 = r1.f2641b
            r10.put(r9, r0)
            goto L_0x01fc
        L_0x01db:
            org.json.JSONObject r10 = r1.f2641b
            r10.put(r9, r0)
            r0 = 14
            int r0 = r0 / r2
            goto L_0x01fc
        L_0x01e4:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x01e7:
            r1.m1939a((java.lang.String) r9)
            goto L_0x01fc
        L_0x01eb:
            java.lang.String r0 = "C010"
            r1.m1941b(r0)
            int r0 = f2639q
            r9 = r0 & 7
            r0 = r0 | r7
            int r9 = r9 + r0
            int r0 = r9 % 128
            f2638p = r0
            int r9 = r9 % 2
        L_0x01fc:
            boolean r0 = r1.f2654o
            if (r0 == 0) goto L_0x0203
            r0 = 88
            goto L_0x0205
        L_0x0203:
            r0 = 32
        L_0x0205:
            r9 = 88
            r10 = 12
            if (r0 == r9) goto L_0x020c
            goto L_0x0263
        L_0x020c:
            int r0 = f2638p
            r9 = r0 & 47
            r0 = r0 ^ 47
            r0 = r0 | r9
            int r0 = ~r0
            int r9 = r9 - r0
            int r9 = r9 - r3
            int r0 = r9 % 128
            f2639q = r0
            int r9 = r9 % 2
            android.content.Context r0 = r1.f2644e
            java.lang.String r9 = "android.permission.ACCESS_COARSE_LOCATION"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r9)
            if (r0 != 0) goto L_0x0263
            android.content.Context r0 = r1.f2644e
            java.lang.String r9 = "android.permission.ACCESS_FINE_LOCATION"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r9)
            if (r0 != 0) goto L_0x0233
            r0 = 12
            goto L_0x0235
        L_0x0233:
            r0 = 27
        L_0x0235:
            if (r0 == r10) goto L_0x0238
            goto L_0x0263
        L_0x0238:
            java.lang.String r0 = "C011"
            com.cardinalcommerce.a.setCompoundDrawableTintBlendMode r9 = r1.f2646g
            char[] r9 = r9.init
            java.lang.String r9 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r9)
            if (r9 == 0) goto L_0x024a
            org.json.JSONObject r11 = r1.f2641b
            r11.put(r0, r9)
            goto L_0x024d
        L_0x024a:
            r1.m1939a((java.lang.String) r0)
        L_0x024d:
            java.lang.String r0 = "C012"
            com.cardinalcommerce.a.setCompoundDrawableTintBlendMode r9 = r1.f2646g
            char[] r9 = r9.getInstance
            java.lang.String r9 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r9)
            if (r9 == 0) goto L_0x025f
            org.json.JSONObject r11 = r1.f2641b
            r11.put(r0, r9)
            goto L_0x026d
        L_0x025f:
            r1.m1939a((java.lang.String) r0)
            goto L_0x026d
        L_0x0263:
            java.lang.String r0 = "C011"
            r1.m1941b(r0)
            java.lang.String r0 = "C012"
            r1.m1941b(r0)
        L_0x026d:
            android.content.Context r0 = r1.f2644e
            java.lang.String r9 = "android.permission.READ_PHONE_STATE"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r9)
            r9 = 22
            r11 = 21
            java.lang.String r12 = "A0"
            r13 = 81
            if (r0 != 0) goto L_0x04d4
            java.lang.String r0 = "A001"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A002"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A003"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A004"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A005"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A006"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            char[] r4 = r4.configure     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)     // Catch:{ Exception -> 0x04c2 }
            if (r4 == 0) goto L_0x02d3
            int r6 = f2639q
            r14 = r6 & 35
            int r15 = ~r14
            r6 = r6 | 35
            r6 = r6 & r15
            int r14 = r14 << r3
            int r14 = -r14
            int r14 = -r14
            r15 = r6 ^ r14
            r6 = r6 & r14
            int r6 = r6 << r3
            int r15 = r15 + r6
            int r6 = r15 % 128
            f2638p = r6
            int r15 = r15 % 2
            if (r15 == 0) goto L_0x02be
            r6 = 0
            goto L_0x02bf
        L_0x02be:
            r6 = 1
        L_0x02bf:
            if (r6 == 0) goto L_0x02c7
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            goto L_0x02d6
        L_0x02c7:
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            super.hashCode()     // Catch:{ all -> 0x02d0 }
            goto L_0x02d6
        L_0x02d0:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x02d3:
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
        L_0x02d6:
            java.lang.String r0 = "A007"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            char[] r4 = r4.getInstance     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)     // Catch:{ Exception -> 0x04c2 }
            if (r4 == 0) goto L_0x02e8
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            goto L_0x02eb
        L_0x02e8:
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
        L_0x02eb:
            java.lang.String r0 = "A008"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            char[] r4 = r4.init     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)     // Catch:{ Exception -> 0x04c2 }
            if (r4 == 0) goto L_0x030b
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            int r0 = f2639q
            r4 = r0 | 22
            int r4 = r4 << r3
            r0 = r0 ^ r9
            int r4 = r4 - r0
            int r4 = r4 - r3
            int r0 = r4 % 128
            f2638p = r0
            int r4 = r4 % 2
            goto L_0x030e
        L_0x030b:
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
        L_0x030e:
            java.lang.String r0 = "A009"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            char[] r4 = r4.getSDKVersion     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)     // Catch:{ Exception -> 0x04c2 }
            r6 = 37
            if (r4 == 0) goto L_0x0343
            int r14 = f2638p
            r15 = r14 | 37
            int r15 = r15 << r3
            r16 = r14 & -38
            int r14 = ~r14
            r14 = r14 & r6
            r14 = r16 | r14
            int r14 = -r14
            int r14 = ~r14
            int r15 = r15 - r14
            int r15 = r15 - r3
            int r14 = r15 % 128
            f2639q = r14
            int r15 = r15 % 2
            if (r15 != 0) goto L_0x033d
            org.json.JSONObject r14 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r14.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            int r0 = r8.length     // Catch:{ all -> 0x033a }
            goto L_0x0346
        L_0x033a:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x033d:
            org.json.JSONObject r14 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r14.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            goto L_0x0346
        L_0x0343:
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
        L_0x0346:
            java.lang.String r0 = "A010"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            char[] r4 = r4.values     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)     // Catch:{ Exception -> 0x04c2 }
            if (r4 == 0) goto L_0x0355
            r14 = 37
            goto L_0x0357
        L_0x0355:
            r14 = 39
        L_0x0357:
            if (r14 == r6) goto L_0x035d
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            goto L_0x0362
        L_0x035d:
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
        L_0x0362:
            java.lang.String r0 = "A011"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            int r4 = r4.Cardinal     // Catch:{ Exception -> 0x04c2 }
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A013"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            int r4 = r4.CardinalConfigurationParameters     // Catch:{ Exception -> 0x04c2 }
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A014"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            char[] r4 = r4.CardinalRenderType     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)     // Catch:{ Exception -> 0x04c2 }
            if (r4 == 0) goto L_0x0387
            r6 = 97
            goto L_0x0389
        L_0x0387:
            r6 = 38
        L_0x0389:
            r14 = 97
            if (r6 == r14) goto L_0x0391
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            goto L_0x03b8
        L_0x0391:
            int r6 = f2638p
            int r6 = r6 + 120
            r14 = r6 & -1
            r6 = r6 | -1
            int r14 = r14 + r6
            int r6 = r14 % 128
            f2639q = r6
            int r14 = r14 % 2
            if (r14 != 0) goto L_0x03a4
            r6 = 0
            goto L_0x03a5
        L_0x03a4:
            r6 = 1
        L_0x03a5:
            if (r6 == r3) goto L_0x03b3
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            r0 = 9
            int r0 = r0 / r2
            goto L_0x03b8
        L_0x03b0:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x03b3:
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
        L_0x03b8:
            java.lang.String r0 = "A015"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            char[] r4 = r4.CardinalUiType     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)     // Catch:{ Exception -> 0x04c2 }
            if (r4 == 0) goto L_0x03d7
            int r6 = f2638p
            r14 = r6 ^ 7
            r6 = r6 & r7
            int r6 = r6 << r3
            int r14 = r14 + r6
            int r6 = r14 % 128
            f2639q = r6
            int r14 = r14 % 2
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            goto L_0x03da
        L_0x03d7:
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
        L_0x03da:
            java.lang.String r0 = "A016"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            char[] r4 = r4.valueOf     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)     // Catch:{ Exception -> 0x04c2 }
            if (r4 == 0) goto L_0x03ec
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            goto L_0x03ef
        L_0x03ec:
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
        L_0x03ef:
            java.lang.String r0 = "A017"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A018"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            int r4 = r4.CardinalActionCode     // Catch:{ Exception -> 0x04c2 }
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A019"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A020"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A021"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            boolean r4 = r4.CardinalEnvironment     // Catch:{ Exception -> 0x04c2 }
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A023"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            boolean r4 = r4.getString     // Catch:{ Exception -> 0x04c2 }
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x04c2 }
            r4 = 23
            if (r0 < r4) goto L_0x0427
            r0 = 0
            goto L_0x0428
        L_0x0427:
            r0 = 1
        L_0x0428:
            if (r0 == 0) goto L_0x043f
            java.lang.String r0 = "A012"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A025"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A022"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A027"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            goto L_0x046b
        L_0x043f:
            java.lang.String r0 = "A012"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            int r4 = r4.setRequestTimeout     // Catch:{ Exception -> 0x04c2 }
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A025"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            boolean r4 = r4.CardinalError     // Catch:{ Exception -> 0x04c2 }
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A022"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            boolean r4 = r4.getWarnings     // Catch:{ Exception -> 0x04c2 }
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            java.lang.String r0 = "A027"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            boolean r4 = r4.cleanup     // Catch:{ Exception -> 0x04c2 }
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
        L_0x046b:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x04c2 }
            if (r0 < r11) goto L_0x0471
            r0 = 0
            goto L_0x0472
        L_0x0471:
            r0 = 1
        L_0x0472:
            if (r0 == r3) goto L_0x0493
            int r0 = f2639q
            r4 = r0 ^ 120(0x78, float:1.68E-43)
            r0 = r0 & 120(0x78, float:1.68E-43)
            int r0 = r0 << r3
            int r4 = r4 + r0
            r0 = r4 & -1
            r4 = r4 | -1
            int r0 = r0 + r4
            int r4 = r0 % 128
            f2638p = r4
            int r0 = r0 % 2
            java.lang.String r0 = "A024"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            boolean r4 = r4.getRequestTimeout     // Catch:{ Exception -> 0x04c2 }
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            goto L_0x0498
        L_0x0493:
            java.lang.String r0 = "A024"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
        L_0x0498:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x04c2 }
            if (r0 < r9) goto L_0x04bb
            int r0 = f2638p
            r4 = r0 & 87
            r0 = r0 ^ 87
            r0 = r0 | r4
            r6 = r4 ^ r0
            r0 = r0 & r4
            int r0 = r0 << r3
            int r6 = r6 + r0
            int r0 = r6 % 128
            f2639q = r0
            int r6 = r6 % 2
            java.lang.String r0 = "A026"
            com.cardinalcommerce.a.setTextSelectHandleRight r4 = r1.f2648i     // Catch:{ Exception -> 0x04c2 }
            boolean r4 = r4.getActionCode     // Catch:{ Exception -> 0x04c2 }
            org.json.JSONObject r6 = r1.f2641b     // Catch:{ Exception -> 0x04c2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x04c2 }
            goto L_0x0535
        L_0x04bb:
            java.lang.String r0 = "A026"
            r1.m1939a((java.lang.String) r0)     // Catch:{ Exception -> 0x04c2 }
            goto L_0x0535
        L_0x04c2:
            r0 = move-exception
            com.cardinalcommerce.a.setProgressBackgroundTintMode r4 = r1.f2653n
            com.cardinalcommerce.a.setImageMatrix r6 = new com.cardinalcommerce.a.setImageMatrix
            r14 = 11304(0x2c28, float:1.584E-41)
            java.lang.String r0 = r0.getLocalizedMessage()
            r6.<init>(r14, r0)
            r4.init(r6)
            goto L_0x0535
        L_0x04d4:
            r0 = 1
        L_0x04d5:
            if (r0 > r6) goto L_0x04f1
            java.lang.String r14 = java.lang.String.valueOf(r0)
            java.lang.String r15 = "A00"
            java.lang.String r14 = r15.concat(r14)
            r1.m1941b(r14)
            r14 = r0 & -2
            int r15 = ~r0
            r15 = r15 & r3
            r14 = r14 | r15
            r0 = r0 & 1
            int r0 = r0 << r3
            int r0 = ~r0
            int r14 = r14 - r0
            int r0 = r14 + -1
            goto L_0x04d5
        L_0x04f1:
            r0 = 10
        L_0x04f3:
            if (r0 > r4) goto L_0x0535
            int r6 = f2638p
            r14 = r6 ^ 81
            r6 = r6 & r13
            int r6 = r6 << r3
            int r14 = r14 + r6
            int r6 = r14 % 128
            f2639q = r6
            int r14 = r14 % 2
            if (r14 != 0) goto L_0x0506
            r6 = 1
            goto L_0x0507
        L_0x0506:
            r6 = 0
        L_0x0507:
            if (r6 == r3) goto L_0x051e
            java.lang.String r6 = java.lang.String.valueOf(r0)
            java.lang.String r6 = r12.concat(r6)
            r1.m1941b(r6)
            int r0 = r0 + 2
            r6 = r0 | -1
            int r6 = r6 << r3
            r0 = r0 ^ -1
            int r6 = r6 - r0
            r0 = r6
            goto L_0x04f3
        L_0x051e:
            java.lang.String r6 = java.lang.String.valueOf(r0)
            java.lang.String r6 = r12.concat(r6)
            r1.m1941b(r6)
            r6 = r0 ^ 41
            r0 = r0 & 41
            int r0 = r0 << r3
            r14 = r6 | r0
            int r14 = r14 << r3
            r0 = r0 ^ r6
            int r14 = r14 - r0
            r0 = r14
            goto L_0x04f3
        L_0x0535:
            android.content.Context r0 = r1.f2644e
            java.lang.String r4 = "android.permission.ACCESS_WIFI_STATE"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r4)
            if (r0 != 0) goto L_0x0542
            r0 = 92
            goto L_0x0544
        L_0x0542:
            r0 = 44
        L_0x0544:
            r4 = 92
            if (r0 == r4) goto L_0x055e
            r0 = 28
        L_0x054a:
            r4 = 38
            if (r0 > r4) goto L_0x057c
            java.lang.String r4 = java.lang.String.valueOf(r0)
            java.lang.String r4 = r12.concat(r4)
            r1.m1941b(r4)
            int r0 = r0 + 2
            int r0 = r0 - r2
            int r0 = r0 - r3
            goto L_0x054a
        L_0x055e:
            int r0 = f2639q
            r4 = r0 & 113(0x71, float:1.58E-43)
            r0 = r0 | 113(0x71, float:1.58E-43)
            r6 = r4 | r0
            int r6 = r6 << r3
            r0 = r0 ^ r4
            int r6 = r6 - r0
            int r0 = r6 % 128
            f2638p = r0
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x0579
            r17.m1942c()
            int r0 = r8.length     // Catch:{ all -> 0x0576 }
            goto L_0x057c
        L_0x0576:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0579:
            r17.m1942c()
        L_0x057c:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            r6 = 61
            r14 = 91
            if (r0 < r4) goto L_0x05d4
            android.content.Context r0 = r1.f2644e
            java.lang.String r4 = "android.permission.BLUETOOTH"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r4)
            if (r0 != 0) goto L_0x0592
            r0 = 1
            goto L_0x0593
        L_0x0592:
            r0 = 0
        L_0x0593:
            if (r0 == 0) goto L_0x0642
            int r0 = f2639q
            int r0 = r0 + 8
            int r0 = r0 - r3
            int r4 = r0 % 128
            f2638p = r4
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x05a4
            r0 = 1
            goto L_0x05a5
        L_0x05a4:
            r0 = 0
        L_0x05a5:
            if (r0 == 0) goto L_0x05b6
            android.content.Context r0 = r1.f2644e
            java.lang.String r4 = "android.permission.BLUETOOTH_CONNECT"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r4)
            int r4 = r8.length     // Catch:{ all -> 0x05b3 }
            if (r0 != 0) goto L_0x0642
            goto L_0x05c0
        L_0x05b3:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x05b6:
            android.content.Context r0 = r1.f2644e
            java.lang.String r4 = "android.permission.BLUETOOTH_CONNECT"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r4)
            if (r0 != 0) goto L_0x0642
        L_0x05c0:
            int r0 = f2638p
            int r0 = r0 + 110
            int r0 = r0 - r3
            int r4 = r0 % 128
            f2639q = r4
            int r0 = r0 % 2
            com.cardinalcommerce.a.setCompoundDrawablesRelative r0 = r1.f2651l
            if (r0 == 0) goto L_0x0642
            r17.m1940b()
            goto L_0x0642
        L_0x05d4:
            android.content.Context r0 = r1.f2644e
            java.lang.String r4 = "android.permission.BLUETOOTH"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r4)
            if (r0 != 0) goto L_0x05e0
            r0 = 0
            goto L_0x05e1
        L_0x05e0:
            r0 = 1
        L_0x05e1:
            if (r0 == 0) goto L_0x05e4
            goto L_0x05fd
        L_0x05e4:
            int r0 = f2639q
            r4 = r0 ^ 51
            r0 = r0 & 51
            int r0 = r0 << r3
            int r4 = r4 + r0
            int r0 = r4 % 128
            f2638p = r0
            int r4 = r4 % 2
            com.cardinalcommerce.a.setCompoundDrawablesRelative r0 = r1.f2651l
            if (r0 == 0) goto L_0x05f9
            r0 = 91
            goto L_0x05fb
        L_0x05f9:
            r0 = 58
        L_0x05fb:
            if (r0 == r14) goto L_0x0626
        L_0x05fd:
            r0 = 39
        L_0x05ff:
            r4 = 42
            if (r0 > r4) goto L_0x0642
            int r4 = f2638p
            r15 = r4 & 57
            int r5 = ~r15
            r4 = r4 | 57
            r4 = r4 & r5
            int r5 = r15 << 1
            int r4 = r4 + r5
            int r5 = r4 % 128
            f2639q = r5
            int r4 = r4 % 2
            java.lang.String r4 = java.lang.String.valueOf(r0)
            java.lang.String r4 = r12.concat(r4)
            r1.m1941b(r4)
            int r0 = r0 + 3
            int r0 = r0 - r3
            int r0 = r0 - r3
            r5 = 48
            goto L_0x05ff
        L_0x0626:
            int r0 = f2638p
            r4 = r0 & 61
            r0 = r0 ^ r6
            r0 = r0 | r4
            int r4 = r4 + r0
            int r0 = r4 % 128
            f2639q = r0
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x063f
            r17.m1940b()
            r0 = 33
            int r0 = r0 / r2
            goto L_0x0642
        L_0x063c:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x063f:
            r17.m1940b()
        L_0x0642:
            java.lang.String r0 = "A042"
            r1.m1939a((java.lang.String) r0)
            java.lang.String r0 = "A043"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.CardinalError
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0659
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x065c
        L_0x0659:
            r1.m1939a((java.lang.String) r0)
        L_0x065c:
            java.lang.String r0 = "A044"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.init
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            r5 = 73
            if (r4 == 0) goto L_0x066d
            r12 = 80
            goto L_0x066f
        L_0x066d:
            r12 = 73
        L_0x066f:
            if (r12 == r5) goto L_0x0677
            org.json.JSONObject r12 = r1.f2641b
            r12.put(r0, r4)
            goto L_0x067a
        L_0x0677:
            r1.m1939a((java.lang.String) r0)
        L_0x067a:
            java.lang.String r0 = "A045"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.values
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x06af
            int r12 = f2639q
            r15 = r12 & 15
            int r9 = ~r15
            r12 = r12 | 15
            r9 = r9 & r12
            int r12 = r15 << 1
            r15 = r9 | r12
            int r15 = r15 << r3
            r9 = r9 ^ r12
            int r15 = r15 - r9
            int r9 = r15 % 128
            f2638p = r9
            int r15 = r15 % 2
            if (r15 == 0) goto L_0x06a9
            org.json.JSONObject r9 = r1.f2641b
            r9.put(r0, r4)
            r0 = 65
            int r0 = r0 / r2
            goto L_0x06b2
        L_0x06a6:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x06a9:
            org.json.JSONObject r9 = r1.f2641b
            r9.put(r0, r4)
            goto L_0x06b2
        L_0x06af:
            r1.m1939a((java.lang.String) r0)
        L_0x06b2:
            java.lang.String r0 = "A046"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.getSDKVersion
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x06c4
            org.json.JSONObject r9 = r1.f2641b
            r9.put(r0, r4)
            goto L_0x06c7
        L_0x06c4:
            r1.m1939a((java.lang.String) r0)
        L_0x06c7:
            java.lang.String r0 = "A047"
            r1.m1939a((java.lang.String) r0)
            java.lang.String r0 = "A048"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.CardinalRenderType
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x06db
            r9 = 81
            goto L_0x06dd
        L_0x06db:
            r9 = 24
        L_0x06dd:
            if (r9 == r13) goto L_0x06e3
            r1.m1939a((java.lang.String) r0)
            goto L_0x06e8
        L_0x06e3:
            org.json.JSONObject r9 = r1.f2641b
            r9.put(r0, r4)
        L_0x06e8:
            java.lang.String r0 = "A049"
            r1.m1939a((java.lang.String) r0)
            java.lang.String r0 = "A050"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.configure
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x06fb
            r9 = 0
            goto L_0x06fc
        L_0x06fb:
            r9 = 1
        L_0x06fc:
            if (r9 == 0) goto L_0x0702
            r1.m1939a((java.lang.String) r0)
            goto L_0x0707
        L_0x0702:
            org.json.JSONObject r9 = r1.f2641b
            r9.put(r0, r4)
        L_0x0707:
            java.lang.String r0 = "A051"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.CardinalActionCode
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            r9 = 63
            if (r4 == 0) goto L_0x0718
            r12 = 42
            goto L_0x071a
        L_0x0718:
            r12 = 63
        L_0x071a:
            if (r12 == r9) goto L_0x072b
            int r12 = f2639q
            int r12 = r12 + r9
            int r9 = r12 % 128
            f2638p = r9
            int r12 = r12 % 2
            org.json.JSONObject r9 = r1.f2641b
            r9.put(r0, r4)
            goto L_0x072e
        L_0x072b:
            r1.m1939a((java.lang.String) r0)
        L_0x072e:
            java.lang.String r0 = "A052"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.valueOf
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x073d
            r9 = 20
            goto L_0x073e
        L_0x073d:
            r9 = 7
        L_0x073e:
            if (r9 == r7) goto L_0x0746
            org.json.JSONObject r9 = r1.f2641b
            r9.put(r0, r4)
            goto L_0x075b
        L_0x0746:
            r1.m1939a((java.lang.String) r0)
            int r0 = f2639q
            r4 = r0 & 121(0x79, float:1.7E-43)
            int r9 = ~r4
            r0 = r0 | 121(0x79, float:1.7E-43)
            r0 = r0 & r9
            int r4 = r4 << r3
            int r4 = ~r4
            int r0 = r0 - r4
            int r0 = r0 - r3
            int r4 = r0 % 128
            f2638p = r4
            int r0 = r0 % 2
        L_0x075b:
            java.lang.String r0 = "A053"
            r1.m1939a((java.lang.String) r0)
            java.lang.String r0 = "A054"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.getActionCode
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x076f
            r9 = 48
            goto L_0x0771
        L_0x076f:
            r9 = 81
        L_0x0771:
            if (r9 == r13) goto L_0x0787
            int r9 = f2639q
            r12 = r9 ^ 69
            r9 = r9 & 69
            int r9 = r9 << r3
            int r12 = r12 + r9
            int r9 = r12 % 128
            f2638p = r9
            int r12 = r12 % 2
            org.json.JSONObject r9 = r1.f2641b
            r9.put(r0, r4)
            goto L_0x078a
        L_0x0787:
            r1.m1939a((java.lang.String) r0)
        L_0x078a:
            java.lang.String r0 = "A055"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.setRequestTimeout
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x079c
            org.json.JSONObject r9 = r1.f2641b
            r9.put(r0, r4)
            goto L_0x079f
        L_0x079c:
            r1.m1939a((java.lang.String) r0)
        L_0x079f:
            java.lang.String r0 = "A056"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.getString
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x07b1
            org.json.JSONObject r9 = r1.f2641b
            r9.put(r0, r4)
            goto L_0x07b4
        L_0x07b1:
            r1.m1939a((java.lang.String) r0)
        L_0x07b4:
            com.cardinalcommerce.a.setCompoundDrawableTintList r0 = r1.f2649j
            long r10 = r0.Cardinal
            float r0 = (float) r10
            org.json.JSONObject r10 = r1.f2641b
            double r11 = (double) r0
            java.lang.String r0 = "A057"
            r10.put(r0, r11)
            java.lang.String r0 = "A058"
            com.cardinalcommerce.a.setCompoundDrawableTintList r10 = r1.f2649j
            char[] r10 = r10.CardinalEnvironment
            java.lang.String r10 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r10)
            if (r10 == 0) goto L_0x07cf
            r11 = 0
            goto L_0x07d0
        L_0x07cf:
            r11 = 1
        L_0x07d0:
            if (r11 == 0) goto L_0x07d6
            r1.m1939a((java.lang.String) r0)
            goto L_0x07e5
        L_0x07d6:
            org.json.JSONObject r11 = r1.f2641b
            r11.put(r0, r10)
            int r0 = f2639q
            int r0 = r0 + 117
            int r10 = r0 % 128
            f2638p = r10
            int r0 = r0 % 2
        L_0x07e5:
            java.lang.String r0 = "A059"
            com.cardinalcommerce.a.setCompoundDrawableTintList r10 = r1.f2649j
            char[] r10 = r10.CardinalUiType
            java.lang.String r10 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r10)
            if (r10 == 0) goto L_0x07f3
            r11 = 0
            goto L_0x07f4
        L_0x07f3:
            r11 = 1
        L_0x07f4:
            if (r11 == r3) goto L_0x080d
            int r11 = f2639q
            int r11 = r11 + 47
            int r11 = r11 - r3
            r12 = r11 ^ -1
            r11 = r11 & -1
            int r11 = r11 << r3
            int r12 = r12 + r11
            int r11 = r12 % 128
            f2638p = r11
            int r12 = r12 % 2
            org.json.JSONObject r11 = r1.f2641b
            r11.put(r0, r10)
            goto L_0x0810
        L_0x080d:
            r1.m1939a((java.lang.String) r0)
        L_0x0810:
            java.lang.String r0 = "A060"
            com.cardinalcommerce.a.setTextSelectHandleLeft r10 = r1.f2650k
            char[] r10 = r10.getInstance
            java.lang.String r10 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r10)
            if (r10 == 0) goto L_0x0837
            int r11 = f2638p
            r12 = r11 | 69
            int r15 = r12 << 1
            r11 = r11 & 69
            int r11 = ~r11
            r11 = r11 & r12
            int r11 = -r11
            r12 = r15 & r11
            r11 = r11 | r15
            int r12 = r12 + r11
            int r11 = r12 % 128
            f2639q = r11
            int r12 = r12 % 2
            org.json.JSONObject r11 = r1.f2641b
            r11.put(r0, r10)
            goto L_0x083a
        L_0x0837:
            r1.m1939a((java.lang.String) r0)
        L_0x083a:
            java.lang.String r0 = "A061"
            com.cardinalcommerce.a.setTextSelectHandleLeft r10 = r1.f2650k
            char[] r10 = r10.CardinalError
            java.lang.String r10 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r10)
            if (r10 == 0) goto L_0x084c
            org.json.JSONObject r11 = r1.f2641b
            r11.put(r0, r10)
            goto L_0x084f
        L_0x084c:
            r1.m1939a((java.lang.String) r0)
        L_0x084f:
            com.cardinalcommerce.a.setTextSelectHandleLeft r0 = r1.f2650k
            int r0 = r0.cleanup
            org.json.JSONObject r10 = r1.f2641b
            java.lang.String r11 = "A062"
            r10.put(r11, r0)
            com.cardinalcommerce.a.setTextSelectHandleLeft r0 = r1.f2650k
            int r0 = r0.getSDKVersion
            org.json.JSONObject r10 = r1.f2641b
            java.lang.String r11 = "A063"
            r10.put(r11, r0)
            java.lang.String r0 = "A064"
            com.cardinalcommerce.a.setTextSelectHandleLeft r10 = r1.f2650k
            char[] r10 = r10.values
            java.lang.String r10 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r10)
            if (r10 == 0) goto L_0x088c
            org.json.JSONObject r11 = r1.f2641b
            r11.put(r0, r10)
            int r0 = f2638p
            r10 = r0 | 59
            int r11 = r10 << 1
            r0 = r0 & 59
            int r0 = ~r0
            r0 = r0 & r10
            int r0 = -r0
            r10 = r11 & r0
            r0 = r0 | r11
            int r10 = r10 + r0
            int r0 = r10 % 128
            f2639q = r0
            int r10 = r10 % 2
            goto L_0x088f
        L_0x088c:
            r1.m1939a((java.lang.String) r0)
        L_0x088f:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.PrivateKeyInfo
            org.json.JSONObject r10 = r1.f2641b
            java.lang.String r11 = "A065"
            r10.put(r11, r0)
            java.lang.String r0 = "A066"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r10 = r1.f2652m
            char[] r10 = r10.setRenderType
            java.lang.String r10 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r10)
            if (r10 == 0) goto L_0x08a9
            r11 = 73
            goto L_0x08ab
        L_0x08a9:
            r11 = 29
        L_0x08ab:
            if (r11 == r5) goto L_0x08b1
            r1.m1939a((java.lang.String) r0)
            goto L_0x08d4
        L_0x08b1:
            int r5 = f2639q
            r11 = r5 & 7
            r5 = r5 ^ r7
            r5 = r5 | r11
            r12 = r11 & r5
            r5 = r5 | r11
            int r12 = r12 + r5
            int r5 = r12 % 128
            f2638p = r5
            int r12 = r12 % 2
            if (r12 == 0) goto L_0x08cf
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r10)
            super.hashCode()     // Catch:{ all -> 0x08cc }
            goto L_0x08d4
        L_0x08cc:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x08cf:
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r10)
        L_0x08d4:
            java.lang.String r0 = "A067"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.getUiType
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x08e2
            r10 = 1
            goto L_0x08e3
        L_0x08e2:
            r10 = 0
        L_0x08e3:
            if (r10 == 0) goto L_0x08eb
            org.json.JSONObject r10 = r1.f2641b
            r10.put(r0, r5)
            goto L_0x08ee
        L_0x08eb:
            r1.m1939a((java.lang.String) r0)
        L_0x08ee:
            java.lang.String r0 = "A068"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.getRenderType
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x08fd
            r10 = 86
            goto L_0x08ff
        L_0x08fd:
            r10 = 66
        L_0x08ff:
            r11 = 86
            if (r10 == r11) goto L_0x0907
            r1.m1939a((java.lang.String) r0)
            goto L_0x0924
        L_0x0907:
            int r10 = f2639q
            r11 = r10 ^ 3
            r12 = r10 & 3
            r11 = r11 | r12
            int r11 = r11 << r3
            r12 = r10 & -4
            int r10 = ~r10
            r10 = r10 & 3
            r10 = r10 | r12
            int r10 = -r10
            int r10 = ~r10
            int r11 = r11 - r10
            int r11 = r11 - r3
            int r10 = r11 % 128
            f2638p = r10
            int r11 = r11 % 2
            org.json.JSONObject r10 = r1.f2641b
            r10.put(r0, r5)
        L_0x0924:
            java.lang.String r0 = "A069"
            r1.m1939a((java.lang.String) r0)
            java.lang.String r0 = "A070"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.onSetupCompleted
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x093b
            org.json.JSONObject r10 = r1.f2641b
            r10.put(r0, r5)
            goto L_0x093e
        L_0x093b:
            r1.m1939a((java.lang.String) r0)
        L_0x093e:
            java.lang.String r0 = "A071"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.setUiType
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x095f
            int r10 = f2638p
            r11 = r10 & 57
            r10 = r10 | 57
            int r10 = ~r10
            int r11 = r11 - r10
            int r11 = r11 - r3
            int r10 = r11 % 128
            f2639q = r10
            int r11 = r11 % 2
            org.json.JSONObject r10 = r1.f2641b
            r10.put(r0, r5)
            goto L_0x0962
        L_0x095f:
            r1.m1939a((java.lang.String) r0)
        L_0x0962:
            java.lang.String r0 = "A072"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.CardinalInitService
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0971
            r10 = 75
            goto L_0x0973
        L_0x0971:
            r10 = 96
        L_0x0973:
            r11 = 96
            if (r10 == r11) goto L_0x097d
            org.json.JSONObject r7 = r1.f2641b
            r7.put(r0, r5)
            goto L_0x0989
        L_0x097d:
            r1.m1939a((java.lang.String) r0)
            int r0 = f2638p
            int r0 = r0 + r7
            int r5 = r0 % 128
            f2639q = r5
            int r0 = r0 % 2
        L_0x0989:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.onValidated
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r7 = "A073"
            r5.put(r7, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.setUICustomization
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r7 = "A074"
            r5.put(r7, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.setProxyAddress
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r7 = "A075"
            r5.put(r7, r0)
            java.lang.String r0 = "A076"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.getThreeDSRequestorAppURL
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x09b9
            r7 = 48
            goto L_0x09bb
        L_0x09b9:
            r7 = 61
        L_0x09bb:
            if (r7 == r6) goto L_0x09c3
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x09c6
        L_0x09c3:
            r1.m1939a((java.lang.String) r0)
        L_0x09c6:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.DSA
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A077"
            r5.put(r6, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.CardinalValidateReceiver
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A078"
            r5.put(r6, r0)
            java.lang.String r0 = "A079"
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r8)
            if (r5 == 0) goto L_0x0a0b
            int r6 = f2639q
            r7 = r6 ^ 13
            r6 = r6 & 13
            int r6 = r6 << r3
            int r7 = r7 + r6
            int r6 = r7 % 128
            f2638p = r6
            int r7 = r7 % 2
            if (r7 == 0) goto L_0x09f6
            r6 = 1
            goto L_0x09f7
        L_0x09f6:
            r6 = 0
        L_0x09f7:
            if (r6 == r3) goto L_0x09ff
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x0a0e
        L_0x09ff:
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            r0 = 37
            int r0 = r0 / r2
            goto L_0x0a0e
        L_0x0a08:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0a0b:
            r1.m1939a((java.lang.String) r0)
        L_0x0a0e:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.ASN1ObjectIdentifier
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A080"
            r5.put(r6, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.getUICustomization
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A081"
            r5.put(r6, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.setEnableDFSync
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A082"
            r5.put(r6, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.isEnableDFSync
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A083"
            r5.put(r6, r0)
            java.lang.String r0 = "A084"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.isEnableLogging
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0a65
            int r6 = f2639q
            r7 = r6 & 65
            r6 = r6 | 65
            int r7 = r7 + r6
            int r6 = r7 % 128
            f2638p = r6
            int r7 = r7 % 2
            if (r7 == 0) goto L_0x0a5f
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            int r0 = r8.length     // Catch:{ all -> 0x0a5c }
            goto L_0x0a68
        L_0x0a5c:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0a5f:
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x0a68
        L_0x0a65:
            r1.m1939a((java.lang.String) r0)
        L_0x0a68:
            java.lang.String r0 = "A085"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.isLocationDataConsentGiven
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0a7a
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x0a7d
        L_0x0a7a:
            r1.m1939a((java.lang.String) r0)
        L_0x0a7d:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.setLocationDataConsentGiven
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A086"
            r5.put(r6, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.getPayment
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A087"
            r5.put(r6, r0)
            java.lang.String r0 = "A088"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.setEnableLogging
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0ac4
            int r6 = f2638p
            r7 = r6 & 91
            int r10 = ~r7
            r6 = r6 | r14
            r6 = r6 & r10
            int r7 = r7 << r3
            int r7 = -r7
            int r7 = -r7
            int r7 = ~r7
            int r6 = r6 - r7
            int r6 = r6 - r3
            int r7 = r6 % 128
            f2639q = r7
            int r6 = r6 % 2
            if (r6 != 0) goto L_0x0abe
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            int r0 = r8.length     // Catch:{ all -> 0x0abb }
            goto L_0x0ac7
        L_0x0abb:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0abe:
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x0ac7
        L_0x0ac4:
            r1.m1939a((java.lang.String) r0)
        L_0x0ac7:
            java.lang.String r0 = "A089"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.setThreeDSRequestorAppURL
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0ad9
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x0adc
        L_0x0ad9:
            r1.m1939a((java.lang.String) r0)
        L_0x0adc:
            java.lang.String r0 = "A090"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.getExtendedData
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0aee
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x0af1
        L_0x0aee:
            r1.m1939a((java.lang.String) r0)
        L_0x0af1:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.getType
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A091"
            r5.put(r6, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.getJSON
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A092"
            r5.put(r6, r0)
            java.lang.String r0 = "A093"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.getProcessorTransactionId
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0b15
            r6 = 0
            goto L_0x0b16
        L_0x0b15:
            r6 = 1
        L_0x0b16:
            if (r6 == r3) goto L_0x0b44
            int r6 = f2638p
            r7 = r6 & -20
            int r10 = ~r6
            r10 = r10 & 19
            r7 = r7 | r10
            r6 = r6 & 19
            int r6 = r6 << r3
            int r6 = -r6
            int r6 = -r6
            r10 = r7 | r6
            int r10 = r10 << r3
            r6 = r6 ^ r7
            int r10 = r10 - r6
            int r6 = r10 % 128
            f2639q = r6
            int r10 = r10 % 2
            if (r10 != 0) goto L_0x0b3e
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            super.hashCode()     // Catch:{ all -> 0x0b3b }
            goto L_0x0b47
        L_0x0b3b:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0b3e:
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x0b47
        L_0x0b44:
            r1.m1939a((java.lang.String) r0)
        L_0x0b47:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.Payment
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A094"
            r5.put(r6, r0)
            java.lang.String r0 = "A095"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.getErrorNumber
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0b60
            r6 = 1
            goto L_0x0b61
        L_0x0b60:
            r6 = 0
        L_0x0b61:
            if (r6 == r3) goto L_0x0b67
            r1.m1939a((java.lang.String) r0)
            goto L_0x0b6c
        L_0x0b67:
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
        L_0x0b6c:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.ValidateResponse
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A096"
            r5.put(r6, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.isValidated
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A097"
            r5.put(r6, r0)
            java.lang.String r0 = "A098"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.getErrorDescription
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0ba5
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            int r0 = f2638p
            int r0 = r0 + 43
            int r0 = r0 - r3
            r5 = r0 | -1
            int r5 = r5 << r3
            r0 = r0 ^ -1
            int r5 = r5 - r0
            int r0 = r5 % 128
            f2639q = r0
            int r5 = r5 % 2
            goto L_0x0ba8
        L_0x0ba5:
            r1.m1939a((java.lang.String) r0)
        L_0x0ba8:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.configure
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A099"
            r5.put(r6, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.getInstance
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A100"
            r5.put(r6, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.cca_continue
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A101"
            r5.put(r6, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.Cardinal
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A102"
            r5.put(r6, r0)
            java.lang.String r0 = "A103"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.getEnvironment
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0be6
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x0be9
        L_0x0be6:
            r1.m1939a((java.lang.String) r0)
        L_0x0be9:
            java.lang.String r0 = "A104"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.init
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0c1d
            int r6 = f2638p
            r7 = r6 | 18
            int r7 = r7 << r3
            r6 = r6 ^ 18
            int r7 = r7 - r6
            r6 = r7 ^ -1
            r7 = r7 & -1
            int r7 = r7 << r3
            int r6 = r6 + r7
            int r7 = r6 % 128
            f2639q = r7
            int r6 = r6 % 2
            if (r6 != 0) goto L_0x0c17
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            r0 = 33
            int r0 = r0 / r2
            goto L_0x0c20
        L_0x0c14:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0c17:
            org.json.JSONObject r6 = r1.f2641b
            r6.put(r0, r5)
            goto L_0x0c20
        L_0x0c1d:
            r1.m1939a((java.lang.String) r0)
        L_0x0c20:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.cleanup
            org.json.JSONObject r5 = r1.f2641b
            java.lang.String r6 = "A105"
            r5.put(r6, r0)
            java.lang.String r0 = "A106"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r5 = r1.f2652m
            char[] r5 = r5.getWarnings
            java.lang.String r5 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r5)
            if (r5 == 0) goto L_0x0c3a
            r10 = 81
            goto L_0x0c3c
        L_0x0c3a:
            r10 = 12
        L_0x0c3c:
            if (r10 == r13) goto L_0x0c42
            r1.m1939a((java.lang.String) r0)
            goto L_0x0c47
        L_0x0c42:
            org.json.JSONObject r4 = r1.f2641b
            r4.put(r0, r5)
        L_0x0c47:
            java.lang.String r0 = "A107"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.values
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0c55
            r5 = 1
            goto L_0x0c56
        L_0x0c55:
            r5 = 0
        L_0x0c56:
            if (r5 == r3) goto L_0x0c5c
            r1.m1939a((java.lang.String) r0)
            goto L_0x0c78
        L_0x0c5c:
            int r5 = f2639q
            r6 = 51
            r7 = r5 & -52
            int r10 = ~r5
            r10 = r10 & r6
            r7 = r7 | r10
            r5 = r5 & r6
            int r5 = r5 << r3
            int r5 = -r5
            int r5 = -r5
            r6 = r7 & r5
            r5 = r5 | r7
            int r6 = r6 + r5
            int r5 = r6 % 128
            f2638p = r5
            int r6 = r6 % 2
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
        L_0x0c78:
            java.lang.String r0 = "A108"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.CardinalError
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0c8a
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x0c8d
        L_0x0c8a:
            r1.m1939a((java.lang.String) r0)
        L_0x0c8d:
            java.lang.String r0 = "A109"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.getSDKVersion
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0c9b
            r5 = 1
            goto L_0x0c9c
        L_0x0c9b:
            r5 = 0
        L_0x0c9c:
            if (r5 == 0) goto L_0x0cb8
            int r5 = f2638p
            r6 = r5 & 5
            r5 = r5 ^ 5
            r5 = r5 | r6
            int r5 = -r5
            int r5 = -r5
            r7 = r6 ^ r5
            r5 = r5 & r6
            int r5 = r5 << r3
            int r7 = r7 + r5
            int r5 = r7 % 128
            f2639q = r5
            int r7 = r7 % 2
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x0cbb
        L_0x0cb8:
            r1.m1939a((java.lang.String) r0)
        L_0x0cbb:
            java.lang.String r0 = "A110"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.CardinalEnvironment
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0cdf
            int r5 = f2639q
            r6 = r5 & 69
            r5 = r5 ^ 69
            r5 = r5 | r6
            r7 = r6 | r5
            int r7 = r7 << r3
            r5 = r5 ^ r6
            int r7 = r7 - r5
            int r5 = r7 % 128
            f2638p = r5
            int r7 = r7 % 2
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x0ce2
        L_0x0cdf:
            r1.m1939a((java.lang.String) r0)
        L_0x0ce2:
            java.lang.String r0 = "A111"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.CardinalRenderType
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0cf0
            r5 = 1
            goto L_0x0cf1
        L_0x0cf0:
            r5 = 0
        L_0x0cf1:
            if (r5 == 0) goto L_0x0cf9
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x0cfc
        L_0x0cf9:
            r1.m1939a((java.lang.String) r0)
        L_0x0cfc:
            java.lang.String r0 = "A112"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.CardinalUiType
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0d0b
            r5 = 50
            goto L_0x0d0d
        L_0x0d0b:
            r5 = 21
        L_0x0d0d:
            r6 = 21
            if (r5 == r6) goto L_0x0d24
            int r5 = f2638p
            r6 = r5 & 125(0x7d, float:1.75E-43)
            r5 = r5 | 125(0x7d, float:1.75E-43)
            int r6 = r6 + r5
            int r5 = r6 % 128
            f2639q = r5
            int r6 = r6 % 2
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x0d27
        L_0x0d24:
            r1.m1939a((java.lang.String) r0)
        L_0x0d27:
            java.lang.String r0 = "A113"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.CardinalActionCode
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0d39
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x0d3c
        L_0x0d39:
            r1.m1939a((java.lang.String) r0)
        L_0x0d3c:
            java.lang.String r0 = "A114"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.valueOf
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0d4a
            r5 = 1
            goto L_0x0d4b
        L_0x0d4a:
            r5 = 0
        L_0x0d4b:
            if (r5 == r3) goto L_0x0d51
            r1.m1939a((java.lang.String) r0)
            goto L_0x0d56
        L_0x0d51:
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
        L_0x0d56:
            java.lang.String r0 = "A115"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.CardinalConfigurationParameters
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0d64
            r5 = 0
            goto L_0x0d65
        L_0x0d64:
            r5 = 1
        L_0x0d65:
            if (r5 == 0) goto L_0x0d6b
            r1.m1939a((java.lang.String) r0)
            goto L_0x0d70
        L_0x0d6b:
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
        L_0x0d70:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.getActionCode
            org.json.JSONObject r4 = r1.f2641b
            java.lang.String r5 = "A116"
            r4.put(r5, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.setRequestTimeout
            org.json.JSONObject r4 = r1.f2641b
            java.lang.String r5 = "A117"
            r4.put(r5, r0)
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.getRequestTimeout
            org.json.JSONObject r4 = r1.f2641b
            java.lang.String r5 = "A118"
            r4.put(r5, r0)
            java.lang.String r0 = "A119"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.getString
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0da3
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x0da6
        L_0x0da3:
            r1.m1939a((java.lang.String) r0)
        L_0x0da6:
            java.lang.String r0 = "A120"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.setChallengeTimeout
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0dcc
            int r5 = f2638p
            r6 = r5 & 87
            r5 = r5 ^ 87
            r5 = r5 | r6
            int r5 = -r5
            int r5 = -r5
            r7 = r6 ^ r5
            r5 = r5 & r6
            int r5 = r5 << r3
            int r7 = r7 + r5
            int r5 = r7 % 128
            f2639q = r5
            int r7 = r7 % 2
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x0dcf
        L_0x0dcc:
            r1.m1939a((java.lang.String) r0)
        L_0x0dcf:
            java.lang.String r0 = "A121"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.getProxyAddress
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0e06
            int r5 = f2638p
            r6 = r5 & 125(0x7d, float:1.75E-43)
            int r7 = ~r6
            r5 = r5 | 125(0x7d, float:1.75E-43)
            r5 = r5 & r7
            int r6 = r6 << r3
            int r5 = r5 + r6
            int r6 = r5 % 128
            f2639q = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x0df0
            r9 = 22
            goto L_0x0df2
        L_0x0df0:
            r9 = 43
        L_0x0df2:
            r5 = 43
            if (r9 == r5) goto L_0x0e00
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            int r0 = r8.length     // Catch:{ all -> 0x0dfd }
            goto L_0x0e09
        L_0x0dfd:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0e00:
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x0e09
        L_0x0e06:
            r1.m1939a((java.lang.String) r0)
        L_0x0e09:
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r0 = r1.f2652m
            int r0 = r0.getChallengeTimeout
            org.json.JSONObject r4 = r1.f2641b
            java.lang.String r5 = "A122"
            r4.put(r5, r0)
            java.lang.String r0 = "A123"
            com.cardinalcommerce.a.setLastBaselineToBottomHeight r4 = r1.f2652m
            char[] r4 = r4.setEnvironment
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0e26
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x0e29
        L_0x0e26:
            r1.m1939a((java.lang.String) r0)
        L_0x0e29:
            r0 = 124(0x7c, float:1.74E-43)
        L_0x0e2b:
            r4 = 128(0x80, float:1.794E-43)
            if (r0 > r4) goto L_0x0e57
            int r4 = f2639q
            r5 = r4 & 41
            r4 = r4 | 41
            int r5 = r5 + r4
            int r4 = r5 % 128
            f2638p = r4
            int r5 = r5 % 2
            java.lang.String r4 = java.lang.String.valueOf(r0)
            java.lang.String r5 = "A"
            java.lang.String r4 = r5.concat(r4)
            r1.m1941b(r4)
            r4 = r0 & 1
            int r5 = ~r4
            r0 = r0 | 1
            r0 = r0 & r5
            int r4 = r4 << r3
            int r4 = -r4
            int r4 = -r4
            r5 = r0 & r4
            r0 = r0 | r4
            int r0 = r0 + r5
            goto L_0x0e2b
        L_0x0e57:
            java.lang.String r0 = "A129"
            java.lang.String r4 = android.os.Environment.getExternalStorageState()
            if (r4 == 0) goto L_0x0e62
            r5 = 76
            goto L_0x0e63
        L_0x0e62:
            r5 = 6
        L_0x0e63:
            r6 = 6
            if (r5 == r6) goto L_0x0e8d
            int r5 = f2639q
            r6 = r5 & 126(0x7e, float:1.77E-43)
            r5 = r5 | 126(0x7e, float:1.77E-43)
            int r6 = r6 + r5
            r5 = r6 | -1
            int r5 = r5 << r3
            r6 = r6 ^ -1
            int r5 = r5 - r6
            int r6 = r5 % 128
            f2638p = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0e87
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            r0 = 21
            int r0 = r0 / r2
            goto L_0x0e90
        L_0x0e84:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0e87:
            org.json.JSONObject r5 = r1.f2641b
            r5.put(r0, r4)
            goto L_0x0e90
        L_0x0e8d:
            r1.m1939a((java.lang.String) r0)
        L_0x0e90:
            java.lang.String r0 = "A130"
            com.cardinalcommerce.a.setCompoundDrawableTintList r4 = r1.f2649j
            char[] r4 = r4.getWarnings
            java.lang.String r4 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r4)
            if (r4 == 0) goto L_0x0e9d
            r2 = 1
        L_0x0e9d:
            if (r2 == r3) goto L_0x0ea3
            r1.m1939a((java.lang.String) r0)
            goto L_0x0ea8
        L_0x0ea3:
            org.json.JSONObject r2 = r1.f2641b
            r2.put(r0, r4)
        L_0x0ea8:
            com.cardinalcommerce.a.setCompoundDrawableTintList r0 = r1.f2649j
            float r0 = r0.getRequestTimeout
            org.json.JSONObject r2 = r1.f2641b
            double r3 = (double) r0
            java.lang.String r0 = "A131"
            r2.put(r0, r3)
            com.cardinalcommerce.a.setCompoundDrawableTintList r0 = r1.f2649j
            int r0 = r0.CardinalConfigurationParameters
            org.json.JSONObject r2 = r1.f2641b
            java.lang.String r3 = "A132"
            r2.put(r3, r0)
            com.cardinalcommerce.a.setCompoundDrawableTintList r0 = r1.f2649j
            float r0 = r0.setChallengeTimeout
            org.json.JSONObject r2 = r1.f2641b
            double r3 = (double) r0
            java.lang.String r0 = "A133"
            r2.put(r0, r3)
            com.cardinalcommerce.a.setCompoundDrawableTintList r0 = r1.f2649j
            double r2 = r0.getEnvironment
            long r2 = java.lang.Math.round(r2)
            float r0 = (float) r2
            org.json.JSONObject r2 = r1.f2641b
            double r3 = (double) r0
            java.lang.String r0 = "A134"
            r2.put(r0, r3)
            com.cardinalcommerce.a.setCompoundDrawableTintList r0 = r1.f2649j
            double r2 = r0.getChallengeTimeout
            long r2 = java.lang.Math.round(r2)
            float r0 = (float) r2
            org.json.JSONObject r2 = r1.f2641b
            double r3 = (double) r0
            java.lang.String r0 = "A135"
            r2.put(r0, r3)
            com.cardinalcommerce.a.setCompoundDrawableTintList r0 = r1.f2649j
            long r2 = r0.getProxyAddress
            float r0 = (float) r2
            org.json.JSONObject r2 = r1.f2641b
            double r3 = (double) r0
            java.lang.String r0 = "A136"
            r2.put(r0, r3)
        L_0x0efa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2029s.m1938a():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if ((r2 != null) != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        if ((r2 != null) != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0078, code lost:
        m1939a("A029");
        r2 = f2639q + 68;
        r3 = (r2 ^ -1) + ((r2 & -1) << 1);
        f2638p = r3 % 128;
        r3 = r3 % 2;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1942c() throws org.json.JSONException {
        /*
            r7 = this;
            int r0 = f2638p
            r1 = r0 & 103(0x67, float:1.44E-43)
            r0 = r0 ^ 103(0x67, float:1.44E-43)
            r0 = r0 | r1
            int r0 = -r0
            int r0 = -r0
            r2 = r1 ^ r0
            r0 = r0 & r1
            r1 = 1
            int r0 = r0 << r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f2639q = r0
            int r2 = r2 % 2
            r0 = 0
            if (r2 != 0) goto L_0x001a
            r2 = 0
            goto L_0x001b
        L_0x001a:
            r2 = 1
        L_0x001b:
            java.lang.String r3 = "A029"
            java.lang.String r4 = "A028"
            if (r2 == r1) goto L_0x0039
            r7.m1939a((java.lang.String) r4)
            com.cardinalcommerce.a.setCompoundDrawableTintMode r2 = r7.f2647h
            char[] r2 = r2.getInstance
            java.lang.String r2 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r2)
            r4 = 97
            int r4 = r4 / r0
            if (r2 == 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            if (r4 == 0) goto L_0x0078
            goto L_0x004b
        L_0x0037:
            r0 = move-exception
            throw r0
        L_0x0039:
            r7.m1939a((java.lang.String) r4)
            com.cardinalcommerce.a.setCompoundDrawableTintMode r2 = r7.f2647h
            char[] r2 = r2.getInstance
            java.lang.String r2 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r2)
            if (r2 == 0) goto L_0x0048
            r4 = 1
            goto L_0x0049
        L_0x0048:
            r4 = 0
        L_0x0049:
            if (r4 == 0) goto L_0x0078
        L_0x004b:
            int r4 = f2639q
            r5 = r4 ^ 66
            r4 = r4 & 66
            int r4 = r4 << r1
            int r5 = r5 + r4
            int r5 = r5 - r0
            int r5 = r5 - r1
            int r4 = r5 % 128
            f2638p = r4
            int r5 = r5 % 2
            r4 = 13
            if (r5 == 0) goto L_0x0062
            r5 = 99
            goto L_0x0064
        L_0x0062:
            r5 = 13
        L_0x0064:
            if (r5 == r4) goto L_0x0072
            org.json.JSONObject r4 = r7.f2641b
            r4.put(r3, r2)
            r2 = 0
            super.hashCode()     // Catch:{ all -> 0x0070 }
            goto L_0x008b
        L_0x0070:
            r0 = move-exception
            throw r0
        L_0x0072:
            org.json.JSONObject r4 = r7.f2641b
            r4.put(r3, r2)
            goto L_0x008b
        L_0x0078:
            r7.m1939a((java.lang.String) r3)
            int r2 = f2639q
            int r2 = r2 + 68
            r3 = r2 ^ -1
            r2 = r2 & -1
            int r2 = r2 << r1
            int r3 = r3 + r2
            int r2 = r3 % 128
            f2638p = r2
            int r3 = r3 % 2
        L_0x008b:
            java.lang.String r2 = "A030"
            com.cardinalcommerce.a.setCompoundDrawableTintMode r3 = r7.f2647h
            char[] r3 = r3.configure
            java.lang.String r3 = com.cardinalcommerce.p060a.setHorizontallyScrolling.configure((char[]) r3)
            r4 = 93
            r5 = 36
            if (r3 == 0) goto L_0x009e
            r6 = 93
            goto L_0x00a0
        L_0x009e:
            r6 = 36
        L_0x00a0:
            if (r6 == r5) goto L_0x00c5
            int r5 = f2639q
            int r5 = r5 + 19
            int r6 = r5 % 128
            f2638p = r6
            int r5 = r5 % 2
            org.json.JSONObject r5 = r7.f2641b
            r5.put(r2, r3)
            int r2 = f2639q
            r3 = r2 & 93
            int r5 = ~r3
            r2 = r2 | r4
            r2 = r2 & r5
            int r3 = r3 << r1
            int r3 = -r3
            int r3 = -r3
            int r3 = ~r3
            int r2 = r2 - r3
            int r2 = r2 - r1
            int r3 = r2 % 128
            f2638p = r3
            int r2 = r2 % 2
            goto L_0x00e2
        L_0x00c5:
            r7.m1939a((java.lang.String) r2)
            int r2 = f2638p
            r3 = r2 ^ 77
            r4 = r2 & 77
            r3 = r3 | r4
            int r3 = r3 << r1
            r4 = r2 & -78
            int r2 = ~r2
            r5 = 77
            r2 = r2 & r5
            r2 = r2 | r4
            int r2 = -r2
            r4 = r3 & r2
            r2 = r2 | r3
            int r4 = r4 + r2
            int r2 = r4 % 128
            f2639q = r2
            int r4 = r4 % 2
        L_0x00e2:
            com.cardinalcommerce.a.setCompoundDrawableTintMode r2 = r7.f2647h
            int r2 = r2.cca_continue
            org.json.JSONObject r3 = r7.f2641b
            java.lang.String r4 = "A031"
            r3.put(r4, r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r2 < r3) goto L_0x00f5
            r2 = 1
            goto L_0x00f6
        L_0x00f5:
            r2 = 0
        L_0x00f6:
            if (r2 == r1) goto L_0x0184
            int r2 = f2638p
            r3 = 27
            r4 = r2 | 27
            int r4 = r4 << r1
            r5 = r2 & -28
            int r2 = ~r2
            r2 = r2 & r3
            r2 = r2 | r5
            int r4 = r4 - r2
            int r2 = r4 % 128
            f2639q = r2
            int r4 = r4 % 2
            r2 = 32
            r3 = 32
        L_0x010f:
            r4 = 38
            if (r3 > r4) goto L_0x0115
            r4 = 1
            goto L_0x0116
        L_0x0115:
            r4 = 0
        L_0x0116:
            if (r4 == r1) goto L_0x011a
            goto L_0x01e3
        L_0x011a:
            int r4 = f2638p
            r5 = r4 ^ 3
            r4 = r4 & 3
            int r4 = r4 << r1
            int r5 = r5 + r4
            int r4 = r5 % 128
            f2639q = r4
            int r5 = r5 % 2
            r4 = 37
            if (r3 == r4) goto L_0x012f
            r4 = 11
            goto L_0x0131
        L_0x012f:
            r4 = 32
        L_0x0131:
            if (r4 == r2) goto L_0x016c
            int r4 = f2639q
            r5 = r4 & 118(0x76, float:1.65E-43)
            r4 = r4 | 118(0x76, float:1.65E-43)
            int r5 = r5 + r4
            r4 = r5 ^ -1
            r5 = r5 & -1
            int r5 = r5 << r1
            int r4 = r4 + r5
            int r5 = r4 % 128
            f2638p = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x014a
            r4 = 1
            goto L_0x014b
        L_0x014a:
            r4 = 0
        L_0x014b:
            java.lang.String r5 = "A00"
            if (r4 == r1) goto L_0x015b
            java.lang.String r4 = java.lang.String.valueOf(r3)
            java.lang.String r4 = r5.concat(r4)
            r7.m1939a((java.lang.String) r4)
            goto L_0x016c
        L_0x015b:
            java.lang.String r4 = java.lang.String.valueOf(r3)
            java.lang.String r4 = r5.concat(r4)
            r7.m1939a((java.lang.String) r4)
            r4 = 77
            int r4 = r4 / r0
            goto L_0x016c
        L_0x016a:
            r0 = move-exception
            throw r0
        L_0x016c:
            r4 = r3 & 1
            r3 = r3 ^ 1
            r3 = r3 | r4
            int r3 = ~r3
            int r4 = r4 - r3
            int r3 = r4 + -1
            int r4 = f2639q
            r5 = r4 | 33
            int r5 = r5 << r1
            r4 = r4 ^ 33
            int r5 = r5 - r4
            int r4 = r5 % 128
            f2638p = r4
            int r5 = r5 % 2
            goto L_0x010f
        L_0x0184:
            int r2 = f2638p
            r3 = r2 & 69
            r2 = r2 ^ 69
            r2 = r2 | r3
            int r2 = -r2
            int r2 = -r2
            r4 = r3 & r2
            r2 = r2 | r3
            int r4 = r4 + r2
            int r2 = r4 % 128
            f2639q = r2
            int r4 = r4 % 2
            com.cardinalcommerce.a.setCompoundDrawableTintMode r2 = r7.f2647h
            boolean r2 = r2.Cardinal
            org.json.JSONObject r3 = r7.f2641b
            java.lang.String r4 = "A032"
            r3.put(r4, r2)
            com.cardinalcommerce.a.setCompoundDrawableTintMode r2 = r7.f2647h
            boolean r2 = r2.values
            org.json.JSONObject r3 = r7.f2641b
            java.lang.String r4 = "A033"
            r3.put(r4, r2)
            com.cardinalcommerce.a.setCompoundDrawableTintMode r2 = r7.f2647h
            boolean r2 = r2.CardinalError
            org.json.JSONObject r3 = r7.f2641b
            java.lang.String r4 = "A034"
            r3.put(r4, r2)
            com.cardinalcommerce.a.setCompoundDrawableTintMode r2 = r7.f2647h
            boolean r2 = r2.cleanup
            org.json.JSONObject r3 = r7.f2641b
            java.lang.String r4 = "A035"
            r3.put(r4, r2)
            com.cardinalcommerce.a.setCompoundDrawableTintMode r2 = r7.f2647h
            boolean r2 = r2.getSDKVersion
            org.json.JSONObject r3 = r7.f2641b
            java.lang.String r4 = "A036"
            r3.put(r4, r2)
            com.cardinalcommerce.a.setCompoundDrawableTintMode r2 = r7.f2647h
            boolean r2 = r2.getWarnings
            org.json.JSONObject r3 = r7.f2641b
            java.lang.String r4 = "A038"
            r3.put(r4, r2)
            int r2 = f2638p
            int r2 = r2 + 39
            int r3 = r2 % 128
            f2639q = r3
            int r2 = r2 % 2
        L_0x01e3:
            com.cardinalcommerce.a.setCompoundDrawableTintMode r2 = r7.f2647h
            boolean r2 = r2.CardinalEnvironment
            org.json.JSONObject r3 = r7.f2641b
            java.lang.String r4 = "A037"
            r3.put(r4, r2)
            int r2 = f2639q
            r3 = 61
            r4 = r2 ^ 61
            r5 = r2 & 61
            r4 = r4 | r5
            int r4 = r4 << r1
            r5 = r2 & -62
            int r2 = ~r2
            r2 = r2 & r3
            r2 = r2 | r5
            int r2 = -r2
            int r2 = ~r2
            int r4 = r4 - r2
            int r4 = r4 - r1
            int r1 = r4 % 128
            f2638p = r1
            int r4 = r4 % 2
            r1 = 29
            if (r4 == 0) goto L_0x020e
            r2 = 29
            goto L_0x0210
        L_0x020e:
            r2 = 25
        L_0x0210:
            if (r2 == r1) goto L_0x0213
            return
        L_0x0213:
            r1 = 81
            int r1 = r1 / r0
            return
        L_0x0217:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2029s.m1942c():void");
    }

    /* renamed from: a */
    private void m1939a(String str) {
        int i = f2639q;
        int i2 = i | 119;
        int i3 = (i2 << 1) - ((~(i & 119)) & i2);
        f2638p = i3 % 128;
        char c = i3 % 2 != 0 ? 'M' : 21;
        Object[] objArr = null;
        if (c != 'M') {
            try {
                this.f2642c.putOpt(str, "RE02");
            } catch (JSONException e) {
                setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2653n;
                StringBuilder sb = new StringBuilder("JSON Exception \n");
                sb.append(e.getLocalizedMessage());
                setprogressbackgroundtintmode.init(new setImageMatrix(11305, sb.toString()));
                return;
            }
        } else {
            this.f2642c.putOpt(str, "RE02");
            super.hashCode();
        }
        int i4 = f2639q;
        int i5 = ((i4 | 78) << 1) - (i4 ^ 78);
        int i6 = (i5 & -1) + (i5 | -1);
        f2638p = i6 % 128;
        if ((i6 % 2 != 0 ? '`' : 31) == '`') {
            int length = objArr.length;
        }
    }

    /* renamed from: b */
    private void m1941b(String str) {
        int i = (((f2638p + 47) - 1) + 0) - 1;
        f2639q = i % 128;
        int i2 = i % 2;
        try {
            this.f2642c.putOpt(str, "RE03");
            int i3 = f2639q;
            int i4 = ((i3 | 123) << 1) - (((~i3) & 123) | (i3 & -124));
            f2638p = i4 % 128;
            int i5 = i4 % 2;
        } catch (JSONException e) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2653n;
            StringBuilder sb = new StringBuilder("JSON Exception \n");
            sb.append(e.getLocalizedMessage());
            setprogressbackgroundtintmode.init(new setImageMatrix(11305, sb.toString()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if ((r0 == null) != true) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        if ((r0 != null ? 'G' : '$') != 'G') goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        r6.f2641b.put("A040", r0);
        r0 = (f2638p + 52) - 1;
        f2639q = r0 % 128;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1940b() throws org.json.JSONException {
        /*
            r6 = this;
            int r0 = f2639q
            int r0 = r0 + 26
            r1 = 1
            int r0 = r0 - r1
            int r2 = r0 % 128
            f2638p = r2
            int r0 = r0 % 2
            r2 = 48
            if (r0 == 0) goto L_0x0013
            r0 = 21
            goto L_0x0015
        L_0x0013:
            r0 = 48
        L_0x0015:
            r3 = 0
            java.lang.String r4 = "A040"
            java.lang.String r5 = "A039"
            if (r0 == r2) goto L_0x002f
            r6.m1939a((java.lang.String) r5)
            com.cardinalcommerce.a.setCompoundDrawablesRelative r0 = r6.f2651l
            java.util.List<char[]> r0 = r0.Cardinal
            r2 = 0
            int r2 = r2.length     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0029
            r2 = 0
            goto L_0x002a
        L_0x0029:
            r2 = 1
        L_0x002a:
            if (r2 == r1) goto L_0x0041
            goto L_0x004f
        L_0x002d:
            r0 = move-exception
            throw r0
        L_0x002f:
            r6.m1939a((java.lang.String) r5)
            com.cardinalcommerce.a.setCompoundDrawablesRelative r0 = r6.f2651l
            java.util.List<char[]> r0 = r0.Cardinal
            r2 = 71
            if (r0 == 0) goto L_0x003d
            r5 = 71
            goto L_0x003f
        L_0x003d:
            r5 = 36
        L_0x003f:
            if (r5 == r2) goto L_0x004f
        L_0x0041:
            r6.m1939a((java.lang.String) r4)
            int r0 = f2639q
            int r0 = r0 + 67
            int r2 = r0 % 128
            f2638p = r2
        L_0x004c:
            int r0 = r0 % 2
            goto L_0x005e
        L_0x004f:
            org.json.JSONObject r2 = r6.f2641b
            r2.put(r4, r0)
            int r0 = f2638p
            int r0 = r0 + 52
            int r0 = r0 - r1
            int r2 = r0 % 128
            f2639q = r2
            goto L_0x004c
        L_0x005e:
            com.cardinalcommerce.a.setCompoundDrawablesRelative r0 = r6.f2651l
            boolean r0 = r0.getInstance
            org.json.JSONObject r2 = r6.f2641b
            java.lang.String r4 = "A041"
            r2.put(r4, r0)
            int r0 = f2639q
            int r0 = r0 + 71
            int r0 = r0 - r1
            r1 = r0 & -1
            r0 = r0 | -1
            int r1 = r1 + r0
            int r0 = r1 % 128
            f2638p = r0
            int r1 = r1 % 2
            r0 = 41
            if (r1 == 0) goto L_0x0080
            r1 = 22
            goto L_0x0082
        L_0x0080:
            r1 = 41
        L_0x0082:
            if (r1 == r0) goto L_0x008a
            r0 = 84
            int r0 = r0 / r3
            return
        L_0x0088:
            r0 = move-exception
            throw r0
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2029s.m1940b():void");
    }

    /* renamed from: a */
    private static JSONArray m1937a(setProgressDrawable setprogressdrawable) {
        setTextCursorDrawable settextcursordrawable = setprogressdrawable.cleanup;
        try {
            if (!(!new Throwable().getStackTrace()[1].getClassName().equals(CardinalThreeDS2ServiceImpl.class.getCanonicalName()))) {
                int i = f2639q;
                int i2 = ((i | 19) << 1) - (i ^ 19);
                f2638p = i2 % 128;
                int i3 = i2 % 2;
                settextcursordrawable.init = false;
                int i4 = f2638p;
                int i5 = i4 & 97;
                int i6 = -(-((i4 ^ 97) | i5));
                int i7 = ((i5 | i6) << 1) - (i6 ^ i5);
                f2639q = i7 % 128;
                int i8 = i7 % 2;
            } else {
                settextcursordrawable.init = true;
                int i9 = f2639q;
                int i10 = i9 & 111;
                int i11 = i10 + ((i9 ^ 111) | i10);
                f2638p = i11 % 128;
                int i12 = i11 % 2;
            }
            JSONArray jSONArray = settextcursordrawable.Cardinal;
            int i13 = f2638p;
            int i14 = (i13 ^ 43) + ((i13 & 43) << 1);
            f2639q = i14 % 128;
            int i15 = i14 % 2;
            return jSONArray;
        } catch (Exception unused) {
            return settextcursordrawable.Cardinal;
        }
    }
}
