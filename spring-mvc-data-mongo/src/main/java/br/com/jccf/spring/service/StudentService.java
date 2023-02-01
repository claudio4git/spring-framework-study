package br.com.jccf.spring.service;

import br.com.jccf.spring.entity.*;
import br.com.jccf.spring.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class StudentService {

    @Value("${project.repository.enabled}")
    private Boolean repositoryEnabled;

    private final StudentTemplateRepository studentTemplateRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentTemplateRepository studentTemplateRepository, StudentRepository studentRepository) {
        this.studentTemplateRepository = studentTemplateRepository;
        this.studentRepository = studentRepository;
    }

    public StudentDocument create(StudentDocument studentDocument) {
        if (repositoryEnabled)
            return studentRepository.insert(studentDocument);
        else
            return studentTemplateRepository.insert(studentDocument);
    }

    public Optional<StudentDocument> get(String id) {
        if (repositoryEnabled)
            return studentRepository.findById(id);
        else
            return Optional.ofNullable(studentTemplateRepository.findById(id));
    }
}
