package br.edu.ifpb.pdist.hospitalcare.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
//@EqualsAndHashCode(exclude = {"paciente"})
@AllArgsConstructor
@Entity
public class Medico implements Serializable{

    // Para garantir que a assinatura de um número seja única , para o uso do @Id
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String CRM;

    private String nome;

    private String sexo;

    private String especialidade;

    private Integer telefone;

    // Relação entre Médico e Paciente (1:N)
    @OneToMany
    //@JoinColumn(name = "id_paciente")
    @ToString.Exclude
    private Set<Paciente> pacientes = new HashSet<Paciente>();  
    
}
