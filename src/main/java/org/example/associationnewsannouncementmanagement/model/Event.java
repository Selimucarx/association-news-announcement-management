package org.example.associationnewsannouncementmanagement.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "event_id", columnDefinition = "UUID")
    private UUID eventId;

    private String topic;
    private String content;
    private LocalDate validityDate;
}