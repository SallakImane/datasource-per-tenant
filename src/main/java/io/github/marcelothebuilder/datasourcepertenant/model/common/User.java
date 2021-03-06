package io.github.marcelothebuilder.datasourcepertenant.model.common;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @Column(nullable = false)
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 6, max = 256)
    private String password;

    @JoinColumn(name = "company_id")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Company company;

}
