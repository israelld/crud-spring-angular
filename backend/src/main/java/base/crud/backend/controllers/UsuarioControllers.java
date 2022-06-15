package base.crud.backend.controllers;

import base.crud.backend.models.Usuario;
import base.crud.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioControllers {

    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> GetById(@PathVariable Long id) {
        Usuario obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> GetAll() {
        List<Usuario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
        Usuario newObj = service.create(usuario);
        return ResponseEntity.status(HttpStatus.GONE).body(service.create(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> Put(@PathVariable Long id, @RequestBody Usuario obj) {
        Usuario newUsuario = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
