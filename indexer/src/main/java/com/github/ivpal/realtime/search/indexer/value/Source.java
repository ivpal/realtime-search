package com.github.ivpal.realtime.search.indexer.value;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Source {
    private String version;
    private String connector;
    private String name;

    @JsonProperty("ts_ns")
    private String tsMs;
    private String snapshot;
    private String db;
    private String schema;
    private String table;
    private String txId;
    private String lsn;
    private String xmin;

    public Source() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTsMs() {
        return tsMs;
    }

    public void setTsMs(String tsMs) {
        this.tsMs = tsMs;
    }

    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getLsn() {
        return lsn;
    }

    public void setLsn(String lsn) {
        this.lsn = lsn;
    }

    public String getXmin() {
        return xmin;
    }

    public void setXmin(String xmin) {
        this.xmin = xmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return version.equals(source.version) &&
                connector.equals(source.connector) &&
                name.equals(source.name) &&
                tsMs.equals(source.tsMs) &&
                snapshot.equals(source.snapshot) &&
                db.equals(source.db) &&
                schema.equals(source.schema) &&
                table.equals(source.table) &&
                txId.equals(source.txId) &&
                lsn.equals(source.lsn) &&
                xmin.equals(source.xmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, connector, name, tsMs, snapshot, db, schema, table, txId, lsn, xmin);
    }

    @Override
    public String toString() {
        return "Source{" +
                "version='" + version + '\'' +
                ", connector='" + connector + '\'' +
                ", name='" + name + '\'' +
                ", tsMs='" + tsMs + '\'' +
                ", snapshot='" + snapshot + '\'' +
                ", db='" + db + '\'' +
                ", schema='" + schema + '\'' +
                ", table='" + table + '\'' +
                ", txId='" + txId + '\'' +
                ", lsn='" + lsn + '\'' +
                ", xmin='" + xmin + '\'' +
                '}';
    }
}