package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.GradesRepository;

@Service
public class GradesService {
    @Autowired
    private GradesRepository gradesRepository;
}
