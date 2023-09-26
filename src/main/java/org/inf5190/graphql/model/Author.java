package org.inf5190.graphql.model;

public record Author(String id, String firstName, String lastName, String[] bookIds) {
}
