package edu.aku.hassannaqvi.wellnessscale.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.aku.hassannaqvi.wellnessscale.R;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;
import edu.aku.hassannaqvi.wellnessscale.models.FamilyMembers;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.SectionA1Activity;


public class FamilyMembersAdapter extends RecyclerView.Adapter<FamilyMembersAdapter.ViewHolder> {
    private static final String TAG = "MWRAAdapter";
    private final AlertDialog mDeleteDialog;
    private final Context mContext;
    private final List<FamilyMembers> member;
    private final int mExpandedPosition = -1;
    private final int completeCount;
    private int deletePosition;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param members List<FemaleMembersModel> containing the data to populate views to be used by RecyclerView.
     */
    public FamilyMembersAdapter(Context mContext, List<FamilyMembers> members) {
        this.member = members;
        this.mContext = mContext;
        completeCount = 0;
        MainApp.memberComplete = false;

        // Create the delete confirmation dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("Are you sure you want to delete this item?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              members.remove(deletePosition);
              notifyItemRemoved(deletePosition);
            }
        });
        builder.setNegativeButton("Cancel", null);
        mDeleteDialog = builder.create();
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int positionX) {
        Log.d(TAG, "Element " + viewHolder.getAdapterPosition() + " set.");
        FamilyMembers members = this.member.get(viewHolder.getAdapterPosition());        // Get element from your dataset at this position and replace the contents of the view
        // with that element

        TextView fName = viewHolder.fName;
        TextView fAge = viewHolder.fAge;
        ImageView fmRow = viewHolder.fmRow;
        ImageView mainIcon = viewHolder.mainIcon;
        TextView diabetes = viewHolder.diabetes;
        TextView waist = viewHolder.waist;
        TextView secStatus = viewHolder.secStatus;
        View cloaked = viewHolder.cloak;

        MainApp.memberComplete = completeCount == MainApp.memberCount;

        fName.setText(members.getA103());
        fAge.setText(members.getA104() + "y ");
        diabetes.setText(members.getB102().equals("1") ? " Yes" : "  No");
        waist.setText("Waist: " + members.getB101());
        fmRow.setVisibility(members.getScoreWHO5().equals("")?View.VISIBLE:View.GONE);
     /*   String marStatus = "";
        switch (members.getH306()) {
            case "1":
                marStatus = "Married";
                break;
            case "2":
                marStatus = "Unmarried";
                break;
            case "3":
                marStatus = "Widowed";
                break;
            case "4":
                marStatus = "Divorced/Separated";
                break;
            default:
                marStatus = "Value Unknown";
                break;
        }*/

        //  fMaritalStatus.setText(marStatus);

       /* String secStatusString =
                *//*B1*//*
                "RAPID: \t" + members.getScoreRapid() +
                        *//*C1*//*
                        "\nPain: \t" + (members.getScoreRose() == 1 ? "Agina-" : (members.getScoreRose() == 2 ? "Exertion-" : "No Pain")) +
                        (members.getPainGrade() == 2 ? "II" : members.getPainGrade() == 1 ? "I" : "") +
                        *//*D1*//*
                        "\nQVSFS: \t" + (members.getScoreQVSFS() > 0 ? "+ve" : members.getScoreQVSFS() == 0 ? "-ve" : "unk") +
                        *//*E1*//*
                        "\nIPAQ: \t" + members.getScoreIPAQ() +
                        *//*H1*//*
                        "\nWHO-5: \t" + members.getScoreWHO5();
*/
 /*       switch (members.getH309())
        {
            case "1":
                secStatusString = "Available";
                break;
            case "2":
                secStatusString = "Not Available";

        }*/

        String risk = members.calculateRiskOutcome();

        // cloaked.setVisibility(members.getMemCate().equals("") ? View.VISIBLE : View.GONE);
        mainIcon.setImageResource((members.getA105().equals("1") ? R.drawable.ic_boy : R.drawable.ic_girl));
        mainIcon.setBackgroundColor(members.getA105().equals("1") ? mContext.getResources().getColor(android.R.color.holo_blue_dark) : mContext.getResources().getColor(R.color.girl_pink));
        if(members.getA110().equals("1")) {
            secStatus.setText(risk.replace(" ", "\n"));
            secStatus.setBackgroundColor(risk.equals("VERY HIGH RISK") ? mContext.getResources().getColor(R.color.very_high) : risk.equals("HIGH MEDIUM RISK") ? mContext.getResources().getColor(R.color.high_medium) : mContext.getResources().getColor(R.color.low));
        } else{
            secStatus.setText("Consent not given");
        }
//              Integer.parseInt(members.getH306()) > 19 && members.getH303().equals("2") ? mContext.getResources().getColor(android.R.color.holo_red_dark)
//                      : (members.getH303().equals("1") ? mContext.getResources().getColor(R.color.boy_blue) : mContext.getResources().getColor(R.color.girl_pink)));
        viewHolder.itemView.setOnClickListener(v -> {
            // Get the current state of the item

            MainApp.familyMembers = MainApp.familyList.get(viewHolder.getAdapterPosition());
            Intent intent = new Intent(mContext, SectionA1Activity.class);


            MainApp.selectedMember = viewHolder.getAdapterPosition();

            intent.putExtra("position", viewHolder.getAdapterPosition());

            ((Activity) mContext).startActivityForResult(intent, 2);


        });
        viewHolder.itemView.setOnLongClickListener(v -> {
            deletePosition = viewHolder.getAdapterPosition();
            mDeleteDialog.show();
            return true;
        });


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.famlily_member_row, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return member.size();
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView fName;
        private final TextView fAge;
        private final TextView diabetes;
        private final TextView waist;
        private final TextView secStatus;
        //private final TextView addSec;
        //private final LinearLayout subItem;
        private final ImageView fmRow;
        private final ImageView mainIcon;
        private final View cloak;


        public ViewHolder(View v) {
            super(v);
            fName = v.findViewById(R.id.ca102c);
            fAge = v.findViewById(R.id.chh05);
            diabetes = v.findViewById(R.id.diabetes);
            waist = v.findViewById(R.id.waist);
            secStatus = v.findViewById(R.id.csecStatus);
            fmRow = v.findViewById(R.id.cfmRow);
            mainIcon = v.findViewById(R.id.mainIcon);
            cloak = v.findViewById(R.id.cloaked);

        }

        public TextView getTextView() {
            return fName;
        }
    }



}
