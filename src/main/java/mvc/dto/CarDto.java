package mvc.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Владимир on 29.06.2017.
 */

/*
* Теперь именно в этом классе проведём некую валидацию Данных
* Валидация достатточно простая - поле должно быть не равно 0 и
* Остальные ж поля
* */
public class CarDto {

    @NotNull(message="{message.concern.name.error}")
    @Pattern(regexp = "\\w{2,}",message = "{message.concern.name.error_}")//Означает все символы
    private String concernName;

    @NotNull(message="{message.model.name.error}")
    @Size(min = 2, message = "{message.model.name.error_")
    private String model;


    @NotNull
   // @Pattern(regexp = "\\w{2,}",message = "{message.name.err}")
    private String color;


    //TODO как провалидировать Integer
    @NotNull
   // @Pattern(regexp = "\\d{2,}",message = "{message.power.name.error_}")
    private Integer power;
    @Size(min = 5, message = "{message.carnumber.name.error")
    private String carNumber;



    public CarDto() {
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

    @Override
    public String toString() {
        return "CarDto{" +
                "concernName='" + concernName + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", power=" + power +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}
