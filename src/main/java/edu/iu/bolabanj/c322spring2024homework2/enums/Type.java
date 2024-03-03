package edu.iu.bolabanj.c322spring2024homework2.enums;

public enum Type {
    ACOUSTIC, ELECTRIC;

    public String toString() {
        return switch (this) {
            case ACOUSTIC -> "Acoustic";
            case ELECTRIC -> "Electric";
        };
    }
}
