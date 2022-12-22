package com.didi.jacoco.store.expand;

import com.didi.jacoco.p120ec.CommitInfo;
import com.didi.jacoco.p120ec.DeviceInfo;
import com.didi.jacoco.p120ec.EcInfo;
import com.didi.jacoco.p120ec.JenkinsInfo;
import com.didi.jacoco.p120ec.UserInfo;
import com.didi.jacoco.store.ExecutionData;
import com.didi.jacoco.store.ExecutionDataReader;
import com.didi.jacoco.store.ExecutionDataWriter;
import com.didi.jacoco.store.IExecutionDataVisitor;
import com.didi.jacoco.store.ISessionInfoVisitor;
import com.didi.jacoco.store.IncompatibleExecDataVersionException;
import com.didi.jacoco.store.SessionInfo;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0014J\b\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020@H\u0002J\b\u0010B\u001a\u00020@H\u0002J\b\u0010C\u001a\u00020@H\u0002J\u000e\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020\u001eJ\u0012\u0010F\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010G\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010.H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\b\"\u0004\b&\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u0004R\u001a\u0010*\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R\u001a\u00102\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR\u001a\u00105\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\nR\u001a\u00108\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\b\"\u0004\b:\u0010\n¨\u0006H"}, mo175978d2 = {"Lcom/didi/jacoco/store/expand/DidiExecutionDataReader;", "Lcom/didi/jacoco/store/ExecutionDataReader;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "branchName", "getBranchName", "setBranchName", "buildTime", "", "getBuildTime", "()J", "setBuildTime", "(J)V", "buildType", "getBuildType", "setBuildType", "commitInfo", "getCommitInfo", "setCommitInfo", "deviceInfo", "getDeviceInfo", "setDeviceInfo", "ecInfoVisitor", "Lcom/didi/jacoco/store/expand/IEcInfoVisitor;", "endTime", "getEndTime", "setEndTime", "executionDataVisitor", "Lcom/didi/jacoco/store/IExecutionDataVisitor;", "flavor", "getFlavor", "setFlavor", "getInputStream", "()Ljava/io/InputStream;", "setInputStream", "jenkinsInfo", "getJenkinsInfo", "setJenkinsInfo", "sessionInfoVisitor", "Lcom/didi/jacoco/store/ISessionInfoVisitor;", "startTime", "getStartTime", "setStartTime", "userInfo", "getUserInfo", "setUserInfo", "versionCode", "getVersionCode", "setVersionCode", "versionName", "getVersionName", "setVersionName", "readBlock", "", "blocktype", "", "readEcInfo", "", "readExecutionData", "readHeader", "readSessionInfo", "setEcInfoVisitor", "visitor", "setExecutionDataVisitor", "setSessionInfoVisitor", "jacoco-store"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DidiExecutionDataReader.kt */
public final class DidiExecutionDataReader extends ExecutionDataReader {
    private String appId = "";
    private String branchName = "";
    private long buildTime;
    private String buildType = "";
    private String commitInfo = "";
    private String deviceInfo = "";
    private IEcInfoVisitor ecInfoVisitor;
    private long endTime;
    private IExecutionDataVisitor executionDataVisitor;
    private String flavor = "";
    private InputStream inputStream;
    private String jenkinsInfo = "";
    private ISessionInfoVisitor sessionInfoVisitor;
    private long startTime;
    private String userInfo = "";
    private String versionCode = "";
    private String versionName = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DidiExecutionDataReader(InputStream inputStream2) {
        super(inputStream2);
        Intrinsics.checkParameterIsNotNull(inputStream2, "inputStream");
        this.inputStream = inputStream2;
    }

    public final InputStream getInputStream() {
        return this.inputStream;
    }

    public final void setInputStream(InputStream inputStream2) {
        Intrinsics.checkParameterIsNotNull(inputStream2, "<set-?>");
        this.inputStream = inputStream2;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appId = str;
    }

    public final String getBranchName() {
        return this.branchName;
    }

    public final void setBranchName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.branchName = str;
    }

    public final String getUserInfo() {
        return this.userInfo;
    }

    public final void setUserInfo(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.userInfo = str;
    }

    public final String getCommitInfo() {
        return this.commitInfo;
    }

    public final void setCommitInfo(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.commitInfo = str;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public final void setVersionCode(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.versionCode = str;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final void setVersionName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.versionName = str;
    }

    public final long getBuildTime() {
        return this.buildTime;
    }

    public final void setBuildTime(long j) {
        this.buildTime = j;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final String getDeviceInfo() {
        return this.deviceInfo;
    }

    public final void setDeviceInfo(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.deviceInfo = str;
    }

    public final String getJenkinsInfo() {
        return this.jenkinsInfo;
    }

    public final void setJenkinsInfo(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.jenkinsInfo = str;
    }

    public final String getFlavor() {
        return this.flavor;
    }

    public final void setFlavor(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.flavor = str;
    }

    public final String getBuildType() {
        return this.buildType;
    }

    public final void setBuildType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.buildType = str;
    }

    public void setSessionInfoVisitor(ISessionInfoVisitor iSessionInfoVisitor) {
        this.sessionInfoVisitor = iSessionInfoVisitor;
    }

    public void setExecutionDataVisitor(IExecutionDataVisitor iExecutionDataVisitor) {
        this.executionDataVisitor = iExecutionDataVisitor;
    }

    public final void setEcInfoVisitor(IEcInfoVisitor iEcInfoVisitor) {
        Intrinsics.checkParameterIsNotNull(iEcInfoVisitor, "visitor");
        this.ecInfoVisitor = iEcInfoVisitor;
    }

    /* access modifiers changed from: protected */
    public boolean readBlock(byte b) {
        if (b == DidiExecutionDataWriter.Companion.getBLOCK_HEADER()) {
            readHeader();
            return true;
        } else if (b == DidiExecutionDataWriter.Companion.getBLOCK_EXECUTIONDATA()) {
            readExecutionData();
            return true;
        } else if (b == DidiExecutionDataWriter.Companion.getBLOCK_SESSIONINFO()) {
            readSessionInfo();
            return true;
        } else if (b == DidiExecutionDataWriter.Companion.getBLOCK_ECINO()) {
            readEcInfo();
            return true;
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("Unknown block type %x.", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            throw new IOException(format);
        }
    }

    private final void readEcInfo() throws IOException {
        String readUTF = this.f24387in.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(readUTF, "`in`.readUTF()");
        this.versionCode = readUTF;
        String readUTF2 = this.f24387in.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(readUTF2, "`in`.readUTF()");
        this.versionName = readUTF2;
        this.buildTime = this.f24387in.readLong();
        String readUTF3 = this.f24387in.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(readUTF3, "`in`.readUTF()");
        this.appId = readUTF3;
        String readUTF4 = this.f24387in.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(readUTF4, "`in`.readUTF()");
        this.branchName = readUTF4;
        this.startTime = this.f24387in.readLong();
        this.endTime = this.f24387in.readLong();
        String readUTF5 = this.f24387in.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(readUTF5, "`in`.readUTF()");
        this.userInfo = readUTF5;
        String readUTF6 = this.f24387in.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(readUTF6, "`in`.readUTF()");
        this.commitInfo = readUTF6;
        String readUTF7 = this.f24387in.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(readUTF7, "`in`.readUTF()");
        this.jenkinsInfo = readUTF7;
        String readUTF8 = this.f24387in.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(readUTF8, "`in`.readUTF()");
        this.deviceInfo = readUTF8;
        String readUTF9 = this.f24387in.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(readUTF9, "`in`.readUTF()");
        this.flavor = readUTF9;
        String readUTF10 = this.f24387in.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(readUTF10, "`in`.readUTF()");
        this.buildType = readUTF10;
        IEcInfoVisitor iEcInfoVisitor = this.ecInfoVisitor;
        if (iEcInfoVisitor != null) {
            String str = this.versionCode;
            String str2 = this.versionName;
            long j = this.buildTime;
            String str3 = this.appId;
            String str4 = this.branchName;
            long j2 = this.startTime;
            long j3 = this.endTime;
            Object fromJson = new Gson().fromJson(this.userInfo, UserInfo.class);
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson(userInfo, UserInfo::class.java)");
            Object fromJson2 = new Gson().fromJson(this.commitInfo, CommitInfo.class);
            Intrinsics.checkExpressionValueIsNotNull(fromJson2, "Gson().fromJson(commitIn…, CommitInfo::class.java)");
            IEcInfoVisitor iEcInfoVisitor2 = iEcInfoVisitor;
            Object fromJson3 = new Gson().fromJson(this.jenkinsInfo, JenkinsInfo.class);
            Intrinsics.checkExpressionValueIsNotNull(fromJson3, "Gson().fromJson(jenkinsI… JenkinsInfo::class.java)");
            Object fromJson4 = new Gson().fromJson(this.deviceInfo, DeviceInfo.class);
            Intrinsics.checkExpressionValueIsNotNull(fromJson4, "Gson().fromJson(deviceIn…, DeviceInfo::class.java)");
            String str5 = this.buildType;
            IEcInfoVisitor iEcInfoVisitor3 = iEcInfoVisitor2;
            iEcInfoVisitor3.visitEcInfo(new EcInfo(str3, j, str2, str, str4, (UserInfo) fromJson, (DeviceInfo) fromJson4, "", (CommitInfo) fromJson2, j2, j3, (JenkinsInfo) fromJson3, this.flavor, str5));
        }
    }

    private final void readHeader() throws IOException {
        if (this.f24387in.readChar() == 49344) {
            char readChar = this.f24387in.readChar();
            if (readChar != ExecutionDataWriter.FORMAT_VERSION) {
                throw new IncompatibleExecDataVersionException(readChar);
            }
            return;
        }
        throw new IOException("Invalid execution data file.");
    }

    private final void readSessionInfo() throws IOException {
        String readUTF = this.f24387in.readUTF();
        long readLong = this.f24387in.readLong();
        long readLong2 = this.f24387in.readLong();
        ISessionInfoVisitor iSessionInfoVisitor = this.sessionInfoVisitor;
        if (iSessionInfoVisitor != null) {
            iSessionInfoVisitor.visitSessionInfo(new SessionInfo(readUTF, readLong, readLong2));
        }
    }

    private final void readExecutionData() throws IOException {
        long readLong = this.f24387in.readLong();
        String readUTF = this.f24387in.readUTF();
        boolean[] readBooleanArray = this.f24387in.readBooleanArray();
        IExecutionDataVisitor iExecutionDataVisitor = this.executionDataVisitor;
        if (iExecutionDataVisitor != null) {
            iExecutionDataVisitor.visitClassExecution(new ExecutionData(readLong, readUTF, readBooleanArray));
        }
    }
}
