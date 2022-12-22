package com.didiglobal.enginecore.template.temp;

import java.util.Objects;

public class XETemplateComponent {

    /* renamed from: a */
    private Class<? extends IXEView> f50200a;

    /* renamed from: b */
    private Class<? extends IXEViewModel> f50201b;

    /* renamed from: c */
    private String f50202c;

    public XETemplateComponent(String str, Class<? extends IXEView> cls, Class<? extends IXEViewModel> cls2) {
        this.f50200a = cls;
        this.f50201b = cls2;
        this.f50202c = str;
    }

    public Class<? extends IXEView> getViewClass() {
        return this.f50200a;
    }

    public Class<? extends IXEViewModel> getModelClass() {
        return this.f50201b;
    }

    public String getTemplateId() {
        return this.f50202c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f50202c, ((XETemplateComponent) obj).f50202c);
    }
}
