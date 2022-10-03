package br.ufrn.troquinhas.service;

import br.ufrn.troquinhas.model.Figurinha;
import br.ufrn.troquinhas.repository.FigurinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FigurinhaService {
    @Autowired
    FigurinhaRepository figurinhaRepository;

    public Figurinha addFigurinha(Figurinha f){ return figurinhaRepository.save(f); };

    public ResponseEntity<Figurinha> getFigurinhaById(Integer id){
        Optional<Figurinha> figurinha = figurinhaRepository.findById(id);
        if(figurinha.isPresent()) {
            return new ResponseEntity<>(figurinha.get(), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    };

    public List<Figurinha> getAllFigurinhas(){ return figurinhaRepository.findAll(); }

    public void removeFigurinha(Integer id){ figurinhaRepository.deleteById(id); }

    public Figurinha atualizaFigurinha(Figurinha f){ return figurinhaRepository.save(f); }
}