package com.example.zjy.apputils.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：
 * 作者：zjy on 2017/11/30 17:46
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder> {
    public List<T> mData = new ArrayList<>();

    public BaseRecyclerViewAdapter(List<T> datas) {
        this.mData = datas;
    }

    public static final int ITEM_TYPE_NORMAL = 1000;
    public static final int ITEM_TYPE_HEADER = 2000;
    public static final int ITEM_TYPE_FOOTER = 3000;
    private View mHeaderView;
    private View mFooterView;
    public boolean isHasHeader;
    public boolean isHasFooter;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            return new BaseViewHolder(mHeaderView);
        }
        if (viewType == ITEM_TYPE_FOOTER) {
            return new BaseViewHolder(mFooterView);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        BaseViewHolder baseViewHolder = new BaseViewHolder(view);
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewAdapter.BaseViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == ITEM_TYPE_FOOTER || type == ITEM_TYPE_HEADER) {
            return;
        } else {
            if (isHasHeader) {
                position = position - 1;
            }
            bindData(holder, position);
        }

    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        int size = mData.size();
        if (isHasHeader) {
            size++;
        }
        if (isHasFooter) {
            size++;
        }
        return size;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHasHeader && position == 0) {
            return ITEM_TYPE_HEADER;
        }
        if (isHasHeader && isHasFooter && position == mData.size() + 1) {
            return ITEM_TYPE_FOOTER;
        } else if (!isHasHeader && isHasFooter && position == mData.size()) {
            return ITEM_TYPE_FOOTER;
        }
        return ITEM_TYPE_NORMAL;
    }

    /**
     * 设置头部view
     * @param headerView
     */
    public void setHeaderView(View headerView) {
        this.mHeaderView = headerView;
        isHasHeader = true;
        notifyDataSetChanged();
    }

    public void removeHeaderView() {
        if (isHasHeader) {
            isHasHeader = false;
            this.mHeaderView = null;
            notifyDataSetChanged();
        }
    }

    public void setFooterView(View footerView) {
        this.mFooterView = footerView;
        isHasFooter = true;
        notifyDataSetChanged();
    }

    public void removeFooterView() {
        if (isHasFooter) {
            isHasFooter = false;
            this.mFooterView = null;
            notifyDataSetChanged();
        }
    }


    public void refreshData(List<T> datas) {
        mData.clear();
        mData.addAll(datas);
        notifyDataSetChanged();
    }

    public void removeData(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    public void addData(List<T> datas) {
        mData.addAll(datas);
        notifyDataSetChanged();
    }

    protected abstract void bindData(BaseViewHolder viewHolder, int position);

    protected abstract int getLayoutId();


    class BaseViewHolder extends RecyclerView.ViewHolder {
        private Map<Integer, View> mViewMap;

        public BaseViewHolder(View itemView) {
            super(itemView);
            mViewMap = new HashMap<>();
        }

        public View getView(int id) {
            View view = mViewMap.get(id);
            if (view == null) {
                view = itemView.findViewById(id);
                mViewMap.put(id, view);
            }
            return view;
        }
    }
}
