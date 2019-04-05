package ru.spbstu.abit.base.home.structure.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
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
import ru.spbstu.abit.base.home.structure.StructureFragment;
import ru.spbstu.abit.base.home.structure.model.Institute;

public class StructureInstitutesRecyclerAdapter
        extends RecyclerView.Adapter< StructureInstitutesRecyclerAdapter.ViewHolder > {

    private Context mContext;

    private final List< Institute > mInstitutes;
    private final StructureFragment.OnStructureInstituteInteractionListener mListener;

    public StructureInstitutesRecyclerAdapter (
            List< Institute > items,
            StructureFragment.OnStructureInstituteInteractionListener listener
    ) {
        this.mInstitutes = items;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public StructureInstitutesRecyclerAdapter.ViewHolder onCreateViewHolder (
            @NonNull ViewGroup parent,
            int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext( )).inflate(
                R.layout.fragment_structure_item_institute,
                parent,
                false
        );

        mContext = parent.getContext( );

        return new StructureInstitutesRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder (
            @NonNull final ViewHolder holder,
            int position
    ) {
        Institute institute = mInstitutes.get(position);
        holder.mItem = institute;
        holder.mInstituteNameTextView.setText(institute.getName());
        holder.mStudyProgramsTextView.setText(
                mContext.getString(
                        R.string.study_programs_valued,
                        institute.getStudyPrograms().size()
                )
        );
        Bitmap bmp = BitmapFactory.decodeResource(mContext.getResources(), institute.getBackgroundDrawableId());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mContext.getResources(), bmp);
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        holder.mBackgroundImage.setBackground(bitmapDrawable);

        holder.mHolderView.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                if ( null != mListener ) {
                    mListener.onStructureInstituteSelected(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount ( ) {
        return mInstitutes.size( );
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ConstraintLayout mHolderView;
        final TextView mInstituteNameTextView;
        final TextView mStudyProgramsTextView;
        final ImageView mBackgroundImage;

        Institute mItem;

        ViewHolder (View view) {
            super(view);
            mHolderView = view.findViewById(R.id.institute_holder);
            mInstituteNameTextView = view.findViewById(R.id.institute_name);
            mStudyProgramsTextView = view.findViewById(R.id.institute_programs);
            mBackgroundImage = view.findViewById(R.id.institute_background);
        }

        @NonNull
        @Override
        public String toString ( ) {
            return "ViewHolder {\n" +
                    "\tmHolderView = " + (mHolderView != null ? mHolderView : "") + '\n' +
                    "\tmInstituteNameTextView = " + (mInstituteNameTextView != null ? mInstituteNameTextView : "") + '\n' +
                    "\tmStudyProgramsTextView = " + (mStudyProgramsTextView != null ? mStudyProgramsTextView : "") + '\n' +
                    "\tmBackgroundImage = " + (mBackgroundImage != null ? mBackgroundImage : "") + '\n' +
                    "\tmItem = " + (mItem != null ? mItem : "") + '\n' +
                    '}';
        }
    }
}
