package ru.spbstu.abit.base.home;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public abstract class HomeFragment extends Fragment  {

    protected abstract void parseArguments();

    protected abstract void initViews();

    protected abstract void initToolbar();

    protected abstract void setContent();

    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Animation animation = super.onCreateAnimation(transit, enter, nextAnim);

        if (animation == null && nextAnim != 0) {
            animation = AnimationUtils.loadAnimation(getActivity(), nextAnim);
        }

        final View view = getView();
        if (view == null) {
            return animation;
        }

        if (animation != null) {
            view.setLayerType(View.LAYER_TYPE_HARDWARE, null);

            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                public void onAnimationEnd(Animation animation) {
                    view.setLayerType(View.LAYER_TYPE_NONE, null);
                }

                @Override
                public void onAnimationRepeat(Animation animation) { }
            });
        }

        return animation;
    }
}
