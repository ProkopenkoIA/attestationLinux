package animals.model;

import java.util.Objects;

/**
 * Команда, выполняемая животным
 * @param name команда
 * @param description описание команды
 */
public record Command(String name, String description) {
    public Command(String name) {
        this(name, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command skill = (Command) o;
        return name.equals(skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
