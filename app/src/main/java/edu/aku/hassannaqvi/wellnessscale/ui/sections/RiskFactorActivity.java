package edu.aku.hassannaqvi.wellnessscale.ui.sections;

import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.familyMembers;
import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.memberCount;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.wellnessscale.R;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;
import edu.aku.hassannaqvi.wellnessscale.database.DatabaseHelper;
import edu.aku.hassannaqvi.wellnessscale.databinding.ActivityRiskFactorBinding;

public class RiskFactorActivity extends AppCompatActivity {

    ActivityRiskFactorBinding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? MainApp.selectedLanguage == 1 ? R.style.AppThemeUrdu : R.style.AppThemeSindhi : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_risk_factor);
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;
        bi.setFamilymembers(familyMembers);
        bi.setCallback(this);

        riskColorHex();
    }


    public void riskColorHex() {

        int veryHighColor = ContextCompat.getColor(this, R.color.very_high);
        int highMediumColor = ContextCompat.getColor(this, R.color.high_medium);
        int low = ContextCompat.getColor(this, R.color.low);
        int defaultColor = ContextCompat.getColor(this, R.color.black);

        switch (familyMembers.calculateRiskOutcome()) {
            case "VERY HIGH RISK":
                 bi.riskCategory.setTextColor(veryHighColor);
                 break;
                case "HIGH MEDIUM RISK":
                                 bi.riskCategory.setTextColor(highMediumColor);
break;
            case "LOW RISK":
                                 bi.riskCategory.setTextColor(low);
break;
            default:
                                 bi.riskCategory.setTextColor(defaultColor);
            // Default black color or any other default color you prefer
        }
    }

    public void btnContinue() {
      /*  if (!formValidation()) return;

        if (updateDB()) {
            Intent returnIntent = new Intent();
            //  returnIntent.putExtra("requestCode", requestCode);
            setResult(RESULT_OK, returnIntent);
            finish();
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();

        }  */

        Intent returnIntent = new Intent();
        //  returnIntent.putExtra("requestCode", requestCode);
        setResult(RESULT_OK, returnIntent);
        finish();


    }


    public void btnEnd() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("requestCode", "1");
        setResult(RESULT_CANCELED, returnIntent);
        finish();
        //  startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }

/*
    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }
*/


    @Override
    public void onBackPressed() {
        // Allow BackPress
        super.onBackPressed();
        setResult(RESULT_CANCELED);

        // Dont Allow BackPress
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();

    }
}