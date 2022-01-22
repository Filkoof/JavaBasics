import java.util.ArrayList;

public class TodoList {

    public ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        todoList.add(todo);
        System.out.println("Дело добавлено: " + todo);
    }

    public void add(int index, String todo) {
        if (index < todoList.size()) {
            System.out.println("Дело номер: " + index + " добавлено " + todo);
            todoList.add(index, todo);
        } else {
            todoList.add(todo);
            System.out.println("Дело добавлено");
        }
    }

    public void edit(String todo, int index) {
        if (index < todoList.size()){
            todoList.set(index, todo);
        } else {
            System.out.println("Несуществующий индекс.");
        }
    }

    public void delete(int index) {
        if (index < todoList.size()){
            todoList.remove(index);
        } else {
            System.out.println("Дела с таким номером не сущестует.");        }
    }

    public ArrayList<String> getTodos() {
        for (int i = 0; i < todoList.size(); i ++){
            System.out.println(todoList.get(i));
        }

        return todoList;
    }

}