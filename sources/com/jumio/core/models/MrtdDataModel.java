package com.jumio.core.models;

import com.jumio.core.JumioMrzData;
import com.jumio.core.enums.EMRTDStatus;
import com.jumio.core.model.StaticModel;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0004R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\"R$\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 \u0018\u00010(8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00101\u001a\u00020 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\"¨\u00062"}, mo175978d2 = {"Lcom/jumio/core/models/MrtdDataModel;", "Lcom/jumio/core/model/StaticModel;", "", "getPlaceOfBirth", "()Ljava/lang/String;", "placeOfBirth", "Ljava/util/Date;", "getIssuingDate", "()Ljava/util/Date;", "issuingDate", "Lcom/jumio/core/enums/EMRTDStatus;", "getVerificationStatus", "()Lcom/jumio/core/enums/EMRTDStatus;", "verificationStatus", "getMrzString", "mrzString", "getMrzFirstName", "mrzFirstName", "getMrzLastName", "mrzLastName", "getMrzPersonalNumber", "mrzPersonalNumber", "getMrzIdNumber", "mrzIdNumber", "getMrzIssuingCountry", "mrzIssuingCountry", "getMrzOriginatingCountry", "mrzOriginatingCountry", "Lcom/jumio/core/JumioMrzData;", "getMrzData", "()Lcom/jumio/core/JumioMrzData;", "mrzData", "", "getBacCheckResult", "()I", "bacCheckResult", "getDscCheckResult", "dscCheckResult", "getActiveAuthResult", "activeAuthResult", "", "getHtCheckResults", "()Ljava/util/Map;", "htCheckResults", "", "getEncodedDataItems", "()[I", "encodedDataItems", "getRootCertCheck", "rootCertCheck", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: MrtdDataModel.kt */
public interface MrtdDataModel extends StaticModel {
    int getActiveAuthResult();

    int getBacCheckResult();

    int getDscCheckResult();

    int[] getEncodedDataItems();

    Map<String, Integer> getHtCheckResults();

    Date getIssuingDate();

    JumioMrzData getMrzData();

    String getMrzFirstName();

    String getMrzIdNumber();

    String getMrzIssuingCountry();

    String getMrzLastName();

    String getMrzOriginatingCountry();

    String getMrzPersonalNumber();

    String getMrzString();

    String getPlaceOfBirth();

    int getRootCertCheck();

    EMRTDStatus getVerificationStatus();
}
