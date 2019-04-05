package ru.spbstu.abit.base.home.menu.view;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.spbstu.abit.R;
import ru.spbstu.abit.base.home.menu.MenuFragment;
import ru.spbstu.abit.base.home.menu.model.MenuListItem;

import static ru.spbstu.abit.core.App.getColorId;

public class MenuItemsRecyclerAdapter extends RecyclerView.Adapter< MenuItemsRecyclerAdapter.ViewHolder > {

    private final List<MenuListItem> mMenuListItems;
    private final MenuFragment.OnMenuItemInteractionListener mListener;

    public MenuItemsRecyclerAdapter (
            List<MenuListItem> items,
            MenuFragment.OnMenuItemInteractionListener listener
    ) {
        mMenuListItems = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public MenuItemsRecyclerAdapter.ViewHolder onCreateViewHolder (
            @NonNull ViewGroup parent,
            int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext( )).inflate(
                R.layout.fragment_menu_item,
                parent,
                false
        );

        return new MenuItemsRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder (
            @NonNull final MenuItemsRecyclerAdapter.ViewHolder holder,
            int position
    ) {
        MenuListItem item = mMenuListItems.get(position);

        if (position == mMenuListItems.size() - 1) {
            holder.mSeparator.setVisibility(View.GONE);
        }

        holder.mItem = item;
        holder.mTitle.setText(item.getTitle());
        holder.mIcon.setColorFilter(getColorId(item.getIconColorId()));
        holder.mIcon.setImageResource(item.getIconId());

        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setColor(getColorId(item.getIconBackgroundColorId()));
        holder.mIconHolder.setBackground(drawable);

        holder.mView.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                if ( null != mListener ) {
                    mListener.onMenuListItemSelected(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount ( ) {
        return mMenuListItems.size( );
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final View mSeparator;
        final TextView mTitle;
        final ConstraintLayout mIconHolder;
        final ImageView mIcon;

        MenuListItem mItem;

        ViewHolder (View view) {
            super(view);
            mView = view;
            mSeparator = view.findViewById(R.id.menu_item_separator);
            mTitle = view.findViewById(R.id.menu_item_title_text);
            mIconHolder = view.findViewById(R.id.menu_item_icon_holder);
            mIcon = view.findViewById(R.id.menu_item_icon_image);
        }

        @NonNull
        @Override
        public String toString() {
            return "ViewHolder {\n" +
                    "\tmView = " + (mView != null ? mView : "") + '\n' +
                    "\tmTitle = " + (mTitle != null ? mTitle : "") + '\n' +
                    "\tmIcon = " + (mIcon != null ? mIcon : "") + '\n' +
                    "\tmItem = " + (mItem != null ? mItem : "") + '\n' +
                    '}';
        }
    }
}

