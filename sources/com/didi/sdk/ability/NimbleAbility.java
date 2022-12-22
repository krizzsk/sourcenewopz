package com.didi.sdk.ability;

import java.util.Map;

public interface NimbleAbility {
    public static final String NAME = "BaseAbilityEnd";

    void doAction(Map map, AbilityCallback abilityCallback);
}
