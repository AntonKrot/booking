package com.example.booking.common;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

@Data
public class PredicateBuilder {

    private Predicate predicate;
    private CriteriaBuilder builder;

    public PredicateBuilder(CriteriaBuilder builder) {
        this.builder = builder;
    }

    public void appendCondition(Predicate newPredicate) {
        if (newPredicate != null) {
            if (this.predicate == null) {
                this.predicate = newPredicate;
            } else {
                this.predicate = this.builder.and(this.predicate, newPredicate);
            }
        }
    }
}
