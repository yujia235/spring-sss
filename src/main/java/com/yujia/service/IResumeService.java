package com.yujia.service;

import com.yujia.pojo.Resume;

import java.util.List;

public interface IResumeService {
    List<Resume> findAllSortById();

    Resume findById(Long id);

    Resume save(Resume resume);

    void deleteById(Long id);
}
