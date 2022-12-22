package com.didiglobal.enginecore.littleboy;

public class LBRequest {
    public static void call(LBAbility lBAbility) {
        if (lBAbility.getContext() != null) {
            LBTaskManager.getInstance().call(lBAbility);
        }
    }

    public static void callImmediately(LBAbility lBAbility) {
        if (lBAbility.getContext() != null) {
            C168921 r0 = new LBSingleTaskImpl(lBAbility.getContext()) {
                public void removeCache() {
                }
            };
            r0.addAbility(lBAbility);
            if (r0.getStatus() == 0) {
                r0.requestAbilityInLoop(r0.mAbilityList);
            }
        }
    }

    public static void cancel(LBAbility lBAbility) {
        LBTaskManager.getInstance().cancel(lBAbility);
    }
}
