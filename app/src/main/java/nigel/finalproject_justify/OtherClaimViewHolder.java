package nigel.finalproject_justify;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

    public void bind(final Argument otherClaim) {
        userNameView.setText(otherClaim.user);
        if (otherClaim.agreement)
            positionPhotoView.setImageResource(R.drawable.icon_agree);
        else
            positionPhotoView.setImageResource(R.drawable.icon_disagree);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ReadArgumentActivity.class);
                intent.putExtra(Keys.CHOSEN_INQUIRY_CARD, otherClaim);
                context.startActivity(intent);
//                Toast.makeText(context, userNameView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


