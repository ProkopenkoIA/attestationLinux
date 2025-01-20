package animals.model.implement;

import animals.model.AbstractPet;
import animals.model.AnimalType;

import java.time.LocalDate;

public class Cat extends AbstractPet {
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.CAT);
    }
}
