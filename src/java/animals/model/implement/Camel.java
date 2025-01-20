package animals.model.implement;

import animals.model.AbstractPackAnimal;
import animals.model.AnimalType;

import java.time.LocalDate;

public class Camel extends AbstractPackAnimal {
    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.CAMEL);
    }
}
