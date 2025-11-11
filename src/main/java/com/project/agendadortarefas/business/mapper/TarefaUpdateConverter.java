package com.project.agendadortarefas.business.mapper;

import com.project.agendadortarefas.business.dto.TarefasDTO;
import com.project.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {
    //O MappingTarget será o principal, ou seja, qdo o DTO for null, será o valor do entity.
    void updateTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);

}
