package mvc.domain;

import mvc.dto.CarDto;

import javax.persistence.*;

/**
 * Created by Владимир on 05.07.2017.
 */
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String concernName;

    @Column
    private String model;
    @Column
    private String color;
    @Column
    private Integer power;
    //Это госномер, он полюбому является уникальным
    @Column(unique = true)
    private String carNumber;

    /*
    Это статический класс билдер, который трансформировать DTO в ENTITY
    */

    static class Builder {

        Car car = new Car();

        public Builder setConcernName(CarDto carDto){
            car.setConcernName(carDto.getConcernName());
            return this;
        }
        public Builder setModel(CarDto carDto){
            car.setModel(carDto.getModel());
            return this;
        }

        public Builder setColor(CarDto carDto){
            car.setColor(carDto.getColor());
            return this;
        }
        public Builder setPower(CarDto carDto){
            car.setPower(carDto.getPower());
            return this;
        }
        public Builder setCarNumber(CarDto carDto){
            car.setCarNumber(carDto.getCarNumber());
            return this;
        }
        public Car build(){
            return car;
        }

    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", concernName='" + concernName + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", power=" + power +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcernName() {
        return concernName;
    }

    public void setConcernName(String concernName) {
        this.concernName = concernName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }


}
