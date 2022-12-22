package com.squareup.haha.perflib;

import com.squareup.haha.perflib.p225io.HprofBuffer;
import com.squareup.haha.trove.TLongObjectHashMap;
import java.io.IOException;
import kotlin.UShort;
import net.lingala.zip4j.util.InternalZipConstants;

public class HprofParser {
    private static final int ALLOC_SITES = 6;
    private static final int CONTROL_SETTINGS = 14;
    private static final int CPU_SAMPLES = 13;
    private static final int END_THREAD = 11;
    private static final int HEAP_DUMP = 12;
    private static final int HEAP_DUMP_END = 44;
    private static final int HEAP_DUMP_SEGMENT = 28;
    private static final int HEAP_SUMMARY = 7;
    private static final int LOAD_CLASS = 2;
    private static final int ROOT_CLASS_DUMP = 32;
    private static final int ROOT_DEBUGGER = 139;
    private static final int ROOT_FINALIZING = 138;
    private static final int ROOT_HEAP_DUMP_INFO = 254;
    private static final int ROOT_INSTANCE_DUMP = 33;
    private static final int ROOT_INTERNED_STRING = 137;
    private static final int ROOT_JAVA_FRAME = 3;
    private static final int ROOT_JNI_GLOBAL = 1;
    private static final int ROOT_JNI_LOCAL = 2;
    private static final int ROOT_JNI_MONITOR = 142;
    private static final int ROOT_MONITOR_USED = 7;
    private static final int ROOT_NATIVE_STACK = 4;
    private static final int ROOT_OBJECT_ARRAY_DUMP = 34;
    private static final int ROOT_PRIMITIVE_ARRAY_DUMP = 35;
    private static final int ROOT_PRIMITIVE_ARRAY_NODATA = 195;
    private static final int ROOT_REFERENCE_CLEANUP = 140;
    private static final int ROOT_STICKY_CLASS = 5;
    private static final int ROOT_THREAD_BLOCK = 6;
    private static final int ROOT_THREAD_OBJECT = 8;
    private static final int ROOT_UNKNOWN = 255;
    private static final int ROOT_UNREACHABLE = 144;
    private static final int ROOT_VM_INTERNAL = 141;
    private static final int STACK_FRAME = 4;
    private static final int STACK_TRACE = 5;
    private static final int START_THREAD = 10;
    private static final int STRING_IN_UTF8 = 1;
    private static final int UNLOAD_CLASS = 3;
    TLongObjectHashMap<String> mClassNames = new TLongObjectHashMap<>();
    int mIdSize;
    private final HprofBuffer mInput;
    Snapshot mSnapshot;
    TLongObjectHashMap<String> mStrings = new TLongObjectHashMap<>();

    public HprofParser(HprofBuffer hprofBuffer) {
        this.mInput = hprofBuffer;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|(4:5|(2:7|(2:9|(2:11|(2:13|(2:15|(2:17|31)(2:18|32))(2:19|33))(2:20|34))(2:21|35))(2:22|36))(2:23|37)|30|3)|25|26|28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0071, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0073 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.squareup.haha.perflib.Snapshot parse() {
        /*
            r5 = this;
            com.squareup.haha.perflib.Snapshot r0 = new com.squareup.haha.perflib.Snapshot
            com.squareup.haha.perflib.io.HprofBuffer r1 = r5.mInput
            r0.<init>(r1)
            r5.mSnapshot = r0
            r5.readNullTerminatedString()     // Catch:{ EOFException -> 0x0073 }
            com.squareup.haha.perflib.io.HprofBuffer r1 = r5.mInput     // Catch:{ EOFException -> 0x0073 }
            int r1 = r1.readInt()     // Catch:{ EOFException -> 0x0073 }
            r5.mIdSize = r1     // Catch:{ EOFException -> 0x0073 }
            com.squareup.haha.perflib.Snapshot r2 = r5.mSnapshot     // Catch:{ EOFException -> 0x0073 }
            r2.setIdSize(r1)     // Catch:{ EOFException -> 0x0073 }
            com.squareup.haha.perflib.io.HprofBuffer r1 = r5.mInput     // Catch:{ EOFException -> 0x0073 }
            r1.readLong()     // Catch:{ EOFException -> 0x0073 }
        L_0x001e:
            com.squareup.haha.perflib.io.HprofBuffer r1 = r5.mInput     // Catch:{ EOFException -> 0x0073 }
            boolean r1 = r1.hasRemaining()     // Catch:{ EOFException -> 0x0073 }
            if (r1 == 0) goto L_0x0073
            int r1 = r5.readUnsignedByte()     // Catch:{ EOFException -> 0x0073 }
            com.squareup.haha.perflib.io.HprofBuffer r2 = r5.mInput     // Catch:{ EOFException -> 0x0073 }
            r2.readInt()     // Catch:{ EOFException -> 0x0073 }
            long r2 = r5.readUnsignedInt()     // Catch:{ EOFException -> 0x0073 }
            r4 = 1
            if (r1 == r4) goto L_0x0069
            r4 = 2
            if (r1 == r4) goto L_0x0065
            r4 = 4
            if (r1 == r4) goto L_0x0061
            r4 = 5
            if (r1 == r4) goto L_0x005d
            r4 = 12
            if (r1 == r4) goto L_0x0054
            r4 = 28
            if (r1 == r4) goto L_0x004b
            r5.skipFully(r2)     // Catch:{ EOFException -> 0x0073 }
            goto L_0x001e
        L_0x004b:
            r5.loadHeapDump(r2)     // Catch:{ EOFException -> 0x0073 }
            com.squareup.haha.perflib.Snapshot r1 = r5.mSnapshot     // Catch:{ EOFException -> 0x0073 }
            r1.setToDefaultHeap()     // Catch:{ EOFException -> 0x0073 }
            goto L_0x001e
        L_0x0054:
            r5.loadHeapDump(r2)     // Catch:{ EOFException -> 0x0073 }
            com.squareup.haha.perflib.Snapshot r1 = r5.mSnapshot     // Catch:{ EOFException -> 0x0073 }
            r1.setToDefaultHeap()     // Catch:{ EOFException -> 0x0073 }
            goto L_0x001e
        L_0x005d:
            r5.loadStackTrace()     // Catch:{ EOFException -> 0x0073 }
            goto L_0x001e
        L_0x0061:
            r5.loadStackFrame()     // Catch:{ EOFException -> 0x0073 }
            goto L_0x001e
        L_0x0065:
            r5.loadClass()     // Catch:{ EOFException -> 0x0073 }
            goto L_0x001e
        L_0x0069:
            int r1 = (int) r2     // Catch:{ EOFException -> 0x0073 }
            int r2 = r5.mIdSize     // Catch:{ EOFException -> 0x0073 }
            int r1 = r1 - r2
            r5.loadString(r1)     // Catch:{ EOFException -> 0x0073 }
            goto L_0x001e
        L_0x0071:
            r1 = move-exception
            goto L_0x007e
        L_0x0073:
            com.squareup.haha.perflib.Snapshot r1 = r5.mSnapshot     // Catch:{ Exception -> 0x0071 }
            r1.resolveClasses()     // Catch:{ Exception -> 0x0071 }
            com.squareup.haha.perflib.Snapshot r1 = r5.mSnapshot     // Catch:{ Exception -> 0x0071 }
            r1.resolveReferences()     // Catch:{ Exception -> 0x0071 }
            goto L_0x0081
        L_0x007e:
            r1.printStackTrace()
        L_0x0081:
            com.squareup.haha.trove.TLongObjectHashMap<java.lang.String> r1 = r5.mClassNames
            r1.clear()
            com.squareup.haha.trove.TLongObjectHashMap<java.lang.String> r1 = r5.mStrings
            r1.clear()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.haha.perflib.HprofParser.parse():com.squareup.haha.perflib.Snapshot");
    }

    private String readNullTerminatedString() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            byte readByte = this.mInput.readByte();
            if (readByte == 0) {
                return sb.toString();
            }
            sb.append((char) readByte);
        }
    }

    private long readId() throws IOException {
        int i = this.mIdSize;
        if (i == 1) {
            return (long) this.mInput.readByte();
        }
        if (i == 2) {
            return (long) this.mInput.readShort();
        }
        if (i == 4) {
            return (long) this.mInput.readInt();
        }
        if (i == 8) {
            return this.mInput.readLong();
        }
        throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
    }

    private String readUTF8(int i) throws IOException {
        byte[] bArr = new byte[i];
        this.mInput.read(bArr);
        return new String(bArr, "utf-8");
    }

    private int readUnsignedByte() throws IOException {
        return this.mInput.readByte() & 255;
    }

    private int readUnsignedShort() throws IOException {
        return this.mInput.readShort() & UShort.MAX_VALUE;
    }

    private long readUnsignedInt() throws IOException {
        return ((long) this.mInput.readInt()) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
    }

    private void loadString(int i) throws IOException {
        this.mStrings.put(readId(), readUTF8(i));
    }

    private void loadClass() throws IOException {
        this.mInput.readInt();
        long readId = readId();
        this.mInput.readInt();
        this.mClassNames.put(readId, this.mStrings.get(readId()));
    }

    private void loadStackFrame() throws IOException {
        this.mSnapshot.addStackFrame(new StackFrame(readId(), this.mStrings.get(readId()), this.mStrings.get(readId()), this.mStrings.get(readId()), this.mInput.readInt(), this.mInput.readInt()));
    }

    private void loadStackTrace() throws IOException {
        int readInt = this.mInput.readInt();
        int readInt2 = this.mInput.readInt();
        int readInt3 = this.mInput.readInt();
        StackFrame[] stackFrameArr = new StackFrame[readInt3];
        for (int i = 0; i < readInt3; i++) {
            stackFrameArr[i] = this.mSnapshot.getStackFrame(readId());
        }
        this.mSnapshot.addStackTrace(new StackTrace(readInt, readInt2, stackFrameArr));
    }

    private void loadHeapDump(long j) throws IOException {
        int loadBasicObj;
        while (j > 0) {
            int readUnsignedByte = readUnsignedByte();
            long j2 = j - 1;
            if (readUnsignedByte == 144) {
                loadBasicObj = loadBasicObj(RootType.UNREACHABLE);
            } else if (readUnsignedByte == 195) {
                System.err.println("+--- PRIMITIVE ARRAY NODATA DUMP");
                loadPrimitiveArrayDump();
                throw new IllegalArgumentException("Don't know how to load a nodata array");
            } else if (readUnsignedByte == 254) {
                int readInt = this.mInput.readInt();
                long readId = readId();
                this.mSnapshot.setHeapTo(readInt, this.mStrings.get(readId));
                loadBasicObj = this.mIdSize + 4;
            } else if (readUnsignedByte != 255) {
                switch (readUnsignedByte) {
                    case 1:
                        j2 -= (long) loadBasicObj(RootType.NATIVE_STATIC);
                        readId();
                        loadBasicObj = this.mIdSize;
                        break;
                    case 2:
                        loadBasicObj = loadJniLocal();
                        break;
                    case 3:
                        loadBasicObj = loadJavaFrame();
                        break;
                    case 4:
                        loadBasicObj = loadNativeStack();
                        break;
                    case 5:
                        loadBasicObj = loadBasicObj(RootType.SYSTEM_CLASS);
                        break;
                    case 6:
                        loadBasicObj = loadThreadBlock();
                        break;
                    case 7:
                        loadBasicObj = loadBasicObj(RootType.BUSY_MONITOR);
                        break;
                    case 8:
                        loadBasicObj = loadThreadObject();
                        break;
                    default:
                        switch (readUnsignedByte) {
                            case 32:
                                loadBasicObj = loadClassDump();
                                break;
                            case 33:
                                loadBasicObj = loadInstanceDump();
                                break;
                            case 34:
                                loadBasicObj = loadObjectArrayDump();
                                break;
                            case 35:
                                loadBasicObj = loadPrimitiveArrayDump();
                                break;
                            default:
                                switch (readUnsignedByte) {
                                    case 137:
                                        loadBasicObj = loadBasicObj(RootType.INTERNED_STRING);
                                        break;
                                    case 138:
                                        loadBasicObj = loadBasicObj(RootType.FINALIZING);
                                        break;
                                    case 139:
                                        loadBasicObj = loadBasicObj(RootType.DEBUGGER);
                                        break;
                                    case 140:
                                        loadBasicObj = loadBasicObj(RootType.REFERENCE_CLEANUP);
                                        break;
                                    case 141:
                                        loadBasicObj = loadBasicObj(RootType.VM_INTERNAL);
                                        break;
                                    case 142:
                                        loadBasicObj = loadJniMonitor();
                                        break;
                                    default:
                                        throw new IllegalArgumentException("loadHeapDump loop with unknown tag " + readUnsignedByte + " with " + this.mInput.remaining() + " bytes possibly remaining");
                                }
                        }
                }
            } else {
                loadBasicObj = loadBasicObj(RootType.UNKNOWN);
            }
            j = j2 - ((long) loadBasicObj);
        }
    }

    private int loadJniLocal() throws IOException {
        long readId = readId();
        int readInt = this.mInput.readInt();
        this.mSnapshot.addRoot(new RootObj(RootType.NATIVE_LOCAL, readId, readInt, this.mSnapshot.getStackTraceAtDepth(this.mSnapshot.getThread(readInt).mStackTrace, this.mInput.readInt())));
        return this.mIdSize + 4 + 4;
    }

    private int loadJavaFrame() throws IOException {
        long readId = readId();
        int readInt = this.mInput.readInt();
        this.mSnapshot.addRoot(new RootObj(RootType.JAVA_LOCAL, readId, readInt, this.mSnapshot.getStackTraceAtDepth(this.mSnapshot.getThread(readInt).mStackTrace, this.mInput.readInt())));
        return this.mIdSize + 4 + 4;
    }

    private int loadNativeStack() throws IOException {
        long readId = readId();
        int readInt = this.mInput.readInt();
        this.mSnapshot.addRoot(new RootObj(RootType.NATIVE_STACK, readId, readInt, this.mSnapshot.getStackTrace(this.mSnapshot.getThread(readInt).mStackTrace)));
        return this.mIdSize + 4;
    }

    private int loadBasicObj(RootType rootType) throws IOException {
        this.mSnapshot.addRoot(new RootObj(rootType, readId()));
        return this.mIdSize;
    }

    private int loadThreadBlock() throws IOException {
        long readId = readId();
        int readInt = this.mInput.readInt();
        this.mSnapshot.addRoot(new RootObj(RootType.THREAD_BLOCK, readId, readInt, this.mSnapshot.getStackTrace(this.mSnapshot.getThread(readInt).mStackTrace)));
        return this.mIdSize + 4;
    }

    private int loadThreadObject() throws IOException {
        long readId = readId();
        int readInt = this.mInput.readInt();
        this.mSnapshot.addThread(new ThreadObj(readId, this.mInput.readInt()), readInt);
        return this.mIdSize + 4 + 4;
    }

    private int loadClassDump() throws IOException {
        long readId = readId();
        StackTrace stackTrace = this.mSnapshot.getStackTrace(this.mInput.readInt());
        long readId2 = readId();
        long readId3 = readId();
        readId();
        readId();
        readId();
        readId();
        int readInt = this.mInput.readInt();
        int readUnsignedShort = readUnsignedShort();
        int i = (this.mIdSize * 7) + 4 + 4 + 2;
        for (int i2 = 0; i2 < readUnsignedShort; i2++) {
            readUnsignedShort();
            i += skipValue() + 2;
        }
        ClassObj classObj = r1;
        ClassObj classObj2 = new ClassObj(readId, stackTrace, this.mClassNames.get(readId), this.mInput.position());
        classObj.setSuperClassId(readId2);
        classObj.setClassLoaderId(readId3);
        int readUnsignedShort2 = readUnsignedShort();
        int i3 = i + 2;
        Field[] fieldArr = new Field[readUnsignedShort2];
        for (int i4 = 0; i4 < readUnsignedShort2; i4++) {
            Type type = Type.getType(this.mInput.readByte());
            fieldArr[i4] = new Field(type, this.mStrings.get(readId()));
            skipFully((long) this.mSnapshot.getTypeSize(type));
            i3 += this.mIdSize + 1 + this.mSnapshot.getTypeSize(type);
        }
        classObj.setStaticFields(fieldArr);
        int readUnsignedShort3 = readUnsignedShort();
        int i5 = i3 + 2;
        Field[] fieldArr2 = new Field[readUnsignedShort3];
        for (int i6 = 0; i6 < readUnsignedShort3; i6++) {
            fieldArr2[i6] = new Field(Type.getType(readUnsignedByte()), this.mStrings.get(readId()));
            i5 += this.mIdSize + 1;
        }
        classObj.setFields(fieldArr2);
        classObj.setInstanceSize(readInt);
        this.mSnapshot.addClass(readId, classObj);
        return i5;
    }

    private int loadInstanceDump() throws IOException {
        long readId = readId();
        StackTrace stackTrace = this.mSnapshot.getStackTrace(this.mInput.readInt());
        long readId2 = readId();
        int readInt = this.mInput.readInt();
        ClassInstance classInstance = new ClassInstance(readId, stackTrace, this.mInput.position());
        classInstance.setClassId(readId2);
        this.mSnapshot.addInstance(readId, classInstance);
        skipFully((long) readInt);
        int i = this.mIdSize;
        return i + 4 + i + 4 + readInt;
    }

    private int loadObjectArrayDump() throws IOException {
        long readId = readId();
        StackTrace stackTrace = this.mSnapshot.getStackTrace(this.mInput.readInt());
        int readInt = this.mInput.readInt();
        long readId2 = readId();
        ArrayInstance arrayInstance = new ArrayInstance(readId, stackTrace, Type.OBJECT, readInt, this.mInput.position());
        arrayInstance.setClassId(readId2);
        this.mSnapshot.addInstance(readId, arrayInstance);
        int i = readInt * this.mIdSize;
        skipFully((long) i);
        int i2 = this.mIdSize;
        return i2 + 4 + 4 + i2 + i;
    }

    private int loadPrimitiveArrayDump() throws IOException {
        long readId = readId();
        StackTrace stackTrace = this.mSnapshot.getStackTrace(this.mInput.readInt());
        int readInt = this.mInput.readInt();
        Type type = Type.getType(readUnsignedByte());
        int typeSize = this.mSnapshot.getTypeSize(type);
        this.mSnapshot.addInstance(readId, new ArrayInstance(readId, stackTrace, type, readInt, this.mInput.position()));
        int i = readInt * typeSize;
        skipFully((long) i);
        return this.mIdSize + 4 + 4 + 1 + i;
    }

    private int loadJniMonitor() throws IOException {
        long readId = readId();
        int readInt = this.mInput.readInt();
        this.mSnapshot.addRoot(new RootObj(RootType.NATIVE_MONITOR, readId, readInt, this.mSnapshot.getStackTraceAtDepth(this.mSnapshot.getThread(readInt).mStackTrace, this.mInput.readInt())));
        return this.mIdSize + 4 + 4;
    }

    private int skipValue() throws IOException {
        int typeSize = this.mSnapshot.getTypeSize(Type.getType(readUnsignedByte()));
        skipFully((long) typeSize);
        return typeSize + 1;
    }

    private void skipFully(long j) throws IOException {
        HprofBuffer hprofBuffer = this.mInput;
        hprofBuffer.setPosition(hprofBuffer.position() + j);
    }
}
