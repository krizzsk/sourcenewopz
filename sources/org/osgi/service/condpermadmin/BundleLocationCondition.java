package org.osgi.service.condpermadmin;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Dictionary;
import java.util.Hashtable;
import org.apache.commons.p071io.IOUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;

public class BundleLocationCondition {
    private static final String CONDITION_TYPE = "org.osgi.service.condpermadmin.BundleLocationCondition";

    public static Condition getCondition(final Bundle bundle, ConditionInfo conditionInfo) {
        if (CONDITION_TYPE.equals(conditionInfo.getType())) {
            String[] args = conditionInfo.getArgs();
            if (args.length == 1 || args.length == 2) {
                String str = (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
                    public String run() {
                        return bundle.getLocation();
                    }
                });
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(location=");
                    boolean z = false;
                    sb.append(escapeLocation(args[0]));
                    sb.append(")");
                    Filter createFilter = FrameworkUtil.createFilter(sb.toString());
                    Hashtable hashtable = new Hashtable(2);
                    hashtable.put("location", str);
                    if (args.length == 2) {
                        z = "!".equals(args[1]);
                    }
                    return createFilter.match((Dictionary<String, ?>) hashtable) ^ z ? Condition.TRUE : Condition.FALSE;
                } catch (InvalidSyntaxException e) {
                    throw new RuntimeException("Invalid filter: " + e.getFilter(), e);
                }
            } else {
                throw new IllegalArgumentException("Illegal number of args: " + args.length);
            }
        } else {
            throw new IllegalArgumentException("ConditionInfo must be of type \"org.osgi.service.condpermadmin.BundleLocationCondition\"");
        }
    }

    private BundleLocationCondition() {
    }

    private static String escapeLocation(String str) {
        int i;
        int length = str.length();
        int i2 = length << 1;
        char[] cArr = new char[i2];
        str.getChars(0, length, cArr, length);
        boolean z = false;
        int i3 = 0;
        while (length < i2) {
            char c = cArr[length];
            if (c == '(' || c == ')' || (c == '\\' && ((i = length + 1) >= i2 || cArr[i] != '*'))) {
                cArr[i3] = IOUtils.DIR_SEPARATOR_WINDOWS;
                i3++;
                z = true;
            }
            cArr[i3] = c;
            i3++;
            length++;
        }
        return z ? new String(cArr, 0, i3) : str;
    }
}
