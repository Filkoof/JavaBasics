import java.util.ArrayList;

public class TodoList {

    public static ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todoList.add(todo);
        System.out.println("Дело добавлено: " + todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (todoList.contains(index)) {
            todoList.add(index, todo);
            System.out.println("Дело номер: " + index + " добавлено " + todo);
        } else {
            System.out.println("Несуществующий индекс.");
        }
    }

    public static void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (todoList.contains(index)){
            todoList.set(index, todo);
        } else {
            System.out.println("Несуществующий индекс.");
        }
    }

    public static void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (todoList.contains(index)){
            todoList.remove(index);
        } else {
            System.out.println("Дела с таким номером не сущестует.");        }
    }

    public static ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        for (int i = 0; i < todoList.size(); i ++){

        }

        return new ArrayList<>();
    }

}