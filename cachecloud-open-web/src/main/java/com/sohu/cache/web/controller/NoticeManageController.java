package com.sohu.cache.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sohu.cache.util.ConstUtils;
import com.sohu.cache.web.enums.SuccessEnum;

@Controller
@RequestMapping("manage/notice")
public class NoticeManageController extends BaseController {

    /**
     * 初始化系统通知
     * 
     * @return
     */
    @RequestMapping(value = "/initNotice")
    public ModelAndView init(HttpServletRequest request,
            HttpServletResponse response, Model model) {

        String notice = "";
        model.addAttribute("notice", notice);
        model.addAttribute("success", request.getParameter("success"));
        model.addAttribute("noticeActive", SuccessEnum.SUCCESS.value());
        return new ModelAndView("manage/notice/initNotice");
    }

    /**
     * 添加系统通知
     * 
     * @param notice 前端传过来的通知文本
     * @return
     */
    @RequestMapping(value = "/add")
    public ModelAndView addNotice(HttpServletRequest request,
            HttpServletResponse response, Model model) {
        String notice = request.getParameter("notice");
        SuccessEnum success = SuccessEnum.FAIL;
        if (StringUtils.isNotBlank(notice)) {
            String setResult = "";
            if ("ok".equalsIgnoreCase(setResult)) {
                success = SuccessEnum.SUCCESS;
            }
        }
        model.addAttribute("success", success.value());
        return new ModelAndView("");
    }

    /**
     * 获取系统通知
     * 
     * @return
     */
    @RequestMapping(value = "/get")
    public ModelAndView getNotice(HttpServletRequest request,
            HttpServletResponse response, Model model) {
        String notice = "";
        List<String> list = null;
        if (StringUtils.isNotBlank(notice)) {
            list = Arrays.asList(notice.split(ConstUtils.NEXT_LINE));
            model.addAttribute("status", SuccessEnum.SUCCESS.value());
        } else {
            list = new ArrayList<String>();
            model.addAttribute("status", SuccessEnum.FAIL.value());
        }
        model.addAttribute("data", list);
        return new ModelAndView("");
    }

}
