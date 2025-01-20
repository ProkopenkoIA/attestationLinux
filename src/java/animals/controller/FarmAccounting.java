package animals.controller;

import animals.model.AbstractAnimal;
import animals.model.AnimalType;
import animals.model.implement.*;
import animals.storage.Storage;

import java.time.LocalDate;
import java.util.List;

/**
 * Отвечает за взаимодействие View и Model
 */
public class FarmAccounting {

    private Storage dbFarm;

    public FarmAccounting(Storage dbKennel) {
        this.dbFarm = dbKennel;
    }

    public List<AbstractAnimal> getAnimals() {
        return dbFarm.getAllAnimals();
    }

    public boolean createAnimal(String name, LocalDate birthDay, AnimalType animalType) {
        AbstractAnimal animal = switch (animalType) {
            case CAT -> new Cat(name, birthDay);
            case DOG -> new Dog(name, birthDay);
            case HAMSTER -> new Hamster(name, birthDay);
            case HORSE -> new Horse(name, birthDay);
            case CAMEL -> new Camel(name, birthDay);
            case DONKEY -> new Donkey(name, birthDay);
        };

        return dbFarm.addAnimal(animal);
    }

    public int removeAnimal(AbstractAnimal animal) {
        if (animal == null) return -1;
        return  dbFarm.removeAnimal(animal);
    }
}
