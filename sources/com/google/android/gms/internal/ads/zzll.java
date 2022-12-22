package com.google.android.gms.internal.ads;

import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.internal.ads.zzmh;
import com.google.common.net.HttpHeaders;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzll {
    private static final int zzayx = zzpt.zzbh("nam");
    private static final int zzayy = zzpt.zzbh("trk");
    private static final int zzayz = zzpt.zzbh("cmt");
    private static final int zzaza = zzpt.zzbh("day");
    private static final int zzazb = zzpt.zzbh("ART");
    private static final int zzazc = zzpt.zzbh("too");
    private static final int zzazd = zzpt.zzbh("alb");
    private static final int zzaze = zzpt.zzbh("com");
    private static final int zzazf = zzpt.zzbh("wrt");
    private static final int zzazg = zzpt.zzbh("lyr");
    private static final int zzazh = zzpt.zzbh("gen");
    private static final int zzazi = zzpt.zzbh("covr");
    private static final int zzazj = zzpt.zzbh("gnre");
    private static final int zzazk = zzpt.zzbh("grp");
    private static final int zzazl = zzpt.zzbh("disk");
    private static final int zzazm = zzpt.zzbh("trkn");
    private static final int zzazn = zzpt.zzbh("tmpo");
    private static final int zzazo = zzpt.zzbh("cpil");
    private static final int zzazp = zzpt.zzbh("aART");
    private static final int zzazq = zzpt.zzbh("sonm");
    private static final int zzazr = zzpt.zzbh("soal");
    private static final int zzazs = zzpt.zzbh("soar");
    private static final int zzazt = zzpt.zzbh("soaa");
    private static final int zzazu = zzpt.zzbh("soco");
    private static final int zzazv = zzpt.zzbh("rtng");
    private static final int zzazw = zzpt.zzbh("pgap");
    private static final int zzazx = zzpt.zzbh("sosn");
    private static final int zzazy = zzpt.zzbh("tvsh");
    private static final int zzazz = zzpt.zzbh("----");
    private static final String[] zzbaa = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static zzmh.zza zzd(zzpn zzpn) {
        int position = zzpn.getPosition() + zzpn.readInt();
        int readInt = zzpn.readInt();
        int i = readInt >>> 24;
        zzmh.zza zza = null;
        if (i == 169 || i == 65533) {
            int i2 = 16777215 & readInt;
            if (i2 == zzayz) {
                int readInt2 = zzpn.readInt();
                if (zzpn.readInt() == zzkw.zzawm) {
                    zzpn.zzbm(8);
                    String zzbn = zzpn.zzbn(readInt2 - 16);
                    zza = new zzmj("und", zzbn, zzbn);
                } else {
                    String valueOf = String.valueOf(zzkw.zzaw(readInt));
                    SystemUtils.log(5, "MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "), (Throwable) null, "com.google.android.gms.internal.ads.zzll", 15);
                }
                zzpn.zzbl(position);
                return zza;
            }
            if (i2 != zzayx) {
                if (i2 != zzayy) {
                    if (i2 != zzaze) {
                        if (i2 != zzazf) {
                            if (i2 == zzaza) {
                                zzmn zza2 = zza(readInt, "TDRC", zzpn);
                                zzpn.zzbl(position);
                                return zza2;
                            } else if (i2 == zzazb) {
                                zzmn zza3 = zza(readInt, "TPE1", zzpn);
                                zzpn.zzbl(position);
                                return zza3;
                            } else if (i2 == zzazc) {
                                zzmn zza4 = zza(readInt, "TSSE", zzpn);
                                zzpn.zzbl(position);
                                return zza4;
                            } else if (i2 == zzazd) {
                                zzmn zza5 = zza(readInt, "TALB", zzpn);
                                zzpn.zzbl(position);
                                return zza5;
                            } else if (i2 == zzazg) {
                                zzmn zza6 = zza(readInt, "USLT", zzpn);
                                zzpn.zzbl(position);
                                return zza6;
                            } else if (i2 == zzazh) {
                                zzmn zza7 = zza(readInt, "TCON", zzpn);
                                zzpn.zzbl(position);
                                return zza7;
                            } else if (i2 == zzazk) {
                                zzmn zza8 = zza(readInt, "TIT1", zzpn);
                                zzpn.zzbl(position);
                                return zza8;
                            }
                        }
                    }
                    zzmn zza9 = zza(readInt, "TCOM", zzpn);
                    zzpn.zzbl(position);
                    return zza9;
                }
            }
            zzmn zza10 = zza(readInt, "TIT2", zzpn);
            zzpn.zzbl(position);
            return zza10;
        }
        try {
            if (readInt == zzazj) {
                int zze = zze(zzpn);
                String str = (zze <= 0 || zze > zzbaa.length) ? null : zzbaa[zze - 1];
                if (str != null) {
                    zza = new zzmn("TCON", (String) null, str);
                } else {
                    SystemUtils.log(5, "MetadataUtil", "Failed to parse standard genre code", (Throwable) null, "com.google.android.gms.internal.ads.zzll", 63);
                }
                return zza;
            } else if (readInt == zzazl) {
                zzmn zzb = zzb(readInt, "TPOS", zzpn);
                zzpn.zzbl(position);
                return zzb;
            } else if (readInt == zzazm) {
                zzmn zzb2 = zzb(readInt, "TRCK", zzpn);
                zzpn.zzbl(position);
                return zzb2;
            } else if (readInt == zzazn) {
                zzmo zza11 = zza(readInt, "TBPM", zzpn, true, false);
                zzpn.zzbl(position);
                return zza11;
            } else if (readInt == zzazo) {
                zzmo zza12 = zza(readInt, "TCMP", zzpn, true, true);
                zzpn.zzbl(position);
                return zza12;
            } else if (readInt == zzazi) {
                int readInt3 = zzpn.readInt();
                if (zzpn.readInt() == zzkw.zzawm) {
                    int zzav = zzkw.zzav(zzpn.readInt());
                    String str2 = zzav == 13 ? "image/jpeg" : zzav == 14 ? "image/png" : null;
                    if (str2 == null) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(zzav);
                        SystemUtils.log(5, "MetadataUtil", sb.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzll", 93);
                    } else {
                        zzpn.zzbm(4);
                        int i3 = readInt3 - 16;
                        byte[] bArr = new byte[i3];
                        zzpn.zze(bArr, 0, i3);
                        zza = new zzmi(str2, (String) null, 3, bArr);
                    }
                } else {
                    SystemUtils.log(5, "MetadataUtil", "Failed to parse cover art attribute", (Throwable) null, "com.google.android.gms.internal.ads.zzll", 99);
                }
                zzpn.zzbl(position);
                return zza;
            } else if (readInt == zzazp) {
                zzmn zza13 = zza(readInt, "TPE2", zzpn);
                zzpn.zzbl(position);
                return zza13;
            } else if (readInt == zzazq) {
                zzmn zza14 = zza(readInt, "TSOT", zzpn);
                zzpn.zzbl(position);
                return zza14;
            } else if (readInt == zzazr) {
                zzmn zza15 = zza(readInt, "TSO2", zzpn);
                zzpn.zzbl(position);
                return zza15;
            } else if (readInt == zzazs) {
                zzmn zza16 = zza(readInt, "TSOA", zzpn);
                zzpn.zzbl(position);
                return zza16;
            } else if (readInt == zzazt) {
                zzmn zza17 = zza(readInt, "TSOP", zzpn);
                zzpn.zzbl(position);
                return zza17;
            } else if (readInt == zzazu) {
                zzmn zza18 = zza(readInt, "TSOC", zzpn);
                zzpn.zzbl(position);
                return zza18;
            } else if (readInt == zzazv) {
                zzmo zza19 = zza(readInt, "ITUNESADVISORY", zzpn, false, false);
                zzpn.zzbl(position);
                return zza19;
            } else if (readInt == zzazw) {
                zzmo zza20 = zza(readInt, "ITUNESGAPLESS", zzpn, false, true);
                zzpn.zzbl(position);
                return zza20;
            } else if (readInt == zzazx) {
                zzmn zza21 = zza(readInt, "TVSHOWSORT", zzpn);
                zzpn.zzbl(position);
                return zza21;
            } else if (readInt == zzazy) {
                zzmn zza22 = zza(readInt, "TVSHOW", zzpn);
                zzpn.zzbl(position);
                return zza22;
            } else if (readInt == zzazz) {
                String str3 = null;
                String str4 = null;
                int i4 = -1;
                int i5 = -1;
                while (zzpn.getPosition() < position) {
                    int position2 = zzpn.getPosition();
                    int readInt4 = zzpn.readInt();
                    int readInt5 = zzpn.readInt();
                    zzpn.zzbm(4);
                    if (readInt5 == zzkw.zzawk) {
                        str3 = zzpn.zzbn(readInt4 - 12);
                    } else if (readInt5 == zzkw.zzawl) {
                        str4 = zzpn.zzbn(readInt4 - 12);
                    } else {
                        if (readInt5 == zzkw.zzawm) {
                            i4 = position2;
                            i5 = readInt4;
                        }
                        zzpn.zzbm(readInt4 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(str3) && "iTunSMPB".equals(str4)) {
                    if (i4 != -1) {
                        zzpn.zzbl(i4);
                        zzpn.zzbm(16);
                        zza = new zzmj("und", str4, zzpn.zzbn(i5 - 16));
                    }
                }
                zzpn.zzbl(position);
                return zza;
            }
        } finally {
            zzpn.zzbl(position);
        }
        String valueOf2 = String.valueOf(zzkw.zzaw(readInt));
        SystemUtils.log(3, "MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "), (Throwable) null, "com.google.android.gms.internal.ads.zzll", 173);
        zzpn.zzbl(position);
        return null;
    }

    private static zzmn zza(int i, String str, zzpn zzpn) {
        int readInt = zzpn.readInt();
        if (zzpn.readInt() == zzkw.zzawm) {
            zzpn.zzbm(8);
            return new zzmn(str, (String) null, zzpn.zzbn(readInt - 16));
        }
        String valueOf = String.valueOf(zzkw.zzaw(i));
        SystemUtils.log(5, "MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "), (Throwable) null, "com.google.android.gms.internal.ads.zzll", 184);
        return null;
    }

    private static zzmo zza(int i, String str, zzpn zzpn, boolean z, boolean z2) {
        int zze = zze(zzpn);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze < 0) {
            String valueOf = String.valueOf(zzkw.zzaw(i));
            SystemUtils.log(5, "MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "), (Throwable) null, "com.google.android.gms.internal.ads.zzll", 193);
            return null;
        } else if (z) {
            return new zzmn(str, (String) null, Integer.toString(zze));
        } else {
            return new zzmj("und", str, Integer.toString(zze));
        }
    }

    private static zzmn zzb(int i, String str, zzpn zzpn) {
        int readInt = zzpn.readInt();
        if (zzpn.readInt() == zzkw.zzawm && readInt >= 22) {
            zzpn.zzbm(10);
            int readUnsignedShort = zzpn.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzpn.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzmn(str, (String) null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzkw.zzaw(i));
        SystemUtils.log(5, "MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "), (Throwable) null, "com.google.android.gms.internal.ads.zzll", 206);
        return null;
    }

    private static int zze(zzpn zzpn) {
        zzpn.zzbm(4);
        if (zzpn.readInt() == zzkw.zzawm) {
            zzpn.zzbm(8);
            return zzpn.readUnsignedByte();
        }
        SystemUtils.log(5, "MetadataUtil", "Failed to parse uint8 attribute value", (Throwable) null, "com.google.android.gms.internal.ads.zzll", 213);
        return -1;
    }
}
