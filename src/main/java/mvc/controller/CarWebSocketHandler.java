package mvc.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import mvc.domain.Car;
import mvc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.lang.reflect.Type; //Это класс, который определяет тип Jsona
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Владимир on 02.07.2017.
 */

/*
Client to server

{"HellowMessage":"HellowWorld"}







*/
@Controller//НАдо ли сдесь аннотация контроллер?

public class CarWebSocketHandler extends TextWebSocketHandler {



    private CarService carService;

    @Autowired
    public void setCarService(CarService carService){
        this.carService=carService;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Пришло сообщение с вэбсокета!!! Car Rent ");
        String jsonMessage=null;

        /*
        * Ниже приведён стандартный метод парсинга jsona
        * */

        jsonMessage=message.getPayload();//Преобразовали сообщение в строку
        System.out.println(jsonMessage);
        Gson gson=new Gson();//Используем Гугловский Оыщт
        Type gsonType=new TypeToken<HashMap<String,String>>(){}.getType();//Это тип Jsona

        //формуємо map з json
        Map<String, String> gsonContentMap = gson.fromJson(jsonMessage, gsonType);

        //----------------------------------------------------------------------------
        if(Objects.nonNull(gsonContentMap.get("message"))){
            System.out.println("Сообщение с фронта - "+ gsonContentMap.get("message"));
        }

        /*
        * Проверяем пришедший JSON на атрибут target. Если таковой атрибут присутствует и его значение равняется
        *  getlistOfcars, тогда необходимо сформировать и вернуть на сервет список автомобилей
        *
        * */

        if(Objects.nonNull(gsonContentMap.get("target"))&& gsonContentMap.get("target").equals("getlistOfcars")){
            session.sendMessage(new TextMessage("{\"auth\":\"yes\"}"));
        }

        /*
        * Проверка на условие, в котором целью является сохранение машинки в базу данных. Соотеветсяенно, для этого
        * необходимо заавтоварить сервис по сохранению машинок в базу данных
        * Для начала необходимо распарсить сообщение!
        *
        * */
        if(Objects.nonNull(gsonContentMap.get("target"))&& gsonContentMap.get("target").equals("savecartodb")){
            System.out.println("inWebSocketHandler");
            Car car = new Car();
            System.out.println(car+"   service - "+ carService.toString());
            car.setConcernName(gsonContentMap.get("concernName"));
            car.setModel(gsonContentMap.get("model"));
            car.setColor(gsonContentMap.get("color"));
            car.setPower(Integer.parseInt(gsonContentMap.get("power")));
            car.setCarNumber(gsonContentMap.get("carNumber"));

            System.out.println(car+"   service - "+ carService.toString());


            try {
                carService.saveCarToDB(car);
            } catch (Exception e){
                e.printStackTrace();
            }



            session.sendMessage(new TextMessage("{\"auth\":\"yes\"}"));
        }






    }
}
