package org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime;

import java.util.regex.Pattern;
import org.osgi.framework.VersionRange;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.WildcardMatcher */
public class WildcardMatcher {
    private final Pattern pattern;

    public WildcardMatcher(String str) {
        String[] split = str.split("\\:");
        StringBuilder sb = new StringBuilder(str.length() * 2);
        int length = split.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            String str2 = split[i];
            if (z) {
                sb.append('|');
            }
            sb.append(VersionRange.LEFT_OPEN);
            sb.append(toRegex(str2));
            sb.append(VersionRange.RIGHT_OPEN);
            i++;
            z = true;
        }
        this.pattern = Pattern.compile(sb.toString());
    }

    private static CharSequence toRegex(String str) {
        StringBuilder sb = new StringBuilder(str.length() * 2);
        for (char c : str.toCharArray()) {
            if (c == '*') {
                sb.append(".*");
            } else if (c != '?') {
                sb.append(Pattern.quote(String.valueOf(c)));
            } else {
                sb.append(".?");
            }
        }
        return sb;
    }

    public boolean matches(String str) {
        return this.pattern.matcher(str).matches();
    }
}
