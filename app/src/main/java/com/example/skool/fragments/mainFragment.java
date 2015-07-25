package com.example.skool.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skool.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;

public class mainFragment extends Fragment {
    @Bind(R.id.chart)
    PieChartView pieChartView;

    private static final String ARG_POSITION = "position";

    private int position;
    private Context context;
    private boolean hasLabels = true;
    private boolean hasLabelForSelected = true;
    private boolean hasLabelsOutside = true;
    private boolean hasCenterCircle = true;

    public static mainFragment newInstance(int position) {
        mainFragment f = new mainFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        position = getArguments().getInt(ARG_POSITION);

        View rootView = null;
        switch(position){
            case 0:
                rootView = inflater.inflate(R.layout.weekfragment, container, false);
                ButterKnife.bind(this, rootView);
                generateData(pieChartView,"Attendance", "Week 1 July");
                /*List<PointValue> values = new ArrayList<PointValue>();
                values.add(new PointValue(0, 2));
                values.add(new PointValue(1, 4));
                values.add(new PointValue(2, 3));
                values.add(new PointValue(3, 4));

                //In most cased you can call data model methods in builder-pattern-like manner.
                Line line = new Line(values).setColor(Color.BLUE).setCubic(true);
                List<Line> lines = new ArrayList<Line>();
                lines.add(line);

                LineChartData data = new LineChartData();
                data.setLines(lines);

                //LineChartView chart = new LineChartView(this.context);
                lineChartView.setLineChartData(data);*/
                break;
            case 1:
                rootView = inflater.inflate(R.layout.monthfragment, container, false);
                ButterKnife.bind(this, rootView);
                generateData(pieChartView,"Attendance", "July 2015");
                break;
            case 2:
                rootView = inflater.inflate(R.layout.yearfragment, container, false);
                ButterKnife.bind(this, rootView);
                generateData(pieChartView,"Attendance", "2015");
                break;
        }

        /*ProgressBarCircular progressBarCircular = (ProgressBarCircular) rootView.findViewById(R.id.progress);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabButton);
        fab.setDrawableIcon(getResources().getDrawable(R.drawable.plus));
        switch (position) {
            case 0:
                fab.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                progressBarCircular.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                break;
            case 1:
                fab.setBackgroundColor(getResources().getColor(R.color.red));
                progressBarCircular.setBackgroundColor(getResources().getColor(R.color.red));

                break;
            case 2:
                progressBarCircular.setBackgroundColor(getResources().getColor(R.color.blue));
                fab.setBackgroundColor(getResources().getColor(R.color.blue));

                break;
            case 3:
                fab.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
                progressBarCircular.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));

                break;
        }*/

        return rootView;
    }

    private void generateData(PieChartView chart, String center_data_1, String center_data_2) {
        int numValues = 2;

        List<SliceValue> values = new ArrayList<SliceValue>();
        for (int i = 0; i < numValues; ++i) {
            SliceValue sliceValue = new SliceValue((float) Math.random() * 30 + 15, ChartUtils.pickColor());
            values.add(sliceValue);
        }

        PieChartData data = new PieChartData(values);
        data.setHasLabels(hasLabels);
        data.setHasLabelsOnlyForSelected(hasLabelForSelected);
        data.setHasLabelsOutside(hasLabelsOutside);
        data.setHasCenterCircle(hasCenterCircle);

        data.setCenterText1(center_data_1);

        // Get roboto-italic font.
        //Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Italic.ttf");
        //data.setCenterText1Typeface(tf);

        // Get font size from dimens.xml and convert it to sp(library uses sp values).
        data.setCenterText1FontSize(ChartUtils.px2sp(getResources().getDisplayMetrics().scaledDensity,
                (int) getResources().getDimension(R.dimen.pie_chart_text1_size)));

        data.setSlicesSpacing(24);

        data.setCenterText2(center_data_2);

        //Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Italic.ttf");

        //data.setCenterText2Typeface(tf);
        data.setCenterText2FontSize(ChartUtils.px2sp(getResources().getDisplayMetrics().scaledDensity,
                (int) getResources().getDimension(R.dimen.pie_chart_text1_size)));

        chart.setPieChartData(data);
    }
}