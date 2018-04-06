package ru.vsu.services.serviceImpl;

import org.springframework.stereotype.Service;
import ru.vsu.entity.CarEntity;
import ru.vsu.entity.ObjectEntity;
import ru.vsu.services.AbstractEntityService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService extends AbstractEntityService<CarEntity> {
    //айди атрибута car из driver, который показывает какая машина закреплена за водителем(в условиях нашей бд это атрибут с id = 16)
    private static final int ASSIGNED_TO_THE_DRIVER_ATTRIBUTE = 16;

    public CarService(ObjectService<ObjectEntity> objectService, ParamsService paramsService, ReferenceService referenceService, AttributeService attributeService) {
        super(objectService, paramsService, referenceService, attributeService);
    }

    public List<CarEntity> getAllAvailableCars() {
        List<CarEntity> listOfAvailableCars = new ArrayList<>();

        for (CarEntity carEntity : getAll()) {
            if (!referenceService.isReferenceExistByRefIdAndAttrId(carEntity.getId(), ASSIGNED_TO_THE_DRIVER_ATTRIBUTE)) {
                listOfAvailableCars.add(carEntity);
            }
        }
        return listOfAvailableCars;
    }
}