package ru.spbstu.abit.base.home.timeline;

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

import ru.spbstu.abit.R;
import ru.spbstu.abit.base.MainActivity;
import ru.spbstu.abit.base.home.HomeFragment;
import ru.spbstu.abit.base.home.timeline.model.TimelineEvent;
import ru.spbstu.abit.base.home.timeline.view.TimelineEventsRecyclerAdapter;
import ru.spbstu.abit.core.BaseActivity;

public class TimelineFragment extends HomeFragment {

    private static final String TAG = "TimelineFragment";

    private BaseActivity mActivity;
    private OnTimelineEventInteractionListener mListener;

    private View mView;
    private RecyclerView mRecyclerView;

    private ArrayList<TimelineEvent> mTimelineEvents;

    public TimelineFragment ( ) {}

    public static TimelineFragment newInstance ( ) {
        return new TimelineFragment( );
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

        if (context instanceof OnTimelineEventInteractionListener) {
            mListener = (OnTimelineEventInteractionListener) context;
        } else {
            Log.e(TAG, "[onAttach] " +
                    context.toString( ) + " not implementing OnTimelineEventInteractionListener");
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
                R.layout.fragment_timeline,
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
    protected void parseArguments() { }

    @Override
    protected void initViews ( ) {
        mRecyclerView = mView.findViewById(R.id.events_recycler);
    }

    @Override
    protected void initToolbar ( ) {
        ((MainActivity) mActivity).setToolbarSpannableTitle(
                mActivity.getString(R.string.titles_array_item_01),
                R.color.colorDark,
                false
        );
    }

    @Override
    protected void setContent ( ) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        if (mTimelineEvents == null || mTimelineEvents.isEmpty()) {
            mTimelineEvents = getDefaultEventsList();
        }

        mRecyclerView.setAdapter(new TimelineEventsRecyclerAdapter(mTimelineEvents, mListener));
    }

    private ArrayList<TimelineEvent> getDefaultEventsList() {
        ArrayList<TimelineEvent> events = new ArrayList<>();
        events.add(new TimelineEvent(
                mActivity.getString(R.string.educations_form_array_item_01) + " " + mActivity.getString(R.string.educations_form_array_item_03),
                mActivity.getString(R.string.funding_forms_array_item_01),
                "Окончание приёма документов для поступающих по ЕГЭ. Окончание проведения вступительных экзаменов",
                mActivity.getString(R.string.months_array_item_07),
                26,
                false
        ));
        events.add(new TimelineEvent(
                mActivity.getString(R.string.educations_form_array_item_01) + " " + mActivity.getString(R.string.educations_form_array_item_03),
                mActivity.getString(R.string.funding_forms_array_item_01),
                "Завершение приёма заявлений о согласии на зачисление (по квотам и без вступительных испытаний",
                mActivity.getString(R.string.months_array_item_07),
                28,
                false
        ));
        events.add(new TimelineEvent(
                mActivity.getString(R.string.educations_form_array_item_01) + " " + mActivity.getString(R.string.educations_form_array_item_03),
                mActivity.getString(R.string.funding_forms_array_item_01),
                "Приказ о зачислении лиц, подавших заявление о согласии на зачисление (по квотам)",
                mActivity.getString(R.string.months_array_item_07),
                29,
                false
        ));
        events.add(new TimelineEvent(
                mActivity.getString(R.string.educations_form_array_item_01) + " " + mActivity.getString(R.string.educations_form_array_item_03),
                mActivity.getString(R.string.funding_forms_array_item_01),
                "Приказ о зачислении лиц, подавших заявление о согласии на зачисление (по квотам)",
                mActivity.getString(R.string.months_array_item_07),
                29,
                false
        ));
        events.add(new TimelineEvent(
                mActivity.getString(R.string.educations_form_array_item_01) + " " + mActivity.getString(R.string.educations_form_array_item_03),
                mActivity.getString(R.string.funding_forms_array_item_01),
                "Приказ о зачислении лиц, подавших заявление о согласии на зачисление (по квотам)",
                mActivity.getString(R.string.months_array_item_07),
                29,
                false
        ));
        events.add(new TimelineEvent(
                mActivity.getString(R.string.educations_form_array_item_01) + " " + mActivity.getString(R.string.educations_form_array_item_03),
                mActivity.getString(R.string.funding_forms_array_item_01),
                "Приказ о зачислении лиц, подавших заявление о согласии на зачисление (по квотам)",
                mActivity.getString(R.string.months_array_item_07),
                29,
                false
        ));
        events.add(new TimelineEvent(
                mActivity.getString(R.string.educations_form_array_item_01) + " " + mActivity.getString(R.string.educations_form_array_item_03),
                mActivity.getString(R.string.funding_forms_array_item_01),
                "Завершение приёма заявлений о согласии на зачисление (Первый этап)",
                mActivity.getString(R.string.months_array_item_08),
                1,
                true
        ));

        return events;
    }

    @Override
    public void onDetach ( ) {
        super.onDetach( );
        mListener = null;
    }

    public interface OnTimelineEventInteractionListener {
        void onTimelineEventSelected(TimelineEvent event);
    }
}
