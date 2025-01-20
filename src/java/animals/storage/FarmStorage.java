package animals.storage;

import animals.model.AbstractAnimal;
import animals.model.AbstractPackAnimal;
import animals.model.AbstractPet;
import animals.model.Command;
import animals.model.implement.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация интерфейса Storage
 */
public class FarmStorage implements Storage{
    Map<Integer, AbstractAnimal> dbAnimals = new HashMap<>();

    public FarmStorage() {
        init();
    }

    private void init(){
        AbstractPet cat = new Cat("Том", LocalDate.of(2023, 7, 1));

        int per = cat.getAge();

        dbAnimals.put(cat.getId(), cat);

        AbstractPet dog = new Dog("Шарик", LocalDate.of(2023, 1, 24));
        dog.learnCommand(new Command("Принести тапки"));
        dog.learnCommand(new Command("Сидеть!"));
        dbAnimals.put(dog.getId(), dog);

        AbstractPet hamster = new Hamster("Хомяк99", LocalDate.of(2024, 12, 20));
        hamster.learnCommand(new Command("Бегать в колесе"));
        dbAnimals.put(hamster.getId(), hamster);

        AbstractPackAnimal horse = new Horse("Плотва", LocalDate.of(2020, 3, 4));
        horse.setLoadCapacity(150);
        horse.learnCommand(new Command("Галоп!"));
        horse.learnCommand(new Command("Поклон!"));
        dbAnimals.put(horse.getId(), horse);

        AbstractPackAnimal horse2 = new Horse("Гнедой", LocalDate.of(2022, 12, 1));
        horse2.setLoadCapacity(200);
        horse2.learnCommand(new Command("Галоп!"));
        dbAnimals.put(horse2.getId(), horse2);

        AbstractPackAnimal donkey = new Donkey("Осел", LocalDate.of(2020, 8, 24));
        donkey.setLoadCapacity(500);
        dbAnimals.put(donkey.getId(), donkey);

        AbstractPackAnimal camel = new Camel("Гора", LocalDate.of(2019, 8, 24));
        camel.setLoadCapacity(200);
        dbAnimals.put(camel.getId(), camel);
    }
    @Override
    public List<AbstractAnimal> getAllAnimals() {
        List<AbstractAnimal> result = new ArrayList<>();
        for (AbstractAnimal animal: dbAnimals.values()) {
            result.add(animal);
        }
        return result;
    }

    @Override
    public AbstractAnimal getAnimalById(int animalId) {
        return dbAnimals.getOrDefault(animalId, null);
    }

    @Override
    public boolean addAnimal(AbstractAnimal animal) {
        if (dbAnimals.containsKey(animal.getId())) {return false;}
        dbAnimals.put(animal.getId(), animal);
        return true;
    }

    @Override
    public int removeAnimal(AbstractAnimal animal) {
        if (!dbAnimals.containsKey(animal.getId())) {
            return -1;
        }
        AbstractAnimal removed = dbAnimals.remove(animal.getId());
        return removed.getId();
    }
}
