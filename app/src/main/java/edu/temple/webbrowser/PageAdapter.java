package edu.temple.webbrowser;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageAdapter extends FragmentStatePagerAdapter {

    ArrayList<PageViewerFragment> PVList;

    public PageAdapter(@NonNull FragmentManager fm, ArrayList<PageViewerFragment> PVList_) {
        super(fm);
        PVList = PVList_;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return PVList.get(position);
    }

    @Override
    public int getCount() {
        return PVList.size();
    }

    /*

        PageViewerFragment[] PVList = new PageViewerFragment[100];

    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);
        PVList[0] = new PageViewerFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if(PVList[position] != null) return PVList[position];
        else {
            PVList[position] = new PageViewerFragment();
            return PVList[position];
        }
    }

    @Override
    public int getCount() {
        return PVList.length;
    }

     */

}
