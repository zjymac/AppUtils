package com.example.zjy.apputils.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.zjy.apputils.R;
import com.example.zjy.apputils.bean.AppMsgBean;

import java.util.List;


/**
 * 描述：
 * 作者：zjy on 2017/12/2 15:01
 */

public class ShowAppMsgAdapter extends BaseRecyclerViewAdapter<AppMsgBean> {

    public ShowAppMsgAdapter(List<AppMsgBean> datas) {
        super(datas);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    protected void bindData(BaseViewHolder viewHolder, int position) {
        ((ImageView) viewHolder.getView(R.id.app_iv)).setBackground(mData.get(position).getAppImage());
        ((TextView) viewHolder.getView(R.id.tv1)).setText(mData.get(position).getAppName() + "");
        ((TextView) viewHolder.getView(R.id.tv3)).setText(mData.get(position).getVersionName() + "");
        ((TextView) viewHolder.getView(R.id.tv4)).setText(mData.get(position).getPackageName() + "");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.show_app_msg_item;
    }
}
