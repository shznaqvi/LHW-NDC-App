package edu.aku.hassannaqvi.wellnessscale.models;

import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.wellnessscale.core.MainApp._EMPTY_;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.PropertyChangeRegistry;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.wellnessscale.BR;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts.FamilyMembersTable;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;

public class FamilyMembers extends BaseObservable {

    private final String TAG = "FamilyMembers";
    //Not saving in DB
    private final LocalDate localDate = null;
    private final boolean exist = false;
    private final String lhwuid = _EMPTY_;
    // FIELD VARIABLES
    public String a103 = _EMPTY_;
    public String a104 = _EMPTY_;
    public String a105 = _EMPTY_;
    public String a106 = _EMPTY_;
    public String a10696x = _EMPTY_;
    public String a107 = _EMPTY_;
    public String a108 = _EMPTY_;
    public String a109 = _EMPTY_;
    public String a110 = _EMPTY_;
    public String b101 = _EMPTY_;
    public String b102 = _EMPTY_;
    public String c101 = _EMPTY_;
    public String c102 = _EMPTY_;
    public String c10201 = _EMPTY_;
    public String c10202 = _EMPTY_;
    public String c10203 = _EMPTY_;
    public String c10204 = _EMPTY_;
    public String c10205 = _EMPTY_;
    public String c10206 = _EMPTY_;
    public String c10207 = _EMPTY_;
    public String c10208 = _EMPTY_;
    public String c10209 = _EMPTY_;
    public String c103 = _EMPTY_;
    public String c104 = _EMPTY_;
    public String c105 = _EMPTY_;
    public String c106 = _EMPTY_;
    public String c107 = _EMPTY_;
    public String d101 = _EMPTY_;
    public String d102 = _EMPTY_;
    public String d103 = _EMPTY_;
    public String d104 = _EMPTY_;
    public String d105 = _EMPTY_;
    public String d106 = _EMPTY_;
    public String d107 = _EMPTY_;
    public String d108 = _EMPTY_;
    public String e101 = _EMPTY_;
    public String e101d = _EMPTY_;
    public String e102 = _EMPTY_;
    public String e102x = _EMPTY_;
    public String e103 = _EMPTY_;
    public String e103d = _EMPTY_;
    public String e104 = _EMPTY_;
    public String e104x = _EMPTY_;
    public String e105 = _EMPTY_;
    public String e105d = _EMPTY_;
    public String e106 = _EMPTY_;
    public String e106x = _EMPTY_;
    public String e107 = _EMPTY_;
    public String e107x = _EMPTY_;
    public String h101 = _EMPTY_;
    public String h102 = _EMPTY_;
    public String h103 = _EMPTY_;
    public String h104 = _EMPTY_;
    public String h105 = _EMPTY_;
    public String h106 = _EMPTY_;
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = _EMPTY_;
    private String uid = _EMPTY_;
    private String uuid = _EMPTY_;
    private String distCode = _EMPTY_;
    private String userName = _EMPTY_;
    private String sysDate = _EMPTY_;
    private String lhwCode = _EMPTY_;
    private String kNo = _EMPTY_;
    private String deviceId = _EMPTY_;
    private String deviceTag = _EMPTY_;
    private String appver = _EMPTY_;
    private String endTime = _EMPTY_;
    private String iStatus = _EMPTY_;
    private String iStatus96x = _EMPTY_;
    private String synced = _EMPTY_;
    private String syncDate = _EMPTY_;
    private String sno = _EMPTY_;
    // SECTION VARIABLES
    private String sH3 = _EMPTY_;
    private String memCate = _EMPTY_;
    private int scoreRapid = 0;
    private boolean expanded;
    private boolean mwra;
    private int scoreRose; // 1: Angina; 2: Exertion
    private int scoreQVSFS; // 0 - 8
    private String scoreIPAQ; // 0 - 8
    private int painGrade;
    private String scoreWHO5 = _EMPTY_;
    // private String indexed;


    public FamilyMembers() {

        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setAppver(MainApp.appInfo.getAppVersion());
        setAppver(MainApp.appInfo.getAppVersion());
        //setDistCode(MainApp.hhForm.getDistrict());


    }

    public String getScoreWHO5() {
        return scoreWHO5;
    }

    public void setScoreWHO5(String scoreWHO5) {
        this.scoreWHO5 = scoreWHO5;
    }

    public void populateMeta() {

        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
       /*  //   setUuid(MainApp.form.getUid());  // not applicable in Form table
        setAppver(MainApp.appInfo.getAppVersion());*/
        setProjectName(PROJECT_NAME);

        //  setEntryType(String.valueOf(MainApp.entryType));

        //SECTION VARIABLES
        setDistCode(MainApp.selectedDistrict);
        setLhwCode(MainApp.selectedLHW);
        setKno(MainApp.selectedHousehold);

    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Bindable
    public String getLhwCode() {
        return lhwCode;
    }

    public void setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
        notifyChange(BR.lhwCode);
    }

    @Bindable
    public String getkNo() {
        return kNo;
    }

    public void setKno(String kNo) {
        this.kNo = kNo;
        notifyChange(BR.kNo);
    }

    @Bindable
    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        notifyChange(BR.expanded);
    }

    public String getDistCode() {
        return distCode;
    }

    public void setDistCode(String distCode) {
        this.distCode = distCode;
    }

    @Bindable
    public boolean isMwra() {
        return mwra;
    }

    public void setMwra(boolean mwra) {
        this.mwra = mwra;

        notifyChange(BR.mwra);
    }

    public String getMemCate() {
        return memCate;
    }

    public void setMemCate(String memCate) {
        this.memCate = memCate;
        // notifyChange(BR.memCate);
    }

    public int getScoreRapid() {
        return scoreRapid;
    }

    public void setScoreRapid(int scoreRapid) {
        this.scoreRapid = scoreRapid;
        // notifyChange(BR.memCate);
    }

    public int getScoreRose() {
        return scoreRose;
    }

    public void setScoreRose(int scoreRose) {
        this.scoreRose = scoreRose;
        // notifyChange(BR.memCate);
    }

    public int getScoreQVSFS() {
        return scoreQVSFS;
    }

    public void setScoreQVSFS(int scoreQVSFS) {
        this.scoreQVSFS = scoreQVSFS;
        // notifyChange(BR.memCate);
    }

    public String getScoreIPAQ() {
        return scoreIPAQ;
    }

    public void setScoreIPAQ(String scoreIPAQ) {
        this.scoreIPAQ = scoreIPAQ;
        // notifyChange(BR.memCate);
    }

    public int getPainGrade() {
        return painGrade;
    }

    public void setPainGrade(int painGrade) {
        this.painGrade = painGrade;
        // notifyChange(BR.memCate);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }

    public String getsH3() {
        return sH3;
    }

    public void setsH3(String sH3) {
        this.sH3 = sH3;
    }

    @Bindable
    public String getA103() {
        return a103;
    }

    public void setA103(String a103) {
        this.a103 = a103;
        notifyChange(BR.a103);
    }

    @Bindable
    public String getA104() {
        return a104;
    }

    public void setA104(String a104) {
        this.a104 = a104;
        notifyChange(BR.a104);
    }

    @Bindable
    public String getA105() {
        return a105;
    }

    public void setA105(String a105) {
        this.a105 = a105;
        notifyChange(BR.a105);
    }

    @Bindable
    public String getA106() {
        return a106;
    }

    public void setA106(String a106) {
        this.a106 = a106;
        notifyChange(BR.a106);
    }

    @Bindable
    public String getA10696x() {
        return a10696x;
    }

    public void setA10696x(String a10696x) {
        this.a10696x = a10696x;
        notifyChange(BR.a10696x);
    }

    @Bindable
    public String getA107() {
        return a107;
    }

    public void setA107(String a107) {
        this.a107 = a107;
        notifyChange(BR.a107);
    }

    @Bindable
    public String getA108() {
        return a108;
    }

    public void setA108(String a108) {
        this.a108 = a108;
        notifyChange(BR.a108);
    }

    @Bindable
    public String getA109() {
        return a109;
    }

    public void setA109(String a109) {
        this.a109 = a109;
        notifyChange(BR.a109);
    }

    @Bindable
    public String getA110() {
        return a110;
    }

    public void setA110(String a110) {
        this.a110 = a110;
        notifyChange(BR.a110);
    }

    @Bindable
    public String getB101() {
        return b101;
    }

    public void setB101(String b101) {
        this.b101 = b101;
        notifyChange(BR.b101);
    }

    @Bindable
    public String getB102() {
        return b102;
    }

    public void setB102(String b102) {
        this.b102 = b102;

        notifyChange(BR.b102);
    }

    @Bindable
    public String getC101() {
        return c101;
    }

    public void setC101(String c101) {
        this.c101 = c101;

        setC10201(c101.equals("2") ? "" : c10201);
        setC10202(c101.equals("2") ? "" : c10202);
        setC10203(c101.equals("2") ? "" : c10203);
        setC10204(c101.equals("2") ? "" : c10204);
        setC10205(c101.equals("2") ? "" : c10205);
        setC10206(c101.equals("2") ? "" : c10206);
        setC10207(c101.equals("2") ? "" : c10207);
        setC10208(c101.equals("2") ? "" : c10208);
        setC10209(c101.equals("2") ? "" : c10209);

        notifyChange(BR.c101);
    }

    @Bindable
    public String getC102() {
        return c102;
    }

    public void setC102(String c102) {
        this.c102 = c102;
        notifyChange(BR.c102);
    }

    @Bindable
    public String getC10201() {
        return c10201;
    }

    public void setC10201(String c10201) {
        this.c10201 = c10201;
        notifyChange(BR.c10201);
    }

    @Bindable
    public String getC10202() {
        return c10202;
    }

    public void setC10202(String c10202) {
        this.c10202 = c10202;
        notifyChange(BR.c10202);
    }

    @Bindable
    public String getC10203() {
        return c10203;
    }

    public void setC10203(String c10203) {
        this.c10203 = c10203;
        notifyChange(BR.c10203);
    }

    @Bindable
    public String getC10204() {
        return c10204;
    }

    public void setC10204(String c10204) {
        this.c10204 = c10204;
        notifyChange(BR.c10204);
    }

    @Bindable
    public String getC10205() {
        return c10205;
    }

    public void setC10205(String c10205) {
        this.c10205 = c10205;
        notifyChange(BR.c10205);
    }

    @Bindable
    public String getC10206() {
        return c10206;
    }

    public void setC10206(String c10206) {
        this.c10206 = c10206;
        notifyChange(BR.c10206);
    }

    @Bindable
    public String getC10207() {
        return c10207;
    }

    public void setC10207(String c10207) {
        this.c10207 = c10207;
        notifyChange(BR.c10207);
    }

    @Bindable
    public String getC10208() {
        return c10208;
    }

    public void setC10208(String c10208) {
        this.c10208 = c10208;
        notifyChange(BR.c10208);
    }

    @Bindable
    public String getC10209() {
        return c10209;
    }

    public void setC10209(String c10209) {
        this.c10209 = c10209;
        notifyChange(BR.c10209);
    }

    @Bindable
    public String getC103() {
        return c103;
    }

    public void setC103(String c103) {
        this.c103 = c103;
        notifyChange(BR.c103);
    }

    @Bindable
    public String getC104() {
        return c104;
    }

    public void setC104(String c104) {
        this.c104 = c104;
        notifyChange(BR.c104);
    }

    @Bindable
    public String getC105() {
        return c105;
    }

    public void setC105(String c105) {
        this.c105 = c105;
        notifyChange(BR.c105);
    }

    @Bindable
    public String getC106() {
        return c106;
    }

    public void setC106(String c106) {
        this.c106 = c106;
        setC107(c106.equals("2") ? "" : c107); // Skip C107
        notifyChange(BR.c106);
    }

    @Bindable
    public String getC107() {
        return c107;
    }

    public void setC107(String c107) {
        this.c107 = c107;
        notifyChange(BR.c107);
    }

    @Bindable
    public String getD101() {
        return d101;
    }

    public void setD101(String d101) {
        this.d101 = d101;
        notifyChange(BR.d101);
    }

    @Bindable
    public String getD102() {
        return d102;
    }

    public void setD102(String d102) {
        this.d102 = d102;
        notifyChange(BR.d102);
    }

    @Bindable
    public String getD103() {
        return d103;
    }

    public void setD103(String d103) {
        this.d103 = d103;
        notifyChange(BR.d103);
    }

    @Bindable
    public String getD104() {
        return d104;
    }

    public void setD104(String d104) {
        this.d104 = d104;
        notifyChange(BR.d104);
    }

    @Bindable
    public String getD105() {
        return d105;
    }

    public void setD105(String d105) {
        this.d105 = d105;
        notifyChange(BR.d105);
    }

    @Bindable
    public String getD106() {
        return d106;
    }

    public void setD106(String d106) {
        this.d106 = d106;
        notifyChange(BR.d106);
    }

    @Bindable
    public String getD107() {
        return d107;
    }

    public void setD107(String d107) {
        this.d107 = d107;
        notifyChange(BR.d107);
    }

    @Bindable
    public String getD108() {
        return d108;
    }

    public void setD108(String d108) {
        this.d108 = d108;
        notifyChange(BR.d108);
    }

    @Bindable
    public String getE101() {
        return e101;
    }

    public void setE101(String e101) {
        this.e101 = e101;
        setE102(e101.equals("99") ? "" : e102); // Skip E102
        setE101d(e101.equals("1") ? e101d : ""); // Skip E101d

        notifyChange(BR.e101);
    }

    @Bindable
    public String getE101d() {
        return e101d;
    }

    public void setE101d(String e101d) {
        this.e101d = e101d;
        notifyChange(BR.e101d);
    }


    @Bindable
    public String getE102() {
        return e102;
    }

    public void setE102(String e102) {
        this.e102 = e102;
        setE102x(e102.equals("1") ? e102x : ""); // Skip E102x

        notifyChange(BR.e102);
    }

    @Bindable
    public String getE102x() {
        return e102x;
    }

    public void setE102x(String e102x) {
        this.e102x = e102x;
        notifyChange(BR.e102x);
    }


    @Bindable
    public String getE103() {
        return e103;
    }

    public void setE103(String e103) {
        this.e103 = e103;
        setE104(e103.equals("99") ? "" : e104); // Skip E104
        setE103d(e103.equals("1") ? e103d : ""); // Skip E103d
        notifyChange(BR.e103);
    }

    @Bindable
    public String getE103d() {
        return e103d;
    }

    public void setE103d(String e103d) {
        this.e103d = e103d;
        notifyChange(BR.e103d);
    }


    @Bindable
    public String getE104() {
        return e104;
    }

    public void setE104(String e104) {
        this.e104 = e104;
        setE104x(e104.equals("1") ? e104x : ""); // Skip E104x

        notifyChange(BR.e104);
    }


    @Bindable
    public String getE104x() {
        return e104x;
    }

    public void setE104x(String e104x) {
        this.e104x = e104x;
        notifyChange(BR.e104x);
    }


    @Bindable
    public String getE105() {
        return e105;
    }

    public void setE105(String e105) {
        this.e105 = e105;
        setE106(e105.equals("99") ? "" : e106); // Skip E1052
        setE105d(e105.equals("1") ? e105d : ""); // Skip E105d
        notifyChange(BR.e105);
    }

    @Bindable
    public String getE105d() {
        return e105d;
    }

    public void setE105d(String e105d) {
        this.e105d = e105d;
        notifyChange(BR.e105d);
    }


    @Bindable
    public String getE106() {
        return e106;
    }

    public void setE106(String e106) {
        this.e106 = e106;
        setE106x(e106.equals("1") ? e106x : ""); // Skip E106x
        notifyChange(BR.e106);
    }

    @Bindable
    public String getE106x() {
        return e106x;
    }

    public void setE106x(String e106x) {
        this.e106x = e106x;
        notifyChange(BR.e106x);
    }


    @Bindable
    public String getE107() {
        return e107;
    }

    public void setE107(String e107) {
        this.e107 = e107;
        setE107x(e107.equals("1") ? e107x : ""); // Skip E107x
        notifyChange(BR.e107);
    }

    @Bindable
    public String getE107x() {
        return e107x;
    }

    public void setE107x(String e107x) {
        this.e107x = e107x;
        notifyChange(BR.e107x);
    }


    @Bindable
    public String getH101() {
        return h101;
    }

    public void setH101(String h101) {
        this.h101 = h101;
        notifyChange(BR.h101);
    }

    @Bindable
    public String getH102() {
        return h102;
    }

    public void setH102(String h102) {
        this.h102 = h102;
        notifyChange(BR.h102);
    }

    @Bindable
    public String getH103() {
        return h103;
    }

    public void setH103(String h103) {
        this.h103 = h103;
        notifyChange(BR.h103);
    }

    @Bindable
    public String getH104() {
        return h104;
    }

    public void setH104(String h104) {
        this.h104 = h104;
        notifyChange(BR.h104);
    }

    @Bindable
    public String getH105() {
        return h105;
    }

    public void setH105(String h105) {
        this.h105 = h105;
        notifyChange(BR.h105);
    }

    @Bindable
    public String getH106() {
        return h106;
    }

    public void setH106(String h106) {
        this.h106 = h106;
        notifyChange(BR.h106);
    }


    public FamilyMembers Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_UUID));
        this.lhwCode = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_LHW_CODE));
        this.distCode = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_DISTRICT));
        this.kNo = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_KHANDAN_NO));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_SYSDATE));
        this.sno = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_SNO));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_SYNCED_DATE));

        sA1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_SA1)));
        sB1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_SB1)));
        sC1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_SC1)));
        sD1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_SD1)));
        sE1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_SE1)));
        sF1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_SF1)));
        sG1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_SG1)));
        sH1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.FamilyMembersTable.COLUMN_SH1)));

        return this;
    }


    public void sA1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sA2Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.a103 = json.getString("a103");
            this.a104 = json.getString("a104");
            this.a105 = json.getString("a105");
            this.a106 = json.getString("a106");
            this.a10696x = json.getString("a10696x");
            this.a107 = json.getString("a107");
            this.a108 = json.getString("a108");
            this.a109 = json.getString("a109");
            this.a110 = json.getString("a110");

            //updateMemCategory();
        }
    }

    public void sB1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sAHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);


            this.b101 = json.getString("b101");
            this.b102 = json.getString("b102");

            updateRapidScore();
        }
    }

    public void sC1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sAHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);


            this.c101 = json.getString("c101");
            this.c10201 = json.getString("c10201");
            this.c10202 = json.getString("c10202");
            this.c10203 = json.getString("c10203");
            this.c10204 = json.getString("c10204");
            this.c10205 = json.getString("c10205");
            this.c10206 = json.getString("c10206");
            this.c10207 = json.getString("c10207");
            this.c10208 = json.getString("c10208");
            this.c10209 = json.getString("c10209");
            this.c103 = json.getString("c103");
            this.c104 = json.getString("c104");
            this.c105 = json.getString("c105");
            this.c106 = json.getString("c106");
            this.c107 = json.getString("c107");


            updateRoseScore();
        }
    }

    public void sD1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sAHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);

            this.d101 = json.getString("d101");
            this.d102 = json.getString("d102");
            this.d103 = json.getString("d103");
            this.d104 = json.getString("d104");
            this.d105 = json.getString("d105");
            this.d106 = json.getString("d106");
            this.d107 = json.getString("d107");
            this.d108 = json.getString("d108");


            updateQVSFS();
        }
    }

    public void sE1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sE1Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);


            this.e101 = json.getString("e101");
            this.e101d = json.getString("e101d");

            this.e102 = json.getString("e102");
            this.e102x = json.getString("e102x");

            this.e103 = json.getString("e103");
            this.e103d = json.getString("e103d");

            this.e104 = json.getString("e104");
            this.e104x = json.getString("e104x");

            this.e105 = json.getString("e105");
            this.e105d = json.getString("e105d");
            this.e106 = json.getString("e106");
            this.e106x = json.getString("e106x");
            this.e107 = json.getString("e107");
            this.e107x = json.getString("e107x");

            updateIPAQScore();
        }
    }

    public void sF1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sE1Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
/*

            this.e101 = json.getString("e101");
            this.e101d = json.getString("e101x");

            this.e102h = json.getString("e102x");

            this.e103 = json.getString("e103");
            this.e103d = json.getString("e103x");

            this.e104h = json.getString("e104x");

            this.e105 = json.getString("e105");
            this.e105d = json.getString("e105x");
            this.e105d = json.getString("e105x");
            this.e106 = json.getString("e106");
            this.e107 = json.getString("e107");
            this.e107h = json.getString("e107x");
            this.e107 = json.getString("e107");
            this.e107h = json.getString("e107x");
            this.e107 = json.getString("e107");
            //this.e1071 = json.getString("e1071");
            updateRoseScore();*/
        }
    }

    public void sG1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sE1Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
/*

            this.e101 = json.getString("e101");
            this.e101d = json.getString("e101x");

            this.e102h = json.getString("e102x");

            this.e103 = json.getString("e103");
            this.e103d = json.getString("e103x");

            this.e104h = json.getString("e104x");

            this.e105 = json.getString("e105");
            this.e105d = json.getString("e105x");
            this.e105d = json.getString("e105x");
            this.e106 = json.getString("e106");
            this.e107 = json.getString("e107");
            this.e107h = json.getString("e107x");
            this.e107 = json.getString("e107");
            this.e107h = json.getString("e107x");
            this.e107 = json.getString("e107");
            //this.e1071 = json.getString("e1071");
            updateRoseScore();*/
        }
    }

    public void sH1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sE1Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);

            this.h101 = json.getString("h101");
            this.h102 = json.getString("h102");
            this.h103 = json.getString("h103");
            this.h104 = json.getString("h104");
            this.h105 = json.getString("h105");
            this.h106 = json.getString("h106");
            calculateWHO5Score();
        }
    }

    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(TableContracts.FamilyMembersTable.COLUMN_ID, this.id);
            json.put(TableContracts.FamilyMembersTable.COLUMN_UID, this.uid);
            json.put(TableContracts.FamilyMembersTable.COLUMN_UUID, this.uuid);
            json.put(TableContracts.FamilyMembersTable.COLUMN_LHW_CODE, this.lhwCode);
            json.put(TableContracts.FamilyMembersTable.COLUMN_KHANDAN_NO, this.kNo);
            json.put(TableContracts.FamilyMembersTable.COLUMN_USERNAME, this.userName);
            json.put(TableContracts.FamilyMembersTable.COLUMN_SYSDATE, this.sysDate);
            json.put(TableContracts.FamilyMembersTable.COLUMN_DEVICEID, this.deviceId);
            json.put(TableContracts.FamilyMembersTable.COLUMN_DEVICETAGID, this.deviceTag);
            json.put(TableContracts.FamilyMembersTable.COLUMN_ISTATUS, this.iStatus);
            json.put(FamilyMembersTable.COLUMN_DISTRICT, this.distCode);
            json.put(FamilyMembersTable.COLUMN_SNO, this.sno);
            json.put(FamilyMembersTable.COLUMN_APPVERSION, this.appver);
            //  json.put(FamilyMembersTable.COLUMN_SYNCED, this.synced);
            //  json.put(FamilyMembersTable.COLUMN_SYNCED_DATE, this.syncDate);

            json.put(FamilyMembersTable.COLUMN_SA1, new JSONObject(sA1toString()));
            json.put(FamilyMembersTable.COLUMN_SB1, new JSONObject(sB1toString()));
            json.put(FamilyMembersTable.COLUMN_SC1, new JSONObject(sC1toString()));
            json.put(FamilyMembersTable.COLUMN_SD1, new JSONObject(sD1toString()));
            json.put(FamilyMembersTable.COLUMN_SE1, new JSONObject(sE1toString()));
            json.put(FamilyMembersTable.COLUMN_SF1, new JSONObject(sF1toString()));
            json.put(FamilyMembersTable.COLUMN_SG1, new JSONObject(sG1toString()));
            json.put(FamilyMembersTable.COLUMN_SH1, new JSONObject(sH1toString()));
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "toJSONObject: " + e.getMessage());
            return null;
        }
    }

    public String sA1toString() throws JSONException {
        Log.d(TAG, "sA1toString: ");
        JSONObject json = new JSONObject();
        json.put("a103", a103).put("a104", a104).put("a105", a105).put("a106", a106).put("a10696x", a10696x).put("a107", a107).put("a108", a108).put("a109", a109).put("a110", a110);
        return json.toString();
    }


    public String sB1toString() throws JSONException {
        Log.d(TAG, "sB1toString: ");
        JSONObject json = new JSONObject();
        json.put("b101", b101).put("b102", b102);

        updateRapidScore();
        return json.toString();
    }

    public String sC1toString() throws JSONException {
        Log.d(TAG, "sC1toString: ");
        JSONObject json = new JSONObject();
        json.put("c101", c101).put("c10201", c10201).put("c10202", c10202).put("c10203", c10203).put("c10204", c10204).put("c10205", c10205).put("c10206", c10206).put("c10207", c10207).put("c10208", c10208).put("c10209", c10209).put("c103", c103).put("c104", c104).put("c105", c105).put("c106", c106).put("c107", c107);

        updateRoseScore();
        return json.toString();
    }

    public String sD1toString() throws JSONException {
        Log.d(TAG, "sC1toString: ");
        JSONObject json = new JSONObject();
        json.put("d101", d101).put("d102", d102).put("d103", d103).put("d104", d104).put("d105", d105).put("d106", d106).put("d107", d107).put("d108", d108);

        updateQVSFS();
        return json.toString();
    }


    public String sE1toString() throws JSONException {
        Log.d(TAG, "sC1toString: ");
        JSONObject json = new JSONObject();
        json.put("e101", e101).put("e101d", e101d)

                .put("e102", e102).put("e102x", e102x)

                .put("e103", e103).put("e103d", e103d)

                .put("e104", e104).put("e104x", e104x)

                .put("e105", e105).put("e105d", e105d).put("e106", e106).put("e106x", e106x).put("e107", e107).put("e107x", e107x);
        //  .put("e1071", e1071)


        updateIPAQScore();
        return json.toString();
    }

    public String sF1toString() throws JSONException {
        Log.d(TAG, "sC1toString: ");
        JSONObject json = new JSONObject();
       /* json.put("e101", e101)
                .put("e101x", e101x)
                .put("e10199x", e10199x)
                .put("e10201", e10201)
                .put("e102x", e102x)
                .put("e10202", e10202)
                .put("e10202x", e10202x)
                .put("e10298", e10298)
                .put("e1021", e1021)
                .put("e103", e103)
                .put("e103x", e103x)
                .put("e10399x", e10399x)
                .put("e10401", e10401)
                .put("e104x", e104x)
                .put("e10402", e10402)
                .put("e10402x", e10402x)
                .put("e10498", e10498)
                .put("e1041", e1041)
                .put("e105", e105)
                .put("e105x", e105x)
                .put("e105x", e105x)
                .put("e106", e106)
                .put("e107", e107)
                .put("e107x", e107x)
                .put("e107", e107)
                .put("e107x", e107x)
                .put("e107", e107);
        //  .put("e1071", e1071)*/


        //updateRoseScore();
        return json.toString();
    }

    public String sG1toString() throws JSONException {
        Log.d(TAG, "sC1toString: ");
        JSONObject json = new JSONObject();
       /* json.put("e101", e101)
                .put("e101x", e101x)
                .put("e10199x", e10199x)
                .put("e10201", e10201)
                .put("e102x", e102x)
                .put("e10202", e10202)
                .put("e10202x", e10202x)
                .put("e10298", e10298)
                .put("e1021", e1021)
                .put("e103", e103)
                .put("e103x", e103x)
                .put("e10399x", e10399x)
                .put("e10401", e10401)
                .put("e104x", e104x)
                .put("e10402", e10402)
                .put("e10402x", e10402x)
                .put("e10498", e10498)
                .put("e1041", e1041)
                .put("e105", e105)
                .put("e105x", e105x)
                .put("e105x", e105x)
                .put("e106", e106)
                .put("e107", e107)
                .put("e107x", e107x)
                .put("e107", e107)
                .put("e107x", e107x)
                .put("e107", e107);*/
        //  .put("e1071", e1071)


        //updateRoseScore();
        return json.toString();
    }

    public String sH1toString() throws JSONException {
        Log.d(TAG, "sC1toString: ");
        JSONObject json = new JSONObject();
        json.put("h101", h101).put("h102", h102).put("h103", h103).put("h104", h104).put("h105", h105).put("h106", h106);


        calculateWHO5Score();
        return json.toString();
    }

//    private void CaluculateAge() {
//        Log.d(TAG, "CaluculateAge: " + this.h304y + "-" + this.h304m + "-" + this.h304d);
//
//        if (!this.h304y.equals("") && !this.h304y.equals("9998") && !this.h304m.equals("") && !this.h304d.equals("")) {
//
//            int day = !this.h304d.equals("98") ? Integer.parseInt(this.h304d) : 15;
//            int month = !this.h304m.equals("98") ? Integer.parseInt(this.h304m) : 6;
//            int year = Integer.parseInt(this.h304y);
//
//            SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd", Locale.ENGLISH);
//            String todayDate = df.format(Calendar.getInstance().getTime());
//            Calendar cal = Calendar.getInstance();
//            Calendar cur = Calendar.getInstance();
//
//            try {
//                cal.setTime(df.parse(year + " " + month + " " + day));
//                long millis = System.currentTimeMillis() - cal.getTimeInMillis();
//                cal.setTimeInMillis(millis);
//
//             /*   int mYear = cal.get(Calendar.YEAR)-1970;
//                int mMonth = cal.get(Calendar.MONTH);
//                int mDay = cal.get(Calendar.DAY_OF_MONTH)-1;
//
//                Log.d(TAG, "CaluculateAge: " + (mYear) + "-" + mMonth + "-" + mDay);
//*/
//                long tYear = MILLISECONDS.toDays(millis) / 365;
//                long tMonth = (MILLISECONDS.toDays(millis) - (tYear * 365)) / 30;
//                long tDay = MILLISECONDS.toDays(millis) - ((tYear * 365) + (tMonth * 30));
//
//                Log.d(TAG, "CaluculateAge: Y-" + tYear + " M-" + tMonth + " D-" + tDay);
//               /* setH231d(String.valueOf(tDay));
//                setH231m(String.valueOf(tMonth));*/
//                setH305(String.valueOf(tYear));
//                //setAge(String.valueOf(((tYear) * 12) + tMonth));
//
//
//        /*        String.format("%d min, %d sec",
//                        ,
//                        TimeUnit.MILLISECONDS.toSeconds(millis) -
//                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
//                );*/
//
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//
//
//    /**
//     * Memeber Categories:
//     * 1 = MWRA
//     * 2 = Adolescent
//     * 3 = Male > 19y
//     */
//    private void updateMemCategory() {
//        if (getH303().equals("") || getH305().equals("") || getH306().equals("") || getH309().equals(""))
//            return;
//        String memGender = getH303();
//        String memMaritalStatus = getH306();
//        String memStatus = getH309();
//        int memAge = Integer.parseInt(getH305());
//
//
//
//        switch(memGender)
//        {
//            // Male
//            case "1":
//                if(memAge > 19 && (memStatus.equals("1"))) {
//                setMemCate("3");
//                }else if((memAge >= 10 && memAge <= 19          // 10 to 19 year old Adolescent
//                         && memStatus.equals("1"))) {
//                    setMemCate("2");
//                }
//                else{
//                    setMemCate("");
//                }
//
//                break;
//
//            case  "2":
//                // Unmarried Adolescent girl
//                if(memMaritalStatus.equals("2")){
//                    if((memAge >= 10 && memAge <= 19   // 15 to 49 year old Unmarried girl
//                            && memStatus.equals("1"))) {
//                        setMemCate("2");
//                    }else{
//                        setMemCate("");
//                    }
//                // MWRA
//                }else if ((memAge >= 15 && memAge <= 49)
//                    && memStatus.equals("1")) {
//
//                    setMemCate("1");
//                }else{
//                    setMemCate("");
//                }
//
//                    break;
//
//        }
//    }

    private synchronized void notifyChange(int propertyId) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this, propertyId);
    }

    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(callback);

    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(callback);
        }
    }


    public String updateRapidScore() {

        int score = 0;
        int age = Integer.parseInt(this.getA104());
        int gender = Integer.parseInt(this.getA105());
        int waist = Integer.parseInt(this.getB101());
        int familyHistory = Integer.parseInt(this.getB102());

        score = age >= 40 && age <= 50 ? 1 : age > 50 ? 3 : 0;
        score += ((gender == 1 && waist >= 90) || (gender == 2 && waist >= 80)) ? 2 : 0;
        score += (familyHistory == 1) ? 1 : 0;

        scoreRapid = score;
        return score >= 4 ? " YES " : " NO ";
    }

    public void updateRoseScore() {

        int pain = this.getC101().equals("1") && // yes to question 1
                (this.getC103().equals("1") || this.getC104().equals("1") //yes to either question 3 or 4
                        && (this.getC10204().equals("4") || this.getC10205().equals("5") || this.getC10208().equals("8")) //site 4, 5, or 8 on diagram in question 2
                        && (this.getC105().equals("1") || this.getC105().equals("2")) //forced the subject to slow down or stop (question 5)
                        && this.getC106().equals("1") //was relieved if the subject did so (yes to question 6),
                        && this.getC107().equals("1") // was relieved within 10 minutes (question 7).
                ) ? 1 : 0;

        if (pain == 1) {
            // Angina based
            int angina = this.getC101().equals("1") && (this.getC103().equals("1") || this.getC104().equals("1")) ? 1 : 0; // yes to question 1 and yes to either question 2 or 3 (c103 OR C104 as per box-1, https://jech.bmj.com/content/57/7/538)

            painGrade = this.getC103().equals("1") ? 2 : (this.getC103().equals("2") && this.getC104().equals("1")) ? 1 : 0;
            scoreRose = angina == 1 ? 1 : 2;
            //return score>=4?" YES ":" NO ";
        } else {
            painGrade = 3;
            scoreRose = 3;
        }
    }

    public void updateQVSFS() {

        int D1 = getD101().equals("1") ? 1 : 0;
        int D2 = getD102().equals("1") ? 1 : 0;
        int D3 = getD103().equals("1") ? 1 : 0;
        int D4 = getD104().equals("1") ? 1 : 0;
        int D5 = getD105().equals("1") ? 1 : 0;
        int D6 = getD106().equals("1") ? 1 : 0;
        int D7 = getD107().equals("1") ? 1 : 0;
        int D8 = getD108().equals("1") ? 1 : 0;


        scoreQVSFS = D1 + D2 + D3 + D4 + D5 + D6 + D7 + D8;
        //return score>=4?" YES ":" NO ";
    }

    public void updateIPAQScore() {

        double MET_Vigorous = 8.0;
        double MET_Moderate = 4.0;
        double MET_Walking = 3.3;
        double E101 = Integer.parseInt(getE101());
        double E102x = 0;
        double E103 = Integer.parseInt(getE103());
        double E104x = 0;
        double E105 = Integer.parseInt(getE105());
        double E106x = 0;

        /*Setting 0 minues if Dont know*/
        if (this.e101.equals("99") || this.e102.equals("98")) {
            E101 = 0;
            E102x = 0;
        } else {
            E102x = Integer.parseInt(getE102x());
        }
        if (this.e103.equals("99") || this.e104.equals("98")) {
            E103 = 0;
            E104x = 0;
        } else {
            E104x = Integer.parseInt(getE104x());
        }
        if (this.e105.equals("99") || this.e106.equals("98")) {
            E105 = 0;
            E106x = 0;
        } else {
            E106x = Integer.parseInt(getE106x());
        }

        /*Hours to minutes conversion if Hours were entered*/
        if (this.e102.equals("1")) {
            E102x = E102x * 60;

        }
        if (this.e104.equals("1")) E104x = E104x * 60;
        if (this.e106.equals("1")) E106x = E106x * 60;

        double Vigorous = E101 * (E102x) * MET_Vigorous;
        double Moderate = E103 * (E104x) * MET_Moderate;
        double Walking = E105 * (E106x) * MET_Walking;
        //double Sitting = (E107 + E108) * 0.5;
        double TotalMET = Vigorous + Moderate + Walking; //+ Sitting;
        double TotalDays = E101 + E103 + E105; //+ Sitting;

        double score = TotalMET / (7.0 * 24.0);

        // HIGH
        if ((E101 >= 3 && TotalMET >= 1500) || (E105 >= 7 && TotalMET >= 3000)) {
            scoreIPAQ = "HIGH";
        }
        // MODREATE
        else if ((E105 >= 7 && E106x >= 30) || (E101 >= 3) || (E103 >= 5) || (TotalDays >= 5 && TotalMET >= 600)) {
            scoreIPAQ = "MODREATE";
        }
        // LOW
        else {
            scoreIPAQ = "LOW";
        }

  /*      if (getE109() < 7.0) {
            score += 1.0;
        } else if (E109 >= 9.0) {
            score += 2.0;
        }*/

        // scoreIPAQ = score;
    }

    public void calculateWHO5Score() {

        int H101 = Integer.parseInt(getH101().equals("") ? "0" : getH101());
        int H102 = Integer.parseInt(getH102().equals("") ? "0" : getH102());
        int H103 = Integer.parseInt(getH103().equals("") ? "0" : getH103());
        int H104 = Integer.parseInt(getH104().equals("") ? "0" : getH104());
        int H105 = Integer.parseInt(getH105().equals("") ? "0" : getH105());

        // Calculate WHO-5 score
        int who5Score = H101 + H102 + H103 + H104 + H105;

        scoreWHO5 = String.valueOf(who5Score);
    }
}
