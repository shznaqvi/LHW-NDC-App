package edu.aku.hassannaqvi.wellnessscale.adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.wellnessscale.R;
import edu.aku.hassannaqvi.wellnessscale.core.MainApp;
import edu.aku.hassannaqvi.wellnessscale.database.DatabaseHelper;
import edu.aku.hassannaqvi.wellnessscale.models.Form;
import edu.aku.hassannaqvi.wellnessscale.ui.lists.FamilyMembersListActivity;
import edu.aku.hassannaqvi.wellnessscale.ui.sections.ConsentActivity;

/**
 * Created by hassan.naqvi on 8/1/2016.
 */
public class FormsAdapter extends RecyclerView.Adapter<FormsAdapter.ViewHolder> {
    private static final String TAG = "FormsAdapter";
    Context c;
    DatabaseHelper db;
    private List<Form> fc = new ArrayList<>();


    // Provide a suitable constructor (depends on the kind of dataset)
    public FormsAdapter(List<Form> fc, Context c) {
        this.fc = fc;
        this.c = c;
        Log.d("TAG:count", String.valueOf(getItemCount()));
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pendingform_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        db = new DatabaseHelper(c);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Define the interface
    public interface OnItemClickListener {
        void onItemClick(int position);
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainApp.form = new Form();

                try {
                    MainApp.form = db.getFormBYUID(fc.get(holder.getAdapterPosition()).getUid());
                } catch (JSONException e) {
                    Toast.makeText(c, "JSONException(Forms): "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    //throw new RuntimeException(e);
                }

                // Start a new activity when an item is clicked
                Context context = holder.itemView.getContext();
               /* Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("clicked_item", dataList.get(position)); // Pass data if needed
                context.startActivity(intent);*/

                if (MainApp.form.getSynced().equals("1") && !MainApp.superuser) { // Do not allow synced form to be edited
                    Toast.makeText(c, "This form has been locked.", Toast.LENGTH_SHORT).show();
                } else if (MainApp.form.getA110().equals("1")) {
                    //  finish();
                    context.startActivity(new Intent(context, FamilyMembersListActivity.class));
                } else {
                    //   finish();
                    context.startActivity(new Intent(context, ConsentActivity.class));
                }
            }
        });
//        holder.itemView.setOnClickListener(view -> {
//            if (itemClickListener != null) {
//                itemClickListener.onItemClick(position);
//
//
//
//            }
//        });

        int memberCount = 0;
        memberCount = db.getMembersByUUID(fc.get(position).getUid());
       /* int photoChild = 0;
        photoChild = db.getChildrenPhotoCheck(fc.get(position).getUid());
        int cardChild = 0;
        cardChild = db.getChildrenCardCheck(fc.get(position).getUid());*/


        String tStatus = "Status  Unknown";
        boolean synced = fc.get(position).getSynced().equals("1");
        int iColor = 0;
        switch (fc.get(position).getiStatus()) {
            case "1":
                tStatus = "  Complete  ";
                iColor = Color.GREEN;
                break;
            case "2":
                tStatus = "No Respondent";
                iColor = Color.RED;
                break;
            case "3":
                tStatus = "Memebers Absent";
                iColor = Color.RED;
                break;
            case "4":
                tStatus = "  Refused  ";
                iColor = Color.RED;
                break;
            case "5":
                tStatus = "   Empty   ";
                iColor = Color.RED;
                break;
            case "6":
                tStatus = " Not Found  ";
                iColor = Color.RED;
                break;
            case "96":
                tStatus = "Other Reason";
                iColor = Color.RED;
                break;
            default:
                tStatus = " Open Form  ";
                iColor = Color.RED;
                break;

        }

        holder.hhno.setText(fc.get(position).getKno() + " \t\t(" + fc.get(position).getSysDate() + ")");
        holder.cluster.setText(fc.get(position).getDistrictCode());
        holder.iStatus.setText(tStatus);
        holder.syncStatus.setText(synced ? "Data Synced" : "Sync Pending");
        holder.sysdate.setText("  Member Count: " + memberCount );
        holder.iStatus.setTextColor(iColor);
        holder.syncStatus.setTextColor(synced ? Color.GRAY : Color.RED);


    }




    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return fc.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView rv;
        public TextView sysdate;
        public TextView cluster;
        public TextView hhno;
        public TextView iStatus;
        public TextView syncStatus;
        // each data item is just a string in this case

        public ViewHolder(View v) {
            super(v);
//            rv = v.findViewById(R.id.FormsList);
            sysdate = v.findViewById(R.id.sysdate);
            cluster = v.findViewById(R.id.ebCode);
            hhno = v.findViewById(R.id.hhid);
            iStatus = v.findViewById(R.id.iStatus);
            syncStatus = v.findViewById(R.id.syncStatus);

        }


    }
}