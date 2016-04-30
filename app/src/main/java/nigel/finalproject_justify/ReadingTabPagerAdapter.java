package nigel.finalproject_justify;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by diegoferope on 3/30/16.
 */
public class ReadingTabPagerAdapter extends PagerAdapter {

    Argument argument;

    public ReadingTabPagerAdapter(Argument argument) {
        this.argument = argument;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "CLAIM";
            case 1:
                return "EVIDENCE";
            case 2:
                return "JUSTIFICATION";
        }
        return null;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        switch (position) {
            case 0:
                ReadClaimView viewClaim = new ReadClaimView(container.getContext());
                viewClaim.setText(argument.claim);
                container.addView(viewClaim);
                return viewClaim;
            case 1:
                ReadEvidenceView viewEvidence = new ReadEvidenceView(container.getContext());
                viewEvidence.setText(argument.evidence);
                viewEvidence.setWebView1(argument.webUrl);
                container.addView(viewEvidence);
                return viewEvidence;
            case 2:
                ReadJustificationView viewJustification = new ReadJustificationView(container.getContext());
                viewJustification.setText(argument.justification);
                container.addView(viewJustification);
                return viewJustification;
            default:
                return null;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {//this is a necessary method
        return view == object;
    }

    //I also need this method:
    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }
}
