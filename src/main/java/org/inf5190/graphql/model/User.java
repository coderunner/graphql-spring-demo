package org.inf5190.graphql.model;

public record User(String id, String name, String[] purchasedBookIds) {
}
