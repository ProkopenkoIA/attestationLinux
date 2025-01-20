package animals.model.implement;

import animals.model.AbstractPackAnimal;
import animals.model.AnimalType;

import java.time.LocalDate;

public class Donkey extends AbstractPackAnimal {
    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.DONKEY);
    }
}
