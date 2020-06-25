package com.yujia.dao;

import com.yujia.pojo.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResumeDao extends JpaRepository<Resume, Long>, JpaSpecificationExecutor<Resume> {
}
