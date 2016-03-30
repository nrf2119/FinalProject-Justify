package nigel.finalproject_justify;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ccteadmin on 3/29/16.
 */
public class InquiryViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView;
    private TextView inquiryQuestionView;
    private ImageView inquiryPhotoView;
    private Context context;

    public InquiryViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view_inquiry);
        inquiryQuestionView = (TextView) itemView.findViewById(R.id.inquiry_question);
        inquiryPhotoView = (ImageView) itemView.findViewById(R.id.inquiry_photo);
        this.context = context;
    }

    public void bind(Inquiry inquiry) {
        inquiryQuestionView.setText(inquiry.question);
        inquiryPhotoView.setImageResource(inquiry.photoId);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PositionActivity.class);
                context.startActivity(intent);
//                Toast.makeText(context, inquiryQuestionView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}


