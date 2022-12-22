package kshark;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kshark.HprofRecord;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, mo175978d2 = {"kshark/OnHprofRecordListener$Companion$invoke$1", "Lkshark/OnHprofRecordListener;", "onHprofRecord", "", "position", "", "record", "Lkshark/HprofRecord;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: OnHprofRecordListener.kt */
public final class HprofPrimitiveArrayStripper$$special$$inlined$invoke$1 implements OnHprofRecordListener {
    final /* synthetic */ HprofWriter $writer$inlined;

    public HprofPrimitiveArrayStripper$$special$$inlined$invoke$1(HprofWriter hprofWriter) {
        this.$writer$inlined = hprofWriter;
    }

    public void onHprofRecord(long j, HprofRecord hprofRecord) {
        Intrinsics.checkParameterIsNotNull(hprofRecord, SDKConsts.TAG_KEY_RECORD);
        if (!(hprofRecord instanceof HprofRecord.HeapDumpEndRecord)) {
            HprofWriter hprofWriter = this.$writer$inlined;
            if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump booleanArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) hprofRecord;
                hprofRecord = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump(booleanArrayDump.getId(), booleanArrayDump.getStackTraceSerialNumber(), new boolean[booleanArrayDump.getArray().length]);
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump charArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) hprofRecord;
                long id = charArrayDump.getId();
                int stackTraceSerialNumber = charArrayDump.getStackTraceSerialNumber();
                int length = charArrayDump.getArray().length;
                char[] cArr = new char[length];
                for (int i = 0; i < length; i++) {
                    cArr[i] = '?';
                }
                hprofRecord = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump(id, stackTraceSerialNumber, cArr);
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump floatArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) hprofRecord;
                hprofRecord = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump(floatArrayDump.getId(), floatArrayDump.getStackTraceSerialNumber(), new float[floatArrayDump.getArray().length]);
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump doubleArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) hprofRecord;
                hprofRecord = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump(doubleArrayDump.getId(), doubleArrayDump.getStackTraceSerialNumber(), new double[doubleArrayDump.getArray().length]);
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump byteArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) hprofRecord;
                hprofRecord = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump(byteArrayDump.getId(), byteArrayDump.getStackTraceSerialNumber(), new byte[byteArrayDump.getArray().length]);
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump shortArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) hprofRecord;
                hprofRecord = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump(shortArrayDump.getId(), shortArrayDump.getStackTraceSerialNumber(), new short[shortArrayDump.getArray().length]);
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump intArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) hprofRecord;
                hprofRecord = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump(intArrayDump.getId(), intArrayDump.getStackTraceSerialNumber(), new int[intArrayDump.getArray().length]);
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump longArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) hprofRecord;
                hprofRecord = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump(longArrayDump.getId(), longArrayDump.getStackTraceSerialNumber(), new long[longArrayDump.getArray().length]);
            }
            hprofWriter.write(hprofRecord);
        }
    }
}
