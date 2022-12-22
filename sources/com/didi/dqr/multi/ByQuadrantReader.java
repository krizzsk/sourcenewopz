package com.didi.dqr.multi;

import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.ChecksumException;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.Reader;
import com.didi.dqr.Result;
import com.didi.dqr.ResultPoint;

public final class ByQuadrantReader implements Reader {

    /* renamed from: a */
    private final Reader f18657a;

    public ByQuadrantReader(Reader reader) {
        this.f18657a = reader;
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, (DecodeOptions) null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2 = r5.f18657a.decode(r6.crop(r0, r1, r0, r1), r7);
        m13871a(r2.getResultPoints(), r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        r2 = r0 / 2;
        r3 = r1 / 2;
        r6 = r5.f18657a.decode(r6.crop(r2, r3, r0, r1), r7);
        m13871a(r6.getResultPoints(), r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r3 = r5.f18657a.decode(r6.crop(r0, 0, r0, r1), r7);
        m13871a(r3.getResultPoints(), r0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3 = r5.f18657a.decode(r6.crop(0, r1, r0, r1), r7);
        m13871a(r3.getResultPoints(), 0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        return r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0018 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.dqr.Result decode(com.didi.dqr.BinaryBitmap r6, com.didi.dqr.DecodeOptions r7) throws com.didi.dqr.NotFoundException, com.didi.dqr.ChecksumException, com.didi.dqr.FormatException {
        /*
            r5 = this;
            int r0 = r6.getWidth()
            int r1 = r6.getHeight()
            int r0 = r0 / 2
            int r1 = r1 / 2
            r2 = 0
            com.didi.dqr.Reader r3 = r5.f18657a     // Catch:{ NotFoundException -> 0x0018 }
            com.didi.dqr.BinaryBitmap r4 = r6.crop(r2, r2, r0, r1)     // Catch:{ NotFoundException -> 0x0018 }
            com.didi.dqr.Result r6 = r3.decode(r4, r7)     // Catch:{ NotFoundException -> 0x0018 }
            return r6
        L_0x0018:
            com.didi.dqr.Reader r3 = r5.f18657a     // Catch:{ NotFoundException -> 0x002a }
            com.didi.dqr.BinaryBitmap r4 = r6.crop(r0, r2, r0, r1)     // Catch:{ NotFoundException -> 0x002a }
            com.didi.dqr.Result r3 = r3.decode(r4, r7)     // Catch:{ NotFoundException -> 0x002a }
            com.didi.dqr.ResultPoint[] r4 = r3.getResultPoints()     // Catch:{ NotFoundException -> 0x002a }
            m13871a(r4, r0, r2)     // Catch:{ NotFoundException -> 0x002a }
            return r3
        L_0x002a:
            com.didi.dqr.Reader r3 = r5.f18657a     // Catch:{ NotFoundException -> 0x003c }
            com.didi.dqr.BinaryBitmap r4 = r6.crop(r2, r1, r0, r1)     // Catch:{ NotFoundException -> 0x003c }
            com.didi.dqr.Result r3 = r3.decode(r4, r7)     // Catch:{ NotFoundException -> 0x003c }
            com.didi.dqr.ResultPoint[] r4 = r3.getResultPoints()     // Catch:{ NotFoundException -> 0x003c }
            m13871a(r4, r2, r1)     // Catch:{ NotFoundException -> 0x003c }
            return r3
        L_0x003c:
            com.didi.dqr.Reader r2 = r5.f18657a     // Catch:{ NotFoundException -> 0x004e }
            com.didi.dqr.BinaryBitmap r3 = r6.crop(r0, r1, r0, r1)     // Catch:{ NotFoundException -> 0x004e }
            com.didi.dqr.Result r2 = r2.decode(r3, r7)     // Catch:{ NotFoundException -> 0x004e }
            com.didi.dqr.ResultPoint[] r3 = r2.getResultPoints()     // Catch:{ NotFoundException -> 0x004e }
            m13871a(r3, r0, r1)     // Catch:{ NotFoundException -> 0x004e }
            return r2
        L_0x004e:
            int r2 = r0 / 2
            int r3 = r1 / 2
            com.didi.dqr.BinaryBitmap r6 = r6.crop(r2, r3, r0, r1)
            com.didi.dqr.Reader r0 = r5.f18657a
            com.didi.dqr.Result r6 = r0.decode(r6, r7)
            com.didi.dqr.ResultPoint[] r7 = r6.getResultPoints()
            m13871a(r7, r2, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.multi.ByQuadrantReader.decode(com.didi.dqr.BinaryBitmap, com.didi.dqr.DecodeOptions):com.didi.dqr.Result");
    }

    public void reset() {
        this.f18657a.reset();
    }

    /* renamed from: a */
    private static void m13871a(ResultPoint[] resultPointArr, int i, int i2) {
        if (resultPointArr != null) {
            for (int i3 = 0; i3 < resultPointArr.length; i3++) {
                ResultPoint resultPoint = resultPointArr[i3];
                resultPointArr[i3] = new ResultPoint(resultPoint.getX() + ((float) i), resultPoint.getY() + ((float) i2));
            }
        }
    }
}
