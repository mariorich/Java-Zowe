package empservice.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import empservice.request.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

    
} 
