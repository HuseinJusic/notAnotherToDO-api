package at.huj.NotAnotherToDo.model.TaskModel;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "scales")
public class Scale<E extends Number> {
    private String id;
    private String scaleName;
    private String scaleDescription;

    private E rangeFrom;
    private E rangeTo;
    private Set<E> steps;

    public Scale(String scaleName, String scaleDescription, E rangeFrom, E rangeTo, ScaleRangeStep<E> steps) {
        this.scaleName = scaleName;
        this.scaleDescription = scaleDescription;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.steps = steps.calculateSteps();
    }

    public Scale(String scaleName, String scaleDescription, E rangeFrom, E rangeTo, Set<E> steps) {
        this.scaleName = scaleName;
        this.scaleDescription = scaleDescription;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.steps = steps;
    }

    /*public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>("Integer aufzählend", "Aufzählende Ganzzahl Punkte", 0, 10, () -> {
            Set<Integer> set= new HashSet<>();

            for(int i = 0; i <= 10; i++){
                set.add(i);
            }

            return set;
        });

        Scale<Integer> scale1 = new Scale<>("Integer aufzählend", "Aufzählende Ganzzahl Punkte", 0, 10, () -> {
            Set<Integer> set= new HashSet<>();

            for(int i = 0; i <= 10; i = i+2){
                set.add(i);
            }

            return set;
        });

        Scale<Integer> scale3 = new Scale<>("Integer aufzählend", "Aufzählende Ganzzahl Punkte", 0, 10, () -> {
            Set<Integer> set= new HashSet<>();

            for(int i = 0; i <= 10; i = i+2){
                set.add(i);
            }

            return set;
        });


    }*/

}
