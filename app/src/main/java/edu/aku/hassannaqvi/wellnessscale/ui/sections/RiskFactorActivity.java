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
        int redOverlay = ContextCompat.getColor(this, R.color.redOverlay);
        int greenOverlay = ContextCompat.getColor(this, R.color.greenOverlay);
        int low = ContextCompat.getColor(this, R.color.low);
        int defaultColor = ContextCompat.getColor(this, R.color.black);

        bi.txtStroke.setBackgroundColor(familyMembers.strokeResult?redOverlay:greenOverlay);
        bi.txtAngina.setBackgroundColor(familyMembers.anginaResult?redOverlay:greenOverlay);
        bi.txtHTN.setBackgroundColor(familyMembers.hypertensionResult?redOverlay:greenOverlay);
        bi.txtDM.setBackgroundColor(familyMembers.diabetesResult?redOverlay:greenOverlay);
        bi.txtMH.setBackgroundColor(familyMembers.mentalResult?redOverlay:greenOverlay);

        bi.txtMH.setCompoundDrawablesWithIntrinsicBounds(0, 0, familyMembers.mentalResult?R.drawable.factor_check_red:R.drawable.factor_check_green, 0);
        bi.txtDM.setCompoundDrawablesWithIntrinsicBounds(0, 0, familyMembers.diabetesResult?R.drawable.factor_check_red:R.drawable.factor_check_green, 0);
        bi.txtHTN.setCompoundDrawablesWithIntrinsicBounds(0, 0, familyMembers.hypertensionResult?R.drawable.factor_check_red:R.drawable.factor_check_green, 0);
        bi.txtAngina.setCompoundDrawablesWithIntrinsicBounds(0, 0, familyMembers.anginaResult?R.drawable.factor_check_red:R.drawable.factor_check_green, 0);
        bi.txtStroke.setCompoundDrawablesWithIntrinsicBounds(0, 0, familyMembers.strokeResult?R.drawable.factor_check_red:R.drawable.factor_check_green, 0);


        switch (familyMembers.calculateRiskOutcome()) {
            case "HIGH RISK":
                 bi.riskCategory.setTextColor(veryHighColor);
                 break;
                case "MEDIUM RISK":
                                 bi.riskCategory.setTextColor(highMediumColor);
break;
            case "LOW RISK":
                                 bi.riskCategory.setTextColor(low);
break;
            default:
                                 bi.riskCategory.setTextColor(defaultColor);
            // Default black color or any other default color you prefer



        }
                String suggestions = "";

                if(familyMembers.strokeResult){
                    suggestions = "STROKE: Since you are at High risk for Stroke it means you have high chances of future cardiovascular events. It is essential to attend regular check-ups, take prescribed medications, maintain a heart-healthy diet, exercise regularly, manage stress, avoid smoking, and limit alcohol. Also, try to stay away from unhealthy foods and adopt an active lifestyle. \n";
                }

                if(familyMembers.anginaResult){
                    suggestions += "ANGINA: Being High Risk for Angina means your heart needs extra care. Compromised heart health means careful monitoring is needed. Quit smoking, manage stress, follow a balanced low-fat diet, exercise regularly, take prescribed medications, and avoid bad dietary choices. Remember, an active lifestyle can make a significant difference. \n";
                }

                if(familyMembers.hypertensionResult){
                    suggestions += "HIGH BLOOD PRESSURE: High blood pressure puts your heart at risk, chance of stroke, and other cardiovascular issues. Monitor your blood pressure regularly, opt for a low-sodium diet, stay physically active, manage stress, limit alcohol, take prescribed medications, avoid bad diet, and keep an active lifestyle.  \n";
                }

                if(familyMembers.diabetesResult){
                    suggestions += "DIABETES/SUGAR: Diabetes increases your heart disease risk, kidney problems, and nerve damage. Control your blood sugar through diet, exercise, and medication. Monitor your glucose levels, manage your weight, quit smoking, have regular medical check-ups, and stay away from a bad diet. Also, embrace an active lifestyle.   \n";
                }
                if(familyMembers.mentalResult){
                    suggestions += "MENTAL HEALTH: Your mental health Indirect impacts on heart health through lifestyle habits. Seek support if needed, practice stress-reducing activities like meditation and yoga, maintain social connections, indulge in hobbies, and take care of your mental well-being. Avoid tobacco and embrace an active lifestyle alongside a balanced diet. ";
                }

                bi.lifeStyle.setText(suggestions);

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