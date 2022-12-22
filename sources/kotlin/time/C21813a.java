package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0007J\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, mo175978d2 = {"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "mark", "adjustment", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdjustment-UwyO8pc", "()J", "J", "getMark", "()Lkotlin/time/TimeMark;", "elapsedNow", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.time.a */
/* compiled from: TimeSource.kt */
final class C21813a extends TimeMark {

    /* renamed from: a */
    private final TimeMark f61293a;

    /* renamed from: b */
    private final long f61294b;

    private C21813a(TimeMark timeMark, long j) {
        this.f61293a = timeMark;
        this.f61294b = j;
    }

    public /* synthetic */ C21813a(TimeMark timeMark, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeMark, j);
    }

    /* renamed from: a */
    public final TimeMark mo180484a() {
        return this.f61293a;
    }

    /* renamed from: b */
    public final long mo180485b() {
        return this.f61294b;
    }

    /* renamed from: elapsedNow-UwyO8pc  reason: not valid java name */
    public long m48234elapsedNowUwyO8pc() {
        return Duration.m48178minusLRDsOJo(this.f61293a.m48227elapsedNowUwyO8pc(), this.f61294b);
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public TimeMark m48235plusLRDsOJo(long j) {
        return new C21813a(this.f61293a, Duration.m48179plusLRDsOJo(this.f61294b, j));
    }
}
