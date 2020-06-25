package com.yujia.service.impl;

import com.yujia.dao.ResumeDao;
import com.yujia.dao.UserDao;
import com.yujia.pojo.Resume;
import com.yujia.pojo.User;
import com.yujia.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements IResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public List<Resume> findAllSortById() {
        return resumeDao.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    @Override
    public Resume findById(Long id) {
        return resumeDao.findById(id).orElse(null);
    }

    @Override
    public Resume save(Resume user) {
        return resumeDao.save(user);
    }

    @Override
    public void deleteById(Long id) {
        resumeDao.deleteById(id);
    }
}
