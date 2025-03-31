package _xjava.eventAPI.infrastructure.persistence;

import _xjava.eventAPI.core.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 import java.time.LocalDateTime;

@Entity
@Table(name="Events")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime start;

    @Column(name= "end_date", nullable = false)
    private LocalDateTime end;

    @Column(nullable = false, unique = true)
    private String identifier;

    @Column(nullable = false)
    private String organizer;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private EventType type;

}
