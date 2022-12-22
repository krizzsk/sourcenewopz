package org.mozilla.javascript.regexp;

import net.lingala.zip4j.util.InternalZipConstants;

/* compiled from: NativeRegExp */
class REGlobalData {
    REBackTrackData backTrackStackTop;

    /* renamed from: cp */
    int f6658cp;
    boolean multiline;
    long[] parens;
    RECompiled regexp;
    int skipped;
    REProgState stateStackTop;

    REGlobalData() {
    }

    /* access modifiers changed from: package-private */
    public int parensIndex(int i) {
        return (int) this.parens[i];
    }

    /* access modifiers changed from: package-private */
    public int parensLength(int i) {
        return (int) (this.parens[i] >>> 32);
    }

    /* access modifiers changed from: package-private */
    public void setParens(int i, int i2, int i3) {
        long[] jArr;
        REBackTrackData rEBackTrackData = this.backTrackStackTop;
        if (rEBackTrackData != null && rEBackTrackData.parens == (jArr = this.parens)) {
            this.parens = (long[]) jArr.clone();
        }
        this.parens[i] = (((long) i3) << 32) | (((long) i2) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
    }
}
