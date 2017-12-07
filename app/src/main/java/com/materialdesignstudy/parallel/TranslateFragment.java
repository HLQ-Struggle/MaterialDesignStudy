package com.materialdesignstudy.parallel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author : HLQ
 * e-mail : 925954424@qq.com
 * time   : 2017/12/06
 * desc   : Fragment切换时 记录当前layoutID以及当前页Index
 * version: 1.0
 */
public class TranslateFragment extends Fragment {

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int layoutId = bundle.getInt("layoutId");
        int pageIndex = bundle.getInt("pageIndex");
        View view = inflater.inflate(layoutId, null);
        view.setTag(pageIndex);
        return view;
    }

}
