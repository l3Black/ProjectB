package ru.bellintegrator.practice.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "document",
        indexes = @Index(name = "IX_document_doc_type", columnList = "document_id", unique = false))
public class Document {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "date_issue", nullable = true)
    private LocalDate dateIssue;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "document_type_id")
    private DocumentType type;

    /**
     * Constructor for hibernate
     */
    public Document() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public LocalDate getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(LocalDate dateIssue) {
        this.dateIssue = dateIssue;
    }
}
