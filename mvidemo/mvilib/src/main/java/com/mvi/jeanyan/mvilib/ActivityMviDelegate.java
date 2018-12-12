package com.mvi.jeanyan.mvilib;

import android.os.Bundle;
import com.mvi.jeanyan.mvilib.base.MviPresenter;
import com.mvi.jeanyan.mvilib.base.MviView;

public interface ActivityMviDelegate<V extends MviView, P extends MviPresenter<V>> {

    /**
     * This method internally creates the presenter and attaches the viewState to it.
     */
    void onCreate(Bundle bundle);

    /**
     * This method internally detaches the viewState from presenter
     */
    void onDestroy();

    /**
     */
    void onPause();

    /**
     */
    void onResume();

    /**
     */
    void onStart();

    /**
     */
    void onStop();

    /**
     */
    void onRestart();

    /**
     */
    void onContentChanged();

    /**
     */
    void onSaveInstanceState(Bundle outState);

    /**
     */
    void onPostCreate(Bundle savedInstanceState);

    /**
     *
     * @return Don't forget to return the value returned by this delegate method
     */
    Object onRetainCustomNonConfigurationInstance();
}

