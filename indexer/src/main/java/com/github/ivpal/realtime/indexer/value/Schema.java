package com.github.ivpal.realtime.indexer.value;

import java.util.List;
import java.util.Objects;

public class Schema {
    private String type;
    private List<ValueField> fields;
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

    public List<ValueField> getFields() {
        return fields;
    }

    public void setFields(List<ValueField> fields) {
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
                Objects.equals(type, schema.type) &&
                Objects.equals(fields, schema.fields) &&
                Objects.equals(name, schema.name);
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
