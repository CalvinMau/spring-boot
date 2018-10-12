package com.auth.common.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The type Json untils customize.
 *
 * @ClassName JsonUntilsCustomize
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
public class JsonUntilsCustomize {

    /**
     * Get gson gson.
     *
     * @return the gson
     */
    public Gson getGson(){

        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .enableComplexMapKeySerialization()
                .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
                .setPrettyPrinting()
                .setVersion(1.0).create();
    }
}
