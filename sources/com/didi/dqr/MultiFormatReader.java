package com.didi.dqr;

import com.didi.dqr.datamatrix.DataMatrixReader;
import com.didi.dqr.oned.MultiFormatOneDReader;
import com.didi.dqr.pdf417.PDF417Reader;
import com.didi.dqr.qrcode.QRCodeReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class MultiFormatReader implements Reader {

    /* renamed from: a */
    private Map<DecodeHintType, ?> f18485a;

    /* renamed from: b */
    private Reader[] f18486b;

    /* renamed from: c */
    private DecodeOptions f18487c;

    /* renamed from: d */
    private Map<String, Result> f18488d = new HashMap();

    /* renamed from: e */
    private List<String> f18489e = new LinkedList();

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException {
        setHints((Map<DecodeHintType, ?>) null);
        return m13715a(binaryBitmap);
    }

    public Result decode(BinaryBitmap binaryBitmap, DecodeOptions decodeOptions) throws NotFoundException {
        setHints(this.f18485a);
        return m13715a(binaryBitmap);
    }

    public Result decodeWithState(BinaryBitmap binaryBitmap) throws NotFoundException {
        if (this.f18486b == null) {
            setHints((Map<DecodeHintType, ?>) null);
        }
        return m13715a(binaryBitmap);
    }

    public void setHints(Map<DecodeHintType, ?> map) {
        Collection collection;
        this.f18485a = map;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        PrintStream printStream = System.out;
        printStream.println("setHints() called, formats===" + collection);
        if (collection != null) {
            if (collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF) || collection.contains(BarcodeFormat.RSS_14) || collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new QRCodeReader());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new DataMatrixReader());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new PDF417Reader());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new QRCodeReader());
        }
        this.f18486b = (Reader[]) arrayList.toArray(new Reader[0]);
        PrintStream printStream2 = System.out;
        printStream2.println("setHints readers===" + Arrays.toString(this.f18486b));
    }

    public void reset() {
        Reader[] readerArr = this.f18486b;
        if (readerArr != null) {
            for (Reader reset : readerArr) {
                reset.reset();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007a, code lost:
        throw com.didi.dqr.NotFoundException.getNotFoundInstance();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.didi.dqr.Result m13715a(com.didi.dqr.BinaryBitmap r9) throws com.didi.dqr.NotFoundException {
        /*
            r8 = this;
            com.didi.dqr.Reader[] r0 = r8.f18486b
            if (r0 == 0) goto L_0x0081
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x0007:
            if (r3 >= r1) goto L_0x0081
            r4 = r0[r3]
            com.didi.dqr.DecodeOptions r5 = r8.f18487c     // Catch:{ ReaderException -> 0x007e }
            com.didi.dqr.Result r4 = r4.decode(r9, r5)     // Catch:{ ReaderException -> 0x007e }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ ReaderException -> 0x007e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ReaderException -> 0x007e }
            r6.<init>()     // Catch:{ ReaderException -> 0x007e }
            java.lang.String r7 = "dqr decodeInner result format==="
            r6.append(r7)     // Catch:{ ReaderException -> 0x007e }
            com.didi.dqr.BarcodeFormat r7 = r4.getBarcodeFormat()     // Catch:{ ReaderException -> 0x007e }
            r6.append(r7)     // Catch:{ ReaderException -> 0x007e }
            java.lang.String r6 = r6.toString()     // Catch:{ ReaderException -> 0x007e }
            r5.println(r6)     // Catch:{ ReaderException -> 0x007e }
            com.didi.dqr.BarcodeFormat r5 = r4.getBarcodeFormat()     // Catch:{ ReaderException -> 0x007e }
            com.didi.dqr.BarcodeFormat r6 = com.didi.dqr.BarcodeFormat.EAN_8     // Catch:{ ReaderException -> 0x007e }
            if (r5 == r6) goto L_0x003d
            com.didi.dqr.BarcodeFormat r5 = r4.getBarcodeFormat()     // Catch:{ ReaderException -> 0x007e }
            com.didi.dqr.BarcodeFormat r6 = com.didi.dqr.BarcodeFormat.EAN_13     // Catch:{ ReaderException -> 0x007e }
            if (r5 != r6) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            return r4
        L_0x003d:
            java.util.Map<java.lang.String, com.didi.dqr.Result> r5 = r8.f18488d     // Catch:{ ReaderException -> 0x007e }
            monitor-enter(r5)     // Catch:{ ReaderException -> 0x007e }
            java.util.Map<java.lang.String, com.didi.dqr.Result> r6 = r8.f18488d     // Catch:{ all -> 0x007b }
            java.lang.String r7 = r4.getText()     // Catch:{ all -> 0x007b }
            boolean r6 = r6.containsKey(r7)     // Catch:{ all -> 0x007b }
            if (r6 == 0) goto L_0x004e
            monitor-exit(r5)     // Catch:{ all -> 0x007b }
            return r4
        L_0x004e:
            java.lang.String r6 = r4.getText()     // Catch:{ all -> 0x007b }
            if (r6 == 0) goto L_0x0075
            java.util.Map<java.lang.String, com.didi.dqr.Result> r7 = r8.f18488d     // Catch:{ all -> 0x007b }
            r7.put(r6, r4)     // Catch:{ all -> 0x007b }
            java.util.List<java.lang.String> r4 = r8.f18489e     // Catch:{ all -> 0x007b }
            r4.add(r6)     // Catch:{ all -> 0x007b }
            java.util.Map<java.lang.String, com.didi.dqr.Result> r4 = r8.f18488d     // Catch:{ all -> 0x007b }
            int r4 = r4.size()     // Catch:{ all -> 0x007b }
            r6 = 10
            if (r4 <= r6) goto L_0x0075
            java.util.List<java.lang.String> r4 = r8.f18489e     // Catch:{ all -> 0x007b }
            java.lang.Object r4 = r4.remove(r2)     // Catch:{ all -> 0x007b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x007b }
            java.util.Map<java.lang.String, com.didi.dqr.Result> r6 = r8.f18488d     // Catch:{ all -> 0x007b }
            r6.remove(r4)     // Catch:{ all -> 0x007b }
        L_0x0075:
            monitor-exit(r5)     // Catch:{ all -> 0x007b }
            com.didi.dqr.NotFoundException r4 = com.didi.dqr.NotFoundException.getNotFoundInstance()     // Catch:{ ReaderException -> 0x007e }
            throw r4     // Catch:{ ReaderException -> 0x007e }
        L_0x007b:
            r4 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x007b }
            throw r4     // Catch:{ ReaderException -> 0x007e }
        L_0x007e:
            int r3 = r3 + 1
            goto L_0x0007
        L_0x0081:
            com.didi.dqr.NotFoundException r9 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.MultiFormatReader.m13715a(com.didi.dqr.BinaryBitmap):com.didi.dqr.Result");
    }

    public void setDecodeOptions(DecodeOptions decodeOptions) {
        this.f18487c = decodeOptions;
    }
}
