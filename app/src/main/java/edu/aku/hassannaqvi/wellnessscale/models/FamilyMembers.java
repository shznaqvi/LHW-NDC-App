package edu.aku.hassannaqvi.wellnessscale.models;

import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.wellnessscale.core.MainApp._EMPTY_;
import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.form;

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

    public enum RiskOutcome {
        VERY_HIGH,
        HIGH_MEDIUM,
        LOW
    }
    // FIELD VARIABLES

    public String a103 = _EMPTY_;
    public String a104 = _EMPTY_;
    public String a105 = _EMPTY_;
    public String a106 = _EMPTY_;
    public String a10696x = _EMPTY_;
    public String a107 = _EMPTY_;
    public String a108 = _EMPTY_;
    public String a110 = _EMPTY_;
    public String b101 = _EMPTY_;
    public String b102 = _EMPTY_;
    public String c101 = _EMPTY_;
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
    public String c108 = _EMPTY_;
    public String c109 = _EMPTY_;
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

    // F1: Eating Out
    public String f101 = _EMPTY_;
    public String f102 = _EMPTY_;
    public String f103 = _EMPTY_;
    public String f104 = _EMPTY_;
    public String f105 = _EMPTY_;
    public String f106 = _EMPTY_;
    public String f107 = _EMPTY_;
    public String f108 = _EMPTY_;

    // F1: Food Frequency
    public String f109 = _EMPTY_;
    public String f110 = _EMPTY_;
    public String f111 = _EMPTY_;
    public String f112 = _EMPTY_;
    public String f113 = _EMPTY_;
    public String f114 = _EMPTY_;

    // F1: Beverage Frequency
    public String f115 = _EMPTY_;
    public String f116 = _EMPTY_;
    public String f117 = _EMPTY_;

    // F1: Beverage Frequency - Additional Questions
    public String f118 = _EMPTY_;
    public String f119 = _EMPTY_;

    public String g101 = _EMPTY_;
    // public String g108 = _EMPTY_;
    public String g102 = _EMPTY_;
    public String g103 = _EMPTY_;
    public String g104 = _EMPTY_;
    public String g10498 = _EMPTY_;
    public String g104a = _EMPTY_;
    public String g105 = _EMPTY_;
    public String g10598 = _EMPTY_;
    public String g105a = _EMPTY_;
    public String g10601d = _EMPTY_;
    public String g1060188 = _EMPTY_;
    public String g10601w = _EMPTY_;
    public String g10602d = _EMPTY_;
    public String g1060288 = _EMPTY_;
    public String g10602w = _EMPTY_;
    public String g10603w = _EMPTY_;
    public String g10603d = _EMPTY_;
    public String g1060388 = _EMPTY_;

    public String g10604d = _EMPTY_;
    public String g1060488 = _EMPTY_;

    public String g10604w = _EMPTY_;
    public String g10605d = _EMPTY_;
    public String g1060588 = _EMPTY_;

    public String g10605w = _EMPTY_;
    public String g10606d = _EMPTY_;
    public String g1060688 = _EMPTY_;

    public String g10606w = _EMPTY_;
    public String g10696d = _EMPTY_;
    public String g1069688 = _EMPTY_;

    public String g10696w = _EMPTY_;
    public String g107 = _EMPTY_;
    public String g10801w = _EMPTY_;
    public String g10802w = _EMPTY_;
    public String g10803w = _EMPTY_;
    public String g10804w = _EMPTY_;
    public String g10805w = _EMPTY_;
    public String g10806w = _EMPTY_;
   // public String g10807w = _EMPTY_;
    public String g10896 = _EMPTY_;
    public String g10896x = _EMPTY_;
    public String g10896w = _EMPTY_;
    public String g201 = _EMPTY_;
    public String g202 = _EMPTY_;
    public String g203 = _EMPTY_;
    public String g204 = _EMPTY_;
    public String g20498 = _EMPTY_;
    public String g204a = _EMPTY_;
    public String g205 = _EMPTY_;
    public String g20598 = _EMPTY_;
    public String g205a = _EMPTY_;
    public String g20601d = _EMPTY_;
    public String g2060188 = _EMPTY_;
    public String g20601w = _EMPTY_;
    public String g20602d = _EMPTY_;
    public String g2060288 = _EMPTY_;
    public String g20602w = _EMPTY_;
    public String g20603w = _EMPTY_;
    public String g20603d = _EMPTY_;
    public String g2060388 = _EMPTY_;
    public String g20604d = _EMPTY_;
    public String g2060488 = _EMPTY_;
    public String g20604w = _EMPTY_;
    public String g20696d = _EMPTY_;
    public String g2069688 = _EMPTY_;
    public String g20696w = _EMPTY_;
    public String g207 = _EMPTY_;
    public String g20801w = _EMPTY_;
    public String g20802w = _EMPTY_;
    public String g20803w = _EMPTY_;
    public String g20804w = _EMPTY_;
    public String g20896w = _EMPTY_;
    //public String g20896 = _EMPTY_;
    public String g209 = _EMPTY_;


    public String h101 = _EMPTY_;
    public String h102 = _EMPTY_;
    public String h103 = _EMPTY_;
    public String h104 = _EMPTY_;
    public String h105 = _EMPTY_;
    // public String h106 = _EMPTY_;
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
   /* private String iStatus = _EMPTY_;
    private String iStatus96x = _EMPTY_;*/
    private String synced = _EMPTY_;
    private String syncDate = _EMPTY_;
    private String sno = _EMPTY_;
    // SECTION VARIABLES
    //private String sH3 = _EMPTY_;
   // private String memCate = _EMPTY_;
    private int scoreRapid = 0;
    //private boolean expanded;
   // private boolean mwra;
    private int scoreRose; // 1: Angina; 2: Exertion
    private int scoreQVSFS; // 0 - 8
    private String scoreIPAQ; // 0 - 8
    private int painGrade;
    private String scoreWHO5 = _EMPTY_;
    private double totalMet;
     public boolean strokeResult = false;
    public boolean anginaResult = false;
    public boolean mentalResult = false;
    public boolean diabetesResult = false;
    public boolean hypertensionResult = false;
    private String riskOutcome;
    // private String indexed;


    public FamilyMembers() {

/*        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setAppver(MainApp.appInfo.getAppVersion());
        setAppver(MainApp.appInfo.getAppVersion());*/
        //setDistCode(MainApp.hhForm.getDistrict());


    }

    public String getScoreWHO5() {
        return scoreWHO5;
    }

    public void setScoreWHO5(String scoreWHO5) {
        this.scoreWHO5 = scoreWHO5;
    }

    public void populateMeta() {

        setSysDate(form.getSysDate());
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setUuid(MainApp.form.getUid());  // not applicable in Form table
        setAppver(MainApp.appInfo.getAppVersion());
        setSno(String.valueOf(MainApp.memberCount+1));
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

/*    @Bindable
    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        notifyChange(BR.expanded);
    }*/

    public String getDistCode() {
        return distCode;
    }

    public void setDistCode(String distCode) {
        this.distCode = distCode;
    }

   /* @Bindable
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
    }*/

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

   /* public String getiStatus() {
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
    }*/

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

/*    public String getsH3() {
        return sH3;
    }

    public void setsH3(String sH3) {
        this.sH3 = sH3;
    }*/


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
        setA10696x(!a106.equals("96")? "": a10696x);
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
    public String getA110() {
        return a110;
    }

    public void setA110(String a110) {
        this.a110 = a110;
        setA106(a110.equals("2")? "": a106);
        setA107(a110.equals("2")? "": a107);
        setA108(a110.equals("2")? "": a108);
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
    public double getTotalMet() {
        return totalMet;
    }

    public void setTotalMet(double tm) {
        this.totalMet = tm;
        notifyChange(BR.totalMet);
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
    public String getC108() {
        return c108;
    }

    public void setC108(String c108) {
        this.c108 = c108;
        hypertensionResult = c108.equals("1");
        notifyChange(BR.c108);
    }

    @Bindable
    public String getC109() {
        return c109;
    }

    public void setC109(String c109) {
        this.c109 = c109;
        notifyChange(BR.c109);
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
    public String getF101() {
        return f101;
    }

    public void setF101(String f101) {
        this.f101 = f101;
        setF104(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f104);
        setF105(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f105);
        setF106(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f106);
        setF107(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f107);
        setF108(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f108);
        notifyChange(BR.f101);
    }

    @Bindable
    public String getF102() {
        return f102;
    }

    public void setF102(String f102) {
        this.f102 = f102;
        setF104(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f104);
        setF105(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f105);
        setF106(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f106);
        setF107(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f107);
        setF108(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f108);
        notifyChange(BR.f102);
    }

    @Bindable
    public String getF103() {
        return f103;
    }

    public void setF103(String f103) {
        this.f103 = f103;
        setF104(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f104);
        setF105(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f105);
        setF106(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f106);
        setF107(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f107);
        setF108(f101.equals("5")&&f102.equals("5")&&f103.equals("5")? "" : f108);
        notifyChange(BR.f103);
    }

    @Bindable
    public String getF104() {
        return f104;
    }

    public void setF104(String f104) {
        this.f104 = f104;
        notifyChange(BR.f104);
    }

    @Bindable
    public String getF105() {
        return f105;
    }

    public void setF105(String f105) {
        this.f105 = f105;
        notifyChange(BR.f105);
    }

    @Bindable
    public String getF106() {
        return f106;
    }

    public void setF106(String f106) {
        this.f106 = f106;
        notifyChange(BR.f106);
    }

    @Bindable
    public String getF107() {
        return f107;
    }

    public void setF107(String f107) {
        this.f107 = f107;
        notifyChange(BR.f107);
    }

    @Bindable
    public String getF108() {
        return f108;
    }

    public void setF108(String f108) {
        this.f108 = f108;
        notifyChange(BR.f108);
    }

    @Bindable
    public String getF109() {
        return f109;
    }

    public void setF109(String f109) {
        this.f109 = f109;
        notifyChange(BR.f109);
    }

    @Bindable
    public String getF110() {
        return f110;
    }

    public void setF110(String f110) {
        this.f110 = f110;
        notifyChange(BR.f110);
    }

    @Bindable
    public String getF111() {
        return f111;
    }

    public void setF111(String f111) {
        this.f111 = f111;
        notifyChange(BR.f111);
    }

    @Bindable
    public String getF112() {
        return f112;
    }

    public void setF112(String f112) {
        this.f112 = f112;
        notifyChange(BR.f112);
    }

    @Bindable
    public String getF113() {
        return f113;
    }

    public void setF113(String f113) {
        this.f113 = f113;
        notifyChange(BR.f113);
    }

    @Bindable
    public String getF114() {
        return f114;
    }

    public void setF114(String f114) {
        this.f114 = f114;
        notifyChange(BR.f114);
    }

    @Bindable
    public String getF115() {
        return f115;
    }

    public void setF115(String f115) {
        this.f115 = f115;
        notifyChange(BR.f115);
    }

    @Bindable
    public String getF116() {
        return f116;
    }

    public void setF116(String f116) {
        this.f116 = f116;
        notifyChange(BR.f116);
    }

    @Bindable
    public String getF117() {
        return f117;
    }

    public void setF117(String f117) {
        this.f117 = f117;
        setF118(f117.equals("5")?"":f118);
        setF119(f117.equals("5")?"":f119);
        notifyChange(BR.f117);
    }

    @Bindable
    public String getF118() {
        return f118;
    }

    public void setF118(String f118) {
        this.f118 = f118;
        notifyChange(BR.f118);
    }

    @Bindable
    public String getF119() {
        return f119;
    }

    public void setF119(String f119) {
        this.f119 = f119;
        notifyChange(BR.f119);
    }

/*    @Bindable
    public String getG108() {
        return g108;
    }

    public void setG108(String g108) {
        this.g108 = g108;
        notifyChange(BR.g108);
    }*/

    @Bindable
    public String getG101() {
        return g101;
    }

    public void setG101(String g101) {
        this.g101 = g101;

        setG102(g101.equals("2") ? g102 : "");
        setG103(g101.equals("3") ? g103 : "");

          setG1060188(!g101.equals("1")? "":g1060188);
        setG10601d(!g101.equals("1")? "":g10601d);
        setG10601w(!g101.equals("1")? "":g10601w);
        setG1060288(!g101.equals("1")? "":g1060288);
        setG10602d(!g101.equals("1")? "":g10602d);
        setG10602w(!g101.equals("1")? "":g10602w);
        setG1060388(!g101.equals("1")? "":g1060388);
        setG10603d(!g101.equals("1")? "":g10603d);
        setG10603w(!g101.equals("1")? "":g10603w);
        setG1060488(!g101.equals("1")? "":g1060488);
        setG10604d(!g101.equals("1")? "":g10604d);
        setG10604w(!g101.equals("1")? "":g10604w);
        setG1060588(!g101.equals("1")? "":g1060588);
        setG10605d(!g101.equals("1")? "":g10605d);
        setG10605w(!g101.equals("1")? "":g10605w);
        setG1060688(!g101.equals("1")? "":g1060688);
        setG10606d(!g101.equals("1")? "":g10606d);
        setG10606w(!g101.equals("1")? "":g10606w);
        setG1069688(!g101.equals("1")? "":g1069688);
        setG10696d(!g101.equals("1")? "":g10696d);
        setG10696w(!g101.equals("1")? "":g10696w);
        setG107(!g101.equals("1")? "":g107);


        //skip for G101 when 98 or 99
        setG102(g101.equals("98")||g101.equals("99")? "":g102);
        setG103(g101.equals("98")||g101.equals("99")? "":g103);
        setG104(g101.equals("98")||g101.equals("99")? "":g104);
        setG10498(g101.equals("98")||g101.equals("99")? "":g10498);
        setG104a(g101.equals("98")||g101.equals("99")? "":g104a);
        setG105(g101.equals("98")||g101.equals("99")? "":g105);
        setG105a(g101.equals("98")||g101.equals("99")? "":g105a);
/*        setG1060188(g101.equals("98")||g101.equals("99")? "":g1060188);
        setG10601d(g101.equals("98")||g101.equals("99")? "":g10601d);
        setG10601w(g101.equals("98")||g101.equals("99")? "":g10601w);
        setG1060288(g101.equals("98")||g101.equals("99")? "":g1060288);
        setG10602d(g101.equals("98")||g101.equals("99")? "":g10602d);
        setG10602w(g101.equals("98")||g101.equals("99")? "":g10602w);
        setG1060388(g101.equals("98")||g101.equals("99")? "":g1060388);
        setG10603d(g101.equals("98")||g101.equals("99")? "":g10603d);
        setG10603w(g101.equals("98")||g101.equals("99")? "":g10603w);
        setG1060488(g101.equals("98")||g101.equals("99")? "":g1060488);
        setG10604d(g101.equals("98")||g101.equals("99")? "":g10604d);
        setG10604w(g101.equals("98")||g101.equals("99")? "":g10604w);
        setG1060588(g101.equals("98")||g101.equals("99")? "":g1060588);
        setG10605d(g101.equals("98")||g101.equals("99")? "":g10605d);
        setG10605w(g101.equals("98")||g101.equals("99")? "":g10605w);
        setG1060688(g101.equals("98")||g101.equals("99")? "":g1060688);
        setG10606d(g101.equals("98")||g101.equals("99")? "":g10606d);
        setG10606w(g101.equals("98")||g101.equals("99")? "":g10606w);
        setG1069688(g101.equals("98")||g101.equals("99")? "":g1069688);
        setG10696d(g101.equals("98")||g101.equals("99")? "":g10696d);
        setG10696w(g101.equals("98")||g101.equals("99")? "":g10696w);
        setG107(g101.equals("98")||g101.equals("99")? "":g107);*/
        setG10801w(g101.equals("98")||g101.equals("99")? "":g10801w);
        setG10802w(g101.equals("98")||g101.equals("99")? "":g10802w);
        setG10803w(g101.equals("98")||g101.equals("99")? "":g10803w);
        setG10804w(g101.equals("98")||g101.equals("99")? "":g10804w);
        setG10805w(g101.equals("98")||g101.equals("99")? "":g10805w);
        setG10806w(g101.equals("98")||g101.equals("99")? "":g10806w);
        //setG10807w(g101.equals("98")||g101.equals("99")? "":g10807w);
        setG10896(g101.equals("98")||g101.equals("99")? "":g10896);
        
        // for G209
        setG209(g101.equals("2")||g102.equals("2")? g209:"");



        notifyChange(BR.g101);
    }

    @Bindable
    public String getG102() {
        return g102;
    }

    public void setG102(String g102) {
        this.g102 = g102;

        /// skip for Bcomp1
      /*  setG1060188(!g102.equals("2")? "":g1060188);
        setG10601d(!g102.equals("2")? "":g10601d);
        setG10601w(!g102.equals("2")? "":g10601w);
        setG1060288(!g102.equals("2")? "":g1060288);
        setG10602d(!g102.equals("2")? "":g10602d);
        setG10602w(!g102.equals("2")? "":g10602w);
        setG1060388(!g102.equals("2")? "":g1060388);
        setG10603d(!g102.equals("2")? "":g10603d);
        setG10603w(!g102.equals("2")? "":g10603w);
        setG1060488(!g102.equals("2")? "":g1060488);
        setG10604d(!g102.equals("2")? "":g10604d);
        setG10604w(!g102.equals("2")? "":g10604w);
        setG1060588(!g102.equals("2")? "":g1060588);
        setG10605d(!g102.equals("2")? "":g10605d);
        setG10605w(!g102.equals("2")? "":g10605w);
        setG1060688(!g102.equals("2")? "":g1060688);
        setG10606d(!g102.equals("2")? "":g10606d);
        setG10606w(!g102.equals("2")? "":g10606w);
        setG1069688(!g102.equals("2")? "":g1069688);
        setG10696d(!g102.equals("2")? "":g10696d);
        setG10696w(!g102.equals("2")? "":g10696w);
        setG107(!g102.equals("2")? "":g107);*/

        /// skip for Bcomp2
        setG10801w(g102.equals("1") || g102.equals("2") ? g10801w:"");
        setG10802w(!g102.equals("1")? "":g10802w);
        setG10803w(!g102.equals("1")? "":g10803w);
        setG10804w(!g102.equals("1")? "":g10804w);
        setG10805w(!g102.equals("1")? "":g10805w);
        setG10806w(!g102.equals("1")? "":g10806w);
        //setG10807w(!g102.equals("1")? "":g10807w);
        setG10896(!g102.equals("1")? "":g10896);
        
        // setG105(g101.equals("1") || g102.equals("1") || g103.equals("1") ? g105 : "");


        //skip for G102 when 98 or 99
        setG103(g102.equals("98")||g102.equals("99")? "":g103);
        setG104(g102.equals("98")||g102.equals("99")? "":g104);
        setG10498(g102.equals("98")||g102.equals("99")? "":g10498);
        setG104a(g102.equals("98")||g102.equals("99")? "":g104a);
        setG105(g102.equals("98")||g102.equals("99")? "":g105);
        setG10598(g102.equals("98")||g102.equals("99")? "":g10598);
        setG105a(g102.equals("98")||g102.equals("99")? "":g105a);
        setG10896(g102.equals("98")||g102.equals("99")? "":g10896);
        /*setG1060188(g102.equals("98")||g102.equals("99")? "":g1060188);
        setG10601d(g102.equals("98")||g102.equals("99")? "":g10601d);
        setG10601w(g102.equals("98")||g102.equals("99")? "":g10601w);
        setG1060288(g102.equals("98")||g102.equals("99")? "":g1060288);
        setG10602d(g102.equals("98")||g102.equals("99")? "":g10602d);
        setG10602w(g102.equals("98")||g102.equals("99")? "":g10602w);
        setG1060388(g102.equals("98")||g102.equals("99")? "":g1060388);
        setG10603d(g102.equals("98")||g102.equals("99")? "":g10603d);
        setG10603w(g102.equals("98")||g102.equals("99")? "":g10603w);
        setG1060488(g102.equals("98")||g102.equals("99")? "":g1060488);
        setG10604d(g102.equals("98")||g102.equals("99")? "":g10604d);
        setG10604w(g102.equals("98")||g102.equals("99")? "":g10604w);
        setG1060588(g102.equals("98")||g102.equals("99")? "":g1060588);
        setG10605d(g102.equals("98")||g102.equals("99")? "":g10605d);
        setG10605w(g102.equals("98")||g102.equals("99")? "":g10605w);
        setG1060688(g102.equals("98")||g102.equals("99")? "":g1060688);
        setG10606d(g102.equals("98")||g102.equals("99")? "":g10606d);
        setG10606w(g102.equals("98")||g102.equals("99")? "":g10606w);
        setG1069688(g102.equals("98")||g102.equals("99")? "":g1069688);
        setG10696d(g102.equals("98")||g102.equals("99")? "":g10696d);
        setG10696w(g102.equals("98")||g102.equals("99")? "":g10696w);
        setG107(g102.equals("98")||g102.equals("99")? "":g107);*/


        notifyChange(BR.g102);
    }

    @Bindable
    public String getG103() {
        return g103;
    }

    public void setG103(String g103) {
        this.g103 = g103;


        //skip for G103 when 98 or 99

        boolean g103Check = g103.equals("3") || g103.equals("98") || g103.equals("99");
        setG104(g103Check ? "":g104);
        setG10498(g103Check ? "":g10498);
        setG104a(g103Check ? "":g104a);
        setG105(g103Check ? "":g105);
        setG10598(g103Check ? "":g10598);
        setG105a(g103Check ? "":g105a);
       /* setG1060188(g103Check ? "":g1060188);
        setG10601d(g103Check ? "":g10601d);
        setG10601w(g103Check ? "":g10601w);
        setG1060288(g103Check ? "":g1060288);
        setG10602d(g103Check ? "":g10602d);
        setG10602w(g103Check ? "":g10602w);
        setG1060388(g103Check ? "":g1060388);
        setG10603d(g103Check ? "":g10603d);
        setG10603w(g103Check ? "":g10603w);
        setG1060488(g103Check ? "":g1060488);
        setG10604d(g103Check ? "":g10604d);
        setG10604w(g103Check ? "":g10604w);
        setG1060588(g103Check ? "":g1060588);
        setG10605d(g103Check ? "":g10605d);
        setG10605w(g103Check ? "":g10605w);
        setG1060688(g103Check ? "":g1060688);
        setG10606d(g103Check ? "":g10606d);
        setG10606w(g103Check ? "":g10606w);
        setG1069688(g103Check ? "":g1069688);
        setG10696d(g103Check ? "":g10696d);
        setG10696w(g103Check ? "":g10696w);
        setG107(g103Check ? "":g107);*/
        setG10801w(g103Check ? "":g10801w);
        setG10802w(g103Check ? "":g10802w);
        setG10803w(g103Check ? "":g10803w);
        setG10804w(g103Check ? "":g10804w);
        setG10805w(g103Check ? "":g10805w);
        setG10806w(g103Check ? "":g10806w);
        //setG10807w(g103Check ? "":g10807w);
        setG10896(g103Check ? "":g10896);


        notifyChange(BR.g103);
    }

    @Bindable
    public String getG104() {
        return g104;
    }

    public void setG104(String g104) {
        this.g104 = g104;
        setG105(g101.equals("1") || g102.equals("1") || g103.equals("1") ? g105 : "");
        setG10598(g101.equals("1") || g102.equals("1") || g103.equals("1") ? g10598 : "");
        notifyChange(BR.g104);
    }
 @Bindable
    public String getG10498() {
        return g10498;
    }

    public void setG10498(String g10498) {
        this.g10498 = g10498;

        setG104(g10498.equals("98") ? "" : this.g104);
        setG104a(g10498.equals("98") ? this.g104a:"");

        notifyChange(BR.g10498);
    }

    @Bindable
    public String getG104a() {
        return g104a;
    }

    public void setG104a(String g104a) {
        this.g104a = g104a;
        notifyChange(BR.g104a);
    }

    @Bindable
    public String getG105() {
        return g105;
    }

    public void setG105(String g105) {
        this.g105 = g105;
        notifyChange(BR.g105);
    }
    @Bindable
    public String getG10598() {
        return g10598;
    }

    public void setG10598(String g10598) {
        this.g10598 = g10598;
        setG105(g10598.equals("98") ? "" : this.g105);
        setG105a(g10598.equals("98") ? this.g105a:"");
        
        notifyChange(BR.g10598);
    }

    @Bindable
    public String getG105a() {
        return g105a;
    }

    public void setG105a(String g105a) {
        this.g105a = g105a;
        notifyChange(BR.g105a);
    }

    @Bindable
    public String getG10601d() {
        return g10601d;
    }

    public void setG10601d(String g10601d) {
        this.g10601d = g10601d;
        notifyChange(BR.g10601d);
    }

    @Bindable
    public String getG1060188() {
        return g1060188;
    }

    public void setG1060188(String g1060188) {
        this.g1060188 = g1060188;
        setG10601d(g1060188.equals("88") ? "" : this.g10601d);
        setG10601w(g1060188.equals("88") ? this.g10601w : "");
        notifyChange(BR.g1060188);
    }

    @Bindable
    public String getG10601w() {
        return g10601w;
    }

    public void setG10601w(String g10601w) {
        this.g10601w = g10601w;
        notifyChange(BR.g10601w);
    }

    @Bindable
    public String getG10602d() {
        return g10602d;
    }

    public void setG10602d(String g10602d) {
        this.g10602d = g10602d;
        notifyChange(BR.g10602d);
    }

    @Bindable
    public String getG1060288() {
        return g1060288;
    }

    public void setG1060288(String g1060288) {
        this.g1060288 = g1060288;
        setG10602d(g1060288.equals("88") ? "" : this.g10602d);
        setG10602w(g1060288.equals("88") ? this.g10602w : "");
        notifyChange(BR.g1060288);
    }

    @Bindable
    public String getG10602w() {
        return g10602w;
    }

    public void setG10602w(String g10602w) {
        this.g10602w = g10602w;
        notifyChange(BR.g10602w);
    }

    @Bindable
    public String getG10603w() {
        return g10603w;
    }

    public void setG10603w(String g10603w) {
        this.g10603w = g10603w;
        notifyChange(BR.g10603w);
    }

    @Bindable
    public String getG10603d() {
        return g10603d;
    }

    public void setG10603d(String g10603d) {
        this.g10603d = g10603d;
        notifyChange(BR.g10603d);
    }

    @Bindable
    public String getG1060388() {
        return g1060388;
    }

    public void setG1060388(String g1060388) {
        this.g1060388 = g1060388;
        setG10603d(g1060388.equals("88") ? "" : this.g10603d);
        setG10603w(g1060388.equals("88") ? this.g10603w : "");
        notifyChange(BR.g1060388);
    }

    @Bindable
    public String getG10604d() {
        return g10604d;
    }

    public void setG10604d(String g10604d) {
        this.g10604d = g10604d;
        notifyChange(BR.g10604d);
    }

    @Bindable
    public String getG1060488() {
        return g1060488;
    }

    public void setG1060488(String g1060488) {
        this.g1060488 = g1060488;
        setG10604d(g1060488.equals("88") ? "" : this.g10604d);
        setG10604w(g1060488.equals("88") ? this.g10604w : "");

        notifyChange(BR.g1060488);
    }

    @Bindable
    public String getG10604w() {
        return g10604w;
    }

    public void setG10604w(String g10604w) {
        this.g10604w = g10604w;
        notifyChange(BR.g10604w);
    }

    @Bindable
    public String getG10605d() {
        return g10605d;
    }

    public void setG10605d(String g10605d) {
        this.g10605d = g10605d;
        notifyChange(BR.g10605d);
    }

    @Bindable
    public String getG1060588() {
        return g1060588;
    }

    public void setG1060588(String g1060588) {
        this.g1060588 = g1060588;
        setG10605d(g1060588.equals("88") ? "" : this.g10605d);
        setG10605w(g1060588.equals("88") ? this.g10605w : "");
        notifyChange(BR.g1060588);
    }

    @Bindable
    public String getG10605w() {
        return g10605w;
    }

    public void setG10605w(String g10605w) {
        this.g10605w = g10605w;
        notifyChange(BR.g10605w);
    }

    @Bindable
    public String getG10606d() {
        return g10606d;
    }

    public void setG10606d(String g10606d) {
        this.g10606d = g10606d;
        notifyChange(BR.g10606d);
    }

    @Bindable
    public String getG1060688() {
        return g1060688;
    }

    public void setG1060688(String g1060688) {
        this.g1060688 = g1060688;
        setG10606d(g1060688.equals("88") ? "" : this.g10606d);
        setG10606w(g1060688.equals("88") ? this.g10606w : "");
        notifyChange(BR.g1060688);
    }

    @Bindable
    public String getG10606w() {
        return g10606w;
    }

    public void setG10606w(String g10606w) {
        this.g10606w = g10606w;
        notifyChange(BR.g10606w);
    }

    @Bindable
    public String getG10696d() {
        return g10696d;
    }

    public void setG10696d(String g10696d) {
        this.g10696d = g10696d;
        notifyChange(BR.g10696d);
    }

    @Bindable
    public String getG1069688() {
        return g1069688;
    }

    public void setG1069688(String g1069688) {
        this.g1069688 = g1069688;
        setG10696d(g1069688.equals("88") ? "" : this.g10696d);
        setG10696w(g1069688.equals("88") ? this.g10696w : "");
        notifyChange(BR.g1069688);
    }

    @Bindable
    public String getG10696w() {
        return g10696w;
    }

    public void setG10696w(String g10696w) {
        this.g10696w = g10696w;
        notifyChange(BR.g10696w);
    }

    @Bindable
    public String getG107() {
        return g107;
    }

    public void setG107(String g107) {
        this.g107 = g107;
        notifyChange(BR.g107);
    }

    @Bindable
    public String getG10801w() {
        return g10801w;
    }

    public void setG10801w(String value) {
        g10801w = value;
        notifyChange(BR.g10801w);
    }

    @Bindable
    public String getG10802w() {
        return g10802w;
    }

    public void setG10802w(String value) {
        g10802w = value;
        notifyChange(BR.g10802w);
    }

    @Bindable
    public String getG10803w() {
        return g10803w;
    }

    public void setG10803w(String value) {
        g10803w = value;
        notifyChange(BR.g10803w);
    }

    @Bindable
    public String getG10804w() {
        return g10804w;
    }

    public void setG10804w(String value) {
        g10804w = value;
        notifyChange(BR.g10804w);
    }

    @Bindable
    public String getG10805w() {
        return g10805w;
    }

    public void setG10805w(String value) {
        g10805w = value;
        notifyChange(BR.g10805w);
    }

    @Bindable
    public String getG10806w() {
        return g10806w;
    }

    public void setG10806w(String value) {
        g10806w = value;
        notifyChange(BR.g10806w);
    }

   /* @Bindable
    public String getG10807w() {
        return g10807w;
    }

    public void setG10807w(String value) {
        g10807w = value;
        notifyChange(BR.g10807w);
    }*/
    @Bindable
    public String getG10896() {
        return g10896;
    }

    public void setG10896(String value) {
        g10896 = value;
        setG10896x(value.equals("98")? g10896x:"");
        setG10896w(value.equals("98")? g10896w:"");
        notifyChange(BR.g10896);
    }
    @Bindable
    public String getG10896w() {
        return g10896w;
    }

    public void setG10896w(String value) {
        g10896w = value;
        notifyChange(BR.g10896w);
    }
    @Bindable
    public String getG10896x() {
        return g10896x;
    }

    public void setG10896x(String value) {
        g10896x = value;
        notifyChange(BR.g10896x);
    }

    @Bindable
    public String getG201() {
        return g201;
    }

    public void setG201(String g201) {
        this.g201 = g201;

        setG202(g201.equals("2") ? g202 : "");
        setG203(g201.equals("3") ? g203 : "");

        setG2060188(!g201.equals("1")? "":g2060188);
        setG20601d(!g201.equals("1")? "":g20601d);
        setG20601w(!g201.equals("1")? "":g20601w);
        setG2060288(!g201.equals("1")? "":g2060288);
        setG20602d(!g201.equals("1")? "":g20602d);
        setG20602w(!g201.equals("1")? "":g20602w);
        setG2060388(!g201.equals("1")? "":g2060388);
        setG20603d(!g201.equals("1")? "":g20603d);
        setG20603w(!g201.equals("1")? "":g20603w);
        setG2060488(!g201.equals("1")? "":g2060488);
        setG20604d(!g201.equals("1")? "":g20604d);
        setG20604w(!g201.equals("1")? "":g20604w);
      /*  setG2060588(!g201.equals("1")? "":g2060588);
        setG20605d(!g201.equals("1")? "":g20605d);
        setG20605w(!g201.equals("1")? "":g20605w);
        setG2060688(!g201.equals("1")? "":g2060688);
        setG20606d(!g201.equals("1")? "":g20606d);
        setG20606w(!g201.equals("1")? "":g20606w);*/
        setG2069688(!g201.equals("1")? "":g2069688);
        setG20696d(!g201.equals("1")? "":g20696d);
        setG20696w(!g201.equals("1")? "":g20696w);
        setG207(!g201.equals("1")? "":g207);


        //skip for G201 when 98 or 99
        setG202(g201.equals("98")||g201.equals("99")? "":g202);
        setG203(g201.equals("98")||g201.equals("99")? "":g203);
        setG204(g201.equals("98")||g201.equals("99")? "":g204);
        setG20498(g201.equals("98")||g201.equals("99")? "":g20498);
        setG204a(g201.equals("98")||g201.equals("99")? "":g204a);
        setG205(g201.equals("98")||g201.equals("99")? "":g205);
        setG205a(g201.equals("98")||g201.equals("99")? "":g205a);
/*        setG2060188(g201.equals("98")||g201.equals("99")? "":g2060188);
        setG20601d(g201.equals("98")||g201.equals("99")? "":g20601d);
        setG20601w(g201.equals("98")||g201.equals("99")? "":g20601w);
        setG2060288(g201.equals("98")||g201.equals("99")? "":g2060288);
        setG20602d(g201.equals("98")||g201.equals("99")? "":g20602d);
        setG20602w(g201.equals("98")||g201.equals("99")? "":g20602w);
        setG2060388(g201.equals("98")||g201.equals("99")? "":g2060388);
        setG20603d(g201.equals("98")||g201.equals("99")? "":g20603d);
        setG20603w(g201.equals("98")||g201.equals("99")? "":g20603w);
        setG2060488(g201.equals("98")||g201.equals("99")? "":g2060488);
        setG20604d(g201.equals("98")||g201.equals("99")? "":g20604d);
        setG20604w(g201.equals("98")||g201.equals("99")? "":g20604w);
        setG2060588(g201.equals("98")||g201.equals("99")? "":g2060588);
        setG20605d(g201.equals("98")||g201.equals("99")? "":g20605d);
        setG20605w(g201.equals("98")||g201.equals("99")? "":g20605w);
        setG2060688(g201.equals("98")||g201.equals("99")? "":g2060688);
        setG20606d(g201.equals("98")||g201.equals("99")? "":g20606d);
        setG20606w(g201.equals("98")||g201.equals("99")? "":g20606w);
        setG2069688(g201.equals("98")||g201.equals("99")? "":g2069688);
        setG20696d(g201.equals("98")||g201.equals("99")? "":g20696d);
        setG20696w(g201.equals("98")||g201.equals("99")? "":g20696w);
        setG207(g201.equals("98")||g201.equals("99")? "":g207);*/
        setG20801w(g201.equals("98")||g201.equals("99")? "":g20801w);
        setG20802w(g201.equals("98")||g201.equals("99")? "":g20802w);
        setG20803w(g201.equals("98")||g201.equals("99")? "":g20803w);
        setG20804w(g201.equals("98")||g201.equals("99")? "":g20804w);
/*        setG20805w(g201.equals("98")||g201.equals("99")? "":g20805w);
        setG20806w(g201.equals("98")||g201.equals("99")? "":g20806w);
        setG20807w(g201.equals("98")||g201.equals("99")? "":g20807w);*/

        // for G209
        setG209(g201.equals("2")||g202.equals("2")? g209:"");



        notifyChange(BR.g201);
    }

    @Bindable
    public String getG202() {
        return g202;
    }

    public void setG202(String g202) {
        this.g202 = g202;

        /// skip for Bcomp1
      /*  setG2060188(!g202.equals("2")? "":g2060188);
        setG20601d(!g202.equals("2")? "":g20601d);
        setG20601w(!g202.equals("2")? "":g20601w);
        setG2060288(!g202.equals("2")? "":g2060288);
        setG20602d(!g202.equals("2")? "":g20602d);
        setG20602w(!g202.equals("2")? "":g20602w);
        setG2060388(!g202.equals("2")? "":g2060388);
        setG20603d(!g202.equals("2")? "":g20603d);
        setG20603w(!g202.equals("2")? "":g20603w);
        setG2060488(!g202.equals("2")? "":g2060488);
        setG20604d(!g202.equals("2")? "":g20604d);
        setG20604w(!g202.equals("2")? "":g20604w);
        setG2060588(!g202.equals("2")? "":g2060588);
        setG20605d(!g202.equals("2")? "":g20605d);
        setG20605w(!g202.equals("2")? "":g20605w);
        setG2060688(!g202.equals("2")? "":g2060688);
        setG20606d(!g202.equals("2")? "":g20606d);
        setG20606w(!g202.equals("2")? "":g20606w);
        setG2069688(!g202.equals("2")? "":g2069688);
        setG20696d(!g202.equals("2")? "":g20696d);
        setG20696w(!g202.equals("2")? "":g20696w);
        setG207(!g202.equals("2")? "":g207);*/

        /// skip for Bcomp2
        setG20801w(g202.equals("1") || g202.equals("2") ? g20801w:"");
        setG20802w(!g202.equals("1")? "":g20802w);
        setG20803w(!g202.equals("1")? "":g20803w);
        setG20804w(!g202.equals("1")? "":g20804w);
/*        setG20805w(!g202.equals("1")? "":g20805w);
        setG20806w(!g202.equals("1")? "":g20806w);
        setG20807w(!g202.equals("1")? "":g20807w);*/

        // setG205(g201.equals("1") || g202.equals("1") || g203.equals("1") ? g205 : "");


        //skip for G202 when 98 or 99
        setG203(g202.equals("98")||g202.equals("99")? "":g203);
        setG204(g202.equals("98")||g202.equals("99")? "":g204);
        setG20498(g202.equals("98")||g202.equals("99")? "":g20498);
        setG204a(g202.equals("98")||g202.equals("99")? "":g204a);
        setG205(g202.equals("98")||g202.equals("99")? "":g205);
        setG20598(g202.equals("98")||g202.equals("99")? "":g20598);
        setG205a(g202.equals("98")||g202.equals("99")? "":g205a);
        setG2060188(g202.equals("98")||g202.equals("99")? "":g2060188);
        setG20601d(g202.equals("98")||g202.equals("99")? "":g20601d);
        setG20601w(g202.equals("98")||g202.equals("99")? "":g20601w);
        setG2060288(g202.equals("98")||g202.equals("99")? "":g2060288);
        setG20602d(g202.equals("98")||g202.equals("99")? "":g20602d);
        setG20602w(g202.equals("98")||g202.equals("99")? "":g20602w);
        setG2060388(g202.equals("98")||g202.equals("99")? "":g2060388);
        setG20603d(g202.equals("98")||g202.equals("99")? "":g20603d);
        setG20603w(g202.equals("98")||g202.equals("99")? "":g20603w);
        setG2060488(g202.equals("98")||g202.equals("99")? "":g2060488);
        setG20604d(g202.equals("98")||g202.equals("99")? "":g20604d);
        setG20604w(g202.equals("98")||g202.equals("99")? "":g20604w);
/*        setG2060588(g202.equals("98")||g202.equals("99")? "":g2060588);
        setG20605d(g202.equals("98")||g202.equals("99")? "":g20605d);
        setG20605w(g202.equals("98")||g202.equals("99")? "":g20605w);
        setG2060688(g202.equals("98")||g202.equals("99")? "":g2060688);
        setG20606d(g202.equals("98")||g202.equals("99")? "":g20606d);
        setG20606w(g202.equals("98")||g202.equals("99")? "":g20606w);*/
        setG2069688(g202.equals("98")||g202.equals("99")? "":g2069688);
        setG20696d(g202.equals("98")||g202.equals("99")? "":g20696d);
        setG20696w(g202.equals("98")||g202.equals("99")? "":g20696w);
        setG207(g202.equals("98")||g202.equals("99")? "":g207);


        notifyChange(BR.g202);
    }

    @Bindable
    public String getG203() {
        return g203;
    }

    public void setG203(String g203) {
        this.g203 = g203;


        //skip for G203 when 98 or 99

        boolean g203Check = g203.equals("3") || g203.equals("98") || g203.equals("99");
        setG204(g203Check ? "":g204);
        setG20498(g203Check ? "":g20498);
        setG204a(g203Check ? "":g204a);
        setG205(g203Check ? "":g205);
        setG20598(g203Check ? "":g20598);
        setG205a(g203Check ? "":g205a);
        setG2060188(g203Check ? "":g2060188);
        setG20601d(g203Check ? "":g20601d);
        setG20601w(g203Check ? "":g20601w);
        setG2060288(g203Check ? "":g2060288);
        setG20602d(g203Check ? "":g20602d);
        setG20602w(g203Check ? "":g20602w);
        setG2060388(g203Check ? "":g2060388);
        setG20603d(g203Check ? "":g20603d);
        setG20603w(g203Check ? "":g20603w);
        setG2060488(g203Check ? "":g2060488);
        setG20604d(g203Check ? "":g20604d);
        setG20604w(g203Check ? "":g20604w);
/*        setG2060588(g203Check ? "":g2060588);
        setG20605d(g203Check ? "":g20605d);
        setG20605w(g203Check ? "":g20605w);
        setG2060688(g203Check ? "":g2060688);
        setG20606d(g203Check ? "":g20606d);
        setG20606w(g203Check ? "":g20606w);*/
        setG2069688(g203Check ? "":g2069688);
        setG20696d(g203Check ? "":g20696d);
        setG20696w(g203Check ? "":g20696w);
        setG207(g203Check ? "":g207);
        setG20801w(g203Check ? "":g20801w);
        setG20802w(g203Check ? "":g20802w);
        setG20803w(g203Check ? "":g20803w);
        setG20804w(g203Check ? "":g20804w);
 /*       setG20805w(g203Check ? "":g20805w);
        setG20806w(g203Check ? "":g20806w);
        setG20807w(g203Check ? "":g20807w);*/

        notifyChange(BR.g203);
    }

    @Bindable
    public String getG204() {
        return g204;
    }

    public void setG204(String g204) {
        this.g204 = g204;
        setG205(g201.equals("1") || g202.equals("1") || g203.equals("1") ? g205 : "");
        setG20598(g201.equals("1") || g202.equals("1") || g203.equals("1") ? g20598 : "");
        notifyChange(BR.g204);
    }
    @Bindable
    public String getG20498() {
        return g20498;
    }

    public void setG20498(String g20498) {
        this.g20498 = g20498;

        setG204(g20498.equals("98") ? "" : this.g204);
        setG204a(g20498.equals("98") ? this.g204a:"");

        notifyChange(BR.g20498);
    }

    @Bindable
    public String getG204a() {
        return g204a;
    }

    public void setG204a(String g204a) {
        this.g204a = g204a;
        notifyChange(BR.g204a);
    }

    @Bindable
    public String getG205() {
        return g205;
    }

    public void setG205(String g205) {
        this.g205 = g205;
        notifyChange(BR.g205);
    }
    @Bindable
    public String getG20598() {
        return g20598;
    }

    public void setG20598(String g20598) {
        this.g20598 = g20598;
        setG205(g20598.equals("98") ? "" : this.g205);
        setG205a(g20598.equals("98") ? this.g205a:"");

        notifyChange(BR.g20598);
    }

    @Bindable
    public String getG205a() {
        return g205a;
    }

    public void setG205a(String g205a) {
        this.g205a = g205a;
        notifyChange(BR.g205a);
    }

    @Bindable
    public String getG20601d() {
        return g20601d;
    }

    public void setG20601d(String g20601d) {
        this.g20601d = g20601d;
        notifyChange(BR.g20601d);
    }

    @Bindable
    public String getG2060188() {
        return g2060188;
    }

    public void setG2060188(String g2060188) {
        this.g2060188 = g2060188;
        setG20601d(g2060188.equals("88") ? "" : this.g20601d);
        setG20601w(g2060188.equals("88") ? this.g20601w : "");
        notifyChange(BR.g2060188);
    }

    @Bindable
    public String getG20601w() {
        return g20601w;
    }

    public void setG20601w(String g20601w) {
        this.g20601w = g20601w;
        notifyChange(BR.g20601w);
    }

    @Bindable
    public String getG20602d() {
        return g20602d;
    }

    public void setG20602d(String g20602d) {
        this.g20602d = g20602d;
        notifyChange(BR.g20602d);
    }

    @Bindable
    public String getG2060288() {
        return g2060288;
    }

    public void setG2060288(String g2060288) {
        this.g2060288 = g2060288;
        setG20602d(g2060288.equals("88") ? "" : this.g20602d);
        setG20602w(g2060288.equals("88") ? this.g20602w : "");
        notifyChange(BR.g2060288);
    }

    @Bindable
    public String getG20602w() {
        return g20602w;
    }

    public void setG20602w(String g20602w) {
        this.g20602w = g20602w;
        notifyChange(BR.g20602w);
    }

    @Bindable
    public String getG20603w() {
        return g20603w;
    }

    public void setG20603w(String g20603w) {
        this.g20603w = g20603w;
        notifyChange(BR.g20603w);
    }

    @Bindable
    public String getG20603d() {
        return g20603d;
    }

    public void setG20603d(String g20603d) {
        this.g20603d = g20603d;
        notifyChange(BR.g20603d);
    }

    @Bindable
    public String getG2060388() {
        return g2060388;
    }

    public void setG2060388(String g2060388) {
        this.g2060388 = g2060388;
        setG20603d(g2060388.equals("88") ? "" : this.g20603d);
        setG20603w(g2060388.equals("88") ? this.g20603w : "");
        notifyChange(BR.g2060388);
    }

    @Bindable
    public String getG20604d() {
        return g20604d;
    }

    public void setG20604d(String g20604d) {
        this.g20604d = g20604d;
        notifyChange(BR.g20604d);
    }

    @Bindable
    public String getG2060488() {
        return g2060488;
    }

    public void setG2060488(String g2060488) {
        this.g2060488 = g2060488;
        setG20604d(g2060488.equals("88") ? "" : this.g20604d);
        setG20604w(g2060488.equals("88") ? this.g20604w : "");

        notifyChange(BR.g2060488);
    }

    @Bindable
    public String getG20604w() {
        return g20604w;
    }

    public void setG20604w(String g20604w) {
        this.g20604w = g20604w;
        notifyChange(BR.g20604w);
    }
/*
    @Bindable
    public String getG20605d() {
        return g20605d;
    }

    public void setG20605d(String g20605d) {
        this.g20605d = g20605d;
        notifyChange(BR.g20605d);
    }

    @Bindable
    public String getG2060588() {
        return g2060588;
    }

    public void setG2060588(String g2060588) {
        this.g2060588 = g2060588;
        setG20605d(g2060588.equals("88") ? "" : this.g20605d);
        setG20605w(g2060588.equals("88") ? this.g20605w : "");
        notifyChange(BR.g2060588);
    }

    @Bindable
    public String getG20605w() {
        return g20605w;
    }

    public void setG20605w(String g20605w) {
        this.g20605w = g20605w;
        notifyChange(BR.g20605w);
    }

    @Bindable
    public String getG20606d() {
        return g20606d;
    }

    public void setG20606d(String g20606d) {
        this.g20606d = g20606d;
        notifyChange(BR.g20606d);
    }

    @Bindable
    public String getG2060688() {
        return g2060688;
    }

    public void setG2060688(String g2060688) {
        this.g2060688 = g2060688;
        setG20606d(g2060688.equals("88") ? "" : this.g20606d);
        setG20606w(g2060688.equals("88") ? this.g20606w : "");
        notifyChange(BR.g2060688);
    }

    @Bindable
    public String getG20606w() {
        return g20606w;
    }

    public void setG20606w(String g20606w) {
        this.g20606w = g20606w;
        notifyChange(BR.g20606w);
    }*/

    @Bindable
    public String getG20696d() {
        return g20696d;
    }

    public void setG20696d(String g20696d) {
        this.g20696d = g20696d;
        notifyChange(BR.g20696d);
    }

    @Bindable
    public String getG2069688() {
        return g2069688;
    }

    public void setG2069688(String g2069688) {
        this.g2069688 = g2069688;
        setG20696d(g2069688.equals("88") ? "" : this.g20696d);
        setG20696w(g2069688.equals("88") ? this.g20696w : "");
        notifyChange(BR.g2069688);
    }

    @Bindable
    public String getG20696w() {
        return g20696w;
    }

    public void setG20696w(String g20696w) {
        this.g20696w = g20696w;
        notifyChange(BR.g20696w);
    }

    @Bindable
    public String getG207() {
        return g207;
    }

    public void setG207(String g207) {
        this.g207 = g207;
        notifyChange(BR.g207);
    }

    @Bindable
    public String getG20801w() {
        return g20801w;
    }

    public void setG20801w(String value) {
        g20801w = value;
        notifyChange(BR.g20801w);
    }

    @Bindable
    public String getG20802w() {
        return g20802w;
    }

    public void setG20802w(String value) {
        g20802w = value;
        notifyChange(BR.g20802w);
    }

    @Bindable
    public String getG20803w() {
        return g20803w;
    }

    public void setG20803w(String value) {
        g20803w = value;
        notifyChange(BR.g20803w);
    }

    @Bindable
    public String getG20804w() {
        return g20804w;
    }

    public void setG20804w(String value) {
        g20804w = value;
        notifyChange(BR.g20804w);
    }

   /* @Bindable
    public String getG20805w() {
        return g20805w;
    }

    public void setG20805w(String value) {
        g20805w = value;
        notifyChange(BR.g20805w);
    }

    @Bindable
    public String getG20806w() {
        return g20806w;
    }

    public void setG20806w(String value) {
        g20806w = value;
        notifyChange(BR.g20806w);
    }

    @Bindable
    public String getG20807w() {
        return g20807w;
    }

    public void setG20807w(String value) {
        g20807w = value;
        notifyChange(BR.g20807w);
    }*/

    @Bindable
    public String getG209() {
        return g209;
    }

    public void setG209(String g209) {
        this.g209 = g209;
        notifyChange(BR.g209);
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

/*    @Bindable
    public String getH106() {
        return h106;
    }

    public void setH106(String h106) {
        this.h106 = h106;
        notifyChange(BR.h106);
    }*/


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
       // this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_ISTATUS));
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
            this.a107 = json.getString("a107");
            this.a108 = json.getString("a108");
            this.a110 = json.has("a110")?json.getString("a110"):"";

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
            this.scoreRapid = json.has("scoreRapid") ? Integer.parseInt(json.getString("scoreRapid")): 0;

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
            this.painGrade = json.has("painGrade") ? Integer.parseInt(json.getString("painGrade")): 0;
            this.scoreRose = json.has("scoreRose") ? Integer.parseInt(json.getString("scoreRose")): 0;
            this.c104 = json.getString("c104");
            this.c105 = json.getString("c105");
            this.c106 = json.getString("c106");
            this.c107 = json.getString("c107");
            this.c108 = json.has("c108")?json.getString("c108"):"";
            this.c109 = json.has("c109")?json.getString("c109"):"";



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
            this.scoreQVSFS = json.has("scoreQVSFS") ? Integer.parseInt(json.getString("scoreQVSFS")): 0;


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
            this.totalMet = json.has("totalMet") ? Double.parseDouble(json.getString("totalMet")) : 0;
            this.scoreIPAQ = json.has("scoreIPAQ") ? json.getString("scoreIPAQ") : "";
            this.e106x = json.getString("e106x");
            this.e107 = json.getString("e107");
            this.e107x = json.getString("e107x");

            updateIPAQScore();
        }
    }

    public void sF1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sF1Hydrate: " + string);
        if (string != null) {
            JSONObject json = new JSONObject(string);
            this.f101 = json.getString("f101");
            this.f102 = json.getString("f102");
            this.f103 = json.getString("f103");
            this.f104 = json.getString("f104");
            this.f105 = json.getString("f105");
            this.f106 = json.getString("f106");
            this.f107 = json.getString("f107");
            this.f108 = json.getString("f108");
            this.f109 = json.getString("f109");
            this.f110 = json.getString("f110");
            this.f111 = json.getString("f111");
            this.f112 = json.getString("f112");
            this.f113 = json.getString("f113");
            this.f114 = json.getString("f114");
            this.f115 = json.getString("f115");
            this.f116 = json.getString("f116");
            this.f117 = json.getString("f117");
            this.f118 = json.getString("f118");
            this.f119 = json.getString("f119");
        }
    }


    public void sG1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sE1Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.g101 = json.getString("g101");
            this.g102 = json.getString("g102");
            this.g103 = json.getString("g103");
            this.g104 = json.getString("g104");
            this.g10498 = json.has("g10498")?json.getString("g10498"):"";
            this.g104a = json.getString("g104a");
            this.g105 = json.getString("g105");
            this.g105a = json.has("g105a")? json.getString("g105a"):"";
            this.g10598 = json.has("g10598")?json.getString("g10598"):"";
            this.g10601d = json.getString("g10601d");
            this.g10601w = json.getString("g10601w");
            this.g10602d = json.getString("g10602d");
            this.g10602w = json.getString("g10602w");
            this.g10603d = json.getString("g10603d");
            this.g10603w = json.getString("g10603w");
            this.g10604d = json.getString("g10604d");
            this.g10604w = json.getString("g10604w");
            this.g10605d = json.getString("g10605d");
            this.g10605w = json.getString("g10605w");
            this.g10606d = json.getString("g10606d");
            this.g10606w = json.getString("g10606w");
            this.g10696d = json.getString("g10696d");
            this.g10696w = json.getString("g10696w");
            this.g1060188 = json.getString("g1060188");
            this.g1060288 = json.getString("g1060288");
            this.g1060388 = json.getString("g1060388");
            this.g1060488 = json.getString("g1060488");
            this.g1060588 = json.getString("g1060588");
            this.g1060688 = json.getString("g1060688");
            this.g1069688 = json.getString("g1069688");
            this.g107 = json.getString("g107");
            this.g10801w = json.getString("g10801w");
            this.g10802w = json.getString("g10802w");
            this.g10803w = json.getString("g10803w");
            this.g10804w = json.getString("g10804w");
            this.g10805w = json.getString("g10805w");
            this.g10806w = json.getString("g10806w");
        //    this.g10807w = json.getString("g10807w");
            this.g10896 = json.getString("g10896");
            this.g10896x = json.getString("g10896x");
            this.g10896w = json.getString("g10896w");
            this.g201 = json.getString("g201");
            this.g202 = json.getString("g202");
            this.g203 = json.getString("g203");
            this.g204 = json.getString("g204");
            this.g20498 = json.has("g20498")?json.getString("g20498"):"";
            this.g204a = json.getString("g204a");
            this.g205 = json.getString("g205");
            this.g20598 = json.getString("g20598");
            this.g205a = json.has("g205a")?json.getString("g205a"):"";
            this.g20601d = json.getString("g20601d");
            this.g20601w = json.getString("g20601w");
            this.g20602d = json.getString("g20602d");
            this.g20602w = json.getString("g20602w");
            this.g20603d = json.getString("g20603d");
            this.g20603w = json.getString("g20603w");
            this.g20604d = json.getString("g20604d");
            this.g20604w = json.getString("g20604w");
            this.g20696d = json.getString("g20696d");
            this.g20696w = json.getString("g20696w");
            this.g2060188 = json.getString("g2060188");
            this.g2069688 = json.getString("g2069688");
            this.g2060288 = json.getString("g2060288");
            this.g2060388 = json.getString("g2060388");
            this.g2060488 = json.getString("g2060488");
            this.g207 = json.getString("g207");
            this.g20801w = json.getString("g20801w");
            this.g20802w = json.getString("g20802w");
            this.g20803w = json.getString("g20803w");
            this.g20804w = json.getString("g20804w");
            this.g20896w = json.getString("g20805w");
            this.g209 = json.getString("g209");

            updateRoseScore();
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
            // this.h106 = json.getString("h106");
            this.scoreWHO5 = json.has("scoreWHO5") ? json.getString("scoreWHO5") : "";
            this.endTime = json.has("endTime") ? json.getString("endTime") : "";
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
        //    json.put(TableContracts.FamilyMembersTable.COLUMN_ISTATUS, this.iStatus);
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
        json

                .put("a103", a103)
                .put("a104", a104)
                .put("a105", a105)
                .put("a106", a106)
                .put("a10696x", a10696x)
                .put("a107", a107)
                .put("a107", a107)
                .put("a108", a108)
              .put("a110", a110);
        return json.toString();
    }


    public String sB1toString() throws JSONException {
        Log.d(TAG, "sB1toString: ");
        JSONObject json = new JSONObject();
        json.put("b101", b101)
                .put("b102", b102)
                .put("diabetesResult", diabetesResult)
                .put("scoreRapid", scoreRapid);

        updateRapidScore();
        return json.toString();
    }

    public String sC1toString() throws JSONException {
        Log.d(TAG, "sC1toString: ");
        JSONObject json = new JSONObject();
        json.put("c101", c101)
                .put("c10201", c10201)
                .put("c10202", c10202)
                .put("c10203", c10203)
                .put("c10204", c10204)
                .put("c10205", c10205)
                .put("c10206", c10206)
                .put("c10207", c10207)
                .put("c10208", c10208)
                .put("c10209", c10209)
                .put("c103", c103)
                .put("painGrade", painGrade)
                .put("scoreRose", scoreRose)
                .put("anginaResult", anginaResult)
                .put("c104", c104)
                .put("c105", c105)
                .put("c106", c106)
                .put("c107", c107)
                .put("c108", c108)
                .put("hypertensionResult", hypertensionResult)
                .put("c109", c109);

        updateRoseScore();
        return json.toString();
    }

    public String sD1toString() throws JSONException {
        Log.d(TAG, "sC1toString: ");
        JSONObject json = new JSONObject();
        json.put("d101", d101)
                .put("d102", d102)
                .put("d103", d103)
                .put("d104", d104)
                .put("d105", d105)
                .put("d106", d106)
                .put("d107", d107)
                .put("scoreQVSFS", scoreQVSFS)
                .put("strokeResult", strokeResult)
                .put("d108", d108);

        updateQVSFS();
        return json.toString();
    }


    public String sE1toString() throws JSONException {
        Log.d(TAG, "sC1toString: ");
        JSONObject json = new JSONObject();
        json.put("e101", e101)
                .put("e101d", e101d)

                .put("e102", e102)
                .put("e102x", e102x)

                .put("e103", e103)
                .put("e103d", e103d)

                .put("e104", e104)
                .put("e104x", e104x)

                .put("e105", e105)
                .put("e105d", e105d)
                .put("e106", e106)
                .put("totalMet", totalMet)
                .put("scoreIPAQ", scoreIPAQ)
                .put("e106x", e106x)
                .put("e107", e107)
                .put("e107x", e107x);
        //  .put("e1071", e1071)


        updateIPAQScore();
        return json.toString();
    }

    public String sF1toString() throws JSONException {
        Log.d(TAG, "sF1toString: ");
        JSONObject json = new JSONObject();
        json.put("f101", f101)
                .put("f102", f102)
                .put("f103", f103)
                .put("f104", f104)
                .put("f105", f105)
                .put("f106", f106)
                .put("f107", f107)
                .put("f108", f108)
                .put("f109", f109)
                .put("f110", f110)
                .put("f111", f111)
                .put("f112", f112)
                .put("f113", f113)
                .put("f114", f114)
                .put("f115", f115)
                .put("f116", f116)
                .put("f117", f117)
                .put("f118", f118)
                .put("f119", f119);

        return json.toString();
    }


    public String sG1toString() throws JSONException {
        Log.d(TAG, "sC1toString: ");
        JSONObject json = new JSONObject();
        json.put("g101", g101)
                .put("g102", g102)
                .put("g103", g103)
                .put("g104", g104)
                .put("g10498", g10498)
                .put("g104a", g104a)
                .put("g105", g105)
                .put("g10598", g10598)
                .put("g105a", g105a)
                .put("g10601d", g10601d)
                .put("g10601w", g10601w)
                .put("g10602d", g10602d)
                .put("g10602w", g10602w)
                .put("g10603d", g10603d)
                .put("g10603w", g10603w)
                .put("g10604d", g10604d)
                .put("g10604w", g10604w)
                .put("g10605d", g10605d)
                .put("g10605w", g10605w)
                .put("g10606d", g10606d)
                .put("g10606w", g10606w)
                .put("g10696d", g10696d)
                .put("g10696w", g10696w)
                .put("g1060188", g1060188)
                .put("g1060288", g1060288)
                .put("g1060388", g1060388)
                .put("g1060488", g1060488)
                .put("g1060588", g1060588)
                .put("g1060688", g1060688)
                .put("g1069688", g1069688)
                .put("g107", g107)
                .put("g10801w", g10801w)
                .put("g10802w", g10802w)
                .put("g10803w", g10803w)
                .put("g10804w", g10804w)
                .put("g10805w", g10805w)
                .put("g10806w", g10806w)
               // .put("g10807w", g10807w)
                .put("g10896", g10896)
                .put("g10896x", g10896x)
                .put("g10896w", g10896w)
                .put("g201", g201)
                .put("g202", g202)
                .put("g203", g203)
                .put("g204", g204)
                .put("g20498", g20498)
                .put("g204a", g204a)
                .put("g205", g205)
                .put("g20598", g20598)
                .put("g205a", g205a)
                .put("g20601d", g20601d)
                .put("g2060188", g2060188)
                .put("g2060288", g2060288)
                .put("g2060388", g2060388)
                .put("g2060488", g2060488)
                .put("g2069688", g2069688)
                .put("g20601w", g20601w)
                .put("g20602d", g20602d)
                .put("g20602w", g20602w)
                .put("g20603d", g20603d)
                .put("g20603w", g20603w)
                .put("g20604d", g20604d)
                .put("g20604w", g20604w)
                .put("g20696d", g20696d)
                .put("g20696w", g20696w)
                .put("g207", g207)

                .put("g20801w", g20801w)
                .put("g20802w", g20802w)
                .put("g20803w", g20803w)
                .put("g20804w", g20804w)
                .put("g20805w", g20896w)
                .put("g209", g209)
        ;


        //updateRoseScore();
        return json.toString();
    }

    public String sH1toString() throws JSONException {
        Log.d(TAG, "sC1toString: ");
        JSONObject json = new JSONObject();
        json.put("h101", h101)
                .put("h102", h102)
                .put("h103", h103)
                .put("h104", h104)
                .put("h105", h105)
                //.put("h106", h106)
                .put("endTime", endTime)
                .put("mentalResult", mentalResult)
                .put("scoreWHO5", scoreWHO5);


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
        int H101 = Integer.parseInt(getH101().equals("") ? "0" : getH101());

        int age = Integer.parseInt(getA104().equals("") ? "0" : this.getA104());
        int gender = Integer.parseInt(getA105().equals("") ? "0" : this.getA105());
        int waist = Integer.parseInt(getB101().equals("") ? "0" : this.getB101());
        int familyHistory = Integer.parseInt(getB102().equals("") ? "0" : this.getB102());

        score = age >= 40 && age <= 50 ? 1 : age > 50 ? 3 : 0;
        score += ((gender == 1 && waist >= 90) || (gender == 2 && waist >= 80)) ? 2 : 0;
        score += (familyHistory == 1) ? 1 : 0;

        scoreRapid = score;
        diabetesResult = score >= 4;
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
            scoreRose = pain == 1 ? 1 : 2;
            anginaResult = pain == 1;
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
        strokeResult = scoreQVSFS > 0;
        //return score>=4?" YES ":" NO ";
    }

    public void updateIPAQScore() {
        // https://paulogentil.com/pdf/Interational%20Physical%20Activity%20Questionnaire%20-%20Validity%20againsl --installst%20Fitness.pdf
        double MET_Vigorous = 8.0;
        double MET_Moderate = 4.0;
        double MET_Walking = 3.3;
        double E101 = 0;
        double E102x = 0;
        double E103 = 0;
        double E104x = 0;
        double E105 = 0;
        double E106x = 0;

        if (this.e101.equals("99") ||this.e101.equals("")) {
            E101 = 0;

        } else {
            E101 = Integer.parseInt(getE101d());

        }

        if (this.e103.equals("99") || this.e103.equals("")) {
            E103 = 0;

        } else {
            E103 = Integer.parseInt(getE103d());

        }
        if (this.e105.equals("99") || this.e105.equals("")) {
            E105 = 0;

        } else {
            E105 = Integer.parseInt(getE105d());

        }

        /*Setting 0 minues if Dont know*/
        if (this.e101.equals("99") || this.e102.equals("98")|| this.e102.equals("")) {
            //E101 = 0;
            E102x = 0;
        } else {
            E102x = Integer.parseInt(getE102x());
        }
        if (this.e103.equals("99") || this.e104.equals("98")|| this.e104.equals("")) {
            // E103 = 0;
            E104x = 0;
        } else {
            E104x = Integer.parseInt(getE104x());
        }
        if (this.e105.equals("99") || this.e106.equals("98")|| this.e106.equals("")) {
            // E105 = 0;
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
        totalMet = Vigorous + Moderate + Walking; //+ Sitting;
        double TotalDays = E101 + E103 + E105; //+ Sitting;

        double score = totalMet / (7.0 * 24.0);
        setTotalMet(totalMet);

        // HIGH
        if ((E101 >= 3 && totalMet >= 1500) || ((E101 + E103 + E105) >= 7 && totalMet >= 3000)) {
            scoreIPAQ = "HIGH";
        }
        // MODREATE
        else if ((E101 >= 3) || (E103 >= 5) || E106x > 30 || ((E101 + E103 + E105) >= 5 && totalMet >= 600)) {
            // else if ((E105 >= 7 && E106x >= 30) || (E101 >= 3) || (E103 >= 5) || (TotalDays >= 5 && TotalMET >= 600)) {
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
        int[] hValues = new int[5];
        String[] hCodes = { getH101(), getH102(), getH103(), getH104(), getH105() };

        for (int i = 0; i < 5; i++) {
            hValues[i] = Integer.parseInt(hCodes[i].isEmpty() ? "0" : hCodes[i]);
        }

        // Calculate WHO-5 score
        int who5Score = 0;
        for (int value : hValues) {
            who5Score += value;
        }
        who5Score *= 4;

        mentalResult = who5Score < 13;
        for (int value : hValues) {
            if (value == 0 || value == 1) {
                mentalResult = true;
                break;
            }
        }
        scoreWHO5 = String.valueOf(who5Score);
        riskOutcome = calculateRiskOutcome();
    }


    public String calculateRiskOutcome() {
        if (strokeResult || anginaResult) {
            return "HIGH RISK";
        } else if (hypertensionResult || diabetesResult || mentalResult) {
            return "MEDIUM RISK";
        } else {
            return "LOW RISK";
        }
    }



}
