package com.didi.usercenter.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UserInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {
        public UserInfo createFromParcel(Parcel parcel) {
            return new UserInfo(parcel);
        }

        public UserInfo[] newArray(int i) {
            return new UserInfo[i];
        }
    };
    public static final String NEED_POP_LAW = "0";
    protected String age;
    protected String auth_desc;
    protected String auth_state;
    protected String avatar;
    @SerializedName("cardid_gender")
    protected String cardidGender;
    protected String carinfo;
    protected String circleLevelIconUrl;
    protected String corp;
    protected String country_code;
    protected String driver_auth_state;
    protected String email;
    protected String employ;
    protected String errmsg;
    protected int errno;
    protected String first_name;
    protected String gender;
    @SerializedName("level_info")
    protected GradeInfo gradeInfo;
    protected String head_url;
    protected String lang;
    protected String last_name;
    protected int level;
    protected String levelDes;
    protected String levelIcon;
    protected String levelName;
    protected String nick;
    protected String nickname;
    protected String phone;
    protected String pid;
    protected String pin;
    @SerializedName("pop_law")
    protected String popLaw;
    protected String sign;
    protected String trade;
    protected String userLevelURL;
    protected int user_type;

    public int describeContents() {
        return 0;
    }

    public UserInfo() {
    }

    protected UserInfo(Parcel parcel) {
        this.errno = parcel.readInt();
        this.errmsg = parcel.readString();
        this.level = parcel.readInt();
        this.levelName = parcel.readString();
        this.phone = parcel.readString();
        this.levelIcon = parcel.readString();
        this.circleLevelIconUrl = parcel.readString();
        this.pid = parcel.readString();
        this.userLevelURL = parcel.readString();
        this.nick = parcel.readString();
        this.nickname = parcel.readString();
        this.auth_state = parcel.readString();
        this.auth_desc = parcel.readString();
        this.avatar = parcel.readString();
        this.head_url = parcel.readString();
        this.gender = parcel.readString();
        this.trade = parcel.readString();
        this.corp = parcel.readString();
        this.employ = parcel.readString();
        this.sign = parcel.readString();
        this.age = parcel.readString();
        this.carinfo = parcel.readString();
        this.driver_auth_state = parcel.readString();
        this.lang = parcel.readString();
        this.levelDes = parcel.readString();
        this.country_code = parcel.readString();
        this.first_name = parcel.readString();
        this.last_name = parcel.readString();
        this.email = parcel.readString();
        this.popLaw = parcel.readString();
        this.pin = parcel.readString();
        this.cardidGender = parcel.readString();
        this.user_type = parcel.readInt();
        this.gradeInfo = (GradeInfo) parcel.readParcelable(GradeInfo.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.errno);
        parcel.writeString(this.errmsg);
        parcel.writeInt(this.level);
        parcel.writeString(this.levelName);
        parcel.writeString(this.phone);
        parcel.writeString(this.levelIcon);
        parcel.writeString(this.circleLevelIconUrl);
        parcel.writeString(this.pid);
        parcel.writeString(this.userLevelURL);
        parcel.writeString(this.nick);
        parcel.writeString(this.nickname);
        parcel.writeString(this.auth_state);
        parcel.writeString(this.auth_desc);
        parcel.writeString(this.avatar);
        parcel.writeString(this.head_url);
        parcel.writeString(this.gender);
        parcel.writeString(this.trade);
        parcel.writeString(this.corp);
        parcel.writeString(this.employ);
        parcel.writeString(this.sign);
        parcel.writeString(this.age);
        parcel.writeString(this.carinfo);
        parcel.writeString(this.driver_auth_state);
        parcel.writeString(this.lang);
        parcel.writeString(this.levelDes);
        parcel.writeString(this.country_code);
        parcel.writeString(this.first_name);
        parcel.writeString(this.last_name);
        parcel.writeString(this.email);
        parcel.writeString(this.popLaw);
        parcel.writeString(this.pin);
        parcel.writeString(this.cardidGender);
        parcel.writeInt(this.user_type);
        parcel.writeParcelable(this.gradeInfo, i);
    }

    public int getErrno() {
        return this.errno;
    }

    public void setErrno(int i) {
        this.errno = i;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String str) {
        this.errmsg = str;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public String getLevelName() {
        return this.levelName;
    }

    public void setLevelName(String str) {
        this.levelName = str;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String getLevelIcon() {
        return this.levelIcon;
    }

    public String getCircleLevelIconUrl() {
        return this.circleLevelIconUrl;
    }

    public void setCircleLevelIconUrl(String str) {
        this.circleLevelIconUrl = str;
    }

    public void setLevelIcon(String str) {
        this.levelIcon = str;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public String getUserLevelURL() {
        return this.userLevelURL;
    }

    public void setUserLevelURL(String str) {
        this.userLevelURL = str;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String str) {
        this.nick = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getAuth_state() {
        return this.auth_state;
    }

    public void setAuth_state(String str) {
        this.auth_state = str;
    }

    public String getAuth_desc() {
        return this.auth_desc;
    }

    public void setAuth_desc(String str) {
        this.auth_desc = str;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public String getTrade() {
        return this.trade;
    }

    public void setTrade(String str) {
        this.trade = str;
    }

    public String getCorp() {
        return this.corp;
    }

    public void setCorp(String str) {
        this.corp = str;
    }

    public String getEmploy() {
        return this.employ;
    }

    public void setEmploy(String str) {
        this.employ = str;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String str) {
        this.age = str;
    }

    public String getCarinfo() {
        return this.carinfo;
    }

    public void setCarinfo(String str) {
        this.carinfo = str;
    }

    public String getHead_url() {
        return this.head_url;
    }

    public void setHead_url(String str) {
        this.head_url = str;
    }

    public String getDriver_auth_state() {
        return this.driver_auth_state;
    }

    public void setDriver_auth_state(String str) {
        this.driver_auth_state = str;
    }

    public void setLevelDes(String str) {
        this.levelDes = str;
    }

    public String getLevelDes() {
        return this.levelDes;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public String getCountry_code() {
        return this.country_code;
    }

    public void setCountry_code(String str) {
        this.country_code = str;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public UserInfo setFirst_name(String str) {
        this.first_name = str;
        return this;
    }

    public UserInfo setLast_name(String str) {
        this.last_name = str;
        return this;
    }

    public UserInfo setEmail(String str) {
        this.email = str;
        return this;
    }

    public String getPopLaw() {
        return this.popLaw;
    }

    public UserInfo setPopLaw(String str) {
        this.popLaw = str;
        return this;
    }

    public String getPin() {
        return this.pin;
    }

    public UserInfo setPin(String str) {
        this.pin = str;
        return this;
    }

    public String getCardidGender() {
        return this.cardidGender;
    }

    public UserInfo setCardidGender(String str) {
        this.cardidGender = str;
        return this;
    }

    public int getUserType() {
        return this.user_type;
    }

    public void setUserType(int i) {
        this.user_type = i;
    }

    public GradeInfo getGradeInfo() {
        return this.gradeInfo;
    }

    public void setGradeInfo(GradeInfo gradeInfo2) {
        this.gradeInfo = gradeInfo2;
    }

    public String toString() {
        return "UserInfo{errno=" + this.errno + ", errmsg='" + this.errmsg + '\'' + ", level=" + this.level + ", levelName='" + this.levelName + '\'' + ", phone='" + this.phone + '\'' + ", levelIcon='" + this.levelIcon + '\'' + ", circleLevelIconUrl='" + this.circleLevelIconUrl + '\'' + ", pid='" + this.pid + '\'' + ", userLevelURL='" + this.userLevelURL + '\'' + ", nick='" + this.nick + '\'' + ", nickname='" + this.nickname + '\'' + ", auth_state='" + this.auth_state + '\'' + ", auth_desc='" + this.auth_desc + '\'' + ", avatar='" + this.avatar + '\'' + ", head_url='" + this.head_url + '\'' + ", gender='" + this.gender + '\'' + ", trade='" + this.trade + '\'' + ", corp='" + this.corp + '\'' + ", employ='" + this.employ + '\'' + ", sign='" + this.sign + '\'' + ", age='" + this.age + '\'' + ", carinfo='" + this.carinfo + '\'' + ", driver_auth_state='" + this.driver_auth_state + '\'' + ", lang='" + this.lang + '\'' + ", levelDes='" + this.levelDes + '\'' + ", countryCode='" + this.country_code + '\'' + ", first_name='" + this.first_name + '\'' + ", last_name='" + this.last_name + '\'' + ", email='" + this.email + '\'' + ", popLaw='" + this.popLaw + '\'' + ", pin='" + this.pin + '\'' + ", cardidGender='" + this.cardidGender + '\'' + ", user_type=" + this.user_type + ", gradeInfo=" + this.gradeInfo + '}';
    }

    public String writeToLog() {
        return "UserInfo{errno=" + this.errno + ", errmsg='" + this.errmsg + '\'' + ", phone='" + this.phone + '\'' + ", nickname='" + this.nickname + '\'' + '}';
    }
}
