package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public class zzenn extends IOException {
    private zzeon zziui = null;

    public zzenn(String str) {
        super(str);
    }

    public final zzenn zzl(zzeon zzeon) {
        this.zziui = zzeon;
        return this;
    }

    static zzenn zzbjz() {
        return new zzenn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzenn zzbka() {
        return new zzenn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzenn zzbkb() {
        return new zzenn("CodedInputStream encountered a malformed varint.");
    }

    static zzenn zzbkc() {
        return new zzenn("Protocol message contained an invalid tag (zero).");
    }

    static zzenn zzbkd() {
        return new zzenn("Protocol message end-group tag did not match expected tag.");
    }

    static zzenm zzbke() {
        return new zzenm("Protocol message tag had invalid wire type.");
    }

    static zzenn zzbkf() {
        return new zzenn("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzenn zzbkg() {
        return new zzenn("Failed to parse the message.");
    }

    static zzenn zzbkh() {
        return new zzenn("Protocol message had invalid UTF-8.");
    }
}
