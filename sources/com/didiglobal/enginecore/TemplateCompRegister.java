package com.didiglobal.enginecore;

import android.text.TextUtils;
import com.didiglobal.enginecore.register.EngineTemplateStore;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.enginecore.template.temp.XETemplateComponent;
import java.util.List;
import java.util.Set;

public class TemplateCompRegister {
    public static List<String> getTemplateKeyList() {
        return EngineTemplateStore.getInstance().getSortedList();
    }

    public static List<XETemplateComponent> getTemplateList() {
        return EngineTemplateStore.getInstance().getTemplateList();
    }

    public static Set<String> getRequiredTemplateSet(String str) {
        return EngineTemplateStore.getInstance().getRequiredMap(str);
    }

    public static Set<String> getRegisteredRequestKeysSet(String str) {
        return EngineTemplateStore.getInstance().getRequestkeysMap(str);
    }

    public static void registerTemplate(XERegisterModel xERegisterModel) {
        if (xERegisterModel != null && !TextUtils.isEmpty(xERegisterModel.requestKey)) {
            int i = xERegisterModel.priority;
            if (i <= 0) {
                i = (xERegisterModel.components == null || xERegisterModel.components.isEmpty()) ? 100 : 300;
            }
            EngineTemplateStore.getInstance().put(xERegisterModel.requestKey, xERegisterModel.components, xERegisterModel.scenes, i, xERegisterModel.required);
        }
    }

    public static void updateRequiredMapScene(String str, String... strArr) {
        EngineTemplateStore.getInstance().updateRequiredMapScene(str, strArr);
    }

    public static boolean setCompPriority(String str, int i) {
        return EngineTemplateStore.getInstance().setPriority(str, i);
    }

    public static void unregisterTemplate(String str) {
        if (!TextUtils.isEmpty(str)) {
            EngineTemplateStore.getInstance().remove(str);
        }
    }

    public static void unregisterAllTemplate() {
        EngineTemplateStore.getInstance().clear();
    }
}
