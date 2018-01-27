package ro.ubb.istudent.service.evaluable;

import lombok.NonNull;
import ro.ubb.istudent.domain.Project;

import java.util.List;

/**
 * Created by Administrator on 26.01.2018.
 */
public interface ProjectService {

    @NonNull
    List<Project> findAll();

    @NonNull
    Project save(@NonNull final Float contentSize, @NonNull final Float contentQuality, @NonNull final Float
            topicStrength);

    void delete(@NonNull final String proiectId);

}
