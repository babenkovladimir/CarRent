package mvc.repository.impl;

import mvc.domain.Car;
import mvc.dto.CarDto;
import mvc.exceptions.SaveCarToDbException;
import mvc.repository.CarDao;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/*
   Created by Владимир on 05.07.2017.
   Итак, для разнообразия использования технологий, сохронять автомобиль в базу данных будем при помощи
   DAO класса, который строиться на EntityManager

   На уровне DAO может возникнуть ошибка, которую необходимо пробросить вверх и перехватить. Потому
   оборачиваем процесс сохранения сущьности в блок try - catch. и генерируюем сообщение об ошибке.
   Вариантов ошибки может быть 2.
   1 - ошибка сохранения в базу данных
   2 - такой автомобиль уже существует.(Уникальность автомобиля будем определять по державнму номеру)
 */
@Repository
public class CarDaoImpl implements CarDao {

    @PersistenceContext
    //Аннотация для подключения
    private EntityManager em;

    @Resource
    private MessageSource messageSource;


    @Override
    @Transactional
    // @Modifying /* Если удаляем, тогда эта аннотация нужна */
    public void saveCarToDB(Car car) {

        //TODO пробросить ексепшен!


        System.out.println("inCarDaoImpl");

        try {
            em.persist(car);
            // Сохранить и завершить транзакцию, так как мы взяли на себя управление транзакцией и используем EntityManager
            em.flush();
        } catch (PersistenceException ex) {
            if(ex.getCause() instanceof ConstraintViolationException){
                throw new SaveCarToDbException(messageSource.getMessage("car.exist", null, LocaleContextHolder.getLocale()));
            } else {
                throw new SaveCarToDbException(messageSource.getMessage("db.error", null, LocaleContextHolder.getLocale()));
            }

        }
    }
}
