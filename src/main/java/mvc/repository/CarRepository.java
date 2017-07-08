package mvc.repository;

import mvc.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Владимир on 07.07.2017.
 * В НАшем случае всю работу за нас делает Спринг)
 *
 */

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    //@Query("select all from Car")
    List<Car> getCarByCarNumber(String carnumber);
}
