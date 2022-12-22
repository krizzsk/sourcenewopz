package com.didichuxing.xpanel.global.models.taskoperation;

import android.content.Context;
import com.didichuxing.xpanel.global.models.taskoperation.TaskOperationData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TaskParseHelper {
    public static String KEY_ASSIT = "text1";
    public static String KEY_DATA = "data";
    public static String KEY_FINISH_COUNT = "number0";
    public static String KEY_LINK = "link0";
    public static String KEY_LINK_TITLE = "text4";
    public static String KEY_MAIN_TITLE = "text3";
    public static String KEY_NODE_LIST = "nodeList";
    public static String KEY_NODE_SHOW_STYLE = "style1";
    public static String KEY_NODE_SUCCESS_STYLE = "style0";
    public static String KEY_NODE_TASK_BOTTOM = "text2";
    public static String KEY_NODE_TASK_SUCCESS = "text1";
    public static String KEY_NODE_TASK_TOP = "text0";
    public static String KEY_TIP = "text2";
    public static String KEY_TITLE = "text0";

    public static boolean parse(TaskOperationData taskOperationData, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return false;
        }
        if (!jSONObject.isNull(KEY_ASSIT)) {
            taskOperationData.assit = jSONObject.optString(KEY_ASSIT, (String) null);
        }
        if (!jSONObject.isNull(KEY_TITLE)) {
            taskOperationData.title = jSONObject.optString(KEY_TITLE, (String) null);
        }
        if (!jSONObject.isNull(KEY_TIP)) {
            taskOperationData.tip = jSONObject.optString(KEY_TIP, (String) null);
        }
        if (!jSONObject.isNull(KEY_MAIN_TITLE)) {
            taskOperationData.mainTitle = jSONObject.optString(KEY_MAIN_TITLE, (String) null);
        }
        if (!jSONObject.isNull(KEY_LINK_TITLE)) {
            taskOperationData.linkTitle = jSONObject.optString(KEY_LINK_TITLE, (String) null);
        }
        if (!jSONObject.isNull(KEY_LINK)) {
            taskOperationData.link = jSONObject.optString(KEY_LINK, (String) null);
        }
        taskOperationData.finishCount = jSONObject.optInt(KEY_FINISH_COUNT, 0);
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_NODE_LIST);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject3 = (JSONObject) optJSONArray.get(i);
                    TaskOperationData.Task task = new TaskOperationData.Task(!jSONObject3.isNull(KEY_NODE_TASK_TOP) ? jSONObject3.optString(KEY_NODE_TASK_TOP, (String) null) : null, !jSONObject3.isNull(KEY_NODE_TASK_BOTTOM) ? jSONObject3.optString(KEY_NODE_TASK_BOTTOM, (String) null) : null);
                    task.successStyle = jSONObject3.optInt(KEY_NODE_SUCCESS_STYLE, 1);
                    task.showStyle = jSONObject3.optInt(KEY_NODE_SHOW_STYLE, 1);
                    if (!jSONObject3.isNull(KEY_NODE_TASK_SUCCESS)) {
                        task.success = jSONObject3.optString(KEY_NODE_TASK_SUCCESS, (String) null);
                    }
                    arrayList.add(task);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (taskOperationData.finishCount > arrayList.size() || arrayList.size() == 0) {
                return false;
            }
            taskOperationData.tasks = arrayList;
        }
        return true;
    }

    public static boolean isGlobal(Context context) {
        return context != null && context.getPackageName().startsWith("com.didiglobal.passenger");
    }
}
