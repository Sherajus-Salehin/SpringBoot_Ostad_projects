package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private List<Transaction> transactionList=new ArrayList<>();

    @GetMapping
    public List<Transaction> getAllTransactions(){
        return transactionList.stream().collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable String id){
        return transactionList.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null
        );
    }
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction tr){
        transactionList.add(tr);
        return tr;
    }
    @DeleteMapping("/{id}")
    public String deleteATransaction(@PathVariable String id){
        boolean rem=transactionList.removeIf(t -> t.getId().equals(id));
        return rem ? "deleted successfully": "error deleting";
    }
}
