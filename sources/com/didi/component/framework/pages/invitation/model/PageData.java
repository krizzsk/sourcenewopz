package com.didi.component.framework.pages.invitation.model;

import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\fHÆ\u0003J)\u0010G\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0010HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u000fHÆ\u0003J¥\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2(\b\u0002\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001J\u0013\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020PHÖ\u0001J\t\u0010Q\u001a\u00020\u000fHÖ\u0001R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R:\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006R"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/PageData;", "", "redirectModel", "Lcom/didi/component/framework/pages/invitation/model/RedirectModel;", "rewardModel", "Lcom/didi/component/framework/pages/invitation/model/RewardModel;", "shareChannelVoList", "", "Lcom/didi/component/framework/pages/invitation/model/ShareChannelVo;", "shareUrlModel", "Lcom/didi/component/framework/pages/invitation/model/ShareUrlModel;", "inviteCode", "Lcom/didi/component/framework/pages/invitation/model/InviteCode;", "logParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "lunboConfig", "Lcom/didi/component/framework/pages/invitation/model/LunBoConfig;", "experimentControl", "Lcom/didi/component/framework/pages/invitation/model/ExperimentControl;", "bannerPic", "addressBookAuthorization", "Lcom/didi/component/framework/pages/invitation/model/AddressBookAuthorization;", "(Lcom/didi/component/framework/pages/invitation/model/RedirectModel;Lcom/didi/component/framework/pages/invitation/model/RewardModel;Ljava/util/List;Lcom/didi/component/framework/pages/invitation/model/ShareUrlModel;Lcom/didi/component/framework/pages/invitation/model/InviteCode;Ljava/util/HashMap;Lcom/didi/component/framework/pages/invitation/model/LunBoConfig;Lcom/didi/component/framework/pages/invitation/model/ExperimentControl;Ljava/lang/String;Lcom/didi/component/framework/pages/invitation/model/AddressBookAuthorization;)V", "getAddressBookAuthorization", "()Lcom/didi/component/framework/pages/invitation/model/AddressBookAuthorization;", "setAddressBookAuthorization", "(Lcom/didi/component/framework/pages/invitation/model/AddressBookAuthorization;)V", "getBannerPic", "()Ljava/lang/String;", "setBannerPic", "(Ljava/lang/String;)V", "getExperimentControl", "()Lcom/didi/component/framework/pages/invitation/model/ExperimentControl;", "setExperimentControl", "(Lcom/didi/component/framework/pages/invitation/model/ExperimentControl;)V", "getInviteCode", "()Lcom/didi/component/framework/pages/invitation/model/InviteCode;", "setInviteCode", "(Lcom/didi/component/framework/pages/invitation/model/InviteCode;)V", "getLogParams", "()Ljava/util/HashMap;", "setLogParams", "(Ljava/util/HashMap;)V", "getLunboConfig", "()Lcom/didi/component/framework/pages/invitation/model/LunBoConfig;", "setLunboConfig", "(Lcom/didi/component/framework/pages/invitation/model/LunBoConfig;)V", "getRedirectModel", "()Lcom/didi/component/framework/pages/invitation/model/RedirectModel;", "setRedirectModel", "(Lcom/didi/component/framework/pages/invitation/model/RedirectModel;)V", "getRewardModel", "()Lcom/didi/component/framework/pages/invitation/model/RewardModel;", "setRewardModel", "(Lcom/didi/component/framework/pages/invitation/model/RewardModel;)V", "getShareChannelVoList", "()Ljava/util/List;", "setShareChannelVoList", "(Ljava/util/List;)V", "getShareUrlModel", "()Lcom/didi/component/framework/pages/invitation/model/ShareUrlModel;", "setShareUrlModel", "(Lcom/didi/component/framework/pages/invitation/model/ShareUrlModel;)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitePageModel.kt */
public final class PageData {
    private AddressBookAuthorization addressBookAuthorization;
    private String bannerPic;
    private ExperimentControl experimentControl;
    private InviteCode inviteCode;
    private HashMap<String, Object> logParams;
    private LunBoConfig lunboConfig;
    private RedirectModel redirectModel;
    private RewardModel rewardModel;
    private List<ShareChannelVo> shareChannelVoList;
    private ShareUrlModel shareUrlModel;

    public static /* synthetic */ PageData copy$default(PageData pageData, RedirectModel redirectModel2, RewardModel rewardModel2, List list, ShareUrlModel shareUrlModel2, InviteCode inviteCode2, HashMap hashMap, LunBoConfig lunBoConfig, ExperimentControl experimentControl2, String str, AddressBookAuthorization addressBookAuthorization2, int i, Object obj) {
        PageData pageData2 = pageData;
        int i2 = i;
        return pageData.copy((i2 & 1) != 0 ? pageData2.redirectModel : redirectModel2, (i2 & 2) != 0 ? pageData2.rewardModel : rewardModel2, (i2 & 4) != 0 ? pageData2.shareChannelVoList : list, (i2 & 8) != 0 ? pageData2.shareUrlModel : shareUrlModel2, (i2 & 16) != 0 ? pageData2.inviteCode : inviteCode2, (i2 & 32) != 0 ? pageData2.logParams : hashMap, (i2 & 64) != 0 ? pageData2.lunboConfig : lunBoConfig, (i2 & 128) != 0 ? pageData2.experimentControl : experimentControl2, (i2 & 256) != 0 ? pageData2.bannerPic : str, (i2 & 512) != 0 ? pageData2.addressBookAuthorization : addressBookAuthorization2);
    }

    public final RedirectModel component1() {
        return this.redirectModel;
    }

    public final AddressBookAuthorization component10() {
        return this.addressBookAuthorization;
    }

    public final RewardModel component2() {
        return this.rewardModel;
    }

    public final List<ShareChannelVo> component3() {
        return this.shareChannelVoList;
    }

    public final ShareUrlModel component4() {
        return this.shareUrlModel;
    }

    public final InviteCode component5() {
        return this.inviteCode;
    }

    public final HashMap<String, Object> component6() {
        return this.logParams;
    }

    public final LunBoConfig component7() {
        return this.lunboConfig;
    }

    public final ExperimentControl component8() {
        return this.experimentControl;
    }

    public final String component9() {
        return this.bannerPic;
    }

    public final PageData copy(RedirectModel redirectModel2, RewardModel rewardModel2, List<ShareChannelVo> list, ShareUrlModel shareUrlModel2, InviteCode inviteCode2, HashMap<String, Object> hashMap, LunBoConfig lunBoConfig, ExperimentControl experimentControl2, String str, AddressBookAuthorization addressBookAuthorization2) {
        return new PageData(redirectModel2, rewardModel2, list, shareUrlModel2, inviteCode2, hashMap, lunBoConfig, experimentControl2, str, addressBookAuthorization2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageData)) {
            return false;
        }
        PageData pageData = (PageData) obj;
        return Intrinsics.areEqual((Object) this.redirectModel, (Object) pageData.redirectModel) && Intrinsics.areEqual((Object) this.rewardModel, (Object) pageData.rewardModel) && Intrinsics.areEqual((Object) this.shareChannelVoList, (Object) pageData.shareChannelVoList) && Intrinsics.areEqual((Object) this.shareUrlModel, (Object) pageData.shareUrlModel) && Intrinsics.areEqual((Object) this.inviteCode, (Object) pageData.inviteCode) && Intrinsics.areEqual((Object) this.logParams, (Object) pageData.logParams) && Intrinsics.areEqual((Object) this.lunboConfig, (Object) pageData.lunboConfig) && Intrinsics.areEqual((Object) this.experimentControl, (Object) pageData.experimentControl) && Intrinsics.areEqual((Object) this.bannerPic, (Object) pageData.bannerPic) && Intrinsics.areEqual((Object) this.addressBookAuthorization, (Object) pageData.addressBookAuthorization);
    }

    public int hashCode() {
        RedirectModel redirectModel2 = this.redirectModel;
        int i = 0;
        int hashCode = (redirectModel2 == null ? 0 : redirectModel2.hashCode()) * 31;
        RewardModel rewardModel2 = this.rewardModel;
        int hashCode2 = (hashCode + (rewardModel2 == null ? 0 : rewardModel2.hashCode())) * 31;
        List<ShareChannelVo> list = this.shareChannelVoList;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        ShareUrlModel shareUrlModel2 = this.shareUrlModel;
        int hashCode4 = (hashCode3 + (shareUrlModel2 == null ? 0 : shareUrlModel2.hashCode())) * 31;
        InviteCode inviteCode2 = this.inviteCode;
        int hashCode5 = (hashCode4 + (inviteCode2 == null ? 0 : inviteCode2.hashCode())) * 31;
        HashMap<String, Object> hashMap = this.logParams;
        int hashCode6 = (hashCode5 + (hashMap == null ? 0 : hashMap.hashCode())) * 31;
        LunBoConfig lunBoConfig = this.lunboConfig;
        int hashCode7 = (hashCode6 + (lunBoConfig == null ? 0 : lunBoConfig.hashCode())) * 31;
        ExperimentControl experimentControl2 = this.experimentControl;
        int hashCode8 = (hashCode7 + (experimentControl2 == null ? 0 : experimentControl2.hashCode())) * 31;
        String str = this.bannerPic;
        int hashCode9 = (hashCode8 + (str == null ? 0 : str.hashCode())) * 31;
        AddressBookAuthorization addressBookAuthorization2 = this.addressBookAuthorization;
        if (addressBookAuthorization2 != null) {
            i = addressBookAuthorization2.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "PageData(redirectModel=" + this.redirectModel + ", rewardModel=" + this.rewardModel + ", shareChannelVoList=" + this.shareChannelVoList + ", shareUrlModel=" + this.shareUrlModel + ", inviteCode=" + this.inviteCode + ", logParams=" + this.logParams + ", lunboConfig=" + this.lunboConfig + ", experimentControl=" + this.experimentControl + ", bannerPic=" + this.bannerPic + ", addressBookAuthorization=" + this.addressBookAuthorization + VersionRange.RIGHT_OPEN;
    }

    public PageData(RedirectModel redirectModel2, RewardModel rewardModel2, List<ShareChannelVo> list, ShareUrlModel shareUrlModel2, InviteCode inviteCode2, HashMap<String, Object> hashMap, LunBoConfig lunBoConfig, ExperimentControl experimentControl2, String str, AddressBookAuthorization addressBookAuthorization2) {
        this.redirectModel = redirectModel2;
        this.rewardModel = rewardModel2;
        this.shareChannelVoList = list;
        this.shareUrlModel = shareUrlModel2;
        this.inviteCode = inviteCode2;
        this.logParams = hashMap;
        this.lunboConfig = lunBoConfig;
        this.experimentControl = experimentControl2;
        this.bannerPic = str;
        this.addressBookAuthorization = addressBookAuthorization2;
    }

    public final RedirectModel getRedirectModel() {
        return this.redirectModel;
    }

    public final void setRedirectModel(RedirectModel redirectModel2) {
        this.redirectModel = redirectModel2;
    }

    public final RewardModel getRewardModel() {
        return this.rewardModel;
    }

    public final void setRewardModel(RewardModel rewardModel2) {
        this.rewardModel = rewardModel2;
    }

    public final List<ShareChannelVo> getShareChannelVoList() {
        return this.shareChannelVoList;
    }

    public final void setShareChannelVoList(List<ShareChannelVo> list) {
        this.shareChannelVoList = list;
    }

    public final ShareUrlModel getShareUrlModel() {
        return this.shareUrlModel;
    }

    public final void setShareUrlModel(ShareUrlModel shareUrlModel2) {
        this.shareUrlModel = shareUrlModel2;
    }

    public final InviteCode getInviteCode() {
        return this.inviteCode;
    }

    public final void setInviteCode(InviteCode inviteCode2) {
        this.inviteCode = inviteCode2;
    }

    public final HashMap<String, Object> getLogParams() {
        return this.logParams;
    }

    public final void setLogParams(HashMap<String, Object> hashMap) {
        this.logParams = hashMap;
    }

    public final LunBoConfig getLunboConfig() {
        return this.lunboConfig;
    }

    public final void setLunboConfig(LunBoConfig lunBoConfig) {
        this.lunboConfig = lunBoConfig;
    }

    public final ExperimentControl getExperimentControl() {
        return this.experimentControl;
    }

    public final void setExperimentControl(ExperimentControl experimentControl2) {
        this.experimentControl = experimentControl2;
    }

    public final String getBannerPic() {
        return this.bannerPic;
    }

    public final void setBannerPic(String str) {
        this.bannerPic = str;
    }

    public final AddressBookAuthorization getAddressBookAuthorization() {
        return this.addressBookAuthorization;
    }

    public final void setAddressBookAuthorization(AddressBookAuthorization addressBookAuthorization2) {
        this.addressBookAuthorization = addressBookAuthorization2;
    }
}
