package ro.ubb.istudent.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ro.ubb.istudent.domain.CourseMaterial;

import java.util.Optional;

/**
 * Created by Deni on 23/11/2017.
 */
public interface CourseMaterialRepository   extends MongoRepository<CourseMaterial, ObjectId> {
    Optional<CourseMaterial> findCourseMaterialByMaterialsId(String materialsId);
}
