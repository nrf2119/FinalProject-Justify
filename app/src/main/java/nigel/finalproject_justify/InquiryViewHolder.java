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
    private boolean isInquiry;

    public InquiryViewHolder(View itemView, final Context context, boolean isInquiry) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view_inquiry);
        inquiryQuestionView = (TextView) itemView.findViewById(R.id.inquiry_question);
        inquiryPhotoView = (ImageView) itemView.findViewById(R.id.inquiry_photo);
        this.context = context;
        this.isInquiry = isInquiry;
    }

    public void bind(final Inquiry inquiry) {
        inquiryQuestionView.setText(inquiry.question);
        inquiryPhotoView.setImageResource(inquiry.photoId);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInquiry) {
                    Intent intent = new Intent(context, PositionActivity.class);
//                    intent.putExtra("Key", inquiry);
//                    Inquiry i = (Inquiry) intent.getSerializableExtra("Key");
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, SeeOthersActivity.class);
                    context.startActivity(intent);
                }
//                Toast.makeText(context, inquiryQuestionView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}


