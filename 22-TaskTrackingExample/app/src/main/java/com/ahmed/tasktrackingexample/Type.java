package com.ahmed.tasktrackingexample;

public enum Type {

    LOW, NORMAL, HIGH;

    @Override
    public String toString() {

        switch (this){

            case LOW:
                return "Low";

            case NORMAL:
                return "Normal";

            case HIGH:
                return "High";
        }

        return null;
    }
}
