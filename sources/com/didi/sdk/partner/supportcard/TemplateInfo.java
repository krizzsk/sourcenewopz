package com.didi.sdk.partner.supportcard;

public class TemplateInfo {

    /* renamed from: a */
    private String f36877a;

    /* renamed from: b */
    private String f36878b;

    /* renamed from: c */
    private Class<ITemplateView> f36879c;

    public TemplateInfo(String str, String str2, Class cls) {
        this.f36877a = str;
        this.f36878b = str2;
        this.f36879c = cls;
    }

    public String getId() {
        return this.f36877a;
    }

    public void setId(String str) {
        this.f36877a = str;
    }

    public String getTemplate_name() {
        return this.f36878b;
    }

    public void setTemplate_name(String str) {
        this.f36878b = str;
    }

    public Class<ITemplateView> getTemplate_view() {
        return this.f36879c;
    }

    public void setTemplate_view(Class<ITemplateView> cls) {
        this.f36879c = cls;
    }
}
