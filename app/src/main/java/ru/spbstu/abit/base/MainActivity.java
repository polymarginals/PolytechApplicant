package ru.spbstu.abit.base;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout;

import java.util.ArrayList;

import ru.spbstu.abit.R;
import ru.spbstu.abit.base.home.menu.MenuFragment;
import ru.spbstu.abit.base.home.menu.model.MenuListItem;
import ru.spbstu.abit.base.home.structure.StructureFragment;
import ru.spbstu.abit.base.home.structure.model.Institute;
import ru.spbstu.abit.base.home.timeline.TimelineFragment;
import ru.spbstu.abit.base.home.timeline.model.TimelineEvent;
import ru.spbstu.abit.core.BaseActivity;
import ru.spbstu.abit.core.util.ResizeAnimation;

import static ru.spbstu.abit.core.App.getColorId;

public class MainActivity
        extends BaseActivity
        implements
            TimelineFragment.OnTimelineEventInteractionListener,
            StructureFragment.OnStructureInstituteInteractionListener,
            MenuFragment.OnMenuItemInteractionListener,
            MenuFragment.OnMenuFragmentDismissListener {

    private static final String TAG = "MainActivity";

    private static final int TIMELINE_FRAGMENT  = 0;
    private static final int STRUCTURE_FRAGMENT = 1;
    private static final int LOCATIONS_FRAGMENT = 2;
    private static final int MENU_FRAGMENT      = 3;

    private static final boolean APPBAR_EXPANDED             = true;
    private static final boolean APPBAR_COLLAPSED            = false;
    public static final boolean ACTIVE_TOOLBAR_BACK_BUTTON   = true;
    public static final boolean INACTIVE_TOOLBAR_BACK_BUTTON = false;

    private AppBarLayout            mAppBarLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar                 mToolbar;
    private BottomNavigationView    mBottomNavigationView;
    private LinearLayout            mSubstrateHolder;
    private ImageView               mSubstrateImage;

    private FragmentManager         mFragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener( ) {

        @Override
        public boolean onNavigationItemSelected (@NonNull MenuItem item) {
            switch (item.getItemId( )) {
                case R.id.navigation_timeline:
                    switchToFragment(TIMELINE_FRAGMENT);
                    return true;
                case R.id.navigation_structure:
                    switchToFragment(STRUCTURE_FRAGMENT);
                    return true;
                case R.id.navigation_locations:
                    //switchToFragment(LOCATIONS_FRAGMENT);
                    return true;
                case R.id.navigation_menu:
                    switchToFragment(MENU_FRAGMENT);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        initToolbar();
        setContent();

        if (savedInstanceState == null) {
            Fragment newFragment = TimelineFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .replace(R.id.fragment_holder, newFragment)
                    .commitAllowingStateLoss();
        }
    }

    private void initViews ( ) {
        mAppBarLayout = findViewById(R.id.appbar);
        mBottomNavigationView = findViewById(R.id.navigation);
        mToolbar = findViewById(R.id.toolbar);
        mCollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        mSubstrateHolder = findViewById(R.id.substrate_holder);
        mSubstrateImage = findViewById(R.id.substrate_image);
    }

    private void initToolbar ( ) {
        setSupportActionBar(mToolbar);
        toggleToolbarBackButton(INACTIVE_TOOLBAR_BACK_BUTTON);
    }

    private void setContent( ) {
        mFragmentManager = getSupportFragmentManager();
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mCollapsingToolbarLayout.setCollapsedTitleTypeface(ResourcesCompat.getFont(this, R.font.pt_sans_bold));
        mCollapsingToolbarLayout.setExpandedTitleTypeface(ResourcesCompat.getFont(this, R.font.pt_sans_bold));
        setToolbarTitleColor(R.color.colorDark);
    }

    private void setToolbarTitleColor(int colorId) {
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(ColorStateList.valueOf(getResources().getColor(colorId)));
        mCollapsingToolbarLayout.setExpandedTitleTextColor(ColorStateList.valueOf(getResources().getColor(colorId)));
    }

    private void setToolbarTitle(SpannableString title) {
        mCollapsingToolbarLayout.setTitle(title);
        setToolbarTitleColor(R.color.colorWhite);
    }

    private void setToolbarTitle(String title) {
        mCollapsingToolbarLayout.setTitle(title);
        setToolbarTitleColor(R.color.colorDark);
    }

    public void scaleAppbarHeight(boolean scaleUp) {
        ResizeAnimation resizeAnimation;
        if (scaleUp) {
            resizeAnimation = new ResizeAnimation(
                    mAppBarLayout,
                    (int) getResources().getDimension(R.dimen.appbar_big_height),
                    (int) getResources().getDimension(R.dimen.appbar_small_height)
            );
        } else {
            resizeAnimation = new ResizeAnimation(
                    mAppBarLayout,
                    (int) getResources().getDimension(R.dimen.appbar_small_height),
                    (int) getResources().getDimension(R.dimen.appbar_big_height)
            );
        }
        resizeAnimation.setDuration(500);
        mAppBarLayout.startAnimation(resizeAnimation);
        //mAppBarLayout.animate().scaleY(height).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(1000);
    }

    private void switchToFragment(int id) {
        mAppBarLayout.setExpanded(APPBAR_EXPANDED);
        clearFragments();

        Fragment currentFragment = mFragmentManager.findFragmentById(R.id.fragment_holder);
        if (currentFragment == null) {
            Log.e(TAG, getString(R.string.error_fragment_is_null));
            Toast.makeText(
                    this,
                    getString(R.string.error_fragment_is_null),
                    Toast.LENGTH_LONG
            ).show();

            return;
        }
        Fragment nextFragment = TimelineFragment.newInstance();

        switch (id) {
            case TIMELINE_FRAGMENT:
                if (currentFragment instanceof TimelineFragment) {
                    return;
                }
                nextFragment = TimelineFragment.newInstance();
                break;

            case STRUCTURE_FRAGMENT:
                if (currentFragment instanceof StructureFragment) {
                    return;
                }
                nextFragment = StructureFragment.newInstance();
                break;

            case LOCATIONS_FRAGMENT:
                // TODO
                return;

            case MENU_FRAGMENT:
                nextFragment = MenuFragment.newInstance();
                break;
        }

        mFragmentManager.beginTransaction()
                .replace(R.id.fragment_holder, nextFragment)
                .commitAllowingStateLoss();
    }

    private void addNewFragment(int id, Bundle bundle) {
        mAppBarLayout.setExpanded(APPBAR_EXPANDED);

        Fragment currentFragment = mFragmentManager.findFragmentById(R.id.fragment_holder);
        if (currentFragment == null) {
            Log.e(TAG, getString(R.string.error_fragment_is_null));
            Toast.makeText(
                    this,
                    getString(R.string.error_fragment_is_null),
                    Toast.LENGTH_LONG
            ).show();

            return;
        }
        Fragment nextFragment = TimelineFragment.newInstance();

        switch (id) {
            case TIMELINE_FRAGMENT:
                nextFragment = TimelineFragment.newInstance();
                break;

            case STRUCTURE_FRAGMENT:
                nextFragment = StructureFragment.newInstance();
                break;

            case LOCATIONS_FRAGMENT:
                // TODO
                return;

            case MENU_FRAGMENT:
                nextFragment = MenuFragment.newInstance();
                break;
        }

        nextFragment.setArguments(bundle);

        mFragmentManager.beginTransaction()
                .hide(currentFragment)
                .add(R.id.fragment_holder, nextFragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

    private void clearFragments() {
        for(int i = 0; i < mFragmentManager.getBackStackEntryCount(); i++) {
            mFragmentManager.popBackStack();
        }
    }

    public void setToolbarSpannableTitle(String title, int colorId) {
        if (colorId == R.color.colorDark) {
            setToolbarTitle(title);
            toggleSubstrate(View.GONE, getColorId(R.color.colorGrey));
            return;
        }

        SpannableString spannableString = new SpannableString(title);
        BackgroundColorSpan backgroundSpan;
        backgroundSpan = new BackgroundColorSpan(getColorId(colorId));
        spannableString.setSpan(
                backgroundSpan,
                0,
                spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        toggleSubstrate(View.VISIBLE, getColorId(colorId));
        setToolbarTitle(spannableString);
    }

    public void toggleToolbarBackButton(boolean active) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(active);
            getSupportActionBar().setDisplayShowHomeEnabled(active);
        }
    }

    private void toggleSubstrate(int visibility, int colorId) {
        mSubstrateHolder.setVisibility(visibility);
        mAppBarLayout.setBackgroundColor(colorId);
        mCollapsingToolbarLayout.setContentScrimColor(colorId);
        mCollapsingToolbarLayout.setStatusBarScrimColor(colorId);
        mSubstrateImage.setBackgroundColor(colorId);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(
                    colorId == getColorId(R.color.colorGrey)
                            ? getColorId(R.color.colorDarkGrey)
                            : colorId
            );
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onTimelineEventSelected(TimelineEvent event) {
        Log.d(TAG, "User selected event: " + event.toString());
    }

    @Override
    public void onStructureInstituteSelected(Institute institute) {
        Log.d(TAG, "User selected institute: " + institute.toString());
        ArrayList<MenuListItem> menuListItems = new ArrayList<>();
        menuListItems.add(new MenuListItem(
                getString(R.string.institute_content_menu_array_item_01),
                R.drawable.ic_study_programs,
                institute.getColorId(),
                institute.getColorLightId()
        ));
        menuListItems.add(new MenuListItem(
                getString(R.string.institute_content_menu_array_item_02),
                R.drawable.ic_institute,
                institute.getColorId(),
                institute.getColorLightId()
        ));
        menuListItems.add(new MenuListItem(
                getString(R.string.institute_content_menu_array_item_03),
                R.drawable.ic_structure,
                institute.getColorId(),
                institute.getColorLightId()
        ));
        menuListItems.add(new MenuListItem(
                getString(R.string.institute_content_menu_array_item_04),
                R.drawable.ic_planet,
                institute.getColorId(),
                institute.getColorLightId()
        ));

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(MenuFragment.ARGUMENT_LIST, menuListItems);
        bundle.putString(MenuFragment.ARGUMENT_TITLE, institute.getName());
        bundle.putInt(MenuFragment.ARGUMENT_COLOR, institute.getColorId());

        addNewFragment(MENU_FRAGMENT, bundle);
    }

    @Override
    public void onMenuListItemSelected(MenuListItem menuListItem) {
        Log.d(TAG, "User selected menu item: " + menuListItem.toString());
    }

    @Override
    public void onMenuFragmentDismissed() {
        setToolbarSpannableTitle(
                getString(R.string.titles_array_item_04),
                R.color.colorDark
        );
        toggleToolbarBackButton(INACTIVE_TOOLBAR_BACK_BUTTON);
        scaleAppbarHeight(false);

        /*mAppBarLayout.getLayoutParams().height = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                140,
                getResources().getDisplayMetrics()
        );*/
    }
}
