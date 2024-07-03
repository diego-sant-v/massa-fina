package com.backend.pizzaria.repository;

import com.backend.pizzaria.models.FilesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<FilesModel, Long> {
}
