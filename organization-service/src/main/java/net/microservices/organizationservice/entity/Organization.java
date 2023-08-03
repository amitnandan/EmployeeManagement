package net.microservices.organizationservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.service.annotation.GetExchange;

import java.time.LocalDateTime;


@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organizations")
public class Organization {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id ;
        @Column(nullable = false)
        private String organizationName ;
        private String organizationDescription ;
        @Column(nullable = false,unique = true)
        private String organizationCode ;
        @CreationTimestamp
        private LocalDateTime createdDate ;

}
