package com.didi.addressnew.framework.mapholder;

import java.io.File;
import java.io.FileFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/addressnew/framework/mapholder/HighEndMobile$filter$1", "Ljava/io/FileFilter;", "accept", "", "pathname", "Ljava/io/File;", "global_sug_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HighEndMobile.kt */
public final class HighEndMobile$filter$1 implements FileFilter {
    HighEndMobile$filter$1() {
    }

    public boolean accept(File file) {
        Intrinsics.checkNotNullParameter(file, "pathname");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "pathname.name");
        if (!StringsKt.startsWith$default(name, "cpu", false, 2, (Object) null)) {
            return false;
        }
        int i = 3;
        int length = name.length();
        if (3 >= length) {
            return true;
        }
        while (true) {
            int i2 = i + 1;
            if (Intrinsics.compare((int) name.charAt(i), 48) < 0 || Intrinsics.compare((int) name.charAt(i), 57) > 0) {
                return false;
            }
            if (i2 >= length) {
                return true;
            }
            i = i2;
        }
        return false;
    }
}
