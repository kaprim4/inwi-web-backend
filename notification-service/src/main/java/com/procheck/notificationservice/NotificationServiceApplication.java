package com.procheck.notificationservice;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Objects;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor

public class NotificationServiceApplication {

    private final ObservationRegistry observationRegistry;
    private final Tracer tracer;

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(ReceptionPlacedEvent receptionPlacedEvent) {
        Observation.createNotStarted("on-message", this.observationRegistry).observe(() -> {
            log.info("Message reçu <{}>", receptionPlacedEvent);
            log.info(
                    "TraceId- {}, Notification reçu pour une réception - {}",
                    Objects.requireNonNull(this.tracer.currentSpan()).context().traceId(),
                    receptionPlacedEvent.getOrderNumber()
            );
        });
        // send out an email notification
        // implement mail configuration
        // put code below
    }
}
