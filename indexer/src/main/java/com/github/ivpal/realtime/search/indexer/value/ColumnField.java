package com.github.ivpal.realtime.search.indexer.value;

import java.util.Objects;

public class ColumnField {
    private String type;
    private boolean optional;
    private String field;

    public ColumnField() {
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
        ColumnField that = (ColumnField) o;
        return optional == that.optional &&
                type.equals(that.type) &&
                field.equals(that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, optional, field);
    }

    @Override
    public String toString() {
        return "ColumnField{" +
                "type='" + type + '\'' +
                ", optional=" + optional +
                ", field='" + field + '\'' +
                '}';
    }
}
