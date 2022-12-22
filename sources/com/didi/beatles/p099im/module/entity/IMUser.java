package com.didi.beatles.p099im.module.entity;

import com.didi.beatles.p099im.api.entity.IMGetUserInfoResponse;
import com.didi.beatles.p099im.p100db.entity.IMUserDaoEntity;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.module.entity.IMUser */
public class IMUser implements Serializable {
    public static final int IN_GROUP = 0;
    public static final int NOT_IN_GROUP = 1;
    private IMUserDaoEntity entity;
    private IMGetUserInfoResponse.UserExtendInfo mUserExtendInfo;

    public long getUid() {
        return this.entity.getUser_id();
    }

    public void setUid(long j) {
        this.entity.setUser_id(j);
    }

    public String getNickName() {
        return this.entity.getUser_name();
    }

    public void setNickName(String str) {
        this.entity.setUser_name(str);
    }

    public String getAvatarUrl() {
        return this.entity.getAvatar_url();
    }

    public void setAvatarUrl(String str) {
        this.entity.setAvatar_url(str);
    }

    public void setMIcon(int i) {
        this.entity.setM_icon(i);
    }

    public int getMIcon() {
        return this.entity.getM_icon();
    }

    public IMGetUserInfoResponse.UserExtendInfo getExtendInfo() {
        return this.mUserExtendInfo;
    }

    public void setExtendInfo(String str) {
        this.entity.setReserveStr1(str);
        resolveExtendInfo();
    }

    public IMUserDaoEntity getEntity() {
        this.entity.setReserveStr1(IMJsonUtil.jsonFromObject(this.mUserExtendInfo));
        return this.entity;
    }

    public void setEntity(IMUserDaoEntity iMUserDaoEntity) {
        this.entity = iMUserDaoEntity;
        resolveExtendInfo();
    }

    public IMUser(IMUserDaoEntity iMUserDaoEntity) {
        this.entity = iMUserDaoEntity;
        resolveExtendInfo();
    }

    private void resolveExtendInfo() {
        IMUserDaoEntity iMUserDaoEntity = this.entity;
        if (iMUserDaoEntity != null) {
            this.mUserExtendInfo = (IMGetUserInfoResponse.UserExtendInfo) IMJsonUtil.objectFromJson(iMUserDaoEntity.getReserveStr1(), IMGetUserInfoResponse.UserExtendInfo.class);
        }
    }

    public String getUserTag() {
        IMGetUserInfoResponse.UserExtendInfo userExtendInfo = this.mUserExtendInfo;
        if (userExtendInfo != null) {
            return userExtendInfo.tag;
        }
        return null;
    }

    public void setStatus(int i) {
        IMGetUserInfoResponse.UserExtendInfo userExtendInfo = this.mUserExtendInfo;
        if (userExtendInfo != null) {
            userExtendInfo.status = i;
        }
    }

    public boolean isInGroup() {
        IMGetUserInfoResponse.UserExtendInfo userExtendInfo = this.mUserExtendInfo;
        if (userExtendInfo == null || userExtendInfo.status != 0) {
            return false;
        }
        return true;
    }

    public IMUser() {
        this.entity = new IMUserDaoEntity();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            IMUser iMUser = (IMUser) obj;
            if (this.entity == null && iMUser.getEntity() == null) {
                return true;
            }
            if (this.entity == null || iMUser.getEntity() == null || this.entity.getUser_id() != iMUser.getEntity().getUser_id() || !isSame(this.entity.getAvatar_url(), iMUser.getEntity().getAvatar_url())) {
                return false;
            }
            return isSame(this.entity.getUser_name(), iMUser.getEntity().getUser_name());
        }
        return false;
    }

    private static boolean isSame(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public int hashCode() {
        if (this.entity == null) {
            return super.hashCode();
        }
        int i = 0;
        int uid = ((((int) (getUid() ^ (getUid() >>> 32))) * 31) + (getNickName() != null ? getNickName().hashCode() : 0)) * 31;
        if (getAvatarUrl() != null) {
            i = getAvatarUrl().hashCode();
        }
        return uid + i;
    }
}
