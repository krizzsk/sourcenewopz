package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.didi.soda.blocks.entity.Template;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.NoMoreLoginEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressPageListEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class HomeFeedEntity implements IEntity {
    private static final long serialVersionUID = 425545805577192710L;
    @SerializedName("feedSuspendBall")
    public HomeFeedSuspendBallEntity homeFeedSuspendBallEntity;
    @SerializedName("addressInfo")
    public HomeAddressEntity mAddressInfo;
    @SerializedName("addressListPage")
    public AddressPageListEntity mAddressListInfo;
    @SerializedName("componentList")
    public List<ComponentEntity> mComponentList;
    @SerializedName("filterList")
    public List<FilterEntity> mFilterList;
    @SerializedName("signIn")
    public NoMoreLoginEntity mFooterLoginEntity;
    @SerializedName("hasMore")
    public boolean mHasMore;
    @SerializedName("nativePage")
    public NativePageInfoEntity mNativePageInfo;
    @SerializedName("recId")
    public String mRecId;
    @SerializedName("templates")
    public ArrayList<Template> mTemplates;
}
