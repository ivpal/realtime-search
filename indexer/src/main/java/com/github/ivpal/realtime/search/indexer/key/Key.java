package com.github.ivpal.realtime.search.indexer.key;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Key {
    private Schema schema;
    private Payload payload;

    public Key() {
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return schema.equals(key.schema) &&
                payload.equals(key.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schema, payload);
    }

    @Override
    public String toString() {
        return "Key{" +
                "schema=" + schema +
                ", payload=" + payload +
                '}';
    }

    public static class Schema {
        private String type;
        private List<Field> fields;
        private boolean optional;
        private String name;

        public Schema() {
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Field> getFields() {
            return fields;
        }

        public void setFields(List<Field> fields) {
            this.fields = fields;
        }

        public boolean isOptional() {
            return optional;
        }

        public void setOptional(boolean optional) {
            this.optional = optional;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Schema schema = (Schema) o;
            return optional == schema.optional &&
                    type.equals(schema.type) &&
                    fields.equals(schema.fields) &&
                    name.equals(schema.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, fields, optional, name);
        }

        @Override
        public String toString() {
            return "Schema{" +
                    "type='" + type + '\'' +
                    ", fields=" + fields +
                    ", optional=" + optional +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class Field {
        private String type;
        private boolean optional;

        @JsonProperty("field")
        private String fieldName;

        public Field() {
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isOptional() {
            return optional;
        }

        public void setOptional(boolean optional) {
            this.optional = optional;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Field field = (Field) o;
            return optional == field.optional &&
                    type.equals(field.type) &&
                    fieldName.equals(field.fieldName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, optional, fieldName);
        }

        @Override
        public String toString() {
            return "Field{" +
                    "type='" + type + '\'' +
                    ", optional=" + optional +
                    ", fieldName='" + fieldName + '\'' +
                    '}';
        }
    }

    public static class Payload {
        private Long id;

        public Payload() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Payload payload = (Payload) o;
            return id.equals(payload.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Payload{" +
                    "id=" + id +
                    '}';
        }
    }
}
