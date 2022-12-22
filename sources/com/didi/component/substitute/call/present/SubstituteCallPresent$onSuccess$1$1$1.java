package com.didi.component.substitute.call.present;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.substitute.call.model.ErrorObject;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import com.didi.travel.psnger.model.response.estimate.daijiao.SubstituteCallModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/component/substitute/call/present/SubstituteCallPresent$onSuccess$1$1$1", "Lcom/didi/component/common/util/GsonUtils$OnFromJsonListener;", "Lcom/didi/travel/psnger/model/response/estimate/daijiao/SubstituteCallModel;", "onFail", "", "onSuccess", "data", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteCallPresent.kt */
public final class SubstituteCallPresent$onSuccess$1$1$1 implements GsonUtils.OnFromJsonListener<SubstituteCallModel> {
    final /* synthetic */ SubstituteCallPresent this$0;

    SubstituteCallPresent$onSuccess$1$1$1(SubstituteCallPresent substituteCallPresent) {
        this.this$0 = substituteCallPresent;
    }

    public void onSuccess(SubstituteCallModel substituteCallModel) {
        if (substituteCallModel != null) {
            SubstituteCallPresent substituteCallPresent = this.this$0;
            if (substituteCallPresent.f16086a == 1) {
                ErrorObject errorObject = new ErrorObject();
                errorObject.setErrno(substituteCallModel.getErrno());
                errorObject.setErrmsg(substituteCallModel.getErrmsg());
                substituteCallPresent.doPublish(BaseEventKeys.Confirm.EVENT_SUBSTITUTE_CALL_REFRESH, errorObject);
            }
            if (substituteCallModel.getErrno() == 0) {
                FormStore.getInstance().setSubstituteCallModel(substituteCallModel);
                if (substituteCallPresent.f16086a == 2 && substituteCallModel.getAddAnother() != null) {
                    substituteCallPresent.doPublish(BaseEventKeys.Confirm.EVENT_SUBSTITUTE_CALL_REFRESH_HISTORY_NUM);
                }
                List<FriendItem> friendItems = substituteCallModel.getFriendItems();
                if (friendItems != null) {
                    if (!friendItems.isEmpty()) {
                        FormStore.getInstance().setSubstituteCallIcon(substituteCallModel.getDefaultIcon());
                        FormStore.getInstance().setSubstituteCallText(substituteCallModel.getDefaultText());
                    }
                    if (substituteCallPresent.f16086a == 1 && friendItems.size() > 1) {
                        FormStore.getInstance().setSubstituteCallIcon(friendItems.get(1).getPortrait());
                        FormStore.getInstance().setSubstituteCallText(friendItems.get(1).getName());
                        FormStore.getInstance().setSelectedFriend(friendItems.get(1));
                    }
                    FriendItem selectedFriend = FormStore.getInstance().getSelectedFriend();
                    if (selectedFriend != null) {
                        Iterator<FriendItem> it = friendItems.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            FriendItem next = it.next();
                            if (selectedFriend.getFriendId() != 0 && next.getFriendId() == selectedFriend.getFriendId()) {
                                FormStore.getInstance().setSubstituteCallIcon(next.getPortrait());
                                FormStore.getInstance().setSubstituteCallText(next.getName());
                                break;
                            }
                        }
                    }
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_FORM_ITEM_CHANGE);
                }
            } else {
                substituteCallPresent.m11803b();
                return;
            }
        }
        this.this$0.m11803b();
    }

    public void onFail() {
        this.this$0.m11803b();
    }
}
