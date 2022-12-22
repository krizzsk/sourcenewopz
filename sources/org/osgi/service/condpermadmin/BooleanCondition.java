package org.osgi.service.condpermadmin;

import java.util.Dictionary;

/* compiled from: Condition */
final class BooleanCondition implements Condition {
    private final boolean satisfied;

    public boolean isMutable() {
        return false;
    }

    public boolean isPostponed() {
        return false;
    }

    BooleanCondition(boolean z) {
        this.satisfied = z;
    }

    public boolean isSatisfied() {
        return this.satisfied;
    }

    public boolean isSatisfied(Condition[] conditionArr, Dictionary<Object, Object> dictionary) {
        for (Condition isSatisfied : conditionArr) {
            if (!isSatisfied.isSatisfied()) {
                return false;
            }
        }
        return true;
    }
}
