package mvc.controller;

import mvc.dto.CarDto;

import org.springframework.context.annotation.PropertySource;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;


/**
 * Created by Владимир on 28.06.2017.
 */
@Controller
@PropertySource(value = "classpath:websocket.properties")
public class AddCarController {

    @Resource
    private Environment env;


    @RequestMapping(value = "/editcardb", method = RequestMethod.GET, name = "editingCarDB")
    public ModelAndView getCarEditPage(Model model) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("car", new CarDto());
        mav.setViewName("editcardb");
        return mav;
    }

    @RequestMapping(value = "/editcardb2", method = RequestMethod.GET, name = "editingCarDB2")
    public ModelAndView getCarEditPageMyEdit(Model model) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("car", new CarDto());
        mav.setViewName("editcardb2");
        return mav;
    }


    //Мы должны передать модель, а именно сами данные для обработки
    @RequestMapping(value = "/saveCar", method = RequestMethod.GET, name = "editingCarDB2_")
    public String saveCar(Model model) {
        if (!model.containsAttribute("car")) {
            model.addAttribute("car", new CarDto());//можно добавить коллекцию атрибутов
        }

        return "saveCar";
    }
    //----------------------Post methods----------------------------------//

    @RequestMapping(value = "/editcardb", method = RequestMethod.POST)
    public String getCarEditPage_Postresponce(@Validated @ModelAttribute("car") CarDto carDto,
                                              BindingResult result,//Если нету валидации, то биндинг резултс не работают
                                              RedirectAttributes attributes) {

        if (result.hasErrors()) {
            //TODO задать вопрос про отсылку этих параметров
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.car", result);
            attributes.addFlashAttribute("error", "some error ocured");
            attributes.addFlashAttribute("car", carDto);
            return "editcardb";//Если направить на страничку, сохраняются редирект атрибютес!!!
            //return "redirect:/editcardb";//Если не использовать редирект

        }
        //TODO добать сервис сохранения автомобиля в базу данных

        System.out.println(carDto.toString());

        return "redirect:/editcardb";
    }

    @RequestMapping(value = "/editcardb2", method = RequestMethod.POST)
    public String getCarEditPageMod2_Postresponce(@Validated @ModelAttribute("car") CarDto carDto,
                                              BindingResult result,//Если нету валидации, то биндинг резултс не работают
                                              RedirectAttributes attributes) {
        if (result.hasErrors()) {
            //TODO задать вопрос про отсылку этих параметров
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.car", result);
            attributes.addFlashAttribute("error", "some error ocured");
            attributes.addFlashAttribute("car", carDto);
            return "editcardb2";//Если направить на страничку, сохраняются редирект атрибютес!!!
            //return "redirect:/editcardb";//Если не использовать редирект
        }
        //TODO добать сервис сохранения автомобиля в базу данных

        System.out.println(carDto.toString());

        return "redirect:/editcardb2";
    }

    @RequestMapping(value = "/editcardb3", method = RequestMethod.GET, name = "editingcerdbwebsockets")
    public ModelAndView addCarToDB_WebSocketsProtokol() {

        ModelAndView mav = new ModelAndView();
        mav.addObject("socketAddres", env.getProperty("carSocket.url"));
        mav.setViewName("editcardb3");
        System.out.println("сработал контроллер перевода на страничку с сокетами");
        return mav;
    }


}
