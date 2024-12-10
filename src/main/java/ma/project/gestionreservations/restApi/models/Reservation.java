package ma.project.gestionreservations.restApi.models;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @NotNull(message = "Le client est obligatoire")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "chambre_id", nullable = false)
    @NotNull(message = "La chambre est obligatoire")
    private Chambre chambre;

    @Column(nullable = false)
    @NotNull(message = "La date de début est obligatoire")
    private LocalDate dateDebut;

    @Column(nullable = false)
    @NotNull(message = "La date de fin est obligatoire")
    private LocalDate dateFin;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb", nullable = true)
    private Map<String, String> preferences;
}
