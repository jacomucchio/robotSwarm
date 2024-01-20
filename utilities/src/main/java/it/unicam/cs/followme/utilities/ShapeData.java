package it.unicam.cs.followme.utilities;

import java.util.stream.IntStream;

public record ShapeData(String label, String shape, double[] args) {
    public static ShapeData fromString(String[] elements) {
        System.out.println(elements[0]+" - "+elements[1]+" - "+elements[2]+" - "+elements[3] +" - "+elements[4]);
        return new ShapeData(elements[0],
            elements[1],
                IntStream.range(2, elements.length).mapToDouble(i -> Double.parseDouble(elements[i])).toArray()
        );
    }

}
