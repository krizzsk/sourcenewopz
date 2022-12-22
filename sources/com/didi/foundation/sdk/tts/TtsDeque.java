package com.didi.foundation.sdk.tts;

import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TtsDeque {

    /* renamed from: a */
    private Logger f21379a = LogService.getLogger(TtsDeque.class.getSimpleName());

    /* renamed from: b */
    private Lock f21380b;

    /* renamed from: c */
    private final Condition f21381c;

    /* renamed from: d */
    private LinkedBlockingDeque<PlayData> f21382d;

    /* renamed from: e */
    private LinkedBlockingDeque<PlayData> f21383e;

    /* renamed from: f */
    private LinkedBlockingDeque<PlayData> f21384f;

    public TtsDeque() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f21380b = reentrantLock;
        this.f21381c = reentrantLock.newCondition();
        this.f21382d = new LinkedBlockingDeque<>();
        this.f21383e = new LinkedBlockingDeque<>();
        this.f21384f = new LinkedBlockingDeque<>();
    }

    public void add(PlayData playData) {
        this.f21380b.lock();
        try {
            int i = C84061.$SwitchMap$com$didi$foundation$sdk$tts$PlayData$TtsPriority[playData.f21373a.ordinal()];
            if (i == 1) {
                this.f21382d.add(playData);
                Logger logger = this.f21379a;
                logger.debug("TTS queue add high: " + playData.getTts(), new Object[0]);
            } else if (i == 2) {
                this.f21383e.add(playData);
                Logger logger2 = this.f21379a;
                logger2.debug("TTS queue add  middle: " + playData.getTts(), new Object[0]);
            } else if (i == 3) {
                this.f21384f.add(playData);
                Logger logger3 = this.f21379a;
                logger3.debug("TTS queue add  normal: " + playData.getTts(), new Object[0]);
            }
            this.f21381c.signal();
        } finally {
            this.f21380b.unlock();
        }
    }

    /* renamed from: com.didi.foundation.sdk.tts.TtsDeque$1 */
    static /* synthetic */ class C84061 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$foundation$sdk$tts$PlayData$TtsPriority;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.foundation.sdk.tts.PlayData$TtsPriority[] r0 = com.didi.foundation.sdk.tts.PlayData.TtsPriority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$foundation$sdk$tts$PlayData$TtsPriority = r0
                com.didi.foundation.sdk.tts.PlayData$TtsPriority r1 = com.didi.foundation.sdk.tts.PlayData.TtsPriority.HIGH_PRIORITY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$foundation$sdk$tts$PlayData$TtsPriority     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.foundation.sdk.tts.PlayData$TtsPriority r1 = com.didi.foundation.sdk.tts.PlayData.TtsPriority.MIDDLE_PRIORITY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$foundation$sdk$tts$PlayData$TtsPriority     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.foundation.sdk.tts.PlayData$TtsPriority r1 = com.didi.foundation.sdk.tts.PlayData.TtsPriority.NORMAL_PRIORITY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.foundation.sdk.tts.TtsDeque.C84061.<clinit>():void");
        }
    }

    public PlayData get() throws InterruptedException {
        this.f21380b.lock();
        while (true) {
            try {
                PlayData tts = getTts();
                if (tts == null) {
                    this.f21379a.debug("TTS queue no data to play ", new Object[0]);
                    this.f21381c.await();
                } else {
                    Logger logger = this.f21379a;
                    logger.debug("TTS queue  will play is" + tts.getTts() + " rawId " + tts.getRawId(), new Object[0]);
                    return tts;
                }
            } finally {
                this.f21380b.unlock();
            }
        }
    }

    public PlayData getTts() {
        PlayData poll = this.f21382d.poll();
        if (poll == null) {
            poll = this.f21383e.poll();
        }
        if (poll == null) {
            poll = this.f21384f.poll();
        }
        Logger logger = this.f21379a;
        logger.debug("TTS queue get data is " + poll, new Object[0]);
        return poll;
    }

    public void clear() {
        this.f21382d.clear();
        this.f21383e.clear();
        this.f21384f.clear();
    }
}
