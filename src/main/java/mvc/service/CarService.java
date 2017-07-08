package mvc.service;

import mvc.domain.Car;
import mvc.dto.CarDto;

import java.util.List;

/**
 * Created by Владимир on 05.07.2017.
 */
public interface CarService {

    List<CarDto> getListOfCars();
    void saveCarToDB(Car car);
}
