package ru.spbstu.abit.base.home.structure;

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
import ru.spbstu.abit.base.home.structure.model.Institute;
import ru.spbstu.abit.base.home.structure.model.StudyProgram;
import ru.spbstu.abit.base.home.structure.view.StructureInstitutesRecyclerAdapter;
import ru.spbstu.abit.core.BaseActivity;

public class StructureFragment extends HomeFragment {

    private static final String TAG = "StructureFragment";

    private BaseActivity mActivity;
    private OnStructureInstituteInteractionListener mListener;

    private View mView;
    private RecyclerView mRecyclerView;

    private ArrayList<Institute> mInstitutes;

    public StructureFragment ( ) {}

    public static StructureFragment newInstance ( ) {
        return new StructureFragment( );
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

        if (context instanceof OnStructureInstituteInteractionListener) {
            mListener = (OnStructureInstituteInteractionListener) context;
        } else {
            Log.e(TAG, "[onAttach] " +
                    context.toString( ) + " not implementing OnStructureInstituteInteractionListener");
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
                R.layout.fragment_structure,
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
        mRecyclerView = mView.findViewById(R.id.institutes_recycler);
    }

    @Override
    protected void initToolbar() {
        ((MainActivity) mActivity).setToolbarSpannableTitle(
                mActivity.getString(R.string.titles_array_item_04),
                R.color.colorDark
        );
    }

    @Override
    protected void setContent ( ) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        if (mInstitutes == null || mInstitutes.isEmpty()) {
            mInstitutes = getDefaultStructureInstitutesList();
        }

        mRecyclerView.setAdapter(new StructureInstitutesRecyclerAdapter(mInstitutes, mListener));
    }

    private ArrayList<Institute> getDefaultStructureInstitutesList() {
        ArrayList<StudyProgram> studyPrograms = getDefaultStudyProgramsList();
        ArrayList<Institute> institutes = new ArrayList<>();
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_01),
                studyPrograms,
                null,
                null,
                R.drawable.ih_pattern,
                R.color.colorIhPrimary,
                R.color.colorIhLight,
                "https://hum.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_02),
                studyPrograms,
                null,
                null,
                R.drawable.icst_pattern,
                R.color.colorIcstPrimary,
                R.color.colorIcstLight,
                "https://icst.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_03),
                studyPrograms,
                null,
                null,
                R.drawable.iamm_pattern,
                R.color.colorIammPrimary,
                R.color.colorIammLight,
                "https://iamm.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_04),
                studyPrograms,
                null,
                null,
                R.drawable.iets_pattern,
                R.color.colorIetsPrimary,
                R.color.colorIetsLight,
                "https://ice.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_05),
                studyPrograms,
                null,
                null,
                R.drawable.ice_pattern,
                R.color.colorIcePrimary,
                R.color.colorIceLight,
                "https://immit.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_06),
                studyPrograms,
                null,
                null,
                R.drawable.immet_pattern,
                R.color.colorImmetPrimary,
                R.color.colorImmetLight,
                "https://iamm.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_07),
                studyPrograms,
                null,
                null,
                R.drawable.ipnt_pattern,
                R.color.colorIpntPrimary,
                R.color.colorIpntLight,
                "https://ice.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_08),
                studyPrograms,
                null,
                null,
                R.drawable.iiem_pattern,
                R.color.colorIiemPrimary,
                R.color.colorIiemLight,
                "https://immit.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_09),
                studyPrograms,
                null,
                null,
                R.drawable.icst_pattern,
                R.color.colorIcstPrimary,
                R.color.colorIcstLight,
                "https://iamm.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_10),
                studyPrograms,
                null,
                null,
                R.drawable.iamt_pattern,
                R.color.colorIamtPrimary,
                R.color.colorIamtLight,
                "https://ice.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_11),
                studyPrograms,
                null,
                null,
                R.drawable.ipest_pattern,
                R.color.colorIpestPrimary,
                R.color.colorIpestLight,
                "https://immit.spbstu.ru/"
        ));

        return institutes;
    }

    private ArrayList<StudyProgram> getDefaultStudyProgramsList() {
        return new ArrayList<StudyProgram>() {{
            add(new StudyProgram(
                    "01.03.02",
                    "MATHEMATICS AND MECHANICS",
                    "Mathematical Modeling",
                    184800, 201600));
            add(new StudyProgram(
                    "01.03.02",
                    "MATHEMATICS AND MECHANICS",
                    "Software Engineering",
                    184800, 201600));
            add(new StudyProgram(
                    "01.03.02",
                    "MATHEMATICS AND MECHANICS",
                    "Mathematics and Informatics in Economics",
                    184800, 201600));
            add(new StudyProgram(
                    "01.03.02",
                    "MATHEMATICS AND MECHANICS",
                    "Bioinformatics",
                    184800, 201600));
        }};
    }

    @Override
    public void onDetach ( ) {
        super.onDetach( );
        mListener = null;
    }

    public interface OnStructureInstituteInteractionListener {
        void onStructureInstituteSelected(Institute institute);
    }
}