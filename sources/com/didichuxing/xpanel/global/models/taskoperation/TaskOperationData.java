package com.didichuxing.xpanel.global.models.taskoperation;

import com.didichuxing.xpanel.global.models.XPanelModels;
import com.didichuxing.xpanel.models.IXPanelModel;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class TaskOperationData extends IXPanelModel {
    public static final int STYLE_SHOW_DOT = 1;
    public static final int STYLE_SHOW_TAKE = 2;
    public static final int STYLE_SHOW_TICKET = 3;

    /* renamed from: T */
    public String f49527T;
    public String activityId;
    public String assit;
    public int finishCount;
    public String link;
    public String linkTitle;
    public HashMap<String, Object> logDataMap = new HashMap<>();
    public String mainTitle;
    public List<Task> tasks;
    public String tip;
    public String title;

    public String getTemplate() {
        return XPanelModels.X_PANEL_TEMPLATE_GLOBAL_TASK;
    }

    public static class Task {
        public String bottom;
        public int showStyle;
        public String success;
        public int successStyle;
        public String top;

        public Task(String str, String str2) {
            this.top = str;
            this.bottom = str2;
        }
    }

    public HashMap<String, Object> getExtension() {
        return this.logDataMap;
    }

    public boolean parse(JSONObject jSONObject, JSONObject jSONObject2) {
        return TaskParseHelper.parse(this, jSONObject, jSONObject2);
    }
}
