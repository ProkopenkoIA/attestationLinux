package animals.model.implement;

import animals.model.AbstractPackAnimal;
import animals.model.AnimalType;

import java.time.LocalDate;

public class Horse extends AbstractPackAnimal {
    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.HORSE);
    }
}
