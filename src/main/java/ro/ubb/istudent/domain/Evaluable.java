package ro.ubb.istudent.domain;

import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Administrator on 26.01.2018.
 */
public interface Evaluable extends Serializable {

    float evaluate();

    boolean passed();

}
