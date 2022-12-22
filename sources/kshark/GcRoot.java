package kshark;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0010\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0010\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&¨\u0006'"}, mo175978d2 = {"Lkshark/GcRoot;", "", "()V", "id", "", "getId", "()J", "Debugger", "Finalizing", "InternedString", "JavaFrame", "JniGlobal", "JniLocal", "JniMonitor", "MonitorUsed", "NativeStack", "ReferenceCleanup", "StickyClass", "ThreadBlock", "ThreadObject", "Unknown", "Unreachable", "VmInternal", "Lkshark/GcRoot$Unknown;", "Lkshark/GcRoot$JniGlobal;", "Lkshark/GcRoot$JniLocal;", "Lkshark/GcRoot$JavaFrame;", "Lkshark/GcRoot$NativeStack;", "Lkshark/GcRoot$StickyClass;", "Lkshark/GcRoot$ThreadBlock;", "Lkshark/GcRoot$MonitorUsed;", "Lkshark/GcRoot$ThreadObject;", "Lkshark/GcRoot$ReferenceCleanup;", "Lkshark/GcRoot$VmInternal;", "Lkshark/GcRoot$JniMonitor;", "Lkshark/GcRoot$InternedString;", "Lkshark/GcRoot$Finalizing;", "Lkshark/GcRoot$Debugger;", "Lkshark/GcRoot$Unreachable;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: GcRoot.kt */
public abstract class GcRoot {
    public abstract long getId();

    private GcRoot() {
    }

    public /* synthetic */ GcRoot(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/GcRoot$Unknown;", "Lkshark/GcRoot;", "id", "", "(J)V", "getId", "()J", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class Unknown extends GcRoot {

        /* renamed from: id */
        private final long f4531id;

        public Unknown(long j) {
            super((DefaultConstructorMarker) null);
            this.f4531id = j;
        }

        public long getId() {
            return this.f4531id;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, mo175978d2 = {"Lkshark/GcRoot$JniGlobal;", "Lkshark/GcRoot;", "id", "", "jniGlobalRefId", "(JJ)V", "getId", "()J", "getJniGlobalRefId", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class JniGlobal extends GcRoot {

        /* renamed from: id */
        private final long f4522id;
        private final long jniGlobalRefId;

        public long getId() {
            return this.f4522id;
        }

        public final long getJniGlobalRefId() {
            return this.jniGlobalRefId;
        }

        public JniGlobal(long j, long j2) {
            super((DefaultConstructorMarker) null);
            this.f4522id = j;
            this.jniGlobalRefId = j2;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, mo175978d2 = {"Lkshark/GcRoot$JniLocal;", "Lkshark/GcRoot;", "id", "", "threadSerialNumber", "", "frameNumber", "(JII)V", "getFrameNumber", "()I", "getId", "()J", "getThreadSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class JniLocal extends GcRoot {
        private final int frameNumber;

        /* renamed from: id */
        private final long f4523id;
        private final int threadSerialNumber;

        public long getId() {
            return this.f4523id;
        }

        public final int getThreadSerialNumber() {
            return this.threadSerialNumber;
        }

        public final int getFrameNumber() {
            return this.frameNumber;
        }

        public JniLocal(long j, int i, int i2) {
            super((DefaultConstructorMarker) null);
            this.f4523id = j;
            this.threadSerialNumber = i;
            this.frameNumber = i2;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, mo175978d2 = {"Lkshark/GcRoot$JavaFrame;", "Lkshark/GcRoot;", "id", "", "threadSerialNumber", "", "frameNumber", "(JII)V", "getFrameNumber", "()I", "getId", "()J", "getThreadSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class JavaFrame extends GcRoot {
        private final int frameNumber;

        /* renamed from: id */
        private final long f4521id;
        private final int threadSerialNumber;

        public long getId() {
            return this.f4521id;
        }

        public final int getThreadSerialNumber() {
            return this.threadSerialNumber;
        }

        public final int getFrameNumber() {
            return this.frameNumber;
        }

        public JavaFrame(long j, int i, int i2) {
            super((DefaultConstructorMarker) null);
            this.f4521id = j;
            this.threadSerialNumber = i;
            this.frameNumber = i2;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lkshark/GcRoot$NativeStack;", "Lkshark/GcRoot;", "id", "", "threadSerialNumber", "", "(JI)V", "getId", "()J", "getThreadSerialNumber", "()I", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class NativeStack extends GcRoot {

        /* renamed from: id */
        private final long f4526id;
        private final int threadSerialNumber;

        public long getId() {
            return this.f4526id;
        }

        public final int getThreadSerialNumber() {
            return this.threadSerialNumber;
        }

        public NativeStack(long j, int i) {
            super((DefaultConstructorMarker) null);
            this.f4526id = j;
            this.threadSerialNumber = i;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/GcRoot$StickyClass;", "Lkshark/GcRoot;", "id", "", "(J)V", "getId", "()J", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class StickyClass extends GcRoot {

        /* renamed from: id */
        private final long f4528id;

        public StickyClass(long j) {
            super((DefaultConstructorMarker) null);
            this.f4528id = j;
        }

        public long getId() {
            return this.f4528id;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lkshark/GcRoot$ThreadBlock;", "Lkshark/GcRoot;", "id", "", "threadSerialNumber", "", "(JI)V", "getId", "()J", "getThreadSerialNumber", "()I", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class ThreadBlock extends GcRoot {

        /* renamed from: id */
        private final long f4529id;
        private final int threadSerialNumber;

        public long getId() {
            return this.f4529id;
        }

        public final int getThreadSerialNumber() {
            return this.threadSerialNumber;
        }

        public ThreadBlock(long j, int i) {
            super((DefaultConstructorMarker) null);
            this.f4529id = j;
            this.threadSerialNumber = i;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/GcRoot$MonitorUsed;", "Lkshark/GcRoot;", "id", "", "(J)V", "getId", "()J", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class MonitorUsed extends GcRoot {

        /* renamed from: id */
        private final long f4525id;

        public MonitorUsed(long j) {
            super((DefaultConstructorMarker) null);
            this.f4525id = j;
        }

        public long getId() {
            return this.f4525id;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, mo175978d2 = {"Lkshark/GcRoot$ThreadObject;", "Lkshark/GcRoot;", "id", "", "threadSerialNumber", "", "stackTraceSerialNumber", "(JII)V", "getId", "()J", "getStackTraceSerialNumber", "()I", "getThreadSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class ThreadObject extends GcRoot {

        /* renamed from: id */
        private final long f4530id;
        private final int stackTraceSerialNumber;
        private final int threadSerialNumber;

        public long getId() {
            return this.f4530id;
        }

        public final int getThreadSerialNumber() {
            return this.threadSerialNumber;
        }

        public final int getStackTraceSerialNumber() {
            return this.stackTraceSerialNumber;
        }

        public ThreadObject(long j, int i, int i2) {
            super((DefaultConstructorMarker) null);
            this.f4530id = j;
            this.threadSerialNumber = i;
            this.stackTraceSerialNumber = i2;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/GcRoot$ReferenceCleanup;", "Lkshark/GcRoot;", "id", "", "(J)V", "getId", "()J", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class ReferenceCleanup extends GcRoot {

        /* renamed from: id */
        private final long f4527id;

        public ReferenceCleanup(long j) {
            super((DefaultConstructorMarker) null);
            this.f4527id = j;
        }

        public long getId() {
            return this.f4527id;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/GcRoot$VmInternal;", "Lkshark/GcRoot;", "id", "", "(J)V", "getId", "()J", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class VmInternal extends GcRoot {

        /* renamed from: id */
        private final long f4533id;

        public VmInternal(long j) {
            super((DefaultConstructorMarker) null);
            this.f4533id = j;
        }

        public long getId() {
            return this.f4533id;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, mo175978d2 = {"Lkshark/GcRoot$JniMonitor;", "Lkshark/GcRoot;", "id", "", "stackTraceSerialNumber", "", "stackDepth", "(JII)V", "getId", "()J", "getStackDepth", "()I", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class JniMonitor extends GcRoot {

        /* renamed from: id */
        private final long f4524id;
        private final int stackDepth;
        private final int stackTraceSerialNumber;

        public long getId() {
            return this.f4524id;
        }

        public final int getStackTraceSerialNumber() {
            return this.stackTraceSerialNumber;
        }

        public final int getStackDepth() {
            return this.stackDepth;
        }

        public JniMonitor(long j, int i, int i2) {
            super((DefaultConstructorMarker) null);
            this.f4524id = j;
            this.stackTraceSerialNumber = i;
            this.stackDepth = i2;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/GcRoot$InternedString;", "Lkshark/GcRoot;", "id", "", "(J)V", "getId", "()J", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class InternedString extends GcRoot {

        /* renamed from: id */
        private final long f4520id;

        public InternedString(long j) {
            super((DefaultConstructorMarker) null);
            this.f4520id = j;
        }

        public long getId() {
            return this.f4520id;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/GcRoot$Finalizing;", "Lkshark/GcRoot;", "id", "", "(J)V", "getId", "()J", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class Finalizing extends GcRoot {

        /* renamed from: id */
        private final long f4519id;

        public Finalizing(long j) {
            super((DefaultConstructorMarker) null);
            this.f4519id = j;
        }

        public long getId() {
            return this.f4519id;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/GcRoot$Debugger;", "Lkshark/GcRoot;", "id", "", "(J)V", "getId", "()J", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class Debugger extends GcRoot {

        /* renamed from: id */
        private final long f4518id;

        public Debugger(long j) {
            super((DefaultConstructorMarker) null);
            this.f4518id = j;
        }

        public long getId() {
            return this.f4518id;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/GcRoot$Unreachable;", "Lkshark/GcRoot;", "id", "", "(J)V", "getId", "()J", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: GcRoot.kt */
    public static final class Unreachable extends GcRoot {

        /* renamed from: id */
        private final long f4532id;

        public Unreachable(long j) {
            super((DefaultConstructorMarker) null);
            this.f4532id = j;
        }

        public long getId() {
            return this.f4532id;
        }
    }
}
