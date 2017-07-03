package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Владимир on 28.06.2017.
 */

/*
* IndexController направляет нас на стартовую страничку index.jsp
*
* */
@Controller
public class IndexController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hetHomePage(){
        System.out.println("IndexController is working");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView hetHomePage_exitToStartPage(){
        System.out.println("IndexController is working");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        return modelAndView;
    }




}
