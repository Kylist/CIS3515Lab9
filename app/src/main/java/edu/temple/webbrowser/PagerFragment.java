package edu.temple.webbrowser;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class PagerFragment extends Fragment {



    private PageAdapter mAdapter;

    private ViewPager mPager;

    private View v;

    public PagerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static PagerFragment newInstance() {
        PagerFragment fragment = new PagerFragment();
        return fragment;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    interface getListInterface{
        ArrayList<PageViewerFragment> getList();
    }

    @Override
    public void onResume() {
        super.onResume();
        notifyChange();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_pager, container, false);

        setRetainInstance(true);

        mPager = v.findViewById(R.id.pager);
        mAdapter = new PageAdapter(getFragmentManager(), ((PagerFragment.getListInterface) getActivity()).getList());

        mPager.setAdapter(mAdapter);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ((PageControlFragment.setURLInterface) getActivity()).setURL();
            }

            @Override
            public void onPageSelected(int position) {
                ((PageControlFragment.setURLInterface) getActivity()).setURL();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                ((PageControlFragment.setURLInterface) getActivity()).setURL();
            }


        });

        return v;
    }

    public void notifyChange(){
        mAdapter.notifyDataSetChanged();
    }

    public int getCurrent(){
        return mPager.getCurrentItem();
    }


    public void goToPage(int num){
        mPager.setCurrentItem(num);
    }


}