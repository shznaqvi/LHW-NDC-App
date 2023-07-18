package edu.aku.hassannaqvi.wellnessscale.ui.sections;

import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.form;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.wellnessscale.R;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;
import edu.aku.hassannaqvi.wellnessscale.database.DatabaseHelper;
import edu.aku.hassannaqvi.wellnessscale.databinding.ActivityConsentBinding;
import edu.aku.hassannaqvi.wellnessscale.ui.EndingActivity;
import edu.aku.hassannaqvi.wellnessscale.ui.lists.FamilyMembersListActivity;

public class ConsentActivity extends AppCompatActivity {


    private static final String TAG = "ConsentActivity";
    ActivityConsentBinding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? MainApp.selectedLanguage == 1 ? R.style.AppThemeUrdu : R.style.AppThemeSindhi : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_consent);
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;
        bi.setForm(form);
        setGPS();

        //  String consentText = getString(R.string.hh18t, MainApp.user.getFullname());
        //  bi.consentTextView.setText(consentText);
    }


    private boolean insertNewRecord() {
        if (!form.getUid().equals("") || MainApp.superuser) return true;

        MainApp.form.populateMeta();

        long rowId = 0;
        try {
            rowId = db.addForm(MainApp.form);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error + " FORM-add", Toast.LENGTH_SHORT).show();
            return false;
        }
        MainApp.form.setId(String.valueOf(rowId));
        if (rowId > 0) {
            MainApp.form.setUid(MainApp.form.getDeviceId() + MainApp.form.getId());
            db.updatesFormColumn(TableContracts.FormsTable.COLUMN_UID, MainApp.form.getUid());
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error + " FORM-update", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean updateDB() {
        if (MainApp.superuser) return true;

        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
        try {
            updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SA, form.sAtoString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, R.string.upd_db + e.getMessage());
            Toast.makeText(this, R.string.upd_db + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount > 0) return true;
        else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void btnContinue(View view) {
        if (!formValidation()) return;
        if (!insertNewRecord()) return;
        // saveDraft();
        if (updateDB()) {
            finish();

            startActivity(new Intent(this, FamilyMembersListActivity.class));

     /*       if (form.getHh18().equals("1")) {
                startActivity(new Intent(this, SectionRIActivity.class));
            } else {
                Intent endingActivityIntent = new Intent(this, EndingActivity.class);
                endingActivityIntent.putExtra("complete", false);
                endingActivityIntent.putExtra("checkToEnable", 4);
                startActivity(endingActivityIntent);
            }*/
        } else
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    @Override
    public void onBackPressed() {

        // Backpressed Allowed
        super.onBackPressed();

        //
       // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        setResult(RESULT_CANCELED);
        //finish();
    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Points set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            form.setGpsLat(lat);
            form.setGpsLng(lang);
            form.setGpsAcc(acc);
            form.setGpsDT(date); // Timestamp is converted to date above

//            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }
}