package ru.nsd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.nsd.converternumeral.Converter;

@Controller
@RequestMapping("/numeral")
public class ConverterNumeralController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printHello(@RequestParam(value="number", required=false)  String number,
                             @RequestParam(value="a",required=false) String a, @RequestParam(value="b",required=false) String b) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String result;
        modelAndView.setViewName("converterNumeralPage");
        if(a != null && b != null && number != null) {
            int a_ = Integer.parseInt(a);
            int b_ = Integer.parseInt(b);
            int number_ = Integer.parseInt(number);
            result = Converter.countResult(number, a_, b_);
            modelAndView.getModel().put("a", a_);
            modelAndView.getModel().put("b", b_);
            modelAndView.getModel().put("number", number);
            modelAndView.getModel().put("result", result);
        }
        int f = 4;
        return modelAndView;
    }
}