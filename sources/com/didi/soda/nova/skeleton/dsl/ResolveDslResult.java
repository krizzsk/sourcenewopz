package com.didi.soda.nova.skeleton.dsl;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.List;

public final class ResolveDslResult {
    public List<CompEntry> components;
    public int layoutId;
    public DslIView logicView;
    public DslIPresenter presenter;
    public List<Class> repos;
    public String[] routePath;
    public String tag;
    public int titleStrId;
    public String titleString;
    public List<ViewModelEntry> viewModels;

    public static final class CompEntry {
        public Class<? extends DslComponent> clazz;
        public int containerId;
        public String tag;

        public CompEntry(Class<? extends DslComponent> cls, int i, String str) {
            this.clazz = cls;
            this.containerId = i;
            this.tag = str;
        }
    }

    public static final class ViewModelEntry {
        public Class<? extends DslViewModel> clazz;
        public String variableId;

        public ViewModelEntry(Class<? extends DslViewModel> cls, String str) {
            this.clazz = cls;
            this.variableId = str;
        }
    }

    public String toString() {
        return "PageDslInfo@" + hashCode() + Const.joLeft + "tag:" + this.tag + "," + "titleStrId:" + this.titleStrId + "," + "titleString:" + this.titleString + "," + "layoutId:" + this.layoutId + "," + "repos:" + this.repos + "," + "components:" + this.components + "," + "viewModels:" + this.components + "," + "}";
    }
}
