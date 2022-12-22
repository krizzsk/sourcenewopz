package com.didiglobal.ddmirror.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/utils/RegUtils;", "", "()V", "Companion", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RegUtils.kt */
public final class RegUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/utils/RegUtils$Companion;", "", "()V", "regMatch", "", "obj", "", "ruleText", "regMatchNum", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RegUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean regMatch(String str, String str2) {
            CharSequence charSequence = str;
            if (TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(str2)) {
                return false;
            }
            return Pattern.compile(str2).matcher(charSequence).matches();
        }

        public final boolean regMatchNum(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "obj");
            CharSequence charSequence = str;
            return !TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(str2) && Pattern.compile(str2).matcher(charSequence).find();
        }
    }
}
