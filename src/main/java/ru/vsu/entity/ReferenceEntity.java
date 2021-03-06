package ru.vsu.entity;

import java.util.Objects;

/**
 * Класс-сущность отвечающий за таблицу Reference(связи)
 * Содержит три поля.
 * Поле reference ссылается на первый объект
 * Поле objectId ссылается на второй объект
 * Поле attrId ссылается на атрибут характерный 1 объекту и указывающий его связь с объектом 2
 * Пример:  Объект person - reference
 * Объект car - objectId
 * Атрибут driver - attrId
 * Таким образом, person является driver для машины car.
 * Из таблицы можно вытащить для какой машины person является driver
 * Можно вытащить кто driver для данной car
 */
public class ReferenceEntity {
    long reference;
    long objectId;
    long attrId;

    public ReferenceEntity(long reference, long objId, long attrId) {
        this.reference = reference;
        this.objectId = objId;
        this.attrId = attrId;
    }

    public long getReference() {
        return reference;
    }

    public void setReference(long reference) {
        this.reference = reference;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public long getAttrId() {
        return attrId;
    }

    public void setAttrId(long attrId) {
        this.attrId = attrId;
    }

    @Override
    public String toString() {
        return ReferenceEntity.class.getSimpleName() +
                " reference=" + reference +
                ", objectId=" + objectId +
                ", attrId=" + attrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReferenceEntity that = (ReferenceEntity) o;
        return Objects.equals(getReference(), that.getReference()) &&
                Objects.equals(getObjectId(), that.getObjectId()) &&
                Objects.equals(getAttrId(), that.getAttrId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getReference(), getObjectId(), getAttrId());
    }
}
