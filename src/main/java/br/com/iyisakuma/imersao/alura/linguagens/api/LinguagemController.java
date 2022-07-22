package br.com.iyisakuma.imersao.alura.linguagens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

    @GetMapping(value = "/linguagens")
    public List<Linguagem> obterLinguagens() {
        return repositorio.findByOrderByRankingAsc();
    }

    @PostMapping(value = "linguagens")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "Linguagem Cadastrada")
    public String cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        linguagem = repositorio.insert(linguagem);
        return String.format("Linguagem Cadastrada no MongoDb com Id %s", linguagem.getId());
    }

    @DeleteMapping(value = "linguagens")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletaLinguagens(@RequestBody List<Linguagem> linguagens) {
        repositorio.deleteAll(linguagens);
    }

    @DeleteMapping(value = "linguagens/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletaLinguagem(@PathVariable(value = "id", required = true) String id) {
        repositorio.deleteById(id);
    }
    @PutMapping(value = "linguagens")
    public Linguagem atualizaFilme(@RequestBody Linguagem linguagem){
            linguagem = repositorio.save(linguagem);
            return linguagem;
    }
}
