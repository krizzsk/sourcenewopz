package com.microblink.blinkbarcode.hardware;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* compiled from: line */
final class IlIllIlIIl implements FileFilter {
    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
