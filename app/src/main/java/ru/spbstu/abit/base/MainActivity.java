package ru.spbstu.abit.base;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout;

import java.util.Objects;

import ru.spbstu.abit.R;
import ru.spbstu.abit.base.home.HomeFragment;
import ru.spbstu.abit.base.home.structure.StructureFragment;
import ru.spbstu.abit.base.home.structure.model.Institute;
import ru.spbstu.abit.base.home.timeline.TimelineFragment;
import ru.spbstu.abit.base.home.timeline.model.TimelineEvent;
import ru.spbstu.abit.core.BaseActivity;

public class MainActivity
        extends BaseActivity
        implements TimelineFragment.OnTimelineEventInteractionListener,
        StructureFragment.OnStructureInstituteInteractionListener {

    private static final String TAG = "MainActivity";

    private static final int TIMELINE_FRAGMENT  = 1;
    private static final int STRUCTURE_FRAGMENT = 2;
    private static final int LOCATIONS_FRAGMENT = 3;
    private static final int MENU_FRAGMENT      = 4;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private BottomNavigationView mBottomNavigationView;

    private FragmentManager mFragmentManager;

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
                    switchToFragment(LOCATIONS_FRAGMENT);
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
                    .replace(R.id.fragment_holder, newFragment)
                    .commitAllowingStateLoss();
        }
    }

    private void initViews ( ) {
        mBottomNavigationView = findViewById(R.id.navigation);
        mToolbar = findViewById(R.id.toolbar);
        mCollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
    }

    private void initToolbar ( ) {
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
    }

    private void setContent( ) {
        mFragmentManager = getSupportFragmentManager();
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mCollapsingToolbarLayout.setCollapsedTitleTypeface(ResourcesCompat.getFont(this, R.font.pt_sans_bold));
        mCollapsingToolbarLayout.setExpandedTitleTypeface(ResourcesCompat.getFont(this, R.font.pt_sans_bold));
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorText)));
        mCollapsingToolbarLayout.setExpandedTitleTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorText)));
    }

    public void setToolbarTitle (int titleId) {
        mCollapsingToolbarLayout.setTitle(getString(titleId));
    }

    private void switchToFragment(int id) {
        HomeFragment fragment = TimelineFragment.newInstance();

        //clearCategoriesFragments();

        switch (id) {
            case TIMELINE_FRAGMENT:
                fragment = TimelineFragment.newInstance();
                break;
            case STRUCTURE_FRAGMENT:
                fragment = StructureFragment.newInstance();
                break;
            case LOCATIONS_FRAGMENT:
                // TODO
                return;
            case MENU_FRAGMENT:
                // TODO
                return;
        }

        mFragmentManager.beginTransaction()
                .replace(R.id.fragment_holder, fragment)
                .commitAllowingStateLoss();
    }

    private void clearCategoriesFragments() {
        FragmentTransaction ft = mFragmentManager.beginTransaction();

        for ( Fragment fragment : mFragmentManager.getFragments( ) ) {
            if (fragment instanceof HomeFragment) {
                Log.d(TAG, "Found HomeFragment");
                ft.remove(fragment);
            }
        }

        ft.commitAllowingStateLoss();
    }

    @Override
    public void onListFragmentInteraction (TimelineEvent event) {
        Log.d(TAG, "User selected event: " + event.toString());
    }

    @Override
    public void onListFragmentInteraction (Institute institute) {
        Log.d(TAG, "User selected institute: " + institute.toString());
    }
}
