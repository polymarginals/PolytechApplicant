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

        initViews();
        initToolbar();
        setContent();

        return mView;
    }

    private void initToolbar ( ) {
        ((MainActivity) mActivity).setToolbarTitle(R.string.title_structure);
    }

    private void initViews ( ) {
        mRecyclerView = mView.findViewById(R.id.institutes_recycler);
    }

    private void setContent ( ) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        ArrayList<Institute> institutes = new ArrayList<>();
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_01),
                new ArrayList< StudyProgram >() {{
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
                }},
                null,
                null,
                R.color.colorPrimary,
                "https://hum.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_02),
                new ArrayList< StudyProgram >() {{
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
                }},
                null,
                null,
                R.color.colorPrimaryDark,
                "https://icst.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_03),
                new ArrayList< StudyProgram >() {{
                    add(new StudyProgram(
                            "01.03.02",
                            "MATHEMATICS AND MECHANICS",
                            "Mathematical Modeling",
                            184800, 201600));
                }},
                null,
                null,
                R.color.colorBlack,
                "https://iamm.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_04),
                new ArrayList< StudyProgram >() {{
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
                    add(new StudyProgram(
                            "01.03.02",
                            "MATHEMATICS AND MECHANICS",
                            "Mathematical Modeling",
                            184800, 201600));
                }},
                null,
                null,
                R.color.colorDarkGrey,
                "https://ice.spbstu.ru/"
        ));
        institutes.add(new Institute(
                mActivity.getString(R.string.institutes_array_item_05),
                new ArrayList< StudyProgram >() {{
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
                }},
                null,
                null,
                R.color.colorPrimary,
                "https://immit.spbstu.ru/"
        ));

        mRecyclerView.setAdapter(new StructureInstitutesRecyclerAdapter(institutes, mListener));
    }

    @Override
    public void onDetach ( ) {
        super.onDetach( );
        mListener = null;
    }

    public interface OnStructureInstituteInteractionListener {
        void onListFragmentInteraction (Institute institute);
    }
}