package com.example.Assignment15.service;

import com.example.Assignment15.model.Test;
import com.example.Assignment15.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class TestService {
    @Autowired
    TestRepository tr;

    public List<Test> allData(){
        return tr.findAll();
    }

    public void construct(String data){
        Test t=new Test();
        t.setTestString(data);
        tr.save(t);
    }
    public Test get(Long id){
        return tr.findById(id).orElseThrow();
    }
}
