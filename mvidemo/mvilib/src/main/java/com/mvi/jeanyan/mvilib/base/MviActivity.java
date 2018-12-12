package com.mvi.jeanyan.mvilib.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.mvi.jeanyan.mvilib.ActivityMviDelegate;
import com.mvi.jeanyan.mvilib.ActivityMviDelegateImpl;
import com.mvi.jeanyan.mvilib.MviDelegateCallback;

public abstract class MviActivity<V extends MviView, P extends MviPresenter<V>>
        extends AppCompatActivity implements MviView, MviDelegateCallback<V, P> {

    private boolean isRestoringViewState = false;
    protected ActivityMviDelegate<V, P> mvpDelegate;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
    }

    @Override protected void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override protected void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override protected void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override protected void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @Override protected void onRestart() {
        super.onRestart();
        getMvpDelegate().onRestart();
    }

    @Override public void onContentChanged() {
        super.onContentChanged();
        getMvpDelegate().onContentChanged();
    }

    @Override protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getMvpDelegate().onPostCreate(savedInstanceState);
    }

    /**
     * Instantiate a presenter instance
     *
     * @return The {@link MviPresenter} for this viewState
     */
    @NonNull public abstract P createPresenter();

    /**
     * Get the mvp delegate. This is internally used for creating presenter, attaching and detaching
     * viewState from presenter.
     *
     * <p><b>Please note that only one instance of mvp delegate should be used per Activity
     * instance</b>.
     * </p>
     *
     * <p>
     * Only override this method if you really know what you are doing.
     * </p>
     *
     * @return {@link ActivityMviDelegate}
     */
    @NonNull
    protected ActivityMviDelegate<V, P> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ActivityMviDelegateImpl<V, P>(this, this);
        }

        return mvpDelegate;
    }

    @NonNull public V getMviView() {
        try {
            return (V) this;
        } catch (ClassCastException e) {
            String msg =
                    "Couldn't cast the View to the corresponding View interface. Most likely you forgot to add \"Activity implements YourMviViewInterface\".";
            Log.e(this.toString(), msg);
            throw new RuntimeException(msg, e);
        }
    }

    @Override public final Object onRetainCustomNonConfigurationInstance() {
        return getMvpDelegate().onRetainCustomNonConfigurationInstance();
    }

    @Override public void setRestoringViewState(boolean restoringViewState) {
        this.isRestoringViewState = restoringViewState;
    }

    protected boolean isRestoringViewState() {
        return isRestoringViewState;
    }
}
