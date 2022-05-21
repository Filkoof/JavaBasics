package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.Task;

import java.util.List;

@RestController
public class AffairController {

    @PostMapping("/tasks/")
    public int add(Task task) {
        return Storage.addAffair(task);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Task task = Storage.getTask(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(Storage.deleteTask(id), HttpStatus.OK);
    }

    @DeleteMapping("/tasks/")
    public ResponseEntity deleteList() {
        return new ResponseEntity(Storage.deleteTask(), HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity patch(Task task) {
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(Storage.patchTask(task), HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Task task = Storage.getTask(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(task, HttpStatus.OK);
    }

    @GetMapping("/tasks/")
    public List<Task> list(){
        return Storage.getTasks();
    }
}
