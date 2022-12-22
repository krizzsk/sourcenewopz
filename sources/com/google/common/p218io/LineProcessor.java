package com.google.common.p218io;

import java.io.IOException;

/* renamed from: com.google.common.io.LineProcessor */
public interface LineProcessor<T> {
    T getResult();

    boolean processLine(String str) throws IOException;
}
