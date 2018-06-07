package codeclan.example.javaProject.repository;

import codeclan.example.javaProject.models.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {


}