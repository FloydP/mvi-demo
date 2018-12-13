package com.mvi.jeanyan.componentservice.home;

import android.support.v4.app.Fragment;

public interface HomeService<T extends Fragment> {
    T getHomeFragmen();
}
