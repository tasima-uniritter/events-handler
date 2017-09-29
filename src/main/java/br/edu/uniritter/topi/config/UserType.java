package br.edu.uniritter.topi.config;

public enum UserType {
    STUDANT("studant"),
    ELDERLY("elderly"),
    GOLD("gold"),
    SILVER("silver");

    private String type;

    UserType(String type) {
        this.type = type;
    }
}
