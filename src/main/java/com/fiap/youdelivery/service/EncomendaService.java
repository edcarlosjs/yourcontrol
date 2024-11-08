package com.fiap.youdelivery.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fiap.youdelivery.dto.EncomendaDTO;
import com.fiap.youdelivery.entities.Encomenda;
import com.fiap.youdelivery.exception.ResourceNotFoundException;
import com.fiap.youdelivery.repository.IEncomendaRepository;
import com.fiap.youdelivery.repository.IMoradorRepository;

@Service
public class EncomendaService {

    @Autowired
    private IEncomendaRepository encomendaRepository;

    @Autowired
    private IMoradorRepository moradorRepository; // Injetando o MoradorRepository

    @Autowired
    private NotificacaoService notificationService;

    //PARA AMARZENAR E CRIAR AS FILAS DE ENCOMENDAS
    private Queue<Encomenda> filaEncomendas = new LinkedList<>();

   //PARA BUSCAR O EMAIL DO MORADOR
    private String buscarEmailDoMorador(String nomeMorador) {
        return moradorRepository.findEmailByNome(nomeMorador);
    }
    
    public Encomenda registrarEncomenda(EncomendaDTO encomendaDTO) {
        var encomenda = new Encomenda();
        encomenda.setNm_morador(encomendaDTO.getNm_morador());
        encomenda.setNr_apartamento(encomendaDTO.getNr_apartamento());
        encomenda.setEncomenda(encomendaDTO.getEncomenda());
        var savedEncomenda = encomendaRepository.save(encomenda);
        
        filaEncomendas.add(savedEncomenda);
        return savedEncomenda;
    }

   
    @Scheduled(fixedRate = 5000)
    public void processarEncomenda() {
        Encomenda encomenda = filaEncomendas.poll();
        if (encomenda != null) {
            encomenda.setProcessado(true);
            encomendaRepository.save(encomenda);

            // PARA NOTIFICAR O EMAIL
            String emailMorador = buscarEmailDoMorador(encomenda.getNm_morador());
            if (emailMorador != null) {
                String assunto = "Sua encomenda chegou!";
                String mensagem = String.format("Olá %s, sua encomenda foi recebida pela portaria.", encomenda.getNm_morador());
                notificationService.enviarNotificacaoPorEmail(emailMorador, assunto, mensagem);
            }
        }
    }
    
    public Encomenda darBaixaEncomenda(Long encomendaId) {
        Encomenda encomenda = encomendaRepository.findById(encomendaId)
              .orElseThrow(() -> new ResourceNotFoundException("Encomenda não encontrada"));
        encomenda.setRetirada(true);
        encomenda.setDtRetirada(LocalDateTime.now());
        return encomendaRepository.save(encomenda);
    }
    
//    public void darBaixaEncomenda(Long encomendaId) {
//        Encomenda encomenda = encomendaRepository.findById(encomendaId)
//              .orElseThrow(() -> new ResourceNotFoundException("Encomenda não encontrada"));
//        encomenda.setRetirada(true);
//        encomenda.setDtRetirada(LocalDateTime.now());
//        encomendaRepository.save(encomenda);
//    }


}

