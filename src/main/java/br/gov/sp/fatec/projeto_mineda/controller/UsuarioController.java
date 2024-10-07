package br.gov.sp.fatec.projeto_mineda.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.sp.fatec.projeto_mineda.entity.Usuario;
import br.gov.sp.fatec.projeto_mineda.service.UsuarioService;


@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {

 @Autowired
 private UsuarioService service;

 @GetMapping
 public List<Usuario> buscarTodos() {
    return service.buscarTodos();
 }

 @GetMapping(value = "/{usuario}")
 public Usuario buscarPorId(@PathVariable("usuario") Long id) {
    return service.buscarPorId(id);
 }

 @PostMapping
 public Usuario novoUsuario(@RequestBody Usuario usuario) {
    return service.novo(usuario);
 }
 
}