package com.innovation.validator.core.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pessoa-fisica")
public class CPF {

    @Id
    private String id;
    private List<String> numero;

    private String nome;
    
    private Integer number;
    
}
