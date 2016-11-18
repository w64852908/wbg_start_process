package com.lanxiang.info.guice;

import com.google.inject.PrivateModule;
import com.lanxiang.info.rest.InfoRestServiceImpl;

/**
 * Created by lanxiang on 2016/11/15.
 */
public class InfoModule extends PrivateModule {

    @Override
    protected void configure() {
        bind(InfoRestServiceImpl.class).asEagerSingleton();
        expose(InfoRestServiceImpl.class);
    }
}
