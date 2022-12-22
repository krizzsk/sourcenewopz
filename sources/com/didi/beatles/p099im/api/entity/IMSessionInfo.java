package com.didi.beatles.p099im.api.entity;

import com.didi.beatles.p099im.api.entity.IMGetUserInfoResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMSessionInfo */
public class IMSessionInfo implements Serializable {
    public int enable;
    public IMSessionExtendInfo extend;
    public GroupInfo group;
    public String img;
    public String name;
    public long oid;
    public int product;
    public long sid;
    public int sty;
    public IMTopOperationBody tip;
    public String tip_fol;
    public String tip_txt;
    public List<UserInfo> users = new ArrayList();

    /* renamed from: com.didi.beatles.im.api.entity.IMSessionInfo$UserInfo */
    public class UserInfo implements Serializable {
        public IMGetUserInfoResponse.UserExtendInfo extend;
        public String img;
        public int m_icon;
        public String nick;
        public long uid;

        public UserInfo() {
        }
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMSessionInfo$GroupInfo */
    public class GroupInfo implements Serializable {
        public long creator;
        public long ctime;
        public String img;
        public String name;

        public GroupInfo() {
        }
    }
}
