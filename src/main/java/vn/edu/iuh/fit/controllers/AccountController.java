package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.services.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/accounts")
@CrossOrigin(origins = "*")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    @GetMapping("/{id}")
    public Account findByID(@PathVariable("id") long id){
        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(null);
    }

    @GetMapping("/student-code/{id}")
    public Account findByStudentCode(@PathVariable("id") String id){
        Optional<Account> account = accountRepository.findByStudentCode(id);
        return account.orElse(null);
    }

    @PutMapping
    public Account update(@RequestBody Account account){
        return accountRepository.save(account);
    }
}
