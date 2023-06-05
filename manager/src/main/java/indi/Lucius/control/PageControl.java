package indi.Lucius.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: PageControl
 * @Description: 页面跳转
 * @Author: Lucius Pan
 * @Date: 2023/5/31 14:12
 */

@RestController
public class PageControl {
    //首页配置
    @GetMapping("/")
    public ModelAndView toIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/toManager")
    public ModelAndView toManager(String page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(page);
        return modelAndView;
    }


}
