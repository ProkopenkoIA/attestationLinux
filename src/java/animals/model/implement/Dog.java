package animals.model.implement;

import animals.model.AbstractPet;
import animals.model.AnimalType;

import java.time.LocalDate;

public class Dog extends AbstractPet {
    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.DOG);
    }
}
