package com.microblink.blinkbarcode.hardware;

import kotlin.text.Typography;
import org.osgi.framework.VersionRange;

/* compiled from: line */
public class lIlIIIIlIl {
    private IllIIIIllI IlIllIlIIl = null;
    private boolean IllIIIIllI = true;
    private boolean IllIIIllII = false;
    private boolean llIIIlllll = true;
    private IllIIIIllI llIIlIlIIl = null;

    public lIlIIIIlIl(String str) {
        if (str == null || str.length() == 0) {
            throw new NullPointerException("Interval expression cannot be null nor empty!");
        }
        String trim = str.trim();
        if ("*".equals(trim)) {
            this.IllIIIllII = true;
            return;
        }
        if (trim.charAt(0) == '[') {
            this.llIIIlllll = true;
        } else if (trim.charAt(0) == '<') {
            this.llIIIlllll = false;
        } else {
            throw new IllegalArgumentException("Invalid version interval: " + trim);
        }
        int length = trim.length() - 1;
        if (trim.charAt(length) == ']') {
            this.IllIIIIllI = true;
        } else if (trim.charAt(length) == '>') {
            this.IllIIIIllI = false;
        } else {
            throw new IllegalArgumentException("Invalid version interval: " + trim);
        }
        String[] split = trim.substring(1, length).split(",");
        if (split.length == 2) {
            if (!"*".equals(split[0])) {
                this.llIIlIlIIl = new IllIIIIllI(split[0]);
            }
            if (!"*".equals(split[1])) {
                this.IlIllIlIIl = new IllIIIIllI(split[1]);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid version interval: " + trim);
    }

    public boolean llIIlIlIIl(IllIIIIllI illIIIIllI) {
        if (this.IllIIIllII) {
            return true;
        }
        IllIIIIllI illIIIIllI2 = this.llIIlIlIIl;
        if (!(illIIIIllI2 == null || (!this.llIIIlllll ? illIIIIllI.IlIllIlIIl(illIIIIllI2) : illIIIIllI.llIIlIlIIl(illIIIIllI2)))) {
            return false;
        }
        IllIIIIllI illIIIIllI3 = this.IlIllIlIIl;
        if (illIIIIllI3 == null) {
            return true;
        }
        if (this.IllIIIIllI) {
            if (illIIIIllI3.llIIlIlIIl(illIIIIllI)) {
                return true;
            }
        } else if (illIIIIllI3.IlIllIlIIl(illIIIIllI)) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.IllIIIllII) {
            sb.append('*');
        } else {
            if (this.llIIIlllll) {
                sb.append(VersionRange.LEFT_CLOSED);
            } else {
                sb.append(Typography.less);
            }
            IllIIIIllI illIIIIllI = this.llIIlIlIIl;
            if (illIIIIllI != null) {
                sb.append(illIIIIllI.toString());
            } else {
                sb.append('*');
            }
            sb.append(',');
            IllIIIIllI illIIIIllI2 = this.IlIllIlIIl;
            if (illIIIIllI2 != null) {
                sb.append(illIIIIllI2.toString());
            } else {
                sb.append('*');
            }
            if (this.IllIIIIllI) {
                sb.append(VersionRange.RIGHT_CLOSED);
            } else {
                sb.append(Typography.greater);
            }
        }
        return sb.toString();
    }
}
