package synclife.health.nutritrack.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

// https://github.com/alves-dev/SyncLife/blob/main/events.md#todos-os-eventos-v%C3%A3o-ter-os-seguintes-campos
public abstract class EventBase {
    private EventType type;

    @JsonProperty("person_id")
    private String personId;

    private LocalDateTime datetime;

    @JsonProperty("meta_data")
    private EventMetadata metadata;

    public EventBase(EventType type, String personId) {
        this.type = type;
        this.personId = personId;
        this.datetime = LocalDateTime.now();
        this.metadata = new EventMetadata();
    }

    protected EventBase() {
    }

    public EventType getType() {
        return type;
    }

    public String getPersonId() {
        return personId;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public EventMetadata getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "EventBase{" +
                "type=" + type +
                ", personId=" + personId +
                ", datetime=" + datetime +
                ", metadata=" + metadata.toString() +
                '}';
    }
}