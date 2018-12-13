package com.mvi.jeanyan.basicres;

import android.app.Application;

public abstract class BaseApp extends Application {
    public abstract void initModuleApp(Application application);
}
