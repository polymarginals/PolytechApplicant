package ru.spbstu.abit.base.home.timeline.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.spbstu.abit.R;
import ru.spbstu.abit.base.home.timeline.TimelineFragment;
import ru.spbstu.abit.base.home.timeline.model.TimelineEvent;

import static ru.spbstu.abit.core.App.getColorId;

public class TimelineEventsRecyclerAdapter
        extends RecyclerView.Adapter< TimelineEventsRecyclerAdapter.ViewHolder > {

    private Context mContext;

    private final List< TimelineEvent > mEvents;
    private final TimelineFragment.OnTimelineEventInteractionListener mListener;

    public TimelineEventsRecyclerAdapter (
            List< TimelineEvent > items,
            TimelineFragment.OnTimelineEventInteractionListener listener
    ) {
        mEvents = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (
            @NonNull ViewGroup parent,
            int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext( )).inflate(
                R.layout.fragment_timeline_item_event,
                parent,
                false
        );

        mContext = parent.getContext();

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder (
            @NonNull final ViewHolder holder,
            int position
    ) {
        TimelineEvent event = mEvents.get(position);
        holder.mItem = event;
        holder.mMonthTextView.setText(event.getMonth());
        holder.mDayTextView.setText(String.valueOf(event.getDay()));
        holder.mEducationFormTextView.setText(event.getEducationForm());
        holder.mFundingFormTextView.setText(event.getFundingForm());
        holder.mDescriptionTextView.setText(event.getDescription());

        if (event.isSelected()) {
            holder.mMonthTextView.setTextColor(getColorId(R.color.colorPrimary));
            holder.mDayTextView.setTextColor(getColorId(R.color.colorPrimary));
        }

        holder.mView.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                if ( null != mListener ) {
                    mListener.onTimelineEventSelected(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount ( ) {
        return mEvents.size( );
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mMonthTextView;
        final TextView mDayTextView;
        final TextView mEducationFormTextView;
        final TextView mFundingFormTextView;
        final TextView mDescriptionTextView;

        TimelineEvent mItem;

        ViewHolder (View view) {
            super(view);
            mView = view;
            mMonthTextView = view.findViewById(R.id.event_month_text);
            mDayTextView = view.findViewById(R.id.event_day_text);
            mEducationFormTextView = view.findViewById(R.id.event_education_form_text);
            mFundingFormTextView = view.findViewById(R.id.event_funding_form_text);
            mDescriptionTextView = view.findViewById(R.id.event_description_text);
        }

        @NonNull
        @Override
        public String toString ( ) {
            return "ViewHolder {\n" +
                    "\tmView = " + (mView != null ? mView : "") + '\n' +
                    "\tmMonthTextView = " + (mMonthTextView != null ? mMonthTextView : "") + '\n' +
                    "\tmDayTextView = " + (mDayTextView != null ? mDayTextView : "") + '\n' +
                    "\tmEducationFormTextView = " + (mEducationFormTextView != null ? mEducationFormTextView : "") + '\n' +
                    "\tmFundingFormTextView = " + (mFundingFormTextView != null ? mFundingFormTextView : "") + '\n' +
                    "\tmDescriptionTextView = " + (mDescriptionTextView != null ? mDescriptionTextView : "") + '\n' +
                    "\tmItem = " + (mItem != null ? mItem : "") + '\n' +
                    '}';
        }
    }
}