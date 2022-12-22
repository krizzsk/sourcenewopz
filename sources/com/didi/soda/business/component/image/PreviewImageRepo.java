package com.didi.soda.business.component.image;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.business.component.home.PreviewImageModel;

public class PreviewImageRepo extends Repo<PreviewImageModel> {
    public void clickAdd(PreviewImageModel previewImageModel) {
        setValue(previewImageModel);
    }

    public Subscription subscribe(ScopeContext scopeContext, Action<PreviewImageModel> action) {
        return from().shutViscidityNotice().subscribe(scopeContext, action);
    }
}
