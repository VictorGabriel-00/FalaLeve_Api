package com.fala.ficr.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/arquivo")
public class ArquivoController {


    private final String PASTA_UPLOAD = "upload/";


    @PostMapping("/upload")
    public ResponseEntity<String> uploadArquivo(@RequestParam("file") MultipartFile arquivo){
        try {
            Path caminhoPasta = Paths.get(PASTA_UPLOAD);

            if(!Files.exists(caminhoPasta)){
                Files.createDirectories(caminhoPasta);
            }

            String nomeArquivo = arquivo.getOriginalFilename();
            String nomeUnicoArquivo = UUID.randomUUID().toString() + "_" + nomeArquivo;

            Path caminhoArquivo = caminhoPasta.resolve(nomeUnicoArquivo);
            Files.copy(arquivo.getInputStream(), caminhoArquivo);

            return ResponseEntity.ok("/upload/" + nomeUnicoArquivo);

        }catch (IOException e){
            return ResponseEntity.internalServerError().body("Erro ao salvar o arquivo no banco de dados" + e.getMessage());
        }

    }

}
