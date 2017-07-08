package mvc.controller;

import mvc.domain.Car;
import mvc.dto.ResponceDto;

import mvc.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import java.util.List;

/**
 * Created by Владимир on 07.07.2017.
 */



@RestController
public class AddCarRestController {

  private CarRepository carRepository;


    @Autowired
    public AddCarRestController(CarRepository carRepository){
        this.carRepository=carRepository;
    }

    @RequestMapping(value = "/editcardb3/getCarListAjax", method = RequestMethod.GET)

    public ResponseEntity<ResponceDto> getListOfCars(HttpSession session){//Можем использовать сессию. Для авторизации , но не в этот раз)
        System.out.println("In getCarListAjax");
        List<Car> cars;
        cars = carRepository.getCarByCarNumber("dfbd");

        for (Car car:cars) {
            System.out.println(car);

        }


        ResponceDto responceDto = new ResponceDto();



        return new ResponseEntity<ResponceDto>(responceDto, HttpStatus.OK);

    }



}
