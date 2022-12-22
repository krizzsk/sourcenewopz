package com.google.android.gms.internal.ads;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.osgi.framework.VersionRange;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzdyq {
    public static String zzhn(@NullableDecl String str) {
        return zzdye.zzhn(str);
    }

    @NullableDecl
    public static String emptyToNull(@NullableDecl String str) {
        return zzdye.emptyToNull(str);
    }

    public static boolean zzar(@NullableDecl String str) {
        return zzdye.zzhm(str);
    }

    public static String zzb(@NullableDecl String str, @NullableDecl Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            objArr[i2] = zzz(objArr[i2]);
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i3 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf(InvitationTrackFragment.INVITE_DATE, i3)) != -1) {
            sb.append(valueOf, i3, indexOf);
            sb.append(objArr[i]);
            int i4 = i + 1;
            i3 = indexOf + 2;
            i = i4;
        }
        sb.append(valueOf, i3, valueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i5 = i + 1; i5 < objArr.length; i5++) {
                sb.append(", ");
                sb.append(objArr[i5]);
            }
            sb.append(VersionRange.RIGHT_CLOSED);
        }
        return sb.toString();
    }

    private static String zzz(@NullableDecl Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
            sb.append(name);
            sb.append('@');
            sb.append(hexString);
            String sb2 = sb.toString();
            Logger logger = Logger.getLogger("com.google.common.base.Strings");
            Level level = Level.WARNING;
            String valueOf = String.valueOf(sb2);
            logger.logp(level, "com.google.common.base.Strings", "lenientToString", valueOf.length() != 0 ? "Exception during lenientFormat for ".concat(valueOf) : new String("Exception during lenientFormat for "), e);
            String name2 = e.getClass().getName();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 9 + String.valueOf(name2).length());
            sb3.append(IMTextUtils.STREET_IMAGE_TAG_START);
            sb3.append(sb2);
            sb3.append(" threw ");
            sb3.append(name2);
            sb3.append(IMTextUtils.STREET_IMAGE_TAG_END);
            return sb3.toString();
        }
    }
}
