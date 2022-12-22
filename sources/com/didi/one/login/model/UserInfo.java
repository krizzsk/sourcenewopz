package com.didi.one.login.model;

public class UserInfo extends com.didi.usercenter.entity.UserInfo {
    public static UserInfo getUserInfo(com.didi.usercenter.entity.UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }
        UserInfo userInfo2 = new UserInfo();
        userInfo2.errno = userInfo.getErrno();
        userInfo2.errmsg = userInfo.getErrmsg();
        userInfo2.level = userInfo.getLevel();
        userInfo2.levelName = userInfo.getLevelName();
        userInfo2.phone = userInfo.getPhone();
        userInfo2.levelIcon = userInfo.getLevelIcon();
        userInfo2.circleLevelIconUrl = userInfo.getCircleLevelIconUrl();
        userInfo2.pid = userInfo.getPid();
        userInfo2.userLevelURL = userInfo.getUserLevelURL();
        userInfo2.nick = userInfo.getNick();
        userInfo2.nickname = userInfo.getNickname();
        userInfo2.auth_state = userInfo.getAuth_state();
        userInfo2.auth_desc = userInfo.getAuth_desc();
        userInfo2.avatar = userInfo.getAvatar();
        userInfo2.head_url = userInfo.getHead_url();
        userInfo2.gender = userInfo.getGender();
        userInfo2.trade = userInfo.getTrade();
        userInfo2.corp = userInfo.getCorp();
        userInfo2.employ = userInfo.getEmploy();
        userInfo2.sign = userInfo.getSign();
        userInfo2.age = userInfo.getAge();
        userInfo2.carinfo = userInfo.getCarinfo();
        userInfo2.driver_auth_state = userInfo.getDriver_auth_state();
        userInfo2.lang = userInfo.getLang();
        userInfo2.levelDes = userInfo.getLevelDes();
        userInfo2.first_name = userInfo.getFirst_name();
        userInfo2.last_name = userInfo.getLast_name();
        userInfo2.email = userInfo.getEmail();
        userInfo2.popLaw = userInfo.getPopLaw();
        userInfo2.pin = userInfo.getPin();
        userInfo2.cardidGender = userInfo.getCardidGender();
        userInfo2.gradeInfo = userInfo.getGradeInfo();
        return userInfo2;
    }
}
