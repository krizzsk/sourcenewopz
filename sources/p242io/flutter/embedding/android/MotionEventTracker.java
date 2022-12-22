package p242io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: io.flutter.embedding.android.MotionEventTracker */
public final class MotionEventTracker {

    /* renamed from: c */
    private static MotionEventTracker f57551c;

    /* renamed from: a */
    private final LongSparseArray<MotionEvent> f57552a = new LongSparseArray<>();

    /* renamed from: b */
    private final PriorityQueue<Long> f57553b = new PriorityQueue<>();

    /* renamed from: io.flutter.embedding.android.MotionEventTracker$MotionEventId */
    public static class MotionEventId {
        private static final AtomicLong ID_COUNTER = new AtomicLong(0);
        /* access modifiers changed from: private */

        /* renamed from: id */
        public final long f57554id;

        private MotionEventId(long j) {
            this.f57554id = j;
        }

        public static MotionEventId from(long j) {
            return new MotionEventId(j);
        }

        public static MotionEventId createUnique() {
            return from(ID_COUNTER.incrementAndGet());
        }

        public long getId() {
            return this.f57554id;
        }
    }

    public static MotionEventTracker getInstance() {
        if (f57551c == null) {
            f57551c = new MotionEventTracker();
        }
        return f57551c;
    }

    private MotionEventTracker() {
    }

    public MotionEventId track(MotionEvent motionEvent) {
        MotionEventId createUnique = MotionEventId.createUnique();
        this.f57552a.put(createUnique.f57554id, MotionEvent.obtain(motionEvent));
        this.f57553b.add(Long.valueOf(createUnique.f57554id));
        return createUnique;
    }

    public MotionEvent pop(MotionEventId motionEventId) {
        while (!this.f57553b.isEmpty() && this.f57553b.peek().longValue() < motionEventId.f57554id) {
            this.f57552a.remove(this.f57553b.poll().longValue());
        }
        if (!this.f57553b.isEmpty() && this.f57553b.peek().longValue() == motionEventId.f57554id) {
            this.f57553b.poll();
        }
        MotionEvent motionEvent = this.f57552a.get(motionEventId.f57554id);
        this.f57552a.remove(motionEventId.f57554id);
        return motionEvent;
    }
}
