package com.db.grad.javaapi.repository;
import com.db.grad.javaapi.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DogsRepository extends JpaRepository<Dog, Long>  {

    @Autowired

    @Query(
            nativeQuery = true, value =
            "select dog_id from dogs")
    List<Dog> findAll();

    // check if the reference to the instance is correct
    @Query(
            nativeQuery = true, value =
            "Delete FROM DOGS WHERE dog_id = :dog.getId()")
    void delete(Dog dog);

    @Query(
            nativeQuery = true, value =
            "INSERT INTO dogs (dog_id, name, age) VALUES (:dog.getId(), :dog.getName(), :dog.getAge())")
    Dog save(Dog dog);


    @Query(
            nativeQuery = true, value =
            "select * from dogs  where dog_id = :dog_id")
    Optional<Dog> findById(long dog_id);


    @Query(nativeQuery = true, value = "select * from dogs where name = \"Kaya\"")
        List<Dog> findByName(Dog name);

    @Query(
            nativeQuery = true, value =
            "select count (*) from dogs")
    long count();

}
