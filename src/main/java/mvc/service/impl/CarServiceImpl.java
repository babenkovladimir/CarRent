package mvc.service.impl;

import mvc.domain.Car;
import mvc.dto.CarDto;
import mvc.repository.CarDao;
import mvc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Владимир on 05.07.2017.
 */

@Service
public class CarServiceImpl implements CarService {

   private CarDao carDao;

   @Autowired
   public void setCarDao(CarDao carDao){
       this.carDao=carDao;
   }

    @Override
    public List<CarDto> getListOfCars() {
        return null;
    }


    /*
    * Для сохранения объекта в базу данных используем класс DAO
    *
    * */
    @Override
    public void saveCarToDB(Car car) {
        System.out.println("inCarService");


            carDao.saveCarToDB(car);

    }
}
