package com.didiglobal.enginecore.littleboy;

import java.util.List;

public interface ILBTask {
    ILBTask addAbility(LBAbility lBAbility);

    boolean canAddAbilityInThisTask(LBAbility lBAbility);

    int getStatus();

    boolean isRequesting();

    ILBTask removeAbility(String str);

    void removeCache();

    void requestAbilityInLoop(List<LBAbility> list);

    void setRequesting(boolean z);

    void setStatus(int i);
}
