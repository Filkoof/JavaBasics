import java.util.ArrayList;

public class TodoList {

    public static ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        todoList.add(todo);
        System.out.println("Дело добавлено: " + todo);
    }

    public void add(int index, String todo) {
        if (todoList.contains(index)) {
            todoList.add(index, todo);
            System.out.println("Дело номер: " + index + " добавлено " + todo);
        } else {
            System.out.println("Несуществующий индекс.");
        }
    }

    public void edit(String todo, int index) {
        if (todoList.contains(index)){
            todoList.set(index, todo);
        } else {
            System.out.println("Несуществующий индекс.");
        }
    }

    public void delete(int index) {
        if (todoList.contains(index)){
            todoList.remove(index);
        } else {
            System.out.println("Дела с таким номером не сущестует.");        }
    }

    public ArrayList<String> getTodos() {
        for (int i = 0; i < todoList.size(); i ++){

        }

        return new ArrayList<>();
    }

}