package at.huj.NotAnotherToDo.model.TaskModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ScaleRangeStep<E> {
    public Set<E> calculateSteps();
}
