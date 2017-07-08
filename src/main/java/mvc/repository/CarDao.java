package mvc.repository;

import mvc.domain.Car;
import mvc.dto.CarDto;

/**
 * Created by Владимир on 05.07.2017.
 */
public interface CarDao {

    void saveCarToDB(Car car);
}
