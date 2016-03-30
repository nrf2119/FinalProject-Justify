package nigel.finalproject_justify;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ccteadmin on 2/23/16.
 */
public class OtherClaimViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView userNameView;
    private ImageView positionPhotoView;
    private Context context;

    public OtherClaimViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view_other_claim);
        userNameView = (TextView) itemView.findViewById(R.id.other_user_name);
        positionPhotoView = (ImageView) itemView.findViewById(R.id.position_photo);
        this.context = context;
    }

    public void bind(OtherClaim otherClaim) {
        userNameView.setText(otherClaim.userName);
        positionPhotoView.setImageResource(otherClaim.positionPhotoId);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, userNameView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


