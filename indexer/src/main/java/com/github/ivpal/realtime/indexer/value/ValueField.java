package com.github.ivpal.realtime.indexer.value;

import java.util.List;
import java.util.Objects;

public class ValueField {
    private String type;
    private List<ColumnField> fields;
    private boolean optional;
    private String name;
    private String field;

    public ValueField() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ColumnField> getFields() {
        return fields;
    }

    public void setFields(List<ColumnField> fields) {
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueField that = (ValueField) o;
        return optional == that.optional &&
                Objects.equals(type, that.type) &&
                Objects.equals(fields, that.fields) &&
                Objects.equals(name, that.name) &&
                Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fields, optional, name, field);
    }

    @Override
    public String toString() {
        return "ValueField{" +
                "type='" + type + '\'' +
                ", fields=" + fields +
                ", optional=" + optional +
                ", name='" + name + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
