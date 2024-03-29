package ru.spbstu.abit.base.home.menu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.spbstu.abit.R;
import ru.spbstu.abit.base.MainActivity;
import ru.spbstu.abit.base.home.HomeFragment;
import ru.spbstu.abit.base.home.menu.model.MenuListItem;
import ru.spbstu.abit.base.home.menu.view.MenuItemsRecyclerAdapter;
import ru.spbstu.abit.core.BaseActivity;

public class MenuFragment extends HomeFragment {

    private static final String TAG = "MenuFragment";

    public static final String ARGUMENT_LIST  = "menu_list";
    public static final String ARGUMENT_TITLE = "menu_title";
    public static final String ARGUMENT_COLOR = "menu_color";

    private BaseActivity mActivity;
    private OnMenuItemInteractionListener mListener;

    private View mView;
    private RecyclerView mRecyclerView;

    private boolean mUsingAsMainMenu = true;
    private String mMenuTitle = null;
    private int mSubtractColorId = R.color.colorGreen;
    private List<MenuListItem> mMenuListItems = null;

    public MenuFragment ( ) {}

    public static MenuFragment newInstance ( ) {
        return new MenuFragment( );
    }

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);

        if (context == null) {
            Log.e(TAG, "[onAttach] " +
                    "[ERROR] Context is null");
        }
        assert context != null;

        mActivity = (BaseActivity) context;

        if (context instanceof OnMenuItemInteractionListener) {
            mListener = (OnMenuItemInteractionListener) context;
        } else {
            Log.e(TAG, "[onAttach] " +
                    context.toString( ) + " not implementing OnMenuItemInteractionListener");
        }
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        mView = inflater.inflate(
                R.layout.fragment_menu,
                container,
                false
        );

        parseArguments();
        initViews();
        initToolbar();
        setContent();

        return mView;
    }

    @Override
    protected void parseArguments() {
        if (getArguments() != null) {
            if (getArguments().containsKey(ARGUMENT_LIST)) {
                mMenuListItems = getArguments().getParcelableArrayList(ARGUMENT_LIST);
                mUsingAsMainMenu = false;
            }
            if (getArguments().containsKey(ARGUMENT_TITLE)) {
                mMenuTitle = getArguments().getString(ARGUMENT_TITLE);
            }
            if (getArguments().containsKey(ARGUMENT_COLOR)) {
                mSubtractColorId = getArguments().getInt(ARGUMENT_COLOR);
            }
        }
    }

    @Override
    protected void initViews ( ) {
        mRecyclerView = mView.findViewById(R.id.menu_recycler);
    }

    @Override
    protected void initToolbar ( ) {
        if (mMenuTitle == null) {
            mMenuTitle = getString(R.string.titles_array_item_02);
        }
        if (!mUsingAsMainMenu) {
            ((MainActivity) mActivity).scaleAppbarHeight(true);
            ((MainActivity) mActivity).toggleToolbarBackButton(MainActivity.ACTIVE_TOOLBAR_BACK_BUTTON);

            ((MainActivity) mActivity).setToolbarSpannableTitle(
                    mMenuTitle,
                    mSubtractColorId,
                    false
            );
        } else {
            ((MainActivity) mActivity).setToolbarSpannableTitle(
                    mMenuTitle,
                    mSubtractColorId,
                    true
            );
        }
    }

    @Override
    protected void setContent ( ) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        if (mUsingAsMainMenu) {
            mMenuListItems = getDefaultMenuEntranceList();
        }

        mRecyclerView.setAdapter(new MenuItemsRecyclerAdapter(mMenuListItems, mListener));
    }

    private ArrayList<MenuListItem> getDefaultMenuEntranceList() {
        ArrayList<MenuListItem> menuListItems = new ArrayList<>();
        menuListItems.add(new MenuListItem(
                mActivity.getString(R.string.menu_entrance_array_item_01),
                R.drawable.ic_assignment,
                R.color.colorPrimary,
                R.color.colorLightSalad
        ));
        menuListItems.add(new MenuListItem(
                mActivity.getString(R.string.menu_entrance_array_item_02),
                R.drawable.ic_rules,
                R.color.colorPrimary,
                R.color.colorLightSalad
        ));
        menuListItems.add(new MenuListItem(
                mActivity.getString(R.string.menu_entrance_array_item_03),
                R.drawable.ic_why_polytech,
                R.color.colorPrimary,
                R.color.colorLightSalad
        ));
        menuListItems.add(new MenuListItem(
                mActivity.getString(R.string.menu_entrance_array_item_04),
                R.drawable.ic_contacts,
                R.color.colorPrimary,
                R.color.colorLightSalad
        ));
        menuListItems.add(new MenuListItem(
                mActivity.getString(R.string.menu_entrance_array_item_05),
                R.drawable.ic_people,
                R.color.colorPrimary,
                R.color.colorLightSalad
        ));
        menuListItems.add(new MenuListItem(
                mActivity.getString(R.string.menu_entrance_array_item_01),
                R.drawable.ic_assignment,
                R.color.colorPrimary,
                R.color.colorLightSalad
        ));
        menuListItems.add(new MenuListItem(
                mActivity.getString(R.string.menu_entrance_array_item_02),
                R.drawable.ic_rules,
                R.color.colorPrimary,
                R.color.colorLightSalad
        ));
        menuListItems.add(new MenuListItem(
                mActivity.getString(R.string.menu_entrance_array_item_03),
                R.drawable.ic_why_polytech,
                R.color.colorPrimary,
                R.color.colorLightSalad
        ));
        menuListItems.add(new MenuListItem(
                mActivity.getString(R.string.menu_entrance_array_item_04),
                R.drawable.ic_contacts,
                R.color.colorPrimary,
                R.color.colorLightSalad
        ));
        menuListItems.add(new MenuListItem(
                mActivity.getString(R.string.menu_entrance_array_item_05),
                R.drawable.ic_people,
                R.color.colorPrimary,
                R.color.colorLightSalad
        ));

        return menuListItems;
    }

    @Override
    public void onDetach ( ) {
        super.onDetach( );
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (!mUsingAsMainMenu && mActivity instanceof OnMenuFragmentDismissListener) {
            ((OnMenuFragmentDismissListener) mActivity).onMenuFragmentDismissed();
        }
    }

    public interface OnMenuItemInteractionListener {
        void onMenuListItemSelected(MenuListItem menuListItem);
    }

    public interface OnMenuFragmentDismissListener {
        void onMenuFragmentDismissed();
    }
}
