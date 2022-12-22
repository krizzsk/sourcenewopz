package com.google.android.gms.internal.ads;

import org.apache.commons.p071io.IOUtils;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepw {
    static String zzan(zzelq zzelq) {
        zzepz zzepz = new zzepz(zzelq);
        StringBuilder sb = new StringBuilder(zzepz.size());
        for (int i = 0; i < zzepz.size(); i++) {
            byte zzgh = zzepz.zzgh(i);
            if (zzgh == 34) {
                sb.append("\\\"");
            } else if (zzgh == 39) {
                sb.append("\\'");
            } else if (zzgh != 92) {
                switch (zzgh) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zzgh >= 32 && zzgh <= 126) {
                            sb.append((char) zzgh);
                            break;
                        } else {
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append((char) (((zzgh >>> 6) & 3) + 48));
                            sb.append((char) (((zzgh >>> 3) & 7) + 48));
                            sb.append((char) ((zzgh & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
