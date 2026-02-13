package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private List<Transaction> transactionList=new ArrayList<>();

    ///api/transactions?type=income

    @GetMapping
    public List<Transaction> getAllTransactions(@RequestParam(name= "type",required = false) String type){
        if(type!=null){
            return transactionList.stream().filter(t-> t.getType().equalsIgnoreCase(type)).toList();
        }
        return transactionList;
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
