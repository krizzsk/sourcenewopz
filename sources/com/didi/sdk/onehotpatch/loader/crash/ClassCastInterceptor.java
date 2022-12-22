package com.didi.sdk.onehotpatch.loader.crash;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassCastInterceptor implements CrashInterceptor {

    /* renamed from: p */
    private static final Pattern f36875p = Pattern.compile("^.*((?:[\\w$]+(?:\\.[\\w$]+)+?)) .* \\1.*$");

    public boolean intercept(Throwable th) {
        String message = th.getMessage();
        if (message != null && !"".equals(message.trim())) {
            Matcher matcher = f36875p.matcher(message);
            if (matcher.matches() && matcher.groupCount() == 2) {
                String group = matcher.group(0);
                String group2 = matcher.group(1);
                if (group == null || group2 == null || !group.equals(group2)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
