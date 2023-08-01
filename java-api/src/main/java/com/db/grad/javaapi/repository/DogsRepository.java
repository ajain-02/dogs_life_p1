package com.db.grad.javaapi.repository;
import java.util.List;
import java.util.Optional;

import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface DogsRepository extends JpaRepository<Dog, Long>
{
        @Query(nativeQuery = true, value = "select * from dogs")
        List<Dog> findAll();
        @Query(nativeQuery = true, value = "select count (*) from dogs")
        long count();

        @Query(nativeQuery = true, value = "select * from dogs where name = :dog.getName()")
        List<Dog> findByName(Dog dog);
        @Query(nativeQuery = true, value = "Delete FROM DOGS WHERE dog_id = :dog.getId()")
        void delete(Dog dog);
        @Query(nativeQuery = true, value = "INSERT INTO dogs (dog_id, name, age) VALUES (:dog.getId(), :dog.getName(), :dog.getAge())")
        Dog save(Dog dog);
        @Query(nativeQuery = true, value = "select * from dogs  where dog_id = :dog_id")
        Optional<Dog> findById(long dog_id);


}