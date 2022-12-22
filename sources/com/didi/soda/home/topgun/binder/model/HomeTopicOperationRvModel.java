package com.didi.soda.home.topgun.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.TofuEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.topgun.widget.HomeTopicOperationView;
import java.util.ArrayList;
import java.util.List;

public class HomeTopicOperationRvModel implements RecyclerModel {
    public List<HomeTopicOperationView.TopicOperationItemModel> mTopicList;

    public static HomeTopicOperationRvModel convertTofuEntity(ComponentEntity componentEntity, FeedPayload feedPayload) {
        List<TofuEntity> list = componentEntity.mTofuList;
        HomeTopicOperationRvModel homeTopicOperationRvModel = new HomeTopicOperationRvModel();
        ArrayList arrayList = new ArrayList();
        for (TofuEntity next : list) {
            if (next != null) {
                arrayList.add(HomeTopicOperationView.TopicOperationItemModel.newInstance(componentEntity, next, feedPayload, list.indexOf(next) % 2));
            }
        }
        homeTopicOperationRvModel.mTopicList = arrayList;
        return homeTopicOperationRvModel;
    }
}
