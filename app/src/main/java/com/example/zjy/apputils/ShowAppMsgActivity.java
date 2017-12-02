package com.example.zjy.apputils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.zjy.apputils.adapter.ShowAppMsgAdapter;
import com.example.zjy.apputils.bean.AppMsgBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShowAppMsgActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private ShowAppMsgAdapter mShowAppMsgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_app_msg);
        ButterKnife.bind(this);

        mShowAppMsgAdapter = new ShowAppMsgAdapter(getAppMsg());
//        LinearLayoutManager lin = new LinearLayoutManager(this);
//        lin.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mShowAppMsgAdapter);
    }

    private List<AppMsgBean> getAppMsg() {
        PackageManager pckMan = getPackageManager();
        List<AppMsgBean> appMsgList = new ArrayList<>();
        List<PackageInfo> packageInfo = pckMan.getInstalledPackages(0);

        for (PackageInfo pInfo : packageInfo) {
            AppMsgBean appMsgBean = new AppMsgBean();
            appMsgBean.setAppImage(pInfo.applicationInfo.loadIcon(pckMan));
            appMsgBean.setAppName(pInfo.applicationInfo.loadLabel(pckMan).toString());
            appMsgBean.setPackageName(pInfo.packageName);
            appMsgBean.setVersionName(pInfo.versionName);
            appMsgBean.setVersionCode(pInfo.versionCode + "");
            appMsgList.add(appMsgBean);
        }
        Log.e("asdas", appMsgList.toString());
        return appMsgList;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }


}
