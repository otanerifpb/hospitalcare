package br.edu.ifpb.pdist.hospitalcare.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@EqualsAndHashCode(exclude = {"medico", "anamineses", "prontuarios"})
@AllArgsConstructor
@Entity
public class Paciente implements Serializable{

    // Para garantir que a assinatura de um número seja única , para o uso do @Id
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String sexo;

    private Date dataNascimento;

    private String email;

    // Relação entre Paciente e Médido (1:1)
    private Medico medico;

    // Relação entre Paciente e Anamnese (1:N)
    private Set<Anaminese> anemineses = new HashSet<Anaminese>(); 

    // Relação entre Paciente e Prontuário (1:N)
    private Set<Prontuario> prontuarios = new HashSet<Prontuario>();  
}
