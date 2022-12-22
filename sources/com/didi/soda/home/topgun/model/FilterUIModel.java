package com.didi.soda.home.topgun.model;

import com.didi.soda.home.topgun.model.FilterModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/model/FilterUIModel;", "", "()V", "isMultipleChoice", "", "()Z", "setMultipleChoice", "(Z)V", "isSelected", "setSelected", "itemRvModel", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterItemRvModel;", "getItemRvModel", "()Lcom/didi/soda/home/topgun/model/FilterModel$FilterItemRvModel;", "setItemRvModel", "(Lcom/didi/soda/home/topgun/model/FilterModel$FilterItemRvModel;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterUIModel.kt */
public class FilterUIModel {
    private boolean isMultipleChoice;
    private boolean isSelected;
    private FilterModel.FilterItemRvModel itemRvModel;

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final boolean isMultipleChoice() {
        return this.isMultipleChoice;
    }

    public final void setMultipleChoice(boolean z) {
        this.isMultipleChoice = z;
    }

    public final FilterModel.FilterItemRvModel getItemRvModel() {
        return this.itemRvModel;
    }

    public final void setItemRvModel(FilterModel.FilterItemRvModel filterItemRvModel) {
        this.itemRvModel = filterItemRvModel;
    }
}
