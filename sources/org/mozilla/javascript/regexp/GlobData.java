package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

/* compiled from: RegExpImpl */
final class GlobData {
    Scriptable arrayobj;
    StringBuilder charBuf;
    int dollar = -1;

    /* renamed from: global  reason: collision with root package name */
    boolean f61858global;
    Function lambda;
    int leftIndex;
    int mode;
    String repstr;
    String str;

    GlobData() {
    }
}
