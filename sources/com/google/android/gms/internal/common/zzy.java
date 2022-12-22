package com.google.android.gms.internal.common;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;
import org.osgi.framework.VersionRange;

@NullMarked
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzy {
    public static String zza(@CheckForNull String str, @CheckForNull Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e) {
                    String str3 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str3), e);
                    str2 = IMTextUtils.STREET_IMAGE_TAG_START + str3 + " threw " + e.getClass().getName() + IMTextUtils.STREET_IMAGE_TAG_END;
                }
            }
            objArr[i2] = str2;
            i2++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (indexOf = str.indexOf(InvitationTrackFragment.INVITE_DATE, i3)) == -1) {
                sb.append(str, i3, str.length());
            } else {
                sb.append(str, i3, indexOf);
                sb.append(objArr[i]);
                i3 = indexOf + 2;
                i++;
            }
        }
        sb.append(str, i3, str.length());
        if (i < length2) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(VersionRange.RIGHT_CLOSED);
        }
        return sb.toString();
    }
}
