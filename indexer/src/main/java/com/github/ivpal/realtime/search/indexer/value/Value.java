package com.github.ivpal.realtime.search.indexer.value;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Value<T> {
    @JsonProperty("schema")
    private Schema schema;

    private Payload<T> payload;

    public Value() {
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public Payload<T> getPayload() {
        return payload;
    }

    public void setPayload(Payload<T> payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value<?> value = (Value<?>) o;
        return Objects.equals(schema, value.schema) &&
                Objects.equals(payload, value.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schema, payload);
    }

    @Override
    public String toString() {
        return "Value{" +
                "schema=" + schema +
                ", payload=" + payload +
                '}';
    }
}
