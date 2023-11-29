package com.example.backend.control;


import com.example.backend.model.Mesa;
import com.example.backend.model.MesaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author rfdouro
 *
 * a anotação CrossOrigin serve para habilitar a
 * comunicação entre diferentes domínios
 * por exemplo, uma aplicação em http://local1 pode consumir
 * uma REST API em http://local2 apenas se
 * for habilitado o CORS
 *
 * a anotação RestController torna adapta
 * controle atual para responder como
 * endpoint REST consumindo e produzindo JSON
 *
 * a anotação RequestMapping indica qual caminho
 * da aplicação será usado como mapeador dos endpoints
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/mesa")
public class MesaController {


 /*
insere automaticamente um repositório de dados para mesas
  */
 @Autowired
 MesaRepository repository;


 /*
método que retorna a listagem de mesas ordenada por descrição
atende no endpoint /mesa com verbo GET
  */
 @GetMapping({"", "/"})
 public List<Mesa> getMesas() {
  return repository.findAll(Sort.by("numero"));
 }


 /*
método que recebe uma mesa enviada na requisição e a insere no banco de dados
retorta após inserir já com o ID
atende no endpoint /mesa com verbo POST
a anotação @RequestBody é importante pois indica que os dados da requisição
serão enviados no corpo da requisição (em JSON)
  */
 @PostMapping({"", "/"})
 public Mesa insere(@RequestBody Mesa mesa) {
  return repository.save(mesa);


 }


 /*
método que recebe uma mesa enviada na requisição (com id preenchido)
e a atualiza no banco de dados
retorta a mesa atualizada
caso não tenha id na requisição retorna null
atende no endpoint /mesa com verbo PUT
a anotação @RequestBody é importante pois indica que os dados da requisição
serão enviados no corpo da requisição (em JSON)
  */
 @PutMapping({"", "/"})
 public Mesa atualiza(@RequestBody Mesa mesa) {
  if (mesa.getId() != null) {
   return repository.save(mesa);
  }
  return null;
 }


 /*
método que recebe um id de mesa enviada na requisição
caso tenha enviado o id, é excluída no banco de dados
retorta uma mensagem
o id é passado no path (caminho da url) por isso
se usa o @PathVariable indicativo
  */
 @DeleteMapping("/{id}")
 public String exclui(@PathVariable("id") Long id) {
  if (id != null) {
   repository.deleteById(id);
   return "Excluído";
  }
  return null;
 }


}
