package animals.view;

import animals.model.AbstractAnimal;

public interface View {
    /**
     * Команды главного меню
     */
    enum MainMenuCommand {
        ADD_ANIMAL ("Добавить животное"),
        SHOW_SKILLS("Показать команды"),
        REMOVE_ANIMAL ("Удалить животное"),
        EXIT ("Выйти");

        private String tag;

        MainMenuCommand(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    /**
     * Команды меню обучения командам
     */
    enum AddCommandMenu {
        ADD_SKILL ("Обучить команде"),
        EXIT ("Выйти");

        private String tag;

        AddCommandMenu(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    /**
     * Показывает список животных
     */
    void showKennelRegistry();

    /**
     * Показывает основное меню приложения
     * @return Возвращает выбранную команду
     */
    MainMenuCommand showMainMenuWithResult();

    /**
     * Показывает диалог добавления животного
     * @return Возвращает true в при успешном добавлении
     */
    boolean showAddAnimalDialog();

    /**
     * Показывает диалог удаления животного
     * @return Возвращает id выписанного животного или -1 при ошибке
     */
    int showRemoveAnimalDialog();

    /**
     * Показывает диалог отображения развернутой информации о животном
     */
    void showDetailInfoAnimalDialog();

    /**
     * Показывает развернутую информацию о животном
     */
    void showAnimalInfo(AbstractAnimal animal);

    /**
     * Показывает меню добавления команды
     * @return Возвращает выбранную команду
     */
    AddCommandMenu showAddComandMenu(AbstractAnimal animal);

    /**
     * Показывает диалог добавления навыка
     * @return Возвращает true в при успешном добавлении
     */
    boolean showAddComandDialog(AbstractAnimal animal);
}
