package com.didichuxing.xpanel.global.models;

import com.didichuxing.xpanel.global.models.misoperation.MisOperationData;
import com.didichuxing.xpanel.global.models.misoperation.MisOperationView;
import com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData;
import com.didichuxing.xpanel.global.models.taskoperation.TaskOperationView;
import com.didichuxing.xpanel.models.ModelsFactory;

public class XPanelModels {
    public static final String X_PANEL_ID_GLOBAL_OPERATION = "xpcard_global_operation";
    public static final String X_PANEL_TEMPLATE_GLOBAL_OPERATION = "global_operation";
    public static final String X_PANEL_TEMPLATE_GLOBAL_TASK = "global_mission_combo";

    public static void register() {
        ModelsFactory modelsFactory = ModelsFactory.get();
        modelsFactory.register(X_PANEL_TEMPLATE_GLOBAL_OPERATION, MisOperationView.class, MisOperationData.class, 1);
        modelsFactory.register(X_PANEL_TEMPLATE_GLOBAL_TASK, TaskOperationView.class, TaskOperationData.class, 2);
    }
}
