package com.didi.dqr.datamatrix.encoder;

/* renamed from: com.didi.dqr.datamatrix.encoder.d */
/* compiled from: DataMatrixSymbolInfo144 */
final class C7842d extends SymbolInfo {
    public int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? 156 : 155;
    }

    public int getInterleavedBlockCount() {
        return 10;
    }

    C7842d() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }
}
