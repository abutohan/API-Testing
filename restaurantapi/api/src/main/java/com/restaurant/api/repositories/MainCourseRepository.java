package com.restaurant.api.repositories;

import com.restaurant.api.entities.MainCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCourseRepository extends JpaRepository<MainCourse, Long> {
}
