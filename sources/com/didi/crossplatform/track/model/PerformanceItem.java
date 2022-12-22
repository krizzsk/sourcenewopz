package com.didi.crossplatform.track.model;

import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import org.json.JSONObject;

public class PerformanceItem {
    public String category;
    public String name;
    public String unit;
    public Object value;

    public JSONObject parseJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("var", this.category);
            jSONObject.put("name", this.name);
            jSONObject.put("value", this.value);
            jSONObject.put("unit", this.unit);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public enum CommonIndicator {
        FS_RENDER_TIME("fsRenderTime", "首屏渲染时间", "ms"),
        JS_FIRST_EXEC_TIME("jsFirstExecTime", "JS解析时间", "ms"),
        INTERACTION_TIME(DiminaTraceService.MAS_MONITOR_EVENT.VALUE.INTERACTION_TIME, "可交互时间", "ms"),
        JS_TEMPLATE_SIZE("jsTemplateSize", "JS文件大小", "kb"),
        PAGE_VIEW("pageView", "页面展示", ""),
        PAGE_SUCCESS("pageSuccess", "页面展示成功", "");
        
        private String category;
        private String name;
        private String unit;

        private CommonIndicator(String str, String str2, String str3) {
            this.category = str;
            this.name = str2;
            this.unit = str3;
        }

        public String getCategory() {
            return this.category;
        }

        public String getName() {
            return this.name;
        }

        public String getUnit() {
            return this.unit;
        }
    }
}
