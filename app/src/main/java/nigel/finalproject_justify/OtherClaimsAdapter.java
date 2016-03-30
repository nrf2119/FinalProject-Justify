package nigel.finalproject_justify;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ccteadmin on 2/23/16.
 */
public class OtherClaimsAdapter extends RecyclerView.Adapter<OtherClaimViewHolder> {

    private List<OtherClaim> otherClaims;
    private Context context;

    public OtherClaimsAdapter(List<OtherClaim> otherClaims, Context context) {
        this.otherClaims = otherClaims;
        this.context = context;
    }

    @Override
    public OtherClaimViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_other, parent, false);
        return new OtherClaimViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(OtherClaimViewHolder holder, int position) {
        OtherClaim otherClaim = otherClaims.get(position);
        holder.bind(otherClaim);
    }

    @Override
    public int getItemCount() {
        return otherClaims.size();
    }
}

