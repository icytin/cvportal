package com.cgi.cvportal.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface EducationDao extends CrudRepository<Education, Long> {

}