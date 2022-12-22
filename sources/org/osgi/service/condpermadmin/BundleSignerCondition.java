package org.osgi.service.condpermadmin;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class BundleSignerCondition {
    private static final String CONDITION_TYPE = "org.osgi.service.condpermadmin.BundleSignerCondition";

    public static Condition getCondition(Bundle bundle, ConditionInfo conditionInfo) {
        boolean z;
        boolean z2;
        if (CONDITION_TYPE.equals(conditionInfo.getType())) {
            String[] args = conditionInfo.getArgs();
            if (args.length == 1 || args.length == 2) {
                Iterator<List<X509Certificate>> it = bundle.getSignerCertificates(2).values().iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    List<X509Certificate> next = it.next();
                    ArrayList arrayList = new ArrayList(next.size());
                    for (X509Certificate subjectDN : next) {
                        arrayList.add(subjectDN.getSubjectDN().getName());
                    }
                    if (FrameworkUtil.matchDistinguishedNameChain(args[0], arrayList)) {
                        z2 = true;
                        break;
                    }
                }
                if (args.length == 2) {
                    z = "!".equals(args[1]);
                }
                if (z2 ^ z) {
                    return Condition.TRUE;
                }
                return Condition.FALSE;
            }
            throw new IllegalArgumentException("Illegal number of args: " + args.length);
        }
        throw new IllegalArgumentException("ConditionInfo must be of type \"org.osgi.service.condpermadmin.BundleSignerCondition\"");
    }

    private BundleSignerCondition() {
    }
}
