package kshark;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.GraphRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, mo175978d2 = {"Lkshark/HprofRecord;", "", "()V", "HeapDumpEndRecord", "HeapDumpRecord", "LoadClassRecord", "StackFrameRecord", "StackTraceRecord", "StringRecord", "Lkshark/HprofRecord$StringRecord;", "Lkshark/HprofRecord$LoadClassRecord;", "Lkshark/HprofRecord$HeapDumpEndRecord;", "Lkshark/HprofRecord$StackFrameRecord;", "Lkshark/HprofRecord$StackTraceRecord;", "Lkshark/HprofRecord$HeapDumpRecord;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HprofRecord.kt */
public abstract class HprofRecord {
    private HprofRecord() {
    }

    public /* synthetic */ HprofRecord(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lkshark/HprofRecord$StringRecord;", "Lkshark/HprofRecord;", "id", "", "string", "", "(JLjava/lang/String;)V", "getId", "()J", "getString", "()Ljava/lang/String;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HprofRecord.kt */
    public static final class StringRecord extends HprofRecord {

        /* renamed from: id */
        private final long f4593id;
        private final String string;

        public final long getId() {
            return this.f4593id;
        }

        public final String getString() {
            return this.string;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StringRecord(long j, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(str, TypedValues.Custom.S_STRING);
            this.f4593id = j;
            this.string = str;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, mo175978d2 = {"Lkshark/HprofRecord$LoadClassRecord;", "Lkshark/HprofRecord;", "classSerialNumber", "", "id", "", "stackTraceSerialNumber", "classNameStringId", "(IJIJ)V", "getClassNameStringId", "()J", "getClassSerialNumber", "()I", "getId", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HprofRecord.kt */
    public static final class LoadClassRecord extends HprofRecord {
        private final long classNameStringId;
        private final int classSerialNumber;

        /* renamed from: id */
        private final long f4591id;
        private final int stackTraceSerialNumber;

        public final int getClassSerialNumber() {
            return this.classSerialNumber;
        }

        public final long getId() {
            return this.f4591id;
        }

        public final int getStackTraceSerialNumber() {
            return this.stackTraceSerialNumber;
        }

        public final long getClassNameStringId() {
            return this.classNameStringId;
        }

        public LoadClassRecord(int i, long j, int i2, long j2) {
            super((DefaultConstructorMarker) null);
            this.classSerialNumber = i;
            this.f4591id = j;
            this.stackTraceSerialNumber = i2;
            this.classNameStringId = j2;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpEndRecord;", "Lkshark/HprofRecord;", "()V", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HprofRecord.kt */
    public static final class HeapDumpEndRecord extends HprofRecord {
        public static final HeapDumpEndRecord INSTANCE = new HeapDumpEndRecord();

        private HeapDumpEndRecord() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, mo175978d2 = {"Lkshark/HprofRecord$StackFrameRecord;", "Lkshark/HprofRecord;", "id", "", "methodNameStringId", "methodSignatureStringId", "sourceFileNameStringId", "classSerialNumber", "", "lineNumber", "(JJJJII)V", "getClassSerialNumber", "()I", "getId", "()J", "getLineNumber", "getMethodNameStringId", "getMethodSignatureStringId", "getSourceFileNameStringId", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HprofRecord.kt */
    public static final class StackFrameRecord extends HprofRecord {
        private final int classSerialNumber;

        /* renamed from: id */
        private final long f4592id;
        private final int lineNumber;
        private final long methodNameStringId;
        private final long methodSignatureStringId;
        private final long sourceFileNameStringId;

        public final long getId() {
            return this.f4592id;
        }

        public final long getMethodNameStringId() {
            return this.methodNameStringId;
        }

        public final long getMethodSignatureStringId() {
            return this.methodSignatureStringId;
        }

        public final long getSourceFileNameStringId() {
            return this.sourceFileNameStringId;
        }

        public final int getClassSerialNumber() {
            return this.classSerialNumber;
        }

        public final int getLineNumber() {
            return this.lineNumber;
        }

        public StackFrameRecord(long j, long j2, long j3, long j4, int i, int i2) {
            super((DefaultConstructorMarker) null);
            this.f4592id = j;
            this.methodNameStringId = j2;
            this.methodSignatureStringId = j3;
            this.sourceFileNameStringId = j4;
            this.classSerialNumber = i;
            this.lineNumber = i2;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, mo175978d2 = {"Lkshark/HprofRecord$StackTraceRecord;", "Lkshark/HprofRecord;", "stackTraceSerialNumber", "", "threadSerialNumber", "stackFrameIds", "", "(II[J)V", "getStackFrameIds", "()[J", "getStackTraceSerialNumber", "()I", "getThreadSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HprofRecord.kt */
    public static final class StackTraceRecord extends HprofRecord {
        private final long[] stackFrameIds;
        private final int stackTraceSerialNumber;
        private final int threadSerialNumber;

        public final int getStackTraceSerialNumber() {
            return this.stackTraceSerialNumber;
        }

        public final int getThreadSerialNumber() {
            return this.threadSerialNumber;
        }

        public final long[] getStackFrameIds() {
            return this.stackFrameIds;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StackTraceRecord(int i, int i2, long[] jArr) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(jArr, "stackFrameIds");
            this.stackTraceSerialNumber = i;
            this.threadSerialNumber = i2;
            this.stackFrameIds = jArr;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord;", "Lkshark/HprofRecord;", "()V", "GcRootRecord", "HeapDumpInfoRecord", "ObjectRecord", "Lkshark/HprofRecord$HeapDumpRecord$GcRootRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Lkshark/HprofRecord$HeapDumpRecord$HeapDumpInfoRecord;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HprofRecord.kt */
    public static abstract class HeapDumpRecord extends HprofRecord {
        private HeapDumpRecord() {
            super((DefaultConstructorMarker) null);
        }

        public /* synthetic */ HeapDumpRecord(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$GcRootRecord;", "Lkshark/HprofRecord$HeapDumpRecord;", "gcRoot", "Lkshark/GcRoot;", "(Lkshark/GcRoot;)V", "getGcRoot", "()Lkshark/GcRoot;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
        /* compiled from: HprofRecord.kt */
        public static final class GcRootRecord extends HeapDumpRecord {
            private final GcRoot gcRoot;

            public final GcRoot getGcRoot() {
                return this.gcRoot;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GcRootRecord(GcRoot gcRoot2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkParameterIsNotNull(gcRoot2, "gcRoot");
                this.gcRoot = gcRoot2;
            }
        }

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Lkshark/HprofRecord$HeapDumpRecord;", "()V", "ClassDumpRecord", "ClassSkipContentRecord", "InstanceDumpRecord", "InstanceSkipContentRecord", "ObjectArrayDumpRecord", "ObjectArraySkipContentRecord", "PrimitiveArrayDumpRecord", "PrimitiveArraySkipContentRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassSkipContentRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceSkipContentRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArraySkipContentRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArraySkipContentRecord;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
        /* compiled from: HprofRecord.kt */
        public static abstract class ObjectRecord extends HeapDumpRecord {
            private ObjectRecord() {
                super((DefaultConstructorMarker) null);
            }

            public /* synthetic */ ObjectRecord(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0002\u001d\u001eBY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006\u001f"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "superclassId", "classLoaderId", "signersId", "protectionDomainId", "instanceSize", "staticFields", "", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "fields", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "(JIJJJJILjava/util/List;Ljava/util/List;)V", "getClassLoaderId", "()J", "getFields", "()Ljava/util/List;", "getId", "getInstanceSize", "()I", "getProtectionDomainId", "getSignersId", "getStackTraceSerialNumber", "getStaticFields", "getSuperclassId", "FieldRecord", "StaticFieldRecord", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
            /* compiled from: HprofRecord.kt */
            public static final class ClassDumpRecord extends ObjectRecord {
                private final long classLoaderId;
                private final List<FieldRecord> fields;

                /* renamed from: id */
                private final long f4576id;
                private final int instanceSize;
                private final long protectionDomainId;
                private final long signersId;
                private final int stackTraceSerialNumber;
                private final List<StaticFieldRecord> staticFields;
                private final long superclassId;

                public final long getId() {
                    return this.f4576id;
                }

                public final int getStackTraceSerialNumber() {
                    return this.stackTraceSerialNumber;
                }

                public final long getSuperclassId() {
                    return this.superclassId;
                }

                public final long getClassLoaderId() {
                    return this.classLoaderId;
                }

                public final long getSignersId() {
                    return this.signersId;
                }

                public final long getProtectionDomainId() {
                    return this.protectionDomainId;
                }

                public final int getInstanceSize() {
                    return this.instanceSize;
                }

                public final List<StaticFieldRecord> getStaticFields() {
                    return this.staticFields;
                }

                public final List<FieldRecord> getFields() {
                    return this.fields;
                }

                @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "", "nameStringId", "", "type", "", "value", "Lkshark/ValueHolder;", "(JILkshark/ValueHolder;)V", "getNameStringId", "()J", "getType", "()I", "getValue", "()Lkshark/ValueHolder;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
                /* compiled from: HprofRecord.kt */
                public static final class StaticFieldRecord {
                    private final long nameStringId;
                    private final int type;
                    private final ValueHolder value;

                    public static /* synthetic */ StaticFieldRecord copy$default(StaticFieldRecord staticFieldRecord, long j, int i, ValueHolder valueHolder, int i2, Object obj) {
                        if ((i2 & 1) != 0) {
                            j = staticFieldRecord.nameStringId;
                        }
                        if ((i2 & 2) != 0) {
                            i = staticFieldRecord.type;
                        }
                        if ((i2 & 4) != 0) {
                            valueHolder = staticFieldRecord.value;
                        }
                        return staticFieldRecord.copy(j, i, valueHolder);
                    }

                    public final long component1() {
                        return this.nameStringId;
                    }

                    public final int component2() {
                        return this.type;
                    }

                    public final ValueHolder component3() {
                        return this.value;
                    }

                    public final StaticFieldRecord copy(long j, int i, ValueHolder valueHolder) {
                        Intrinsics.checkParameterIsNotNull(valueHolder, "value");
                        return new StaticFieldRecord(j, i, valueHolder);
                    }

                    public boolean equals(Object obj) {
                        if (this != obj) {
                            if (obj instanceof StaticFieldRecord) {
                                StaticFieldRecord staticFieldRecord = (StaticFieldRecord) obj;
                                if (this.nameStringId == staticFieldRecord.nameStringId) {
                                    if (!(this.type == staticFieldRecord.type) || !Intrinsics.areEqual((Object) this.value, (Object) staticFieldRecord.value)) {
                                        return false;
                                    }
                                }
                            }
                            return false;
                        }
                        return true;
                    }

                    public int hashCode() {
                        long j = this.nameStringId;
                        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.type) * 31;
                        ValueHolder valueHolder = this.value;
                        return i + (valueHolder != null ? valueHolder.hashCode() : 0);
                    }

                    public String toString() {
                        return "StaticFieldRecord(nameStringId=" + this.nameStringId + ", type=" + this.type + ", value=" + this.value + ")";
                    }

                    public StaticFieldRecord(long j, int i, ValueHolder valueHolder) {
                        Intrinsics.checkParameterIsNotNull(valueHolder, "value");
                        this.nameStringId = j;
                        this.type = i;
                        this.value = valueHolder;
                    }

                    public final long getNameStringId() {
                        return this.nameStringId;
                    }

                    public final int getType() {
                        return this.type;
                    }

                    public final ValueHolder getValue() {
                        return this.value;
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public ClassDumpRecord(long j, int i, long j2, long j3, long j4, long j5, int i2, List<StaticFieldRecord> list, List<FieldRecord> list2) {
                    super((DefaultConstructorMarker) null);
                    Intrinsics.checkParameterIsNotNull(list, "staticFields");
                    Intrinsics.checkParameterIsNotNull(list2, GraphRequest.FIELDS_PARAM);
                    this.f4576id = j;
                    this.stackTraceSerialNumber = i;
                    this.superclassId = j2;
                    this.classLoaderId = j3;
                    this.signersId = j4;
                    this.protectionDomainId = j5;
                    this.instanceSize = i2;
                    this.staticFields = list;
                    this.fields = list2;
                }

                @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "", "nameStringId", "", "type", "", "(JI)V", "getNameStringId", "()J", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
                /* compiled from: HprofRecord.kt */
                public static final class FieldRecord {
                    private final long nameStringId;
                    private final int type;

                    public static /* synthetic */ FieldRecord copy$default(FieldRecord fieldRecord, long j, int i, int i2, Object obj) {
                        if ((i2 & 1) != 0) {
                            j = fieldRecord.nameStringId;
                        }
                        if ((i2 & 2) != 0) {
                            i = fieldRecord.type;
                        }
                        return fieldRecord.copy(j, i);
                    }

                    public final long component1() {
                        return this.nameStringId;
                    }

                    public final int component2() {
                        return this.type;
                    }

                    public final FieldRecord copy(long j, int i) {
                        return new FieldRecord(j, i);
                    }

                    public boolean equals(Object obj) {
                        if (this != obj) {
                            if (obj instanceof FieldRecord) {
                                FieldRecord fieldRecord = (FieldRecord) obj;
                                if (this.nameStringId == fieldRecord.nameStringId) {
                                    if (this.type == fieldRecord.type) {
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }
                        return true;
                    }

                    public int hashCode() {
                        long j = this.nameStringId;
                        return (((int) (j ^ (j >>> 32))) * 31) + this.type;
                    }

                    public String toString() {
                        return "FieldRecord(nameStringId=" + this.nameStringId + ", type=" + this.type + ")";
                    }

                    public FieldRecord(long j, int i) {
                        this.nameStringId = j;
                        this.type = i;
                    }

                    public final long getNameStringId() {
                        return this.nameStringId;
                    }

                    public final int getType() {
                        return this.type;
                    }
                }
            }

            @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassSkipContentRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "superclassId", "classLoaderId", "signersId", "protectionDomainId", "instanceSize", "staticFieldCount", "fieldCount", "(JIJJJJIII)V", "getClassLoaderId", "()J", "getFieldCount", "()I", "getId", "getInstanceSize", "getProtectionDomainId", "getSignersId", "getStackTraceSerialNumber", "getStaticFieldCount", "getSuperclassId", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
            /* compiled from: HprofRecord.kt */
            public static final class ClassSkipContentRecord extends ObjectRecord {
                private final long classLoaderId;
                private final int fieldCount;

                /* renamed from: id */
                private final long f4577id;
                private final int instanceSize;
                private final long protectionDomainId;
                private final long signersId;
                private final int stackTraceSerialNumber;
                private final int staticFieldCount;
                private final long superclassId;

                public final long getId() {
                    return this.f4577id;
                }

                public final int getStackTraceSerialNumber() {
                    return this.stackTraceSerialNumber;
                }

                public final long getSuperclassId() {
                    return this.superclassId;
                }

                public final long getClassLoaderId() {
                    return this.classLoaderId;
                }

                public final long getSignersId() {
                    return this.signersId;
                }

                public final long getProtectionDomainId() {
                    return this.protectionDomainId;
                }

                public final int getInstanceSize() {
                    return this.instanceSize;
                }

                public final int getStaticFieldCount() {
                    return this.staticFieldCount;
                }

                public final int getFieldCount() {
                    return this.fieldCount;
                }

                public ClassSkipContentRecord(long j, int i, long j2, long j3, long j4, long j5, int i2, int i3, int i4) {
                    super((DefaultConstructorMarker) null);
                    this.f4577id = j;
                    this.stackTraceSerialNumber = i;
                    this.superclassId = j2;
                    this.classLoaderId = j3;
                    this.signersId = j4;
                    this.protectionDomainId = j5;
                    this.instanceSize = i2;
                    this.staticFieldCount = i3;
                    this.fieldCount = i4;
                }
            }

            @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "classId", "fieldValues", "", "(JIJ[B)V", "getClassId", "()J", "getFieldValues", "()[B", "getId", "getStackTraceSerialNumber", "()I", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
            /* compiled from: HprofRecord.kt */
            public static final class InstanceDumpRecord extends ObjectRecord {
                private final long classId;
                private final byte[] fieldValues;

                /* renamed from: id */
                private final long f4578id;
                private final int stackTraceSerialNumber;

                public final long getId() {
                    return this.f4578id;
                }

                public final int getStackTraceSerialNumber() {
                    return this.stackTraceSerialNumber;
                }

                public final long getClassId() {
                    return this.classId;
                }

                public final byte[] getFieldValues() {
                    return this.fieldValues;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public InstanceDumpRecord(long j, int i, long j2, byte[] bArr) {
                    super((DefaultConstructorMarker) null);
                    Intrinsics.checkParameterIsNotNull(bArr, "fieldValues");
                    this.f4578id = j;
                    this.stackTraceSerialNumber = i;
                    this.classId = j2;
                    this.fieldValues = bArr;
                }
            }

            @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceSkipContentRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "classId", "(JIJ)V", "getClassId", "()J", "getId", "getStackTraceSerialNumber", "()I", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
            /* compiled from: HprofRecord.kt */
            public static final class InstanceSkipContentRecord extends ObjectRecord {
                private final long classId;

                /* renamed from: id */
                private final long f4579id;
                private final int stackTraceSerialNumber;

                public final long getId() {
                    return this.f4579id;
                }

                public final int getStackTraceSerialNumber() {
                    return this.stackTraceSerialNumber;
                }

                public final long getClassId() {
                    return this.classId;
                }

                public InstanceSkipContentRecord(long j, int i, long j2) {
                    super((DefaultConstructorMarker) null);
                    this.f4579id = j;
                    this.stackTraceSerialNumber = i;
                    this.classId = j2;
                }
            }

            @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u000b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "arrayClassId", "elementIds", "", "size", "(JIJ[JI)V", "getArrayClassId", "()J", "getElementIds", "()[J", "getId", "getSize", "()I", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
            /* compiled from: HprofRecord.kt */
            public static final class ObjectArrayDumpRecord extends ObjectRecord {
                private final long arrayClassId;
                private final long[] elementIds;

                /* renamed from: id */
                private final long f4580id;
                private final int size;
                private final int stackTraceSerialNumber;

                public final long getId() {
                    return this.f4580id;
                }

                public final int getStackTraceSerialNumber() {
                    return this.stackTraceSerialNumber;
                }

                public final long getArrayClassId() {
                    return this.arrayClassId;
                }

                public final long[] getElementIds() {
                    return this.elementIds;
                }

                public final int getSize() {
                    return this.size;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public ObjectArrayDumpRecord(long j, int i, long j2, long[] jArr, int i2) {
                    super((DefaultConstructorMarker) null);
                    Intrinsics.checkParameterIsNotNull(jArr, "elementIds");
                    this.f4580id = j;
                    this.stackTraceSerialNumber = i;
                    this.arrayClassId = j2;
                    this.elementIds = jArr;
                    this.size = i2;
                }
            }

            @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u000f"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArraySkipContentRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "arrayClassId", "size", "(JIJI)V", "getArrayClassId", "()J", "getId", "getSize", "()I", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
            /* compiled from: HprofRecord.kt */
            public static final class ObjectArraySkipContentRecord extends ObjectRecord {
                private final long arrayClassId;

                /* renamed from: id */
                private final long f4581id;
                private final int size;
                private final int stackTraceSerialNumber;

                public final long getId() {
                    return this.f4581id;
                }

                public final int getStackTraceSerialNumber() {
                    return this.stackTraceSerialNumber;
                }

                public final long getArrayClassId() {
                    return this.arrayClassId;
                }

                public final int getSize() {
                    return this.size;
                }

                public ObjectArraySkipContentRecord(long j, int i, long j2, int i2) {
                    super((DefaultConstructorMarker) null);
                    this.f4581id = j;
                    this.stackTraceSerialNumber = i;
                    this.arrayClassId = j2;
                    this.size = i2;
                }
            }

            @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n\u0001\b\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "()V", "id", "", "getId", "()J", "size", "", "getSize", "()I", "stackTraceSerialNumber", "getStackTraceSerialNumber", "BooleanArrayDump", "ByteArrayDump", "CharArrayDump", "DoubleArrayDump", "FloatArrayDump", "IntArrayDump", "LongArrayDump", "ShortArrayDump", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$BooleanArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$CharArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$FloatArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$DoubleArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ByteArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ShortArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$IntArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$LongArrayDump;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
            /* compiled from: HprofRecord.kt */
            public static abstract class PrimitiveArrayDumpRecord extends ObjectRecord {
                public abstract long getId();

                public abstract int getSize();

                public abstract int getStackTraceSerialNumber();

                private PrimitiveArrayDumpRecord() {
                    super((DefaultConstructorMarker) null);
                }

                public /* synthetic */ PrimitiveArrayDumpRecord(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$BooleanArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[Z)V", "getArray", "()[Z", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
                /* compiled from: HprofRecord.kt */
                public static final class BooleanArrayDump extends PrimitiveArrayDumpRecord {
                    private final boolean[] array;

                    /* renamed from: id */
                    private final long f4582id;
                    private final int stackTraceSerialNumber;

                    public long getId() {
                        return this.f4582id;
                    }

                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final boolean[] getArray() {
                        return this.array;
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public BooleanArrayDump(long j, int i, boolean[] zArr) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkParameterIsNotNull(zArr, "array");
                        this.f4582id = j;
                        this.stackTraceSerialNumber = i;
                        this.array = zArr;
                    }

                    public int getSize() {
                        return this.array.length;
                    }
                }

                @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$CharArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[C)V", "getArray", "()[C", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
                /* compiled from: HprofRecord.kt */
                public static final class CharArrayDump extends PrimitiveArrayDumpRecord {
                    private final char[] array;

                    /* renamed from: id */
                    private final long f4584id;
                    private final int stackTraceSerialNumber;

                    public long getId() {
                        return this.f4584id;
                    }

                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final char[] getArray() {
                        return this.array;
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public CharArrayDump(long j, int i, char[] cArr) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkParameterIsNotNull(cArr, "array");
                        this.f4584id = j;
                        this.stackTraceSerialNumber = i;
                        this.array = cArr;
                    }

                    public int getSize() {
                        return this.array.length;
                    }
                }

                @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$FloatArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[F)V", "getArray", "()[F", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
                /* compiled from: HprofRecord.kt */
                public static final class FloatArrayDump extends PrimitiveArrayDumpRecord {
                    private final float[] array;

                    /* renamed from: id */
                    private final long f4586id;
                    private final int stackTraceSerialNumber;

                    public long getId() {
                        return this.f4586id;
                    }

                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final float[] getArray() {
                        return this.array;
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public FloatArrayDump(long j, int i, float[] fArr) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkParameterIsNotNull(fArr, "array");
                        this.f4586id = j;
                        this.stackTraceSerialNumber = i;
                        this.array = fArr;
                    }

                    public int getSize() {
                        return this.array.length;
                    }
                }

                @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$DoubleArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[D)V", "getArray", "()[D", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
                /* compiled from: HprofRecord.kt */
                public static final class DoubleArrayDump extends PrimitiveArrayDumpRecord {
                    private final double[] array;

                    /* renamed from: id */
                    private final long f4585id;
                    private final int stackTraceSerialNumber;

                    public long getId() {
                        return this.f4585id;
                    }

                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final double[] getArray() {
                        return this.array;
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public DoubleArrayDump(long j, int i, double[] dArr) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkParameterIsNotNull(dArr, "array");
                        this.f4585id = j;
                        this.stackTraceSerialNumber = i;
                        this.array = dArr;
                    }

                    public int getSize() {
                        return this.array.length;
                    }
                }

                @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ByteArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[B)V", "getArray", "()[B", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
                /* compiled from: HprofRecord.kt */
                public static final class ByteArrayDump extends PrimitiveArrayDumpRecord {
                    private final byte[] array;

                    /* renamed from: id */
                    private final long f4583id;
                    private final int stackTraceSerialNumber;

                    public long getId() {
                        return this.f4583id;
                    }

                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final byte[] getArray() {
                        return this.array;
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public ByteArrayDump(long j, int i, byte[] bArr) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkParameterIsNotNull(bArr, "array");
                        this.f4583id = j;
                        this.stackTraceSerialNumber = i;
                        this.array = bArr;
                    }

                    public int getSize() {
                        return this.array.length;
                    }
                }

                @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0017\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ShortArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[S)V", "getArray", "()[S", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
                /* compiled from: HprofRecord.kt */
                public static final class ShortArrayDump extends PrimitiveArrayDumpRecord {
                    private final short[] array;

                    /* renamed from: id */
                    private final long f4589id;
                    private final int stackTraceSerialNumber;

                    public long getId() {
                        return this.f4589id;
                    }

                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final short[] getArray() {
                        return this.array;
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public ShortArrayDump(long j, int i, short[] sArr) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkParameterIsNotNull(sArr, "array");
                        this.f4589id = j;
                        this.stackTraceSerialNumber = i;
                        this.array = sArr;
                    }

                    public int getSize() {
                        return this.array.length;
                    }
                }

                @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$IntArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[I)V", "getArray", "()[I", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
                /* compiled from: HprofRecord.kt */
                public static final class IntArrayDump extends PrimitiveArrayDumpRecord {
                    private final int[] array;

                    /* renamed from: id */
                    private final long f4587id;
                    private final int stackTraceSerialNumber;

                    public long getId() {
                        return this.f4587id;
                    }

                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final int[] getArray() {
                        return this.array;
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public IntArrayDump(long j, int i, int[] iArr) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkParameterIsNotNull(iArr, "array");
                        this.f4587id = j;
                        this.stackTraceSerialNumber = i;
                        this.array = iArr;
                    }

                    public int getSize() {
                        return this.array.length;
                    }
                }

                @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$LongArrayDump;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[J)V", "getArray", "()[J", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
                /* compiled from: HprofRecord.kt */
                public static final class LongArrayDump extends PrimitiveArrayDumpRecord {
                    private final long[] array;

                    /* renamed from: id */
                    private final long f4588id;
                    private final int stackTraceSerialNumber;

                    public long getId() {
                        return this.f4588id;
                    }

                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final long[] getArray() {
                        return this.array;
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public LongArrayDump(long j, int i, long[] jArr) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkParameterIsNotNull(jArr, "array");
                        this.f4588id = j;
                        this.stackTraceSerialNumber = i;
                        this.array = jArr;
                    }

                    public int getSize() {
                        return this.array.length;
                    }
                }
            }

            @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArraySkipContentRecord;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "size", "type", "Lkshark/PrimitiveType;", "(JIILkshark/PrimitiveType;)V", "getId", "()J", "getSize", "()I", "getStackTraceSerialNumber", "getType", "()Lkshark/PrimitiveType;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
            /* compiled from: HprofRecord.kt */
            public static final class PrimitiveArraySkipContentRecord extends ObjectRecord {

                /* renamed from: id */
                private final long f4590id;
                private final int size;
                private final int stackTraceSerialNumber;
                private final PrimitiveType type;

                public final long getId() {
                    return this.f4590id;
                }

                public final int getStackTraceSerialNumber() {
                    return this.stackTraceSerialNumber;
                }

                public final int getSize() {
                    return this.size;
                }

                public final PrimitiveType getType() {
                    return this.type;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public PrimitiveArraySkipContentRecord(long j, int i, int i2, PrimitiveType primitiveType) {
                    super((DefaultConstructorMarker) null);
                    Intrinsics.checkParameterIsNotNull(primitiveType, "type");
                    this.f4590id = j;
                    this.stackTraceSerialNumber = i;
                    this.size = i2;
                    this.type = primitiveType;
                }
            }
        }

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lkshark/HprofRecord$HeapDumpRecord$HeapDumpInfoRecord;", "Lkshark/HprofRecord$HeapDumpRecord;", "heapId", "", "heapNameStringId", "", "(IJ)V", "getHeapId", "()I", "getHeapNameStringId", "()J", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
        /* compiled from: HprofRecord.kt */
        public static final class HeapDumpInfoRecord extends HeapDumpRecord {
            private final int heapId;
            private final long heapNameStringId;

            public final int getHeapId() {
                return this.heapId;
            }

            public final long getHeapNameStringId() {
                return this.heapNameStringId;
            }

            public HeapDumpInfoRecord(int i, long j) {
                super((DefaultConstructorMarker) null);
                this.heapId = i;
                this.heapNameStringId = j;
            }
        }
    }
}
