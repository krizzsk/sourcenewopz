package org.osgi.service.condpermadmin;

import java.util.Dictionary;

public interface Condition {
    public static final Condition FALSE = new BooleanCondition(false);
    public static final Condition TRUE = new BooleanCondition(true);

    boolean isMutable();

    boolean isPostponed();

    boolean isSatisfied();

    boolean isSatisfied(Condition[] conditionArr, Dictionary<Object, Object> dictionary);
}
