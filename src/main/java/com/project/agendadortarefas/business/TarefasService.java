package com.project.agendadortarefas.business;

import com.project.agendadortarefas.business.dto.TarefasDTO;
import com.project.agendadortarefas.business.mapper.TarefasConverter;
import com.project.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.project.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.project.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.project.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacao(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }
}
