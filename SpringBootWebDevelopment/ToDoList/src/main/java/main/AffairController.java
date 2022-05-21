package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AffairController {

    @PostMapping("/affairs/")
    public int add(Affair affair) {
        return Storage.addAffair(affair);
    }

    @DeleteMapping("/affairs/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Affair affair = Storage.getAffair(id);
        if (affair == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(Storage.deleteAffair(id), HttpStatus.OK);
    }

    @DeleteMapping("/affairs/")
    public ResponseEntity deleteList() {
        return new ResponseEntity(Storage.deleteAffairs(), HttpStatus.OK);
    }

    @PutMapping("/affairs/{id}")
    public ResponseEntity patch(Affair affair) {
        if (affair == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(Storage.patchAffair(affair), HttpStatus.OK);
    }

    @GetMapping("/affairs/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Affair affair = Storage.getAffair(id);
        if (affair == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(affair,HttpStatus.OK);
    }

    @GetMapping("/affairs/")
    public List<Affair> list(){
        return Storage.getAffairs();
    }
}
