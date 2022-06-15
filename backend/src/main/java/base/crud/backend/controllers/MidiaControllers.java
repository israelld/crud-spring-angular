package base.crud.backend.controllers;

import base.crud.backend.models.Midia;
import base.crud.backend.services.MidiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/midia")
public class MidiaControllers {

    @Autowired
    private MidiaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Midia> GetById(@PathVariable Long id) {
        Midia obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Midia>> GetAll() {
        List<Midia> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Midia> Post(@RequestBody Midia usuario) {
        Midia newObj = service.create(usuario);
        return ResponseEntity.status(HttpStatus.GONE).body(service.create(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Midia> Put(@PathVariable Long id, @RequestBody Midia obj) {
        Midia newUsuario = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
