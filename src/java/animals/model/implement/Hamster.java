package animals.model.implement;

import animals.model.AbstractPet;
import animals.model.AnimalType;

import java.time.LocalDate;

public class Hamster extends AbstractPet {
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.HAMSTER);
    }
}
