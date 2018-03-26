package ru.vsu.services.serviceImpl;

import org.springframework.stereotype.Service;
import ru.vsu.entity.DriverEntity;
import ru.vsu.entity.ObjectEntity;
import ru.vsu.services.AbstractEntityService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService extends AbstractEntityService<DriverEntity> {
    //айди атрибута driver из order, который показывает какой водитель на заказе(в условиях нашей бд это атрибут с id = 18)
    private static final int ON_ORDER_ATTRIBUTE = 18;

    public DriverService(ObjectService<ObjectEntity> objectService, ParamsService paramsService, ReferenceService referenceService) {
        super(objectService, paramsService, referenceService);
    }

    public List<DriverEntity> getAllAvailableDrivers() {
        List<DriverEntity> listOfAvailableDrivers = new ArrayList<>();

        for (DriverEntity driverEntity : getAll()) {
            if (!referenceService.isReferenceExistByRefIdAndAttrId(driverEntity.getId(), ON_ORDER_ATTRIBUTE)) {
                listOfAvailableDrivers.add(driverEntity);
            }
        }
        return listOfAvailableDrivers;
    }
}
