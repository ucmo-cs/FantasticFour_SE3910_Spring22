package com.example.CommerceBankProject.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
public class OpenSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectID;
    @NotNull
    private String projectName;
    @NotNull
    private String sourceLink;
    private String description;
    @NotNull
    private String versionNumber;
    private Date dateRequested;
    private boolean status;
    private Date dateFinal;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false, updatable = false)
    private Account account;
    public Account getid(){return account;}

}
