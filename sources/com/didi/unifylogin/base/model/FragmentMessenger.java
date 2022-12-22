package com.didi.unifylogin.base.model;

import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.entity.PromptPageData;
import com.didi.unifylogin.base.net.pojo.response.AuthResponse;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.base.net.pojo.response.DeleteUserResponse;
import com.didi.unifylogin.base.net.pojo.response.GateKeeperResponse;
import com.didi.unifylogin.utils.LoginState;
import java.io.Serializable;
import java.util.List;
import java.util.Stack;

public class FragmentMessenger implements Serializable, Cloneable {
    public static LoginState nowState = LoginState.STATE_UNKNOWN;
    public static Stack<LoginScene> scenesStack = new Stack<>();
    private AuthResponse.AuthInfo authInfo;
    private String captchaCell;
    private String cell;
    private String channel;
    private String code;
    private int codeLength;
    private int codeType = 0;
    private String credential;
    private List<DeleteUserResponse.DeleteContent> deleteAccountFailTexts;
    private String deleteAccountFailedSubPromptTitle;
    private String deleteAccountFailedSubTitle;
    private List<String> deleteAccountReasons;
    private String email;
    private GateKeeperResponse.FaceDes faceDes;
    private String hideEmail;
    private String idNum;
    private String idtoken;
    private boolean isChangePhoneByID = false;
    private boolean isNeedBind;
    private int lackType;
    private long lastCodeMTTime;
    private String lastName;
    private String loginMethod;
    private String name;
    private String newCell;
    private CountryListResponse.CountryRule newCellCountry;
    private String newCode;
    private int newCodeType = 0;
    private String newEmail;
    private String newEmailCode;
    private LoginState nextState = null;
    private String password;
    private String prompt;
    private PromptPageData promptPageData;
    private LoginScene scene;
    private String sessionId;
    private String tempData;
    private String verifyCOdeKey;
    private boolean voiceSupport = true;

    public long getLastCodeMTTime() {
        return this.lastCodeMTTime;
    }

    public void setLastCodeMTTime(long j) {
        this.lastCodeMTTime = j;
    }

    public String getVerifyCOdeKey() {
        return this.verifyCOdeKey;
    }

    public void setVerifyCOdeKey(String str) {
        this.verifyCOdeKey = str;
    }

    public FragmentMessenger setCell(String str) {
        this.cell = str;
        return this;
    }

    public FragmentMessenger setCode(String str) {
        this.code = str;
        return this;
    }

    public FragmentMessenger setPassword(String str) {
        this.password = str;
        return this;
    }

    public FragmentMessenger setScene(LoginScene loginScene) {
        this.scene = loginScene;
        return this;
    }

    public FragmentMessenger updateOmegaScene(LoginScene loginScene) {
        scenesStack.push(loginScene);
        return this;
    }

    public FragmentMessenger setNewCell(String str) {
        this.newCell = str;
        return this;
    }

    public CountryListResponse.CountryRule getNewCellCountry() {
        return this.newCellCountry;
    }

    public FragmentMessenger setNewCellCountry(CountryListResponse.CountryRule countryRule) {
        this.newCellCountry = countryRule;
        return this;
    }

    public FragmentMessenger setNewCode(String str) {
        this.newCode = str;
        return this;
    }

    public FragmentMessenger setNextState(LoginState loginState) {
        this.nextState = loginState;
        return this;
    }

    public FragmentMessenger setPrompt(String str) {
        this.prompt = str;
        return this;
    }

    public FragmentMessenger setCaptchaCell(String str) {
        this.captchaCell = str;
        return this;
    }

    public FragmentMessenger setCodeType(int i) {
        this.codeType = i;
        return this;
    }

    public FragmentMessenger setHideEmail(String str) {
        this.hideEmail = str;
        return this;
    }

    public FragmentMessenger setLackType(int i) {
        this.lackType = i;
        return this;
    }

    public FragmentMessenger setNewCodeType(int i) {
        this.newCodeType = i;
        return this;
    }

    public FragmentMessenger setName(String str) {
        this.name = str;
        return this;
    }

    public FragmentMessenger setLastName(String str) {
        this.lastName = str;
        return this;
    }

    public FragmentMessenger setIdNum(String str) {
        this.idNum = str;
        return this;
    }

    public FragmentMessenger setEmail(String str) {
        this.email = str;
        return this;
    }

    public FragmentMessenger setCredential(String str) {
        this.credential = str;
        return this;
    }

    public FragmentMessenger setNewEmail(String str) {
        this.newEmail = str;
        return this;
    }

    public FragmentMessenger setNewEmailCode(String str) {
        this.newEmailCode = str;
        return this;
    }

    public String getNewEmail() {
        return this.newEmail;
    }

    public String getNewEmailCode() {
        return this.newEmailCode;
    }

    public FragmentMessenger setNeedBind(boolean z) {
        this.isNeedBind = z;
        return this;
    }

    public FragmentMessenger setIdtoken(String str) {
        this.idtoken = str;
        return this;
    }

    public FragmentMessenger setChannel(String str) {
        this.channel = str;
        return this;
    }

    public FragmentMessenger setAuthInfo(AuthResponse.AuthInfo authInfo2) {
        this.authInfo = authInfo2;
        return this;
    }

    public FragmentMessenger setVoiceSupport(boolean z) {
        this.voiceSupport = z;
        return this;
    }

    public FragmentMessenger setPromptPageData(PromptPageData promptPageData2) {
        this.promptPageData = promptPageData2;
        return this;
    }

    public FragmentMessenger setFaceDes(GateKeeperResponse.FaceDes faceDes2) {
        this.faceDes = faceDes2;
        return this;
    }

    public FragmentMessenger setSessionId(String str) {
        this.sessionId = str;
        return this;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public GateKeeperResponse.FaceDes getFaceDes() {
        return this.faceDes;
    }

    public PromptPageData getPromptPageData() {
        return this.promptPageData;
    }

    public String getIdtoken() {
        return this.idtoken;
    }

    public String getChannel() {
        return this.channel;
    }

    public AuthResponse.AuthInfo getAuthInfo() {
        return this.authInfo;
    }

    public boolean isNeedBind() {
        return this.isNeedBind;
    }

    public String getCredential() {
        return this.credential;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getIdNum() {
        return this.idNum;
    }

    public int getNewCodeType() {
        return this.newCodeType;
    }

    public String getHideEmail() {
        return this.hideEmail;
    }

    public int getLackType() {
        return this.lackType;
    }

    public int getCodeType() {
        return this.codeType;
    }

    public String getCaptchaCell() {
        return this.captchaCell;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public LoginState getNextState() {
        return this.nextState;
    }

    public String getNewCode() {
        return this.newCode;
    }

    public String getNewCell() {
        return this.newCell;
    }

    public LoginScene getScene() {
        return this.scene;
    }

    public String getCell() {
        return this.cell;
    }

    public String getCode() {
        return this.code;
    }

    public String getPassword() {
        return this.password;
    }

    public int getSceneNum() {
        LoginScene loginScene = this.scene;
        if (loginScene != null) {
            return loginScene.getSceneNum();
        }
        return -1;
    }

    public int getCodeLength() {
        return this.codeLength;
    }

    public void setCodeLength(int i) {
        this.codeLength = i;
    }

    public boolean isVoiceSupport() {
        return this.voiceSupport;
    }

    public List<String> getDeleteAccountReasons() {
        return this.deleteAccountReasons;
    }

    public void setDeleteAccountReasons(List<String> list) {
        this.deleteAccountReasons = list;
    }

    public List<DeleteUserResponse.DeleteContent> getDeleteAccountFailTexts() {
        return this.deleteAccountFailTexts;
    }

    public void setDeleteAccountFailTexts(List<DeleteUserResponse.DeleteContent> list) {
        this.deleteAccountFailTexts = list;
    }

    public String getDeleteAccountFailedSubPromptTitle() {
        return this.deleteAccountFailedSubPromptTitle;
    }

    public void setDeleteAccountFailedSubPromptTitle(String str) {
        this.deleteAccountFailedSubPromptTitle = str;
    }

    public String getDeleteAccountFailedSubTitle() {
        return this.deleteAccountFailedSubTitle;
    }

    public void setDeleteAccountFailedSubTitle(String str) {
        this.deleteAccountFailedSubTitle = str;
    }

    public FragmentMessenger setTempData(String str) {
        this.tempData = str;
        return this;
    }

    public String getTempData() {
        return this.tempData;
    }

    public String toString() {
        return "FragmentMessenger{cell='" + this.cell + '\'' + ", newCell='" + this.newCell + '\'' + ", scene=" + this.scene + ", code='" + this.code + '\'' + ", newCode='" + this.newCode + '\'' + ", password='" + this.password + '\'' + ", prompt='" + this.prompt + '\'' + ", nextState=" + this.nextState + ", captchaCell='" + this.captchaCell + '\'' + ", email='" + this.hideEmail + '\'' + ", lackType=" + this.lackType + ", codeType=" + this.codeType + ", newCodeType=" + this.newCodeType + ", codeLength=" + this.codeLength + '}';
    }

    public FragmentMessenger cloneObj() {
        try {
            return (FragmentMessenger) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new FragmentMessenger();
        }
    }

    public static LoginScene getNowScene() {
        return scenesStack.isEmpty() ? LoginScene.SCENE_UNDEFINED : scenesStack.peek();
    }

    public boolean isChangePhoneByID() {
        return this.isChangePhoneByID;
    }

    public FragmentMessenger setChangePhoneByID(boolean z) {
        this.isChangePhoneByID = z;
        return this;
    }

    public String getLoginMethod() {
        return this.loginMethod;
    }

    public void setLoginMethod(String str) {
        this.loginMethod = str;
    }
}
