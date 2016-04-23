package nigel.finalproject_justify;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccteadmin on 2/23/16.
 */
public class OtherClaimsAdapter extends RecyclerView.Adapter<OtherClaimViewHolder> {

    private List<Argument> otherClaims;
    private List<String> keys = new ArrayList<>();
    private Context context;


    public OtherClaimsAdapter(List<Argument> otherClaims, Context context) {
        this.otherClaims = otherClaims;
        this.context = context;
    }

    public OtherClaimsAdapter(final Firebase othersRef, Context context) {
        this.context = context;
        otherClaims = new ArrayList<>();
        othersRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Argument argument = dataSnapshot.getValue(Argument.class);
                otherClaims.add(argument);
                notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Argument argument = dataSnapshot.getValue(Argument.class);
                otherClaims.remove(argument);
                notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public OtherClaimViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_other, parent, false);
        return new OtherClaimViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(OtherClaimViewHolder holder, int position) {
        Argument otherClaim = otherClaims.get(position);
        holder.bind(otherClaim);
    }

    @Override
    public int getItemCount() {
        return otherClaims.size();
    }
}

