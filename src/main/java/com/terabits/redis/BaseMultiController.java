package com.terabits.redis;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/15.
 */
public class BaseMultiController {
    protected ModelAndView toView(final String url, final Map<String,Object> map)
    {
        ModelAndView  view = new ModelAndView(url);
        return view;
    }
}