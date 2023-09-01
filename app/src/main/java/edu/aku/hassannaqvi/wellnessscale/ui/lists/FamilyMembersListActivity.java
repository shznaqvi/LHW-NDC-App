package edu.aku.hassannaqvi.wellnessscale.ui.lists;

import static edu.aku.hassannaqvi.wellnessscale.core.MainApp._EMPTY_;
import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.familyList;
import static edu.aku.hassannaqvi.wellnessscale.core.MainApp.selectedMember;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;

import java.util.ArrayList;

import edu.aku.hassannaqvi.wellnessscale.R;
import edu.aku.hassannaqvi.wellnessscale.adapters.FamilyMembersAdapter;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;
import edu.aku.hassannaqvi.wellnessscale.database.DatabaseHelper;
import edu.aku.hassannaqvi.wellnessscale.databinding.ActivityFamilyListBinding;
import edu.aku.hassannaqvi.wellnessscale.models.FamilyMembers;
import edu.aku.hassannaqvi.wellnessscale.ui.EndingActivity;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.SectionA1Activity;


public class FamilyMembersListActivity extends AppCompatActivity {


    private static final String TAG = "MwraActivity";
    ActivityFamilyListBinding bi;
    DatabaseHelper db;
    private FamilyMembersAdapter familyMembersAdapter;
    ActivityResultLauncher<Intent> MemberInfoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                //    if (result.getResultCode() == Activity.RESULT_OK) {
                   if (!MainApp.familyMembers.getUid().equals(_EMPTY_)) {

                        familyList.add(MainApp.familyMembers);
             /*           if (!MainApp.familyMembers.getScoreWHO5().equals("")) {
                          //  MainApp.mwraList.add(MainApp.familyMembers);
                            MainApp.incompCount++;
                     *//*       switch (MainApp.familyMembers.getMemCate()) {
                                case "1":
                                    MainApp.mwraList.add(MainApp.familyMembers);
                                    MainApp.mwraCount++;
                                    break;
                                case "2":
                                    MainApp.adolList.add(MainApp.familyMembers);
                                    MainApp.adolCount++;
                                    break;
                                case "3":
                                    MainApp.maleList.add(MainApp.familyMembers);
                                    MainApp.maleCount++;
                                    break;
                            }*//*

                        } else{
                            MainApp.incompCount++;
                        }*/
                        MainApp.memberCount++;
                        familyMembersAdapter.notifyItemInserted(familyList.size() - 1);

                        checkCompleteFm();
                    }
                    if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        Toast.makeText(FamilyMembersListActivity.this, "No family member added.", Toast.LENGTH_SHORT).show();
                    }

                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_family_list);
        bi.setCallback(this);

        db = MainApp.appInfo.dbHelper;
        MainApp.familyList = new ArrayList<>();
      /*  MainApp.mwraList = new ArrayList<>();
        MainApp.adolList = new ArrayList<>();
        MainApp.maleList = new ArrayList<>();*/

        Log.d(TAG, "onCreate: familyList " + familyList.size());
        try {
            familyList = db.getMemberBYUID(MainApp.form.getUid());
            int fmCount = 0;
            for (FamilyMembers fm : familyList) {
                fmCount++;

/*                if (!fm.getMemCate().equals("")) {
                    switch (fm.getMemCate()) {
                        case "1":
                            MainApp.mwraList.add(fm);
                            MainApp.mwraCount++;
                            break;
                        case "2":
                            MainApp.adolList.add(fm);
                            MainApp.adolCount++;
                            break;
                        case "3":
                            MainApp.maleList.add(fm);
                            MainApp.maleCount++;
                            break;
                    }

                }*/
            }


        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(FamilyMembers): " + e.getMessage(), Toast.LENGTH_LONG).show();
        }


        bi.btnContinue.setVisibility(familyList.size() > 0 ? View.VISIBLE : View.INVISIBLE);
        MainApp.memberCount = Math.round(familyList.size());

        familyMembersAdapter = new FamilyMembersAdapter(this, familyList);
        bi.rvMwra.setAdapter(familyMembersAdapter);
        bi.rvMwra.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!MainApp.form.getiStatus().equals("1")) {
                    MainApp.familyMembers = new FamilyMembers();
                    addMember();
                } else {
                    Toast.makeText(FamilyMembersListActivity.this, "This form has been locked. You cannot add new MWRA to locked forms", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity Resumed!", Toast.LENGTH_SHORT).show();

        checkCompleteFm();
        bi.btnContinue.setVisibility(familyList.size() > 0 ? View.VISIBLE : View.INVISIBLE);
        bi.btnContinue.setEnabled(familyList.size() > 0);

        bi.totalMember.setText("Total: " + familyList.size());
        bi.compForms.setText("Completed: " + MainApp.memberCountComplete);
        bi.incompForms.setText("Incomplete: " + MainApp.memberCountInomplete);
//        bi.totalMwra.setText("MWRA: " + mwraList.size());
//        bi.totalAdol.setText("Adol: " + MainApp.adolList.size());
//        bi.totalMale.setText("AdultMale: " + MainApp.maleList.size());
    }

    private void checkCompleteFm() {

        MainApp.memberCount = familyList.size();
        MainApp.memberCountComplete = 0;
        MainApp.memberCountInomplete = 0;

        for (FamilyMembers fm : MainApp.familyList) {
            if (fm.getScoreWHO5().equals("") && fm.getA110().equals("1") ) {
                MainApp.memberCountInomplete++;
            } else {
                MainApp.memberCountComplete++;
            }
        }


    }

    public void addMember() {
        addMoreMember();

    }

    public void btnContinue(View view) {

/*        if (mwraList.size() > 0) {
            MainApp.mwra = new MWRA();
            MainApp.lhwgbHhForm = new LHWGB_HH();
            //       finish();
            startActivity(new Intent(this, SectionW1Activity.class).putExtra("complete", true));
        } else if (adolList.size() > 0) {
            MainApp.lhwgbHhForm = new LHWGB_HH();
            //      finish();
            startActivity(new Intent(this, SectionABActivity.class).putExtra("complete", true));
        } else if (maleList.size() > 0) {
            MainApp.lhwgbHhForm = new LHWGB_HH();
            //    finish();
            startActivity(new Intent(this, SectionMActivity.class).putExtra("complete", true));
        } else {*/
if(MainApp.memberCountInomplete>0) {
    startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    // }
    finish();
} else {
    startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
    // }
    finish();
}


    }


    private void addMoreMember() {
        MainApp.familyMembers = new FamilyMembers();
        MainApp.familyMembers.setLhwCode(MainApp.form.getLhwCode());
        MainApp.familyMembers.setKno(MainApp.form.getKno());
        MainApp.familyMembers.setUuid(MainApp.form.getUid());
        MainApp.familyMembers.setSysDate(MainApp.form.getSysDate());

        Intent intent = new Intent(this, SectionA1Activity.class);
        //   finish();
        MemberInfoLauncher.launch(intent);
    }

    public void btnEnd(View view) {

        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                //   mwra.get(selectedMWRA).setExpanded(false);
                checkCompleteFm();
                familyMembersAdapter.notifyItemChanged(selectedMember);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                // Write your code if there's no result
               // Toast.makeText(this, "Child for " + MainApp.familyList.get(selectedMember).getH221() + " was not added.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}