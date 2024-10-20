package com.stat.stats.training.repository;

import com.stat.stats.training.model.Training;
import com.stat.stats.weight.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {


}
