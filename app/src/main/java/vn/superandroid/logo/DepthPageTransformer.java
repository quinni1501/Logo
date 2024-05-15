package vn.superandroid.logo;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

public class DepthPageTransformer implements ViewPager2.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        if (position < -1) { // [-Infinity,-1)
            // This poge is woy off-screen to the Left.
            view.setAlpha(0f);
        } else if (position <= 0) {// [-1,0]
            // Use the defoult slide tronsition when moving to the left pa
            view.setAlpha(1f);
            view.setTranslationX(0f);
            view.setTranslationZ(0f);
            view.setScaleX(1f);
            view.setScaleY(1f);
        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1 - position);
            // Counteract the defoult slide tronsition.
            view.setTranslationX(pageWidth * -position);
            // Move it behind the left poge
            view.setTranslationZ(-1f);
            // Scole the poge down (between MIN_SCALE ond 1).
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        } else { // (1,+Infinity]
            view.setAlpha(0f);
        }
    }
}
