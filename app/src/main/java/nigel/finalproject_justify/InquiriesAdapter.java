package nigel.finalproject_justify;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ccteadmin on 3/29/16.
 */
public class InquiriesAdapter extends RecyclerView.Adapter<InquiryViewHolder> {
    private List<Inquiry> inquiries;
    private Context context;
    private boolean inquiry;

    public InquiriesAdapter(List<Inquiry> inquiries, Context context, boolean inquiry) {
        this.inquiries = inquiries;
        this.context = context;
        this.inquiry = inquiry;
    }

    @Override
    public InquiryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_inquiry, parent, false);
        return new InquiryViewHolder(view, context, inquiry);
    }

    @Override
    public void onBindViewHolder(InquiryViewHolder holder, int position) {
        Inquiry inquiry = inquiries.get(position);
        holder.bind(inquiry);
    }

    @Override
    public int getItemCount() {
        return inquiries.size();
    }
}

