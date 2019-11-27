package entity.plane;

import type.ClassificationLevelType;
import type.ExperimentalType;

public class ExperimentalPlane extends Plane {

    private ExperimentalType experimentalType;
    private ClassificationLevelType classificationLevelType;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalType experimentalType, ClassificationLevelType classificationLevelType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevelType = classificationLevelType;
    }

    public void setClassificationLevelType(ClassificationLevelType classificationLevelType) {
        this.classificationLevelType = classificationLevelType;
    }

    public ClassificationLevelType getClassificationLevelType(){
        return classificationLevelType;
    }

    public void setExperimentalType(ExperimentalType experimentalType) {
        this.experimentalType = experimentalType;
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" + "model='" + model + '\'' + '}';
    }
}