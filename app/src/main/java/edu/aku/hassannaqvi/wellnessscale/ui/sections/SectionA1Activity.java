package edu.aku.hassannaqvi.wellnessscale.ui.sections;

import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.familyMembers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.wellnessscale.R;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;
import edu.aku.hassannaqvi.wellnessscale.database.DatabaseHelper;
import edu.aku.hassannaqvi.wellnessscale.databinding.ActivitySectionA1Binding;
import edu.aku.hassannaqvi.wellnessscale.ui.EndingActivity;


public class SectionA1Activity extends AppCompatActivity {
    private static final String TAG = "SectionA1Activity";
    private final boolean respAgeCheck = false;
    ActivitySectionA1Binding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? MainApp.selectedLanguage == 1 ? R.style.AppThemeUrdu:R.style.AppThemeSindhi  : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a1);

       // MainApp.form = new Form();
        bi.setFamilymembers(familyMembers);
        bi.setCallback(this);

        //   if (MainApp.superuser)
   //         bi.btnContinue.setText("Review Next");
        db = MainApp.appInfo.dbHelper;
   //     form.setA101C(String.valueOf(new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime())));

    }
    
//
//
//    public void ageSkip(CharSequence s, int i, int i1, int i2) {
//        if (TextUtils.isEmpty(bi.a113.getText())) return;
//        if (Integer.parseInt(bi.a113.getText().toString()) < 18) {
//            bi.a114t.clearCheck();
//            bi.a115t.clearCheck();
//            bi.fldGrpCVa114t.setVisibility(View.GONE);
//            bi.fldGrpCVa115t.setVisibility(View.GONE);
//            bi.btnContinue.setVisibility(View.GONE);
//            respAgeCheck = false;
//        } else {
//            bi.fldGrpCVa114t.setVisibility(View.VISIBLE);
//            bi.fldGrpCVa115t.setVisibility(View.VISIBLE);
//            bi.btnContinue.setVisibility(View.VISIBLE);
//            respAgeCheck = true;
//        }
//    }
//
//
    private boolean insertNewRecord() {
        if (!familyMembers.getUid().equals("") || MainApp.superuser) return true;
        familyMembers.populateMeta();
        long rowId = 0;
        try {
            rowId = db.addFamilyMember(familyMembers);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        familyMembers.setId(String.valueOf(rowId));
        if (rowId > 0) {
            familyMembers.setUid(familyMembers.getDeviceId() + familyMembers.getId());
            db.updatesFamilyMembersColumn(TableContracts.FamilyMembersTable.COLUMN_UID, familyMembers.getUid());
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private boolean updateDB() {
        if (MainApp.superuser) return true;

        int updcount = 0;
        try {
            updcount = db.updatesFamilyMembersColumn(TableContracts.FamilyMembersTable.COLUMN_SA1, familyMembers.sA1toString());
        } catch (JSONException e) {
            Toast.makeText(this, R.string.upd_db + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void btnContinue() {
        if (!formValidation()) return;
       if (!insertNewRecord()) return;
        // saveDraft();
        if (updateDB()) {
          /*  setResult(RESULT_OK);
            Intent i;
            i = new Intent(this, SectionB1Activity.class).putExtra("complete", true).setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
            startActivity(i);
            finish();*/

            if (familyMembers.getA110().equals("1")) {
                Intent i;
                i = new Intent(this, SectionB1Activity.class).putExtra("complete", true).setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                startActivity(i);
                finish();
            } else {
                Intent returnIntent = new Intent();
                //  returnIntent.putExtra("requestCode", requestCode);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }



    public void btnEnd() {
        if (!formValidationEnd()) return;
        if (!insertNewRecord()) return;
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
        /*finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));*/
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.secGrpA);
    }


    private boolean formValidationEnd() {
        return Validator.emptyCheckingContainer(this, bi.secGrpA);
    }


    @Override
    public void onBackPressed() {

        // Allow BackPress
        super.onBackPressed();
        setResult(RESULT_CANCELED);

        // Dont Allow BackPress
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();

    }
}