package com.example.examplemod.utils;

import com.example.examplemod.reference.Reference;

/**
 * Created by Henry Welch on 7/28/2014.
 */
public class pathUtils {
    public static String getTexturePath(String blockName)
    {
        return Reference.TEXTURE_PATH + blockName;
    }
}
