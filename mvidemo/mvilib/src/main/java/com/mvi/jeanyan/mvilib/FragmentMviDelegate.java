package com.mvi.jeanyan.mvilib;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import com.mvi.jeanyan.mvilib.base.MviPresenter;
import com.mvi.jeanyan.mvilib.base.MviView;

public interface FragmentMviDelegate<V extends MviView, P extends MviPresenter<V>> {

    /**
     * Must be called from {@link Fragment#onCreate(Bundle)}
     *
     * @param saved The bundle
     */
    void onCreate(Bundle saved);

    /**
     * Must be called from {@link Fragment#onDestroy()}
     */
    void onDestroy();

    /**
     * Must be called from {@link Fragment#onViewCreated(View, Bundle)}
     *
     * @param view The inflated view
     * @param savedInstanceState the bundle with the viewstate
     */
    void onViewCreated(View view, @Nullable Bundle savedInstanceState);

    /**
     * Must be called from {@link Fragment#onDestroyView()}
     */
    void onDestroyView();

    /**
     * Must be called from {@link Fragment#onPause()}
     */
    void onPause();

    /**
     * Must be called from {@link Fragment#onResume()}
     */
    void onResume();

    /**
     * Must be called from {@link Fragment#onStart()}
     */
    void onStart();

    /**
     * Must be called from {@link Fragment#onStop()}
     */
    void onStop();

    /**
     * Must be called from {@link Fragment#onActivityCreated(Bundle)}
     *
     * @param savedInstanceState The saved bundle
     */
    void onActivityCreated(Bundle savedInstanceState);

    /**
     * Must be called from {@link Fragment#onAttach(Activity)}
     *
     * @param activity The activity the fragment is attached to
     */
    void onAttach(Activity activity);

    /**
     * Must be called from {@link Fragment#onAttach(Context)}
     *
     * @param context The context the fragment is attached to
     */
    void onAttach(Context context);

    /**
     * Must be called from {@link Fragment#onDetach()}
     */
    void onDetach();

    /**
     * Must be called from {@link Fragment#onSaveInstanceState(Bundle)}
     */
    void onSaveInstanceState(Bundle outState);

    /**
     * Must be called from {@link Fragment#onAttachFragment(Fragment)}
     *
     * @param childFragment the new childFragment
     */
    void onAttachFragment(Fragment childFragment);

    /**
     * Must be called from {@link Fragment#onConfigurationChanged(Configuration)}
     *
     * @param newConfig The new config
     */
    void onConfigurationChanged(Configuration newConfig);
}

