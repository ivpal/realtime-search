package com.github.ivpal.realtime.indexer.value;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Payload<T> {
    private T before;
    private T after;
    private Source source;
    private String op;

    @JsonProperty("ts_ms")
    private long tsMs;

    private String transaction;

    public Payload() {
    }

    public T getBefore() {
        return before;
    }

    public void setBefore(T before) {
        this.before = before;
    }

    public T getAfter() {
        return after;
    }

    public void setAfter(T after) {
        this.after = after;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public long getTsMs() {
        return tsMs;
    }

    public void setTsMs(long tsMs) {
        this.tsMs = tsMs;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payload<?> payload = (Payload<?>) o;
        return tsMs == payload.tsMs &&
                before.equals(payload.before) &&
                after.equals(payload.after) &&
                source.equals(payload.source) &&
                op.equals(payload.op) &&
                transaction.equals(payload.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(before, after, source, op, tsMs, transaction);
    }

    @Override
    public String toString() {
        return "Payload{" +
                "before=" + before +
                ", after=" + after +
                ", source=" + source +
                ", op='" + op + '\'' +
                ", tsMs=" + tsMs +
                ", transaction='" + transaction + '\'' +
                '}';
    }
}
