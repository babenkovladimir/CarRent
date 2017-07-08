package mvc.dto;

import java.util.List;

/**
 * Created by Владимир on 07.07.2017.
 */
public class ResponceDto {

    private List<CarDto> cars;

    public List<CarDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }
}
