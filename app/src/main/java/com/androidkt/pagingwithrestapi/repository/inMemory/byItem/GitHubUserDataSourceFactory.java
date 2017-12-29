package com.androidkt.pagingwithrestapi.repository.inMemory.byItem;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import java.util.concurrent.Executor;

/**
 * Created by brijesh on 25/12/17.
 */

public class GitHubUserDataSourceFactory implements DataSource.Factory {

    MutableLiveData<ItemKeyedUserDataSource> mutableLiveData;
    ItemKeyedUserDataSource itemKeyedUserDataSource;
    Executor executor;

    public GitHubUserDataSourceFactory(Executor executor) {
        this.mutableLiveData = new MutableLiveData<ItemKeyedUserDataSource>();
        this.executor = executor;
    }


    @Override
    public DataSource create() {
        itemKeyedUserDataSource = new ItemKeyedUserDataSource(executor);
        mutableLiveData.postValue(itemKeyedUserDataSource);
        return itemKeyedUserDataSource;
    }

    public MutableLiveData<ItemKeyedUserDataSource> getMutableLiveData() {
        return mutableLiveData;
    }

}
