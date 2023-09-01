package edu.aku.hassannaqvi.wellnessscale.ui.sections;

import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.familyMembers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.internal.MaterialCheckable;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.wellnessscale.R;
import edu.aku.hassannaqvi.wellnessscale.contracts.TableContracts;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;
import edu.aku.hassannaqvi.wellnessscale.database.DatabaseHelper;
import edu.aku.hassannaqvi.wellnessscale.databinding.ActivitySectionE1Binding;

public class SectionE1Activity extends AppCompatActivity {


    private static final String TAG = "SectionSS_2Activity";
    ActivitySectionE1Binding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? MainApp.selectedLanguage == 1 ? R.style.AppThemeUrdu:R.style.AppThemeSindhi  : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e1);
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;
        bi.setFamilymembers(familyMembers);
        bi.setCallback(this);



        bi.e102.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.e10201:
                        bi.e10201x.setMaxvalue(Float.parseFloat("24"));
                        // Option 1 is selected
                        break;
                    case R.id.e10202:
                        // Option 2 is selected
                        bi.e10201x.setMaxvalue(Float.parseFloat("59"));
                        break;
                }
            }
        });

        bi.e104.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.e10401:
                        bi.e10401x.setMaxvalue(Float.parseFloat("24"));
                        // Option 1 is selected
                        break;
                    case R.id.e10402:
                        // Option 2 is selected
                        bi.e10401x.setMaxvalue(Float.parseFloat("59"));
                        break;
                }
            }
        });

        bi.e106.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.e10601:
                        bi.e10601x.setMaxvalue(Float.parseFloat("24"));
                        // Option 1 is selected
                        break;
                    case R.id.e10602:
                        // Option 2 is selected
                        bi.e10601x.setMaxvalue(Float.parseFloat("59"));
                        break;
                }
            }
        });

        bi.e107.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.e10701:
                        bi.e10701x.setMaxvalue(Float.parseFloat("24"));
                        // Option 1 is selected
                        break;
                    case R.id.e10702:
                        // Option 2 is selected
                        bi.e10701x.setMaxvalue(Float.parseFloat("59"));
                        break;
                }
            }
        });
    }

    private boolean updateDB() {
        if (MainApp.superuser) return true;
        familyMembers.updateIPAQScore();
        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
        try {
            updcount = db.updatesFamilyMembersColumn(TableContracts.FamilyMembersTable.COLUMN_SE1, familyMembers.sE1toString());
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

    public void btnContinue() {
        if (!formValidation()) return;
        if (updateDB()) {
            setResult(RESULT_OK);
            Intent i;
            i = new Intent(this, SectionF1Activity.class).putExtra("complete", true).setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();

        }
    }


    public void btnEnd() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("requestCode", "1");
        setResult(RESULT_CANCELED, returnIntent);
        finish();
        //  startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    @Override
    public void onBackPressed() {
        // Allow BackPress
        super.onBackPressed();
        setResult(RESULT_CANCELED);

        // Dont Allow BackPress
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();

    }

    public static void blinkEditText(View view) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;

            // Apply the blink animation
            Animation blinkAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.blink_anim);
            editText.setBackgroundResource(R.drawable.edittext_blink);
            editText.startAnimation(blinkAnimation);
        }
    }
}