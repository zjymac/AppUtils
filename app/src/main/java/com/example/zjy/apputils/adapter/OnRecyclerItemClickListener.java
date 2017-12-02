package com.example.zjy.apputils.adapter;

import android.view.View;

/**
 * 描述：
 * 作者：zjy on 2017/11/30 15:12
 */

public interface OnRecyclerItemClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
